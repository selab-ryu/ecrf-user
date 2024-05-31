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

import ecrf.user.model.CRFSearchLog;
import ecrf.user.service.CRFSearchLogLocalService;
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
 * Provides the base implementation for the crf search log local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link ecrf.user.service.impl.CRFSearchLogLocalServiceImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see ecrf.user.service.impl.CRFSearchLogLocalServiceImpl
 * @generated
 */
public abstract class CRFSearchLogLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CRFSearchLogLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CRFSearchLogLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ecrf.user.service.CRFSearchLogLocalServiceUtil</code>.
	 */

	/**
	 * Adds the crf search log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSearchLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSearchLog the crf search log
	 * @return the crf search log that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CRFSearchLog addCRFSearchLog(CRFSearchLog crfSearchLog) {
		crfSearchLog.setNew(true);

		return crfSearchLogPersistence.update(crfSearchLog);
	}

	/**
	 * Creates a new crf search log with the primary key. Does not add the crf search log to the database.
	 *
	 * @param searchLogId the primary key for the new crf search log
	 * @return the new crf search log
	 */
	@Override
	@Transactional(enabled = false)
	public CRFSearchLog createCRFSearchLog(long searchLogId) {
		return crfSearchLogPersistence.create(searchLogId);
	}

	/**
	 * Deletes the crf search log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSearchLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log that was removed
	 * @throws PortalException if a crf search log with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CRFSearchLog deleteCRFSearchLog(long searchLogId)
		throws PortalException {

		return crfSearchLogPersistence.remove(searchLogId);
	}

	/**
	 * Deletes the crf search log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSearchLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSearchLog the crf search log
	 * @return the crf search log that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CRFSearchLog deleteCRFSearchLog(CRFSearchLog crfSearchLog) {
		return crfSearchLogPersistence.remove(crfSearchLog);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CRFSearchLog.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return crfSearchLogPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSearchLogModelImpl</code>.
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

		return crfSearchLogPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSearchLogModelImpl</code>.
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

		return crfSearchLogPersistence.findWithDynamicQuery(
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
		return crfSearchLogPersistence.countWithDynamicQuery(dynamicQuery);
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

		return crfSearchLogPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CRFSearchLog fetchCRFSearchLog(long searchLogId) {
		return crfSearchLogPersistence.fetchByPrimaryKey(searchLogId);
	}

	/**
	 * Returns the crf search log matching the UUID and group.
	 *
	 * @param uuid the crf search log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog fetchCRFSearchLogByUuidAndGroupId(
		String uuid, long groupId) {

		return crfSearchLogPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf search log with the primary key.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log
	 * @throws PortalException if a crf search log with the primary key could not be found
	 */
	@Override
	public CRFSearchLog getCRFSearchLog(long searchLogId)
		throws PortalException {

		return crfSearchLogPersistence.findByPrimaryKey(searchLogId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(crfSearchLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CRFSearchLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("searchLogId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			crfSearchLogLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CRFSearchLog.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"searchLogId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(crfSearchLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CRFSearchLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("searchLogId");
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
			new ActionableDynamicQuery.PerformActionMethod<CRFSearchLog>() {

				@Override
				public void performAction(CRFSearchLog crfSearchLog)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, crfSearchLog);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(CRFSearchLog.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return crfSearchLogLocalService.deleteCRFSearchLog(
			(CRFSearchLog)persistedModel);
	}

	public BasePersistence<CRFSearchLog> getBasePersistence() {
		return crfSearchLogPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return crfSearchLogPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the crf search logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf search logs
	 * @param companyId the primary key of the company
	 * @return the matching crf search logs, or an empty list if no matches were found
	 */
	@Override
	public List<CRFSearchLog> getCRFSearchLogsByUuidAndCompanyId(
		String uuid, long companyId) {

		return crfSearchLogPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of crf search logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf search logs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crf search logs, or an empty list if no matches were found
	 */
	@Override
	public List<CRFSearchLog> getCRFSearchLogsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		return crfSearchLogPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the crf search log matching the UUID and group.
	 *
	 * @param uuid the crf search log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf search log
	 * @throws PortalException if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog getCRFSearchLogByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return crfSearchLogPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of crf search logs
	 */
	@Override
	public List<CRFSearchLog> getCRFSearchLogs(int start, int end) {
		return crfSearchLogPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of crf search logs.
	 *
	 * @return the number of crf search logs
	 */
	@Override
	public int getCRFSearchLogsCount() {
		return crfSearchLogPersistence.countAll();
	}

	/**
	 * Updates the crf search log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFSearchLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfSearchLog the crf search log
	 * @return the crf search log that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CRFSearchLog updateCRFSearchLog(CRFSearchLog crfSearchLog) {
		return crfSearchLogPersistence.update(crfSearchLog);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CRFSearchLogLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		crfSearchLogLocalService = (CRFSearchLogLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CRFSearchLogLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CRFSearchLog.class;
	}

	protected String getModelClassName() {
		return CRFSearchLog.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = crfSearchLogPersistence.getDataSource();

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

	protected CRFSearchLogLocalService crfSearchLogLocalService;

	@Reference
	protected CRFSearchLogPersistence crfSearchLogPersistence;

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