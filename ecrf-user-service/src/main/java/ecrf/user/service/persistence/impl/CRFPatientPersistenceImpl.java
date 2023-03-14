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

package ecrf.user.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import ecrf.user.exception.NoSuchCRFPatientException;
import ecrf.user.model.CRFPatient;
import ecrf.user.model.impl.CRFPatientImpl;
import ecrf.user.model.impl.CRFPatientModelImpl;
import ecrf.user.service.persistence.CRFPatientPersistence;
import ecrf.user.service.persistence.CRFPatientUtil;
import ecrf.user.service.persistence.impl.constants.ECPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the crf patient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @generated
 */
@Component(service = CRFPatientPersistence.class)
public class CRFPatientPersistenceImpl
	extends BasePersistenceImpl<CRFPatient> implements CRFPatientPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CRFPatientUtil</code> to access the crf patient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CRFPatientImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the crf patients where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf patients
	 */
	@Override
	public List<CRFPatient> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf patients where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf patients where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf patients where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CRFPatient> list = null;

		if (useFinderCache) {
			list = (List<CRFPatient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFPatient crfPatient : list) {
					if (!uuid.equals(crfPatient.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CRFPatient>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByUuid_First(
			String uuid, OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByUuid_First(uuid, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByUuid_First(
		String uuid, OrderByComparator<CRFPatient> orderByComparator) {

		List<CRFPatient> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByUuid_Last(
			String uuid, OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByUuid_Last(uuid, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByUuid_Last(
		String uuid, OrderByComparator<CRFPatient> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CRFPatient> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where uuid = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient[] findByUuid_PrevAndNext(
			long crfPatientId, String uuid,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		uuid = Objects.toString(uuid, "");

		CRFPatient crfPatient = findByPrimaryKey(crfPatientId);

		Session session = null;

		try {
			session = openSession();

			CRFPatient[] array = new CRFPatientImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, crfPatient, uuid, orderByComparator, true);

			array[1] = crfPatient;

			array[2] = getByUuid_PrevAndNext(
				session, crfPatient, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFPatient getByUuid_PrevAndNext(
		Session session, CRFPatient crfPatient, String uuid,
		OrderByComparator<CRFPatient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfPatient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFPatient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf patients where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CRFPatient crfPatient :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfPatient);
		}
	}

	/**
	 * Returns the number of crf patients where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf patients
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFPATIENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"crfPatient.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(crfPatient.uuid IS NULL OR crfPatient.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the crf patient where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFPatientException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByUUID_G(uuid, groupId);

		if (crfPatient == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCRFPatientException(sb.toString());
		}

		return crfPatient;
	}

	/**
	 * Returns the crf patient where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the crf patient where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof CRFPatient) {
			CRFPatient crfPatient = (CRFPatient)result;

			if (!Objects.equals(uuid, crfPatient.getUuid()) ||
				(groupId != crfPatient.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<CRFPatient> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CRFPatient crfPatient = list.get(0);

					result = crfPatient;

					cacheResult(crfPatient);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CRFPatient)result;
		}
	}

	/**
	 * Removes the crf patient where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf patient that was removed
	 */
	@Override
	public CRFPatient removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = findByUUID_G(uuid, groupId);

		return remove(crfPatient);
	}

	/**
	 * Returns the number of crf patients where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf patients
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFPATIENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"crfPatient.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(crfPatient.uuid IS NULL OR crfPatient.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"crfPatient.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf patients
	 */
	@Override
	public List<CRFPatient> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CRFPatient> list = null;

		if (useFinderCache) {
			list = (List<CRFPatient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFPatient crfPatient : list) {
					if (!uuid.equals(crfPatient.getUuid()) ||
						(companyId != crfPatient.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<CRFPatient>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the first crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFPatient> orderByComparator) {

		List<CRFPatient> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the last crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFPatient> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CRFPatient> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient[] findByUuid_C_PrevAndNext(
			long crfPatientId, String uuid, long companyId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		uuid = Objects.toString(uuid, "");

		CRFPatient crfPatient = findByPrimaryKey(crfPatientId);

		Session session = null;

		try {
			session = openSession();

			CRFPatient[] array = new CRFPatientImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, crfPatient, uuid, companyId, orderByComparator, true);

			array[1] = crfPatient;

			array[2] = getByUuid_C_PrevAndNext(
				session, crfPatient, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFPatient getByUuid_C_PrevAndNext(
		Session session, CRFPatient crfPatient, String uuid, long companyId,
		OrderByComparator<CRFPatient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfPatient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFPatient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf patients where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CRFPatient crfPatient :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfPatient);
		}
	}

	/**
	 * Returns the number of crf patients where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf patients
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFPATIENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"crfPatient.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(crfPatient.uuid IS NULL OR crfPatient.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"crfPatient.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the crf patients where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf patients
	 */
	@Override
	public List<CRFPatient> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf patients where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<CRFPatient> list = null;

		if (useFinderCache) {
			list = (List<CRFPatient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFPatient crfPatient : list) {
					if (groupId != crfPatient.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<CRFPatient>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByGroupId_First(
			long groupId, OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByGroupId_First(
			groupId, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByGroupId_First(
		long groupId, OrderByComparator<CRFPatient> orderByComparator) {

		List<CRFPatient> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByGroupId_Last(
			long groupId, OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByGroupId_Last(groupId, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFPatient> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CRFPatient> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where groupId = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient[] findByGroupId_PrevAndNext(
			long crfPatientId, long groupId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = findByPrimaryKey(crfPatientId);

		Session session = null;

		try {
			session = openSession();

			CRFPatient[] array = new CRFPatientImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, crfPatient, groupId, orderByComparator, true);

			array[1] = crfPatient;

			array[2] = getByGroupId_PrevAndNext(
				session, crfPatient, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFPatient getByGroupId_PrevAndNext(
		Session session, CRFPatient crfPatient, long groupId,
		OrderByComparator<CRFPatient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfPatient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFPatient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf patients where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (CRFPatient crfPatient :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfPatient);
		}
	}

	/**
	 * Returns the number of crf patients where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf patients
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFPATIENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"crfPatient.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C;
	private FinderPath _finderPathWithoutPaginationFindByG_C;
	private FinderPath _finderPathCountByG_C;

	/**
	 * Returns all the crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf patients
	 */
	@Override
	public List<CRFPatient> findByG_C(long groupId, long crfId) {
		return findByG_C(
			groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByG_C(
		long groupId, long crfId, int start, int end) {

		return findByG_C(groupId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return findByG_C(groupId, crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C;
				finderArgs = new Object[] {groupId, crfId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C;
			finderArgs = new Object[] {
				groupId, crfId, start, end, orderByComparator
			};
		}

		List<CRFPatient> list = null;

		if (useFinderCache) {
			list = (List<CRFPatient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFPatient crfPatient : list) {
					if ((groupId != crfPatient.getGroupId()) ||
						(crfId != crfPatient.getCrfId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				list = (List<CRFPatient>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByG_C_First(
			groupId, crfId, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFPatient> orderByComparator) {

		List<CRFPatient> list = findByG_C(
			groupId, crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByG_C_Last(
			groupId, crfId, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFPatient> orderByComparator) {

		int count = countByG_C(groupId, crfId);

		if (count == 0) {
			return null;
		}

		List<CRFPatient> list = findByG_C(
			groupId, crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient[] findByG_C_PrevAndNext(
			long crfPatientId, long groupId, long crfId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = findByPrimaryKey(crfPatientId);

		Session session = null;

		try {
			session = openSession();

			CRFPatient[] array = new CRFPatientImpl[3];

			array[0] = getByG_C_PrevAndNext(
				session, crfPatient, groupId, crfId, orderByComparator, true);

			array[1] = crfPatient;

			array[2] = getByG_C_PrevAndNext(
				session, crfPatient, groupId, crfId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFPatient getByG_C_PrevAndNext(
		Session session, CRFPatient crfPatient, long groupId, long crfId,
		OrderByComparator<CRFPatient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CRFID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(crfId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfPatient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFPatient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf patients where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByG_C(long groupId, long crfId) {
		for (CRFPatient crfPatient :
				findByG_C(
					groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfPatient);
		}
	}

	/**
	 * Returns the number of crf patients where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf patients
	 */
	@Override
	public int countByG_C(long groupId, long crfId) {
		FinderPath finderPath = _finderPathCountByG_C;

		Object[] finderArgs = new Object[] {groupId, crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFPATIENT_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CRFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_C_GROUPID_2 =
		"crfPatient.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_CRFID_2 =
		"crfPatient.crfId = ?";

	private FinderPath _finderPathWithPaginationFindByG_PA;
	private FinderPath _finderPathWithoutPaginationFindByG_PA;
	private FinderPath _finderPathCountByG_PA;

	/**
	 * Returns all the crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @return the matching crf patients
	 */
	@Override
	public List<CRFPatient> findByG_PA(long groupId, long patientId) {
		return findByG_PA(
			groupId, patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByG_PA(
		long groupId, long patientId, int start, int end) {

		return findByG_PA(groupId, patientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByG_PA(
		long groupId, long patientId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator) {

		return findByG_PA(
			groupId, patientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf patients
	 */
	@Override
	public List<CRFPatient> findByG_PA(
		long groupId, long patientId, int start, int end,
		OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_PA;
				finderArgs = new Object[] {groupId, patientId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_PA;
			finderArgs = new Object[] {
				groupId, patientId, start, end, orderByComparator
			};
		}

		List<CRFPatient> list = null;

		if (useFinderCache) {
			list = (List<CRFPatient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFPatient crfPatient : list) {
					if ((groupId != crfPatient.getGroupId()) ||
						(patientId != crfPatient.getPatientId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

			sb.append(_FINDER_COLUMN_G_PA_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_PA_PATIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(patientId);

				list = (List<CRFPatient>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByG_PA_First(
			long groupId, long patientId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByG_PA_First(
			groupId, patientId, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the first crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByG_PA_First(
		long groupId, long patientId,
		OrderByComparator<CRFPatient> orderByComparator) {

		List<CRFPatient> list = findByG_PA(
			groupId, patientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient
	 * @throws NoSuchCRFPatientException if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient findByG_PA_Last(
			long groupId, long patientId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByG_PA_Last(
			groupId, patientId, orderByComparator);

		if (crfPatient != null) {
			return crfPatient;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchCRFPatientException(sb.toString());
	}

	/**
	 * Returns the last crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf patient, or <code>null</code> if a matching crf patient could not be found
	 */
	@Override
	public CRFPatient fetchByG_PA_Last(
		long groupId, long patientId,
		OrderByComparator<CRFPatient> orderByComparator) {

		int count = countByG_PA(groupId, patientId);

		if (count == 0) {
			return null;
		}

		List<CRFPatient> list = findByG_PA(
			groupId, patientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf patients before and after the current crf patient in the ordered set where groupId = &#63; and patientId = &#63;.
	 *
	 * @param crfPatientId the primary key of the current crf patient
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient[] findByG_PA_PrevAndNext(
			long crfPatientId, long groupId, long patientId,
			OrderByComparator<CRFPatient> orderByComparator)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = findByPrimaryKey(crfPatientId);

		Session session = null;

		try {
			session = openSession();

			CRFPatient[] array = new CRFPatientImpl[3];

			array[0] = getByG_PA_PrevAndNext(
				session, crfPatient, groupId, patientId, orderByComparator,
				true);

			array[1] = crfPatient;

			array[2] = getByG_PA_PrevAndNext(
				session, crfPatient, groupId, patientId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFPatient getByG_PA_PrevAndNext(
		Session session, CRFPatient crfPatient, long groupId, long patientId,
		OrderByComparator<CRFPatient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFPATIENT_WHERE);

		sb.append(_FINDER_COLUMN_G_PA_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_PA_PATIENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CRFPatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(patientId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfPatient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFPatient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf patients where groupId = &#63; and patientId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 */
	@Override
	public void removeByG_PA(long groupId, long patientId) {
		for (CRFPatient crfPatient :
				findByG_PA(
					groupId, patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfPatient);
		}
	}

	/**
	 * Returns the number of crf patients where groupId = &#63; and patientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param patientId the patient ID
	 * @return the number of matching crf patients
	 */
	@Override
	public int countByG_PA(long groupId, long patientId) {
		FinderPath finderPath = _finderPathCountByG_PA;

		Object[] finderArgs = new Object[] {groupId, patientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFPATIENT_WHERE);

			sb.append(_FINDER_COLUMN_G_PA_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_PA_PATIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(patientId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_PA_GROUPID_2 =
		"crfPatient.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_PA_PATIENTID_2 =
		"crfPatient.patientId = ?";

	public CRFPatientPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CRFPatient.class);

		setModelImplClass(CRFPatientImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the crf patient in the entity cache if it is enabled.
	 *
	 * @param crfPatient the crf patient
	 */
	@Override
	public void cacheResult(CRFPatient crfPatient) {
		entityCache.putResult(
			entityCacheEnabled, CRFPatientImpl.class,
			crfPatient.getPrimaryKey(), crfPatient);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {crfPatient.getUuid(), crfPatient.getGroupId()},
			crfPatient);

		crfPatient.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the crf patients in the entity cache if it is enabled.
	 *
	 * @param crfPatients the crf patients
	 */
	@Override
	public void cacheResult(List<CRFPatient> crfPatients) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (crfPatients.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CRFPatient crfPatient : crfPatients) {
			if (entityCache.getResult(
					entityCacheEnabled, CRFPatientImpl.class,
					crfPatient.getPrimaryKey()) == null) {

				cacheResult(crfPatient);
			}
			else {
				crfPatient.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all crf patients.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CRFPatientImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the crf patient.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CRFPatient crfPatient) {
		entityCache.removeResult(
			entityCacheEnabled, CRFPatientImpl.class,
			crfPatient.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CRFPatientModelImpl)crfPatient, true);
	}

	@Override
	public void clearCache(List<CRFPatient> crfPatients) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CRFPatient crfPatient : crfPatients) {
			entityCache.removeResult(
				entityCacheEnabled, CRFPatientImpl.class,
				crfPatient.getPrimaryKey());

			clearUniqueFindersCache((CRFPatientModelImpl)crfPatient, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CRFPatientImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CRFPatientModelImpl crfPatientModelImpl) {

		Object[] args = new Object[] {
			crfPatientModelImpl.getUuid(), crfPatientModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, crfPatientModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CRFPatientModelImpl crfPatientModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfPatientModelImpl.getUuid(), crfPatientModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((crfPatientModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfPatientModelImpl.getOriginalUuid(),
				crfPatientModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new crf patient with the primary key. Does not add the crf patient to the database.
	 *
	 * @param crfPatientId the primary key for the new crf patient
	 * @return the new crf patient
	 */
	@Override
	public CRFPatient create(long crfPatientId) {
		CRFPatient crfPatient = new CRFPatientImpl();

		crfPatient.setNew(true);
		crfPatient.setPrimaryKey(crfPatientId);

		String uuid = PortalUUIDUtil.generate();

		crfPatient.setUuid(uuid);

		crfPatient.setCompanyId(CompanyThreadLocal.getCompanyId());

		return crfPatient;
	}

	/**
	 * Removes the crf patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient that was removed
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient remove(long crfPatientId)
		throws NoSuchCRFPatientException {

		return remove((Serializable)crfPatientId);
	}

	/**
	 * Removes the crf patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the crf patient
	 * @return the crf patient that was removed
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient remove(Serializable primaryKey)
		throws NoSuchCRFPatientException {

		Session session = null;

		try {
			session = openSession();

			CRFPatient crfPatient = (CRFPatient)session.get(
				CRFPatientImpl.class, primaryKey);

			if (crfPatient == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCRFPatientException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(crfPatient);
		}
		catch (NoSuchCRFPatientException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CRFPatient removeImpl(CRFPatient crfPatient) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(crfPatient)) {
				crfPatient = (CRFPatient)session.get(
					CRFPatientImpl.class, crfPatient.getPrimaryKeyObj());
			}

			if (crfPatient != null) {
				session.delete(crfPatient);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (crfPatient != null) {
			clearCache(crfPatient);
		}

		return crfPatient;
	}

	@Override
	public CRFPatient updateImpl(CRFPatient crfPatient) {
		boolean isNew = crfPatient.isNew();

		if (!(crfPatient instanceof CRFPatientModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(crfPatient.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(crfPatient);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in crfPatient proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CRFPatient implementation " +
					crfPatient.getClass());
		}

		CRFPatientModelImpl crfPatientModelImpl =
			(CRFPatientModelImpl)crfPatient;

		if (Validator.isNull(crfPatient.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			crfPatient.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (crfPatient.getCreateDate() == null)) {
			if (serviceContext == null) {
				crfPatient.setCreateDate(date);
			}
			else {
				crfPatient.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!crfPatientModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				crfPatient.setModifiedDate(date);
			}
			else {
				crfPatient.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(crfPatient);

				crfPatient.setNew(false);
			}
			else {
				crfPatient = (CRFPatient)session.merge(crfPatient);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {crfPatientModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				crfPatientModelImpl.getUuid(),
				crfPatientModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {crfPatientModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				crfPatientModelImpl.getGroupId(), crfPatientModelImpl.getCrfId()
			};

			finderCache.removeResult(_finderPathCountByG_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C, args);

			args = new Object[] {
				crfPatientModelImpl.getGroupId(),
				crfPatientModelImpl.getPatientId()
			};

			finderCache.removeResult(_finderPathCountByG_PA, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_PA, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((crfPatientModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfPatientModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {crfPatientModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((crfPatientModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfPatientModelImpl.getOriginalUuid(),
					crfPatientModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					crfPatientModelImpl.getUuid(),
					crfPatientModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((crfPatientModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfPatientModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {crfPatientModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((crfPatientModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfPatientModelImpl.getOriginalGroupId(),
					crfPatientModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);

				args = new Object[] {
					crfPatientModelImpl.getGroupId(),
					crfPatientModelImpl.getCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);
			}

			if ((crfPatientModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_PA.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfPatientModelImpl.getOriginalGroupId(),
					crfPatientModelImpl.getOriginalPatientId()
				};

				finderCache.removeResult(_finderPathCountByG_PA, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_PA, args);

				args = new Object[] {
					crfPatientModelImpl.getGroupId(),
					crfPatientModelImpl.getPatientId()
				};

				finderCache.removeResult(_finderPathCountByG_PA, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_PA, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CRFPatientImpl.class,
			crfPatient.getPrimaryKey(), crfPatient, false);

		clearUniqueFindersCache(crfPatientModelImpl, false);
		cacheUniqueFindersCache(crfPatientModelImpl);

		crfPatient.resetOriginalValues();

		return crfPatient;
	}

	/**
	 * Returns the crf patient with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the crf patient
	 * @return the crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCRFPatientException {

		CRFPatient crfPatient = fetchByPrimaryKey(primaryKey);

		if (crfPatient == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCRFPatientException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return crfPatient;
	}

	/**
	 * Returns the crf patient with the primary key or throws a <code>NoSuchCRFPatientException</code> if it could not be found.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient
	 * @throws NoSuchCRFPatientException if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient findByPrimaryKey(long crfPatientId)
		throws NoSuchCRFPatientException {

		return findByPrimaryKey((Serializable)crfPatientId);
	}

	/**
	 * Returns the crf patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfPatientId the primary key of the crf patient
	 * @return the crf patient, or <code>null</code> if a crf patient with the primary key could not be found
	 */
	@Override
	public CRFPatient fetchByPrimaryKey(long crfPatientId) {
		return fetchByPrimaryKey((Serializable)crfPatientId);
	}

	/**
	 * Returns all the crf patients.
	 *
	 * @return the crf patients
	 */
	@Override
	public List<CRFPatient> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @return the range of crf patients
	 */
	@Override
	public List<CRFPatient> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf patients
	 */
	@Override
	public List<CRFPatient> findAll(
		int start, int end, OrderByComparator<CRFPatient> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFPatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf patients
	 * @param end the upper bound of the range of crf patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf patients
	 */
	@Override
	public List<CRFPatient> findAll(
		int start, int end, OrderByComparator<CRFPatient> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CRFPatient> list = null;

		if (useFinderCache) {
			list = (List<CRFPatient>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CRFPATIENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CRFPATIENT;

				sql = sql.concat(CRFPatientModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CRFPatient>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the crf patients from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CRFPatient crfPatient : findAll()) {
			remove(crfPatient);
		}
	}

	/**
	 * Returns the number of crf patients.
	 *
	 * @return the number of crf patients
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CRFPATIENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "crfPatientId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CRFPATIENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CRFPatientModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the crf patient persistence.
	 */
	@Activate
	public void activate() {
		CRFPatientModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CRFPatientModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CRFPatientModelImpl.UUID_COLUMN_BITMASK |
			CRFPatientModelImpl.CRFID_COLUMN_BITMASK |
			CRFPatientModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFPatientModelImpl.UUID_COLUMN_BITMASK |
			CRFPatientModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFPatientModelImpl.UUID_COLUMN_BITMASK |
			CRFPatientModelImpl.COMPANYID_COLUMN_BITMASK |
			CRFPatientModelImpl.CRFID_COLUMN_BITMASK |
			CRFPatientModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			CRFPatientModelImpl.GROUPID_COLUMN_BITMASK |
			CRFPatientModelImpl.CRFID_COLUMN_BITMASK |
			CRFPatientModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFPatientModelImpl.GROUPID_COLUMN_BITMASK |
			CRFPatientModelImpl.CRFID_COLUMN_BITMASK |
			CRFPatientModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_PA = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_PA",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_PA = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFPatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_PA",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFPatientModelImpl.GROUPID_COLUMN_BITMASK |
			CRFPatientModelImpl.PATIENTID_COLUMN_BITMASK |
			CRFPatientModelImpl.CRFID_COLUMN_BITMASK |
			CRFPatientModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_PA = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_PA",
			new String[] {Long.class.getName(), Long.class.getName()});

		_setCRFPatientUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCRFPatientUtilPersistence(null);

		entityCache.removeCache(CRFPatientImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setCRFPatientUtilPersistence(
		CRFPatientPersistence crfPatientPersistence) {

		try {
			Field field = CRFPatientUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, crfPatientPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = ECPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.ecrf.user.model.CRFPatient"),
			true);
	}

	@Override
	@Reference(
		target = ECPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ECPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CRFPATIENT =
		"SELECT crfPatient FROM CRFPatient crfPatient";

	private static final String _SQL_SELECT_CRFPATIENT_WHERE =
		"SELECT crfPatient FROM CRFPatient crfPatient WHERE ";

	private static final String _SQL_COUNT_CRFPATIENT =
		"SELECT COUNT(crfPatient) FROM CRFPatient crfPatient";

	private static final String _SQL_COUNT_CRFPATIENT_WHERE =
		"SELECT COUNT(crfPatient) FROM CRFPatient crfPatient WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "crfPatient.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CRFPatient exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CRFPatient exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CRFPatientPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}