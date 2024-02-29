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

import ecrf.user.exception.NoSuchLinkCRFException;
import ecrf.user.model.LinkCRF;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for LinkCRF. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ryu W.C.
 * @see LinkCRFLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LinkCRFLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>ecrf.user.service.impl.LinkCRFLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the link crf local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link LinkCRFLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the link crf to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkCRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linkCRF the link crf
	 * @return the link crf that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LinkCRF addLinkCRF(LinkCRF linkCRF);

	public LinkCRF addLinkCRF(
			long subjectId, long crfId, long structuredDataId,
			ServiceContext sc)
		throws PortalException;

	public int countAllLinkCRF();

	public int countLinkByStructuredDataId(long structuredDataId);

	public int countLinkBySubjectId(long subjectId);

	public int countLinkCRFByG_C(long groupId, long crfId);

	public int countLinkCRFByG_S(long groupId, long subjectId);

	public int countLinkCRFByG_S_C(long groupId, long subjectId, long crfId);

	public int countLinkCRFByGroupId(long groupId);

	/**
	 * Creates a new link crf with the primary key. Does not add the link crf to the database.
	 *
	 * @param linkId the primary key for the new link crf
	 * @return the new link crf
	 */
	@Transactional(enabled = false)
	public LinkCRF createLinkCRF(long linkId);

	/**
	 * Deletes the link crf from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkCRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linkCRF the link crf
	 * @return the link crf that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public LinkCRF deleteLinkCRF(LinkCRF linkCRF);

	/**
	 * Deletes the link crf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkCRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf that was removed
	 * @throws PortalException if a link crf with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public LinkCRF deleteLinkCRF(long linkId) throws PortalException;

	public void deleteLinkCRFs(long[] linkIds) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.LinkCRFModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.LinkCRFModelImpl</code>.
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
	public LinkCRF fetchLinkCRF(long linkId);

	/**
	 * Returns the link crf matching the UUID and group.
	 *
	 * @param uuid the link crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LinkCRF fetchLinkCRFByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getAllLinkCRF();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getAllLinkCRF(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getAllLinkCRF(
		int start, int end, OrderByComparator<LinkCRF> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the link crf with the primary key.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf
	 * @throws PortalException if a link crf with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LinkCRF getLinkCRF(long linkId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByC_S(long crfId, long subjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LinkCRF getLinkCRFByC_S_SD(
			long crfId, long subjectId, long structuredDataId)
		throws NoSuchLinkCRFException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByG_C(long groupId, long crfId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByG_C(
		long groupId, long crfId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByG_S(long groupId, long subjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByG_S(
		long groupId, long subjectId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<LinkCRF> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LinkCRF getLinkCRFByG_S_C_SD(
			long groupId, long subjectId, long crfId, long structuredDataId)
		throws NoSuchLinkCRFException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByGroupId(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LinkCRF> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LinkCRF getLinkCRFBySdId(long structuredDataId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LinkCRF getLinkCRFBySId(long subjectId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFBySubjectId(long subjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFBySubjectId(
		long subjectId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<LinkCRF> comparator);

	/**
	 * Returns the link crf matching the UUID and group.
	 *
	 * @param uuid the link crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching link crf
	 * @throws PortalException if a matching link crf could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LinkCRF getLinkCRFByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of link crfs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFs(int start, int end);

	/**
	 * Returns all the link crfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the link crfs
	 * @param companyId the primary key of the company
	 * @return the matching link crfs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of link crfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the link crfs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching link crfs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LinkCRF> getLinkCRFsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator);

	/**
	 * Returns the number of link crfs.
	 *
	 * @return the number of link crfs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLinkCRFsCount();

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
	 * Updates the link crf in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkCRFLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linkCRF the link crf
	 * @return the link crf that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LinkCRF updateLinkCRF(LinkCRF linkCRF);

	public LinkCRF updateLinkCRF(
			long linkId, long subjectId, long crfId, long structuredDataId,
			ServiceContext sc)
		throws PortalException;

}