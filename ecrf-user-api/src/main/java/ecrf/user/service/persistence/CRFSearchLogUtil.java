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

import ecrf.user.model.CRFSearchLog;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the crf search log service. This utility wraps <code>ecrf.user.service.persistence.impl.CRFSearchLogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFSearchLogPersistence
 * @generated
 */
public class CRFSearchLogUtil {

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
	public static void clearCache(CRFSearchLog crfSearchLog) {
		getPersistence().clearCache(crfSearchLog);
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
	public static Map<Serializable, CRFSearchLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CRFSearchLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CRFSearchLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CRFSearchLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CRFSearchLog update(CRFSearchLog crfSearchLog) {
		return getPersistence().update(crfSearchLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CRFSearchLog update(
		CRFSearchLog crfSearchLog, ServiceContext serviceContext) {

		return getPersistence().update(crfSearchLog, serviceContext);
	}

	/**
	 * Returns all the crf search logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf search logs
	 */
	public static List<CRFSearchLog> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the crf search logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of matching crf search logs
	 */
	public static List<CRFSearchLog> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf search logs
	 */
	public static List<CRFSearchLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf search logs
	 */
	public static List<CRFSearchLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public static CRFSearchLog findByUuid_First(
			String uuid, OrderByComparator<CRFSearchLog> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public static CRFSearchLog fetchByUuid_First(
		String uuid, OrderByComparator<CRFSearchLog> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public static CRFSearchLog findByUuid_Last(
			String uuid, OrderByComparator<CRFSearchLog> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public static CRFSearchLog fetchByUuid_Last(
		String uuid, OrderByComparator<CRFSearchLog> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the crf search logs before and after the current crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param searchLogId the primary key of the current crf search log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	public static CRFSearchLog[] findByUuid_PrevAndNext(
			long searchLogId, String uuid,
			OrderByComparator<CRFSearchLog> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().findByUuid_PrevAndNext(
			searchLogId, uuid, orderByComparator);
	}

	/**
	 * Removes all the crf search logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of crf search logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf search logs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the crf search log where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFSearchLogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public static CRFSearchLog findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf search log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public static CRFSearchLog fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf search log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public static CRFSearchLog fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the crf search log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf search log that was removed
	 */
	public static CRFSearchLog removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of crf search logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf search logs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf search logs
	 */
	public static List<CRFSearchLog> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of matching crf search logs
	 */
	public static List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf search logs
	 */
	public static List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf search logs
	 */
	public static List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public static CRFSearchLog findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFSearchLog> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public static CRFSearchLog fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public static CRFSearchLog findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFSearchLog> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public static CRFSearchLog fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the crf search logs before and after the current crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param searchLogId the primary key of the current crf search log
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	public static CRFSearchLog[] findByUuid_C_PrevAndNext(
			long searchLogId, String uuid, long companyId,
			OrderByComparator<CRFSearchLog> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().findByUuid_C_PrevAndNext(
			searchLogId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the crf search logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf search logs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the crf search log where searchLogId = &#63; or throws a <code>NoSuchCRFSearchLogException</code> if it could not be found.
	 *
	 * @param searchLogId the search log ID
	 * @return the matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public static CRFSearchLog findBySearchLogId(long searchLogId)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().findBySearchLogId(searchLogId);
	}

	/**
	 * Returns the crf search log where searchLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param searchLogId the search log ID
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public static CRFSearchLog fetchBySearchLogId(long searchLogId) {
		return getPersistence().fetchBySearchLogId(searchLogId);
	}

	/**
	 * Returns the crf search log where searchLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param searchLogId the search log ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public static CRFSearchLog fetchBySearchLogId(
		long searchLogId, boolean useFinderCache) {

		return getPersistence().fetchBySearchLogId(searchLogId, useFinderCache);
	}

	/**
	 * Removes the crf search log where searchLogId = &#63; from the database.
	 *
	 * @param searchLogId the search log ID
	 * @return the crf search log that was removed
	 */
	public static CRFSearchLog removeBySearchLogId(long searchLogId)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().removeBySearchLogId(searchLogId);
	}

	/**
	 * Returns the number of crf search logs where searchLogId = &#63;.
	 *
	 * @param searchLogId the search log ID
	 * @return the number of matching crf search logs
	 */
	public static int countBySearchLogId(long searchLogId) {
		return getPersistence().countBySearchLogId(searchLogId);
	}

	/**
	 * Caches the crf search log in the entity cache if it is enabled.
	 *
	 * @param crfSearchLog the crf search log
	 */
	public static void cacheResult(CRFSearchLog crfSearchLog) {
		getPersistence().cacheResult(crfSearchLog);
	}

	/**
	 * Caches the crf search logs in the entity cache if it is enabled.
	 *
	 * @param crfSearchLogs the crf search logs
	 */
	public static void cacheResult(List<CRFSearchLog> crfSearchLogs) {
		getPersistence().cacheResult(crfSearchLogs);
	}

	/**
	 * Creates a new crf search log with the primary key. Does not add the crf search log to the database.
	 *
	 * @param searchLogId the primary key for the new crf search log
	 * @return the new crf search log
	 */
	public static CRFSearchLog create(long searchLogId) {
		return getPersistence().create(searchLogId);
	}

	/**
	 * Removes the crf search log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log that was removed
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	public static CRFSearchLog remove(long searchLogId)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().remove(searchLogId);
	}

	public static CRFSearchLog updateImpl(CRFSearchLog crfSearchLog) {
		return getPersistence().updateImpl(crfSearchLog);
	}

	/**
	 * Returns the crf search log with the primary key or throws a <code>NoSuchCRFSearchLogException</code> if it could not be found.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	public static CRFSearchLog findByPrimaryKey(long searchLogId)
		throws ecrf.user.exception.NoSuchCRFSearchLogException {

		return getPersistence().findByPrimaryKey(searchLogId);
	}

	/**
	 * Returns the crf search log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log, or <code>null</code> if a crf search log with the primary key could not be found
	 */
	public static CRFSearchLog fetchByPrimaryKey(long searchLogId) {
		return getPersistence().fetchByPrimaryKey(searchLogId);
	}

	/**
	 * Returns all the crf search logs.
	 *
	 * @return the crf search logs
	 */
	public static List<CRFSearchLog> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of crf search logs
	 */
	public static List<CRFSearchLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf search logs
	 */
	public static List<CRFSearchLog> findAll(
		int start, int end, OrderByComparator<CRFSearchLog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf search logs
	 */
	public static List<CRFSearchLog> findAll(
		int start, int end, OrderByComparator<CRFSearchLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the crf search logs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of crf search logs.
	 *
	 * @return the number of crf search logs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CRFSearchLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CRFSearchLogPersistence, CRFSearchLogPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CRFSearchLogPersistence.class);

		ServiceTracker<CRFSearchLogPersistence, CRFSearchLogPersistence>
			serviceTracker =
				new ServiceTracker
					<CRFSearchLogPersistence, CRFSearchLogPersistence>(
						bundle.getBundleContext(),
						CRFSearchLogPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}