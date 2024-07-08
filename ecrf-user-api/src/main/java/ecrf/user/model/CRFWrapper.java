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
 * This class is a wrapper for {@link CRF}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRF
 * @generated
 */
public class CRFWrapper
	extends BaseModelWrapper<CRF> implements CRF, ModelWrapper<CRF> {

	public CRFWrapper(CRF crf) {
		super(crf);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("crfId", getCrfId());
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
		attributes.put("datatypeId", getDatatypeId());
		attributes.put("crfStatus", getCrfStatus());
		attributes.put("applyDate", getApplyDate());
		attributes.put("defaultUILayout", getDefaultUILayout());

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

		Long crfId = (Long)attributes.get("crfId");

		if (crfId != null) {
			setCrfId(crfId);
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

		Long datatypeId = (Long)attributes.get("datatypeId");

		if (datatypeId != null) {
			setDatatypeId(datatypeId);
		}

		Integer crfStatus = (Integer)attributes.get("crfStatus");

		if (crfStatus != null) {
			setCrfStatus(crfStatus);
		}

		Date applyDate = (Date)attributes.get("applyDate");

		if (applyDate != null) {
			setApplyDate(applyDate);
		}

		Integer defaultUILayout = (Integer)attributes.get("defaultUILayout");

		if (defaultUILayout != null) {
			setDefaultUILayout(defaultUILayout);
		}
	}

	/**
	 * Returns the apply date of this crf.
	 *
	 * @return the apply date of this crf
	 */
	@Override
	public Date getApplyDate() {
		return model.getApplyDate();
	}

	/**
	 * Returns the company ID of this crf.
	 *
	 * @return the company ID of this crf
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this crf.
	 *
	 * @return the create date of this crf
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the crf ID of this crf.
	 *
	 * @return the crf ID of this crf
	 */
	@Override
	public long getCrfId() {
		return model.getCrfId();
	}

	/**
	 * Returns the crf status of this crf.
	 *
	 * @return the crf status of this crf
	 */
	@Override
	public int getCrfStatus() {
		return model.getCrfStatus();
	}

	/**
	 * Returns the datatype ID of this crf.
	 *
	 * @return the datatype ID of this crf
	 */
	@Override
	public long getDatatypeId() {
		return model.getDatatypeId();
	}

	/**
	 * Returns the default ui layout of this crf.
	 *
	 * @return the default ui layout of this crf
	 */
	@Override
	public int getDefaultUILayout() {
		return model.getDefaultUILayout();
	}

	/**
	 * Returns the group ID of this crf.
	 *
	 * @return the group ID of this crf
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this crf.
	 *
	 * @return the modified date of this crf
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this crf.
	 *
	 * @return the mvcc version of this crf
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this crf.
	 *
	 * @return the primary key of this crf
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this crf.
	 *
	 * @return the status of this crf
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this crf.
	 *
	 * @return the status by user ID of this crf
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this crf.
	 *
	 * @return the status by user name of this crf
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this crf.
	 *
	 * @return the status by user uuid of this crf
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this crf.
	 *
	 * @return the status date of this crf
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this crf.
	 *
	 * @return the user ID of this crf
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this crf.
	 *
	 * @return the user name of this crf
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this crf.
	 *
	 * @return the user uuid of this crf
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this crf.
	 *
	 * @return the uuid of this crf
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this crf is approved.
	 *
	 * @return <code>true</code> if this crf is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this crf is denied.
	 *
	 * @return <code>true</code> if this crf is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this crf is a draft.
	 *
	 * @return <code>true</code> if this crf is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this crf is expired.
	 *
	 * @return <code>true</code> if this crf is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this crf is inactive.
	 *
	 * @return <code>true</code> if this crf is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this crf is incomplete.
	 *
	 * @return <code>true</code> if this crf is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this crf is pending.
	 *
	 * @return <code>true</code> if this crf is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this crf is scheduled.
	 *
	 * @return <code>true</code> if this crf is scheduled; <code>false</code> otherwise
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
	 * Sets the apply date of this crf.
	 *
	 * @param applyDate the apply date of this crf
	 */
	@Override
	public void setApplyDate(Date applyDate) {
		model.setApplyDate(applyDate);
	}

	/**
	 * Sets the company ID of this crf.
	 *
	 * @param companyId the company ID of this crf
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this crf.
	 *
	 * @param createDate the create date of this crf
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the crf ID of this crf.
	 *
	 * @param crfId the crf ID of this crf
	 */
	@Override
	public void setCrfId(long crfId) {
		model.setCrfId(crfId);
	}

	/**
	 * Sets the crf status of this crf.
	 *
	 * @param crfStatus the crf status of this crf
	 */
	@Override
	public void setCrfStatus(int crfStatus) {
		model.setCrfStatus(crfStatus);
	}

	/**
	 * Sets the datatype ID of this crf.
	 *
	 * @param datatypeId the datatype ID of this crf
	 */
	@Override
	public void setDatatypeId(long datatypeId) {
		model.setDatatypeId(datatypeId);
	}

	/**
	 * Sets the default ui layout of this crf.
	 *
	 * @param defaultUILayout the default ui layout of this crf
	 */
	@Override
	public void setDefaultUILayout(int defaultUILayout) {
		model.setDefaultUILayout(defaultUILayout);
	}

	/**
	 * Sets the group ID of this crf.
	 *
	 * @param groupId the group ID of this crf
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this crf.
	 *
	 * @param modifiedDate the modified date of this crf
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this crf.
	 *
	 * @param mvccVersion the mvcc version of this crf
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this crf.
	 *
	 * @param primaryKey the primary key of this crf
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this crf.
	 *
	 * @param status the status of this crf
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this crf.
	 *
	 * @param statusByUserId the status by user ID of this crf
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this crf.
	 *
	 * @param statusByUserName the status by user name of this crf
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this crf.
	 *
	 * @param statusByUserUuid the status by user uuid of this crf
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this crf.
	 *
	 * @param statusDate the status date of this crf
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this crf.
	 *
	 * @param userId the user ID of this crf
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this crf.
	 *
	 * @param userName the user name of this crf
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this crf.
	 *
	 * @param userUuid the user uuid of this crf
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this crf.
	 *
	 * @param uuid the uuid of this crf
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
	protected CRFWrapper wrap(CRF crf) {
		return new CRFWrapper(crf);
	}

}