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

import ecrf.user.model.Researcher;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Researcher in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class ResearcherCacheModel
	implements CacheModel<Researcher>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ResearcherCacheModel)) {
			return false;
		}

		ResearcherCacheModel researcherCacheModel =
			(ResearcherCacheModel)object;

		if ((researcherId == researcherCacheModel.researcherId) &&
			(mvccVersion == researcherCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, researcherId);

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
		StringBundler sb = new StringBundler(43);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", researcherId=");
		sb.append(researcherId);
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
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", institution=");
		sb.append(institution);
		sb.append(", officeContact=");
		sb.append(officeContact);
		sb.append(", position=");
		sb.append(position);
		sb.append(", approveStatus=");
		sb.append(approveStatus);
		sb.append(", researcherUserId=");
		sb.append(researcherUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Researcher toEntityModel() {
		ResearcherImpl researcherImpl = new ResearcherImpl();

		researcherImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			researcherImpl.setUuid("");
		}
		else {
			researcherImpl.setUuid(uuid);
		}

		researcherImpl.setResearcherId(researcherId);
		researcherImpl.setGroupId(groupId);
		researcherImpl.setCompanyId(companyId);
		researcherImpl.setCreateUserId(createUserId);

		if (createUserName == null) {
			researcherImpl.setCreateUserName("");
		}
		else {
			researcherImpl.setCreateUserName(createUserName);
		}

		if (createDate == Long.MIN_VALUE) {
			researcherImpl.setCreateDate(null);
		}
		else {
			researcherImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			researcherImpl.setModifiedDate(null);
		}
		else {
			researcherImpl.setModifiedDate(new Date(modifiedDate));
		}

		researcherImpl.setStatus(status);
		researcherImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			researcherImpl.setStatusByUserName("");
		}
		else {
			researcherImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			researcherImpl.setStatusDate(null);
		}
		else {
			researcherImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			researcherImpl.setName("");
		}
		else {
			researcherImpl.setName(name);
		}

		if (birth == Long.MIN_VALUE) {
			researcherImpl.setBirth(null);
		}
		else {
			researcherImpl.setBirth(new Date(birth));
		}

		if (phone == null) {
			researcherImpl.setPhone("");
		}
		else {
			researcherImpl.setPhone(phone);
		}

		if (institution == null) {
			researcherImpl.setInstitution("");
		}
		else {
			researcherImpl.setInstitution(institution);
		}

		if (officeContact == null) {
			researcherImpl.setOfficeContact("");
		}
		else {
			researcherImpl.setOfficeContact(officeContact);
		}

		if (position == null) {
			researcherImpl.setPosition("");
		}
		else {
			researcherImpl.setPosition(position);
		}

		researcherImpl.setApproveStatus(approveStatus);
		researcherImpl.setResearcherUserId(researcherUserId);

		researcherImpl.resetOriginalValues();

		return researcherImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		researcherId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		createUserId = objectInput.readLong();
		createUserName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		name = objectInput.readUTF();
		birth = objectInput.readLong();
		phone = objectInput.readUTF();
		institution = objectInput.readUTF();
		officeContact = objectInput.readUTF();
		position = objectInput.readUTF();

		approveStatus = objectInput.readInt();

		researcherUserId = objectInput.readLong();
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

		objectOutput.writeLong(researcherId);

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

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (institution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(institution);
		}

		if (officeContact == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officeContact);
		}

		if (position == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(position);
		}

		objectOutput.writeInt(approveStatus);

		objectOutput.writeLong(researcherUserId);
	}

	public long mvccVersion;
	public String uuid;
	public long researcherId;
	public long groupId;
	public long companyId;
	public long createUserId;
	public String createUserName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String name;
	public long birth;
	public String phone;
	public String institution;
	public String officeContact;
	public String position;
	public int approveStatus;
	public long researcherUserId;

}