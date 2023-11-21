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
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.CRFSubject;
import ecrf.user.model.Subject;
import ecrf.user.service.CRFSubjectLocalService;
import ecrf.user.service.base.SubjectLocalServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = "model.class.name=ecrf.user.model.Subject",
	service = AopService.class
)
public class SubjectLocalServiceImpl extends SubjectLocalServiceBaseImpl {
	public Subject addSubject(
			String name,
			int birthYear, int birthMonth, int birthDay,
			int gender, String phone, String phone2, String address, 
			String serialId, int hospitalCode,
			int visitDateYear, int visitDateMonth, int visitDateDay,
			int consentYear, int consentMonth, int consentDay,
			int participationDateYear, int participationDateMonth, int participationDateDay,
			int participationStatus, String experimentalGroup,
			boolean hasCRF, boolean hasCohortStudy, boolean hasMRIStudy,
			ServiceContext sc) throws PortalException {
		_log = LogFactoryUtil.getLog(this.getClass().getName());
		_log.info("Service : Add Subject");
		
		long subjectId = super.counterLocalService.increment();
		Subject subject = super.subjectLocalService.createSubject(subjectId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		Date visitDate = PortalUtil.getDate(visitDateMonth, visitDateDay, visitDateYear);
		Date consentDate = PortalUtil.getDate(consentMonth, consentDay, consentYear);
		Date participationStartDate = PortalUtil.getDate(participationDateMonth, participationDateDay, participationDateYear);
		
		// set audit fields
		subject.setUserId(userId);
		subject.setUserName(user.getFullName());
		subject.setCompanyId(user.getCompanyId());
		subject.setGroupId(groupId);
		subject.setCreateDate(sc.getCreateDate());
		subject.setModifiedDate(sc.getModifiedDate());
		subject.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		subject.setName(name);
		subject.setBirth(birth);
		subject.setGender(gender);
		subject.setPhone(phone);
		subject.setPhone2(phone2);
		subject.setAddress(address);
		
		subject.setSerialId(serialId);
		subject.setHospitalCode(hospitalCode);
		subject.setVisitDate(visitDate);
		subject.setConsentDate(consentDate);
		subject.setParticipationStartDate(participationStartDate);
		subject.setParticipationStatus(participationStatus);
		subject.setExperimentalGroup(experimentalGroup);
		
		subject.setHasCRF(hasCRF);
		subject.setHasCohortStudy(hasCohortStudy);
		subject.setHasMRIStudy(hasMRIStudy);
		
		// other liferay frameworks
		
		super.subjectPersistence.update(subject);
		
		return subject;
	}
	
	public Subject updateSubject(
			long subjectId, String name,
			int birthYear, int birthMonth, int birthDay,
			int gender, String phone, String phone2, String address, 
			String serialId, int hospitalCode,
			int visitDateYear, int visitDateMonth, int visitDateDay,
			int consentYear, int consentMonth, int consentDay,
			int participationDateYear, int participationDateMonth, int participationDateDay,
			int participationStatus, String experimentalGroup,
			boolean hasCRF, boolean hasCohortStudy, boolean hasMRIStudy,
			ServiceContext sc) throws PortalException {
		_log = LogFactoryUtil.getLog(this.getClass().getName());
		_log.info("Service : Update Subject");
		
		Subject subject = super.subjectLocalService.getSubject(subjectId);
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		Date visitDate = PortalUtil.getDate(visitDateMonth, visitDateDay, visitDateYear);
		Date consentDate = PortalUtil.getDate(consentMonth, consentDay, consentYear);
		Date participationStartDate = PortalUtil.getDate(participationDateMonth, participationDateDay, participationDateYear);
		
		// set audit fields
		subject.setModifiedDate(sc.getModifiedDate());
		subject.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		subject.setName(name);
		subject.setBirth(birth);
		subject.setGender(gender);
		subject.setPhone(phone);
		subject.setPhone2(phone2);
		subject.setAddress(address);
		
		subject.setSerialId(serialId);
		subject.setHospitalCode(hospitalCode);
		subject.setVisitDate(visitDate);
		subject.setConsentDate(consentDate);
		subject.setParticipationStartDate(participationStartDate);
		subject.setParticipationStatus(participationStatus);
		subject.setExperimentalGroup(experimentalGroup);
		
		subject.setHasCRF(hasCRF);
		subject.setHasCohortStudy(hasCohortStudy);
		subject.setHasMRIStudy(hasMRIStudy);
		
		// other liferay frameworks
		
		super.subjectPersistence.update(subject);
		
		return subject;
	}
	
	public Subject deleteSubject(long subjectId, ServiceContext sc) throws PortalException {
		Subject subject = null;
		if(subjectId > 0) {
			subject = super.subjectLocalService.getSubject(subjectId);
			super.subjectPersistence.remove(subjectId);
			
			List<CRFSubject> crfSubjectList = _crfSubjectLocalService.getCRFSubjectBySubjectId(sc.getScopeGroupId(), subjectId);
			for(CRFSubject crfSubject : crfSubjectList) {
				_crfSubjectLocalService.deleteCRFSubject(crfSubject);
			}
		}
		
		return subject;
	}
	
	public Subject deleteSubject(Subject subject, ServiceContext sc) {
		super.subjectPersistence.remove(subject);
		
		List<CRFSubject> crfSubjectList = _crfSubjectLocalService.getCRFSubjectBySubjectId(sc.getScopeGroupId(), subject.getSubjectId());
		for(CRFSubject crfSubject : crfSubjectList) {
			_crfSubjectLocalService.deleteCRFSubject(crfSubject);
		}
		
		return subject;
	}
	
	public List<Subject> getAllSubject(long groupId) {
		return super.subjectPersistence.findByGroupId(groupId);
	}
	
	@Reference
	private CRFSubjectLocalService _crfSubjectLocalService;
	
	private Log _log;
}