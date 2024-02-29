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
 * Provides a wrapper for {@link LinkCRFLocalService}.
 *
 * @author Ryu W.C.
 * @see LinkCRFLocalService
 * @generated
 */
public class LinkCRFLocalServiceWrapper
	implements LinkCRFLocalService, ServiceWrapper<LinkCRFLocalService> {

	public LinkCRFLocalServiceWrapper(LinkCRFLocalService linkCRFLocalService) {
		_linkCRFLocalService = linkCRFLocalService;
	}

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
	@Override
	public ecrf.user.model.LinkCRF addLinkCRF(ecrf.user.model.LinkCRF linkCRF) {
		return _linkCRFLocalService.addLinkCRF(linkCRF);
	}

	@Override
	public ecrf.user.model.LinkCRF addLinkCRF(
			long subjectId, long crfId, long structuredDataId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkCRFLocalService.addLinkCRF(
			subjectId, crfId, structuredDataId, sc);
	}

	@Override
	public int countAllLinkCRF() {
		return _linkCRFLocalService.countAllLinkCRF();
	}

	@Override
	public int countLinkByStructuredDataId(long structuredDataId) {
		return _linkCRFLocalService.countLinkByStructuredDataId(
			structuredDataId);
	}

	@Override
	public int countLinkBySubjectId(long subjectId) {
		return _linkCRFLocalService.countLinkBySubjectId(subjectId);
	}

	@Override
	public int countLinkCRFByG_C(long groupId, long crfId) {
		return _linkCRFLocalService.countLinkCRFByG_C(groupId, crfId);
	}

	@Override
	public int countLinkCRFByG_S(long groupId, long subjectId) {
		return _linkCRFLocalService.countLinkCRFByG_S(groupId, subjectId);
	}

	@Override
	public int countLinkCRFByG_S_C(long groupId, long subjectId, long crfId) {
		return _linkCRFLocalService.countLinkCRFByG_S_C(
			groupId, subjectId, crfId);
	}

	@Override
	public int countLinkCRFByGroupId(long groupId) {
		return _linkCRFLocalService.countLinkCRFByGroupId(groupId);
	}

	/**
	 * Creates a new link crf with the primary key. Does not add the link crf to the database.
	 *
	 * @param linkId the primary key for the new link crf
	 * @return the new link crf
	 */
	@Override
	public ecrf.user.model.LinkCRF createLinkCRF(long linkId) {
		return _linkCRFLocalService.createLinkCRF(linkId);
	}

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
	@Override
	public ecrf.user.model.LinkCRF deleteLinkCRF(
		ecrf.user.model.LinkCRF linkCRF) {

		return _linkCRFLocalService.deleteLinkCRF(linkCRF);
	}

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
	@Override
	public ecrf.user.model.LinkCRF deleteLinkCRF(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkCRFLocalService.deleteLinkCRF(linkId);
	}

	@Override
	public void deleteLinkCRFs(long[] linkIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_linkCRFLocalService.deleteLinkCRFs(linkIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkCRFLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _linkCRFLocalService.dynamicQuery();
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

		return _linkCRFLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _linkCRFLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _linkCRFLocalService.dynamicQuery(
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

		return _linkCRFLocalService.dynamicQueryCount(dynamicQuery);
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

		return _linkCRFLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.LinkCRF fetchLinkCRF(long linkId) {
		return _linkCRFLocalService.fetchLinkCRF(linkId);
	}

	/**
	 * Returns the link crf matching the UUID and group.
	 *
	 * @param uuid the link crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public ecrf.user.model.LinkCRF fetchLinkCRFByUuidAndGroupId(
		String uuid, long groupId) {

		return _linkCRFLocalService.fetchLinkCRFByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _linkCRFLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getAllLinkCRF() {
		return _linkCRFLocalService.getAllLinkCRF();
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getAllLinkCRF(
		int start, int end) {

		return _linkCRFLocalService.getAllLinkCRF(start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getAllLinkCRF(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return _linkCRFLocalService.getAllLinkCRF(start, end, comparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _linkCRFLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _linkCRFLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the link crf with the primary key.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf
	 * @throws PortalException if a link crf with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.LinkCRF getLinkCRF(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkCRFLocalService.getLinkCRF(linkId);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByC_S(
		long crfId, long subjectId) {

		return _linkCRFLocalService.getLinkCRFByC_S(crfId, subjectId);
	}

	@Override
	public ecrf.user.model.LinkCRF getLinkCRFByC_S_SD(
			long crfId, long subjectId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return _linkCRFLocalService.getLinkCRFByC_S_SD(
			crfId, subjectId, structuredDataId);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_C(
		long groupId, long crfId) {

		return _linkCRFLocalService.getLinkCRFByG_C(groupId, crfId);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_C(
		long groupId, long crfId, int start, int end) {

		return _linkCRFLocalService.getLinkCRFByG_C(groupId, crfId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_C(
		long groupId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return _linkCRFLocalService.getLinkCRFByG_C(
			groupId, crfId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S(
		long groupId, long subjectId) {

		return _linkCRFLocalService.getLinkCRFByG_S(groupId, subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S(
		long groupId, long subjectId, int start, int end) {

		return _linkCRFLocalService.getLinkCRFByG_S(
			groupId, subjectId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S(
		long groupId, long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return _linkCRFLocalService.getLinkCRFByG_S(
			groupId, subjectId, start, end, comparator);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId) {

		return _linkCRFLocalService.getLinkCRFByG_S_C(
			groupId, subjectId, crfId);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end) {

		return _linkCRFLocalService.getLinkCRFByG_S_C(
			groupId, subjectId, crfId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return _linkCRFLocalService.getLinkCRFByG_S_C(
			groupId, subjectId, crfId, start, end, comparator);
	}

	@Override
	public ecrf.user.model.LinkCRF getLinkCRFByG_S_C_SD(
			long groupId, long subjectId, long crfId, long structuredDataId)
		throws ecrf.user.exception.NoSuchLinkCRFException {

		return _linkCRFLocalService.getLinkCRFByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByGroupId(
		long groupId) {

		return _linkCRFLocalService.getLinkCRFByGroupId(groupId);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByGroupId(
		long groupId, int start, int end) {

		return _linkCRFLocalService.getLinkCRFByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return _linkCRFLocalService.getLinkCRFByGroupId(
			groupId, start, end, comparator);
	}

	@Override
	public ecrf.user.model.LinkCRF getLinkCRFBySdId(long structuredDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkCRFLocalService.getLinkCRFBySdId(structuredDataId);
	}

	@Override
	public ecrf.user.model.LinkCRF getLinkCRFBySId(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkCRFLocalService.getLinkCRFBySId(subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFBySubjectId(
		long subjectId) {

		return _linkCRFLocalService.getLinkCRFBySubjectId(subjectId);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFBySubjectId(
		long subjectId, int start, int end) {

		return _linkCRFLocalService.getLinkCRFBySubjectId(
			subjectId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ecrf.user.model.LinkCRF> comparator) {

		return _linkCRFLocalService.getLinkCRFBySubjectId(
			subjectId, start, end, comparator);
	}

	/**
	 * Returns the link crf matching the UUID and group.
	 *
	 * @param uuid the link crf's UUID
	 * @param groupId the primary key of the group
	 * @return the matching link crf
	 * @throws PortalException if a matching link crf could not be found
	 */
	@Override
	public ecrf.user.model.LinkCRF getLinkCRFByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkCRFLocalService.getLinkCRFByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<ecrf.user.model.LinkCRF> getLinkCRFs(
		int start, int end) {

		return _linkCRFLocalService.getLinkCRFs(start, end);
	}

	/**
	 * Returns all the link crfs matching the UUID and company.
	 *
	 * @param uuid the UUID of the link crfs
	 * @param companyId the primary key of the company
	 * @return the matching link crfs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.LinkCRF>
		getLinkCRFsByUuidAndCompanyId(String uuid, long companyId) {

		return _linkCRFLocalService.getLinkCRFsByUuidAndCompanyId(
			uuid, companyId);
	}

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
	@Override
	public java.util.List<ecrf.user.model.LinkCRF>
		getLinkCRFsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.LinkCRF> orderByComparator) {

		return _linkCRFLocalService.getLinkCRFsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of link crfs.
	 *
	 * @return the number of link crfs
	 */
	@Override
	public int getLinkCRFsCount() {
		return _linkCRFLocalService.getLinkCRFsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _linkCRFLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkCRFLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public ecrf.user.model.LinkCRF updateLinkCRF(
		ecrf.user.model.LinkCRF linkCRF) {

		return _linkCRFLocalService.updateLinkCRF(linkCRF);
	}

	@Override
	public ecrf.user.model.LinkCRF updateLinkCRF(
			long linkId, long subjectId, long crfId, long structuredDataId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkCRFLocalService.updateLinkCRF(
			linkId, subjectId, crfId, structuredDataId, sc);
	}

	@Override
	public LinkCRFLocalService getWrappedService() {
		return _linkCRFLocalService;
	}

	@Override
	public void setWrappedService(LinkCRFLocalService linkCRFLocalService) {
		_linkCRFLocalService = linkCRFLocalService;
	}

	private LinkCRFLocalService _linkCRFLocalService;

}