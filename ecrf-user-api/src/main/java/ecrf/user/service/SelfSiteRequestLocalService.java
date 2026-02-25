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

import ecrf.user.model.SelfSiteRequest;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SelfSiteRequest. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ryu W.C.
 * @see SelfSiteRequestLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SelfSiteRequestLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>ecrf.user.service.impl.SelfSiteRequestLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the self site request local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SelfSiteRequestLocalServiceUtil} if injection and service tracking are not available.
	 */
	public SelfSiteRequest addRequest(
			String email, String lastName, String firstName, String phone,
			String title, String description, ServiceContext sc)
		throws PortalException;

	/**
	 * Adds the self site request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelfSiteRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param selfSiteRequest the self site request
	 * @return the self site request that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SelfSiteRequest addSelfSiteRequest(SelfSiteRequest selfSiteRequest);

	/**
	 * Creates a new self site request with the primary key. Does not add the self site request to the database.
	 *
	 * @param selfSiteRequestId the primary key for the new self site request
	 * @return the new self site request
	 */
	@Transactional(enabled = false)
	public SelfSiteRequest createSelfSiteRequest(long selfSiteRequestId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the self site request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelfSiteRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request that was removed
	 * @throws PortalException if a self site request with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SelfSiteRequest deleteSelfSiteRequest(long selfSiteRequestId)
		throws PortalException;

	/**
	 * Deletes the self site request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelfSiteRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param selfSiteRequest the self site request
	 * @return the self site request that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SelfSiteRequest deleteSelfSiteRequest(
		SelfSiteRequest selfSiteRequest);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.SelfSiteRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.SelfSiteRequestModelImpl</code>.
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
	public SelfSiteRequest fetchSelfSiteRequest(long selfSiteRequestId);

	/**
	 * Returns the self site request matching the UUID and group.
	 *
	 * @param uuid the self site request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching self site request, or <code>null</code> if a matching self site request could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SelfSiteRequest fetchSelfSiteRequestByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SelfSiteRequest> getAllSiteRequest();

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

	/**
	 * Returns the self site request with the primary key.
	 *
	 * @param selfSiteRequestId the primary key of the self site request
	 * @return the self site request
	 * @throws PortalException if a self site request with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SelfSiteRequest getSelfSiteRequest(long selfSiteRequestId)
		throws PortalException;

	/**
	 * Returns the self site request matching the UUID and group.
	 *
	 * @param uuid the self site request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching self site request
	 * @throws PortalException if a matching self site request could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SelfSiteRequest getSelfSiteRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the self site requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.SelfSiteRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @return the range of self site requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SelfSiteRequest> getSelfSiteRequests(int start, int end);

	/**
	 * Returns all the self site requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the self site requests
	 * @param companyId the primary key of the company
	 * @return the matching self site requests, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SelfSiteRequest> getSelfSiteRequestsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of self site requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the self site requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of self site requests
	 * @param end the upper bound of the range of self site requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching self site requests, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SelfSiteRequest> getSelfSiteRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SelfSiteRequest> orderByComparator);

	/**
	 * Returns the number of self site requests.
	 *
	 * @return the number of self site requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSelfSiteRequestsCount();

	/**
	 * Updates the self site request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelfSiteRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param selfSiteRequest the self site request
	 * @return the self site request that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SelfSiteRequest updateSelfSiteRequest(
		SelfSiteRequest selfSiteRequest);

}