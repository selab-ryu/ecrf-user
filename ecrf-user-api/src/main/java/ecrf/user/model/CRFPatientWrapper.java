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
 * @author Brian Wing Shun Chan
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

		attributes.put("uuid", getUuid());
		attributes.put("crfPatientId", getCrfPatientId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createUserName", getCreateUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("crfId", getCrfId());
		attributes.put("patientId", getPatientId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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
	 * Returns the create user ID of this crf patient.
	 *
	 * @return the create user ID of this crf patient
	 */
	@Override
	public long getCreateUserId() {
		return model.getCreateUserId();
	}

	/**
	 * Returns the create user name of this crf patient.
	 *
	 * @return the create user name of this crf patient
	 */
	@Override
	public String getCreateUserName() {
		return model.getCreateUserName();
	}

	/**
	 * Returns the create user uuid of this crf patient.
	 *
	 * @return the create user uuid of this crf patient
	 */
	@Override
	public String getCreateUserUuid() {
		return model.getCreateUserUuid();
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
	 * Sets the create user ID of this crf patient.
	 *
	 * @param createUserId the create user ID of this crf patient
	 */
	@Override
	public void setCreateUserId(long createUserId) {
		model.setCreateUserId(createUserId);
	}

	/**
	 * Sets the create user name of this crf patient.
	 *
	 * @param createUserName the create user name of this crf patient
	 */
	@Override
	public void setCreateUserName(String createUserName) {
		model.setCreateUserName(createUserName);
	}

	/**
	 * Sets the create user uuid of this crf patient.
	 *
	 * @param createUserUuid the create user uuid of this crf patient
	 */
	@Override
	public void setCreateUserUuid(String createUserUuid) {
		model.setCreateUserUuid(createUserUuid);
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