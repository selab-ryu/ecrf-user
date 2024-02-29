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
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.ArrayList;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.CRF;
import ecrf.user.model.CRFResearcher;
import ecrf.user.model.Researcher;
import ecrf.user.model.custom.CRFResearcherInfo;
import ecrf.user.service.CRFLocalService;
import ecrf.user.service.CRFResearcherLocalService;
import ecrf.user.service.ResearcherLocalService;
import ecrf.user.service.base.CRFResearcherServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ec",
		"json.web.service.context.path=CRFResearcher"
	},
	service = AopService.class
)
@JSONWebService("crf-researcher")
public class CRFResearcherServiceImpl extends CRFResearcherServiceBaseImpl {
	
	@JSONWebService("get-crf-researcher-list")
	public ArrayList<CRFResearcherInfo> getCRFResearcherList(long groupId, long crfId) {
		_log.info("get crf researcher list");
		ArrayList<Researcher> researcherList = new ArrayList<>();
		ArrayList<CRFResearcher> crfResearcherList = new ArrayList<>();
		crfResearcherList.addAll(_crfResearcherLocalService.getCRFResearcherByCRFId(crfId));
		
		_log.info("crf researcher list size : " + crfResearcherList.size());
		ArrayList<CRFResearcherInfo> crfResearcherInfoList = new ArrayList<>();
		
		int crfResearcherListSize = crfResearcherList.size();
		
		if(crfResearcherListSize > 0) {
			try {
				for(CRFResearcher crfResearcher : crfResearcherList) {
					long researcherId = crfResearcher.getResearcherId();
					Researcher researcher = _researcherLocalService.getResearcher(researcherId);
					CRF crf = _crfLocalService.getCRF(crfId);
					DataType dataType = _dataTypeLocalService.getDataType(crf.getDatatypeId());
					
					CRFResearcherInfo info = new CRFResearcherInfo(crfResearcher.getCrfResearcherId(), crfId, researcher.getResearcherId());
					
					// set variable
					info.setGroupId(groupId);
					
					info.setCrfName(dataType.getDisplayName(Locale.ENGLISH));
					info.setCrfStatus(crf.getCrfStatus());

					info.setEmail(researcher.getEmail());
					info.setName(researcher.getName());
					info.setBirth(researcher.getBirth());
					info.setGender(researcher.getGender());
					
					info.setPhone(researcher.getPhone());
					info.setOfficeContact(researcher.getOfficeContact());
					info.setInstitution(researcher.getInstitution());
					
					info.setPosition(researcher.getPosition());
					
					info.setResearcherUserId(researcher.getResearcherUserId());
					
					crfResearcherInfoList.add(info);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return crfResearcherInfoList;
	}
	
	@JSONWebService("get-all-crf-researcher-info")
	public ArrayList<CRFResearcherInfo> getCRFAllResearcherInfoList(long groupId, long crfId) {
		_log.info("get all crf researcher info");
		
		ArrayList<Researcher> researcherList = new ArrayList<>();
		// get researcher by group's membership
		researcherList.addAll(_researcherLocalService.getResearcherBySite(groupId));

		ArrayList<CRFResearcherInfo> crfResearcherInfoList = new ArrayList<>();		
		
		try {
			for(Researcher researcher : researcherList) {
				long researcherId = researcher.getResearcherId();
				CRF crf = _crfLocalService.getCRF(crfId);
				DataType dataType = _dataTypeLocalService.getDataType(crf.getDatatypeId());
				
				CRFResearcherInfo info = new CRFResearcherInfo(0, crfId, researcherId);
				
				// set variable
				info.setGroupId(groupId);
				
				info.setCrfName(dataType.getDisplayName(Locale.ENGLISH));
				info.setCrfStatus(crf.getCrfStatus());

				info.setEmail(researcher.getEmail());
				info.setName(researcher.getName());
				info.setBirth(researcher.getBirth());
				info.setGender(researcher.getGender());
				
				info.setPhone(researcher.getPhone());
				info.setOfficeContact(researcher.getOfficeContact());
				info.setInstitution(researcher.getInstitution());
				
				info.setPosition(researcher.getPosition());
				
				info.setResearcherUserId(researcher.getResearcherUserId());
				
				crfResearcherInfoList.add(info);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return crfResearcherInfoList;
	}
	
	private Log _log = LogFactoryUtil.getLog(CRFResearcherServiceImpl.class);
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private CRFLocalService _crfLocalService;
	
	@Reference
	private CRFResearcherLocalService _crfResearcherLocalService;
	
	@Reference
	private ResearcherLocalService _researcherLocalService;
	
}