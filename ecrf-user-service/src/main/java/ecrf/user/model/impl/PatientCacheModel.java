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

import ecrf.user.model.Patient;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Patient in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class PatientCacheModel
	implements CacheModel<Patient>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PatientCacheModel)) {
			return false;
		}

		PatientCacheModel patientCacheModel = (PatientCacheModel)object;

		if ((patientId == patientCacheModel.patientId) &&
			(mvccVersion == patientCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, patientId);

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
		StringBundler sb = new StringBundler(59);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", patientId=");
		sb.append(patientId);
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
		sb.append(", position=");
		sb.append(position);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", phone2=");
		sb.append(phone2);
		sb.append(", serialId=");
		sb.append(serialId);
		sb.append(", hospitalCode=");
		sb.append(hospitalCode);
		sb.append(", visitDate=");
		sb.append(visitDate);
		sb.append(", consentDate=");
		sb.append(consentDate);
		sb.append(", participationStartDate=");
		sb.append(participationStartDate);
		sb.append(", participationStatus=");
		sb.append(participationStatus);
		sb.append(", experimentalGroup=");
		sb.append(experimentalGroup);
		sb.append(", hasCRF=");
		sb.append(hasCRF);
		sb.append(", hasCohortStudy=");
		sb.append(hasCohortStudy);
		sb.append(", hasMRIStudy=");
		sb.append(hasMRIStudy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Patient toEntityModel() {
		PatientImpl patientImpl = new PatientImpl();

		patientImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			patientImpl.setUuid("");
		}
		else {
			patientImpl.setUuid(uuid);
		}

		patientImpl.setPatientId(patientId);
		patientImpl.setCompanyId(companyId);
		patientImpl.setGroupId(groupId);
		patientImpl.setUserId(userId);

		if (userName == null) {
			patientImpl.setUserName("");
		}
		else {
			patientImpl.setUserName(userName);
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

		if (position == null) {
			patientImpl.setPosition("");
		}
		else {
			patientImpl.setPosition(position);
		}

		patientImpl.setGender(gender);

		if (phone == null) {
			patientImpl.setPhone("");
		}
		else {
			patientImpl.setPhone(phone);
		}

		if (phone2 == null) {
			patientImpl.setPhone2("");
		}
		else {
			patientImpl.setPhone2(phone2);
		}

		if (serialId == null) {
			patientImpl.setSerialId("");
		}
		else {
			patientImpl.setSerialId(serialId);
		}

		patientImpl.setHospitalCode(hospitalCode);

		if (visitDate == Long.MIN_VALUE) {
			patientImpl.setVisitDate(null);
		}
		else {
			patientImpl.setVisitDate(new Date(visitDate));
		}

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

		patientImpl.setHasCRF(hasCRF);
		patientImpl.setHasCohortStudy(hasCohortStudy);
		patientImpl.setHasMRIStudy(hasMRIStudy);

		patientImpl.resetOriginalValues();

		return patientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		patientId = objectInput.readLong();

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
		position = objectInput.readUTF();

		gender = objectInput.readInt();
		phone = objectInput.readUTF();
		phone2 = objectInput.readUTF();
		serialId = objectInput.readUTF();

		hospitalCode = objectInput.readInt();
		visitDate = objectInput.readLong();
		consentDate = objectInput.readLong();
		participationStartDate = objectInput.readLong();

		participationStatus = objectInput.readInt();
		experimentalGroup = objectInput.readUTF();

		hasCRF = objectInput.readBoolean();

		hasCohortStudy = objectInput.readBoolean();

		hasMRIStudy = objectInput.readBoolean();
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

		objectOutput.writeLong(patientId);

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

		if (position == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(position);
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

		if (serialId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serialId);
		}

		objectOutput.writeInt(hospitalCode);
		objectOutput.writeLong(visitDate);
		objectOutput.writeLong(consentDate);
		objectOutput.writeLong(participationStartDate);

		objectOutput.writeInt(participationStatus);

		if (experimentalGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(experimentalGroup);
		}

		objectOutput.writeBoolean(hasCRF);

		objectOutput.writeBoolean(hasCohortStudy);

		objectOutput.writeBoolean(hasMRIStudy);
	}

	public long mvccVersion;
	public String uuid;
	public long patientId;
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
	public String position;
	public int gender;
	public String phone;
	public String phone2;
	public String serialId;
	public int hospitalCode;
	public long visitDate;
	public long consentDate;
	public long participationStartDate;
	public int participationStatus;
	public String experimentalGroup;
	public boolean hasCRF;
	public boolean hasCohortStudy;
	public boolean hasMRIStudy;

}