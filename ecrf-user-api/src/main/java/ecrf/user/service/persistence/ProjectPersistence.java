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

import ecrf.user.exception.NoSuchProjectException;
import ecrf.user.model.Project;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see ProjectUtil
 * @generated
 */
@ProviderType
public interface ProjectPersistence extends BasePersistence<Project> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectUtil} to access the project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the projects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching projects
	 */
	public java.util.List<Project> findByUuid(String uuid);

	/**
	 * Returns a range of all the projects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of matching projects
	 */
	public java.util.List<Project> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the projects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projects
	 */
	public java.util.List<Project> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns an ordered range of all the projects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching projects
	 */
	public java.util.List<Project> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	public Project findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Returns the first project in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project, or <code>null</code> if a matching project could not be found
	 */
	public Project fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns the last project in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	public Project findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Returns the last project in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project, or <code>null</code> if a matching project could not be found
	 */
	public Project fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns the projects before and after the current project in the ordered set where uuid = &#63;.
	 *
	 * @param projectId the primary key of the current project
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	public Project[] findByUuid_PrevAndNext(
			long projectId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Removes all the projects where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of projects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching projects
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the project where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	public Project findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectException;

	/**
	 * Returns the project where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project, or <code>null</code> if a matching project could not be found
	 */
	public Project fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the project where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project, or <code>null</code> if a matching project could not be found
	 */
	public Project fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the project where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project that was removed
	 */
	public Project removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectException;

	/**
	 * Returns the number of projects where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching projects
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the projects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching projects
	 */
	public java.util.List<Project> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the projects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of matching projects
	 */
	public java.util.List<Project> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the projects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projects
	 */
	public java.util.List<Project> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns an ordered range of all the projects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching projects
	 */
	public java.util.List<Project> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	public Project findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Returns the first project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project, or <code>null</code> if a matching project could not be found
	 */
	public Project fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns the last project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	public Project findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Returns the last project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project, or <code>null</code> if a matching project could not be found
	 */
	public Project fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns the projects before and after the current project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectId the primary key of the current project
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	public Project[] findByUuid_C_PrevAndNext(
			long projectId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Removes all the projects where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of projects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching projects
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the projects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching projects
	 */
	public java.util.List<Project> findByGroupId(long groupId);

	/**
	 * Returns a range of all the projects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of matching projects
	 */
	public java.util.List<Project> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the projects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projects
	 */
	public java.util.List<Project> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns an ordered range of all the projects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching projects
	 */
	public java.util.List<Project> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	public Project findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Returns the first project in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project, or <code>null</code> if a matching project could not be found
	 */
	public Project fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns the last project in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	public Project findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Returns the last project in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project, or <code>null</code> if a matching project could not be found
	 */
	public Project fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns the projects before and after the current project in the ordered set where groupId = &#63;.
	 *
	 * @param projectId the primary key of the current project
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	public Project[] findByGroupId_PrevAndNext(
			long projectId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Returns all the projects that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching projects that the user has permission to view
	 */
	public java.util.List<Project> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the projects that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of matching projects that the user has permission to view
	 */
	public java.util.List<Project> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the projects that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projects that the user has permission to view
	 */
	public java.util.List<Project> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns the projects before and after the current project in the ordered set of projects that the user has permission to view where groupId = &#63;.
	 *
	 * @param projectId the primary key of the current project
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	public Project[] filterFindByGroupId_PrevAndNext(
			long projectId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Project>
				orderByComparator)
		throws NoSuchProjectException;

	/**
	 * Removes all the projects where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of projects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching projects
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of projects that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching projects that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Caches the project in the entity cache if it is enabled.
	 *
	 * @param project the project
	 */
	public void cacheResult(Project project);

	/**
	 * Caches the projects in the entity cache if it is enabled.
	 *
	 * @param projects the projects
	 */
	public void cacheResult(java.util.List<Project> projects);

	/**
	 * Creates a new project with the primary key. Does not add the project to the database.
	 *
	 * @param projectId the primary key for the new project
	 * @return the new project
	 */
	public Project create(long projectId);

	/**
	 * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the project
	 * @return the project that was removed
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	public Project remove(long projectId) throws NoSuchProjectException;

	public Project updateImpl(Project project);

	/**
	 * Returns the project with the primary key or throws a <code>NoSuchProjectException</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project
	 * @return the project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	public Project findByPrimaryKey(long projectId)
		throws NoSuchProjectException;

	/**
	 * Returns the project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project
	 * @return the project, or <code>null</code> if a project with the primary key could not be found
	 */
	public Project fetchByPrimaryKey(long projectId);

	/**
	 * Returns all the projects.
	 *
	 * @return the projects
	 */
	public java.util.List<Project> findAll();

	/**
	 * Returns a range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of projects
	 */
	public java.util.List<Project> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of projects
	 */
	public java.util.List<Project> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator);

	/**
	 * Returns an ordered range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of projects
	 */
	public java.util.List<Project> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Project>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the projects from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of projects.
	 *
	 * @return the number of projects
	 */
	public int countAll();

}