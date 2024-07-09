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

import ecrf.user.model.CRFSubject;
import ecrf.user.model.CRFSubjectModel;
import ecrf.user.model.CRFSubjectSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

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
 * The base model implementation for the CRFSubject service. Represents a row in the &quot;EC_CRFSubject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CRFSubjectModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CRFSubjectImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFSubjectImpl
 * @generated
 */
@JSON(strict = true)
public class CRFSubjectModelImpl
	extends BaseModelImpl<CRFSubject> implements CRFSubjectModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a crf subject model instance should use the <code>CRFSubject</code> interface instead.
	 */
	public static final String TABLE_NAME = "EC_CRFSubject";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"crfSubjectId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"crfId", Types.BIGINT},
		{"subjectId", Types.BIGINT}, {"participationStatus", Types.INTEGER},
		{"participationStartDate", Types.TIMESTAMP},
		{"updateLock", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("crfSubjectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("crfId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("subjectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("participationStatus", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("participationStartDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("updateLock", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EC_CRFSubject (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,crfSubjectId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,crfId LONG,subjectId LONG,participationStatus INTEGER,participationStartDate DATE null,updateLock BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table EC_CRFSubject";

	public static final String ORDER_BY_JPQL =
		" ORDER BY crfSubject.crfId ASC, crfSubject.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EC_CRFSubject.crfId ASC, EC_CRFSubject.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long CRFID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long SUBJECTID_COLUMN_BITMASK = 8L;

	public static final long UPDATELOCK_COLUMN_BITMASK = 16L;

	public static final long UUID_COLUMN_BITMASK = 32L;

	public static final long CREATEDATE_COLUMN_BITMASK = 64L;

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
	public static CRFSubject toModel(CRFSubjectSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CRFSubject model = new CRFSubjectImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setCrfSubjectId(soapModel.getCrfSubjectId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCrfId(soapModel.getCrfId());
		model.setSubjectId(soapModel.getSubjectId());
		model.setParticipationStatus(soapModel.getParticipationStatus());
		model.setParticipationStartDate(soapModel.getParticipationStartDate());
		model.setUpdateLock(soapModel.isUpdateLock());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CRFSubject> toModels(CRFSubjectSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CRFSubject> models = new ArrayList<CRFSubject>(soapModels.length);

		for (CRFSubjectSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CRFSubjectModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _crfSubjectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCrfSubjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _crfSubjectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CRFSubject.class;
	}

	@Override
	public String getModelClassName() {
		return CRFSubject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CRFSubject, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CRFSubject, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFSubject, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CRFSubject)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CRFSubject, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CRFSubject, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CRFSubject)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CRFSubject, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CRFSubject, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CRFSubject>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CRFSubject.class.getClassLoader(), CRFSubject.class,
			ModelWrapper.class);

		try {
			Constructor<CRFSubject> constructor =
				(Constructor<CRFSubject>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CRFSubject, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CRFSubject, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CRFSubject, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CRFSubject, Object>>();
		Map<String, BiConsumer<CRFSubject, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CRFSubject, ?>>();

		attributeGetterFunctions.put("mvccVersion", CRFSubject::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CRFSubject, Long>)CRFSubject::setMvccVersion);
		attributeGetterFunctions.put("uuid", CRFSubject::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CRFSubject, String>)CRFSubject::setUuid);
		attributeGetterFunctions.put(
			"crfSubjectId", CRFSubject::getCrfSubjectId);
		attributeSetterBiConsumers.put(
			"crfSubjectId",
			(BiConsumer<CRFSubject, Long>)CRFSubject::setCrfSubjectId);
		attributeGetterFunctions.put("groupId", CRFSubject::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<CRFSubject, Long>)CRFSubject::setGroupId);
		attributeGetterFunctions.put("companyId", CRFSubject::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CRFSubject, Long>)CRFSubject::setCompanyId);
		attributeGetterFunctions.put("userId", CRFSubject::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<CRFSubject, Long>)CRFSubject::setUserId);
		attributeGetterFunctions.put("userName", CRFSubject::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CRFSubject, String>)CRFSubject::setUserName);
		attributeGetterFunctions.put("createDate", CRFSubject::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CRFSubject, Date>)CRFSubject::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CRFSubject::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CRFSubject, Date>)CRFSubject::setModifiedDate);
		attributeGetterFunctions.put("crfId", CRFSubject::getCrfId);
		attributeSetterBiConsumers.put(
			"crfId", (BiConsumer<CRFSubject, Long>)CRFSubject::setCrfId);
		attributeGetterFunctions.put("subjectId", CRFSubject::getSubjectId);
		attributeSetterBiConsumers.put(
			"subjectId",
			(BiConsumer<CRFSubject, Long>)CRFSubject::setSubjectId);
		attributeGetterFunctions.put(
			"participationStatus", CRFSubject::getParticipationStatus);
		attributeSetterBiConsumers.put(
			"participationStatus",
			(BiConsumer<CRFSubject, Integer>)
				CRFSubject::setParticipationStatus);
		attributeGetterFunctions.put(
			"participationStartDate", CRFSubject::getParticipationStartDate);
		attributeSetterBiConsumers.put(
			"participationStartDate",
			(BiConsumer<CRFSubject, Date>)
				CRFSubject::setParticipationStartDate);
		attributeGetterFunctions.put("updateLock", CRFSubject::getUpdateLock);
		attributeSetterBiConsumers.put(
			"updateLock",
			(BiConsumer<CRFSubject, Boolean>)CRFSubject::setUpdateLock);

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
	public long getCrfSubjectId() {
		return _crfSubjectId;
	}

	@Override
	public void setCrfSubjectId(long crfSubjectId) {
		_crfSubjectId = crfSubjectId;
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
	public int getParticipationStatus() {
		return _participationStatus;
	}

	@Override
	public void setParticipationStatus(int participationStatus) {
		_participationStatus = participationStatus;
	}

	@JSON
	@Override
	public Date getParticipationStartDate() {
		return _participationStartDate;
	}

	@Override
	public void setParticipationStartDate(Date participationStartDate) {
		_participationStartDate = participationStartDate;
	}

	@JSON
	@Override
	public boolean getUpdateLock() {
		return _updateLock;
	}

	@JSON
	@Override
	public boolean isUpdateLock() {
		return _updateLock;
	}

	@Override
	public void setUpdateLock(boolean updateLock) {
		_columnBitmask |= UPDATELOCK_COLUMN_BITMASK;

		if (!_setOriginalUpdateLock) {
			_setOriginalUpdateLock = true;

			_originalUpdateLock = _updateLock;
		}

		_updateLock = updateLock;
	}

	public boolean getOriginalUpdateLock() {
		return _originalUpdateLock;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CRFSubject.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CRFSubject.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CRFSubject toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CRFSubject>
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
		CRFSubjectImpl crfSubjectImpl = new CRFSubjectImpl();

		crfSubjectImpl.setMvccVersion(getMvccVersion());
		crfSubjectImpl.setUuid(getUuid());
		crfSubjectImpl.setCrfSubjectId(getCrfSubjectId());
		crfSubjectImpl.setGroupId(getGroupId());
		crfSubjectImpl.setCompanyId(getCompanyId());
		crfSubjectImpl.setUserId(getUserId());
		crfSubjectImpl.setUserName(getUserName());
		crfSubjectImpl.setCreateDate(getCreateDate());
		crfSubjectImpl.setModifiedDate(getModifiedDate());
		crfSubjectImpl.setCrfId(getCrfId());
		crfSubjectImpl.setSubjectId(getSubjectId());
		crfSubjectImpl.setParticipationStatus(getParticipationStatus());
		crfSubjectImpl.setParticipationStartDate(getParticipationStartDate());
		crfSubjectImpl.setUpdateLock(isUpdateLock());

		crfSubjectImpl.resetOriginalValues();

		return crfSubjectImpl;
	}

	@Override
	public int compareTo(CRFSubject crfSubject) {
		int value = 0;

		if (getCrfId() < crfSubject.getCrfId()) {
			value = -1;
		}
		else if (getCrfId() > crfSubject.getCrfId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), crfSubject.getCreateDate());

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

		if (!(object instanceof CRFSubject)) {
			return false;
		}

		CRFSubject crfSubject = (CRFSubject)object;

		long primaryKey = crfSubject.getPrimaryKey();

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
		CRFSubjectModelImpl crfSubjectModelImpl = this;

		crfSubjectModelImpl._originalUuid = crfSubjectModelImpl._uuid;

		crfSubjectModelImpl._originalGroupId = crfSubjectModelImpl._groupId;

		crfSubjectModelImpl._setOriginalGroupId = false;

		crfSubjectModelImpl._originalCompanyId = crfSubjectModelImpl._companyId;

		crfSubjectModelImpl._setOriginalCompanyId = false;

		crfSubjectModelImpl._setModifiedDate = false;

		crfSubjectModelImpl._originalCrfId = crfSubjectModelImpl._crfId;

		crfSubjectModelImpl._setOriginalCrfId = false;

		crfSubjectModelImpl._originalSubjectId = crfSubjectModelImpl._subjectId;

		crfSubjectModelImpl._setOriginalSubjectId = false;

		crfSubjectModelImpl._originalUpdateLock =
			crfSubjectModelImpl._updateLock;

		crfSubjectModelImpl._setOriginalUpdateLock = false;

		crfSubjectModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CRFSubject> toCacheModel() {
		CRFSubjectCacheModel crfSubjectCacheModel = new CRFSubjectCacheModel();

		crfSubjectCacheModel.mvccVersion = getMvccVersion();

		crfSubjectCacheModel.uuid = getUuid();

		String uuid = crfSubjectCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			crfSubjectCacheModel.uuid = null;
		}

		crfSubjectCacheModel.crfSubjectId = getCrfSubjectId();

		crfSubjectCacheModel.groupId = getGroupId();

		crfSubjectCacheModel.companyId = getCompanyId();

		crfSubjectCacheModel.userId = getUserId();

		crfSubjectCacheModel.userName = getUserName();

		String userName = crfSubjectCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			crfSubjectCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			crfSubjectCacheModel.createDate = createDate.getTime();
		}
		else {
			crfSubjectCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			crfSubjectCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			crfSubjectCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		crfSubjectCacheModel.crfId = getCrfId();

		crfSubjectCacheModel.subjectId = getSubjectId();

		crfSubjectCacheModel.participationStatus = getParticipationStatus();

		Date participationStartDate = getParticipationStartDate();

		if (participationStartDate != null) {
			crfSubjectCacheModel.participationStartDate =
				participationStartDate.getTime();
		}
		else {
			crfSubjectCacheModel.participationStartDate = Long.MIN_VALUE;
		}

		crfSubjectCacheModel.updateLock = isUpdateLock();

		return crfSubjectCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CRFSubject, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CRFSubject, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFSubject, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CRFSubject)this));
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
		Map<String, Function<CRFSubject, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CRFSubject, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CRFSubject, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CRFSubject)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CRFSubject>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _crfSubjectId;
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
	private long _crfId;
	private long _originalCrfId;
	private boolean _setOriginalCrfId;
	private long _subjectId;
	private long _originalSubjectId;
	private boolean _setOriginalSubjectId;
	private int _participationStatus;
	private Date _participationStartDate;
	private boolean _updateLock;
	private boolean _originalUpdateLock;
	private boolean _setOriginalUpdateLock;
	private long _columnBitmask;
	private CRFSubject _escapedModel;

}