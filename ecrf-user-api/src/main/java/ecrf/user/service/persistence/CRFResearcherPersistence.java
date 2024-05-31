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

import ecrf.user.exception.NoSuchCRFResearcherException;
import ecrf.user.model.CRFResearcher;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the crf researcher service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFResearcherUtil
 * @generated
 */
@ProviderType
public interface CRFResearcherPersistence
	extends BasePersistence<CRFResearcher> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CRFResearcherUtil} to access the crf researcher persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the crf researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByUuid(String uuid);

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
	public java.util.List<CRFResearcher> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CRFResearcher> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

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
	public java.util.List<CRFResearcher> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher[] findByUuid_PrevAndNext(
			long crfResearcherId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Removes all the crf researchers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of crf researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf researchers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the crf researcher where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFResearcherException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the crf researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the crf researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the crf researcher where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf researcher that was removed
	 */
	public CRFResearcher removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the number of crf researchers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf researchers
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CRFResearcher> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CRFResearcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

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
	public java.util.List<CRFResearcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

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
	public CRFResearcher[] findByUuid_C_PrevAndNext(
			long crfResearcherId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Removes all the crf researchers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf researchers
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the crf researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByGroupId(long groupId);

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
	public java.util.List<CRFResearcher> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<CRFResearcher> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

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
	public java.util.List<CRFResearcher> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher[] findByGroupId_PrevAndNext(
			long crfResearcherId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns all the crf researchers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf researchers that the user has permission to view
	 */
	public java.util.List<CRFResearcher> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the crf researchers that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers that the user has permission to view
	 */
	public java.util.List<CRFResearcher> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the crf researchers that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers that the user has permission to view
	 */
	public java.util.List<CRFResearcher> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set of crf researchers that the user has permission to view where groupId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher[] filterFindByGroupId_PrevAndNext(
			long crfResearcherId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Removes all the crf researchers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of crf researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf researchers
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of crf researchers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf researchers that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the crf researchers where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByCRFId(long crfId);

	/**
	 * Returns a range of all the crf researchers where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByCRFId(
		long crfId, int start, int end);

	/**
	 * Returns an ordered range of all the crf researchers where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByCRFId(
		long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf researchers where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByCRFId(
		long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByCRFId_First(
			long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the first crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByCRFId_First(
		long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the last crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByCRFId_Last(
			long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the last crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByCRFId_Last(
		long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher[] findByCRFId_PrevAndNext(
			long crfResearcherId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Removes all the crf researchers where crfId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 */
	public void removeByCRFId(long crfId);

	/**
	 * Returns the number of crf researchers where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the number of matching crf researchers
	 */
	public int countByCRFId(long crfId);

	/**
	 * Returns all the crf researchers where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @return the matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByResearcherId(long researcherId);

	/**
	 * Returns a range of all the crf researchers where researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByResearcherId(
		long researcherId, int start, int end);

	/**
	 * Returns an ordered range of all the crf researchers where researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByResearcherId(
		long researcherId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crf researchers where researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByResearcherId(
		long researcherId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByResearcherId_First(
			long researcherId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the first crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByResearcherId_First(
		long researcherId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the last crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByResearcherId_Last(
			long researcherId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the last crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByResearcherId_Last(
		long researcherId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher[] findByResearcherId_PrevAndNext(
			long crfResearcherId, long researcherId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Removes all the crf researchers where researcherId = &#63; from the database.
	 *
	 * @param researcherId the researcher ID
	 */
	public void removeByResearcherId(long researcherId);

	/**
	 * Returns the number of crf researchers where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @return the number of matching crf researchers
	 */
	public int countByResearcherId(long researcherId);

	/**
	 * Returns all the crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByG_C(long groupId, long crfId);

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
	public java.util.List<CRFResearcher> findByG_C(
		long groupId, long crfId, int start, int end);

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
	public java.util.List<CRFResearcher> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

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
	public java.util.List<CRFResearcher> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByG_C_First(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByG_C_First(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByG_C_Last(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByG_C_Last(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

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
	public CRFResearcher[] findByG_C_PrevAndNext(
			long crfResearcherId, long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns all the crf researchers that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf researchers that the user has permission to view
	 */
	public java.util.List<CRFResearcher> filterFindByG_C(
		long groupId, long crfId);

	/**
	 * Returns a range of all the crf researchers that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers that the user has permission to view
	 */
	public java.util.List<CRFResearcher> filterFindByG_C(
		long groupId, long crfId, int start, int end);

	/**
	 * Returns an ordered range of all the crf researchers that the user has permissions to view where groupId = &#63; and crfId = &#63;.
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
	 * @return the ordered range of matching crf researchers that the user has permission to view
	 */
	public java.util.List<CRFResearcher> filterFindByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set of crf researchers that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher[] filterFindByG_C_PrevAndNext(
			long crfResearcherId, long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Removes all the crf researchers where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public void removeByG_C(long groupId, long crfId);

	/**
	 * Returns the number of crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf researchers
	 */
	public int countByG_C(long groupId, long crfId);

	/**
	 * Returns the number of crf researchers that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf researchers that the user has permission to view
	 */
	public int filterCountByG_C(long groupId, long crfId);

	/**
	 * Returns all the crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @return the matching crf researchers
	 */
	public java.util.List<CRFResearcher> findByG_R(
		long groupId, long researcherId);

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
	public java.util.List<CRFResearcher> findByG_R(
		long groupId, long researcherId, int start, int end);

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
	public java.util.List<CRFResearcher> findByG_R(
		long groupId, long researcherId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

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
	public java.util.List<CRFResearcher> findByG_R(
		long groupId, long researcherId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByG_R_First(
			long groupId, long researcherId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByG_R_First(
		long groupId, long researcherId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByG_R_Last(
			long groupId, long researcherId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByG_R_Last(
		long groupId, long researcherId,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

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
	public CRFResearcher[] findByG_R_PrevAndNext(
			long crfResearcherId, long groupId, long researcherId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns all the crf researchers that the user has permission to view where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @return the matching crf researchers that the user has permission to view
	 */
	public java.util.List<CRFResearcher> filterFindByG_R(
		long groupId, long researcherId);

	/**
	 * Returns a range of all the crf researchers that the user has permission to view where groupId = &#63; and researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers that the user has permission to view
	 */
	public java.util.List<CRFResearcher> filterFindByG_R(
		long groupId, long researcherId, int start, int end);

	/**
	 * Returns an ordered range of all the crf researchers that the user has permissions to view where groupId = &#63; and researcherId = &#63;.
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
	 * @return the ordered range of matching crf researchers that the user has permission to view
	 */
	public java.util.List<CRFResearcher> filterFindByG_R(
		long groupId, long researcherId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set of crf researchers that the user has permission to view where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher[] filterFindByG_R_PrevAndNext(
			long crfResearcherId, long groupId, long researcherId,
			com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
				orderByComparator)
		throws NoSuchCRFResearcherException;

	/**
	 * Removes all the crf researchers where groupId = &#63; and researcherId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 */
	public void removeByG_R(long groupId, long researcherId);

	/**
	 * Returns the number of crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @return the number of matching crf researchers
	 */
	public int countByG_R(long groupId, long researcherId);

	/**
	 * Returns the number of crf researchers that the user has permission to view where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @return the number of matching crf researchers that the user has permission to view
	 */
	public int filterCountByG_R(long groupId, long researcherId);

	/**
	 * Returns the crf researcher where crfId = &#63; and researcherId = &#63; or throws a <code>NoSuchCRFResearcherException</code> if it could not be found.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @return the matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	public CRFResearcher findByC_R(long crfId, long researcherId)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the crf researcher where crfId = &#63; and researcherId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByC_R(long crfId, long researcherId);

	/**
	 * Returns the crf researcher where crfId = &#63; and researcherId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	public CRFResearcher fetchByC_R(
		long crfId, long researcherId, boolean useFinderCache);

	/**
	 * Removes the crf researcher where crfId = &#63; and researcherId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @return the crf researcher that was removed
	 */
	public CRFResearcher removeByC_R(long crfId, long researcherId)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the number of crf researchers where crfId = &#63; and researcherId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @return the number of matching crf researchers
	 */
	public int countByC_R(long crfId, long researcherId);

	/**
	 * Caches the crf researcher in the entity cache if it is enabled.
	 *
	 * @param crfResearcher the crf researcher
	 */
	public void cacheResult(CRFResearcher crfResearcher);

	/**
	 * Caches the crf researchers in the entity cache if it is enabled.
	 *
	 * @param crfResearchers the crf researchers
	 */
	public void cacheResult(java.util.List<CRFResearcher> crfResearchers);

	/**
	 * Creates a new crf researcher with the primary key. Does not add the crf researcher to the database.
	 *
	 * @param crfResearcherId the primary key for the new crf researcher
	 * @return the new crf researcher
	 */
	public CRFResearcher create(long crfResearcherId);

	/**
	 * Removes the crf researcher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher that was removed
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher remove(long crfResearcherId)
		throws NoSuchCRFResearcherException;

	public CRFResearcher updateImpl(CRFResearcher crfResearcher);

	/**
	 * Returns the crf researcher with the primary key or throws a <code>NoSuchCRFResearcherException</code> if it could not be found.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher findByPrimaryKey(long crfResearcherId)
		throws NoSuchCRFResearcherException;

	/**
	 * Returns the crf researcher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher, or <code>null</code> if a crf researcher with the primary key could not be found
	 */
	public CRFResearcher fetchByPrimaryKey(long crfResearcherId);

	/**
	 * Returns all the crf researchers.
	 *
	 * @return the crf researchers
	 */
	public java.util.List<CRFResearcher> findAll();

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
	public java.util.List<CRFResearcher> findAll(int start, int end);

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
	public java.util.List<CRFResearcher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator);

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
	public java.util.List<CRFResearcher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRFResearcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the crf researchers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of crf researchers.
	 *
	 * @return the number of crf researchers
	 */
	public int countAll();

}