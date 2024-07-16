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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.CRFAutoquery;
import ecrf.user.model.CRFHistory;
import ecrf.user.model.CRFSubject;
import ecrf.user.model.LinkCRF;
import ecrf.user.model.custom.CRFSubjectInfo;
import ecrf.user.service.CRFAutoqueryLocalService;
import ecrf.user.service.CRFHistoryLocalService;
import ecrf.user.service.LinkCRFLocalService;
import ecrf.user.service.base.CRFSubjectLocalServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = "model.class.name=ecrf.user.model.CRFSubject",
	service = AopService.class
)
public class CRFSubjectLocalServiceImpl extends CRFSubjectLocalServiceBaseImpl {
	public CRFSubject addCRFSubject(
			long crfId, long subjectId,
			ServiceContext sc) throws PortalException {
		//_log.info("Service : Add CRF-Subject");
		
		long crfSubjectId = super.counterLocalService.increment();
		CRFSubject crfSubject = super.crfSubjectLocalService.createCRFSubject(crfSubjectId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date now = new Date();
		
		// set audit fields
		crfSubject.setGroupId(groupId);
		crfSubject.setUserId(userId);
		crfSubject.setUserName(user.getFullName());
		crfSubject.setCompanyId(sc.getCompanyId());
		crfSubject.setCreateDate(now);
		crfSubject.setModifiedDate(now);
		
		// set entity fields
		crfSubject.setCrfId(crfId);
		crfSubject.setSubjectId(crfSubjectId);
		crfSubject.setUpdateLock(false);
		
		crfSubject.setExpandoBridgeAttributes(sc);
		
		// other liferay frameworks
		super.crfSubjectPersistence.update(crfSubject);
		
		resourceLocalService.addResources(
			crfSubject.getCompanyId(), groupId, userId,
			CRFSubject.class.getName(), crfSubject.getCrfSubjectId(),
			false, true, true);
		
		return crfSubject;
	}
	
	public void updateCRFSubjects(long crfId, ArrayList<CRFSubject> crfSubjectList, ServiceContext sc) throws PortalException {
		//_log.info("Service : Update CRF-Subject List by infoList");
		
		long groupId = sc.getScopeGroupId();
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		
		Date now = new Date();
		
		//_log.info("group : " + groupId);
		//_log.info("user : " + userId);
		
		// get crf-subjects from db
		ArrayList<CRFSubject> wholeCRFSubjectList = new ArrayList<CRFSubject>();
		wholeCRFSubjectList.addAll(super.crfSubjectPersistence.findByG_C(groupId, crfId));
		
		// loop crf-subject
		for(CRFSubject crfSubject : crfSubjectList) {
			//_log.info(crfSubject.toString());
			 
			long subjectId = crfSubject.getSubjectId();
			
			boolean updateLock = crfSubject.isUpdateLock();
			
			// current crf-subject vs new crf-subject 
			Optional<CRFSubject> crfSubjectOpt = wholeCRFSubjectList.stream()
					.filter(x -> subjectId == x.getSubjectId())
					.findFirst();
			
			// if matched (e:e) : update info
			if(crfSubjectOpt.isPresent()) {
				CRFSubject tempCRFSubject = crfSubjectOpt.get();
				tempCRFSubject.setUpdateLock(updateLock);
				
				super.crfSubjectPersistence.update(tempCRFSubject);
				
				// remove matched item -> only not matched item exist in list after iterate
				wholeCRFSubjectList.remove(tempCRFSubject);
			} else {	// if new (n:e) : add
				long crfSubjectId = super.counterLocalService.increment();
				CRFSubject tempCRFSubject = super.crfSubjectLocalService.createCRFSubject(crfSubjectId);
				
				tempCRFSubject.setGroupId(groupId);
				tempCRFSubject.setUserId(userId);
				tempCRFSubject.setUserName(user.getFullName());
				tempCRFSubject.setCompanyId(user.getCompanyId());
				tempCRFSubject.setCreateDate(now);
				tempCRFSubject.setModifiedDate(now);
				
				tempCRFSubject.setCrfId(crfId);
				tempCRFSubject.setSubjectId(subjectId);
				tempCRFSubject.setParticipationStartDate(now);
				tempCRFSubject.setParticipationStatus(0);
				tempCRFSubject.setUpdateLock(updateLock);
				
				super.crfSubjectPersistence.update(tempCRFSubject);
			}	
		}
		
		// if not matched (e:n) : delete
		for(CRFSubject crfSubject : wholeCRFSubjectList) {
			this.deleteCRFSubject(crfSubject.getCrfSubjectId());
		}
	}
		
	public CRFSubject deleteCRFSubject(long crfSubjectId) throws PortalException {
		CRFSubject crfSubject = null;
		
		if(crfSubjectId > 0) {
			crfSubject = super.crfSubjectLocalService.getCRFSubject(crfSubjectId);
			super.crfSubjectPersistence.remove(crfSubjectId);
			
			resourceLocalService.deleteResource(
				crfSubject.getCompanyId(), CRFSubject.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, crfSubject.getCrfSubjectId());
			
			long groupId = crfSubject.getGroupId();
			long crfId = crfSubject.getCrfId();
			long subjectId = crfSubject.getSubjectId();
			
			// remove crf-data
			List<LinkCRF> linkList = _linkCRFLocalService.getLinkCRFByG_S_C(groupId, subjectId, crfId);
			for(LinkCRF link : linkList) {
				_linkCRFLocalService.deleteLinkCRF(link.getLinkId());
			}			
		}
		
		return crfSubject;
	}
	
	public CRFSubject deleteCRFSubject(CRFSubject crfSubject) {
		super.crfSubjectPersistence.remove(crfSubject);
		
		try {
			resourceLocalService.deleteResource(
				crfSubject.getCompanyId(), CRFSubject.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, crfSubject.getCrfSubjectId());
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return crfSubject;
	}
	
	
	public List<CRFSubject> getCRFSubjectByGroupId(long groupId) {
		return super.crfSubjectPersistence.findByGroupId(groupId);
	}
	public List<CRFSubject> getCRFSubjectByGroupId(long groupId, int start, int end) {
		return super.crfSubjectPersistence.findByGroupId(groupId, start, end);
	}
	public List<CRFSubject> getCRFSubjectByGroupId(long groupId, int start, int end, OrderByComparator comparator) {
		return super.crfSubjectPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int countCRFSubjectByGroupId(long groupId) {
		return super.crfSubjectPersistence.countByGroupId(groupId);
	}
	
	public List<CRFSubject> getCRFSubjectByCRFId(long groupId, long crfId) {
		return super.crfSubjectPersistence.findByG_C(groupId, crfId);
	}
	public List<CRFSubject> getCRFSubjectByCRFId(long groupId, long crfId, int start, int end) {
		return super.crfSubjectPersistence.findByG_C(groupId, crfId, start, end);
	}
	public List<CRFSubject> getCRFSubjectByCRFId(long groupId, long crfId, int start, int end, OrderByComparator comparator) {
		return super.crfSubjectPersistence.findByG_C(groupId, crfId, start, end, comparator);
	}
	public int countCRFSubjectByCRFId(long groupId, long crfId) {
		return super.crfSubjectPersistence.countByG_C(groupId, crfId);
	}
	
	public List<CRFSubject> getCRFSubjectBySubjectId(long groupId, long subjectId) {
		return super.crfSubjectPersistence.findByG_S(groupId, subjectId);
	}
	public List<CRFSubject> getCRFSubjectBySubjectId(long groupId, long subjectId, int start, int end) {
		return super.crfSubjectPersistence.findByG_S(groupId, subjectId, start, end);
	}
	public List<CRFSubject> getCRFSubjectBySubjectId(long groupId, long subjectId, int start, int end, OrderByComparator comparator) {
		return super.crfSubjectPersistence.findByG_S(groupId, subjectId, start, end, comparator);
	}
	public int countCRFSubjectBySubjectId(long groupId, long subjectId) {
		return super.crfSubjectPersistence.countByG_S(groupId, subjectId);
	}
	
	public CRFSubject getCRFSubjectByC_S(long crfId, long subjectId) {
		return super.crfSubjectPersistence.fetchByC_S(crfId, subjectId);
	}
	
	public boolean getUpdateLockByC_S(long crfId, long subjectId) {
		CRFSubject crfSubject = super.crfSubjectPersistence.fetchByC_S(crfId, subjectId);
		if(Validator.isNull(crfSubject)) return false;
		return crfSubject.getUpdateLock();
	}
	
	// get crf-subject by update lock
	public List<CRFSubject> getCRFSubjectByG_C_UL(long groupId, long crfId, boolean updateLock) {
		return super.crfSubjectPersistence.findByG_C_UL(groupId, crfId, updateLock);
	}
	public List<CRFSubject> getCRFSubjectByG_C_UL(long groupId, long crfId, boolean updateLock, int start, int end) {
		return super.crfSubjectPersistence.findByG_C_UL(groupId, crfId, updateLock, start, end);
	}
	public int countCRFSubjectByG_C_UL(long groupId, long crfId, boolean updateLock) {
		return super.crfSubjectPersistence.countByG_C_UL(groupId, crfId, updateLock);
	}
	
	public CRFSubject changeUpdateLock(long crfId, long subjectId, boolean updateLock) {
		CRFSubject crfSubject = super.crfSubjectPersistence.fetchByC_S(crfId, subjectId);
		
		crfSubject.setUpdateLock(updateLock);
		
		super.crfSubjectPersistence.update(crfSubject);
		
		return crfSubject;
	}
	
	@Reference
	private CRFAutoqueryLocalService _crfAutoQueryLocalService;
	
	@Reference
	private CRFHistoryLocalService _crfHistoryLocalService;
	
	@Reference
	private LinkCRFLocalService _linkCRFLocalService;
	
	private Log _log = LogFactoryUtil.getLog(CRFSubjectLocalServiceImpl.class);;
}