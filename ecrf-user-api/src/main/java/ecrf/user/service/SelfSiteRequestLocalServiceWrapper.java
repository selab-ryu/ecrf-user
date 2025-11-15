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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SelfSiteRequestLocalService}.
 *
 * @author Ryu W.C.
 * @see SelfSiteRequestLocalService
 * @generated
 */
public class SelfSiteRequestLocalServiceWrapper
	implements SelfSiteRequestLocalService,
			   ServiceWrapper<SelfSiteRequestLocalService> {

	public SelfSiteRequestLocalServiceWrapper(
		SelfSiteRequestLocalService selfSiteRequestLocalService) {

		_selfSiteRequestLocalService = selfSiteRequestLocalService;
	}

	@Override
	public ecrf.user.model.SelfSiteRequest addRequest(
			String email, String lastName, String firstName, String phone,
			String title, String description,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selfSiteRequestLocalService.addRequest(
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
	@Override
	public ecrf.user.model.SelfSiteRequest addSelfSiteRequest(
		ecrf.user.model.SelfSiteRequest selfSiteRequest) {

		return _selfSiteRequestLocalService.addSelfSiteRequest(selfSiteRequest);
	}

	/**
	 * Creates a new self site request with the primary key. Does not add the self site request to the database.
	 *
	 * @param selfSiteRequestId the primary key for the new self site request
	 * @return the new self site request
	 */
	@Override
	public ecrf.user.model.SelfSiteRequest createSelfSiteRequest(
		long selfSiteRequestId) {

		return _selfSiteRequestLocalService.createSelfSiteRequest(
			selfSiteRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selfSiteRequestLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public ecrf.user.model.SelfSiteRequest deleteSelfSiteRequest(
			long selfSiteRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selfSiteRequestLocalService.deleteSelfSiteRequest(
			selfSiteRequestId);
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
	@Override
	public ecrf.user.model.SelfSiteRequest deleteSelfSiteRequest(
		ecrf.user.model.SelfSiteRequest selfSiteRequest) {

		return _selfSiteRequestLocalService.deleteSelfSiteRequest(
			selfSiteRequest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _selfSiteRequestLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _selfSiteRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _selfSiteRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _selfSiteRequestLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _selfSiteRequestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _selfSiteRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.SelfSiteRequest fetchSelfSiteRequest(
		long selfSiteRequestId) {

		return _selfSiteRequestLocalService.fetchSelfSiteRequest(
			selfSiteRequestId);
	}

	/**
	 * Returns the self site request matching the UUID and group.
	 *
	 * @param uuid the self site request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	@Override
	public ecrf.user.model.SelfSiteRequest fetchSelfSiteRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return _selfSiteRequestLocalService.
			fetchSelfSiteRequestByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _selfSiteRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<ecrf.user.model.SelfSiteRequest> getAllSiteRequest() {
		return _selfSiteRequestLocalService.getAllSiteRequest();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _selfSiteRequestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _selfSiteRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _selfSiteRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selfSiteRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the self site request with the primary key.
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request
	 * @throws PortalException if a self site request with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.SelfSiteRequest getSelfSiteRequest(
			long selfSiteRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selfSiteRequestLocalService.getSelfSiteRequest(
			selfSiteRequestId);
	}

	/**
	 * Returns the self site request matching the UUID and group.
	 *
	 * @param uuid the self site request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching self site request
	 * @throws PortalException if a matching self site request could not be found
	 */
	@Override
	public ecrf.user.model.SelfSiteRequest getSelfSiteRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selfSiteRequestLocalService.getSelfSiteRequestByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<ecrf.user.model.SelfSiteRequest> getSelfSiteRequests(
		int start, int end) {

		return _selfSiteRequestLocalService.getSelfSiteRequests(start, end);
	}

	/**
	 * Returns all the self site requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the self site requests
	 * @param companyId the primary key of the company
	 * @return the matching self site requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.SelfSiteRequest>
		getSelfSiteRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return _selfSiteRequestLocalService.
			getSelfSiteRequestsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<ecrf.user.model.SelfSiteRequest>
		getSelfSiteRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.SelfSiteRequest> orderByComparator) {

		return _selfSiteRequestLocalService.
			getSelfSiteRequestsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of self site requests.
	 *
	 * @return the number of self site requests
	 */
	@Override
	public int getSelfSiteRequestsCount() {
		return _selfSiteRequestLocalService.getSelfSiteRequestsCount();
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
	@Override
	public ecrf.user.model.SelfSiteRequest updateSelfSiteRequest(
		ecrf.user.model.SelfSiteRequest selfSiteRequest) {

		return _selfSiteRequestLocalService.updateSelfSiteRequest(
			selfSiteRequest);
	}

	@Override
	public SelfSiteRequestLocalService getWrappedService() {
		return _selfSiteRequestLocalService;
	}

	@Override
	public void setWrappedService(
		SelfSiteRequestLocalService selfSiteRequestLocalService) {

		_selfSiteRequestLocalService = selfSiteRequestLocalService;
	}

	private SelfSiteRequestLocalService _selfSiteRequestLocalService;

}