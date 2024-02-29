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

import ecrf.user.model.CRFAutoquery;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CRFAutoquery in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFAutoqueryCacheModel
	implements CacheModel<CRFAutoquery>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CRFAutoqueryCacheModel)) {
			return false;
		}

		CRFAutoqueryCacheModel crfAutoqueryCacheModel =
			(CRFAutoqueryCacheModel)object;

		if ((autoQueryId == crfAutoqueryCacheModel.autoQueryId) &&
			(mvccVersion == crfAutoqueryCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, autoQueryId);

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
		StringBundler sb = new StringBundler(51);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", autoQueryId=");
		sb.append(autoQueryId);
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
		sb.append(", crfId=");
		sb.append(crfId);
		sb.append(", queryTermId=");
		sb.append(queryTermId);
		sb.append(", queryTermName=");
		sb.append(queryTermName);
		sb.append(", queryValue=");
		sb.append(queryValue);
		sb.append(", queryPreviousValue=");
		sb.append(queryPreviousValue);
		sb.append(", queryType=");
		sb.append(queryType);
		sb.append(", queryComment=");
		sb.append(queryComment);
		sb.append(", queryComfirm=");
		sb.append(queryComfirm);
		sb.append(", queryComfirmUserId=");
		sb.append(queryComfirmUserId);
		sb.append(", queryComfirmUserName=");
		sb.append(queryComfirmUserName);
		sb.append(", queryComfirmDate=");
		sb.append(queryComfirmDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CRFAutoquery toEntityModel() {
		CRFAutoqueryImpl crfAutoqueryImpl = new CRFAutoqueryImpl();

		crfAutoqueryImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			crfAutoqueryImpl.setUuid("");
		}
		else {
			crfAutoqueryImpl.setUuid(uuid);
		}

		crfAutoqueryImpl.setAutoQueryId(autoQueryId);
		crfAutoqueryImpl.setGroupId(groupId);
		crfAutoqueryImpl.setCompanyId(companyId);
		crfAutoqueryImpl.setUserId(userId);

		if (userName == null) {
			crfAutoqueryImpl.setUserName("");
		}
		else {
			crfAutoqueryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			crfAutoqueryImpl.setCreateDate(null);
		}
		else {
			crfAutoqueryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			crfAutoqueryImpl.setModifiedDate(null);
		}
		else {
			crfAutoqueryImpl.setModifiedDate(new Date(modifiedDate));
		}

		crfAutoqueryImpl.setStatus(status);
		crfAutoqueryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			crfAutoqueryImpl.setStatusByUserName("");
		}
		else {
			crfAutoqueryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			crfAutoqueryImpl.setStatusDate(null);
		}
		else {
			crfAutoqueryImpl.setStatusDate(new Date(statusDate));
		}

		crfAutoqueryImpl.setSubjectId(subjectId);
		crfAutoqueryImpl.setCrfId(crfId);
		crfAutoqueryImpl.setQueryTermId(queryTermId);

		if (queryTermName == null) {
			crfAutoqueryImpl.setQueryTermName("");
		}
		else {
			crfAutoqueryImpl.setQueryTermName(queryTermName);
		}

		if (queryValue == null) {
			crfAutoqueryImpl.setQueryValue("");
		}
		else {
			crfAutoqueryImpl.setQueryValue(queryValue);
		}

		if (queryPreviousValue == null) {
			crfAutoqueryImpl.setQueryPreviousValue("");
		}
		else {
			crfAutoqueryImpl.setQueryPreviousValue(queryPreviousValue);
		}

		crfAutoqueryImpl.setQueryType(queryType);

		if (queryComment == null) {
			crfAutoqueryImpl.setQueryComment("");
		}
		else {
			crfAutoqueryImpl.setQueryComment(queryComment);
		}

		crfAutoqueryImpl.setQueryComfirm(queryComfirm);
		crfAutoqueryImpl.setQueryComfirmUserId(queryComfirmUserId);

		if (queryComfirmUserName == null) {
			crfAutoqueryImpl.setQueryComfirmUserName("");
		}
		else {
			crfAutoqueryImpl.setQueryComfirmUserName(queryComfirmUserName);
		}

		if (queryComfirmDate == Long.MIN_VALUE) {
			crfAutoqueryImpl.setQueryComfirmDate(null);
		}
		else {
			crfAutoqueryImpl.setQueryComfirmDate(new Date(queryComfirmDate));
		}

		crfAutoqueryImpl.resetOriginalValues();

		return crfAutoqueryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		autoQueryId = objectInput.readLong();

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

		crfId = objectInput.readLong();

		queryTermId = objectInput.readLong();
		queryTermName = objectInput.readUTF();
		queryValue = objectInput.readUTF();
		queryPreviousValue = objectInput.readUTF();

		queryType = objectInput.readInt();
		queryComment = objectInput.readUTF();

		queryComfirm = objectInput.readInt();

		queryComfirmUserId = objectInput.readLong();
		queryComfirmUserName = objectInput.readUTF();
		queryComfirmDate = objectInput.readLong();
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

		objectOutput.writeLong(autoQueryId);

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

		objectOutput.writeLong(crfId);

		objectOutput.writeLong(queryTermId);

		if (queryTermName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(queryTermName);
		}

		if (queryValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(queryValue);
		}

		if (queryPreviousValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(queryPreviousValue);
		}

		objectOutput.writeInt(queryType);

		if (queryComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(queryComment);
		}

		objectOutput.writeInt(queryComfirm);

		objectOutput.writeLong(queryComfirmUserId);

		if (queryComfirmUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(queryComfirmUserName);
		}

		objectOutput.writeLong(queryComfirmDate);
	}

	public long mvccVersion;
	public String uuid;
	public long autoQueryId;
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
	public long crfId;
	public long queryTermId;
	public String queryTermName;
	public String queryValue;
	public String queryPreviousValue;
	public int queryType;
	public String queryComment;
	public int queryComfirm;
	public long queryComfirmUserId;
	public String queryComfirmUserName;
	public long queryComfirmDate;

}