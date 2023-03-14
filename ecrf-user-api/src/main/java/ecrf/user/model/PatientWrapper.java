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
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createUserName", getCreateUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("birth", getBirth());
		attributes.put("phone", getPhone());
		attributes.put("position", getPosition());
		attributes.put("gender", getGender());
		attributes.put("consentDate", getConsentDate());
		attributes.put("participationStartDate", getParticipationStartDate());
		attributes.put("participationStatus", getParticipationStatus());
		attributes.put("experimentalGroup", getExperimentalGroup());
		attributes.put("patientUserId", getPatientUserId());

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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		String createUserName = (String)attributes.get("createUserName");

		if (createUserName != null) {
			setCreateUserName(createUserName);
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

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
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

		Long patientUserId = (Long)attributes.get("patientUserId");

		if (patientUserId != null) {
			setPatientUserId(patientUserId);
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
	 * Returns the create user ID of this patient.
	 *
	 * @return the create user ID of this patient
	 */
	@Override
	public long getCreateUserId() {
		return model.getCreateUserId();
	}

	/**
	 * Returns the create user name of this patient.
	 *
	 * @return the create user name of this patient
	 */
	@Override
	public String getCreateUserName() {
		return model.getCreateUserName();
	}

	/**
	 * Returns the create user uuid of this patient.
	 *
	 * @return the create user uuid of this patient
	 */
	@Override
	public String getCreateUserUuid() {
		return model.getCreateUserUuid();
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
	 * Returns the patient user ID of this patient.
	 *
	 * @return the patient user ID of this patient
	 */
	@Override
	public long getPatientUserId() {
		return model.getPatientUserId();
	}

	/**
	 * Returns the patient user uuid of this patient.
	 *
	 * @return the patient user uuid of this patient
	 */
	@Override
	public String getPatientUserUuid() {
		return model.getPatientUserUuid();
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
	 * Returns the uuid of this patient.
	 *
	 * @return the uuid of this patient
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
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
	 * Sets the create user ID of this patient.
	 *
	 * @param createUserId the create user ID of this patient
	 */
	@Override
	public void setCreateUserId(long createUserId) {
		model.setCreateUserId(createUserId);
	}

	/**
	 * Sets the create user name of this patient.
	 *
	 * @param createUserName the create user name of this patient
	 */
	@Override
	public void setCreateUserName(String createUserName) {
		model.setCreateUserName(createUserName);
	}

	/**
	 * Sets the create user uuid of this patient.
	 *
	 * @param createUserUuid the create user uuid of this patient
	 */
	@Override
	public void setCreateUserUuid(String createUserUuid) {
		model.setCreateUserUuid(createUserUuid);
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
	 * Sets the patient user ID of this patient.
	 *
	 * @param patientUserId the patient user ID of this patient
	 */
	@Override
	public void setPatientUserId(long patientUserId) {
		model.setPatientUserId(patientUserId);
	}

	/**
	 * Sets the patient user uuid of this patient.
	 *
	 * @param patientUserUuid the patient user uuid of this patient
	 */
	@Override
	public void setPatientUserUuid(String patientUserUuid) {
		model.setPatientUserUuid(patientUserUuid);
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
	 * Sets the uuid of this patient.
	 *
	 * @param uuid the uuid of this patient
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
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