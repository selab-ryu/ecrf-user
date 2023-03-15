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
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.CRF;
import ecrf.user.model.CRFPatient;
import ecrf.user.model.CRFResearcher;
import ecrf.user.service.CRFPatientLocalService;
import ecrf.user.service.CRFResearcherLocalService;
import ecrf.user.service.base.CRFLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ecrf.user.model.CRF",
	service = AopService.class
)
public class CRFLocalServiceImpl extends CRFLocalServiceBaseImpl {
	public CRF addCRF(
			String title, long managerId,
			int applyDateYear, int applyDateMonth, int applyDateDay,
			int crfStatus,
			ServiceContext sc) throws PortalException {
		_logger = Logger.getLogger(this.getClass().getName());
		_logger.info("Add CRF Start");
		
		long crfId = super.counterLocalService.increment();
		CRF crf = super.crfLocalService.createCRF(crfId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date applyDate = PortalUtil.getDate(applyDateMonth, applyDateDay, applyDateYear);
		
		// set audit fields
		crf.setGroupId(groupId);
		crf.setUserId(userId);
		crf.setUserName(user.getFullName());
		crf.setCompanyId(user.getCompanyId());
		crf.setCreateDate(sc.getCreateDate());
		crf.setModifiedDate(sc.getModifiedDate());
		crf.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		//crf.setDatatypeId(datatypeId);
		crf.setManagerId(managerId);
		crf.setApplyDate(applyDate);
		crf.setCrfStatus(crfStatus);
		
		// other liferay frameworks
		
		super.crfPersistence.update(crf);
		
		return crf;
	}
	
	public CRF updateCRF(
			long crfId, String title, long managerId,
			int applyDateYear, int applyDateMonth, int applyDateDay,
			int crfStatus,
			ServiceContext sc) throws PortalException {
		_logger = Logger.getLogger(this.getClass().getName());
		_logger.info("Add CRF Start");
		
		CRF crf = super.crfLocalService.createCRF(crfId);
		
		Date applyDate = PortalUtil.getDate(applyDateMonth, applyDateDay, applyDateYear);
		
		// set audit fields
		crf.setModifiedDate(sc.getModifiedDate());
		crf.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		crf.setManagerId(managerId);
		crf.setApplyDate(applyDate);
		crf.setCrfStatus(crfStatus);
		
		// other liferay frameworks
		
		super.crfPersistence.update(crf);
		
		return crf;
	}
	
	public CRF deleteCRF(long crfId, ServiceContext sc) throws PortalException {
		CRF crf = null;
		
		if(crfId > 0) {
			crf = super.crfLocalService.getCRF(crfId);
			super.crfPersistence.remove(crfId);
			
			List<CRFResearcher> crfResearcherList = _crfResearcherLocalService.getCRFResearcherByCRFId(sc.getScopeGroupId(), crfId);
			for (CRFResearcher crfResearcher : crfResearcherList) {
				_crfResearcherLocalService.deleteCRFResearcher(crfResearcher);
			}
			
			List<CRFPatient> crfPatientList = _crfPatientLocalService.getCRFPatientByCRFId(sc.getScopeGroupId(), crfId);
			for (CRFPatient crfPatient : crfPatientList) {
				_crfPatientLocalService.deleteCRFPatient(crfPatient);
			}
		}
		
		return crf;
	}
	
	public CRF deleteCRF(CRF crf, ServiceContext sc) {
		super.crfPersistence.remove(crf);
		
		List<CRFResearcher> crfResearcherList = _crfResearcherLocalService.getCRFResearcherByCRFId(sc.getScopeGroupId(), crf.getCrfId());
		for (CRFResearcher crfResearcher : crfResearcherList) {
			_crfResearcherLocalService.deleteCRFResearcher(crfResearcher);
		}
		
		List<CRFPatient> crfPatientList = _crfPatientLocalService.getCRFPatientByCRFId(sc.getScopeGroupId(), crf.getCrfId());
		for (CRFPatient crfPatient : crfPatientList) {
			_crfPatientLocalService.deleteCRFPatient(crfPatient);
		}
		
		return crf;
	}
	
	public List<CRF> getCRFByGroupId(long groupId) {
		return super.crfPersistence.findByGroupId(groupId);
	}
	public List<CRF> getCRFByGroupId(long groupId, int start, int end) {
		return super.crfPersistence.findByGroupId(groupId, start, end);
	}
	public List<CRF> getCRFByGroupId(long groupId, int start, int end, OrderByComparator comparator) {
		return super.crfPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int getCRFCount(long groupId) {
		return super.crfPersistence.countByGroupId(groupId);
	}
	
	public List<CRF> getCRFByManagerId(long groupId, long managerId) {
		return super.crfPersistence.findByG_M(groupId, managerId);
	}
	public List<CRF> getCRFByManagerId(long groupId, long managerId, int start, int end) {
		return super.crfPersistence.findByG_M(groupId, managerId, start, end);
	}
	public List<CRF> getCRFByManagerId(long groupId, long managerId, int start, int end, OrderByComparator comparator) {
		return super.crfPersistence.findByG_M(groupId, managerId, start, end, comparator);
	}
	public int getCRFCountByManagerId(long groupId, long managerId) {
		return super.crfPersistence.countByG_M(groupId, managerId);
	}
	
	public CRF updateManager(long crfId, long managerId, ServiceContext sc) throws PortalException {
		_logger = Logger.getLogger(this.getClass().getName());
		_logger.info("Update Manager ID Start");
		
		CRF crf = super.crfLocalService.getCRF(crfId);
		
		crf.setModifiedDate(sc.getModifiedDate());
		crf.setExpandoBridgeAttributes(sc);
		
		if(managerId > 0) {
			crf.setManagerId(managerId);
		} else {
			crf.setManagerId(0);	// 0 or null?
		}
		
		super.crfPersistence.update(crf);
		
		return crf;
	}
	
	@Reference
	private CRFPatientLocalService _crfPatientLocalService;
	
	@Reference
	private CRFResearcherLocalService _crfResearcherLocalService;
	
	private Logger _logger;
}