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

import ecrf.user.exception.NoSuchCRFSearchLogException;
import ecrf.user.model.CRFSearchLog;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the crf search log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFSearchLogUtil
 * @generated
 */
@ProviderType
public interface CRFSearchLogPersistence extends BasePersistence<CRFSearchLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CRFSearchLogUtil} to access the crf search log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the crf search logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf search logs
	 */
	public java.util.List<CRFSearchLog> findByUuid(String uuid);

	/**
	 * Returns a range of all the crf search logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of matching crf search logs
	 */
	public java.util.List<CRFSearchLog> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf search logs
	 */
	public java.util.List<CRFSearchLog> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf search logs
	 */
	public java.util.List<CRFSearchLog> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public CRFSearchLog findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
				orderByComparator)
		throws NoSuchCRFSearchLogException;

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public CRFSearchLog fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator);

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public CRFSearchLog findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
				orderByComparator)
		throws NoSuchCRFSearchLogException;

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public CRFSearchLog fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator);

	/**
	 * Returns the crf search logs before and after the current crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param searchLogId the primary key of the current crf search log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	public CRFSearchLog[] findByUuid_PrevAndNext(
			long searchLogId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
				orderByComparator)
		throws NoSuchCRFSearchLogException;

	/**
	 * Removes all the crf search logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of crf search logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf search logs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the crf search log where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFSearchLogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public CRFSearchLog findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFSearchLogException;

	/**
	 * Returns the crf search log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public CRFSearchLog fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the crf search log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public CRFSearchLog fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the crf search log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf search log that was removed
	 */
	public CRFSearchLog removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFSearchLogException;

	/**
	 * Returns the number of crf search logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf search logs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf search logs
	 */
	public java.util.List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of matching crf search logs
	 */
	public java.util.List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf search logs
	 */
	public java.util.List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf search logs
	 */
	public java.util.List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public CRFSearchLog findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
				orderByComparator)
		throws NoSuchCRFSearchLogException;

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public CRFSearchLog fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator);

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public CRFSearchLog findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
				orderByComparator)
		throws NoSuchCRFSearchLogException;

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public CRFSearchLog fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator);

	/**
	 * Returns the crf search logs before and after the current crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param searchLogId the primary key of the current crf search log
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	public CRFSearchLog[] findByUuid_C_PrevAndNext(
			long searchLogId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
				orderByComparator)
		throws NoSuchCRFSearchLogException;

	/**
	 * Removes all the crf search logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf search logs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the crf search log where searchLogId = &#63; or throws a <code>NoSuchCRFSearchLogException</code> if it could not be found.
	 *
	 * @param searchLogId the search log ID
	 * @return the matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	public CRFSearchLog findBySearchLogId(long searchLogId)
		throws NoSuchCRFSearchLogException;

	/**
	 * Returns the crf search log where searchLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param searchLogId the search log ID
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public CRFSearchLog fetchBySearchLogId(long searchLogId);

	/**
	 * Returns the crf search log where searchLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param searchLogId the search log ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	public CRFSearchLog fetchBySearchLogId(
		long searchLogId, boolean useFinderCache);

	/**
	 * Removes the crf search log where searchLogId = &#63; from the database.
	 *
	 * @param searchLogId the search log ID
	 * @return the crf search log that was removed
	 */
	public CRFSearchLog removeBySearchLogId(long searchLogId)
		throws NoSuchCRFSearchLogException;

	/**
	 * Returns the number of crf search logs where searchLogId = &#63;.
	 *
	 * @param searchLogId the search log ID
	 * @return the number of matching crf search logs
	 */
	public int countBySearchLogId(long searchLogId);

	/**
	 * Caches the crf search log in the entity cache if it is enabled.
	 *
	 * @param crfSearchLog the crf search log
	 */
	public void cacheResult(CRFSearchLog crfSearchLog);

	/**
	 * Caches the crf search logs in the entity cache if it is enabled.
	 *
	 * @param crfSearchLogs the crf search logs
	 */
	public void cacheResult(java.util.List<CRFSearchLog> crfSearchLogs);

	/**
	 * Creates a new crf search log with the primary key. Does not add the crf search log to the database.
	 *
	 * @param searchLogId the primary key for the new crf search log
	 * @return the new crf search log
	 */
	public CRFSearchLog create(long searchLogId);

	/**
	 * Removes the crf search log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log that was removed
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	public CRFSearchLog remove(long searchLogId)
		throws NoSuchCRFSearchLogException;

	public CRFSearchLog updateImpl(CRFSearchLog crfSearchLog);

	/**
	 * Returns the crf search log with the primary key or throws a <code>NoSuchCRFSearchLogException</code> if it could not be found.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	public CRFSearchLog findByPrimaryKey(long searchLogId)
		throws NoSuchCRFSearchLogException;

	/**
	 * Returns the crf search log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log, or <code>null</code> if a crf search log with the primary key could not be found
	 */
	public CRFSearchLog fetchByPrimaryKey(long searchLogId);

	/**
	 * Returns all the crf search logs.
	 *
	 * @return the crf search logs
	 */
	public java.util.List<CRFSearchLog> findAll();

	/**
	 * Returns a range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of crf search logs
	 */
	public java.util.List<CRFSearchLog> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf search logs
	 */
	public java.util.List<CRFSearchLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf search logs
	 */
	public java.util.List<CRFSearchLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSearchLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the crf search logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of crf search logs.
	 *
	 * @return the number of crf search logs
	 */
	public int countAll();

}