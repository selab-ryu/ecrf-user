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

import ecrf.user.model.CRFAutoquery;
import ecrf.user.model.CRFAutoqueryModel;
import ecrf.user.model.CRFAutoquerySoap;

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
 * The base model implementation for the CRFAutoquery service. Represents a row in the &quot;EC_CRFAutoquery&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CRFAutoqueryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CRFAutoqueryImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFAutoqueryImpl
 * @generated
 */
@JSON(strict = true)
public class CRFAutoqueryModelImpl
	extends BaseModelImpl<CRFAutoquery> implements CRFAutoqueryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a crf autoquery model instance should use the <code>CRFAutoquery</code> interface instead.
	 */
	public static final String TABLE_NAME = "EC_CRFAutoquery";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"autoQueryId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}, {"subjectId", Types.BIGINT},
		{"crfId", Types.BIGINT}, {"queryTermId", Types.BIGINT},
		{"queryTermName", Types.VARCHAR}, {"queryValue", Types.VARCHAR},
		{"queryPreviousValue", Types.VARCHAR}, {"queryType", Types.INTEGER},
		{"queryComment", Types.VARCHAR}, {"queryComfirm", Types.INTEGER},
		{"queryComfirmUserId", Types.BIGINT},
		{"queryComfirmUserName", Types.VARCHAR},
		{"queryComfirmDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("autoQueryId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("crfId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("queryTermId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("queryTermName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("queryValue", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("queryPreviousValue", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("queryType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("queryComment", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("queryComfirm", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("queryComfirmUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("queryComfirmUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("queryComfirmDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EC_CRFAutoquery (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,autoQueryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,subjectId LONG,crfId LONG,queryTermId LONG,queryTermName VARCHAR(75) null,queryValue VARCHAR(75) null,queryPreviousValue VARCHAR(75) null,queryType INTEGER,queryComment VARCHAR(75) null,queryComfirm INTEGER,queryComfirmUserId LONG,queryComfirmUserName VARCHAR(75) null,queryComfirmDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table EC_CRFAutoquery";

	public static final String ORDER_BY_JPQL =
		" ORDER BY crfAutoquery.modifiedDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EC_CRFAutoquery.modifiedDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long AUTOQUERYID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long CRFID_COLUMN_BITMASK = 4L;

	public static final long GROUPID_COLUMN_BITMASK = 8L;

	public static final long QUERYTERMID_COLUMN_BITMASK = 16L;

	public static final long QUERYTERMNAME_COLUMN_BITMASK = 32L;

	public static final long QUERYVALUE_COLUMN_BITMASK = 64L;

	public static final long SUBJECTID_COLUMN_BITMASK = 128L;

	public static final long USERID_COLUMN_BITMASK = 256L;

	public static final long UUID_COLUMN_BITMASK = 512L;

	public static final long MODIFIEDDATE_COLUMN_BITMASK = 1024L;

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
	public static CRFAutoquery toModel(CRFAutoquerySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CRFAutoquery model = new CRFAutoqueryImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setAutoQueryId(soapModel.getAutoQueryId());
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
		model.setCrfId(soapModel.getCrfId());
		model.setQueryTermId(soapModel.getQueryTermId());
		model.setQueryTermName(soapModel.getQueryTermName());
		model.setQueryValue(soapModel.getQueryValue());
		model.setQueryPreviousValue(soapModel.getQueryPreviousValue());
		model.setQueryType(soapModel.getQueryType());
		model.setQueryComment(soapModel.getQueryComment());
		model.setQueryComfirm(soapModel.getQueryComfirm());
		model.setQueryComfirmUserId(soapModel.getQueryComfirmUserId());
		model.setQueryComfirmUserName(soapModel.getQueryComfirmUserName());
		model.setQueryComfirmDate(soapModel.getQueryComfirmDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CRFAutoquery> toModels(CRFAutoquerySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CRFAutoquery> models = new ArrayList<CRFAutoquery>(
			soapModels.length);

		for (CRFAutoquerySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CRFAutoqueryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _autoQueryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAutoQueryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _autoQueryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CRFAutoquery.class;
	}

	@Override
	public String getModelClassName() {
		return CRFAutoquery.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CRFAutoquery, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CRFAutoquery, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFAutoquery, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CRFAutoquery)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CRFAutoquery, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CRFAutoquery, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CRFAutoquery)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CRFAutoquery, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CRFAutoquery, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CRFAutoquery, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CRFAutoquery, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CRFAutoquery, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CRFAutoquery, Object>>();
		Map<String, BiConsumer<CRFAutoquery, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CRFAutoquery, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", CRFAutoquery::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CRFAutoquery, Long>)CRFAutoquery::setMvccVersion);
		attributeGetterFunctions.put("uuid", CRFAutoquery::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CRFAutoquery, String>)CRFAutoquery::setUuid);
		attributeGetterFunctions.put(
			"autoQueryId", CRFAutoquery::getAutoQueryId);
		attributeSetterBiConsumers.put(
			"autoQueryId",
			(BiConsumer<CRFAutoquery, Long>)CRFAutoquery::setAutoQueryId);
		attributeGetterFunctions.put("groupId", CRFAutoquery::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CRFAutoquery, Long>)CRFAutoquery::setGroupId);
		attributeGetterFunctions.put("companyId", CRFAutoquery::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CRFAutoquery, Long>)CRFAutoquery::setCompanyId);
		attributeGetterFunctions.put("userId", CRFAutoquery::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<CRFAutoquery, Long>)CRFAutoquery::setUserId);
		attributeGetterFunctions.put("userName", CRFAutoquery::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CRFAutoquery, String>)CRFAutoquery::setUserName);
		attributeGetterFunctions.put("createDate", CRFAutoquery::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CRFAutoquery, Date>)CRFAutoquery::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CRFAutoquery::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CRFAutoquery, Date>)CRFAutoquery::setModifiedDate);
		attributeGetterFunctions.put("status", CRFAutoquery::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<CRFAutoquery, Integer>)CRFAutoquery::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", CRFAutoquery::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<CRFAutoquery, Long>)CRFAutoquery::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", CRFAutoquery::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<CRFAutoquery, String>)
				CRFAutoquery::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", CRFAutoquery::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<CRFAutoquery, Date>)CRFAutoquery::setStatusDate);
		attributeGetterFunctions.put("subjectId", CRFAutoquery::getSubjectId);
		attributeSetterBiConsumers.put(
			"subjectId",
			(BiConsumer<CRFAutoquery, Long>)CRFAutoquery::setSubjectId);
		attributeGetterFunctions.put("crfId", CRFAutoquery::getCrfId);
		attributeSetterBiConsumers.put(
			"crfId", (BiConsumer<CRFAutoquery, Long>)CRFAutoquery::setCrfId);
		attributeGetterFunctions.put(
			"queryTermId", CRFAutoquery::getQueryTermId);
		attributeSetterBiConsumers.put(
			"queryTermId",
			(BiConsumer<CRFAutoquery, Long>)CRFAutoquery::setQueryTermId);
		attributeGetterFunctions.put(
			"queryTermName", CRFAutoquery::getQueryTermName);
		attributeSetterBiConsumers.put(
			"queryTermName",
			(BiConsumer<CRFAutoquery, String>)CRFAutoquery::setQueryTermName);
		attributeGetterFunctions.put("queryValue", CRFAutoquery::getQueryValue);
		attributeSetterBiConsumers.put(
			"queryValue",
			(BiConsumer<CRFAutoquery, String>)CRFAutoquery::setQueryValue);
		attributeGetterFunctions.put(
			"queryPreviousValue", CRFAutoquery::getQueryPreviousValue);
		attributeSetterBiConsumers.put(
			"queryPreviousValue",
			(BiConsumer<CRFAutoquery, String>)
				CRFAutoquery::setQueryPreviousValue);
		attributeGetterFunctions.put("queryType", CRFAutoquery::getQueryType);
		attributeSetterBiConsumers.put(
			"queryType",
			(BiConsumer<CRFAutoquery, Integer>)CRFAutoquery::setQueryType);
		attributeGetterFunctions.put(
			"queryComment", CRFAutoquery::getQueryComment);
		attributeSetterBiConsumers.put(
			"queryComment",
			(BiConsumer<CRFAutoquery, String>)CRFAutoquery::setQueryComment);
		attributeGetterFunctions.put(
			"queryComfirm", CRFAutoquery::getQueryComfirm);
		attributeSetterBiConsumers.put(
			"queryComfirm",
			(BiConsumer<CRFAutoquery, Integer>)CRFAutoquery::setQueryComfirm);
		attributeGetterFunctions.put(
			"queryComfirmUserId", CRFAutoquery::getQueryComfirmUserId);
		attributeSetterBiConsumers.put(
			"queryComfirmUserId",
			(BiConsumer<CRFAutoquery, Long>)
				CRFAutoquery::setQueryComfirmUserId);
		attributeGetterFunctions.put(
			"queryComfirmUserName", CRFAutoquery::getQueryComfirmUserName);
		attributeSetterBiConsumers.put(
			"queryComfirmUserName",
			(BiConsumer<CRFAutoquery, String>)
				CRFAutoquery::setQueryComfirmUserName);
		attributeGetterFunctions.put(
			"queryComfirmDate", CRFAutoquery::getQueryComfirmDate);
		attributeSetterBiConsumers.put(
			"queryComfirmDate",
			(BiConsumer<CRFAutoquery, Date>)CRFAutoquery::setQueryComfirmDate);

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
	public long getAutoQueryId() {
		return _autoQueryId;
	}

	@Override
	public void setAutoQueryId(long autoQueryId) {
		_columnBitmask |= AUTOQUERYID_COLUMN_BITMASK;

		if (!_setOriginalAutoQueryId) {
			_setOriginalAutoQueryId = true;

			_originalAutoQueryId = _autoQueryId;
		}

		_autoQueryId = autoQueryId;
	}

	public long getOriginalAutoQueryId() {
		return _originalAutoQueryId;
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
	public long getQueryTermId() {
		return _queryTermId;
	}

	@Override
	public void setQueryTermId(long queryTermId) {
		_columnBitmask |= QUERYTERMID_COLUMN_BITMASK;

		if (!_setOriginalQueryTermId) {
			_setOriginalQueryTermId = true;

			_originalQueryTermId = _queryTermId;
		}

		_queryTermId = queryTermId;
	}

	public long getOriginalQueryTermId() {
		return _originalQueryTermId;
	}

	@JSON
	@Override
	public String getQueryTermName() {
		if (_queryTermName == null) {
			return "";
		}
		else {
			return _queryTermName;
		}
	}

	@Override
	public void setQueryTermName(String queryTermName) {
		_columnBitmask |= QUERYTERMNAME_COLUMN_BITMASK;

		if (_originalQueryTermName == null) {
			_originalQueryTermName = _queryTermName;
		}

		_queryTermName = queryTermName;
	}

	public String getOriginalQueryTermName() {
		return GetterUtil.getString(_originalQueryTermName);
	}

	@JSON
	@Override
	public String getQueryValue() {
		if (_queryValue == null) {
			return "";
		}
		else {
			return _queryValue;
		}
	}

	@Override
	public void setQueryValue(String queryValue) {
		_columnBitmask |= QUERYVALUE_COLUMN_BITMASK;

		if (_originalQueryValue == null) {
			_originalQueryValue = _queryValue;
		}

		_queryValue = queryValue;
	}

	public String getOriginalQueryValue() {
		return GetterUtil.getString(_originalQueryValue);
	}

	@JSON
	@Override
	public String getQueryPreviousValue() {
		if (_queryPreviousValue == null) {
			return "";
		}
		else {
			return _queryPreviousValue;
		}
	}

	@Override
	public void setQueryPreviousValue(String queryPreviousValue) {
		_queryPreviousValue = queryPreviousValue;
	}

	@JSON
	@Override
	public int getQueryType() {
		return _queryType;
	}

	@Override
	public void setQueryType(int queryType) {
		_queryType = queryType;
	}

	@JSON
	@Override
	public String getQueryComment() {
		if (_queryComment == null) {
			return "";
		}
		else {
			return _queryComment;
		}
	}

	@Override
	public void setQueryComment(String queryComment) {
		_queryComment = queryComment;
	}

	@JSON
	@Override
	public int getQueryComfirm() {
		return _queryComfirm;
	}

	@Override
	public void setQueryComfirm(int queryComfirm) {
		_queryComfirm = queryComfirm;
	}

	@JSON
	@Override
	public long getQueryComfirmUserId() {
		return _queryComfirmUserId;
	}

	@Override
	public void setQueryComfirmUserId(long queryComfirmUserId) {
		_queryComfirmUserId = queryComfirmUserId;
	}

	@Override
	public String getQueryComfirmUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(
				getQueryComfirmUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setQueryComfirmUserUuid(String queryComfirmUserUuid) {
	}

	@JSON
	@Override
	public String getQueryComfirmUserName() {
		if (_queryComfirmUserName == null) {
			return "";
		}
		else {
			return _queryComfirmUserName;
		}
	}

	@Override
	public void setQueryComfirmUserName(String queryComfirmUserName) {
		_queryComfirmUserName = queryComfirmUserName;
	}

	@JSON
	@Override
	public Date getQueryComfirmDate() {
		return _queryComfirmDate;
	}

	@Override
	public void setQueryComfirmDate(Date queryComfirmDate) {
		_queryComfirmDate = queryComfirmDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CRFAutoquery.class.getName()));
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
			getCompanyId(), CRFAutoquery.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CRFAutoquery toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CRFAutoquery>
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
		CRFAutoqueryImpl crfAutoqueryImpl = new CRFAutoqueryImpl();

		crfAutoqueryImpl.setMvccVersion(getMvccVersion());
		crfAutoqueryImpl.setUuid(getUuid());
		crfAutoqueryImpl.setAutoQueryId(getAutoQueryId());
		crfAutoqueryImpl.setGroupId(getGroupId());
		crfAutoqueryImpl.setCompanyId(getCompanyId());
		crfAutoqueryImpl.setUserId(getUserId());
		crfAutoqueryImpl.setUserName(getUserName());
		crfAutoqueryImpl.setCreateDate(getCreateDate());
		crfAutoqueryImpl.setModifiedDate(getModifiedDate());
		crfAutoqueryImpl.setStatus(getStatus());
		crfAutoqueryImpl.setStatusByUserId(getStatusByUserId());
		crfAutoqueryImpl.setStatusByUserName(getStatusByUserName());
		crfAutoqueryImpl.setStatusDate(getStatusDate());
		crfAutoqueryImpl.setSubjectId(getSubjectId());
		crfAutoqueryImpl.setCrfId(getCrfId());
		crfAutoqueryImpl.setQueryTermId(getQueryTermId());
		crfAutoqueryImpl.setQueryTermName(getQueryTermName());
		crfAutoqueryImpl.setQueryValue(getQueryValue());
		crfAutoqueryImpl.setQueryPreviousValue(getQueryPreviousValue());
		crfAutoqueryImpl.setQueryType(getQueryType());
		crfAutoqueryImpl.setQueryComment(getQueryComment());
		crfAutoqueryImpl.setQueryComfirm(getQueryComfirm());
		crfAutoqueryImpl.setQueryComfirmUserId(getQueryComfirmUserId());
		crfAutoqueryImpl.setQueryComfirmUserName(getQueryComfirmUserName());
		crfAutoqueryImpl.setQueryComfirmDate(getQueryComfirmDate());

		crfAutoqueryImpl.resetOriginalValues();

		return crfAutoqueryImpl;
	}

	@Override
	public int compareTo(CRFAutoquery crfAutoquery) {
		int value = 0;

		value = DateUtil.compareTo(
			getModifiedDate(), crfAutoquery.getModifiedDate());

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

		if (!(object instanceof CRFAutoquery)) {
			return false;
		}

		CRFAutoquery crfAutoquery = (CRFAutoquery)object;

		long primaryKey = crfAutoquery.getPrimaryKey();

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

		_originalAutoQueryId = _autoQueryId;

		_setOriginalAutoQueryId = false;

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

		_originalQueryTermId = _queryTermId;

		_setOriginalQueryTermId = false;

		_originalQueryTermName = _queryTermName;

		_originalQueryValue = _queryValue;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CRFAutoquery> toCacheModel() {
		CRFAutoqueryCacheModel crfAutoqueryCacheModel =
			new CRFAutoqueryCacheModel();

		crfAutoqueryCacheModel.mvccVersion = getMvccVersion();

		crfAutoqueryCacheModel.uuid = getUuid();

		String uuid = crfAutoqueryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			crfAutoqueryCacheModel.uuid = null;
		}

		crfAutoqueryCacheModel.autoQueryId = getAutoQueryId();

		crfAutoqueryCacheModel.groupId = getGroupId();

		crfAutoqueryCacheModel.companyId = getCompanyId();

		crfAutoqueryCacheModel.userId = getUserId();

		crfAutoqueryCacheModel.userName = getUserName();

		String userName = crfAutoqueryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			crfAutoqueryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			crfAutoqueryCacheModel.createDate = createDate.getTime();
		}
		else {
			crfAutoqueryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			crfAutoqueryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			crfAutoqueryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		crfAutoqueryCacheModel.status = getStatus();

		crfAutoqueryCacheModel.statusByUserId = getStatusByUserId();

		crfAutoqueryCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = crfAutoqueryCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			crfAutoqueryCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			crfAutoqueryCacheModel.statusDate = statusDate.getTime();
		}
		else {
			crfAutoqueryCacheModel.statusDate = Long.MIN_VALUE;
		}

		crfAutoqueryCacheModel.subjectId = getSubjectId();

		crfAutoqueryCacheModel.crfId = getCrfId();

		crfAutoqueryCacheModel.queryTermId = getQueryTermId();

		crfAutoqueryCacheModel.queryTermName = getQueryTermName();

		String queryTermName = crfAutoqueryCacheModel.queryTermName;

		if ((queryTermName != null) && (queryTermName.length() == 0)) {
			crfAutoqueryCacheModel.queryTermName = null;
		}

		crfAutoqueryCacheModel.queryValue = getQueryValue();

		String queryValue = crfAutoqueryCacheModel.queryValue;

		if ((queryValue != null) && (queryValue.length() == 0)) {
			crfAutoqueryCacheModel.queryValue = null;
		}

		crfAutoqueryCacheModel.queryPreviousValue = getQueryPreviousValue();

		String queryPreviousValue = crfAutoqueryCacheModel.queryPreviousValue;

		if ((queryPreviousValue != null) &&
			(queryPreviousValue.length() == 0)) {

			crfAutoqueryCacheModel.queryPreviousValue = null;
		}

		crfAutoqueryCacheModel.queryType = getQueryType();

		crfAutoqueryCacheModel.queryComment = getQueryComment();

		String queryComment = crfAutoqueryCacheModel.queryComment;

		if ((queryComment != null) && (queryComment.length() == 0)) {
			crfAutoqueryCacheModel.queryComment = null;
		}

		crfAutoqueryCacheModel.queryComfirm = getQueryComfirm();

		crfAutoqueryCacheModel.queryComfirmUserId = getQueryComfirmUserId();

		crfAutoqueryCacheModel.queryComfirmUserName = getQueryComfirmUserName();

		String queryComfirmUserName =
			crfAutoqueryCacheModel.queryComfirmUserName;

		if ((queryComfirmUserName != null) &&
			(queryComfirmUserName.length() == 0)) {

			crfAutoqueryCacheModel.queryComfirmUserName = null;
		}

		Date queryComfirmDate = getQueryComfirmDate();

		if (queryComfirmDate != null) {
			crfAutoqueryCacheModel.queryComfirmDate =
				queryComfirmDate.getTime();
		}
		else {
			crfAutoqueryCacheModel.queryComfirmDate = Long.MIN_VALUE;
		}

		return crfAutoqueryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CRFAutoquery, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CRFAutoquery, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFAutoquery, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CRFAutoquery)this);

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
		Map<String, Function<CRFAutoquery, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CRFAutoquery, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFAutoquery, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CRFAutoquery)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CRFAutoquery>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CRFAutoquery.class, ModelWrapper.class);

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _autoQueryId;
	private long _originalAutoQueryId;
	private boolean _setOriginalAutoQueryId;
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
	private long _crfId;
	private long _originalCrfId;
	private boolean _setOriginalCrfId;
	private long _queryTermId;
	private long _originalQueryTermId;
	private boolean _setOriginalQueryTermId;
	private String _queryTermName;
	private String _originalQueryTermName;
	private String _queryValue;
	private String _originalQueryValue;
	private String _queryPreviousValue;
	private int _queryType;
	private String _queryComment;
	private int _queryComfirm;
	private long _queryComfirmUserId;
	private String _queryComfirmUserName;
	private Date _queryComfirmDate;
	private long _columnBitmask;
	private CRFAutoquery _escapedModel;

}