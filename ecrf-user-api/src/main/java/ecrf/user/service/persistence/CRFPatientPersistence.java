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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import ecrf.user.exception.NoSuchCRFPatientException;
import ecrf.user.model.CRFPatient;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the crf patient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CRFPatientUtil
 * @generated
 */
@ProviderType
public interface CRFPatientPersistence extends BasePersistence<CRFPatient> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CRFPatientUtil} to access the crf patient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the crf patients where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf patients
	 */
	public java.util.List<CRFPatient> findByUuid(String uuid);

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
	public java.util.List<CRFPatient> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CRFPatient> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

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
	public java.util.List<CRFPatient> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public CRFPatient[] findByUuid_PrevAndNext(
			long crfPatientId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Removes all the crf patients where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of crf patients where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf patients
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the crf patient where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFPatientException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the crf patient where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the crf patient where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the crf patient where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf patient that was removed
	 */
	public CRFPatient removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the number of crf patients where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf patients
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf patients
	 */
	public java.util.List<CRFPatient> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<CRFPatient> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CRFPatient> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

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
	public java.util.List<CRFPatient> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

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
	public CRFPatient[] findByUuid_C_PrevAndNext(
			long crfPatientId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Removes all the crf patients where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf patients
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the crf patients where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf patients
	 */
	public java.util.List<CRFPatient> findByGroupId(long groupId);

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
	public java.util.List<CRFPatient> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<CRFPatient> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

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
	public java.util.List<CRFPatient> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public CRFPatient[] findByGroupId_PrevAndNext(
			long crfPatientId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Removes all the crf patients where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of crf patients where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf patients
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf patients
	 */
	public java.util.List<CRFPatient> findByG_C(long groupId, long crfId);

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
	public java.util.List<CRFPatient> findByG_C(
		long groupId, long crfId, int start, int end);

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
	public java.util.List<CRFPatient> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

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
	public java.util.List<CRFPatient> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByG_C_First(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByG_C_First(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByG_C_Last(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByG_C_Last(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

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
	public CRFPatient[] findByG_C_PrevAndNext(
			long crfPatientId, long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Removes all the crf patients where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public void removeByG_C(long groupId, long crfId);

	/**
	 * Returns the number of crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf patients
	 */
	public int countByG_C(long groupId, long crfId);

	/**
	 * Returns all the crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @return the matching crf patients
	 */
	public java.util.List<CRFPatient> findByG_PA(long groupId, long patientId);

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
	public java.util.List<CRFPatient> findByG_PA(
		long groupId, long patientId, int start, int end);

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
	public java.util.List<CRFPatient> findByG_PA(
		long groupId, long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

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
	public java.util.List<CRFPatient> findByG_PA(
		long groupId, long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByG_PA_First(
			long groupId, long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByG_PA_First(
		long groupId, long patientId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	public CRFPatient findByG_PA_Last(
			long groupId, long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public CRFPatient fetchByG_PA_Last(
		long groupId, long patientId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

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
	public CRFPatient[] findByG_PA_PrevAndNext(
			long crfPatientId, long groupId, long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
				orderByComparator)
		throws NoSuchCRFPatientException;

	/**
	 * Removes all the crf patients where groupId = &#63; and patientId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 */
	public void removeByG_PA(long groupId, long patientId);

	/**
	 * Returns the number of crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @return the number of matching crf patients
	 */
	public int countByG_PA(long groupId, long patientId);

	/**
	 * Caches the crf patient in the entity cache if it is enabled.
	 *
	 * @param crfPatient the crf patient
	 */
	public void cacheResult(CRFPatient crfPatient);

	/**
	 * Caches the crf patients in the entity cache if it is enabled.
	 *
	 * @param crfPatients the crf patients
	 */
	public void cacheResult(java.util.List<CRFPatient> crfPatients);

	/**
	 * Creates a new crf patient with the primary key. Does not add the crf patient to the database.
	 *
	 * @param crfPatientId the primary key for the new crf patient
	 * @return the new crf patient
	 */
	public CRFPatient create(long crfPatientId);

	/**
	 * Removes the crf patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient that was removed
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public CRFPatient remove(long crfPatientId)
		throws NoSuchCRFPatientException;

	public CRFPatient updateImpl(CRFPatient crfPatient);

	/**
	 * Returns the crf patient with the primary key or throws a <code>NoSuchCRFPatientException</code> if it could not be found.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	public CRFPatient findByPrimaryKey(long crfPatientId)
		throws NoSuchCRFPatientException;

	/**
	 * Returns the crf patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient, or <code>null</code> if a crf patient with the primary key could not be found
	 */
	public CRFPatient fetchByPrimaryKey(long crfPatientId);

	/**
	 * Returns all the crf patients.
	 *
	 * @return the crf patients
	 */
	public java.util.List<CRFPatient> findAll();

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
	public java.util.List<CRFPatient> findAll(int start, int end);

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
	public java.util.List<CRFPatient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator);

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
	public java.util.List<CRFPatient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFPatient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the crf patients from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of crf patients.
	 *
	 * @return the number of crf patients
	 */
	public int countAll();

}