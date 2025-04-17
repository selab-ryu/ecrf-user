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
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.exception.NoSuchSubjectException;
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
			String lunarBirth,
			int gender, String phone, String phone2, String address, 
			String serialId, int hospitalCode,
			long expGroupId,
			ServiceContext sc) throws PortalException {
		_log.info("Service : Add Subject Start");
		
		long subjectId = super.counterLocalService.increment();
		Subject subject = super.subjectLocalService.createSubject(subjectId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		
		Date now = new Date();
		
		// set audit fields
		subject.setCompanyId(sc.getCompanyId());
		subject.setGroupId(groupId);
		subject.setUserId(userId);
		subject.setUserName(user.getFullName());
		subject.setCreateDate(now);
		subject.setModifiedDate(now);
		
		// set entity fields
		subject.setName(name);
		subject.setBirth(birth);
		subject.setLunarBirth(lunarBirth);
		subject.setGender(gender);
		subject.setPhone(phone);
		subject.setPhone2(phone2);
		subject.setAddress(address);
		
		subject.setSerialId(serialId);
		subject.setHospitalCode(hospitalCode);
		
		subject.setExpGroupId(expGroupId);
		
		// other liferay frameworks
		
		subject.setExpandoBridgeAttributes(sc);
		subject.setStatus(WorkflowConstants.STATUS_APPROVED);
		subject.setStatusByUserId(userId);
		subject.setStatusByUserName(user.getFullName());
		subject.setStatusDate(now);
		
		subject.setExpandoBridgeAttributes(sc);
		super.subjectPersistence.update(subject);
		
		resourceLocalService.addResources(
			subject.getCompanyId(), 0, userId,
			Subject.class.getName(), subjectId,
			false, true, true);
		
		_log.info("Service : Add Subject End");
		return subject;
	}
	
	public Subject updateSubject(
			long subjectId, String name,
			int birthYear, int birthMonth, int birthDay,
			String lunarBirth,
			int gender, String phone, String phone2, String address, 
			String serialId, int hospitalCode,
			long expGroupId,
			ServiceContext sc) throws PortalException {
		_log.info("Service : Update Subject Start");
		
		Subject subject = super.subjectLocalService.getSubject(subjectId);
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		
		// set audit fields
		subject.setModifiedDate(sc.getModifiedDate());
		subject.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		subject.setName(name);
		subject.setBirth(birth);
		subject.setLunarBirth(lunarBirth);
		subject.setGender(gender);
		subject.setPhone(phone);
		subject.setPhone2(phone2);
		subject.setAddress(address);
		
		subject.setSerialId(serialId);
		subject.setHospitalCode(hospitalCode);
		
		subject.setExpGroupId(expGroupId);
		
		super.subjectPersistence.update(subject);
		
		resourceLocalService.updateResources(
				subject.getCompanyId(), 0, 
				Subject.class.getName(), subject.getSubjectId(),
				sc.getModelPermissions());
		
		_log.info("Service : Update Subject End");
		return subject;
	}
	
	public Subject deleteSubject(long subjectId) throws PortalException {
		Subject subject = null;
		if(subjectId > 0) {
			subject = super.subjectLocalService.getSubject(subjectId);
			super.subjectPersistence.remove(subjectId);
			
			resourceLocalService.deleteResource(
				subject.getCompanyId(),
				Subject.class.getName(), 
				ResourceConstants.SCOPE_INDIVIDUAL, subject.getSubjectId());
			
			//_log.info("service group id : " + subject.getGroupId());
			
			List<CRFSubject> crfSubjectList = _crfSubjectLocalService.getCRFSubjectBySubjectId(subject.getGroupId(), subjectId);
			for(CRFSubject crfSubject : crfSubjectList) {
				_crfSubjectLocalService.deleteCRFSubject(crfSubject.getCrfSubjectId());
			}
			
			// both of below processed by crf subject service
			// remove link crf
			// remove structured data
		}
		
		return subject;
	}
	
	public Subject deleteSubject(Subject subject) {
		super.subjectPersistence.remove(subject);
		
		try {
			resourceLocalService.deleteResource(
				subject.getCompanyId(),
				Subject.class.getName(), 
				ResourceConstants.SCOPE_INDIVIDUAL, subject.getSubjectId());
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		List<CRFSubject> crfSubjectList = _crfSubjectLocalService.getCRFSubjectBySubjectId(subject.getGroupId(), subject.getSubjectId());
		for(CRFSubject crfSubject : crfSubjectList) {
			_crfSubjectLocalService.deleteCRFSubject(crfSubject);
		}
		
		// both of below processed by crf subject service
		// remove link crf
		// remove structured data
		
		return subject;
	}
	
	public void deleteAllSubject(long groupId) throws PortalException {
		List<Subject> allSubjectList = new ArrayList<>();
		allSubjectList = getSubjectByGroupId(groupId);
		
		for(int i=0; i<allSubjectList.size(); i++) {
			Subject subject = allSubjectList.get(i);
			deleteSubject(subject.getSubjectId());
		}
	}
	
	public List<Subject> getAllSubject() {
		return super.subjectPersistence.findAll();
	}
	
	public List<Subject> getSubjectByGroupId(long groupId) {
		return super.subjectPersistence.findByGroupId(groupId);
	}
	
	public List<Subject> getSubjectByIds(long groupId, long[] subjectIds) {
		return subjectFinder.findBySubjectIds(groupId, subjectIds);
	}
	
	public Subject getSubjectBySerialId(long groupId, String serialId) {
		Subject subject = null;
		
		try {
			subject = super.subjectPersistence.findBySerialId(groupId, serialId);
		} catch (NoSuchSubjectException e) {
			_log.info("No such Subject with serialId : " + serialId );
		}
		return subject;
	}
	
	public boolean isDuplicatedSerialId(long groupId, String serialId) {
		return Validator.isNotNull(getSubjectBySerialId(groupId, serialId));
	}
	
	@Reference
	private CRFSubjectLocalService _crfSubjectLocalService;
	
	private Log _log = LogFactoryUtil.getLog(SubjectLocalServiceImpl.class);
}