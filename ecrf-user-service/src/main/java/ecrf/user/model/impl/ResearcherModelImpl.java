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

import ecrf.user.model.Researcher;
import ecrf.user.model.ResearcherModel;
import ecrf.user.model.ResearcherSoap;

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
 * The base model implementation for the Researcher service. Represents a row in the &quot;EC_Researcher&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ResearcherModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ResearcherImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see ResearcherImpl
 * @generated
 */
@JSON(strict = true)
public class ResearcherModelImpl
	extends BaseModelImpl<Researcher> implements ResearcherModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a researcher model instance should use the <code>Researcher</code> interface instead.
	 */
	public static final String TABLE_NAME = "EC_Researcher";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"researcherId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"email", Types.VARCHAR}, {"birth", Types.TIMESTAMP},
		{"phone", Types.VARCHAR}, {"institution", Types.VARCHAR},
		{"officeContact", Types.VARCHAR}, {"position", Types.VARCHAR},
		{"approveStatus", Types.INTEGER}, {"researcherUserId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("researcherId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birth", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("phone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("institution", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("officeContact", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("position", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("approveStatus", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("researcherUserId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EC_Researcher (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,researcherId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,name VARCHAR(75) null,email VARCHAR(75) null,birth DATE null,phone VARCHAR(75) null,institution VARCHAR(75) null,officeContact VARCHAR(75) null,position VARCHAR(75) null,approveStatus INTEGER,researcherUserId LONG)";

	public static final String TABLE_SQL_DROP = "drop table EC_Researcher";

	public static final String ORDER_BY_JPQL =
		" ORDER BY researcher.researcherId ASC, researcher.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EC_Researcher.researcherId ASC, EC_Researcher.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long STATUS_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long RESEARCHERID_COLUMN_BITMASK = 16L;

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
	public static Researcher toModel(ResearcherSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Researcher model = new ResearcherImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setResearcherId(soapModel.getResearcherId());
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
		model.setName(soapModel.getName());
		model.setEmail(soapModel.getEmail());
		model.setBirth(soapModel.getBirth());
		model.setPhone(soapModel.getPhone());
		model.setInstitution(soapModel.getInstitution());
		model.setOfficeContact(soapModel.getOfficeContact());
		model.setPosition(soapModel.getPosition());
		model.setApproveStatus(soapModel.getApproveStatus());
		model.setResearcherUserId(soapModel.getResearcherUserId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Researcher> toModels(ResearcherSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Researcher> models = new ArrayList<Researcher>(soapModels.length);

		for (ResearcherSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ResearcherModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _researcherId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setResearcherId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _researcherId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Researcher.class;
	}

	@Override
	public String getModelClassName() {
		return Researcher.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Researcher, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Researcher, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Researcher, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Researcher)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Researcher, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Researcher, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Researcher)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Researcher, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Researcher, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Researcher, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Researcher, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Researcher, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Researcher, Object>>();
		Map<String, BiConsumer<Researcher, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Researcher, ?>>();

		attributeGetterFunctions.put("mvccVersion", Researcher::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<Researcher, Long>)Researcher::setMvccVersion);
		attributeGetterFunctions.put("uuid", Researcher::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Researcher, String>)Researcher::setUuid);
		attributeGetterFunctions.put(
			"researcherId", Researcher::getResearcherId);
		attributeSetterBiConsumers.put(
			"researcherId",
			(BiConsumer<Researcher, Long>)Researcher::setResearcherId);
		attributeGetterFunctions.put("groupId", Researcher::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Researcher, Long>)Researcher::setGroupId);
		attributeGetterFunctions.put("companyId", Researcher::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<Researcher, Long>)Researcher::setCompanyId);
		attributeGetterFunctions.put("userId", Researcher::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Researcher, Long>)Researcher::setUserId);
		attributeGetterFunctions.put("userName", Researcher::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<Researcher, String>)Researcher::setUserName);
		attributeGetterFunctions.put("createDate", Researcher::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<Researcher, Date>)Researcher::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", Researcher::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Researcher, Date>)Researcher::setModifiedDate);
		attributeGetterFunctions.put("status", Researcher::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Researcher, Integer>)Researcher::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", Researcher::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<Researcher, Long>)Researcher::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", Researcher::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<Researcher, String>)Researcher::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", Researcher::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<Researcher, Date>)Researcher::setStatusDate);
		attributeGetterFunctions.put("name", Researcher::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Researcher, String>)Researcher::setName);
		attributeGetterFunctions.put("email", Researcher::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<Researcher, String>)Researcher::setEmail);
		attributeGetterFunctions.put("birth", Researcher::getBirth);
		attributeSetterBiConsumers.put(
			"birth", (BiConsumer<Researcher, Date>)Researcher::setBirth);
		attributeGetterFunctions.put("phone", Researcher::getPhone);
		attributeSetterBiConsumers.put(
			"phone", (BiConsumer<Researcher, String>)Researcher::setPhone);
		attributeGetterFunctions.put("institution", Researcher::getInstitution);
		attributeSetterBiConsumers.put(
			"institution",
			(BiConsumer<Researcher, String>)Researcher::setInstitution);
		attributeGetterFunctions.put(
			"officeContact", Researcher::getOfficeContact);
		attributeSetterBiConsumers.put(
			"officeContact",
			(BiConsumer<Researcher, String>)Researcher::setOfficeContact);
		attributeGetterFunctions.put("position", Researcher::getPosition);
		attributeSetterBiConsumers.put(
			"position",
			(BiConsumer<Researcher, String>)Researcher::setPosition);
		attributeGetterFunctions.put(
			"approveStatus", Researcher::getApproveStatus);
		attributeSetterBiConsumers.put(
			"approveStatus",
			(BiConsumer<Researcher, Integer>)Researcher::setApproveStatus);
		attributeGetterFunctions.put(
			"researcherUserId", Researcher::getResearcherUserId);
		attributeSetterBiConsumers.put(
			"researcherUserId",
			(BiConsumer<Researcher, Long>)Researcher::setResearcherUserId);

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
	public long getResearcherId() {
		return _researcherId;
	}

	@Override
	public void setResearcherId(long researcherId) {
		_columnBitmask = -1L;

		_researcherId = researcherId;
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
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
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
		_name = name;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
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
	public String getInstitution() {
		if (_institution == null) {
			return "";
		}
		else {
			return _institution;
		}
	}

	@Override
	public void setInstitution(String institution) {
		_institution = institution;
	}

	@JSON
	@Override
	public String getOfficeContact() {
		if (_officeContact == null) {
			return "";
		}
		else {
			return _officeContact;
		}
	}

	@Override
	public void setOfficeContact(String officeContact) {
		_officeContact = officeContact;
	}

	@JSON
	@Override
	public String getPosition() {
		if (_position == null) {
			return "";
		}
		else {
			return _position;
		}
	}

	@Override
	public void setPosition(String position) {
		_position = position;
	}

	@JSON
	@Override
	public int getApproveStatus() {
		return _approveStatus;
	}

	@Override
	public void setApproveStatus(int approveStatus) {
		_approveStatus = approveStatus;
	}

	@JSON
	@Override
	public long getResearcherUserId() {
		return _researcherUserId;
	}

	@Override
	public void setResearcherUserId(long researcherUserId) {
		_researcherUserId = researcherUserId;
	}

	@Override
	public String getResearcherUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getResearcherUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setResearcherUserUuid(String researcherUserUuid) {
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Researcher.class.getName()));
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
			getCompanyId(), Researcher.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Researcher toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Researcher>
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
		ResearcherImpl researcherImpl = new ResearcherImpl();

		researcherImpl.setMvccVersion(getMvccVersion());
		researcherImpl.setUuid(getUuid());
		researcherImpl.setResearcherId(getResearcherId());
		researcherImpl.setGroupId(getGroupId());
		researcherImpl.setCompanyId(getCompanyId());
		researcherImpl.setUserId(getUserId());
		researcherImpl.setUserName(getUserName());
		researcherImpl.setCreateDate(getCreateDate());
		researcherImpl.setModifiedDate(getModifiedDate());
		researcherImpl.setStatus(getStatus());
		researcherImpl.setStatusByUserId(getStatusByUserId());
		researcherImpl.setStatusByUserName(getStatusByUserName());
		researcherImpl.setStatusDate(getStatusDate());
		researcherImpl.setName(getName());
		researcherImpl.setEmail(getEmail());
		researcherImpl.setBirth(getBirth());
		researcherImpl.setPhone(getPhone());
		researcherImpl.setInstitution(getInstitution());
		researcherImpl.setOfficeContact(getOfficeContact());
		researcherImpl.setPosition(getPosition());
		researcherImpl.setApproveStatus(getApproveStatus());
		researcherImpl.setResearcherUserId(getResearcherUserId());

		researcherImpl.resetOriginalValues();

		return researcherImpl;
	}

	@Override
	public int compareTo(Researcher researcher) {
		int value = 0;

		if (getResearcherId() < researcher.getResearcherId()) {
			value = -1;
		}
		else if (getResearcherId() > researcher.getResearcherId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), researcher.getCreateDate());

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

		if (!(object instanceof Researcher)) {
			return false;
		}

		Researcher researcher = (Researcher)object;

		long primaryKey = researcher.getPrimaryKey();

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
		_originalStatus = _status;

		_setOriginalStatus = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Researcher> toCacheModel() {
		ResearcherCacheModel researcherCacheModel = new ResearcherCacheModel();

		researcherCacheModel.mvccVersion = getMvccVersion();

		researcherCacheModel.uuid = getUuid();

		String uuid = researcherCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			researcherCacheModel.uuid = null;
		}

		researcherCacheModel.researcherId = getResearcherId();

		researcherCacheModel.groupId = getGroupId();

		researcherCacheModel.companyId = getCompanyId();

		researcherCacheModel.userId = getUserId();

		researcherCacheModel.userName = getUserName();

		String userName = researcherCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			researcherCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			researcherCacheModel.createDate = createDate.getTime();
		}
		else {
			researcherCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			researcherCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			researcherCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		researcherCacheModel.status = getStatus();

		researcherCacheModel.statusByUserId = getStatusByUserId();

		researcherCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = researcherCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			researcherCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			researcherCacheModel.statusDate = statusDate.getTime();
		}
		else {
			researcherCacheModel.statusDate = Long.MIN_VALUE;
		}

		researcherCacheModel.name = getName();

		String name = researcherCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			researcherCacheModel.name = null;
		}

		researcherCacheModel.email = getEmail();

		String email = researcherCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			researcherCacheModel.email = null;
		}

		Date birth = getBirth();

		if (birth != null) {
			researcherCacheModel.birth = birth.getTime();
		}
		else {
			researcherCacheModel.birth = Long.MIN_VALUE;
		}

		researcherCacheModel.phone = getPhone();

		String phone = researcherCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			researcherCacheModel.phone = null;
		}

		researcherCacheModel.institution = getInstitution();

		String institution = researcherCacheModel.institution;

		if ((institution != null) && (institution.length() == 0)) {
			researcherCacheModel.institution = null;
		}

		researcherCacheModel.officeContact = getOfficeContact();

		String officeContact = researcherCacheModel.officeContact;

		if ((officeContact != null) && (officeContact.length() == 0)) {
			researcherCacheModel.officeContact = null;
		}

		researcherCacheModel.position = getPosition();

		String position = researcherCacheModel.position;

		if ((position != null) && (position.length() == 0)) {
			researcherCacheModel.position = null;
		}

		researcherCacheModel.approveStatus = getApproveStatus();

		researcherCacheModel.researcherUserId = getResearcherUserId();

		return researcherCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Researcher, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Researcher, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Researcher, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Researcher)this);

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
		Map<String, Function<Researcher, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Researcher, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Researcher, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Researcher)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Researcher>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Researcher.class, ModelWrapper.class);

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _researcherId;
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
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _name;
	private String _email;
	private Date _birth;
	private String _phone;
	private String _institution;
	private String _officeContact;
	private String _position;
	private int _approveStatus;
	private long _researcherUserId;
	private long _columnBitmask;
	private Researcher _escapedModel;

}