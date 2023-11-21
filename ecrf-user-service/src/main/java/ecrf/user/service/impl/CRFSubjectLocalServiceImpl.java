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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import ecrf.user.model.CRFSubject;
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
		_log = LogFactoryUtil.getLog(this.getClass().getName());
		_log.info("Service : Add CRF-Subject");
		
		long crfSubjectId = super.counterLocalService.increment();
		CRFSubject crfSubject = super.crfSubjectLocalService.createCRFSubject(crfSubjectId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		// set audit fields
		crfSubject. setGroupId(groupId);
		crfSubject. setUserId(userId);
		crfSubject. setUserName(user.getFullName());
		crfSubject. setCompanyId(user.getCompanyId());
		crfSubject. setCreateDate(sc.getCreateDate());
		crfSubject. setModifiedDate(sc.getModifiedDate());
		crfSubject. setExpandoBridgeAttributes(sc);
		
		// set entity fields
		crfSubject. setCrfId(crfId);
		crfSubject. setSubjectId(crfSubjectId);
		
		// other liferay frameworks
		super.crfSubjectPersistence.update(crfSubject);
		
		return crfSubject;
	}
	
	public CRFSubject deleteCRFSubject(long crfSubjectId) throws PortalException {
		CRFSubject crfSubject = null;
		
		if(crfSubjectId > 0) {
			crfSubject = super.crfSubjectLocalService.getCRFSubject(crfSubjectId);
			super.crfSubjectPersistence.remove(crfSubjectId);
		}
		
		return crfSubject;
	}
	
	public CRFSubject deleteCRFSubject(CRFSubject crfSubject) {
		return super.crfSubjectPersistence.remove(crfSubject);
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
	
	private Log _log;
}