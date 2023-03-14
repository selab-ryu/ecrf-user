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
 * Provides a wrapper for {@link PatientLocalService}.
 *
 * @author Ryu W.C.
 * @see PatientLocalService
 * @generated
 */
public class PatientLocalServiceWrapper
	implements PatientLocalService, ServiceWrapper<PatientLocalService> {

	public PatientLocalServiceWrapper(PatientLocalService patientLocalService) {
		_patientLocalService = patientLocalService;
	}

	/**
	 * Adds the patient to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patient the patient
	 * @return the patient that was added
	 */
	@Override
	public ecrf.user.model.Patient addPatient(ecrf.user.model.Patient patient) {
		return _patientLocalService.addPatient(patient);
	}

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param patientId the primary key for the new patient
	 * @return the new patient
	 */
	@Override
	public ecrf.user.model.Patient createPatient(long patientId) {
		return _patientLocalService.createPatient(patientId);
	}

	/**
	 * Deletes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient that was removed
	 * @throws PortalException if a patient with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.Patient deletePatient(long patientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.deletePatient(patientId);
	}

	/**
	 * Deletes the patient from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patient the patient
	 * @return the patient that was removed
	 */
	@Override
	public ecrf.user.model.Patient deletePatient(
		ecrf.user.model.Patient patient) {

		return _patientLocalService.deletePatient(patient);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _patientLocalService.dynamicQuery();
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

		return _patientLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.PatientModelImpl</code>.
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

		return _patientLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.PatientModelImpl</code>.
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

		return _patientLocalService.dynamicQuery(
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

		return _patientLocalService.dynamicQueryCount(dynamicQuery);
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

		return _patientLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.Patient fetchPatient(long patientId) {
		return _patientLocalService.fetchPatient(patientId);
	}

	/**
	 * Returns the patient matching the UUID and group.
	 *
	 * @param uuid the patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public ecrf.user.model.Patient fetchPatientByUuidAndGroupId(
		String uuid, long groupId) {

		return _patientLocalService.fetchPatientByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _patientLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _patientLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _patientLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _patientLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the patient with the primary key.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient
	 * @throws PortalException if a patient with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.Patient getPatient(long patientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.getPatient(patientId);
	}

	/**
	 * Returns the patient matching the UUID and group.
	 *
	 * @param uuid the patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient
	 * @throws PortalException if a matching patient could not be found
	 */
	@Override
	public ecrf.user.model.Patient getPatientByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.getPatientByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.PatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of patients
	 */
	@Override
	public java.util.List<ecrf.user.model.Patient> getPatients(
		int start, int end) {

		return _patientLocalService.getPatients(start, end);
	}

	/**
	 * Returns all the patients matching the UUID and company.
	 *
	 * @param uuid the UUID of the patients
	 * @param companyId the primary key of the company
	 * @return the matching patients, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.Patient>
		getPatientsByUuidAndCompanyId(String uuid, long companyId) {

		return _patientLocalService.getPatientsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of patients matching the UUID and company.
	 *
	 * @param uuid the UUID of the patients
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching patients, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.Patient>
		getPatientsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.Patient> orderByComparator) {

		return _patientLocalService.getPatientsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
	 */
	@Override
	public int getPatientsCount() {
		return _patientLocalService.getPatientsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the patient in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patient the patient
	 * @return the patient that was updated
	 */
	@Override
	public ecrf.user.model.Patient updatePatient(
		ecrf.user.model.Patient patient) {

		return _patientLocalService.updatePatient(patient);
	}

	@Override
	public PatientLocalService getWrappedService() {
		return _patientLocalService;
	}

	@Override
	public void setWrappedService(PatientLocalService patientLocalService) {
		_patientLocalService = patientLocalService;
	}

	private PatientLocalService _patientLocalService;

}