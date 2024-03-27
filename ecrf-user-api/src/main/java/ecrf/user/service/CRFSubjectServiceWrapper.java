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

	@Override
	public java.util.ArrayList<ecrf.user.model.custom.CRFSubjectInfo>
		getAllCRFSubjectInfoList(long groupId, long crfId) {

		return _crfSubjectService.getAllCRFSubjectInfoList(groupId, crfId);
	}

	@Override
	public java.util.ArrayList<ecrf.user.model.Subject> getCRFSubjectByExGroup(
		long groupId, long crfId, String exGroup) {

		return _crfSubjectService.getCRFSubjectByExGroup(
			groupId, crfId, exGroup);
	}

	@Override
	public java.util.ArrayList<ecrf.user.model.custom.CRFSubjectInfo>
		getCRFSubjectList(long groupId, long crfId) {

		return _crfSubjectService.getCRFSubjectList(groupId, crfId);
	}

	@Override
	public java.util.ArrayList<ecrf.user.model.custom.CRFSubjectInfo>
		getCRFSubjectList(long groupId, long crfId, boolean isUpdateLock) {

		return _crfSubjectService.getCRFSubjectList(
			groupId, crfId, isUpdateLock);
	}

	@Override
	public java.util.ArrayList<ecrf.user.model.Subject>
		getCRFSubjectListNotIncluded(long groupId, long crfId) {

		return _crfSubjectService.getCRFSubjectListNotIncluded(groupId, crfId);
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
	public java.util.ArrayList<ecrf.user.model.Subject> getSubjectList(
		long groupId) {

		return _crfSubjectService.getSubjectList(groupId);
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