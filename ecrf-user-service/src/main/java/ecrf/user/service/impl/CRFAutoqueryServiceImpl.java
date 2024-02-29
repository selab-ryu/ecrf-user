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
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.CRFAutoquery;
import ecrf.user.service.CRFAutoqueryLocalService;
import ecrf.user.service.base.CRFAutoqueryServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = {
		"json.web.service.context.name=ec",
		"json.web.service.context.path=CRFAutoquery"
	},
	service = AopService.class
)
@JSONWebService("crf-autoquery")
public class CRFAutoqueryServiceImpl extends CRFAutoqueryServiceBaseImpl {
	public List<CRFAutoquery> getQueryListBySId(long subjectId){
		List<CRFAutoquery> results = _queryLocalService.getQueryBySId(subjectId);
		return results;
	}
	
	@Reference
	private CRFAutoqueryLocalService _queryLocalService;
}