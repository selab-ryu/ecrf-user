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

import ecrf.user.model.LinkCRF;
import ecrf.user.model.LinkCRFModel;
import ecrf.user.model.LinkCRFSoap;

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
 * The base model implementation for the LinkCRF service. Represents a row in the &quot;EC_LinkCRF&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>LinkCRFModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LinkCRFImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see LinkCRFImpl
 * @generated
 */
@JSON(strict = true)
public class LinkCRFModelImpl
	extends BaseModelImpl<LinkCRF> implements LinkCRFModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a link crf model instance should use the <code>LinkCRF</code> interface instead.
	 */
	public static final String TABLE_NAME = "EC_LinkCRF";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"linkId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"subjectId", Types.BIGINT},
		{"crfId", Types.BIGINT}, {"structuredDataId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("linkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("subjectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("crfId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("structuredDataId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EC_LinkCRF (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,linkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,subjectId LONG,crfId LONG,structuredDataId LONG)";

	public static final String TABLE_SQL_DROP = "drop table EC_LinkCRF";

	public static final String ORDER_BY_JPQL =
		" ORDER BY linkCRF.linkId ASC, linkCRF.subjectId ASC, linkCRF.structuredDataId ASC, linkCRF.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EC_LinkCRF.linkId ASC, EC_LinkCRF.subjectId ASC, EC_LinkCRF.structuredDataId ASC, EC_LinkCRF.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long CRFID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long LINKID_COLUMN_BITMASK = 8L;

	public static final long STRUCTUREDDATAID_COLUMN_BITMASK = 16L;

	public static final long SUBJECTID_COLUMN_BITMASK = 32L;

	public static final long UUID_COLUMN_BITMASK = 64L;

	public static final long CREATEDATE_COLUMN_BITMASK = 128L;

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
	public static LinkCRF toModel(LinkCRFSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LinkCRF model = new LinkCRFImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setLinkId(soapModel.getLinkId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setSubjectId(soapModel.getSubjectId());
		model.setCrfId(soapModel.getCrfId());
		model.setStructuredDataId(soapModel.getStructuredDataId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LinkCRF> toModels(LinkCRFSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LinkCRF> models = new ArrayList<LinkCRF>(soapModels.length);

		for (LinkCRFSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public LinkCRFModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _linkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _linkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LinkCRF.class;
	}

	@Override
	public String getModelClassName() {
		return LinkCRF.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LinkCRF, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LinkCRF, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LinkCRF, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((LinkCRF)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LinkCRF, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LinkCRF, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LinkCRF)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LinkCRF, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LinkCRF, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, LinkCRF>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			LinkCRF.class.getClassLoader(), LinkCRF.class, ModelWrapper.class);

		try {
			Constructor<LinkCRF> constructor =
				(Constructor<LinkCRF>)proxyClass.getConstructor(
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

	private static final Map<String, Function<LinkCRF, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<LinkCRF, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<LinkCRF, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<LinkCRF, Object>>();
		Map<String, BiConsumer<LinkCRF, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<LinkCRF, ?>>();

		attributeGetterFunctions.put("mvccVersion", LinkCRF::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion", (BiConsumer<LinkCRF, Long>)LinkCRF::setMvccVersion);
		attributeGetterFunctions.put("uuid", LinkCRF::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<LinkCRF, String>)LinkCRF::setUuid);
		attributeGetterFunctions.put("linkId", LinkCRF::getLinkId);
		attributeSetterBiConsumers.put(
			"linkId", (BiConsumer<LinkCRF, Long>)LinkCRF::setLinkId);
		attributeGetterFunctions.put("groupId", LinkCRF::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<LinkCRF, Long>)LinkCRF::setGroupId);
		attributeGetterFunctions.put("companyId", LinkCRF::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<LinkCRF, Long>)LinkCRF::setCompanyId);
		attributeGetterFunctions.put("userId", LinkCRF::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<LinkCRF, Long>)LinkCRF::setUserId);
		attributeGetterFunctions.put("userName", LinkCRF::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<LinkCRF, String>)LinkCRF::setUserName);
		attributeGetterFunctions.put("createDate", LinkCRF::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<LinkCRF, Date>)LinkCRF::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", LinkCRF::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<LinkCRF, Date>)LinkCRF::setModifiedDate);
		attributeGetterFunctions.put("subjectId", LinkCRF::getSubjectId);
		attributeSetterBiConsumers.put(
			"subjectId", (BiConsumer<LinkCRF, Long>)LinkCRF::setSubjectId);
		attributeGetterFunctions.put("crfId", LinkCRF::getCrfId);
		attributeSetterBiConsumers.put(
			"crfId", (BiConsumer<LinkCRF, Long>)LinkCRF::setCrfId);
		attributeGetterFunctions.put(
			"structuredDataId", LinkCRF::getStructuredDataId);
		attributeSetterBiConsumers.put(
			"structuredDataId",
			(BiConsumer<LinkCRF, Long>)LinkCRF::setStructuredDataId);

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
	public long getLinkId() {
		return _linkId;
	}

	@Override
	public void setLinkId(long linkId) {
		_columnBitmask = -1L;

		if (!_setOriginalLinkId) {
			_setOriginalLinkId = true;

			_originalLinkId = _linkId;
		}

		_linkId = linkId;
	}

	public long getOriginalLinkId() {
		return _originalLinkId;
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
	public long getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(long subjectId) {
		_columnBitmask = -1L;

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
	public long getStructuredDataId() {
		return _structuredDataId;
	}

	@Override
	public void setStructuredDataId(long structuredDataId) {
		_columnBitmask = -1L;

		if (!_setOriginalStructuredDataId) {
			_setOriginalStructuredDataId = true;

			_originalStructuredDataId = _structuredDataId;
		}

		_structuredDataId = structuredDataId;
	}

	public long getOriginalStructuredDataId() {
		return _originalStructuredDataId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(LinkCRF.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), LinkCRF.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LinkCRF toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, LinkCRF>
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
		LinkCRFImpl linkCRFImpl = new LinkCRFImpl();

		linkCRFImpl.setMvccVersion(getMvccVersion());
		linkCRFImpl.setUuid(getUuid());
		linkCRFImpl.setLinkId(getLinkId());
		linkCRFImpl.setGroupId(getGroupId());
		linkCRFImpl.setCompanyId(getCompanyId());
		linkCRFImpl.setUserId(getUserId());
		linkCRFImpl.setUserName(getUserName());
		linkCRFImpl.setCreateDate(getCreateDate());
		linkCRFImpl.setModifiedDate(getModifiedDate());
		linkCRFImpl.setSubjectId(getSubjectId());
		linkCRFImpl.setCrfId(getCrfId());
		linkCRFImpl.setStructuredDataId(getStructuredDataId());

		linkCRFImpl.resetOriginalValues();

		return linkCRFImpl;
	}

	@Override
	public int compareTo(LinkCRF linkCRF) {
		int value = 0;

		if (getLinkId() < linkCRF.getLinkId()) {
			value = -1;
		}
		else if (getLinkId() > linkCRF.getLinkId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getSubjectId() < linkCRF.getSubjectId()) {
			value = -1;
		}
		else if (getSubjectId() > linkCRF.getSubjectId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getStructuredDataId() < linkCRF.getStructuredDataId()) {
			value = -1;
		}
		else if (getStructuredDataId() > linkCRF.getStructuredDataId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), linkCRF.getCreateDate());

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

		if (!(object instanceof LinkCRF)) {
			return false;
		}

		LinkCRF linkCRF = (LinkCRF)object;

		long primaryKey = linkCRF.getPrimaryKey();

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
		LinkCRFModelImpl linkCRFModelImpl = this;

		linkCRFModelImpl._originalUuid = linkCRFModelImpl._uuid;

		linkCRFModelImpl._originalLinkId = linkCRFModelImpl._linkId;

		linkCRFModelImpl._setOriginalLinkId = false;

		linkCRFModelImpl._originalGroupId = linkCRFModelImpl._groupId;

		linkCRFModelImpl._setOriginalGroupId = false;

		linkCRFModelImpl._originalCompanyId = linkCRFModelImpl._companyId;

		linkCRFModelImpl._setOriginalCompanyId = false;

		linkCRFModelImpl._setModifiedDate = false;

		linkCRFModelImpl._originalSubjectId = linkCRFModelImpl._subjectId;

		linkCRFModelImpl._setOriginalSubjectId = false;

		linkCRFModelImpl._originalCrfId = linkCRFModelImpl._crfId;

		linkCRFModelImpl._setOriginalCrfId = false;

		linkCRFModelImpl._originalStructuredDataId =
			linkCRFModelImpl._structuredDataId;

		linkCRFModelImpl._setOriginalStructuredDataId = false;

		linkCRFModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LinkCRF> toCacheModel() {
		LinkCRFCacheModel linkCRFCacheModel = new LinkCRFCacheModel();

		linkCRFCacheModel.mvccVersion = getMvccVersion();

		linkCRFCacheModel.uuid = getUuid();

		String uuid = linkCRFCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			linkCRFCacheModel.uuid = null;
		}

		linkCRFCacheModel.linkId = getLinkId();

		linkCRFCacheModel.groupId = getGroupId();

		linkCRFCacheModel.companyId = getCompanyId();

		linkCRFCacheModel.userId = getUserId();

		linkCRFCacheModel.userName = getUserName();

		String userName = linkCRFCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			linkCRFCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			linkCRFCacheModel.createDate = createDate.getTime();
		}
		else {
			linkCRFCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			linkCRFCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			linkCRFCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		linkCRFCacheModel.subjectId = getSubjectId();

		linkCRFCacheModel.crfId = getCrfId();

		linkCRFCacheModel.structuredDataId = getStructuredDataId();

		return linkCRFCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LinkCRF, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<LinkCRF, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LinkCRF, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((LinkCRF)this));
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
		Map<String, Function<LinkCRF, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<LinkCRF, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LinkCRF, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((LinkCRF)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, LinkCRF>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _linkId;
	private long _originalLinkId;
	private boolean _setOriginalLinkId;
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
	private long _subjectId;
	private long _originalSubjectId;
	private boolean _setOriginalSubjectId;
	private long _crfId;
	private long _originalCrfId;
	private boolean _setOriginalCrfId;
	private long _structuredDataId;
	private long _originalStructuredDataId;
	private boolean _setOriginalStructuredDataId;
	private long _columnBitmask;
	private LinkCRF _escapedModel;

}