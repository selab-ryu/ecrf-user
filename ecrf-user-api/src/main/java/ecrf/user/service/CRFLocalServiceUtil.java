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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import ecrf.user.model.CRF;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for CRF. This utility wraps
 * <code>ecrf.user.service.impl.CRFLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see CRFLocalService
 * @generated
 */
public class CRFLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.CRFLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static CRF addCRF(CRF crf) {
		return getService().addCRF(crf);
	}

	public static CRF addCRF(
			String crfName, String crfVersion,
			Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, int applyDateYear,
			int applyDateMonth, int applyDateDay, int crfStatus,
			com.liferay.portal.kernel.service.ServiceContext crfsc,
			com.liferay.portal.kernel.service.ServiceContext dtsc)
		throws PortalException {

		return getService().addCRF(
			crfName, crfVersion, titleMap, descriptionMap, applyDateYear,
			applyDateMonth, applyDateDay, crfStatus, crfsc, dtsc);
	}

	/**
	 * Creates a new crf with the primary key. Does not add the crf to the database.
	 *
	 * @param crfId the primary key for the new crf
	 * @return the new crf
	 */
	public static CRF createCRF(long crfId) {
		return getService().createCRF(crfId);
	}

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
	public static CRF deleteCRF(CRF crf) {
		return getService().deleteCRF(crf);
	}

	public static CRF deleteCRF(
		CRF crf, com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().deleteCRF(crf, sc);
	}

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
	public static CRF deleteCRF(long crfId) throws PortalException {
		return getService().deleteCRF(crfId);
	}

	public static CRF deleteCRF(
			long crfId, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().deleteCRF(crfId, sc);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CRF fetchCRF(long crfId) {
		return getService().fetchCRF(crfId);
	}

	/**
	 * Returns the crf matching the UUID and group.
	 *
	 * @param uuid the crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchCRFByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchCRFByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the crf with the primary key.
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf
	 * @throws PortalException if a crf with the primary key could not be found
	 */
	public static CRF getCRF(long crfId) throws PortalException {
		return getService().getCRF(crfId);
	}

	public static CRF getCRFByDataTypeId(long dataTypeId) {
		return getService().getCRFByDataTypeId(dataTypeId);
	}

	public static List<CRF> getCRFByGroupId(long groupId) {
		return getService().getCRFByGroupId(groupId);
	}

	public static List<CRF> getCRFByGroupId(long groupId, int start, int end) {
		return getService().getCRFByGroupId(groupId, start, end);
	}

	public static List<CRF> getCRFByGroupId(
		long groupId, int start, int end, OrderByComparator comparator) {

		return getService().getCRFByGroupId(groupId, start, end, comparator);
	}

	/**
	 * Returns the crf matching the UUID and group.
	 *
	 * @param uuid the crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf
	 * @throws PortalException if a matching crf could not be found
	 */
	public static CRF getCRFByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getCRFByUuidAndGroupId(uuid, groupId);
	}

	public static int getCRFCount(long groupId) {
		return getService().getCRFCount(groupId);
	}

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
	public static List<CRF> getCRFs(int start, int end) {
		return getService().getCRFs(start, end);
	}

	/**
	 * Returns all the crfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the crfs
	 * @param companyId the primary key of the company
	 * @return the matching crfs, or an empty list if no matches were found
	 */
	public static List<CRF> getCRFsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCRFsByUuidAndCompanyId(uuid, companyId);
	}

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
	public static List<CRF> getCRFsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRF> orderByComparator) {

		return getService().getCRFsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crfs.
	 *
	 * @return the number of crfs
	 */
	public static int getCRFsCount() {
		return getService().getCRFsCount();
	}

	public static long getDataTypeId(long crfId) {
		return getService().getDataTypeId(crfId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static String getTitle(long crfId, java.util.Locale locale) {
		return getService().getTitle(crfId, locale);
	}

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
	public static CRF updateCRF(CRF crf) {
		return getService().updateCRF(crf);
	}

	public static CRF updateCRF(
			long crfId, String crfName, String crfVersion,
			Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, int applyDateYear,
			int applyDateMonth, int applyDateDay, int crfStatus,
			com.liferay.portal.kernel.service.ServiceContext crfsc,
			com.liferay.portal.kernel.service.ServiceContext dtsc)
		throws PortalException {

		return getService().updateCRF(
			crfId, crfName, crfVersion, titleMap, descriptionMap, applyDateYear,
			applyDateMonth, applyDateDay, crfStatus, crfsc, dtsc);
	}

	public static CRF updateCRFStatus(
		long crfId, int crfStatus,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().updateCRFStatus(crfId, crfStatus, sc);
	}

	public static CRFLocalService getService() {
		return _service;
	}

	private static volatile CRFLocalService _service;

}