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

import ecrf.user.model.Researcher;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Researcher. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ryu W.C.
 * @see ResearcherLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ResearcherLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>ecrf.user.service.impl.ResearcherLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the researcher local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ResearcherLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Researcher addResarcherWithUser(
			long companyId, long facebookId, String openId, String languageId,
			boolean male, String jobTitle, long prefixId, long suffixId,
			String emailAddress, String password1, String password2,
			String screenName, String firstName, String lastName, int birthYear,
			int birthMonth, int birthDay, String phone, String institution,
			String officeContact, String position, int approveStatus,
			ServiceContext userServiceContext,
			ServiceContext researcherServiceContext)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public Researcher addResearcher(
			long researcherUserId, String firstName, String lastName,
			String emailAddress, int birthYear, int birthMonth, int birthDay,
			String phone, String institution, String officeContact,
			String position, int approveStatus, ServiceContext sc)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public Researcher addResearcher(Researcher researcher);

	public Researcher changeApproveStatus(long researcherId, int approveStatus)
		throws PortalException;

	/**
	 * Creates a new researcher with the primary key. Does not add the researcher to the database.
	 *
	 * @param researcherId the primary key for the new researcher
	 * @return the new researcher
	 */
	@Transactional(enabled = false)
	public Researcher createResearcher(long researcherId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Researcher deleteResearcher(long researcherId)
		throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	public Researcher deleteResearcher(long researcherId, ServiceContext sc)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Researcher deleteResearcher(Researcher researcher);

	@Indexable(type = IndexableType.DELETE)
	public Researcher deleteResearcher(
		Researcher researcher, ServiceContext sc);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ResearcherModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ResearcherModelImpl</code>.
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
	public Researcher fetchResearcher(long researcherId);

	/**
	 * Returns the researcher matching the UUID and group.
	 *
	 * @param uuid the researcher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching researcher, or <code>null</code> if a matching researcher could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Researcher fetchResearcherByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	 * Returns the researcher with the primary key.
	 *
	 * @param researcherId the primary key of the researcher
	 * @return the researcher
	 * @throws PortalException if a researcher with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Researcher getResearcher(long researcherId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Researcher> getResearcherByG_P(long groupId, String position);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Researcher> getResearcherByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Researcher> getResearcherByGroupId(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Researcher> getResearcherByGroupId(
		long groupId, int start, int end, OrderByComparator comparator);

	/**
	 * Returns the researcher matching the UUID and group.
	 *
	 * @param uuid the researcher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching researcher
	 * @throws PortalException if a matching researcher could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Researcher getResearcherByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getResearcherCount(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getResearcherCountByG_P(long groupId, String position);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Researcher> getResearchers(int start, int end);

	/**
	 * Returns all the researchers matching the UUID and company.
	 *
	 * @param uuid the UUID of the researchers
	 * @param companyId the primary key of the company
	 * @return the matching researchers, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Researcher> getResearchersByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Researcher> getResearchersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Researcher> orderByComparator);

	/**
	 * Returns the number of researchers.
	 *
	 * @return the number of researchers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getResearchersCount();

	@Indexable(type = IndexableType.REINDEX)
	public Researcher updateResearcher(
			long researcherId, long researcherUserId, String firstName,
			String lastName, String emailAddress, int birthYear, int birthMonth,
			int birthDay, String phone, String institution,
			String officeContact, String position, int approveStatus,
			ServiceContext sc)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public Researcher updateResearcher(Researcher researcher);

}