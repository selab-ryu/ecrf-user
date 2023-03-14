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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

import ecrf.user.model.CRFResearcher;

/**
 * The cache model class for representing CRFResearcher in entity cache.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFResearcherCacheModel
	implements CacheModel<CRFResearcher>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CRFResearcherCacheModel)) {
			return false;
		}

		CRFResearcherCacheModel crfResearcherCacheModel =
			(CRFResearcherCacheModel)object;

		if ((crfResearcherId == crfResearcherCacheModel.crfResearcherId) &&
			(mvccVersion == crfResearcherCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, crfResearcherId);

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
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", crfResearcherId=");
		sb.append(crfResearcherId);
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
		sb.append(", researcherId=");
		sb.append(researcherId);
		sb.append(", crfId=");
		sb.append(crfId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CRFResearcher toEntityModel() {
		CRFResearcherImpl crfResearcherImpl = new CRFResearcherImpl();

		crfResearcherImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			crfResearcherImpl.setUuid("");
		}
		else {
			crfResearcherImpl.setUuid(uuid);
		}

		crfResearcherImpl.setCrfResearcherId(crfResearcherId);
		crfResearcherImpl.setGroupId(groupId);
		crfResearcherImpl.setCompanyId(companyId);
		crfResearcherImpl.setCreateUserId(createUserId);

		if (createUserName == null) {
			crfResearcherImpl.setCreateUserName("");
		}
		else {
			crfResearcherImpl.setCreateUserName(createUserName);
		}

		if (createDate == Long.MIN_VALUE) {
			crfResearcherImpl.setCreateDate(null);
		}
		else {
			crfResearcherImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			crfResearcherImpl.setModifiedDate(null);
		}
		else {
			crfResearcherImpl.setModifiedDate(new Date(modifiedDate));
		}

		crfResearcherImpl.setResearcherId(researcherId);
		crfResearcherImpl.setCrfId(crfId);

		crfResearcherImpl.resetOriginalValues();

		return crfResearcherImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		crfResearcherId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		createUserId = objectInput.readLong();
		createUserName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		researcherId = objectInput.readLong();

		crfId = objectInput.readLong();
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

		objectOutput.writeLong(crfResearcherId);

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

		objectOutput.writeLong(researcherId);

		objectOutput.writeLong(crfId);
	}

	public long mvccVersion;
	public String uuid;
	public long crfResearcherId;
	public long groupId;
	public long companyId;
	public long createUserId;
	public String createUserName;
	public long createDate;
	public long modifiedDate;
	public long researcherId;
	public long crfId;

}