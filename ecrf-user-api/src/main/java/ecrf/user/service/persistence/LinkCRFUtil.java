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

import ecrf.user.model.LinkCRF;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the link crf service. This utility wraps <code>ecrf.user.service.persistence.impl.LinkCRFPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see LinkCRFPersistence
 * @generated
 */
public class LinkCRFUtil {

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
	public static void clearCache(LinkCRF linkCRF) {
		getPersistence().clearCache(linkCRF);
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
	public static Map<Serializable, LinkCRF> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LinkCRF> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LinkCRF> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LinkCRF> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LinkCRF update(LinkCRF linkCRF) {
		return getPersistence().update(linkCRF);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LinkCRF update(
		LinkCRF linkCRF, ServiceContext serviceContext) {

		return getPersistence().update(linkCRF, serviceContext);
	}

	/**
	 * Returns all the link crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching link crfs
	 */
	public static List<LinkCRF> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the link crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public static List<LinkCRF> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByUuid_First(
			String uuid, OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByUuid_First(
		String uuid, OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByUuid_Last(
			String uuid, OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByUuid_Last(
		String uuid, OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where uuid = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF[] findByUuid_PrevAndNext(
			long linkId, String uuid,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByUuid_PrevAndNext(
			linkId, uuid, orderByComparator);
	}

	/**
	 * Removes all the link crfs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of link crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching link crfs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the link crf where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the link crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the link crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the link crf where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the link crf that was removed
	 */
	public static LinkCRF removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of link crfs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching link crfs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching link crfs
	 */
	public static List<LinkCRF> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public static List<LinkCRF> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF[] findByUuid_C_PrevAndNext(
			long linkId, String uuid, long companyId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByUuid_C_PrevAndNext(
			linkId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the link crfs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching link crfs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the link crf where linkId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param linkId the link ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByLinkId(long linkId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByLinkId(linkId);
	}

	/**
	 * Returns the link crf where linkId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param linkId the link ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByLinkId(long linkId) {
		return getPersistence().fetchByLinkId(linkId);
	}

	/**
	 * Returns the link crf where linkId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linkId the link ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByLinkId(long linkId, boolean useFinderCache) {
		return getPersistence().fetchByLinkId(linkId, useFinderCache);
	}

	/**
	 * Removes the link crf where linkId = &#63; from the database.
	 *
	 * @param linkId the link ID
	 * @return the link crf that was removed
	 */
	public static LinkCRF removeByLinkId(long linkId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().removeByLinkId(linkId);
	}

	/**
	 * Returns the number of link crfs where linkId = &#63;.
	 *
	 * @param linkId the link ID
	 * @return the number of matching link crfs
	 */
	public static int countByLinkId(long linkId) {
		return getPersistence().countByLinkId(linkId);
	}

	/**
	 * Returns all the link crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching link crfs
	 */
	public static List<LinkCRF> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the link crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public static List<LinkCRF> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByGroupId_First(
			long groupId, OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByGroupId_First(
		long groupId, OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByGroupId_Last(
			long groupId, OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByGroupId_Last(
		long groupId, OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF[] findByGroupId_PrevAndNext(
			long linkId, long groupId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByGroupId_PrevAndNext(
			linkId, groupId, orderByComparator);
	}

	/**
	 * Removes all the link crfs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of link crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching link crfs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the link crfs where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching link crfs
	 */
	public static List<LinkCRF> findBySubjectId(long subjectId) {
		return getPersistence().findBySubjectId(subjectId);
	}

	/**
	 * Returns a range of all the link crfs where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public static List<LinkCRF> findBySubjectId(
		long subjectId, int start, int end) {

		return getPersistence().findBySubjectId(subjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findBySubjectId(
			subjectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySubjectId(
			subjectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findBySubjectId_First(
			long subjectId, OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findBySubjectId_First(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the first link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchBySubjectId_First(
		long subjectId, OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchBySubjectId_First(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findBySubjectId_Last(
			long subjectId, OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findBySubjectId_Last(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchBySubjectId_Last(
		long subjectId, OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchBySubjectId_Last(
			subjectId, orderByComparator);
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF[] findBySubjectId_PrevAndNext(
			long linkId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findBySubjectId_PrevAndNext(
			linkId, subjectId, orderByComparator);
	}

	/**
	 * Removes all the link crfs where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	public static void removeBySubjectId(long subjectId) {
		getPersistence().removeBySubjectId(subjectId);
	}

	/**
	 * Returns the number of link crfs where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	public static int countBySubjectId(long subjectId) {
		return getPersistence().countBySubjectId(subjectId);
	}

	/**
	 * Returns all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the matching link crfs
	 */
	public static List<LinkCRF> findByG_S(long groupId, long subjectId) {
		return getPersistence().findByG_S(groupId, subjectId);
	}

	/**
	 * Returns a range of all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public static List<LinkCRF> findByG_S(
		long groupId, long subjectId, int start, int end) {

		return getPersistence().findByG_S(groupId, subjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, subjectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, subjectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByG_S_First(
			long groupId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_S_First(
			groupId, subjectId, orderByComparator);
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_S_First(
		long groupId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByG_S_Last(
			long groupId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_S_Last(
			groupId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_S_Last(
		long groupId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, subjectId, orderByComparator);
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF[] findByG_S_PrevAndNext(
			long linkId, long groupId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_S_PrevAndNext(
			linkId, groupId, subjectId, orderByComparator);
	}

	/**
	 * Removes all the link crfs where groupId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 */
	public static void removeByG_S(long groupId, long subjectId) {
		getPersistence().removeByG_S(groupId, subjectId);
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	public static int countByG_S(long groupId, long subjectId) {
		return getPersistence().countByG_S(groupId, subjectId);
	}

	/**
	 * Returns all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching link crfs
	 */
	public static List<LinkCRF> findByG_C(long groupId, long crfId) {
		return getPersistence().findByG_C(groupId, crfId);
	}

	/**
	 * Returns a range of all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public static List<LinkCRF> findByG_C(
		long groupId, long crfId, int start, int end) {

		return getPersistence().findByG_C(groupId, crfId, start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF[] findByG_C_PrevAndNext(
			long linkId, long groupId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_C_PrevAndNext(
			linkId, groupId, crfId, orderByComparator);
	}

	/**
	 * Removes all the link crfs where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public static void removeByG_C(long groupId, long crfId) {
		getPersistence().removeByG_C(groupId, crfId);
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching link crfs
	 */
	public static int countByG_C(long groupId, long crfId) {
		return getPersistence().countByG_C(groupId, crfId);
	}

	/**
	 * Returns all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the matching link crfs
	 */
	public static List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId) {

		return getPersistence().findByG_S_C(groupId, subjectId, crfId);
	}

	/**
	 * Returns a range of all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public static List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end) {

		return getPersistence().findByG_S_C(
			groupId, subjectId, crfId, start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findByG_S_C(
			groupId, subjectId, crfId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S_C(
			groupId, subjectId, crfId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByG_S_C_First(
			long groupId, long subjectId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_S_C_First(
			groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_S_C_First(
		long groupId, long subjectId, long crfId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByG_S_C_First(
			groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByG_S_C_Last(
			long groupId, long subjectId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_S_C_Last(
			groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_S_C_Last(
		long groupId, long subjectId, long crfId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByG_S_C_Last(
			groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF[] findByG_S_C_PrevAndNext(
			long linkId, long groupId, long subjectId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_S_C_PrevAndNext(
			linkId, groupId, subjectId, crfId, orderByComparator);
	}

	/**
	 * Removes all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 */
	public static void removeByG_S_C(long groupId, long subjectId, long crfId) {
		getPersistence().removeByG_S_C(groupId, subjectId, crfId);
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the number of matching link crfs
	 */
	public static int countByG_S_C(long groupId, long subjectId, long crfId) {
		return getPersistence().countByG_S_C(groupId, subjectId, crfId);
	}

	/**
	 * Returns the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByG_S_SD(
			long groupId, long crfId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_S_SD(groupId, crfId, structuredDataId);
	}

	/**
	 * Returns the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_S_SD(
		long groupId, long crfId, long structuredDataId) {

		return getPersistence().fetchByG_S_SD(groupId, crfId, structuredDataId);
	}

	/**
	 * Returns the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_S_SD(
		long groupId, long crfId, long structuredDataId,
		boolean useFinderCache) {

		return getPersistence().fetchByG_S_SD(
			groupId, crfId, structuredDataId, useFinderCache);
	}

	/**
	 * Removes the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	public static LinkCRF removeByG_S_SD(
			long groupId, long crfId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().removeByG_S_SD(
			groupId, crfId, structuredDataId);
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	public static int countByG_S_SD(
		long groupId, long crfId, long structuredDataId) {

		return getPersistence().countByG_S_SD(groupId, crfId, structuredDataId);
	}

	/**
	 * Returns the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByG_S_C_SD(
			long groupId, long subjectId, long crfId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);
	}

	/**
	 * Returns the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		return getPersistence().fetchByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);
	}

	/**
	 * Returns the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		boolean useFinderCache) {

		return getPersistence().fetchByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, useFinderCache);
	}

	/**
	 * Removes the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	public static LinkCRF removeByG_S_C_SD(
			long groupId, long subjectId, long crfId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().removeByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	public static int countByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		return getPersistence().countByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);
	}

	/**
	 * Returns all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching link crfs
	 */
	public static List<LinkCRF> findByC_S(long crfId, long subjectId) {
		return getPersistence().findByC_S(crfId, subjectId);
	}

	/**
	 * Returns a range of all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public static List<LinkCRF> findByC_S(
		long crfId, long subjectId, int start, int end) {

		return getPersistence().findByC_S(crfId, subjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByC_S(
		long crfId, long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findByC_S(
			crfId, subjectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByC_S(
		long crfId, long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_S(
			crfId, subjectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByC_S_First(
			long crfId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByC_S_First(
			crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the first link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByC_S_First(
		long crfId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByC_S_First(
			crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByC_S_Last(
			long crfId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByC_S_Last(
			crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByC_S_Last(
		long crfId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByC_S_Last(
			crfId, subjectId, orderByComparator);
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF[] findByC_S_PrevAndNext(
			long linkId, long crfId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByC_S_PrevAndNext(
			linkId, crfId, subjectId, orderByComparator);
	}

	/**
	 * Removes all the link crfs where crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	public static void removeByC_S(long crfId, long subjectId) {
		getPersistence().removeByC_S(crfId, subjectId);
	}

	/**
	 * Returns the number of link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	public static int countByC_S(long crfId, long subjectId) {
		return getPersistence().countByC_S(crfId, subjectId);
	}

	/**
	 * Returns the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByC_S_SD(
			long crfId, long subjectId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByC_S_SD(
			crfId, subjectId, structuredDataId);
	}

	/**
	 * Returns the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByC_S_SD(
		long crfId, long subjectId, long structuredDataId) {

		return getPersistence().fetchByC_S_SD(
			crfId, subjectId, structuredDataId);
	}

	/**
	 * Returns the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByC_S_SD(
		long crfId, long subjectId, long structuredDataId,
		boolean useFinderCache) {

		return getPersistence().fetchByC_S_SD(
			crfId, subjectId, structuredDataId, useFinderCache);
	}

	/**
	 * Removes the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	public static LinkCRF removeByC_S_SD(
			long crfId, long subjectId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().removeByC_S_SD(
			crfId, subjectId, structuredDataId);
	}

	/**
	 * Returns the number of link crfs where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	public static int countByC_S_SD(
		long crfId, long subjectId, long structuredDataId) {

		return getPersistence().countByC_S_SD(
			crfId, subjectId, structuredDataId);
	}

	/**
	 * Returns all the link crfs where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching link crfs
	 */
	public static List<LinkCRF> findByStructuredDataId(long structuredDataId) {
		return getPersistence().findByStructuredDataId(structuredDataId);
	}

	/**
	 * Returns a range of all the link crfs where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public static List<LinkCRF> findByStructuredDataId(
		long structuredDataId, int start, int end) {

		return getPersistence().findByStructuredDataId(
			structuredDataId, start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByStructuredDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findByStructuredDataId(
			structuredDataId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public static List<LinkCRF> findByStructuredDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStructuredDataId(
			structuredDataId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByStructuredDataId_First(
			long structuredDataId, OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByStructuredDataId_First(
			structuredDataId, orderByComparator);
	}

	/**
	 * Returns the first link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByStructuredDataId_First(
		long structuredDataId, OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByStructuredDataId_First(
			structuredDataId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByStructuredDataId_Last(
			long structuredDataId, OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByStructuredDataId_Last(
			structuredDataId, orderByComparator);
	}

	/**
	 * Returns the last link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByStructuredDataId_Last(
		long structuredDataId, OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().fetchByStructuredDataId_Last(
			structuredDataId, orderByComparator);
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF[] findByStructuredDataId_PrevAndNext(
			long linkId, long structuredDataId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByStructuredDataId_PrevAndNext(
			linkId, structuredDataId, orderByComparator);
	}

	/**
	 * Removes all the link crfs where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 */
	public static void removeByStructuredDataId(long structuredDataId) {
		getPersistence().removeByStructuredDataId(structuredDataId);
	}

	/**
	 * Returns the number of link crfs where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	public static int countByStructuredDataId(long structuredDataId) {
		return getPersistence().countByStructuredDataId(structuredDataId);
	}

	/**
	 * Returns the link crf where subjectId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param subjectId the subject ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByLinkSId(long subjectId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByLinkSId(subjectId);
	}

	/**
	 * Returns the link crf where subjectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByLinkSId(long subjectId) {
		return getPersistence().fetchByLinkSId(subjectId);
	}

	/**
	 * Returns the link crf where subjectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByLinkSId(
		long subjectId, boolean useFinderCache) {

		return getPersistence().fetchByLinkSId(subjectId, useFinderCache);
	}

	/**
	 * Removes the link crf where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 * @return the link crf that was removed
	 */
	public static LinkCRF removeByLinkSId(long subjectId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().removeByLinkSId(subjectId);
	}

	/**
	 * Returns the number of link crfs where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	public static int countByLinkSId(long subjectId) {
		return getPersistence().countByLinkSId(subjectId);
	}

	/**
	 * Returns the link crf where structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public static LinkCRF findByLinkSdId(long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByLinkSdId(structuredDataId);
	}

	/**
	 * Returns the link crf where structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByLinkSdId(long structuredDataId) {
		return getPersistence().fetchByLinkSdId(structuredDataId);
	}

	/**
	 * Returns the link crf where structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public static LinkCRF fetchByLinkSdId(
		long structuredDataId, boolean useFinderCache) {

		return getPersistence().fetchByLinkSdId(
			structuredDataId, useFinderCache);
	}

	/**
	 * Removes the link crf where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	public static LinkCRF removeByLinkSdId(long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().removeByLinkSdId(structuredDataId);
	}

	/**
	 * Returns the number of link crfs where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	public static int countByLinkSdId(long structuredDataId) {
		return getPersistence().countByLinkSdId(structuredDataId);
	}

	/**
	 * Caches the link crf in the entity cache if it is enabled.
	 *
	 * @param linkCRF the link crf
	 */
	public static void cacheResult(LinkCRF linkCRF) {
		getPersistence().cacheResult(linkCRF);
	}

	/**
	 * Caches the link crfs in the entity cache if it is enabled.
	 *
	 * @param linkCRFs the link crfs
	 */
	public static void cacheResult(List<LinkCRF> linkCRFs) {
		getPersistence().cacheResult(linkCRFs);
	}

	/**
	 * Creates a new link crf with the primary key. Does not add the link crf to the database.
	 *
	 * @param linkId the primary key for the new link crf
	 * @return the new link crf
	 */
	public static LinkCRF create(long linkId) {
		return getPersistence().create(linkId);
	}

	/**
	 * Removes the link crf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf that was removed
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF remove(long linkId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().remove(linkId);
	}

	public static LinkCRF updateImpl(LinkCRF linkCRF) {
		return getPersistence().updateImpl(linkCRF);
	}

	/**
	 * Returns the link crf with the primary key or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public static LinkCRF findByPrimaryKey(long linkId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return getPersistence().findByPrimaryKey(linkId);
	}

	/**
	 * Returns the link crf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf, or <code>null</code> if a link crf with the primary key could not be found
	 */
	public static LinkCRF fetchByPrimaryKey(long linkId) {
		return getPersistence().fetchByPrimaryKey(linkId);
	}

	/**
	 * Returns all the link crfs.
	 *
	 * @return the link crfs
	 */
	public static List<LinkCRF> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of link crfs
	 */
	public static List<LinkCRF> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of link crfs
	 */
	public static List<LinkCRF> findAll(
		int start, int end, OrderByComparator<LinkCRF> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of link crfs
	 */
	public static List<LinkCRF> findAll(
		int start, int end, OrderByComparator<LinkCRF> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the link crfs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of link crfs.
	 *
	 * @return the number of link crfs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LinkCRFPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LinkCRFPersistence, LinkCRFPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LinkCRFPersistence.class);

		ServiceTracker<LinkCRFPersistence, LinkCRFPersistence> serviceTracker =
			new ServiceTracker<LinkCRFPersistence, LinkCRFPersistence>(
				bundle.getBundleContext(), LinkCRFPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}