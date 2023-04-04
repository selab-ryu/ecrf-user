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
 * Provides a wrapper for {@link ResearcherLocalService}.
 *
 * @author Ryu W.C.
 * @see ResearcherLocalService
 * @generated
 */
public class ResearcherLocalServiceWrapper
	implements ResearcherLocalService, ServiceWrapper<ResearcherLocalService> {

	public ResearcherLocalServiceWrapper(
		ResearcherLocalService researcherLocalService) {

		_researcherLocalService = researcherLocalService;
	}

	@Override
	public ecrf.user.model.Researcher addResarcherWithUser(
			long companyId, long facebookId, String openId, String languageId,
			boolean male, String jobTitle, long prefixId, long suffixId,
			String emailAddress, String password1, String password2,
			String screenName, String firstName, String lastName, int birthYear,
			int birthMonth, int birthDay, String phone, String institution,
			String officeContact, String position, int approveStatus,
			com.liferay.portal.kernel.service.ServiceContext userServiceContext,
			com.liferay.portal.kernel.service.ServiceContext
				researcherServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.addResarcherWithUser(
			companyId, facebookId, openId, languageId, male, jobTitle, prefixId,
			suffixId, emailAddress, password1, password2, screenName, firstName,
			lastName, birthYear, birthMonth, birthDay, phone, institution,
			officeContact, position, approveStatus, userServiceContext,
			researcherServiceContext);
	}

	@Override
	public ecrf.user.model.Researcher addResearcher(
			long researcherUserId, String firstName, String lastName,
			String emailAddress, int birthYear, int birthMonth, int birthDay,
			String phone, String institution, String officeContact,
			String position, int approveStatus,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.addResearcher(
			researcherUserId, firstName, lastName, emailAddress, birthYear,
			birthMonth, birthDay, phone, institution, officeContact, position,
			approveStatus, sc);
	}

	/**
	 * Adds the researcher to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResearcherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param researcher the researcher
	 * @return the researcher that was added
	 */
	@Override
	public ecrf.user.model.Researcher addResearcher(
		ecrf.user.model.Researcher researcher) {

		return _researcherLocalService.addResearcher(researcher);
	}

	@Override
	public ecrf.user.model.Researcher changeApproveStatus(
			long researcherId, int approveStatus)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.changeApproveStatus(
			researcherId, approveStatus);
	}

	/**
	 * Creates a new researcher with the primary key. Does not add the researcher to the database.
	 *
	 * @param researcherId the primary key for the new researcher
	 * @return the new researcher
	 */
	@Override
	public ecrf.user.model.Researcher createResearcher(long researcherId) {
		return _researcherLocalService.createResearcher(researcherId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the researcher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResearcherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher that was removed
	 * @throws PortalException if a researcher with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.Researcher deleteResearcher(long researcherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.deleteResearcher(researcherId);
	}

	@Override
	public ecrf.user.model.Researcher deleteResearcher(
			long researcherId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.deleteResearcher(researcherId, sc);
	}

	/**
	 * Deletes the researcher from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResearcherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param researcher the researcher
	 * @return the researcher that was removed
	 */
	@Override
	public ecrf.user.model.Researcher deleteResearcher(
		ecrf.user.model.Researcher researcher) {

		return _researcherLocalService.deleteResearcher(researcher);
	}

	@Override
	public ecrf.user.model.Researcher deleteResearcher(
		ecrf.user.model.Researcher researcher,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _researcherLocalService.deleteResearcher(researcher, sc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _researcherLocalService.dynamicQuery();
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

		return _researcherLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ResearcherModelImpl</code>.
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

		return _researcherLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ResearcherModelImpl</code>.
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

		return _researcherLocalService.dynamicQuery(
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

		return _researcherLocalService.dynamicQueryCount(dynamicQuery);
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

		return _researcherLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ecrf.user.model.Researcher fetchResearcher(long researcherId) {
		return _researcherLocalService.fetchResearcher(researcherId);
	}

	/**
	 * Returns the researcher matching the UUID and group.
	 *
	 * @param uuid the researcher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	@Override
	public ecrf.user.model.Researcher fetchResearcherByUuidAndGroupId(
		String uuid, long groupId) {

		return _researcherLocalService.fetchResearcherByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _researcherLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _researcherLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _researcherLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _researcherLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the researcher with the primary key.
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher
	 * @throws PortalException if a researcher with the primary key could not be found
	 */
	@Override
	public ecrf.user.model.Researcher getResearcher(long researcherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.getResearcher(researcherId);
	}

	@Override
	public java.util.List<ecrf.user.model.Researcher> getResearcherByG_P(
		long groupId, String position) {

		return _researcherLocalService.getResearcherByG_P(groupId, position);
	}

	@Override
	public java.util.List<ecrf.user.model.Researcher> getResearcherByG_RU(
		long groupId, long researcherUserId) {

		return _researcherLocalService.getResearcherByG_RU(
			groupId, researcherUserId);
	}

	@Override
	public ecrf.user.model.Researcher getResearcherByG_RU_First(
		long groupId, long researcherUserId) {

		return _researcherLocalService.getResearcherByG_RU_First(
			groupId, researcherUserId);
	}

	@Override
	public java.util.List<ecrf.user.model.Researcher> getResearcherByGroupId(
		long groupId) {

		return _researcherLocalService.getResearcherByGroupId(groupId);
	}

	@Override
	public java.util.List<ecrf.user.model.Researcher> getResearcherByGroupId(
		long groupId, int start, int end) {

		return _researcherLocalService.getResearcherByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<ecrf.user.model.Researcher> getResearcherByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator comparator) {

		return _researcherLocalService.getResearcherByGroupId(
			groupId, start, end, comparator);
	}

	/**
	 * Returns the researcher matching the UUID and group.
	 *
	 * @param uuid the researcher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching researcher
	 * @throws PortalException if a matching researcher could not be found
	 */
	@Override
	public ecrf.user.model.Researcher getResearcherByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.getResearcherByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public int getResearcherCount(long groupId) {
		return _researcherLocalService.getResearcherCount(groupId);
	}

	@Override
	public int getResearcherCountByG_P(long groupId, String position) {
		return _researcherLocalService.getResearcherCountByG_P(
			groupId, position);
	}

	@Override
	public int getResearcherCountByG_RU(long groupId, long researcherUserId) {
		return _researcherLocalService.getResearcherCountByG_RU(
			groupId, researcherUserId);
	}

	/**
	 * Returns a range of all the researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @return the range of researchers
	 */
	@Override
	public java.util.List<ecrf.user.model.Researcher> getResearchers(
		int start, int end) {

		return _researcherLocalService.getResearchers(start, end);
	}

	/**
	 * Returns all the researchers matching the UUID and company.
	 *
	 * @param uuid the UUID of the researchers
	 * @param companyId the primary key of the company
	 * @return the matching researchers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.Researcher>
		getResearchersByUuidAndCompanyId(String uuid, long companyId) {

		return _researcherLocalService.getResearchersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of researchers matching the UUID and company.
	 *
	 * @param uuid the UUID of the researchers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of researchers
	 * @param end the upper bound of the range of researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching researchers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ecrf.user.model.Researcher>
		getResearchersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ecrf.user.model.Researcher> orderByComparator) {

		return _researcherLocalService.getResearchersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of researchers.
	 *
	 * @return the number of researchers
	 */
	@Override
	public int getResearchersCount() {
		return _researcherLocalService.getResearchersCount();
	}

	@Override
	public ecrf.user.model.Researcher updateResearcher(
			long researcherId, long researcherUserId, String firstName,
			String lastName, String emailAddress, int birthYear, int birthMonth,
			int birthDay, String phone, String institution,
			String officeContact, String position, int approveStatus,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _researcherLocalService.updateResearcher(
			researcherId, researcherUserId, firstName, lastName, emailAddress,
			birthYear, birthMonth, birthDay, phone, institution, officeContact,
			position, approveStatus, sc);
	}

	/**
	 * Updates the researcher in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResearcherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param researcher the researcher
	 * @return the researcher that was updated
	 */
	@Override
	public ecrf.user.model.Researcher updateResearcher(
		ecrf.user.model.Researcher researcher) {

		return _researcherLocalService.updateResearcher(researcher);
	}

	@Override
	public ResearcherLocalService getWrappedService() {
		return _researcherLocalService;
	}

	@Override
	public void setWrappedService(
		ResearcherLocalService researcherLocalService) {

		_researcherLocalService = researcherLocalService;
	}

	private ResearcherLocalService _researcherLocalService;

}