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
 * This class is used by SOAP remote services, specifically {@link ecrf.user.service.http.CRFHistoryServiceSoap}.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFHistorySoap implements Serializable {

	public static CRFHistorySoap toSoapModel(CRFHistory model) {
		CRFHistorySoap soapModel = new CRFHistorySoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setHistoryId(model.getHistoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setSubjectId(model.getSubjectId());
		soapModel.setSubjectName(model.getSubjectName());
		soapModel.setSerialId(model.getSerialId());
		soapModel.setCrfId(model.getCrfId());
		soapModel.setStructuredDataId(model.getStructuredDataId());
		soapModel.setActionType(model.getActionType());
		soapModel.setPreviousJSON(model.getPreviousJSON());
		soapModel.setCurrentJSON(model.getCurrentJSON());
		soapModel.setHistoryVersion(model.getHistoryVersion());
		soapModel.setPreviousHistoryVersion(model.getPreviousHistoryVersion());

		return soapModel;
	}

	public static CRFHistorySoap[] toSoapModels(CRFHistory[] models) {
		CRFHistorySoap[] soapModels = new CRFHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CRFHistorySoap[][] toSoapModels(CRFHistory[][] models) {
		CRFHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CRFHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CRFHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CRFHistorySoap[] toSoapModels(List<CRFHistory> models) {
		List<CRFHistorySoap> soapModels = new ArrayList<CRFHistorySoap>(
			models.size());

		for (CRFHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CRFHistorySoap[soapModels.size()]);
	}

	public CRFHistorySoap() {
	}

	public long getPrimaryKey() {
		return _historyId;
	}

	public void setPrimaryKey(long pk) {
		setHistoryId(pk);
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

	public long getHistoryId() {
		return _historyId;
	}

	public void setHistoryId(long historyId) {
		_historyId = historyId;
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

	public long getSubjectId() {
		return _subjectId;
	}

	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;
	}

	public String getSubjectName() {
		return _subjectName;
	}

	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;
	}

	public String getSerialId() {
		return _serialId;
	}

	public void setSerialId(String serialId) {
		_serialId = serialId;
	}

	public long getCrfId() {
		return _crfId;
	}

	public void setCrfId(long crfId) {
		_crfId = crfId;
	}

	public long getStructuredDataId() {
		return _structuredDataId;
	}

	public void setStructuredDataId(long structuredDataId) {
		_structuredDataId = structuredDataId;
	}

	public int getActionType() {
		return _actionType;
	}

	public void setActionType(int actionType) {
		_actionType = actionType;
	}

	public String getPreviousJSON() {
		return _previousJSON;
	}

	public void setPreviousJSON(String previousJSON) {
		_previousJSON = previousJSON;
	}

	public String getCurrentJSON() {
		return _currentJSON;
	}

	public void setCurrentJSON(String currentJSON) {
		_currentJSON = currentJSON;
	}

	public String getHistoryVersion() {
		return _historyVersion;
	}

	public void setHistoryVersion(String historyVersion) {
		_historyVersion = historyVersion;
	}

	public String getPreviousHistoryVersion() {
		return _previousHistoryVersion;
	}

	public void setPreviousHistoryVersion(String previousHistoryVersion) {
		_previousHistoryVersion = previousHistoryVersion;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _historyId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _subjectId;
	private String _subjectName;
	private String _serialId;
	private long _crfId;
	private long _structuredDataId;
	private int _actionType;
	private String _previousJSON;
	private String _currentJSON;
	private String _historyVersion;
	private String _previousHistoryVersion;

}