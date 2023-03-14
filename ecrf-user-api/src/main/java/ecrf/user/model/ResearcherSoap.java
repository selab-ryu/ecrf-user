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
 * This class is used by SOAP remote services, specifically {@link ecrf.user.service.http.ResearcherServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ResearcherSoap implements Serializable {

	public static ResearcherSoap toSoapModel(Researcher model) {
		ResearcherSoap soapModel = new ResearcherSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setResearcherId(model.getResearcherId());
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
		soapModel.setName(model.getName());
		soapModel.setBirth(model.getBirth());
		soapModel.setPhone(model.getPhone());
		soapModel.setInstitution(model.getInstitution());
		soapModel.setOfficeContact(model.getOfficeContact());
		soapModel.setPosition(model.getPosition());
		soapModel.setApproveStatus(model.getApproveStatus());
		soapModel.setResearcherUserId(model.getResearcherUserId());

		return soapModel;
	}

	public static ResearcherSoap[] toSoapModels(Researcher[] models) {
		ResearcherSoap[] soapModels = new ResearcherSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResearcherSoap[][] toSoapModels(Researcher[][] models) {
		ResearcherSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ResearcherSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResearcherSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResearcherSoap[] toSoapModels(List<Researcher> models) {
		List<ResearcherSoap> soapModels = new ArrayList<ResearcherSoap>(
			models.size());

		for (Researcher model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResearcherSoap[soapModels.size()]);
	}

	public ResearcherSoap() {
	}

	public long getPrimaryKey() {
		return _researcherId;
	}

	public void setPrimaryKey(long pk) {
		setResearcherId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getResearcherId() {
		return _researcherId;
	}

	public void setResearcherId(long researcherId) {
		_researcherId = researcherId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getBirth() {
		return _birth;
	}

	public void setBirth(Date birth) {
		_birth = birth;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getInstitution() {
		return _institution;
	}

	public void setInstitution(String institution) {
		_institution = institution;
	}

	public String getOfficeContact() {
		return _officeContact;
	}

	public void setOfficeContact(String officeContact) {
		_officeContact = officeContact;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public int getApproveStatus() {
		return _approveStatus;
	}

	public void setApproveStatus(int approveStatus) {
		_approveStatus = approveStatus;
	}

	public long getResearcherUserId() {
		return _researcherUserId;
	}

	public void setResearcherUserId(long researcherUserId) {
		_researcherUserId = researcherUserId;
	}

	private String _uuid;
	private long _researcherId;
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
	private String _name;
	private Date _birth;
	private String _phone;
	private String _institution;
	private String _officeContact;
	private String _position;
	private int _approveStatus;
	private long _researcherUserId;

}