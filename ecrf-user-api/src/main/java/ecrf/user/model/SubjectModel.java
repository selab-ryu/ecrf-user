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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Subject service. Represents a row in the &quot;EC_Subject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>ecrf.user.model.impl.SubjectModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>ecrf.user.model.impl.SubjectImpl</code>.
 * </p>
 *
 * @author Ryu W.C.
 * @see Subject
 * @generated
 */
@ProviderType
public interface SubjectModel
	extends BaseModel<Subject>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a subject model instance should use the {@link Subject} interface instead.
	 */

	/**
	 * Returns the primary key of this subject.
	 *
	 * @return the primary key of this subject
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this subject.
	 *
	 * @param primaryKey the primary key of this subject
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this subject.
	 *
	 * @return the mvcc version of this subject
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this subject.
	 *
	 * @param mvccVersion the mvcc version of this subject
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this subject.
	 *
	 * @return the uuid of this subject
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this subject.
	 *
	 * @param uuid the uuid of this subject
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the subject ID of this subject.
	 *
	 * @return the subject ID of this subject
	 */
	public long getSubjectId();

	/**
	 * Sets the subject ID of this subject.
	 *
	 * @param subjectId the subject ID of this subject
	 */
	public void setSubjectId(long subjectId);

	/**
	 * Returns the company ID of this subject.
	 *
	 * @return the company ID of this subject
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this subject.
	 *
	 * @param companyId the company ID of this subject
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this subject.
	 *
	 * @return the group ID of this subject
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this subject.
	 *
	 * @param groupId the group ID of this subject
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this subject.
	 *
	 * @return the user ID of this subject
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this subject.
	 *
	 * @param userId the user ID of this subject
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this subject.
	 *
	 * @return the user uuid of this subject
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this subject.
	 *
	 * @param userUuid the user uuid of this subject
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this subject.
	 *
	 * @return the user name of this subject
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this subject.
	 *
	 * @param userName the user name of this subject
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this subject.
	 *
	 * @return the create date of this subject
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this subject.
	 *
	 * @param createDate the create date of this subject
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this subject.
	 *
	 * @return the modified date of this subject
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this subject.
	 *
	 * @param modifiedDate the modified date of this subject
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this subject.
	 *
	 * @return the status of this subject
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this subject.
	 *
	 * @param status the status of this subject
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this subject.
	 *
	 * @return the status by user ID of this subject
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this subject.
	 *
	 * @param statusByUserId the status by user ID of this subject
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this subject.
	 *
	 * @return the status by user uuid of this subject
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this subject.
	 *
	 * @param statusByUserUuid the status by user uuid of this subject
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this subject.
	 *
	 * @return the status by user name of this subject
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this subject.
	 *
	 * @param statusByUserName the status by user name of this subject
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this subject.
	 *
	 * @return the status date of this subject
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this subject.
	 *
	 * @param statusDate the status date of this subject
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the name of this subject.
	 *
	 * @return the name of this subject
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this subject.
	 *
	 * @param name the name of this subject
	 */
	public void setName(String name);

	/**
	 * Returns the birth of this subject.
	 *
	 * @return the birth of this subject
	 */
	public Date getBirth();

	/**
	 * Sets the birth of this subject.
	 *
	 * @param birth the birth of this subject
	 */
	public void setBirth(Date birth);

	/**
	 * Returns the gender of this subject.
	 *
	 * @return the gender of this subject
	 */
	public int getGender();

	/**
	 * Sets the gender of this subject.
	 *
	 * @param gender the gender of this subject
	 */
	public void setGender(int gender);

	/**
	 * Returns the phone of this subject.
	 *
	 * @return the phone of this subject
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this subject.
	 *
	 * @param phone the phone of this subject
	 */
	public void setPhone(String phone);

	/**
	 * Returns the phone2 of this subject.
	 *
	 * @return the phone2 of this subject
	 */
	@AutoEscape
	public String getPhone2();

	/**
	 * Sets the phone2 of this subject.
	 *
	 * @param phone2 the phone2 of this subject
	 */
	public void setPhone2(String phone2);

	/**
	 * Returns the address of this subject.
	 *
	 * @return the address of this subject
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this subject.
	 *
	 * @param address the address of this subject
	 */
	public void setAddress(String address);

	/**
	 * Returns the serial ID of this subject.
	 *
	 * @return the serial ID of this subject
	 */
	@AutoEscape
	public String getSerialId();

	/**
	 * Sets the serial ID of this subject.
	 *
	 * @param serialId the serial ID of this subject
	 */
	public void setSerialId(String serialId);

	/**
	 * Returns the hospital code of this subject.
	 *
	 * @return the hospital code of this subject
	 */
	public int getHospitalCode();

	/**
	 * Sets the hospital code of this subject.
	 *
	 * @param hospitalCode the hospital code of this subject
	 */
	public void setHospitalCode(int hospitalCode);

	/**
	 * Returns <code>true</code> if this subject is approved.
	 *
	 * @return <code>true</code> if this subject is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this subject is denied.
	 *
	 * @return <code>true</code> if this subject is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this subject is a draft.
	 *
	 * @return <code>true</code> if this subject is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this subject is expired.
	 *
	 * @return <code>true</code> if this subject is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this subject is inactive.
	 *
	 * @return <code>true</code> if this subject is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this subject is incomplete.
	 *
	 * @return <code>true</code> if this subject is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this subject is pending.
	 *
	 * @return <code>true</code> if this subject is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this subject is scheduled.
	 *
	 * @return <code>true</code> if this subject is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}