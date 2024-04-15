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

package ecrf.user.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import ecrf.user.model.ExperimentalGroup;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the experimental group service. This utility wraps <code>ecrf.user.service.persistence.impl.ExperimentalGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see ExperimentalGroupPersistence
 * @generated
 */
public class ExperimentalGroupUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ExperimentalGroup experimentalGroup) {
		getPersistence().clearCache(experimentalGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ExperimentalGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ExperimentalGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExperimentalGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExperimentalGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExperimentalGroup update(
		ExperimentalGroup experimentalGroup) {

		return getPersistence().update(experimentalGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExperimentalGroup update(
		ExperimentalGroup experimentalGroup, ServiceContext serviceContext) {

		return getPersistence().update(experimentalGroup, serviceContext);
	}

	/**
	 * Returns all the experimental groups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching experimental groups
	 */
	public static List<ExperimentalGroup> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the experimental groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByUuid_First(
			String uuid, OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByUuid_First(
		String uuid, OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByUuid_Last(
			String uuid, OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByUuid_Last(
		String uuid, OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public static ExperimentalGroup[] findByUuid_PrevAndNext(
			long experimentalGroupId, String uuid,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByUuid_PrevAndNext(
			experimentalGroupId, uuid, orderByComparator);
	}

	/**
	 * Removes all the experimental groups where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of experimental groups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching experimental groups
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the experimental group where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the experimental group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the experimental group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the experimental group where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the experimental group that was removed
	 */
	public static ExperimentalGroup removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of experimental groups where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching experimental groups
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching experimental groups
	 */
	public static List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public static ExperimentalGroup[] findByUuid_C_PrevAndNext(
			long experimentalGroupId, String uuid, long companyId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByUuid_C_PrevAndNext(
			experimentalGroupId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the experimental groups where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching experimental groups
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the experimental group where experimentalGroupId = &#63; or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByExperimentalGroupId(
			long experimentalGroupId)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByExperimentalGroupId(experimentalGroupId);
	}

	/**
	 * Returns the experimental group where experimentalGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByExperimentalGroupId(
		long experimentalGroupId) {

		return getPersistence().fetchByExperimentalGroupId(experimentalGroupId);
	}

	/**
	 * Returns the experimental group where experimentalGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByExperimentalGroupId(
		long experimentalGroupId, boolean useFinderCache) {

		return getPersistence().fetchByExperimentalGroupId(
			experimentalGroupId, useFinderCache);
	}

	/**
	 * Removes the experimental group where experimentalGroupId = &#63; from the database.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the experimental group that was removed
	 */
	public static ExperimentalGroup removeByExperimentalGroupId(
			long experimentalGroupId)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().removeByExperimentalGroupId(
			experimentalGroupId);
	}

	/**
	 * Returns the number of experimental groups where experimentalGroupId = &#63;.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the number of matching experimental groups
	 */
	public static int countByExperimentalGroupId(long experimentalGroupId) {
		return getPersistence().countByExperimentalGroupId(experimentalGroupId);
	}

	/**
	 * Returns all the experimental groups where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching experimental groups
	 */
	public static List<ExperimentalGroup> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the experimental groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the experimental groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByName(
		String name, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the experimental groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByName(
		String name, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByName_First(
			String name, OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByName_First(
		String name, OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByName_Last(
			String name, OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByName_Last(
		String name, OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where name = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public static ExperimentalGroup[] findByName_PrevAndNext(
			long experimentalGroupId, String name,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByName_PrevAndNext(
			experimentalGroupId, name, orderByComparator);
	}

	/**
	 * Removes all the experimental groups where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of experimental groups where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching experimental groups
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the experimental groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching experimental groups
	 */
	public static List<ExperimentalGroup> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the experimental groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the experimental groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the experimental groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	public static List<ExperimentalGroup> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByGroupId_First(
			long groupId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByGroupId_First(
		long groupId, OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public static ExperimentalGroup findByGroupId_Last(
			long groupId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public static ExperimentalGroup fetchByGroupId_Last(
		long groupId, OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public static ExperimentalGroup[] findByGroupId_PrevAndNext(
			long experimentalGroupId, long groupId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByGroupId_PrevAndNext(
			experimentalGroupId, groupId, orderByComparator);
	}

	/**
	 * Removes all the experimental groups where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of experimental groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching experimental groups
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the experimental group in the entity cache if it is enabled.
	 *
	 * @param experimentalGroup the experimental group
	 */
	public static void cacheResult(ExperimentalGroup experimentalGroup) {
		getPersistence().cacheResult(experimentalGroup);
	}

	/**
	 * Caches the experimental groups in the entity cache if it is enabled.
	 *
	 * @param experimentalGroups the experimental groups
	 */
	public static void cacheResult(List<ExperimentalGroup> experimentalGroups) {
		getPersistence().cacheResult(experimentalGroups);
	}

	/**
	 * Creates a new experimental group with the primary key. Does not add the experimental group to the database.
	 *
	 * @param experimentalGroupId the primary key for the new experimental group
	 * @return the new experimental group
	 */
	public static ExperimentalGroup create(long experimentalGroupId) {
		return getPersistence().create(experimentalGroupId);
	}

	/**
	 * Removes the experimental group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group that was removed
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public static ExperimentalGroup remove(long experimentalGroupId)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().remove(experimentalGroupId);
	}

	public static ExperimentalGroup updateImpl(
		ExperimentalGroup experimentalGroup) {

		return getPersistence().updateImpl(experimentalGroup);
	}

	/**
	 * Returns the experimental group with the primary key or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public static ExperimentalGroup findByPrimaryKey(long experimentalGroupId)
		throws ecrf.user.exception.NoSuchExperimentalGroupException {

		return getPersistence().findByPrimaryKey(experimentalGroupId);
	}

	/**
	 * Returns the experimental group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group, or <code>null</code> if a experimental group with the primary key could not be found
	 */
	public static ExperimentalGroup fetchByPrimaryKey(
		long experimentalGroupId) {

		return getPersistence().fetchByPrimaryKey(experimentalGroupId);
	}

	/**
	 * Returns all the experimental groups.
	 *
	 * @return the experimental groups
	 */
	public static List<ExperimentalGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of experimental groups
	 */
	public static List<ExperimentalGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experimental groups
	 */
	public static List<ExperimentalGroup> findAll(
		int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of experimental groups
	 */
	public static List<ExperimentalGroup> findAll(
		int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the experimental groups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of experimental groups.
	 *
	 * @return the number of experimental groups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExperimentalGroupPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ExperimentalGroupPersistence _persistence;

}