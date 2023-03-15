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

package ecrf.user.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.logging.Logger;

import org.osgi.service.component.annotations.Component;

import ecrf.user.model.CRFPatient;
import ecrf.user.service.base.CRFPatientLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ecrf.user.model.CRFPatient",
	service = AopService.class
)
public class CRFPatientLocalServiceImpl extends CRFPatientLocalServiceBaseImpl {
	public CRFPatient addCRFPatient(
			long crfId, long patientId,
			ServiceContext sc) throws PortalException {
		_logger = Logger.getLogger(this.getClass().getName());
		_logger.info("Add CRFPatient Start");
		
		long crfPatientId = super.counterLocalService.increment();
		CRFPatient crfPatient = super.crfPatientLocalService.createCRFPatient(crfPatientId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		// set audit fields
		crfPatient.setGroupId(groupId);
		crfPatient.setUserId(userId);
		crfPatient.setUserName(user.getFullName());
		crfPatient.setCompanyId(user.getCompanyId());
		crfPatient.setCreateDate(sc.getCreateDate());
		crfPatient.setModifiedDate(sc.getModifiedDate());
		crfPatient.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		crfPatient.setCrfId(crfId);
		crfPatient.setPatientId(crfPatientId);
		
		// other liferay frameworks
		
		super.crfPatientPersistence.update(crfPatient);
		
		return crfPatient;
	}
	
	public CRFPatient deleteCRFPatient(long crfPatientId) throws PortalException {
		CRFPatient crfPatient = null;
		
		if(crfPatientId > 0) {
			crfPatient = super.crfPatientLocalService.getCRFPatient(crfPatientId);
			super.crfPatientPersistence.remove(crfPatientId);
		}
		
		return crfPatient;
	}
	
	public CRFPatient deleteCRFPatient(CRFPatient crfPatient) {
		super.crfPatientPersistence.remove(crfPatient);
		return crfPatient;
	}
	
	public List<CRFPatient> getCRFPatientByGroupId(long groupId) {
		return super.crfPatientPersistence.findByGroupId(groupId);
	}
	public List<CRFPatient> getCRFPatientByGroupId(long groupId, int start, int end) {
		return super.crfPatientPersistence.findByGroupId(groupId, start, end);
	}
	public List<CRFPatient> getCRFPatientByGroupId(long groupId, int start, int end, OrderByComparator comparator) {
		return super.crfPatientPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int getCRFPatientCountByGroupId(long groupId) {
		return super.crfPatientPersistence.countByGroupId(groupId);
	}
	
	public List<CRFPatient> getCRFPatientByCRFId(long groupId, long crfId) {
		return super.crfPatientPersistence.findByG_C(groupId, crfId);
	}
	public List<CRFPatient> getCRFPatientByCRFId(long groupId, long crfId, int start, int end) {
		return super.crfPatientPersistence.findByG_C(groupId, crfId, start, end);
	}
	public List<CRFPatient> getCRFPatientByCRFId(long groupId, long crfId, int start, int end, OrderByComparator comparator) {
		return super.crfPatientPersistence.findByG_C(groupId, crfId, start, end, comparator);
	}
	public int getCRFPatientCountByCRFId(long groupId, long crfId) {
		return super.crfPatientPersistence.countByG_C(groupId, crfId);
	}
	
	public List<CRFPatient> getCRFPatientByPatientId(long groupId, long patientId) {
		return super.crfPatientPersistence.findByG_PA(groupId, patientId);
	}
	public List<CRFPatient> getCRFPatientByPatientId(long groupId, long patientId, int start, int end) {
		return super.crfPatientPersistence.findByG_PA(groupId, patientId, start, end);
	}
	public List<CRFPatient> getCRFPatientByPatientId(long groupId, long patientId, int start, int end, OrderByComparator comparator) {
		return super.crfPatientPersistence.findByG_PA(groupId, patientId, start, end, comparator);
	}
	public int getCRFPatientCountByPatientId(long groupId, long patientId) {
		return super.crfPatientPersistence.countByG_PA(groupId, patientId);
	}
	
	private Logger _logger;
}