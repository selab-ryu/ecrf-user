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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.CRFPatient;
import ecrf.user.model.Patient;
import ecrf.user.service.CRFPatientLocalService;
import ecrf.user.service.base.PatientLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ecrf.user.model.Patient",
	service = AopService.class
)
public class PatientLocalServiceImpl extends PatientLocalServiceBaseImpl {
	public Patient addPatient(
			long patientUserId, String name,
			int birthYear, int birthMonth, int birthDay,
			String phone, String position, int gender,
			int consentYear, int consentMonth, int consentDay,
			int participationDateYear, int participationDateMonth, int participationDateDay,
			int participationStatus, String experimentalGroup,
			ServiceContext sc) throws PortalException {
		_logger = Logger.getLogger(this.getClass().getName());
		_logger.info("Add Patient Start");
		
		long patientId = super.counterLocalService.increment();
		Patient patient = super.patientLocalService.createPatient(patientId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		Date consentDate = PortalUtil.getDate(consentMonth, consentDay, consentYear);
		Date participationStartDate = PortalUtil.getDate(participationDateMonth, participationDateDay, participationDateYear);
		
		// set audit fields
		patient.setUserId(userId);
		patient.setUserName(user.getFullName());
		patient.setCompanyId(user.getCompanyId());
		patient.setGroupId(groupId);
		patient.setCreateDate(sc.getCreateDate());
		patient.setModifiedDate(sc.getModifiedDate());
		patient.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		patient.setName(name);
		patient.setBirth(birth);
		patient.setPhone(phone);
		patient.setPosition(position);
		patient.setGender(gender);
		patient.setConsentDate(consentDate);
		patient.setParticipationStartDate(participationStartDate);
		patient.setParticipationStatus(participationStatus);
		patient.setExperimentalGroup(experimentalGroup);
		patient.setPatientUserId(patientUserId);
		
		// other liferay frameworks
		
		super.patientPersistence.update(patient);
		
		return patient;
	}
	
	public Patient updatePatient(
			long patientId, long patientUserId, String name,
			int birthYear, int birthMonth, int birthDay,
			String phone, String position, int gender,
			int consentYear, int consentMonth, int consentDay,
			int participationDateYear, int participationDateMonth, int participationDateDay,
			int participationStatus, String experimentalGroup,
			ServiceContext sc) throws PortalException {
		_logger = Logger.getLogger(this.getClass().getName());
		_logger.info("Update Patient Start");
		
		Patient patient = super.patientLocalService.createPatient(patientId);
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		Date consentDate = PortalUtil.getDate(consentMonth, consentDay, consentYear);
		Date participationStartDate = PortalUtil.getDate(participationDateMonth, participationDateDay, participationDateYear);
		
		// set audit fields
		patient.setModifiedDate(sc.getModifiedDate());
		patient.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		patient.setName(name);
		patient.setBirth(birth);
		patient.setPhone(phone);
		patient.setPosition(position);
		patient.setGender(gender);
		patient.setConsentDate(consentDate);
		patient.setParticipationStartDate(participationStartDate);
		patient.setParticipationStatus(participationStatus);
		patient.setExperimentalGroup(experimentalGroup);
		patient.setPatientUserId(patientUserId);
		
		// other liferay frameworks
		
		super.patientPersistence.update(patient);
		
		return patient;
	}
	
	public Patient deletePatient(long patientId, ServiceContext sc) throws PortalException {
		Patient patient = null;
		if(patientId > 0) {
			patient = super.patientLocalService.getPatient(patientId);
			super.patientPersistence.remove(patientId);
			
			List<CRFPatient> crfPatientList = _crfPatientLocalService.getCRFPatientByPatientId(sc.getScopeGroupId(), patientId);
			for(CRFPatient crfPatient : crfPatientList) {
				_crfPatientLocalService.deleteCRFPatient(crfPatient);
			}
		}
		
		return patient;
	}
	
	public Patient deletePatient(Patient patient, ServiceContext sc) {
		super.patientPersistence.remove(patient);
		
		List<CRFPatient> crfPatientList = _crfPatientLocalService.getCRFPatientByPatientId(sc.getScopeGroupId(), patient.getPatientId());
		for(CRFPatient crfPatient : crfPatientList) {
			_crfPatientLocalService.deleteCRFPatient(crfPatient);
		}
		
		return patient;
	}
	
	public List<Patient> getPatientByGroupId(long groupId) {
		return super.patientPersistence.findByGroupId(groupId);
	}
	public List<Patient> getPatientByGroupId(long groupId, int start, int end) {
		return super.patientPersistence.findByGroupId(groupId, start, end);
	}
	public List<Patient> getPatientByGroupId(long groupId, int start, int end, OrderByComparator comparator) {
		return super.patientPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int getPatientCount(long groupId) {
		return super.patientPersistence.countByGroupId(groupId);
	}
	
	@Reference
	private CRFPatientLocalService _crfPatientLocalService;
	
	private Logger _logger;
}