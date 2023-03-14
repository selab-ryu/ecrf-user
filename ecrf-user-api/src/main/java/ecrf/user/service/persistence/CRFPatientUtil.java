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

import ecrf.user.model.CRFPatient;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the crf patient service. This utility wraps <code>ecrf.user.service.persistence.impl.CRFPatientPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFPatientPersistence
 * @generated
 */
public class CRFPatientUtil {

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
	public static void clearCache(CRFPatient crfPatient) {
		getPersistence().clearCache(crfPatient);
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
	public static Map<Serializable, CRFPatient> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CRFPatient> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CRFPatient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CRFPatient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CRFPatient update(CRFPatient crfPatient) {
		return getPersistence().update(crfPatient);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CRFPatient update(
		CRFPatient crfPatient, ServiceContext serviceContext) {

		return getPersistence().update(crfPatient, serviceContext);
	}

	/**
	 * Returns all the crf patients where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf patients
	 */
	public static List<CRFPatient> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the crf patients where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	public static List<CRFPatient> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the crf patients where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf patients where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByUuid_First(
			String uuid, OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByUuid_First(
		String uuid, OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByUuid_Last(
			String uuid, OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByUuid_Last(
		String uuid, OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public static CRFPatient[] findByUuid_PrevAndNext(
			long crfPatientId, String uuid,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByUuid_PrevAndNext(
			crfPatientId, uuid, orderByComparator);
	}

	/**
	 * Removes all the crf patients where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of crf patients where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf patients
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the crf patient where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFPatientException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf patient where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf patient where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the crf patient where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf patient that was removed
	 */
	public static CRFPatient removeByUUID_G(String uuid, long groupId)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of crf patients where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf patients
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf patients
	 */
	public static List<CRFPatient> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	public static List<CRFPatient> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public static CRFPatient[] findByUuid_C_PrevAndNext(
			long crfPatientId, String uuid, long companyId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByUuid_C_PrevAndNext(
			crfPatientId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the crf patients where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf patients
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the crf patients where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf patients
	 */
	public static List<CRFPatient> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the crf patients where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	public static List<CRFPatient> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByGroupId_First(
			long groupId, OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByGroupId_First(
		long groupId, OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByGroupId_Last(
			long groupId, OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public static CRFPatient[] findByGroupId_PrevAndNext(
			long crfPatientId, long groupId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByGroupId_PrevAndNext(
			crfPatientId, groupId, orderByComparator);
	}

	/**
	 * Removes all the crf patients where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of crf patients where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf patients
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf patients
	 */
	public static List<CRFPatient> findByG_C(long groupId, long crfId) {
		return getPersistence().findByG_C(groupId, crfId);
	}

	/**
	 * Returns a range of all the crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	public static List<CRFPatient> findByG_C(
		long groupId, long crfId, int start, int end) {

		return getPersistence().findByG_C(groupId, crfId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C(
			groupId, crfId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByG_C_First(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByG_C_Last(
			groupId, crfId, orderByComparator);
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public static CRFPatient[] findByG_C_PrevAndNext(
			long crfPatientId, long groupId, long crfId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByG_C_PrevAndNext(
			crfPatientId, groupId, crfId, orderByComparator);
	}

	/**
	 * Removes all the crf patients where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public static void removeByG_C(long groupId, long crfId) {
		getPersistence().removeByG_C(groupId, crfId);
	}

	/**
	 * Returns the number of crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf patients
	 */
	public static int countByG_C(long groupId, long crfId) {
		return getPersistence().countByG_C(groupId, crfId);
	}

	/**
	 * Returns all the crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @return the matching crf patients
	 */
	public static List<CRFPatient> findByG_PA(long groupId, long patientId) {
		return getPersistence().findByG_PA(groupId, patientId);
	}

	/**
	 * Returns a range of all the crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	public static List<CRFPatient> findByG_PA(
		long groupId, long patientId, int start, int end) {

		return getPersistence().findByG_PA(groupId, patientId, start, end);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByG_PA(
		long groupId, long patientId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().findByG_PA(
			groupId, patientId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	public static List<CRFPatient> findByG_PA(
		long groupId, long patientId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_PA(
			groupId, patientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByG_PA_First(
			long groupId, long patientId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByG_PA_First(
			groupId, patientId, orderByComparator);
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByG_PA_First(
		long groupId, long patientId,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByG_PA_First(
			groupId, patientId, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public static CRFPatient findByG_PA_Last(
			long groupId, long patientId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByG_PA_Last(
			groupId, patientId, orderByComparator);
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchByG_PA_Last(
		long groupId, long patientId,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().fetchByG_PA_Last(
			groupId, patientId, orderByComparator);
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public static CRFPatient[] findByG_PA_PrevAndNext(
			long crfPatientId, long groupId, long patientId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByG_PA_PrevAndNext(
			crfPatientId, groupId, patientId, orderByComparator);
	}

	/**
	 * Removes all the crf patients where groupId = &#63; and patientId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 */
	public static void removeByG_PA(long groupId, long patientId) {
		getPersistence().removeByG_PA(groupId, patientId);
	}

	/**
	 * Returns the number of crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @return the number of matching crf patients
	 */
	public static int countByG_PA(long groupId, long patientId) {
		return getPersistence().countByG_PA(groupId, patientId);
	}

	/**
	 * Caches the crf patient in the entity cache if it is enabled.
	 *
	 * @param crfPatient the crf patient
	 */
	public static void cacheResult(CRFPatient crfPatient) {
		getPersistence().cacheResult(crfPatient);
	}

	/**
	 * Caches the crf patients in the entity cache if it is enabled.
	 *
	 * @param crfPatients the crf patients
	 */
	public static void cacheResult(List<CRFPatient> crfPatients) {
		getPersistence().cacheResult(crfPatients);
	}

	/**
	 * Creates a new crf patient with the primary key. Does not add the crf patient to the database.
	 *
	 * @param crfPatientId the primary key for the new crf patient
	 * @return the new crf patient
	 */
	public static CRFPatient create(long crfPatientId) {
		return getPersistence().create(crfPatientId);
	}

	/**
	 * Removes the crf patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient that was removed
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public static CRFPatient remove(long crfPatientId)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().remove(crfPatientId);
	}

	public static CRFPatient updateImpl(CRFPatient crfPatient) {
		return getPersistence().updateImpl(crfPatient);
	}

	/**
	 * Returns the crf patient with the primary key or throws a <code>NoSuchCRFPatientException</code> if it could not be found.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public static CRFPatient findByPrimaryKey(long crfPatientId)
		throws ecrf.user.exception.NoSuchCRFPatientException {

		return getPersistence().findByPrimaryKey(crfPatientId);
	}

	/**
	 * Returns the crf patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient, or <code>null</code> if a crf patient with the primary key could not be found
	 */
	public static CRFPatient fetchByPrimaryKey(long crfPatientId) {
		return getPersistence().fetchByPrimaryKey(crfPatientId);
	}

	/**
	 * Returns all the crf patients.
	 *
	 * @return the crf patients
	 */
	public static List<CRFPatient> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the crf patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of crf patients
	 */
	public static List<CRFPatient> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the crf patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf patients
	 */
	public static List<CRFPatient> findAll(
		int start, int end, OrderByComparator<CRFPatient> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crf patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf patients
	 */
	public static List<CRFPatient> findAll(
		int start, int end, OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the crf patients from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of crf patients.
	 *
	 * @return the number of crf patients
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CRFPatientPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CRFPatientPersistence _persistence;

}