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
 * Provides a wrapper for {@link CRFHistoryLocalService}.
 *
 * @author Ryu W.C.
 * @see CRFHistoryLocalService
 * @generated
 */
public class CRFHistoryLocalServiceWrapper
	implements CRFHistoryLocalService, ServiceWrapper<CRFHistoryLocalService> {

	public CRFHistoryLocalServiceWrapper(
		CRFHistoryLocalService crfHistoryLocalService) {

		_crfHistoryLocalService = crfHistoryLocalService;
	}

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
	@Override
	public ecrf.user.model.CRFHistory addCRFHistory(
		ecrf.user.model.CRFHistory crfHistory) {

		return _crfHistoryLocalService.addCRFHistory(crfHistory);
	}

	@Override
	public ecrf.user.model.CRFHistory addCRFHistory(
			String subjectName, long subjectId, String serialId,
			long structuredDataId, long crfId, String previousJSON,
			String currentJSON, int actionType, String historyVersion,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfHistoryLocalService.addCRFHistory(
			subjectName, subjectId, serialId, structuredDataId, crfId,
			previousJSON, currentJSON, actionType, historyVersion, sc);
	}

	@Override
	public int countAllCRFHistory() {
		return _crfHistoryLocalService.countAllCRFHistory();
	}

	@Override
	public int countCRFHistoryByG_C_S(
		long groupId, long crfId, long subjectId) {

		return _crfHistoryLocalService.countCRFHistoryByG_C_S(
			groupId, crfId, subjectId);
	}

	@Override
	public int countCRFHistoryByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId) {

		return _crfHistoryLocalService.countCRFHistoryByG_C_S_SD(
			groupId, crfId, subjectId, structuredDataId);
	}

	@Override
	public int countCRFHistoryByGroupId(long groupId) {
		return _crfHistoryLocalService.countCRFHistoryByGroupId(groupId);
	}

	@Override
	public int countCRFHistoryByHistoryId(long historyId) {
		return _crfHistoryLocalService.countCRFHistoryByHistoryId(historyId);
	}

	@Override
	public int countCRFHistoryBySubjectId(long subjectId) {
		return _crfHistoryLocalService.countCRFHistoryBySubjectId(subjectId);
	}

	/**
	 * Creates a new crf history with the primary key. Does not add the crf history to the database.
	 *
	 * @param historyId the primary key for the new crf history
	 * @return the new crf history
	 */
	@Override
	public ecrf.user.model.CRFHistory createCRFHistory(long historyId) {
		return _crfHistoryLocalService.createCRFHistory(historyId);
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
	@Override
	public ecrf.user.model.CRFHistory deleteCRFHistory(
		ecrf.user.model.CRFHistory crfHistory) {

		return _crfHistoryLocalService.deleteCRFHistory(crfHistory);
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
	@Override
	public ecrf.user.model.CRFHistory deleteCRFHistory(long historyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfHistoryLocalService.deleteCRFHistory(historyId);
	}

	@Override
	public void deleteCRFHistorys(long[] historyIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_crfHistoryLocalService.deleteCRFHistorys(historyIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfHistoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crfHistoryLocalService.dynamicQuery();
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

		return _crfHistoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _crfHistoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _crfHistoryLocalService.dynamicQuery(
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

		return _crfHistoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _crfHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.CRFHistory fetchCRFHistory(long historyId) {
		return _crfHistoryLocalService.fetchCRFHistory(historyId);
	}

	/**
	 * Returns the crf history matching the UUID and group.
	 *
	 * @param uuid the crf history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public ecrf.user.model.CRFHistory fetchCRFHistoryByUuidAndGroupId(
		String uuid, long groupId) {

		return _crfHistoryLocalService.fetchCRFHistoryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crfHistoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getAllCRFHistory() {
		return _crfHistoryLocalService.getAllCRFHistory();
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getAllCRFHistory(
		int start, int end) {

		return _crfHistoryLocalService.getAllCRFHistory(start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getAllCRFHistory(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.CRFHistory> comparator) {

		return _crfHistoryLocalService.getAllCRFHistory(start, end, comparator);
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
	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistories(
		int start, int end) {

		return _crfHistoryLocalService.getCRFHistories(start, end);
	}

	/**
	 * Returns all the crf histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf histories
	 * @param companyId the primary key of the company
	 * @return the matching crf histories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFHistory>
		getCRFHistoriesByUuidAndCompanyId(String uuid, long companyId) {

		return _crfHistoryLocalService.getCRFHistoriesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<ecrf.user.model.CRFHistory>
		getCRFHistoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.CRFHistory> orderByComparator) {

		return _crfHistoryLocalService.getCRFHistoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf histories.
	 *
	 * @return the number of crf histories
	 */
	@Override
	public int getCRFHistoriesCount() {
		return _crfHistoryLocalService.getCRFHistoriesCount();
	}

	/**
	 * Returns the crf history with the primary key.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history
	 * @throws PortalException if a crf history with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFHistory getCRFHistory(long historyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfHistoryLocalService.getCRFHistory(historyId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByC_S(
		long crfId, long subjectId) {

		return _crfHistoryLocalService.getCRFHistoryByC_S(crfId, subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByG_C(
		long groupId, long crfId) {

		return _crfHistoryLocalService.getCRFHistoryByG_C(groupId, crfId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByG_C_S(
		long groupId, long crfId, long subjectId) {

		return _crfHistoryLocalService.getCRFHistoryByG_C_S(
			groupId, crfId, subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end) {

		return _crfHistoryLocalService.getCRFHistoryByG_C_S(
			groupId, crfId, subjectId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.CRFHistory> comparator) {

		return _crfHistoryLocalService.getCRFHistoryByG_C_S(
			groupId, crfId, subjectId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId) {

		return _crfHistoryLocalService.getCRFHistoryByG_C_S_SD(
			groupId, crfId, subjectId, structuredDataId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId,
		int start, int end) {

		return _crfHistoryLocalService.getCRFHistoryByG_C_S_SD(
			groupId, crfId, subjectId, structuredDataId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByG_C_S_SD(
		long groupId, long crfId, long subjectId, long structuredDataId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.CRFHistory> comparator) {

		return _crfHistoryLocalService.getCRFHistoryByG_C_S_SD(
			groupId, crfId, subjectId, structuredDataId, start, end,
			comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByGroupId(
		long groupId) {

		return _crfHistoryLocalService.getCRFHistoryByGroupId(groupId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByGroupId(
		long groupId, int start, int end) {

		return _crfHistoryLocalService.getCRFHistoryByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.CRFHistory> comparator) {

		return _crfHistoryLocalService.getCRFHistoryByGroupId(
			groupId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByHistoryId(
		long historyId) {

		return _crfHistoryLocalService.getCRFHistoryByHistoryId(historyId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByHistoryId(
		long historyId, int start, int end) {

		return _crfHistoryLocalService.getCRFHistoryByHistoryId(
			historyId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryByHistoryId(
		long historyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.CRFHistory> comparator) {

		return _crfHistoryLocalService.getCRFHistoryByHistoryId(
			historyId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryBySubjectId(
		long subjectId) {

		return _crfHistoryLocalService.getCRFHistoryBySubjectId(subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryBySubjectId(
		long subjectId, int start, int end) {

		return _crfHistoryLocalService.getCRFHistoryBySubjectId(
			subjectId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFHistory> getCRFHistoryBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.CRFHistory> comparator) {

		return _crfHistoryLocalService.getCRFHistoryBySubjectId(
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
	@Override
	public ecrf.user.model.CRFHistory getCRFHistoryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfHistoryLocalService.getCRFHistoryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _crfHistoryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crfHistoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crfHistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfHistoryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public ecrf.user.model.CRFHistory updateCRFHistory(
		ecrf.user.model.CRFHistory crfHistory) {

		return _crfHistoryLocalService.updateCRFHistory(crfHistory);
	}

	@Override
	public ecrf.user.model.CRFHistory updateCRFHistory(
			long historyId, String subjectName, long subjectId, String serialId,
			long structuredDataId, long crfId, String previousJSON,
			String currentJSON, int actionType, String historyVersion,
			String previousVersion,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfHistoryLocalService.updateCRFHistory(
			historyId, subjectName, subjectId, serialId, structuredDataId,
			crfId, previousJSON, currentJSON, actionType, historyVersion,
			previousVersion, sc);
	}

	@Override
	public CRFHistoryLocalService getWrappedService() {
		return _crfHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		CRFHistoryLocalService crfHistoryLocalService) {

		_crfHistoryLocalService = crfHistoryLocalService;
	}

	private CRFHistoryLocalService _crfHistoryLocalService;

}