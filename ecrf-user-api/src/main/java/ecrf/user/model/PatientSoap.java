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
 * This class is used by SOAP remote services, specifically {@link ecrf.user.service.http.PatientServiceSoap}.
 *
 * @author Ryu W.C.
 * @generated
 */
public class PatientSoap implements Serializable {

	public static PatientSoap toSoapModel(Patient model) {
		PatientSoap soapModel = new PatientSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setPatientId(model.getPatientId());
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
		soapModel.setPosition(model.getPosition());
		soapModel.setGender(model.getGender());
		soapModel.setConsentDate(model.getConsentDate());
		soapModel.setParticipationStartDate(model.getParticipationStartDate());
		soapModel.setParticipationStatus(model.getParticipationStatus());
		soapModel.setExperimentalGroup(model.getExperimentalGroup());
		soapModel.setPatientUserId(model.getPatientUserId());

		return soapModel;
	}

	public static PatientSoap[] toSoapModels(Patient[] models) {
		PatientSoap[] soapModels = new PatientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PatientSoap[][] toSoapModels(Patient[][] models) {
		PatientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PatientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PatientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PatientSoap[] toSoapModels(List<Patient> models) {
		List<PatientSoap> soapModels = new ArrayList<PatientSoap>(
			models.size());

		for (Patient model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PatientSoap[soapModels.size()]);
	}

	public PatientSoap() {
	}

	public long getPrimaryKey() {
		return _patientId;
	}

	public void setPrimaryKey(long pk) {
		setPatientId(pk);
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

	public long getPatientId() {
		return _patientId;
	}

	public void setPatientId(long patientId) {
		_patientId = patientId;
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

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public int getGender() {
		return _gender;
	}

	public void setGender(int gender) {
		_gender = gender;
	}

	public Date getConsentDate() {
		return _consentDate;
	}

	public void setConsentDate(Date consentDate) {
		_consentDate = consentDate;
	}

	public Date getParticipationStartDate() {
		return _participationStartDate;
	}

	public void setParticipationStartDate(Date participationStartDate) {
		_participationStartDate = participationStartDate;
	}

	public int getParticipationStatus() {
		return _participationStatus;
	}

	public void setParticipationStatus(int participationStatus) {
		_participationStatus = participationStatus;
	}

	public String getExperimentalGroup() {
		return _experimentalGroup;
	}

	public void setExperimentalGroup(String experimentalGroup) {
		_experimentalGroup = experimentalGroup;
	}

	public long getPatientUserId() {
		return _patientUserId;
	}

	public void setPatientUserId(long patientUserId) {
		_patientUserId = patientUserId;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _patientId;
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
	private String _position;
	private int _gender;
	private Date _consentDate;
	private Date _participationStartDate;
	private int _participationStatus;
	private String _experimentalGroup;
	private long _patientUserId;

}