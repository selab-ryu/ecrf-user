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

import ecrf.user.model.CRFPatient;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CRFPatient. This utility wraps
 * <code>ecrf.user.service.impl.CRFPatientLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see CRFPatientLocalService
 * @generated
 */
public class CRFPatientLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.CRFPatientLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CRFPatient addCRFPatient(CRFPatient crfPatient) {
		return getService().addCRFPatient(crfPatient);
	}

	/**
	 * Creates a new crf patient with the primary key. Does not add the crf patient to the database.
	 *
	 * @param crfPatientId the primary key for the new crf patient
	 * @return the new crf patient
	 */
	public static CRFPatient createCRFPatient(long crfPatientId) {
		return getService().createCRFPatient(crfPatientId);
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
	public static CRFPatient deleteCRFPatient(CRFPatient crfPatient) {
		return getService().deleteCRFPatient(crfPatient);
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
	public static CRFPatient deleteCRFPatient(long crfPatientId)
		throws PortalException {

		return getService().deleteCRFPatient(crfPatientId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFPatientModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFPatientModelImpl</code>.
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

	public static CRFPatient fetchCRFPatient(long crfPatientId) {
		return getService().fetchCRFPatient(crfPatientId);
	}

	/**
	 * Returns the crf patient matching the UUID and group.
	 *
	 * @param uuid the crf patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	public static CRFPatient fetchCRFPatientByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCRFPatientByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the crf patient with the primary key.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient
	 * @throws PortalException if a crf patient with the primary key could not be found
	 */
	public static CRFPatient getCRFPatient(long crfPatientId)
		throws PortalException {

		return getService().getCRFPatient(crfPatientId);
	}

	/**
	 * Returns the crf patient matching the UUID and group.
	 *
	 * @param uuid the crf patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf patient
	 * @throws PortalException if a matching crf patient could not be found
	 */
	public static CRFPatient getCRFPatientByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCRFPatientByUuidAndGroupId(uuid, groupId);
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
	public static List<CRFPatient> getCRFPatients(int start, int end) {
		return getService().getCRFPatients(start, end);
	}

	/**
	 * Returns all the crf patients matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf patients
	 * @param companyId the primary key of the company
	 * @return the matching crf patients, or an empty list if no matches were found
	 */
	public static List<CRFPatient> getCRFPatientsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCRFPatientsByUuidAndCompanyId(uuid, companyId);
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
	public static List<CRFPatient> getCRFPatientsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return getService().getCRFPatientsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf patients.
	 *
	 * @return the number of crf patients
	 */
	public static int getCRFPatientsCount() {
		return getService().getCRFPatientsCount();
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
	 * Updates the crf patient in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFPatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfPatient the crf patient
	 * @return the crf patient that was updated
	 */
	public static CRFPatient updateCRFPatient(CRFPatient crfPatient) {
		return getService().updateCRFPatient(crfPatient);
	}

	public static CRFPatientLocalService getService() {
		return _service;
	}

	private static volatile CRFPatientLocalService _service;

}