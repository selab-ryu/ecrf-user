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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for CRFResearcher. This utility wraps
 * <code>ecrf.user.service.impl.CRFResearcherServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ryu W.C.
 * @see CRFResearcherService
 * @generated
 */
public class CRFResearcherServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ecrf.user.service.impl.CRFResearcherServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.ArrayList<ecrf.user.model.custom.CRFResearcherInfo>
		getCRFAllResearcherInfoList(long groupId, long crfId) {

		return getService().getCRFAllResearcherInfoList(groupId, crfId);
	}

	public static java.util.ArrayList<ecrf.user.model.custom.CRFResearcherInfo>
		getCRFResearcherList(long groupId, long crfId) {

		return getService().getCRFResearcherList(groupId, crfId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CRFResearcherService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CRFResearcherService, CRFResearcherService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CRFResearcherService.class);

		ServiceTracker<CRFResearcherService, CRFResearcherService>
			serviceTracker =
				new ServiceTracker<CRFResearcherService, CRFResearcherService>(
					bundle.getBundleContext(), CRFResearcherService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}