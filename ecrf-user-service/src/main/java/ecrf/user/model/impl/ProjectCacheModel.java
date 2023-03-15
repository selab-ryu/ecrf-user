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

package ecrf.user.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import ecrf.user.model.Project;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class ProjectCacheModel
	implements CacheModel<Project>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectCacheModel)) {
			return false;
		}

		ProjectCacheModel projectCacheModel = (ProjectCacheModel)object;

		if ((projectId == projectCacheModel.projectId) &&
			(mvccVersion == projectCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, projectId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", shortTitle=");
		sb.append(shortTitle);
		sb.append(", purpose=");
		sb.append(purpose);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", principalResearcherId=");
		sb.append(principalResearcherId);
		sb.append(", manageResearcherId=");
		sb.append(manageResearcherId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		projectImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			projectImpl.setUuid("");
		}
		else {
			projectImpl.setUuid(uuid);
		}

		projectImpl.setProjectId(projectId);
		projectImpl.setGroupId(groupId);
		projectImpl.setCompanyId(companyId);
		projectImpl.setUserId(userId);

		if (userName == null) {
			projectImpl.setUserName("");
		}
		else {
			projectImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			projectImpl.setCreateDate(null);
		}
		else {
			projectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectImpl.setModifiedDate(null);
		}
		else {
			projectImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectImpl.setStatus(status);
		projectImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			projectImpl.setStatusByUserName("");
		}
		else {
			projectImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			projectImpl.setStatusDate(null);
		}
		else {
			projectImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			projectImpl.setTitle("");
		}
		else {
			projectImpl.setTitle(title);
		}

		if (shortTitle == null) {
			projectImpl.setShortTitle("");
		}
		else {
			projectImpl.setShortTitle(shortTitle);
		}

		if (purpose == null) {
			projectImpl.setPurpose("");
		}
		else {
			projectImpl.setPurpose(purpose);
		}

		if (startDate == Long.MIN_VALUE) {
			projectImpl.setStartDate(null);
		}
		else {
			projectImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectImpl.setEndDate(null);
		}
		else {
			projectImpl.setEndDate(new Date(endDate));
		}

		projectImpl.setPrincipalResearcherId(principalResearcherId);
		projectImpl.setManageResearcherId(manageResearcherId);

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		projectId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		title = objectInput.readUTF();
		shortTitle = objectInput.readUTF();
		purpose = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		principalResearcherId = objectInput.readLong();

		manageResearcherId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (shortTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortTitle);
		}

		if (purpose == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(purpose);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeLong(principalResearcherId);

		objectOutput.writeLong(manageResearcherId);
	}

	public long mvccVersion;
	public String uuid;
	public long projectId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public String shortTitle;
	public String purpose;
	public long startDate;
	public long endDate;
	public long principalResearcherId;
	public long manageResearcherId;

}