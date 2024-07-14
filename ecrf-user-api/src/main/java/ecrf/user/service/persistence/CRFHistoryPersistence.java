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

import ecrf.user.exception.NoSuchCRFHistoryException;
import ecrf.user.model.CRFHistory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the crf history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFHistoryUtil
 * @generated
 */
@ProviderType
public interface CRFHistoryPersistence extends BasePersistence<CRFHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CRFHistoryUtil} to access the crf history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the crf histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByUuid(String uuid);

	/**
	 * Returns a range of all the crf histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where uuid = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByUuid_PrevAndNext(
			long historyId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of crf histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf histories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the crf history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the crf history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the crf history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the crf history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf history that was removed
	 */
	public CRFHistory removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the number of crf histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf histories
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByUuid_C_PrevAndNext(
			long historyId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf histories
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the crf histories where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByHistoryId(long historyId);

	/**
	 * Returns a range of all the crf histories where historyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param historyId the history ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByHistoryId(
		long historyId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where historyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param historyId the history ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByHistoryId(
		long historyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where historyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param historyId the history ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByHistoryId(
		long historyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByHistoryId_First(
			long historyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByHistoryId_First(
		long historyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByHistoryId_Last(
			long historyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByHistoryId_Last(
		long historyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Removes all the crf histories where historyId = &#63; from the database.
	 *
	 * @param historyId the history ID
	 */
	public void removeByHistoryId(long historyId);

	/**
	 * Returns the number of crf histories where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @return the number of matching crf histories
	 */
	public int countByHistoryId(long historyId);

	/**
	 * Returns all the crf histories where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findBySubjectId(long subjectId);

	/**
	 * Returns a range of all the crf histories where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findBySubjectId(
		long subjectId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findBySubjectId_First(
			long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchBySubjectId_First(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findBySubjectId_Last(
			long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchBySubjectId_Last(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findBySubjectId_PrevAndNext(
			long historyId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	public void removeBySubjectId(long subjectId);

	/**
	 * Returns the number of crf histories where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching crf histories
	 */
	public int countBySubjectId(long subjectId);

	/**
	 * Returns all the crf histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByStructuredDataId(
		long structuredDataId);

	/**
	 * Returns a range of all the crf histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByStructuredDataId(
		long structuredDataId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByStructuredDataId(
		long structuredDataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByStructuredDataId(
		long structuredDataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByStructuredDataId_First(
			long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByStructuredDataId_First(
		long structuredDataId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByStructuredDataId_Last(
			long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByStructuredDataId_Last(
		long structuredDataId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByStructuredDataId_PrevAndNext(
			long historyId, long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 */
	public void removeByStructuredDataId(long structuredDataId);

	/**
	 * Returns the number of crf histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching crf histories
	 */
	public int countByStructuredDataId(long structuredDataId);

	/**
	 * Returns all the crf histories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByGroupId(long groupId);

	/**
	 * Returns a range of all the crf histories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByGroupId_PrevAndNext(
			long historyId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] filterFindByGroupId_PrevAndNext(
			long historyId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of crf histories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf histories
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the crf histories where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByUserId(long userId);

	/**
	 * Returns a range of all the crf histories where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where userId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByUserId_PrevAndNext(
			long historyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of crf histories where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching crf histories
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_U(long groupId, long userId);

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_U(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByG_U_PrevAndNext(
			long historyId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_U(
		long groupId, long userId);

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_U(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] filterFindByG_U_PrevAndNext(
			long historyId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching crf histories
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	public int filterCountByG_U(long groupId, long userId);

	/**
	 * Returns all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByC_S(long crfId, long subjectId);

	/**
	 * Returns a range of all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByC_S(
		long crfId, long subjectId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByC_S(
		long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByC_S(
		long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByC_S_First(
			long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByC_S_First(
		long crfId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByC_S_Last(
			long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByC_S_Last(
		long crfId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByC_S_PrevAndNext(
			long historyId, long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	public void removeByC_S(long crfId, long subjectId);

	/**
	 * Returns the number of crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf histories
	 */
	public int countByC_S(long crfId, long subjectId);

	/**
	 * Returns all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C(long groupId, long crfId);

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C(
		long groupId, long crfId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByG_C_First(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByG_C_First(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByG_C_Last(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByG_C_Last(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByG_C_PrevAndNext(
			long historyId, long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_C(long groupId, long crfId);

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_C(
		long groupId, long crfId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] filterFindByG_C_PrevAndNext(
			long historyId, long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public void removeByG_C(long groupId, long crfId);

	/**
	 * Returns the number of crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf histories
	 */
	public int countByG_C(long groupId, long crfId);

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	public int filterCountByG_C(long groupId, long crfId);

	/**
	 * Returns all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C_S(
		long groupId, long crfId, long subjectId);

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByG_C_S_First(
			long groupId, long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByG_C_S_First(
		long groupId, long crfId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByG_C_S_Last(
			long groupId, long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByG_C_S_Last(
		long groupId, long crfId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByG_C_S_PrevAndNext(
			long historyId, long groupId, long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_C_S(
		long groupId, long crfId, long subjectId);

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end);

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] filterFindByG_C_S_PrevAndNext(
			long historyId, long groupId, long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	public void removeByG_C_S(long groupId, long crfId, long subjectId);

	/**
	 * Returns the number of crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf histories
	 */
	public int countByG_C_S(long groupId, long crfId, long subjectId);

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	public int filterCountByG_C_S(long groupId, long crfId, long subjectId);

	/**
	 * Returns all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId);

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId,
		int start, int end);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	public java.util.List<CRFHistory> findByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByG_C_S_SD_First(
			long groupId, long crfId, long subjectId, long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByG_C_S_SD_First(
		long groupId, long crfId, long subjectId, long structuredDataId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	public CRFHistory findByG_C_S_SD_Last(
			long groupId, long crfId, long subjectId, long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public CRFHistory fetchByG_C_S_SD_Last(
		long groupId, long crfId, long subjectId, long structuredDataId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] findByG_C_S_SD_PrevAndNext(
			long historyId, long groupId, long crfId, long subjectId,
			long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId);

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId,
		int start, int end);

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	public java.util.List<CRFHistory> filterFindByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory[] filterFindByG_C_S_SD_PrevAndNext(
			long historyId, long groupId, long crfId, long subjectId,
			long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
				orderByComparator)
		throws NoSuchCRFHistoryException;

	/**
	 * Removes all the crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 */
	public void removeByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId);

	/**
	 * Returns the number of crf histories where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching crf histories
	 */
	public int countByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId);

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63; and crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	public int filterCountByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId);

	/**
	 * Caches the crf history in the entity cache if it is enabled.
	 *
	 * @param crfHistory the crf history
	 */
	public void cacheResult(CRFHistory crfHistory);

	/**
	 * Caches the crf histories in the entity cache if it is enabled.
	 *
	 * @param crfHistories the crf histories
	 */
	public void cacheResult(java.util.List<CRFHistory> crfHistories);

	/**
	 * Creates a new crf history with the primary key. Does not add the crf history to the database.
	 *
	 * @param historyId the primary key for the new crf history
	 * @return the new crf history
	 */
	public CRFHistory create(long historyId);

	/**
	 * Removes the crf history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history that was removed
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory remove(long historyId) throws NoSuchCRFHistoryException;

	public CRFHistory updateImpl(CRFHistory crfHistory);

	/**
	 * Returns the crf history with the primary key or throws a <code>NoSuchCRFHistoryException</code> if it could not be found.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	public CRFHistory findByPrimaryKey(long historyId)
		throws NoSuchCRFHistoryException;

	/**
	 * Returns the crf history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history, or <code>null</code> if a crf history with the primary key could not be found
	 */
	public CRFHistory fetchByPrimaryKey(long historyId);

	/**
	 * Returns all the crf histories.
	 *
	 * @return the crf histories
	 */
	public java.util.List<CRFHistory> findAll();

	/**
	 * Returns a range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of crf histories
	 */
	public java.util.List<CRFHistory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf histories
	 */
	public java.util.List<CRFHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf histories
	 */
	public java.util.List<CRFHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the crf histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of crf histories.
	 *
	 * @return the number of crf histories
	 */
	public int countAll();

}