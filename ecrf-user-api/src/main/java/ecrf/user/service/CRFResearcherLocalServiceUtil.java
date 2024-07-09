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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CRFResearcher. This utility wraps
 * <code>ecrf.user.service.impl.CRFResearcherLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see CRFResearcherLocalService
 * @generated
 */
public class CRFResearcherLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.CRFResearcherLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the crf researcher to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFResearcherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfResearcher the crf researcher
	 * @return the crf researcher that was added
	 */
	public static ecrf.user.model.CRFResearcher addCRFResearcher(
		ecrf.user.model.CRFResearcher crfResearcher) {

		return getService().addCRFResearcher(crfResearcher);
	}

	public static ecrf.user.model.CRFResearcher addCRFResearcher(
			long researcherId, long crfId, String jobTitle,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCRFResearcher(researcherId, crfId, jobTitle, sc);
	}

	public static int countCRFResearcherByG_C(long groupId, long crfId) {
		return getService().countCRFResearcherByG_C(groupId, crfId);
	}

	public static int countCRFResearcherByG_R(long groupId, long researcherId) {
		return getService().countCRFResearcherByG_R(groupId, researcherId);
	}

	/**
	 * Creates a new crf researcher with the primary key. Does not add the crf researcher to the database.
	 *
	 * @param crfResearcherId the primary key for the new crf researcher
	 * @return the new crf researcher
	 */
	public static ecrf.user.model.CRFResearcher createCRFResearcher(
		long crfResearcherId) {

		return getService().createCRFResearcher(crfResearcherId);
	}

	/**
	 * Deletes the crf researcher from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFResearcherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfResearcher the crf researcher
	 * @return the crf researcher that was removed
	 */
	public static ecrf.user.model.CRFResearcher deleteCRFResearcher(
		ecrf.user.model.CRFResearcher crfResearcher) {

		return getService().deleteCRFResearcher(crfResearcher);
	}

	/**
	 * Deletes the crf researcher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFResearcherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher that was removed
	 * @throws PortalException if a crf researcher with the primary key could not be found
	 */
	public static ecrf.user.model.CRFResearcher deleteCRFResearcher(
			long crfResearcherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCRFResearcher(crfResearcherId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ecrf.user.model.CRFResearcher fetchCRFResearcher(
		long crfResearcherId) {

		return getService().fetchCRFResearcher(crfResearcherId);
	}

	/**
	 * Returns the crf researcher matching the UUID and group.
	 *
	 * @param uuid the crf researcher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static ecrf.user.model.CRFResearcher
		fetchCRFResearcherByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchCRFResearcherByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the crf researcher with the primary key.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher
	 * @throws PortalException if a crf researcher with the primary key could not be found
	 */
	public static ecrf.user.model.CRFResearcher getCRFResearcher(
			long crfResearcherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCRFResearcher(crfResearcherId);
	}

	public static ecrf.user.model.CRFResearcher getCRFResearcherByC_R(
		long crfId, long researcherId) {

		return getService().getCRFResearcherByC_R(crfId, researcherId);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByCRFId(long crfId) {

		return getService().getCRFResearcherByCRFId(crfId);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByG_C(long groupId, long crfId) {

		return getService().getCRFResearcherByG_C(groupId, crfId);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByG_C(long groupId, long crfId, int start, int end) {

		return getService().getCRFResearcherByG_C(groupId, crfId, start, end);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByG_C(
			long groupId, long crfId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return getService().getCRFResearcherByG_C(
			groupId, crfId, start, end, comparator);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByG_R(long groupId, long researcherId) {

		return getService().getCRFResearcherByG_R(groupId, researcherId);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByG_R(
			long groupId, long researcherId, int start, int end) {

		return getService().getCRFResearcherByG_R(
			groupId, researcherId, start, end);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByG_R(
			long groupId, long researcherId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return getService().getCRFResearcherByG_R(
			groupId, researcherId, start, end, comparator);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByGroupId(long groupId) {

		return getService().getCRFResearcherByGroupId(groupId);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByGroupId(long groupId, int start, int end) {

		return getService().getCRFResearcherByGroupId(groupId, start, end);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return getService().getCRFResearcherByGroupId(
			groupId, start, end, comparator);
	}

	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByResearcherId(long researcherId) {

		return getService().getCRFResearcherByResearcherId(researcherId);
	}

	/**
	 * Returns the crf researcher matching the UUID and group.
	 *
	 * @param uuid the crf researcher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf researcher
	 * @throws PortalException if a matching crf researcher could not be found
	 */
	public static ecrf.user.model.CRFResearcher
			getCRFResearcherByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCRFResearcherByUuidAndGroupId(uuid, groupId);
	}

	public static int getCRFResearcherCount(long groupId) {
		return getService().getCRFResearcherCount(groupId);
	}

	/**
	 * Returns a range of all the crf researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of crf researchers
	 */
	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearchers(int start, int end) {

		return getService().getCRFResearchers(start, end);
	}

	/**
	 * Returns all the crf researchers matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf researchers
	 * @param companyId the primary key of the company
	 * @return the matching crf researchers, or an empty list if no matches were found
	 */
	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearchersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getCRFResearchersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of crf researchers matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf researchers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crf researchers, or an empty list if no matches were found
	 */
	public static java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearchersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.CRFResearcher> orderByComparator) {

		return getService().getCRFResearchersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf researchers.
	 *
	 * @return the number of crf researchers
	 */
	public static int getCRFResearchersCount() {
		return getService().getCRFResearchersCount();
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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean isResearcherInCRF(long crfId, long userId) {
		return getService().isResearcherInCRF(crfId, userId);
	}

	/**
	 * Updates the crf researcher in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFResearcherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfResearcher the crf researcher
	 * @return the crf researcher that was updated
	 */
	public static ecrf.user.model.CRFResearcher updateCRFResearcher(
		ecrf.user.model.CRFResearcher crfResearcher) {

		return getService().updateCRFResearcher(crfResearcher);
	}

	public static void updateCRFResearchers(
			long crfId,
			java.util.ArrayList<ecrf.user.model.CRFResearcher>
				crfResearcherList,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateCRFResearchers(crfId, crfResearcherList, sc);
	}

	public static CRFResearcherLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CRFResearcherLocalService, CRFResearcherLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CRFResearcherLocalService.class);

		ServiceTracker<CRFResearcherLocalService, CRFResearcherLocalService>
			serviceTracker =
				new ServiceTracker
					<CRFResearcherLocalService, CRFResearcherLocalService>(
						bundle.getBundleContext(),
						CRFResearcherLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}