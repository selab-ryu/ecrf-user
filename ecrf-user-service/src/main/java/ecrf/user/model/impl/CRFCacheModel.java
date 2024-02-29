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

import ecrf.user.model.CRF;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CRF in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFCacheModel
	implements CacheModel<CRF>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CRFCacheModel)) {
			return false;
		}

		CRFCacheModel crfCacheModel = (CRFCacheModel)object;

		if ((crfId == crfCacheModel.crfId) &&
			(mvccVersion == crfCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, crfId);

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
		StringBundler sb = new StringBundler(33);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", crfId=");
		sb.append(crfId);
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
		sb.append(", datatypeId=");
		sb.append(datatypeId);
		sb.append(", crfStatus=");
		sb.append(crfStatus);
		sb.append(", applyDate=");
		sb.append(applyDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CRF toEntityModel() {
		CRFImpl crfImpl = new CRFImpl();

		crfImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			crfImpl.setUuid("");
		}
		else {
			crfImpl.setUuid(uuid);
		}

		crfImpl.setCrfId(crfId);
		crfImpl.setGroupId(groupId);
		crfImpl.setCompanyId(companyId);
		crfImpl.setUserId(userId);

		if (userName == null) {
			crfImpl.setUserName("");
		}
		else {
			crfImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			crfImpl.setCreateDate(null);
		}
		else {
			crfImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			crfImpl.setModifiedDate(null);
		}
		else {
			crfImpl.setModifiedDate(new Date(modifiedDate));
		}

		crfImpl.setStatus(status);
		crfImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			crfImpl.setStatusByUserName("");
		}
		else {
			crfImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			crfImpl.setStatusDate(null);
		}
		else {
			crfImpl.setStatusDate(new Date(statusDate));
		}

		crfImpl.setDatatypeId(datatypeId);
		crfImpl.setCrfStatus(crfStatus);

		if (applyDate == Long.MIN_VALUE) {
			crfImpl.setApplyDate(null);
		}
		else {
			crfImpl.setApplyDate(new Date(applyDate));
		}

		crfImpl.resetOriginalValues();

		return crfImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		crfId = objectInput.readLong();

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

		datatypeId = objectInput.readLong();

		crfStatus = objectInput.readInt();
		applyDate = objectInput.readLong();
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

		objectOutput.writeLong(crfId);

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

		objectOutput.writeLong(datatypeId);

		objectOutput.writeInt(crfStatus);
		objectOutput.writeLong(applyDate);
	}

	public long mvccVersion;
	public String uuid;
	public long crfId;
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
	public long datatypeId;
	public int crfStatus;
	public long applyDate;

}