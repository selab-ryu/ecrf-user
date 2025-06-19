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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ContactLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.exception.NoSuchResearcherException;
import ecrf.user.model.CRFResearcher;
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
	private Log _log = LogFactoryUtil.getLog(ResearcherLocalServiceImpl.class);
	
	@Reference
	private CRFResearcherLocalService _crfResearcherLocalService;
	
	@Reference
	private CRFLocalService _crfLocalService;
		
	@Reference
	private ContactLocalService _contactLocalService;
	
	@Reference
	private RoleLocalService _roleLocalService;
	
	@Indexable(type=IndexableType.REINDEX)
	public Researcher addResarcherWithUser(
			long companyId,
			long facebookId, String openId,
			String languageId, boolean male, String jobTitle,
			long prefixId, long suffixId,
			String emailAddress, String password1, String password2,
			String screenName,  String firstName, String lastName,
			int birthYear, int birthMonth, int birthDay, int gender, 
			String phone, String institution, String officeContact, String position,
			int approveStatus, ServiceContext userServiceContext, ServiceContext researcherServiceContext
			) throws PortalException {
		_log.info("Add Researcher With User Start");
		
		long creatorUserId = researcherServiceContext.getUserId();
		User creatorUser = null;
		try {
			creatorUser = super.userLocalService.getUser(creatorUserId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		// add user
		boolean autoPassword = false;
		boolean autoScreenName = false;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = true;
		
		_log.info("Add User");
		User user = null;
		Researcher researcher = null;

		user = userLocalService.addUserWithWorkflow(
				creatorUserId, companyId, autoPassword, password1, password2, 
				autoScreenName, screenName, emailAddress, facebookId, openId, 
				LocaleUtil.fromLanguageId(languageId), firstName, null, lastName, prefixId, suffixId, 
				male, birthMonth, birthDay, birthYear, jobTitle, groupIds, 
				organizationIds, roleIds, userGroupIds, sendEmail, userServiceContext);
	
		long researcherUserId = user.getUserId();
		
		_log.info("Add Researcher");
		// add Researcher
		long researcherId = super.counterLocalService.increment();
		researcher = super.researcherLocalService.createResearcher(researcherId);
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		
		// set audit fields
		researcher.setUserId(creatorUserId);
		researcher.setCompanyId(companyId);
		researcher.setGroupId(0);
		researcher.setUserName(creatorUser.getFullName());
		researcher.setCreateDate(researcherServiceContext.getCreateDate());
		researcher.setModifiedDate(researcherServiceContext.getModifiedDate());
		researcher.setExpandoBridgeAttributes(researcherServiceContext);
		
		String fullName = lastName + StringPool.SPACE + firstName;
		
		// set entity fields
		researcher.setResearcherUserId(researcherUserId);
		researcher.setName(fullName);
		researcher.setEmail(emailAddress);
		researcher.setBirth(birth);
		researcher.setGender(gender);
		researcher.setPhone(phone);
		researcher.setInstitution(institution);
		researcher.setOfficeContact(officeContact);
		researcher.setPosition(position);
		researcher.setApproveStatus(approveStatus);
		
		_log.info("Update Researcher");
		super.researcherPersistence.update(researcher);
		
		resourceLocalService.addResources(
				researcher.getCompanyId(), 0, creatorUserId,
				Researcher.class.getName(), researcherId,
				false, true, true);
		
		_log.info("Add Researcher With User End");
				
		return researcher;
	}
	
	@Indexable(type=IndexableType.REINDEX)
	public Researcher updateResearcherWithUser(
			long researcherId,
			boolean male, String password1,
			String screenName,  String firstName, String lastName,
			int birthYear, int birthMonth, int birthDay, int gender, 
			String phone, String institution, String officeContact, String position,
			ServiceContext userServiceContext, ServiceContext researcherServiceContext
			) throws PortalException {
		
		Researcher researcher = super.researcherLocalService.getResearcher(researcherId);
		
		Date birth = PortalUtil.getDate(birthMonth, birthDay, birthYear);
		
		long userId = userServiceContext.getUserId();
		User user = super.userLocalService.getUser(userId);
		
		// set attributes
		User researcherUser = super.userLocalService.getUser(researcher.getResearcherUserId());
		// email cannot changed
		researcherUser.setScreenName(screenName);
		researcherUser.setFirstName(firstName);
		researcherUser.setLastName(lastName);
		
		super.userLocalService.updateUser(researcherUser);
		
		// password change
		if(Validator.isNotNull(password1)) {
			super.userLocalService.updatePassword(researcherUser.getUserId(), password1, password1, false);
		}
		
		Contact contact = _contactLocalService.getContact(researcherUser.getContactId());
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setBirthday(birth);
		contact.setMale(male);
				
		_contactLocalService.updateContact(contact);
		
		String fullName = lastName + StringPool.SPACE + firstName;
		
		researcher.setModifiedDate(researcherServiceContext.getModifiedDate());
		researcher.setExpandoBridgeAttributes(researcherServiceContext);
		
		researcher.setBirth(birth);
		researcher.setGender(gender);
		researcher.setInstitution(institution);
		researcher.setModifiedDate(new Date());
		researcher.setName(fullName);
		researcher.setOfficeContact(officeContact);
		researcher.setPhone(phone);
		researcher.setPosition(position);
		
		super.researcherPersistence.update(researcher);
		
		super.resourceLocalService.updateResources(
				researcher.getCompanyId(), researcherServiceContext.getScopeGroup().getParentGroupId(),
				Researcher.class.getName(), researcher.getResearcherId(),
				researcherServiceContext.getModelPermissions());
		
		return researcher;
	}
	
	@Indexable(type=IndexableType.DELETE)
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

			resourceLocalService.deleteResource(
					researcher.getCompanyId(), Researcher.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, researcher.getResearcherId());
		}
		
		return researcher;
	}
	
	@Indexable(type=IndexableType.DELETE)
	public Researcher deleteResearcher(Researcher researcher) {
		
		try {
			this.deleteResearcher(researcher.getResearcherId());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
		
		return researcher;
	}	
	
	@Indexable(type=IndexableType.DELETE)
	public Researcher deleteResearcherWithUser(Researcher researcher) throws PortalException {
		super.researcherPersistence.remove(researcher);
		
		resourceLocalService.deleteResource(
				researcher.getCompanyId(), Researcher.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, researcher.getResearcherId());
		
		long userId = researcher.getResearcherUserId();
		if(userId > 0)
			super.userLocalService.deleteUser(userId);
		
		// remove other related entity
		List<CRFResearcher> crfResearcherList = _crfResearcherLocalService.getCRFResearcherByResearcherId(researcher.getResearcherId());
		for(CRFResearcher crfResearcher : crfResearcherList) {
			_crfResearcherLocalService.deleteCRFResearcher(crfResearcher);
		}
				
		return researcher;
	}
	
	public Researcher changeApproveStatus(long researcherId, int approveStatus) throws PortalException {
		_log.info("Change Aprrove Status");
		
		Researcher researcher = super.researcherLocalService.getResearcher(researcherId);
		
		researcher.setApproveStatus(approveStatus);
		
		super.researcherPersistence.update(researcher);
		
		return researcher;
	}
	
	public List<Researcher> getResearcherBySite(long siteId) {
		List<User> siteUsers = super.userLocalService.getGroupUsers(siteId);
		List<Researcher> siteResearchers = new ArrayList<>();

		long[] userIds = null;
		ArrayList<Long> userIdList = new ArrayList<Long>(); 
		for(User user : siteUsers) {
			long userId = user.getUserId();
			
			if(userId > 0) {
				userIdList.add(new Long(userId));
			}
		}
		
		userIds = userIdList.stream().mapToLong(l -> l).toArray();
		
		siteResearchers = researcherFinder.findByUserIds(userIds);
		
		_log.info("[size match check] site users / user ids / site researchers : " + siteUsers.size() + " / " + userIds.length + " / " + siteResearchers.size());
		
		return siteResearchers;
	}
	
	public Researcher getResearcherByUserId(long userId) throws NoSuchResearcherException {		
		return super.researcherPersistence.findByResearcherUserId(userId);
	}
	
	public boolean hasPIPermission(long userId) {
		boolean hasPermission = false;
		try {
			_log.info("user id : " + userId);
			Researcher researcher = this.getResearcherByUserId(userId);
			if(Validator.isNotNull(researcher)) {
				if(researcher.getPosition().equals("pi")) hasPermission = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
			return false;
		}
		return hasPermission;
	}
	
	public boolean checkAgreement(long researcherId) throws NoSuchResearcherException {
		boolean agree = false;
		Researcher researcher = super.researcherPersistence.findByPrimaryKey(researcherId);
		
		int termAgree = researcher.getTermOfUseAgree();
		int privacyAgree = researcher.getPrivacyAgree();
		
		if(termAgree+privacyAgree == 2) {
			agree = true;
		}
		
		return agree;
	}
	
	public void updateAgreemnt(long researcherId, boolean state) throws NoSuchResearcherException {
		Researcher researcher = super.researcherPersistence.findByPrimaryKey(researcherId);
		
		if(state) {
			researcher.setTermOfUseAgree(1);
			researcher.setPrivacyAgree(1);
		} else {
			researcher.setTermOfUseAgree(0);
			researcher.setPrivacyAgree(0);
		}
		
		super.researcherPersistence.update(researcher);
	}
}