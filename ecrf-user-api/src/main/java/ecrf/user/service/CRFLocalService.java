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

package ecrf.user.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import ecrf.user.model.CRF;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for CRF. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ryu W.C.
 * @see CRFLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CRFLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>ecrf.user.service.impl.CRFLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the crf local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CRFLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the crf to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crf the crf
	 * @return the crf that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CRF addCRF(CRF crf);

	public CRF addCRF(
			String crfName, String crfVersion, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, int applyDateYear,
			int applyDateMonth, int applyDateDay, int crfStatus,
			ServiceContext crfsc, ServiceContext dtsc)
		throws PortalException;

	/**
	 * Creates a new crf with the primary key. Does not add the crf to the database.
	 *
	 * @param crfId the primary key for the new crf
	 * @return the new crf
	 */
	@Transactional(enabled = false)
	public CRF createCRF(long crfId);

	/**
	 * Deletes the crf from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crf the crf
	 * @return the crf that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public CRF deleteCRF(CRF crf);

	public CRF deleteCRF(CRF crf, ServiceContext sc);

	/**
	 * Deletes the crf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf that was removed
	 * @throws PortalException if a crf with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public CRF deleteCRF(long crfId) throws PortalException;

	public CRF deleteCRF(long crfId, ServiceContext sc) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRF fetchCRF(long crfId);

	/**
	 * Returns the crf matching the UUID and group.
	 *
	 * @param uuid the crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf, or <code>null</code> if a matching crf could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRF fetchCRFByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the crf with the primary key.
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf
	 * @throws PortalException if a crf with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRF getCRF(long crfId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRF getCRFByDataTypeId(long dataTypeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRF> getCRFByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRF> getCRFByGroupId(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRF> getCRFByGroupId(
		long groupId, int start, int end, OrderByComparator comparator);

	/**
	 * Returns the crf matching the UUID and group.
	 *
	 * @param uuid the crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf
	 * @throws PortalException if a matching crf could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRF getCRFByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCRFCount(long groupId);

	/**
	 * Returns a range of all the crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of crfs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRF> getCRFs(int start, int end);

	/**
	 * Returns all the crfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the crfs
	 * @param companyId the primary key of the company
	 * @return the matching crfs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRF> getCRFsByUuidAndCompanyId(String uuid, long companyId);

	/**
	 * Returns a range of crfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the crfs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crfs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRF> getCRFsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRF> orderByComparator);

	/**
	 * Returns the number of crfs.
	 *
	 * @return the number of crfs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCRFsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getDataTypeId(long crfId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getTitle(long crfId, Locale locale);

	/**
	 * Updates the crf in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crf the crf
	 * @return the crf that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CRF updateCRF(CRF crf);

	public CRF updateCRF(
			long crfId, String crfName, String crfVersion,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			int applyDateYear, int applyDateMonth, int applyDateDay,
			int crfStatus, ServiceContext crfsc, ServiceContext dtsc)
		throws PortalException;

	public CRF updateCRFStatus(long crfId, int crfStatus, ServiceContext sc);

}