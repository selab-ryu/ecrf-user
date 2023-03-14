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

import ecrf.user.model.Patient;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Patient in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PatientCacheModel implements CacheModel<Patient>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PatientCacheModel)) {
			return false;
		}

		PatientCacheModel patientCacheModel = (PatientCacheModel)object;

		if (patientId == patientCacheModel.patientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, patientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", patientId=");
		sb.append(patientId);
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
		sb.append(", position=");
		sb.append(position);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", consentDate=");
		sb.append(consentDate);
		sb.append(", participationStartDate=");
		sb.append(participationStartDate);
		sb.append(", participationStatus=");
		sb.append(participationStatus);
		sb.append(", experimentalGroup=");
		sb.append(experimentalGroup);
		sb.append(", patientUserId=");
		sb.append(patientUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Patient toEntityModel() {
		PatientImpl patientImpl = new PatientImpl();

		if (uuid == null) {
			patientImpl.setUuid("");
		}
		else {
			patientImpl.setUuid(uuid);
		}

		patientImpl.setPatientId(patientId);
		patientImpl.setGroupId(groupId);
		patientImpl.setCompanyId(companyId);
		patientImpl.setCreateUserId(createUserId);

		if (createUserName == null) {
			patientImpl.setCreateUserName("");
		}
		else {
			patientImpl.setCreateUserName(createUserName);
		}

		if (createDate == Long.MIN_VALUE) {
			patientImpl.setCreateDate(null);
		}
		else {
			patientImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			patientImpl.setModifiedDate(null);
		}
		else {
			patientImpl.setModifiedDate(new Date(modifiedDate));
		}

		patientImpl.setStatus(status);
		patientImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			patientImpl.setStatusByUserName("");
		}
		else {
			patientImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			patientImpl.setStatusDate(null);
		}
		else {
			patientImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			patientImpl.setName("");
		}
		else {
			patientImpl.setName(name);
		}

		if (birth == Long.MIN_VALUE) {
			patientImpl.setBirth(null);
		}
		else {
			patientImpl.setBirth(new Date(birth));
		}

		if (phone == null) {
			patientImpl.setPhone("");
		}
		else {
			patientImpl.setPhone(phone);
		}

		if (position == null) {
			patientImpl.setPosition("");
		}
		else {
			patientImpl.setPosition(position);
		}

		patientImpl.setGender(gender);

		if (consentDate == Long.MIN_VALUE) {
			patientImpl.setConsentDate(null);
		}
		else {
			patientImpl.setConsentDate(new Date(consentDate));
		}

		if (participationStartDate == Long.MIN_VALUE) {
			patientImpl.setParticipationStartDate(null);
		}
		else {
			patientImpl.setParticipationStartDate(
				new Date(participationStartDate));
		}

		patientImpl.setParticipationStatus(participationStatus);

		if (experimentalGroup == null) {
			patientImpl.setExperimentalGroup("");
		}
		else {
			patientImpl.setExperimentalGroup(experimentalGroup);
		}

		patientImpl.setPatientUserId(patientUserId);

		patientImpl.resetOriginalValues();

		return patientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		patientId = objectInput.readLong();

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
		position = objectInput.readUTF();

		gender = objectInput.readInt();
		consentDate = objectInput.readLong();
		participationStartDate = objectInput.readLong();

		participationStatus = objectInput.readInt();
		experimentalGroup = objectInput.readUTF();

		patientUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(patientId);

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

		if (position == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(position);
		}

		objectOutput.writeInt(gender);
		objectOutput.writeLong(consentDate);
		objectOutput.writeLong(participationStartDate);

		objectOutput.writeInt(participationStatus);

		if (experimentalGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(experimentalGroup);
		}

		objectOutput.writeLong(patientUserId);
	}

	public String uuid;
	public long patientId;
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
	public String position;
	public int gender;
	public long consentDate;
	public long participationStartDate;
	public int participationStatus;
	public String experimentalGroup;
	public long patientUserId;

}