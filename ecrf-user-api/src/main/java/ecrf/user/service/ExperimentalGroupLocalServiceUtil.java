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
 * Provides the local service utility for ExperimentalGroup. This utility wraps
 * <code>ecrf.user.service.impl.ExperimentalGroupLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see ExperimentalGroupLocalService
 * @generated
 */
public class ExperimentalGroupLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.ExperimentalGroupLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ecrf.user.model.ExperimentalGroup addExperimentalGroup(
		ecrf.user.model.ExperimentalGroup experimentalGroup) {

		return getService().addExperimentalGroup(experimentalGroup);
	}

	public static ecrf.user.model.ExperimentalGroup addExpGroup(
			String name, String abbr, String description, int type,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addExpGroup(name, abbr, description, type, sc);
	}

	/**
	 * Creates a new experimental group with the primary key. Does not add the experimental group to the database.
	 *
	 * @param experimentalGroupId the primary key for the new experimental group
	 * @return the new experimental group
	 */
	public static ecrf.user.model.ExperimentalGroup createExperimentalGroup(
		long experimentalGroupId) {

		return getService().createExperimentalGroup(experimentalGroupId);
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
	public static ecrf.user.model.ExperimentalGroup deleteExperimentalGroup(
		ecrf.user.model.ExperimentalGroup experimentalGroup) {

		return getService().deleteExperimentalGroup(experimentalGroup);
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
	public static ecrf.user.model.ExperimentalGroup deleteExperimentalGroup(
			long experimentalGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteExperimentalGroup(experimentalGroupId);
	}

public static ExperimentalGroup deleteExpGroup(long expGroupId)
		throws PortalException {

		return getService().deleteExpGroup(expGroupId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ExperimentalGroupModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ExperimentalGroupModelImpl</code>.
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

	public static ecrf.user.model.ExperimentalGroup fetchExperimentalGroup(
		long experimentalGroupId) {

		return getService().fetchExperimentalGroup(experimentalGroupId);
	}

	/**
	 * Returns the experimental group matching the UUID and group.
	 *
	 * @param uuid the experimental group's UUID
	 * @param groupId the primary key of the group
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ecrf.user.model.ExperimentalGroup
		fetchExperimentalGroupByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchExperimentalGroupByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the experimental group with the primary key.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group
	 * @throws PortalException if a experimental group with the primary key could not be found
	 */
	public static ecrf.user.model.ExperimentalGroup getExperimentalGroup(
			long experimentalGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getExperimentalGroup(experimentalGroupId);
	}

	/**
	 * Returns the experimental group matching the UUID and group.
	 *
	 * @param uuid the experimental group's UUID
	 * @param groupId the primary key of the group
	 * @return the matching experimental group
	 * @throws PortalException if a matching experimental group could not be found
	 */
	public static ecrf.user.model.ExperimentalGroup
			getExperimentalGroupByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getExperimentalGroupByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<ecrf.user.model.ExperimentalGroup>
		getExperimentalGroups(int start, int end) {

		return getService().getExperimentalGroups(start, end);
	}

	/**
	 * Returns all the experimental groups matching the UUID and company.
	 *
	 * @param uuid the UUID of the experimental groups
	 * @param companyId the primary key of the company
	 * @return the matching experimental groups, or an empty list if no matches were found
	 */
	public static java.util.List<ecrf.user.model.ExperimentalGroup>
		getExperimentalGroupsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getExperimentalGroupsByUuidAndCompanyId(
			uuid, companyId);
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
	public static java.util.List<ecrf.user.model.ExperimentalGroup>
		getExperimentalGroupsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.ExperimentalGroup> orderByComparator) {

		return getService().getExperimentalGroupsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of experimental groups.
	 *
	 * @return the number of experimental groups
	 */
	public static int getExperimentalGroupsCount() {
		return getService().getExperimentalGroupsCount();
	}

	public static ecrf.user.model.ExperimentalGroup getExpGroupByG_N(
		long groupId, String name) {

		return getService().getExpGroupByG_N(groupId, name);
	}

	public static java.util.List<ecrf.user.model.ExperimentalGroup>
		getExpGroupByGroupId(long groupId) {

		return getService().getExpGroupByGroupId(groupId);
	}

	public static java.util.List<ecrf.user.model.ExperimentalGroup>
		getExpGroupByName(String name) {

		return getService().getExpGroupByName(name);
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
	public static ecrf.user.model.ExperimentalGroup updateExperimentalGroup(
		ecrf.user.model.ExperimentalGroup experimentalGroup) {

		return getService().updateExperimentalGroup(experimentalGroup);
	}

	public static ecrf.user.model.ExperimentalGroup updateExpGroup(
			long expGroupId, String name, String abbr, String description,
			int type, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateExpGroup(
			expGroupId, name, abbr, description, type, sc);
	}

	public static ExperimentalGroupLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ExperimentalGroupLocalService, ExperimentalGroupLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ExperimentalGroupLocalService.class);

		ServiceTracker
			<ExperimentalGroupLocalService, ExperimentalGroupLocalService>
				serviceTracker =
					new ServiceTracker
						<ExperimentalGroupLocalService,
						 ExperimentalGroupLocalService>(
							 bundle.getBundleContext(),
							 ExperimentalGroupLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}