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

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import ecrf.user.model.ExperimentalGroup;
import ecrf.user.model.Project;
import ecrf.user.service.base.ExperimentalGroupLocalServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = "model.class.name=ecrf.user.model.ExperimentalGroup",
	service = AopService.class
)
public class ExperimentalGroupLocalServiceImpl extends ExperimentalGroupLocalServiceBaseImpl {
	public ExperimentalGroup addExpGroup(
			String name, String abbr,
			String description, int type,
			ServiceContext sc) throws PortalException {
		_log.info("Service : Add Exp. Group");
		
		long expGroupId = super.counterLocalService.increment();
		ExperimentalGroup expGroup = super.experimentalGroupLocalService.createExperimentalGroup(expGroupId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date now = new Date();
		
		expGroup.setGroupId(groupId);
		expGroup.setUserId(userId);
		expGroup.setUserName(user.getFullName());
		expGroup.setCompanyId(user.getCompanyId());
		expGroup.setCreateDate(now);
		expGroup.setModifiedDate(now);
		
		expGroup.setName(name);
		expGroup.setAbbreviation(abbr);
		expGroup.setDescription(description);
		expGroup.setType(type);
		
		expGroup.setExpandoBridgeAttributes(sc);
		
		resourceLocalService.addResources(
			expGroup.getCompanyId(), expGroup.getGroupId(), expGroup.getUserId(),
			ExperimentalGroup.class.getName(), expGroup.getExperimentalGroupId(),
			false, true, true);
		
		super.experimentalGroupPersistence.update(expGroup);
		
		return expGroup;
	}
	
	public ExperimentalGroup updateExpGroup(
			long expGroupId,
			String name, String abbr,
			String description, int type,
			ServiceContext sc) throws PortalException {
		_log.info("Service : Add Exp. Group");
		
		ExperimentalGroup expGroup = super.experimentalGroupPersistence.fetchByExperimentalGroupId(expGroupId);
				
		Date now = new Date();
		
		expGroup.setModifiedDate(now);
		
		expGroup.setName(name);
		expGroup.setAbbreviation(abbr);
		expGroup.setDescription(description);
		expGroup.setType(type);
		
		expGroup.setExpandoBridgeAttributes(sc);
		
		super.experimentalGroupPersistence.update(expGroup);
		
		resourceLocalService.updateResources(
				expGroup.getCompanyId(), expGroup.getGroupId(), 
				ExperimentalGroup.class.getName(), expGroup.getExperimentalGroupId(),
				sc.getModelPermissions());
		
		return expGroup;
	}
	
	public ExperimentalGroup deleteExpGroup(long expGroupId) throws PortalException {
		ExperimentalGroup expGroup = null;
		if(expGroupId > 0) {
			expGroup = super.experimentalGroupPersistence.fetchByExperimentalGroupId(expGroupId);
			
			resourceLocalService.deleteResource(
				expGroup.getCompanyId(), ExperimentalGroup.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, expGroup.getExperimentalGroupId()
			);
			
			super.experimentalGroupPersistence.remove(expGroup);
		}
		
		return expGroup;
	}
	
	public List<ExperimentalGroup> getExpGroupByGroupId(long groupId) {
		return super.experimentalGroupPersistence.findByGroupId(groupId);
	}
	
	public List<ExperimentalGroup> getExpGroupByName(String name) {
		return super.experimentalGroupPersistence.findByName(name);
	}
	
	public ExperimentalGroup getExpGroupById(long expGroupId) {
		return super.experimentalGroupPersistence.fetchByExperimentalGroupId(expGroupId);
	}
	
	public ExperimentalGroup getExpGroupByG_N(long groupId, String name) {
		try {
			return super.experimentalGroupPersistence.findByG_N(groupId, name);
		} catch (Exception e) {
			_log.error("No Such Experimental Group : " + groupId + " / " + name);
			e.printStackTrace();
			return null;
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(ExperimentalGroupLocalServiceImpl.class);
}