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

package ecrf.user.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import ecrf.user.model.CRFSubject;
import ecrf.user.service.CRFSubjectLocalService;
import ecrf.user.service.persistence.CRFAutoqueryPersistence;
import ecrf.user.service.persistence.CRFHistoryPersistence;
import ecrf.user.service.persistence.CRFPersistence;
import ecrf.user.service.persistence.CRFResearcherPersistence;
import ecrf.user.service.persistence.CRFSearchLogPersistence;
import ecrf.user.service.persistence.CRFSubjectPersistence;
import ecrf.user.service.persistence.LinkCRFPersistence;
import ecrf.user.service.persistence.ProjectPersistence;
import ecrf.user.service.persistence.ResearcherFinder;
import ecrf.user.service.persistence.ResearcherPersistence;
import ecrf.user.service.persistence.SubjectFinder;
import ecrf.user.service.persistence.SubjectPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the crf subject local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link ecrf.user.service.impl.CRFSubjectLocalServiceImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see ecrf.user.service.impl.CRFSubjectLocalServiceImpl
 * @generated
 */
public abstract class CRFSubjectLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CRFSubjectLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CRFSubjectLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ecrf.user.service.CRFSubjectLocalServiceUtil</code>.
	 */

	/**
	 * Adds the crf subject to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSubject the crf subject
	 * @return the crf subject that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CRFSubject addCRFSubject(CRFSubject crfSubject) {
		crfSubject.setNew(true);

		return crfSubjectPersistence.update(crfSubject);
	}

	/**
	 * Creates a new crf subject with the primary key. Does not add the crf subject to the database.
	 *
	 * @param crfSubjectId the primary key for the new crf subject
	 * @return the new crf subject
	 */
	@Override
	@Transactional(enabled = false)
	public CRFSubject createCRFSubject(long crfSubjectId) {
		return crfSubjectPersistence.create(crfSubjectId);
	}

	/**
	 * Deletes the crf subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject that was removed
	 * @throws PortalException if a crf subject with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CRFSubject deleteCRFSubject(long crfSubjectId)
		throws PortalException {

		return crfSubjectPersistence.remove(crfSubjectId);
	}

	/**
	 * Deletes the crf subject from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSubject the crf subject
	 * @return the crf subject that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CRFSubject deleteCRFSubject(CRFSubject crfSubject) {
		return crfSubjectPersistence.remove(crfSubject);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CRFSubject.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return crfSubjectPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return crfSubjectPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return crfSubjectPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return crfSubjectPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return crfSubjectPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CRFSubject fetchCRFSubject(long crfSubjectId) {
		return crfSubjectPersistence.fetchByPrimaryKey(crfSubjectId);
	}

	/**
	 * Returns the crf subject matching the UUID and group.
	 *
	 * @param uuid the crf subject's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchCRFSubjectByUuidAndGroupId(
		String uuid, long groupId) {

		return crfSubjectPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf subject with the primary key.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject
	 * @throws PortalException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject getCRFSubject(long crfSubjectId) throws PortalException {
		return crfSubjectPersistence.findByPrimaryKey(crfSubjectId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(crfSubjectLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CRFSubject.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("crfSubjectId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			crfSubjectLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CRFSubject.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"crfSubjectId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(crfSubjectLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CRFSubject.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("crfSubjectId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CRFSubject>() {

				@Override
				public void performAction(CRFSubject crfSubject)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, crfSubject);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(CRFSubject.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return crfSubjectLocalService.deleteCRFSubject(
			(CRFSubject)persistedModel);
	}

	public BasePersistence<CRFSubject> getBasePersistence() {
		return crfSubjectPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return crfSubjectPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the crf subjects matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf subjects
	 * @param companyId the primary key of the company
	 * @return the matching crf subjects, or an empty list if no matches were found
	 */
	@Override
	public List<CRFSubject> getCRFSubjectsByUuidAndCompanyId(
		String uuid, long companyId) {

		return crfSubjectPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of crf subjects matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf subjects
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crf subjects, or an empty list if no matches were found
	 */
	@Override
	public List<CRFSubject> getCRFSubjectsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return crfSubjectPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the crf subject matching the UUID and group.
	 *
	 * @param uuid the crf subject's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf subject
	 * @throws PortalException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject getCRFSubjectByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return crfSubjectPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the crf subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of crf subjects
	 */
	@Override
	public List<CRFSubject> getCRFSubjects(int start, int end) {
		return crfSubjectPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of crf subjects.
	 *
	 * @return the number of crf subjects
	 */
	@Override
	public int getCRFSubjectsCount() {
		return crfSubjectPersistence.countAll();
	}

	/**
	 * Updates the crf subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSubject the crf subject
	 * @return the crf subject that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CRFSubject updateCRFSubject(CRFSubject crfSubject) {
		return crfSubjectPersistence.update(crfSubject);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CRFSubjectLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		crfSubjectLocalService = (CRFSubjectLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CRFSubjectLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CRFSubject.class;
	}

	protected String getModelClassName() {
		return CRFSubject.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = crfSubjectPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected CRFPersistence crfPersistence;

	@Reference
	protected CRFAutoqueryPersistence crfAutoqueryPersistence;

	@Reference
	protected CRFHistoryPersistence crfHistoryPersistence;

	@Reference
	protected CRFResearcherPersistence crfResearcherPersistence;

	@Reference
	protected CRFSearchLogPersistence crfSearchLogPersistence;

	protected CRFSubjectLocalService crfSubjectLocalService;

	@Reference
	protected CRFSubjectPersistence crfSubjectPersistence;

	@Reference
	protected LinkCRFPersistence linkCRFPersistence;

	@Reference
	protected ProjectPersistence projectPersistence;

	@Reference
	protected ResearcherPersistence researcherPersistence;

	@Reference
	protected ResearcherFinder researcherFinder;

	@Reference
	protected SubjectPersistence subjectPersistence;

	@Reference
	protected SubjectFinder subjectFinder;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.ratings.kernel.service.RatingsStatsLocalService
		ratingsStatsLocalService;

	@Reference
	protected com.liferay.trash.kernel.service.TrashEntryLocalService
		trashEntryLocalService;

	@Reference
	protected com.liferay.trash.kernel.service.TrashVersionLocalService
		trashVersionLocalService;

}