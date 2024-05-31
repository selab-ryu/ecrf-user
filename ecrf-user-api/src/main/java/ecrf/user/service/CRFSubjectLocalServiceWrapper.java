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
 * Provides a wrapper for {@link CRFSubjectLocalService}.
 *
 * @author Ryu W.C.
 * @see CRFSubjectLocalService
 * @generated
 */
public class CRFSubjectLocalServiceWrapper
	implements CRFSubjectLocalService, ServiceWrapper<CRFSubjectLocalService> {

	public CRFSubjectLocalServiceWrapper(
		CRFSubjectLocalService crfSubjectLocalService) {

		_crfSubjectLocalService = crfSubjectLocalService;
	}

	/**
	 * Adds the crf subject to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSubject the crf subject
	 * @return the crf subject that was added
	 */
	@Override
	public ecrf.user.model.CRFSubject addCRFSubject(
		ecrf.user.model.CRFSubject crfSubject) {

		return _crfSubjectLocalService.addCRFSubject(crfSubject);
	}

	@Override
	public ecrf.user.model.CRFSubject addCRFSubject(
			long crfId, long subjectId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSubjectLocalService.addCRFSubject(crfId, subjectId, sc);
	}

	@Override
	public ecrf.user.model.CRFSubject changeUpdateLock(
		long crfId, long subjectId, boolean updateLock) {

		return _crfSubjectLocalService.changeUpdateLock(
			crfId, subjectId, updateLock);
	}

	@Override
	public int countCRFSubjectByCRFId(long groupId, long crfId) {
		return _crfSubjectLocalService.countCRFSubjectByCRFId(groupId, crfId);
	}

	@Override
	public int countCRFSubjectByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		return _crfSubjectLocalService.countCRFSubjectByG_C_UL(
			groupId, crfId, updateLock);
	}

	@Override
	public int countCRFSubjectByGroupId(long groupId) {
		return _crfSubjectLocalService.countCRFSubjectByGroupId(groupId);
	}

	@Override
	public int countCRFSubjectBySubjectId(long groupId, long subjectId) {
		return _crfSubjectLocalService.countCRFSubjectBySubjectId(
			groupId, subjectId);
	}

	/**
	 * Creates a new crf subject with the primary key. Does not add the crf subject to the database.
	 *
	 * @param crfSubjectId the primary key for the new crf subject
	 * @return the new crf subject
	 */
	@Override
	public ecrf.user.model.CRFSubject createCRFSubject(long crfSubjectId) {
		return _crfSubjectLocalService.createCRFSubject(crfSubjectId);
	}

	/**
	 * Deletes the crf subject from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSubject the crf subject
	 * @return the crf subject that was removed
	 */
	@Override
	public ecrf.user.model.CRFSubject deleteCRFSubject(
		ecrf.user.model.CRFSubject crfSubject) {

		return _crfSubjectLocalService.deleteCRFSubject(crfSubject);
	}

	/**
	 * Deletes the crf subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject that was removed
	 * @throws PortalException if a crf subject with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFSubject deleteCRFSubject(long crfSubjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSubjectLocalService.deleteCRFSubject(crfSubjectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSubjectLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crfSubjectLocalService.dynamicQuery();
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

		return _crfSubjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSubjectModelImpl</code>.
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

		return _crfSubjectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSubjectModelImpl</code>.
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

		return _crfSubjectLocalService.dynamicQuery(
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

		return _crfSubjectLocalService.dynamicQueryCount(dynamicQuery);
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

		return _crfSubjectLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.CRFSubject fetchCRFSubject(long crfSubjectId) {
		return _crfSubjectLocalService.fetchCRFSubject(crfSubjectId);
	}

	/**
	 * Returns the crf subject matching the UUID and group.
	 *
	 * @param uuid the crf subject's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public ecrf.user.model.CRFSubject fetchCRFSubjectByUuidAndGroupId(
		String uuid, long groupId) {

		return _crfSubjectLocalService.fetchCRFSubjectByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crfSubjectLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the crf subject with the primary key.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject
	 * @throws PortalException if a crf subject with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFSubject getCRFSubject(long crfSubjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSubjectLocalService.getCRFSubject(crfSubjectId);
	}

	@Override
	public ecrf.user.model.CRFSubject getCRFSubjectByC_S(
		long crfId, long subjectId) {

		return _crfSubjectLocalService.getCRFSubjectByC_S(crfId, subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectByCRFId(
		long groupId, long crfId) {

		return _crfSubjectLocalService.getCRFSubjectByCRFId(groupId, crfId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectByCRFId(
		long groupId, long crfId, int start, int end) {

		return _crfSubjectLocalService.getCRFSubjectByCRFId(
			groupId, crfId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectByCRFId(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return _crfSubjectLocalService.getCRFSubjectByCRFId(
			groupId, crfId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		return _crfSubjectLocalService.getCRFSubjectByG_C_UL(
			groupId, crfId, updateLock);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end) {

		return _crfSubjectLocalService.getCRFSubjectByG_C_UL(
			groupId, crfId, updateLock, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectByGroupId(
		long groupId) {

		return _crfSubjectLocalService.getCRFSubjectByGroupId(groupId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectByGroupId(
		long groupId, int start, int end) {

		return _crfSubjectLocalService.getCRFSubjectByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return _crfSubjectLocalService.getCRFSubjectByGroupId(
			groupId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectBySubjectId(
		long groupId, long subjectId) {

		return _crfSubjectLocalService.getCRFSubjectBySubjectId(
			groupId, subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectBySubjectId(
		long groupId, long subjectId, int start, int end) {

		return _crfSubjectLocalService.getCRFSubjectBySubjectId(
			groupId, subjectId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjectBySubjectId(
		long groupId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return _crfSubjectLocalService.getCRFSubjectBySubjectId(
			groupId, subjectId, start, end, comparator);
	}

	/**
	 * Returns the crf subject matching the UUID and group.
	 *
	 * @param uuid the crf subject's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf subject
	 * @throws PortalException if a matching crf subject could not be found
	 */
	@Override
	public ecrf.user.model.CRFSubject getCRFSubjectByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSubjectLocalService.getCRFSubjectByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the crf subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of crf subjects
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFSubject> getCRFSubjects(
		int start, int end) {

		return _crfSubjectLocalService.getCRFSubjects(start, end);
	}

	/**
	 * Returns all the crf subjects matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf subjects
	 * @param companyId the primary key of the company
	 * @return the matching crf subjects, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFSubject>
		getCRFSubjectsByUuidAndCompanyId(String uuid, long companyId) {

		return _crfSubjectLocalService.getCRFSubjectsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of crf subjects matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf subjects
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crf subjects, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFSubject>
		getCRFSubjectsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.CRFSubject> orderByComparator) {

		return _crfSubjectLocalService.getCRFSubjectsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf subjects.
	 *
	 * @return the number of crf subjects
	 */
	@Override
	public int getCRFSubjectsCount() {
		return _crfSubjectLocalService.getCRFSubjectsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _crfSubjectLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crfSubjectLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crfSubjectLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfSubjectLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean getUpdateLockByC_S(long crfId, long subjectId) {
		return _crfSubjectLocalService.getUpdateLockByC_S(crfId, subjectId);
	}

	/**
	 * Updates the crf subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSubject the crf subject
	 * @return the crf subject that was updated
	 */
	@Override
	public ecrf.user.model.CRFSubject updateCRFSubject(
		ecrf.user.model.CRFSubject crfSubject) {

		return _crfSubjectLocalService.updateCRFSubject(crfSubject);
	}

	@Override
	public void updateCRFSubjects(
			long crfId,
			java.util.ArrayList<ecrf.user.model.CRFSubject> crfSubjectList,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		_crfSubjectLocalService.updateCRFSubjects(crfId, crfSubjectList, sc);
	}

	@Override
	public CRFSubjectLocalService getWrappedService() {
		return _crfSubjectLocalService;
	}

	@Override
	public void setWrappedService(
		CRFSubjectLocalService crfSubjectLocalService) {

		_crfSubjectLocalService = crfSubjectLocalService;
	}

	private CRFSubjectLocalService _crfSubjectLocalService;

}