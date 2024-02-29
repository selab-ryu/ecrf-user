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

/**
 * Provides the remote service utility for CRFSubject. This utility wraps
 * <code>ecrf.user.service.impl.CRFSubjectServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ryu W.C.
 * @see CRFSubjectService
 * @generated
 */
public class CRFSubjectServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.CRFSubjectServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.ArrayList<ecrf.user.model.custom.CRFSubjectInfo>
		getAllCRFSubjectInfoList(long groupId, long crfId) {

		return getService().getAllCRFSubjectInfoList(groupId, crfId);
	}

	public static java.util.ArrayList<ecrf.user.model.Subject>
		getCRFSubjectByExGroup(
			long groupId, long crfId, java.lang.String exGroup) {

		return getService().getCRFSubjectByExGroup(groupId, crfId, exGroup);
	}

	public static java.util.ArrayList<ecrf.user.model.custom.CRFSubjectInfo>
		getCRFSubjectList(long groupId, long crfId) {

		return getService().getCRFSubjectList(groupId, crfId);
	}

	public static java.util.ArrayList<ecrf.user.model.Subject>
		getCRFSubjectListNotIncluded(long groupId, long crfId) {

		return getService().getCRFSubjectListNotIncluded(groupId, crfId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.ArrayList<ecrf.user.model.Subject> getSubjectList(
		long groupId) {

		return getService().getSubjectList(groupId);
	}

	public static CRFSubjectService getService() {
		return _service;
	}

	private static volatile CRFSubjectService _service;

}