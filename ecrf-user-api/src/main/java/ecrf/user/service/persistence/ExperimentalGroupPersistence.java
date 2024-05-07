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

import ecrf.user.exception.NoSuchExperimentalGroupException;
import ecrf.user.model.ExperimentalGroup;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the experimental group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see ExperimentalGroupUtil
 * @generated
 */
@ProviderType
public interface ExperimentalGroupPersistence
	extends BasePersistence<ExperimentalGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExperimentalGroupUtil} to access the experimental group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the experimental groups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByUuid(String uuid);

	/**
	 * Returns a range of all the experimental groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public ExperimentalGroup[] findByUuid_PrevAndNext(
			long experimentalGroupId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Removes all the experimental groups where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of experimental groups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching experimental groups
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the experimental group where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByUUID_G(String uuid, long groupId)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the experimental group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the experimental group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the experimental group where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the experimental group that was removed
	 */
	public ExperimentalGroup removeByUUID_G(String uuid, long groupId)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the number of experimental groups where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching experimental groups
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public ExperimentalGroup[] findByUuid_C_PrevAndNext(
			long experimentalGroupId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Removes all the experimental groups where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching experimental groups
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the experimental group where experimentalGroupId = &#63; or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByExperimentalGroupId(long experimentalGroupId)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the experimental group where experimentalGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByExperimentalGroupId(
		long experimentalGroupId);

	/**
	 * Returns the experimental group where experimentalGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByExperimentalGroupId(
		long experimentalGroupId, boolean useFinderCache);

	/**
	 * Removes the experimental group where experimentalGroupId = &#63; from the database.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the experimental group that was removed
	 */
	public ExperimentalGroup removeByExperimentalGroupId(
			long experimentalGroupId)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the number of experimental groups where experimentalGroupId = &#63;.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the number of matching experimental groups
	 */
	public int countByExperimentalGroupId(long experimentalGroupId);

	/**
	 * Returns all the experimental groups where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByName(String name);

	/**
	 * Returns a range of all the experimental groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the experimental groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experimental groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the first experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns the last experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the last experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where name = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public ExperimentalGroup[] findByName_PrevAndNext(
			long experimentalGroupId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Removes all the experimental groups where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of experimental groups where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching experimental groups
	 */
	public int countByName(String name);

	/**
	 * Returns all the experimental groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByGroupId(long groupId);

	/**
	 * Returns a range of all the experimental groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the experimental groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experimental groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	public java.util.List<ExperimentalGroup> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the first experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns the last experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the last experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public ExperimentalGroup[] findByGroupId_PrevAndNext(
			long experimentalGroupId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
				orderByComparator)
		throws NoSuchExperimentalGroupException;

	/**
	 * Removes all the experimental groups where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of experimental groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching experimental groups
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the experimental group where groupId = &#63; and name = &#63; or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	public ExperimentalGroup findByG_N(long groupId, String name)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the experimental group where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByG_N(long groupId, String name);

	/**
	 * Returns the experimental group where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	public ExperimentalGroup fetchByG_N(
		long groupId, String name, boolean useFinderCache);

	/**
	 * Removes the experimental group where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the experimental group that was removed
	 */
	public ExperimentalGroup removeByG_N(long groupId, String name)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the number of experimental groups where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching experimental groups
	 */
	public int countByG_N(long groupId, String name);

	/**
	 * Caches the experimental group in the entity cache if it is enabled.
	 *
	 * @param experimentalGroup the experimental group
	 */
	public void cacheResult(ExperimentalGroup experimentalGroup);

	/**
	 * Caches the experimental groups in the entity cache if it is enabled.
	 *
	 * @param experimentalGroups the experimental groups
	 */
	public void cacheResult(
		java.util.List<ExperimentalGroup> experimentalGroups);

	/**
	 * Creates a new experimental group with the primary key. Does not add the experimental group to the database.
	 *
	 * @param experimentalGroupId the primary key for the new experimental group
	 * @return the new experimental group
	 */
	public ExperimentalGroup create(long experimentalGroupId);

	/**
	 * Removes the experimental group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group that was removed
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public ExperimentalGroup remove(long experimentalGroupId)
		throws NoSuchExperimentalGroupException;

	public ExperimentalGroup updateImpl(ExperimentalGroup experimentalGroup);

	/**
	 * Returns the experimental group with the primary key or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	public ExperimentalGroup findByPrimaryKey(long experimentalGroupId)
		throws NoSuchExperimentalGroupException;

	/**
	 * Returns the experimental group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group, or <code>null</code> if a experimental group with the primary key could not be found
	 */
	public ExperimentalGroup fetchByPrimaryKey(long experimentalGroupId);

	/**
	 * Returns all the experimental groups.
	 *
	 * @return the experimental groups
	 */
	public java.util.List<ExperimentalGroup> findAll();

	/**
	 * Returns a range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of experimental groups
	 */
	public java.util.List<ExperimentalGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experimental groups
	 */
	public java.util.List<ExperimentalGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of experimental groups
	 */
	public java.util.List<ExperimentalGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperimentalGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the experimental groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of experimental groups.
	 *
	 * @return the number of experimental groups
	 */
	public int countAll();

}