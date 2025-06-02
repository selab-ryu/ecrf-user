/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ecrf.user.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalServiceUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import ecrf.user.exception.NoSuchCRFAutoqueryException;
import ecrf.user.model.CRF;
import ecrf.user.model.CRFAutoquery;
import ecrf.user.service.CRFLocalServiceUtil;
import ecrf.user.service.base.CRFAutoqueryLocalServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = "model.class.name=ecrf.user.model.CRFAutoquery",
	service = AopService.class
)
public class CRFAutoqueryLocalServiceImpl extends CRFAutoqueryLocalServiceBaseImpl {
	private Log _log = LogFactoryUtil.getLog(CRFAutoqueryLocalServiceImpl.class);
	
	public CRFAutoquery addCRFAutoquery(
			long queryTermId,
			String queryTermName,
			String queryValue,
			String queryPreviousValue,
			long subjectId,
			long crfId,
			int queryType,
			String queryComment,
			ServiceContext sc)throws PortalException{
		_log.info("Start add Query");
		long autoQueryId = super.counterLocalService.increment();
		CRFAutoquery crfAutoquery = super.crfAutoqueryPersistence.create(autoQueryId);
		
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		long companyId = sc.getCompanyId();
		
		Date now = new Date();
		
		crfAutoquery.setQueryTermId(queryTermId);
		crfAutoquery.setQueryTermName(queryTermName);
		crfAutoquery.setQueryValue(queryValue);
		crfAutoquery.setQueryPreviousValue(queryPreviousValue);
		crfAutoquery.setSubjectId(subjectId);
		crfAutoquery.setCrfId(crfId);
		crfAutoquery.setQueryType(queryType);
		crfAutoquery.setQueryComment(queryComment);
		
		crfAutoquery.setCompanyId(companyId);
		crfAutoquery.setGroupId(groupId);
		crfAutoquery.setUserId(userId);
		crfAutoquery.setUserName(user.getFullName());
		crfAutoquery.setCreateDate(now);
		crfAutoquery.setModifiedDate(now);
		
		crfAutoquery.setStatus(WorkflowConstants.STATUS_APPROVED);
		crfAutoquery.setStatusByUserId(userId);
		crfAutoquery.setStatusByUserName(user.getFullName());
		crfAutoquery.setStatusDate(now);
		
		crfAutoquery.setExpandoBridgeAttributes(sc);
		super.crfAutoqueryPersistence.update(crfAutoquery);
		
		resourceLocalService.addResources(
			crfAutoquery.getCompanyId(), groupId, userId,
			CRFAutoquery.class.getName(), crfAutoquery.getAutoQueryId(),
			false, true, true);
		
		_log.info("End add Query");
		return crfAutoquery;
	}
	
	public CRFAutoquery comfirmAutoquery(
			long autoQueryId,
			int queryComfirm,
			String queryValue,
			String queryChangeValue,
			String queryComment,
			ServiceContext sc) throws PortalException {
		
		CRFAutoquery crfAutoquery = super.crfAutoqueryPersistence.findByPrimaryKey(autoQueryId);
		
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		
		Date now = new Date();
		crfAutoquery.setQueryValue(queryChangeValue);
		crfAutoquery.setQueryPreviousValue(queryValue);
		crfAutoquery.setQueryComment(queryComment);
		crfAutoquery.setQueryComfirm(queryComfirm);
		crfAutoquery.setQueryComfirmUserId(userId);
		crfAutoquery.setQueryComfirmUserName(user.getFullName());
		crfAutoquery.setQueryComfirmDate(now);
		
		crfAutoquery.setModifiedDate(now);
		
		crfAutoquery.setExpandoBridgeAttributes(sc);
		super.crfAutoqueryPersistence.update(crfAutoquery);
		
		return crfAutoquery;
	}
	
	public CRFAutoquery deleteAutoquery(long autoQueryId) throws PortalException{
		CRFAutoquery crfAutoquery = super.crfAutoqueryPersistence.remove(autoQueryId);
		
		resourceLocalService.deleteResource(
			crfAutoquery.getCompanyId(), CRFAutoquery.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, crfAutoquery.getAutoQueryId());
		
		return crfAutoquery;
	}
	
	public void deleteCRFAutoqueries(long[] autoQueryIds)throws PortalException{
		for(long autoQueryId : autoQueryIds) {
			this.deleteAutoquery(autoQueryId);
		}
	}
	
	public List<CRFAutoquery> getAllQuery(){
		return super.crfAutoqueryPersistence.findAll();
	}
	
	public List<CRFAutoquery> getQueryByGroupId(long groupId) {
		return super.crfAutoqueryPersistence.findByGroupId(groupId);
	}
	
	public List<CRFAutoquery> getQueryByGroupCRF(long groupId, long crfId) {
		return super.crfAutoqueryPersistence.findByG_C(groupId, crfId);
	}
	
	public List<CRFAutoquery> getQueryByG_C_S(long groupId, long crfId, long subjectId) {
		return super.crfAutoqueryPersistence.findByG_C_S(groupId, crfId, subjectId);
	}
	
	public CRFAutoquery getQueryBySdIdSIdValue(long sdId, long sId, String termName, String value) throws NoSuchCRFAutoqueryException {
		return super.crfAutoqueryPersistence.findBySdIdSIdValue_MODEL(sdId, sId, termName, value);
	}
	public int countQueryBySdIdSIdValue(long sdId, long sId, String termName, String value) {
		return super.crfAutoqueryPersistence.countBySdIdSIdValue_MODEL(sdId, sId, termName, value);
	}
	
	public int countQueryBySdId(long sdId) {
		return super.crfAutoqueryPersistence.countByQueryTermId(sdId);
	}
	
	public CRFAutoquery getQueryBySIdTermName(long sId, String termName) throws NoSuchCRFAutoqueryException {
		return super.crfAutoqueryPersistence.findBySIdTN(sId, termName);
	}
	
	public List<CRFAutoquery> getQueryBySId(long sId){
		return super.crfAutoqueryPersistence.findBySubjectId(sId);
	}
	
	public void checkQuery(
			long sdId, 
			JSONArray crfForm, 
			JSONObject answerForm, 
			long subjectId,
			long crfId,
			ServiceContext sc) throws PortalException {
		CRF crf = CRFLocalServiceUtil.getCRF(crfId);
		DataType dataType = DataTypeLocalServiceUtil.getDataType(crf.getDatatypeId());
		
		_log.info("crf / datatype / sd : " + crfId + " / " + dataType.getDataTypeId() + " / " + sdId );
		
		if(dataType.getDataTypeName().equals("er_crf")) {
			for(int i = 0; i < crfForm.length(); i++) {
				String queryTermName = "";
				String queryValue = "";
				int queryType = 0;
	
				String compareValue = "";
				String minValue = "";
				String maxValue = "";
				boolean isString = true;
				if(crfForm.getJSONObject(i).getString("termType").equals("Numeric")) {
					queryTermName = crfForm.getJSONObject(i).getString("termName");
					
					if(answerForm.has(queryTermName)) {
						queryValue = answerForm.getString(queryTermName).trim();
					}
					
					if(queryValue.equals("")) {
						isString = false;
					}
					
					if(queryValue.equals("-1")) {
						isString = false;
					}
					
					if(queryValue.equals("NA")) {
						isString = false;
					}
					
					if(queryValue.isEmpty()) {
						isString = false;
					}
					int pointCount = 0;
					for(int k = 0; k < queryValue.length(); k++) {
						if(queryValue.charAt(k) == '.') {
							pointCount++;
						}
					}
					if(pointCount > 1) {
						isString = false;
					}
					
					try {
						float testFloat = Float.parseFloat(queryValue);
						//_log.info(testFloat);
						isString = true;
					}catch(NumberFormatException nfe) {
						isString = false;
					}
					
					if(isString) {
						if(crfForm.getJSONObject(i).has("minValue")) {
							//only min
							minValue = crfForm.getJSONObject(i).getString("minValue");
							if(crfForm.getJSONObject(i).has("maxValue")) {
								// min max both
								maxValue = crfForm.getJSONObject(i).getString("maxValue");
							}
						} else if(crfForm.getJSONObject(i).has("maxValue")) {
							//only max
							maxValue = crfForm.getJSONObject(i).getString("maxValue");
						}
						
						if(!minValue.equals("")) {
							queryType = 1;
							if(!maxValue.equals("")) {
								queryType = 3;
							}
						}else if(!maxValue.equals("")) {
							queryType = 2;
						}
						
						switch(queryType) {
							case 1:
								// min value compare
								if(Float.valueOf(minValue) < Float.valueOf(queryValue)) {
									queryType = 0;
									if(minValue.contains(".")) {
										queryType = checkFloatingPoint(minValue, queryValue);
									}
								}
								break;
							case 2:
								// max value compare
								if(Float.valueOf(maxValue) > Float.valueOf(queryValue)) {
									queryType = 0;
									if(maxValue.contains(".")) {
										queryType = checkFloatingPoint(maxValue, queryValue);
									}
								}
								break;
							case 3:
								//min max value compare
								if(Float.valueOf(maxValue) > Float.valueOf(queryValue) && Float.valueOf(minValue) < Float.valueOf(queryValue)) {
									queryType = 0;
									if(minValue.contains(".")) {
										queryType = checkFloatingPoint(minValue, queryValue);
									}
								}
								break;
							default:
								break;	
						}
						_log.info("QueryUtil : " + sdId + " / " + queryTermName + " / " + minValue + " < " + queryValue + " < " + maxValue + " / " + queryType);
						if(queryType > 0 && countQueryBySdIdSIdValue(sdId, subjectId, queryTermName, queryValue) < 1) {
							addCRFAutoquery(sdId, queryTermName, queryValue, "", subjectId, crfId, queryType, "", sc);
						}
					}
				}
			}
		}else if(dataType.getDataTypeName().equals("develop_crf")) {
			for(int i = 0; i < crfForm.length(); i++) {
				String queryTermName = "";
				String queryValue = "";
				int queryType = 0;
	
				String compareValue = "";
				String minValue = "";
				String maxValue = "";
				boolean isString = true;
				if(crfForm.getJSONObject(i).getString("termType").equals("Numeric")) {
					queryTermName = crfForm.getJSONObject(i).getString("termName");
					
					if(answerForm.has(queryTermName)) {
						queryValue = answerForm.getString(queryTermName).trim();
					}
					
					if(queryValue.equals("")) {
						isString = false;
					}
					
					if(queryValue.equals("-1")) {
						isString = false;
					}
					
					if(queryValue.equals("NA")) {
						isString = false;
					}
					
					if(queryValue.isEmpty()) {
						isString = false;
					}
					int pointCount = 0;
					for(int k = 0; k < queryValue.length(); k++) {
						if(queryValue.charAt(k) == '.') {
							pointCount++;
						}
					}
					if(pointCount > 1) {
						isString = false;
					}
					
					try {
						float testFloat = Float.parseFloat(queryValue);
						//_log.info(testFloat);
						isString = true;
					}catch(NumberFormatException nfe) {
						isString = false;
					}
					
					if(isString) {
						if(crfForm.getJSONObject(i).has("minValue")) {
							//only min
							minValue = crfForm.getJSONObject(i).getString("minValue");
							if(crfForm.getJSONObject(i).has("maxValue")) {
								// min max both
								maxValue = crfForm.getJSONObject(i).getString("maxValue");
							}
						} else if(crfForm.getJSONObject(i).has("maxValue")) {
							//only max
							maxValue = crfForm.getJSONObject(i).getString("maxValue");
						}
						
						if(!minValue.equals("")) {
							queryType = 1;
							if(!maxValue.equals("")) {
								queryType = 3;
							}
						}else if(!maxValue.equals("")) {
							queryType = 2;
						}
						
						switch(queryType) {
							case 1:
								// min value compare
								if(Float.valueOf(minValue) < Float.valueOf(queryValue)) {
									queryType = 0;
									if(minValue.contains(".")) {
										queryType = checkFloatingPoint(minValue, queryValue);
									}
								}
								break;
							case 2:
								// max value compare
								if(Float.valueOf(maxValue) > Float.valueOf(queryValue)) {
									queryType = 0;
									if(maxValue.contains(".")) {
										queryType = checkFloatingPoint(maxValue, queryValue);
									}
								}
								break;
							case 3:
								//min max value compare
								if(Float.valueOf(maxValue) > Float.valueOf(queryValue) && Float.valueOf(minValue) < Float.valueOf(queryValue)) {
									queryType = 0;
									if(minValue.contains(".")) {
										queryType = checkFloatingPoint(minValue, queryValue);
									}
								}
								break;
							default:
								break;	
						}
						_log.info("QueryUtil : " + sdId + " / " + queryTermName + " / " + minValue + " < " + queryValue + " < " + maxValue + " / " + queryType);
						if(queryType > 0 && countQueryBySdIdSIdValue(sdId, subjectId, queryTermName, queryValue) < 1) {
							addCRFAutoquery(sdId, queryTermName, queryValue, "", subjectId, crfId, queryType, "", sc);
						}
					}
				}
			}			
		}
	}
	
	public int checkFloatingPoint(String compareValue, String queryValue) {
		if(!queryValue.contains(".")) {
			return 4;
		}else {
			String[] compareValueSplit = compareValue.split("[.]");
			String[] queryValueSplit = queryValue.split("[.]");
			if(compareValueSplit[1].length() == queryValueSplit[1].length()) {
				return 0;
			}
			else {
				return 5;
			}
		}
	}
}