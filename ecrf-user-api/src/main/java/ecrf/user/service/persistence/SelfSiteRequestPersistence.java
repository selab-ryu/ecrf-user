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

import ecrf.user.exception.NoSuchSelfSiteRequestException;
import ecrf.user.model.SelfSiteRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the self site request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see SelfSiteRequestUtil
 * @generated
 */
@ProviderType
public interface SelfSiteRequestPersistence
	extends BasePersistence<SelfSiteRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SelfSiteRequestUtil} to access the self site request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the self site requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the self site requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the self site requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the self site requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first self site request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public SelfSiteRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
				orderByComparator)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Returns the first self site request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public SelfSiteRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns the last self site request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public SelfSiteRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
				orderByComparator)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Returns the last self site request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public SelfSiteRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns the self site requests before and after the current self site request in the ordered set where uuid = &#63;.
	 *
	 * @param selfSiteRequestId the primary key of the current self site request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next self site request
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public SelfSiteRequest[] findByUuid_PrevAndNext(
			long selfSiteRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
				orderByComparator)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Removes all the self site requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of self site requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching self site requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the self site request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSelfSiteRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public SelfSiteRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Returns the self site request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public SelfSiteRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the self site request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public SelfSiteRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the self site request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the self site request that was removed
	 */
	public SelfSiteRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Returns the number of self site requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching self site requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public SelfSiteRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
				orderByComparator)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Returns the first self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public SelfSiteRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns the last self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public SelfSiteRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
				orderByComparator)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Returns the last self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public SelfSiteRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns the self site requests before and after the current self site request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param selfSiteRequestId the primary key of the current self site request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next self site request
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public SelfSiteRequest[] findByUuid_C_PrevAndNext(
			long selfSiteRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
				orderByComparator)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Removes all the self site requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of self site requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching self site requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the self site requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByGroupId(long groupId);

	/**
	 * Returns a range of all the self site requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the self site requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the self site requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching self site requests
	 */
	public java.util.List<SelfSiteRequest> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first self site request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public SelfSiteRequest findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
				orderByComparator)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Returns the first self site request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public SelfSiteRequest fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns the last self site request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request
	 * @throws NoSuchSelfSiteRequestException if a matching self site request could not be found
	 */
	public SelfSiteRequest findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
				orderByComparator)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Returns the last self site request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	public SelfSiteRequest fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns the self site requests before and after the current self site request in the ordered set where groupId = &#63;.
	 *
	 * @param selfSiteRequestId the primary key of the current self site request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next self site request
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public SelfSiteRequest[] findByGroupId_PrevAndNext(
			long selfSiteRequestId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
				orderByComparator)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Removes all the self site requests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of self site requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching self site requests
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the self site request in the entity cache if it is enabled.
	 *
	 * @param selfSiteRequest the self site request
	 */
	public void cacheResult(SelfSiteRequest selfSiteRequest);

	/**
	 * Caches the self site requests in the entity cache if it is enabled.
	 *
	 * @param selfSiteRequests the self site requests
	 */
	public void cacheResult(java.util.List<SelfSiteRequest> selfSiteRequests);

	/**
	 * Creates a new self site request with the primary key. Does not add the self site request to the database.
	 *
	 * @param selfSiteRequestId the primary key for the new self site request
	 * @return the new self site request
	 */
	public SelfSiteRequest create(long selfSiteRequestId);

	/**
	 * Removes the self site request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request that was removed
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public SelfSiteRequest remove(long selfSiteRequestId)
		throws NoSuchSelfSiteRequestException;

	public SelfSiteRequest updateImpl(SelfSiteRequest selfSiteRequest);

	/**
	 * Returns the self site request with the primary key or throws a <code>NoSuchSelfSiteRequestException</code> if it could not be found.
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request
	 * @throws NoSuchSelfSiteRequestException if a self site request with the primary key could not be found
	 */
	public SelfSiteRequest findByPrimaryKey(long selfSiteRequestId)
		throws NoSuchSelfSiteRequestException;

	/**
	 * Returns the self site request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request, or <code>null</code> if a self site request with the primary key could not be found
	 */
	public SelfSiteRequest fetchByPrimaryKey(long selfSiteRequestId);

	/**
	 * Returns all the self site requests.
	 *
	 * @return the self site requests
	 */
	public java.util.List<SelfSiteRequest> findAll();

	/**
	 * Returns a range of all the self site requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of self site requests
	 */
	public java.util.List<SelfSiteRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the self site requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of self site requests
	 */
	public java.util.List<SelfSiteRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the self site requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of self site requests
	 */
	public java.util.List<SelfSiteRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelfSiteRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the self site requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of self site requests.
	 *
	 * @return the number of self site requests
	 */
	public int countAll();

}