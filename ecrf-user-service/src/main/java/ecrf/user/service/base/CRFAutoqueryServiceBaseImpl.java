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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import ecrf.user.model.CRFAutoquery;
import ecrf.user.service.CRFAutoqueryService;
import ecrf.user.service.CRFAutoqueryServiceUtil;
import ecrf.user.service.persistence.CRFAutoqueryPersistence;
import ecrf.user.service.persistence.CRFHistoryPersistence;
import ecrf.user.service.persistence.CRFPersistence;
import ecrf.user.service.persistence.CRFResearcherPersistence;
import ecrf.user.service.persistence.CRFSearchLogPersistence;
import ecrf.user.service.persistence.CRFSubjectPersistence;
import ecrf.user.service.persistence.ExperimentalGroupPersistence;
import ecrf.user.service.persistence.LinkCRFPersistence;
import ecrf.user.service.persistence.ProjectPersistence;
import ecrf.user.service.persistence.ResearcherFinder;
import ecrf.user.service.persistence.ResearcherPersistence;
import ecrf.user.service.persistence.SubjectFinder;
import ecrf.user.service.persistence.SubjectPersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the crf autoquery remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link ecrf.user.service.impl.CRFAutoqueryServiceImpl}.
 * </p>
 *
 * @author Ryu W.C.
 * @see ecrf.user.service.impl.CRFAutoqueryServiceImpl
 * @generated
 */
public abstract class CRFAutoqueryServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, CRFAutoqueryService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CRFAutoqueryService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CRFAutoqueryServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CRFAutoqueryService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		crfAutoqueryService = (CRFAutoqueryService)aopProxy;

		_setServiceUtilService(crfAutoqueryService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CRFAutoqueryService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CRFAutoquery.class;
	}

	protected String getModelClassName() {
		return CRFAutoquery.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = crfAutoqueryPersistence.getDataSource();

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

	private void _setServiceUtilService(
		CRFAutoqueryService crfAutoqueryService) {

		try {
			Field field = CRFAutoqueryServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, crfAutoqueryService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected CRFPersistence crfPersistence;

	@Reference
	protected ecrf.user.service.CRFAutoqueryLocalService
		crfAutoqueryLocalService;

	protected CRFAutoqueryService crfAutoqueryService;

	@Reference
	protected CRFAutoqueryPersistence crfAutoqueryPersistence;

	@Reference
	protected CRFHistoryPersistence crfHistoryPersistence;

	@Reference
	protected CRFResearcherPersistence crfResearcherPersistence;

	@Reference
	protected CRFSearchLogPersistence crfSearchLogPersistence;

	@Reference
	protected CRFSubjectPersistence crfSubjectPersistence;

	@Reference
	protected ExperimentalGroupPersistence experimentalGroupPersistence;

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
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

	@Reference
	protected com.liferay.ratings.kernel.service.RatingsStatsLocalService
		ratingsStatsLocalService;

	@Reference
	protected com.liferay.trash.kernel.service.TrashEntryLocalService
		trashEntryLocalService;

	@Reference
	protected com.liferay.trash.kernel.service.TrashEntryService
		trashEntryService;

	@Reference
	protected com.liferay.trash.kernel.service.TrashVersionLocalService
		trashVersionLocalService;

}