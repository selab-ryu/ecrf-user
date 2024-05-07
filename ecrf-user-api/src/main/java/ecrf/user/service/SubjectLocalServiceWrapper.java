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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubjectLocalService}.
 *
 * @author Ryu W.C.
 * @see SubjectLocalService
 * @generated
 */
public class SubjectLocalServiceWrapper
	implements ServiceWrapper<SubjectLocalService>, SubjectLocalService {

	public SubjectLocalServiceWrapper(SubjectLocalService subjectLocalService) {
		_subjectLocalService = subjectLocalService;
	}

	@Override
	public ecrf.user.model.Subject addSubject(
			String name, int birthYear, int birthMonth, int birthDay,
			int gender, String phone, String phone2, String address,
			String serialId, int hospitalCode, long expGroupId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectLocalService.addSubject(
			name, birthYear, birthMonth, birthDay, gender, phone, phone2,
			address, serialId, hospitalCode, expGroupId, sc);
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
	@Override
	public ecrf.user.model.Subject addSubject(ecrf.user.model.Subject subject) {
		return _subjectLocalService.addSubject(subject);
	}

	/**
	 * Creates a new subject with the primary key. Does not add the subject to the database.
	 *
	 * @param subjectId the primary key for the new subject
	 * @return the new subject
	 */
	@Override
	public ecrf.user.model.Subject createSubject(long subjectId) {
		return _subjectLocalService.createSubject(subjectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public ecrf.user.model.Subject deleteSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectLocalService.deleteSubject(subjectId);
	}

	@Override
	public ecrf.user.model.Subject deleteSubject(
			long subjectId, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectLocalService.deleteSubject(subjectId, sc);
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
	@Override
	public ecrf.user.model.Subject deleteSubject(
		ecrf.user.model.Subject subject) {

		return _subjectLocalService.deleteSubject(subject);
	}

	@Override
	public ecrf.user.model.Subject deleteSubject(
		ecrf.user.model.Subject subject,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _subjectLocalService.deleteSubject(subject, sc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subjectLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _subjectLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _subjectLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _subjectLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _subjectLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _subjectLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.Subject fetchSubject(long subjectId) {
		return _subjectLocalService.fetchSubject(subjectId);
	}

	/**
	 * Returns the subject matching the UUID and group.
	 *
	 * @param uuid the subject's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	@Override
	public ecrf.user.model.Subject fetchSubjectByUuidAndGroupId(
		String uuid, long groupId) {

		return _subjectLocalService.fetchSubjectByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _subjectLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<ecrf.user.model.Subject> getAllSubject() {
		return _subjectLocalService.getAllSubject();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _subjectLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _subjectLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subjectLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the subject with the primary key.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject
	 * @throws PortalException if a subject with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.Subject getSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectLocalService.getSubject(subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.Subject> getSubjectByGroupId(
		long groupId) {

		return _subjectLocalService.getSubjectByGroupId(groupId);
	}

	@Override
	public java.util.List<ecrf.user.model.Subject> getSubjectByIds(
		long groupId, long[] subjectIds) {

		return _subjectLocalService.getSubjectByIds(groupId, subjectIds);
	}

	@Override
	public ecrf.user.model.Subject getSubjectBySerialId(String serialId) {
		return _subjectLocalService.getSubjectBySerialId(serialId);
	}

	/**
	 * Returns the subject matching the UUID and group.
	 *
	 * @param uuid the subject's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subject
	 * @throws PortalException if a matching subject could not be found
	 */
	@Override
	public ecrf.user.model.Subject getSubjectByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectLocalService.getSubjectByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<ecrf.user.model.Subject> getSubjects(
		int start, int end) {

		return _subjectLocalService.getSubjects(start, end);
	}

	/**
	 * Returns all the subjects matching the UUID and company.
	 *
	 * @param uuid the UUID of the subjects
	 * @param companyId the primary key of the company
	 * @return the matching subjects, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.Subject>
		getSubjectsByUuidAndCompanyId(String uuid, long companyId) {

		return _subjectLocalService.getSubjectsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<ecrf.user.model.Subject>
		getSubjectsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.Subject> orderByComparator) {

		return _subjectLocalService.getSubjectsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of subjects.
	 *
	 * @return the number of subjects
	 */
	@Override
	public int getSubjectsCount() {
		return _subjectLocalService.getSubjectsCount();
	}

	@Override
	public ecrf.user.model.Subject updateSubject(
			long subjectId, String name, int birthYear, int birthMonth,
			int birthDay, int gender, String phone, String phone2,
			String address, String serialId, int hospitalCode, long expGroupId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectLocalService.updateSubject(
			subjectId, name, birthYear, birthMonth, birthDay, gender, phone,
			phone2, address, serialId, hospitalCode, expGroupId, sc);
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
	@Override
	public ecrf.user.model.Subject updateSubject(
		ecrf.user.model.Subject subject) {

		return _subjectLocalService.updateSubject(subject);
	}

	@Override
	public SubjectLocalService getWrappedService() {
		return _subjectLocalService;
	}

	@Override
	public void setWrappedService(SubjectLocalService subjectLocalService) {
		_subjectLocalService = subjectLocalService;
	}

	private SubjectLocalService _subjectLocalService;

}