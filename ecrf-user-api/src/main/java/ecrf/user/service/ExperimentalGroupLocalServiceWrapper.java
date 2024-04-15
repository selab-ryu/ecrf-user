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
 * Provides a wrapper for {@link ExperimentalGroupLocalService}.
 *
 * @author Ryu W.C.
 * @see ExperimentalGroupLocalService
 * @generated
 */
public class ExperimentalGroupLocalServiceWrapper
	implements ExperimentalGroupLocalService,
			   ServiceWrapper<ExperimentalGroupLocalService> {

	public ExperimentalGroupLocalServiceWrapper(
		ExperimentalGroupLocalService experimentalGroupLocalService) {

		_experimentalGroupLocalService = experimentalGroupLocalService;
	}

	/**
	 * Adds the experimental group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperimentalGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experimentalGroup the experimental group
	 * @return the experimental group that was added
	 */
	@Override
	public ecrf.user.model.ExperimentalGroup addExperimentalGroup(
		ecrf.user.model.ExperimentalGroup experimentalGroup) {

		return _experimentalGroupLocalService.addExperimentalGroup(
			experimentalGroup);
	}

	/**
	 * Creates a new experimental group with the primary key. Does not add the experimental group to the database.
	 *
	 * @param experimentalGroupId the primary key for the new experimental group
	 * @return the new experimental group
	 */
	@Override
	public ecrf.user.model.ExperimentalGroup createExperimentalGroup(
		long experimentalGroupId) {

		return _experimentalGroupLocalService.createExperimentalGroup(
			experimentalGroupId);
	}

	/**
	 * Deletes the experimental group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperimentalGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experimentalGroup the experimental group
	 * @return the experimental group that was removed
	 */
	@Override
	public ecrf.user.model.ExperimentalGroup deleteExperimentalGroup(
		ecrf.user.model.ExperimentalGroup experimentalGroup) {

		return _experimentalGroupLocalService.deleteExperimentalGroup(
			experimentalGroup);
	}

	/**
	 * Deletes the experimental group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperimentalGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group that was removed
	 * @throws PortalException if a experimental group with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.ExperimentalGroup deleteExperimentalGroup(
			long experimentalGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experimentalGroupLocalService.deleteExperimentalGroup(
			experimentalGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experimentalGroupLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _experimentalGroupLocalService.dynamicQuery();
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

		return _experimentalGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ExperimentalGroupModelImpl</code>.
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

		return _experimentalGroupLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ExperimentalGroupModelImpl</code>.
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

		return _experimentalGroupLocalService.dynamicQuery(
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

		return _experimentalGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _experimentalGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.ExperimentalGroup fetchExperimentalGroup(
		long experimentalGroupId) {

		return _experimentalGroupLocalService.fetchExperimentalGroup(
			experimentalGroupId);
	}

	/**
	 * Returns the experimental group matching the UUID and group.
	 *
	 * @param uuid the experimental group's UUID
	 * @param groupId the primary key of the group
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ecrf.user.model.ExperimentalGroup
		fetchExperimentalGroupByUuidAndGroupId(String uuid, long groupId) {

		return _experimentalGroupLocalService.
			fetchExperimentalGroupByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _experimentalGroupLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the experimental group with the primary key.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group
	 * @throws PortalException if a experimental group with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.ExperimentalGroup getExperimentalGroup(
			long experimentalGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experimentalGroupLocalService.getExperimentalGroup(
			experimentalGroupId);
	}

	/**
	 * Returns the experimental group matching the UUID and group.
	 *
	 * @param uuid the experimental group's UUID
	 * @param groupId the primary key of the group
	 * @return the matching experimental group
	 * @throws PortalException if a matching experimental group could not be found
	 */
	@Override
	public ecrf.user.model.ExperimentalGroup
			getExperimentalGroupByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experimentalGroupLocalService.
			getExperimentalGroupByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of experimental groups
	 */
	@Override
	public java.util.List<ecrf.user.model.ExperimentalGroup>
		getExperimentalGroups(int start, int end) {

		return _experimentalGroupLocalService.getExperimentalGroups(start, end);
	}

	/**
	 * Returns all the experimental groups matching the UUID and company.
	 *
	 * @param uuid the UUID of the experimental groups
	 * @param companyId the primary key of the company
	 * @return the matching experimental groups, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.ExperimentalGroup>
		getExperimentalGroupsByUuidAndCompanyId(String uuid, long companyId) {

		return _experimentalGroupLocalService.
			getExperimentalGroupsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of experimental groups matching the UUID and company.
	 *
	 * @param uuid the UUID of the experimental groups
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching experimental groups, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.ExperimentalGroup>
		getExperimentalGroupsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.ExperimentalGroup> orderByComparator) {

		return _experimentalGroupLocalService.
			getExperimentalGroupsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of experimental groups.
	 *
	 * @return the number of experimental groups
	 */
	@Override
	public int getExperimentalGroupsCount() {
		return _experimentalGroupLocalService.getExperimentalGroupsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _experimentalGroupLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _experimentalGroupLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _experimentalGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experimentalGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the experimental group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperimentalGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experimentalGroup the experimental group
	 * @return the experimental group that was updated
	 */
	@Override
	public ecrf.user.model.ExperimentalGroup updateExperimentalGroup(
		ecrf.user.model.ExperimentalGroup experimentalGroup) {

		return _experimentalGroupLocalService.updateExperimentalGroup(
			experimentalGroup);
	}

	@Override
	public ExperimentalGroupLocalService getWrappedService() {
		return _experimentalGroupLocalService;
	}

	@Override
	public void setWrappedService(
		ExperimentalGroupLocalService experimentalGroupLocalService) {

		_experimentalGroupLocalService = experimentalGroupLocalService;
	}

	private ExperimentalGroupLocalService _experimentalGroupLocalService;

}