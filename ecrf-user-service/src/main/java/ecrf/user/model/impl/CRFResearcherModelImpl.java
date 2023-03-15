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

import ecrf.user.model.CRFResearcher;
import ecrf.user.model.CRFResearcherModel;
import ecrf.user.model.CRFResearcherSoap;

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
 * The base model implementation for the CRFResearcher service. Represents a row in the &quot;EC_CRFResearcher&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CRFResearcherModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CRFResearcherImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFResearcherImpl
 * @generated
 */
@JSON(strict = true)
public class CRFResearcherModelImpl
	extends BaseModelImpl<CRFResearcher> implements CRFResearcherModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a crf researcher model instance should use the <code>CRFResearcher</code> interface instead.
	 */
	public static final String TABLE_NAME = "EC_CRFResearcher";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"crfResearcherId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"researcherId", Types.BIGINT},
		{"crfId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("crfResearcherId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("researcherId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("crfId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EC_CRFResearcher (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,crfResearcherId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,researcherId LONG,crfId LONG)";

	public static final String TABLE_SQL_DROP = "drop table EC_CRFResearcher";

	public static final String ORDER_BY_JPQL =
		" ORDER BY crfResearcher.crfId ASC, crfResearcher.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EC_CRFResearcher.crfId ASC, EC_CRFResearcher.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long CRFID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long RESEARCHERID_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long CREATEDATE_COLUMN_BITMASK = 32L;

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
	public static CRFResearcher toModel(CRFResearcherSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CRFResearcher model = new CRFResearcherImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setCrfResearcherId(soapModel.getCrfResearcherId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setResearcherId(soapModel.getResearcherId());
		model.setCrfId(soapModel.getCrfId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CRFResearcher> toModels(CRFResearcherSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CRFResearcher> models = new ArrayList<CRFResearcher>(
			soapModels.length);

		for (CRFResearcherSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CRFResearcherModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _crfResearcherId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCrfResearcherId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _crfResearcherId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CRFResearcher.class;
	}

	@Override
	public String getModelClassName() {
		return CRFResearcher.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CRFResearcher, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CRFResearcher, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFResearcher, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CRFResearcher)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CRFResearcher, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CRFResearcher, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CRFResearcher)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CRFResearcher, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CRFResearcher, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CRFResearcher, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CRFResearcher, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CRFResearcher, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CRFResearcher, Object>>();
		Map<String, BiConsumer<CRFResearcher, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CRFResearcher, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", CRFResearcher::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CRFResearcher, Long>)CRFResearcher::setMvccVersion);
		attributeGetterFunctions.put("uuid", CRFResearcher::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CRFResearcher, String>)CRFResearcher::setUuid);
		attributeGetterFunctions.put(
			"crfResearcherId", CRFResearcher::getCrfResearcherId);
		attributeSetterBiConsumers.put(
			"crfResearcherId",
			(BiConsumer<CRFResearcher, Long>)CRFResearcher::setCrfResearcherId);
		attributeGetterFunctions.put("groupId", CRFResearcher::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CRFResearcher, Long>)CRFResearcher::setGroupId);
		attributeGetterFunctions.put("companyId", CRFResearcher::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CRFResearcher, Long>)CRFResearcher::setCompanyId);
		attributeGetterFunctions.put("userId", CRFResearcher::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CRFResearcher, Long>)CRFResearcher::setUserId);
		attributeGetterFunctions.put("userName", CRFResearcher::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CRFResearcher, String>)CRFResearcher::setUserName);
		attributeGetterFunctions.put(
			"createDate", CRFResearcher::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CRFResearcher, Date>)CRFResearcher::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CRFResearcher::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CRFResearcher, Date>)CRFResearcher::setModifiedDate);
		attributeGetterFunctions.put(
			"researcherId", CRFResearcher::getResearcherId);
		attributeSetterBiConsumers.put(
			"researcherId",
			(BiConsumer<CRFResearcher, Long>)CRFResearcher::setResearcherId);
		attributeGetterFunctions.put("crfId", CRFResearcher::getCrfId);
		attributeSetterBiConsumers.put(
			"crfId", (BiConsumer<CRFResearcher, Long>)CRFResearcher::setCrfId);

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
	public long getCrfResearcherId() {
		return _crfResearcherId;
	}

	@Override
	public void setCrfResearcherId(long crfResearcherId) {
		_crfResearcherId = crfResearcherId;
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
		_columnBitmask = -1L;

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
	public long getResearcherId() {
		return _researcherId;
	}

	@Override
	public void setResearcherId(long researcherId) {
		_columnBitmask |= RESEARCHERID_COLUMN_BITMASK;

		if (!_setOriginalResearcherId) {
			_setOriginalResearcherId = true;

			_originalResearcherId = _researcherId;
		}

		_researcherId = researcherId;
	}

	public long getOriginalResearcherId() {
		return _originalResearcherId;
	}

	@JSON
	@Override
	public long getCrfId() {
		return _crfId;
	}

	@Override
	public void setCrfId(long crfId) {
		_columnBitmask = -1L;

		if (!_setOriginalCrfId) {
			_setOriginalCrfId = true;

			_originalCrfId = _crfId;
		}

		_crfId = crfId;
	}

	public long getOriginalCrfId() {
		return _originalCrfId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CRFResearcher.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CRFResearcher.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CRFResearcher toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CRFResearcher>
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
		CRFResearcherImpl crfResearcherImpl = new CRFResearcherImpl();

		crfResearcherImpl.setMvccVersion(getMvccVersion());
		crfResearcherImpl.setUuid(getUuid());
		crfResearcherImpl.setCrfResearcherId(getCrfResearcherId());
		crfResearcherImpl.setGroupId(getGroupId());
		crfResearcherImpl.setCompanyId(getCompanyId());
		crfResearcherImpl.setUserId(getUserId());
		crfResearcherImpl.setUserName(getUserName());
		crfResearcherImpl.setCreateDate(getCreateDate());
		crfResearcherImpl.setModifiedDate(getModifiedDate());
		crfResearcherImpl.setResearcherId(getResearcherId());
		crfResearcherImpl.setCrfId(getCrfId());

		crfResearcherImpl.resetOriginalValues();

		return crfResearcherImpl;
	}

	@Override
	public int compareTo(CRFResearcher crfResearcher) {
		int value = 0;

		if (getCrfId() < crfResearcher.getCrfId()) {
			value = -1;
		}
		else if (getCrfId() > crfResearcher.getCrfId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(
			getCreateDate(), crfResearcher.getCreateDate());

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

		if (!(object instanceof CRFResearcher)) {
			return false;
		}

		CRFResearcher crfResearcher = (CRFResearcher)object;

		long primaryKey = crfResearcher.getPrimaryKey();

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

		_originalGroupId = _groupId;

		_setOriginalGroupId = false;

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;
		_originalResearcherId = _researcherId;

		_setOriginalResearcherId = false;

		_originalCrfId = _crfId;

		_setOriginalCrfId = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CRFResearcher> toCacheModel() {
		CRFResearcherCacheModel crfResearcherCacheModel =
			new CRFResearcherCacheModel();

		crfResearcherCacheModel.mvccVersion = getMvccVersion();

		crfResearcherCacheModel.uuid = getUuid();

		String uuid = crfResearcherCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			crfResearcherCacheModel.uuid = null;
		}

		crfResearcherCacheModel.crfResearcherId = getCrfResearcherId();

		crfResearcherCacheModel.groupId = getGroupId();

		crfResearcherCacheModel.companyId = getCompanyId();

		crfResearcherCacheModel.userId = getUserId();

		crfResearcherCacheModel.userName = getUserName();

		String userName = crfResearcherCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			crfResearcherCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			crfResearcherCacheModel.createDate = createDate.getTime();
		}
		else {
			crfResearcherCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			crfResearcherCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			crfResearcherCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		crfResearcherCacheModel.researcherId = getResearcherId();

		crfResearcherCacheModel.crfId = getCrfId();

		return crfResearcherCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CRFResearcher, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CRFResearcher, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFResearcher, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CRFResearcher)this);

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
		Map<String, Function<CRFResearcher, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CRFResearcher, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFResearcher, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CRFResearcher)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CRFResearcher>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CRFResearcher.class, ModelWrapper.class);

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _crfResearcherId;
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
	private long _researcherId;
	private long _originalResearcherId;
	private boolean _setOriginalResearcherId;
	private long _crfId;
	private long _originalCrfId;
	private boolean _setOriginalCrfId;
	private long _columnBitmask;
	private CRFResearcher _escapedModel;

}