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

import ecrf.user.exception.NoSuchLinkCRFException;
import ecrf.user.model.LinkCRF;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the link crf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see LinkCRFUtil
 * @generated
 */
@ProviderType
public interface LinkCRFPersistence extends BasePersistence<LinkCRF> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinkCRFUtil} to access the link crf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the link crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching link crfs
	 */
	public java.util.List<LinkCRF> findByUuid(String uuid);

	/**
	 * Returns a range of all the link crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where uuid = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] findByUuid_PrevAndNext(
			long linkId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Removes all the link crfs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of link crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching link crfs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the link crf where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByUUID_G(String uuid, long groupId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the link crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the link crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the link crf where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the link crf that was removed
	 */
	public LinkCRF removeByUUID_G(String uuid, long groupId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the number of link crfs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching link crfs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching link crfs
	 */
	public java.util.List<LinkCRF> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] findByUuid_C_PrevAndNext(
			long linkId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Removes all the link crfs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching link crfs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the link crf where linkId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param linkId the link ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByLinkId(long linkId) throws NoSuchLinkCRFException;

	/**
	 * Returns the link crf where linkId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param linkId the link ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByLinkId(long linkId);

	/**
	 * Returns the link crf where linkId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linkId the link ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByLinkId(long linkId, boolean useFinderCache);

	/**
	 * Removes the link crf where linkId = &#63; from the database.
	 *
	 * @param linkId the link ID
	 * @return the link crf that was removed
	 */
	public LinkCRF removeByLinkId(long linkId) throws NoSuchLinkCRFException;

	/**
	 * Returns the number of link crfs where linkId = &#63;.
	 *
	 * @param linkId the link ID
	 * @return the number of matching link crfs
	 */
	public int countByLinkId(long linkId);

	/**
	 * Returns the link crf where structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByStructuredDataId(long structuredDataId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the link crf where structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByStructuredDataId(long structuredDataId);

	/**
	 * Returns the link crf where structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByStructuredDataId(
		long structuredDataId, boolean useFinderCache);

	/**
	 * Removes the link crf where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	public LinkCRF removeByStructuredDataId(long structuredDataId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the number of link crfs where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	public int countByStructuredDataId(long structuredDataId);

	/**
	 * Returns all the link crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching link crfs
	 */
	public java.util.List<LinkCRF> findByGroupId(long groupId);

	/**
	 * Returns a range of all the link crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] findByGroupId_PrevAndNext(
			long linkId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns all the link crfs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the link crfs that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set of link crfs that the user has permission to view where groupId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] filterFindByGroupId_PrevAndNext(
			long linkId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Removes all the link crfs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of link crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching link crfs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of link crfs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching link crfs that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the link crfs where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching link crfs
	 */
	public java.util.List<LinkCRF> findBySubjectId(long subjectId);

	/**
	 * Returns a range of all the link crfs where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public java.util.List<LinkCRF> findBySubjectId(
		long subjectId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the link crfs where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findBySubjectId_First(
			long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the first link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchBySubjectId_First(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the last link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findBySubjectId_Last(
			long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the last link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchBySubjectId_Last(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] findBySubjectId_PrevAndNext(
			long linkId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Removes all the link crfs where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	public void removeBySubjectId(long subjectId);

	/**
	 * Returns the number of link crfs where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	public int countBySubjectId(long subjectId);

	/**
	 * Returns all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_S(long groupId, long subjectId);

	/**
	 * Returns a range of all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_S(
		long groupId, long subjectId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_S(
		long groupId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_S(
		long groupId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByG_S_First(
			long groupId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_S_First(
		long groupId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByG_S_Last(
			long groupId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_S_Last(
		long groupId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] findByG_S_PrevAndNext(
			long linkId, long groupId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns all the link crfs that the user has permission to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByG_S(
		long groupId, long subjectId);

	/**
	 * Returns a range of all the link crfs that the user has permission to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByG_S(
		long groupId, long subjectId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs that the user has permissions to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByG_S(
		long groupId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set of link crfs that the user has permission to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] filterFindByG_S_PrevAndNext(
			long linkId, long groupId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Removes all the link crfs where groupId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 */
	public void removeByG_S(long groupId, long subjectId);

	/**
	 * Returns the number of link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	public int countByG_S(long groupId, long subjectId);

	/**
	 * Returns the number of link crfs that the user has permission to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, long subjectId);

	/**
	 * Returns all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_C(long groupId, long crfId);

	/**
	 * Returns a range of all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_C(
		long groupId, long crfId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByG_C_First(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_C_First(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByG_C_Last(
			long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_C_Last(
		long groupId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] findByG_C_PrevAndNext(
			long linkId, long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns all the link crfs that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByG_C(long groupId, long crfId);

	/**
	 * Returns a range of all the link crfs that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByG_C(
		long groupId, long crfId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs that the user has permissions to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set of link crfs that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] filterFindByG_C_PrevAndNext(
			long linkId, long groupId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Removes all the link crfs where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	public void removeByG_C(long groupId, long crfId);

	/**
	 * Returns the number of link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching link crfs
	 */
	public int countByG_C(long groupId, long crfId);

	/**
	 * Returns the number of link crfs that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching link crfs that the user has permission to view
	 */
	public int filterCountByG_C(long groupId, long crfId);

	/**
	 * Returns all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId);

	/**
	 * Returns a range of all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByG_S_C_First(
			long groupId, long subjectId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_S_C_First(
		long groupId, long subjectId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByG_S_C_Last(
			long groupId, long subjectId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_S_C_Last(
		long groupId, long subjectId, long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] findByG_S_C_PrevAndNext(
			long linkId, long groupId, long subjectId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns all the link crfs that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByG_S_C(
		long groupId, long subjectId, long crfId);

	/**
	 * Returns a range of all the link crfs that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs that the user has permissions to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs that the user has permission to view
	 */
	public java.util.List<LinkCRF> filterFindByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set of link crfs that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] filterFindByG_S_C_PrevAndNext(
			long linkId, long groupId, long subjectId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Removes all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 */
	public void removeByG_S_C(long groupId, long subjectId, long crfId);

	/**
	 * Returns the number of link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the number of matching link crfs
	 */
	public int countByG_S_C(long groupId, long subjectId, long crfId);

	/**
	 * Returns the number of link crfs that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the number of matching link crfs that the user has permission to view
	 */
	public int filterCountByG_S_C(long groupId, long subjectId, long crfId);

	/**
	 * Returns the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByG_S_SD(long groupId, long crfId, long structuredDataId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_S_SD(
		long groupId, long crfId, long structuredDataId);

	/**
	 * Returns the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_S_SD(
		long groupId, long crfId, long structuredDataId,
		boolean useFinderCache);

	/**
	 * Removes the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	public LinkCRF removeByG_S_SD(
			long groupId, long crfId, long structuredDataId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the number of link crfs where groupId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	public int countByG_S_SD(long groupId, long crfId, long structuredDataId);

	/**
	 * Returns the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByG_S_C_SD(
			long groupId, long subjectId, long crfId, long structuredDataId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId);

	/**
	 * Returns the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		boolean useFinderCache);

	/**
	 * Removes the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	public LinkCRF removeByG_S_C_SD(
			long groupId, long subjectId, long crfId, long structuredDataId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the number of link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	public int countByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId);

	/**
	 * Returns all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching link crfs
	 */
	public java.util.List<LinkCRF> findByC_S(long crfId, long subjectId);

	/**
	 * Returns a range of all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByC_S(
		long crfId, long subjectId, int start, int end);

	/**
	 * Returns an ordered range of all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByC_S(
		long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	public java.util.List<LinkCRF> findByC_S(
		long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByC_S_First(
			long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the first link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByC_S_First(
		long crfId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the last link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByC_S_Last(
			long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the last link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByC_S_Last(
		long crfId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF[] findByC_S_PrevAndNext(
			long linkId, long crfId, long subjectId,
			com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
				orderByComparator)
		throws NoSuchLinkCRFException;

	/**
	 * Removes all the link crfs where crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	public void removeByC_S(long crfId, long subjectId);

	/**
	 * Returns the number of link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	public int countByC_S(long crfId, long subjectId);

	/**
	 * Returns the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	public LinkCRF findByC_S_SD(
			long crfId, long subjectId, long structuredDataId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByC_S_SD(
		long crfId, long subjectId, long structuredDataId);

	/**
	 * Returns the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	public LinkCRF fetchByC_S_SD(
		long crfId, long subjectId, long structuredDataId,
		boolean useFinderCache);

	/**
	 * Removes the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	public LinkCRF removeByC_S_SD(
			long crfId, long subjectId, long structuredDataId)
		throws NoSuchLinkCRFException;

	/**
	 * Returns the number of link crfs where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	public int countByC_S_SD(long crfId, long subjectId, long structuredDataId);

	/**
	 * Caches the link crf in the entity cache if it is enabled.
	 *
	 * @param linkCRF the link crf
	 */
	public void cacheResult(LinkCRF linkCRF);

	/**
	 * Caches the link crfs in the entity cache if it is enabled.
	 *
	 * @param linkCRFs the link crfs
	 */
	public void cacheResult(java.util.List<LinkCRF> linkCRFs);

	/**
	 * Creates a new link crf with the primary key. Does not add the link crf to the database.
	 *
	 * @param linkId the primary key for the new link crf
	 * @return the new link crf
	 */
	public LinkCRF create(long linkId);

	/**
	 * Removes the link crf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf that was removed
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF remove(long linkId) throws NoSuchLinkCRFException;

	public LinkCRF updateImpl(LinkCRF linkCRF);

	/**
	 * Returns the link crf with the primary key or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	public LinkCRF findByPrimaryKey(long linkId) throws NoSuchLinkCRFException;

	/**
	 * Returns the link crf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf, or <code>null</code> if a link crf with the primary key could not be found
	 */
	public LinkCRF fetchByPrimaryKey(long linkId);

	/**
	 * Returns all the link crfs.
	 *
	 * @return the link crfs
	 */
	public java.util.List<LinkCRF> findAll();

	/**
	 * Returns a range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of link crfs
	 */
	public java.util.List<LinkCRF> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of link crfs
	 */
	public java.util.List<LinkCRF> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of link crfs
	 */
	public java.util.List<LinkCRF> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LinkCRF>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the link crfs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of link crfs.
	 *
	 * @return the number of link crfs
	 */
	public int countAll();

}