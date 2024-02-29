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

import ecrf.user.model.CRFSearchLog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CRFSearchLog in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFSearchLogCacheModel
	implements CacheModel<CRFSearchLog>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CRFSearchLogCacheModel)) {
			return false;
		}

		CRFSearchLogCacheModel crfSearchLogCacheModel =
			(CRFSearchLogCacheModel)object;

		if ((searchLogId == crfSearchLogCacheModel.searchLogId) &&
			(mvccVersion == crfSearchLogCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, searchLogId);

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
		StringBundler sb = new StringBundler(21);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", searchLogId=");
		sb.append(searchLogId);
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
		sb.append(", searchLog=");
		sb.append(searchLog);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CRFSearchLog toEntityModel() {
		CRFSearchLogImpl crfSearchLogImpl = new CRFSearchLogImpl();

		crfSearchLogImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			crfSearchLogImpl.setUuid("");
		}
		else {
			crfSearchLogImpl.setUuid(uuid);
		}

		crfSearchLogImpl.setSearchLogId(searchLogId);
		crfSearchLogImpl.setGroupId(groupId);
		crfSearchLogImpl.setCompanyId(companyId);
		crfSearchLogImpl.setUserId(userId);

		if (userName == null) {
			crfSearchLogImpl.setUserName("");
		}
		else {
			crfSearchLogImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			crfSearchLogImpl.setCreateDate(null);
		}
		else {
			crfSearchLogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			crfSearchLogImpl.setModifiedDate(null);
		}
		else {
			crfSearchLogImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (searchLog == null) {
			crfSearchLogImpl.setSearchLog("");
		}
		else {
			crfSearchLogImpl.setSearchLog(searchLog);
		}

		crfSearchLogImpl.resetOriginalValues();

		return crfSearchLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		searchLogId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		searchLog = objectInput.readUTF();
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

		objectOutput.writeLong(searchLogId);

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

		if (searchLog == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(searchLog);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long searchLogId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String searchLog;

}