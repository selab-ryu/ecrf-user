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
 * Provides a wrapper for {@link CRFLocalService}.
 *
 * @author Ryu W.C.
 * @see CRFLocalService
 * @generated
 */
public class CRFLocalServiceWrapper
	implements CRFLocalService, ServiceWrapper<CRFLocalService> {

	public CRFLocalServiceWrapper(CRFLocalService crfLocalService) {
		_crfLocalService = crfLocalService;
	}

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
	@Override
	public ecrf.user.model.CRF addCRF(ecrf.user.model.CRF crf) {
		return _crfLocalService.addCRF(crf);
	}

	@Override
	public ecrf.user.model.CRF addCRF(
			String crfName, String crfVersion,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			int defaultUILayout, int applyDateYear, int applyDateMonth,
			int applyDateDay, int crfStatus,
			com.liferay.portal.kernel.service.ServiceContext crfsc,
			com.liferay.portal.kernel.service.ServiceContext dtsc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfLocalService.addCRF(
			crfName, crfVersion, titleMap, descriptionMap, defaultUILayout,
			applyDateYear, applyDateMonth, applyDateDay, crfStatus, crfsc,
			dtsc);
	}

	/**
	 * Creates a new crf with the primary key. Does not add the crf to the database.
	 *
	 * @param crfId the primary key for the new crf
	 * @return the new crf
	 */
	@Override
	public ecrf.user.model.CRF createCRF(long crfId) {
		return _crfLocalService.createCRF(crfId);
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
	@Override
	public ecrf.user.model.CRF deleteCRF(ecrf.user.model.CRF crf) {
		return _crfLocalService.deleteCRF(crf);
	}

	@Override
	public ecrf.user.model.CRF deleteCRF(
		ecrf.user.model.CRF crf,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _crfLocalService.deleteCRF(crf, sc);
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
	@Override
	public ecrf.user.model.CRF deleteCRF(long crfId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfLocalService.deleteCRF(crfId);
	}

	@Override
	public ecrf.user.model.CRF deleteCRF(
			long crfId, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfLocalService.deleteCRF(crfId, sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crfLocalService.dynamicQuery();
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

		return _crfLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _crfLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _crfLocalService.dynamicQuery(
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

		return _crfLocalService.dynamicQueryCount(dynamicQuery);
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

		return _crfLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.CRF fetchCRF(long crfId) {
		return _crfLocalService.fetchCRF(crfId);
	}

	/**
	 * Returns the crf matching the UUID and group.
	 *
	 * @param uuid the crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf, or <code>null</code> if a matching crf could not be found
	 */
	@Override
	public ecrf.user.model.CRF fetchCRFByUuidAndGroupId(
		String uuid, long groupId) {

		return _crfLocalService.fetchCRFByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crfLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the crf with the primary key.
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf
	 * @throws PortalException if a crf with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRF getCRF(long crfId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfLocalService.getCRF(crfId);
	}

	@Override
	public ecrf.user.model.CRF getCRFByDataTypeId(long dataTypeId) {
		return _crfLocalService.getCRFByDataTypeId(dataTypeId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRF> getCRFByGroupId(long groupId) {
		return _crfLocalService.getCRFByGroupId(groupId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRF> getCRFByGroupId(
		long groupId, int start, int end) {

		return _crfLocalService.getCRFByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRF> getCRFByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return _crfLocalService.getCRFByGroupId(
			groupId, start, end, comparator);
	}

	@Override
	public ecrf.user.model.CRF getCRFByName(String name) {
		return _crfLocalService.getCRFByName(name);
	}

	/**
	 * Returns the crf matching the UUID and group.
	 *
	 * @param uuid the crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf
	 * @throws PortalException if a matching crf could not be found
	 */
	@Override
	public ecrf.user.model.CRF getCRFByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfLocalService.getCRFByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public int getCRFCount(long groupId) {
		return _crfLocalService.getCRFCount(groupId);
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
	@Override
	public java.util.List<ecrf.user.model.CRF> getCRFs(int start, int end) {
		return _crfLocalService.getCRFs(start, end);
	}

	/**
	 * Returns all the crfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the crfs
	 * @param companyId the primary key of the company
	 * @return the matching crfs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRF> getCRFsByUuidAndCompanyId(
		String uuid, long companyId) {

		return _crfLocalService.getCRFsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<ecrf.user.model.CRF> getCRFsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ecrf.user.model.CRF>
			orderByComparator) {

		return _crfLocalService.getCRFsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crfs.
	 *
	 * @return the number of crfs
	 */
	@Override
	public int getCRFsCount() {
		return _crfLocalService.getCRFsCount();
	}

	@Override
	public long getDataTypeId(long crfId) {
		return _crfLocalService.getDataTypeId(crfId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _crfLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crfLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crfLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public String getTitle(long crfId, java.util.Locale locale) {
		return _crfLocalService.getTitle(crfId, locale);
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
	@Override
	public ecrf.user.model.CRF updateCRF(ecrf.user.model.CRF crf) {
		return _crfLocalService.updateCRF(crf);
	}

	@Override
	public ecrf.user.model.CRF updateCRF(
			long crfId, String crfName, String crfVersion,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			int defaultUILayout, int applyDateYear, int applyDateMonth,
			int applyDateDay, int crfStatus,
			com.liferay.portal.kernel.service.ServiceContext crfsc,
			com.liferay.portal.kernel.service.ServiceContext dtsc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfLocalService.updateCRF(
			crfId, crfName, crfVersion, titleMap, descriptionMap,
			defaultUILayout, applyDateYear, applyDateMonth, applyDateDay,
			crfStatus, crfsc, dtsc);
	}

	@Override
	public ecrf.user.model.CRF updateCRFStatus(
		long crfId, int crfStatus,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _crfLocalService.updateCRFStatus(crfId, crfStatus, sc);
	}

	@Override
	public CRFLocalService getWrappedService() {
		return _crfLocalService;
	}

	@Override
	public void setWrappedService(CRFLocalService crfLocalService) {
		_crfLocalService = crfLocalService;
	}

	private CRFLocalService _crfLocalService;

}