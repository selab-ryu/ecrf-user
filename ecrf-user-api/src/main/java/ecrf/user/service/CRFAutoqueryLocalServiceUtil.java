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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CRFAutoquery. This utility wraps
 * <code>ecrf.user.service.impl.CRFAutoqueryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see CRFAutoqueryLocalService
 * @generated
 */
public class CRFAutoqueryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.CRFAutoqueryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ecrf.user.model.CRFAutoquery addCRFAutoquery(
		ecrf.user.model.CRFAutoquery crfAutoquery) {

		return getService().addCRFAutoquery(crfAutoquery);
	}

	public static ecrf.user.model.CRFAutoquery addCRFAutoquery(
			long queryTermId, String queryTermName, String queryValue,
			String queryPreviousValue, long subjectId, long crfId,
			int queryType, String queryComment,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCRFAutoquery(
			queryTermId, queryTermName, queryValue, queryPreviousValue,
			subjectId, crfId, queryType, queryComment, sc);
	}

	public static int checkFloatingPoint(
		String compareValue, String queryValue) {

		return getService().checkFloatingPoint(compareValue, queryValue);
	}

	public static void checkQuery(
			long sdId, com.liferay.portal.kernel.json.JSONArray crfForm,
			com.liferay.portal.kernel.json.JSONObject answerForm,
			long subjectId, long crfId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().checkQuery(
			sdId, crfForm, answerForm, subjectId, crfId, sc);
	}

	public static ecrf.user.model.CRFAutoquery comfirmAutoquery(
			long autoQueryId, int queryComfirm, String queryValue,
			String queryChangeValue, String queryComment,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().comfirmAutoquery(
			autoQueryId, queryComfirm, queryValue, queryChangeValue,
			queryComment, sc);
	}

	public static int countQueryBySdId(long sdId) {
		return getService().countQueryBySdId(sdId);
	}

	public static int countQueryBySdIdSIdValue(
		long sdId, long sId, String termName, String value) {

		return getService().countQueryBySdIdSIdValue(
			sdId, sId, termName, value);
	}

	/**
	 * Creates a new crf autoquery with the primary key. Does not add the crf autoquery to the database.
	 *
	 * @param autoQueryId the primary key for the new crf autoquery
	 * @return the new crf autoquery
	 */
	public static ecrf.user.model.CRFAutoquery createCRFAutoquery(
		long autoQueryId) {

		return getService().createCRFAutoquery(autoQueryId);
	}

	public static ecrf.user.model.CRFAutoquery deleteAutoquery(long autoQueryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAutoquery(autoQueryId);
	}

	public static void deleteCRFAutoqueries(long[] autoQueryIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCRFAutoqueries(autoQueryIds);
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
	public static ecrf.user.model.CRFAutoquery deleteCRFAutoquery(
		ecrf.user.model.CRFAutoquery crfAutoquery) {

		return getService().deleteCRFAutoquery(crfAutoquery);
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
	public static ecrf.user.model.CRFAutoquery deleteCRFAutoquery(
			long autoQueryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCRFAutoquery(autoQueryId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ecrf.user.model.CRFAutoquery fetchCRFAutoquery(
		long autoQueryId) {

		return getService().fetchCRFAutoquery(autoQueryId);
	}

	/**
	 * Returns the crf autoquery matching the UUID and group.
	 *
	 * @param uuid the crf autoquery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	public static ecrf.user.model.CRFAutoquery
		fetchCRFAutoqueryByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchCRFAutoqueryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<ecrf.user.model.CRFAutoquery> getAllQuery() {
		return getService().getAllQuery();
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
	public static java.util.List<ecrf.user.model.CRFAutoquery>
		getCRFAutoqueries(int start, int end) {

		return getService().getCRFAutoqueries(start, end);
	}

	/**
	 * Returns all the crf autoqueries matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf autoqueries
	 * @param companyId the primary key of the company
	 * @return the matching crf autoqueries, or an empty list if no matches were found
	 */
	public static java.util.List<ecrf.user.model.CRFAutoquery>
		getCRFAutoqueriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getCRFAutoqueriesByUuidAndCompanyId(
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
	public static java.util.List<ecrf.user.model.CRFAutoquery>
		getCRFAutoqueriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.CRFAutoquery> orderByComparator) {

		return getService().getCRFAutoqueriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of crf autoqueries.
	 *
	 * @return the number of crf autoqueries
	 */
	public static int getCRFAutoqueriesCount() {
		return getService().getCRFAutoqueriesCount();
	}

	/**
	 * Returns the crf autoquery with the primary key.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery
	 * @throws PortalException if a crf autoquery with the primary key could not be found
	 */
	public static ecrf.user.model.CRFAutoquery getCRFAutoquery(long autoQueryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCRFAutoquery(autoQueryId);
	}

	/**
	 * Returns the crf autoquery matching the UUID and group.
	 *
	 * @param uuid the crf autoquery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf autoquery
	 * @throws PortalException if a matching crf autoquery could not be found
	 */
	public static ecrf.user.model.CRFAutoquery getCRFAutoqueryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCRFAutoqueryByUuidAndGroupId(uuid, groupId);
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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<ecrf.user.model.CRFAutoquery> getQueryByG_C_S(
		long groupId, long crfId, long subjectId) {

		return getService().getQueryByG_C_S(groupId, crfId, subjectId);
	}

	public static java.util.List<ecrf.user.model.CRFAutoquery>
		getQueryByGroupCRF(long groupId, long crfId) {

		return getService().getQueryByGroupCRF(groupId, crfId);
	}

	public static java.util.List<ecrf.user.model.CRFAutoquery>
		getQueryByGroupId(long groupId) {

		return getService().getQueryByGroupId(groupId);
	}

	public static ecrf.user.model.CRFAutoquery getQueryBySdIdSIdValue(
			long sdId, long sId, String termName, String value)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getService().getQueryBySdIdSIdValue(sdId, sId, termName, value);
	}

	public static java.util.List<ecrf.user.model.CRFAutoquery> getQueryBySId(
		long sId) {

		return getService().getQueryBySId(sId);
	}

	public static ecrf.user.model.CRFAutoquery getQueryBySIdTermName(
			long sId, String termName)
		throws ecrf.user.exception.NoSuchCRFAutoqueryException {

		return getService().getQueryBySIdTermName(sId, termName);
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
	public static ecrf.user.model.CRFAutoquery updateCRFAutoquery(
		ecrf.user.model.CRFAutoquery crfAutoquery) {

		return getService().updateCRFAutoquery(crfAutoquery);
	}

	public static CRFAutoqueryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CRFAutoqueryLocalService, CRFAutoqueryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CRFAutoqueryLocalService.class);

		ServiceTracker<CRFAutoqueryLocalService, CRFAutoqueryLocalService>
			serviceTracker =
				new ServiceTracker
					<CRFAutoqueryLocalService, CRFAutoqueryLocalService>(
						bundle.getBundleContext(),
						CRFAutoqueryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}