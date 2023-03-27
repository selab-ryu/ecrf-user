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

import ecrf.user.model.Researcher;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the researcher service. This utility wraps <code>ecrf.user.service.persistence.impl.ResearcherPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see ResearcherPersistence
 * @generated
 */
public class ResearcherUtil {

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
	public static void clearCache(Researcher researcher) {
		getPersistence().clearCache(researcher);
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
	public static Map<Serializable, Researcher> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Researcher> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Researcher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Researcher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Researcher update(Researcher researcher) {
		return getPersistence().update(researcher);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Researcher update(
		Researcher researcher, ServiceContext serviceContext) {

		return getPersistence().update(researcher, serviceContext);
	}

	/**
	 * Returns all the researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching researchers
	 */
	public static List<Researcher> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public static List<Researcher> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Researcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByUuid_First(
			String uuid, OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByUuid_First(
		String uuid, OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByUuid_Last(
			String uuid, OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByUuid_Last(
		String uuid, OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where uuid = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher[] findByUuid_PrevAndNext(
			long researcherId, String uuid,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByUuid_PrevAndNext(
			researcherId, uuid, orderByComparator);
	}

	/**
	 * Removes all the researchers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching researchers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the researcher where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResearcherException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the researcher where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the researcher that was removed
	 */
	public static Researcher removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of researchers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching researchers
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching researchers
	 */
	public static List<Researcher> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public static List<Researcher> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Researcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher[] findByUuid_C_PrevAndNext(
			long researcherId, String uuid, long companyId,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByUuid_C_PrevAndNext(
			researcherId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the researchers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching researchers
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching researchers
	 */
	public static List<Researcher> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public static List<Researcher> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Researcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByGroupId_First(
			long groupId, OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByGroupId_First(
		long groupId, OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByGroupId_Last(
			long groupId, OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByGroupId_Last(
		long groupId, OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where groupId = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher[] findByGroupId_PrevAndNext(
			long researcherId, long groupId,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByGroupId_PrevAndNext(
			researcherId, groupId, orderByComparator);
	}

	/**
	 * Returns all the researchers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching researchers that the user has permission to view
	 */
	public static List<Researcher> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the researchers that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers that the user has permission to view
	 */
	public static List<Researcher> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the researchers that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers that the user has permission to view
	 */
	public static List<Researcher> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the researchers before and after the current researcher in the ordered set of researchers that the user has permission to view where groupId = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher[] filterFindByGroupId_PrevAndNext(
			long researcherId, long groupId,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			researcherId, groupId, orderByComparator);
	}

	/**
	 * Removes all the researchers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching researchers
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of researchers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching researchers that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the researchers where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching researchers
	 */
	public static List<Researcher> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the researchers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public static List<Researcher> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the researchers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByStatus(
		int status, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the researchers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByStatus(
		int status, int start, int end,
		OrderByComparator<Researcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first researcher in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByStatus_First(
			int status, OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first researcher in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByStatus_First(
		int status, OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByStatus_Last(
			int status, OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByStatus_Last(
		int status, OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where status = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher[] findByStatus_PrevAndNext(
			long researcherId, int status,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByStatus_PrevAndNext(
			researcherId, status, orderByComparator);
	}

	/**
	 * Removes all the researchers where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of researchers where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching researchers
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the researchers where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching researchers
	 */
	public static List<Researcher> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the researchers where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public static List<Researcher> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Researcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByG_S_First(
			long groupId, int status,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByG_S_Last(
			long groupId, int status,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher[] findByG_S_PrevAndNext(
			long researcherId, long groupId, int status,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByG_S_PrevAndNext(
			researcherId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the researchers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching researchers that the user has permission to view
	 */
	public static List<Researcher> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the researchers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers that the user has permission to view
	 */
	public static List<Researcher> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the researchers that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers that the user has permission to view
	 */
	public static List<Researcher> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the researchers before and after the current researcher in the ordered set of researchers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher[] filterFindByG_S_PrevAndNext(
			long researcherId, long groupId, int status,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			researcherId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the researchers where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of researchers where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching researchers
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of researchers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching researchers that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns all the researchers where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @return the matching researchers
	 */
	public static List<Researcher> findByG_P(long groupId, String position) {
		return getPersistence().findByG_P(groupId, position);
	}

	/**
	 * Returns a range of all the researchers where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public static List<Researcher> findByG_P(
		long groupId, String position, int start, int end) {

		return getPersistence().findByG_P(groupId, position, start, end);
	}

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByG_P(
		long groupId, String position, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().findByG_P(
			groupId, position, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public static List<Researcher> findByG_P(
		long groupId, String position, int start, int end,
		OrderByComparator<Researcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_P(
			groupId, position, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByG_P_First(
			long groupId, String position,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByG_P_First(
			groupId, position, orderByComparator);
	}

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByG_P_First(
		long groupId, String position,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByG_P_First(
			groupId, position, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public static Researcher findByG_P_Last(
			long groupId, String position,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByG_P_Last(
			groupId, position, orderByComparator);
	}

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchByG_P_Last(
		long groupId, String position,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().fetchByG_P_Last(
			groupId, position, orderByComparator);
	}

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where groupId = &#63; and position = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher[] findByG_P_PrevAndNext(
			long researcherId, long groupId, String position,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByG_P_PrevAndNext(
			researcherId, groupId, position, orderByComparator);
	}

	/**
	 * Returns all the researchers that the user has permission to view where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @return the matching researchers that the user has permission to view
	 */
	public static List<Researcher> filterFindByG_P(
		long groupId, String position) {

		return getPersistence().filterFindByG_P(groupId, position);
	}

	/**
	 * Returns a range of all the researchers that the user has permission to view where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers that the user has permission to view
	 */
	public static List<Researcher> filterFindByG_P(
		long groupId, String position, int start, int end) {

		return getPersistence().filterFindByG_P(groupId, position, start, end);
	}

	/**
	 * Returns an ordered range of all the researchers that the user has permissions to view where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers that the user has permission to view
	 */
	public static List<Researcher> filterFindByG_P(
		long groupId, String position, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().filterFindByG_P(
			groupId, position, start, end, orderByComparator);
	}

	/**
	 * Returns the researchers before and after the current researcher in the ordered set of researchers that the user has permission to view where groupId = &#63; and position = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher[] filterFindByG_P_PrevAndNext(
			long researcherId, long groupId, String position,
			OrderByComparator<Researcher> orderByComparator)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().filterFindByG_P_PrevAndNext(
			researcherId, groupId, position, orderByComparator);
	}

	/**
	 * Removes all the researchers where groupId = &#63; and position = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 */
	public static void removeByG_P(long groupId, String position) {
		getPersistence().removeByG_P(groupId, position);
	}

	/**
	 * Returns the number of researchers where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @return the number of matching researchers
	 */
	public static int countByG_P(long groupId, String position) {
		return getPersistence().countByG_P(groupId, position);
	}

	/**
	 * Returns the number of researchers that the user has permission to view where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @return the number of matching researchers that the user has permission to view
	 */
	public static int filterCountByG_P(long groupId, String position) {
		return getPersistence().filterCountByG_P(groupId, position);
	}

	/**
	 * Caches the researcher in the entity cache if it is enabled.
	 *
	 * @param researcher the researcher
	 */
	public static void cacheResult(Researcher researcher) {
		getPersistence().cacheResult(researcher);
	}

	/**
	 * Caches the researchers in the entity cache if it is enabled.
	 *
	 * @param researchers the researchers
	 */
	public static void cacheResult(List<Researcher> researchers) {
		getPersistence().cacheResult(researchers);
	}

	/**
	 * Creates a new researcher with the primary key. Does not add the researcher to the database.
	 *
	 * @param researcherId the primary key for the new researcher
	 * @return the new researcher
	 */
	public static Researcher create(long researcherId) {
		return getPersistence().create(researcherId);
	}

	/**
	 * Removes the researcher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher that was removed
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher remove(long researcherId)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().remove(researcherId);
	}

	public static Researcher updateImpl(Researcher researcher) {
		return getPersistence().updateImpl(researcher);
	}

	/**
	 * Returns the researcher with the primary key or throws a <code>NoSuchResearcherException</code> if it could not be found.
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public static Researcher findByPrimaryKey(long researcherId)
		throws ecrf.user.exception.NoSuchResearcherException {

		return getPersistence().findByPrimaryKey(researcherId);
	}

	/**
	 * Returns the researcher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher, or <code>null</code> if a researcher with the primary key could not be found
	 */
	public static Researcher fetchByPrimaryKey(long researcherId) {
		return getPersistence().fetchByPrimaryKey(researcherId);
	}

	/**
	 * Returns all the researchers.
	 *
	 * @return the researchers
	 */
	public static List<Researcher> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of researchers
	 */
	public static List<Researcher> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of researchers
	 */
	public static List<Researcher> findAll(
		int start, int end, OrderByComparator<Researcher> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of researchers
	 */
	public static List<Researcher> findAll(
		int start, int end, OrderByComparator<Researcher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the researchers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of researchers.
	 *
	 * @return the number of researchers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ResearcherPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ResearcherPersistence _persistence;

}