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

import ecrf.user.model.CRFSubject;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CRFSubject. This utility wraps
 * <code>ecrf.user.service.impl.CRFSubjectLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see CRFSubjectLocalService
 * @generated
 */
public class CRFSubjectLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.CRFSubjectLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CRFSubject addCRFSubject(CRFSubject crfSubject) {
		return getService().addCRFSubject(crfSubject);
	}

	public static CRFSubject addCRFSubject(
			long crfId, long subjectId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addCRFSubject(crfId, subjectId, sc);
	}

	public static int countCRFSubjectByCRFId(long groupId, long crfId) {
		return getService().countCRFSubjectByCRFId(groupId, crfId);
	}

	public static int countCRFSubjectByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		return getService().countCRFSubjectByG_C_UL(groupId, crfId, updateLock);
	}

	public static int countCRFSubjectByGroupId(long groupId) {
		return getService().countCRFSubjectByGroupId(groupId);
	}

	public static int countCRFSubjectBySubjectId(long groupId, long subjectId) {
		return getService().countCRFSubjectBySubjectId(groupId, subjectId);
	}

	/**
	 * Creates a new crf subject with the primary key. Does not add the crf subject to the database.
	 *
	 * @param crfSubjectId the primary key for the new crf subject
	 * @return the new crf subject
	 */
	public static CRFSubject createCRFSubject(long crfSubjectId) {
		return getService().createCRFSubject(crfSubjectId);
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
	public static CRFSubject deleteCRFSubject(CRFSubject crfSubject) {
		return getService().deleteCRFSubject(crfSubject);
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
	public static CRFSubject deleteCRFSubject(long crfSubjectId)
		throws PortalException {

		return getService().deleteCRFSubject(crfSubjectId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSubjectModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSubjectModelImpl</code>.
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

	public static CRFSubject fetchCRFSubject(long crfSubjectId) {
		return getService().fetchCRFSubject(crfSubjectId);
	}

	/**
	 * Returns the crf subject matching the UUID and group.
	 *
	 * @param uuid the crf subject's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	public static CRFSubject fetchCRFSubjectByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCRFSubjectByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the crf subject with the primary key.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject
	 * @throws PortalException if a crf subject with the primary key could not be found
	 */
	public static CRFSubject getCRFSubject(long crfSubjectId)
		throws PortalException {

		return getService().getCRFSubject(crfSubjectId);
	}

	public static CRFSubject getCRFSubjectByC_S(long crfId, long subjectId) {
		return getService().getCRFSubjectByC_S(crfId, subjectId);
	}

	public static List<CRFSubject> getCRFSubjectByCRFId(
		long groupId, long crfId) {

		return getService().getCRFSubjectByCRFId(groupId, crfId);
	}

	public static List<CRFSubject> getCRFSubjectByCRFId(
		long groupId, long crfId, int start, int end) {

		return getService().getCRFSubjectByCRFId(groupId, crfId, start, end);
	}

	public static List<CRFSubject> getCRFSubjectByCRFId(
		long groupId, long crfId, int start, int end,
		OrderByComparator comparator) {

		return getService().getCRFSubjectByCRFId(
			groupId, crfId, start, end, comparator);
	}

	public static List<CRFSubject> getCRFSubjectByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		return getService().getCRFSubjectByG_C_UL(groupId, crfId, updateLock);
	}

	public static List<CRFSubject> getCRFSubjectByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end) {

		return getService().getCRFSubjectByG_C_UL(
			groupId, crfId, updateLock, start, end);
	}

	public static List<CRFSubject> getCRFSubjectByGroupId(long groupId) {
		return getService().getCRFSubjectByGroupId(groupId);
	}

	public static List<CRFSubject> getCRFSubjectByGroupId(
		long groupId, int start, int end) {

		return getService().getCRFSubjectByGroupId(groupId, start, end);
	}

	public static List<CRFSubject> getCRFSubjectByGroupId(
		long groupId, int start, int end, OrderByComparator comparator) {

		return getService().getCRFSubjectByGroupId(
			groupId, start, end, comparator);
	}

	public static List<CRFSubject> getCRFSubjectBySubjectId(
		long groupId, long subjectId) {

		return getService().getCRFSubjectBySubjectId(groupId, subjectId);
	}

	public static List<CRFSubject> getCRFSubjectBySubjectId(
		long groupId, long subjectId, int start, int end) {

		return getService().getCRFSubjectBySubjectId(
			groupId, subjectId, start, end);
	}

	public static List<CRFSubject> getCRFSubjectBySubjectId(
		long groupId, long subjectId, int start, int end,
		OrderByComparator comparator) {

		return getService().getCRFSubjectBySubjectId(
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
	public static CRFSubject getCRFSubjectByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCRFSubjectByUuidAndGroupId(uuid, groupId);
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
	public static List<CRFSubject> getCRFSubjects(int start, int end) {
		return getService().getCRFSubjects(start, end);
	}

	/**
	 * Returns all the crf subjects matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf subjects
	 * @param companyId the primary key of the company
	 * @return the matching crf subjects, or an empty list if no matches were found
	 */
	public static List<CRFSubject> getCRFSubjectsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCRFSubjectsByUuidAndCompanyId(uuid, companyId);
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
	public static List<CRFSubject> getCRFSubjectsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return getService().getCRFSubjectsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf subjects.
	 *
	 * @return the number of crf subjects
	 */
	public static int getCRFSubjectsCount() {
		return getService().getCRFSubjectsCount();
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

	public static boolean getUpdateLockByC_S(long crfId, long subjectId) {
		return getService().getUpdateLockByC_S(crfId, subjectId);
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
	public static CRFSubject updateCRFSubject(CRFSubject crfSubject) {
		return getService().updateCRFSubject(crfSubject);
	}

	public static void updateCRFSubjects(
			long crfId, java.util.ArrayList<CRFSubject> crfSubjectList,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		getService().updateCRFSubjects(crfId, crfSubjectList, sc);
	}

	public static CRFSubjectLocalService getService() {
		return _service;
	}

	private static volatile CRFSubjectLocalService _service;

}