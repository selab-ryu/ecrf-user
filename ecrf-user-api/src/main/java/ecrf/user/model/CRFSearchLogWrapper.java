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
 * This class is a wrapper for {@link CRFSearchLog}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFSearchLog
 * @generated
 */
public class CRFSearchLogWrapper
	extends BaseModelWrapper<CRFSearchLog>
	implements CRFSearchLog, ModelWrapper<CRFSearchLog> {

	public CRFSearchLogWrapper(CRFSearchLog crfSearchLog) {
		super(crfSearchLog);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("searchLogId", getSearchLogId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("searchLog", getSearchLog());

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

		Long searchLogId = (Long)attributes.get("searchLogId");

		if (searchLogId != null) {
			setSearchLogId(searchLogId);
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

		String searchLog = (String)attributes.get("searchLog");

		if (searchLog != null) {
			setSearchLog(searchLog);
		}
	}

	/**
	 * Returns the company ID of this crf search log.
	 *
	 * @return the company ID of this crf search log
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this crf search log.
	 *
	 * @return the create date of this crf search log
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this crf search log.
	 *
	 * @return the group ID of this crf search log
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this crf search log.
	 *
	 * @return the modified date of this crf search log
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this crf search log.
	 *
	 * @return the mvcc version of this crf search log
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this crf search log.
	 *
	 * @return the primary key of this crf search log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the search log of this crf search log.
	 *
	 * @return the search log of this crf search log
	 */
	@Override
	public String getSearchLog() {
		return model.getSearchLog();
	}

	/**
	 * Returns the search log ID of this crf search log.
	 *
	 * @return the search log ID of this crf search log
	 */
	@Override
	public long getSearchLogId() {
		return model.getSearchLogId();
	}

	/**
	 * Returns the user ID of this crf search log.
	 *
	 * @return the user ID of this crf search log
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this crf search log.
	 *
	 * @return the user name of this crf search log
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this crf search log.
	 *
	 * @return the user uuid of this crf search log
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this crf search log.
	 *
	 * @return the uuid of this crf search log
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
	 * Sets the company ID of this crf search log.
	 *
	 * @param companyId the company ID of this crf search log
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this crf search log.
	 *
	 * @param createDate the create date of this crf search log
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this crf search log.
	 *
	 * @param groupId the group ID of this crf search log
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this crf search log.
	 *
	 * @param modifiedDate the modified date of this crf search log
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this crf search log.
	 *
	 * @param mvccVersion the mvcc version of this crf search log
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this crf search log.
	 *
	 * @param primaryKey the primary key of this crf search log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the search log of this crf search log.
	 *
	 * @param searchLog the search log of this crf search log
	 */
	@Override
	public void setSearchLog(String searchLog) {
		model.setSearchLog(searchLog);
	}

	/**
	 * Sets the search log ID of this crf search log.
	 *
	 * @param searchLogId the search log ID of this crf search log
	 */
	@Override
	public void setSearchLogId(long searchLogId) {
		model.setSearchLogId(searchLogId);
	}

	/**
	 * Sets the user ID of this crf search log.
	 *
	 * @param userId the user ID of this crf search log
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this crf search log.
	 *
	 * @param userName the user name of this crf search log
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this crf search log.
	 *
	 * @param userUuid the user uuid of this crf search log
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this crf search log.
	 *
	 * @param uuid the uuid of this crf search log
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
	protected CRFSearchLogWrapper wrap(CRFSearchLog crfSearchLog) {
		return new CRFSearchLogWrapper(crfSearchLog);
	}

}