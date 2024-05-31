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
 * This class is a wrapper for {@link CRFSubject}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFSubject
 * @generated
 */
public class CRFSubjectWrapper
	extends BaseModelWrapper<CRFSubject>
	implements CRFSubject, ModelWrapper<CRFSubject> {

	public CRFSubjectWrapper(CRFSubject crfSubject) {
		super(crfSubject);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("crfSubjectId", getCrfSubjectId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("crfId", getCrfId());
		attributes.put("subjectId", getSubjectId());
		attributes.put("participationStatus", getParticipationStatus());
		attributes.put("participationStartDate", getParticipationStartDate());
		attributes.put("updateLock", isUpdateLock());

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

		Long crfSubjectId = (Long)attributes.get("crfSubjectId");

		if (crfSubjectId != null) {
			setCrfSubjectId(crfSubjectId);
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

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		Integer participationStatus = (Integer)attributes.get(
			"participationStatus");

		if (participationStatus != null) {
			setParticipationStatus(participationStatus);
		}

		Date participationStartDate = (Date)attributes.get(
			"participationStartDate");

		if (participationStartDate != null) {
			setParticipationStartDate(participationStartDate);
		}

		Boolean updateLock = (Boolean)attributes.get("updateLock");

		if (updateLock != null) {
			setUpdateLock(updateLock);
		}
	}

	/**
	 * Returns the company ID of this crf subject.
	 *
	 * @return the company ID of this crf subject
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this crf subject.
	 *
	 * @return the create date of this crf subject
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the crf ID of this crf subject.
	 *
	 * @return the crf ID of this crf subject
	 */
	@Override
	public long getCrfId() {
		return model.getCrfId();
	}

	/**
	 * Returns the crf subject ID of this crf subject.
	 *
	 * @return the crf subject ID of this crf subject
	 */
	@Override
	public long getCrfSubjectId() {
		return model.getCrfSubjectId();
	}

	/**
	 * Returns the group ID of this crf subject.
	 *
	 * @return the group ID of this crf subject
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this crf subject.
	 *
	 * @return the modified date of this crf subject
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this crf subject.
	 *
	 * @return the mvcc version of this crf subject
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the participation start date of this crf subject.
	 *
	 * @return the participation start date of this crf subject
	 */
	@Override
	public Date getParticipationStartDate() {
		return model.getParticipationStartDate();
	}

	/**
	 * Returns the participation status of this crf subject.
	 *
	 * @return the participation status of this crf subject
	 */
	@Override
	public int getParticipationStatus() {
		return model.getParticipationStatus();
	}

	/**
	 * Returns the primary key of this crf subject.
	 *
	 * @return the primary key of this crf subject
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the subject ID of this crf subject.
	 *
	 * @return the subject ID of this crf subject
	 */
	@Override
	public long getSubjectId() {
		return model.getSubjectId();
	}

	/**
	 * Returns the update lock of this crf subject.
	 *
	 * @return the update lock of this crf subject
	 */
	@Override
	public boolean getUpdateLock() {
		return model.getUpdateLock();
	}

	/**
	 * Returns the user ID of this crf subject.
	 *
	 * @return the user ID of this crf subject
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this crf subject.
	 *
	 * @return the user name of this crf subject
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this crf subject.
	 *
	 * @return the user uuid of this crf subject
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this crf subject.
	 *
	 * @return the uuid of this crf subject
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this crf subject is update lock.
	 *
	 * @return <code>true</code> if this crf subject is update lock; <code>false</code> otherwise
	 */
	@Override
	public boolean isUpdateLock() {
		return model.isUpdateLock();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this crf subject.
	 *
	 * @param companyId the company ID of this crf subject
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this crf subject.
	 *
	 * @param createDate the create date of this crf subject
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the crf ID of this crf subject.
	 *
	 * @param crfId the crf ID of this crf subject
	 */
	@Override
	public void setCrfId(long crfId) {
		model.setCrfId(crfId);
	}

	/**
	 * Sets the crf subject ID of this crf subject.
	 *
	 * @param crfSubjectId the crf subject ID of this crf subject
	 */
	@Override
	public void setCrfSubjectId(long crfSubjectId) {
		model.setCrfSubjectId(crfSubjectId);
	}

	/**
	 * Sets the group ID of this crf subject.
	 *
	 * @param groupId the group ID of this crf subject
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this crf subject.
	 *
	 * @param modifiedDate the modified date of this crf subject
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this crf subject.
	 *
	 * @param mvccVersion the mvcc version of this crf subject
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the participation start date of this crf subject.
	 *
	 * @param participationStartDate the participation start date of this crf subject
	 */
	@Override
	public void setParticipationStartDate(Date participationStartDate) {
		model.setParticipationStartDate(participationStartDate);
	}

	/**
	 * Sets the participation status of this crf subject.
	 *
	 * @param participationStatus the participation status of this crf subject
	 */
	@Override
	public void setParticipationStatus(int participationStatus) {
		model.setParticipationStatus(participationStatus);
	}

	/**
	 * Sets the primary key of this crf subject.
	 *
	 * @param primaryKey the primary key of this crf subject
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the subject ID of this crf subject.
	 *
	 * @param subjectId the subject ID of this crf subject
	 */
	@Override
	public void setSubjectId(long subjectId) {
		model.setSubjectId(subjectId);
	}

	/**
	 * Sets whether this crf subject is update lock.
	 *
	 * @param updateLock the update lock of this crf subject
	 */
	@Override
	public void setUpdateLock(boolean updateLock) {
		model.setUpdateLock(updateLock);
	}

	/**
	 * Sets the user ID of this crf subject.
	 *
	 * @param userId the user ID of this crf subject
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this crf subject.
	 *
	 * @param userName the user name of this crf subject
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this crf subject.
	 *
	 * @param userUuid the user uuid of this crf subject
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this crf subject.
	 *
	 * @param uuid the uuid of this crf subject
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
	protected CRFSubjectWrapper wrap(CRFSubject crfSubject) {
		return new CRFSubjectWrapper(crfSubject);
	}

}