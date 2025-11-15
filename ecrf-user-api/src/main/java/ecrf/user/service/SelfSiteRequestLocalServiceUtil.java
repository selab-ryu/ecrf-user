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

import ecrf.user.model.SelfSiteRequest;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SelfSiteRequest. This utility wraps
 * <code>ecrf.user.service.impl.SelfSiteRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see SelfSiteRequestLocalService
 * @generated
 */
public class SelfSiteRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.SelfSiteRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SelfSiteRequest addRequest(
			String email, String lastName, String firstName, String phone,
			String title, String description,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addRequest(
			email, lastName, firstName, phone, title, description, sc);
	}

	/**
	 * Adds the self site request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelfSiteRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param selfSiteRequest the self site request
	 * @return the self site request that was added
	 */
	public static SelfSiteRequest addSelfSiteRequest(
		SelfSiteRequest selfSiteRequest) {

		return getService().addSelfSiteRequest(selfSiteRequest);
	}

	/**
	 * Creates a new self site request with the primary key. Does not add the self site request to the database.
	 *
	 * @param selfSiteRequestId the primary key for the new self site request
	 * @return the new self site request
	 */
	public static SelfSiteRequest createSelfSiteRequest(
		long selfSiteRequestId) {

		return getService().createSelfSiteRequest(selfSiteRequestId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the self site request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelfSiteRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request that was removed
	 * @throws PortalException if a self site request with the primary key could not be found
	 */
	public static SelfSiteRequest deleteSelfSiteRequest(long selfSiteRequestId)
		throws PortalException {

		return getService().deleteSelfSiteRequest(selfSiteRequestId);
	}

	/**
	 * Deletes the self site request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelfSiteRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param selfSiteRequest the self site request
	 * @return the self site request that was removed
	 */
	public static SelfSiteRequest deleteSelfSiteRequest(
		SelfSiteRequest selfSiteRequest) {

		return getService().deleteSelfSiteRequest(selfSiteRequest);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.SelfSiteRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.SelfSiteRequestModelImpl</code>.
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

	public static SelfSiteRequest fetchSelfSiteRequest(long selfSiteRequestId) {
		return getService().fetchSelfSiteRequest(selfSiteRequestId);
	}

	/**
	 * Returns the self site request matching the UUID and group.
	 *
	 * @param uuid the self site request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public static SelfSiteRequest fetchSelfSiteRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSelfSiteRequestByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SelfSiteRequest> getAllSiteRequest() {
		return getService().getAllSiteRequest();
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

	/**
	 * Returns the self site request with the primary key.
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request
	 * @throws PortalException if a self site request with the primary key could not be found
	 */
	public static SelfSiteRequest getSelfSiteRequest(long selfSiteRequestId)
		throws PortalException {

		return getService().getSelfSiteRequest(selfSiteRequestId);
	}

	/**
	 * Returns the self site request matching the UUID and group.
	 *
	 * @param uuid the self site request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching self site request
	 * @throws PortalException if a matching self site request could not be found
	 */
	public static SelfSiteRequest getSelfSiteRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSelfSiteRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the self site requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of self site requests
	 */
	public static List<SelfSiteRequest> getSelfSiteRequests(
		int start, int end) {

		return getService().getSelfSiteRequests(start, end);
	}

	/**
	 * Returns all the self site requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the self site requests
	 * @param companyId the primary key of the company
	 * @return the matching self site requests, or an empty list if no matches were found
	 */
	public static List<SelfSiteRequest> getSelfSiteRequestsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSelfSiteRequestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of self site requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the self site requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching self site requests, or an empty list if no matches were found
	 */
	public static List<SelfSiteRequest> getSelfSiteRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getService().getSelfSiteRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of self site requests.
	 *
	 * @return the number of self site requests
	 */
	public static int getSelfSiteRequestsCount() {
		return getService().getSelfSiteRequestsCount();
	}

	/**
	 * Updates the self site request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelfSiteRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param selfSiteRequest the self site request
	 * @return the self site request that was updated
	 */
	public static SelfSiteRequest updateSelfSiteRequest(
		SelfSiteRequest selfSiteRequest) {

		return getService().updateSelfSiteRequest(selfSiteRequest);
	}

	public static SelfSiteRequestLocalService getService() {
		return _service;
	}

	private static volatile SelfSiteRequestLocalService _service;

}