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

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import ecrf.user.model.CRFSearchLog;
import ecrf.user.service.base.CRFSearchLogLocalServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = "model.class.name=ecrf.user.model.CRFSearchLog",
	service = AopService.class
)
public class CRFSearchLogLocalServiceImpl extends CRFSearchLogLocalServiceBaseImpl {
	public CRFSearchLog addSearchLog(String searchLog, ServiceContext sc) throws PortalException {
		long searchLogId = super.counterLocalService.increment();
		CRFSearchLog crfSearchLog = super.crfSearchLogLocalService.createCRFSearchLog(searchLogId);

		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		long companyId = sc.getCompanyId();
		
		Date now = new Date();
		
		crfSearchLog.setSearchLog(searchLog);
		
		
		crfSearchLog.setCompanyId(companyId);
		crfSearchLog.setGroupId(groupId);
		crfSearchLog.setUserId(userId);
		crfSearchLog.setUserName(user.getFullName());
		crfSearchLog.setCreateDate(now);
		crfSearchLog.setModifiedDate(now);
		
		crfSearchLog.setExpandoBridgeAttributes(sc);
		
		super.crfSearchLogPersistence.update(crfSearchLog);
		
		return crfSearchLog;
	}
}