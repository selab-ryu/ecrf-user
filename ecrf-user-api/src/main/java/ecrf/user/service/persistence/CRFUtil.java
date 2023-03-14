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

import ecrf.user.model.CRF;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the crf service. This utility wraps <code>ecrf.user.service.persistence.impl.CRFPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFPersistence
 * @generated
 */
public class CRFUtil {

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
	public static void clearCache(CRF crf) {
		getPersistence().clearCache(crf);
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
	public static Map<Serializable, CRF> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CRF> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CRF> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CRF> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CRF> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CRF update(CRF crf) {
		return getPersistence().update(crf);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CRF update(CRF crf, ServiceContext serviceContext) {
		return getPersistence().update(crf, serviceContext);
	}

	/**
	 * Returns all the crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crfs
	 */
	public static List<CRF> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of matching crfs
	 */
	public static List<CRF> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crfs
	 */
	public static List<CRF> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRF> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crfs
	 */
	public static List<CRF> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public static CRF findByUuid_First(
			String uuid, OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByUuid_First(
		String uuid, OrderByComparator<CRF> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public static CRF findByUuid_Last(
			String uuid, OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByUuid_Last(
		String uuid, OrderByComparator<CRF> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the crfs before and after the current crf in the ordered set where uuid = &#63;.
	 *
	 * @param crfId the primary key of the current crf
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public static CRF[] findByUuid_PrevAndNext(
			long crfId, String uuid, OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByUuid_PrevAndNext(
			crfId, uuid, orderByComparator);
	}

	/**
	 * Removes all the crfs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crfs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the crf where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public static CRF findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the crf where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf that was removed
	 */
	public static CRF removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of crfs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crfs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crfs
	 */
	public static List<CRF> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of matching crfs
	 */
	public static List<CRF> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crfs
	 */
	public static List<CRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRF> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crfs
	 */
	public static List<CRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public static CRF findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByUuid_C_First(
		String uuid, long companyId, OrderByComparator<CRF> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public static CRF findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByUuid_C_Last(
		String uuid, long companyId, OrderByComparator<CRF> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the crfs before and after the current crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param crfId the primary key of the current crf
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public static CRF[] findByUuid_C_PrevAndNext(
			long crfId, String uuid, long companyId,
			OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByUuid_C_PrevAndNext(
			crfId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the crfs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crfs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crfs
	 */
	public static List<CRF> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of matching crfs
	 */
	public static List<CRF> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crfs
	 */
	public static List<CRF> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRF> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crfs
	 */
	public static List<CRF> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public static CRF findByGroupId_First(
			long groupId, OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByGroupId_First(
		long groupId, OrderByComparator<CRF> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public static CRF findByGroupId_Last(
			long groupId, OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByGroupId_Last(
		long groupId, OrderByComparator<CRF> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the crfs before and after the current crf in the ordered set where groupId = &#63;.
	 *
	 * @param crfId the primary key of the current crf
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public static CRF[] findByGroupId_PrevAndNext(
			long crfId, long groupId, OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByGroupId_PrevAndNext(
			crfId, groupId, orderByComparator);
	}

	/**
	 * Removes all the crfs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crfs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the crfs where groupId = &#63; and managerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @return the matching crfs
	 */
	public static List<CRF> findByG_M(long groupId, long managerId) {
		return getPersistence().findByG_M(groupId, managerId);
	}

	/**
	 * Returns a range of all the crfs where groupId = &#63; and managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of matching crfs
	 */
	public static List<CRF> findByG_M(
		long groupId, long managerId, int start, int end) {

		return getPersistence().findByG_M(groupId, managerId, start, end);
	}

	/**
	 * Returns an ordered range of all the crfs where groupId = &#63; and managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crfs
	 */
	public static List<CRF> findByG_M(
		long groupId, long managerId, int start, int end,
		OrderByComparator<CRF> orderByComparator) {

		return getPersistence().findByG_M(
			groupId, managerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crfs where groupId = &#63; and managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crfs
	 */
	public static List<CRF> findByG_M(
		long groupId, long managerId, int start, int end,
		OrderByComparator<CRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_M(
			groupId, managerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf in the ordered set where groupId = &#63; and managerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public static CRF findByG_M_First(
			long groupId, long managerId,
			OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByG_M_First(
			groupId, managerId, orderByComparator);
	}

	/**
	 * Returns the first crf in the ordered set where groupId = &#63; and managerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByG_M_First(
		long groupId, long managerId,
		OrderByComparator<CRF> orderByComparator) {

		return getPersistence().fetchByG_M_First(
			groupId, managerId, orderByComparator);
	}

	/**
	 * Returns the last crf in the ordered set where groupId = &#63; and managerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public static CRF findByG_M_Last(
			long groupId, long managerId,
			OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByG_M_Last(
			groupId, managerId, orderByComparator);
	}

	/**
	 * Returns the last crf in the ordered set where groupId = &#63; and managerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public static CRF fetchByG_M_Last(
		long groupId, long managerId,
		OrderByComparator<CRF> orderByComparator) {

		return getPersistence().fetchByG_M_Last(
			groupId, managerId, orderByComparator);
	}

	/**
	 * Returns the crfs before and after the current crf in the ordered set where groupId = &#63; and managerId = &#63;.
	 *
	 * @param crfId the primary key of the current crf
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public static CRF[] findByG_M_PrevAndNext(
			long crfId, long groupId, long managerId,
			OrderByComparator<CRF> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByG_M_PrevAndNext(
			crfId, groupId, managerId, orderByComparator);
	}

	/**
	 * Removes all the crfs where groupId = &#63; and managerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 */
	public static void removeByG_M(long groupId, long managerId) {
		getPersistence().removeByG_M(groupId, managerId);
	}

	/**
	 * Returns the number of crfs where groupId = &#63; and managerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param managerId the manager ID
	 * @return the number of matching crfs
	 */
	public static int countByG_M(long groupId, long managerId) {
		return getPersistence().countByG_M(groupId, managerId);
	}

	/**
	 * Caches the crf in the entity cache if it is enabled.
	 *
	 * @param crf the crf
	 */
	public static void cacheResult(CRF crf) {
		getPersistence().cacheResult(crf);
	}

	/**
	 * Caches the crfs in the entity cache if it is enabled.
	 *
	 * @param crfs the crfs
	 */
	public static void cacheResult(List<CRF> crfs) {
		getPersistence().cacheResult(crfs);
	}

	/**
	 * Creates a new crf with the primary key. Does not add the crf to the database.
	 *
	 * @param crfId the primary key for the new crf
	 * @return the new crf
	 */
	public static CRF create(long crfId) {
		return getPersistence().create(crfId);
	}

	/**
	 * Removes the crf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf that was removed
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public static CRF remove(long crfId)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().remove(crfId);
	}

	public static CRF updateImpl(CRF crf) {
		return getPersistence().updateImpl(crf);
	}

	/**
	 * Returns the crf with the primary key or throws a <code>NoSuchCRFException</code> if it could not be found.
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public static CRF findByPrimaryKey(long crfId)
		throws ecrf.user.exception.NoSuchCRFException {

		return getPersistence().findByPrimaryKey(crfId);
	}

	/**
	 * Returns the crf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf, or <code>null</code> if a crf with the primary key could not be found
	 */
	public static CRF fetchByPrimaryKey(long crfId) {
		return getPersistence().fetchByPrimaryKey(crfId);
	}

	/**
	 * Returns all the crfs.
	 *
	 * @return the crfs
	 */
	public static List<CRF> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of crfs
	 */
	public static List<CRF> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crfs
	 */
	public static List<CRF> findAll(
		int start, int end, OrderByComparator<CRF> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crfs
	 */
	public static List<CRF> findAll(
		int start, int end, OrderByComparator<CRF> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the crfs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of crfs.
	 *
	 * @return the number of crfs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CRFPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CRFPersistence _persistence;

}