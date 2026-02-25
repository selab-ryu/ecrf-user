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
 * This class is used by SOAP remote services, specifically {@link ecrf.user.service.http.SelfSiteRequestServiceSoap}.
 *
 * @author Ryu W.C.
 * @generated
 */
public class SelfSiteRequestSoap implements Serializable {

	public static SelfSiteRequestSoap toSoapModel(SelfSiteRequest model) {
		SelfSiteRequestSoap soapModel = new SelfSiteRequestSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setSelfSiteRequestId(model.getSelfSiteRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmail(model.getEmail());
		soapModel.setLastName(model.getLastName());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setPhone(model.getPhone());
		soapModel.setProjectTitle(model.getProjectTitle());
		soapModel.setProjectDescription(model.getProjectDescription());

		return soapModel;
	}

	public static SelfSiteRequestSoap[] toSoapModels(SelfSiteRequest[] models) {
		SelfSiteRequestSoap[] soapModels =
			new SelfSiteRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SelfSiteRequestSoap[][] toSoapModels(
		SelfSiteRequest[][] models) {

		SelfSiteRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SelfSiteRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SelfSiteRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SelfSiteRequestSoap[] toSoapModels(
		List<SelfSiteRequest> models) {

		List<SelfSiteRequestSoap> soapModels =
			new ArrayList<SelfSiteRequestSoap>(models.size());

		for (SelfSiteRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SelfSiteRequestSoap[soapModels.size()]);
	}

	public SelfSiteRequestSoap() {
	}

	public long getPrimaryKey() {
		return _selfSiteRequestId;
	}

	public void setPrimaryKey(long pk) {
		setSelfSiteRequestId(pk);
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

	public long getSelfSiteRequestId() {
		return _selfSiteRequestId;
	}

	public void setSelfSiteRequestId(long selfSiteRequestId) {
		_selfSiteRequestId = selfSiteRequestId;
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

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getProjectTitle() {
		return _projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		_projectTitle = projectTitle;
	}

	public String getProjectDescription() {
		return _projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		_projectDescription = projectDescription;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _selfSiteRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _email;
	private String _lastName;
	private String _firstName;
	private String _phone;
	private String _projectTitle;
	private String _projectDescription;

}