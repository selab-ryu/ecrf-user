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

import ecrf.user.model.CRFPatient;
import ecrf.user.service.CRFPatientLocalService;
import ecrf.user.service.CRFPatientLocalServiceUtil;
import ecrf.user.service.persistence.CRFPatientPersistence;
import ecrf.user.service.persistence.CRFPersistence;
import ecrf.user.service.persistence.CRFResearcherPersistence;
import ecrf.user.service.persistence.PatientPersistence;
import ecrf.user.service.persistence.ProjectPersistence;
import ecrf.user.service.persistence.ResearcherPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the crf patient local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link ecrf.user.service.impl.CRFPatientLocalServiceImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see ecrf.user.service.impl.CRFPatientLocalServiceImpl
 * @generated
 */
public abstract class CRFPatientLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CRFPatientLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CRFPatientLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CRFPatientLocalServiceUtil</code>.
	 */

	/**
	 * Adds the crf patient to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFPatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfPatient the crf patient
	 * @return the crf patient that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CRFPatient addCRFPatient(CRFPatient crfPatient) {
		crfPatient.setNew(true);

		return crfPatientPersistence.update(crfPatient);
	}

	/**
	 * Creates a new crf patient with the primary key. Does not add the crf patient to the database.
	 *
	 * @param crfPatientId the primary key for the new crf patient
	 * @return the new crf patient
	 */
	@Override
	@Transactional(enabled = false)
	public CRFPatient createCRFPatient(long crfPatientId) {
		return crfPatientPersistence.create(crfPatientId);
	}

	/**
	 * Deletes the crf patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFPatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient that was removed
	 * @throws PortalException if a crf patient with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CRFPatient deleteCRFPatient(long crfPatientId)
		throws PortalException {

		return crfPatientPersistence.remove(crfPatientId);
	}

	/**
	 * Deletes the crf patient from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFPatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfPatient the crf patient
	 * @return the crf patient that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CRFPatient deleteCRFPatient(CRFPatient crfPatient) {
		return crfPatientPersistence.remove(crfPatient);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CRFPatient.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return crfPatientPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFPatientModelImpl</code>.
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

		return crfPatientPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFPatientModelImpl</code>.
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

		return crfPatientPersistence.findWithDynamicQuery(
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
		return crfPatientPersistence.countWithDynamicQuery(dynamicQuery);
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

		return crfPatientPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CRFPatient fetchCRFPatient(long crfPatientId) {
		return crfPatientPersistence.fetchByPrimaryKey(crfPatientId);
	}

	/**
	 * Returns the crf patient matching the UUID and group.
	 *
	 * @param uuid the crf patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchCRFPatientByUuidAndGroupId(
		String uuid, long groupId) {

		return crfPatientPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the crf patient with the primary key.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient
	 * @throws PortalException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient getCRFPatient(long crfPatientId) throws PortalException {
		return crfPatientPersistence.findByPrimaryKey(crfPatientId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(crfPatientLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CRFPatient.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("crfPatientId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			crfPatientLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CRFPatient.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"crfPatientId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(crfPatientLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CRFPatient.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("crfPatientId");
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
			new ActionableDynamicQuery.PerformActionMethod<CRFPatient>() {

				@Override
				public void performAction(CRFPatient crfPatient)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, crfPatient);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(CRFPatient.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return crfPatientLocalService.deleteCRFPatient(
			(CRFPatient)persistedModel);
	}

	public BasePersistence<CRFPatient> getBasePersistence() {
		return crfPatientPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return crfPatientPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the crf patients matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf patients
	 * @param companyId the primary key of the company
	 * @return the matching crf patients, or an empty list if no matches were found
	 */
	@Override
	public List<CRFPatient> getCRFPatientsByUuidAndCompanyId(
		String uuid, long companyId) {

		return crfPatientPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of crf patients matching the UUID and company.
	 *
	 * @param uuid the UUID of the crf patients
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching crf patients, or an empty list if no matches were found
	 */
	@Override
	public List<CRFPatient> getCRFPatientsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return crfPatientPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the crf patient matching the UUID and group.
	 *
	 * @param uuid the crf patient's UUID
	 * @param groupId the primary key of the group
	 * @return the matching crf patient
	 * @throws PortalException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient getCRFPatientByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return crfPatientPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the crf patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ecrf.user.model.impl.CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of crf patients
	 */
	@Override
	public List<CRFPatient> getCRFPatients(int start, int end) {
		return crfPatientPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of crf patients.
	 *
	 * @return the number of crf patients
	 */
	@Override
	public int getCRFPatientsCount() {
		return crfPatientPersistence.countAll();
	}

	/**
	 * Updates the crf patient in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CRFPatientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crfPatient the crf patient
	 * @return the crf patient that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CRFPatient updateCRFPatient(CRFPatient crfPatient) {
		return crfPatientPersistence.update(crfPatient);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CRFPatientLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		crfPatientLocalService = (CRFPatientLocalService)aopProxy;

		_setLocalServiceUtilService(crfPatientLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CRFPatientLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CRFPatient.class;
	}

	protected String getModelClassName() {
		return CRFPatient.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = crfPatientPersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		CRFPatientLocalService crfPatientLocalService) {

		try {
			Field field = CRFPatientLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, crfPatientLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected CRFPersistence crfPersistence;

	protected CRFPatientLocalService crfPatientLocalService;

	@Reference
	protected CRFPatientPersistence crfPatientPersistence;

	@Reference
	protected CRFResearcherPersistence crfResearcherPersistence;

	@Reference
	protected PatientPersistence patientPersistence;

	@Reference
	protected ProjectPersistence projectPersistence;

	@Reference
	protected ResearcherPersistence researcherPersistence;

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

}