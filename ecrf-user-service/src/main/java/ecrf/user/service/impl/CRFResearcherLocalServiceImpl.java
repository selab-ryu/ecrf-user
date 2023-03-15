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

import ecrf.user.model.CRFResearcher;
import ecrf.user.service.base.CRFResearcherLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ecrf.user.model.CRFResearcher",
	service = AopService.class
)
public class CRFResearcherLocalServiceImpl
	extends CRFResearcherLocalServiceBaseImpl {
	
	public CRFResearcher addCRFResearcher(
			long researcherId, long crfId,
			ServiceContext sc) throws PortalException {
		_logger = Logger.getLogger(this.getClass().getName());
		_logger.info("Add CRFResearcher Start");
		
		long crfResearcherId = super.counterLocalService.increment();
		CRFResearcher crfResearcher = super.crfResearcherLocalService.createCRFResearcher(crfResearcherId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		// set audit fields
		crfResearcher.setGroupId(groupId);
		crfResearcher.setUserId(userId);
		crfResearcher.setUserName(user.getFullName());
		crfResearcher.setCompanyId(user.getCompanyId());
		crfResearcher.setCreateDate(sc.getCreateDate());
		crfResearcher.setModifiedDate(sc.getModifiedDate());
		crfResearcher.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		crfResearcher.setCrfId(crfId);
		crfResearcher.setResearcherId(researcherId);
		
		super.crfResearcherPersistence.update(crfResearcher);
		
		return crfResearcher;
	}
	
	public CRFResearcher deleteCRFResearcher(long crfResearcherId) throws PortalException {
		CRFResearcher crfResearcher = null;
		
		if(crfResearcherId > 0) {
			crfResearcher = super.crfResearcherLocalService.getCRFResearcher(crfResearcherId);
			super.crfResearcherPersistence.remove(crfResearcherId);
		}
		
		return crfResearcher;
	}
	
	public CRFResearcher deleteCRFResearcher(CRFResearcher crfResearcher) {
		super.crfResearcherPersistence.remove(crfResearcher);
		return crfResearcher;
	}
	
	public List<CRFResearcher> getCRFResearcherByGroupId(long groupId) {
		return super.crfResearcherPersistence.findByGroupId(groupId);
	}
	public List<CRFResearcher> getCRFResearcherByGroupId(long groupId, int start, int end) {
		return super.crfResearcherPersistence.findByGroupId(groupId, start, end);
	}
	public List<CRFResearcher> getCRFResearcherByGroupId(long groupId, int start, int end, OrderByComparator comparator) {
		return super.crfResearcherPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int getCRFResearcherCount(long groupId) {
		return super.crfResearcherPersistence.countByGroupId(groupId);
	}
	
	public List<CRFResearcher> getCRFResearcherByCRFId(long groupId, long crfId) {
		return super.crfResearcherPersistence.findByG_C(groupId, crfId);
	}
	public List<CRFResearcher> getCRFResearcherByCRFId(long groupId, long crfId, int start, int end) {
		return super.crfResearcherPersistence.findByG_C(groupId, crfId, start, end);
	}
	public List<CRFResearcher> getCRFResearcherByCRFId(long groupId, long crfId, int start, int end, OrderByComparator comparator) {
		return super.crfResearcherPersistence.findByG_C(groupId, crfId, start, end, comparator);
	}
	public int getCRFResearcherCountByCRFId(long groupId, long crfId) {
		return super.crfResearcherPersistence.countByG_C(groupId, crfId);
	}
	
	public List<CRFResearcher> getCRFResearcherByResearcherId(long groupId, long researcherId) {
		return super.crfResearcherPersistence.findByG_R(groupId, researcherId);
	}
	public List<CRFResearcher> getCRFResearcherByResearcherId(long groupId, long researcherId, int start, int end) {
		return super.crfResearcherPersistence.findByG_R(groupId, researcherId, start, end);
	}
	public List<CRFResearcher> getCRFResearcherByResearcherId(long groupId, long researcherId, int start, int end, OrderByComparator comparator) {
		return super.crfResearcherPersistence.findByG_R(groupId, researcherId, start, end, comparator);
	}
	public int getCRFResearcherCountByResearcherId(long groupId, long researcherId) {
		return super.crfResearcherPersistence.countByG_R(groupId, researcherId);
	}
	
	private Logger _logger;
}