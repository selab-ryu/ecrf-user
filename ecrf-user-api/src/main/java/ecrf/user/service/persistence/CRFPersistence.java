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

import ecrf.user.exception.NoSuchCRFException;
import ecrf.user.model.CRF;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the crf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFUtil
 * @generated
 */
@ProviderType
public interface CRFPersistence extends BasePersistence<CRF> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CRFUtil} to access the crf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crfs
	 */
	public java.util.List<CRF> findByUuid(String uuid);

	/**
	 * Returns a range of all the crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of matching crfs
	 */
	public java.util.List<CRF> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crfs
	 */
	public java.util.List<CRF> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crfs
	 */
	public java.util.List<CRF> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRF> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public CRF findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Returns the first crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns the last crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public CRF findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Returns the last crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns the crfs before and after the current crf in the ordered set where uuid = &#63;.
	 *
	 * @param crfId the primary key of the current crf
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public CRF[] findByUuid_PrevAndNext(
			long crfId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Removes all the crfs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crfs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the crf where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public CRF findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFException;

	/**
	 * Returns the crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByUUID_G(String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the crf where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf that was removed
	 */
	public CRF removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFException;

	/**
	 * Returns the number of crfs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crfs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crfs
	 */
	public java.util.List<CRF> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of matching crfs
	 */
	public java.util.List<CRF> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crfs
	 */
	public java.util.List<CRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crfs
	 */
	public java.util.List<CRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRF> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public CRF findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Returns the first crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns the last crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public CRF findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Returns the last crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns the crfs before and after the current crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param crfId the primary key of the current crf
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public CRF[] findByUuid_C_PrevAndNext(
			long crfId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Removes all the crfs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crfs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crfs
	 */
	public java.util.List<CRF> findByGroupId(long groupId);

	/**
	 * Returns a range of all the crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of matching crfs
	 */
	public java.util.List<CRF> findByGroupId(long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crfs
	 */
	public java.util.List<CRF> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crfs
	 */
	public java.util.List<CRF> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRF> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public CRF findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Returns the first crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns the last crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public CRF findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Returns the last crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns the crfs before and after the current crf in the ordered set where groupId = &#63;.
	 *
	 * @param crfId the primary key of the current crf
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public CRF[] findByGroupId_PrevAndNext(
			long crfId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Returns all the crfs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crfs that the user has permission to view
	 */
	public java.util.List<CRF> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the crfs that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of matching crfs that the user has permission to view
	 */
	public java.util.List<CRF> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the crfs that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crfs that the user has permission to view
	 */
	public java.util.List<CRF> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns the crfs before and after the current crf in the ordered set of crfs that the user has permission to view where groupId = &#63;.
	 *
	 * @param crfId the primary key of the current crf
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public CRF[] filterFindByGroupId_PrevAndNext(
			long crfId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CRF>
				orderByComparator)
		throws NoSuchCRFException;

	/**
	 * Removes all the crfs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crfs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of crfs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crfs that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns the crf where datatypeId = &#63; or throws a <code>NoSuchCRFException</code> if it could not be found.
	 *
	 * @param datatypeId the datatype ID
	 * @return the matching crf
	 * @throws NoSuchCRFException if a matching crf could not be found
	 */
	public CRF findByDataTypeId(long datatypeId) throws NoSuchCRFException;

	/**
	 * Returns the crf where datatypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param datatypeId the datatype ID
	 * @return the matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByDataTypeId(long datatypeId);

	/**
	 * Returns the crf where datatypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param datatypeId the datatype ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf, or <code>null</code> if a matching crf could not be found
	 */
	public CRF fetchByDataTypeId(long datatypeId, boolean useFinderCache);

	/**
	 * Removes the crf where datatypeId = &#63; from the database.
	 *
	 * @param datatypeId the datatype ID
	 * @return the crf that was removed
	 */
	public CRF removeByDataTypeId(long datatypeId) throws NoSuchCRFException;

	/**
	 * Returns the number of crfs where datatypeId = &#63;.
	 *
	 * @param datatypeId the datatype ID
	 * @return the number of matching crfs
	 */
	public int countByDataTypeId(long datatypeId);

	/**
	 * Caches the crf in the entity cache if it is enabled.
	 *
	 * @param crf the crf
	 */
	public void cacheResult(CRF crf);

	/**
	 * Caches the crfs in the entity cache if it is enabled.
	 *
	 * @param crfs the crfs
	 */
	public void cacheResult(java.util.List<CRF> crfs);

	/**
	 * Creates a new crf with the primary key. Does not add the crf to the database.
	 *
	 * @param crfId the primary key for the new crf
	 * @return the new crf
	 */
	public CRF create(long crfId);

	/**
	 * Removes the crf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf that was removed
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public CRF remove(long crfId) throws NoSuchCRFException;

	public CRF updateImpl(CRF crf);

	/**
	 * Returns the crf with the primary key or throws a <code>NoSuchCRFException</code> if it could not be found.
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf
	 * @throws NoSuchCRFException if a crf with the primary key could not be found
	 */
	public CRF findByPrimaryKey(long crfId) throws NoSuchCRFException;

	/**
	 * Returns the crf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfId the primary key of the crf
	 * @return the crf, or <code>null</code> if a crf with the primary key could not be found
	 */
	public CRF fetchByPrimaryKey(long crfId);

	/**
	 * Returns all the crfs.
	 *
	 * @return the crfs
	 */
	public java.util.List<CRF> findAll();

	/**
	 * Returns a range of all the crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @return the range of crfs
	 */
	public java.util.List<CRF> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crfs
	 */
	public java.util.List<CRF> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRF>
			orderByComparator);

	/**
	 * Returns an ordered range of all the crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crfs
	 * @param end the upper bound of the range of crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crfs
	 */
	public java.util.List<CRF> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CRF> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the crfs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of crfs.
	 *
	 * @return the number of crfs
	 */
	public int countAll();

}