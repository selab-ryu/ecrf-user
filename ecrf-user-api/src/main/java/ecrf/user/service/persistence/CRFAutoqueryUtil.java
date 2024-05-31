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

import ecrf.user.model.CRFAutoquery;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the crf autoquery service. This utility wraps <code>ecrf.user.service.persistence.impl.CRFAutoqueryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFAutoqueryPersistence
 * @generated
 */
public class CRFAutoqueryUtil {

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
	public static void clearCache(CRFAutoquery crfAutoquery) {
		getPersistence().clearCache(crfAutoquery);
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
	public static Map<Serializable, CRFAutoquery> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CRFAutoquery> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CRFAutoquery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CRFAutoquery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CRFAutoquery update(CRFAutoquery crfAutoquery) {
		return getPersistence().update(crfAutoquery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CRFAutoquery update(
		CRFAutoquery crfAutoquery, ServiceContext serviceContext) {

		return getPersistence().update(crfAutoquery, serviceContext);
	}

	/**
	 * Returns all the crf autoqueries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the crf autoqueries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByUuid_First(
			String uuid, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByUuid_First(
		String uuid, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByUuid_Last(
			String uuid, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByUuid_Last(
		String uuid, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] findByUuid_PrevAndNext(
			long autoQueryId, String uuid,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUuid_PrevAndNext(
			autoQueryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of crf autoqueries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf autoqueries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the crf autoquery where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf autoquery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf autoquery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the crf autoquery where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf autoquery that was removed
	 */
	public static CRFAutoquery removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of crf autoqueries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf autoqueries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] findByUuid_C_PrevAndNext(
			long autoQueryId, String uuid, long companyId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			autoQueryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf autoqueries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the crf autoqueries where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByAutoQueryId(long autoQueryId) {
		return getPersistence().findByAutoQueryId(autoQueryId);
	}

	/**
	 * Returns a range of all the crf autoqueries where autoQueryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param autoQueryId the auto query ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByAutoQueryId(
		long autoQueryId, int start, int end) {

		return getPersistence().findByAutoQueryId(autoQueryId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where autoQueryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param autoQueryId the auto query ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByAutoQueryId(
		long autoQueryId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findByAutoQueryId(
			autoQueryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where autoQueryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param autoQueryId the auto query ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByAutoQueryId(
		long autoQueryId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAutoQueryId(
			autoQueryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByAutoQueryId_First(
			long autoQueryId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByAutoQueryId_First(
			autoQueryId, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByAutoQueryId_First(
		long autoQueryId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByAutoQueryId_First(
			autoQueryId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByAutoQueryId_Last(
			long autoQueryId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByAutoQueryId_Last(
			autoQueryId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByAutoQueryId_Last(
		long autoQueryId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByAutoQueryId_Last(
			autoQueryId, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where autoQueryId = &#63; from the database.
	 *
	 * @param autoQueryId the auto query ID
	 */
	public static void removeByAutoQueryId(long autoQueryId) {
		getPersistence().removeByAutoQueryId(autoQueryId);
	}

	/**
	 * Returns the number of crf autoqueries where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @return the number of matching crf autoqueries
	 */
	public static int countByAutoQueryId(long autoQueryId) {
		return getPersistence().countByAutoQueryId(autoQueryId);
	}

	/**
	 * Returns all the crf autoqueries where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByQueryTermId(long queryTermId) {
		return getPersistence().findByQueryTermId(queryTermId);
	}

	/**
	 * Returns a range of all the crf autoqueries where queryTermId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByQueryTermId(
		long queryTermId, int start, int end) {

		return getPersistence().findByQueryTermId(queryTermId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where queryTermId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByQueryTermId(
		long queryTermId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findByQueryTermId(
			queryTermId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where queryTermId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByQueryTermId(
		long queryTermId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQueryTermId(
			queryTermId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByQueryTermId_First(
			long queryTermId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByQueryTermId_First(
			queryTermId, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByQueryTermId_First(
		long queryTermId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByQueryTermId_First(
			queryTermId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByQueryTermId_Last(
			long queryTermId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByQueryTermId_Last(
			queryTermId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByQueryTermId_Last(
		long queryTermId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByQueryTermId_Last(
			queryTermId, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] findByQueryTermId_PrevAndNext(
			long autoQueryId, long queryTermId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByQueryTermId_PrevAndNext(
			autoQueryId, queryTermId, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where queryTermId = &#63; from the database.
	 *
	 * @param queryTermId the query term ID
	 */
	public static void removeByQueryTermId(long queryTermId) {
		getPersistence().removeByQueryTermId(queryTermId);
	}

	/**
	 * Returns the number of crf autoqueries where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @return the number of matching crf autoqueries
	 */
	public static int countByQueryTermId(long queryTermId) {
		return getPersistence().countByQueryTermId(queryTermId);
	}

	/**
	 * Returns all the crf autoqueries where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findBySubjectId(long subjectId) {
		return getPersistence().findBySubjectId(subjectId);
	}

	/**
	 * Returns a range of all the crf autoqueries where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findBySubjectId(
		long subjectId, int start, int end) {

		return getPersistence().findBySubjectId(subjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findBySubjectId(
			subjectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubjectId(
			subjectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findBySubjectId_First(
			long subjectId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findBySubjectId_First(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchBySubjectId_First(
		long subjectId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchBySubjectId_First(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findBySubjectId_Last(
			long subjectId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findBySubjectId_Last(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchBySubjectId_Last(
		long subjectId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchBySubjectId_Last(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] findBySubjectId_PrevAndNext(
			long autoQueryId, long subjectId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findBySubjectId_PrevAndNext(
			autoQueryId, subjectId, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	public static void removeBySubjectId(long subjectId) {
		getPersistence().removeBySubjectId(subjectId);
	}

	/**
	 * Returns the number of crf autoqueries where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching crf autoqueries
	 */
	public static int countBySubjectId(long subjectId) {
		return getPersistence().countBySubjectId(subjectId);
	}

	/**
	 * Returns all the crf autoqueries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the crf autoqueries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByUserId_First(
			long userId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByUserId_First(
		long userId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByUserId_Last(
			long userId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByUserId_Last(
		long userId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] findByUserId_PrevAndNext(
			long autoQueryId, long userId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByUserId_PrevAndNext(
			autoQueryId, userId, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of crf autoqueries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching crf autoqueries
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the crf autoqueries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the crf autoqueries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByGroupId_First(
			long groupId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByGroupId_First(
		long groupId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByGroupId_Last(
			long groupId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] findByGroupId_PrevAndNext(
			long autoQueryId, long groupId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByGroupId_PrevAndNext(
			autoQueryId, groupId, orderByComparator);
	}

	/**
	 * Returns all the crf autoqueries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf autoqueries that the user has permission to view
	 */
	public static List<CRFAutoquery> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the crf autoqueries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries that the user has permission to view
	 */
	public static List<CRFAutoquery> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries that the user has permission to view
	 */
	public static List<CRFAutoquery> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set of crf autoqueries that the user has permission to view where groupId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] filterFindByGroupId_PrevAndNext(
			long autoQueryId, long groupId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			autoQueryId, groupId, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of crf autoqueries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf autoqueries
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of crf autoqueries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf autoqueries that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByG_C(long groupId, long crfId) {
		return getPersistence().findByG_C(groupId, crfId);
	}

	/**
	 * Returns a range of all the crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByG_C(
		long groupId, long crfId, int start, int end) {

		return getPersistence().findByG_C(groupId, crfId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] findByG_C_PrevAndNext(
			long autoQueryId, long groupId, long crfId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByG_C_PrevAndNext(
			autoQueryId, groupId, crfId, orderByComparator);
	}

	/**
	 * Returns all the crf autoqueries that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf autoqueries that the user has permission to view
	 */
	public static List<CRFAutoquery> filterFindByG_C(long groupId, long crfId) {
		return getPersistence().filterFindByG_C(groupId, crfId);
	}

	/**
	 * Returns a range of all the crf autoqueries that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries that the user has permission to view
	 */
	public static List<CRFAutoquery> filterFindByG_C(
		long groupId, long crfId, int start, int end) {

		return getPersistence().filterFindByG_C(groupId, crfId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries that the user has permissions to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries that the user has permission to view
	 */
	public static List<CRFAutoquery> filterFindByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().filterFindByG_C(
			groupId, crfId, start, end, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set of crf autoqueries that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] filterFindByG_C_PrevAndNext(
			long autoQueryId, long groupId, long crfId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().filterFindByG_C_PrevAndNext(
			autoQueryId, groupId, crfId, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public static void removeByG_C(long groupId, long crfId) {
		getPersistence().removeByG_C(groupId, crfId);
	}

	/**
	 * Returns the number of crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf autoqueries
	 */
	public static int countByG_C(long groupId, long crfId) {
		return getPersistence().countByG_C(groupId, crfId);
	}

	/**
	 * Returns the number of crf autoqueries that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf autoqueries that the user has permission to view
	 */
	public static int filterCountByG_C(long groupId, long crfId) {
		return getPersistence().filterCountByG_C(groupId, crfId);
	}

	/**
	 * Returns all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId) {

		return getPersistence().findByG_C_S(groupId, crfId, subjectId);
	}

	/**
	 * Returns a range of all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end) {

		return getPersistence().findByG_C_S(
			groupId, crfId, subjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findByG_C_S(
			groupId, crfId, subjectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_S(
			groupId, crfId, subjectId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByG_C_S_First(
			long groupId, long crfId, long subjectId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByG_C_S_First(
			groupId, crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByG_C_S_First(
		long groupId, long crfId, long subjectId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByG_C_S_First(
			groupId, crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findByG_C_S_Last(
			long groupId, long crfId, long subjectId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByG_C_S_Last(
			groupId, crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchByG_C_S_Last(
		long groupId, long crfId, long subjectId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchByG_C_S_Last(
			groupId, crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] findByG_C_S_PrevAndNext(
			long autoQueryId, long groupId, long crfId, long subjectId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByG_C_S_PrevAndNext(
			autoQueryId, groupId, crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns all the crf autoqueries that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf autoqueries that the user has permission to view
	 */
	public static List<CRFAutoquery> filterFindByG_C_S(
		long groupId, long crfId, long subjectId) {

		return getPersistence().filterFindByG_C_S(groupId, crfId, subjectId);
	}

	/**
	 * Returns a range of all the crf autoqueries that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries that the user has permission to view
	 */
	public static List<CRFAutoquery> filterFindByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end) {

		return getPersistence().filterFindByG_C_S(
			groupId, crfId, subjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries that the user has permissions to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries that the user has permission to view
	 */
	public static List<CRFAutoquery> filterFindByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().filterFindByG_C_S(
			groupId, crfId, subjectId, start, end, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set of crf autoqueries that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] filterFindByG_C_S_PrevAndNext(
			long autoQueryId, long groupId, long crfId, long subjectId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().filterFindByG_C_S_PrevAndNext(
			autoQueryId, groupId, crfId, subjectId, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	public static void removeByG_C_S(long groupId, long crfId, long subjectId) {
		getPersistence().removeByG_C_S(groupId, crfId, subjectId);
	}

	/**
	 * Returns the number of crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf autoqueries
	 */
	public static int countByG_C_S(long groupId, long crfId, long subjectId) {
		return getPersistence().countByG_C_S(groupId, crfId, subjectId);
	}

	/**
	 * Returns the number of crf autoqueries that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf autoqueries that the user has permission to view
	 */
	public static int filterCountByG_C_S(
		long groupId, long crfId, long subjectId) {

		return getPersistence().filterCountByG_C_S(groupId, crfId, subjectId);
	}

	/**
	 * Returns all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @return the matching crf autoqueries
	 */
	public static List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue) {

		return getPersistence().findBySdIdSIdValue(
			queryTermId, subjectId, queryValue);
	}

	/**
	 * Returns a range of all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue, int start,
		int end) {

		return getPersistence().findBySdIdSIdValue(
			queryTermId, subjectId, queryValue, start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findBySdIdSIdValue(
			queryTermId, subjectId, queryValue, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	public static List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySdIdSIdValue(
			queryTermId, subjectId, queryValue, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findBySdIdSIdValue_First(
			long queryTermId, long subjectId, String queryValue,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findBySdIdSIdValue_First(
			queryTermId, subjectId, queryValue, orderByComparator);
	}

	/**
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchBySdIdSIdValue_First(
		long queryTermId, long subjectId, String queryValue,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchBySdIdSIdValue_First(
			queryTermId, subjectId, queryValue, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findBySdIdSIdValue_Last(
			long queryTermId, long subjectId, String queryValue,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findBySdIdSIdValue_Last(
			queryTermId, subjectId, queryValue, orderByComparator);
	}

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchBySdIdSIdValue_Last(
		long queryTermId, long subjectId, String queryValue,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().fetchBySdIdSIdValue_Last(
			queryTermId, subjectId, queryValue, orderByComparator);
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery[] findBySdIdSIdValue_PrevAndNext(
			long autoQueryId, long queryTermId, long subjectId,
			String queryValue,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findBySdIdSIdValue_PrevAndNext(
			autoQueryId, queryTermId, subjectId, queryValue, orderByComparator);
	}

	/**
	 * Removes all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63; from the database.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 */
	public static void removeBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue) {

		getPersistence().removeBySdIdSIdValue(
			queryTermId, subjectId, queryValue);
	}

	/**
	 * Returns the number of crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @return the number of matching crf autoqueries
	 */
	public static int countBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue) {

		return getPersistence().countBySdIdSIdValue(
			queryTermId, subjectId, queryValue);
	}

	/**
	 * Returns the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findBySdIdSIdValue_MODEL(
			long queryTermId, long subjectId, String queryTermName,
			String queryValue)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findBySdIdSIdValue_MODEL(
			queryTermId, subjectId, queryTermName, queryValue);
	}

	/**
	 * Returns the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchBySdIdSIdValue_MODEL(
		long queryTermId, long subjectId, String queryTermName,
		String queryValue) {

		return getPersistence().fetchBySdIdSIdValue_MODEL(
			queryTermId, subjectId, queryTermName, queryValue);
	}

	/**
	 * Returns the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchBySdIdSIdValue_MODEL(
		long queryTermId, long subjectId, String queryTermName,
		String queryValue, boolean useFinderCache) {

		return getPersistence().fetchBySdIdSIdValue_MODEL(
			queryTermId, subjectId, queryTermName, queryValue, useFinderCache);
	}

	/**
	 * Removes the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; from the database.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the crf autoquery that was removed
	 */
	public static CRFAutoquery removeBySdIdSIdValue_MODEL(
			long queryTermId, long subjectId, String queryTermName,
			String queryValue)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().removeBySdIdSIdValue_MODEL(
			queryTermId, subjectId, queryTermName, queryValue);
	}

	/**
	 * Returns the number of crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the number of matching crf autoqueries
	 */
	public static int countBySdIdSIdValue_MODEL(
		long queryTermId, long subjectId, String queryTermName,
		String queryValue) {

		return getPersistence().countBySdIdSIdValue_MODEL(
			queryTermId, subjectId, queryTermName, queryValue);
	}

	/**
	 * Returns the crf autoquery where subjectId = &#63; and queryTermName = &#63; or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery findBySIdTN(long subjectId, String queryTermName)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findBySIdTN(subjectId, queryTermName);
	}

	/**
	 * Returns the crf autoquery where subjectId = &#63; and queryTermName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchBySIdTN(
		long subjectId, String queryTermName) {

		return getPersistence().fetchBySIdTN(subjectId, queryTermName);
	}

	/**
	 * Returns the crf autoquery where subjectId = &#63; and queryTermName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static CRFAutoquery fetchBySIdTN(
		long subjectId, String queryTermName, boolean useFinderCache) {

		return getPersistence().fetchBySIdTN(
			subjectId, queryTermName, useFinderCache);
	}

	/**
	 * Removes the crf autoquery where subjectId = &#63; and queryTermName = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the crf autoquery that was removed
	 */
	public static CRFAutoquery removeBySIdTN(
			long subjectId, String queryTermName)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().removeBySIdTN(subjectId, queryTermName);
	}

	/**
	 * Returns the number of crf autoqueries where subjectId = &#63; and queryTermName = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the number of matching crf autoqueries
	 */
	public static int countBySIdTN(long subjectId, String queryTermName) {
		return getPersistence().countBySIdTN(subjectId, queryTermName);
	}

	/**
	 * Caches the crf autoquery in the entity cache if it is enabled.
	 *
	 * @param crfAutoquery the crf autoquery
	 */
	public static void cacheResult(CRFAutoquery crfAutoquery) {
		getPersistence().cacheResult(crfAutoquery);
	}

	/**
	 * Caches the crf autoqueries in the entity cache if it is enabled.
	 *
	 * @param crfAutoqueries the crf autoqueries
	 */
	public static void cacheResult(List<CRFAutoquery> crfAutoqueries) {
		getPersistence().cacheResult(crfAutoqueries);
	}

	/**
	 * Creates a new crf autoquery with the primary key. Does not add the crf autoquery to the database.
	 *
	 * @param autoQueryId the primary key for the new crf autoquery
	 * @return the new crf autoquery
	 */
	public static CRFAutoquery create(long autoQueryId) {
		return getPersistence().create(autoQueryId);
	}

	/**
	 * Removes the crf autoquery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery that was removed
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery remove(long autoQueryId)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().remove(autoQueryId);
	}

	public static CRFAutoquery updateImpl(CRFAutoquery crfAutoquery) {
		return getPersistence().updateImpl(crfAutoquery);
	}

	/**
	 * Returns the crf autoquery with the primary key or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery findByPrimaryKey(long autoQueryId)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getPersistence().findByPrimaryKey(autoQueryId);
	}

	/**
	 * Returns the crf autoquery with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery, or <code>null</code> if a crf autoquery with the primary key could not be found
	 */
	public static CRFAutoquery fetchByPrimaryKey(long autoQueryId) {
		return getPersistence().fetchByPrimaryKey(autoQueryId);
	}

	/**
	 * Returns all the crf autoqueries.
	 *
	 * @return the crf autoqueries
	 */
	public static List<CRFAutoquery> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the crf autoqueries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of crf autoqueries
	 */
	public static List<CRFAutoquery> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf autoqueries
	 */
	public static List<CRFAutoquery> findAll(
		int start, int end, OrderByComparator<CRFAutoquery> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf autoqueries
	 */
	public static List<CRFAutoquery> findAll(
		int start, int end, OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the crf autoqueries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of crf autoqueries.
	 *
	 * @return the number of crf autoqueries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CRFAutoqueryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CRFAutoqueryPersistence _persistence;

}