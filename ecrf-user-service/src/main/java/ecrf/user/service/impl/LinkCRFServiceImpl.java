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

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import ecrf.user.model.LinkCRF;
import ecrf.user.service.base.LinkCRFServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = {
		"json.web.service.context.name=ec",
		"json.web.service.context.path=LinkCRF"
	},
	service = AopService.class
)
@JSONWebService("link-crf")
public class LinkCRFServiceImpl extends LinkCRFServiceBaseImpl {
	@JSONWebService("get-all-data-by-crf")
	public ArrayList<LinkCRF> getAllLinkCRFByCRF(long groupId, long crfId) {
		ArrayList<LinkCRF> linkList = new ArrayList<>();
		
		return linkList;
	}
		 
}