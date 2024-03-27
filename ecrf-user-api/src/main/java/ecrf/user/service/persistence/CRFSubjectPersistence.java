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

import ecrf.user.exception.NoSuchCRFSubjectException;
import ecrf.user.model.CRFSubject;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the crf subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFSubjectUtil
 * @generated
 */
@ProviderType
public interface CRFSubjectPersistence extends BasePersistence<CRFSubject> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CRFSubjectUtil} to access the crf subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the crf subjects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf subjects
	 */
	public java.util.List<CRFSubject> findByUuid(String uuid);

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
	public java.util.List<CRFSubject> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CRFSubject> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public java.util.List<CRFSubject> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public CRFSubject[] findByUuid_PrevAndNext(
			long crfSubjectId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Removes all the crf subjects where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of crf subjects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf subjects
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the crf subject where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFSubjectException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the crf subject where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the crf subject where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the crf subject where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf subject that was removed
	 */
	public CRFSubject removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the number of crf subjects where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf subjects
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf subjects
	 */
	public java.util.List<CRFSubject> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<CRFSubject> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CRFSubject> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public java.util.List<CRFSubject> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public CRFSubject[] findByUuid_C_PrevAndNext(
			long crfSubjectId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Removes all the crf subjects where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf subjects
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the crf subjects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf subjects
	 */
	public java.util.List<CRFSubject> findByGroupId(long groupId);

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
	public java.util.List<CRFSubject> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<CRFSubject> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public java.util.List<CRFSubject> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public CRFSubject[] findByGroupId_PrevAndNext(
			long crfSubjectId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Removes all the crf subjects where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of crf subjects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf subjects
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf subjects
	 */
	public java.util.List<CRFSubject> findByG_C(long groupId, long crfId);

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
	public java.util.List<CRFSubject> findByG_C(
		long groupId, long crfId, int start, int end);

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
	public java.util.List<CRFSubject> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public java.util.List<CRFSubject> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByG_C_First(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByG_C_First(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByG_C_Last(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByG_C_Last(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public CRFSubject[] findByG_C_PrevAndNext(
			long crfSubjectId, long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Removes all the crf subjects where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public void removeByG_C(long groupId, long crfId);

	/**
	 * Returns the number of crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf subjects
	 */
	public int countByG_C(long groupId, long crfId);

	/**
	 * Returns all the crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the matching crf subjects
	 */
	public java.util.List<CRFSubject> findByG_S(long groupId, long subjectId);

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
	public java.util.List<CRFSubject> findByG_S(
		long groupId, long subjectId, int start, int end);

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
	public java.util.List<CRFSubject> findByG_S(
		long groupId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public java.util.List<CRFSubject> findByG_S(
		long groupId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByG_S_First(
			long groupId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByG_S_First(
		long groupId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByG_S_Last(
			long groupId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByG_S_Last(
		long groupId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public CRFSubject[] findByG_S_PrevAndNext(
			long crfSubjectId, long groupId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Removes all the crf subjects where groupId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 */
	public void removeByG_S(long groupId, long subjectId);

	/**
	 * Returns the number of crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf subjects
	 */
	public int countByG_S(long groupId, long subjectId);

	/**
	 * Returns all the crf subjects where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @return the matching crf subjects
	 */
	public java.util.List<CRFSubject> findByG_C_EXP(
		long groupId, long crfId, String experimentalGroup);

	/**
	 * Returns a range of all the crf subjects where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	public java.util.List<CRFSubject> findByG_C_EXP(
		long groupId, long crfId, String experimentalGroup, int start, int end);

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	public java.util.List<CRFSubject> findByG_C_EXP(
		long groupId, long crfId, String experimentalGroup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	public java.util.List<CRFSubject> findByG_C_EXP(
		long groupId, long crfId, String experimentalGroup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByG_C_EXP_First(
			long groupId, long crfId, String experimentalGroup,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByG_C_EXP_First(
		long groupId, long crfId, String experimentalGroup,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	public CRFSubject findByG_C_EXP_Last(
			long groupId, long crfId, String experimentalGroup,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByG_C_EXP_Last(
		long groupId, long crfId, String experimentalGroup,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public CRFSubject[] findByG_C_EXP_PrevAndNext(
			long crfSubjectId, long groupId, long crfId,
			String experimentalGroup,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Removes all the crf subjects where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 */
	public void removeByG_C_EXP(
		long groupId, long crfId, String experimentalGroup);

	/**
	 * Returns the number of crf subjects where groupId = &#63; and crfId = &#63; and experimentalGroup = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param experimentalGroup the experimental group
	 * @return the number of matching crf subjects
	 */
	public int countByG_C_EXP(
		long groupId, long crfId, String experimentalGroup);

	/**
	 * Returns all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @return the matching crf subjects
	 */
	public java.util.List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock);

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
	public java.util.List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end);

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
	public java.util.List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public java.util.List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator,
		boolean useFinderCache);

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
	public CRFSubject findByG_C_UL_First(
			long groupId, long crfId, boolean updateLock,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByG_C_UL_First(
		long groupId, long crfId, boolean updateLock,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public CRFSubject findByG_C_UL_Last(
			long groupId, long crfId, boolean updateLock,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public CRFSubject fetchByG_C_UL_Last(
		long groupId, long crfId, boolean updateLock,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public CRFSubject[] findByG_C_UL_PrevAndNext(
			long crfSubjectId, long groupId, long crfId, boolean updateLock,
			com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
				orderByComparator)
		throws NoSuchCRFSubjectException;

	/**
	 * Removes all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 */
	public void removeByG_C_UL(long groupId, long crfId, boolean updateLock);

	/**
	 * Returns the number of crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @return the number of matching crf subjects
	 */
	public int countByG_C_UL(long groupId, long crfId, boolean updateLock);

	/**
	 * Caches the crf subject in the entity cache if it is enabled.
	 *
	 * @param crfSubject the crf subject
	 */
	public void cacheResult(CRFSubject crfSubject);

	/**
	 * Caches the crf subjects in the entity cache if it is enabled.
	 *
	 * @param crfSubjects the crf subjects
	 */
	public void cacheResult(java.util.List<CRFSubject> crfSubjects);

	/**
	 * Creates a new crf subject with the primary key. Does not add the crf subject to the database.
	 *
	 * @param crfSubjectId the primary key for the new crf subject
	 * @return the new crf subject
	 */
	public CRFSubject create(long crfSubjectId);

	/**
	 * Removes the crf subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject that was removed
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public CRFSubject remove(long crfSubjectId)
		throws NoSuchCRFSubjectException;

	public CRFSubject updateImpl(CRFSubject crfSubject);

	/**
	 * Returns the crf subject with the primary key or throws a <code>NoSuchCRFSubjectException</code> if it could not be found.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	public CRFSubject findByPrimaryKey(long crfSubjectId)
		throws NoSuchCRFSubjectException;

	/**
	 * Returns the crf subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject, or <code>null</code> if a crf subject with the primary key could not be found
	 */
	public CRFSubject fetchByPrimaryKey(long crfSubjectId);

	/**
	 * Returns all the crf subjects.
	 *
	 * @return the crf subjects
	 */
	public java.util.List<CRFSubject> findAll();

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
	public java.util.List<CRFSubject> findAll(int start, int end);

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
	public java.util.List<CRFSubject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator);

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
	public java.util.List<CRFSubject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the crf subjects from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of crf subjects.
	 *
	 * @return the number of crf subjects
	 */
	public int countAll();

}