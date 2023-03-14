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
 * This class is used by SOAP remote services, specifically {@link ecrf.user.service.http.CRFServiceSoap}.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFSoap implements Serializable {

	public static CRFSoap toSoapModel(CRF model) {
		CRFSoap soapModel = new CRFSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setCrfId(model.getCrfId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreateUserName(model.getCreateUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setDatatypeId(model.getDatatypeId());
		soapModel.setManagerId(model.getManagerId());
		soapModel.setApplyDate(model.getApplyDate());
		soapModel.setCrfStatus(model.getCrfStatus());

		return soapModel;
	}

	public static CRFSoap[] toSoapModels(CRF[] models) {
		CRFSoap[] soapModels = new CRFSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CRFSoap[][] toSoapModels(CRF[][] models) {
		CRFSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CRFSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CRFSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CRFSoap[] toSoapModels(List<CRF> models) {
		List<CRFSoap> soapModels = new ArrayList<CRFSoap>(models.size());

		for (CRF model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CRFSoap[soapModels.size()]);
	}

	public CRFSoap() {
	}

	public long getPrimaryKey() {
		return _crfId;
	}

	public void setPrimaryKey(long pk) {
		setCrfId(pk);
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

	public long getCrfId() {
		return _crfId;
	}

	public void setCrfId(long crfId) {
		_crfId = crfId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getDatatypeId() {
		return _datatypeId;
	}

	public void setDatatypeId(long datatypeId) {
		_datatypeId = datatypeId;
	}

	public long getManagerId() {
		return _managerId;
	}

	public void setManagerId(long managerId) {
		_managerId = managerId;
	}

	public Date getApplyDate() {
		return _applyDate;
	}

	public void setApplyDate(Date applyDate) {
		_applyDate = applyDate;
	}

	public int getCrfStatus() {
		return _crfStatus;
	}

	public void setCrfStatus(int crfStatus) {
		_crfStatus = crfStatus;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _crfId;
	private long _groupId;
	private long _companyId;
	private long _createUserId;
	private String _createUserName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _datatypeId;
	private long _managerId;
	private Date _applyDate;
	private int _crfStatus;

}