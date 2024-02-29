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

import ecrf.user.exception.NoSuchCRFAutoqueryException;
import ecrf.user.model.CRFAutoquery;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the crf autoquery service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFAutoqueryUtil
 * @generated
 */
@ProviderType
public interface CRFAutoqueryPersistence extends BasePersistence<CRFAutoquery> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CRFAutoqueryUtil} to access the crf autoquery persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the crf autoqueries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findByUuid(String uuid);

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
	public java.util.List<CRFAutoquery> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CRFAutoquery> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public CRFAutoquery[] findByUuid_PrevAndNext(
			long autoQueryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Removes all the crf autoqueries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of crf autoqueries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf autoqueries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the crf autoquery where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the crf autoquery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the crf autoquery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the crf autoquery where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf autoquery that was removed
	 */
	public CRFAutoquery removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the number of crf autoqueries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf autoqueries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public CRFAutoquery[] findByUuid_C_PrevAndNext(
			long autoQueryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Removes all the crf autoqueries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf autoqueries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the crf autoqueries where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findByAutoQueryId(long autoQueryId);

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
	public java.util.List<CRFAutoquery> findByAutoQueryId(
		long autoQueryId, int start, int end);

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
	public java.util.List<CRFAutoquery> findByAutoQueryId(
		long autoQueryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findByAutoQueryId(
		long autoQueryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByAutoQueryId_First(
			long autoQueryId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByAutoQueryId_First(
		long autoQueryId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the last crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByAutoQueryId_Last(
			long autoQueryId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByAutoQueryId_Last(
		long autoQueryId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Removes all the crf autoqueries where autoQueryId = &#63; from the database.
	 *
	 * @param autoQueryId the auto query ID
	 */
	public void removeByAutoQueryId(long autoQueryId);

	/**
	 * Returns the number of crf autoqueries where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @return the number of matching crf autoqueries
	 */
	public int countByAutoQueryId(long autoQueryId);

	/**
	 * Returns all the crf autoqueries where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findByQueryTermId(long queryTermId);

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
	public java.util.List<CRFAutoquery> findByQueryTermId(
		long queryTermId, int start, int end);

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
	public java.util.List<CRFAutoquery> findByQueryTermId(
		long queryTermId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findByQueryTermId(
		long queryTermId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByQueryTermId_First(
			long queryTermId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByQueryTermId_First(
		long queryTermId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByQueryTermId_Last(
			long queryTermId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByQueryTermId_Last(
		long queryTermId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public CRFAutoquery[] findByQueryTermId_PrevAndNext(
			long autoQueryId, long queryTermId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Removes all the crf autoqueries where queryTermId = &#63; from the database.
	 *
	 * @param queryTermId the query term ID
	 */
	public void removeByQueryTermId(long queryTermId);

	/**
	 * Returns the number of crf autoqueries where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @return the number of matching crf autoqueries
	 */
	public int countByQueryTermId(long queryTermId);

	/**
	 * Returns all the crf autoqueries where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findBySubjectId(long subjectId);

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
	public java.util.List<CRFAutoquery> findBySubjectId(
		long subjectId, int start, int end);

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
	public java.util.List<CRFAutoquery> findBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findBySubjectId_First(
			long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchBySubjectId_First(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the last crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findBySubjectId_Last(
			long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchBySubjectId_Last(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public CRFAutoquery[] findBySubjectId_PrevAndNext(
			long autoQueryId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Removes all the crf autoqueries where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	public void removeBySubjectId(long subjectId);

	/**
	 * Returns the number of crf autoqueries where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching crf autoqueries
	 */
	public int countBySubjectId(long subjectId);

	/**
	 * Returns all the crf autoqueries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findByUserId(long userId);

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
	public java.util.List<CRFAutoquery> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<CRFAutoquery> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the last crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public CRFAutoquery[] findByUserId_PrevAndNext(
			long autoQueryId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Removes all the crf autoqueries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of crf autoqueries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching crf autoqueries
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the crf autoqueries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findByGroupId(long groupId);

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
	public java.util.List<CRFAutoquery> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<CRFAutoquery> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public CRFAutoquery[] findByGroupId_PrevAndNext(
			long autoQueryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Removes all the crf autoqueries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of crf autoqueries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf autoqueries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findByG_C(long groupId, long crfId);

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
	public java.util.List<CRFAutoquery> findByG_C(
		long groupId, long crfId, int start, int end);

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
	public java.util.List<CRFAutoquery> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByG_C_First(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByG_C_First(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findByG_C_Last(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByG_C_Last(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public CRFAutoquery[] findByG_C_PrevAndNext(
			long autoQueryId, long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Removes all the crf autoqueries where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public void removeByG_C(long groupId, long crfId);

	/**
	 * Returns the number of crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf autoqueries
	 */
	public int countByG_C(long groupId, long crfId);

	/**
	 * Returns all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId);

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
	public java.util.List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end);

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
	public java.util.List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

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
	public CRFAutoquery findByG_C_S_First(
			long groupId, long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByG_C_S_First(
		long groupId, long crfId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public CRFAutoquery findByG_C_S_Last(
			long groupId, long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchByG_C_S_Last(
		long groupId, long crfId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public CRFAutoquery[] findByG_C_S_PrevAndNext(
			long autoQueryId, long groupId, long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Removes all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	public void removeByG_C_S(long groupId, long crfId, long subjectId);

	/**
	 * Returns the number of crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf autoqueries
	 */
	public int countByG_C_S(long groupId, long crfId, long subjectId);

	/**
	 * Returns all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @return the matching crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue);

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
	public java.util.List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue, int start,
		int end);

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
	public java.util.List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

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
	public CRFAutoquery findBySdIdSIdValue_First(
			long queryTermId, long subjectId, String queryValue,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchBySdIdSIdValue_First(
		long queryTermId, long subjectId, String queryValue,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public CRFAutoquery findBySdIdSIdValue_Last(
			long queryTermId, long subjectId, String queryValue,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchBySdIdSIdValue_Last(
		long queryTermId, long subjectId, String queryValue,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public CRFAutoquery[] findBySdIdSIdValue_PrevAndNext(
			long autoQueryId, long queryTermId, long subjectId,
			String queryValue,
			com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
				orderByComparator)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Removes all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63; from the database.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 */
	public void removeBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue);

	/**
	 * Returns the number of crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @return the number of matching crf autoqueries
	 */
	public int countBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue);

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
	public CRFAutoquery findBySdIdSIdValue_MODEL(
			long queryTermId, long subjectId, String queryTermName,
			String queryValue)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchBySdIdSIdValue_MODEL(
		long queryTermId, long subjectId, String queryTermName,
		String queryValue);

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
	public CRFAutoquery fetchBySdIdSIdValue_MODEL(
		long queryTermId, long subjectId, String queryTermName,
		String queryValue, boolean useFinderCache);

	/**
	 * Removes the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; from the database.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the crf autoquery that was removed
	 */
	public CRFAutoquery removeBySdIdSIdValue_MODEL(
			long queryTermId, long subjectId, String queryTermName,
			String queryValue)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the number of crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the number of matching crf autoqueries
	 */
	public int countBySdIdSIdValue_MODEL(
		long queryTermId, long subjectId, String queryTermName,
		String queryValue);

	/**
	 * Returns the crf autoquery where subjectId = &#63; and queryTermName = &#63; or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	public CRFAutoquery findBySIdTN(long subjectId, String queryTermName)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the crf autoquery where subjectId = &#63; and queryTermName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchBySIdTN(long subjectId, String queryTermName);

	/**
	 * Returns the crf autoquery where subjectId = &#63; and queryTermName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public CRFAutoquery fetchBySIdTN(
		long subjectId, String queryTermName, boolean useFinderCache);

	/**
	 * Removes the crf autoquery where subjectId = &#63; and queryTermName = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the crf autoquery that was removed
	 */
	public CRFAutoquery removeBySIdTN(long subjectId, String queryTermName)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the number of crf autoqueries where subjectId = &#63; and queryTermName = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the number of matching crf autoqueries
	 */
	public int countBySIdTN(long subjectId, String queryTermName);

	/**
	 * Caches the crf autoquery in the entity cache if it is enabled.
	 *
	 * @param crfAutoquery the crf autoquery
	 */
	public void cacheResult(CRFAutoquery crfAutoquery);

	/**
	 * Caches the crf autoqueries in the entity cache if it is enabled.
	 *
	 * @param crfAutoqueries the crf autoqueries
	 */
	public void cacheResult(java.util.List<CRFAutoquery> crfAutoqueries);

	/**
	 * Creates a new crf autoquery with the primary key. Does not add the crf autoquery to the database.
	 *
	 * @param autoQueryId the primary key for the new crf autoquery
	 * @return the new crf autoquery
	 */
	public CRFAutoquery create(long autoQueryId);

	/**
	 * Removes the crf autoquery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery that was removed
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public CRFAutoquery remove(long autoQueryId)
		throws NoSuchCRFAutoqueryException;

	public CRFAutoquery updateImpl(CRFAutoquery crfAutoquery);

	/**
	 * Returns the crf autoquery with the primary key or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	public CRFAutoquery findByPrimaryKey(long autoQueryId)
		throws NoSuchCRFAutoqueryException;

	/**
	 * Returns the crf autoquery with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery, or <code>null</code> if a crf autoquery with the primary key could not be found
	 */
	public CRFAutoquery fetchByPrimaryKey(long autoQueryId);

	/**
	 * Returns all the crf autoqueries.
	 *
	 * @return the crf autoqueries
	 */
	public java.util.List<CRFAutoquery> findAll();

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
	public java.util.List<CRFAutoquery> findAll(int start, int end);

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
	public java.util.List<CRFAutoquery> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator);

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
	public java.util.List<CRFAutoquery> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFAutoquery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the crf autoqueries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of crf autoqueries.
	 *
	 * @return the number of crf autoqueries
	 */
	public int countAll();

}