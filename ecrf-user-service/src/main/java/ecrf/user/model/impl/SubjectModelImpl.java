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
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import ecrf.user.model.Subject;
import ecrf.user.model.SubjectModel;
import ecrf.user.model.SubjectSoap;

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
 * The base model implementation for the Subject service. Represents a row in the &quot;EC_Subject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SubjectModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SubjectImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see SubjectImpl
 * @generated
 */
@JSON(strict = true)
public class SubjectModelImpl
	extends BaseModelImpl<Subject> implements SubjectModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a subject model instance should use the <code>Subject</code> interface instead.
	 */
	public static final String TABLE_NAME = "EC_Subject";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"subjectId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"birth", Types.TIMESTAMP}, {"gender", Types.INTEGER},
		{"phone", Types.VARCHAR}, {"phone2", Types.VARCHAR},
		{"address", Types.VARCHAR}, {"serialId", Types.VARCHAR},
		{"hospitalCode", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subjectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birth", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("gender", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("phone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phone2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serialId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("hospitalCode", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EC_Subject (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,subjectId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,name VARCHAR(75) null,birth DATE null,gender INTEGER,phone VARCHAR(75) null,phone2 VARCHAR(75) null,address VARCHAR(75) null,serialId VARCHAR(75) null,hospitalCode INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table EC_Subject";

	public static final String ORDER_BY_JPQL =
		" ORDER BY subject.subjectId DESC, subject.name ASC, subject.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EC_Subject.subjectId DESC, EC_Subject.name ASC, EC_Subject.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long NAME_COLUMN_BITMASK = 4L;

	public static final long SERIALID_COLUMN_BITMASK = 8L;

	public static final long SUBJECTID_COLUMN_BITMASK = 16L;

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
	public static Subject toModel(SubjectSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Subject model = new SubjectImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setSubjectId(soapModel.getSubjectId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setName(soapModel.getName());
		model.setBirth(soapModel.getBirth());
		model.setGender(soapModel.getGender());
		model.setPhone(soapModel.getPhone());
		model.setPhone2(soapModel.getPhone2());
		model.setAddress(soapModel.getAddress());
		model.setSerialId(soapModel.getSerialId());
		model.setHospitalCode(soapModel.getHospitalCode());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Subject> toModels(SubjectSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Subject> models = new ArrayList<Subject>(soapModels.length);

		for (SubjectSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SubjectModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _subjectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subjectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Subject.class;
	}

	@Override
	public String getModelClassName() {
		return Subject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Subject, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Subject, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Subject, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Subject)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Subject, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Subject, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Subject)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Subject, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Subject, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Subject>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Subject.class.getClassLoader(), Subject.class, ModelWrapper.class);

		try {
			Constructor<Subject> constructor =
				(Constructor<Subject>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Subject, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Subject, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Subject, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Subject, Object>>();
		Map<String, BiConsumer<Subject, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Subject, ?>>();

		attributeGetterFunctions.put("mvccVersion", Subject::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion", (BiConsumer<Subject, Long>)Subject::setMvccVersion);
		attributeGetterFunctions.put("uuid", Subject::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Subject, String>)Subject::setUuid);
		attributeGetterFunctions.put("subjectId", Subject::getSubjectId);
		attributeSetterBiConsumers.put(
			"subjectId", (BiConsumer<Subject, Long>)Subject::setSubjectId);
		attributeGetterFunctions.put("companyId", Subject::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Subject, Long>)Subject::setCompanyId);
		attributeGetterFunctions.put("groupId", Subject::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Subject, Long>)Subject::setGroupId);
		attributeGetterFunctions.put("userId", Subject::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Subject, Long>)Subject::setUserId);
		attributeGetterFunctions.put("userName", Subject::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Subject, String>)Subject::setUserName);
		attributeGetterFunctions.put("createDate", Subject::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Subject, Date>)Subject::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Subject::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Subject, Date>)Subject::setModifiedDate);
		attributeGetterFunctions.put("status", Subject::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Subject, Integer>)Subject::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", Subject::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<Subject, Long>)Subject::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", Subject::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<Subject, String>)Subject::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", Subject::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate", (BiConsumer<Subject, Date>)Subject::setStatusDate);
		attributeGetterFunctions.put("name", Subject::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Subject, String>)Subject::setName);
		attributeGetterFunctions.put("birth", Subject::getBirth);
		attributeSetterBiConsumers.put(
			"birth", (BiConsumer<Subject, Date>)Subject::setBirth);
		attributeGetterFunctions.put("gender", Subject::getGender);
		attributeSetterBiConsumers.put(
			"gender", (BiConsumer<Subject, Integer>)Subject::setGender);
		attributeGetterFunctions.put("phone", Subject::getPhone);
		attributeSetterBiConsumers.put(
			"phone", (BiConsumer<Subject, String>)Subject::setPhone);
		attributeGetterFunctions.put("phone2", Subject::getPhone2);
		attributeSetterBiConsumers.put(
			"phone2", (BiConsumer<Subject, String>)Subject::setPhone2);
		attributeGetterFunctions.put("address", Subject::getAddress);
		attributeSetterBiConsumers.put(
			"address", (BiConsumer<Subject, String>)Subject::setAddress);
		attributeGetterFunctions.put("serialId", Subject::getSerialId);
		attributeSetterBiConsumers.put(
			"serialId", (BiConsumer<Subject, String>)Subject::setSerialId);
		attributeGetterFunctions.put("hospitalCode", Subject::getHospitalCode);
		attributeSetterBiConsumers.put(
			"hospitalCode",
			(BiConsumer<Subject, Integer>)Subject::setHospitalCode);

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
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public Date getBirth() {
		return _birth;
	}

	@Override
	public void setBirth(Date birth) {
		_birth = birth;
	}

	@JSON
	@Override
	public int getGender() {
		return _gender;
	}

	@Override
	public void setGender(int gender) {
		_gender = gender;
	}

	@JSON
	@Override
	public String getPhone() {
		if (_phone == null) {
			return "";
		}
		else {
			return _phone;
		}
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;
	}

	@JSON
	@Override
	public String getPhone2() {
		if (_phone2 == null) {
			return "";
		}
		else {
			return _phone2;
		}
	}

	@Override
	public void setPhone2(String phone2) {
		_phone2 = phone2;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
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
		_columnBitmask |= SERIALID_COLUMN_BITMASK;

		if (_originalSerialId == null) {
			_originalSerialId = _serialId;
		}

		_serialId = serialId;
	}

	public String getOriginalSerialId() {
		return GetterUtil.getString(_originalSerialId);
	}

	@JSON
	@Override
	public int getHospitalCode() {
		return _hospitalCode;
	}

	@Override
	public void setHospitalCode(int hospitalCode) {
		_hospitalCode = hospitalCode;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Subject.class.getName()));
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
			getCompanyId(), Subject.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Subject toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Subject>
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
		SubjectImpl subjectImpl = new SubjectImpl();

		subjectImpl.setMvccVersion(getMvccVersion());
		subjectImpl.setUuid(getUuid());
		subjectImpl.setSubjectId(getSubjectId());
		subjectImpl.setCompanyId(getCompanyId());
		subjectImpl.setGroupId(getGroupId());
		subjectImpl.setUserId(getUserId());
		subjectImpl.setUserName(getUserName());
		subjectImpl.setCreateDate(getCreateDate());
		subjectImpl.setModifiedDate(getModifiedDate());
		subjectImpl.setStatus(getStatus());
		subjectImpl.setStatusByUserId(getStatusByUserId());
		subjectImpl.setStatusByUserName(getStatusByUserName());
		subjectImpl.setStatusDate(getStatusDate());
		subjectImpl.setName(getName());
		subjectImpl.setBirth(getBirth());
		subjectImpl.setGender(getGender());
		subjectImpl.setPhone(getPhone());
		subjectImpl.setPhone2(getPhone2());
		subjectImpl.setAddress(getAddress());
		subjectImpl.setSerialId(getSerialId());
		subjectImpl.setHospitalCode(getHospitalCode());

		subjectImpl.resetOriginalValues();

		return subjectImpl;
	}

	@Override
	public int compareTo(Subject subject) {
		int value = 0;

		if (getSubjectId() < subject.getSubjectId()) {
			value = -1;
		}
		else if (getSubjectId() > subject.getSubjectId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(subject.getName());

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), subject.getCreateDate());

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

		if (!(object instanceof Subject)) {
			return false;
		}

		Subject subject = (Subject)object;

		long primaryKey = subject.getPrimaryKey();

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
		SubjectModelImpl subjectModelImpl = this;

		subjectModelImpl._originalUuid = subjectModelImpl._uuid;

		subjectModelImpl._originalSubjectId = subjectModelImpl._subjectId;

		subjectModelImpl._setOriginalSubjectId = false;

		subjectModelImpl._originalCompanyId = subjectModelImpl._companyId;

		subjectModelImpl._setOriginalCompanyId = false;

		subjectModelImpl._originalGroupId = subjectModelImpl._groupId;

		subjectModelImpl._setOriginalGroupId = false;

		subjectModelImpl._setModifiedDate = false;

		subjectModelImpl._originalName = subjectModelImpl._name;

		subjectModelImpl._originalSerialId = subjectModelImpl._serialId;

		subjectModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Subject> toCacheModel() {
		SubjectCacheModel subjectCacheModel = new SubjectCacheModel();

		subjectCacheModel.mvccVersion = getMvccVersion();

		subjectCacheModel.uuid = getUuid();

		String uuid = subjectCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			subjectCacheModel.uuid = null;
		}

		subjectCacheModel.subjectId = getSubjectId();

		subjectCacheModel.companyId = getCompanyId();

		subjectCacheModel.groupId = getGroupId();

		subjectCacheModel.userId = getUserId();

		subjectCacheModel.userName = getUserName();

		String userName = subjectCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			subjectCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			subjectCacheModel.createDate = createDate.getTime();
		}
		else {
			subjectCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			subjectCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			subjectCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		subjectCacheModel.status = getStatus();

		subjectCacheModel.statusByUserId = getStatusByUserId();

		subjectCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = subjectCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			subjectCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			subjectCacheModel.statusDate = statusDate.getTime();
		}
		else {
			subjectCacheModel.statusDate = Long.MIN_VALUE;
		}

		subjectCacheModel.name = getName();

		String name = subjectCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			subjectCacheModel.name = null;
		}

		Date birth = getBirth();

		if (birth != null) {
			subjectCacheModel.birth = birth.getTime();
		}
		else {
			subjectCacheModel.birth = Long.MIN_VALUE;
		}

		subjectCacheModel.gender = getGender();

		subjectCacheModel.phone = getPhone();

		String phone = subjectCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			subjectCacheModel.phone = null;
		}

		subjectCacheModel.phone2 = getPhone2();

		String phone2 = subjectCacheModel.phone2;

		if ((phone2 != null) && (phone2.length() == 0)) {
			subjectCacheModel.phone2 = null;
		}

		subjectCacheModel.address = getAddress();

		String address = subjectCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			subjectCacheModel.address = null;
		}

		subjectCacheModel.serialId = getSerialId();

		String serialId = subjectCacheModel.serialId;

		if ((serialId != null) && (serialId.length() == 0)) {
			subjectCacheModel.serialId = null;
		}

		subjectCacheModel.hospitalCode = getHospitalCode();

		return subjectCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Subject, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Subject, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Subject, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Subject)this));
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
		Map<String, Function<Subject, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Subject, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Subject, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Subject)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Subject>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _subjectId;
	private long _originalSubjectId;
	private boolean _setOriginalSubjectId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _name;
	private String _originalName;
	private Date _birth;
	private int _gender;
	private String _phone;
	private String _phone2;
	private String _address;
	private String _serialId;
	private String _originalSerialId;
	private int _hospitalCode;
	private long _columnBitmask;
	private Subject _escapedModel;

}