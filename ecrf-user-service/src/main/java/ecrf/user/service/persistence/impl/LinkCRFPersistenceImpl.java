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

import ecrf.user.exception.NoSuchLinkCRFException;
import ecrf.user.model.LinkCRF;
import ecrf.user.model.impl.LinkCRFImpl;
import ecrf.user.model.impl.LinkCRFModelImpl;
import ecrf.user.service.persistence.LinkCRFPersistence;
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
 * The persistence implementation for the link crf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @generated
 */
@Component(service = LinkCRFPersistence.class)
public class LinkCRFPersistenceImpl
	extends BasePersistenceImpl<LinkCRF> implements LinkCRFPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LinkCRFUtil</code> to access the link crf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LinkCRFImpl.class.getName();

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
	 * Returns all the link crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching link crfs
	 */
	@Override
	public List<LinkCRF> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

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

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LinkCRF linkCRF : list) {
					if (!uuid.equals(linkCRF.getUuid())) {
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

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
				sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
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

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Returns the first link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByUuid_First(
			String uuid, OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByUuid_First(uuid, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByUuid_First(
		String uuid, OrderByComparator<LinkCRF> orderByComparator) {

		List<LinkCRF> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByUuid_Last(
			String uuid, OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByUuid_Last(uuid, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByUuid_Last(
		String uuid, OrderByComparator<LinkCRF> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LinkCRF> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where uuid = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF[] findByUuid_PrevAndNext(
			long linkId, String uuid,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		uuid = Objects.toString(uuid, "");

		LinkCRF linkCRF = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			LinkCRF[] array = new LinkCRFImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, linkCRF, uuid, orderByComparator, true);

			array[1] = linkCRF;

			array[2] = getByUuid_PrevAndNext(
				session, linkCRF, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkCRF getByUuid_PrevAndNext(
		Session session, LinkCRF linkCRF, String uuid,
		OrderByComparator<LinkCRF> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
			sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(linkCRF)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LinkCRF> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link crfs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LinkCRF linkCRF :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "linkCRF.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(linkCRF.uuid IS NULL OR linkCRF.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the link crf where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByUUID_G(String uuid, long groupId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByUUID_G(uuid, groupId);

		if (linkCRF == null) {
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

			throw new NoSuchLinkCRFException(sb.toString());
		}

		return linkCRF;
	}

	/**
	 * Returns the link crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the link crf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByUUID_G(
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

		if (result instanceof LinkCRF) {
			LinkCRF linkCRF = (LinkCRF)result;

			if (!Objects.equals(uuid, linkCRF.getUuid()) ||
				(groupId != linkCRF.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

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

				List<LinkCRF> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LinkCRF linkCRF = list.get(0);

					result = linkCRF;

					cacheResult(linkCRF);
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
			return (LinkCRF)result;
		}
	}

	/**
	 * Removes the link crf where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the link crf that was removed
	 */
	@Override
	public LinkCRF removeByUUID_G(String uuid, long groupId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByUUID_G(uuid, groupId);

		return remove(linkCRF);
	}

	/**
	 * Returns the number of link crfs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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
		"linkCRF.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(linkCRF.uuid IS NULL OR linkCRF.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"linkCRF.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching link crfs
	 */
	@Override
	public List<LinkCRF> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

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

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LinkCRF linkCRF : list) {
					if (!uuid.equals(linkCRF.getUuid()) ||
						(companyId != linkCRF.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
				sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
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

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Returns the first link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the first link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LinkCRF> orderByComparator) {

		List<LinkCRF> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the last link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LinkCRF> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LinkCRF> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF[] findByUuid_C_PrevAndNext(
			long linkId, String uuid, long companyId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		uuid = Objects.toString(uuid, "");

		LinkCRF linkCRF = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			LinkCRF[] array = new LinkCRFImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, linkCRF, uuid, companyId, orderByComparator, true);

			array[1] = linkCRF;

			array[2] = getByUuid_C_PrevAndNext(
				session, linkCRF, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkCRF getByUuid_C_PrevAndNext(
		Session session, LinkCRF linkCRF, String uuid, long companyId,
		OrderByComparator<LinkCRF> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
			sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(linkCRF)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LinkCRF> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link crfs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LinkCRF linkCRF :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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
		"linkCRF.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(linkCRF.uuid IS NULL OR linkCRF.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"linkCRF.companyId = ?";

	private FinderPath _finderPathFetchByLinkId;
	private FinderPath _finderPathCountByLinkId;

	/**
	 * Returns the link crf where linkId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param linkId the link ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByLinkId(long linkId) throws NoSuchLinkCRFException {
		LinkCRF linkCRF = fetchByLinkId(linkId);

		if (linkCRF == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("linkId=");
			sb.append(linkId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLinkCRFException(sb.toString());
		}

		return linkCRF;
	}

	/**
	 * Returns the link crf where linkId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param linkId the link ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByLinkId(long linkId) {
		return fetchByLinkId(linkId, true);
	}

	/**
	 * Returns the link crf where linkId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linkId the link ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByLinkId(long linkId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {linkId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLinkId, finderArgs, this);
		}

		if (result instanceof LinkCRF) {
			LinkCRF linkCRF = (LinkCRF)result;

			if (linkId != linkCRF.getLinkId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_LINKID_LINKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(linkId);

				List<LinkCRF> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLinkId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {linkId};
							}

							_log.warn(
								"LinkCRFPersistenceImpl.fetchByLinkId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LinkCRF linkCRF = list.get(0);

					result = linkCRF;

					cacheResult(linkCRF);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByLinkId, finderArgs);
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
			return (LinkCRF)result;
		}
	}

	/**
	 * Removes the link crf where linkId = &#63; from the database.
	 *
	 * @param linkId the link ID
	 * @return the link crf that was removed
	 */
	@Override
	public LinkCRF removeByLinkId(long linkId) throws NoSuchLinkCRFException {
		LinkCRF linkCRF = findByLinkId(linkId);

		return remove(linkCRF);
	}

	/**
	 * Returns the number of link crfs where linkId = &#63;.
	 *
	 * @param linkId the link ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByLinkId(long linkId) {
		FinderPath finderPath = _finderPathCountByLinkId;

		Object[] finderArgs = new Object[] {linkId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_LINKID_LINKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(linkId);

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

	private static final String _FINDER_COLUMN_LINKID_LINKID_2 =
		"linkCRF.linkId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the link crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching link crfs
	 */
	@Override
	public List<LinkCRF> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

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

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LinkCRF linkCRF : list) {
					if (groupId != linkCRF.getGroupId()) {
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

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Returns the first link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByGroupId_First(
			long groupId, OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByGroupId_First(groupId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByGroupId_First(
		long groupId, OrderByComparator<LinkCRF> orderByComparator) {

		List<LinkCRF> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByGroupId_Last(
			long groupId, OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByGroupId_Last(groupId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByGroupId_Last(
		long groupId, OrderByComparator<LinkCRF> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LinkCRF> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF[] findByGroupId_PrevAndNext(
			long linkId, long groupId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			LinkCRF[] array = new LinkCRFImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, linkCRF, groupId, orderByComparator, true);

			array[1] = linkCRF;

			array[2] = getByGroupId_PrevAndNext(
				session, linkCRF, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkCRF getByGroupId_PrevAndNext(
		Session session, LinkCRF linkCRF, long groupId,
		OrderByComparator<LinkCRF> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
			sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(linkCRF)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LinkCRF> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link crfs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LinkCRF linkCRF :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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
		"linkCRF.groupId = ?";

	private FinderPath _finderPathWithPaginationFindBySubjectId;
	private FinderPath _finderPathWithoutPaginationFindBySubjectId;
	private FinderPath _finderPathCountBySubjectId;

	/**
	 * Returns all the link crfs where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching link crfs
	 */
	@Override
	public List<LinkCRF> findBySubjectId(long subjectId) {
		return findBySubjectId(
			subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link crfs where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findBySubjectId(long subjectId, int start, int end) {
		return findBySubjectId(subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return findBySubjectId(subjectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findBySubjectId(
		long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

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

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LinkCRF linkCRF : list) {
					if (subjectId != linkCRF.getSubjectId()) {
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

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_SUBJECTID_SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subjectId);

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Returns the first link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findBySubjectId_First(
			long subjectId, OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchBySubjectId_First(subjectId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the first link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchBySubjectId_First(
		long subjectId, OrderByComparator<LinkCRF> orderByComparator) {

		List<LinkCRF> list = findBySubjectId(
			subjectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findBySubjectId_Last(
			long subjectId, OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchBySubjectId_Last(subjectId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the last link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchBySubjectId_Last(
		long subjectId, OrderByComparator<LinkCRF> orderByComparator) {

		int count = countBySubjectId(subjectId);

		if (count == 0) {
			return null;
		}

		List<LinkCRF> list = findBySubjectId(
			subjectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF[] findBySubjectId_PrevAndNext(
			long linkId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			LinkCRF[] array = new LinkCRFImpl[3];

			array[0] = getBySubjectId_PrevAndNext(
				session, linkCRF, subjectId, orderByComparator, true);

			array[1] = linkCRF;

			array[2] = getBySubjectId_PrevAndNext(
				session, linkCRF, subjectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkCRF getBySubjectId_PrevAndNext(
		Session session, LinkCRF linkCRF, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
			sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subjectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(linkCRF)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LinkCRF> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link crfs where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	@Override
	public void removeBySubjectId(long subjectId) {
		for (LinkCRF linkCRF :
				findBySubjectId(
					subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countBySubjectId(long subjectId) {
		FinderPath finderPath = _finderPathCountBySubjectId;

		Object[] finderArgs = new Object[] {subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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
		"linkCRF.subjectId = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_S(long groupId, long subjectId) {
		return findByG_S(
			groupId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_S(
		long groupId, long subjectId, int start, int end) {

		return findByG_S(groupId, subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return findByG_S(
			groupId, subjectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, subjectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, subjectId, start, end, orderByComparator
			};
		}

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LinkCRF linkCRF : list) {
					if ((groupId != linkCRF.getGroupId()) ||
						(subjectId != linkCRF.getSubjectId())) {

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

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(subjectId);

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByG_S_First(
			long groupId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByG_S_First(
			groupId, subjectId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_S_First(
		long groupId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator) {

		List<LinkCRF> list = findByG_S(
			groupId, subjectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByG_S_Last(
			long groupId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByG_S_Last(
			groupId, subjectId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_S_Last(
		long groupId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator) {

		int count = countByG_S(groupId, subjectId);

		if (count == 0) {
			return null;
		}

		List<LinkCRF> list = findByG_S(
			groupId, subjectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF[] findByG_S_PrevAndNext(
			long linkId, long groupId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			LinkCRF[] array = new LinkCRFImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, linkCRF, groupId, subjectId, orderByComparator, true);

			array[1] = linkCRF;

			array[2] = getByG_S_PrevAndNext(
				session, linkCRF, groupId, subjectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkCRF getByG_S_PrevAndNext(
		Session session, LinkCRF linkCRF, long groupId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LINKCRF_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_SUBJECTID_2);

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
			sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(subjectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(linkCRF)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LinkCRF> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link crfs where groupId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 */
	@Override
	public void removeByG_S(long groupId, long subjectId) {
		for (LinkCRF linkCRF :
				findByG_S(
					groupId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByG_S(long groupId, long subjectId) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_SUBJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"linkCRF.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_SUBJECTID_2 =
		"linkCRF.subjectId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C;
	private FinderPath _finderPathWithoutPaginationFindByG_C;
	private FinderPath _finderPathCountByG_C;

	/**
	 * Returns all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_C(long groupId, long crfId) {
		return findByG_C(
			groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_C(
		long groupId, long crfId, int start, int end) {

		return findByG_C(groupId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return findByG_C(groupId, crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

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

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LinkCRF linkCRF : list) {
					if ((groupId != linkCRF.getGroupId()) ||
						(crfId != linkCRF.getCrfId())) {

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

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Returns the first link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByG_C_First(groupId, crfId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<LinkCRF> orderByComparator) {

		List<LinkCRF> list = findByG_C(groupId, crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByG_C_Last(groupId, crfId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<LinkCRF> orderByComparator) {

		int count = countByG_C(groupId, crfId);

		if (count == 0) {
			return null;
		}

		List<LinkCRF> list = findByG_C(
			groupId, crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF[] findByG_C_PrevAndNext(
			long linkId, long groupId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			LinkCRF[] array = new LinkCRFImpl[3];

			array[0] = getByG_C_PrevAndNext(
				session, linkCRF, groupId, crfId, orderByComparator, true);

			array[1] = linkCRF;

			array[2] = getByG_C_PrevAndNext(
				session, linkCRF, groupId, crfId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkCRF getByG_C_PrevAndNext(
		Session session, LinkCRF linkCRF, long groupId, long crfId,
		OrderByComparator<LinkCRF> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
			sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(linkCRF)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LinkCRF> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link crfs where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByG_C(long groupId, long crfId) {
		for (LinkCRF linkCRF :
				findByG_C(
					groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByG_C(long groupId, long crfId) {
		FinderPath finderPath = _finderPathCountByG_C;

		Object[] finderArgs = new Object[] {groupId, crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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
		"linkCRF.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_CRFID_2 =
		"linkCRF.crfId = ?";

	private FinderPath _finderPathWithPaginationFindByG_S_C;
	private FinderPath _finderPathWithoutPaginationFindByG_S_C;
	private FinderPath _finderPathCountByG_S_C;

	/**
	 * Returns all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_S_C(long groupId, long subjectId, long crfId) {
		return findByG_S_C(
			groupId, subjectId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end) {

		return findByG_S_C(groupId, subjectId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return findByG_S_C(
			groupId, subjectId, crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByG_S_C(
		long groupId, long subjectId, long crfId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

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

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LinkCRF linkCRF : list) {
					if ((groupId != linkCRF.getGroupId()) ||
						(subjectId != linkCRF.getSubjectId()) ||
						(crfId != linkCRF.getCrfId())) {

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

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_C_SUBJECTID_2);

			sb.append(_FINDER_COLUMN_G_S_C_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
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

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByG_S_C_First(
			long groupId, long subjectId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByG_S_C_First(
			groupId, subjectId, crfId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
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

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the first link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_S_C_First(
		long groupId, long subjectId, long crfId,
		OrderByComparator<LinkCRF> orderByComparator) {

		List<LinkCRF> list = findByG_S_C(
			groupId, subjectId, crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByG_S_C_Last(
			long groupId, long subjectId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByG_S_C_Last(
			groupId, subjectId, crfId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
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

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the last link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_S_C_Last(
		long groupId, long subjectId, long crfId,
		OrderByComparator<LinkCRF> orderByComparator) {

		int count = countByG_S_C(groupId, subjectId, crfId);

		if (count == 0) {
			return null;
		}

		List<LinkCRF> list = findByG_S_C(
			groupId, subjectId, crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF[] findByG_S_C_PrevAndNext(
			long linkId, long groupId, long subjectId, long crfId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			LinkCRF[] array = new LinkCRFImpl[3];

			array[0] = getByG_S_C_PrevAndNext(
				session, linkCRF, groupId, subjectId, crfId, orderByComparator,
				true);

			array[1] = linkCRF;

			array[2] = getByG_S_C_PrevAndNext(
				session, linkCRF, groupId, subjectId, crfId, orderByComparator,
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

	protected LinkCRF getByG_S_C_PrevAndNext(
		Session session, LinkCRF linkCRF, long groupId, long subjectId,
		long crfId, OrderByComparator<LinkCRF> orderByComparator,
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

		sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
			sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(linkCRF)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LinkCRF> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByG_S_C(long groupId, long subjectId, long crfId) {
		for (LinkCRF linkCRF :
				findByG_S_C(
					groupId, subjectId, crfId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByG_S_C(long groupId, long subjectId, long crfId) {
		FinderPath finderPath = _finderPathCountByG_S_C;

		Object[] finderArgs = new Object[] {groupId, subjectId, crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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

	private static final String _FINDER_COLUMN_G_S_C_GROUPID_2 =
		"linkCRF.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_SUBJECTID_2 =
		"linkCRF.subjectId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_CRFID_2 =
		"linkCRF.crfId = ?";

	private FinderPath _finderPathFetchByG_S_SD;
	private FinderPath _finderPathCountByG_S_SD;

	/**
	 * Returns the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByG_S_SD(long groupId, long crfId, long structuredDataId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByG_S_SD(groupId, crfId, structuredDataId);

		if (linkCRF == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", crfId=");
			sb.append(crfId);

			sb.append(", structuredDataId=");
			sb.append(structuredDataId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLinkCRFException(sb.toString());
		}

		return linkCRF;
	}

	/**
	 * Returns the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_S_SD(
		long groupId, long crfId, long structuredDataId) {

		return fetchByG_S_SD(groupId, crfId, structuredDataId, true);
	}

	/**
	 * Returns the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_S_SD(
		long groupId, long crfId, long structuredDataId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, crfId, structuredDataId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_S_SD, finderArgs, this);
		}

		if (result instanceof LinkCRF) {
			LinkCRF linkCRF = (LinkCRF)result;

			if ((groupId != linkCRF.getGroupId()) ||
				(crfId != linkCRF.getCrfId()) ||
				(structuredDataId != linkCRF.getStructuredDataId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_G_S_SD_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_SD_CRFID_2);

			sb.append(_FINDER_COLUMN_G_S_SD_STRUCTUREDDATAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				queryPos.add(structuredDataId);

				List<LinkCRF> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_S_SD, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, crfId, structuredDataId
								};
							}

							_log.warn(
								"LinkCRFPersistenceImpl.fetchByG_S_SD(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LinkCRF linkCRF = list.get(0);

					result = linkCRF;

					cacheResult(linkCRF);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByG_S_SD, finderArgs);
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
			return (LinkCRF)result;
		}
	}

	/**
	 * Removes the link crf where groupId = &#63; and crfId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	@Override
	public LinkCRF removeByG_S_SD(
			long groupId, long crfId, long structuredDataId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByG_S_SD(groupId, crfId, structuredDataId);

		return remove(linkCRF);
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByG_S_SD(long groupId, long crfId, long structuredDataId) {
		FinderPath finderPath = _finderPathCountByG_S_SD;

		Object[] finderArgs = new Object[] {groupId, crfId, structuredDataId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_G_S_SD_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_SD_CRFID_2);

			sb.append(_FINDER_COLUMN_G_S_SD_STRUCTUREDDATAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_S_SD_GROUPID_2 =
		"linkCRF.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_SD_CRFID_2 =
		"linkCRF.crfId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_SD_STRUCTUREDDATAID_2 =
		"linkCRF.structuredDataId = ?";

	private FinderPath _finderPathFetchByG_S_C_SD;
	private FinderPath _finderPathCountByG_S_C_SD;

	/**
	 * Returns the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByG_S_C_SD(
			long groupId, long subjectId, long crfId, long structuredDataId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);

		if (linkCRF == null) {
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

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLinkCRFException(sb.toString());
		}

		return linkCRF;
	}

	/**
	 * Returns the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId) {

		return fetchByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId, true);
	}

	/**
	 * Returns the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByG_S_C_SD(
		long groupId, long subjectId, long crfId, long structuredDataId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, subjectId, crfId, structuredDataId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_S_C_SD, finderArgs, this);
		}

		if (result instanceof LinkCRF) {
			LinkCRF linkCRF = (LinkCRF)result;

			if ((groupId != linkCRF.getGroupId()) ||
				(subjectId != linkCRF.getSubjectId()) ||
				(crfId != linkCRF.getCrfId()) ||
				(structuredDataId != linkCRF.getStructuredDataId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

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

				List<LinkCRF> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_S_C_SD, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, subjectId, crfId, structuredDataId
								};
							}

							_log.warn(
								"LinkCRFPersistenceImpl.fetchByG_S_C_SD(long, long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LinkCRF linkCRF = list.get(0);

					result = linkCRF;

					cacheResult(linkCRF);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByG_S_C_SD, finderArgs);
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
			return (LinkCRF)result;
		}
	}

	/**
	 * Removes the link crf where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	@Override
	public LinkCRF removeByG_S_C_SD(
			long groupId, long subjectId, long crfId, long structuredDataId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByG_S_C_SD(
			groupId, subjectId, crfId, structuredDataId);

		return remove(linkCRF);
	}

	/**
	 * Returns the number of link crfs where groupId = &#63; and subjectId = &#63; and crfId = &#63; and structuredDataId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param crfId the crf ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
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

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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

	private static final String _FINDER_COLUMN_G_S_C_SD_GROUPID_2 =
		"linkCRF.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_SD_SUBJECTID_2 =
		"linkCRF.subjectId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_SD_CRFID_2 =
		"linkCRF.crfId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_C_SD_STRUCTUREDDATAID_2 =
		"linkCRF.structuredDataId = ?";

	private FinderPath _finderPathWithPaginationFindByC_S;
	private FinderPath _finderPathWithoutPaginationFindByC_S;
	private FinderPath _finderPathCountByC_S;

	/**
	 * Returns all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching link crfs
	 */
	@Override
	public List<LinkCRF> findByC_S(long crfId, long subjectId) {
		return findByC_S(
			crfId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByC_S(
		long crfId, long subjectId, int start, int end) {

		return findByC_S(crfId, subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByC_S(
		long crfId, long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return findByC_S(crfId, subjectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByC_S(
		long crfId, long subjectId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

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

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LinkCRF linkCRF : list) {
					if ((crfId != linkCRF.getCrfId()) ||
						(subjectId != linkCRF.getSubjectId())) {

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

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_C_S_CRFID_2);

			sb.append(_FINDER_COLUMN_C_S_SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				queryPos.add(subjectId);

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Returns the first link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByC_S_First(
			long crfId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByC_S_First(crfId, subjectId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the first link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByC_S_First(
		long crfId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator) {

		List<LinkCRF> list = findByC_S(
			crfId, subjectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByC_S_Last(
			long crfId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByC_S_Last(crfId, subjectId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the last link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByC_S_Last(
		long crfId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator) {

		int count = countByC_S(crfId, subjectId);

		if (count == 0) {
			return null;
		}

		List<LinkCRF> list = findByC_S(
			crfId, subjectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF[] findByC_S_PrevAndNext(
			long linkId, long crfId, long subjectId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			LinkCRF[] array = new LinkCRFImpl[3];

			array[0] = getByC_S_PrevAndNext(
				session, linkCRF, crfId, subjectId, orderByComparator, true);

			array[1] = linkCRF;

			array[2] = getByC_S_PrevAndNext(
				session, linkCRF, crfId, subjectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkCRF getByC_S_PrevAndNext(
		Session session, LinkCRF linkCRF, long crfId, long subjectId,
		OrderByComparator<LinkCRF> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
			sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(linkCRF)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LinkCRF> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link crfs where crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 */
	@Override
	public void removeByC_S(long crfId, long subjectId) {
		for (LinkCRF linkCRF :
				findByC_S(
					crfId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByC_S(long crfId, long subjectId) {
		FinderPath finderPath = _finderPathCountByC_S;

		Object[] finderArgs = new Object[] {crfId, subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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
		"linkCRF.crfId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_SUBJECTID_2 =
		"linkCRF.subjectId = ?";

	private FinderPath _finderPathFetchByC_S_SD;
	private FinderPath _finderPathCountByC_S_SD;

	/**
	 * Returns the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByC_S_SD(
			long crfId, long subjectId, long structuredDataId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByC_S_SD(crfId, subjectId, structuredDataId);

		if (linkCRF == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("crfId=");
			sb.append(crfId);

			sb.append(", subjectId=");
			sb.append(subjectId);

			sb.append(", structuredDataId=");
			sb.append(structuredDataId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLinkCRFException(sb.toString());
		}

		return linkCRF;
	}

	/**
	 * Returns the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByC_S_SD(
		long crfId, long subjectId, long structuredDataId) {

		return fetchByC_S_SD(crfId, subjectId, structuredDataId, true);
	}

	/**
	 * Returns the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByC_S_SD(
		long crfId, long subjectId, long structuredDataId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {crfId, subjectId, structuredDataId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_S_SD, finderArgs, this);
		}

		if (result instanceof LinkCRF) {
			LinkCRF linkCRF = (LinkCRF)result;

			if ((crfId != linkCRF.getCrfId()) ||
				(subjectId != linkCRF.getSubjectId()) ||
				(structuredDataId != linkCRF.getStructuredDataId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_C_S_SD_CRFID_2);

			sb.append(_FINDER_COLUMN_C_S_SD_SUBJECTID_2);

			sb.append(_FINDER_COLUMN_C_S_SD_STRUCTUREDDATAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				queryPos.add(subjectId);

				queryPos.add(structuredDataId);

				List<LinkCRF> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_S_SD, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									crfId, subjectId, structuredDataId
								};
							}

							_log.warn(
								"LinkCRFPersistenceImpl.fetchByC_S_SD(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LinkCRF linkCRF = list.get(0);

					result = linkCRF;

					cacheResult(linkCRF);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByC_S_SD, finderArgs);
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
			return (LinkCRF)result;
		}
	}

	/**
	 * Removes the link crf where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	@Override
	public LinkCRF removeByC_S_SD(
			long crfId, long subjectId, long structuredDataId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByC_S_SD(crfId, subjectId, structuredDataId);

		return remove(linkCRF);
	}

	/**
	 * Returns the number of link crfs where crfId = &#63; and subjectId = &#63; and structuredDataId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByC_S_SD(
		long crfId, long subjectId, long structuredDataId) {

		FinderPath finderPath = _finderPathCountByC_S_SD;

		Object[] finderArgs = new Object[] {crfId, subjectId, structuredDataId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_C_S_SD_CRFID_2);

			sb.append(_FINDER_COLUMN_C_S_SD_SUBJECTID_2);

			sb.append(_FINDER_COLUMN_C_S_SD_STRUCTUREDDATAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				queryPos.add(subjectId);

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

	private static final String _FINDER_COLUMN_C_S_SD_CRFID_2 =
		"linkCRF.crfId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_SD_SUBJECTID_2 =
		"linkCRF.subjectId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_SD_STRUCTUREDDATAID_2 =
		"linkCRF.structuredDataId = ?";

	private FinderPath _finderPathWithPaginationFindByStructuredDataId;
	private FinderPath _finderPathWithoutPaginationFindByStructuredDataId;
	private FinderPath _finderPathCountByStructuredDataId;

	/**
	 * Returns all the link crfs where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching link crfs
	 */
	@Override
	public List<LinkCRF> findByStructuredDataId(long structuredDataId) {
		return findByStructuredDataId(
			structuredDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link crfs where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByStructuredDataId(
		long structuredDataId, int start, int end) {

		return findByStructuredDataId(structuredDataId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByStructuredDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator) {

		return findByStructuredDataId(
			structuredDataId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching link crfs
	 */
	@Override
	public List<LinkCRF> findByStructuredDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<LinkCRF> orderByComparator, boolean useFinderCache) {

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

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LinkCRF linkCRF : list) {
					if (structuredDataId != linkCRF.getStructuredDataId()) {
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

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_STRUCTUREDDATAID_STRUCTUREDDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(structuredDataId);

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Returns the first link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByStructuredDataId_First(
			long structuredDataId, OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByStructuredDataId_First(
			structuredDataId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("structuredDataId=");
		sb.append(structuredDataId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the first link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByStructuredDataId_First(
		long structuredDataId, OrderByComparator<LinkCRF> orderByComparator) {

		List<LinkCRF> list = findByStructuredDataId(
			structuredDataId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByStructuredDataId_Last(
			long structuredDataId, OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByStructuredDataId_Last(
			structuredDataId, orderByComparator);

		if (linkCRF != null) {
			return linkCRF;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("structuredDataId=");
		sb.append(structuredDataId);

		sb.append("}");

		throw new NoSuchLinkCRFException(sb.toString());
	}

	/**
	 * Returns the last link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByStructuredDataId_Last(
		long structuredDataId, OrderByComparator<LinkCRF> orderByComparator) {

		int count = countByStructuredDataId(structuredDataId);

		if (count == 0) {
			return null;
		}

		List<LinkCRF> list = findByStructuredDataId(
			structuredDataId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link crfs before and after the current link crf in the ordered set where structuredDataId = &#63;.
	 *
	 * @param linkId the primary key of the current link crf
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF[] findByStructuredDataId_PrevAndNext(
			long linkId, long structuredDataId,
			OrderByComparator<LinkCRF> orderByComparator)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			LinkCRF[] array = new LinkCRFImpl[3];

			array[0] = getByStructuredDataId_PrevAndNext(
				session, linkCRF, structuredDataId, orderByComparator, true);

			array[1] = linkCRF;

			array[2] = getByStructuredDataId_PrevAndNext(
				session, linkCRF, structuredDataId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkCRF getByStructuredDataId_PrevAndNext(
		Session session, LinkCRF linkCRF, long structuredDataId,
		OrderByComparator<LinkCRF> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LINKCRF_WHERE);

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
			sb.append(LinkCRFModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(structuredDataId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(linkCRF)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LinkCRF> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link crfs where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 */
	@Override
	public void removeByStructuredDataId(long structuredDataId) {
		for (LinkCRF linkCRF :
				findByStructuredDataId(
					structuredDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByStructuredDataId(long structuredDataId) {
		FinderPath finderPath = _finderPathCountByStructuredDataId;

		Object[] finderArgs = new Object[] {structuredDataId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

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
			"linkCRF.structuredDataId = ?";

	private FinderPath _finderPathFetchByLinkSId;
	private FinderPath _finderPathCountByLinkSId;

	/**
	 * Returns the link crf where subjectId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param subjectId the subject ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByLinkSId(long subjectId) throws NoSuchLinkCRFException {
		LinkCRF linkCRF = fetchByLinkSId(subjectId);

		if (linkCRF == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("subjectId=");
			sb.append(subjectId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLinkCRFException(sb.toString());
		}

		return linkCRF;
	}

	/**
	 * Returns the link crf where subjectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByLinkSId(long subjectId) {
		return fetchByLinkSId(subjectId, true);
	}

	/**
	 * Returns the link crf where subjectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subjectId the subject ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByLinkSId(long subjectId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {subjectId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLinkSId, finderArgs, this);
		}

		if (result instanceof LinkCRF) {
			LinkCRF linkCRF = (LinkCRF)result;

			if (subjectId != linkCRF.getSubjectId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_LINKSID_SUBJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subjectId);

				List<LinkCRF> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLinkSId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {subjectId};
							}

							_log.warn(
								"LinkCRFPersistenceImpl.fetchByLinkSId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LinkCRF linkCRF = list.get(0);

					result = linkCRF;

					cacheResult(linkCRF);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByLinkSId, finderArgs);
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
			return (LinkCRF)result;
		}
	}

	/**
	 * Removes the link crf where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 * @return the link crf that was removed
	 */
	@Override
	public LinkCRF removeByLinkSId(long subjectId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByLinkSId(subjectId);

		return remove(linkCRF);
	}

	/**
	 * Returns the number of link crfs where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByLinkSId(long subjectId) {
		FinderPath finderPath = _finderPathCountByLinkSId;

		Object[] finderArgs = new Object[] {subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_LINKSID_SUBJECTID_2);

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

	private static final String _FINDER_COLUMN_LINKSID_SUBJECTID_2 =
		"linkCRF.subjectId = ?";

	private FinderPath _finderPathFetchByLinkSdId;
	private FinderPath _finderPathCountByLinkSdId;

	/**
	 * Returns the link crf where structuredDataId = &#63; or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf
	 * @throws NoSuchLinkCRFException if a matching link crf could not be found
	 */
	@Override
	public LinkCRF findByLinkSdId(long structuredDataId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByLinkSdId(structuredDataId);

		if (linkCRF == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("structuredDataId=");
			sb.append(structuredDataId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLinkCRFException(sb.toString());
		}

		return linkCRF;
	}

	/**
	 * Returns the link crf where structuredDataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByLinkSdId(long structuredDataId) {
		return fetchByLinkSdId(structuredDataId, true);
	}

	/**
	 * Returns the link crf where structuredDataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link crf, or <code>null</code> if a matching link crf could not be found
	 */
	@Override
	public LinkCRF fetchByLinkSdId(
		long structuredDataId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {structuredDataId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLinkSdId, finderArgs, this);
		}

		if (result instanceof LinkCRF) {
			LinkCRF linkCRF = (LinkCRF)result;

			if (structuredDataId != linkCRF.getStructuredDataId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_LINKSDID_STRUCTUREDDATAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(structuredDataId);

				List<LinkCRF> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLinkSdId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {structuredDataId};
							}

							_log.warn(
								"LinkCRFPersistenceImpl.fetchByLinkSdId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LinkCRF linkCRF = list.get(0);

					result = linkCRF;

					cacheResult(linkCRF);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByLinkSdId, finderArgs);
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
			return (LinkCRF)result;
		}
	}

	/**
	 * Removes the link crf where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the link crf that was removed
	 */
	@Override
	public LinkCRF removeByLinkSdId(long structuredDataId)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = findByLinkSdId(structuredDataId);

		return remove(linkCRF);
	}

	/**
	 * Returns the number of link crfs where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching link crfs
	 */
	@Override
	public int countByLinkSdId(long structuredDataId) {
		FinderPath finderPath = _finderPathCountByLinkSdId;

		Object[] finderArgs = new Object[] {structuredDataId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LINKCRF_WHERE);

			sb.append(_FINDER_COLUMN_LINKSDID_STRUCTUREDDATAID_2);

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

	private static final String _FINDER_COLUMN_LINKSDID_STRUCTUREDDATAID_2 =
		"linkCRF.structuredDataId = ?";

	public LinkCRFPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LinkCRF.class);

		setModelImplClass(LinkCRFImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the link crf in the entity cache if it is enabled.
	 *
	 * @param linkCRF the link crf
	 */
	@Override
	public void cacheResult(LinkCRF linkCRF) {
		entityCache.putResult(
			entityCacheEnabled, LinkCRFImpl.class, linkCRF.getPrimaryKey(),
			linkCRF);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {linkCRF.getUuid(), linkCRF.getGroupId()}, linkCRF);

		finderCache.putResult(
			_finderPathFetchByLinkId, new Object[] {linkCRF.getLinkId()},
			linkCRF);

		finderCache.putResult(
			_finderPathFetchByG_S_SD,
			new Object[] {
				linkCRF.getGroupId(), linkCRF.getCrfId(),
				linkCRF.getStructuredDataId()
			},
			linkCRF);

		finderCache.putResult(
			_finderPathFetchByG_S_C_SD,
			new Object[] {
				linkCRF.getGroupId(), linkCRF.getSubjectId(),
				linkCRF.getCrfId(), linkCRF.getStructuredDataId()
			},
			linkCRF);

		finderCache.putResult(
			_finderPathFetchByC_S_SD,
			new Object[] {
				linkCRF.getCrfId(), linkCRF.getSubjectId(),
				linkCRF.getStructuredDataId()
			},
			linkCRF);

		finderCache.putResult(
			_finderPathFetchByLinkSId, new Object[] {linkCRF.getSubjectId()},
			linkCRF);

		finderCache.putResult(
			_finderPathFetchByLinkSdId,
			new Object[] {linkCRF.getStructuredDataId()}, linkCRF);

		linkCRF.resetOriginalValues();
	}

	/**
	 * Caches the link crfs in the entity cache if it is enabled.
	 *
	 * @param linkCRFs the link crfs
	 */
	@Override
	public void cacheResult(List<LinkCRF> linkCRFs) {
		for (LinkCRF linkCRF : linkCRFs) {
			if (entityCache.getResult(
					entityCacheEnabled, LinkCRFImpl.class,
					linkCRF.getPrimaryKey()) == null) {

				cacheResult(linkCRF);
			}
			else {
				linkCRF.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all link crfs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LinkCRFImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the link crf.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LinkCRF linkCRF) {
		entityCache.removeResult(
			entityCacheEnabled, LinkCRFImpl.class, linkCRF.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LinkCRFModelImpl)linkCRF, true);
	}

	@Override
	public void clearCache(List<LinkCRF> linkCRFs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LinkCRF linkCRF : linkCRFs) {
			entityCache.removeResult(
				entityCacheEnabled, LinkCRFImpl.class, linkCRF.getPrimaryKey());

			clearUniqueFindersCache((LinkCRFModelImpl)linkCRF, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LinkCRFImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(LinkCRFModelImpl linkCRFModelImpl) {
		Object[] args = new Object[] {
			linkCRFModelImpl.getUuid(), linkCRFModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, linkCRFModelImpl, false);

		args = new Object[] {linkCRFModelImpl.getLinkId()};

		finderCache.putResult(
			_finderPathCountByLinkId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByLinkId, args, linkCRFModelImpl, false);

		args = new Object[] {
			linkCRFModelImpl.getGroupId(), linkCRFModelImpl.getCrfId(),
			linkCRFModelImpl.getStructuredDataId()
		};

		finderCache.putResult(
			_finderPathCountByG_S_SD, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_S_SD, args, linkCRFModelImpl, false);

		args = new Object[] {
			linkCRFModelImpl.getGroupId(), linkCRFModelImpl.getSubjectId(),
			linkCRFModelImpl.getCrfId(), linkCRFModelImpl.getStructuredDataId()
		};

		finderCache.putResult(
			_finderPathCountByG_S_C_SD, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_S_C_SD, args, linkCRFModelImpl, false);

		args = new Object[] {
			linkCRFModelImpl.getCrfId(), linkCRFModelImpl.getSubjectId(),
			linkCRFModelImpl.getStructuredDataId()
		};

		finderCache.putResult(
			_finderPathCountByC_S_SD, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_S_SD, args, linkCRFModelImpl, false);

		args = new Object[] {linkCRFModelImpl.getSubjectId()};

		finderCache.putResult(
			_finderPathCountByLinkSId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByLinkSId, args, linkCRFModelImpl, false);

		args = new Object[] {linkCRFModelImpl.getStructuredDataId()};

		finderCache.putResult(
			_finderPathCountByLinkSdId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByLinkSdId, args, linkCRFModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LinkCRFModelImpl linkCRFModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				linkCRFModelImpl.getUuid(), linkCRFModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((linkCRFModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				linkCRFModelImpl.getOriginalUuid(),
				linkCRFModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {linkCRFModelImpl.getLinkId()};

			finderCache.removeResult(_finderPathCountByLinkId, args);
			finderCache.removeResult(_finderPathFetchByLinkId, args);
		}

		if ((linkCRFModelImpl.getColumnBitmask() &
			 _finderPathFetchByLinkId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {linkCRFModelImpl.getOriginalLinkId()};

			finderCache.removeResult(_finderPathCountByLinkId, args);
			finderCache.removeResult(_finderPathFetchByLinkId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				linkCRFModelImpl.getGroupId(), linkCRFModelImpl.getCrfId(),
				linkCRFModelImpl.getStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByG_S_SD, args);
			finderCache.removeResult(_finderPathFetchByG_S_SD, args);
		}

		if ((linkCRFModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_S_SD.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				linkCRFModelImpl.getOriginalGroupId(),
				linkCRFModelImpl.getOriginalCrfId(),
				linkCRFModelImpl.getOriginalStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByG_S_SD, args);
			finderCache.removeResult(_finderPathFetchByG_S_SD, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				linkCRFModelImpl.getGroupId(), linkCRFModelImpl.getSubjectId(),
				linkCRFModelImpl.getCrfId(),
				linkCRFModelImpl.getStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByG_S_C_SD, args);
			finderCache.removeResult(_finderPathFetchByG_S_C_SD, args);
		}

		if ((linkCRFModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_S_C_SD.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				linkCRFModelImpl.getOriginalGroupId(),
				linkCRFModelImpl.getOriginalSubjectId(),
				linkCRFModelImpl.getOriginalCrfId(),
				linkCRFModelImpl.getOriginalStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByG_S_C_SD, args);
			finderCache.removeResult(_finderPathFetchByG_S_C_SD, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				linkCRFModelImpl.getCrfId(), linkCRFModelImpl.getSubjectId(),
				linkCRFModelImpl.getStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByC_S_SD, args);
			finderCache.removeResult(_finderPathFetchByC_S_SD, args);
		}

		if ((linkCRFModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_S_SD.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				linkCRFModelImpl.getOriginalCrfId(),
				linkCRFModelImpl.getOriginalSubjectId(),
				linkCRFModelImpl.getOriginalStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByC_S_SD, args);
			finderCache.removeResult(_finderPathFetchByC_S_SD, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {linkCRFModelImpl.getSubjectId()};

			finderCache.removeResult(_finderPathCountByLinkSId, args);
			finderCache.removeResult(_finderPathFetchByLinkSId, args);
		}

		if ((linkCRFModelImpl.getColumnBitmask() &
			 _finderPathFetchByLinkSId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				linkCRFModelImpl.getOriginalSubjectId()
			};

			finderCache.removeResult(_finderPathCountByLinkSId, args);
			finderCache.removeResult(_finderPathFetchByLinkSId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				linkCRFModelImpl.getStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByLinkSdId, args);
			finderCache.removeResult(_finderPathFetchByLinkSdId, args);
		}

		if ((linkCRFModelImpl.getColumnBitmask() &
			 _finderPathFetchByLinkSdId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				linkCRFModelImpl.getOriginalStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByLinkSdId, args);
			finderCache.removeResult(_finderPathFetchByLinkSdId, args);
		}
	}

	/**
	 * Creates a new link crf with the primary key. Does not add the link crf to the database.
	 *
	 * @param linkId the primary key for the new link crf
	 * @return the new link crf
	 */
	@Override
	public LinkCRF create(long linkId) {
		LinkCRF linkCRF = new LinkCRFImpl();

		linkCRF.setNew(true);
		linkCRF.setPrimaryKey(linkId);

		String uuid = PortalUUIDUtil.generate();

		linkCRF.setUuid(uuid);

		linkCRF.setCompanyId(CompanyThreadLocal.getCompanyId());

		return linkCRF;
	}

	/**
	 * Removes the link crf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf that was removed
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF remove(long linkId) throws NoSuchLinkCRFException {
		return remove((Serializable)linkId);
	}

	/**
	 * Removes the link crf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the link crf
	 * @return the link crf that was removed
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF remove(Serializable primaryKey)
		throws NoSuchLinkCRFException {

		Session session = null;

		try {
			session = openSession();

			LinkCRF linkCRF = (LinkCRF)session.get(
				LinkCRFImpl.class, primaryKey);

			if (linkCRF == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLinkCRFException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(linkCRF);
		}
		catch (NoSuchLinkCRFException noSuchEntityException) {
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
	protected LinkCRF removeImpl(LinkCRF linkCRF) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(linkCRF)) {
				linkCRF = (LinkCRF)session.get(
					LinkCRFImpl.class, linkCRF.getPrimaryKeyObj());
			}

			if (linkCRF != null) {
				session.delete(linkCRF);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (linkCRF != null) {
			clearCache(linkCRF);
		}

		return linkCRF;
	}

	@Override
	public LinkCRF updateImpl(LinkCRF linkCRF) {
		boolean isNew = linkCRF.isNew();

		if (!(linkCRF instanceof LinkCRFModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(linkCRF.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(linkCRF);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in linkCRF proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LinkCRF implementation " +
					linkCRF.getClass());
		}

		LinkCRFModelImpl linkCRFModelImpl = (LinkCRFModelImpl)linkCRF;

		if (Validator.isNull(linkCRF.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			linkCRF.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (linkCRF.getCreateDate() == null)) {
			if (serviceContext == null) {
				linkCRF.setCreateDate(now);
			}
			else {
				linkCRF.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!linkCRFModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				linkCRF.setModifiedDate(now);
			}
			else {
				linkCRF.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (linkCRF.isNew()) {
				session.save(linkCRF);

				linkCRF.setNew(false);
			}
			else {
				linkCRF = (LinkCRF)session.merge(linkCRF);
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
			Object[] args = new Object[] {linkCRFModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				linkCRFModelImpl.getUuid(), linkCRFModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {linkCRFModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {linkCRFModelImpl.getSubjectId()};

			finderCache.removeResult(_finderPathCountBySubjectId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySubjectId, args);

			args = new Object[] {
				linkCRFModelImpl.getGroupId(), linkCRFModelImpl.getSubjectId()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S, args);

			args = new Object[] {
				linkCRFModelImpl.getGroupId(), linkCRFModelImpl.getCrfId()
			};

			finderCache.removeResult(_finderPathCountByG_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C, args);

			args = new Object[] {
				linkCRFModelImpl.getGroupId(), linkCRFModelImpl.getSubjectId(),
				linkCRFModelImpl.getCrfId()
			};

			finderCache.removeResult(_finderPathCountByG_S_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S_C, args);

			args = new Object[] {
				linkCRFModelImpl.getCrfId(), linkCRFModelImpl.getSubjectId()
			};

			finderCache.removeResult(_finderPathCountByC_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_S, args);

			args = new Object[] {linkCRFModelImpl.getStructuredDataId()};

			finderCache.removeResult(_finderPathCountByStructuredDataId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStructuredDataId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((linkCRFModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					linkCRFModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {linkCRFModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((linkCRFModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					linkCRFModelImpl.getOriginalUuid(),
					linkCRFModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					linkCRFModelImpl.getUuid(), linkCRFModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((linkCRFModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					linkCRFModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {linkCRFModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((linkCRFModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySubjectId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					linkCRFModelImpl.getOriginalSubjectId()
				};

				finderCache.removeResult(_finderPathCountBySubjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySubjectId, args);

				args = new Object[] {linkCRFModelImpl.getSubjectId()};

				finderCache.removeResult(_finderPathCountBySubjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySubjectId, args);
			}

			if ((linkCRFModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					linkCRFModelImpl.getOriginalGroupId(),
					linkCRFModelImpl.getOriginalSubjectId()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);

				args = new Object[] {
					linkCRFModelImpl.getGroupId(),
					linkCRFModelImpl.getSubjectId()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);
			}

			if ((linkCRFModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					linkCRFModelImpl.getOriginalGroupId(),
					linkCRFModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);

				args = new Object[] {
					linkCRFModelImpl.getGroupId(), linkCRFModelImpl.getCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);
			}

			if ((linkCRFModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					linkCRFModelImpl.getOriginalGroupId(),
					linkCRFModelImpl.getOriginalSubjectId(),
					linkCRFModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_S_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S_C, args);

				args = new Object[] {
					linkCRFModelImpl.getGroupId(),
					linkCRFModelImpl.getSubjectId(), linkCRFModelImpl.getCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_S_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S_C, args);
			}

			if ((linkCRFModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					linkCRFModelImpl.getOriginalCrfId(),
					linkCRFModelImpl.getOriginalSubjectId()
				};

				finderCache.removeResult(_finderPathCountByC_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_S, args);

				args = new Object[] {
					linkCRFModelImpl.getCrfId(), linkCRFModelImpl.getSubjectId()
				};

				finderCache.removeResult(_finderPathCountByC_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_S, args);
			}

			if ((linkCRFModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStructuredDataId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					linkCRFModelImpl.getOriginalStructuredDataId()
				};

				finderCache.removeResult(
					_finderPathCountByStructuredDataId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStructuredDataId, args);

				args = new Object[] {linkCRFModelImpl.getStructuredDataId()};

				finderCache.removeResult(
					_finderPathCountByStructuredDataId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStructuredDataId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LinkCRFImpl.class, linkCRF.getPrimaryKey(),
			linkCRF, false);

		clearUniqueFindersCache(linkCRFModelImpl, false);
		cacheUniqueFindersCache(linkCRFModelImpl);

		linkCRF.resetOriginalValues();

		return linkCRF;
	}

	/**
	 * Returns the link crf with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the link crf
	 * @return the link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLinkCRFException {

		LinkCRF linkCRF = fetchByPrimaryKey(primaryKey);

		if (linkCRF == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLinkCRFException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return linkCRF;
	}

	/**
	 * Returns the link crf with the primary key or throws a <code>NoSuchLinkCRFException</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf
	 * @throws NoSuchLinkCRFException if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF findByPrimaryKey(long linkId) throws NoSuchLinkCRFException {
		return findByPrimaryKey((Serializable)linkId);
	}

	/**
	 * Returns the link crf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link crf
	 * @return the link crf, or <code>null</code> if a link crf with the primary key could not be found
	 */
	@Override
	public LinkCRF fetchByPrimaryKey(long linkId) {
		return fetchByPrimaryKey((Serializable)linkId);
	}

	/**
	 * Returns all the link crfs.
	 *
	 * @return the link crfs
	 */
	@Override
	public List<LinkCRF> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @return the range of link crfs
	 */
	@Override
	public List<LinkCRF> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of link crfs
	 */
	@Override
	public List<LinkCRF> findAll(
		int start, int end, OrderByComparator<LinkCRF> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the link crfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkCRFModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of link crfs
	 * @param end the upper bound of the range of link crfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of link crfs
	 */
	@Override
	public List<LinkCRF> findAll(
		int start, int end, OrderByComparator<LinkCRF> orderByComparator,
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

		List<LinkCRF> list = null;

		if (useFinderCache) {
			list = (List<LinkCRF>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LINKCRF);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LINKCRF;

				sql = sql.concat(LinkCRFModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LinkCRF>)QueryUtil.list(
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
	 * Removes all the link crfs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LinkCRF linkCRF : findAll()) {
			remove(linkCRF);
		}
	}

	/**
	 * Returns the number of link crfs.
	 *
	 * @return the number of link crfs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LINKCRF);

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
		return "linkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LINKCRF;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LinkCRFModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the link crf persistence.
	 */
	@Activate
	public void activate() {
		LinkCRFModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LinkCRFModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			LinkCRFModelImpl.UUID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			LinkCRFModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			LinkCRFModelImpl.UUID_COLUMN_BITMASK |
			LinkCRFModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			LinkCRFModelImpl.UUID_COLUMN_BITMASK |
			LinkCRFModelImpl.COMPANYID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			LinkCRFModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByLinkId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLinkId",
			new String[] {Long.class.getName()},
			LinkCRFModelImpl.LINKID_COLUMN_BITMASK);

		_finderPathCountByLinkId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLinkId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LinkCRFModelImpl.GROUPID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			LinkCRFModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBySubjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySubjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubjectId",
			new String[] {Long.class.getName()},
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			LinkCRFModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountBySubjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubjectId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Long.class.getName()},
			LinkCRFModelImpl.GROUPID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			LinkCRFModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			LinkCRFModelImpl.GROUPID_COLUMN_BITMASK |
			LinkCRFModelImpl.CRFID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			LinkCRFModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_S_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LinkCRFModelImpl.GROUPID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.CRFID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			LinkCRFModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_S_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathFetchByG_S_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_S_SD",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LinkCRFModelImpl.GROUPID_COLUMN_BITMASK |
			LinkCRFModelImpl.CRFID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK);

		_finderPathCountByG_S_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_SD",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathFetchByG_S_C_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_S_C_SD",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			LinkCRFModelImpl.GROUPID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.CRFID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK);

		_finderPathCountByG_S_C_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_C_SD",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S",
			new String[] {Long.class.getName(), Long.class.getName()},
			LinkCRFModelImpl.CRFID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			LinkCRFModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByC_S_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_S_SD",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LinkCRFModelImpl.CRFID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK);

		_finderPathCountByC_S_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S_SD",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByStructuredDataId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStructuredDataId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStructuredDataId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStructuredDataId",
			new String[] {Long.class.getName()},
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK |
			LinkCRFModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByStructuredDataId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStructuredDataId", new String[] {Long.class.getName()});

		_finderPathFetchByLinkSId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLinkSId",
			new String[] {Long.class.getName()},
			LinkCRFModelImpl.SUBJECTID_COLUMN_BITMASK);

		_finderPathCountByLinkSId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLinkSId",
			new String[] {Long.class.getName()});

		_finderPathFetchByLinkSdId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinkCRFImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLinkSdId",
			new String[] {Long.class.getName()},
			LinkCRFModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK);

		_finderPathCountByLinkSdId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLinkSdId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LinkCRFImpl.class.getName());
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
				"value.object.column.bitmask.enabled.ecrf.user.model.LinkCRF"),
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

	private static final String _SQL_SELECT_LINKCRF =
		"SELECT linkCRF FROM LinkCRF linkCRF";

	private static final String _SQL_SELECT_LINKCRF_WHERE =
		"SELECT linkCRF FROM LinkCRF linkCRF WHERE ";

	private static final String _SQL_COUNT_LINKCRF =
		"SELECT COUNT(linkCRF) FROM LinkCRF linkCRF";

	private static final String _SQL_COUNT_LINKCRF_WHERE =
		"SELECT COUNT(linkCRF) FROM LinkCRF linkCRF WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "linkCRF.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LinkCRF exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LinkCRF exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LinkCRFPersistenceImpl.class);

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