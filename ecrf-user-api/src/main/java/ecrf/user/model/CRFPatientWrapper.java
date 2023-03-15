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
 * This class is a wrapper for {@link CRFPatient}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFPatient
 * @generated
 */
public class CRFPatientWrapper
	extends BaseModelWrapper<CRFPatient>
	implements CRFPatient, ModelWrapper<CRFPatient> {

	public CRFPatientWrapper(CRFPatient crfPatient) {
		super(crfPatient);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("crfPatientId", getCrfPatientId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("crfId", getCrfId());
		attributes.put("patientId", getPatientId());

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

		Long crfPatientId = (Long)attributes.get("crfPatientId");

		if (crfPatientId != null) {
			setCrfPatientId(crfPatientId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long crfId = (Long)attributes.get("crfId");

		if (crfId != null) {
			setCrfId(crfId);
		}

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}
	}

	/**
	 * Returns the company ID of this crf patient.
	 *
	 * @return the company ID of this crf patient
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this crf patient.
	 *
	 * @return the create date of this crf patient
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the crf ID of this crf patient.
	 *
	 * @return the crf ID of this crf patient
	 */
	@Override
	public long getCrfId() {
		return model.getCrfId();
	}

	/**
	 * Returns the crf patient ID of this crf patient.
	 *
	 * @return the crf patient ID of this crf patient
	 */
	@Override
	public long getCrfPatientId() {
		return model.getCrfPatientId();
	}

	/**
	 * Returns the group ID of this crf patient.
	 *
	 * @return the group ID of this crf patient
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this crf patient.
	 *
	 * @return the modified date of this crf patient
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this crf patient.
	 *
	 * @return the mvcc version of this crf patient
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the patient ID of this crf patient.
	 *
	 * @return the patient ID of this crf patient
	 */
	@Override
	public long getPatientId() {
		return model.getPatientId();
	}

	/**
	 * Returns the primary key of this crf patient.
	 *
	 * @return the primary key of this crf patient
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this crf patient.
	 *
	 * @return the user ID of this crf patient
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this crf patient.
	 *
	 * @return the user name of this crf patient
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this crf patient.
	 *
	 * @return the user uuid of this crf patient
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this crf patient.
	 *
	 * @return the uuid of this crf patient
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this crf patient.
	 *
	 * @param companyId the company ID of this crf patient
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this crf patient.
	 *
	 * @param createDate the create date of this crf patient
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the crf ID of this crf patient.
	 *
	 * @param crfId the crf ID of this crf patient
	 */
	@Override
	public void setCrfId(long crfId) {
		model.setCrfId(crfId);
	}

	/**
	 * Sets the crf patient ID of this crf patient.
	 *
	 * @param crfPatientId the crf patient ID of this crf patient
	 */
	@Override
	public void setCrfPatientId(long crfPatientId) {
		model.setCrfPatientId(crfPatientId);
	}

	/**
	 * Sets the group ID of this crf patient.
	 *
	 * @param groupId the group ID of this crf patient
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this crf patient.
	 *
	 * @param modifiedDate the modified date of this crf patient
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this crf patient.
	 *
	 * @param mvccVersion the mvcc version of this crf patient
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the patient ID of this crf patient.
	 *
	 * @param patientId the patient ID of this crf patient
	 */
	@Override
	public void setPatientId(long patientId) {
		model.setPatientId(patientId);
	}

	/**
	 * Sets the primary key of this crf patient.
	 *
	 * @param primaryKey the primary key of this crf patient
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this crf patient.
	 *
	 * @param userId the user ID of this crf patient
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this crf patient.
	 *
	 * @param userName the user name of this crf patient
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this crf patient.
	 *
	 * @param userUuid the user uuid of this crf patient
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this crf patient.
	 *
	 * @param uuid the uuid of this crf patient
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
	protected CRFPatientWrapper wrap(CRFPatient crfPatient) {
		return new CRFPatientWrapper(crfPatient);
	}

}