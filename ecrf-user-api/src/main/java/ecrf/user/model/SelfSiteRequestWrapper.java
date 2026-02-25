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
 * This class is a wrapper for {@link SelfSiteRequest}.
 * </p>
 *
 * @author Ryu W.C.
 * @see SelfSiteRequest
 * @generated
 */
public class SelfSiteRequestWrapper
	extends BaseModelWrapper<SelfSiteRequest>
	implements ModelWrapper<SelfSiteRequest>, SelfSiteRequest {

	public SelfSiteRequestWrapper(SelfSiteRequest selfSiteRequest) {
		super(selfSiteRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("selfSiteRequestId", getSelfSiteRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("email", getEmail());
		attributes.put("lastName", getLastName());
		attributes.put("firstName", getFirstName());
		attributes.put("phone", getPhone());
		attributes.put("projectTitle", getProjectTitle());
		attributes.put("projectDescription", getProjectDescription());

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

		Long selfSiteRequestId = (Long)attributes.get("selfSiteRequestId");

		if (selfSiteRequestId != null) {
			setSelfSiteRequestId(selfSiteRequestId);
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

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String projectTitle = (String)attributes.get("projectTitle");

		if (projectTitle != null) {
			setProjectTitle(projectTitle);
		}

		String projectDescription = (String)attributes.get(
			"projectDescription");

		if (projectDescription != null) {
			setProjectDescription(projectDescription);
		}
	}

	/**
	 * Returns the company ID of this self site request.
	 *
	 * @return the company ID of this self site request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this self site request.
	 *
	 * @return the create date of this self site request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this self site request.
	 *
	 * @return the email of this self site request
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this self site request.
	 *
	 * @return the first name of this self site request
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the group ID of this self site request.
	 *
	 * @return the group ID of this self site request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last name of this self site request.
	 *
	 * @return the last name of this self site request
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified date of this self site request.
	 *
	 * @return the modified date of this self site request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this self site request.
	 *
	 * @return the mvcc version of this self site request
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the phone of this self site request.
	 *
	 * @return the phone of this self site request
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this self site request.
	 *
	 * @return the primary key of this self site request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project description of this self site request.
	 *
	 * @return the project description of this self site request
	 */
	@Override
	public String getProjectDescription() {
		return model.getProjectDescription();
	}

	/**
	 * Returns the project title of this self site request.
	 *
	 * @return the project title of this self site request
	 */
	@Override
	public String getProjectTitle() {
		return model.getProjectTitle();
	}

	/**
	 * Returns the self site request ID of this self site request.
	 *
	 * @return the self site request ID of this self site request
	 */
	@Override
	public long getSelfSiteRequestId() {
		return model.getSelfSiteRequestId();
	}

	/**
	 * Returns the user ID of this self site request.
	 *
	 * @return the user ID of this self site request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this self site request.
	 *
	 * @return the user name of this self site request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this self site request.
	 *
	 * @return the user uuid of this self site request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this self site request.
	 *
	 * @return the uuid of this self site request
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
	 * Sets the company ID of this self site request.
	 *
	 * @param companyId the company ID of this self site request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this self site request.
	 *
	 * @param createDate the create date of this self site request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this self site request.
	 *
	 * @param email the email of this self site request
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the first name of this self site request.
	 *
	 * @param firstName the first name of this self site request
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the group ID of this self site request.
	 *
	 * @param groupId the group ID of this self site request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last name of this self site request.
	 *
	 * @param lastName the last name of this self site request
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the modified date of this self site request.
	 *
	 * @param modifiedDate the modified date of this self site request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this self site request.
	 *
	 * @param mvccVersion the mvcc version of this self site request
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the phone of this self site request.
	 *
	 * @param phone the phone of this self site request
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this self site request.
	 *
	 * @param primaryKey the primary key of this self site request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project description of this self site request.
	 *
	 * @param projectDescription the project description of this self site request
	 */
	@Override
	public void setProjectDescription(String projectDescription) {
		model.setProjectDescription(projectDescription);
	}

	/**
	 * Sets the project title of this self site request.
	 *
	 * @param projectTitle the project title of this self site request
	 */
	@Override
	public void setProjectTitle(String projectTitle) {
		model.setProjectTitle(projectTitle);
	}

	/**
	 * Sets the self site request ID of this self site request.
	 *
	 * @param selfSiteRequestId the self site request ID of this self site request
	 */
	@Override
	public void setSelfSiteRequestId(long selfSiteRequestId) {
		model.setSelfSiteRequestId(selfSiteRequestId);
	}

	/**
	 * Sets the user ID of this self site request.
	 *
	 * @param userId the user ID of this self site request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this self site request.
	 *
	 * @param userName the user name of this self site request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this self site request.
	 *
	 * @param userUuid the user uuid of this self site request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this self site request.
	 *
	 * @param uuid the uuid of this self site request
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
	protected SelfSiteRequestWrapper wrap(SelfSiteRequest selfSiteRequest) {
		return new SelfSiteRequestWrapper(selfSiteRequest);
	}

}