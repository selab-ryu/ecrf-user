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

import ecrf.user.model.Researcher;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Researcher. This utility wraps
 * <code>ecrf.user.service.impl.ResearcherLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryu W.C.
 * @see ResearcherLocalService
 * @generated
 */
public class ResearcherLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.ResearcherLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Researcher addResarcherWithUser(
			long companyId, long facebookId, String openId, String languageId,
			boolean male, String jobTitle, long prefixId, long suffixId,
			String emailAddress, String password1, String password2,
			String screenName, String firstName, String lastName, int birthYear,
			int birthMonth, int birthDay, String phone, String institution,
			String officeContact, String position, int approveStatus,
			com.liferay.portal.kernel.service.ServiceContext userServiceContext,
			com.liferay.portal.kernel.service.ServiceContext
				researcherServiceContext)
		throws PortalException {

		return getService().addResarcherWithUser(
			companyId, facebookId, openId, languageId, male, jobTitle, prefixId,
			suffixId, emailAddress, password1, password2, screenName, firstName,
			lastName, birthYear, birthMonth, birthDay, phone, institution,
			officeContact, position, approveStatus, userServiceContext,
			researcherServiceContext);
	}

	public static Researcher addResearcher(
			long researcherUserId, String firstName, String lastName,
			String emailAddress, int birthYear, int birthMonth, int birthDay,
			String phone, String institution, String officeContact,
			String position, int approveStatus,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addResearcher(
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
	public static Researcher addResearcher(Researcher researcher) {
		return getService().addResearcher(researcher);
	}

	public static Researcher changeApproveStatus(
			long researcherId, int approveStatus)
		throws PortalException {

		return getService().changeApproveStatus(researcherId, approveStatus);
	}

	/**
	 * Creates a new researcher with the primary key. Does not add the researcher to the database.
	 *
	 * @param researcherId the primary key for the new researcher
	 * @return the new researcher
	 */
	public static Researcher createResearcher(long researcherId) {
		return getService().createResearcher(researcherId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Researcher deleteResearcher(long researcherId)
		throws PortalException {

		return getService().deleteResearcher(researcherId);
	}

	public static Researcher deleteResearcher(
			long researcherId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().deleteResearcher(researcherId, sc);
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
	public static Researcher deleteResearcher(Researcher researcher) {
		return getService().deleteResearcher(researcher);
	}

	public static Researcher deleteResearcher(
		Researcher researcher,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().deleteResearcher(researcher, sc);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ResearcherModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ResearcherModelImpl</code>.
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

	public static Researcher fetchResearcher(long researcherId) {
		return getService().fetchResearcher(researcherId);
	}

	/**
	 * Returns the researcher matching the UUID and group.
	 *
	 * @param uuid the researcher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	public static Researcher fetchResearcherByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchResearcherByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the researcher with the primary key.
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher
	 * @throws PortalException if a researcher with the primary key could not be found
	 */
	public static Researcher getResearcher(long researcherId)
		throws PortalException {

		return getService().getResearcher(researcherId);
	}

	public static List<Researcher> getResearcherByG_P(
		long groupId, String position) {

		return getService().getResearcherByG_P(groupId, position);
	}

	public static List<Researcher> getResearcherByG_RU(
		long groupId, long researcherUserId) {

		return getService().getResearcherByG_RU(groupId, researcherUserId);
	}

	public static List<Researcher> getResearcherByGroupId(long groupId) {
		return getService().getResearcherByGroupId(groupId);
	}

	public static List<Researcher> getResearcherByGroupId(
		long groupId, int start, int end) {

		return getService().getResearcherByGroupId(groupId, start, end);
	}

	public static List<Researcher> getResearcherByGroupId(
		long groupId, int start, int end, OrderByComparator comparator) {

		return getService().getResearcherByGroupId(
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
	public static Researcher getResearcherByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getResearcherByUuidAndGroupId(uuid, groupId);
	}

	public static int getResearcherCount(long groupId) {
		return getService().getResearcherCount(groupId);
	}

	public static int getResearcherCountByG_P(long groupId, String position) {
		return getService().getResearcherCountByG_P(groupId, position);
	}

	public static int getResearcherCountByG_RU(
		long groupId, long researcherUserId) {

		return getService().getResearcherCountByG_RU(groupId, researcherUserId);
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
	public static List<Researcher> getResearchers(int start, int end) {
		return getService().getResearchers(start, end);
	}

	/**
	 * Returns all the researchers matching the UUID and company.
	 *
	 * @param uuid the UUID of the researchers
	 * @param companyId the primary key of the company
	 * @return the matching researchers, or an empty list if no matches were found
	 */
	public static List<Researcher> getResearchersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getResearchersByUuidAndCompanyId(uuid, companyId);
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
	public static List<Researcher> getResearchersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Researcher> orderByComparator) {

		return getService().getResearchersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of researchers.
	 *
	 * @return the number of researchers
	 */
	public static int getResearchersCount() {
		return getService().getResearchersCount();
	}

	public static Researcher updateResearcher(
			long researcherId, long researcherUserId, String firstName,
			String lastName, String emailAddress, int birthYear, int birthMonth,
			int birthDay, String phone, String institution,
			String officeContact, String position, int approveStatus,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateResearcher(
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
	public static Researcher updateResearcher(Researcher researcher) {
		return getService().updateResearcher(researcher);
	}

	public static ResearcherLocalService getService() {
		return _service;
	}

	private static volatile ResearcherLocalService _service;

}