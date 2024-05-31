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

import ecrf.user.exception.NoSuchCRFResearcherException;
import ecrf.user.model.CRFResearcher;
import ecrf.user.model.impl.CRFResearcherImpl;
import ecrf.user.model.impl.CRFResearcherModelImpl;
import ecrf.user.service.persistence.CRFResearcherPersistence;
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
 * The persistence implementation for the crf researcher service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @generated
 */
@Component(service = CRFResearcherPersistence.class)
public class CRFResearcherPersistenceImpl
	extends BasePersistenceImpl<CRFResearcher>
	implements CRFResearcherPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CRFResearcherUtil</code> to access the crf researcher persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CRFResearcherImpl.class.getName();

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
	 * Returns all the crf researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf researchers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
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

		List<CRFResearcher> list = null;

		if (useFinderCache) {
			list = (List<CRFResearcher>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFResearcher crfResearcher : list) {
					if (!uuid.equals(crfResearcher.getUuid())) {
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

			sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

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
				sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFResearcher>)QueryUtil.list(
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
	 * Returns the first crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByUuid_First(
			String uuid, OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByUuid_First(
			uuid, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByUuid_First(
		String uuid, OrderByComparator<CRFResearcher> orderByComparator) {

		List<CRFResearcher> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByUuid_Last(
			String uuid, OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByUuid_Last(uuid, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByUuid_Last(
		String uuid, OrderByComparator<CRFResearcher> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CRFResearcher> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where uuid = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher[] findByUuid_PrevAndNext(
			long crfResearcherId, String uuid,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		uuid = Objects.toString(uuid, "");

		CRFResearcher crfResearcher = findByPrimaryKey(crfResearcherId);

		Session session = null;

		try {
			session = openSession();

			CRFResearcher[] array = new CRFResearcherImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, crfResearcher, uuid, orderByComparator, true);

			array[1] = crfResearcher;

			array[2] = getByUuid_PrevAndNext(
				session, crfResearcher, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFResearcher getByUuid_PrevAndNext(
		Session session, CRFResearcher crfResearcher, String uuid,
		OrderByComparator<CRFResearcher> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

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
			sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						crfResearcher)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFResearcher> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf researchers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CRFResearcher crfResearcher :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfResearcher);
		}
	}

	/**
	 * Returns the number of crf researchers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf researchers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFRESEARCHER_WHERE);

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
		"crfResearcher.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(crfResearcher.uuid IS NULL OR crfResearcher.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the crf researcher where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFResearcherException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByUUID_G(uuid, groupId);

		if (crfResearcher == null) {
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

			throw new NoSuchCRFResearcherException(sb.toString());
		}

		return crfResearcher;
	}

	/**
	 * Returns the crf researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the crf researcher where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByUUID_G(
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

		if (result instanceof CRFResearcher) {
			CRFResearcher crfResearcher = (CRFResearcher)result;

			if (!Objects.equals(uuid, crfResearcher.getUuid()) ||
				(groupId != crfResearcher.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

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

				List<CRFResearcher> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CRFResearcher crfResearcher = list.get(0);

					result = crfResearcher;

					cacheResult(crfResearcher);
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
			return (CRFResearcher)result;
		}
	}

	/**
	 * Removes the crf researcher where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf researcher that was removed
	 */
	@Override
	public CRFResearcher removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = findByUUID_G(uuid, groupId);

		return remove(crfResearcher);
	}

	/**
	 * Returns the number of crf researchers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf researchers
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFRESEARCHER_WHERE);

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
		"crfResearcher.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(crfResearcher.uuid IS NULL OR crfResearcher.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"crfResearcher.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
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

		List<CRFResearcher> list = null;

		if (useFinderCache) {
			list = (List<CRFResearcher>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFResearcher crfResearcher : list) {
					if (!uuid.equals(crfResearcher.getUuid()) ||
						(companyId != crfResearcher.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

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
				sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFResearcher>)QueryUtil.list(
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
	 * Returns the first crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the first crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		List<CRFResearcher> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the last crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CRFResearcher> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher[] findByUuid_C_PrevAndNext(
			long crfResearcherId, String uuid, long companyId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		uuid = Objects.toString(uuid, "");

		CRFResearcher crfResearcher = findByPrimaryKey(crfResearcherId);

		Session session = null;

		try {
			session = openSession();

			CRFResearcher[] array = new CRFResearcherImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, crfResearcher, uuid, companyId, orderByComparator,
				true);

			array[1] = crfResearcher;

			array[2] = getByUuid_C_PrevAndNext(
				session, crfResearcher, uuid, companyId, orderByComparator,
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

	protected CRFResearcher getByUuid_C_PrevAndNext(
		Session session, CRFResearcher crfResearcher, String uuid,
		long companyId, OrderByComparator<CRFResearcher> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

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
			sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						crfResearcher)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFResearcher> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf researchers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CRFResearcher crfResearcher :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfResearcher);
		}
	}

	/**
	 * Returns the number of crf researchers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf researchers
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFRESEARCHER_WHERE);

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
		"crfResearcher.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(crfResearcher.uuid IS NULL OR crfResearcher.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"crfResearcher.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the crf researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
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

		List<CRFResearcher> list = null;

		if (useFinderCache) {
			list = (List<CRFResearcher>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFResearcher crfResearcher : list) {
					if (groupId != crfResearcher.getGroupId()) {
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

			sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<CRFResearcher>)QueryUtil.list(
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
	 * Returns the first crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByGroupId_First(
			long groupId, OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByGroupId_First(
			groupId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByGroupId_First(
		long groupId, OrderByComparator<CRFResearcher> orderByComparator) {

		List<CRFResearcher> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByGroupId_Last(
			long groupId, OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFResearcher> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CRFResearcher> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where groupId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher[] findByGroupId_PrevAndNext(
			long crfResearcherId, long groupId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = findByPrimaryKey(crfResearcherId);

		Session session = null;

		try {
			session = openSession();

			CRFResearcher[] array = new CRFResearcherImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, crfResearcher, groupId, orderByComparator, true);

			array[1] = crfResearcher;

			array[2] = getByGroupId_PrevAndNext(
				session, crfResearcher, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFResearcher getByGroupId_PrevAndNext(
		Session session, CRFResearcher crfResearcher, long groupId,
		OrderByComparator<CRFResearcher> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

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
			sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						crfResearcher)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFResearcher> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf researchers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (CRFResearcher crfResearcher :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfResearcher);
		}
	}

	/**
	 * Returns the number of crf researchers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf researchers
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFRESEARCHER_WHERE);

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
		"crfResearcher.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCRFId;
	private FinderPath _finderPathWithoutPaginationFindByCRFId;
	private FinderPath _finderPathCountByCRFId;

	/**
	 * Returns all the crf researchers where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByCRFId(long crfId) {
		return findByCRFId(crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf researchers where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByCRFId(long crfId, int start, int end) {
		return findByCRFId(crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf researchers where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByCRFId(
		long crfId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return findByCRFId(crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf researchers where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByCRFId(
		long crfId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCRFId;
				finderArgs = new Object[] {crfId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCRFId;
			finderArgs = new Object[] {crfId, start, end, orderByComparator};
		}

		List<CRFResearcher> list = null;

		if (useFinderCache) {
			list = (List<CRFResearcher>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFResearcher crfResearcher : list) {
					if (crfId != crfResearcher.getCrfId()) {
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

			sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_CRFID_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				list = (List<CRFResearcher>)QueryUtil.list(
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
	 * Returns the first crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByCRFId_First(
			long crfId, OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByCRFId_First(
			crfId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the first crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByCRFId_First(
		long crfId, OrderByComparator<CRFResearcher> orderByComparator) {

		List<CRFResearcher> list = findByCRFId(crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByCRFId_Last(
			long crfId, OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByCRFId_Last(
			crfId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the last crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByCRFId_Last(
		long crfId, OrderByComparator<CRFResearcher> orderByComparator) {

		int count = countByCRFId(crfId);

		if (count == 0) {
			return null;
		}

		List<CRFResearcher> list = findByCRFId(
			crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where crfId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher[] findByCRFId_PrevAndNext(
			long crfResearcherId, long crfId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = findByPrimaryKey(crfResearcherId);

		Session session = null;

		try {
			session = openSession();

			CRFResearcher[] array = new CRFResearcherImpl[3];

			array[0] = getByCRFId_PrevAndNext(
				session, crfResearcher, crfId, orderByComparator, true);

			array[1] = crfResearcher;

			array[2] = getByCRFId_PrevAndNext(
				session, crfResearcher, crfId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFResearcher getByCRFId_PrevAndNext(
		Session session, CRFResearcher crfResearcher, long crfId,
		OrderByComparator<CRFResearcher> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

		sb.append(_FINDER_COLUMN_CRFID_CRFID_2);

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
			sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(crfId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						crfResearcher)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFResearcher> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf researchers where crfId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByCRFId(long crfId) {
		for (CRFResearcher crfResearcher :
				findByCRFId(
					crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfResearcher);
		}
	}

	/**
	 * Returns the number of crf researchers where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the number of matching crf researchers
	 */
	@Override
	public int countByCRFId(long crfId) {
		FinderPath finderPath = _finderPathCountByCRFId;

		Object[] finderArgs = new Object[] {crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_CRFID_CRFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_CRFID_CRFID_2 =
		"crfResearcher.crfId = ?";

	private FinderPath _finderPathWithPaginationFindByResearcherId;
	private FinderPath _finderPathWithoutPaginationFindByResearcherId;
	private FinderPath _finderPathCountByResearcherId;

	/**
	 * Returns all the crf researchers where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @return the matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByResearcherId(long researcherId) {
		return findByResearcherId(
			researcherId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf researchers where researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByResearcherId(
		long researcherId, int start, int end) {

		return findByResearcherId(researcherId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf researchers where researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByResearcherId(
		long researcherId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return findByResearcherId(
			researcherId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf researchers where researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByResearcherId(
		long researcherId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByResearcherId;
				finderArgs = new Object[] {researcherId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByResearcherId;
			finderArgs = new Object[] {
				researcherId, start, end, orderByComparator
			};
		}

		List<CRFResearcher> list = null;

		if (useFinderCache) {
			list = (List<CRFResearcher>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFResearcher crfResearcher : list) {
					if (researcherId != crfResearcher.getResearcherId()) {
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

			sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_RESEARCHERID_RESEARCHERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(researcherId);

				list = (List<CRFResearcher>)QueryUtil.list(
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
	 * Returns the first crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByResearcherId_First(
			long researcherId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByResearcherId_First(
			researcherId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("researcherId=");
		sb.append(researcherId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the first crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByResearcherId_First(
		long researcherId, OrderByComparator<CRFResearcher> orderByComparator) {

		List<CRFResearcher> list = findByResearcherId(
			researcherId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByResearcherId_Last(
			long researcherId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByResearcherId_Last(
			researcherId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("researcherId=");
		sb.append(researcherId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the last crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByResearcherId_Last(
		long researcherId, OrderByComparator<CRFResearcher> orderByComparator) {

		int count = countByResearcherId(researcherId);

		if (count == 0) {
			return null;
		}

		List<CRFResearcher> list = findByResearcherId(
			researcherId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where researcherId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher[] findByResearcherId_PrevAndNext(
			long crfResearcherId, long researcherId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = findByPrimaryKey(crfResearcherId);

		Session session = null;

		try {
			session = openSession();

			CRFResearcher[] array = new CRFResearcherImpl[3];

			array[0] = getByResearcherId_PrevAndNext(
				session, crfResearcher, researcherId, orderByComparator, true);

			array[1] = crfResearcher;

			array[2] = getByResearcherId_PrevAndNext(
				session, crfResearcher, researcherId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFResearcher getByResearcherId_PrevAndNext(
		Session session, CRFResearcher crfResearcher, long researcherId,
		OrderByComparator<CRFResearcher> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

		sb.append(_FINDER_COLUMN_RESEARCHERID_RESEARCHERID_2);

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
			sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(researcherId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						crfResearcher)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFResearcher> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf researchers where researcherId = &#63; from the database.
	 *
	 * @param researcherId the researcher ID
	 */
	@Override
	public void removeByResearcherId(long researcherId) {
		for (CRFResearcher crfResearcher :
				findByResearcherId(
					researcherId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfResearcher);
		}
	}

	/**
	 * Returns the number of crf researchers where researcherId = &#63;.
	 *
	 * @param researcherId the researcher ID
	 * @return the number of matching crf researchers
	 */
	@Override
	public int countByResearcherId(long researcherId) {
		FinderPath finderPath = _finderPathCountByResearcherId;

		Object[] finderArgs = new Object[] {researcherId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_RESEARCHERID_RESEARCHERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(researcherId);

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

	private static final String _FINDER_COLUMN_RESEARCHERID_RESEARCHERID_2 =
		"crfResearcher.researcherId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C;
	private FinderPath _finderPathWithoutPaginationFindByG_C;
	private FinderPath _finderPathCountByG_C;

	/**
	 * Returns all the crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByG_C(long groupId, long crfId) {
		return findByG_C(
			groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByG_C(
		long groupId, long crfId, int start, int end) {

		return findByG_C(groupId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return findByG_C(groupId, crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
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

		List<CRFResearcher> list = null;

		if (useFinderCache) {
			list = (List<CRFResearcher>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFResearcher crfResearcher : list) {
					if ((groupId != crfResearcher.getGroupId()) ||
						(crfId != crfResearcher.getCrfId())) {

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

			sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				list = (List<CRFResearcher>)QueryUtil.list(
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
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByG_C_First(
			groupId, crfId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		List<CRFResearcher> list = findByG_C(
			groupId, crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByG_C_Last(
			groupId, crfId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		int count = countByG_C(groupId, crfId);

		if (count == 0) {
			return null;
		}

		List<CRFResearcher> list = findByG_C(
			groupId, crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher[] findByG_C_PrevAndNext(
			long crfResearcherId, long groupId, long crfId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = findByPrimaryKey(crfResearcherId);

		Session session = null;

		try {
			session = openSession();

			CRFResearcher[] array = new CRFResearcherImpl[3];

			array[0] = getByG_C_PrevAndNext(
				session, crfResearcher, groupId, crfId, orderByComparator,
				true);

			array[1] = crfResearcher;

			array[2] = getByG_C_PrevAndNext(
				session, crfResearcher, groupId, crfId, orderByComparator,
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

	protected CRFResearcher getByG_C_PrevAndNext(
		Session session, CRFResearcher crfResearcher, long groupId, long crfId,
		OrderByComparator<CRFResearcher> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

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
			sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						crfResearcher)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFResearcher> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf researchers where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByG_C(long groupId, long crfId) {
		for (CRFResearcher crfResearcher :
				findByG_C(
					groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfResearcher);
		}
	}

	/**
	 * Returns the number of crf researchers where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf researchers
	 */
	@Override
	public int countByG_C(long groupId, long crfId) {
		FinderPath finderPath = _finderPathCountByG_C;

		Object[] finderArgs = new Object[] {groupId, crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFRESEARCHER_WHERE);

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
		"crfResearcher.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_CRFID_2 =
		"crfResearcher.crfId = ?";

	private FinderPath _finderPathWithPaginationFindByG_R;
	private FinderPath _finderPathWithoutPaginationFindByG_R;
	private FinderPath _finderPathCountByG_R;

	/**
	 * Returns all the crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @return the matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByG_R(long groupId, long researcherId) {
		return findByG_R(
			groupId, researcherId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByG_R(
		long groupId, long researcherId, int start, int end) {

		return findByG_R(groupId, researcherId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByG_R(
		long groupId, long researcherId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return findByG_R(
			groupId, researcherId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf researchers
	 */
	@Override
	public List<CRFResearcher> findByG_R(
		long groupId, long researcherId, int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_R;
				finderArgs = new Object[] {groupId, researcherId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_R;
			finderArgs = new Object[] {
				groupId, researcherId, start, end, orderByComparator
			};
		}

		List<CRFResearcher> list = null;

		if (useFinderCache) {
			list = (List<CRFResearcher>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFResearcher crfResearcher : list) {
					if ((groupId != crfResearcher.getGroupId()) ||
						(researcherId != crfResearcher.getResearcherId())) {

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

			sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_G_R_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_R_RESEARCHERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(researcherId);

				list = (List<CRFResearcher>)QueryUtil.list(
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
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByG_R_First(
			long groupId, long researcherId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByG_R_First(
			groupId, researcherId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", researcherId=");
		sb.append(researcherId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the first crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByG_R_First(
		long groupId, long researcherId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		List<CRFResearcher> list = findByG_R(
			groupId, researcherId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByG_R_Last(
			long groupId, long researcherId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByG_R_Last(
			groupId, researcherId, orderByComparator);

		if (crfResearcher != null) {
			return crfResearcher;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", researcherId=");
		sb.append(researcherId);

		sb.append("}");

		throw new NoSuchCRFResearcherException(sb.toString());
	}

	/**
	 * Returns the last crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByG_R_Last(
		long groupId, long researcherId,
		OrderByComparator<CRFResearcher> orderByComparator) {

		int count = countByG_R(groupId, researcherId);

		if (count == 0) {
			return null;
		}

		List<CRFResearcher> list = findByG_R(
			groupId, researcherId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf researchers before and after the current crf researcher in the ordered set where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param crfResearcherId the primary key of the current crf researcher
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher[] findByG_R_PrevAndNext(
			long crfResearcherId, long groupId, long researcherId,
			OrderByComparator<CRFResearcher> orderByComparator)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = findByPrimaryKey(crfResearcherId);

		Session session = null;

		try {
			session = openSession();

			CRFResearcher[] array = new CRFResearcherImpl[3];

			array[0] = getByG_R_PrevAndNext(
				session, crfResearcher, groupId, researcherId,
				orderByComparator, true);

			array[1] = crfResearcher;

			array[2] = getByG_R_PrevAndNext(
				session, crfResearcher, groupId, researcherId,
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

	protected CRFResearcher getByG_R_PrevAndNext(
		Session session, CRFResearcher crfResearcher, long groupId,
		long researcherId, OrderByComparator<CRFResearcher> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

		sb.append(_FINDER_COLUMN_G_R_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_R_RESEARCHERID_2);

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
			sb.append(CRFResearcherModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(researcherId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						crfResearcher)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFResearcher> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf researchers where groupId = &#63; and researcherId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 */
	@Override
	public void removeByG_R(long groupId, long researcherId) {
		for (CRFResearcher crfResearcher :
				findByG_R(
					groupId, researcherId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfResearcher);
		}
	}

	/**
	 * Returns the number of crf researchers where groupId = &#63; and researcherId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param researcherId the researcher ID
	 * @return the number of matching crf researchers
	 */
	@Override
	public int countByG_R(long groupId, long researcherId) {
		FinderPath finderPath = _finderPathCountByG_R;

		Object[] finderArgs = new Object[] {groupId, researcherId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_G_R_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_R_RESEARCHERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(researcherId);

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

	private static final String _FINDER_COLUMN_G_R_GROUPID_2 =
		"crfResearcher.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_R_RESEARCHERID_2 =
		"crfResearcher.researcherId = ?";

	private FinderPath _finderPathFetchByC_R;
	private FinderPath _finderPathCountByC_R;

	/**
	 * Returns the crf researcher where crfId = &#63; and researcherId = &#63; or throws a <code>NoSuchCRFResearcherException</code> if it could not be found.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @return the matching crf researcher
	 * @throws NoSuchCRFResearcherException if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher findByC_R(long crfId, long researcherId)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByC_R(crfId, researcherId);

		if (crfResearcher == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("crfId=");
			sb.append(crfId);

			sb.append(", researcherId=");
			sb.append(researcherId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCRFResearcherException(sb.toString());
		}

		return crfResearcher;
	}

	/**
	 * Returns the crf researcher where crfId = &#63; and researcherId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByC_R(long crfId, long researcherId) {
		return fetchByC_R(crfId, researcherId, true);
	}

	/**
	 * Returns the crf researcher where crfId = &#63; and researcherId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf researcher, or <code>null</code> if a matching crf researcher could not be found
	 */
	@Override
	public CRFResearcher fetchByC_R(
		long crfId, long researcherId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {crfId, researcherId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_R, finderArgs, this);
		}

		if (result instanceof CRFResearcher) {
			CRFResearcher crfResearcher = (CRFResearcher)result;

			if ((crfId != crfResearcher.getCrfId()) ||
				(researcherId != crfResearcher.getResearcherId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_C_R_CRFID_2);

			sb.append(_FINDER_COLUMN_C_R_RESEARCHERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				queryPos.add(researcherId);

				List<CRFResearcher> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_R, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {crfId, researcherId};
							}

							_log.warn(
								"CRFResearcherPersistenceImpl.fetchByC_R(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CRFResearcher crfResearcher = list.get(0);

					result = crfResearcher;

					cacheResult(crfResearcher);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByC_R, finderArgs);
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
			return (CRFResearcher)result;
		}
	}

	/**
	 * Removes the crf researcher where crfId = &#63; and researcherId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @return the crf researcher that was removed
	 */
	@Override
	public CRFResearcher removeByC_R(long crfId, long researcherId)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = findByC_R(crfId, researcherId);

		return remove(crfResearcher);
	}

	/**
	 * Returns the number of crf researchers where crfId = &#63; and researcherId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param researcherId the researcher ID
	 * @return the number of matching crf researchers
	 */
	@Override
	public int countByC_R(long crfId, long researcherId) {
		FinderPath finderPath = _finderPathCountByC_R;

		Object[] finderArgs = new Object[] {crfId, researcherId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFRESEARCHER_WHERE);

			sb.append(_FINDER_COLUMN_C_R_CRFID_2);

			sb.append(_FINDER_COLUMN_C_R_RESEARCHERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				queryPos.add(researcherId);

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

	private static final String _FINDER_COLUMN_C_R_CRFID_2 =
		"crfResearcher.crfId = ? AND ";

	private static final String _FINDER_COLUMN_C_R_RESEARCHERID_2 =
		"crfResearcher.researcherId = ?";

	public CRFResearcherPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CRFResearcher.class);

		setModelImplClass(CRFResearcherImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the crf researcher in the entity cache if it is enabled.
	 *
	 * @param crfResearcher the crf researcher
	 */
	@Override
	public void cacheResult(CRFResearcher crfResearcher) {
		entityCache.putResult(
			entityCacheEnabled, CRFResearcherImpl.class,
			crfResearcher.getPrimaryKey(), crfResearcher);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {crfResearcher.getUuid(), crfResearcher.getGroupId()},
			crfResearcher);

		finderCache.putResult(
			_finderPathFetchByC_R,
			new Object[] {
				crfResearcher.getCrfId(), crfResearcher.getResearcherId()
			},
			crfResearcher);

		crfResearcher.resetOriginalValues();
	}

	/**
	 * Caches the crf researchers in the entity cache if it is enabled.
	 *
	 * @param crfResearchers the crf researchers
	 */
	@Override
	public void cacheResult(List<CRFResearcher> crfResearchers) {
		for (CRFResearcher crfResearcher : crfResearchers) {
			if (entityCache.getResult(
					entityCacheEnabled, CRFResearcherImpl.class,
					crfResearcher.getPrimaryKey()) == null) {

				cacheResult(crfResearcher);
			}
			else {
				crfResearcher.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all crf researchers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CRFResearcherImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the crf researcher.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CRFResearcher crfResearcher) {
		entityCache.removeResult(
			entityCacheEnabled, CRFResearcherImpl.class,
			crfResearcher.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CRFResearcherModelImpl)crfResearcher, true);
	}

	@Override
	public void clearCache(List<CRFResearcher> crfResearchers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CRFResearcher crfResearcher : crfResearchers) {
			entityCache.removeResult(
				entityCacheEnabled, CRFResearcherImpl.class,
				crfResearcher.getPrimaryKey());

			clearUniqueFindersCache(
				(CRFResearcherModelImpl)crfResearcher, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CRFResearcherImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CRFResearcherModelImpl crfResearcherModelImpl) {

		Object[] args = new Object[] {
			crfResearcherModelImpl.getUuid(),
			crfResearcherModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, crfResearcherModelImpl, false);

		args = new Object[] {
			crfResearcherModelImpl.getCrfId(),
			crfResearcherModelImpl.getResearcherId()
		};

		finderCache.putResult(
			_finderPathCountByC_R, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_R, args, crfResearcherModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CRFResearcherModelImpl crfResearcherModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfResearcherModelImpl.getUuid(),
				crfResearcherModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((crfResearcherModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfResearcherModelImpl.getOriginalUuid(),
				crfResearcherModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfResearcherModelImpl.getCrfId(),
				crfResearcherModelImpl.getResearcherId()
			};

			finderCache.removeResult(_finderPathCountByC_R, args);
			finderCache.removeResult(_finderPathFetchByC_R, args);
		}

		if ((crfResearcherModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_R.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfResearcherModelImpl.getOriginalCrfId(),
				crfResearcherModelImpl.getOriginalResearcherId()
			};

			finderCache.removeResult(_finderPathCountByC_R, args);
			finderCache.removeResult(_finderPathFetchByC_R, args);
		}
	}

	/**
	 * Creates a new crf researcher with the primary key. Does not add the crf researcher to the database.
	 *
	 * @param crfResearcherId the primary key for the new crf researcher
	 * @return the new crf researcher
	 */
	@Override
	public CRFResearcher create(long crfResearcherId) {
		CRFResearcher crfResearcher = new CRFResearcherImpl();

		crfResearcher.setNew(true);
		crfResearcher.setPrimaryKey(crfResearcherId);

		String uuid = PortalUUIDUtil.generate();

		crfResearcher.setUuid(uuid);

		crfResearcher.setCompanyId(CompanyThreadLocal.getCompanyId());

		return crfResearcher;
	}

	/**
	 * Removes the crf researcher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher that was removed
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher remove(long crfResearcherId)
		throws NoSuchCRFResearcherException {

		return remove((Serializable)crfResearcherId);
	}

	/**
	 * Removes the crf researcher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the crf researcher
	 * @return the crf researcher that was removed
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher remove(Serializable primaryKey)
		throws NoSuchCRFResearcherException {

		Session session = null;

		try {
			session = openSession();

			CRFResearcher crfResearcher = (CRFResearcher)session.get(
				CRFResearcherImpl.class, primaryKey);

			if (crfResearcher == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCRFResearcherException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(crfResearcher);
		}
		catch (NoSuchCRFResearcherException noSuchEntityException) {
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
	protected CRFResearcher removeImpl(CRFResearcher crfResearcher) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(crfResearcher)) {
				crfResearcher = (CRFResearcher)session.get(
					CRFResearcherImpl.class, crfResearcher.getPrimaryKeyObj());
			}

			if (crfResearcher != null) {
				session.delete(crfResearcher);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (crfResearcher != null) {
			clearCache(crfResearcher);
		}

		return crfResearcher;
	}

	@Override
	public CRFResearcher updateImpl(CRFResearcher crfResearcher) {
		boolean isNew = crfResearcher.isNew();

		if (!(crfResearcher instanceof CRFResearcherModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(crfResearcher.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					crfResearcher);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in crfResearcher proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CRFResearcher implementation " +
					crfResearcher.getClass());
		}

		CRFResearcherModelImpl crfResearcherModelImpl =
			(CRFResearcherModelImpl)crfResearcher;

		if (Validator.isNull(crfResearcher.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			crfResearcher.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (crfResearcher.getCreateDate() == null)) {
			if (serviceContext == null) {
				crfResearcher.setCreateDate(now);
			}
			else {
				crfResearcher.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!crfResearcherModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				crfResearcher.setModifiedDate(now);
			}
			else {
				crfResearcher.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (crfResearcher.isNew()) {
				session.save(crfResearcher);

				crfResearcher.setNew(false);
			}
			else {
				crfResearcher = (CRFResearcher)session.merge(crfResearcher);
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
			Object[] args = new Object[] {crfResearcherModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				crfResearcherModelImpl.getUuid(),
				crfResearcherModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {crfResearcherModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {crfResearcherModelImpl.getCrfId()};

			finderCache.removeResult(_finderPathCountByCRFId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCRFId, args);

			args = new Object[] {crfResearcherModelImpl.getResearcherId()};

			finderCache.removeResult(_finderPathCountByResearcherId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByResearcherId, args);

			args = new Object[] {
				crfResearcherModelImpl.getGroupId(),
				crfResearcherModelImpl.getCrfId()
			};

			finderCache.removeResult(_finderPathCountByG_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C, args);

			args = new Object[] {
				crfResearcherModelImpl.getGroupId(),
				crfResearcherModelImpl.getResearcherId()
			};

			finderCache.removeResult(_finderPathCountByG_R, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_R, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((crfResearcherModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfResearcherModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {crfResearcherModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((crfResearcherModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfResearcherModelImpl.getOriginalUuid(),
					crfResearcherModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					crfResearcherModelImpl.getUuid(),
					crfResearcherModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((crfResearcherModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfResearcherModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {crfResearcherModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((crfResearcherModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCRFId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfResearcherModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByCRFId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCRFId, args);

				args = new Object[] {crfResearcherModelImpl.getCrfId()};

				finderCache.removeResult(_finderPathCountByCRFId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCRFId, args);
			}

			if ((crfResearcherModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByResearcherId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfResearcherModelImpl.getOriginalResearcherId()
				};

				finderCache.removeResult(_finderPathCountByResearcherId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByResearcherId, args);

				args = new Object[] {crfResearcherModelImpl.getResearcherId()};

				finderCache.removeResult(_finderPathCountByResearcherId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByResearcherId, args);
			}

			if ((crfResearcherModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfResearcherModelImpl.getOriginalGroupId(),
					crfResearcherModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);

				args = new Object[] {
					crfResearcherModelImpl.getGroupId(),
					crfResearcherModelImpl.getCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);
			}

			if ((crfResearcherModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_R.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfResearcherModelImpl.getOriginalGroupId(),
					crfResearcherModelImpl.getOriginalResearcherId()
				};

				finderCache.removeResult(_finderPathCountByG_R, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_R, args);

				args = new Object[] {
					crfResearcherModelImpl.getGroupId(),
					crfResearcherModelImpl.getResearcherId()
				};

				finderCache.removeResult(_finderPathCountByG_R, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_R, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CRFResearcherImpl.class,
			crfResearcher.getPrimaryKey(), crfResearcher, false);

		clearUniqueFindersCache(crfResearcherModelImpl, false);
		cacheUniqueFindersCache(crfResearcherModelImpl);

		crfResearcher.resetOriginalValues();

		return crfResearcher;
	}

	/**
	 * Returns the crf researcher with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the crf researcher
	 * @return the crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCRFResearcherException {

		CRFResearcher crfResearcher = fetchByPrimaryKey(primaryKey);

		if (crfResearcher == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCRFResearcherException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return crfResearcher;
	}

	/**
	 * Returns the crf researcher with the primary key or throws a <code>NoSuchCRFResearcherException</code> if it could not be found.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher
	 * @throws NoSuchCRFResearcherException if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher findByPrimaryKey(long crfResearcherId)
		throws NoSuchCRFResearcherException {

		return findByPrimaryKey((Serializable)crfResearcherId);
	}

	/**
	 * Returns the crf researcher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfResearcherId the primary key of the crf researcher
	 * @return the crf researcher, or <code>null</code> if a crf researcher with the primary key could not be found
	 */
	@Override
	public CRFResearcher fetchByPrimaryKey(long crfResearcherId) {
		return fetchByPrimaryKey((Serializable)crfResearcherId);
	}

	/**
	 * Returns all the crf researchers.
	 *
	 * @return the crf researchers
	 */
	@Override
	public List<CRFResearcher> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @return the range of crf researchers
	 */
	@Override
	public List<CRFResearcher> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf researchers
	 */
	@Override
	public List<CRFResearcher> findAll(
		int start, int end,
		OrderByComparator<CRFResearcher> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf researchers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFResearcherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf researchers
	 * @param end the upper bound of the range of crf researchers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf researchers
	 */
	@Override
	public List<CRFResearcher> findAll(
		int start, int end, OrderByComparator<CRFResearcher> orderByComparator,
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

		List<CRFResearcher> list = null;

		if (useFinderCache) {
			list = (List<CRFResearcher>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CRFRESEARCHER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CRFRESEARCHER;

				sql = sql.concat(CRFResearcherModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CRFResearcher>)QueryUtil.list(
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
	 * Removes all the crf researchers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CRFResearcher crfResearcher : findAll()) {
			remove(crfResearcher);
		}
	}

	/**
	 * Returns the number of crf researchers.
	 *
	 * @return the number of crf researchers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CRFRESEARCHER);

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
		return "crfResearcherId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CRFRESEARCHER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CRFResearcherModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the crf researcher persistence.
	 */
	@Activate
	public void activate() {
		CRFResearcherModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CRFResearcherModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CRFResearcherModelImpl.UUID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CRFID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFResearcherModelImpl.UUID_COLUMN_BITMASK |
			CRFResearcherModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFResearcherModelImpl.UUID_COLUMN_BITMASK |
			CRFResearcherModelImpl.COMPANYID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CRFID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			CRFResearcherModelImpl.GROUPID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CRFID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCRFId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCRFId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCRFId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCRFId",
			new String[] {Long.class.getName()},
			CRFResearcherModelImpl.CRFID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByCRFId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCRFId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByResearcherId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResearcherId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByResearcherId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResearcherId",
			new String[] {Long.class.getName()},
			CRFResearcherModelImpl.RESEARCHERID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CRFID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByResearcherId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByResearcherId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFResearcherModelImpl.GROUPID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CRFID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_R",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFResearcherModelImpl.GROUPID_COLUMN_BITMASK |
			CRFResearcherModelImpl.RESEARCHERID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CRFID_COLUMN_BITMASK |
			CRFResearcherModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_R",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByC_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFResearcherImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_R",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFResearcherModelImpl.CRFID_COLUMN_BITMASK |
			CRFResearcherModelImpl.RESEARCHERID_COLUMN_BITMASK);

		_finderPathCountByC_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CRFResearcherImpl.class.getName());
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
				"value.object.column.bitmask.enabled.ecrf.user.model.CRFResearcher"),
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

	private static final String _SQL_SELECT_CRFRESEARCHER =
		"SELECT crfResearcher FROM CRFResearcher crfResearcher";

	private static final String _SQL_SELECT_CRFRESEARCHER_WHERE =
		"SELECT crfResearcher FROM CRFResearcher crfResearcher WHERE ";

	private static final String _SQL_COUNT_CRFRESEARCHER =
		"SELECT COUNT(crfResearcher) FROM CRFResearcher crfResearcher";

	private static final String _SQL_COUNT_CRFRESEARCHER_WHERE =
		"SELECT COUNT(crfResearcher) FROM CRFResearcher crfResearcher WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "crfResearcher.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CRFResearcher exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CRFResearcher exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CRFResearcherPersistenceImpl.class);

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