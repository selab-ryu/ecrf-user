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

import ecrf.user.model.CRFSubject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CRFSubject in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFSubjectCacheModel
	implements CacheModel<CRFSubject>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CRFSubjectCacheModel)) {
			return false;
		}

		CRFSubjectCacheModel crfSubjectCacheModel =
			(CRFSubjectCacheModel)object;

		if ((crfSubjectId == crfSubjectCacheModel.crfSubjectId) &&
			(mvccVersion == crfSubjectCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, crfSubjectId);

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
		StringBundler sb = new StringBundler(31);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", crfSubjectId=");
		sb.append(crfSubjectId);
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
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append(", participationStatus=");
		sb.append(participationStatus);
		sb.append(", participationStartDate=");
		sb.append(participationStartDate);
		sb.append(", experimentalGroup=");
		sb.append(experimentalGroup);
		sb.append(", updateLock=");
		sb.append(updateLock);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CRFSubject toEntityModel() {
		CRFSubjectImpl crfSubjectImpl = new CRFSubjectImpl();

		crfSubjectImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			crfSubjectImpl.setUuid("");
		}
		else {
			crfSubjectImpl.setUuid(uuid);
		}

		crfSubjectImpl.setCrfSubjectId(crfSubjectId);
		crfSubjectImpl.setGroupId(groupId);
		crfSubjectImpl.setCompanyId(companyId);
		crfSubjectImpl.setUserId(userId);

		if (userName == null) {
			crfSubjectImpl.setUserName("");
		}
		else {
			crfSubjectImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			crfSubjectImpl.setCreateDate(null);
		}
		else {
			crfSubjectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			crfSubjectImpl.setModifiedDate(null);
		}
		else {
			crfSubjectImpl.setModifiedDate(new Date(modifiedDate));
		}

		crfSubjectImpl.setCrfId(crfId);
		crfSubjectImpl.setSubjectId(subjectId);
		crfSubjectImpl.setParticipationStatus(participationStatus);

		if (participationStartDate == Long.MIN_VALUE) {
			crfSubjectImpl.setParticipationStartDate(null);
		}
		else {
			crfSubjectImpl.setParticipationStartDate(
				new Date(participationStartDate));
		}

		if (experimentalGroup == null) {
			crfSubjectImpl.setExperimentalGroup("");
		}
		else {
			crfSubjectImpl.setExperimentalGroup(experimentalGroup);
		}

		crfSubjectImpl.setUpdateLock(updateLock);

		crfSubjectImpl.resetOriginalValues();

		return crfSubjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		crfSubjectId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		crfId = objectInput.readLong();

		subjectId = objectInput.readLong();

		participationStatus = objectInput.readInt();
		participationStartDate = objectInput.readLong();
		experimentalGroup = objectInput.readUTF();

		updateLock = objectInput.readBoolean();
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

		objectOutput.writeLong(crfSubjectId);

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

		objectOutput.writeLong(subjectId);

		objectOutput.writeInt(participationStatus);
		objectOutput.writeLong(participationStartDate);

		if (experimentalGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(experimentalGroup);
		}

		objectOutput.writeBoolean(updateLock);
	}

	public long mvccVersion;
	public String uuid;
	public long crfSubjectId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long crfId;
	public long subjectId;
	public int participationStatus;
	public long participationStartDate;
	public String experimentalGroup;
	public boolean updateLock;

}