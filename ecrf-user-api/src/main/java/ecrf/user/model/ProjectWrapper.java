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
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
public class ProjectWrapper
	extends BaseModelWrapper<Project>
	implements ModelWrapper<Project>, Project {

	public ProjectWrapper(Project project) {
		super(project);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectId", getProjectId());
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
		attributes.put("title", getTitle());
		attributes.put("shortTitle", getShortTitle());
		attributes.put("purpose", getPurpose());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("principalResearcherId", getPrincipalResearcherId());
		attributes.put("manageResearcherId", getManageResearcherId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String shortTitle = (String)attributes.get("shortTitle");

		if (shortTitle != null) {
			setShortTitle(shortTitle);
		}

		String purpose = (String)attributes.get("purpose");

		if (purpose != null) {
			setPurpose(purpose);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long principalResearcherId = (Long)attributes.get(
			"principalResearcherId");

		if (principalResearcherId != null) {
			setPrincipalResearcherId(principalResearcherId);
		}

		Long manageResearcherId = (Long)attributes.get("manageResearcherId");

		if (manageResearcherId != null) {
			setManageResearcherId(manageResearcherId);
		}
	}

	/**
	 * Returns the company ID of this project.
	 *
	 * @return the company ID of this project
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this project.
	 *
	 * @return the create date of this project
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the create user ID of this project.
	 *
	 * @return the create user ID of this project
	 */
	@Override
	public long getCreateUserId() {
		return model.getCreateUserId();
	}

	/**
	 * Returns the create user name of this project.
	 *
	 * @return the create user name of this project
	 */
	@Override
	public String getCreateUserName() {
		return model.getCreateUserName();
	}

	/**
	 * Returns the create user uuid of this project.
	 *
	 * @return the create user uuid of this project
	 */
	@Override
	public String getCreateUserUuid() {
		return model.getCreateUserUuid();
	}

	/**
	 * Returns the end date of this project.
	 *
	 * @return the end date of this project
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this project.
	 *
	 * @return the group ID of this project
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the manage researcher ID of this project.
	 *
	 * @return the manage researcher ID of this project
	 */
	@Override
	public long getManageResearcherId() {
		return model.getManageResearcherId();
	}

	/**
	 * Returns the modified date of this project.
	 *
	 * @return the modified date of this project
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this project.
	 *
	 * @return the primary key of this project
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the principal researcher ID of this project.
	 *
	 * @return the principal researcher ID of this project
	 */
	@Override
	public long getPrincipalResearcherId() {
		return model.getPrincipalResearcherId();
	}

	/**
	 * Returns the project ID of this project.
	 *
	 * @return the project ID of this project
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the purpose of this project.
	 *
	 * @return the purpose of this project
	 */
	@Override
	public String getPurpose() {
		return model.getPurpose();
	}

	/**
	 * Returns the short title of this project.
	 *
	 * @return the short title of this project
	 */
	@Override
	public String getShortTitle() {
		return model.getShortTitle();
	}

	/**
	 * Returns the start date of this project.
	 *
	 * @return the start date of this project
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this project.
	 *
	 * @return the status of this project
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this project.
	 *
	 * @return the status by user ID of this project
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this project.
	 *
	 * @return the status by user name of this project
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this project.
	 *
	 * @return the status by user uuid of this project
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this project.
	 *
	 * @return the status date of this project
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this project.
	 *
	 * @return the title of this project
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this project.
	 *
	 * @return the uuid of this project
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this project is approved.
	 *
	 * @return <code>true</code> if this project is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this project is denied.
	 *
	 * @return <code>true</code> if this project is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this project is a draft.
	 *
	 * @return <code>true</code> if this project is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this project is expired.
	 *
	 * @return <code>true</code> if this project is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this project is inactive.
	 *
	 * @return <code>true</code> if this project is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this project is incomplete.
	 *
	 * @return <code>true</code> if this project is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this project is pending.
	 *
	 * @return <code>true</code> if this project is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this project is scheduled.
	 *
	 * @return <code>true</code> if this project is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this project.
	 *
	 * @param companyId the company ID of this project
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this project.
	 *
	 * @param createDate the create date of this project
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the create user ID of this project.
	 *
	 * @param createUserId the create user ID of this project
	 */
	@Override
	public void setCreateUserId(long createUserId) {
		model.setCreateUserId(createUserId);
	}

	/**
	 * Sets the create user name of this project.
	 *
	 * @param createUserName the create user name of this project
	 */
	@Override
	public void setCreateUserName(String createUserName) {
		model.setCreateUserName(createUserName);
	}

	/**
	 * Sets the create user uuid of this project.
	 *
	 * @param createUserUuid the create user uuid of this project
	 */
	@Override
	public void setCreateUserUuid(String createUserUuid) {
		model.setCreateUserUuid(createUserUuid);
	}

	/**
	 * Sets the end date of this project.
	 *
	 * @param endDate the end date of this project
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this project.
	 *
	 * @param groupId the group ID of this project
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the manage researcher ID of this project.
	 *
	 * @param manageResearcherId the manage researcher ID of this project
	 */
	@Override
	public void setManageResearcherId(long manageResearcherId) {
		model.setManageResearcherId(manageResearcherId);
	}

	/**
	 * Sets the modified date of this project.
	 *
	 * @param modifiedDate the modified date of this project
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this project.
	 *
	 * @param primaryKey the primary key of this project
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the principal researcher ID of this project.
	 *
	 * @param principalResearcherId the principal researcher ID of this project
	 */
	@Override
	public void setPrincipalResearcherId(long principalResearcherId) {
		model.setPrincipalResearcherId(principalResearcherId);
	}

	/**
	 * Sets the project ID of this project.
	 *
	 * @param projectId the project ID of this project
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the purpose of this project.
	 *
	 * @param purpose the purpose of this project
	 */
	@Override
	public void setPurpose(String purpose) {
		model.setPurpose(purpose);
	}

	/**
	 * Sets the short title of this project.
	 *
	 * @param shortTitle the short title of this project
	 */
	@Override
	public void setShortTitle(String shortTitle) {
		model.setShortTitle(shortTitle);
	}

	/**
	 * Sets the start date of this project.
	 *
	 * @param startDate the start date of this project
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this project.
	 *
	 * @param status the status of this project
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this project.
	 *
	 * @param statusByUserId the status by user ID of this project
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this project.
	 *
	 * @param statusByUserName the status by user name of this project
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this project.
	 *
	 * @param statusByUserUuid the status by user uuid of this project
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this project.
	 *
	 * @param statusDate the status date of this project
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this project.
	 *
	 * @param title the title of this project
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the uuid of this project.
	 *
	 * @param uuid the uuid of this project
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
	protected ProjectWrapper wrap(Project project) {
		return new ProjectWrapper(project);
	}

}