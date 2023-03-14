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
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CRFResearcher service. Represents a row in the &quot;EC_CRFResearcher&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>ecrf.user.model.impl.CRFResearcherModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>ecrf.user.model.impl.CRFResearcherImpl</code>.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFResearcher
 * @generated
 */
@ProviderType
public interface CRFResearcherModel
	extends BaseModel<CRFResearcher>, MVCCModel, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a crf researcher model instance should use the {@link CRFResearcher} interface instead.
	 */

	/**
	 * Returns the primary key of this crf researcher.
	 *
	 * @return the primary key of this crf researcher
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this crf researcher.
	 *
	 * @param primaryKey the primary key of this crf researcher
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this crf researcher.
	 *
	 * @return the mvcc version of this crf researcher
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this crf researcher.
	 *
	 * @param mvccVersion the mvcc version of this crf researcher
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this crf researcher.
	 *
	 * @return the uuid of this crf researcher
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this crf researcher.
	 *
	 * @param uuid the uuid of this crf researcher
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the crf researcher ID of this crf researcher.
	 *
	 * @return the crf researcher ID of this crf researcher
	 */
	public long getCrfResearcherId();

	/**
	 * Sets the crf researcher ID of this crf researcher.
	 *
	 * @param crfResearcherId the crf researcher ID of this crf researcher
	 */
	public void setCrfResearcherId(long crfResearcherId);

	/**
	 * Returns the group ID of this crf researcher.
	 *
	 * @return the group ID of this crf researcher
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this crf researcher.
	 *
	 * @param groupId the group ID of this crf researcher
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this crf researcher.
	 *
	 * @return the company ID of this crf researcher
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this crf researcher.
	 *
	 * @param companyId the company ID of this crf researcher
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create user ID of this crf researcher.
	 *
	 * @return the create user ID of this crf researcher
	 */
	public long getCreateUserId();

	/**
	 * Sets the create user ID of this crf researcher.
	 *
	 * @param createUserId the create user ID of this crf researcher
	 */
	public void setCreateUserId(long createUserId);

	/**
	 * Returns the create user uuid of this crf researcher.
	 *
	 * @return the create user uuid of this crf researcher
	 */
	public String getCreateUserUuid();

	/**
	 * Sets the create user uuid of this crf researcher.
	 *
	 * @param createUserUuid the create user uuid of this crf researcher
	 */
	public void setCreateUserUuid(String createUserUuid);

	/**
	 * Returns the create user name of this crf researcher.
	 *
	 * @return the create user name of this crf researcher
	 */
	@AutoEscape
	public String getCreateUserName();

	/**
	 * Sets the create user name of this crf researcher.
	 *
	 * @param createUserName the create user name of this crf researcher
	 */
	public void setCreateUserName(String createUserName);

	/**
	 * Returns the create date of this crf researcher.
	 *
	 * @return the create date of this crf researcher
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this crf researcher.
	 *
	 * @param createDate the create date of this crf researcher
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this crf researcher.
	 *
	 * @return the modified date of this crf researcher
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this crf researcher.
	 *
	 * @param modifiedDate the modified date of this crf researcher
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the researcher ID of this crf researcher.
	 *
	 * @return the researcher ID of this crf researcher
	 */
	public long getResearcherId();

	/**
	 * Sets the researcher ID of this crf researcher.
	 *
	 * @param researcherId the researcher ID of this crf researcher
	 */
	public void setResearcherId(long researcherId);

	/**
	 * Returns the crf ID of this crf researcher.
	 *
	 * @return the crf ID of this crf researcher
	 */
	public long getCrfId();

	/**
	 * Sets the crf ID of this crf researcher.
	 *
	 * @param crfId the crf ID of this crf researcher
	 */
	public void setCrfId(long crfId);

}