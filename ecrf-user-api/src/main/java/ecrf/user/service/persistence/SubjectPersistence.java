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

import ecrf.user.exception.NoSuchSubjectException;
import ecrf.user.model.Subject;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @see SubjectUtil
 * @generated
 */
@ProviderType
public interface SubjectPersistence extends BasePersistence<Subject> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubjectUtil} to access the subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the subjects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching subjects
	 */
	public java.util.List<Subject> findByUuid(String uuid);

	/**
	 * Returns a range of all the subjects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of matching subjects
	 */
	public java.util.List<Subject> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the subjects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subjects
	 */
	public java.util.List<Subject> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subjects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subjects
	 */
	public java.util.List<Subject> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Returns the first subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns the last subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Returns the last subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns the subjects before and after the current subject in the ordered set where uuid = &#63;.
	 *
	 * @param subjectId the primary key of the current subject
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subject
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	public Subject[] findByUuid_PrevAndNext(
			long subjectId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Removes all the subjects where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of subjects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching subjects
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the subject where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSubjectException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findByUUID_G(String uuid, long groupId)
		throws NoSuchSubjectException;

	/**
	 * Returns the subject where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the subject where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the subject where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the subject that was removed
	 */
	public Subject removeByUUID_G(String uuid, long groupId)
		throws NoSuchSubjectException;

	/**
	 * Returns the number of subjects where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching subjects
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching subjects
	 */
	public java.util.List<Subject> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of matching subjects
	 */
	public java.util.List<Subject> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subjects
	 */
	public java.util.List<Subject> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subjects
	 */
	public java.util.List<Subject> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Returns the first subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns the last subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Returns the last subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns the subjects before and after the current subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param subjectId the primary key of the current subject
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subject
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	public Subject[] findByUuid_C_PrevAndNext(
			long subjectId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Removes all the subjects where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching subjects
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the subject where subjectId = &#63; or throws a <code>NoSuchSubjectException</code> if it could not be found.
	 *
	 * @param subjectId the subject ID
	 * @return the matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findBySubjectId(long subjectId)
		throws NoSuchSubjectException;

	/**
	 * Returns the subject where subjectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchBySubjectId(long subjectId);

	/**
	 * Returns the subject where subjectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchBySubjectId(long subjectId, boolean useFinderCache);

	/**
	 * Removes the subject where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 * @return the subject that was removed
	 */
	public Subject removeBySubjectId(long subjectId)
		throws NoSuchSubjectException;

	/**
	 * Returns the number of subjects where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching subjects
	 */
	public int countBySubjectId(long subjectId);

	/**
	 * Returns the subject where serialId = &#63; or throws a <code>NoSuchSubjectException</code> if it could not be found.
	 *
	 * @param serialId the serial ID
	 * @return the matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findBySerialId(String serialId)
		throws NoSuchSubjectException;

	/**
	 * Returns the subject where serialId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serialId the serial ID
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchBySerialId(String serialId);

	/**
	 * Returns the subject where serialId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serialId the serial ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchBySerialId(String serialId, boolean useFinderCache);

	/**
	 * Removes the subject where serialId = &#63; from the database.
	 *
	 * @param serialId the serial ID
	 * @return the subject that was removed
	 */
	public Subject removeBySerialId(String serialId)
		throws NoSuchSubjectException;

	/**
	 * Returns the number of subjects where serialId = &#63;.
	 *
	 * @param serialId the serial ID
	 * @return the number of matching subjects
	 */
	public int countBySerialId(String serialId);

	/**
	 * Returns all the subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching subjects
	 */
	public java.util.List<Subject> findBySubjectName(String name);

	/**
	 * Returns a range of all the subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of matching subjects
	 */
	public java.util.List<Subject> findBySubjectName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subjects
	 */
	public java.util.List<Subject> findBySubjectName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subjects
	 */
	public java.util.List<Subject> findBySubjectName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findBySubjectName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Returns the first subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchBySubjectName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns the last subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findBySubjectName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Returns the last subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchBySubjectName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns the subjects before and after the current subject in the ordered set where name = &#63;.
	 *
	 * @param subjectId the primary key of the current subject
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subject
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	public Subject[] findBySubjectName_PrevAndNext(
			long subjectId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Removes all the subjects where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeBySubjectName(String name);

	/**
	 * Returns the number of subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching subjects
	 */
	public int countBySubjectName(String name);

	/**
	 * Returns all the subjects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching subjects
	 */
	public java.util.List<Subject> findByGroupId(long groupId);

	/**
	 * Returns a range of all the subjects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of matching subjects
	 */
	public java.util.List<Subject> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the subjects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subjects
	 */
	public java.util.List<Subject> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subjects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subjects
	 */
	public java.util.List<Subject> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Returns the first subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns the last subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	public Subject findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Returns the last subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public Subject fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns the subjects before and after the current subject in the ordered set where groupId = &#63;.
	 *
	 * @param subjectId the primary key of the current subject
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subject
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	public Subject[] findByGroupId_PrevAndNext(
			long subjectId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Subject>
				orderByComparator)
		throws NoSuchSubjectException;

	/**
	 * Removes all the subjects where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of subjects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching subjects
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the subject in the entity cache if it is enabled.
	 *
	 * @param subject the subject
	 */
	public void cacheResult(Subject subject);

	/**
	 * Caches the subjects in the entity cache if it is enabled.
	 *
	 * @param subjects the subjects
	 */
	public void cacheResult(java.util.List<Subject> subjects);

	/**
	 * Creates a new subject with the primary key. Does not add the subject to the database.
	 *
	 * @param subjectId the primary key for the new subject
	 * @return the new subject
	 */
	public Subject create(long subjectId);

	/**
	 * Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject that was removed
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	public Subject remove(long subjectId) throws NoSuchSubjectException;

	public Subject updateImpl(Subject subject);

	/**
	 * Returns the subject with the primary key or throws a <code>NoSuchSubjectException</code> if it could not be found.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	public Subject findByPrimaryKey(long subjectId)
		throws NoSuchSubjectException;

	/**
	 * Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject, or <code>null</code> if a subject with the primary key could not be found
	 */
	public Subject fetchByPrimaryKey(long subjectId);

	/**
	 * Returns all the subjects.
	 *
	 * @return the subjects
	 */
	public java.util.List<Subject> findAll();

	/**
	 * Returns a range of all the subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of subjects
	 */
	public java.util.List<Subject> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subjects
	 */
	public java.util.List<Subject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subjects
	 */
	public java.util.List<Subject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the subjects from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of subjects.
	 *
	 * @return the number of subjects
	 */
	public int countAll();

}