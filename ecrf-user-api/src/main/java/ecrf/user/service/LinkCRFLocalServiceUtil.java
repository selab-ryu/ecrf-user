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
 * Provides the local service utility for LinkCRF. This utility wraps
 * <code>ecrf.user.service.impl.LinkCRFLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see LinkCRFLocalService
 * @generated
 */
public class LinkCRFLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.LinkCRFLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the link crf to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkCRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linkCRF the link crf
	 * @return the link crf that was added
	 */
	public static ecrf.user.model.LinkCRF addLinkCRF(
		ecrf.user.model.LinkCRF linkCRF) {

		return getService().addLinkCRF(linkCRF);
	}

	public static ecrf.user.model.LinkCRF addLinkCRF(
			long subjectId, long crfId, long structuredDataId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addLinkCRF(subjectId, crfId, structuredDataId, sc);
	}

	public static int countAllLinkCRF() {
		return getService().countAllLinkCRF();
	}

	public static int countLinkByStructuredDataId(long structuredDataId) {
		return getService().countLinkByStructuredDataId(structuredDataId);
	}

	public static int countLinkBySubjectId(long subjectId) {
		return getService().countLinkBySubjectId(subjectId);
	}

	public static int countLinkCRFByG_C(long groupId, long crfId) {
		return getService().countLinkCRFByG_C(groupId, crfId);
	}

	public static int countLinkCRFByG_S(long groupId, long subjectId) {
		return getService().countLinkCRFByG_S(groupId, subjectId);
	}

	public static int countLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId) {

		return getService().countLinkCRFByG_S_C(groupId, subjectId, crfId);
	}

	public static int countLinkCRFByGroupId(long groupId) {
		return getService().countLinkCRFByGroupId(groupId);
	}

	/**
	 * Creates a new link crf with the primary key. Does not add the link crf to the database.
	 *
	 * @param linkId the primary key for the new link crf
	 * @return the new link crf
	 */
	public static ecrf.user.model.LinkCRF createLinkCRF(long linkId) {
		return getService().createLinkCRF(linkId);
	}

	/**
	 * Deletes the link crf from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkCRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linkCRF the link crf
	 * @return the link crf that was removed
	 */
	public static ecrf.user.model.LinkCRF deleteLinkCRF(
		ecrf.user.model.LinkCRF linkCRF) {

		return getService().deleteLinkCRF(linkCRF);
	}

	/**
	 * Deletes the link crf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkCRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf that was removed
	 * @throws PortalException if a link crf with the primary key could not be found
	 */
	public static ecrf.user.model.LinkCRF deleteLinkCRF(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLinkCRF(linkId);
	}

	public static void deleteLinkCRFs(long[] linkIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteLinkCRFs(linkIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.LinkCRFModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.LinkCRFModelImpl</code>.
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

	public static ecrf.user.model.LinkCRF fetchLinkCRF(long linkId) {
		return getService().fetchLinkCRF(linkId);
	}

	/**
	 * Returns the link crf matching the UUID and group.
	 *
	 * @param uuid the link crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static ecrf.user.model.LinkCRF fetchLinkCRFByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLinkCRFByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getAllLinkCRF() {
		return getService().getAllLinkCRF();
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getAllLinkCRF(
		int start, int end) {

		return getService().getAllLinkCRF(start, end);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getAllLinkCRF(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return getService().getAllLinkCRF(start, end, comparator);
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
	 * Returns the link crf with the primary key.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf
	 * @throws PortalException if a link crf with the primary key could not be found
	 */
	public static ecrf.user.model.LinkCRF getLinkCRF(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLinkCRF(linkId);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByC_S(
		long crfId, long subjectId) {

		return getService().getLinkCRFByC_S(crfId, subjectId);
	}

	public static ecrf.user.model.LinkCRF getLinkCRFByC_S_SD(
			long crfId, long subjectId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getService().getLinkCRFByC_S_SD(
			crfId, subjectId, structuredDataId);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_C(
		long groupId, long crfId) {

		return getService().getLinkCRFByG_C(groupId, crfId);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_C(
		long groupId, long crfId, int start, int end) {

		return getService().getLinkCRFByG_C(groupId, crfId, start, end);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return getService().getLinkCRFByG_C(
			groupId, crfId, start, end, comparator);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S(
		long groupId, long subjectId) {

		return getService().getLinkCRFByG_S(groupId, subjectId);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S(
		long groupId, long subjectId, int start, int end) {

		return getService().getLinkCRFByG_S(groupId, subjectId, start, end);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S(
		long groupId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return getService().getLinkCRFByG_S(
			groupId, subjectId, start, end, comparator);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId) {

		return getService().getLinkCRFByG_S_C(groupId, subjectId, crfId);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end) {

		return getService().getLinkCRFByG_S_C(
			groupId, subjectId, crfId, start, end);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return getService().getLinkCRFByG_S_C(
			groupId, subjectId, crfId, start, end, comparator);
	}

	public static ecrf.user.model.LinkCRF getLinkCRFByG_S_C_SD(
			long groupId, long subjectId, long crfId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getService().getLinkCRFByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByGroupId(
		long groupId) {

		return getService().getLinkCRFByGroupId(groupId);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByGroupId(
		long groupId, int start, int end) {

		return getService().getLinkCRFByGroupId(groupId, start, end);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return getService().getLinkCRFByGroupId(
			groupId, start, end, comparator);
	}

	public static ecrf.user.model.LinkCRF getLinkCRFBySdId(
			long structuredDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLinkCRFBySdId(structuredDataId);
	}

	public static ecrf.user.model.LinkCRF getLinkCRFBySId(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLinkCRFBySId(subjectId);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFBySubjectId(
		long subjectId) {

		return getService().getLinkCRFBySubjectId(subjectId);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFBySubjectId(
		long subjectId, int start, int end) {

		return getService().getLinkCRFBySubjectId(subjectId, start, end);
	}

	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return getService().getLinkCRFBySubjectId(
			subjectId, start, end, comparator);
	}

	/**
	 * Returns the link crf matching the UUID and group.
	 *
	 * @param uuid the link crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching link crf
	 * @throws PortalException if a matching link crf could not be found
	 */
	public static ecrf.user.model.LinkCRF getLinkCRFByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLinkCRFByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of link crfs
	 */
	public static java.util.List<ecrf.user.model.LinkCRF> getLinkCRFs(
		int start, int end) {

		return getService().getLinkCRFs(start, end);
	}

	/**
	 * Returns all the link crfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the link crfs
	 * @param companyId the primary key of the company
	 * @return the matching link crfs, or an empty list if no matches were found
	 */
	public static java.util.List<ecrf.user.model.LinkCRF>
		getLinkCRFsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getLinkCRFsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of link crfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the link crfs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching link crfs, or an empty list if no matches were found
	 */
	public static java.util.List<ecrf.user.model.LinkCRF>
		getLinkCRFsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.LinkCRF> orderByComparator) {

		return getService().getLinkCRFsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of link crfs.
	 *
	 * @return the number of link crfs
	 */
	public static int getLinkCRFsCount() {
		return getService().getLinkCRFsCount();
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

	/**
	 * Updates the link crf in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkCRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linkCRF the link crf
	 * @return the link crf that was updated
	 */
	public static ecrf.user.model.LinkCRF updateLinkCRF(
		ecrf.user.model.LinkCRF linkCRF) {

		return getService().updateLinkCRF(linkCRF);
	}

	public static ecrf.user.model.LinkCRF updateLinkCRF(
			long linkId, long subjectId, long crfId, long structuredDataId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateLinkCRF(
			linkId, subjectId, crfId, structuredDataId, sc);
	}

	public static LinkCRFLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LinkCRFLocalService, LinkCRFLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LinkCRFLocalService.class);

		ServiceTracker<LinkCRFLocalService, LinkCRFLocalService>
			serviceTracker =
				new ServiceTracker<LinkCRFLocalService, LinkCRFLocalService>(
					bundle.getBundleContext(), LinkCRFLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}