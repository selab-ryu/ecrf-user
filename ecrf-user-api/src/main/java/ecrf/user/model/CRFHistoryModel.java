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
 * The base model interface for the CRFHistory service. Represents a row in the &quot;EC_CRFHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>ecrf.user.model.impl.CRFHistoryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>ecrf.user.model.impl.CRFHistoryImpl</code>.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFHistory
 * @generated
 */
@ProviderType
public interface CRFHistoryModel
	extends BaseModel<CRFHistory>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a crf history model instance should use the {@link CRFHistory} interface instead.
	 */

	/**
	 * Returns the primary key of this crf history.
	 *
	 * @return the primary key of this crf history
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this crf history.
	 *
	 * @param primaryKey the primary key of this crf history
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this crf history.
	 *
	 * @return the mvcc version of this crf history
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this crf history.
	 *
	 * @param mvccVersion the mvcc version of this crf history
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this crf history.
	 *
	 * @return the uuid of this crf history
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this crf history.
	 *
	 * @param uuid the uuid of this crf history
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the history ID of this crf history.
	 *
	 * @return the history ID of this crf history
	 */
	public long getHistoryId();

	/**
	 * Sets the history ID of this crf history.
	 *
	 * @param historyId the history ID of this crf history
	 */
	public void setHistoryId(long historyId);

	/**
	 * Returns the group ID of this crf history.
	 *
	 * @return the group ID of this crf history
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this crf history.
	 *
	 * @param groupId the group ID of this crf history
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this crf history.
	 *
	 * @return the company ID of this crf history
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this crf history.
	 *
	 * @param companyId the company ID of this crf history
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this crf history.
	 *
	 * @return the user ID of this crf history
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this crf history.
	 *
	 * @param userId the user ID of this crf history
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this crf history.
	 *
	 * @return the user uuid of this crf history
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this crf history.
	 *
	 * @param userUuid the user uuid of this crf history
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this crf history.
	 *
	 * @return the user name of this crf history
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this crf history.
	 *
	 * @param userName the user name of this crf history
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this crf history.
	 *
	 * @return the create date of this crf history
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this crf history.
	 *
	 * @param createDate the create date of this crf history
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this crf history.
	 *
	 * @return the modified date of this crf history
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this crf history.
	 *
	 * @param modifiedDate the modified date of this crf history
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this crf history.
	 *
	 * @return the status of this crf history
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this crf history.
	 *
	 * @param status the status of this crf history
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this crf history.
	 *
	 * @return the status by user ID of this crf history
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this crf history.
	 *
	 * @param statusByUserId the status by user ID of this crf history
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this crf history.
	 *
	 * @return the status by user uuid of this crf history
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this crf history.
	 *
	 * @param statusByUserUuid the status by user uuid of this crf history
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this crf history.
	 *
	 * @return the status by user name of this crf history
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this crf history.
	 *
	 * @param statusByUserName the status by user name of this crf history
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this crf history.
	 *
	 * @return the status date of this crf history
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this crf history.
	 *
	 * @param statusDate the status date of this crf history
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the subject ID of this crf history.
	 *
	 * @return the subject ID of this crf history
	 */
	public long getSubjectId();

	/**
	 * Sets the subject ID of this crf history.
	 *
	 * @param subjectId the subject ID of this crf history
	 */
	public void setSubjectId(long subjectId);

	/**
	 * Returns the subject name of this crf history.
	 *
	 * @return the subject name of this crf history
	 */
	@AutoEscape
	public String getSubjectName();

	/**
	 * Sets the subject name of this crf history.
	 *
	 * @param subjectName the subject name of this crf history
	 */
	public void setSubjectName(String subjectName);

	/**
	 * Returns the serial ID of this crf history.
	 *
	 * @return the serial ID of this crf history
	 */
	@AutoEscape
	public String getSerialId();

	/**
	 * Sets the serial ID of this crf history.
	 *
	 * @param serialId the serial ID of this crf history
	 */
	public void setSerialId(String serialId);

	/**
	 * Returns the crf ID of this crf history.
	 *
	 * @return the crf ID of this crf history
	 */
	public long getCrfId();

	/**
	 * Sets the crf ID of this crf history.
	 *
	 * @param crfId the crf ID of this crf history
	 */
	public void setCrfId(long crfId);

	/**
	 * Returns the structured data ID of this crf history.
	 *
	 * @return the structured data ID of this crf history
	 */
	public long getStructuredDataId();

	/**
	 * Sets the structured data ID of this crf history.
	 *
	 * @param structuredDataId the structured data ID of this crf history
	 */
	public void setStructuredDataId(long structuredDataId);

	/**
	 * Returns the action type of this crf history.
	 *
	 * @return the action type of this crf history
	 */
	public int getActionType();

	/**
	 * Sets the action type of this crf history.
	 *
	 * @param actionType the action type of this crf history
	 */
	public void setActionType(int actionType);

	/**
	 * Returns the previous json of this crf history.
	 *
	 * @return the previous json of this crf history
	 */
	@AutoEscape
	public String getPreviousJSON();

	/**
	 * Sets the previous json of this crf history.
	 *
	 * @param previousJSON the previous json of this crf history
	 */
	public void setPreviousJSON(String previousJSON);

	/**
	 * Returns the current json of this crf history.
	 *
	 * @return the current json of this crf history
	 */
	@AutoEscape
	public String getCurrentJSON();

	/**
	 * Sets the current json of this crf history.
	 *
	 * @param currentJSON the current json of this crf history
	 */
	public void setCurrentJSON(String currentJSON);

	/**
	 * Returns the history version of this crf history.
	 *
	 * @return the history version of this crf history
	 */
	@AutoEscape
	public String getHistoryVersion();

	/**
	 * Sets the history version of this crf history.
	 *
	 * @param historyVersion the history version of this crf history
	 */
	public void setHistoryVersion(String historyVersion);

	/**
	 * Returns the previous history version of this crf history.
	 *
	 * @return the previous history version of this crf history
	 */
	@AutoEscape
	public String getPreviousHistoryVersion();

	/**
	 * Sets the previous history version of this crf history.
	 *
	 * @param previousHistoryVersion the previous history version of this crf history
	 */
	public void setPreviousHistoryVersion(String previousHistoryVersion);

	/**
	 * Returns <code>true</code> if this crf history is approved.
	 *
	 * @return <code>true</code> if this crf history is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this crf history is denied.
	 *
	 * @return <code>true</code> if this crf history is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this crf history is a draft.
	 *
	 * @return <code>true</code> if this crf history is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this crf history is expired.
	 *
	 * @return <code>true</code> if this crf history is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this crf history is inactive.
	 *
	 * @return <code>true</code> if this crf history is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this crf history is incomplete.
	 *
	 * @return <code>true</code> if this crf history is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this crf history is pending.
	 *
	 * @return <code>true</code> if this crf history is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this crf history is scheduled.
	 *
	 * @return <code>true</code> if this crf history is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}