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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import ecrf.user.exception.NoSuchCRFAutoqueryException;
import ecrf.user.model.CRFAutoquery;
import ecrf.user.model.impl.CRFAutoqueryImpl;
import ecrf.user.model.impl.CRFAutoqueryModelImpl;
import ecrf.user.service.persistence.CRFAutoqueryPersistence;
import ecrf.user.service.persistence.impl.constants.ECPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the crf autoquery service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @generated
 */
@Component(service = CRFAutoqueryPersistence.class)
public class CRFAutoqueryPersistenceImpl
	extends BasePersistenceImpl<CRFAutoquery>
	implements CRFAutoqueryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CRFAutoqueryUtil</code> to access the crf autoquery persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CRFAutoqueryImpl.class.getName();

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
	 * Returns all the crf autoqueries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
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

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if (!uuid.equals(crfAutoquery.getUuid())) {
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

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

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
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByUuid_First(
			String uuid, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByUuid_First(uuid, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByUuid_First(
		String uuid, OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByUuid_Last(
			String uuid, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByUuid_Last(uuid, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByUuid_Last(
		String uuid, OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where uuid = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery[] findByUuid_PrevAndNext(
			long autoQueryId, String uuid,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		uuid = Objects.toString(uuid, "");

		CRFAutoquery crfAutoquery = findByPrimaryKey(autoQueryId);

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery[] array = new CRFAutoqueryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, crfAutoquery, uuid, orderByComparator, true);

			array[1] = crfAutoquery;

			array[2] = getByUuid_PrevAndNext(
				session, crfAutoquery, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFAutoquery getByUuid_PrevAndNext(
		Session session, CRFAutoquery crfAutoquery, String uuid,
		OrderByComparator<CRFAutoquery> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

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
			sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfAutoquery)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFAutoquery> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf autoqueries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CRFAutoquery crfAutoquery :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

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
		"crfAutoquery.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(crfAutoquery.uuid IS NULL OR crfAutoquery.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the crf autoquery where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByUUID_G(uuid, groupId);

		if (crfAutoquery == null) {
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

			throw new NoSuchCRFAutoqueryException(sb.toString());
		}

		return crfAutoquery;
	}

	/**
	 * Returns the crf autoquery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the crf autoquery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByUUID_G(
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

		if (result instanceof CRFAutoquery) {
			CRFAutoquery crfAutoquery = (CRFAutoquery)result;

			if (!Objects.equals(uuid, crfAutoquery.getUuid()) ||
				(groupId != crfAutoquery.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

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

				List<CRFAutoquery> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CRFAutoquery crfAutoquery = list.get(0);

					result = crfAutoquery;

					cacheResult(crfAutoquery);
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
			return (CRFAutoquery)result;
		}
	}

	/**
	 * Removes the crf autoquery where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf autoquery that was removed
	 */
	@Override
	public CRFAutoquery removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = findByUUID_G(uuid, groupId);

		return remove(crfAutoquery);
	}

	/**
	 * Returns the number of crf autoqueries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

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
		"crfAutoquery.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(crfAutoquery.uuid IS NULL OR crfAutoquery.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"crfAutoquery.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
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

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if (!uuid.equals(crfAutoquery.getUuid()) ||
						(companyId != crfAutoquery.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

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
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery[] findByUuid_C_PrevAndNext(
			long autoQueryId, String uuid, long companyId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		uuid = Objects.toString(uuid, "");

		CRFAutoquery crfAutoquery = findByPrimaryKey(autoQueryId);

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery[] array = new CRFAutoqueryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, crfAutoquery, uuid, companyId, orderByComparator,
				true);

			array[1] = crfAutoquery;

			array[2] = getByUuid_C_PrevAndNext(
				session, crfAutoquery, uuid, companyId, orderByComparator,
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

	protected CRFAutoquery getByUuid_C_PrevAndNext(
		Session session, CRFAutoquery crfAutoquery, String uuid, long companyId,
		OrderByComparator<CRFAutoquery> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

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
			sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfAutoquery)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFAutoquery> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf autoqueries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CRFAutoquery crfAutoquery :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

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
		"crfAutoquery.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(crfAutoquery.uuid IS NULL OR crfAutoquery.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"crfAutoquery.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByAutoQueryId;
	private FinderPath _finderPathWithoutPaginationFindByAutoQueryId;
	private FinderPath _finderPathCountByAutoQueryId;

	/**
	 * Returns all the crf autoqueries where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByAutoQueryId(long autoQueryId) {
		return findByAutoQueryId(
			autoQueryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries where autoQueryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param autoQueryId the auto query ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByAutoQueryId(
		long autoQueryId, int start, int end) {

		return findByAutoQueryId(autoQueryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where autoQueryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param autoQueryId the auto query ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByAutoQueryId(
		long autoQueryId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findByAutoQueryId(
			autoQueryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where autoQueryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param autoQueryId the auto query ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByAutoQueryId(
		long autoQueryId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAutoQueryId;
				finderArgs = new Object[] {autoQueryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAutoQueryId;
			finderArgs = new Object[] {
				autoQueryId, start, end, orderByComparator
			};
		}

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if (autoQueryId != crfAutoquery.getAutoQueryId()) {
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

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_AUTOQUERYID_AUTOQUERYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(autoQueryId);

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByAutoQueryId_First(
			long autoQueryId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByAutoQueryId_First(
			autoQueryId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("autoQueryId=");
		sb.append(autoQueryId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByAutoQueryId_First(
		long autoQueryId, OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findByAutoQueryId(
			autoQueryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByAutoQueryId_Last(
			long autoQueryId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByAutoQueryId_Last(
			autoQueryId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("autoQueryId=");
		sb.append(autoQueryId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByAutoQueryId_Last(
		long autoQueryId, OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countByAutoQueryId(autoQueryId);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findByAutoQueryId(
			autoQueryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the crf autoqueries where autoQueryId = &#63; from the database.
	 *
	 * @param autoQueryId the auto query ID
	 */
	@Override
	public void removeByAutoQueryId(long autoQueryId) {
		for (CRFAutoquery crfAutoquery :
				findByAutoQueryId(
					autoQueryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where autoQueryId = &#63;.
	 *
	 * @param autoQueryId the auto query ID
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countByAutoQueryId(long autoQueryId) {
		FinderPath finderPath = _finderPathCountByAutoQueryId;

		Object[] finderArgs = new Object[] {autoQueryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_AUTOQUERYID_AUTOQUERYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(autoQueryId);

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

	private static final String _FINDER_COLUMN_AUTOQUERYID_AUTOQUERYID_2 =
		"crfAutoquery.autoQueryId = ?";

	private FinderPath _finderPathWithPaginationFindByQueryTermId;
	private FinderPath _finderPathWithoutPaginationFindByQueryTermId;
	private FinderPath _finderPathCountByQueryTermId;

	/**
	 * Returns all the crf autoqueries where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByQueryTermId(long queryTermId) {
		return findByQueryTermId(
			queryTermId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries where queryTermId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByQueryTermId(
		long queryTermId, int start, int end) {

		return findByQueryTermId(queryTermId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where queryTermId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByQueryTermId(
		long queryTermId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findByQueryTermId(
			queryTermId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where queryTermId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByQueryTermId(
		long queryTermId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByQueryTermId;
				finderArgs = new Object[] {queryTermId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByQueryTermId;
			finderArgs = new Object[] {
				queryTermId, start, end, orderByComparator
			};
		}

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if (queryTermId != crfAutoquery.getQueryTermId()) {
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

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_QUERYTERMID_QUERYTERMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(queryTermId);

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByQueryTermId_First(
			long queryTermId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByQueryTermId_First(
			queryTermId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("queryTermId=");
		sb.append(queryTermId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByQueryTermId_First(
		long queryTermId, OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findByQueryTermId(
			queryTermId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByQueryTermId_Last(
			long queryTermId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByQueryTermId_Last(
			queryTermId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("queryTermId=");
		sb.append(queryTermId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByQueryTermId_Last(
		long queryTermId, OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countByQueryTermId(queryTermId);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findByQueryTermId(
			queryTermId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where queryTermId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param queryTermId the query term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery[] findByQueryTermId_PrevAndNext(
			long autoQueryId, long queryTermId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = findByPrimaryKey(autoQueryId);

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery[] array = new CRFAutoqueryImpl[3];

			array[0] = getByQueryTermId_PrevAndNext(
				session, crfAutoquery, queryTermId, orderByComparator, true);

			array[1] = crfAutoquery;

			array[2] = getByQueryTermId_PrevAndNext(
				session, crfAutoquery, queryTermId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFAutoquery getByQueryTermId_PrevAndNext(
		Session session, CRFAutoquery crfAutoquery, long queryTermId,
		OrderByComparator<CRFAutoquery> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

		sb.append(_FINDER_COLUMN_QUERYTERMID_QUERYTERMID_2);

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
			sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(queryTermId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfAutoquery)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFAutoquery> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf autoqueries where queryTermId = &#63; from the database.
	 *
	 * @param queryTermId the query term ID
	 */
	@Override
	public void removeByQueryTermId(long queryTermId) {
		for (CRFAutoquery crfAutoquery :
				findByQueryTermId(
					queryTermId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where queryTermId = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countByQueryTermId(long queryTermId) {
		FinderPath finderPath = _finderPathCountByQueryTermId;

		Object[] finderArgs = new Object[] {queryTermId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_QUERYTERMID_QUERYTERMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(queryTermId);

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

	private static final String _FINDER_COLUMN_QUERYTERMID_QUERYTERMID_2 =
		"crfAutoquery.queryTermId = ?";

	private FinderPath _finderPathWithPaginationFindBySubjectId;
	private FinderPath _finderPathWithoutPaginationFindBySubjectId;
	private FinderPath _finderPathCountBySubjectId;

	/**
	 * Returns all the crf autoqueries where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findBySubjectId(long subjectId) {
		return findBySubjectId(
			subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findBySubjectId(
		long subjectId, int start, int end) {

		return findBySubjectId(subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findBySubjectId(subjectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySubjectId;
				finderArgs = new Object[] {subjectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySubjectId;
			finderArgs = new Object[] {
				subjectId, start, end, orderByComparator
			};
		}

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if (subjectId != crfAutoquery.getSubjectId()) {
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

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_SUBJECTID_SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subjectId);

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findBySubjectId_First(
			long subjectId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchBySubjectId_First(
			subjectId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchBySubjectId_First(
		long subjectId, OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findBySubjectId(
			subjectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findBySubjectId_Last(
			long subjectId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchBySubjectId_Last(
			subjectId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchBySubjectId_Last(
		long subjectId, OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countBySubjectId(subjectId);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findBySubjectId(
			subjectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where subjectId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery[] findBySubjectId_PrevAndNext(
			long autoQueryId, long subjectId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = findByPrimaryKey(autoQueryId);

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery[] array = new CRFAutoqueryImpl[3];

			array[0] = getBySubjectId_PrevAndNext(
				session, crfAutoquery, subjectId, orderByComparator, true);

			array[1] = crfAutoquery;

			array[2] = getBySubjectId_PrevAndNext(
				session, crfAutoquery, subjectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFAutoquery getBySubjectId_PrevAndNext(
		Session session, CRFAutoquery crfAutoquery, long subjectId,
		OrderByComparator<CRFAutoquery> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

		sb.append(_FINDER_COLUMN_SUBJECTID_SUBJECTID_2);

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
			sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subjectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfAutoquery)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFAutoquery> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf autoqueries where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	@Override
	public void removeBySubjectId(long subjectId) {
		for (CRFAutoquery crfAutoquery :
				findBySubjectId(
					subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countBySubjectId(long subjectId) {
		FinderPath finderPath = _finderPathCountBySubjectId;

		Object[] finderArgs = new Object[] {subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_SUBJECTID_SUBJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subjectId);

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

	private static final String _FINDER_COLUMN_SUBJECTID_SUBJECTID_2 =
		"crfAutoquery.subjectId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the crf autoqueries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if (userId != crfAutoquery.getUserId()) {
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

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByUserId_First(
			long userId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByUserId_First(
			userId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByUserId_First(
		long userId, OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByUserId_Last(
			long userId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByUserId_Last(
			userId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByUserId_Last(
		long userId, OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where userId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery[] findByUserId_PrevAndNext(
			long autoQueryId, long userId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = findByPrimaryKey(autoQueryId);

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery[] array = new CRFAutoqueryImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, crfAutoquery, userId, orderByComparator, true);

			array[1] = crfAutoquery;

			array[2] = getByUserId_PrevAndNext(
				session, crfAutoquery, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFAutoquery getByUserId_PrevAndNext(
		Session session, CRFAutoquery crfAutoquery, long userId,
		OrderByComparator<CRFAutoquery> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfAutoquery)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFAutoquery> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf autoqueries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (CRFAutoquery crfAutoquery :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"crfAutoquery.userId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the crf autoqueries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
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

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if (groupId != crfAutoquery.getGroupId()) {
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

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByGroupId_First(
			long groupId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByGroupId_First(
			groupId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByGroupId_First(
		long groupId, OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByGroupId_Last(
			long groupId, OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where groupId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery[] findByGroupId_PrevAndNext(
			long autoQueryId, long groupId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = findByPrimaryKey(autoQueryId);

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery[] array = new CRFAutoqueryImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, crfAutoquery, groupId, orderByComparator, true);

			array[1] = crfAutoquery;

			array[2] = getByGroupId_PrevAndNext(
				session, crfAutoquery, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFAutoquery getByGroupId_PrevAndNext(
		Session session, CRFAutoquery crfAutoquery, long groupId,
		OrderByComparator<CRFAutoquery> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

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
			sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfAutoquery)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFAutoquery> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf autoqueries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (CRFAutoquery crfAutoquery :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

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
		"crfAutoquery.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C;
	private FinderPath _finderPathWithoutPaginationFindByG_C;
	private FinderPath _finderPathCountByG_C;

	/**
	 * Returns all the crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByG_C(long groupId, long crfId) {
		return findByG_C(
			groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByG_C(
		long groupId, long crfId, int start, int end) {

		return findByG_C(groupId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findByG_C(groupId, crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
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

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if ((groupId != crfAutoquery.getGroupId()) ||
						(crfId != crfAutoquery.getCrfId())) {

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

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByG_C_First(
			groupId, crfId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findByG_C(
			groupId, crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByG_C_Last(
			groupId, crfId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countByG_C(groupId, crfId);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findByG_C(
			groupId, crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery[] findByG_C_PrevAndNext(
			long autoQueryId, long groupId, long crfId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = findByPrimaryKey(autoQueryId);

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery[] array = new CRFAutoqueryImpl[3];

			array[0] = getByG_C_PrevAndNext(
				session, crfAutoquery, groupId, crfId, orderByComparator, true);

			array[1] = crfAutoquery;

			array[2] = getByG_C_PrevAndNext(
				session, crfAutoquery, groupId, crfId, orderByComparator,
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

	protected CRFAutoquery getByG_C_PrevAndNext(
		Session session, CRFAutoquery crfAutoquery, long groupId, long crfId,
		OrderByComparator<CRFAutoquery> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

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
			sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfAutoquery)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFAutoquery> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf autoqueries where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByG_C(long groupId, long crfId) {
		for (CRFAutoquery crfAutoquery :
				findByG_C(
					groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countByG_C(long groupId, long crfId) {
		FinderPath finderPath = _finderPathCountByG_C;

		Object[] finderArgs = new Object[] {groupId, crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

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
		"crfAutoquery.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_CRFID_2 =
		"crfAutoquery.crfId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_S;
	private FinderPath _finderPathWithoutPaginationFindByG_C_S;
	private FinderPath _finderPathCountByG_C_S;

	/**
	 * Returns all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId) {

		return findByG_C_S(
			groupId, crfId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end) {

		return findByG_C_S(groupId, crfId, subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findByG_C_S(
			groupId, crfId, subjectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findByG_C_S(
		long groupId, long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_S;
				finderArgs = new Object[] {groupId, crfId, subjectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_S;
			finderArgs = new Object[] {
				groupId, crfId, subjectId, start, end, orderByComparator
			};
		}

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if ((groupId != crfAutoquery.getGroupId()) ||
						(crfId != crfAutoquery.getCrfId()) ||
						(subjectId != crfAutoquery.getSubjectId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_S_CRFID_2);

			sb.append(_FINDER_COLUMN_G_C_S_SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				queryPos.add(subjectId);

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByG_C_S_First(
			long groupId, long crfId, long subjectId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByG_C_S_First(
			groupId, crfId, subjectId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByG_C_S_First(
		long groupId, long crfId, long subjectId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findByG_C_S(
			groupId, crfId, subjectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findByG_C_S_Last(
			long groupId, long crfId, long subjectId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByG_C_S_Last(
			groupId, crfId, subjectId, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchByG_C_S_Last(
		long groupId, long crfId, long subjectId,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countByG_C_S(groupId, crfId, subjectId);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findByG_C_S(
			groupId, crfId, subjectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery[] findByG_C_S_PrevAndNext(
			long autoQueryId, long groupId, long crfId, long subjectId,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = findByPrimaryKey(autoQueryId);

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery[] array = new CRFAutoqueryImpl[3];

			array[0] = getByG_C_S_PrevAndNext(
				session, crfAutoquery, groupId, crfId, subjectId,
				orderByComparator, true);

			array[1] = crfAutoquery;

			array[2] = getByG_C_S_PrevAndNext(
				session, crfAutoquery, groupId, crfId, subjectId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFAutoquery getByG_C_S_PrevAndNext(
		Session session, CRFAutoquery crfAutoquery, long groupId, long crfId,
		long subjectId, OrderByComparator<CRFAutoquery> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

		sb.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_S_CRFID_2);

		sb.append(_FINDER_COLUMN_G_C_S_SUBJECTID_2);

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
			sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(crfId);

		queryPos.add(subjectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfAutoquery)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFAutoquery> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	@Override
	public void removeByG_C_S(long groupId, long crfId, long subjectId) {
		for (CRFAutoquery crfAutoquery :
				findByG_C_S(
					groupId, crfId, subjectId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where groupId = &#63; and crfId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countByG_C_S(long groupId, long crfId, long subjectId) {
		FinderPath finderPath = _finderPathCountByG_C_S;

		Object[] finderArgs = new Object[] {groupId, crfId, subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_S_CRFID_2);

			sb.append(_FINDER_COLUMN_G_C_S_SUBJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				queryPos.add(subjectId);

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

	private static final String _FINDER_COLUMN_G_C_S_GROUPID_2 =
		"crfAutoquery.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_S_CRFID_2 =
		"crfAutoquery.crfId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_S_SUBJECTID_2 =
		"crfAutoquery.subjectId = ?";

	private FinderPath _finderPathWithPaginationFindBySdIdSIdValue;
	private FinderPath _finderPathWithoutPaginationFindBySdIdSIdValue;
	private FinderPath _finderPathCountBySdIdSIdValue;

	/**
	 * Returns all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @return the matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue) {

		return findBySdIdSIdValue(
			queryTermId, subjectId, queryValue, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue, int start,
		int end) {

		return findBySdIdSIdValue(
			queryTermId, subjectId, queryValue, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		return findBySdIdSIdValue(
			queryTermId, subjectId, queryValue, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue, int start, int end,
		OrderByComparator<CRFAutoquery> orderByComparator,
		boolean useFinderCache) {

		queryValue = Objects.toString(queryValue, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySdIdSIdValue;
				finderArgs = new Object[] {queryTermId, subjectId, queryValue};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySdIdSIdValue;
			finderArgs = new Object[] {
				queryTermId, subjectId, queryValue, start, end,
				orderByComparator
			};
		}

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFAutoquery crfAutoquery : list) {
					if ((queryTermId != crfAutoquery.getQueryTermId()) ||
						(subjectId != crfAutoquery.getSubjectId()) ||
						!queryValue.equals(crfAutoquery.getQueryValue())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_QUERYTERMID_2);

			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_SUBJECTID_2);

			boolean bindQueryValue = false;

			if (queryValue.isEmpty()) {
				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_QUERYVALUE_3);
			}
			else {
				bindQueryValue = true;

				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_QUERYVALUE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(queryTermId);

				queryPos.add(subjectId);

				if (bindQueryValue) {
					queryPos.add(queryValue);
				}

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findBySdIdSIdValue_First(
			long queryTermId, long subjectId, String queryValue,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchBySdIdSIdValue_First(
			queryTermId, subjectId, queryValue, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("queryTermId=");
		sb.append(queryTermId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append(", queryValue=");
		sb.append(queryValue);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the first crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchBySdIdSIdValue_First(
		long queryTermId, long subjectId, String queryValue,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		List<CRFAutoquery> list = findBySdIdSIdValue(
			queryTermId, subjectId, queryValue, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findBySdIdSIdValue_Last(
			long queryTermId, long subjectId, String queryValue,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchBySdIdSIdValue_Last(
			queryTermId, subjectId, queryValue, orderByComparator);

		if (crfAutoquery != null) {
			return crfAutoquery;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("queryTermId=");
		sb.append(queryTermId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append(", queryValue=");
		sb.append(queryValue);

		sb.append("}");

		throw new NoSuchCRFAutoqueryException(sb.toString());
	}

	/**
	 * Returns the last crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchBySdIdSIdValue_Last(
		long queryTermId, long subjectId, String queryValue,
		OrderByComparator<CRFAutoquery> orderByComparator) {

		int count = countBySdIdSIdValue(queryTermId, subjectId, queryValue);

		if (count == 0) {
			return null;
		}

		List<CRFAutoquery> list = findBySdIdSIdValue(
			queryTermId, subjectId, queryValue, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf autoqueries before and after the current crf autoquery in the ordered set where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param autoQueryId the primary key of the current crf autoquery
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery[] findBySdIdSIdValue_PrevAndNext(
			long autoQueryId, long queryTermId, long subjectId,
			String queryValue,
			OrderByComparator<CRFAutoquery> orderByComparator)
		throws NoSuchCRFAutoqueryException {

		queryValue = Objects.toString(queryValue, "");

		CRFAutoquery crfAutoquery = findByPrimaryKey(autoQueryId);

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery[] array = new CRFAutoqueryImpl[3];

			array[0] = getBySdIdSIdValue_PrevAndNext(
				session, crfAutoquery, queryTermId, subjectId, queryValue,
				orderByComparator, true);

			array[1] = crfAutoquery;

			array[2] = getBySdIdSIdValue_PrevAndNext(
				session, crfAutoquery, queryTermId, subjectId, queryValue,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFAutoquery getBySdIdSIdValue_PrevAndNext(
		Session session, CRFAutoquery crfAutoquery, long queryTermId,
		long subjectId, String queryValue,
		OrderByComparator<CRFAutoquery> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

		sb.append(_FINDER_COLUMN_SDIDSIDVALUE_QUERYTERMID_2);

		sb.append(_FINDER_COLUMN_SDIDSIDVALUE_SUBJECTID_2);

		boolean bindQueryValue = false;

		if (queryValue.isEmpty()) {
			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_QUERYVALUE_3);
		}
		else {
			bindQueryValue = true;

			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_QUERYVALUE_2);
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
			sb.append(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(queryTermId);

		queryPos.add(subjectId);

		if (bindQueryValue) {
			queryPos.add(queryValue);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfAutoquery)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFAutoquery> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63; from the database.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 */
	@Override
	public void removeBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue) {

		for (CRFAutoquery crfAutoquery :
				findBySdIdSIdValue(
					queryTermId, subjectId, queryValue, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryValue the query value
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countBySdIdSIdValue(
		long queryTermId, long subjectId, String queryValue) {

		queryValue = Objects.toString(queryValue, "");

		FinderPath finderPath = _finderPathCountBySdIdSIdValue;

		Object[] finderArgs = new Object[] {queryTermId, subjectId, queryValue};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_QUERYTERMID_2);

			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_SUBJECTID_2);

			boolean bindQueryValue = false;

			if (queryValue.isEmpty()) {
				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_QUERYVALUE_3);
			}
			else {
				bindQueryValue = true;

				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_QUERYVALUE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(queryTermId);

				queryPos.add(subjectId);

				if (bindQueryValue) {
					queryPos.add(queryValue);
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

	private static final String _FINDER_COLUMN_SDIDSIDVALUE_QUERYTERMID_2 =
		"crfAutoquery.queryTermId = ? AND ";

	private static final String _FINDER_COLUMN_SDIDSIDVALUE_SUBJECTID_2 =
		"crfAutoquery.subjectId = ? AND ";

	private static final String _FINDER_COLUMN_SDIDSIDVALUE_QUERYVALUE_2 =
		"crfAutoquery.queryValue = ?";

	private static final String _FINDER_COLUMN_SDIDSIDVALUE_QUERYVALUE_3 =
		"(crfAutoquery.queryValue IS NULL OR crfAutoquery.queryValue = '')";

	private FinderPath _finderPathFetchBySdIdSIdValue_MODEL;
	private FinderPath _finderPathCountBySdIdSIdValue_MODEL;

	/**
	 * Returns the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findBySdIdSIdValue_MODEL(
			long queryTermId, long subjectId, String queryTermName,
			String queryValue)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchBySdIdSIdValue_MODEL(
			queryTermId, subjectId, queryTermName, queryValue);

		if (crfAutoquery == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("queryTermId=");
			sb.append(queryTermId);

			sb.append(", subjectId=");
			sb.append(subjectId);

			sb.append(", queryTermName=");
			sb.append(queryTermName);

			sb.append(", queryValue=");
			sb.append(queryValue);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCRFAutoqueryException(sb.toString());
		}

		return crfAutoquery;
	}

	/**
	 * Returns the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchBySdIdSIdValue_MODEL(
		long queryTermId, long subjectId, String queryTermName,
		String queryValue) {

		return fetchBySdIdSIdValue_MODEL(
			queryTermId, subjectId, queryTermName, queryValue, true);
	}

	/**
	 * Returns the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchBySdIdSIdValue_MODEL(
		long queryTermId, long subjectId, String queryTermName,
		String queryValue, boolean useFinderCache) {

		queryTermName = Objects.toString(queryTermName, "");
		queryValue = Objects.toString(queryValue, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				queryTermId, subjectId, queryTermName, queryValue
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySdIdSIdValue_MODEL, finderArgs, this);
		}

		if (result instanceof CRFAutoquery) {
			CRFAutoquery crfAutoquery = (CRFAutoquery)result;

			if ((queryTermId != crfAutoquery.getQueryTermId()) ||
				(subjectId != crfAutoquery.getSubjectId()) ||
				!Objects.equals(
					queryTermName, crfAutoquery.getQueryTermName()) ||
				!Objects.equals(queryValue, crfAutoquery.getQueryValue())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYTERMID_2);

			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_SUBJECTID_2);

			boolean bindQueryTermName = false;

			if (queryTermName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYTERMNAME_3);
			}
			else {
				bindQueryTermName = true;

				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYTERMNAME_2);
			}

			boolean bindQueryValue = false;

			if (queryValue.isEmpty()) {
				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYVALUE_3);
			}
			else {
				bindQueryValue = true;

				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYVALUE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(queryTermId);

				queryPos.add(subjectId);

				if (bindQueryTermName) {
					queryPos.add(queryTermName);
				}

				if (bindQueryValue) {
					queryPos.add(queryValue);
				}

				List<CRFAutoquery> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySdIdSIdValue_MODEL, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									queryTermId, subjectId, queryTermName,
									queryValue
								};
							}

							_log.warn(
								"CRFAutoqueryPersistenceImpl.fetchBySdIdSIdValue_MODEL(long, long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CRFAutoquery crfAutoquery = list.get(0);

					result = crfAutoquery;

					cacheResult(crfAutoquery);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBySdIdSIdValue_MODEL, finderArgs);
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
			return (CRFAutoquery)result;
		}
	}

	/**
	 * Removes the crf autoquery where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63; from the database.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the crf autoquery that was removed
	 */
	@Override
	public CRFAutoquery removeBySdIdSIdValue_MODEL(
			long queryTermId, long subjectId, String queryTermName,
			String queryValue)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = findBySdIdSIdValue_MODEL(
			queryTermId, subjectId, queryTermName, queryValue);

		return remove(crfAutoquery);
	}

	/**
	 * Returns the number of crf autoqueries where queryTermId = &#63; and subjectId = &#63; and queryTermName = &#63; and queryValue = &#63;.
	 *
	 * @param queryTermId the query term ID
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param queryValue the query value
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countBySdIdSIdValue_MODEL(
		long queryTermId, long subjectId, String queryTermName,
		String queryValue) {

		queryTermName = Objects.toString(queryTermName, "");
		queryValue = Objects.toString(queryValue, "");

		FinderPath finderPath = _finderPathCountBySdIdSIdValue_MODEL;

		Object[] finderArgs = new Object[] {
			queryTermId, subjectId, queryTermName, queryValue
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYTERMID_2);

			sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_SUBJECTID_2);

			boolean bindQueryTermName = false;

			if (queryTermName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYTERMNAME_3);
			}
			else {
				bindQueryTermName = true;

				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYTERMNAME_2);
			}

			boolean bindQueryValue = false;

			if (queryValue.isEmpty()) {
				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYVALUE_3);
			}
			else {
				bindQueryValue = true;

				sb.append(_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYVALUE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(queryTermId);

				queryPos.add(subjectId);

				if (bindQueryTermName) {
					queryPos.add(queryTermName);
				}

				if (bindQueryValue) {
					queryPos.add(queryValue);
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

	private static final String
		_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYTERMID_2 =
			"crfAutoquery.queryTermId = ? AND ";

	private static final String _FINDER_COLUMN_SDIDSIDVALUE_MODEL_SUBJECTID_2 =
		"crfAutoquery.subjectId = ? AND ";

	private static final String
		_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYTERMNAME_2 =
			"crfAutoquery.queryTermName = ? AND ";

	private static final String
		_FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYTERMNAME_3 =
			"(crfAutoquery.queryTermName IS NULL OR crfAutoquery.queryTermName = '') AND ";

	private static final String _FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYVALUE_2 =
		"crfAutoquery.queryValue = ?";

	private static final String _FINDER_COLUMN_SDIDSIDVALUE_MODEL_QUERYVALUE_3 =
		"(crfAutoquery.queryValue IS NULL OR crfAutoquery.queryValue = '')";

	private FinderPath _finderPathFetchBySIdTN;
	private FinderPath _finderPathCountBySIdTN;

	/**
	 * Returns the crf autoquery where subjectId = &#63; and queryTermName = &#63; or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the matching crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery findBySIdTN(long subjectId, String queryTermName)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchBySIdTN(subjectId, queryTermName);

		if (crfAutoquery == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("subjectId=");
			sb.append(subjectId);

			sb.append(", queryTermName=");
			sb.append(queryTermName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCRFAutoqueryException(sb.toString());
		}

		return crfAutoquery;
	}

	/**
	 * Returns the crf autoquery where subjectId = &#63; and queryTermName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchBySIdTN(long subjectId, String queryTermName) {
		return fetchBySIdTN(subjectId, queryTermName, true);
	}

	/**
	 * Returns the crf autoquery where subjectId = &#63; and queryTermName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf autoquery, or <code>null</code> if a matching crf autoquery could not be found
	 */
	@Override
	public CRFAutoquery fetchBySIdTN(
		long subjectId, String queryTermName, boolean useFinderCache) {

		queryTermName = Objects.toString(queryTermName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {subjectId, queryTermName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySIdTN, finderArgs, this);
		}

		if (result instanceof CRFAutoquery) {
			CRFAutoquery crfAutoquery = (CRFAutoquery)result;

			if ((subjectId != crfAutoquery.getSubjectId()) ||
				!Objects.equals(
					queryTermName, crfAutoquery.getQueryTermName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_SIDTN_SUBJECTID_2);

			boolean bindQueryTermName = false;

			if (queryTermName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIDTN_QUERYTERMNAME_3);
			}
			else {
				bindQueryTermName = true;

				sb.append(_FINDER_COLUMN_SIDTN_QUERYTERMNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subjectId);

				if (bindQueryTermName) {
					queryPos.add(queryTermName);
				}

				List<CRFAutoquery> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySIdTN, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									subjectId, queryTermName
								};
							}

							_log.warn(
								"CRFAutoqueryPersistenceImpl.fetchBySIdTN(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CRFAutoquery crfAutoquery = list.get(0);

					result = crfAutoquery;

					cacheResult(crfAutoquery);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBySIdTN, finderArgs);
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
			return (CRFAutoquery)result;
		}
	}

	/**
	 * Removes the crf autoquery where subjectId = &#63; and queryTermName = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the crf autoquery that was removed
	 */
	@Override
	public CRFAutoquery removeBySIdTN(long subjectId, String queryTermName)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = findBySIdTN(subjectId, queryTermName);

		return remove(crfAutoquery);
	}

	/**
	 * Returns the number of crf autoqueries where subjectId = &#63; and queryTermName = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param queryTermName the query term name
	 * @return the number of matching crf autoqueries
	 */
	@Override
	public int countBySIdTN(long subjectId, String queryTermName) {
		queryTermName = Objects.toString(queryTermName, "");

		FinderPath finderPath = _finderPathCountBySIdTN;

		Object[] finderArgs = new Object[] {subjectId, queryTermName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFAUTOQUERY_WHERE);

			sb.append(_FINDER_COLUMN_SIDTN_SUBJECTID_2);

			boolean bindQueryTermName = false;

			if (queryTermName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIDTN_QUERYTERMNAME_3);
			}
			else {
				bindQueryTermName = true;

				sb.append(_FINDER_COLUMN_SIDTN_QUERYTERMNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subjectId);

				if (bindQueryTermName) {
					queryPos.add(queryTermName);
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

	private static final String _FINDER_COLUMN_SIDTN_SUBJECTID_2 =
		"crfAutoquery.subjectId = ? AND ";

	private static final String _FINDER_COLUMN_SIDTN_QUERYTERMNAME_2 =
		"crfAutoquery.queryTermName = ?";

	private static final String _FINDER_COLUMN_SIDTN_QUERYTERMNAME_3 =
		"(crfAutoquery.queryTermName IS NULL OR crfAutoquery.queryTermName = '')";

	public CRFAutoqueryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CRFAutoquery.class);

		setModelImplClass(CRFAutoqueryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the crf autoquery in the entity cache if it is enabled.
	 *
	 * @param crfAutoquery the crf autoquery
	 */
	@Override
	public void cacheResult(CRFAutoquery crfAutoquery) {
		entityCache.putResult(
			entityCacheEnabled, CRFAutoqueryImpl.class,
			crfAutoquery.getPrimaryKey(), crfAutoquery);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {crfAutoquery.getUuid(), crfAutoquery.getGroupId()},
			crfAutoquery);

		finderCache.putResult(
			_finderPathFetchBySdIdSIdValue_MODEL,
			new Object[] {
				crfAutoquery.getQueryTermId(), crfAutoquery.getSubjectId(),
				crfAutoquery.getQueryTermName(), crfAutoquery.getQueryValue()
			},
			crfAutoquery);

		finderCache.putResult(
			_finderPathFetchBySIdTN,
			new Object[] {
				crfAutoquery.getSubjectId(), crfAutoquery.getQueryTermName()
			},
			crfAutoquery);

		crfAutoquery.resetOriginalValues();
	}

	/**
	 * Caches the crf autoqueries in the entity cache if it is enabled.
	 *
	 * @param crfAutoqueries the crf autoqueries
	 */
	@Override
	public void cacheResult(List<CRFAutoquery> crfAutoqueries) {
		for (CRFAutoquery crfAutoquery : crfAutoqueries) {
			if (entityCache.getResult(
					entityCacheEnabled, CRFAutoqueryImpl.class,
					crfAutoquery.getPrimaryKey()) == null) {

				cacheResult(crfAutoquery);
			}
			else {
				crfAutoquery.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all crf autoqueries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CRFAutoqueryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the crf autoquery.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CRFAutoquery crfAutoquery) {
		entityCache.removeResult(
			entityCacheEnabled, CRFAutoqueryImpl.class,
			crfAutoquery.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CRFAutoqueryModelImpl)crfAutoquery, true);
	}

	@Override
	public void clearCache(List<CRFAutoquery> crfAutoqueries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CRFAutoquery crfAutoquery : crfAutoqueries) {
			entityCache.removeResult(
				entityCacheEnabled, CRFAutoqueryImpl.class,
				crfAutoquery.getPrimaryKey());

			clearUniqueFindersCache((CRFAutoqueryModelImpl)crfAutoquery, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CRFAutoqueryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CRFAutoqueryModelImpl crfAutoqueryModelImpl) {

		Object[] args = new Object[] {
			crfAutoqueryModelImpl.getUuid(), crfAutoqueryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, crfAutoqueryModelImpl, false);

		args = new Object[] {
			crfAutoqueryModelImpl.getQueryTermId(),
			crfAutoqueryModelImpl.getSubjectId(),
			crfAutoqueryModelImpl.getQueryTermName(),
			crfAutoqueryModelImpl.getQueryValue()
		};

		finderCache.putResult(
			_finderPathCountBySdIdSIdValue_MODEL, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySdIdSIdValue_MODEL, args, crfAutoqueryModelImpl,
			false);

		args = new Object[] {
			crfAutoqueryModelImpl.getSubjectId(),
			crfAutoqueryModelImpl.getQueryTermName()
		};

		finderCache.putResult(
			_finderPathCountBySIdTN, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySIdTN, args, crfAutoqueryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CRFAutoqueryModelImpl crfAutoqueryModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfAutoqueryModelImpl.getUuid(),
				crfAutoqueryModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((crfAutoqueryModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfAutoqueryModelImpl.getOriginalUuid(),
				crfAutoqueryModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfAutoqueryModelImpl.getQueryTermId(),
				crfAutoqueryModelImpl.getSubjectId(),
				crfAutoqueryModelImpl.getQueryTermName(),
				crfAutoqueryModelImpl.getQueryValue()
			};

			finderCache.removeResult(
				_finderPathCountBySdIdSIdValue_MODEL, args);
			finderCache.removeResult(
				_finderPathFetchBySdIdSIdValue_MODEL, args);
		}

		if ((crfAutoqueryModelImpl.getColumnBitmask() &
			 _finderPathFetchBySdIdSIdValue_MODEL.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfAutoqueryModelImpl.getOriginalQueryTermId(),
				crfAutoqueryModelImpl.getOriginalSubjectId(),
				crfAutoqueryModelImpl.getOriginalQueryTermName(),
				crfAutoqueryModelImpl.getOriginalQueryValue()
			};

			finderCache.removeResult(
				_finderPathCountBySdIdSIdValue_MODEL, args);
			finderCache.removeResult(
				_finderPathFetchBySdIdSIdValue_MODEL, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfAutoqueryModelImpl.getSubjectId(),
				crfAutoqueryModelImpl.getQueryTermName()
			};

			finderCache.removeResult(_finderPathCountBySIdTN, args);
			finderCache.removeResult(_finderPathFetchBySIdTN, args);
		}

		if ((crfAutoqueryModelImpl.getColumnBitmask() &
			 _finderPathFetchBySIdTN.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfAutoqueryModelImpl.getOriginalSubjectId(),
				crfAutoqueryModelImpl.getOriginalQueryTermName()
			};

			finderCache.removeResult(_finderPathCountBySIdTN, args);
			finderCache.removeResult(_finderPathFetchBySIdTN, args);
		}
	}

	/**
	 * Creates a new crf autoquery with the primary key. Does not add the crf autoquery to the database.
	 *
	 * @param autoQueryId the primary key for the new crf autoquery
	 * @return the new crf autoquery
	 */
	@Override
	public CRFAutoquery create(long autoQueryId) {
		CRFAutoquery crfAutoquery = new CRFAutoqueryImpl();

		crfAutoquery.setNew(true);
		crfAutoquery.setPrimaryKey(autoQueryId);

		String uuid = PortalUUIDUtil.generate();

		crfAutoquery.setUuid(uuid);

		crfAutoquery.setCompanyId(CompanyThreadLocal.getCompanyId());

		return crfAutoquery;
	}

	/**
	 * Removes the crf autoquery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery that was removed
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery remove(long autoQueryId)
		throws NoSuchCRFAutoqueryException {

		return remove((Serializable)autoQueryId);
	}

	/**
	 * Removes the crf autoquery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the crf autoquery
	 * @return the crf autoquery that was removed
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery remove(Serializable primaryKey)
		throws NoSuchCRFAutoqueryException {

		Session session = null;

		try {
			session = openSession();

			CRFAutoquery crfAutoquery = (CRFAutoquery)session.get(
				CRFAutoqueryImpl.class, primaryKey);

			if (crfAutoquery == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCRFAutoqueryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(crfAutoquery);
		}
		catch (NoSuchCRFAutoqueryException noSuchEntityException) {
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
	protected CRFAutoquery removeImpl(CRFAutoquery crfAutoquery) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(crfAutoquery)) {
				crfAutoquery = (CRFAutoquery)session.get(
					CRFAutoqueryImpl.class, crfAutoquery.getPrimaryKeyObj());
			}

			if (crfAutoquery != null) {
				session.delete(crfAutoquery);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (crfAutoquery != null) {
			clearCache(crfAutoquery);
		}

		return crfAutoquery;
	}

	@Override
	public CRFAutoquery updateImpl(CRFAutoquery crfAutoquery) {
		boolean isNew = crfAutoquery.isNew();

		if (!(crfAutoquery instanceof CRFAutoqueryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(crfAutoquery.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					crfAutoquery);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in crfAutoquery proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CRFAutoquery implementation " +
					crfAutoquery.getClass());
		}

		CRFAutoqueryModelImpl crfAutoqueryModelImpl =
			(CRFAutoqueryModelImpl)crfAutoquery;

		if (Validator.isNull(crfAutoquery.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			crfAutoquery.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (crfAutoquery.getCreateDate() == null)) {
			if (serviceContext == null) {
				crfAutoquery.setCreateDate(now);
			}
			else {
				crfAutoquery.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!crfAutoqueryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				crfAutoquery.setModifiedDate(now);
			}
			else {
				crfAutoquery.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (crfAutoquery.isNew()) {
				session.save(crfAutoquery);

				crfAutoquery.setNew(false);
			}
			else {
				crfAutoquery = (CRFAutoquery)session.merge(crfAutoquery);
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
			Object[] args = new Object[] {crfAutoqueryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				crfAutoqueryModelImpl.getUuid(),
				crfAutoqueryModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {crfAutoqueryModelImpl.getAutoQueryId()};

			finderCache.removeResult(_finderPathCountByAutoQueryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAutoQueryId, args);

			args = new Object[] {crfAutoqueryModelImpl.getQueryTermId()};

			finderCache.removeResult(_finderPathCountByQueryTermId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByQueryTermId, args);

			args = new Object[] {crfAutoqueryModelImpl.getSubjectId()};

			finderCache.removeResult(_finderPathCountBySubjectId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySubjectId, args);

			args = new Object[] {crfAutoqueryModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {crfAutoqueryModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				crfAutoqueryModelImpl.getGroupId(),
				crfAutoqueryModelImpl.getCrfId()
			};

			finderCache.removeResult(_finderPathCountByG_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C, args);

			args = new Object[] {
				crfAutoqueryModelImpl.getGroupId(),
				crfAutoqueryModelImpl.getCrfId(),
				crfAutoqueryModelImpl.getSubjectId()
			};

			finderCache.removeResult(_finderPathCountByG_C_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_S, args);

			args = new Object[] {
				crfAutoqueryModelImpl.getQueryTermId(),
				crfAutoqueryModelImpl.getSubjectId(),
				crfAutoqueryModelImpl.getQueryValue()
			};

			finderCache.removeResult(_finderPathCountBySdIdSIdValue, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySdIdSIdValue, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {crfAutoqueryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalUuid(),
					crfAutoqueryModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					crfAutoqueryModelImpl.getUuid(),
					crfAutoqueryModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAutoQueryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalAutoQueryId()
				};

				finderCache.removeResult(_finderPathCountByAutoQueryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAutoQueryId, args);

				args = new Object[] {crfAutoqueryModelImpl.getAutoQueryId()};

				finderCache.removeResult(_finderPathCountByAutoQueryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAutoQueryId, args);
			}

			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByQueryTermId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalQueryTermId()
				};

				finderCache.removeResult(_finderPathCountByQueryTermId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByQueryTermId, args);

				args = new Object[] {crfAutoqueryModelImpl.getQueryTermId()};

				finderCache.removeResult(_finderPathCountByQueryTermId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByQueryTermId, args);
			}

			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySubjectId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalSubjectId()
				};

				finderCache.removeResult(_finderPathCountBySubjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySubjectId, args);

				args = new Object[] {crfAutoqueryModelImpl.getSubjectId()};

				finderCache.removeResult(_finderPathCountBySubjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySubjectId, args);
			}

			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {crfAutoqueryModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {crfAutoqueryModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalGroupId(),
					crfAutoqueryModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);

				args = new Object[] {
					crfAutoqueryModelImpl.getGroupId(),
					crfAutoqueryModelImpl.getCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);
			}

			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalGroupId(),
					crfAutoqueryModelImpl.getOriginalCrfId(),
					crfAutoqueryModelImpl.getOriginalSubjectId()
				};

				finderCache.removeResult(_finderPathCountByG_C_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_S, args);

				args = new Object[] {
					crfAutoqueryModelImpl.getGroupId(),
					crfAutoqueryModelImpl.getCrfId(),
					crfAutoqueryModelImpl.getSubjectId()
				};

				finderCache.removeResult(_finderPathCountByG_C_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_S, args);
			}

			if ((crfAutoqueryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySdIdSIdValue.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfAutoqueryModelImpl.getOriginalQueryTermId(),
					crfAutoqueryModelImpl.getOriginalSubjectId(),
					crfAutoqueryModelImpl.getOriginalQueryValue()
				};

				finderCache.removeResult(_finderPathCountBySdIdSIdValue, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySdIdSIdValue, args);

				args = new Object[] {
					crfAutoqueryModelImpl.getQueryTermId(),
					crfAutoqueryModelImpl.getSubjectId(),
					crfAutoqueryModelImpl.getQueryValue()
				};

				finderCache.removeResult(_finderPathCountBySdIdSIdValue, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySdIdSIdValue, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CRFAutoqueryImpl.class,
			crfAutoquery.getPrimaryKey(), crfAutoquery, false);

		clearUniqueFindersCache(crfAutoqueryModelImpl, false);
		cacheUniqueFindersCache(crfAutoqueryModelImpl);

		crfAutoquery.resetOriginalValues();

		return crfAutoquery;
	}

	/**
	 * Returns the crf autoquery with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the crf autoquery
	 * @return the crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCRFAutoqueryException {

		CRFAutoquery crfAutoquery = fetchByPrimaryKey(primaryKey);

		if (crfAutoquery == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCRFAutoqueryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return crfAutoquery;
	}

	/**
	 * Returns the crf autoquery with the primary key or throws a <code>NoSuchCRFAutoqueryException</code> if it could not be found.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery
	 * @throws NoSuchCRFAutoqueryException if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery findByPrimaryKey(long autoQueryId)
		throws NoSuchCRFAutoqueryException {

		return findByPrimaryKey((Serializable)autoQueryId);
	}

	/**
	 * Returns the crf autoquery with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param autoQueryId the primary key of the crf autoquery
	 * @return the crf autoquery, or <code>null</code> if a crf autoquery with the primary key could not be found
	 */
	@Override
	public CRFAutoquery fetchByPrimaryKey(long autoQueryId) {
		return fetchByPrimaryKey((Serializable)autoQueryId);
	}

	/**
	 * Returns all the crf autoqueries.
	 *
	 * @return the crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf autoqueries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @return the range of crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findAll(
		int start, int end, OrderByComparator<CRFAutoquery> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf autoqueries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFAutoqueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf autoqueries
	 * @param end the upper bound of the range of crf autoqueries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf autoqueries
	 */
	@Override
	public List<CRFAutoquery> findAll(
		int start, int end, OrderByComparator<CRFAutoquery> orderByComparator,
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

		List<CRFAutoquery> list = null;

		if (useFinderCache) {
			list = (List<CRFAutoquery>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CRFAUTOQUERY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CRFAUTOQUERY;

				sql = sql.concat(CRFAutoqueryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CRFAutoquery>)QueryUtil.list(
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
	 * Removes all the crf autoqueries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CRFAutoquery crfAutoquery : findAll()) {
			remove(crfAutoquery);
		}
	}

	/**
	 * Returns the number of crf autoqueries.
	 *
	 * @return the number of crf autoqueries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CRFAUTOQUERY);

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
		return "autoQueryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CRFAUTOQUERY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CRFAutoqueryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the crf autoquery persistence.
	 */
	@Activate
	public void activate() {
		CRFAutoqueryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CRFAutoqueryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CRFAutoqueryModelImpl.UUID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFAutoqueryModelImpl.UUID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFAutoqueryModelImpl.UUID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.COMPANYID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByAutoQueryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAutoQueryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAutoQueryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAutoQueryId",
			new String[] {Long.class.getName()},
			CRFAutoqueryModelImpl.AUTOQUERYID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByAutoQueryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAutoQueryId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByQueryTermId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQueryTermId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByQueryTermId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQueryTermId",
			new String[] {Long.class.getName()},
			CRFAutoqueryModelImpl.QUERYTERMID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByQueryTermId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQueryTermId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBySubjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySubjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubjectId",
			new String[] {Long.class.getName()},
			CRFAutoqueryModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountBySubjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubjectId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			CRFAutoqueryModelImpl.USERID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			CRFAutoqueryModelImpl.GROUPID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFAutoqueryModelImpl.GROUPID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.CRFID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_C_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			CRFAutoqueryModelImpl.GROUPID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.CRFID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_C_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindBySdIdSIdValue = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySdIdSIdValue",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySdIdSIdValue = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySdIdSIdValue",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			CRFAutoqueryModelImpl.QUERYTERMID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.QUERYVALUE_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountBySdIdSIdValue = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySdIdSIdValue",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

		_finderPathFetchBySdIdSIdValue_MODEL = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySdIdSIdValue_MODEL",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			CRFAutoqueryModelImpl.QUERYTERMID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.QUERYTERMNAME_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.QUERYVALUE_COLUMN_BITMASK);

		_finderPathCountBySdIdSIdValue_MODEL = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySdIdSIdValue_MODEL",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

		_finderPathFetchBySIdTN = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFAutoqueryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySIdTN",
			new String[] {Long.class.getName(), String.class.getName()},
			CRFAutoqueryModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFAutoqueryModelImpl.QUERYTERMNAME_COLUMN_BITMASK);

		_finderPathCountBySIdTN = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySIdTN",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CRFAutoqueryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
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
				"value.object.column.bitmask.enabled.ecrf.user.model.CRFAutoquery"),
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

	private static final String _SQL_SELECT_CRFAUTOQUERY =
		"SELECT crfAutoquery FROM CRFAutoquery crfAutoquery";

	private static final String _SQL_SELECT_CRFAUTOQUERY_WHERE =
		"SELECT crfAutoquery FROM CRFAutoquery crfAutoquery WHERE ";

	private static final String _SQL_COUNT_CRFAUTOQUERY =
		"SELECT COUNT(crfAutoquery) FROM CRFAutoquery crfAutoquery";

	private static final String _SQL_COUNT_CRFAUTOQUERY_WHERE =
		"SELECT COUNT(crfAutoquery) FROM CRFAutoquery crfAutoquery WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "crfAutoquery.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CRFAutoquery exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CRFAutoquery exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CRFAutoqueryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(ECPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}