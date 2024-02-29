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
 * Provides a wrapper for {@link CRFAutoqueryLocalService}.
 *
 * @author Ryu W.C.
 * @see CRFAutoqueryLocalService
 * @generated
 */
public class CRFAutoqueryLocalServiceWrapper
	implements CRFAutoqueryLocalService,
			   ServiceWrapper<CRFAutoqueryLocalService> {

	public CRFAutoqueryLocalServiceWrapper(
		CRFAutoqueryLocalService crfAutoqueryLocalService) {

		_crfAutoqueryLocalService = crfAutoqueryLocalService;
	}

	/**
	 * Adds the crf autoquery to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFAutoqueryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfAutoquery the crf autoquery
	 * @return the crf autoquery that was added
	 */
	@Override
	public ecrf.user.model.CRFAutoquery addCRFAutoquery(
		ecrf.user.model.CRFAutoquery crfAutoquery) {

		return _crfAutoqueryLocalService.addCRFAutoquery(crfAutoquery);
	}

	@Override
	public ecrf.user.model.CRFAutoquery addCRFAutoquery(
			long queryTermId, String queryTermName, String queryValue,
			String queryPreviousValue, long subjectId, long crfId,
			int queryType, String queryComment,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfAutoqueryLocalService.addCRFAutoquery(
			queryTermId, queryTermName, queryValue, queryPreviousValue,
			subjectId, crfId, queryType, queryComment, sc);
	}

	@Override
	public int checkFloatingPoint(String compareValue, String queryValue) {
		return _crfAutoqueryLocalService.checkFloatingPoint(
			compareValue, queryValue);
	}

	@Override
	public void checkQuery(
			long sdId, com.liferay.portal.kernel.json.JSONArray crfForm,
			com.liferay.portal.kernel.json.JSONObject answerForm,
			long subjectId, long crfId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		_crfAutoqueryLocalService.checkQuery(
			sdId, crfForm, answerForm, subjectId, crfId, sc);
	}

	@Override
	public ecrf.user.model.CRFAutoquery comfirmAutoquery(
			long autoQueryId, int queryComfirm, String queryValue,
			String queryChangeValue, String queryComment,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfAutoqueryLocalService.comfirmAutoquery(
			autoQueryId, queryComfirm, queryValue, queryChangeValue,
			queryComment, sc);
	}

	@Override
	public int countQueryBySdId(long sdId) {
		return _crfAutoqueryLocalService.countQueryBySdId(sdId);
	}

	@Override
	public int countQueryBySdIdSIdValue(
		long sdId, long sId, String termName, String value) {

		return _crfAutoqueryLocalService.countQueryBySdIdSIdValue(
			sdId, sId, termName, value);
	}

	/**
	 * Creates a new crf autoquery with the primary key. Does not add the crf autoquery to the database.
	 *
	 * @param autoQueryId the primary key for the new crf autoquery
	 * @return the new crf autoquery
	 */
	@Override
	public ecrf.user.model.CRFAutoquery createCRFAutoquery(long autoQueryId) {
		return _crfAutoqueryLocalService.createCRFAutoquery(autoQueryId);
	}

	@Override
	public ecrf.user.model.CRFAutoquery deleteAutoquery(long autoQueryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfAutoqueryLocalService.deleteAutoquery(autoQueryId);
	}

	@Override
	public void deleteCRFAutoqueries(long[] autoQueryIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_crfAutoqueryLocalService.deleteCRFAutoqueries(autoQueryIds);
	}

	/**
	 * Deletes the crf autoquery from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFAutoqueryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfAutoquery the crf autoquery
	 * @return the crf autoquery that was removed
	 */
	@Override
	public ecrf.user.model.CRFAutoquery deleteCRFAutoquery(
		ecrf.user.model.CRFAutoquery crfAutoquery) {

		return _crfAutoqueryLocalService.deleteCRFAutoquery(crfAutoquery);
	}

	/**
	 * Deletes the crf autoquery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFAutoqueryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery that was removed
	 * @throws PortalException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFAutoquery deleteCRFAutoquery(long autoQueryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfAutoqueryLocalService.deleteCRFAutoquery(autoQueryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfAutoqueryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crfAutoqueryLocalService.dynamicQuery();
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

		return _crfAutoqueryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFAutoqueryModelImpl</code>.
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

		return _crfAutoqueryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFAutoqueryModelImpl</code>.
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

		return _crfAutoqueryLocalService.dynamicQuery(
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

		return _crfAutoqueryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _crfAutoqueryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.CRFAutoquery fetchCRFAutoquery(long autoQueryId) {
		return _crfAutoqueryLocalService.fetchCRFAutoquery(autoQueryId);
	}

	/**
	 * Returns the crf autoquery matching the UUID and group.
	 *
	 * @param uuid the crf autoquery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public ecrf.user.model.CRFAutoquery fetchCRFAutoqueryByUuidAndGroupId(
		String uuid, long groupId) {

		return _crfAutoqueryLocalService.fetchCRFAutoqueryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crfAutoqueryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<ecrf.user.model.CRFAutoquery> getAllQuery() {
		return _crfAutoqueryLocalService.getAllQuery();
	}

	/**
	 * Returns a range of all the crf autoqueries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of crf autoqueries
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFAutoquery> getCRFAutoqueries(
		int start, int end) {

		return _crfAutoqueryLocalService.getCRFAutoqueries(start, end);
	}

	/**
	 * Returns all the crf autoqueries matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf autoqueries
	 * @param companyId the primary key of the company
	 * @return the matching crf autoqueries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFAutoquery>
		getCRFAutoqueriesByUuidAndCompanyId(String uuid, long companyId) {

		return _crfAutoqueryLocalService.getCRFAutoqueriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of crf autoqueries matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf autoqueries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crf autoqueries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.CRFAutoquery>
		getCRFAutoqueriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.CRFAutoquery> orderByComparator) {

		return _crfAutoqueryLocalService.getCRFAutoqueriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf autoqueries.
	 *
	 * @return the number of crf autoqueries
	 */
	@Override
	public int getCRFAutoqueriesCount() {
		return _crfAutoqueryLocalService.getCRFAutoqueriesCount();
	}

	/**
	 * Returns the crf autoquery with the primary key.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery
	 * @throws PortalException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.CRFAutoquery getCRFAutoquery(long autoQueryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfAutoqueryLocalService.getCRFAutoquery(autoQueryId);
	}

	/**
	 * Returns the crf autoquery matching the UUID and group.
	 *
	 * @param uuid the crf autoquery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf autoquery
	 * @throws PortalException if a matching crf autoquery could not be found
	 */
	@Override
	public ecrf.user.model.CRFAutoquery getCRFAutoqueryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfAutoqueryLocalService.getCRFAutoqueryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _crfAutoqueryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crfAutoqueryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crfAutoqueryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crfAutoqueryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFAutoquery> getQueryByG_C_S(
		long groupId, long crfId, long subjectId) {

		return _crfAutoqueryLocalService.getQueryByG_C_S(
			groupId, crfId, subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFAutoquery> getQueryByGroupCRF(
		long groupId, long crfId) {

		return _crfAutoqueryLocalService.getQueryByGroupCRF(groupId, crfId);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFAutoquery> getQueryByGroupId(
		long groupId) {

		return _crfAutoqueryLocalService.getQueryByGroupId(groupId);
	}

	@Override
	public ecrf.user.model.CRFAutoquery getQueryBySdIdSIdValue(
			long sdId, long sId, String termName, String value)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return _crfAutoqueryLocalService.getQueryBySdIdSIdValue(
			sdId, sId, termName, value);
	}

	@Override
	public java.util.List<ecrf.user.model.CRFAutoquery> getQueryBySId(
		long sId) {

		return _crfAutoqueryLocalService.getQueryBySId(sId);
	}

	@Override
	public ecrf.user.model.CRFAutoquery getQueryBySIdTermName(
			long sId, String termName)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return _crfAutoqueryLocalService.getQueryBySIdTermName(sId, termName);
	}

	/**
	 * Updates the crf autoquery in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFAutoqueryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfAutoquery the crf autoquery
	 * @return the crf autoquery that was updated
	 */
	@Override
	public ecrf.user.model.CRFAutoquery updateCRFAutoquery(
		ecrf.user.model.CRFAutoquery crfAutoquery) {

		return _crfAutoqueryLocalService.updateCRFAutoquery(crfAutoquery);
	}

	@Override
	public CRFAutoqueryLocalService getWrappedService() {
		return _crfAutoqueryLocalService;
	}

	@Override
	public void setWrappedService(
		CRFAutoqueryLocalService crfAutoqueryLocalService) {

		_crfAutoqueryLocalService = crfAutoqueryLocalService;
	}

	private CRFAutoqueryLocalService _crfAutoqueryLocalService;

}