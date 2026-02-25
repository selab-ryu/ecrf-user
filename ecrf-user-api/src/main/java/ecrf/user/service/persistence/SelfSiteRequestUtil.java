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

import ecrf.user.model.SelfSiteRequest;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the self site request service. This utility wraps <code>ecrf.user.service.persistence.impl.SelfSiteRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see SelfSiteRequestPersistence
 * @generated
 */
public class SelfSiteRequestUtil {

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
	public static void clearCache(SelfSiteRequest selfSiteRequest) {
		getPersistence().clearCache(selfSiteRequest);
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
	public static Map<Serializable, SelfSiteRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SelfSiteRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SelfSiteRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SelfSiteRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SelfSiteRequest update(SelfSiteRequest selfSiteRequest) {
		return getPersistence().update(selfSiteRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SelfSiteRequest update(
		SelfSiteRequest selfSiteRequest, ServiceContext serviceContext) {

		return getPersistence().update(selfSiteRequest, serviceContext);
	}

	/**
	 * Returns all the self site requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching self site requests
	 */
	public static List<SelfSiteRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the self site requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of matching self site requests
	 */
	public static List<SelfSiteRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the self site requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching self site requests
	 */
	public static List<SelfSiteRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the self site requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching self site requests
	 */
	public static List<SelfSiteRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first self site request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public static SelfSiteRequest findByUuid_First(
			String uuid, OrderByComparator<SelfSiteRequest> orderByComparator)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first self site request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public static SelfSiteRequest fetchByUuid_First(
		String uuid, OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last self site request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public static SelfSiteRequest findByUuid_Last(
			String uuid, OrderByComparator<SelfSiteRequest> orderByComparator)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last self site request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public static SelfSiteRequest fetchByUuid_Last(
		String uuid, OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the self site requests before and after the current self site request in the ordered set where uuid = &#63;.
	 *
	 * @param selfSiteRequestId the primary key of the current self site request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next self site request
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public static SelfSiteRequest[] findByUuid_PrevAndNext(
			long selfSiteRequestId, String uuid,
			OrderByComparator<SelfSiteRequest> orderByComparator)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			selfSiteRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the self site requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of self site requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching self site requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the self site request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSelfSiteRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public static SelfSiteRequest findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the self site request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public static SelfSiteRequest fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the self site request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public static SelfSiteRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the self site request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the self site request that was removed
	 */
	public static SelfSiteRequest removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of self site requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching self site requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching self site requests
	 */
	public static List<SelfSiteRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of matching self site requests
	 */
	public static List<SelfSiteRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching self site requests
	 */
	public static List<SelfSiteRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching self site requests
	 */
	public static List<SelfSiteRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public static SelfSiteRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SelfSiteRequest> orderByComparator)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public static SelfSiteRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public static SelfSiteRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SelfSiteRequest> orderByComparator)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public static SelfSiteRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the self site requests before and after the current self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param selfSiteRequestId the primary key of the current self site request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next self site request
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public static SelfSiteRequest[] findByUuid_C_PrevAndNext(
			long selfSiteRequestId, String uuid, long companyId,
			OrderByComparator<SelfSiteRequest> orderByComparator)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			selfSiteRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the self site requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching self site requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the self site requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching self site requests
	 */
	public static List<SelfSiteRequest> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the self site requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of matching self site requests
	 */
	public static List<SelfSiteRequest> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the self site requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching self site requests
	 */
	public static List<SelfSiteRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the self site requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching self site requests
	 */
	public static List<SelfSiteRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first self site request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public static SelfSiteRequest findByGroupId_First(
			long groupId, OrderByComparator<SelfSiteRequest> orderByComparator)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first self site request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public static SelfSiteRequest fetchByGroupId_First(
		long groupId, OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last self site request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public static SelfSiteRequest findByGroupId_Last(
			long groupId, OrderByComparator<SelfSiteRequest> orderByComparator)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last self site request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public static SelfSiteRequest fetchByGroupId_Last(
		long groupId, OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the self site requests before and after the current self site request in the ordered set where groupId = &#63;.
	 *
	 * @param selfSiteRequestId the primary key of the current self site request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next self site request
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public static SelfSiteRequest[] findByGroupId_PrevAndNext(
			long selfSiteRequestId, long groupId,
			OrderByComparator<SelfSiteRequest> orderByComparator)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByGroupId_PrevAndNext(
			selfSiteRequestId, groupId, orderByComparator);
	}

	/**
	 * Removes all the self site requests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of self site requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching self site requests
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the self site request in the entity cache if it is enabled.
	 *
	 * @param selfSiteRequest the self site request
	 */
	public static void cacheResult(SelfSiteRequest selfSiteRequest) {
		getPersistence().cacheResult(selfSiteRequest);
	}

	/**
	 * Caches the self site requests in the entity cache if it is enabled.
	 *
	 * @param selfSiteRequests the self site requests
	 */
	public static void cacheResult(List<SelfSiteRequest> selfSiteRequests) {
		getPersistence().cacheResult(selfSiteRequests);
	}

	/**
	 * Creates a new self site request with the primary key. Does not add the self site request to the database.
	 *
	 * @param selfSiteRequestId the primary key for the new self site request
	 * @return the new self site request
	 */
	public static SelfSiteRequest create(long selfSiteRequestId) {
		return getPersistence().create(selfSiteRequestId);
	}

	/**
	 * Removes the self site request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request that was removed
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public static SelfSiteRequest remove(long selfSiteRequestId)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().remove(selfSiteRequestId);
	}

	public static SelfSiteRequest updateImpl(SelfSiteRequest selfSiteRequest) {
		return getPersistence().updateImpl(selfSiteRequest);
	}

	/**
	 * Returns the self site request with the primary key or throws a <code>NoSuchSelfSiteRequestException</code> if it could not be found.
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public static SelfSiteRequest findByPrimaryKey(long selfSiteRequestId)
		throws ecrf.user.exception.NoSuchSelfSiteRequestException {

		return getPersistence().findByPrimaryKey(selfSiteRequestId);
	}

	/**
	 * Returns the self site request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request, or <code>null</code> if a self site request with the primary key could not be found
	 */
	public static SelfSiteRequest fetchByPrimaryKey(long selfSiteRequestId) {
		return getPersistence().fetchByPrimaryKey(selfSiteRequestId);
	}

	/**
	 * Returns all the self site requests.
	 *
	 * @return the self site requests
	 */
	public static List<SelfSiteRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the self site requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of self site requests
	 */
	public static List<SelfSiteRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the self site requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of self site requests
	 */
	public static List<SelfSiteRequest> findAll(
		int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the self site requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of self site requests
	 */
	public static List<SelfSiteRequest> findAll(
		int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the self site requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of self site requests.
	 *
	 * @return the number of self site requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SelfSiteRequestPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SelfSiteRequestPersistence _persistence;

}