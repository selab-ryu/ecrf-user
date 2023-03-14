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
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.exception.NoSuchResearcherException;
import ecrf.user.model.Researcher;
import ecrf.user.service.CRFLocalService;
import ecrf.user.service.CRFResearcherLocalService;
import ecrf.user.service.base.ResearcherLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ecrf.user.model.Researcher",
	service = AopService.class
)
public class ResearcherLocalServiceImpl extends ResearcherLocalServiceBaseImpl {
	private Logger _logger;
	
	@Reference
	private CRFResearcherLocalService _crfResearcherLocalService;
	
	@Reference
	private CRFLocalService _crfLocalService;
	
	public Researcher addResarcherWithUser(
			long companyId, long facebookId, String openId,
			String languageId, boolean male, String jobTitle,
			long prefixId, long suffixId,
			String emailAddress, String password1, String password2,
			String screenName,  String firstName, String lastName,
			int birthYear, int birthMonth, int birthDay, String phone,
			String institution, String officeContact, String position,
			int approveStatus, ServiceContext userServiceContext, ServiceContext researcherServiceContext
			) throws PortalException {
		_logger = Logger.getLogger(ResearcherLocalServiceImpl.class.getName());
		_logger.info("Add Researcher With User Start");
		
		long creatorUserId = researcherServiceContext.getUserId();
		User creatorUser = null;
		try {
			creatorUser = super.userLocalService.getUser(creatorUserId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		long groupId = researcherServiceContext.getScopeGroupId();
		
		// add user
		boolean autoPassword = false;
		boolean autoScreenName = false;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = true;
		
		_logger.info("Add User");
		User user = null;
		try {
			user = userLocalService.addUserWithWorkflow(
					creatorUserId, companyId, autoPassword, password1, password2, 
					autoScreenName, screenName, emailAddress, facebookId, openId, 
					LocaleUtil.fromLanguageId(languageId), firstName, null, lastName, prefixId, suffixId, 
					male, birthMonth, birthDay, birthYear, jobTitle, groupIds, 
					organizationIds, roleIds, userGroupIds, sendEmail, userServiceContext);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		long researcherUserId = user.getUserId();
		
		_logger.info("Add Researcher");
		// add Researcher
		long researcherId = super.counterLocalService.increment();
		Researcher researcher = super.researcherLocalService.createResearcher(researcherId);
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		
		// set audit fields
		researcher.setCreateUserId(creatorUserId);
		researcher.setGroupId(groupId);
		researcher.setCompanyId(companyId);
		researcher.setCreateUserName(creatorUser.getFullName());
		researcher.setCreateDate(researcherServiceContext.getCreateDate());
		researcher.setModifiedDate(researcherServiceContext.getModifiedDate());
		researcher.setExpandoBridgeAttributes(researcherServiceContext);
		
		// set entity fields
		researcher.setResearcherUserId(researcherUserId);
		researcher.setName(screenName);
		researcher.setBirth(birth);
		researcher.setPhone(phone);
		researcher.setInstitution(institution);
		researcher.setOfficeContact(officeContact);
		researcher.setPosition(position);
		researcher.setApproveStatus(approveStatus);
		
		_logger.info("Update Researcher");
		super.researcherPersistence.update(researcher, researcherServiceContext);
		
		// calls to other liferay frameworks (workflow, asset, resource, ...)
		
		resourceLocalService.addResources(
				researcher.getCompanyId(), researcher.getGroupId(), researcher.getCreateUserId(),
				Researcher.class.getName(), researcher.getResearcherId(),
				false, true, true);
		
		_logger.info("Add Researcher With User End");
		return researcher;
	}
	
	public Researcher addResearcher(
			long researcherUserId,
			int birthYear, int birthMonth, int birthDay, String phone,
			String institution, String officeContact, String position,
			int approveStatus, ServiceContext sc) throws  PortalException {
		_logger = Logger.getLogger(ResearcherLocalServiceImpl.class.getName());
		_logger.info("Add Researcher Start");
		
		long researcherId = super.counterLocalService.increment();
		Researcher researcher = super.researcherLocalService.createResearcher(researcherId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		
		// set audit fields
		researcher.setCreateUserId(userId);
		researcher.setGroupId(groupId);
		researcher.setCompanyId(user.getCompanyId());
		researcher.setCreateUserName(user.getFullName());
		researcher.setCreateDate(sc.getCreateDate());
		researcher.setModifiedDate(sc.getModifiedDate());
		researcher.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		researcher.setResearcherUserId(researcherUserId);
		researcher.setBirth(birth);
		researcher.setPhone(phone);
		researcher.setInstitution(institution);
		researcher.setOfficeContact(officeContact);
		researcher.setPosition(position);
		researcher.setApproveStatus(approveStatus);
		
		super.researcherPersistence.update(researcher, sc);
		
		// calls to other liferay frameworks (workflow, asset, resource, ...)
		
		resourceLocalService.addResources(
				researcher.getCompanyId(), researcher.getGroupId(), researcher.getCreateUserId(),
				Researcher.class.getName(), researcher.getResearcherId(),
				false, true, true);
		
		return researcher;
	}
	
	public Researcher updateResearcher(
			long researcherId, long researcherUserId, 
			int birthYear, int birthMonth, int birthDay, String phone,
			String institution, String officeContact, String position,
			int approveStatus, ServiceContext sc) throws  PortalException {
		_logger = Logger.getLogger(ResearcherLocalServiceImpl.class.getName());
		_logger.info("Update Researcher");
		
		Researcher researcher = super.researcherLocalService.getResearcher(researcherId);
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		
		// set audit fields
		researcher.setModifiedDate(sc.getModifiedDate());
		researcher.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		researcher.setResearcherUserId(researcherUserId);
		researcher.setBirth(birth);
		researcher.setPhone(phone);
		researcher.setInstitution(institution);
		researcher.setOfficeContact(officeContact);
		researcher.setPosition(position);
		researcher.setApproveStatus(approveStatus);
		
		super.researcherPersistence.update(researcher, sc);
		
		// calls to other liferay frameworks (workflow, asset, resource, ...)
		
		super.resourceLocalService.updateResources(
				researcher.getCompanyId(), researcher.getGroupId(),
				Researcher.class.getName(), researcher.getResearcherId(),
				sc.getModelPermissions());
		
		return researcher;
	}
	
	public Researcher deleteResearcher(long researcherId, ServiceContext sc) throws PortalException {
		Researcher researcher = null;
		if(researcherId > 0) {
			researcher = super.researcherLocalService.getResearcher(researcherId);
			super.researcherPersistence.remove(researcherId);
			
//			// remove other related entity
//			List<CRFResearcher> crfResearcherList = _crfResearcherLocalService.getCRFResearcherByResearcherId(sc.getScopeGroupId(), researcherId);
//			for(CRFResearcher crfResearcher : crfResearcherList) {
//				_crfResearcherLocalService.deleteCRFResearcher(crfResearcher);
//			}
//			
//			List<CRF> crfList = _crfLocalService.getCRFByManagerId(sc.getScopeGroupId(), researcherId);
//			for(CRF crf : crfList) {
//				_crfLocalService.updateManager(crf.getCrfId(), 0, sc);
//			}
			
			resourceLocalService.deleteResource(
					researcher.getCompanyId(), Researcher.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, researcherId);
		}
		
		return researcher;
	}
	
	public Researcher deleteResearcher(Researcher researcher, ServiceContext sc) {
		super.researcherPersistence.remove(researcher);
		
//		// remove other related entity
//		List<CRFResearcher> crfResearcherList = _crfResearcherLocalService.getCRFResearcherByResearcherId(sc.getScopeGroupId(), researcher.getResearcherId());
//		for(CRFResearcher crfResearcher : crfResearcherList) {
//			_crfResearcherLocalService.deleteCRFResearcher(crfResearcher);
//		}
//		
//		List<CRF> crfList = _crfLocalService.getCRFByManagerId(sc.getScopeGroupId(), researcher.getResearcherId());
//		for(CRF crf : crfList) {
//			try {
//				_crfLocalService.updateManager(crf.getCrfId(), 0, sc);
//			} catch (PortalException e) {
//				e.printStackTrace();
//			}
//		}
		
		try {
			resourceLocalService.deleteResource(
					researcher.getCompanyId(), Researcher.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, researcher.getResearcherId());
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return researcher;
	}
	
	public Researcher getResearcher(long researcherId) throws NoSuchResearcherException {
		return super.researcherPersistence.findByPrimaryKey(researcherId);
	}
	
	public List<Researcher> getResearcherByGroupId(long groupId) {
		return super.researcherPersistence.findByGroupId(groupId);
	}
	public List<Researcher> getResearcherByGroupId(long groupId, int start, int end) {
		return super.researcherPersistence.findByGroupId(groupId, start, end);
	}
	public List<Researcher> getResearcherByGroupId(long groupId, int start, int end, OrderByComparator comparator) {
		return super.researcherPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int getResearcherCount(long groupId) {
		return super.researcherPersistence.countByGroupId(groupId);
	}
	
	public Researcher changeApproveStatus(long researcherId, int approveStatus) throws PortalException {
		_logger = Logger.getLogger(ResearcherLocalServiceImpl.class.getName());
		_logger.info("Change Aprrove Status");
		
		Researcher researcher = super.researcherLocalService.getResearcher(researcherId);
		
		researcher.setApproveStatus(approveStatus);
		
		super.researcherPersistence.update(researcher);
		
		return researcher;
	}
}