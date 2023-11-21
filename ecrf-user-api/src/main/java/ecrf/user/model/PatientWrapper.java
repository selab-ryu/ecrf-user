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

package ecrf.user.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Patient}.
 * </p>
 *
 * @author Ryu W.C.
 * @see Patient
 * @generated
 */
public class PatientWrapper
	extends BaseModelWrapper<Patient>
	implements ModelWrapper<Patient>, Patient {

	public PatientWrapper(Patient patient) {
		super(patient);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("patientId", getPatientId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("birth", getBirth());
		attributes.put("position", getPosition());
		attributes.put("gender", getGender());
		attributes.put("phone", getPhone());
		attributes.put("phone2", getPhone2());
		attributes.put("serialId", getSerialId());
		attributes.put("hospitalCode", getHospitalCode());
		attributes.put("visitDate", getVisitDate());
		attributes.put("consentDate", getConsentDate());
		attributes.put("participationStartDate", getParticipationStartDate());
		attributes.put("participationStatus", getParticipationStatus());
		attributes.put("experimentalGroup", getExperimentalGroup());
		attributes.put("hasCRF", getHasCRF());
		attributes.put("hasCohortStudy", getHasCohortStudy());
		attributes.put("hasMRIStudy", getHasMRIStudy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date birth = (Date)attributes.get("birth");

		if (birth != null) {
			setBirth(birth);
		}

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String phone2 = (String)attributes.get("phone2");

		if (phone2 != null) {
			setPhone2(phone2);
		}

		String serialId = (String)attributes.get("serialId");

		if (serialId != null) {
			setSerialId(serialId);
		}

		Integer hospitalCode = (Integer)attributes.get("hospitalCode");

		if (hospitalCode != null) {
			setHospitalCode(hospitalCode);
		}

		Date visitDate = (Date)attributes.get("visitDate");

		if (visitDate != null) {
			setVisitDate(visitDate);
		}

		Date consentDate = (Date)attributes.get("consentDate");

		if (consentDate != null) {
			setConsentDate(consentDate);
		}

		Date participationStartDate = (Date)attributes.get(
			"participationStartDate");

		if (participationStartDate != null) {
			setParticipationStartDate(participationStartDate);
		}

		Integer participationStatus = (Integer)attributes.get(
			"participationStatus");

		if (participationStatus != null) {
			setParticipationStatus(participationStatus);
		}

		String experimentalGroup = (String)attributes.get("experimentalGroup");

		if (experimentalGroup != null) {
			setExperimentalGroup(experimentalGroup);
		}

		Boolean hasCRF = (Boolean)attributes.get("hasCRF");

		if (hasCRF != null) {
			setHasCRF(hasCRF);
		}

		Boolean hasCohortStudy = (Boolean)attributes.get("hasCohortStudy");

		if (hasCohortStudy != null) {
			setHasCohortStudy(hasCohortStudy);
		}

		Boolean hasMRIStudy = (Boolean)attributes.get("hasMRIStudy");

		if (hasMRIStudy != null) {
			setHasMRIStudy(hasMRIStudy);
		}
	}

	/**
	 * Returns the birth of this patient.
	 *
	 * @return the birth of this patient
	 */
	@Override
	public Date getBirth() {
		return model.getBirth();
	}

	/**
	 * Returns the company ID of this patient.
	 *
	 * @return the company ID of this patient
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the consent date of this patient.
	 *
	 * @return the consent date of this patient
	 */
	@Override
	public Date getConsentDate() {
		return model.getConsentDate();
	}

	/**
	 * Returns the create date of this patient.
	 *
	 * @return the create date of this patient
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the experimental group of this patient.
	 *
	 * @return the experimental group of this patient
	 */
	@Override
	public String getExperimentalGroup() {
		return model.getExperimentalGroup();
	}

	/**
	 * Returns the gender of this patient.
	 *
	 * @return the gender of this patient
	 */
	@Override
	public int getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this patient.
	 *
	 * @return the group ID of this patient
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the has cohort study of this patient.
	 *
	 * @return the has cohort study of this patient
	 */
	@Override
	public Boolean getHasCohortStudy() {
		return model.getHasCohortStudy();
	}

	/**
	 * Returns the has crf of this patient.
	 *
	 * @return the has crf of this patient
	 */
	@Override
	public Boolean getHasCRF() {
		return model.getHasCRF();
	}

	/**
	 * Returns the has mri study of this patient.
	 *
	 * @return the has mri study of this patient
	 */
	@Override
	public Boolean getHasMRIStudy() {
		return model.getHasMRIStudy();
	}

	/**
	 * Returns the hospital code of this patient.
	 *
	 * @return the hospital code of this patient
	 */
	@Override
	public int getHospitalCode() {
		return model.getHospitalCode();
	}

	/**
	 * Returns the modified date of this patient.
	 *
	 * @return the modified date of this patient
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this patient.
	 *
	 * @return the mvcc version of this patient
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this patient.
	 *
	 * @return the name of this patient
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the participation start date of this patient.
	 *
	 * @return the participation start date of this patient
	 */
	@Override
	public Date getParticipationStartDate() {
		return model.getParticipationStartDate();
	}

	/**
	 * Returns the participation status of this patient.
	 *
	 * @return the participation status of this patient
	 */
	@Override
	public int getParticipationStatus() {
		return model.getParticipationStatus();
	}

	/**
	 * Returns the patient ID of this patient.
	 *
	 * @return the patient ID of this patient
	 */
	@Override
	public long getPatientId() {
		return model.getPatientId();
	}

	/**
	 * Returns the phone of this patient.
	 *
	 * @return the phone of this patient
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the phone2 of this patient.
	 *
	 * @return the phone2 of this patient
	 */
	@Override
	public String getPhone2() {
		return model.getPhone2();
	}

	/**
	 * Returns the position of this patient.
	 *
	 * @return the position of this patient
	 */
	@Override
	public String getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this patient.
	 *
	 * @return the primary key of this patient
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the serial ID of this patient.
	 *
	 * @return the serial ID of this patient
	 */
	@Override
	public String getSerialId() {
		return model.getSerialId();
	}

	/**
	 * Returns the status of this patient.
	 *
	 * @return the status of this patient
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this patient.
	 *
	 * @return the status by user ID of this patient
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this patient.
	 *
	 * @return the status by user name of this patient
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this patient.
	 *
	 * @return the status by user uuid of this patient
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this patient.
	 *
	 * @return the status date of this patient
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this patient.
	 *
	 * @return the user ID of this patient
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this patient.
	 *
	 * @return the user name of this patient
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this patient.
	 *
	 * @return the user uuid of this patient
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this patient.
	 *
	 * @return the uuid of this patient
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the visit date of this patient.
	 *
	 * @return the visit date of this patient
	 */
	@Override
	public Date getVisitDate() {
		return model.getVisitDate();
	}

	/**
	 * Returns <code>true</code> if this patient is approved.
	 *
	 * @return <code>true</code> if this patient is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this patient is denied.
	 *
	 * @return <code>true</code> if this patient is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this patient is a draft.
	 *
	 * @return <code>true</code> if this patient is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this patient is expired.
	 *
	 * @return <code>true</code> if this patient is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this patient is inactive.
	 *
	 * @return <code>true</code> if this patient is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this patient is incomplete.
	 *
	 * @return <code>true</code> if this patient is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this patient is pending.
	 *
	 * @return <code>true</code> if this patient is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this patient is scheduled.
	 *
	 * @return <code>true</code> if this patient is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the birth of this patient.
	 *
	 * @param birth the birth of this patient
	 */
	@Override
	public void setBirth(Date birth) {
		model.setBirth(birth);
	}

	/**
	 * Sets the company ID of this patient.
	 *
	 * @param companyId the company ID of this patient
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the consent date of this patient.
	 *
	 * @param consentDate the consent date of this patient
	 */
	@Override
	public void setConsentDate(Date consentDate) {
		model.setConsentDate(consentDate);
	}

	/**
	 * Sets the create date of this patient.
	 *
	 * @param createDate the create date of this patient
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the experimental group of this patient.
	 *
	 * @param experimentalGroup the experimental group of this patient
	 */
	@Override
	public void setExperimentalGroup(String experimentalGroup) {
		model.setExperimentalGroup(experimentalGroup);
	}

	/**
	 * Sets the gender of this patient.
	 *
	 * @param gender the gender of this patient
	 */
	@Override
	public void setGender(int gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this patient.
	 *
	 * @param groupId the group ID of this patient
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the has cohort study of this patient.
	 *
	 * @param hasCohortStudy the has cohort study of this patient
	 */
	@Override
	public void setHasCohortStudy(Boolean hasCohortStudy) {
		model.setHasCohortStudy(hasCohortStudy);
	}

	/**
	 * Sets the has crf of this patient.
	 *
	 * @param hasCRF the has crf of this patient
	 */
	@Override
	public void setHasCRF(Boolean hasCRF) {
		model.setHasCRF(hasCRF);
	}

	/**
	 * Sets the has mri study of this patient.
	 *
	 * @param hasMRIStudy the has mri study of this patient
	 */
	@Override
	public void setHasMRIStudy(Boolean hasMRIStudy) {
		model.setHasMRIStudy(hasMRIStudy);
	}

	/**
	 * Sets the hospital code of this patient.
	 *
	 * @param hospitalCode the hospital code of this patient
	 */
	@Override
	public void setHospitalCode(int hospitalCode) {
		model.setHospitalCode(hospitalCode);
	}

	/**
	 * Sets the modified date of this patient.
	 *
	 * @param modifiedDate the modified date of this patient
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this patient.
	 *
	 * @param mvccVersion the mvcc version of this patient
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this patient.
	 *
	 * @param name the name of this patient
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the participation start date of this patient.
	 *
	 * @param participationStartDate the participation start date of this patient
	 */
	@Override
	public void setParticipationStartDate(Date participationStartDate) {
		model.setParticipationStartDate(participationStartDate);
	}

	/**
	 * Sets the participation status of this patient.
	 *
	 * @param participationStatus the participation status of this patient
	 */
	@Override
	public void setParticipationStatus(int participationStatus) {
		model.setParticipationStatus(participationStatus);
	}

	/**
	 * Sets the patient ID of this patient.
	 *
	 * @param patientId the patient ID of this patient
	 */
	@Override
	public void setPatientId(long patientId) {
		model.setPatientId(patientId);
	}

	/**
	 * Sets the phone of this patient.
	 *
	 * @param phone the phone of this patient
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the phone2 of this patient.
	 *
	 * @param phone2 the phone2 of this patient
	 */
	@Override
	public void setPhone2(String phone2) {
		model.setPhone2(phone2);
	}

	/**
	 * Sets the position of this patient.
	 *
	 * @param position the position of this patient
	 */
	@Override
	public void setPosition(String position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this patient.
	 *
	 * @param primaryKey the primary key of this patient
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the serial ID of this patient.
	 *
	 * @param serialId the serial ID of this patient
	 */
	@Override
	public void setSerialId(String serialId) {
		model.setSerialId(serialId);
	}

	/**
	 * Sets the status of this patient.
	 *
	 * @param status the status of this patient
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this patient.
	 *
	 * @param statusByUserId the status by user ID of this patient
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this patient.
	 *
	 * @param statusByUserName the status by user name of this patient
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this patient.
	 *
	 * @param statusByUserUuid the status by user uuid of this patient
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this patient.
	 *
	 * @param statusDate the status date of this patient
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this patient.
	 *
	 * @param userId the user ID of this patient
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this patient.
	 *
	 * @param userName the user name of this patient
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this patient.
	 *
	 * @param userUuid the user uuid of this patient
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this patient.
	 *
	 * @param uuid the uuid of this patient
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the visit date of this patient.
	 *
	 * @param visitDate the visit date of this patient
	 */
	@Override
	public void setVisitDate(Date visitDate) {
		model.setVisitDate(visitDate);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PatientWrapper wrap(Patient patient) {
		return new PatientWrapper(patient);
	}

}