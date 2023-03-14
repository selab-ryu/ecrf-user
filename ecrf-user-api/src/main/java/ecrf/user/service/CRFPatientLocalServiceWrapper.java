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
 * Provides a wrapper for {@link CRFPatientLocalService}.
 *
 * @author Ryu W.C.
 * @see CRFPatientLocalService
 * @generated
 */
public class CRFPatientLocalServiceWrapper
	implements CRFPatientLocalService, ServiceWrapper<CRFPatientLocalService> {

	public CRFPatientLocalServiceWrapper(
		CRFPatientLocalService crfPatientLocalService) {

		_crfPatientLocalService = crfPatientLocalService;
	}

	/**
	 * Adds the crf patient to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFPatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfPatient the crf patient
	 * @return the crf patient that was added
	 */
	@Override
	public ecrf.user.model.CRFPatient addCRFPatient(
		ecrf.user.model.CRFPatient crfPatient) {

		return _crfPatientLocalService.addCRFPatient(crfPatient);
	}

	/**
	 * Creates a new crf patient with the primary key. Does not add the crf patient to the database.
	 *
	 * @param crfPatientId the primary key for the new crf patient
	 * @return the new crf patient
	 */
	@Override
	public ecrf.user.model.CRFPatient createCRFPatient(long crfPatientId) {
		return _crfPatientLocalService.createCRFPatient(crfPatientId);
	}

	/**
	 * Deletes the crf patient from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFPatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfPatient the crf patient
	 * @return the crf patient that was removed
	 */
	@Override
	public ecrf.user.model.CRFPatient deleteCRFPatient(
		ecrf.user.model.CRFPatient crfPatient) {

		return _crfPatientLocalService.deleteCRFPatient(crfPatient);
	}

	/**
	 * Deletes the crf patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFPatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient that was removed
	 * @throws PortalException if a crf patient with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFPatient deleteCRFPatient(long crfPatientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfPatientLocalService.deleteCRFPatient(crfPatientId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfPatientLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crfPatientLocalService.dynamicQuery();
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

		return _crfPatientLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFPatientModelImpl</code>.
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

		return _crfPatientLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFPatientModelImpl</code>.
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

		return _crfPatientLocalService.dynamicQuery(
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

		return _crfPatientLocalService.dynamicQueryCount(dynamicQuery);
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

		return _crfPatientLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.CRFPatient fetchCRFPatient(long crfPatientId) {
		return _crfPatientLocalService.fetchCRFPatient(crfPatientId);
	}

	/**
	 * Returns the crf patient matching the UUID and group.
	 *
	 * @param uuid the crf patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public ecrf.user.model.CRFPatient fetchCRFPatientByUuidAndGroupId(
		String uuid, long groupId) {

		return _crfPatientLocalService.fetchCRFPatientByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crfPatientLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the crf patient with the primary key.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient
	 * @throws PortalException if a crf patient with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFPatient getCRFPatient(long crfPatientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfPatientLocalService.getCRFPatient(crfPatientId);
	}

	/**
	 * Returns the crf patient matching the UUID and group.
	 *
	 * @param uuid the crf patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf patient
	 * @throws PortalException if a matching crf patient could not be found
	 */
	@Override
	public ecrf.user.model.CRFPatient getCRFPatientByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfPatientLocalService.getCRFPatientByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the crf patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of crf patients
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFPatient> getCRFPatients(
		int start, int end) {

		return _crfPatientLocalService.getCRFPatients(start, end);
	}

	/**
	 * Returns all the crf patients matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf patients
	 * @param companyId the primary key of the company
	 * @return the matching crf patients, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFPatient>
		getCRFPatientsByUuidAndCompanyId(String uuid, long companyId) {

		return _crfPatientLocalService.getCRFPatientsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of crf patients matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf patients
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crf patients, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFPatient>
		getCRFPatientsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.CRFPatient> orderByComparator) {

		return _crfPatientLocalService.getCRFPatientsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf patients.
	 *
	 * @return the number of crf patients
	 */
	@Override
	public int getCRFPatientsCount() {
		return _crfPatientLocalService.getCRFPatientsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _crfPatientLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crfPatientLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crfPatientLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfPatientLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the crf patient in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFPatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfPatient the crf patient
	 * @return the crf patient that was updated
	 */
	@Override
	public ecrf.user.model.CRFPatient updateCRFPatient(
		ecrf.user.model.CRFPatient crfPatient) {

		return _crfPatientLocalService.updateCRFPatient(crfPatient);
	}

	@Override
	public CRFPatientLocalService getWrappedService() {
		return _crfPatientLocalService;
	}

	@Override
	public void setWrappedService(
		CRFPatientLocalService crfPatientLocalService) {

		_crfPatientLocalService = crfPatientLocalService;
	}

	private CRFPatientLocalService _crfPatientLocalService;

}