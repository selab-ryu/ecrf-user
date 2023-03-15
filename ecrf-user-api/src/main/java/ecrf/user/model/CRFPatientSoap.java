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
 * This class is used by SOAP remote services, specifically {@link ecrf.user.service.http.CRFPatientServiceSoap}.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFPatientSoap implements Serializable {

	public static CRFPatientSoap toSoapModel(CRFPatient model) {
		CRFPatientSoap soapModel = new CRFPatientSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setCrfPatientId(model.getCrfPatientId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCrfId(model.getCrfId());
		soapModel.setPatientId(model.getPatientId());

		return soapModel;
	}

	public static CRFPatientSoap[] toSoapModels(CRFPatient[] models) {
		CRFPatientSoap[] soapModels = new CRFPatientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CRFPatientSoap[][] toSoapModels(CRFPatient[][] models) {
		CRFPatientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CRFPatientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CRFPatientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CRFPatientSoap[] toSoapModels(List<CRFPatient> models) {
		List<CRFPatientSoap> soapModels = new ArrayList<CRFPatientSoap>(
			models.size());

		for (CRFPatient model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CRFPatientSoap[soapModels.size()]);
	}

	public CRFPatientSoap() {
	}

	public long getPrimaryKey() {
		return _crfPatientId;
	}

	public void setPrimaryKey(long pk) {
		setCrfPatientId(pk);
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

	public long getCrfPatientId() {
		return _crfPatientId;
	}

	public void setCrfPatientId(long crfPatientId) {
		_crfPatientId = crfPatientId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public long getCrfId() {
		return _crfId;
	}

	public void setCrfId(long crfId) {
		_crfId = crfId;
	}

	public long getPatientId() {
		return _patientId;
	}

	public void setPatientId(long patientId) {
		_patientId = patientId;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _crfPatientId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _crfId;
	private long _patientId;

}