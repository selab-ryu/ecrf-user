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

import ecrf.user.model.Subject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subject in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class SubjectCacheModel
	implements CacheModel<Subject>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubjectCacheModel)) {
			return false;
		}

		SubjectCacheModel subjectCacheModel = (SubjectCacheModel)object;

		if ((subjectId == subjectCacheModel.subjectId) &&
			(mvccVersion == subjectCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, subjectId);

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
		StringBundler sb = new StringBundler(47);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", subjectId=");
		sb.append(subjectId);
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
		sb.append(", birth=");
		sb.append(birth);
		sb.append(", lunarBirth=");
		sb.append(lunarBirth);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", phone2=");
		sb.append(phone2);
		sb.append(", address=");
		sb.append(address);
		sb.append(", serialId=");
		sb.append(serialId);
		sb.append(", hospitalCode=");
		sb.append(hospitalCode);
		sb.append(", expGroupId=");
		sb.append(expGroupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subject toEntityModel() {
		SubjectImpl subjectImpl = new SubjectImpl();

		subjectImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			subjectImpl.setUuid("");
		}
		else {
			subjectImpl.setUuid(uuid);
		}

		subjectImpl.setSubjectId(subjectId);
		subjectImpl.setCompanyId(companyId);
		subjectImpl.setGroupId(groupId);
		subjectImpl.setUserId(userId);

		if (userName == null) {
			subjectImpl.setUserName("");
		}
		else {
			subjectImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			subjectImpl.setCreateDate(null);
		}
		else {
			subjectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subjectImpl.setModifiedDate(null);
		}
		else {
			subjectImpl.setModifiedDate(new Date(modifiedDate));
		}

		subjectImpl.setStatus(status);
		subjectImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			subjectImpl.setStatusByUserName("");
		}
		else {
			subjectImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			subjectImpl.setStatusDate(null);
		}
		else {
			subjectImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			subjectImpl.setName("");
		}
		else {
			subjectImpl.setName(name);
		}

		if (birth == Long.MIN_VALUE) {
			subjectImpl.setBirth(null);
		}
		else {
			subjectImpl.setBirth(new Date(birth));
		}

		if (lunarBirth == null) {
			subjectImpl.setLunarBirth("");
		}
		else {
			subjectImpl.setLunarBirth(lunarBirth);
		}

		subjectImpl.setGender(gender);

		if (phone == null) {
			subjectImpl.setPhone("");
		}
		else {
			subjectImpl.setPhone(phone);
		}

		if (phone2 == null) {
			subjectImpl.setPhone2("");
		}
		else {
			subjectImpl.setPhone2(phone2);
		}

		if (address == null) {
			subjectImpl.setAddress("");
		}
		else {
			subjectImpl.setAddress(address);
		}

		if (serialId == null) {
			subjectImpl.setSerialId("");
		}
		else {
			subjectImpl.setSerialId(serialId);
		}

		subjectImpl.setHospitalCode(hospitalCode);
		subjectImpl.setExpGroupId(expGroupId);

		subjectImpl.resetOriginalValues();

		return subjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		subjectId = objectInput.readLong();

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
		birth = objectInput.readLong();
		lunarBirth = objectInput.readUTF();

		gender = objectInput.readInt();
		phone = objectInput.readUTF();
		phone2 = objectInput.readUTF();
		address = objectInput.readUTF();
		serialId = objectInput.readUTF();

		hospitalCode = objectInput.readInt();

		expGroupId = objectInput.readLong();
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

		objectOutput.writeLong(subjectId);

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

		objectOutput.writeLong(birth);

		if (lunarBirth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lunarBirth);
		}

		objectOutput.writeInt(gender);

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (phone2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone2);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (serialId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serialId);
		}

		objectOutput.writeInt(hospitalCode);

		objectOutput.writeLong(expGroupId);
	}

	public long mvccVersion;
	public String uuid;
	public long subjectId;
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
	public long birth;
	public String lunarBirth;
	public int gender;
	public String phone;
	public String phone2;
	public String address;
	public String serialId;
	public int hospitalCode;
	public long expGroupId;

}