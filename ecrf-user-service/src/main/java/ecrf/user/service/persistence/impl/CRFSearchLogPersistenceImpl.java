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

import ecrf.user.exception.NoSuchCRFSearchLogException;
import ecrf.user.model.CRFSearchLog;
import ecrf.user.model.impl.CRFSearchLogImpl;
import ecrf.user.model.impl.CRFSearchLogModelImpl;
import ecrf.user.service.persistence.CRFSearchLogPersistence;
import ecrf.user.service.persistence.CRFSearchLogUtil;
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
 * The persistence implementation for the crf search log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @generated
 */
@Component(service = CRFSearchLogPersistence.class)
public class CRFSearchLogPersistenceImpl
	extends BasePersistenceImpl<CRFSearchLog>
	implements CRFSearchLogPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CRFSearchLogUtil</code> to access the crf search log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CRFSearchLogImpl.class.getName();

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
	 * Returns all the crf search logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf search logs
	 */
	@Override
	public List<CRFSearchLog> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf search logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of matching crf search logs
	 */
	@Override
	public List<CRFSearchLog> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf search logs
	 */
	@Override
	public List<CRFSearchLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf search logs
	 */
	@Override
	public List<CRFSearchLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator,
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

		List<CRFSearchLog> list = null;

		if (useFinderCache) {
			list = (List<CRFSearchLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFSearchLog crfSearchLog : list) {
					if (!uuid.equals(crfSearchLog.getUuid())) {
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

			sb.append(_SQL_SELECT_CRFSEARCHLOG_WHERE);

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
				sb.append(CRFSearchLogModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFSearchLog>)QueryUtil.list(
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
	 * Returns the first crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog findByUuid_First(
			String uuid, OrderByComparator<CRFSearchLog> orderByComparator)
		throws NoSuchCRFSearchLogException {

		CRFSearchLog crfSearchLog = fetchByUuid_First(uuid, orderByComparator);

		if (crfSearchLog != null) {
			return crfSearchLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFSearchLogException(sb.toString());
	}

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog fetchByUuid_First(
		String uuid, OrderByComparator<CRFSearchLog> orderByComparator) {

		List<CRFSearchLog> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog findByUuid_Last(
			String uuid, OrderByComparator<CRFSearchLog> orderByComparator)
		throws NoSuchCRFSearchLogException {

		CRFSearchLog crfSearchLog = fetchByUuid_Last(uuid, orderByComparator);

		if (crfSearchLog != null) {
			return crfSearchLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFSearchLogException(sb.toString());
	}

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog fetchByUuid_Last(
		String uuid, OrderByComparator<CRFSearchLog> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CRFSearchLog> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf search logs before and after the current crf search log in the ordered set where uuid = &#63;.
	 *
	 * @param searchLogId the primary key of the current crf search log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	@Override
	public CRFSearchLog[] findByUuid_PrevAndNext(
			long searchLogId, String uuid,
			OrderByComparator<CRFSearchLog> orderByComparator)
		throws NoSuchCRFSearchLogException {

		uuid = Objects.toString(uuid, "");

		CRFSearchLog crfSearchLog = findByPrimaryKey(searchLogId);

		Session session = null;

		try {
			session = openSession();

			CRFSearchLog[] array = new CRFSearchLogImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, crfSearchLog, uuid, orderByComparator, true);

			array[1] = crfSearchLog;

			array[2] = getByUuid_PrevAndNext(
				session, crfSearchLog, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFSearchLog getByUuid_PrevAndNext(
		Session session, CRFSearchLog crfSearchLog, String uuid,
		OrderByComparator<CRFSearchLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFSEARCHLOG_WHERE);

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
			sb.append(CRFSearchLogModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfSearchLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSearchLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf search logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CRFSearchLog crfSearchLog :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfSearchLog);
		}
	}

	/**
	 * Returns the number of crf search logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf search logs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFSEARCHLOG_WHERE);

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
		"crfSearchLog.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(crfSearchLog.uuid IS NULL OR crfSearchLog.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the crf search log where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFSearchLogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFSearchLogException {

		CRFSearchLog crfSearchLog = fetchByUUID_G(uuid, groupId);

		if (crfSearchLog == null) {
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

			throw new NoSuchCRFSearchLogException(sb.toString());
		}

		return crfSearchLog;
	}

	/**
	 * Returns the crf search log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the crf search log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog fetchByUUID_G(
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

		if (result instanceof CRFSearchLog) {
			CRFSearchLog crfSearchLog = (CRFSearchLog)result;

			if (!Objects.equals(uuid, crfSearchLog.getUuid()) ||
				(groupId != crfSearchLog.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CRFSEARCHLOG_WHERE);

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

				List<CRFSearchLog> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CRFSearchLog crfSearchLog = list.get(0);

					result = crfSearchLog;

					cacheResult(crfSearchLog);
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
			return (CRFSearchLog)result;
		}
	}

	/**
	 * Removes the crf search log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf search log that was removed
	 */
	@Override
	public CRFSearchLog removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFSearchLogException {

		CRFSearchLog crfSearchLog = findByUUID_G(uuid, groupId);

		return remove(crfSearchLog);
	}

	/**
	 * Returns the number of crf search logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf search logs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFSEARCHLOG_WHERE);

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
		"crfSearchLog.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(crfSearchLog.uuid IS NULL OR crfSearchLog.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"crfSearchLog.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf search logs
	 */
	@Override
	public List<CRFSearchLog> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of matching crf search logs
	 */
	@Override
	public List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf search logs
	 */
	@Override
	public List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf search logs
	 */
	@Override
	public List<CRFSearchLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSearchLog> orderByComparator,
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

		List<CRFSearchLog> list = null;

		if (useFinderCache) {
			list = (List<CRFSearchLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFSearchLog crfSearchLog : list) {
					if (!uuid.equals(crfSearchLog.getUuid()) ||
						(companyId != crfSearchLog.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CRFSEARCHLOG_WHERE);

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
				sb.append(CRFSearchLogModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFSearchLog>)QueryUtil.list(
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
	 * Returns the first crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFSearchLog> orderByComparator)
		throws NoSuchCRFSearchLogException {

		CRFSearchLog crfSearchLog = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (crfSearchLog != null) {
			return crfSearchLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFSearchLogException(sb.toString());
	}

	/**
	 * Returns the first crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		List<CRFSearchLog> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFSearchLog> orderByComparator)
		throws NoSuchCRFSearchLogException {

		CRFSearchLog crfSearchLog = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (crfSearchLog != null) {
			return crfSearchLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFSearchLogException(sb.toString());
	}

	/**
	 * Returns the last crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFSearchLog> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CRFSearchLog> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf search logs before and after the current crf search log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param searchLogId the primary key of the current crf search log
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	@Override
	public CRFSearchLog[] findByUuid_C_PrevAndNext(
			long searchLogId, String uuid, long companyId,
			OrderByComparator<CRFSearchLog> orderByComparator)
		throws NoSuchCRFSearchLogException {

		uuid = Objects.toString(uuid, "");

		CRFSearchLog crfSearchLog = findByPrimaryKey(searchLogId);

		Session session = null;

		try {
			session = openSession();

			CRFSearchLog[] array = new CRFSearchLogImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, crfSearchLog, uuid, companyId, orderByComparator,
				true);

			array[1] = crfSearchLog;

			array[2] = getByUuid_C_PrevAndNext(
				session, crfSearchLog, uuid, companyId, orderByComparator,
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

	protected CRFSearchLog getByUuid_C_PrevAndNext(
		Session session, CRFSearchLog crfSearchLog, String uuid, long companyId,
		OrderByComparator<CRFSearchLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFSEARCHLOG_WHERE);

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
			sb.append(CRFSearchLogModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfSearchLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSearchLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf search logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CRFSearchLog crfSearchLog :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfSearchLog);
		}
	}

	/**
	 * Returns the number of crf search logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf search logs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFSEARCHLOG_WHERE);

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
		"crfSearchLog.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(crfSearchLog.uuid IS NULL OR crfSearchLog.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"crfSearchLog.companyId = ?";

	private FinderPath _finderPathFetchBySearchLogId;
	private FinderPath _finderPathCountBySearchLogId;

	/**
	 * Returns the crf search log where searchLogId = &#63; or throws a <code>NoSuchCRFSearchLogException</code> if it could not be found.
	 *
	 * @param searchLogId the search log ID
	 * @return the matching crf search log
	 * @throws NoSuchCRFSearchLogException if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog findBySearchLogId(long searchLogId)
		throws NoSuchCRFSearchLogException {

		CRFSearchLog crfSearchLog = fetchBySearchLogId(searchLogId);

		if (crfSearchLog == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("searchLogId=");
			sb.append(searchLogId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCRFSearchLogException(sb.toString());
		}

		return crfSearchLog;
	}

	/**
	 * Returns the crf search log where searchLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param searchLogId the search log ID
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog fetchBySearchLogId(long searchLogId) {
		return fetchBySearchLogId(searchLogId, true);
	}

	/**
	 * Returns the crf search log where searchLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param searchLogId the search log ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf search log, or <code>null</code> if a matching crf search log could not be found
	 */
	@Override
	public CRFSearchLog fetchBySearchLogId(
		long searchLogId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {searchLogId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySearchLogId, finderArgs, this);
		}

		if (result instanceof CRFSearchLog) {
			CRFSearchLog crfSearchLog = (CRFSearchLog)result;

			if (searchLogId != crfSearchLog.getSearchLogId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CRFSEARCHLOG_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHLOGID_SEARCHLOGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(searchLogId);

				List<CRFSearchLog> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySearchLogId, finderArgs, list);
					}
				}
				else {
					CRFSearchLog crfSearchLog = list.get(0);

					result = crfSearchLog;

					cacheResult(crfSearchLog);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBySearchLogId, finderArgs);
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
			return (CRFSearchLog)result;
		}
	}

	/**
	 * Removes the crf search log where searchLogId = &#63; from the database.
	 *
	 * @param searchLogId the search log ID
	 * @return the crf search log that was removed
	 */
	@Override
	public CRFSearchLog removeBySearchLogId(long searchLogId)
		throws NoSuchCRFSearchLogException {

		CRFSearchLog crfSearchLog = findBySearchLogId(searchLogId);

		return remove(crfSearchLog);
	}

	/**
	 * Returns the number of crf search logs where searchLogId = &#63;.
	 *
	 * @param searchLogId the search log ID
	 * @return the number of matching crf search logs
	 */
	@Override
	public int countBySearchLogId(long searchLogId) {
		FinderPath finderPath = _finderPathCountBySearchLogId;

		Object[] finderArgs = new Object[] {searchLogId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFSEARCHLOG_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHLOGID_SEARCHLOGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(searchLogId);

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

	private static final String _FINDER_COLUMN_SEARCHLOGID_SEARCHLOGID_2 =
		"crfSearchLog.searchLogId = ?";

	public CRFSearchLogPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CRFSearchLog.class);

		setModelImplClass(CRFSearchLogImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the crf search log in the entity cache if it is enabled.
	 *
	 * @param crfSearchLog the crf search log
	 */
	@Override
	public void cacheResult(CRFSearchLog crfSearchLog) {
		entityCache.putResult(
			entityCacheEnabled, CRFSearchLogImpl.class,
			crfSearchLog.getPrimaryKey(), crfSearchLog);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {crfSearchLog.getUuid(), crfSearchLog.getGroupId()},
			crfSearchLog);

		finderCache.putResult(
			_finderPathFetchBySearchLogId,
			new Object[] {crfSearchLog.getSearchLogId()}, crfSearchLog);

		crfSearchLog.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the crf search logs in the entity cache if it is enabled.
	 *
	 * @param crfSearchLogs the crf search logs
	 */
	@Override
	public void cacheResult(List<CRFSearchLog> crfSearchLogs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (crfSearchLogs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CRFSearchLog crfSearchLog : crfSearchLogs) {
			if (entityCache.getResult(
					entityCacheEnabled, CRFSearchLogImpl.class,
					crfSearchLog.getPrimaryKey()) == null) {

				cacheResult(crfSearchLog);
			}
			else {
				crfSearchLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all crf search logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CRFSearchLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the crf search log.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CRFSearchLog crfSearchLog) {
		entityCache.removeResult(
			entityCacheEnabled, CRFSearchLogImpl.class,
			crfSearchLog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CRFSearchLogModelImpl)crfSearchLog, true);
	}

	@Override
	public void clearCache(List<CRFSearchLog> crfSearchLogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CRFSearchLog crfSearchLog : crfSearchLogs) {
			entityCache.removeResult(
				entityCacheEnabled, CRFSearchLogImpl.class,
				crfSearchLog.getPrimaryKey());

			clearUniqueFindersCache((CRFSearchLogModelImpl)crfSearchLog, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CRFSearchLogImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CRFSearchLogModelImpl crfSearchLogModelImpl) {

		Object[] args = new Object[] {
			crfSearchLogModelImpl.getUuid(), crfSearchLogModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, crfSearchLogModelImpl, false);

		args = new Object[] {crfSearchLogModelImpl.getSearchLogId()};

		finderCache.putResult(
			_finderPathCountBySearchLogId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySearchLogId, args, crfSearchLogModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CRFSearchLogModelImpl crfSearchLogModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfSearchLogModelImpl.getUuid(),
				crfSearchLogModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((crfSearchLogModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfSearchLogModelImpl.getOriginalUuid(),
				crfSearchLogModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfSearchLogModelImpl.getSearchLogId()
			};

			finderCache.removeResult(_finderPathCountBySearchLogId, args);
			finderCache.removeResult(_finderPathFetchBySearchLogId, args);
		}

		if ((crfSearchLogModelImpl.getColumnBitmask() &
			 _finderPathFetchBySearchLogId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfSearchLogModelImpl.getOriginalSearchLogId()
			};

			finderCache.removeResult(_finderPathCountBySearchLogId, args);
			finderCache.removeResult(_finderPathFetchBySearchLogId, args);
		}
	}

	/**
	 * Creates a new crf search log with the primary key. Does not add the crf search log to the database.
	 *
	 * @param searchLogId the primary key for the new crf search log
	 * @return the new crf search log
	 */
	@Override
	public CRFSearchLog create(long searchLogId) {
		CRFSearchLog crfSearchLog = new CRFSearchLogImpl();

		crfSearchLog.setNew(true);
		crfSearchLog.setPrimaryKey(searchLogId);

		String uuid = PortalUUIDUtil.generate();

		crfSearchLog.setUuid(uuid);

		crfSearchLog.setCompanyId(CompanyThreadLocal.getCompanyId());

		return crfSearchLog;
	}

	/**
	 * Removes the crf search log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log that was removed
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	@Override
	public CRFSearchLog remove(long searchLogId)
		throws NoSuchCRFSearchLogException {

		return remove((Serializable)searchLogId);
	}

	/**
	 * Removes the crf search log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the crf search log
	 * @return the crf search log that was removed
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	@Override
	public CRFSearchLog remove(Serializable primaryKey)
		throws NoSuchCRFSearchLogException {

		Session session = null;

		try {
			session = openSession();

			CRFSearchLog crfSearchLog = (CRFSearchLog)session.get(
				CRFSearchLogImpl.class, primaryKey);

			if (crfSearchLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCRFSearchLogException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(crfSearchLog);
		}
		catch (NoSuchCRFSearchLogException noSuchEntityException) {
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
	protected CRFSearchLog removeImpl(CRFSearchLog crfSearchLog) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(crfSearchLog)) {
				crfSearchLog = (CRFSearchLog)session.get(
					CRFSearchLogImpl.class, crfSearchLog.getPrimaryKeyObj());
			}

			if (crfSearchLog != null) {
				session.delete(crfSearchLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (crfSearchLog != null) {
			clearCache(crfSearchLog);
		}

		return crfSearchLog;
	}

	@Override
	public CRFSearchLog updateImpl(CRFSearchLog crfSearchLog) {
		boolean isNew = crfSearchLog.isNew();

		if (!(crfSearchLog instanceof CRFSearchLogModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(crfSearchLog.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					crfSearchLog);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in crfSearchLog proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CRFSearchLog implementation " +
					crfSearchLog.getClass());
		}

		CRFSearchLogModelImpl crfSearchLogModelImpl =
			(CRFSearchLogModelImpl)crfSearchLog;

		if (Validator.isNull(crfSearchLog.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			crfSearchLog.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (crfSearchLog.getCreateDate() == null)) {
			if (serviceContext == null) {
				crfSearchLog.setCreateDate(date);
			}
			else {
				crfSearchLog.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!crfSearchLogModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				crfSearchLog.setModifiedDate(date);
			}
			else {
				crfSearchLog.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(crfSearchLog);

				crfSearchLog.setNew(false);
			}
			else {
				crfSearchLog = (CRFSearchLog)session.merge(crfSearchLog);
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
			Object[] args = new Object[] {crfSearchLogModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				crfSearchLogModelImpl.getUuid(),
				crfSearchLogModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((crfSearchLogModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfSearchLogModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {crfSearchLogModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((crfSearchLogModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfSearchLogModelImpl.getOriginalUuid(),
					crfSearchLogModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					crfSearchLogModelImpl.getUuid(),
					crfSearchLogModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CRFSearchLogImpl.class,
			crfSearchLog.getPrimaryKey(), crfSearchLog, false);

		clearUniqueFindersCache(crfSearchLogModelImpl, false);
		cacheUniqueFindersCache(crfSearchLogModelImpl);

		crfSearchLog.resetOriginalValues();

		return crfSearchLog;
	}

	/**
	 * Returns the crf search log with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the crf search log
	 * @return the crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	@Override
	public CRFSearchLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCRFSearchLogException {

		CRFSearchLog crfSearchLog = fetchByPrimaryKey(primaryKey);

		if (crfSearchLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCRFSearchLogException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return crfSearchLog;
	}

	/**
	 * Returns the crf search log with the primary key or throws a <code>NoSuchCRFSearchLogException</code> if it could not be found.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log
	 * @throws NoSuchCRFSearchLogException if a crf search log with the primary key could not be found
	 */
	@Override
	public CRFSearchLog findByPrimaryKey(long searchLogId)
		throws NoSuchCRFSearchLogException {

		return findByPrimaryKey((Serializable)searchLogId);
	}

	/**
	 * Returns the crf search log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchLogId the primary key of the crf search log
	 * @return the crf search log, or <code>null</code> if a crf search log with the primary key could not be found
	 */
	@Override
	public CRFSearchLog fetchByPrimaryKey(long searchLogId) {
		return fetchByPrimaryKey((Serializable)searchLogId);
	}

	/**
	 * Returns all the crf search logs.
	 *
	 * @return the crf search logs
	 */
	@Override
	public List<CRFSearchLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @return the range of crf search logs
	 */
	@Override
	public List<CRFSearchLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf search logs
	 */
	@Override
	public List<CRFSearchLog> findAll(
		int start, int end, OrderByComparator<CRFSearchLog> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf search logs
	 * @param end the upper bound of the range of crf search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf search logs
	 */
	@Override
	public List<CRFSearchLog> findAll(
		int start, int end, OrderByComparator<CRFSearchLog> orderByComparator,
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

		List<CRFSearchLog> list = null;

		if (useFinderCache) {
			list = (List<CRFSearchLog>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CRFSEARCHLOG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CRFSEARCHLOG;

				sql = sql.concat(CRFSearchLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CRFSearchLog>)QueryUtil.list(
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
	 * Removes all the crf search logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CRFSearchLog crfSearchLog : findAll()) {
			remove(crfSearchLog);
		}
	}

	/**
	 * Returns the number of crf search logs.
	 *
	 * @return the number of crf search logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CRFSEARCHLOG);

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
		return "searchLogId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CRFSEARCHLOG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CRFSearchLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the crf search log persistence.
	 */
	@Activate
	public void activate() {
		CRFSearchLogModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CRFSearchLogModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSearchLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSearchLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSearchLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSearchLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CRFSearchLogModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSearchLogImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFSearchLogModelImpl.UUID_COLUMN_BITMASK |
			CRFSearchLogModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSearchLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSearchLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFSearchLogModelImpl.UUID_COLUMN_BITMASK |
			CRFSearchLogModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchBySearchLogId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSearchLogImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySearchLogId",
			new String[] {Long.class.getName()},
			CRFSearchLogModelImpl.SEARCHLOGID_COLUMN_BITMASK);

		_finderPathCountBySearchLogId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySearchLogId",
			new String[] {Long.class.getName()});

		_setCRFSearchLogUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCRFSearchLogUtilPersistence(null);

		entityCache.removeCache(CRFSearchLogImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setCRFSearchLogUtilPersistence(
		CRFSearchLogPersistence crfSearchLogPersistence) {

		try {
			Field field = CRFSearchLogUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, crfSearchLogPersistence);
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
				"value.object.column.bitmask.enabled.ecrf.user.model.CRFSearchLog"),
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

	private static final String _SQL_SELECT_CRFSEARCHLOG =
		"SELECT crfSearchLog FROM CRFSearchLog crfSearchLog";

	private static final String _SQL_SELECT_CRFSEARCHLOG_WHERE =
		"SELECT crfSearchLog FROM CRFSearchLog crfSearchLog WHERE ";

	private static final String _SQL_COUNT_CRFSEARCHLOG =
		"SELECT COUNT(crfSearchLog) FROM CRFSearchLog crfSearchLog";

	private static final String _SQL_COUNT_CRFSEARCHLOG_WHERE =
		"SELECT COUNT(crfSearchLog) FROM CRFSearchLog crfSearchLog WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "crfSearchLog.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CRFSearchLog exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CRFSearchLog exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CRFSearchLogPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}