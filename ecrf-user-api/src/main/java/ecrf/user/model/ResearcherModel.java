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
 * The base model interface for the Researcher service. Represents a row in the &quot;EC_Researcher&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>ecrf.user.model.impl.ResearcherModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>ecrf.user.model.impl.ResearcherImpl</code>.
 * </p>
 *
 * @author Ryu W.C.
 * @see Researcher
 * @generated
 */
@ProviderType
public interface ResearcherModel
	extends BaseModel<Researcher>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a researcher model instance should use the {@link Researcher} interface instead.
	 */

	/**
	 * Returns the primary key of this researcher.
	 *
	 * @return the primary key of this researcher
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this researcher.
	 *
	 * @param primaryKey the primary key of this researcher
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this researcher.
	 *
	 * @return the mvcc version of this researcher
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this researcher.
	 *
	 * @param mvccVersion the mvcc version of this researcher
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this researcher.
	 *
	 * @return the uuid of this researcher
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this researcher.
	 *
	 * @param uuid the uuid of this researcher
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the researcher ID of this researcher.
	 *
	 * @return the researcher ID of this researcher
	 */
	public long getResearcherId();

	/**
	 * Sets the researcher ID of this researcher.
	 *
	 * @param researcherId the researcher ID of this researcher
	 */
	public void setResearcherId(long researcherId);

	/**
	 * Returns the group ID of this researcher.
	 *
	 * @return the group ID of this researcher
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this researcher.
	 *
	 * @param groupId the group ID of this researcher
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this researcher.
	 *
	 * @return the company ID of this researcher
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this researcher.
	 *
	 * @param companyId the company ID of this researcher
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this researcher.
	 *
	 * @return the user ID of this researcher
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this researcher.
	 *
	 * @param userId the user ID of this researcher
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this researcher.
	 *
	 * @return the user uuid of this researcher
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this researcher.
	 *
	 * @param userUuid the user uuid of this researcher
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this researcher.
	 *
	 * @return the user name of this researcher
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this researcher.
	 *
	 * @param userName the user name of this researcher
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this researcher.
	 *
	 * @return the create date of this researcher
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this researcher.
	 *
	 * @param createDate the create date of this researcher
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this researcher.
	 *
	 * @return the modified date of this researcher
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this researcher.
	 *
	 * @param modifiedDate the modified date of this researcher
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this researcher.
	 *
	 * @return the status of this researcher
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this researcher.
	 *
	 * @param status the status of this researcher
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this researcher.
	 *
	 * @return the status by user ID of this researcher
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this researcher.
	 *
	 * @param statusByUserId the status by user ID of this researcher
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this researcher.
	 *
	 * @return the status by user uuid of this researcher
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this researcher.
	 *
	 * @param statusByUserUuid the status by user uuid of this researcher
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this researcher.
	 *
	 * @return the status by user name of this researcher
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this researcher.
	 *
	 * @param statusByUserName the status by user name of this researcher
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this researcher.
	 *
	 * @return the status date of this researcher
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this researcher.
	 *
	 * @param statusDate the status date of this researcher
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the name of this researcher.
	 *
	 * @return the name of this researcher
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this researcher.
	 *
	 * @param name the name of this researcher
	 */
	public void setName(String name);

	/**
	 * Returns the email of this researcher.
	 *
	 * @return the email of this researcher
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this researcher.
	 *
	 * @param email the email of this researcher
	 */
	public void setEmail(String email);

	/**
	 * Returns the birth of this researcher.
	 *
	 * @return the birth of this researcher
	 */
	public Date getBirth();

	/**
	 * Sets the birth of this researcher.
	 *
	 * @param birth the birth of this researcher
	 */
	public void setBirth(Date birth);

	/**
	 * Returns the phone of this researcher.
	 *
	 * @return the phone of this researcher
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this researcher.
	 *
	 * @param phone the phone of this researcher
	 */
	public void setPhone(String phone);

	/**
	 * Returns the institution of this researcher.
	 *
	 * @return the institution of this researcher
	 */
	@AutoEscape
	public String getInstitution();

	/**
	 * Sets the institution of this researcher.
	 *
	 * @param institution the institution of this researcher
	 */
	public void setInstitution(String institution);

	/**
	 * Returns the office contact of this researcher.
	 *
	 * @return the office contact of this researcher
	 */
	@AutoEscape
	public String getOfficeContact();

	/**
	 * Sets the office contact of this researcher.
	 *
	 * @param officeContact the office contact of this researcher
	 */
	public void setOfficeContact(String officeContact);

	/**
	 * Returns the position of this researcher.
	 *
	 * @return the position of this researcher
	 */
	@AutoEscape
	public String getPosition();

	/**
	 * Sets the position of this researcher.
	 *
	 * @param position the position of this researcher
	 */
	public void setPosition(String position);

	/**
	 * Returns the approve status of this researcher.
	 *
	 * @return the approve status of this researcher
	 */
	public int getApproveStatus();

	/**
	 * Sets the approve status of this researcher.
	 *
	 * @param approveStatus the approve status of this researcher
	 */
	public void setApproveStatus(int approveStatus);

	/**
	 * Returns the researcher user ID of this researcher.
	 *
	 * @return the researcher user ID of this researcher
	 */
	public long getResearcherUserId();

	/**
	 * Sets the researcher user ID of this researcher.
	 *
	 * @param researcherUserId the researcher user ID of this researcher
	 */
	public void setResearcherUserId(long researcherUserId);

	/**
	 * Returns the researcher user uuid of this researcher.
	 *
	 * @return the researcher user uuid of this researcher
	 */
	public String getResearcherUserUuid();

	/**
	 * Sets the researcher user uuid of this researcher.
	 *
	 * @param researcherUserUuid the researcher user uuid of this researcher
	 */
	public void setResearcherUserUuid(String researcherUserUuid);

	/**
	 * Returns <code>true</code> if this researcher is approved.
	 *
	 * @return <code>true</code> if this researcher is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this researcher is denied.
	 *
	 * @return <code>true</code> if this researcher is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this researcher is a draft.
	 *
	 * @return <code>true</code> if this researcher is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this researcher is expired.
	 *
	 * @return <code>true</code> if this researcher is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this researcher is inactive.
	 *
	 * @return <code>true</code> if this researcher is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this researcher is incomplete.
	 *
	 * @return <code>true</code> if this researcher is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this researcher is pending.
	 *
	 * @return <code>true</code> if this researcher is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this researcher is scheduled.
	 *
	 * @return <code>true</code> if this researcher is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}