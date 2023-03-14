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

package ecrf.user.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ecrf.user.service.http.CRFResearcherServiceSoap}.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFResearcherSoap implements Serializable {

	public static CRFResearcherSoap toSoapModel(CRFResearcher model) {
		CRFResearcherSoap soapModel = new CRFResearcherSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setCrfResearcherId(model.getCrfResearcherId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreateUserName(model.getCreateUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setResearcherId(model.getResearcherId());
		soapModel.setCrfId(model.getCrfId());

		return soapModel;
	}

	public static CRFResearcherSoap[] toSoapModels(CRFResearcher[] models) {
		CRFResearcherSoap[] soapModels = new CRFResearcherSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CRFResearcherSoap[][] toSoapModels(CRFResearcher[][] models) {
		CRFResearcherSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CRFResearcherSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CRFResearcherSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CRFResearcherSoap[] toSoapModels(List<CRFResearcher> models) {
		List<CRFResearcherSoap> soapModels = new ArrayList<CRFResearcherSoap>(
			models.size());

		for (CRFResearcher model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CRFResearcherSoap[soapModels.size()]);
	}

	public CRFResearcherSoap() {
	}

	public long getPrimaryKey() {
		return _crfResearcherId;
	}

	public void setPrimaryKey(long pk) {
		setCrfResearcherId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCrfResearcherId() {
		return _crfResearcherId;
	}

	public void setCrfResearcherId(long crfResearcherId) {
		_crfResearcherId = crfResearcherId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	public String getCreateUserName() {
		return _createUserName;
	}

	public void setCreateUserName(String createUserName) {
		_createUserName = createUserName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getResearcherId() {
		return _researcherId;
	}

	public void setResearcherId(long researcherId) {
		_researcherId = researcherId;
	}

	public long getCrfId() {
		return _crfId;
	}

	public void setCrfId(long crfId) {
		_crfId = crfId;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _crfResearcherId;
	private long _groupId;
	private long _companyId;
	private long _createUserId;
	private String _createUserName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _researcherId;
	private long _crfId;

}