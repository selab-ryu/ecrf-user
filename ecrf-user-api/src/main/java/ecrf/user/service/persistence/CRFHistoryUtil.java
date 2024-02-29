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

import ecrf.user.model.CRFHistory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the crf history service. This utility wraps <code>ecrf.user.service.persistence.impl.CRFHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFHistoryPersistence
 * @generated
 */
public class CRFHistoryUtil {

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
	public static void clearCache(CRFHistory crfHistory) {
		getPersistence().clearCache(crfHistory);
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
	public static Map<Serializable, CRFHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CRFHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CRFHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CRFHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CRFHistory update(CRFHistory crfHistory) {
		return getPersistence().update(crfHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CRFHistory update(
		CRFHistory crfHistory, ServiceContext serviceContext) {

		return getPersistence().update(crfHistory, serviceContext);
	}

	/**
	 * Returns all the crf histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the crf histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByUuid_First(
			String uuid, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByUuid_First(
		String uuid, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByUuid_Last(
			String uuid, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByUuid_Last(
		String uuid, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where uuid = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByUuid_PrevAndNext(
			long historyId, String uuid,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUuid_PrevAndNext(
			historyId, uuid, orderByComparator);
	}

	/**
	 * Removes all the crf histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of crf histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf histories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the crf history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the crf history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf history that was removed
	 */
	public static CRFHistory removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of crf histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf histories
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByUuid_C_PrevAndNext(
			long historyId, String uuid, long companyId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			historyId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf histories
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the crf histories where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByHistoryId(long historyId) {
		return getPersistence().findByHistoryId(historyId);
	}

	/**
	 * Returns a range of all the crf histories where historyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param historyId the history ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByHistoryId(
		long historyId, int start, int end) {

		return getPersistence().findByHistoryId(historyId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where historyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param historyId the history ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByHistoryId(
		long historyId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByHistoryId(
			historyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where historyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param historyId the history ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByHistoryId(
		long historyId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByHistoryId(
			historyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByHistoryId_First(
			long historyId, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByHistoryId_First(
			historyId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByHistoryId_First(
		long historyId, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByHistoryId_First(
			historyId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByHistoryId_Last(
			long historyId, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByHistoryId_Last(
			historyId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByHistoryId_Last(
		long historyId, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByHistoryId_Last(
			historyId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where historyId = &#63; from the database.
	 *
	 * @param historyId the history ID
	 */
	public static void removeByHistoryId(long historyId) {
		getPersistence().removeByHistoryId(historyId);
	}

	/**
	 * Returns the number of crf histories where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @return the number of matching crf histories
	 */
	public static int countByHistoryId(long historyId) {
		return getPersistence().countByHistoryId(historyId);
	}

	/**
	 * Returns all the crf histories where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findBySubjectId(long subjectId) {
		return getPersistence().findBySubjectId(subjectId);
	}

	/**
	 * Returns a range of all the crf histories where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findBySubjectId(
		long subjectId, int start, int end) {

		return getPersistence().findBySubjectId(subjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findBySubjectId(
			subjectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubjectId(
			subjectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findBySubjectId_First(
			long subjectId, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findBySubjectId_First(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchBySubjectId_First(
		long subjectId, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchBySubjectId_First(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findBySubjectId_Last(
			long subjectId, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findBySubjectId_Last(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchBySubjectId_Last(
		long subjectId, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchBySubjectId_Last(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findBySubjectId_PrevAndNext(
			long historyId, long subjectId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findBySubjectId_PrevAndNext(
			historyId, subjectId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	public static void removeBySubjectId(long subjectId) {
		getPersistence().removeBySubjectId(subjectId);
	}

	/**
	 * Returns the number of crf histories where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching crf histories
	 */
	public static int countBySubjectId(long subjectId) {
		return getPersistence().countBySubjectId(subjectId);
	}

	/**
	 * Returns all the crf histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByStructuredDataId(
		long structuredDataId) {

		return getPersistence().findByStructuredDataId(structuredDataId);
	}

	/**
	 * Returns a range of all the crf histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByStructuredDataId(
		long structuredDataId, int start, int end) {

		return getPersistence().findByStructuredDataId(
			structuredDataId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByStructuredDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByStructuredDataId(
			structuredDataId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByStructuredDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStructuredDataId(
			structuredDataId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByStructuredDataId_First(
			long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByStructuredDataId_First(
			structuredDataId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByStructuredDataId_First(
		long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByStructuredDataId_First(
			structuredDataId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByStructuredDataId_Last(
			long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByStructuredDataId_Last(
			structuredDataId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByStructuredDataId_Last(
		long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByStructuredDataId_Last(
			structuredDataId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByStructuredDataId_PrevAndNext(
			long historyId, long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByStructuredDataId_PrevAndNext(
			historyId, structuredDataId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 */
	public static void removeByStructuredDataId(long structuredDataId) {
		getPersistence().removeByStructuredDataId(structuredDataId);
	}

	/**
	 * Returns the number of crf histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching crf histories
	 */
	public static int countByStructuredDataId(long structuredDataId) {
		return getPersistence().countByStructuredDataId(structuredDataId);
	}

	/**
	 * Returns all the crf histories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByGroupId_First(
			long groupId, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByGroupId_First(
		long groupId, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByGroupId_Last(
			long groupId, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByGroupId_PrevAndNext(
			long historyId, long groupId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByGroupId_PrevAndNext(
			historyId, groupId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of crf histories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf histories
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the crf histories where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the crf histories where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByUserId_First(
			long userId, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByUserId_First(
		long userId, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByUserId_Last(
			long userId, OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByUserId_Last(
		long userId, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where userId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByUserId_PrevAndNext(
			long historyId, long userId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByUserId_PrevAndNext(
			historyId, userId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of crf histories where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching crf histories
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByG_U_First(
			long groupId, long userId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByG_U_PrevAndNext(
			long historyId, long groupId, long userId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_U_PrevAndNext(
			historyId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching crf histories
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByC_S(long crfId, long subjectId) {
		return getPersistence().findByC_S(crfId, subjectId);
	}

	/**
	 * Returns a range of all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByC_S(
		long crfId, long subjectId, int start, int end) {

		return getPersistence().findByC_S(crfId, subjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByC_S(
		long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByC_S(
			crfId, subjectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByC_S(
		long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_S(
			crfId, subjectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByC_S_First(
			long crfId, long subjectId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByC_S_First(
			crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByC_S_First(
		long crfId, long subjectId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByC_S_First(
			crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByC_S_Last(
			long crfId, long subjectId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByC_S_Last(
			crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByC_S_Last(
		long crfId, long subjectId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByC_S_Last(
			crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByC_S_PrevAndNext(
			long historyId, long crfId, long subjectId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByC_S_PrevAndNext(
			historyId, crfId, subjectId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	public static void removeByC_S(long crfId, long subjectId) {
		getPersistence().removeByC_S(crfId, subjectId);
	}

	/**
	 * Returns the number of crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf histories
	 */
	public static int countByC_S(long crfId, long subjectId) {
		return getPersistence().countByC_S(crfId, subjectId);
	}

	/**
	 * Returns all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByG_C(long groupId, long crfId) {
		return getPersistence().findByG_C(groupId, crfId);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByG_C(
		long groupId, long crfId, int start, int end) {

		return getPersistence().findByG_C(groupId, crfId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByG_C_PrevAndNext(
			long historyId, long groupId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_C_PrevAndNext(
			historyId, groupId, crfId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public static void removeByG_C(long groupId, long crfId) {
		getPersistence().removeByG_C(groupId, crfId);
	}

	/**
	 * Returns the number of crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf histories
	 */
	public static int countByG_C(long groupId, long crfId) {
		return getPersistence().countByG_C(groupId, crfId);
	}

	/**
	 * Returns all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByG_S_C(
		long groupId, long subjectId, long crfId) {

		return getPersistence().findByG_S_C(groupId, subjectId, crfId);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end) {

		return getPersistence().findByG_S_C(
			groupId, subjectId, crfId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByG_S_C(
			groupId, subjectId, crfId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S_C(
			groupId, subjectId, crfId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByG_S_C_First(
			long groupId, long subjectId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_S_C_First(
			groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByG_S_C_First(
		long groupId, long subjectId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByG_S_C_First(
			groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByG_S_C_Last(
			long groupId, long subjectId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_S_C_Last(
			groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByG_S_C_Last(
		long groupId, long subjectId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByG_S_C_Last(
			groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByG_S_C_PrevAndNext(
			long historyId, long groupId, long subjectId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_S_C_PrevAndNext(
			historyId, groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Removes all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 */
	public static void removeByG_S_C(long groupId, long subjectId, long crfId) {
		getPersistence().removeByG_S_C(groupId, subjectId, crfId);
	}

	/**
	 * Returns the number of crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the number of matching crf histories
	 */
	public static int countByG_S_C(long groupId, long subjectId, long crfId) {
		return getPersistence().countByG_S_C(groupId, subjectId, crfId);
	}

	/**
	 * Returns all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching crf histories
	 */
	public static List<CRFHistory> findByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		return getPersistence().findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public static List<CRFHistory> findByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		int start, int end) {

		return getPersistence().findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		int start, int end, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public static List<CRFHistory> findByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		int start, int end, OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByG_S_C_SD_First(
			long groupId, long subjectId, long crfId, long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_S_C_SD_First(
			groupId, subjectId, crfId, structuredDataId, orderByComparator);
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByG_S_C_SD_First(
		long groupId, long subjectId, long crfId, long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByG_S_C_SD_First(
			groupId, subjectId, crfId, structuredDataId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public static CRFHistory findByG_S_C_SD_Last(
			long groupId, long subjectId, long crfId, long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_S_C_SD_Last(
			groupId, subjectId, crfId, structuredDataId, orderByComparator);
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchByG_S_C_SD_Last(
		long groupId, long subjectId, long crfId, long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().fetchByG_S_C_SD_Last(
			groupId, subjectId, crfId, structuredDataId, orderByComparator);
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory[] findByG_S_C_SD_PrevAndNext(
			long historyId, long groupId, long subjectId, long crfId,
			long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByG_S_C_SD_PrevAndNext(
			historyId, groupId, subjectId, crfId, structuredDataId,
			orderByComparator);
	}

	/**
	 * Removes all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 */
	public static void removeByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		getPersistence().removeByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);
	}

	/**
	 * Returns the number of crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching crf histories
	 */
	public static int countByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		return getPersistence().countByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);
	}

	/**
	 * Caches the crf history in the entity cache if it is enabled.
	 *
	 * @param crfHistory the crf history
	 */
	public static void cacheResult(CRFHistory crfHistory) {
		getPersistence().cacheResult(crfHistory);
	}

	/**
	 * Caches the crf histories in the entity cache if it is enabled.
	 *
	 * @param crfHistories the crf histories
	 */
	public static void cacheResult(List<CRFHistory> crfHistories) {
		getPersistence().cacheResult(crfHistories);
	}

	/**
	 * Creates a new crf history with the primary key. Does not add the crf history to the database.
	 *
	 * @param historyId the primary key for the new crf history
	 * @return the new crf history
	 */
	public static CRFHistory create(long historyId) {
		return getPersistence().create(historyId);
	}

	/**
	 * Removes the crf history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history that was removed
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory remove(long historyId)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().remove(historyId);
	}

	public static CRFHistory updateImpl(CRFHistory crfHistory) {
		return getPersistence().updateImpl(crfHistory);
	}

	/**
	 * Returns the crf history with the primary key or throws a <code>NoSuchCRFHistoryException</code> if it could not be found.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public static CRFHistory findByPrimaryKey(long historyId)
		throws ecrf.user.exception.NoSuchCRFHistoryException {

		return getPersistence().findByPrimaryKey(historyId);
	}

	/**
	 * Returns the crf history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history, or <code>null</code> if a crf history with the primary key could not be found
	 */
	public static CRFHistory fetchByPrimaryKey(long historyId) {
		return getPersistence().fetchByPrimaryKey(historyId);
	}

	/**
	 * Returns all the crf histories.
	 *
	 * @return the crf histories
	 */
	public static List<CRFHistory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of crf histories
	 */
	public static List<CRFHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf histories
	 */
	public static List<CRFHistory> findAll(
		int start, int end, OrderByComparator<CRFHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf histories
	 */
	public static List<CRFHistory> findAll(
		int start, int end, OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the crf histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of crf histories.
	 *
	 * @return the number of crf histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CRFHistoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CRFHistoryPersistence _persistence;

}