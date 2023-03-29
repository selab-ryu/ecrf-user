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

import ecrf.user.exception.NoSuchProjectException;
import ecrf.user.model.Project;
import ecrf.user.service.base.ProjectLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ecrf.user.model.Project",
	service = AopService.class
)
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {
	public Project addProject(
			String title, String shortTitle, String purpose,
			int startDateYear, int startDateMonth, int startDateDay,
			int endDateYear, int endDateMonth, int endDateDay,
			long principleResearcherId, long manageResearcherId,
			ServiceContext sc) throws PortalException {
		_logger = Logger.getLogger(this.getClass().getName());
		_logger.info("Add Project Start");
		
		long projectId = super.counterLocalService.increment();
		Project project = super.projectLocalService.createProject(projectId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date startDate = PortalUtil.getDate(startDateMonth, startDateDay, startDateYear);
		Date endDate = PortalUtil.getDate(endDateMonth, endDateDay, endDateYear);
		
		// set audit fields
		project.setGroupId(groupId);
		project.setUserId(userId);
		project.setUserName(user.getFullName());
		project.setCompanyId(user.getCompanyId());
		project.setCreateDate(sc.getCreateDate());
		project.setModifiedDate(sc.getModifiedDate());
		project.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		project.setTitle(title);
		project.setShortTitle(shortTitle);
		project.setPurpose(purpose);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		
		project.setPrincipalResearcherId(principleResearcherId);
		project.setManageResearcherId(manageResearcherId);
		
		super.projectPersistence.update(project);
		
		return project;
	}
	
	public Project updateProject(
			long projectId,
			String title, String shortTitle, String purpose,
			int startDateYear, int startDateMonth, int startDateDay,
			int endDateYear, int endDateMonth, int endDateDay,
			long principleResearcherId, long manageResearcherId,
			ServiceContext sc) throws PortalException {
		_logger = Logger.getLogger(this.getClass().getName());
		_logger.info("Update Project Start");
		
		Project project = super.projectLocalService.getProject(projectId);
		
		Date startDate = PortalUtil.getDate(startDateMonth, startDateDay, startDateYear);
		Date endDate = PortalUtil.getDate(endDateMonth, endDateDay, endDateYear);
		
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		
		// set audit fields
		project.setUserId(userId);
		project.setUserName(user.getFullName());
		project.setModifiedDate(sc.getModifiedDate());
		project.setExpandoBridgeAttributes(sc);
		
		// set entity fields
		project.setTitle(title);
		project.setShortTitle(shortTitle);
		project.setPurpose(purpose);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		
		if(principleResearcherId > 0) project.setPrincipalResearcherId(principleResearcherId);
		if(manageResearcherId > 0) project.setManageResearcherId(manageResearcherId);
		
		super.projectPersistence.update(project);
		
		return project;
	}
	
	public Project deleteProject(long projectId) throws PortalException {
		Project project = null;
		if(projectId > 0) {
			project = super.projectLocalService.getProject(projectId);
			super.projectPersistence.remove(projectId);
		}
		
		return project;
	}
	
	public Project deleteProject(Project project) {
		super.projectPersistence.remove(project);
		
		return project;
	}
	
	public List<Project> getProjectByGroupId(long groupId) {
		return super.projectPersistence.findByGroupId(groupId);
	}
	public List<Project> getProjectByGroupId(long groupId, int start, int end) {
		return super.projectPersistence.findByGroupId(groupId, start, end);
	}
	public List<Project> getProjectByGroupId(long groupId, int start, int end, OrderByComparator comparator) {
		return super.projectPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int getProjectCount(long groupId) {
		return super.projectPersistence.countByGroupId(groupId);
	}
	
	private Logger _logger;
}