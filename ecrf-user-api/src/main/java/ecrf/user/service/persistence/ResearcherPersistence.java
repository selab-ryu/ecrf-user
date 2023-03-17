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

import ecrf.user.exception.NoSuchResearcherException;
import ecrf.user.model.Researcher;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the researcher service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see ResearcherUtil
 * @generated
 */
@ProviderType
public interface ResearcherPersistence extends BasePersistence<Researcher> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResearcherUtil} to access the researcher persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching researchers
	 */
	public java.util.List<Researcher> findByUuid(String uuid);

	/**
	 * Returns a range of all the researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public java.util.List<Researcher> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns an ordered range of all the researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the first researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the last researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the last researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where uuid = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public Researcher[] findByUuid_PrevAndNext(
			long researcherId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Removes all the researchers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching researchers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the researcher where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResearcherException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByUUID_G(String uuid, long groupId)
		throws NoSuchResearcherException;

	/**
	 * Returns the researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the researcher where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the researcher that was removed
	 */
	public Researcher removeByUUID_G(String uuid, long groupId)
		throws NoSuchResearcherException;

	/**
	 * Returns the number of researchers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching researchers
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching researchers
	 */
	public java.util.List<Researcher> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public java.util.List<Researcher> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns an ordered range of all the researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the first researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the last researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the last researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public Researcher[] findByUuid_C_PrevAndNext(
			long researcherId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Removes all the researchers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching researchers
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching researchers
	 */
	public java.util.List<Researcher> findByGroupId(long groupId);

	/**
	 * Returns a range of all the researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public java.util.List<Researcher> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where groupId = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public Researcher[] findByGroupId_PrevAndNext(
			long researcherId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns all the researchers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching researchers that the user has permission to view
	 */
	public java.util.List<Researcher> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the researchers that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers that the user has permission to view
	 */
	public java.util.List<Researcher> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the researchers that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers that the user has permission to view
	 */
	public java.util.List<Researcher> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the researchers before and after the current researcher in the ordered set of researchers that the user has permission to view where groupId = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public Researcher[] filterFindByGroupId_PrevAndNext(
			long researcherId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Removes all the researchers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching researchers
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of researchers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching researchers that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the researchers where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching researchers
	 */
	public java.util.List<Researcher> findByStatus(int status);

	/**
	 * Returns a range of all the researchers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public java.util.List<Researcher> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the researchers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns an ordered range of all the researchers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first researcher in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the first researcher in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the last researcher in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the last researcher in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where status = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public Researcher[] findByStatus_PrevAndNext(
			long researcherId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Removes all the researchers where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of researchers where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching researchers
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the researchers where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching researchers
	 */
	public java.util.List<Researcher> findByG_S(long groupId, int status);

	/**
	 * Returns a range of all the researchers where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers
	 */
	public java.util.List<Researcher> findByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns an ordered range of all the researchers where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching researchers
	 */
	public java.util.List<Researcher> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the first researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher
	 * @throws NoSuchResearcherException if a matching researcher could not be found
	 */
	public Researcher findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns the last researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public Researcher fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the researchers before and after the current researcher in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public Researcher[] findByG_S_PrevAndNext(
			long researcherId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Returns all the researchers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching researchers that the user has permission to view
	 */
	public java.util.List<Researcher> filterFindByG_S(long groupId, int status);

	/**
	 * Returns a range of all the researchers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of matching researchers that the user has permission to view
	 */
	public java.util.List<Researcher> filterFindByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the researchers that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching researchers that the user has permission to view
	 */
	public java.util.List<Researcher> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns the researchers before and after the current researcher in the ordered set of researchers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param researcherId the primary key of the current researcher
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public Researcher[] filterFindByG_S_PrevAndNext(
			long researcherId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Researcher>
				orderByComparator)
		throws NoSuchResearcherException;

	/**
	 * Removes all the researchers where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of researchers where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching researchers
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of researchers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching researchers that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Caches the researcher in the entity cache if it is enabled.
	 *
	 * @param researcher the researcher
	 */
	public void cacheResult(Researcher researcher);

	/**
	 * Caches the researchers in the entity cache if it is enabled.
	 *
	 * @param researchers the researchers
	 */
	public void cacheResult(java.util.List<Researcher> researchers);

	/**
	 * Creates a new researcher with the primary key. Does not add the researcher to the database.
	 *
	 * @param researcherId the primary key for the new researcher
	 * @return the new researcher
	 */
	public Researcher create(long researcherId);

	/**
	 * Removes the researcher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher that was removed
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public Researcher remove(long researcherId)
		throws NoSuchResearcherException;

	public Researcher updateImpl(Researcher researcher);

	/**
	 * Returns the researcher with the primary key or throws a <code>NoSuchResearcherException</code> if it could not be found.
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher
	 * @throws NoSuchResearcherException if a researcher with the primary key could not be found
	 */
	public Researcher findByPrimaryKey(long researcherId)
		throws NoSuchResearcherException;

	/**
	 * Returns the researcher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher, or <code>null</code> if a researcher with the primary key could not be found
	 */
	public Researcher fetchByPrimaryKey(long researcherId);

	/**
	 * Returns all the researchers.
	 *
	 * @return the researchers
	 */
	public java.util.List<Researcher> findAll();

	/**
	 * Returns a range of all the researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of researchers
	 */
	public java.util.List<Researcher> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of researchers
	 */
	public java.util.List<Researcher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator);

	/**
	 * Returns an ordered range of all the researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of researchers
	 */
	public java.util.List<Researcher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Researcher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the researchers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of researchers.
	 *
	 * @return the number of researchers
	 */
	public int countAll();

}