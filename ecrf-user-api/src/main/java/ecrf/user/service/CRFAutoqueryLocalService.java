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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import ecrf.user.exception.NoSuchCRFAutoqueryException;
import ecrf.user.model.CRFAutoquery;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for CRFAutoquery. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ryu W.C.
 * @see CRFAutoqueryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CRFAutoqueryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>ecrf.user.service.impl.CRFAutoqueryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the crf autoquery local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CRFAutoqueryLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public CRFAutoquery addCRFAutoquery(CRFAutoquery crfAutoquery);

	public CRFAutoquery addCRFAutoquery(
			long queryTermId, String queryTermName, String queryValue,
			String queryPreviousValue, long subjectId, long crfId,
			int queryType, String queryComment, ServiceContext sc)
		throws PortalException;

	public int checkFloatingPoint(String compareValue, String queryValue);

	public void checkQuery(
			long sdId, JSONArray crfForm, JSONObject answerForm, long subjectId,
			long crfId, ServiceContext sc)
		throws PortalException;

	public CRFAutoquery comfirmAutoquery(
			long autoQueryId, int queryComfirm, String queryValue,
			String queryChangeValue, String queryComment, ServiceContext sc)
		throws PortalException;

	public int countQueryBySdId(long sdId);

	public int countQueryBySdIdSIdValue(
		long sdId, long sId, String termName, String value);

	/**
	 * Creates a new crf autoquery with the primary key. Does not add the crf autoquery to the database.
	 *
	 * @param autoQueryId the primary key for the new crf autoquery
	 * @return the new crf autoquery
	 */
	@Transactional(enabled = false)
	public CRFAutoquery createCRFAutoquery(long autoQueryId);

	public CRFAutoquery deleteAutoquery(long autoQueryId)
		throws PortalException;

	public void deleteCRFAutoqueries(long[] autoQueryIds)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public CRFAutoquery deleteCRFAutoquery(CRFAutoquery crfAutoquery);

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
	@Indexable(type = IndexableType.DELETE)
	public CRFAutoquery deleteCRFAutoquery(long autoQueryId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRFAutoquery fetchCRFAutoquery(long autoQueryId);

	/**
	 * Returns the crf autoquery matching the UUID and group.
	 *
	 * @param uuid the crf autoquery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRFAutoquery fetchCRFAutoqueryByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRFAutoquery> getAllQuery();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRFAutoquery> getCRFAutoqueries(int start, int end);

	/**
	 * Returns all the crf autoqueries matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf autoqueries
	 * @param companyId the primary key of the company
	 * @return the matching crf autoqueries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRFAutoquery> getCRFAutoqueriesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRFAutoquery> getCRFAutoqueriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator);

	/**
	 * Returns the number of crf autoqueries.
	 *
	 * @return the number of crf autoqueries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCRFAutoqueriesCount();

	/**
	 * Returns the crf autoquery with the primary key.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery
	 * @throws PortalException if a crf autoquery with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRFAutoquery getCRFAutoquery(long autoQueryId)
		throws PortalException;

	/**
	 * Returns the crf autoquery matching the UUID and group.
	 *
	 * @param uuid the crf autoquery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf autoquery
	 * @throws PortalException if a matching crf autoquery could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRFAutoquery getCRFAutoqueryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRFAutoquery> getQueryByG_C_S(
		long groupId, long crfId, long subjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRFAutoquery> getQueryByGroupCRF(long groupId, long crfId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRFAutoquery> getQueryByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRFAutoquery getQueryBySdIdSIdValue(
			long sdId, long sId, String termName, String value)
		throws NoSuchCRFAutoqueryException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CRFAutoquery> getQueryBySId(long sId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CRFAutoquery getQueryBySIdTermName(long sId, String termName)
		throws NoSuchCRFAutoqueryException;

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
	@Indexable(type = IndexableType.REINDEX)
	public CRFAutoquery updateCRFAutoquery(CRFAutoquery crfAutoquery);

}