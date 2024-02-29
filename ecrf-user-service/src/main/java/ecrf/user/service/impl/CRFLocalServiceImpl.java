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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.CRF;
import ecrf.user.model.CRFAutoquery;
import ecrf.user.model.CRFHistory;
import ecrf.user.model.CRFResearcher;
import ecrf.user.model.CRFSubject;
import ecrf.user.model.LinkCRF;
import ecrf.user.service.CRFAutoqueryLocalService;
import ecrf.user.service.CRFHistoryLocalService;
import ecrf.user.service.CRFResearcherLocalService;
import ecrf.user.service.CRFSubjectLocalService;
import ecrf.user.service.LinkCRFLocalService;
import ecrf.user.service.base.CRFLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ecrf.user.model.CRF",
	service = AopService.class
)
public class CRFLocalServiceImpl extends CRFLocalServiceBaseImpl {
	public CRF addCRF(
			String crfName,
			String crfVersion,
			Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap,
			int applyDateYear, int applyDateMonth, int applyDateDay,
			int crfStatus,
			ServiceContext crfsc, ServiceContext dtsc) throws PortalException {
		_log.info("Add CRF Start");
		
		_log.info("create datatype");
		
		String extension = "docx";
		int status = WorkflowConstants.STATUS_APPROVED;
		DataType datatype = _dataTypeLocalService.addDataType(crfName, crfVersion, extension, titleMap, descriptionMap, null, status, dtsc);
		
		long crfId = super.counterLocalService.increment();
		CRF crf = super.crfLocalService.createCRF(crfId);
				
		// get metadata
		long userId = crfsc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = crfsc.getScopeGroupId();
		
		Date applyDate = PortalUtil.getDate(applyDateMonth, applyDateDay, applyDateYear);
		
		// set audit fields
		crf.setGroupId(groupId);
		crf.setUserId(userId);
		crf.setUserName(user.getFullName());
		crf.setCompanyId(user.getCompanyId());
		crf.setCreateDate(crfsc.getCreateDate());
		crf.setModifiedDate(crfsc.getModifiedDate());
		crf.setExpandoBridgeAttributes(crfsc);
		
		// set entity fields
		crf.setDatatypeId(datatype.getDataTypeId());
		crf.setApplyDate(applyDate);
		crf.setCrfStatus(crfStatus);
		
		// other liferay frameworks
		
		super.crfPersistence.update(crf);
		
		return crf;
	}
	
	public CRF updateCRF(
			long crfId,
			String crfName,
			String crfVersion,
			Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap,
			int applyDateYear, int applyDateMonth, int applyDateDay,
			int crfStatus,
			ServiceContext crfsc, ServiceContext dtsc) throws PortalException {
		_log.info("Add CRF Start");
		
		CRF crf = super.crfLocalService.getCRF(crfId);
		
		long dataTypeId = crf.getDatatypeId();
		
		_log.info("update DataType");
		
		String extension = "docx";
		int status = WorkflowConstants.STATUS_APPROVED;
		
		DataType dataType = _dataTypeLocalService.updateDataType(dataTypeId, crfName, crfVersion, extension, titleMap, descriptionMap, null, status, dtsc);
		
		Date applyDate = PortalUtil.getDate(applyDateMonth, applyDateDay, applyDateYear);
		
		// set audit fields
		crf.setModifiedDate(crfsc.getModifiedDate());
		crf.setExpandoBridgeAttributes(crfsc);
		
		// set entity fields
		crf.setApplyDate(applyDate);
		crf.setCrfStatus(crfStatus);
		
		// other liferay frameworks
		
		super.crfPersistence.update(crf);
		
		return crf;
	}
	
	public CRF updateCRFStatus(long crfId, int crfStatus, ServiceContext sc) {
		CRF crf = super.crfPersistence.fetchByPrimaryKey(crfId);
		
		crf.setCrfStatus(crfStatus);
		
		super.crfPersistence.update(crf);
		return crf;
	}
	
	public CRF deleteCRF(long crfId, ServiceContext sc) throws PortalException {
		CRF crf = null;
		
		if(crfId > 0) {
			crf = super.crfLocalService.getCRF(crfId);
			super.crfPersistence.remove(crfId);
			
			// remove crf-researcher
			List<CRFResearcher> crfResearcherList = _crfResearcherLocalService.getCRFResearcherByCRFId(crfId);
			for (CRFResearcher crfResearcher : crfResearcherList) {
				_crfResearcherLocalService.deleteCRFResearcher(crfResearcher);
			}
			
			// remove crf-subject
			List<CRFSubject> crfSubjectList = _crfSubjectLocalService.getCRFSubjectByCRFId(sc.getScopeGroupId(), crf.getCrfId());
			for(CRFSubject crfSubject : crfSubjectList) {
				_crfSubjectLocalService.deleteCRFSubject(crfSubject);
			}
			
			// remove crf-data
			List<LinkCRF> linkCRFList = _linkCRFLocalService.getLinkCRFByG_C(sc.getScopeGroupId(), crf.getCrfId());
			for(LinkCRF link : linkCRFList) {
				_linkCRFLocalService.deleteLinkCRF(link);
			}
			
			// remove crf-query
			List<CRFAutoquery> crfAutoQueryList = _crfAutoQueryLocalService.getQueryByGroupCRF(sc.getScopeGroupId(), crf.getCrfId());
			for(CRFAutoquery query : crfAutoQueryList) {
				_crfAutoQueryLocalService.deleteCRFAutoquery(query);
			}
			
			// remove crf-history
			List<CRFHistory> historyList = _crfHistoryLocalService.getCRFHistoryByG_C(sc.getScopeGroupId(), crf.getCrfId());
			for(CRFHistory history : historyList) {
				_crfHistoryLocalService.deleteCRFHistory(history);
			}
			
			long dataTypeId = 0;
			dataTypeId = crf.getDatatypeId();
			if(dataTypeId > 0) {
				_dataTypeLocalService.deleteDataType(dataTypeId);
			}
		}
		
		return crf;
	}
	
	public CRF deleteCRF(CRF crf, ServiceContext sc) {
		super.crfPersistence.remove(crf);
		
		// remove crf-researcher
		List<CRFResearcher> crfResearcherList = _crfResearcherLocalService.getCRFResearcherByCRFId(crf.getCrfId());
		for (CRFResearcher crfResearcher : crfResearcherList) {
			_crfResearcherLocalService.deleteCRFResearcher(crfResearcher);
		}
		
		// remove crf-subject
		List<CRFSubject> crfSubjectList = _crfSubjectLocalService.getCRFSubjectByCRFId(sc.getScopeGroupId(), crf.getCrfId());
		for(CRFSubject crfSubject : crfSubjectList) {
			_crfSubjectLocalService.deleteCRFSubject(crfSubject);
		}
		
		// remove crf-data
		List<LinkCRF> linkCRFList = _linkCRFLocalService.getLinkCRFByG_C(sc.getScopeGroupId(), crf.getCrfId());
		for(LinkCRF link : linkCRFList) {
			_linkCRFLocalService.deleteLinkCRF(link);
		}
		
		// remove crf-query
		List<CRFAutoquery> crfAutoQueryList = _crfAutoQueryLocalService.getQueryByGroupCRF(sc.getScopeGroupId(), crf.getCrfId());
		for(CRFAutoquery query : crfAutoQueryList) {
			_crfAutoQueryLocalService.deleteCRFAutoquery(query);
		}
		
		// remove crf-history
		List<CRFHistory> historyList = _crfHistoryLocalService.getCRFHistoryByG_C(sc.getScopeGroupId(), crf.getCrfId());
		for(CRFHistory history : historyList) {
			_crfHistoryLocalService.deleteCRFHistory(history);
		}
		
		long dataTypeId = 0;
		dataTypeId = crf.getDatatypeId();
		if(dataTypeId > 0) {
			try {
				_dataTypeLocalService.deleteDataType(dataTypeId);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		
		return crf;
	}
	
	public long getDataTypeId(long crfId) {
		CRF crf = super.crfPersistence.fetchByPrimaryKey(crfId);
		long dataTypeId = 0;
		if(Validator.isNotNull(crf)) {
			dataTypeId = crf.getDatatypeId();
		}
		return dataTypeId;
	}
	
	public String getTitle(long crfId, Locale locale) {
		CRF crf = super.crfPersistence.fetchByPrimaryKey(crfId);
		long dataTypeId = 0;
		String title = "";
		if(Validator.isNotNull(crf)) {
			dataTypeId = crf.getDatatypeId();
			DataType dataType = _dataTypeLocalService.fetchDataType(dataTypeId);
			if(Validator.isNotNull(dataType))
				title = dataType.getDisplayName(locale);
		}
		return title;
	}
	
	public List<CRF> getCRFByGroupId(long groupId) {
		return super.crfPersistence.findByGroupId(groupId);
	}
	public List<CRF> getCRFByGroupId(long groupId, int start, int end) {
		return super.crfPersistence.findByGroupId(groupId, start, end);
	}
	public List<CRF> getCRFByGroupId(long groupId, int start, int end, OrderByComparator comparator) {
		return super.crfPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int getCRFCount(long groupId) {
		return super.crfPersistence.countByGroupId(groupId);
	}	
	
	@Reference
	private CRFAutoqueryLocalService _crfAutoQueryLocalService;
	
	@Reference
	private CRFHistoryLocalService _crfHistoryLocalService;
	
	@Reference
	private LinkCRFLocalService _linkCRFLocalService;
	
	@Reference
	private CRFSubjectLocalService _crfSubjectLocalService;
	
	@Reference
	private CRFResearcherLocalService _crfResearcherLocalService;
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	private Log _log = LogFactoryUtil.getLog(CRFLocalServiceImpl.class);
}