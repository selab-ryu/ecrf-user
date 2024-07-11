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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import ecrf.user.model.CRFHistory;
import ecrf.user.model.CRFHistoryModel;
import ecrf.user.model.CRFHistorySoap;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CRFHistory service. Represents a row in the &quot;EC_CRFHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CRFHistoryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CRFHistoryImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFHistoryImpl
 * @generated
 */
@JSON(strict = true)
public class CRFHistoryModelImpl
	extends BaseModelImpl<CRFHistory> implements CRFHistoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a crf history model instance should use the <code>CRFHistory</code> interface instead.
	 */
	public static final String TABLE_NAME = "EC_CRFHistory";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"historyId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}, {"subjectId", Types.BIGINT},
		{"subjectName", Types.VARCHAR}, {"serialId", Types.VARCHAR},
		{"crfId", Types.BIGINT}, {"structuredDataId", Types.BIGINT},
		{"actionType", Types.INTEGER}, {"previousJSON", Types.VARCHAR},
		{"currentJSON", Types.VARCHAR}, {"historyVersion", Types.VARCHAR},
		{"previousHistoryVersion", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("historyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("subjectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("subjectName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serialId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("crfId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("structuredDataId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("actionType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("previousJSON", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("currentJSON", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("historyVersion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("previousHistoryVersion", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EC_CRFHistory (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,historyId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,subjectId LONG,subjectName VARCHAR(75) null,serialId VARCHAR(75) null,crfId LONG,structuredDataId LONG,actionType INTEGER,previousJSON TEXT null,currentJSON TEXT null,historyVersion VARCHAR(75) null,previousHistoryVersion VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table EC_CRFHistory";

	public static final String ORDER_BY_JPQL =
		" ORDER BY crfHistory.historyId DESC, crfHistory.modifiedDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EC_CRFHistory.historyId DESC, EC_CRFHistory.modifiedDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long CRFID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long HISTORYID_COLUMN_BITMASK = 8L;

	public static final long STRUCTUREDDATAID_COLUMN_BITMASK = 16L;

	public static final long SUBJECTID_COLUMN_BITMASK = 32L;

	public static final long USERID_COLUMN_BITMASK = 64L;

	public static final long UUID_COLUMN_BITMASK = 128L;

	public static final long MODIFIEDDATE_COLUMN_BITMASK = 256L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CRFHistory toModel(CRFHistorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CRFHistory model = new CRFHistoryImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setHistoryId(soapModel.getHistoryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setSubjectId(soapModel.getSubjectId());
		model.setSubjectName(soapModel.getSubjectName());
		model.setSerialId(soapModel.getSerialId());
		model.setCrfId(soapModel.getCrfId());
		model.setStructuredDataId(soapModel.getStructuredDataId());
		model.setActionType(soapModel.getActionType());
		model.setPreviousJSON(soapModel.getPreviousJSON());
		model.setCurrentJSON(soapModel.getCurrentJSON());
		model.setHistoryVersion(soapModel.getHistoryVersion());
		model.setPreviousHistoryVersion(soapModel.getPreviousHistoryVersion());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CRFHistory> toModels(CRFHistorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CRFHistory> models = new ArrayList<CRFHistory>(soapModels.length);

		for (CRFHistorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CRFHistoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _historyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _historyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CRFHistory.class;
	}

	@Override
	public String getModelClassName() {
		return CRFHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CRFHistory, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CRFHistory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFHistory, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CRFHistory)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CRFHistory, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CRFHistory, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CRFHistory)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CRFHistory, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CRFHistory, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CRFHistory, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CRFHistory, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CRFHistory, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CRFHistory, Object>>();
		Map<String, BiConsumer<CRFHistory, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CRFHistory, ?>>();

		attributeGetterFunctions.put("mvccVersion", CRFHistory::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CRFHistory, Long>)CRFHistory::setMvccVersion);
		attributeGetterFunctions.put("uuid", CRFHistory::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CRFHistory, String>)CRFHistory::setUuid);
		attributeGetterFunctions.put("historyId", CRFHistory::getHistoryId);
		attributeSetterBiConsumers.put(
			"historyId",
			(BiConsumer<CRFHistory, Long>)CRFHistory::setHistoryId);
		attributeGetterFunctions.put("groupId", CRFHistory::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<CRFHistory, Long>)CRFHistory::setGroupId);
		attributeGetterFunctions.put("companyId", CRFHistory::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CRFHistory, Long>)CRFHistory::setCompanyId);
		attributeGetterFunctions.put("userId", CRFHistory::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<CRFHistory, Long>)CRFHistory::setUserId);
		attributeGetterFunctions.put("userName", CRFHistory::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CRFHistory, String>)CRFHistory::setUserName);
		attributeGetterFunctions.put("createDate", CRFHistory::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CRFHistory, Date>)CRFHistory::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CRFHistory::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CRFHistory, Date>)CRFHistory::setModifiedDate);
		attributeGetterFunctions.put("status", CRFHistory::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<CRFHistory, Integer>)CRFHistory::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", CRFHistory::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<CRFHistory, Long>)CRFHistory::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", CRFHistory::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<CRFHistory, String>)CRFHistory::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", CRFHistory::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<CRFHistory, Date>)CRFHistory::setStatusDate);
		attributeGetterFunctions.put("subjectId", CRFHistory::getSubjectId);
		attributeSetterBiConsumers.put(
			"subjectId",
			(BiConsumer<CRFHistory, Long>)CRFHistory::setSubjectId);
		attributeGetterFunctions.put("subjectName", CRFHistory::getSubjectName);
		attributeSetterBiConsumers.put(
			"subjectName",
			(BiConsumer<CRFHistory, String>)CRFHistory::setSubjectName);
		attributeGetterFunctions.put("serialId", CRFHistory::getSerialId);
		attributeSetterBiConsumers.put(
			"serialId",
			(BiConsumer<CRFHistory, String>)CRFHistory::setSerialId);
		attributeGetterFunctions.put("crfId", CRFHistory::getCrfId);
		attributeSetterBiConsumers.put(
			"crfId", (BiConsumer<CRFHistory, Long>)CRFHistory::setCrfId);
		attributeGetterFunctions.put(
			"structuredDataId", CRFHistory::getStructuredDataId);
		attributeSetterBiConsumers.put(
			"structuredDataId",
			(BiConsumer<CRFHistory, Long>)CRFHistory::setStructuredDataId);
		attributeGetterFunctions.put("actionType", CRFHistory::getActionType);
		attributeSetterBiConsumers.put(
			"actionType",
			(BiConsumer<CRFHistory, Integer>)CRFHistory::setActionType);
		attributeGetterFunctions.put(
			"previousJSON", CRFHistory::getPreviousJSON);
		attributeSetterBiConsumers.put(
			"previousJSON",
			(BiConsumer<CRFHistory, String>)CRFHistory::setPreviousJSON);
		attributeGetterFunctions.put("currentJSON", CRFHistory::getCurrentJSON);
		attributeSetterBiConsumers.put(
			"currentJSON",
			(BiConsumer<CRFHistory, String>)CRFHistory::setCurrentJSON);
		attributeGetterFunctions.put(
			"historyVersion", CRFHistory::getHistoryVersion);
		attributeSetterBiConsumers.put(
			"historyVersion",
			(BiConsumer<CRFHistory, String>)CRFHistory::setHistoryVersion);
		attributeGetterFunctions.put(
			"previousHistoryVersion", CRFHistory::getPreviousHistoryVersion);
		attributeSetterBiConsumers.put(
			"previousHistoryVersion",
			(BiConsumer<CRFHistory, String>)
				CRFHistory::setPreviousHistoryVersion);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getHistoryId() {
		return _historyId;
	}

	@Override
	public void setHistoryId(long historyId) {
		_columnBitmask = -1L;

		if (!_setOriginalHistoryId) {
			_setOriginalHistoryId = true;

			_originalHistoryId = _historyId;
		}

		_historyId = historyId;
	}

	public long getOriginalHistoryId() {
		return _originalHistoryId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	@Override
	public long getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(long subjectId) {
		_columnBitmask |= SUBJECTID_COLUMN_BITMASK;

		if (!_setOriginalSubjectId) {
			_setOriginalSubjectId = true;

			_originalSubjectId = _subjectId;
		}

		_subjectId = subjectId;
	}

	public long getOriginalSubjectId() {
		return _originalSubjectId;
	}

	@JSON
	@Override
	public String getSubjectName() {
		if (_subjectName == null) {
			return "";
		}
		else {
			return _subjectName;
		}
	}

	@Override
	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;
	}

	@JSON
	@Override
	public String getSerialId() {
		if (_serialId == null) {
			return "";
		}
		else {
			return _serialId;
		}
	}

	@Override
	public void setSerialId(String serialId) {
		_serialId = serialId;
	}

	@JSON
	@Override
	public long getCrfId() {
		return _crfId;
	}

	@Override
	public void setCrfId(long crfId) {
		_columnBitmask |= CRFID_COLUMN_BITMASK;

		if (!_setOriginalCrfId) {
			_setOriginalCrfId = true;

			_originalCrfId = _crfId;
		}

		_crfId = crfId;
	}

	public long getOriginalCrfId() {
		return _originalCrfId;
	}

	@JSON
	@Override
	public long getStructuredDataId() {
		return _structuredDataId;
	}

	@Override
	public void setStructuredDataId(long structuredDataId) {
		_columnBitmask |= STRUCTUREDDATAID_COLUMN_BITMASK;

		if (!_setOriginalStructuredDataId) {
			_setOriginalStructuredDataId = true;

			_originalStructuredDataId = _structuredDataId;
		}

		_structuredDataId = structuredDataId;
	}

	public long getOriginalStructuredDataId() {
		return _originalStructuredDataId;
	}

	@JSON
	@Override
	public int getActionType() {
		return _actionType;
	}

	@Override
	public void setActionType(int actionType) {
		_actionType = actionType;
	}

	@JSON
	@Override
	public String getPreviousJSON() {
		if (_previousJSON == null) {
			return "";
		}
		else {
			return _previousJSON;
		}
	}

	@Override
	public void setPreviousJSON(String previousJSON) {
		_previousJSON = previousJSON;
	}

	@JSON
	@Override
	public String getCurrentJSON() {
		if (_currentJSON == null) {
			return "";
		}
		else {
			return _currentJSON;
		}
	}

	@Override
	public void setCurrentJSON(String currentJSON) {
		_currentJSON = currentJSON;
	}

	@JSON
	@Override
	public String getHistoryVersion() {
		if (_historyVersion == null) {
			return "";
		}
		else {
			return _historyVersion;
		}
	}

	@Override
	public void setHistoryVersion(String historyVersion) {
		_historyVersion = historyVersion;
	}

	@JSON
	@Override
	public String getPreviousHistoryVersion() {
		if (_previousHistoryVersion == null) {
			return "";
		}
		else {
			return _previousHistoryVersion;
		}
	}

	@Override
	public void setPreviousHistoryVersion(String previousHistoryVersion) {
		_previousHistoryVersion = previousHistoryVersion;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CRFHistory.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CRFHistory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CRFHistory toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CRFHistory>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CRFHistoryImpl crfHistoryImpl = new CRFHistoryImpl();

		crfHistoryImpl.setMvccVersion(getMvccVersion());
		crfHistoryImpl.setUuid(getUuid());
		crfHistoryImpl.setHistoryId(getHistoryId());
		crfHistoryImpl.setGroupId(getGroupId());
		crfHistoryImpl.setCompanyId(getCompanyId());
		crfHistoryImpl.setUserId(getUserId());
		crfHistoryImpl.setUserName(getUserName());
		crfHistoryImpl.setCreateDate(getCreateDate());
		crfHistoryImpl.setModifiedDate(getModifiedDate());
		crfHistoryImpl.setStatus(getStatus());
		crfHistoryImpl.setStatusByUserId(getStatusByUserId());
		crfHistoryImpl.setStatusByUserName(getStatusByUserName());
		crfHistoryImpl.setStatusDate(getStatusDate());
		crfHistoryImpl.setSubjectId(getSubjectId());
		crfHistoryImpl.setSubjectName(getSubjectName());
		crfHistoryImpl.setSerialId(getSerialId());
		crfHistoryImpl.setCrfId(getCrfId());
		crfHistoryImpl.setStructuredDataId(getStructuredDataId());
		crfHistoryImpl.setActionType(getActionType());
		crfHistoryImpl.setPreviousJSON(getPreviousJSON());
		crfHistoryImpl.setCurrentJSON(getCurrentJSON());
		crfHistoryImpl.setHistoryVersion(getHistoryVersion());
		crfHistoryImpl.setPreviousHistoryVersion(getPreviousHistoryVersion());

		crfHistoryImpl.resetOriginalValues();

		return crfHistoryImpl;
	}

	@Override
	public int compareTo(CRFHistory crfHistory) {
		int value = 0;

		if (getHistoryId() < crfHistory.getHistoryId()) {
			value = -1;
		}
		else if (getHistoryId() > crfHistory.getHistoryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(
			getModifiedDate(), crfHistory.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CRFHistory)) {
			return false;
		}

		CRFHistory crfHistory = (CRFHistory)object;

		long primaryKey = crfHistory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		_originalUuid = _uuid;

		_originalHistoryId = _historyId;

		_setOriginalHistoryId = false;

		_originalGroupId = _groupId;

		_setOriginalGroupId = false;

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_originalUserId = _userId;

		_setOriginalUserId = false;

		_setModifiedDate = false;

		_originalSubjectId = _subjectId;

		_setOriginalSubjectId = false;

		_originalCrfId = _crfId;

		_setOriginalCrfId = false;

		_originalStructuredDataId = _structuredDataId;

		_setOriginalStructuredDataId = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CRFHistory> toCacheModel() {
		CRFHistoryCacheModel crfHistoryCacheModel = new CRFHistoryCacheModel();

		crfHistoryCacheModel.mvccVersion = getMvccVersion();

		crfHistoryCacheModel.uuid = getUuid();

		String uuid = crfHistoryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			crfHistoryCacheModel.uuid = null;
		}

		crfHistoryCacheModel.historyId = getHistoryId();

		crfHistoryCacheModel.groupId = getGroupId();

		crfHistoryCacheModel.companyId = getCompanyId();

		crfHistoryCacheModel.userId = getUserId();

		crfHistoryCacheModel.userName = getUserName();

		String userName = crfHistoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			crfHistoryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			crfHistoryCacheModel.createDate = createDate.getTime();
		}
		else {
			crfHistoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			crfHistoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			crfHistoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		crfHistoryCacheModel.status = getStatus();

		crfHistoryCacheModel.statusByUserId = getStatusByUserId();

		crfHistoryCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = crfHistoryCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			crfHistoryCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			crfHistoryCacheModel.statusDate = statusDate.getTime();
		}
		else {
			crfHistoryCacheModel.statusDate = Long.MIN_VALUE;
		}

		crfHistoryCacheModel.subjectId = getSubjectId();

		crfHistoryCacheModel.subjectName = getSubjectName();

		String subjectName = crfHistoryCacheModel.subjectName;

		if ((subjectName != null) && (subjectName.length() == 0)) {
			crfHistoryCacheModel.subjectName = null;
		}

		crfHistoryCacheModel.serialId = getSerialId();

		String serialId = crfHistoryCacheModel.serialId;

		if ((serialId != null) && (serialId.length() == 0)) {
			crfHistoryCacheModel.serialId = null;
		}

		crfHistoryCacheModel.crfId = getCrfId();

		crfHistoryCacheModel.structuredDataId = getStructuredDataId();

		crfHistoryCacheModel.actionType = getActionType();

		crfHistoryCacheModel.previousJSON = getPreviousJSON();

		String previousJSON = crfHistoryCacheModel.previousJSON;

		if ((previousJSON != null) && (previousJSON.length() == 0)) {
			crfHistoryCacheModel.previousJSON = null;
		}

		crfHistoryCacheModel.currentJSON = getCurrentJSON();

		String currentJSON = crfHistoryCacheModel.currentJSON;

		if ((currentJSON != null) && (currentJSON.length() == 0)) {
			crfHistoryCacheModel.currentJSON = null;
		}

		crfHistoryCacheModel.historyVersion = getHistoryVersion();

		String historyVersion = crfHistoryCacheModel.historyVersion;

		if ((historyVersion != null) && (historyVersion.length() == 0)) {
			crfHistoryCacheModel.historyVersion = null;
		}

		crfHistoryCacheModel.previousHistoryVersion =
			getPreviousHistoryVersion();

		String previousHistoryVersion =
			crfHistoryCacheModel.previousHistoryVersion;

		if ((previousHistoryVersion != null) &&
			(previousHistoryVersion.length() == 0)) {

			crfHistoryCacheModel.previousHistoryVersion = null;
		}

		return crfHistoryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CRFHistory, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CRFHistory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFHistory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CRFHistory)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CRFHistory, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CRFHistory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFHistory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CRFHistory)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CRFHistory>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CRFHistory.class, ModelWrapper.class);

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _historyId;
	private long _originalHistoryId;
	private boolean _setOriginalHistoryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _subjectId;
	private long _originalSubjectId;
	private boolean _setOriginalSubjectId;
	private String _subjectName;
	private String _serialId;
	private long _crfId;
	private long _originalCrfId;
	private boolean _setOriginalCrfId;
	private long _structuredDataId;
	private long _originalStructuredDataId;
	private boolean _setOriginalStructuredDataId;
	private int _actionType;
	private String _previousJSON;
	private String _currentJSON;
	private String _historyVersion;
	private String _previousHistoryVersion;
	private long _columnBitmask;
	private CRFHistory _escapedModel;

}