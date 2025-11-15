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

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import ecrf.user.model.SelfSiteRequest;
import ecrf.user.service.base.SelfSiteRequestLocalServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = "model.class.name=ecrf.user.model.SelfSiteRequest",
	service = AopService.class
)
public class SelfSiteRequestLocalServiceImpl
	extends SelfSiteRequestLocalServiceBaseImpl {
	
	public SelfSiteRequest addRequest(
			String email,
			String lastName, String firstName,
			String phone,
			String title, String description,
			ServiceContext sc ) throws PortalException {
		
		long requestId = super.counterLocalService.increment();
		SelfSiteRequest siteRequest = super.selfSiteRequestLocalService.createSelfSiteRequest(requestId);
		
		// get metadata
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		
		Date now = new Date();
		
		siteRequest.setCompanyId(user.getCompanyId());
		siteRequest.setGroupId(0);
		siteRequest.setUserId(userId);
		siteRequest.setUserName(user.getFullName());
		siteRequest.setCreateDate(now);
		siteRequest.setModifiedDate(now);
				
		siteRequest.setEmail(email);
		siteRequest.setLastName(lastName);
		siteRequest.setFirstName(firstName);
		siteRequest.setPhone(phone);
		siteRequest.setProjectTitle(title);
		siteRequest.setProjectDescription(description);
		
		siteRequest.setExpandoBridgeAttributes(sc);
		
		super.selfSiteRequestPersistence.update(siteRequest);
		
		return siteRequest;
	}
	
	public List<SelfSiteRequest> getAllSiteRequest() {
		return super.selfSiteRequestPersistence.findAll();
	}
 	
	private Log _log = LogFactoryUtil.getLog(SelfSiteRequestLocalServiceImpl.class);
}