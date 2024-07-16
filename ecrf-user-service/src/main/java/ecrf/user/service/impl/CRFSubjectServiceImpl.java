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
import com.liferay.portal.kernel.util.Validator;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.ArrayList;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.CRF;
import ecrf.user.model.CRFSubject;
import ecrf.user.model.ExperimentalGroup;
import ecrf.user.model.Subject;
import ecrf.user.model.custom.CRFSubjectInfo;
import ecrf.user.service.CRFLocalService;
import ecrf.user.service.CRFSubjectLocalService;
import ecrf.user.service.ExperimentalGroupLocalService;
import ecrf.user.service.SubjectLocalService;
import ecrf.user.service.base.CRFSubjectServiceBaseImpl;
import ecrf.user.service.persistence.SubjectFinder;

/**
 * @author Ryu W.C.
 */
@Component(
	property = {
		"json.web.service.context.name=ec",
		"json.web.service.context.path=CRFSubject"
	},
	service = AopService.class
)
@JSONWebService("crf-subject")
public class CRFSubjectServiceImpl extends CRFSubjectServiceBaseImpl {
		
	@JSONWebService("get-crf-subject-list")
	public ArrayList<CRFSubjectInfo> getCRFSubjectList(long groupId, long crfId) {
		_log.info("get crf subject list");
		
		ArrayList<Subject> subjectList = new ArrayList<>();
		ArrayList<CRFSubject> crfSubjectList = new ArrayList<>();
		crfSubjectList.addAll(_crfSubjectLocalService.getCRFSubjectByCRFId(groupId, crfId));
		
		ArrayList<CRFSubjectInfo> crfSubjectInfoList = new ArrayList<>();
		
		int crfSubjectListSize = crfSubjectList.size();
		if(crfSubjectListSize > 0) {
			
			for(CRFSubject crfSubject : crfSubjectList) {
				try {
					long subjectId = crfSubject.getSubjectId();
					
					Subject subject = _subjectLocalService.getSubject(subjectId);
					ExperimentalGroup expGroup = _expGroupLocalService.getExpGroupById(subject.getExpGroupId());
					CRF crf = _crfLocalService.getCRF(crfId);
					DataType dataType = _dataTypeLocalService.getDataType(crf.getDatatypeId());
					
					CRFSubjectInfo info = new CRFSubjectInfo(crfSubject.getCrfSubjectId(), crfSubject.getCrfId(), crfSubject.getSubjectId());
					
					info.setCrfName(dataType.getDisplayName(Locale.ENGLISH));
					info.setCrfStatus(crf.getCrfStatus());
					
					info.setSubjectName(subject.getName());
					info.setSerialId(subject.getSerialId());
					info.setSubjectBirth(subject.getBirth());
					info.setSubjectGender(subject.getGender());
					
					info.setParticipationStatus(crfSubject.getParticipationStatus());
					info.setParticipationStartDate(crfSubject.getParticipationStartDate());
					info.setUpdateLock(crfSubject.isUpdateLock());
					
					if(Validator.isNotNull(expGroup))
						info.setExperimentalGroup(expGroup.getName());
					
					crfSubjectInfoList.add(info);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return crfSubjectInfoList;
	}
	
	@JSONWebService("get-crf-subject-info-list-by-update-lock")
	public ArrayList<CRFSubjectInfo> getCRFSubjectList(long groupId, long crfId, boolean isUpdateLock) {
		_log.info("get crf subject list by update lock");
		
		ArrayList<Subject> subjectList = new ArrayList<>();
		ArrayList<CRFSubject> crfSubjectList = new ArrayList<>();
		crfSubjectList.addAll(_crfSubjectLocalService.getCRFSubjectByG_C_UL(groupId, crfId, isUpdateLock));
		
		ArrayList<CRFSubjectInfo> crfSubjectInfoList = new ArrayList<>();
		
		int crfSubjectListSize = crfSubjectList.size();
		if(crfSubjectListSize > 0) {
			
			for(CRFSubject crfSubject : crfSubjectList) {
				try {
					long subjectId = crfSubject.getSubjectId();
					
					Subject subject = _subjectLocalService.getSubject(subjectId);
					ExperimentalGroup expGroup = _expGroupLocalService.getExpGroupById(subject.getExpGroupId());
					CRF crf = _crfLocalService.getCRF(crfId);
					DataType dataType = _dataTypeLocalService.getDataType(crf.getDatatypeId());
					
					CRFSubjectInfo info = new CRFSubjectInfo(crfSubject.getCrfSubjectId(), crfSubject.getCrfId(), crfSubject.getSubjectId());
					
					info.setCrfName(dataType.getDisplayName(Locale.ENGLISH));
					info.setCrfStatus(crf.getCrfStatus());
					
					info.setSubjectName(subject.getName());
					info.setSerialId(subject.getSerialId());
					info.setSubjectBirth(subject.getBirth());
					info.setSubjectGender(subject.getGender());
					
					info.setParticipationStatus(crfSubject.getParticipationStatus());
					info.setParticipationStartDate(crfSubject.getParticipationStartDate());
					info.setUpdateLock(crfSubject.isUpdateLock());
					
					if(Validator.isNotNull(expGroup))
						info.setExperimentalGroup(expGroup.getName());
					
					crfSubjectInfoList.add(info);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return crfSubjectInfoList;
	}
	
	@JSONWebService("get-all-crf-subject-info-list")
	public ArrayList<CRFSubjectInfo> getAllCRFSubjectInfoList(long groupId, long crfId) {
		_log.info("get all crf subject list");
		
		ArrayList<Subject> subjectList = new ArrayList<>();
		subjectList.addAll(_subjectLocalService.getSubjectByGroupId(groupId));
		
		ArrayList<CRFSubjectInfo> crfSubjectInfoList = new ArrayList<>();
	
		try {
			for(Subject subject : subjectList) {
				long subjectId = subject.getSubjectId();
				
				ExperimentalGroup expGroup = _expGroupLocalService.getExpGroupById(subject.getExpGroupId());
				CRF crf = _crfLocalService.getCRF(crfId);
				DataType dataType = _dataTypeLocalService.getDataType(crf.getDatatypeId());
				
				CRFSubjectInfo info = new CRFSubjectInfo(0, crfId, subjectId);
				
				info.setGroupId(groupId);
				
				info.setCrfName(dataType.getDisplayName(Locale.ENGLISH));
				info.setCrfStatus(crf.getCrfStatus());
				
				info.setSubjectName(subject.getName());
				info.setSerialId(subject.getSerialId());
				info.setSubjectBirth(subject.getBirth());
				info.setSubjectGender(subject.getGender());
				
				if(Validator.isNotNull(expGroup))
					info.setExperimentalGroup(expGroup.getName());
								
				crfSubjectInfoList.add(info);
				//_log.info(info.toString());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
		_log.info(crfSubjectInfoList.size());
		
		return crfSubjectInfoList;
	}
	
	@JSONWebService("get-crf-subject-list-not-included")
	public ArrayList<Subject> getCRFSubjectListNotIncluded(long groupId, long crfId) {
		ArrayList<Subject> subjectList = new ArrayList<>();
		ArrayList<CRFSubject> crfSubjectList = new ArrayList<>();
		crfSubjectList.addAll(_crfSubjectLocalService.getCRFSubjectByCRFId(groupId, crfId));
		subjectList.addAll(_subjectLocalService.getSubjectByGroupId(groupId));
		
		int crfSubjectListSize = crfSubjectList.size();
		if(crfSubjectListSize > 0) {
			long[] subjectIds = getSubjectIdFromCRFSubject(crfSubjectList);
			
			for(int i=0; i<subjectIds.length; i++) {
				long subjectId = subjectIds[i];
				subjectList.removeIf( subject -> (subject.getSubjectId() == subjectId) );
			}
		}
		
		return subjectList;
	}
	
	private long[] getSubjectIdFromCRFSubject(ArrayList<CRFSubject> crfSubjectList) {
		long[] subjectIds = null;
		int crfSubjectListSize = crfSubjectList.size(); 
		if(crfSubjectListSize > 0) {
			subjectIds = new long[crfSubjectListSize];
			
			for(int i=0; i < crfSubjectListSize; i++) {
				CRFSubject crfSubject = crfSubjectList.get(i); 
				subjectIds[i] = crfSubject.getSubjectId();
			}
		}
		return subjectIds;
	}
	
	@JSONWebService("get-subject-list")
	public ArrayList<Subject> getSubjectList(long groupId) {
		ArrayList<Subject> subjectList = new ArrayList<>();
		subjectList.addAll(_subjectLocalService.getSubjectByGroupId(groupId));
		return subjectList;
	}
		
	private Log _log = LogFactoryUtil.getLog(CRFSubjectServiceImpl.class);
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private SubjectLocalService _subjectLocalService;
	
	@Reference
	private ExperimentalGroupLocalService _expGroupLocalService;
	
	@Reference
	private CRFSubjectLocalService _crfSubjectLocalService;
	
	@Reference
	private CRFLocalService _crfLocalService;
	
	@Reference
	private SubjectFinder _subjectFinder;
} 