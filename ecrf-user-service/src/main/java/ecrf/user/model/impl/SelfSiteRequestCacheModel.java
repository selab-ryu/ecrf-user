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

import ecrf.user.model.SelfSiteRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SelfSiteRequest in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class SelfSiteRequestCacheModel
	implements CacheModel<SelfSiteRequest>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SelfSiteRequestCacheModel)) {
			return false;
		}

		SelfSiteRequestCacheModel selfSiteRequestCacheModel =
			(SelfSiteRequestCacheModel)object;

		if ((selfSiteRequestId ==
				selfSiteRequestCacheModel.selfSiteRequestId) &&
			(mvccVersion == selfSiteRequestCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, selfSiteRequestId);

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
		sb.append(", selfSiteRequestId=");
		sb.append(selfSiteRequestId);
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
		sb.append(", email=");
		sb.append(email);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", projectTitle=");
		sb.append(projectTitle);
		sb.append(", projectDescription=");
		sb.append(projectDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SelfSiteRequest toEntityModel() {
		SelfSiteRequestImpl selfSiteRequestImpl = new SelfSiteRequestImpl();

		selfSiteRequestImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			selfSiteRequestImpl.setUuid("");
		}
		else {
			selfSiteRequestImpl.setUuid(uuid);
		}

		selfSiteRequestImpl.setSelfSiteRequestId(selfSiteRequestId);
		selfSiteRequestImpl.setGroupId(groupId);
		selfSiteRequestImpl.setCompanyId(companyId);
		selfSiteRequestImpl.setUserId(userId);

		if (userName == null) {
			selfSiteRequestImpl.setUserName("");
		}
		else {
			selfSiteRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			selfSiteRequestImpl.setCreateDate(null);
		}
		else {
			selfSiteRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			selfSiteRequestImpl.setModifiedDate(null);
		}
		else {
			selfSiteRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (email == null) {
			selfSiteRequestImpl.setEmail("");
		}
		else {
			selfSiteRequestImpl.setEmail(email);
		}

		if (lastName == null) {
			selfSiteRequestImpl.setLastName("");
		}
		else {
			selfSiteRequestImpl.setLastName(lastName);
		}

		if (firstName == null) {
			selfSiteRequestImpl.setFirstName("");
		}
		else {
			selfSiteRequestImpl.setFirstName(firstName);
		}

		if (phone == null) {
			selfSiteRequestImpl.setPhone("");
		}
		else {
			selfSiteRequestImpl.setPhone(phone);
		}

		if (projectTitle == null) {
			selfSiteRequestImpl.setProjectTitle("");
		}
		else {
			selfSiteRequestImpl.setProjectTitle(projectTitle);
		}

		if (projectDescription == null) {
			selfSiteRequestImpl.setProjectDescription("");
		}
		else {
			selfSiteRequestImpl.setProjectDescription(projectDescription);
		}

		selfSiteRequestImpl.resetOriginalValues();

		return selfSiteRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		selfSiteRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		email = objectInput.readUTF();
		lastName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		phone = objectInput.readUTF();
		projectTitle = objectInput.readUTF();
		projectDescription = objectInput.readUTF();
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

		objectOutput.writeLong(selfSiteRequestId);

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

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (projectTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectTitle);
		}

		if (projectDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectDescription);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long selfSiteRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String email;
	public String lastName;
	public String firstName;
	public String phone;
	public String projectTitle;
	public String projectDescription;

}