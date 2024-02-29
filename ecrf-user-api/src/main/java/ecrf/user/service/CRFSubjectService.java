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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import ecrf.user.model.Subject;
import ecrf.user.model.custom.CRFSubjectInfo;

import java.util.ArrayList;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for CRFSubject. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Ryu W.C.
 * @see CRFSubjectServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CRFSubjectService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>ecrf.user.service.impl.CRFSubjectServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the crf subject remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CRFSubjectServiceUtil} if injection and service tracking are not available.
	 */
	@JSONWebService(value = "get-all-crf-subject-info-list")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<CRFSubjectInfo> getAllCRFSubjectInfoList(
		long groupId, long crfId);

	@JSONWebService(value = "get-subject-list-by-experimental-group")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<Subject> getCRFSubjectByExGroup(
		long groupId, long crfId, String exGroup);

	@JSONWebService(value = "get-crf-subject-list")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<CRFSubjectInfo> getCRFSubjectList(
		long groupId, long crfId);

	@JSONWebService(value = "get-crf-subject-list-not-included")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<Subject> getCRFSubjectListNotIncluded(
		long groupId, long crfId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@JSONWebService(value = "get-subject-list")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<Subject> getSubjectList(long groupId);

}