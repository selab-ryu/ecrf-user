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

import ecrf.user.model.ExperimentalGroup;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ExperimentalGroup. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ryu W.C.
 * @see ExperimentalGroupLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ExperimentalGroupLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>ecrf.user.service.impl.ExperimentalGroupLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the experimental group local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ExperimentalGroupLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the experimental group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperimentalGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experimentalGroup the experimental group
	 * @return the experimental group that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ExperimentalGroup addExperimentalGroup(
		ExperimentalGroup experimentalGroup);

	public ExperimentalGroup addExpGroup(
			String name, String abbr, String description, int type,
			ServiceContext sc)
		throws PortalException;

	/**
	 * Creates a new experimental group with the primary key. Does not add the experimental group to the database.
	 *
	 * @param experimentalGroupId the primary key for the new experimental group
	 * @return the new experimental group
	 */
	@Transactional(enabled = false)
	public ExperimentalGroup createExperimentalGroup(long experimentalGroupId);

	/**
	 * Deletes the experimental group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperimentalGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experimentalGroup the experimental group
	 * @return the experimental group that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ExperimentalGroup deleteExperimentalGroup(
		ExperimentalGroup experimentalGroup);

	/**
	 * Deletes the experimental group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperimentalGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group that was removed
	 * @throws PortalException if a experimental group with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ExperimentalGroup deleteExperimentalGroup(long experimentalGroupId)
		throws PortalException;

	public ExperimentalGroup deleteExpGroup(long expGroupId);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ExperimentalGroupModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ExperimentalGroupModelImpl</code>.
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
	public ExperimentalGroup fetchExperimentalGroup(long experimentalGroupId);

	/**
	 * Returns the experimental group matching the UUID and group.
	 *
	 * @param uuid the experimental group's UUID
	 * @param groupId the primary key of the group
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExperimentalGroup fetchExperimentalGroupByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the experimental group with the primary key.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group
	 * @throws PortalException if a experimental group with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExperimentalGroup getExperimentalGroup(long experimentalGroupId)
		throws PortalException;

	/**
	 * Returns the experimental group matching the UUID and group.
	 *
	 * @param uuid the experimental group's UUID
	 * @param groupId the primary key of the group
	 * @return the matching experimental group
	 * @throws PortalException if a matching experimental group could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExperimentalGroup getExperimentalGroupByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of experimental groups
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ExperimentalGroup> getExperimentalGroups(int start, int end);

	/**
	 * Returns all the experimental groups matching the UUID and company.
	 *
	 * @param uuid the UUID of the experimental groups
	 * @param companyId the primary key of the company
	 * @return the matching experimental groups, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ExperimentalGroup> getExperimentalGroupsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of experimental groups matching the UUID and company.
	 *
	 * @param uuid the UUID of the experimental groups
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching experimental groups, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ExperimentalGroup> getExperimentalGroupsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator);

	/**
	 * Returns the number of experimental groups.
	 *
	 * @return the number of experimental groups
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getExperimentalGroupsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExperimentalGroup getExpGroupByG_N(long groupId, String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ExperimentalGroup> getExpGroupByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ExperimentalGroup> getExpGroupByName(String name);

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
	 * Updates the experimental group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperimentalGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experimentalGroup the experimental group
	 * @return the experimental group that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ExperimentalGroup updateExperimentalGroup(
		ExperimentalGroup experimentalGroup);

	public ExperimentalGroup updateExpGroup(
			long expGroupId, String name, String abbr, String description,
			int type, ServiceContext sc)
		throws PortalException;

}