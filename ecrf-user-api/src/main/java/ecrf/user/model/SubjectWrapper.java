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
 * This class is a wrapper for {@link Subject}.
 * </p>
 *
 * @author Ryu W.C.
 * @see Subject
 * @generated
 */
public class SubjectWrapper
	extends BaseModelWrapper<Subject>
	implements ModelWrapper<Subject>, Subject {

	public SubjectWrapper(Subject subject) {
		super(subject);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("subjectId", getSubjectId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("birth", getBirth());
		attributes.put("gender", getGender());
		attributes.put("phone", getPhone());
		attributes.put("phone2", getPhone2());
		attributes.put("address", getAddress());
		attributes.put("serialId", getSerialId());
		attributes.put("hospitalCode", getHospitalCode());

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

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date birth = (Date)attributes.get("birth");

		if (birth != null) {
			setBirth(birth);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String phone2 = (String)attributes.get("phone2");

		if (phone2 != null) {
			setPhone2(phone2);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String serialId = (String)attributes.get("serialId");

		if (serialId != null) {
			setSerialId(serialId);
		}

		Integer hospitalCode = (Integer)attributes.get("hospitalCode");

		if (hospitalCode != null) {
			setHospitalCode(hospitalCode);
		}
	}

	/**
	 * Returns the address of this subject.
	 *
	 * @return the address of this subject
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the birth of this subject.
	 *
	 * @return the birth of this subject
	 */
	@Override
	public Date getBirth() {
		return model.getBirth();
	}

	/**
	 * Returns the company ID of this subject.
	 *
	 * @return the company ID of this subject
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this subject.
	 *
	 * @return the create date of this subject
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the gender of this subject.
	 *
	 * @return the gender of this subject
	 */
	@Override
	public int getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this subject.
	 *
	 * @return the group ID of this subject
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hospital code of this subject.
	 *
	 * @return the hospital code of this subject
	 */
	@Override
	public int getHospitalCode() {
		return model.getHospitalCode();
	}

	/**
	 * Returns the modified date of this subject.
	 *
	 * @return the modified date of this subject
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this subject.
	 *
	 * @return the mvcc version of this subject
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this subject.
	 *
	 * @return the name of this subject
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the phone of this subject.
	 *
	 * @return the phone of this subject
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the phone2 of this subject.
	 *
	 * @return the phone2 of this subject
	 */
	@Override
	public String getPhone2() {
		return model.getPhone2();
	}

	/**
	 * Returns the primary key of this subject.
	 *
	 * @return the primary key of this subject
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the serial ID of this subject.
	 *
	 * @return the serial ID of this subject
	 */
	@Override
	public String getSerialId() {
		return model.getSerialId();
	}

	/**
	 * Returns the status of this subject.
	 *
	 * @return the status of this subject
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this subject.
	 *
	 * @return the status by user ID of this subject
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this subject.
	 *
	 * @return the status by user name of this subject
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this subject.
	 *
	 * @return the status by user uuid of this subject
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this subject.
	 *
	 * @return the status date of this subject
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subject ID of this subject.
	 *
	 * @return the subject ID of this subject
	 */
	@Override
	public long getSubjectId() {
		return model.getSubjectId();
	}

	/**
	 * Returns the user ID of this subject.
	 *
	 * @return the user ID of this subject
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this subject.
	 *
	 * @return the user name of this subject
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this subject.
	 *
	 * @return the user uuid of this subject
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this subject.
	 *
	 * @return the uuid of this subject
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this subject is approved.
	 *
	 * @return <code>true</code> if this subject is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this subject is denied.
	 *
	 * @return <code>true</code> if this subject is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this subject is a draft.
	 *
	 * @return <code>true</code> if this subject is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this subject is expired.
	 *
	 * @return <code>true</code> if this subject is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this subject is inactive.
	 *
	 * @return <code>true</code> if this subject is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this subject is incomplete.
	 *
	 * @return <code>true</code> if this subject is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this subject is pending.
	 *
	 * @return <code>true</code> if this subject is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this subject is scheduled.
	 *
	 * @return <code>true</code> if this subject is scheduled; <code>false</code> otherwise
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
	 * Sets the address of this subject.
	 *
	 * @param address the address of this subject
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the birth of this subject.
	 *
	 * @param birth the birth of this subject
	 */
	@Override
	public void setBirth(Date birth) {
		model.setBirth(birth);
	}

	/**
	 * Sets the company ID of this subject.
	 *
	 * @param companyId the company ID of this subject
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this subject.
	 *
	 * @param createDate the create date of this subject
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the gender of this subject.
	 *
	 * @param gender the gender of this subject
	 */
	@Override
	public void setGender(int gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this subject.
	 *
	 * @param groupId the group ID of this subject
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hospital code of this subject.
	 *
	 * @param hospitalCode the hospital code of this subject
	 */
	@Override
	public void setHospitalCode(int hospitalCode) {
		model.setHospitalCode(hospitalCode);
	}

	/**
	 * Sets the modified date of this subject.
	 *
	 * @param modifiedDate the modified date of this subject
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this subject.
	 *
	 * @param mvccVersion the mvcc version of this subject
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this subject.
	 *
	 * @param name the name of this subject
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the phone of this subject.
	 *
	 * @param phone the phone of this subject
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the phone2 of this subject.
	 *
	 * @param phone2 the phone2 of this subject
	 */
	@Override
	public void setPhone2(String phone2) {
		model.setPhone2(phone2);
	}

	/**
	 * Sets the primary key of this subject.
	 *
	 * @param primaryKey the primary key of this subject
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the serial ID of this subject.
	 *
	 * @param serialId the serial ID of this subject
	 */
	@Override
	public void setSerialId(String serialId) {
		model.setSerialId(serialId);
	}

	/**
	 * Sets the status of this subject.
	 *
	 * @param status the status of this subject
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this subject.
	 *
	 * @param statusByUserId the status by user ID of this subject
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this subject.
	 *
	 * @param statusByUserName the status by user name of this subject
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this subject.
	 *
	 * @param statusByUserUuid the status by user uuid of this subject
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this subject.
	 *
	 * @param statusDate the status date of this subject
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subject ID of this subject.
	 *
	 * @param subjectId the subject ID of this subject
	 */
	@Override
	public void setSubjectId(long subjectId) {
		model.setSubjectId(subjectId);
	}

	/**
	 * Sets the user ID of this subject.
	 *
	 * @param userId the user ID of this subject
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this subject.
	 *
	 * @param userName the user name of this subject
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this subject.
	 *
	 * @param userUuid the user uuid of this subject
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this subject.
	 *
	 * @param uuid the uuid of this subject
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
	protected SubjectWrapper wrap(Subject subject) {
		return new SubjectWrapper(subject);
	}

}