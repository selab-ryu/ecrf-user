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

import ecrf.user.model.CRFHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CRFHistory in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFHistoryCacheModel
	implements CacheModel<CRFHistory>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CRFHistoryCacheModel)) {
			return false;
		}

		CRFHistoryCacheModel crfHistoryCacheModel =
			(CRFHistoryCacheModel)object;

		if ((historyId == crfHistoryCacheModel.historyId) &&
			(mvccVersion == crfHistoryCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, historyId);

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
		sb.append(", historyId=");
		sb.append(historyId);
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
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append(", subjectName=");
		sb.append(subjectName);
		sb.append(", serialId=");
		sb.append(serialId);
		sb.append(", crfId=");
		sb.append(crfId);
		sb.append(", structuredDataId=");
		sb.append(structuredDataId);
		sb.append(", actionType=");
		sb.append(actionType);
		sb.append(", previousJSON=");
		sb.append(previousJSON);
		sb.append(", currentJSON=");
		sb.append(currentJSON);
		sb.append(", historyVersion=");
		sb.append(historyVersion);
		sb.append(", previousHistoryVersion=");
		sb.append(previousHistoryVersion);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CRFHistory toEntityModel() {
		CRFHistoryImpl crfHistoryImpl = new CRFHistoryImpl();

		crfHistoryImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			crfHistoryImpl.setUuid("");
		}
		else {
			crfHistoryImpl.setUuid(uuid);
		}

		crfHistoryImpl.setHistoryId(historyId);
		crfHistoryImpl.setGroupId(groupId);
		crfHistoryImpl.setCompanyId(companyId);
		crfHistoryImpl.setUserId(userId);

		if (userName == null) {
			crfHistoryImpl.setUserName("");
		}
		else {
			crfHistoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			crfHistoryImpl.setCreateDate(null);
		}
		else {
			crfHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			crfHistoryImpl.setModifiedDate(null);
		}
		else {
			crfHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		crfHistoryImpl.setStatus(status);
		crfHistoryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			crfHistoryImpl.setStatusByUserName("");
		}
		else {
			crfHistoryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			crfHistoryImpl.setStatusDate(null);
		}
		else {
			crfHistoryImpl.setStatusDate(new Date(statusDate));
		}

		crfHistoryImpl.setSubjectId(subjectId);

		if (subjectName == null) {
			crfHistoryImpl.setSubjectName("");
		}
		else {
			crfHistoryImpl.setSubjectName(subjectName);
		}

		if (serialId == null) {
			crfHistoryImpl.setSerialId("");
		}
		else {
			crfHistoryImpl.setSerialId(serialId);
		}

		crfHistoryImpl.setCrfId(crfId);
		crfHistoryImpl.setStructuredDataId(structuredDataId);
		crfHistoryImpl.setActionType(actionType);

		if (previousJSON == null) {
			crfHistoryImpl.setPreviousJSON("");
		}
		else {
			crfHistoryImpl.setPreviousJSON(previousJSON);
		}

		if (currentJSON == null) {
			crfHistoryImpl.setCurrentJSON("");
		}
		else {
			crfHistoryImpl.setCurrentJSON(currentJSON);
		}

		if (historyVersion == null) {
			crfHistoryImpl.setHistoryVersion("");
		}
		else {
			crfHistoryImpl.setHistoryVersion(historyVersion);
		}

		if (previousHistoryVersion == null) {
			crfHistoryImpl.setPreviousHistoryVersion("");
		}
		else {
			crfHistoryImpl.setPreviousHistoryVersion(previousHistoryVersion);
		}

		crfHistoryImpl.resetOriginalValues();

		return crfHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		historyId = objectInput.readLong();

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

		subjectId = objectInput.readLong();
		subjectName = objectInput.readUTF();
		serialId = objectInput.readUTF();

		crfId = objectInput.readLong();

		structuredDataId = objectInput.readLong();

		actionType = objectInput.readInt();
		previousJSON = objectInput.readUTF();
		currentJSON = objectInput.readUTF();
		historyVersion = objectInput.readUTF();
		previousHistoryVersion = objectInput.readUTF();
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

		objectOutput.writeLong(historyId);

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

		objectOutput.writeLong(subjectId);

		if (subjectName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subjectName);
		}

		if (serialId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serialId);
		}

		objectOutput.writeLong(crfId);

		objectOutput.writeLong(structuredDataId);

		objectOutput.writeInt(actionType);

		if (previousJSON == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(previousJSON);
		}

		if (currentJSON == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentJSON);
		}

		if (historyVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(historyVersion);
		}

		if (previousHistoryVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(previousHistoryVersion);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long historyId;
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
	public long subjectId;
	public String subjectName;
	public String serialId;
	public long crfId;
	public long structuredDataId;
	public int actionType;
	public String previousJSON;
	public String currentJSON;
	public String historyVersion;
	public String previousHistoryVersion;

}