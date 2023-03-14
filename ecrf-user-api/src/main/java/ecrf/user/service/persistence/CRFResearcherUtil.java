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

import ecrf.user.model.CRFResearcher;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the crf researcher service. This utility wraps <code>ecrf.user.service.persistence.impl.CRFResearcherPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CRFResearcherPersistence
 * @generated
 */
public class CRFResearcherUtil {

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
	public static void clearCache(CRFResearcher crfResearcher) {
		getPersistence().clearCache(crfResearcher);
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
	public static Map<Serializable, CRFResearcher> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CRFResearcher> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CRFResearcher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CRFResearcher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CRFResearcher update(CRFResearcher crfResearcher) {
		return getPersistence().update(crfResearcher);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CRFResearcher update(
		CRFResearcher crfResearcher, ServiceContext serviceContext) {

		return getPersistence().update(crfResearcher, serviceContext);
	}

	/**
	 * Returns all the crf researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf researchers
	 */
	public static List<CRFResearcher> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the crf researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	public static List<CRFResearcher> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the crf researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByUuid_First(
			String uuid, OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByUuid_First(
		String uuid, OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByUuid_Last(
			String uuid, OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByUuid_Last(
		String uuid, OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public static CRFResearcher[] findByUuid_PrevAndNext(
			long crfResearcherId, String uuid,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByUuid_PrevAndNext(
			crfResearcherId, uuid, orderByComparator);
	}

	/**
	 * Removes all the crf researchers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of crf researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf researchers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the crf researcher where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFResearcherException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the crf researcher where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf researcher that was removed
	 */
	public static CRFResearcher removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of crf researchers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf researchers
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf researchers
	 */
	public static List<CRFResearcher> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	public static List<CRFResearcher> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public static CRFResearcher[] findByUuid_C_PrevAndNext(
			long crfResearcherId, String uuid, long companyId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByUuid_C_PrevAndNext(
			crfResearcherId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the crf researchers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf researchers
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the crf researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf researchers
	 */
	public static List<CRFResearcher> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the crf researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	public static List<CRFResearcher> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByGroupId_First(
			long groupId, OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByGroupId_First(
		long groupId, OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByGroupId_Last(
			long groupId, OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public static CRFResearcher[] findByGroupId_PrevAndNext(
			long crfResearcherId, long groupId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByGroupId_PrevAndNext(
			crfResearcherId, groupId, orderByComparator);
	}

	/**
	 * Removes all the crf researchers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of crf researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf researchers
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf researchers
	 */
	public static List<CRFResearcher> findByG_C(long groupId, long crfId) {
		return getPersistence().findByG_C(groupId, crfId);
	}

	/**
	 * Returns a range of all the crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	public static List<CRFResearcher> findByG_C(
		long groupId, long crfId, int start, int end) {

		return getPersistence().findByG_C(groupId, crfId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public static CRFResearcher[] findByG_C_PrevAndNext(
			long crfResearcherId, long groupId, long crfId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByG_C_PrevAndNext(
			crfResearcherId, groupId, crfId, orderByComparator);
	}

	/**
	 * Removes all the crf researchers where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public static void removeByG_C(long groupId, long crfId) {
		getPersistence().removeByG_C(groupId, crfId);
	}

	/**
	 * Returns the number of crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf researchers
	 */
	public static int countByG_C(long groupId, long crfId) {
		return getPersistence().countByG_C(groupId, crfId);
	}

	/**
	 * Returns all the crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @return the matching crf researchers
	 */
	public static List<CRFResearcher> findByG_R(
		long groupId, long researcherId) {

		return getPersistence().findByG_R(groupId, researcherId);
	}

	/**
	 * Returns a range of all the crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	public static List<CRFResearcher> findByG_R(
		long groupId, long researcherId, int start, int end) {

		return getPersistence().findByG_R(groupId, researcherId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByG_R(
		long groupId, long researcherId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().findByG_R(
			groupId, researcherId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	public static List<CRFResearcher> findByG_R(
		long groupId, long researcherId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_R(
			groupId, researcherId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByG_R_First(
			long groupId, long researcherId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByG_R_First(
			groupId, researcherId, orderByComparator);
	}

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByG_R_First(
		long groupId, long researcherId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByG_R_First(
			groupId, researcherId, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public static CRFResearcher findByG_R_Last(
			long groupId, long researcherId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByG_R_Last(
			groupId, researcherId, orderByComparator);
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public static CRFResearcher fetchByG_R_Last(
		long groupId, long researcherId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().fetchByG_R_Last(
			groupId, researcherId, orderByComparator);
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public static CRFResearcher[] findByG_R_PrevAndNext(
			long crfResearcherId, long groupId, long researcherId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByG_R_PrevAndNext(
			crfResearcherId, groupId, researcherId, orderByComparator);
	}

	/**
	 * Removes all the crf researchers where groupId = &#63; and researcherId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 */
	public static void removeByG_R(long groupId, long researcherId) {
		getPersistence().removeByG_R(groupId, researcherId);
	}

	/**
	 * Returns the number of crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @return the number of matching crf researchers
	 */
	public static int countByG_R(long groupId, long researcherId) {
		return getPersistence().countByG_R(groupId, researcherId);
	}

	/**
	 * Caches the crf researcher in the entity cache if it is enabled.
	 *
	 * @param crfResearcher the crf researcher
	 */
	public static void cacheResult(CRFResearcher crfResearcher) {
		getPersistence().cacheResult(crfResearcher);
	}

	/**
	 * Caches the crf researchers in the entity cache if it is enabled.
	 *
	 * @param crfResearchers the crf researchers
	 */
	public static void cacheResult(List<CRFResearcher> crfResearchers) {
		getPersistence().cacheResult(crfResearchers);
	}

	/**
	 * Creates a new crf researcher with the primary key. Does not add the crf researcher to the database.
	 *
	 * @param crfResearcherId the primary key for the new crf researcher
	 * @return the new crf researcher
	 */
	public static CRFResearcher create(long crfResearcherId) {
		return getPersistence().create(crfResearcherId);
	}

	/**
	 * Removes the crf researcher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher that was removed
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public static CRFResearcher remove(long crfResearcherId)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().remove(crfResearcherId);
	}

	public static CRFResearcher updateImpl(CRFResearcher crfResearcher) {
		return getPersistence().updateImpl(crfResearcher);
	}

	/**
	 * Returns the crf researcher with the primary key or throws a <code>NoSuchCRFResearcherException</code> if it could not be found.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public static CRFResearcher findByPrimaryKey(long crfResearcherId)
		throws ecrf.user.exception.NoSuchCRFResearcherException {

		return getPersistence().findByPrimaryKey(crfResearcherId);
	}

	/**
	 * Returns the crf researcher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher, or <code>null</code> if a crf researcher with the primary key could not be found
	 */
	public static CRFResearcher fetchByPrimaryKey(long crfResearcherId) {
		return getPersistence().fetchByPrimaryKey(crfResearcherId);
	}

	/**
	 * Returns all the crf researchers.
	 *
	 * @return the crf researchers
	 */
	public static List<CRFResearcher> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the crf researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of crf researchers
	 */
	public static List<CRFResearcher> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the crf researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf researchers
	 */
	public static List<CRFResearcher> findAll(
		int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf researchers
	 */
	public static List<CRFResearcher> findAll(
		int start, int end, OrderByComparator<CRFResearcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the crf researchers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of crf researchers.
	 *
	 * @return the number of crf researchers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CRFResearcherPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CRFResearcherPersistence _persistence;

}