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
 * Provides a wrapper for {@link CRFResearcherLocalService}.
 *
 * @author Ryu W.C.
 * @see CRFResearcherLocalService
 * @generated
 */
public class CRFResearcherLocalServiceWrapper
	implements CRFResearcherLocalService,
			   ServiceWrapper<CRFResearcherLocalService> {

	public CRFResearcherLocalServiceWrapper(
		CRFResearcherLocalService crfResearcherLocalService) {

		_crfResearcherLocalService = crfResearcherLocalService;
	}

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
	@Override
	public ecrf.user.model.CRFResearcher addCRFResearcher(
		ecrf.user.model.CRFResearcher crfResearcher) {

		return _crfResearcherLocalService.addCRFResearcher(crfResearcher);
	}

	@Override
	public ecrf.user.model.CRFResearcher addCRFResearcher(
			long researcherId, long crfId, String jobTitle,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfResearcherLocalService.addCRFResearcher(
			researcherId, crfId, jobTitle, sc);
	}

	@Override
	public int countCRFResearcherByG_C(long groupId, long crfId) {
		return _crfResearcherLocalService.countCRFResearcherByG_C(
			groupId, crfId);
	}

	@Override
	public int countCRFResearcherByG_R(long groupId, long researcherId) {
		return _crfResearcherLocalService.countCRFResearcherByG_R(
			groupId, researcherId);
	}

	/**
	 * Creates a new crf researcher with the primary key. Does not add the crf researcher to the database.
	 *
	 * @param crfResearcherId the primary key for the new crf researcher
	 * @return the new crf researcher
	 */
	@Override
	public ecrf.user.model.CRFResearcher createCRFResearcher(
		long crfResearcherId) {

		return _crfResearcherLocalService.createCRFResearcher(crfResearcherId);
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
	@Override
	public ecrf.user.model.CRFResearcher deleteCRFResearcher(
		ecrf.user.model.CRFResearcher crfResearcher) {

		return _crfResearcherLocalService.deleteCRFResearcher(crfResearcher);
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
	@Override
	public ecrf.user.model.CRFResearcher deleteCRFResearcher(
			long crfResearcherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfResearcherLocalService.deleteCRFResearcher(crfResearcherId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfResearcherLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crfResearcherLocalService.dynamicQuery();
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

		return _crfResearcherLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _crfResearcherLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _crfResearcherLocalService.dynamicQuery(
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

		return _crfResearcherLocalService.dynamicQueryCount(dynamicQuery);
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

		return _crfResearcherLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.CRFResearcher fetchCRFResearcher(
		long crfResearcherId) {

		return _crfResearcherLocalService.fetchCRFResearcher(crfResearcherId);
	}

	/**
	 * Returns the crf researcher matching the UUID and group.
	 *
	 * @param uuid the crf researcher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public ecrf.user.model.CRFResearcher fetchCRFResearcherByUuidAndGroupId(
		String uuid, long groupId) {

		return _crfResearcherLocalService.fetchCRFResearcherByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crfResearcherLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the crf researcher with the primary key.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher
	 * @throws PortalException if a crf researcher with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFResearcher getCRFResearcher(long crfResearcherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfResearcherLocalService.getCRFResearcher(crfResearcherId);
	}

	@Override
	public ecrf.user.model.CRFResearcher getCRFResearcherByC_R(
		long crfId, long researcherId) {

		return _crfResearcherLocalService.getCRFResearcherByC_R(
			crfId, researcherId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByCRFId(long crfId) {

		return _crfResearcherLocalService.getCRFResearcherByCRFId(crfId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher> getCRFResearcherByG_C(
		long groupId, long crfId) {

		return _crfResearcherLocalService.getCRFResearcherByG_C(groupId, crfId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher> getCRFResearcherByG_C(
		long groupId, long crfId, int start, int end) {

		return _crfResearcherLocalService.getCRFResearcherByG_C(
			groupId, crfId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher> getCRFResearcherByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return _crfResearcherLocalService.getCRFResearcherByG_C(
			groupId, crfId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher> getCRFResearcherByG_R(
		long groupId, long researcherId) {

		return _crfResearcherLocalService.getCRFResearcherByG_R(
			groupId, researcherId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher> getCRFResearcherByG_R(
		long groupId, long researcherId, int start, int end) {

		return _crfResearcherLocalService.getCRFResearcherByG_R(
			groupId, researcherId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher> getCRFResearcherByG_R(
		long groupId, long researcherId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return _crfResearcherLocalService.getCRFResearcherByG_R(
			groupId, researcherId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByGroupId(long groupId) {

		return _crfResearcherLocalService.getCRFResearcherByGroupId(groupId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByGroupId(long groupId, int start, int end) {

		return _crfResearcherLocalService.getCRFResearcherByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return _crfResearcherLocalService.getCRFResearcherByGroupId(
			groupId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearcherByResearcherId(long researcherId) {

		return _crfResearcherLocalService.getCRFResearcherByResearcherId(
			researcherId);
	}

	/**
	 * Returns the crf researcher matching the UUID and group.
	 *
	 * @param uuid the crf researcher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf researcher
	 * @throws PortalException if a matching crf researcher could not be found
	 */
	@Override
	public ecrf.user.model.CRFResearcher getCRFResearcherByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfResearcherLocalService.getCRFResearcherByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public int getCRFResearcherCount(long groupId) {
		return _crfResearcherLocalService.getCRFResearcherCount(groupId);
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
	@Override
	public java.util.List<ecrf.user.model.CRFResearcher> getCRFResearchers(
		int start, int end) {

		return _crfResearcherLocalService.getCRFResearchers(start, end);
	}

	/**
	 * Returns all the crf researchers matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf researchers
	 * @param companyId the primary key of the company
	 * @return the matching crf researchers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearchersByUuidAndCompanyId(String uuid, long companyId) {

		return _crfResearcherLocalService.getCRFResearchersByUuidAndCompanyId(
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
	@Override
	public java.util.List<ecrf.user.model.CRFResearcher>
		getCRFResearchersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.CRFResearcher> orderByComparator) {

		return _crfResearcherLocalService.getCRFResearchersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf researchers.
	 *
	 * @return the number of crf researchers
	 */
	@Override
	public int getCRFResearchersCount() {
		return _crfResearcherLocalService.getCRFResearchersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _crfResearcherLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crfResearcherLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crfResearcherLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfResearcherLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean isResearcherInCRF(long crfId, long userId) {
		return _crfResearcherLocalService.isResearcherInCRF(crfId, userId);
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
	@Override
	public ecrf.user.model.CRFResearcher updateCRFResearcher(
		ecrf.user.model.CRFResearcher crfResearcher) {

		return _crfResearcherLocalService.updateCRFResearcher(crfResearcher);
	}

	@Override
	public void updateCRFResearchers(
			long crfId,
			java.util.ArrayList<ecrf.user.model.CRFResearcher>
				crfResearcherList,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		_crfResearcherLocalService.updateCRFResearchers(
			crfId, crfResearcherList, sc);
	}

	@Override
	public CRFResearcherLocalService getWrappedService() {
		return _crfResearcherLocalService;
	}

	@Override
	public void setWrappedService(
		CRFResearcherLocalService crfResearcherLocalService) {

		_crfResearcherLocalService = crfResearcherLocalService;
	}

	private CRFResearcherLocalService _crfResearcherLocalService;

}