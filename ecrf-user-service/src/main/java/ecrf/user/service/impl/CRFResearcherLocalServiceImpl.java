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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;

import ecrf.user.exception.NoSuchCRFResearcherException;
import ecrf.user.exception.NoSuchResearcherException;
import ecrf.user.model.CRFResearcher;
import ecrf.user.model.Researcher;
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
			long researcherId, long crfId, String jobTitle,
			ServiceContext sc) throws PortalException {
		_log.info("Add CRFResearcher Start");
		
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
		
		// set entity fields
		crfResearcher.setCrfId(crfId);
		crfResearcher.setResearcherId(researcherId);
		
		crfResearcher.setExpandoBridgeAttributes(sc);
		
		super.crfResearcherPersistence.update(crfResearcher);
		
		resourceLocalService.addResources(crfResearcher.getCompanyId(), groupId, userId,
			CRFResearcher.class.getName(), crfResearcherId,
			false, true, true);
		
		return crfResearcher;
	}
	
	public void updateCRFResearchers(long crfId, ArrayList<CRFResearcher> crfResearcherList, ServiceContext sc) throws PortalException {
		_log.info("Service : Update CRF-Researcher List by infoList");
		
		long groupId = sc.getScopeGroupId();
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		
		Date now = new Date();
		
		_log.info("group : " + groupId);
		_log.info("user : " + userId);
		
		ArrayList<CRFResearcher> wholeCRFResearcherList = new ArrayList<CRFResearcher>();
		wholeCRFResearcherList.addAll(super.crfResearcherPersistence.findByG_C(groupId, crfId));
		
		for(CRFResearcher crfResearcher : crfResearcherList) {
			_log.info(crfResearcher.toString());
			
			long researcherId = crfResearcher.getResearcherId();
			String jobTitle = crfResearcher.getJobTitle();
			// compare current crf-researcher vs new crf-researcher (current : new)
			Optional<CRFResearcher> crfResearcherOpt = wholeCRFResearcherList.stream()
					.filter(x -> x.getResearcherId() == researcherId)
					.findFirst();
			
			// if matched (o:o) : update info [jobTitle]
			if(crfResearcherOpt.isPresent()) {
				CRFResearcher tempCRFResearcher = crfResearcherOpt.get();
				tempCRFResearcher.setJobTitle(jobTitle);
				super.crfResearcherPersistence.update(tempCRFResearcher);
				// remove matched item from wholeList => only not matched item remained in whole list after iterate
				wholeCRFResearcherList.remove(tempCRFResearcher);
			} else {	// if new (x:o) : add
				long crfResearcherId = super.counterLocalService.increment();
				CRFResearcher tempCRFResearcher = super.crfResearcherLocalService.createCRFResearcher(crfResearcherId);
				
				// set attribute
				tempCRFResearcher.setCompanyId(user.getCompanyId());
				tempCRFResearcher.setGroupId(groupId);
				tempCRFResearcher.setUserId(userId);
				tempCRFResearcher.setUserName(user.getFirstName());
				tempCRFResearcher.setCreateDate(now);
				tempCRFResearcher.setModifiedDate(now);
				
				tempCRFResearcher.setCrfId(crfId);
				tempCRFResearcher.setResearcherId(researcherId);
				tempCRFResearcher.setJobTitle(jobTitle);
				
				super.crfResearcherPersistence.update(tempCRFResearcher);
			}
		}
		
		// if not matched (o:x) : delete
		// remained whole list item is not matched item
		for(CRFResearcher crfResearcher : wholeCRFResearcherList) {
			this.deleteCRFResearcher(crfResearcher.getCrfResearcherId());
		}
	}
	
	public CRFResearcher deleteCRFResearcher(long crfResearcherId) throws PortalException {
		CRFResearcher crfResearcher = null;
		
		if(crfResearcherId > 0) {
			crfResearcher = super.crfResearcherLocalService.getCRFResearcher(crfResearcherId);
			super.crfResearcherPersistence.remove(crfResearcherId);
			
			resourceLocalService.deleteResource(
				crfResearcher.getCompanyId(), CRFResearcher.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, crfResearcher.getCrfResearcherId());
		}
		
		// remove crf query => nope
		// TODO : update crf query status
		
		return crfResearcher;
	}
	
	public CRFResearcher deleteCRFResearcher(CRFResearcher crfResearcher) {
		super.crfResearcherPersistence.remove(crfResearcher);
		
		try {
			resourceLocalService.deleteResource(
				crfResearcher.getCompanyId(), CRFResearcher.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, crfResearcher.getCrfResearcherId());
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		// remove crf query => nope
		// TODO : update crf query status
		
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
	
	public List<CRFResearcher> getCRFResearcherByG_C(long groupId, long crfId) {
		return super.crfResearcherPersistence.findByG_C(groupId, crfId);
	}
	public List<CRFResearcher> getCRFResearcherByG_C(long groupId, long crfId, int start, int end) {
		return super.crfResearcherPersistence.findByG_C(groupId, crfId, start, end);
	}
	public List<CRFResearcher> getCRFResearcherByG_C(long groupId, long crfId, int start, int end, OrderByComparator comparator) {
		return super.crfResearcherPersistence.findByG_C(groupId, crfId, start, end, comparator);
	}
	public int countCRFResearcherByG_C(long groupId, long crfId) {
		return super.crfResearcherPersistence.countByG_C(groupId, crfId);
	}
	
	public List<CRFResearcher> getCRFResearcherByG_R(long groupId, long researcherId) {
		return super.crfResearcherPersistence.findByG_R(groupId, researcherId);
	}
	public List<CRFResearcher> getCRFResearcherByG_R(long groupId, long researcherId, int start, int end) {
		return super.crfResearcherPersistence.findByG_R(groupId, researcherId, start, end);
	}
	public List<CRFResearcher> getCRFResearcherByG_R(long groupId, long researcherId, int start, int end, OrderByComparator comparator) {
		return super.crfResearcherPersistence.findByG_R(groupId, researcherId, start, end, comparator);
	}
	public int countCRFResearcherByG_R(long groupId, long researcherId) {
		return super.crfResearcherPersistence.countByG_R(groupId, researcherId);
	}
	
	public List<CRFResearcher> getCRFResearcherByResearcherId(long researcherId) {
		return super.crfResearcherPersistence.findByResearcherId(researcherId);
	}
	
	public List<CRFResearcher> getCRFResearcherByCRFId(long crfId) {
		return super.crfResearcherPersistence.findByCRFId(crfId);
	}
	
	public boolean isResearcherInCRF(long crfId, long userId) {
		boolean isIn = false;
		Researcher researcher;
		try {
			researcher = super.researcherPersistence.findByResearcherUserId(userId);
			
			if(Validator.isNotNull(researcher)) {
				CRFResearcher cr = this.getCRFResearcherByC_R(crfId, researcher.getResearcherId());
				if(Validator.isNotNull(cr)) isIn = true;
			}
		} catch (Exception e) {
			try {
				User user = userLocalService.getUser(userId);
				
				boolean isAdmin = false;
				
				//check user roles
				if(user != null) {
					List<Role> roleList = user.getRoles();
					for(int i=0; i<roleList.size(); i++) {
						Role role = roleList.get(i);
						if(role.getName().equals("Administrator")) isAdmin = true;
					}
				}
				
				if(!isAdmin) {
					_log.error(e.getMessage());
				}
			} catch (PortalException pe) {
				_log.error(pe.getMessage());
			}
			
			return false;
		}
		
		return isIn;
	}
	
	public CRFResearcher getCRFResearcherByC_R(long crfId, long researcherId) {
		try {
			return super.crfResearcherPersistence.findByC_R(crfId, researcherId);
		} catch (NoSuchCRFResearcherException e) {
			_log.error(e.getMessage());
		}
		return null;
	}
	
	private Log _log = LogFactoryUtil.getLog(CRFResearcherLocalServiceImpl.class);
}