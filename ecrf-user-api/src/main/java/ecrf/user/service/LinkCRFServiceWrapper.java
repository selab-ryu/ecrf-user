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

package ecrf.user.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LinkCRFService}.
 *
 * @author Ryu W.C.
 * @see LinkCRFService
 * @generated
 */
public class LinkCRFServiceWrapper
	implements LinkCRFService, ServiceWrapper<LinkCRFService> {

	public LinkCRFServiceWrapper(LinkCRFService linkCRFService) {
		_linkCRFService = linkCRFService;
	}

	@Override
	public java.util.ArrayList<ecrf.user.model.LinkCRF> getAllLinkCRFByCRF(
		long groupId, long crfId) {

		return _linkCRFService.getAllLinkCRFByCRF(groupId, crfId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _linkCRFService.getOSGiServiceIdentifier();
	}

	@Override
	public LinkCRFService getWrappedService() {
		return _linkCRFService;
	}

	@Override
	public void setWrappedService(LinkCRFService linkCRFService) {
		_linkCRFService = linkCRFService;
	}

	private LinkCRFService _linkCRFService;

}