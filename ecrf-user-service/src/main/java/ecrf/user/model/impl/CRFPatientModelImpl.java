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

import ecrf.user.model.CRFPatient;
import ecrf.user.model.CRFPatientModel;
import ecrf.user.model.CRFPatientSoap;

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
 * The base model implementation for the CRFPatient service. Represents a row in the &quot;EC_CRFPatient&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CRFPatientModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CRFPatientImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CRFPatientImpl
 * @generated
 */
@JSON(strict = true)
public class CRFPatientModelImpl
	extends BaseModelImpl<CRFPatient> implements CRFPatientModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a crf patient model instance should use the <code>CRFPatient</code> interface instead.
	 */
	public static final String TABLE_NAME = "EC_CRFPatient";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"crfPatientId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"createUserId", Types.BIGINT}, {"createUserName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"crfId", Types.BIGINT}, {"patientId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("crfPatientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("crfId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("patientId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EC_CRFPatient (uuid_ VARCHAR(75) null,crfPatientId LONG not null primary key,groupId LONG,companyId LONG,createUserId LONG,createUserName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,crfId LONG,patientId LONG)";

	public static final String TABLE_SQL_DROP = "drop table EC_CRFPatient";

	public static final String ORDER_BY_JPQL =
		" ORDER BY crfPatient.crfId ASC, crfPatient.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EC_CRFPatient.crfId ASC, EC_CRFPatient.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long CRFID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long PATIENTID_COLUMN_BITMASK = 8L;

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
	public static CRFPatient toModel(CRFPatientSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CRFPatient model = new CRFPatientImpl();

		model.setUuid(soapModel.getUuid());
		model.setCrfPatientId(soapModel.getCrfPatientId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreateUserId(soapModel.getCreateUserId());
		model.setCreateUserName(soapModel.getCreateUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCrfId(soapModel.getCrfId());
		model.setPatientId(soapModel.getPatientId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CRFPatient> toModels(CRFPatientSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CRFPatient> models = new ArrayList<CRFPatient>(soapModels.length);

		for (CRFPatientSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CRFPatientModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _crfPatientId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCrfPatientId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _crfPatientId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CRFPatient.class;
	}

	@Override
	public String getModelClassName() {
		return CRFPatient.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CRFPatient, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CRFPatient, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFPatient, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CRFPatient)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CRFPatient, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CRFPatient, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CRFPatient)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CRFPatient, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CRFPatient, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CRFPatient, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CRFPatient, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CRFPatient, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CRFPatient, Object>>();
		Map<String, BiConsumer<CRFPatient, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CRFPatient, ?>>();

		attributeGetterFunctions.put("uuid", CRFPatient::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CRFPatient, String>)CRFPatient::setUuid);
		attributeGetterFunctions.put(
			"crfPatientId", CRFPatient::getCrfPatientId);
		attributeSetterBiConsumers.put(
			"crfPatientId",
			(BiConsumer<CRFPatient, Long>)CRFPatient::setCrfPatientId);
		attributeGetterFunctions.put("groupId", CRFPatient::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<CRFPatient, Long>)CRFPatient::setGroupId);
		attributeGetterFunctions.put("companyId", CRFPatient::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CRFPatient, Long>)CRFPatient::setCompanyId);
		attributeGetterFunctions.put(
			"createUserId", CRFPatient::getCreateUserId);
		attributeSetterBiConsumers.put(
			"createUserId",
			(BiConsumer<CRFPatient, Long>)CRFPatient::setCreateUserId);
		attributeGetterFunctions.put(
			"createUserName", CRFPatient::getCreateUserName);
		attributeSetterBiConsumers.put(
			"createUserName",
			(BiConsumer<CRFPatient, String>)CRFPatient::setCreateUserName);
		attributeGetterFunctions.put("createDate", CRFPatient::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CRFPatient, Date>)CRFPatient::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CRFPatient::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CRFPatient, Date>)CRFPatient::setModifiedDate);
		attributeGetterFunctions.put("crfId", CRFPatient::getCrfId);
		attributeSetterBiConsumers.put(
			"crfId", (BiConsumer<CRFPatient, Long>)CRFPatient::setCrfId);
		attributeGetterFunctions.put("patientId", CRFPatient::getPatientId);
		attributeSetterBiConsumers.put(
			"patientId",
			(BiConsumer<CRFPatient, Long>)CRFPatient::setPatientId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public long getCrfPatientId() {
		return _crfPatientId;
	}

	@Override
	public void setCrfPatientId(long crfPatientId) {
		_crfPatientId = crfPatientId;
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
	public long getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	@Override
	public String getCreateUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getCreateUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setCreateUserUuid(String createUserUuid) {
	}

	@JSON
	@Override
	public String getCreateUserName() {
		if (_createUserName == null) {
			return "";
		}
		else {
			return _createUserName;
		}
	}

	@Override
	public void setCreateUserName(String createUserName) {
		_createUserName = createUserName;
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

	@JSON
	@Override
	public long getPatientId() {
		return _patientId;
	}

	@Override
	public void setPatientId(long patientId) {
		_columnBitmask |= PATIENTID_COLUMN_BITMASK;

		if (!_setOriginalPatientId) {
			_setOriginalPatientId = true;

			_originalPatientId = _patientId;
		}

		_patientId = patientId;
	}

	public long getOriginalPatientId() {
		return _originalPatientId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CRFPatient.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CRFPatient.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CRFPatient toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CRFPatient>
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
		CRFPatientImpl crfPatientImpl = new CRFPatientImpl();

		crfPatientImpl.setUuid(getUuid());
		crfPatientImpl.setCrfPatientId(getCrfPatientId());
		crfPatientImpl.setGroupId(getGroupId());
		crfPatientImpl.setCompanyId(getCompanyId());
		crfPatientImpl.setCreateUserId(getCreateUserId());
		crfPatientImpl.setCreateUserName(getCreateUserName());
		crfPatientImpl.setCreateDate(getCreateDate());
		crfPatientImpl.setModifiedDate(getModifiedDate());
		crfPatientImpl.setCrfId(getCrfId());
		crfPatientImpl.setPatientId(getPatientId());

		crfPatientImpl.resetOriginalValues();

		return crfPatientImpl;
	}

	@Override
	public int compareTo(CRFPatient crfPatient) {
		int value = 0;

		if (getCrfId() < crfPatient.getCrfId()) {
			value = -1;
		}
		else if (getCrfId() > crfPatient.getCrfId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), crfPatient.getCreateDate());

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

		if (!(object instanceof CRFPatient)) {
			return false;
		}

		CRFPatient crfPatient = (CRFPatient)object;

		long primaryKey = crfPatient.getPrimaryKey();

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
		_originalCrfId = _crfId;

		_setOriginalCrfId = false;

		_originalPatientId = _patientId;

		_setOriginalPatientId = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CRFPatient> toCacheModel() {
		CRFPatientCacheModel crfPatientCacheModel = new CRFPatientCacheModel();

		crfPatientCacheModel.uuid = getUuid();

		String uuid = crfPatientCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			crfPatientCacheModel.uuid = null;
		}

		crfPatientCacheModel.crfPatientId = getCrfPatientId();

		crfPatientCacheModel.groupId = getGroupId();

		crfPatientCacheModel.companyId = getCompanyId();

		crfPatientCacheModel.createUserId = getCreateUserId();

		crfPatientCacheModel.createUserName = getCreateUserName();

		String createUserName = crfPatientCacheModel.createUserName;

		if ((createUserName != null) && (createUserName.length() == 0)) {
			crfPatientCacheModel.createUserName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			crfPatientCacheModel.createDate = createDate.getTime();
		}
		else {
			crfPatientCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			crfPatientCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			crfPatientCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		crfPatientCacheModel.crfId = getCrfId();

		crfPatientCacheModel.patientId = getPatientId();

		return crfPatientCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CRFPatient, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CRFPatient, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFPatient, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CRFPatient)this);

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
		Map<String, Function<CRFPatient, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CRFPatient, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFPatient, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CRFPatient)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CRFPatient>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CRFPatient.class, ModelWrapper.class);

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _crfPatientId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _createUserId;
	private String _createUserName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _crfId;
	private long _originalCrfId;
	private boolean _setOriginalCrfId;
	private long _patientId;
	private long _originalPatientId;
	private boolean _setOriginalPatientId;
	private long _columnBitmask;
	private CRFPatient _escapedModel;

}