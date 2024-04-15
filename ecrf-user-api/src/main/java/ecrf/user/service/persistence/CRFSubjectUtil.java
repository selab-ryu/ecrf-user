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

import ecrf.user.model.CRFSubject;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the crf subject service. This utility wraps <code>ecrf.user.service.persistence.impl.CRFSubjectPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFSubjectPersistence
 * @generated
 */
public class CRFSubjectUtil {

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
	public static void clearCache(CRFSubject crfSubject) {
		getPersistence().clearCache(crfSubject);
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
	public static Map<Serializable, CRFSubject> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CRFSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CRFSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CRFSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CRFSubject update(CRFSubject crfSubject) {
		return getPersistence().update(crfSubject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CRFSubject update(
		CRFSubject crfSubject, ServiceContext serviceContext) {

		return getPersistence().update(crfSubject, serviceContext);
	}

	/**
	 * Returns all the crf subjects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf subjects
	 */
	public static List<CRFSubject> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the crf subjects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	public static List<CRFSubject> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the crf subjects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf subjects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByUuid_First(
			String uuid, OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByUuid_First(
		String uuid, OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByUuid_Last(
			String uuid, OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByUuid_Last(
		String uuid, OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public static CRFSubject[] findByUuid_PrevAndNext(
			long crfSubjectId, String uuid,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByUuid_PrevAndNext(
			crfSubjectId, uuid, orderByComparator);
	}

	/**
	 * Removes all the crf subjects where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of crf subjects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf subjects
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the crf subject where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFSubjectException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf subject where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf subject where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the crf subject where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf subject that was removed
	 */
	public static CRFSubject removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of crf subjects where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf subjects
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf subjects
	 */
	public static List<CRFSubject> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	public static List<CRFSubject> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public static CRFSubject[] findByUuid_C_PrevAndNext(
			long crfSubjectId, String uuid, long companyId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByUuid_C_PrevAndNext(
			crfSubjectId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the crf subjects where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf subjects
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the crf subjects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf subjects
	 */
	public static List<CRFSubject> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the crf subjects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	public static List<CRFSubject> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByGroupId_First(
			long groupId, OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByGroupId_First(
		long groupId, OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByGroupId_Last(
			long groupId, OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public static CRFSubject[] findByGroupId_PrevAndNext(
			long crfSubjectId, long groupId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByGroupId_PrevAndNext(
			crfSubjectId, groupId, orderByComparator);
	}

	/**
	 * Removes all the crf subjects where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of crf subjects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf subjects
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf subjects
	 */
	public static List<CRFSubject> findByG_C(long groupId, long crfId) {
		return getPersistence().findByG_C(groupId, crfId);
	}

	/**
	 * Returns a range of all the crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	public static List<CRFSubject> findByG_C(
		long groupId, long crfId, int start, int end) {

		return getPersistence().findByG_C(groupId, crfId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public static CRFSubject[] findByG_C_PrevAndNext(
			long crfSubjectId, long groupId, long crfId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByG_C_PrevAndNext(
			crfSubjectId, groupId, crfId, orderByComparator);
	}

	/**
	 * Removes all the crf subjects where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public static void removeByG_C(long groupId, long crfId) {
		getPersistence().removeByG_C(groupId, crfId);
	}

	/**
	 * Returns the number of crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf subjects
	 */
	public static int countByG_C(long groupId, long crfId) {
		return getPersistence().countByG_C(groupId, crfId);
	}

	/**
	 * Returns all the crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the matching crf subjects
	 */
	public static List<CRFSubject> findByG_S(long groupId, long subjectId) {
		return getPersistence().findByG_S(groupId, subjectId);
	}

	/**
	 * Returns a range of all the crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	public static List<CRFSubject> findByG_S(
		long groupId, long subjectId, int start, int end) {

		return getPersistence().findByG_S(groupId, subjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, subjectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, subjectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByG_S_First(
			long groupId, long subjectId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByG_S_First(
			groupId, subjectId, orderByComparator);
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByG_S_First(
		long groupId, long subjectId,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByG_S_Last(
			long groupId, long subjectId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByG_S_Last(
			groupId, subjectId, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByG_S_Last(
		long groupId, long subjectId,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, subjectId, orderByComparator);
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public static CRFSubject[] findByG_S_PrevAndNext(
			long crfSubjectId, long groupId, long subjectId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByG_S_PrevAndNext(
			crfSubjectId, groupId, subjectId, orderByComparator);
	}

	/**
	 * Removes all the crf subjects where groupId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 */
	public static void removeByG_S(long groupId, long subjectId) {
		getPersistence().removeByG_S(groupId, subjectId);
	}

	/**
	 * Returns the number of crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf subjects
	 */
	public static int countByG_S(long groupId, long subjectId) {
		return getPersistence().countByG_S(groupId, subjectId);
	}

	/**
	 * Returns the crf subject where crfId = &#63; and subjectId = &#63; or throws a <code>NoSuchCRFSubjectException</code> if it could not be found.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByC_S(long crfId, long subjectId)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByC_S(crfId, subjectId);
	}

	/**
	 * Returns the crf subject where crfId = &#63; and subjectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByC_S(long crfId, long subjectId) {
		return getPersistence().fetchByC_S(crfId, subjectId);
	}

	/**
	 * Returns the crf subject where crfId = &#63; and subjectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByC_S(
		long crfId, long subjectId, boolean useFinderCache) {

		return getPersistence().fetchByC_S(crfId, subjectId, useFinderCache);
	}

	/**
	 * Removes the crf subject where crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the crf subject that was removed
	 */
	public static CRFSubject removeByC_S(long crfId, long subjectId)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().removeByC_S(crfId, subjectId);
	}

	/**
	 * Returns the number of crf subjects where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf subjects
	 */
	public static int countByC_S(long crfId, long subjectId) {
		return getPersistence().countByC_S(crfId, subjectId);
	}

	/**
	 * Returns all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @return the matching crf subjects
	 */
	public static List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		return getPersistence().findByG_C_UL(groupId, crfId, updateLock);
	}

	/**
	 * Returns a range of all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	public static List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end) {

		return getPersistence().findByG_C_UL(
			groupId, crfId, updateLock, start, end);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().findByG_C_UL(
			groupId, crfId, updateLock, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	public static List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_UL(
			groupId, crfId, updateLock, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByG_C_UL_First(
			long groupId, long crfId, boolean updateLock,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByG_C_UL_First(
			groupId, crfId, updateLock, orderByComparator);
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByG_C_UL_First(
		long groupId, long crfId, boolean updateLock,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByG_C_UL_First(
			groupId, crfId, updateLock, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public static CRFSubject findByG_C_UL_Last(
			long groupId, long crfId, boolean updateLock,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByG_C_UL_Last(
			groupId, crfId, updateLock, orderByComparator);
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchByG_C_UL_Last(
		long groupId, long crfId, boolean updateLock,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().fetchByG_C_UL_Last(
			groupId, crfId, updateLock, orderByComparator);
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public static CRFSubject[] findByG_C_UL_PrevAndNext(
			long crfSubjectId, long groupId, long crfId, boolean updateLock,
			OrderByComparator<CRFSubject> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByG_C_UL_PrevAndNext(
			crfSubjectId, groupId, crfId, updateLock, orderByComparator);
	}

	/**
	 * Removes all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 */
	public static void removeByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		getPersistence().removeByG_C_UL(groupId, crfId, updateLock);
	}

	/**
	 * Returns the number of crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @return the number of matching crf subjects
	 */
	public static int countByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		return getPersistence().countByG_C_UL(groupId, crfId, updateLock);
	}

	/**
	 * Caches the crf subject in the entity cache if it is enabled.
	 *
	 * @param crfSubject the crf subject
	 */
	public static void cacheResult(CRFSubject crfSubject) {
		getPersistence().cacheResult(crfSubject);
	}

	/**
	 * Caches the crf subjects in the entity cache if it is enabled.
	 *
	 * @param crfSubjects the crf subjects
	 */
	public static void cacheResult(List<CRFSubject> crfSubjects) {
		getPersistence().cacheResult(crfSubjects);
	}

	/**
	 * Creates a new crf subject with the primary key. Does not add the crf subject to the database.
	 *
	 * @param crfSubjectId the primary key for the new crf subject
	 * @return the new crf subject
	 */
	public static CRFSubject create(long crfSubjectId) {
		return getPersistence().create(crfSubjectId);
	}

	/**
	 * Removes the crf subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject that was removed
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public static CRFSubject remove(long crfSubjectId)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().remove(crfSubjectId);
	}

	public static CRFSubject updateImpl(CRFSubject crfSubject) {
		return getPersistence().updateImpl(crfSubject);
	}

	/**
	 * Returns the crf subject with the primary key or throws a <code>NoSuchCRFSubjectException</code> if it could not be found.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public static CRFSubject findByPrimaryKey(long crfSubjectId)
		throws ecrf.user.exception.NoSuchCRFSubjectException {

		return getPersistence().findByPrimaryKey(crfSubjectId);
	}

	/**
	 * Returns the crf subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject, or <code>null</code> if a crf subject with the primary key could not be found
	 */
	public static CRFSubject fetchByPrimaryKey(long crfSubjectId) {
		return getPersistence().fetchByPrimaryKey(crfSubjectId);
	}

	/**
	 * Returns all the crf subjects.
	 *
	 * @return the crf subjects
	 */
	public static List<CRFSubject> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the crf subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of crf subjects
	 */
	public static List<CRFSubject> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the crf subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf subjects
	 */
	public static List<CRFSubject> findAll(
		int start, int end, OrderByComparator<CRFSubject> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf subjects
	 */
	public static List<CRFSubject> findAll(
		int start, int end, OrderByComparator<CRFSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the crf subjects from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of crf subjects.
	 *
	 * @return the number of crf subjects
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CRFSubjectPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CRFSubjectPersistence _persistence;

}