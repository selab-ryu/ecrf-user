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

import ecrf.user.model.CRFPatient;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CRFPatient in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CRFPatientCacheModel
	implements CacheModel<CRFPatient>, Externalizable {

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

		if (crfPatientId == crfPatientCacheModel.crfPatientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, crfPatientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", crfPatientId=");
		sb.append(crfPatientId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", createUserName=");
		sb.append(createUserName);
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

		if (uuid == null) {
			crfPatientImpl.setUuid("");
		}
		else {
			crfPatientImpl.setUuid(uuid);
		}

		crfPatientImpl.setCrfPatientId(crfPatientId);
		crfPatientImpl.setGroupId(groupId);
		crfPatientImpl.setCompanyId(companyId);
		crfPatientImpl.setCreateUserId(createUserId);

		if (createUserName == null) {
			crfPatientImpl.setCreateUserName("");
		}
		else {
			crfPatientImpl.setCreateUserName(createUserName);
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
		uuid = objectInput.readUTF();

		crfPatientId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		createUserId = objectInput.readLong();
		createUserName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		crfId = objectInput.readLong();

		patientId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(crfPatientId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createUserId);

		if (createUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createUserName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(crfId);

		objectOutput.writeLong(patientId);
	}

	public String uuid;
	public long crfPatientId;
	public long groupId;
	public long companyId;
	public long createUserId;
	public String createUserName;
	public long createDate;
	public long modifiedDate;
	public long crfId;
	public long patientId;

}