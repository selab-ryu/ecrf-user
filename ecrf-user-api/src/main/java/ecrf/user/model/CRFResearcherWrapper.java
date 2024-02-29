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
 * This class is a wrapper for {@link CRFResearcher}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFResearcher
 * @generated
 */
public class CRFResearcherWrapper
	extends BaseModelWrapper<CRFResearcher>
	implements CRFResearcher, ModelWrapper<CRFResearcher> {

	public CRFResearcherWrapper(CRFResearcher crfResearcher) {
		super(crfResearcher);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("crfResearcherId", getCrfResearcherId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("researcherId", getResearcherId());
		attributes.put("crfId", getCrfId());
		attributes.put("jobTitle", getJobTitle());

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

		Long crfResearcherId = (Long)attributes.get("crfResearcherId");

		if (crfResearcherId != null) {
			setCrfResearcherId(crfResearcherId);
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

		Long researcherId = (Long)attributes.get("researcherId");

		if (researcherId != null) {
			setResearcherId(researcherId);
		}

		Long crfId = (Long)attributes.get("crfId");

		if (crfId != null) {
			setCrfId(crfId);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}
	}

	/**
	 * Returns the company ID of this crf researcher.
	 *
	 * @return the company ID of this crf researcher
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this crf researcher.
	 *
	 * @return the create date of this crf researcher
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the crf ID of this crf researcher.
	 *
	 * @return the crf ID of this crf researcher
	 */
	@Override
	public long getCrfId() {
		return model.getCrfId();
	}

	/**
	 * Returns the crf researcher ID of this crf researcher.
	 *
	 * @return the crf researcher ID of this crf researcher
	 */
	@Override
	public long getCrfResearcherId() {
		return model.getCrfResearcherId();
	}

	/**
	 * Returns the group ID of this crf researcher.
	 *
	 * @return the group ID of this crf researcher
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the job title of this crf researcher.
	 *
	 * @return the job title of this crf researcher
	 */
	@Override
	public String getJobTitle() {
		return model.getJobTitle();
	}

	/**
	 * Returns the modified date of this crf researcher.
	 *
	 * @return the modified date of this crf researcher
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this crf researcher.
	 *
	 * @return the mvcc version of this crf researcher
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this crf researcher.
	 *
	 * @return the primary key of this crf researcher
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the researcher ID of this crf researcher.
	 *
	 * @return the researcher ID of this crf researcher
	 */
	@Override
	public long getResearcherId() {
		return model.getResearcherId();
	}

	/**
	 * Returns the user ID of this crf researcher.
	 *
	 * @return the user ID of this crf researcher
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this crf researcher.
	 *
	 * @return the user name of this crf researcher
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this crf researcher.
	 *
	 * @return the user uuid of this crf researcher
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this crf researcher.
	 *
	 * @return the uuid of this crf researcher
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
	 * Sets the company ID of this crf researcher.
	 *
	 * @param companyId the company ID of this crf researcher
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this crf researcher.
	 *
	 * @param createDate the create date of this crf researcher
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the crf ID of this crf researcher.
	 *
	 * @param crfId the crf ID of this crf researcher
	 */
	@Override
	public void setCrfId(long crfId) {
		model.setCrfId(crfId);
	}

	/**
	 * Sets the crf researcher ID of this crf researcher.
	 *
	 * @param crfResearcherId the crf researcher ID of this crf researcher
	 */
	@Override
	public void setCrfResearcherId(long crfResearcherId) {
		model.setCrfResearcherId(crfResearcherId);
	}

	/**
	 * Sets the group ID of this crf researcher.
	 *
	 * @param groupId the group ID of this crf researcher
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the job title of this crf researcher.
	 *
	 * @param jobTitle the job title of this crf researcher
	 */
	@Override
	public void setJobTitle(String jobTitle) {
		model.setJobTitle(jobTitle);
	}

	/**
	 * Sets the modified date of this crf researcher.
	 *
	 * @param modifiedDate the modified date of this crf researcher
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this crf researcher.
	 *
	 * @param mvccVersion the mvcc version of this crf researcher
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this crf researcher.
	 *
	 * @param primaryKey the primary key of this crf researcher
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the researcher ID of this crf researcher.
	 *
	 * @param researcherId the researcher ID of this crf researcher
	 */
	@Override
	public void setResearcherId(long researcherId) {
		model.setResearcherId(researcherId);
	}

	/**
	 * Sets the user ID of this crf researcher.
	 *
	 * @param userId the user ID of this crf researcher
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this crf researcher.
	 *
	 * @param userName the user name of this crf researcher
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this crf researcher.
	 *
	 * @param userUuid the user uuid of this crf researcher
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this crf researcher.
	 *
	 * @param uuid the uuid of this crf researcher
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
	protected CRFResearcherWrapper wrap(CRFResearcher crfResearcher) {
		return new CRFResearcherWrapper(crfResearcher);
	}

}