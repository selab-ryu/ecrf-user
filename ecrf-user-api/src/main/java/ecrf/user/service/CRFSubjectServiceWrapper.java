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
 * Provides a wrapper for {@link CRFSubjectService}.
 *
 * @author Ryu W.C.
 * @see CRFSubjectService
 * @generated
 */
public class CRFSubjectServiceWrapper
	implements CRFSubjectService, ServiceWrapper<CRFSubjectService> {

	public CRFSubjectServiceWrapper(CRFSubjectService crfSubjectService) {
		_crfSubjectService = crfSubjectService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crfSubjectService.getOSGiServiceIdentifier();
	}

	@Override
	public CRFSubjectService getWrappedService() {
		return _crfSubjectService;
	}

	@Override
	public void setWrappedService(CRFSubjectService crfSubjectService) {
		_crfSubjectService = crfSubjectService;
	}

	private CRFSubjectService _crfSubjectService;

}