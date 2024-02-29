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
 * This class is a wrapper for {@link CRFHistory}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFHistory
 * @generated
 */
public class CRFHistoryWrapper
	extends BaseModelWrapper<CRFHistory>
	implements CRFHistory, ModelWrapper<CRFHistory> {

	public CRFHistoryWrapper(CRFHistory crfHistory) {
		super(crfHistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("historyId", getHistoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("subjectId", getSubjectId());
		attributes.put("subjectName", getSubjectName());
		attributes.put("serialId", getSerialId());
		attributes.put("crfId", getCrfId());
		attributes.put("structuredDataId", getStructuredDataId());
		attributes.put("actionType", getActionType());
		attributes.put("previousJSON", getPreviousJSON());
		attributes.put("currentJSON", getCurrentJSON());
		attributes.put("historyVersion", getHistoryVersion());
		attributes.put("previousHistoryVersion", getPreviousHistoryVersion());

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

		Long historyId = (Long)attributes.get("historyId");

		if (historyId != null) {
			setHistoryId(historyId);
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

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
		}

		String serialId = (String)attributes.get("serialId");

		if (serialId != null) {
			setSerialId(serialId);
		}

		Long crfId = (Long)attributes.get("crfId");

		if (crfId != null) {
			setCrfId(crfId);
		}

		Long structuredDataId = (Long)attributes.get("structuredDataId");

		if (structuredDataId != null) {
			setStructuredDataId(structuredDataId);
		}

		Integer actionType = (Integer)attributes.get("actionType");

		if (actionType != null) {
			setActionType(actionType);
		}

		String previousJSON = (String)attributes.get("previousJSON");

		if (previousJSON != null) {
			setPreviousJSON(previousJSON);
		}

		String currentJSON = (String)attributes.get("currentJSON");

		if (currentJSON != null) {
			setCurrentJSON(currentJSON);
		}

		String historyVersion = (String)attributes.get("historyVersion");

		if (historyVersion != null) {
			setHistoryVersion(historyVersion);
		}

		String previousHistoryVersion = (String)attributes.get(
			"previousHistoryVersion");

		if (previousHistoryVersion != null) {
			setPreviousHistoryVersion(previousHistoryVersion);
		}
	}

	/**
	 * Returns the action type of this crf history.
	 *
	 * @return the action type of this crf history
	 */
	@Override
	public int getActionType() {
		return model.getActionType();
	}

	/**
	 * Returns the company ID of this crf history.
	 *
	 * @return the company ID of this crf history
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this crf history.
	 *
	 * @return the create date of this crf history
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the crf ID of this crf history.
	 *
	 * @return the crf ID of this crf history
	 */
	@Override
	public long getCrfId() {
		return model.getCrfId();
	}

	/**
	 * Returns the current json of this crf history.
	 *
	 * @return the current json of this crf history
	 */
	@Override
	public String getCurrentJSON() {
		return model.getCurrentJSON();
	}

	/**
	 * Returns the group ID of this crf history.
	 *
	 * @return the group ID of this crf history
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the history ID of this crf history.
	 *
	 * @return the history ID of this crf history
	 */
	@Override
	public long getHistoryId() {
		return model.getHistoryId();
	}

	/**
	 * Returns the history version of this crf history.
	 *
	 * @return the history version of this crf history
	 */
	@Override
	public String getHistoryVersion() {
		return model.getHistoryVersion();
	}

	/**
	 * Returns the modified date of this crf history.
	 *
	 * @return the modified date of this crf history
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this crf history.
	 *
	 * @return the mvcc version of this crf history
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the previous history version of this crf history.
	 *
	 * @return the previous history version of this crf history
	 */
	@Override
	public String getPreviousHistoryVersion() {
		return model.getPreviousHistoryVersion();
	}

	/**
	 * Returns the previous json of this crf history.
	 *
	 * @return the previous json of this crf history
	 */
	@Override
	public String getPreviousJSON() {
		return model.getPreviousJSON();
	}

	/**
	 * Returns the primary key of this crf history.
	 *
	 * @return the primary key of this crf history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the serial ID of this crf history.
	 *
	 * @return the serial ID of this crf history
	 */
	@Override
	public String getSerialId() {
		return model.getSerialId();
	}

	/**
	 * Returns the status of this crf history.
	 *
	 * @return the status of this crf history
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this crf history.
	 *
	 * @return the status by user ID of this crf history
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this crf history.
	 *
	 * @return the status by user name of this crf history
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this crf history.
	 *
	 * @return the status by user uuid of this crf history
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this crf history.
	 *
	 * @return the status date of this crf history
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the structured data ID of this crf history.
	 *
	 * @return the structured data ID of this crf history
	 */
	@Override
	public long getStructuredDataId() {
		return model.getStructuredDataId();
	}

	/**
	 * Returns the subject ID of this crf history.
	 *
	 * @return the subject ID of this crf history
	 */
	@Override
	public long getSubjectId() {
		return model.getSubjectId();
	}

	/**
	 * Returns the subject name of this crf history.
	 *
	 * @return the subject name of this crf history
	 */
	@Override
	public String getSubjectName() {
		return model.getSubjectName();
	}

	/**
	 * Returns the user ID of this crf history.
	 *
	 * @return the user ID of this crf history
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this crf history.
	 *
	 * @return the user name of this crf history
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this crf history.
	 *
	 * @return the user uuid of this crf history
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this crf history.
	 *
	 * @return the uuid of this crf history
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this crf history is approved.
	 *
	 * @return <code>true</code> if this crf history is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this crf history is denied.
	 *
	 * @return <code>true</code> if this crf history is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this crf history is a draft.
	 *
	 * @return <code>true</code> if this crf history is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this crf history is expired.
	 *
	 * @return <code>true</code> if this crf history is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this crf history is inactive.
	 *
	 * @return <code>true</code> if this crf history is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this crf history is incomplete.
	 *
	 * @return <code>true</code> if this crf history is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this crf history is pending.
	 *
	 * @return <code>true</code> if this crf history is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this crf history is scheduled.
	 *
	 * @return <code>true</code> if this crf history is scheduled; <code>false</code> otherwise
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
	 * Sets the action type of this crf history.
	 *
	 * @param actionType the action type of this crf history
	 */
	@Override
	public void setActionType(int actionType) {
		model.setActionType(actionType);
	}

	/**
	 * Sets the company ID of this crf history.
	 *
	 * @param companyId the company ID of this crf history
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this crf history.
	 *
	 * @param createDate the create date of this crf history
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the crf ID of this crf history.
	 *
	 * @param crfId the crf ID of this crf history
	 */
	@Override
	public void setCrfId(long crfId) {
		model.setCrfId(crfId);
	}

	/**
	 * Sets the current json of this crf history.
	 *
	 * @param currentJSON the current json of this crf history
	 */
	@Override
	public void setCurrentJSON(String currentJSON) {
		model.setCurrentJSON(currentJSON);
	}

	/**
	 * Sets the group ID of this crf history.
	 *
	 * @param groupId the group ID of this crf history
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the history ID of this crf history.
	 *
	 * @param historyId the history ID of this crf history
	 */
	@Override
	public void setHistoryId(long historyId) {
		model.setHistoryId(historyId);
	}

	/**
	 * Sets the history version of this crf history.
	 *
	 * @param historyVersion the history version of this crf history
	 */
	@Override
	public void setHistoryVersion(String historyVersion) {
		model.setHistoryVersion(historyVersion);
	}

	/**
	 * Sets the modified date of this crf history.
	 *
	 * @param modifiedDate the modified date of this crf history
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this crf history.
	 *
	 * @param mvccVersion the mvcc version of this crf history
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the previous history version of this crf history.
	 *
	 * @param previousHistoryVersion the previous history version of this crf history
	 */
	@Override
	public void setPreviousHistoryVersion(String previousHistoryVersion) {
		model.setPreviousHistoryVersion(previousHistoryVersion);
	}

	/**
	 * Sets the previous json of this crf history.
	 *
	 * @param previousJSON the previous json of this crf history
	 */
	@Override
	public void setPreviousJSON(String previousJSON) {
		model.setPreviousJSON(previousJSON);
	}

	/**
	 * Sets the primary key of this crf history.
	 *
	 * @param primaryKey the primary key of this crf history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the serial ID of this crf history.
	 *
	 * @param serialId the serial ID of this crf history
	 */
	@Override
	public void setSerialId(String serialId) {
		model.setSerialId(serialId);
	}

	/**
	 * Sets the status of this crf history.
	 *
	 * @param status the status of this crf history
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this crf history.
	 *
	 * @param statusByUserId the status by user ID of this crf history
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this crf history.
	 *
	 * @param statusByUserName the status by user name of this crf history
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this crf history.
	 *
	 * @param statusByUserUuid the status by user uuid of this crf history
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this crf history.
	 *
	 * @param statusDate the status date of this crf history
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the structured data ID of this crf history.
	 *
	 * @param structuredDataId the structured data ID of this crf history
	 */
	@Override
	public void setStructuredDataId(long structuredDataId) {
		model.setStructuredDataId(structuredDataId);
	}

	/**
	 * Sets the subject ID of this crf history.
	 *
	 * @param subjectId the subject ID of this crf history
	 */
	@Override
	public void setSubjectId(long subjectId) {
		model.setSubjectId(subjectId);
	}

	/**
	 * Sets the subject name of this crf history.
	 *
	 * @param subjectName the subject name of this crf history
	 */
	@Override
	public void setSubjectName(String subjectName) {
		model.setSubjectName(subjectName);
	}

	/**
	 * Sets the user ID of this crf history.
	 *
	 * @param userId the user ID of this crf history
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this crf history.
	 *
	 * @param userName the user name of this crf history
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this crf history.
	 *
	 * @param userUuid the user uuid of this crf history
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this crf history.
	 *
	 * @param uuid the uuid of this crf history
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
	protected CRFHistoryWrapper wrap(CRFHistory crfHistory) {
		return new CRFHistoryWrapper(crfHistory);
	}

}