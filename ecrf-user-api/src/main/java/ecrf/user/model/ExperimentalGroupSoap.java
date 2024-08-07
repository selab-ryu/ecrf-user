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
 * This class is used by SOAP remote services, specifically {@link ecrf.user.service.http.ExperimentalGroupServiceSoap}.
 *
 * @author Ryu W.C.
 * @generated
 */
public class ExperimentalGroupSoap implements Serializable {

	public static ExperimentalGroupSoap toSoapModel(ExperimentalGroup model) {
		ExperimentalGroupSoap soapModel = new ExperimentalGroupSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setExperimentalGroupId(model.getExperimentalGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setName(model.getName());
		soapModel.setAbbreviation(model.getAbbreviation());
		soapModel.setDescription(model.getDescription());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static ExperimentalGroupSoap[] toSoapModels(
		ExperimentalGroup[] models) {

		ExperimentalGroupSoap[] soapModels =
			new ExperimentalGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExperimentalGroupSoap[][] toSoapModels(
		ExperimentalGroup[][] models) {

		ExperimentalGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ExperimentalGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExperimentalGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExperimentalGroupSoap[] toSoapModels(
		List<ExperimentalGroup> models) {

		List<ExperimentalGroupSoap> soapModels =
			new ArrayList<ExperimentalGroupSoap>(models.size());

		for (ExperimentalGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExperimentalGroupSoap[soapModels.size()]);
	}

	public ExperimentalGroupSoap() {
	}

	public long getPrimaryKey() {
		return _experimentalGroupId;
	}

	public void setPrimaryKey(long pk) {
		setExperimentalGroupId(pk);
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

	public long getExperimentalGroupId() {
		return _experimentalGroupId;
	}

	public void setExperimentalGroupId(long experimentalGroupId) {
		_experimentalGroupId = experimentalGroupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAbbreviation() {
		return _abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		_abbreviation = abbreviation;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _experimentalGroupId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _name;
	private String _abbreviation;
	private String _description;
	private int _type;

}