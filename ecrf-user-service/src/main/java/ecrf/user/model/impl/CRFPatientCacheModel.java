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

import ecrf.user.model.CRFPatient;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CRFPatient in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFPatientCacheModel
	implements CacheModel<CRFPatient>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CRFPatientCacheModel)) {
			return false;
		}

		CRFPatientCacheModel crfPatientCacheModel =
			(CRFPatientCacheModel)object;

		if ((crfPatientId == crfPatientCacheModel.crfPatientId) &&
			(mvccVersion == crfPatientCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, crfPatientId);

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
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", crfPatientId=");
		sb.append(crfPatientId);
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
		sb.append(", crfId=");
		sb.append(crfId);
		sb.append(", patientId=");
		sb.append(patientId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CRFPatient toEntityModel() {
		CRFPatientImpl crfPatientImpl = new CRFPatientImpl();

		crfPatientImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			crfPatientImpl.setUuid("");
		}
		else {
			crfPatientImpl.setUuid(uuid);
		}

		crfPatientImpl.setCrfPatientId(crfPatientId);
		crfPatientImpl.setGroupId(groupId);
		crfPatientImpl.setCompanyId(companyId);
		crfPatientImpl.setUserId(userId);

		if (userName == null) {
			crfPatientImpl.setUserName("");
		}
		else {
			crfPatientImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			crfPatientImpl.setCreateDate(null);
		}
		else {
			crfPatientImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			crfPatientImpl.setModifiedDate(null);
		}
		else {
			crfPatientImpl.setModifiedDate(new Date(modifiedDate));
		}

		crfPatientImpl.setCrfId(crfId);
		crfPatientImpl.setPatientId(patientId);

		crfPatientImpl.resetOriginalValues();

		return crfPatientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		crfPatientId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		crfId = objectInput.readLong();

		patientId = objectInput.readLong();
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

		objectOutput.writeLong(crfPatientId);

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

		objectOutput.writeLong(crfId);

		objectOutput.writeLong(patientId);
	}

	public long mvccVersion;
	public String uuid;
	public long crfPatientId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long crfId;
	public long patientId;

}