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

import ecrf.user.model.ExperimentalGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExperimentalGroup in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class ExperimentalGroupCacheModel
	implements CacheModel<ExperimentalGroup>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExperimentalGroupCacheModel)) {
			return false;
		}

		ExperimentalGroupCacheModel experimentalGroupCacheModel =
			(ExperimentalGroupCacheModel)object;

		if ((experimentalGroupId ==
				experimentalGroupCacheModel.experimentalGroupId) &&
			(mvccVersion == experimentalGroupCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, experimentalGroupId);

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
		StringBundler sb = new StringBundler(35);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", experimentalGroupId=");
		sb.append(experimentalGroupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", abbr=");
		sb.append(abbr);
		sb.append(", description=");
		sb.append(description);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExperimentalGroup toEntityModel() {
		ExperimentalGroupImpl experimentalGroupImpl =
			new ExperimentalGroupImpl();

		experimentalGroupImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			experimentalGroupImpl.setUuid("");
		}
		else {
			experimentalGroupImpl.setUuid(uuid);
		}

		experimentalGroupImpl.setExperimentalGroupId(experimentalGroupId);
		experimentalGroupImpl.setCompanyId(companyId);
		experimentalGroupImpl.setGroupId(groupId);
		experimentalGroupImpl.setUserId(userId);

		if (userName == null) {
			experimentalGroupImpl.setUserName("");
		}
		else {
			experimentalGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			experimentalGroupImpl.setCreateDate(null);
		}
		else {
			experimentalGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			experimentalGroupImpl.setModifiedDate(null);
		}
		else {
			experimentalGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		experimentalGroupImpl.setStatus(status);
		experimentalGroupImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			experimentalGroupImpl.setStatusByUserName("");
		}
		else {
			experimentalGroupImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			experimentalGroupImpl.setStatusDate(null);
		}
		else {
			experimentalGroupImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			experimentalGroupImpl.setName("");
		}
		else {
			experimentalGroupImpl.setName(name);
		}

		if (abbr == null) {
			experimentalGroupImpl.setAbbr("");
		}
		else {
			experimentalGroupImpl.setAbbr(abbr);
		}

		if (description == null) {
			experimentalGroupImpl.setDescription("");
		}
		else {
			experimentalGroupImpl.setDescription(description);
		}

		experimentalGroupImpl.setType(type);

		experimentalGroupImpl.resetOriginalValues();

		return experimentalGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		experimentalGroupId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		name = objectInput.readUTF();
		abbr = objectInput.readUTF();
		description = objectInput.readUTF();

		type = objectInput.readInt();
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

		objectOutput.writeLong(experimentalGroupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (abbr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(abbr);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(type);
	}

	public long mvccVersion;
	public String uuid;
	public long experimentalGroupId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String name;
	public String abbr;
	public String description;
	public int type;

}