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
			String name,
			int birthYear, int birthMonth, int birthDay,
			String position, int gender, String phone, String phone2,
			String serialId, int hospitalCode,
			int visitDateYear, int visitDateMonth, int visitDateDay,
			int consentYear, int consentMonth, int consentDay,
			int participationDateYear, int participationDateMonth, int participationDateDay,
			int participationStatus, String experimentalGroup,
			boolean hasCRF, boolean hasCohortStudy, boolean hasMRIStudy,
			ServiceContext sc) throws PortalException {
		_log = LogFactoryUtil.getLog(this.getClass().getName());
		_log.info("Service : Add Patient");
		
		long patientId = super.counterLocalService.increment();
		Patient patient = super.patientLocalService.createPatient(patientId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		Date visitDate = PortalUtil.getDate(visitDateMonth, visitDateDay, visitDateYear);
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
		patient.setPosition(position);
		patient.setGender(gender);
		patient.setPhone(phone);
		patient.setPhone2(phone2);
		
		patient.setSerialId(serialId);
		patient.setHospitalCode(hospitalCode);
		patient.setVisitDate(visitDate);
		patient.setConsentDate(consentDate);
		patient.setParticipationStartDate(participationStartDate);
		patient.setParticipationStatus(participationStatus);
		patient.setExperimentalGroup(experimentalGroup);
		
		patient.setHasCRF(hasCRF);
		patient.setHasCohortStudy(hasCohortStudy);
		patient.setHasMRIStudy(hasMRIStudy);
		
		// other liferay frameworks
		
		super.patientPersistence.update(patient);
		
		return patient;
	}
	
	public Patient updatePatient(
			long patientId, String name,
			int birthYear, int birthMonth, int birthDay,
			String position, int gender, String phone, String phone2,
			String serialId, int hospitalCode,
			int visitDateYear, int visitDateMonth, int visitDateDay,
			int consentYear, int consentMonth, int consentDay,
			int participationDateYear, int participationDateMonth, int participationDateDay,
			int participationStatus, String experimentalGroup,
			boolean hasCRF, boolean hasCohortStudy, boolean hasMRIStudy,
			ServiceContext sc) throws PortalException {
		_log = LogFactoryUtil.getLog(this.getClass().getName());
		_log.info("Service : Update Patient");
		
		Patient patient = super.patientLocalService.getPatient(patientId);
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		Date visitDate = PortalUtil.getDate(visitDateMonth, visitDateDay, visitDateYear);
		Date consentDate = PortalUtil.getDate(consentMonth, consentDay, consentYear);
		Date participationStartDate = PortalUtil.getDate(participationDateMonth, participationDateDay, participationDateYear);
		
		// set audit fields
		patient.setModifiedDate(sc.getModifiedDate());
		patient.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		patient.setName(name);
		patient.setBirth(birth);
		patient.setPosition(position);
		patient.setGender(gender);
		patient.setPhone(phone);
		patient.setPhone2(phone2);
		
		patient.setSerialId(serialId);
		patient.setHospitalCode(hospitalCode);
		patient.setVisitDate(visitDate);
		patient.setConsentDate(consentDate);
		patient.setParticipationStartDate(participationStartDate);
		patient.setParticipationStatus(participationStatus);
		patient.setExperimentalGroup(experimentalGroup);
		
		patient.setHasCRF(hasCRF);
		patient.setHasCohortStudy(hasCohortStudy);
		patient.setHasMRIStudy(hasMRIStudy);
		
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
	
	@Reference
	private CRFPatientLocalService _crfPatientLocalService;
	
	private Log _log;
}