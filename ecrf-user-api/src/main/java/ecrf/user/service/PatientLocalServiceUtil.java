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

import ecrf.user.model.Patient;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Patient. This utility wraps
 * <code>ecrf.user.service.impl.PatientLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PatientLocalService
 * @generated
 */
public class PatientLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.PatientLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Patient addPatient(Patient patient) {
		return getService().addPatient(patient);
	}

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param patientId the primary key for the new patient
	 * @return the new patient
	 */
	public static Patient createPatient(long patientId) {
		return getService().createPatient(patientId);
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
	public static Patient deletePatient(long patientId) throws PortalException {
		return getService().deletePatient(patientId);
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
	public static Patient deletePatient(Patient patient) {
		return getService().deletePatient(patient);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.PatientModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.PatientModelImpl</code>.
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

	public static Patient fetchPatient(long patientId) {
		return getService().fetchPatient(patientId);
	}

	/**
	 * Returns the patient matching the UUID and group.
	 *
	 * @param uuid the patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchPatientByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPatientByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the patient with the primary key.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient
	 * @throws PortalException if a patient with the primary key could not be found
	 */
	public static Patient getPatient(long patientId) throws PortalException {
		return getService().getPatient(patientId);
	}

	/**
	 * Returns the patient matching the UUID and group.
	 *
	 * @param uuid the patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient
	 * @throws PortalException if a matching patient could not be found
	 */
	public static Patient getPatientByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getPatientByUuidAndGroupId(uuid, groupId);
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
	public static List<Patient> getPatients(int start, int end) {
		return getService().getPatients(start, end);
	}

	/**
	 * Returns all the patients matching the UUID and company.
	 *
	 * @param uuid the UUID of the patients
	 * @param companyId the primary key of the company
	 * @return the matching patients, or an empty list if no matches were found
	 */
	public static List<Patient> getPatientsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPatientsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Patient> getPatientsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getService().getPatientsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
	 */
	public static int getPatientsCount() {
		return getService().getPatientsCount();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static Patient updatePatient(Patient patient) {
		return getService().updatePatient(patient);
	}

	public static PatientLocalService getService() {
		return _service;
	}

	private static volatile PatientLocalService _service;

}