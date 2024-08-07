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

import ecrf.user.model.CRFHistory;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CRFHistory. This utility wraps
 * <code>ecrf.user.service.impl.CRFHistoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see CRFHistoryLocalService
 * @generated
 */
public class CRFHistoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.CRFHistoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the crf history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfHistory the crf history
	 * @return the crf history that was added
	 */
	public static CRFHistory addCRFHistory(CRFHistory crfHistory) {
		return getService().addCRFHistory(crfHistory);
	}

	public static CRFHistory addCRFHistory(
			String subjectName, long subjectId, String serialId,
			long structuredDataId, long crfId, String previousJSON,
			String currentJSON, int actionType, String historyVersion,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addCRFHistory(
			subjectName, subjectId, serialId, structuredDataId, crfId,
			previousJSON, currentJSON, actionType, historyVersion, sc);
	}

	public static int countAllCRFHistory() {
		return getService().countAllCRFHistory();
	}

	public static int countCRFHistoryByG_C_S(
		long groupId, long crfId, long subjectId) {

		return getService().countCRFHistoryByG_C_S(groupId, crfId, subjectId);
	}

	public static int countCRFHistoryByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId) {

		return getService().countCRFHistoryByG_C_S_SD(
			groupId, crfId, subjectId, structuredDataId);
	}

	public static int countCRFHistoryByGroupId(long groupId) {
		return getService().countCRFHistoryByGroupId(groupId);
	}

	public static int countCRFHistoryByHistoryId(long historyId) {
		return getService().countCRFHistoryByHistoryId(historyId);
	}

	public static int countCRFHistoryBySubjectId(long subjectId) {
		return getService().countCRFHistoryBySubjectId(subjectId);
	}

	/**
	 * Creates a new crf history with the primary key. Does not add the crf history to the database.
	 *
	 * @param historyId the primary key for the new crf history
	 * @return the new crf history
	 */
	public static CRFHistory createCRFHistory(long historyId) {
		return getService().createCRFHistory(historyId);
	}

	/**
	 * Deletes the crf history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfHistory the crf history
	 * @return the crf history that was removed
	 */
	public static CRFHistory deleteCRFHistory(CRFHistory crfHistory) {
		return getService().deleteCRFHistory(crfHistory);
	}

	/**
	 * Deletes the crf history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history that was removed
	 * @throws PortalException if a crf history with the primary key could not be found
	 */
	public static CRFHistory deleteCRFHistory(long historyId)
		throws PortalException {

		return getService().deleteCRFHistory(historyId);
	}

	public static void deleteCRFHistorys(long[] historyIds)
		throws PortalException {

		getService().deleteCRFHistorys(historyIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFHistoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFHistoryModelImpl</code>.
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

	public static CRFHistory fetchCRFHistory(long historyId) {
		return getService().fetchCRFHistory(historyId);
	}

	/**
	 * Returns the crf history matching the UUID and group.
	 *
	 * @param uuid the crf history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	public static CRFHistory fetchCRFHistoryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCRFHistoryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<CRFHistory> getAllCRFHistory() {
		return getService().getAllCRFHistory();
	}

	public static List<CRFHistory> getAllCRFHistory(int start, int end) {
		return getService().getAllCRFHistory(start, end);
	}

	public static List<CRFHistory> getAllCRFHistory(
		int start, int end, OrderByComparator<CRFHistory> comparator) {

		return getService().getAllCRFHistory(start, end, comparator);
	}

	/**
	 * Returns a range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of crf histories
	 */
	public static List<CRFHistory> getCRFHistories(int start, int end) {
		return getService().getCRFHistories(start, end);
	}

	/**
	 * Returns all the crf histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf histories
	 * @param companyId the primary key of the company
	 * @return the matching crf histories, or an empty list if no matches were found
	 */
	public static List<CRFHistory> getCRFHistoriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCRFHistoriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of crf histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf histories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crf histories, or an empty list if no matches were found
	 */
	public static List<CRFHistory> getCRFHistoriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return getService().getCRFHistoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf histories.
	 *
	 * @return the number of crf histories
	 */
	public static int getCRFHistoriesCount() {
		return getService().getCRFHistoriesCount();
	}

	/**
	 * Returns the crf history with the primary key.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history
	 * @throws PortalException if a crf history with the primary key could not be found
	 */
	public static CRFHistory getCRFHistory(long historyId)
		throws PortalException {

		return getService().getCRFHistory(historyId);
	}

	public static List<CRFHistory> getCRFHistoryByC_S(
		long crfId, long subjectId) {

		return getService().getCRFHistoryByC_S(crfId, subjectId);
	}

	public static List<CRFHistory> getCRFHistoryByG_C(
		long groupId, long crfId) {

		return getService().getCRFHistoryByG_C(groupId, crfId);
	}

	public static List<CRFHistory> getCRFHistoryByG_C_S(
		long groupId, long crfId, long subjectId) {

		return getService().getCRFHistoryByG_C_S(groupId, crfId, subjectId);
	}

	public static List<CRFHistory> getCRFHistoryByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end) {

		return getService().getCRFHistoryByG_C_S(
			groupId, crfId, subjectId, start, end);
	}

	public static List<CRFHistory> getCRFHistoryByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFHistory> comparator) {

		return getService().getCRFHistoryByG_C_S(
			groupId, crfId, subjectId, start, end, comparator);
	}

	public static List<CRFHistory> getCRFHistoryByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId) {

		return getService().getCRFHistoryByG_C_S_SD(
			groupId, crfId, subjectId, structuredDataId);
	}

	public static List<CRFHistory> getCRFHistoryByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId,
		int start, int end) {

		return getService().getCRFHistoryByG_C_S_SD(
			groupId, crfId, subjectId, structuredDataId, start, end);
	}

	public static List<CRFHistory> getCRFHistoryByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId,
		int start, int end, OrderByComparator<CRFHistory> comparator) {

		return getService().getCRFHistoryByG_C_S_SD(
			groupId, crfId, subjectId, structuredDataId, start, end,
			comparator);
	}

	public static List<CRFHistory> getCRFHistoryByGroupId(long groupId) {
		return getService().getCRFHistoryByGroupId(groupId);
	}

	public static List<CRFHistory> getCRFHistoryByGroupId(
		long groupId, int start, int end) {

		return getService().getCRFHistoryByGroupId(groupId, start, end);
	}

	public static List<CRFHistory> getCRFHistoryByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFHistory> comparator) {

		return getService().getCRFHistoryByGroupId(
			groupId, start, end, comparator);
	}

	public static List<CRFHistory> getCRFHistoryByHistoryId(long historyId) {
		return getService().getCRFHistoryByHistoryId(historyId);
	}

	public static List<CRFHistory> getCRFHistoryByHistoryId(
		long historyId, int start, int end) {

		return getService().getCRFHistoryByHistoryId(historyId, start, end);
	}

	public static List<CRFHistory> getCRFHistoryByHistoryId(
		long historyId, int start, int end,
		OrderByComparator<CRFHistory> comparator) {

		return getService().getCRFHistoryByHistoryId(
			historyId, start, end, comparator);
	}

	public static List<CRFHistory> getCRFHistoryBySubjectId(long subjectId) {
		return getService().getCRFHistoryBySubjectId(subjectId);
	}

	public static List<CRFHistory> getCRFHistoryBySubjectId(
		long subjectId, int start, int end) {

		return getService().getCRFHistoryBySubjectId(subjectId, start, end);
	}

	public static List<CRFHistory> getCRFHistoryBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<CRFHistory> comparator) {

		return getService().getCRFHistoryBySubjectId(
			subjectId, start, end, comparator);
	}

	/**
	 * Returns the crf history matching the UUID and group.
	 *
	 * @param uuid the crf history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf history
	 * @throws PortalException if a matching crf history could not be found
	 */
	public static CRFHistory getCRFHistoryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCRFHistoryByUuidAndGroupId(uuid, groupId);
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
	 * Updates the crf history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfHistory the crf history
	 * @return the crf history that was updated
	 */
	public static CRFHistory updateCRFHistory(CRFHistory crfHistory) {
		return getService().updateCRFHistory(crfHistory);
	}

	public static CRFHistory updateCRFHistory(
			long historyId, String subjectName, long subjectId, String serialId,
			long structuredDataId, long crfId, String previousJSON,
			String currentJSON, int actionType, String historyVersion,
			String previousVersion,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateCRFHistory(
			historyId, subjectName, subjectId, serialId, structuredDataId,
			crfId, previousJSON, currentJSON, actionType, historyVersion,
			previousVersion, sc);
	}

	public static CRFHistoryLocalService getService() {
		return _service;
	}

	private static volatile CRFHistoryLocalService _service;

}