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
 * This class is used by SOAP remote services, specifically {@link ecrf.user.service.http.CRFAutoqueryServiceSoap}.
 *
 * @author Ryu W.C.
 * @generated
 */
public class CRFAutoquerySoap implements Serializable {

	public static CRFAutoquerySoap toSoapModel(CRFAutoquery model) {
		CRFAutoquerySoap soapModel = new CRFAutoquerySoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setAutoQueryId(model.getAutoQueryId());
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
		soapModel.setCrfId(model.getCrfId());
		soapModel.setQueryTermId(model.getQueryTermId());
		soapModel.setQueryTermName(model.getQueryTermName());
		soapModel.setQueryValue(model.getQueryValue());
		soapModel.setQueryPreviousValue(model.getQueryPreviousValue());
		soapModel.setQueryType(model.getQueryType());
		soapModel.setQueryComment(model.getQueryComment());
		soapModel.setQueryComfirm(model.getQueryComfirm());
		soapModel.setQueryComfirmUserId(model.getQueryComfirmUserId());
		soapModel.setQueryComfirmUserName(model.getQueryComfirmUserName());
		soapModel.setQueryComfirmDate(model.getQueryComfirmDate());

		return soapModel;
	}

	public static CRFAutoquerySoap[] toSoapModels(CRFAutoquery[] models) {
		CRFAutoquerySoap[] soapModels = new CRFAutoquerySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CRFAutoquerySoap[][] toSoapModels(CRFAutoquery[][] models) {
		CRFAutoquerySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CRFAutoquerySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CRFAutoquerySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CRFAutoquerySoap[] toSoapModels(List<CRFAutoquery> models) {
		List<CRFAutoquerySoap> soapModels = new ArrayList<CRFAutoquerySoap>(
			models.size());

		for (CRFAutoquery model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CRFAutoquerySoap[soapModels.size()]);
	}

	public CRFAutoquerySoap() {
	}

	public long getPrimaryKey() {
		return _autoQueryId;
	}

	public void setPrimaryKey(long pk) {
		setAutoQueryId(pk);
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

	public long getAutoQueryId() {
		return _autoQueryId;
	}

	public void setAutoQueryId(long autoQueryId) {
		_autoQueryId = autoQueryId;
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

	public long getCrfId() {
		return _crfId;
	}

	public void setCrfId(long crfId) {
		_crfId = crfId;
	}

	public long getQueryTermId() {
		return _queryTermId;
	}

	public void setQueryTermId(long queryTermId) {
		_queryTermId = queryTermId;
	}

	public String getQueryTermName() {
		return _queryTermName;
	}

	public void setQueryTermName(String queryTermName) {
		_queryTermName = queryTermName;
	}

	public String getQueryValue() {
		return _queryValue;
	}

	public void setQueryValue(String queryValue) {
		_queryValue = queryValue;
	}

	public String getQueryPreviousValue() {
		return _queryPreviousValue;
	}

	public void setQueryPreviousValue(String queryPreviousValue) {
		_queryPreviousValue = queryPreviousValue;
	}

	public int getQueryType() {
		return _queryType;
	}

	public void setQueryType(int queryType) {
		_queryType = queryType;
	}

	public String getQueryComment() {
		return _queryComment;
	}

	public void setQueryComment(String queryComment) {
		_queryComment = queryComment;
	}

	public int getQueryComfirm() {
		return _queryComfirm;
	}

	public void setQueryComfirm(int queryComfirm) {
		_queryComfirm = queryComfirm;
	}

	public long getQueryComfirmUserId() {
		return _queryComfirmUserId;
	}

	public void setQueryComfirmUserId(long queryComfirmUserId) {
		_queryComfirmUserId = queryComfirmUserId;
	}

	public String getQueryComfirmUserName() {
		return _queryComfirmUserName;
	}

	public void setQueryComfirmUserName(String queryComfirmUserName) {
		_queryComfirmUserName = queryComfirmUserName;
	}

	public Date getQueryComfirmDate() {
		return _queryComfirmDate;
	}

	public void setQueryComfirmDate(Date queryComfirmDate) {
		_queryComfirmDate = queryComfirmDate;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _autoQueryId;
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
	private long _crfId;
	private long _queryTermId;
	private String _queryTermName;
	private String _queryValue;
	private String _queryPreviousValue;
	private int _queryType;
	private String _queryComment;
	private int _queryComfirm;
	private long _queryComfirmUserId;
	private String _queryComfirmUserName;
	private Date _queryComfirmDate;

}