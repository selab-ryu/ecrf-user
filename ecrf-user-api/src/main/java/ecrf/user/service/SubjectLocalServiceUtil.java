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

package ecrf.user.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import ecrf.user.model.Subject;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Subject. This utility wraps
 * <code>ecrf.user.service.impl.SubjectLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see SubjectLocalService
 * @generated
 */
public class SubjectLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.SubjectLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Subject addSubject(
			String name, int birthYear, int birthMonth, int birthDay,
			String lunarBirth, int gender, String phone, String phone2,
			String address, String serialId, int hospitalCode, long expGroupId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addSubject(
			name, birthYear, birthMonth, birthDay, lunarBirth, gender, phone,
			phone2, address, serialId, hospitalCode, expGroupId, sc);
	}

	/**
	 * Adds the subject to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subject the subject
	 * @return the subject that was added
	 */
	public static Subject addSubject(Subject subject) {
		return getService().addSubject(subject);
	}

	/**
	 * Creates a new subject with the primary key. Does not add the subject to the database.
	 *
	 * @param subjectId the primary key for the new subject
	 * @return the new subject
	 */
	public static Subject createSubject(long subjectId) {
		return getService().createSubject(subjectId);
	}

	public static void deleteAllSubject(long groupId) throws PortalException {
		getService().deleteAllSubject(groupId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject that was removed
	 * @throws PortalException if a subject with the primary key could not be found
	 */
	public static Subject deleteSubject(long subjectId) throws PortalException {
		return getService().deleteSubject(subjectId);
	}

	/**
	 * Deletes the subject from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subject the subject
	 * @return the subject that was removed
	 */
	public static Subject deleteSubject(Subject subject) {
		return getService().deleteSubject(subject);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Subject fetchSubject(long subjectId) {
		return getService().fetchSubject(subjectId);
	}

	/**
	 * Returns the subject matching the UUID and group.
	 *
	 * @param uuid the subject's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	public static Subject fetchSubjectByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSubjectByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Subject> getAllSubject() {
		return getService().getAllSubject();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the subject with the primary key.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject
	 * @throws PortalException if a subject with the primary key could not be found
	 */
	public static Subject getSubject(long subjectId) throws PortalException {
		return getService().getSubject(subjectId);
	}

	public static List<Subject> getSubjectByGroupId(long groupId) {
		return getService().getSubjectByGroupId(groupId);
	}

	public static List<Subject> getSubjectByIds(
		long groupId, long[] subjectIds) {

		return getService().getSubjectByIds(groupId, subjectIds);
	}

	public static Subject getSubjectBySerialId(long groupId, String serialId) {
		return getService().getSubjectBySerialId(groupId, serialId);
	}

	/**
	 * Returns the subject matching the UUID and group.
	 *
	 * @param uuid the subject's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subject
	 * @throws PortalException if a matching subject could not be found
	 */
	public static Subject getSubjectByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getSubjectByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.SubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of subjects
	 */
	public static List<Subject> getSubjects(int start, int end) {
		return getService().getSubjects(start, end);
	}

	/**
	 * Returns all the subjects matching the UUID and company.
	 *
	 * @param uuid the UUID of the subjects
	 * @param companyId the primary key of the company
	 * @return the matching subjects, or an empty list if no matches were found
	 */
	public static List<Subject> getSubjectsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSubjectsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of subjects matching the UUID and company.
	 *
	 * @param uuid the UUID of the subjects
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching subjects, or an empty list if no matches were found
	 */
	public static List<Subject> getSubjectsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Subject> orderByComparator) {

		return getService().getSubjectsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of subjects.
	 *
	 * @return the number of subjects
	 */
	public static int getSubjectsCount() {
		return getService().getSubjectsCount();
	}

	public static boolean isDuplicatedSerialId(long groupId, String serialId) {
		return getService().isDuplicatedSerialId(groupId, serialId);
	}

	public static Subject updateSubject(
			long subjectId, String name, int birthYear, int birthMonth,
			int birthDay, String lunarBirth, int gender, String phone,
			String phone2, String address, String serialId, int hospitalCode,
			long expGroupId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateSubject(
			subjectId, name, birthYear, birthMonth, birthDay, lunarBirth,
			gender, phone, phone2, address, serialId, hospitalCode, expGroupId,
			sc);
	}

	/**
	 * Updates the subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subject the subject
	 * @return the subject that was updated
	 */
	public static Subject updateSubject(Subject subject) {
		return getService().updateSubject(subject);
	}

	public static SubjectLocalService getService() {
		return _service;
	}

	private static volatile SubjectLocalService _service;

}