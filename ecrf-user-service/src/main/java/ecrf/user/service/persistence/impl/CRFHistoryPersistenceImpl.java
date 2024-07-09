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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import ecrf.user.exception.NoSuchCRFHistoryException;
import ecrf.user.model.CRFHistory;
import ecrf.user.model.impl.CRFHistoryImpl;
import ecrf.user.model.impl.CRFHistoryModelImpl;
import ecrf.user.service.persistence.CRFHistoryPersistence;
import ecrf.user.service.persistence.impl.constants.ECPersistenceConstants;

import java.io.Serializable;

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
 * The persistence implementation for the crf history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @generated
 */
@Component(service = CRFHistoryPersistence.class)
public class CRFHistoryPersistenceImpl
	extends BasePersistenceImpl<CRFHistory> implements CRFHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CRFHistoryUtil</code> to access the crf history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CRFHistoryImpl.class.getName();

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
	 * Returns all the crf histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
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

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if (!uuid.equals(crfHistory.getUuid())) {
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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

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
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByUuid_First(
			String uuid, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByUuid_First(uuid, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByUuid_First(
		String uuid, OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByUuid_Last(
			String uuid, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByUuid_Last(uuid, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByUuid_Last(
		String uuid, OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where uuid = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByUuid_PrevAndNext(
			long historyId, String uuid,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		uuid = Objects.toString(uuid, "");

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, crfHistory, uuid, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByUuid_PrevAndNext(
				session, crfHistory, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory getByUuid_PrevAndNext(
		Session session, CRFHistory crfHistory, String uuid,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CRFHistory crfHistory :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

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
		"crfHistory.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(crfHistory.uuid IS NULL OR crfHistory.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the crf history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByUUID_G(uuid, groupId);

		if (crfHistory == null) {
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

			throw new NoSuchCRFHistoryException(sb.toString());
		}

		return crfHistory;
	}

	/**
	 * Returns the crf history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the crf history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByUUID_G(
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

		if (result instanceof CRFHistory) {
			CRFHistory crfHistory = (CRFHistory)result;

			if (!Objects.equals(uuid, crfHistory.getUuid()) ||
				(groupId != crfHistory.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

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

				List<CRFHistory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CRFHistory crfHistory = list.get(0);

					result = crfHistory;

					cacheResult(crfHistory);
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
			return (CRFHistory)result;
		}
	}

	/**
	 * Removes the crf history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf history that was removed
	 */
	@Override
	public CRFHistory removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByUUID_G(uuid, groupId);

		return remove(crfHistory);
	}

	/**
	 * Returns the number of crf histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

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
		"crfHistory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(crfHistory.uuid IS NULL OR crfHistory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"crfHistory.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
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

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if (!uuid.equals(crfHistory.getUuid()) ||
						(companyId != crfHistory.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

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
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByUuid_C_PrevAndNext(
			long historyId, String uuid, long companyId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		uuid = Objects.toString(uuid, "");

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, crfHistory, uuid, companyId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByUuid_C_PrevAndNext(
				session, crfHistory, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory getByUuid_C_PrevAndNext(
		Session session, CRFHistory crfHistory, String uuid, long companyId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CRFHistory crfHistory :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

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
		"crfHistory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(crfHistory.uuid IS NULL OR crfHistory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"crfHistory.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByHistoryId;
	private FinderPath _finderPathWithoutPaginationFindByHistoryId;
	private FinderPath _finderPathCountByHistoryId;

	/**
	 * Returns all the crf histories where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByHistoryId(long historyId) {
		return findByHistoryId(
			historyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where historyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param historyId the history ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByHistoryId(
		long historyId, int start, int end) {

		return findByHistoryId(historyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where historyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param historyId the history ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByHistoryId(
		long historyId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByHistoryId(historyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where historyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param historyId the history ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByHistoryId(
		long historyId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByHistoryId;
				finderArgs = new Object[] {historyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByHistoryId;
			finderArgs = new Object[] {
				historyId, start, end, orderByComparator
			};
		}

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if (historyId != crfHistory.getHistoryId()) {
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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_HISTORYID_HISTORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(historyId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByHistoryId_First(
			long historyId, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByHistoryId_First(
			historyId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("historyId=");
		sb.append(historyId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByHistoryId_First(
		long historyId, OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByHistoryId(
			historyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByHistoryId_Last(
			long historyId, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByHistoryId_Last(
			historyId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("historyId=");
		sb.append(historyId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByHistoryId_Last(
		long historyId, OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByHistoryId(historyId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByHistoryId(
			historyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the crf histories where historyId = &#63; from the database.
	 *
	 * @param historyId the history ID
	 */
	@Override
	public void removeByHistoryId(long historyId) {
		for (CRFHistory crfHistory :
				findByHistoryId(
					historyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where historyId = &#63;.
	 *
	 * @param historyId the history ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByHistoryId(long historyId) {
		FinderPath finderPath = _finderPathCountByHistoryId;

		Object[] finderArgs = new Object[] {historyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_HISTORYID_HISTORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(historyId);

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

	private static final String _FINDER_COLUMN_HISTORYID_HISTORYID_2 =
		"crfHistory.historyId = ?";

	private FinderPath _finderPathWithPaginationFindBySubjectId;
	private FinderPath _finderPathWithoutPaginationFindBySubjectId;
	private FinderPath _finderPathCountBySubjectId;

	/**
	 * Returns all the crf histories where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findBySubjectId(long subjectId) {
		return findBySubjectId(
			subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findBySubjectId(
		long subjectId, int start, int end) {

		return findBySubjectId(subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findBySubjectId(subjectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
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

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if (subjectId != crfHistory.getSubjectId()) {
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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_SUBJECTID_SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subjectId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findBySubjectId_First(
			long subjectId, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchBySubjectId_First(
			subjectId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchBySubjectId_First(
		long subjectId, OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findBySubjectId(
			subjectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findBySubjectId_Last(
			long subjectId, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchBySubjectId_Last(
			subjectId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchBySubjectId_Last(
		long subjectId, OrderByComparator<CRFHistory> orderByComparator) {

		int count = countBySubjectId(subjectId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findBySubjectId(
			subjectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where subjectId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findBySubjectId_PrevAndNext(
			long historyId, long subjectId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getBySubjectId_PrevAndNext(
				session, crfHistory, subjectId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getBySubjectId_PrevAndNext(
				session, crfHistory, subjectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory getBySubjectId_PrevAndNext(
		Session session, CRFHistory crfHistory, long subjectId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subjectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	@Override
	public void removeBySubjectId(long subjectId) {
		for (CRFHistory crfHistory :
				findBySubjectId(
					subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countBySubjectId(long subjectId) {
		FinderPath finderPath = _finderPathCountBySubjectId;

		Object[] finderArgs = new Object[] {subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

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
		"crfHistory.subjectId = ?";

	private FinderPath _finderPathWithPaginationFindByStructuredDataId;
	private FinderPath _finderPathWithoutPaginationFindByStructuredDataId;
	private FinderPath _finderPathCountByStructuredDataId;

	/**
	 * Returns all the crf histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByStructuredDataId(long structuredDataId) {
		return findByStructuredDataId(
			structuredDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByStructuredDataId(
		long structuredDataId, int start, int end) {

		return findByStructuredDataId(structuredDataId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByStructuredDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByStructuredDataId(
			structuredDataId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByStructuredDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStructuredDataId;
				finderArgs = new Object[] {structuredDataId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStructuredDataId;
			finderArgs = new Object[] {
				structuredDataId, start, end, orderByComparator
			};
		}

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if (structuredDataId != crfHistory.getStructuredDataId()) {
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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_STRUCTUREDDATAID_STRUCTUREDDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(structuredDataId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByStructuredDataId_First(
			long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByStructuredDataId_First(
			structuredDataId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("structuredDataId=");
		sb.append(structuredDataId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByStructuredDataId_First(
		long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByStructuredDataId(
			structuredDataId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByStructuredDataId_Last(
			long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByStructuredDataId_Last(
			structuredDataId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("structuredDataId=");
		sb.append(structuredDataId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByStructuredDataId_Last(
		long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByStructuredDataId(structuredDataId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByStructuredDataId(
			structuredDataId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByStructuredDataId_PrevAndNext(
			long historyId, long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByStructuredDataId_PrevAndNext(
				session, crfHistory, structuredDataId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByStructuredDataId_PrevAndNext(
				session, crfHistory, structuredDataId, orderByComparator,
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

	protected CRFHistory getByStructuredDataId_PrevAndNext(
		Session session, CRFHistory crfHistory, long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_STRUCTUREDDATAID_STRUCTUREDDATAID_2);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(structuredDataId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 */
	@Override
	public void removeByStructuredDataId(long structuredDataId) {
		for (CRFHistory crfHistory :
				findByStructuredDataId(
					structuredDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByStructuredDataId(long structuredDataId) {
		FinderPath finderPath = _finderPathCountByStructuredDataId;

		Object[] finderArgs = new Object[] {structuredDataId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_STRUCTUREDDATAID_STRUCTUREDDATAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(structuredDataId);

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
		_FINDER_COLUMN_STRUCTUREDDATAID_STRUCTUREDDATAID_2 =
			"crfHistory.structuredDataId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the crf histories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
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

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if (groupId != crfHistory.getGroupId()) {
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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByGroupId_First(
			long groupId, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByGroupId_First(
			groupId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByGroupId_First(
		long groupId, OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByGroupId_Last(
			long groupId, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByGroupId_Last(groupId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByGroupId_PrevAndNext(
			long historyId, long groupId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, crfHistory, groupId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByGroupId_PrevAndNext(
				session, crfHistory, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory getByGroupId_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<CRFHistory>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] filterFindByGroupId_PrevAndNext(
			long historyId, long groupId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				historyId, groupId, orderByComparator);
		}

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, crfHistory, groupId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, crfHistory, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory filterGetByGroupId_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (CRFHistory crfHistory :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

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

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"crfHistory.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the crf histories where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
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

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if (userId != crfHistory.getUserId()) {
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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByUserId_First(
			long userId, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByUserId_First(userId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByUserId_First(
		long userId, OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByUserId_Last(
			long userId, OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByUserId_Last(userId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByUserId_Last(
		long userId, OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where userId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByUserId_PrevAndNext(
			long historyId, long userId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, crfHistory, userId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByUserId_PrevAndNext(
				session, crfHistory, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory getByUserId_PrevAndNext(
		Session session, CRFHistory crfHistory, long userId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (CRFHistory crfHistory :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

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
		"crfHistory.userId = ?";

	private FinderPath _finderPathWithPaginationFindByG_U;
	private FinderPath _finderPathWithoutPaginationFindByG_U;
	private FinderPath _finderPathCountByG_U;

	/**
	 * Returns all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_U(long groupId, long userId) {
		return findByG_U(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_U(
		long groupId, long userId, int start, int end) {

		return findByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByG_U(groupId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_U;
				finderArgs = new Object[] {groupId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_U;
			finderArgs = new Object[] {
				groupId, userId, start, end, orderByComparator
			};
		}

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if ((groupId != crfHistory.getGroupId()) ||
						(userId != crfHistory.getUserId())) {

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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByG_U_First(
			long groupId, long userId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByG_U_First(
			groupId, userId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByG_U(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByG_U_Last(
			groupId, userId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByG_U(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByG_U(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByG_U_PrevAndNext(
			long historyId, long groupId, long userId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByG_U_PrevAndNext(
				session, crfHistory, groupId, userId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByG_U_PrevAndNext(
				session, crfHistory, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory getByG_U_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId, long userId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_USERID_2);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_U(long groupId, long userId) {
		return filterFindByG_U(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_U(
		long groupId, long userId, int start, int end) {

		return filterFindByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U(groupId, userId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			return (List<CRFHistory>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] filterFindByG_U_PrevAndNext(
			long historyId, long groupId, long userId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_PrevAndNext(
				historyId, groupId, userId, orderByComparator);
		}

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = filterGetByG_U_PrevAndNext(
				session, crfHistory, groupId, userId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = filterGetByG_U_PrevAndNext(
				session, crfHistory, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory filterGetByG_U_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId, long userId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByG_U(long groupId, long userId) {
		for (CRFHistory crfHistory :
				findByG_U(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByG_U(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountByG_U;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	@Override
	public int filterCountByG_U(long groupId, long userId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U(groupId, userId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_U_GROUPID_2 =
		"crfHistory.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_USERID_2 =
		"crfHistory.userId = ?";

	private FinderPath _finderPathWithPaginationFindByC_S;
	private FinderPath _finderPathWithoutPaginationFindByC_S;
	private FinderPath _finderPathCountByC_S;

	/**
	 * Returns all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByC_S(long crfId, long subjectId) {
		return findByC_S(
			crfId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByC_S(
		long crfId, long subjectId, int start, int end) {

		return findByC_S(crfId, subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByC_S(
		long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByC_S(crfId, subjectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByC_S(
		long crfId, long subjectId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_S;
				finderArgs = new Object[] {crfId, subjectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_S;
			finderArgs = new Object[] {
				crfId, subjectId, start, end, orderByComparator
			};
		}

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if ((crfId != crfHistory.getCrfId()) ||
						(subjectId != crfHistory.getSubjectId())) {

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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_C_S_CRFID_2);

			sb.append(_FINDER_COLUMN_C_S_SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				queryPos.add(subjectId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByC_S_First(
			long crfId, long subjectId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByC_S_First(
			crfId, subjectId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByC_S_First(
		long crfId, long subjectId,
		OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByC_S(
			crfId, subjectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByC_S_Last(
			long crfId, long subjectId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByC_S_Last(
			crfId, subjectId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByC_S_Last(
		long crfId, long subjectId,
		OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByC_S(crfId, subjectId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByC_S(
			crfId, subjectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByC_S_PrevAndNext(
			long historyId, long crfId, long subjectId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByC_S_PrevAndNext(
				session, crfHistory, crfId, subjectId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByC_S_PrevAndNext(
				session, crfHistory, crfId, subjectId, orderByComparator,
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

	protected CRFHistory getByC_S_PrevAndNext(
		Session session, CRFHistory crfHistory, long crfId, long subjectId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_C_S_CRFID_2);

		sb.append(_FINDER_COLUMN_C_S_SUBJECTID_2);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(crfId);

		queryPos.add(subjectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	@Override
	public void removeByC_S(long crfId, long subjectId) {
		for (CRFHistory crfHistory :
				findByC_S(
					crfId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByC_S(long crfId, long subjectId) {
		FinderPath finderPath = _finderPathCountByC_S;

		Object[] finderArgs = new Object[] {crfId, subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_C_S_CRFID_2);

			sb.append(_FINDER_COLUMN_C_S_SUBJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_C_S_CRFID_2 =
		"crfHistory.crfId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_SUBJECTID_2 =
		"crfHistory.subjectId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C;
	private FinderPath _finderPathWithoutPaginationFindByG_C;
	private FinderPath _finderPathCountByG_C;

	/**
	 * Returns all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_C(long groupId, long crfId) {
		return findByG_C(
			groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_C(
		long groupId, long crfId, int start, int end) {

		return findByG_C(groupId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByG_C(groupId, crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
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

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if ((groupId != crfHistory.getGroupId()) ||
						(crfId != crfHistory.getCrfId())) {

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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByG_C_First(
			groupId, crfId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByG_C(
			groupId, crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByG_C_Last(
			groupId, crfId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByG_C(groupId, crfId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByG_C(
			groupId, crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByG_C_PrevAndNext(
			long historyId, long groupId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByG_C_PrevAndNext(
				session, crfHistory, groupId, crfId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByG_C_PrevAndNext(
				session, crfHistory, groupId, crfId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory getByG_C_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_C(long groupId, long crfId) {
		return filterFindByG_C(
			groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_C(
		long groupId, long crfId, int start, int end) {

		return filterFindByG_C(groupId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C(groupId, crfId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CRFID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(crfId);

			return (List<CRFHistory>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] filterFindByG_C_PrevAndNext(
			long historyId, long groupId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_PrevAndNext(
				historyId, groupId, crfId, orderByComparator);
		}

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = filterGetByG_C_PrevAndNext(
				session, crfHistory, groupId, crfId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = filterGetByG_C_PrevAndNext(
				session, crfHistory, groupId, crfId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory filterGetByG_C_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CRFID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(crfId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByG_C(long groupId, long crfId) {
		for (CRFHistory crfHistory :
				findByG_C(
					groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByG_C(long groupId, long crfId) {
		FinderPath finderPath = _finderPathCountByG_C;

		Object[] finderArgs = new Object[] {groupId, crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

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

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	@Override
	public int filterCountByG_C(long groupId, long crfId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C(groupId, crfId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CRFID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(crfId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_C_GROUPID_2 =
		"crfHistory.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_CRFID_2 =
		"crfHistory.crfId = ?";

	private FinderPath _finderPathWithPaginationFindByG_S_C;
	private FinderPath _finderPathWithoutPaginationFindByG_S_C;
	private FinderPath _finderPathCountByG_S_C;

	/**
	 * Returns all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_S_C(
		long groupId, long subjectId, long crfId) {

		return findByG_S_C(
			groupId, subjectId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end) {

		return findByG_S_C(groupId, subjectId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		return findByG_S_C(
			groupId, subjectId, crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S_C;
				finderArgs = new Object[] {groupId, subjectId, crfId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S_C;
			finderArgs = new Object[] {
				groupId, subjectId, crfId, start, end, orderByComparator
			};
		}

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if ((groupId != crfHistory.getGroupId()) ||
						(subjectId != crfHistory.getSubjectId()) ||
						(crfId != crfHistory.getCrfId())) {

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

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_C_SUBJECTID_2);

			sb.append(_FINDER_COLUMN_G_S_C_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(subjectId);

				queryPos.add(crfId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByG_S_C_First(
			long groupId, long subjectId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByG_S_C_First(
			groupId, subjectId, crfId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByG_S_C_First(
		long groupId, long subjectId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByG_S_C(
			groupId, subjectId, crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByG_S_C_Last(
			long groupId, long subjectId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByG_S_C_Last(
			groupId, subjectId, crfId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByG_S_C_Last(
		long groupId, long subjectId, long crfId,
		OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByG_S_C(groupId, subjectId, crfId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByG_S_C(
			groupId, subjectId, crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByG_S_C_PrevAndNext(
			long historyId, long groupId, long subjectId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByG_S_C_PrevAndNext(
				session, crfHistory, groupId, subjectId, crfId,
				orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByG_S_C_PrevAndNext(
				session, crfHistory, groupId, subjectId, crfId,
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

	protected CRFHistory getByG_S_C_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId, long subjectId,
		long crfId, OrderByComparator<CRFHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SUBJECTID_2);

		sb.append(_FINDER_COLUMN_G_S_C_CRFID_2);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(subjectId);

		queryPos.add(crfId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_S_C(
		long groupId, long subjectId, long crfId) {

		return filterFindByG_S_C(
			groupId, subjectId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end) {

		return filterFindByG_S_C(groupId, subjectId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<CRFHistory> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_C(
				groupId, subjectId, crfId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SUBJECTID_2);

		sb.append(_FINDER_COLUMN_G_S_C_CRFID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(subjectId);

			queryPos.add(crfId);

			return (List<CRFHistory>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] filterFindByG_S_C_PrevAndNext(
			long historyId, long groupId, long subjectId, long crfId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_C_PrevAndNext(
				historyId, groupId, subjectId, crfId, orderByComparator);
		}

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = filterGetByG_S_C_PrevAndNext(
				session, crfHistory, groupId, subjectId, crfId,
				orderByComparator, true);

			array[1] = crfHistory;

			array[2] = filterGetByG_S_C_PrevAndNext(
				session, crfHistory, groupId, subjectId, crfId,
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

	protected CRFHistory filterGetByG_S_C_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId, long subjectId,
		long crfId, OrderByComparator<CRFHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SUBJECTID_2);

		sb.append(_FINDER_COLUMN_G_S_C_CRFID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(subjectId);

		queryPos.add(crfId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByG_S_C(long groupId, long subjectId, long crfId) {
		for (CRFHistory crfHistory :
				findByG_S_C(
					groupId, subjectId, crfId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByG_S_C(long groupId, long subjectId, long crfId) {
		FinderPath finderPath = _finderPathCountByG_S_C;

		Object[] finderArgs = new Object[] {groupId, subjectId, crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_C_SUBJECTID_2);

			sb.append(_FINDER_COLUMN_G_S_C_CRFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(subjectId);

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

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	@Override
	public int filterCountByG_S_C(long groupId, long subjectId, long crfId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S_C(groupId, subjectId, crfId);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SUBJECTID_2);

		sb.append(_FINDER_COLUMN_G_S_C_CRFID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(subjectId);

			queryPos.add(crfId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_C_GROUPID_2 =
		"crfHistory.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_SUBJECTID_2 =
		"crfHistory.subjectId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_CRFID_2 =
		"crfHistory.crfId = ?";

	private FinderPath _finderPathWithPaginationFindByG_S_C_SD;
	private FinderPath _finderPathWithoutPaginationFindByG_S_C_SD;
	private FinderPath _finderPathCountByG_S_C_SD;

	/**
	 * Returns all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		return findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		int start, int end) {

		return findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		int start, int end, OrderByComparator<CRFHistory> orderByComparator) {

		return findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf histories
	 */
	@Override
	public List<CRFHistory> findByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		int start, int end, OrderByComparator<CRFHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S_C_SD;
				finderArgs = new Object[] {
					groupId, subjectId, crfId, structuredDataId
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S_C_SD;
			finderArgs = new Object[] {
				groupId, subjectId, crfId, structuredDataId, start, end,
				orderByComparator
			};
		}

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFHistory crfHistory : list) {
					if ((groupId != crfHistory.getGroupId()) ||
						(subjectId != crfHistory.getSubjectId()) ||
						(crfId != crfHistory.getCrfId()) ||
						(structuredDataId !=
							crfHistory.getStructuredDataId())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_C_SD_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_C_SD_SUBJECTID_2);

			sb.append(_FINDER_COLUMN_G_S_C_SD_CRFID_2);

			sb.append(_FINDER_COLUMN_G_S_C_SD_STRUCTUREDDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(subjectId);

				queryPos.add(crfId);

				queryPos.add(structuredDataId);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Returns the first crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByG_S_C_SD_First(
			long groupId, long subjectId, long crfId, long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByG_S_C_SD_First(
			groupId, subjectId, crfId, structuredDataId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append(", structuredDataId=");
		sb.append(structuredDataId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the first crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByG_S_C_SD_First(
		long groupId, long subjectId, long crfId, long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator) {

		List<CRFHistory> list = findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history
	 * @throws NoSuchCRFHistoryException if a matching crf history could not be found
	 */
	@Override
	public CRFHistory findByG_S_C_SD_Last(
			long groupId, long subjectId, long crfId, long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByG_S_C_SD_Last(
			groupId, subjectId, crfId, structuredDataId, orderByComparator);

		if (crfHistory != null) {
			return crfHistory;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append(", structuredDataId=");
		sb.append(structuredDataId);

		sb.append("}");

		throw new NoSuchCRFHistoryException(sb.toString());
	}

	/**
	 * Returns the last crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf history, or <code>null</code> if a matching crf history could not be found
	 */
	@Override
	public CRFHistory fetchByG_S_C_SD_Last(
		long groupId, long subjectId, long crfId, long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator) {

		int count = countByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);

		if (count == 0) {
			return null;
		}

		List<CRFHistory> list = findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] findByG_S_C_SD_PrevAndNext(
			long historyId, long groupId, long subjectId, long crfId,
			long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = getByG_S_C_SD_PrevAndNext(
				session, crfHistory, groupId, subjectId, crfId,
				structuredDataId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = getByG_S_C_SD_PrevAndNext(
				session, crfHistory, groupId, subjectId, crfId,
				structuredDataId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory getByG_S_C_SD_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId, long subjectId,
		long crfId, long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_C_SD_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_SUBJECTID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_CRFID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_STRUCTUREDDATAID_2);

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
			sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(subjectId);

		queryPos.add(crfId);

		queryPos.add(structuredDataId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the crf histories that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		return filterFindByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		int start, int end) {

		return filterFindByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories that the user has permissions to view where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf histories that the user has permission to view
	 */
	@Override
	public List<CRFHistory> filterFindByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		int start, int end, OrderByComparator<CRFHistory> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_C_SD(
				groupId, subjectId, crfId, structuredDataId, start, end,
				orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(7);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_C_SD_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_SUBJECTID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_CRFID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_STRUCTUREDDATAID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(subjectId);

			queryPos.add(crfId);

			queryPos.add(structuredDataId);

			return (List<CRFHistory>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the crf histories before and after the current crf history in the ordered set of crf histories that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param historyId the primary key of the current crf history
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory[] filterFindByG_S_C_SD_PrevAndNext(
			long historyId, long groupId, long subjectId, long crfId,
			long structuredDataId,
			OrderByComparator<CRFHistory> orderByComparator)
		throws NoSuchCRFHistoryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_C_SD_PrevAndNext(
				historyId, groupId, subjectId, crfId, structuredDataId,
				orderByComparator);
		}

		CRFHistory crfHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			CRFHistory[] array = new CRFHistoryImpl[3];

			array[0] = filterGetByG_S_C_SD_PrevAndNext(
				session, crfHistory, groupId, subjectId, crfId,
				structuredDataId, orderByComparator, true);

			array[1] = crfHistory;

			array[2] = filterGetByG_S_C_SD_PrevAndNext(
				session, crfHistory, groupId, subjectId, crfId,
				structuredDataId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFHistory filterGetByG_S_C_SD_PrevAndNext(
		Session session, CRFHistory crfHistory, long groupId, long subjectId,
		long crfId, long structuredDataId,
		OrderByComparator<CRFHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(7);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_C_SD_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_SUBJECTID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_CRFID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_STRUCTUREDDATAID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFHistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFHistoryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFHistoryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(subjectId);

		queryPos.add(crfId);

		queryPos.add(structuredDataId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFHistory> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 */
	@Override
	public void removeByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		for (CRFHistory crfHistory :
				findByG_S_C_SD(
					groupId, subjectId, crfId, structuredDataId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching crf histories
	 */
	@Override
	public int countByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		FinderPath finderPath = _finderPathCountByG_S_C_SD;

		Object[] finderArgs = new Object[] {
			groupId, subjectId, crfId, structuredDataId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_CRFHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_C_SD_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_C_SD_SUBJECTID_2);

			sb.append(_FINDER_COLUMN_G_S_C_SD_CRFID_2);

			sb.append(_FINDER_COLUMN_G_S_C_SD_STRUCTUREDDATAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(subjectId);

				queryPos.add(crfId);

				queryPos.add(structuredDataId);

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

	/**
	 * Returns the number of crf histories that the user has permission to view where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching crf histories that the user has permission to view
	 */
	@Override
	public int filterCountByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S_C_SD(groupId, subjectId, crfId, structuredDataId);
		}

		StringBundler sb = new StringBundler(5);

		sb.append(_FILTER_SQL_COUNT_CRFHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_C_SD_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_SUBJECTID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_CRFID_2);

		sb.append(_FINDER_COLUMN_G_S_C_SD_STRUCTUREDDATAID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFHistory.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(subjectId);

			queryPos.add(crfId);

			queryPos.add(structuredDataId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_C_SD_GROUPID_2 =
		"crfHistory.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_SD_SUBJECTID_2 =
		"crfHistory.subjectId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_SD_CRFID_2 =
		"crfHistory.crfId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_SD_STRUCTUREDDATAID_2 =
		"crfHistory.structuredDataId = ?";

	public CRFHistoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CRFHistory.class);

		setModelImplClass(CRFHistoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the crf history in the entity cache if it is enabled.
	 *
	 * @param crfHistory the crf history
	 */
	@Override
	public void cacheResult(CRFHistory crfHistory) {
		entityCache.putResult(
			entityCacheEnabled, CRFHistoryImpl.class,
			crfHistory.getPrimaryKey(), crfHistory);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {crfHistory.getUuid(), crfHistory.getGroupId()},
			crfHistory);

		crfHistory.resetOriginalValues();
	}

	/**
	 * Caches the crf histories in the entity cache if it is enabled.
	 *
	 * @param crfHistories the crf histories
	 */
	@Override
	public void cacheResult(List<CRFHistory> crfHistories) {
		for (CRFHistory crfHistory : crfHistories) {
			if (entityCache.getResult(
					entityCacheEnabled, CRFHistoryImpl.class,
					crfHistory.getPrimaryKey()) == null) {

				cacheResult(crfHistory);
			}
			else {
				crfHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all crf histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CRFHistoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the crf history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CRFHistory crfHistory) {
		entityCache.removeResult(
			entityCacheEnabled, CRFHistoryImpl.class,
			crfHistory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CRFHistoryModelImpl)crfHistory, true);
	}

	@Override
	public void clearCache(List<CRFHistory> crfHistories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CRFHistory crfHistory : crfHistories) {
			entityCache.removeResult(
				entityCacheEnabled, CRFHistoryImpl.class,
				crfHistory.getPrimaryKey());

			clearUniqueFindersCache((CRFHistoryModelImpl)crfHistory, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CRFHistoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CRFHistoryModelImpl crfHistoryModelImpl) {

		Object[] args = new Object[] {
			crfHistoryModelImpl.getUuid(), crfHistoryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, crfHistoryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CRFHistoryModelImpl crfHistoryModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfHistoryModelImpl.getUuid(), crfHistoryModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((crfHistoryModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfHistoryModelImpl.getOriginalUuid(),
				crfHistoryModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new crf history with the primary key. Does not add the crf history to the database.
	 *
	 * @param historyId the primary key for the new crf history
	 * @return the new crf history
	 */
	@Override
	public CRFHistory create(long historyId) {
		CRFHistory crfHistory = new CRFHistoryImpl();

		crfHistory.setNew(true);
		crfHistory.setPrimaryKey(historyId);

		String uuid = PortalUUIDUtil.generate();

		crfHistory.setUuid(uuid);

		crfHistory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return crfHistory;
	}

	/**
	 * Removes the crf history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history that was removed
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory remove(long historyId) throws NoSuchCRFHistoryException {
		return remove((Serializable)historyId);
	}

	/**
	 * Removes the crf history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the crf history
	 * @return the crf history that was removed
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory remove(Serializable primaryKey)
		throws NoSuchCRFHistoryException {

		Session session = null;

		try {
			session = openSession();

			CRFHistory crfHistory = (CRFHistory)session.get(
				CRFHistoryImpl.class, primaryKey);

			if (crfHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCRFHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(crfHistory);
		}
		catch (NoSuchCRFHistoryException noSuchEntityException) {
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
	protected CRFHistory removeImpl(CRFHistory crfHistory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(crfHistory)) {
				crfHistory = (CRFHistory)session.get(
					CRFHistoryImpl.class, crfHistory.getPrimaryKeyObj());
			}

			if (crfHistory != null) {
				session.delete(crfHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (crfHistory != null) {
			clearCache(crfHistory);
		}

		return crfHistory;
	}

	@Override
	public CRFHistory updateImpl(CRFHistory crfHistory) {
		boolean isNew = crfHistory.isNew();

		if (!(crfHistory instanceof CRFHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(crfHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(crfHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in crfHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CRFHistory implementation " +
					crfHistory.getClass());
		}

		CRFHistoryModelImpl crfHistoryModelImpl =
			(CRFHistoryModelImpl)crfHistory;

		if (Validator.isNull(crfHistory.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			crfHistory.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (crfHistory.getCreateDate() == null)) {
			if (serviceContext == null) {
				crfHistory.setCreateDate(now);
			}
			else {
				crfHistory.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!crfHistoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				crfHistory.setModifiedDate(now);
			}
			else {
				crfHistory.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (crfHistory.isNew()) {
				session.save(crfHistory);

				crfHistory.setNew(false);
			}
			else {
				crfHistory = (CRFHistory)session.merge(crfHistory);
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
			Object[] args = new Object[] {crfHistoryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				crfHistoryModelImpl.getUuid(),
				crfHistoryModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {crfHistoryModelImpl.getHistoryId()};

			finderCache.removeResult(_finderPathCountByHistoryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByHistoryId, args);

			args = new Object[] {crfHistoryModelImpl.getSubjectId()};

			finderCache.removeResult(_finderPathCountBySubjectId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySubjectId, args);

			args = new Object[] {crfHistoryModelImpl.getStructuredDataId()};

			finderCache.removeResult(_finderPathCountByStructuredDataId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStructuredDataId, args);

			args = new Object[] {crfHistoryModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {crfHistoryModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {
				crfHistoryModelImpl.getGroupId(),
				crfHistoryModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByG_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_U, args);

			args = new Object[] {
				crfHistoryModelImpl.getCrfId(),
				crfHistoryModelImpl.getSubjectId()
			};

			finderCache.removeResult(_finderPathCountByC_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_S, args);

			args = new Object[] {
				crfHistoryModelImpl.getGroupId(), crfHistoryModelImpl.getCrfId()
			};

			finderCache.removeResult(_finderPathCountByG_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C, args);

			args = new Object[] {
				crfHistoryModelImpl.getGroupId(),
				crfHistoryModelImpl.getSubjectId(),
				crfHistoryModelImpl.getCrfId()
			};

			finderCache.removeResult(_finderPathCountByG_S_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S_C, args);

			args = new Object[] {
				crfHistoryModelImpl.getGroupId(),
				crfHistoryModelImpl.getSubjectId(),
				crfHistoryModelImpl.getCrfId(),
				crfHistoryModelImpl.getStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByG_S_C_SD, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S_C_SD, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {crfHistoryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalUuid(),
					crfHistoryModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					crfHistoryModelImpl.getUuid(),
					crfHistoryModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByHistoryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalHistoryId()
				};

				finderCache.removeResult(_finderPathCountByHistoryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByHistoryId, args);

				args = new Object[] {crfHistoryModelImpl.getHistoryId()};

				finderCache.removeResult(_finderPathCountByHistoryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByHistoryId, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySubjectId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalSubjectId()
				};

				finderCache.removeResult(_finderPathCountBySubjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySubjectId, args);

				args = new Object[] {crfHistoryModelImpl.getSubjectId()};

				finderCache.removeResult(_finderPathCountBySubjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySubjectId, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStructuredDataId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalStructuredDataId()
				};

				finderCache.removeResult(
					_finderPathCountByStructuredDataId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStructuredDataId, args);

				args = new Object[] {crfHistoryModelImpl.getStructuredDataId()};

				finderCache.removeResult(
					_finderPathCountByStructuredDataId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStructuredDataId, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {crfHistoryModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {crfHistoryModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_U.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalGroupId(),
					crfHistoryModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByG_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U, args);

				args = new Object[] {
					crfHistoryModelImpl.getGroupId(),
					crfHistoryModelImpl.getUserId()
				};

				finderCache.removeResult(_finderPathCountByG_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalCrfId(),
					crfHistoryModelImpl.getOriginalSubjectId()
				};

				finderCache.removeResult(_finderPathCountByC_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_S, args);

				args = new Object[] {
					crfHistoryModelImpl.getCrfId(),
					crfHistoryModelImpl.getSubjectId()
				};

				finderCache.removeResult(_finderPathCountByC_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_S, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalGroupId(),
					crfHistoryModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);

				args = new Object[] {
					crfHistoryModelImpl.getGroupId(),
					crfHistoryModelImpl.getCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalGroupId(),
					crfHistoryModelImpl.getOriginalSubjectId(),
					crfHistoryModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_S_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S_C, args);

				args = new Object[] {
					crfHistoryModelImpl.getGroupId(),
					crfHistoryModelImpl.getSubjectId(),
					crfHistoryModelImpl.getCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_S_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S_C, args);
			}

			if ((crfHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S_C_SD.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfHistoryModelImpl.getOriginalGroupId(),
					crfHistoryModelImpl.getOriginalSubjectId(),
					crfHistoryModelImpl.getOriginalCrfId(),
					crfHistoryModelImpl.getOriginalStructuredDataId()
				};

				finderCache.removeResult(_finderPathCountByG_S_C_SD, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S_C_SD, args);

				args = new Object[] {
					crfHistoryModelImpl.getGroupId(),
					crfHistoryModelImpl.getSubjectId(),
					crfHistoryModelImpl.getCrfId(),
					crfHistoryModelImpl.getStructuredDataId()
				};

				finderCache.removeResult(_finderPathCountByG_S_C_SD, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S_C_SD, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CRFHistoryImpl.class,
			crfHistory.getPrimaryKey(), crfHistory, false);

		clearUniqueFindersCache(crfHistoryModelImpl, false);
		cacheUniqueFindersCache(crfHistoryModelImpl);

		crfHistory.resetOriginalValues();

		return crfHistory;
	}

	/**
	 * Returns the crf history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the crf history
	 * @return the crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCRFHistoryException {

		CRFHistory crfHistory = fetchByPrimaryKey(primaryKey);

		if (crfHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCRFHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return crfHistory;
	}

	/**
	 * Returns the crf history with the primary key or throws a <code>NoSuchCRFHistoryException</code> if it could not be found.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history
	 * @throws NoSuchCRFHistoryException if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory findByPrimaryKey(long historyId)
		throws NoSuchCRFHistoryException {

		return findByPrimaryKey((Serializable)historyId);
	}

	/**
	 * Returns the crf history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the crf history
	 * @return the crf history, or <code>null</code> if a crf history with the primary key could not be found
	 */
	@Override
	public CRFHistory fetchByPrimaryKey(long historyId) {
		return fetchByPrimaryKey((Serializable)historyId);
	}

	/**
	 * Returns all the crf histories.
	 *
	 * @return the crf histories
	 */
	@Override
	public List<CRFHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @return the range of crf histories
	 */
	@Override
	public List<CRFHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf histories
	 */
	@Override
	public List<CRFHistory> findAll(
		int start, int end, OrderByComparator<CRFHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf histories
	 * @param end the upper bound of the range of crf histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf histories
	 */
	@Override
	public List<CRFHistory> findAll(
		int start, int end, OrderByComparator<CRFHistory> orderByComparator,
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

		List<CRFHistory> list = null;

		if (useFinderCache) {
			list = (List<CRFHistory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CRFHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CRFHISTORY;

				sql = sql.concat(CRFHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CRFHistory>)QueryUtil.list(
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
	 * Removes all the crf histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CRFHistory crfHistory : findAll()) {
			remove(crfHistory);
		}
	}

	/**
	 * Returns the number of crf histories.
	 *
	 * @return the number of crf histories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CRFHISTORY);

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
		return "historyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CRFHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CRFHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the crf history persistence.
	 */
	@Activate
	public void activate() {
		CRFHistoryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CRFHistoryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CRFHistoryModelImpl.UUID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFHistoryModelImpl.UUID_COLUMN_BITMASK |
			CRFHistoryModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFHistoryModelImpl.UUID_COLUMN_BITMASK |
			CRFHistoryModelImpl.COMPANYID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByHistoryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHistoryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByHistoryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHistoryId",
			new String[] {Long.class.getName()},
			CRFHistoryModelImpl.HISTORYID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByHistoryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHistoryId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBySubjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySubjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubjectId",
			new String[] {Long.class.getName()},
			CRFHistoryModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountBySubjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubjectId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByStructuredDataId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStructuredDataId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStructuredDataId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStructuredDataId",
			new String[] {Long.class.getName()},
			CRFHistoryModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByStructuredDataId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStructuredDataId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			CRFHistoryModelImpl.GROUPID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			CRFHistoryModelImpl.USERID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFHistoryModelImpl.GROUPID_COLUMN_BITMASK |
			CRFHistoryModelImpl.USERID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFHistoryModelImpl.CRFID_COLUMN_BITMASK |
			CRFHistoryModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFHistoryModelImpl.GROUPID_COLUMN_BITMASK |
			CRFHistoryModelImpl.CRFID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_S_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			CRFHistoryModelImpl.GROUPID_COLUMN_BITMASK |
			CRFHistoryModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFHistoryModelImpl.CRFID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_S_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByG_S_C_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S_C_SD",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S_C_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_C_SD",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			CRFHistoryModelImpl.GROUPID_COLUMN_BITMASK |
			CRFHistoryModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFHistoryModelImpl.CRFID_COLUMN_BITMASK |
			CRFHistoryModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			CRFHistoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_S_C_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_C_SD",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CRFHistoryImpl.class.getName());
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
				"value.object.column.bitmask.enabled.ecrf.user.model.CRFHistory"),
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

	private static final String _SQL_SELECT_CRFHISTORY =
		"SELECT crfHistory FROM CRFHistory crfHistory";

	private static final String _SQL_SELECT_CRFHISTORY_WHERE =
		"SELECT crfHistory FROM CRFHistory crfHistory WHERE ";

	private static final String _SQL_COUNT_CRFHISTORY =
		"SELECT COUNT(crfHistory) FROM CRFHistory crfHistory";

	private static final String _SQL_COUNT_CRFHISTORY_WHERE =
		"SELECT COUNT(crfHistory) FROM CRFHistory crfHistory WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"crfHistory.historyId";

	private static final String _FILTER_SQL_SELECT_CRFHISTORY_WHERE =
		"SELECT DISTINCT {crfHistory.*} FROM EC_CRFHistory crfHistory WHERE ";

	private static final String
		_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {EC_CRFHistory.*} FROM (SELECT DISTINCT crfHistory.historyId FROM EC_CRFHistory crfHistory WHERE ";

	private static final String
		_FILTER_SQL_SELECT_CRFHISTORY_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN EC_CRFHistory ON TEMP_TABLE.historyId = EC_CRFHistory.historyId";

	private static final String _FILTER_SQL_COUNT_CRFHISTORY_WHERE =
		"SELECT COUNT(DISTINCT crfHistory.historyId) AS COUNT_VALUE FROM EC_CRFHistory crfHistory WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "crfHistory";

	private static final String _FILTER_ENTITY_TABLE = "EC_CRFHistory";

	private static final String _ORDER_BY_ENTITY_ALIAS = "crfHistory.";

	private static final String _ORDER_BY_ENTITY_TABLE = "EC_CRFHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CRFHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CRFHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CRFHistoryPersistenceImpl.class);

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