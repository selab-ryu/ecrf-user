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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import ecrf.user.model.CRFSearchLog;
import ecrf.user.model.CRFSearchLogModel;
import ecrf.user.model.CRFSearchLogSoap;

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
 * The base model implementation for the CRFSearchLog service. Represents a row in the &quot;EC_CRFSearchLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CRFSearchLogModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CRFSearchLogImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFSearchLogImpl
 * @generated
 */
@JSON(strict = true)
public class CRFSearchLogModelImpl
	extends BaseModelImpl<CRFSearchLog> implements CRFSearchLogModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a crf search log model instance should use the <code>CRFSearchLog</code> interface instead.
	 */
	public static final String TABLE_NAME = "EC_CRFSearchLog";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"searchLogId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"searchLog", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("searchLogId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("searchLog", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EC_CRFSearchLog (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,searchLogId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,searchLog VARCHAR(2048) null)";

	public static final String TABLE_SQL_DROP = "drop table EC_CRFSearchLog";

	public static final String ORDER_BY_JPQL =
		" ORDER BY crfSearchLog.searchLogId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EC_CRFSearchLog.searchLogId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long SEARCHLOGID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

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
	public static CRFSearchLog toModel(CRFSearchLogSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CRFSearchLog model = new CRFSearchLogImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setSearchLogId(soapModel.getSearchLogId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setSearchLog(soapModel.getSearchLog());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CRFSearchLog> toModels(CRFSearchLogSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CRFSearchLog> models = new ArrayList<CRFSearchLog>(
			soapModels.length);

		for (CRFSearchLogSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CRFSearchLogModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _searchLogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSearchLogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _searchLogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CRFSearchLog.class;
	}

	@Override
	public String getModelClassName() {
		return CRFSearchLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CRFSearchLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CRFSearchLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFSearchLog, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CRFSearchLog)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CRFSearchLog, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CRFSearchLog, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CRFSearchLog)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CRFSearchLog, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CRFSearchLog, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CRFSearchLog, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CRFSearchLog, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CRFSearchLog, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CRFSearchLog, Object>>();
		Map<String, BiConsumer<CRFSearchLog, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CRFSearchLog, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", CRFSearchLog::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CRFSearchLog, Long>)CRFSearchLog::setMvccVersion);
		attributeGetterFunctions.put("uuid", CRFSearchLog::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CRFSearchLog, String>)CRFSearchLog::setUuid);
		attributeGetterFunctions.put(
			"searchLogId", CRFSearchLog::getSearchLogId);
		attributeSetterBiConsumers.put(
			"searchLogId",
			(BiConsumer<CRFSearchLog, Long>)CRFSearchLog::setSearchLogId);
		attributeGetterFunctions.put("groupId", CRFSearchLog::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CRFSearchLog, Long>)CRFSearchLog::setGroupId);
		attributeGetterFunctions.put("companyId", CRFSearchLog::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CRFSearchLog, Long>)CRFSearchLog::setCompanyId);
		attributeGetterFunctions.put("userId", CRFSearchLog::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<CRFSearchLog, Long>)CRFSearchLog::setUserId);
		attributeGetterFunctions.put("userName", CRFSearchLog::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CRFSearchLog, String>)CRFSearchLog::setUserName);
		attributeGetterFunctions.put("createDate", CRFSearchLog::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CRFSearchLog, Date>)CRFSearchLog::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CRFSearchLog::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CRFSearchLog, Date>)CRFSearchLog::setModifiedDate);
		attributeGetterFunctions.put("searchLog", CRFSearchLog::getSearchLog);
		attributeSetterBiConsumers.put(
			"searchLog",
			(BiConsumer<CRFSearchLog, String>)CRFSearchLog::setSearchLog);

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
	public long getSearchLogId() {
		return _searchLogId;
	}

	@Override
	public void setSearchLogId(long searchLogId) {
		_columnBitmask |= SEARCHLOGID_COLUMN_BITMASK;

		if (!_setOriginalSearchLogId) {
			_setOriginalSearchLogId = true;

			_originalSearchLogId = _searchLogId;
		}

		_searchLogId = searchLogId;
	}

	public long getOriginalSearchLogId() {
		return _originalSearchLogId;
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

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getSearchLog() {
		if (_searchLog == null) {
			return "";
		}
		else {
			return _searchLog;
		}
	}

	@Override
	public void setSearchLog(String searchLog) {
		_searchLog = searchLog;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CRFSearchLog.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CRFSearchLog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CRFSearchLog toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CRFSearchLog>
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
		CRFSearchLogImpl crfSearchLogImpl = new CRFSearchLogImpl();

		crfSearchLogImpl.setMvccVersion(getMvccVersion());
		crfSearchLogImpl.setUuid(getUuid());
		crfSearchLogImpl.setSearchLogId(getSearchLogId());
		crfSearchLogImpl.setGroupId(getGroupId());
		crfSearchLogImpl.setCompanyId(getCompanyId());
		crfSearchLogImpl.setUserId(getUserId());
		crfSearchLogImpl.setUserName(getUserName());
		crfSearchLogImpl.setCreateDate(getCreateDate());
		crfSearchLogImpl.setModifiedDate(getModifiedDate());
		crfSearchLogImpl.setSearchLog(getSearchLog());

		crfSearchLogImpl.resetOriginalValues();

		return crfSearchLogImpl;
	}

	@Override
	public int compareTo(CRFSearchLog crfSearchLog) {
		long primaryKey = crfSearchLog.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CRFSearchLog)) {
			return false;
		}

		CRFSearchLog crfSearchLog = (CRFSearchLog)object;

		long primaryKey = crfSearchLog.getPrimaryKey();

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

		_originalSearchLogId = _searchLogId;

		_setOriginalSearchLogId = false;

		_originalGroupId = _groupId;

		_setOriginalGroupId = false;

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CRFSearchLog> toCacheModel() {
		CRFSearchLogCacheModel crfSearchLogCacheModel =
			new CRFSearchLogCacheModel();

		crfSearchLogCacheModel.mvccVersion = getMvccVersion();

		crfSearchLogCacheModel.uuid = getUuid();

		String uuid = crfSearchLogCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			crfSearchLogCacheModel.uuid = null;
		}

		crfSearchLogCacheModel.searchLogId = getSearchLogId();

		crfSearchLogCacheModel.groupId = getGroupId();

		crfSearchLogCacheModel.companyId = getCompanyId();

		crfSearchLogCacheModel.userId = getUserId();

		crfSearchLogCacheModel.userName = getUserName();

		String userName = crfSearchLogCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			crfSearchLogCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			crfSearchLogCacheModel.createDate = createDate.getTime();
		}
		else {
			crfSearchLogCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			crfSearchLogCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			crfSearchLogCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		crfSearchLogCacheModel.searchLog = getSearchLog();

		String searchLog = crfSearchLogCacheModel.searchLog;

		if ((searchLog != null) && (searchLog.length() == 0)) {
			crfSearchLogCacheModel.searchLog = null;
		}

		return crfSearchLogCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CRFSearchLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CRFSearchLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFSearchLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CRFSearchLog)this);

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
		Map<String, Function<CRFSearchLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CRFSearchLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFSearchLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CRFSearchLog)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CRFSearchLog>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CRFSearchLog.class, ModelWrapper.class);

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _searchLogId;
	private long _originalSearchLogId;
	private boolean _setOriginalSearchLogId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _searchLog;
	private long _columnBitmask;
	private CRFSearchLog _escapedModel;

}