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
 * This class is a wrapper for {@link CRFAutoquery}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFAutoquery
 * @generated
 */
public class CRFAutoqueryWrapper
	extends BaseModelWrapper<CRFAutoquery>
	implements CRFAutoquery, ModelWrapper<CRFAutoquery> {

	public CRFAutoqueryWrapper(CRFAutoquery crfAutoquery) {
		super(crfAutoquery);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("autoQueryId", getAutoQueryId());
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
		attributes.put("crfId", getCrfId());
		attributes.put("queryTermId", getQueryTermId());
		attributes.put("queryTermName", getQueryTermName());
		attributes.put("queryValue", getQueryValue());
		attributes.put("queryPreviousValue", getQueryPreviousValue());
		attributes.put("queryType", getQueryType());
		attributes.put("queryComment", getQueryComment());
		attributes.put("queryComfirm", getQueryComfirm());
		attributes.put("queryComfirmUserId", getQueryComfirmUserId());
		attributes.put("queryComfirmUserName", getQueryComfirmUserName());
		attributes.put("queryComfirmDate", getQueryComfirmDate());

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

		Long autoQueryId = (Long)attributes.get("autoQueryId");

		if (autoQueryId != null) {
			setAutoQueryId(autoQueryId);
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

		Long crfId = (Long)attributes.get("crfId");

		if (crfId != null) {
			setCrfId(crfId);
		}

		Long queryTermId = (Long)attributes.get("queryTermId");

		if (queryTermId != null) {
			setQueryTermId(queryTermId);
		}

		String queryTermName = (String)attributes.get("queryTermName");

		if (queryTermName != null) {
			setQueryTermName(queryTermName);
		}

		String queryValue = (String)attributes.get("queryValue");

		if (queryValue != null) {
			setQueryValue(queryValue);
		}

		String queryPreviousValue = (String)attributes.get(
			"queryPreviousValue");

		if (queryPreviousValue != null) {
			setQueryPreviousValue(queryPreviousValue);
		}

		Integer queryType = (Integer)attributes.get("queryType");

		if (queryType != null) {
			setQueryType(queryType);
		}

		String queryComment = (String)attributes.get("queryComment");

		if (queryComment != null) {
			setQueryComment(queryComment);
		}

		Integer queryComfirm = (Integer)attributes.get("queryComfirm");

		if (queryComfirm != null) {
			setQueryComfirm(queryComfirm);
		}

		Long queryComfirmUserId = (Long)attributes.get("queryComfirmUserId");

		if (queryComfirmUserId != null) {
			setQueryComfirmUserId(queryComfirmUserId);
		}

		String queryComfirmUserName = (String)attributes.get(
			"queryComfirmUserName");

		if (queryComfirmUserName != null) {
			setQueryComfirmUserName(queryComfirmUserName);
		}

		Date queryComfirmDate = (Date)attributes.get("queryComfirmDate");

		if (queryComfirmDate != null) {
			setQueryComfirmDate(queryComfirmDate);
		}
	}

	/**
	 * Returns the auto query ID of this crf autoquery.
	 *
	 * @return the auto query ID of this crf autoquery
	 */
	@Override
	public long getAutoQueryId() {
		return model.getAutoQueryId();
	}

	/**
	 * Returns the company ID of this crf autoquery.
	 *
	 * @return the company ID of this crf autoquery
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this crf autoquery.
	 *
	 * @return the create date of this crf autoquery
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the crf ID of this crf autoquery.
	 *
	 * @return the crf ID of this crf autoquery
	 */
	@Override
	public long getCrfId() {
		return model.getCrfId();
	}

	/**
	 * Returns the group ID of this crf autoquery.
	 *
	 * @return the group ID of this crf autoquery
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this crf autoquery.
	 *
	 * @return the modified date of this crf autoquery
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this crf autoquery.
	 *
	 * @return the mvcc version of this crf autoquery
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this crf autoquery.
	 *
	 * @return the primary key of this crf autoquery
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the query comfirm of this crf autoquery.
	 *
	 * @return the query comfirm of this crf autoquery
	 */
	@Override
	public int getQueryComfirm() {
		return model.getQueryComfirm();
	}

	/**
	 * Returns the query comfirm date of this crf autoquery.
	 *
	 * @return the query comfirm date of this crf autoquery
	 */
	@Override
	public Date getQueryComfirmDate() {
		return model.getQueryComfirmDate();
	}

	/**
	 * Returns the query comfirm user ID of this crf autoquery.
	 *
	 * @return the query comfirm user ID of this crf autoquery
	 */
	@Override
	public long getQueryComfirmUserId() {
		return model.getQueryComfirmUserId();
	}

	/**
	 * Returns the query comfirm user name of this crf autoquery.
	 *
	 * @return the query comfirm user name of this crf autoquery
	 */
	@Override
	public String getQueryComfirmUserName() {
		return model.getQueryComfirmUserName();
	}

	/**
	 * Returns the query comfirm user uuid of this crf autoquery.
	 *
	 * @return the query comfirm user uuid of this crf autoquery
	 */
	@Override
	public String getQueryComfirmUserUuid() {
		return model.getQueryComfirmUserUuid();
	}

	/**
	 * Returns the query comment of this crf autoquery.
	 *
	 * @return the query comment of this crf autoquery
	 */
	@Override
	public String getQueryComment() {
		return model.getQueryComment();
	}

	/**
	 * Returns the query previous value of this crf autoquery.
	 *
	 * @return the query previous value of this crf autoquery
	 */
	@Override
	public String getQueryPreviousValue() {
		return model.getQueryPreviousValue();
	}

	/**
	 * Returns the query term ID of this crf autoquery.
	 *
	 * @return the query term ID of this crf autoquery
	 */
	@Override
	public long getQueryTermId() {
		return model.getQueryTermId();
	}

	/**
	 * Returns the query term name of this crf autoquery.
	 *
	 * @return the query term name of this crf autoquery
	 */
	@Override
	public String getQueryTermName() {
		return model.getQueryTermName();
	}

	/**
	 * Returns the query type of this crf autoquery.
	 *
	 * @return the query type of this crf autoquery
	 */
	@Override
	public int getQueryType() {
		return model.getQueryType();
	}

	/**
	 * Returns the query value of this crf autoquery.
	 *
	 * @return the query value of this crf autoquery
	 */
	@Override
	public String getQueryValue() {
		return model.getQueryValue();
	}

	/**
	 * Returns the status of this crf autoquery.
	 *
	 * @return the status of this crf autoquery
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this crf autoquery.
	 *
	 * @return the status by user ID of this crf autoquery
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this crf autoquery.
	 *
	 * @return the status by user name of this crf autoquery
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this crf autoquery.
	 *
	 * @return the status by user uuid of this crf autoquery
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this crf autoquery.
	 *
	 * @return the status date of this crf autoquery
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subject ID of this crf autoquery.
	 *
	 * @return the subject ID of this crf autoquery
	 */
	@Override
	public long getSubjectId() {
		return model.getSubjectId();
	}

	/**
	 * Returns the user ID of this crf autoquery.
	 *
	 * @return the user ID of this crf autoquery
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this crf autoquery.
	 *
	 * @return the user name of this crf autoquery
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this crf autoquery.
	 *
	 * @return the user uuid of this crf autoquery
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this crf autoquery.
	 *
	 * @return the uuid of this crf autoquery
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this crf autoquery is approved.
	 *
	 * @return <code>true</code> if this crf autoquery is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this crf autoquery is denied.
	 *
	 * @return <code>true</code> if this crf autoquery is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this crf autoquery is a draft.
	 *
	 * @return <code>true</code> if this crf autoquery is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this crf autoquery is expired.
	 *
	 * @return <code>true</code> if this crf autoquery is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this crf autoquery is inactive.
	 *
	 * @return <code>true</code> if this crf autoquery is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this crf autoquery is incomplete.
	 *
	 * @return <code>true</code> if this crf autoquery is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this crf autoquery is pending.
	 *
	 * @return <code>true</code> if this crf autoquery is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this crf autoquery is scheduled.
	 *
	 * @return <code>true</code> if this crf autoquery is scheduled; <code>false</code> otherwise
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
	 * Sets the auto query ID of this crf autoquery.
	 *
	 * @param autoQueryId the auto query ID of this crf autoquery
	 */
	@Override
	public void setAutoQueryId(long autoQueryId) {
		model.setAutoQueryId(autoQueryId);
	}

	/**
	 * Sets the company ID of this crf autoquery.
	 *
	 * @param companyId the company ID of this crf autoquery
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this crf autoquery.
	 *
	 * @param createDate the create date of this crf autoquery
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the crf ID of this crf autoquery.
	 *
	 * @param crfId the crf ID of this crf autoquery
	 */
	@Override
	public void setCrfId(long crfId) {
		model.setCrfId(crfId);
	}

	/**
	 * Sets the group ID of this crf autoquery.
	 *
	 * @param groupId the group ID of this crf autoquery
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this crf autoquery.
	 *
	 * @param modifiedDate the modified date of this crf autoquery
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this crf autoquery.
	 *
	 * @param mvccVersion the mvcc version of this crf autoquery
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this crf autoquery.
	 *
	 * @param primaryKey the primary key of this crf autoquery
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the query comfirm of this crf autoquery.
	 *
	 * @param queryComfirm the query comfirm of this crf autoquery
	 */
	@Override
	public void setQueryComfirm(int queryComfirm) {
		model.setQueryComfirm(queryComfirm);
	}

	/**
	 * Sets the query comfirm date of this crf autoquery.
	 *
	 * @param queryComfirmDate the query comfirm date of this crf autoquery
	 */
	@Override
	public void setQueryComfirmDate(Date queryComfirmDate) {
		model.setQueryComfirmDate(queryComfirmDate);
	}

	/**
	 * Sets the query comfirm user ID of this crf autoquery.
	 *
	 * @param queryComfirmUserId the query comfirm user ID of this crf autoquery
	 */
	@Override
	public void setQueryComfirmUserId(long queryComfirmUserId) {
		model.setQueryComfirmUserId(queryComfirmUserId);
	}

	/**
	 * Sets the query comfirm user name of this crf autoquery.
	 *
	 * @param queryComfirmUserName the query comfirm user name of this crf autoquery
	 */
	@Override
	public void setQueryComfirmUserName(String queryComfirmUserName) {
		model.setQueryComfirmUserName(queryComfirmUserName);
	}

	/**
	 * Sets the query comfirm user uuid of this crf autoquery.
	 *
	 * @param queryComfirmUserUuid the query comfirm user uuid of this crf autoquery
	 */
	@Override
	public void setQueryComfirmUserUuid(String queryComfirmUserUuid) {
		model.setQueryComfirmUserUuid(queryComfirmUserUuid);
	}

	/**
	 * Sets the query comment of this crf autoquery.
	 *
	 * @param queryComment the query comment of this crf autoquery
	 */
	@Override
	public void setQueryComment(String queryComment) {
		model.setQueryComment(queryComment);
	}

	/**
	 * Sets the query previous value of this crf autoquery.
	 *
	 * @param queryPreviousValue the query previous value of this crf autoquery
	 */
	@Override
	public void setQueryPreviousValue(String queryPreviousValue) {
		model.setQueryPreviousValue(queryPreviousValue);
	}

	/**
	 * Sets the query term ID of this crf autoquery.
	 *
	 * @param queryTermId the query term ID of this crf autoquery
	 */
	@Override
	public void setQueryTermId(long queryTermId) {
		model.setQueryTermId(queryTermId);
	}

	/**
	 * Sets the query term name of this crf autoquery.
	 *
	 * @param queryTermName the query term name of this crf autoquery
	 */
	@Override
	public void setQueryTermName(String queryTermName) {
		model.setQueryTermName(queryTermName);
	}

	/**
	 * Sets the query type of this crf autoquery.
	 *
	 * @param queryType the query type of this crf autoquery
	 */
	@Override
	public void setQueryType(int queryType) {
		model.setQueryType(queryType);
	}

	/**
	 * Sets the query value of this crf autoquery.
	 *
	 * @param queryValue the query value of this crf autoquery
	 */
	@Override
	public void setQueryValue(String queryValue) {
		model.setQueryValue(queryValue);
	}

	/**
	 * Sets the status of this crf autoquery.
	 *
	 * @param status the status of this crf autoquery
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this crf autoquery.
	 *
	 * @param statusByUserId the status by user ID of this crf autoquery
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this crf autoquery.
	 *
	 * @param statusByUserName the status by user name of this crf autoquery
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this crf autoquery.
	 *
	 * @param statusByUserUuid the status by user uuid of this crf autoquery
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this crf autoquery.
	 *
	 * @param statusDate the status date of this crf autoquery
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subject ID of this crf autoquery.
	 *
	 * @param subjectId the subject ID of this crf autoquery
	 */
	@Override
	public void setSubjectId(long subjectId) {
		model.setSubjectId(subjectId);
	}

	/**
	 * Sets the user ID of this crf autoquery.
	 *
	 * @param userId the user ID of this crf autoquery
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this crf autoquery.
	 *
	 * @param userName the user name of this crf autoquery
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this crf autoquery.
	 *
	 * @param userUuid the user uuid of this crf autoquery
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this crf autoquery.
	 *
	 * @param uuid the uuid of this crf autoquery
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
	protected CRFAutoqueryWrapper wrap(CRFAutoquery crfAutoquery) {
		return new CRFAutoqueryWrapper(crfAutoquery);
	}

}