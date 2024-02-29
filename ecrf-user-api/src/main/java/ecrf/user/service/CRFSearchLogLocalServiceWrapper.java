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
 * Provides a wrapper for {@link CRFSearchLogLocalService}.
 *
 * @author Ryu W.C.
 * @see CRFSearchLogLocalService
 * @generated
 */
public class CRFSearchLogLocalServiceWrapper
	implements CRFSearchLogLocalService,
			   ServiceWrapper<CRFSearchLogLocalService> {

	public CRFSearchLogLocalServiceWrapper(
		CRFSearchLogLocalService crfSearchLogLocalService) {

		_crfSearchLogLocalService = crfSearchLogLocalService;
	}

	/**
	 * Adds the crf search log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSearchLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSearchLog the crf search log
	 * @return the crf search log that was added
	 */
	@Override
	public ecrf.user.model.CRFSearchLog addCRFSearchLog(
		ecrf.user.model.CRFSearchLog crfSearchLog) {

		return _crfSearchLogLocalService.addCRFSearchLog(crfSearchLog);
	}

	@Override
	public ecrf.user.model.CRFSearchLog addSearchLog(
			String searchLog,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSearchLogLocalService.addSearchLog(searchLog, sc);
	}

	/**
	 * Creates a new crf search log with the primary key. Does not add the crf search log to the database.
	 *
	 * @param searchLogId the primary key for the new crf search log
	 * @return the new crf search log
	 */
	@Override
	public ecrf.user.model.CRFSearchLog createCRFSearchLog(long searchLogId) {
		return _crfSearchLogLocalService.createCRFSearchLog(searchLogId);
	}

	/**
	 * Deletes the crf search log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSearchLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSearchLog the crf search log
	 * @return the crf search log that was removed
	 */
	@Override
	public ecrf.user.model.CRFSearchLog deleteCRFSearchLog(
		ecrf.user.model.CRFSearchLog crfSearchLog) {

		return _crfSearchLogLocalService.deleteCRFSearchLog(crfSearchLog);
	}

	/**
	 * Deletes the crf search log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSearchLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log that was removed
	 * @throws PortalException if a crf search log with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFSearchLog deleteCRFSearchLog(long searchLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSearchLogLocalService.deleteCRFSearchLog(searchLogId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSearchLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crfSearchLogLocalService.dynamicQuery();
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

		return _crfSearchLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSearchLogModelImpl</code>.
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

		return _crfSearchLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSearchLogModelImpl</code>.
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

		return _crfSearchLogLocalService.dynamicQuery(
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

		return _crfSearchLogLocalService.dynamicQueryCount(dynamicQuery);
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

		return _crfSearchLogLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.CRFSearchLog fetchCRFSearchLog(long searchLogId) {
		return _crfSearchLogLocalService.fetchCRFSearchLog(searchLogId);
	}

	/**
	 * Returns the crf search log matching the UUID and group.
	 *
	 * @param uuid the crf search log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public ecrf.user.model.CRFSearchLog fetchCRFSearchLogByUuidAndGroupId(
		String uuid, long groupId) {

		return _crfSearchLogLocalService.fetchCRFSearchLogByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crfSearchLogLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the crf search log with the primary key.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log
	 * @throws PortalException if a crf search log with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFSearchLog getCRFSearchLog(long searchLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSearchLogLocalService.getCRFSearchLog(searchLogId);
	}

	/**
	 * Returns the crf search log matching the UUID and group.
	 *
	 * @param uuid the crf search log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf search log
	 * @throws PortalException if a matching crf search log could not be found
	 */
	@Override
	public ecrf.user.model.CRFSearchLog getCRFSearchLogByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSearchLogLocalService.getCRFSearchLogByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of crf search logs
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFSearchLog> getCRFSearchLogs(
		int start, int end) {

		return _crfSearchLogLocalService.getCRFSearchLogs(start, end);
	}

	/**
	 * Returns all the crf search logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf search logs
	 * @param companyId the primary key of the company
	 * @return the matching crf search logs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFSearchLog>
		getCRFSearchLogsByUuidAndCompanyId(String uuid, long companyId) {

		return _crfSearchLogLocalService.getCRFSearchLogsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of crf search logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf search logs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crf search logs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFSearchLog>
		getCRFSearchLogsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.CRFSearchLog> orderByComparator) {

		return _crfSearchLogLocalService.getCRFSearchLogsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf search logs.
	 *
	 * @return the number of crf search logs
	 */
	@Override
	public int getCRFSearchLogsCount() {
		return _crfSearchLogLocalService.getCRFSearchLogsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _crfSearchLogLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crfSearchLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crfSearchLogLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSearchLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the crf search log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSearchLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSearchLog the crf search log
	 * @return the crf search log that was updated
	 */
	@Override
	public ecrf.user.model.CRFSearchLog updateCRFSearchLog(
		ecrf.user.model.CRFSearchLog crfSearchLog) {

		return _crfSearchLogLocalService.updateCRFSearchLog(crfSearchLog);
	}

	@Override
	public CRFSearchLogLocalService getWrappedService() {
		return _crfSearchLogLocalService;
	}

	@Override
	public void setWrappedService(
		CRFSearchLogLocalService crfSearchLogLocalService) {

		_crfSearchLogLocalService = crfSearchLogLocalService;
	}

	private CRFSearchLogLocalService _crfSearchLogLocalService;

}