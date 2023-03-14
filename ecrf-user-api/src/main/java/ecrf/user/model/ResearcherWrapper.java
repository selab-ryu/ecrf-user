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
 * This class is a wrapper for {@link Researcher}.
 * </p>
 *
 * @author Ryu W.C.
 * @see Researcher
 * @generated
 */
public class ResearcherWrapper
	extends BaseModelWrapper<Researcher>
	implements ModelWrapper<Researcher>, Researcher {

	public ResearcherWrapper(Researcher researcher) {
		super(researcher);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("researcherId", getResearcherId());
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
		attributes.put("name", getName());
		attributes.put("birth", getBirth());
		attributes.put("phone", getPhone());
		attributes.put("institution", getInstitution());
		attributes.put("officeContact", getOfficeContact());
		attributes.put("position", getPosition());
		attributes.put("approveStatus", getApproveStatus());
		attributes.put("researcherUserId", getResearcherUserId());

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

		Long researcherId = (Long)attributes.get("researcherId");

		if (researcherId != null) {
			setResearcherId(researcherId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date birth = (Date)attributes.get("birth");

		if (birth != null) {
			setBirth(birth);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String institution = (String)attributes.get("institution");

		if (institution != null) {
			setInstitution(institution);
		}

		String officeContact = (String)attributes.get("officeContact");

		if (officeContact != null) {
			setOfficeContact(officeContact);
		}

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Integer approveStatus = (Integer)attributes.get("approveStatus");

		if (approveStatus != null) {
			setApproveStatus(approveStatus);
		}

		Long researcherUserId = (Long)attributes.get("researcherUserId");

		if (researcherUserId != null) {
			setResearcherUserId(researcherUserId);
		}
	}

	/**
	 * Returns the approve status of this researcher.
	 *
	 * @return the approve status of this researcher
	 */
	@Override
	public int getApproveStatus() {
		return model.getApproveStatus();
	}

	/**
	 * Returns the birth of this researcher.
	 *
	 * @return the birth of this researcher
	 */
	@Override
	public Date getBirth() {
		return model.getBirth();
	}

	/**
	 * Returns the company ID of this researcher.
	 *
	 * @return the company ID of this researcher
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this researcher.
	 *
	 * @return the create date of this researcher
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the create user ID of this researcher.
	 *
	 * @return the create user ID of this researcher
	 */
	@Override
	public long getCreateUserId() {
		return model.getCreateUserId();
	}

	/**
	 * Returns the create user name of this researcher.
	 *
	 * @return the create user name of this researcher
	 */
	@Override
	public String getCreateUserName() {
		return model.getCreateUserName();
	}

	/**
	 * Returns the create user uuid of this researcher.
	 *
	 * @return the create user uuid of this researcher
	 */
	@Override
	public String getCreateUserUuid() {
		return model.getCreateUserUuid();
	}

	/**
	 * Returns the group ID of this researcher.
	 *
	 * @return the group ID of this researcher
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the institution of this researcher.
	 *
	 * @return the institution of this researcher
	 */
	@Override
	public String getInstitution() {
		return model.getInstitution();
	}

	/**
	 * Returns the modified date of this researcher.
	 *
	 * @return the modified date of this researcher
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this researcher.
	 *
	 * @return the mvcc version of this researcher
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this researcher.
	 *
	 * @return the name of this researcher
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the office contact of this researcher.
	 *
	 * @return the office contact of this researcher
	 */
	@Override
	public String getOfficeContact() {
		return model.getOfficeContact();
	}

	/**
	 * Returns the phone of this researcher.
	 *
	 * @return the phone of this researcher
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the position of this researcher.
	 *
	 * @return the position of this researcher
	 */
	@Override
	public String getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this researcher.
	 *
	 * @return the primary key of this researcher
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the researcher ID of this researcher.
	 *
	 * @return the researcher ID of this researcher
	 */
	@Override
	public long getResearcherId() {
		return model.getResearcherId();
	}

	/**
	 * Returns the researcher user ID of this researcher.
	 *
	 * @return the researcher user ID of this researcher
	 */
	@Override
	public long getResearcherUserId() {
		return model.getResearcherUserId();
	}

	/**
	 * Returns the researcher user uuid of this researcher.
	 *
	 * @return the researcher user uuid of this researcher
	 */
	@Override
	public String getResearcherUserUuid() {
		return model.getResearcherUserUuid();
	}

	/**
	 * Returns the status of this researcher.
	 *
	 * @return the status of this researcher
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this researcher.
	 *
	 * @return the status by user ID of this researcher
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this researcher.
	 *
	 * @return the status by user name of this researcher
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this researcher.
	 *
	 * @return the status by user uuid of this researcher
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this researcher.
	 *
	 * @return the status date of this researcher
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the uuid of this researcher.
	 *
	 * @return the uuid of this researcher
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this researcher is approved.
	 *
	 * @return <code>true</code> if this researcher is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this researcher is denied.
	 *
	 * @return <code>true</code> if this researcher is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this researcher is a draft.
	 *
	 * @return <code>true</code> if this researcher is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this researcher is expired.
	 *
	 * @return <code>true</code> if this researcher is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this researcher is inactive.
	 *
	 * @return <code>true</code> if this researcher is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this researcher is incomplete.
	 *
	 * @return <code>true</code> if this researcher is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this researcher is pending.
	 *
	 * @return <code>true</code> if this researcher is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this researcher is scheduled.
	 *
	 * @return <code>true</code> if this researcher is scheduled; <code>false</code> otherwise
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
	 * Sets the approve status of this researcher.
	 *
	 * @param approveStatus the approve status of this researcher
	 */
	@Override
	public void setApproveStatus(int approveStatus) {
		model.setApproveStatus(approveStatus);
	}

	/**
	 * Sets the birth of this researcher.
	 *
	 * @param birth the birth of this researcher
	 */
	@Override
	public void setBirth(Date birth) {
		model.setBirth(birth);
	}

	/**
	 * Sets the company ID of this researcher.
	 *
	 * @param companyId the company ID of this researcher
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this researcher.
	 *
	 * @param createDate the create date of this researcher
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the create user ID of this researcher.
	 *
	 * @param createUserId the create user ID of this researcher
	 */
	@Override
	public void setCreateUserId(long createUserId) {
		model.setCreateUserId(createUserId);
	}

	/**
	 * Sets the create user name of this researcher.
	 *
	 * @param createUserName the create user name of this researcher
	 */
	@Override
	public void setCreateUserName(String createUserName) {
		model.setCreateUserName(createUserName);
	}

	/**
	 * Sets the create user uuid of this researcher.
	 *
	 * @param createUserUuid the create user uuid of this researcher
	 */
	@Override
	public void setCreateUserUuid(String createUserUuid) {
		model.setCreateUserUuid(createUserUuid);
	}

	/**
	 * Sets the group ID of this researcher.
	 *
	 * @param groupId the group ID of this researcher
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the institution of this researcher.
	 *
	 * @param institution the institution of this researcher
	 */
	@Override
	public void setInstitution(String institution) {
		model.setInstitution(institution);
	}

	/**
	 * Sets the modified date of this researcher.
	 *
	 * @param modifiedDate the modified date of this researcher
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this researcher.
	 *
	 * @param mvccVersion the mvcc version of this researcher
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this researcher.
	 *
	 * @param name the name of this researcher
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the office contact of this researcher.
	 *
	 * @param officeContact the office contact of this researcher
	 */
	@Override
	public void setOfficeContact(String officeContact) {
		model.setOfficeContact(officeContact);
	}

	/**
	 * Sets the phone of this researcher.
	 *
	 * @param phone the phone of this researcher
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the position of this researcher.
	 *
	 * @param position the position of this researcher
	 */
	@Override
	public void setPosition(String position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this researcher.
	 *
	 * @param primaryKey the primary key of this researcher
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the researcher ID of this researcher.
	 *
	 * @param researcherId the researcher ID of this researcher
	 */
	@Override
	public void setResearcherId(long researcherId) {
		model.setResearcherId(researcherId);
	}

	/**
	 * Sets the researcher user ID of this researcher.
	 *
	 * @param researcherUserId the researcher user ID of this researcher
	 */
	@Override
	public void setResearcherUserId(long researcherUserId) {
		model.setResearcherUserId(researcherUserId);
	}

	/**
	 * Sets the researcher user uuid of this researcher.
	 *
	 * @param researcherUserUuid the researcher user uuid of this researcher
	 */
	@Override
	public void setResearcherUserUuid(String researcherUserUuid) {
		model.setResearcherUserUuid(researcherUserUuid);
	}

	/**
	 * Sets the status of this researcher.
	 *
	 * @param status the status of this researcher
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this researcher.
	 *
	 * @param statusByUserId the status by user ID of this researcher
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this researcher.
	 *
	 * @param statusByUserName the status by user name of this researcher
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this researcher.
	 *
	 * @param statusByUserUuid the status by user uuid of this researcher
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this researcher.
	 *
	 * @param statusDate the status date of this researcher
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the uuid of this researcher.
	 *
	 * @param uuid the uuid of this researcher
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
	protected ResearcherWrapper wrap(Researcher researcher) {
		return new ResearcherWrapper(researcher);
	}

}