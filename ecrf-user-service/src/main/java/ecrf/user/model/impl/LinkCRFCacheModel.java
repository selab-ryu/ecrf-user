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

import ecrf.user.model.LinkCRF;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LinkCRF in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class LinkCRFCacheModel
	implements CacheModel<LinkCRF>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LinkCRFCacheModel)) {
			return false;
		}

		LinkCRFCacheModel linkCRFCacheModel = (LinkCRFCacheModel)object;

		if ((linkId == linkCRFCacheModel.linkId) &&
			(mvccVersion == linkCRFCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, linkId);

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
		StringBundler sb = new StringBundler(25);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", linkId=");
		sb.append(linkId);
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
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append(", crfId=");
		sb.append(crfId);
		sb.append(", structuredDataId=");
		sb.append(structuredDataId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LinkCRF toEntityModel() {
		LinkCRFImpl linkCRFImpl = new LinkCRFImpl();

		linkCRFImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			linkCRFImpl.setUuid("");
		}
		else {
			linkCRFImpl.setUuid(uuid);
		}

		linkCRFImpl.setLinkId(linkId);
		linkCRFImpl.setGroupId(groupId);
		linkCRFImpl.setCompanyId(companyId);
		linkCRFImpl.setUserId(userId);

		if (userName == null) {
			linkCRFImpl.setUserName("");
		}
		else {
			linkCRFImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			linkCRFImpl.setCreateDate(null);
		}
		else {
			linkCRFImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			linkCRFImpl.setModifiedDate(null);
		}
		else {
			linkCRFImpl.setModifiedDate(new Date(modifiedDate));
		}

		linkCRFImpl.setSubjectId(subjectId);
		linkCRFImpl.setCrfId(crfId);
		linkCRFImpl.setStructuredDataId(structuredDataId);

		linkCRFImpl.resetOriginalValues();

		return linkCRFImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		linkId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		subjectId = objectInput.readLong();

		crfId = objectInput.readLong();

		structuredDataId = objectInput.readLong();
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

		objectOutput.writeLong(linkId);

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

		objectOutput.writeLong(subjectId);

		objectOutput.writeLong(crfId);

		objectOutput.writeLong(structuredDataId);
	}

	public long mvccVersion;
	public String uuid;
	public long linkId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long subjectId;
	public long crfId;
	public long structuredDataId;

}