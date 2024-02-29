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

package ecrf.user.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import ecrf.user.service.CRFSubjectServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>CRFSubjectServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Ryu W.C.
 * @see CRFSubjectServiceSoap
 * @generated
 */
public class CRFSubjectServiceHttp {

	public static java.util.ArrayList<ecrf.user.model.Subject>
		getCRFSubjectByExGroup(
			HttpPrincipal httpPrincipal, long groupId, long crfId,
			String exGroup) {

		try {
			MethodKey methodKey = new MethodKey(
				CRFSubjectServiceUtil.class, "getCRFSubjectByExGroup",
				_getCRFSubjectByExGroupParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, crfId, exGroup);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.ArrayList<ecrf.user.model.Subject>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.ArrayList<ecrf.user.model.custom.CRFSubjectInfo>
		getCRFSubjectList(
			HttpPrincipal httpPrincipal, long groupId, long crfId) {

		try {
			MethodKey methodKey = new MethodKey(
				CRFSubjectServiceUtil.class, "getCRFSubjectList",
				_getCRFSubjectListParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, crfId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.ArrayList<ecrf.user.model.custom.CRFSubjectInfo>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.ArrayList<ecrf.user.model.custom.CRFSubjectInfo>
		getAllCRFSubjectInfoList(
			HttpPrincipal httpPrincipal, long groupId, long crfId) {

		try {
			MethodKey methodKey = new MethodKey(
				CRFSubjectServiceUtil.class, "getAllCRFSubjectInfoList",
				_getAllCRFSubjectInfoListParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, crfId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.ArrayList<ecrf.user.model.custom.CRFSubjectInfo>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.ArrayList<ecrf.user.model.Subject>
		getCRFSubjectListNotIncluded(
			HttpPrincipal httpPrincipal, long groupId, long crfId) {

		try {
			MethodKey methodKey = new MethodKey(
				CRFSubjectServiceUtil.class, "getCRFSubjectListNotIncluded",
				_getCRFSubjectListNotIncludedParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, crfId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.ArrayList<ecrf.user.model.Subject>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.ArrayList<ecrf.user.model.Subject> getSubjectList(
		HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				CRFSubjectServiceUtil.class, "getSubjectList",
				_getSubjectListParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.ArrayList<ecrf.user.model.Subject>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CRFSubjectServiceHttp.class);

	private static final Class<?>[] _getCRFSubjectByExGroupParameterTypes0 =
		new Class[] {long.class, long.class, String.class};
	private static final Class<?>[] _getCRFSubjectListParameterTypes1 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _getAllCRFSubjectInfoListParameterTypes2 =
		new Class[] {long.class, long.class};
	private static final Class<?>[]
		_getCRFSubjectListNotIncludedParameterTypes3 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getSubjectListParameterTypes5 =
		new Class[] {long.class};

}