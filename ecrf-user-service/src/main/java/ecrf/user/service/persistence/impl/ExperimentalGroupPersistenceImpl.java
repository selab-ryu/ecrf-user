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
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import ecrf.user.exception.NoSuchExperimentalGroupException;
import ecrf.user.model.ExperimentalGroup;
import ecrf.user.model.impl.ExperimentalGroupImpl;
import ecrf.user.model.impl.ExperimentalGroupModelImpl;
import ecrf.user.service.persistence.ExperimentalGroupPersistence;
import ecrf.user.service.persistence.ExperimentalGroupUtil;
import ecrf.user.service.persistence.impl.constants.ECPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
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
 * The persistence implementation for the experimental group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @generated
 */
@Component(service = ExperimentalGroupPersistence.class)
public class ExperimentalGroupPersistenceImpl
	extends BasePersistenceImpl<ExperimentalGroup>
	implements ExperimentalGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExperimentalGroupUtil</code> to access the experimental group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExperimentalGroupImpl.class.getName();

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
	 * Returns all the experimental groups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experimental groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
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

		List<ExperimentalGroup> list = null;

		if (useFinderCache) {
			list = (List<ExperimentalGroup>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExperimentalGroup experimentalGroup : list) {
					if (!uuid.equals(experimentalGroup.getUuid())) {
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

			sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

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
				sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
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

				list = (List<ExperimentalGroup>)QueryUtil.list(
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
	 * Returns the first experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByUuid_First(
			String uuid, OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByUuid_First(
			uuid, orderByComparator);

		if (experimentalGroup != null) {
			return experimentalGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchExperimentalGroupException(sb.toString());
	}

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByUuid_First(
		String uuid, OrderByComparator<ExperimentalGroup> orderByComparator) {

		List<ExperimentalGroup> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByUuid_Last(
			String uuid, OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByUuid_Last(
			uuid, orderByComparator);

		if (experimentalGroup != null) {
			return experimentalGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchExperimentalGroupException(sb.toString());
	}

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByUuid_Last(
		String uuid, OrderByComparator<ExperimentalGroup> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ExperimentalGroup> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where uuid = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup[] findByUuid_PrevAndNext(
			long experimentalGroupId, String uuid,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		uuid = Objects.toString(uuid, "");

		ExperimentalGroup experimentalGroup = findByPrimaryKey(
			experimentalGroupId);

		Session session = null;

		try {
			session = openSession();

			ExperimentalGroup[] array = new ExperimentalGroupImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, experimentalGroup, uuid, orderByComparator, true);

			array[1] = experimentalGroup;

			array[2] = getByUuid_PrevAndNext(
				session, experimentalGroup, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExperimentalGroup getByUuid_PrevAndNext(
		Session session, ExperimentalGroup experimentalGroup, String uuid,
		OrderByComparator<ExperimentalGroup> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

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
			sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
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
						experimentalGroup)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExperimentalGroup> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the experimental groups where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ExperimentalGroup experimentalGroup :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(experimentalGroup);
		}
	}

	/**
	 * Returns the number of experimental groups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching experimental groups
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPERIMENTALGROUP_WHERE);

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
		"experimentalGroup.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(experimentalGroup.uuid IS NULL OR experimentalGroup.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the experimental group where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByUUID_G(String uuid, long groupId)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByUUID_G(uuid, groupId);

		if (experimentalGroup == null) {
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

			throw new NoSuchExperimentalGroupException(sb.toString());
		}

		return experimentalGroup;
	}

	/**
	 * Returns the experimental group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the experimental group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByUUID_G(
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

		if (result instanceof ExperimentalGroup) {
			ExperimentalGroup experimentalGroup = (ExperimentalGroup)result;

			if (!Objects.equals(uuid, experimentalGroup.getUuid()) ||
				(groupId != experimentalGroup.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

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

				List<ExperimentalGroup> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ExperimentalGroup experimentalGroup = list.get(0);

					result = experimentalGroup;

					cacheResult(experimentalGroup);
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
			return (ExperimentalGroup)result;
		}
	}

	/**
	 * Removes the experimental group where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the experimental group that was removed
	 */
	@Override
	public ExperimentalGroup removeByUUID_G(String uuid, long groupId)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = findByUUID_G(uuid, groupId);

		return remove(experimentalGroup);
	}

	/**
	 * Returns the number of experimental groups where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching experimental groups
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXPERIMENTALGROUP_WHERE);

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
		"experimentalGroup.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(experimentalGroup.uuid IS NULL OR experimentalGroup.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"experimentalGroup.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
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

		List<ExperimentalGroup> list = null;

		if (useFinderCache) {
			list = (List<ExperimentalGroup>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExperimentalGroup experimentalGroup : list) {
					if (!uuid.equals(experimentalGroup.getUuid()) ||
						(companyId != experimentalGroup.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

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
				sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
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

				list = (List<ExperimentalGroup>)QueryUtil.list(
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
	 * Returns the first experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (experimentalGroup != null) {
			return experimentalGroup;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchExperimentalGroupException(sb.toString());
	}

	/**
	 * Returns the first experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		List<ExperimentalGroup> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (experimentalGroup != null) {
			return experimentalGroup;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchExperimentalGroupException(sb.toString());
	}

	/**
	 * Returns the last experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ExperimentalGroup> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup[] findByUuid_C_PrevAndNext(
			long experimentalGroupId, String uuid, long companyId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		uuid = Objects.toString(uuid, "");

		ExperimentalGroup experimentalGroup = findByPrimaryKey(
			experimentalGroupId);

		Session session = null;

		try {
			session = openSession();

			ExperimentalGroup[] array = new ExperimentalGroupImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, experimentalGroup, uuid, companyId, orderByComparator,
				true);

			array[1] = experimentalGroup;

			array[2] = getByUuid_C_PrevAndNext(
				session, experimentalGroup, uuid, companyId, orderByComparator,
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

	protected ExperimentalGroup getByUuid_C_PrevAndNext(
		Session session, ExperimentalGroup experimentalGroup, String uuid,
		long companyId, OrderByComparator<ExperimentalGroup> orderByComparator,
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

		sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

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
			sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
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
						experimentalGroup)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExperimentalGroup> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the experimental groups where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ExperimentalGroup experimentalGroup :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(experimentalGroup);
		}
	}

	/**
	 * Returns the number of experimental groups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching experimental groups
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXPERIMENTALGROUP_WHERE);

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
		"experimentalGroup.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(experimentalGroup.uuid IS NULL OR experimentalGroup.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"experimentalGroup.companyId = ?";

	private FinderPath _finderPathFetchByExperimentalGroupId;
	private FinderPath _finderPathCountByExperimentalGroupId;

	/**
	 * Returns the experimental group where experimentalGroupId = &#63; or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByExperimentalGroupId(long experimentalGroupId)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByExperimentalGroupId(
			experimentalGroupId);

		if (experimentalGroup == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("experimentalGroupId=");
			sb.append(experimentalGroupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchExperimentalGroupException(sb.toString());
		}

		return experimentalGroup;
	}

	/**
	 * Returns the experimental group where experimentalGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByExperimentalGroupId(
		long experimentalGroupId) {

		return fetchByExperimentalGroupId(experimentalGroupId, true);
	}

	/**
	 * Returns the experimental group where experimentalGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByExperimentalGroupId(
		long experimentalGroupId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {experimentalGroupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExperimentalGroupId, finderArgs, this);
		}

		if (result instanceof ExperimentalGroup) {
			ExperimentalGroup experimentalGroup = (ExperimentalGroup)result;

			if (experimentalGroupId !=
					experimentalGroup.getExperimentalGroupId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

			sb.append(_FINDER_COLUMN_EXPERIMENTALGROUPID_EXPERIMENTALGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(experimentalGroupId);

				List<ExperimentalGroup> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExperimentalGroupId, finderArgs,
							list);
					}
				}
				else {
					ExperimentalGroup experimentalGroup = list.get(0);

					result = experimentalGroup;

					cacheResult(experimentalGroup);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExperimentalGroupId, finderArgs);
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
			return (ExperimentalGroup)result;
		}
	}

	/**
	 * Removes the experimental group where experimentalGroupId = &#63; from the database.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the experimental group that was removed
	 */
	@Override
	public ExperimentalGroup removeByExperimentalGroupId(
			long experimentalGroupId)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = findByExperimentalGroupId(
			experimentalGroupId);

		return remove(experimentalGroup);
	}

	/**
	 * Returns the number of experimental groups where experimentalGroupId = &#63;.
	 *
	 * @param experimentalGroupId the experimental group ID
	 * @return the number of matching experimental groups
	 */
	@Override
	public int countByExperimentalGroupId(long experimentalGroupId) {
		FinderPath finderPath = _finderPathCountByExperimentalGroupId;

		Object[] finderArgs = new Object[] {experimentalGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPERIMENTALGROUP_WHERE);

			sb.append(_FINDER_COLUMN_EXPERIMENTALGROUPID_EXPERIMENTALGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(experimentalGroupId);

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
		_FINDER_COLUMN_EXPERIMENTALGROUPID_EXPERIMENTALGROUPID_2 =
			"experimentalGroup.experimentalGroupId = ?";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the experimental groups where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experimental groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the experimental groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByName(
		String name, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the experimental groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByName(
		String name, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<ExperimentalGroup> list = null;

		if (useFinderCache) {
			list = (List<ExperimentalGroup>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExperimentalGroup experimentalGroup : list) {
					if (!name.equals(experimentalGroup.getName())) {
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

			sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<ExperimentalGroup>)QueryUtil.list(
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
	 * Returns the first experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByName_First(
			String name, OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByName_First(
			name, orderByComparator);

		if (experimentalGroup != null) {
			return experimentalGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchExperimentalGroupException(sb.toString());
	}

	/**
	 * Returns the first experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByName_First(
		String name, OrderByComparator<ExperimentalGroup> orderByComparator) {

		List<ExperimentalGroup> list = findByName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByName_Last(
			String name, OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByName_Last(
			name, orderByComparator);

		if (experimentalGroup != null) {
			return experimentalGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchExperimentalGroupException(sb.toString());
	}

	/**
	 * Returns the last experimental group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByName_Last(
		String name, OrderByComparator<ExperimentalGroup> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ExperimentalGroup> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where name = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup[] findByName_PrevAndNext(
			long experimentalGroupId, String name,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		name = Objects.toString(name, "");

		ExperimentalGroup experimentalGroup = findByPrimaryKey(
			experimentalGroupId);

		Session session = null;

		try {
			session = openSession();

			ExperimentalGroup[] array = new ExperimentalGroupImpl[3];

			array[0] = getByName_PrevAndNext(
				session, experimentalGroup, name, orderByComparator, true);

			array[1] = experimentalGroup;

			array[2] = getByName_PrevAndNext(
				session, experimentalGroup, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExperimentalGroup getByName_PrevAndNext(
		Session session, ExperimentalGroup experimentalGroup, String name,
		OrderByComparator<ExperimentalGroup> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
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
			sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						experimentalGroup)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExperimentalGroup> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the experimental groups where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (ExperimentalGroup experimentalGroup :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(experimentalGroup);
		}
	}

	/**
	 * Returns the number of experimental groups where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching experimental groups
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPERIMENTALGROUP_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"experimentalGroup.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(experimentalGroup.name IS NULL OR experimentalGroup.name = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the experimental groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experimental groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the experimental groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the experimental groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
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

		List<ExperimentalGroup> list = null;

		if (useFinderCache) {
			list = (List<ExperimentalGroup>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExperimentalGroup experimentalGroup : list) {
					if (groupId != experimentalGroup.getGroupId()) {
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

			sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ExperimentalGroup>)QueryUtil.list(
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
	 * Returns the first experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByGroupId_First(
			long groupId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByGroupId_First(
			groupId, orderByComparator);

		if (experimentalGroup != null) {
			return experimentalGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchExperimentalGroupException(sb.toString());
	}

	/**
	 * Returns the first experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByGroupId_First(
		long groupId, OrderByComparator<ExperimentalGroup> orderByComparator) {

		List<ExperimentalGroup> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByGroupId_Last(
			long groupId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (experimentalGroup != null) {
			return experimentalGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchExperimentalGroupException(sb.toString());
	}

	/**
	 * Returns the last experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByGroupId_Last(
		long groupId, OrderByComparator<ExperimentalGroup> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ExperimentalGroup> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the experimental groups before and after the current experimental group in the ordered set where groupId = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup[] findByGroupId_PrevAndNext(
			long experimentalGroupId, long groupId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = findByPrimaryKey(
			experimentalGroupId);

		Session session = null;

		try {
			session = openSession();

			ExperimentalGroup[] array = new ExperimentalGroupImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, experimentalGroup, groupId, orderByComparator, true);

			array[1] = experimentalGroup;

			array[2] = getByGroupId_PrevAndNext(
				session, experimentalGroup, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExperimentalGroup getByGroupId_PrevAndNext(
		Session session, ExperimentalGroup experimentalGroup, long groupId,
		OrderByComparator<ExperimentalGroup> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

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
			sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
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
						experimentalGroup)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExperimentalGroup> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the experimental groups that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching experimental groups that the user has permission to view
	 */
	@Override
	public List<ExperimentalGroup> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experimental groups that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of matching experimental groups that the user has permission to view
	 */
	@Override
	public List<ExperimentalGroup> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the experimental groups that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experimental groups that the user has permission to view
	 */
	@Override
	public List<ExperimentalGroup> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_EXPERIMENTALGROUP_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPERIMENTALGROUP_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPERIMENTALGROUP_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExperimentalGroupModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExperimentalGroup.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, ExperimentalGroupImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, ExperimentalGroupImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<ExperimentalGroup>)QueryUtil.list(
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
	 * Returns the experimental groups before and after the current experimental group in the ordered set of experimental groups that the user has permission to view where groupId = &#63;.
	 *
	 * @param experimentalGroupId the primary key of the current experimental group
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup[] filterFindByGroupId_PrevAndNext(
			long experimentalGroupId, long groupId,
			OrderByComparator<ExperimentalGroup> orderByComparator)
		throws NoSuchExperimentalGroupException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				experimentalGroupId, groupId, orderByComparator);
		}

		ExperimentalGroup experimentalGroup = findByPrimaryKey(
			experimentalGroupId);

		Session session = null;

		try {
			session = openSession();

			ExperimentalGroup[] array = new ExperimentalGroupImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, experimentalGroup, groupId, orderByComparator, true);

			array[1] = experimentalGroup;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, experimentalGroup, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExperimentalGroup filterGetByGroupId_PrevAndNext(
		Session session, ExperimentalGroup experimentalGroup, long groupId,
		OrderByComparator<ExperimentalGroup> orderByComparator,
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

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_EXPERIMENTALGROUP_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPERIMENTALGROUP_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPERIMENTALGROUP_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExperimentalGroupModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExperimentalGroup.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, ExperimentalGroupImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, ExperimentalGroupImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						experimentalGroup)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExperimentalGroup> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the experimental groups where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ExperimentalGroup experimentalGroup :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(experimentalGroup);
		}
	}

	/**
	 * Returns the number of experimental groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching experimental groups
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPERIMENTALGROUP_WHERE);

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
	 * Returns the number of experimental groups that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching experimental groups that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_EXPERIMENTALGROUP_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExperimentalGroup.class.getName(),
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
		"experimentalGroup.groupId = ?";

	private FinderPath _finderPathFetchByG_N;
	private FinderPath _finderPathCountByG_N;

	/**
	 * Returns the experimental group where groupId = &#63; and name = &#63; or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching experimental group
	 * @throws NoSuchExperimentalGroupException if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup findByG_N(long groupId, String name)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByG_N(groupId, name);

		if (experimentalGroup == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchExperimentalGroupException(sb.toString());
		}

		return experimentalGroup;
	}

	/**
	 * Returns the experimental group where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByG_N(long groupId, String name) {
		return fetchByG_N(groupId, name, true);
	}

	/**
	 * Returns the experimental group where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching experimental group, or <code>null</code> if a matching experimental group could not be found
	 */
	@Override
	public ExperimentalGroup fetchByG_N(
		long groupId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_N, finderArgs, this);
		}

		if (result instanceof ExperimentalGroup) {
			ExperimentalGroup experimentalGroup = (ExperimentalGroup)result;

			if ((groupId != experimentalGroup.getGroupId()) ||
				!Objects.equals(name, experimentalGroup.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EXPERIMENTALGROUP_WHERE);

			sb.append(_FINDER_COLUMN_G_N_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_G_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindName) {
					queryPos.add(name);
				}

				List<ExperimentalGroup> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupId, name};
							}

							_log.warn(
								"ExperimentalGroupPersistenceImpl.fetchByG_N(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ExperimentalGroup experimentalGroup = list.get(0);

					result = experimentalGroup;

					cacheResult(experimentalGroup);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByG_N, finderArgs);
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
			return (ExperimentalGroup)result;
		}
	}

	/**
	 * Removes the experimental group where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the experimental group that was removed
	 */
	@Override
	public ExperimentalGroup removeByG_N(long groupId, String name)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = findByG_N(groupId, name);

		return remove(experimentalGroup);
	}

	/**
	 * Returns the number of experimental groups where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching experimental groups
	 */
	@Override
	public int countByG_N(long groupId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByG_N;

		Object[] finderArgs = new Object[] {groupId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXPERIMENTALGROUP_WHERE);

			sb.append(_FINDER_COLUMN_G_N_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_G_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_G_N_GROUPID_2 =
		"experimentalGroup.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_N_NAME_2 =
		"experimentalGroup.name = ?";

	private static final String _FINDER_COLUMN_G_N_NAME_3 =
		"(experimentalGroup.name IS NULL OR experimentalGroup.name = '')";

	public ExperimentalGroupPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ExperimentalGroup.class);

		setModelImplClass(ExperimentalGroupImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the experimental group in the entity cache if it is enabled.
	 *
	 * @param experimentalGroup the experimental group
	 */
	@Override
	public void cacheResult(ExperimentalGroup experimentalGroup) {
		entityCache.putResult(
			entityCacheEnabled, ExperimentalGroupImpl.class,
			experimentalGroup.getPrimaryKey(), experimentalGroup);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				experimentalGroup.getUuid(), experimentalGroup.getGroupId()
			},
			experimentalGroup);

		finderCache.putResult(
			_finderPathFetchByExperimentalGroupId,
			new Object[] {experimentalGroup.getExperimentalGroupId()},
			experimentalGroup);

		finderCache.putResult(
			_finderPathFetchByG_N,
			new Object[] {
				experimentalGroup.getGroupId(), experimentalGroup.getName()
			},
			experimentalGroup);

		experimentalGroup.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the experimental groups in the entity cache if it is enabled.
	 *
	 * @param experimentalGroups the experimental groups
	 */
	@Override
	public void cacheResult(List<ExperimentalGroup> experimentalGroups) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (experimentalGroups.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ExperimentalGroup experimentalGroup : experimentalGroups) {
			if (entityCache.getResult(
					entityCacheEnabled, ExperimentalGroupImpl.class,
					experimentalGroup.getPrimaryKey()) == null) {

				cacheResult(experimentalGroup);
			}
			else {
				experimentalGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all experimental groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExperimentalGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the experimental group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExperimentalGroup experimentalGroup) {
		entityCache.removeResult(
			entityCacheEnabled, ExperimentalGroupImpl.class,
			experimentalGroup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ExperimentalGroupModelImpl)experimentalGroup, true);
	}

	@Override
	public void clearCache(List<ExperimentalGroup> experimentalGroups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExperimentalGroup experimentalGroup : experimentalGroups) {
			entityCache.removeResult(
				entityCacheEnabled, ExperimentalGroupImpl.class,
				experimentalGroup.getPrimaryKey());

			clearUniqueFindersCache(
				(ExperimentalGroupModelImpl)experimentalGroup, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ExperimentalGroupImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ExperimentalGroupModelImpl experimentalGroupModelImpl) {

		Object[] args = new Object[] {
			experimentalGroupModelImpl.getUuid(),
			experimentalGroupModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, experimentalGroupModelImpl, false);

		args = new Object[] {
			experimentalGroupModelImpl.getExperimentalGroupId()
		};

		finderCache.putResult(
			_finderPathCountByExperimentalGroupId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByExperimentalGroupId, args,
			experimentalGroupModelImpl, false);

		args = new Object[] {
			experimentalGroupModelImpl.getGroupId(),
			experimentalGroupModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByG_N, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_N, args, experimentalGroupModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ExperimentalGroupModelImpl experimentalGroupModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				experimentalGroupModelImpl.getUuid(),
				experimentalGroupModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((experimentalGroupModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				experimentalGroupModelImpl.getOriginalUuid(),
				experimentalGroupModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				experimentalGroupModelImpl.getExperimentalGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByExperimentalGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByExperimentalGroupId, args);
		}

		if ((experimentalGroupModelImpl.getColumnBitmask() &
			 _finderPathFetchByExperimentalGroupId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				experimentalGroupModelImpl.getOriginalExperimentalGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByExperimentalGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByExperimentalGroupId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				experimentalGroupModelImpl.getGroupId(),
				experimentalGroupModelImpl.getName()
			};

			finderCache.removeResult(_finderPathCountByG_N, args);
			finderCache.removeResult(_finderPathFetchByG_N, args);
		}

		if ((experimentalGroupModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_N.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				experimentalGroupModelImpl.getOriginalGroupId(),
				experimentalGroupModelImpl.getOriginalName()
			};

			finderCache.removeResult(_finderPathCountByG_N, args);
			finderCache.removeResult(_finderPathFetchByG_N, args);
		}
	}

	/**
	 * Creates a new experimental group with the primary key. Does not add the experimental group to the database.
	 *
	 * @param experimentalGroupId the primary key for the new experimental group
	 * @return the new experimental group
	 */
	@Override
	public ExperimentalGroup create(long experimentalGroupId) {
		ExperimentalGroup experimentalGroup = new ExperimentalGroupImpl();

		experimentalGroup.setNew(true);
		experimentalGroup.setPrimaryKey(experimentalGroupId);

		String uuid = PortalUUIDUtil.generate();

		experimentalGroup.setUuid(uuid);

		experimentalGroup.setCompanyId(CompanyThreadLocal.getCompanyId());

		return experimentalGroup;
	}

	/**
	 * Removes the experimental group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group that was removed
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup remove(long experimentalGroupId)
		throws NoSuchExperimentalGroupException {

		return remove((Serializable)experimentalGroupId);
	}

	/**
	 * Removes the experimental group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the experimental group
	 * @return the experimental group that was removed
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup remove(Serializable primaryKey)
		throws NoSuchExperimentalGroupException {

		Session session = null;

		try {
			session = openSession();

			ExperimentalGroup experimentalGroup =
				(ExperimentalGroup)session.get(
					ExperimentalGroupImpl.class, primaryKey);

			if (experimentalGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExperimentalGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(experimentalGroup);
		}
		catch (NoSuchExperimentalGroupException noSuchEntityException) {
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
	protected ExperimentalGroup removeImpl(
		ExperimentalGroup experimentalGroup) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(experimentalGroup)) {
				experimentalGroup = (ExperimentalGroup)session.get(
					ExperimentalGroupImpl.class,
					experimentalGroup.getPrimaryKeyObj());
			}

			if (experimentalGroup != null) {
				session.delete(experimentalGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (experimentalGroup != null) {
			clearCache(experimentalGroup);
		}

		return experimentalGroup;
	}

	@Override
	public ExperimentalGroup updateImpl(ExperimentalGroup experimentalGroup) {
		boolean isNew = experimentalGroup.isNew();

		if (!(experimentalGroup instanceof ExperimentalGroupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(experimentalGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					experimentalGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in experimentalGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ExperimentalGroup implementation " +
					experimentalGroup.getClass());
		}

		ExperimentalGroupModelImpl experimentalGroupModelImpl =
			(ExperimentalGroupModelImpl)experimentalGroup;

		if (Validator.isNull(experimentalGroup.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			experimentalGroup.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (experimentalGroup.getCreateDate() == null)) {
			if (serviceContext == null) {
				experimentalGroup.setCreateDate(date);
			}
			else {
				experimentalGroup.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!experimentalGroupModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				experimentalGroup.setModifiedDate(date);
			}
			else {
				experimentalGroup.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(experimentalGroup);

				experimentalGroup.setNew(false);
			}
			else {
				experimentalGroup = (ExperimentalGroup)session.merge(
					experimentalGroup);
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
			Object[] args = new Object[] {experimentalGroupModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				experimentalGroupModelImpl.getUuid(),
				experimentalGroupModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {experimentalGroupModelImpl.getName()};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName, args);

			args = new Object[] {experimentalGroupModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((experimentalGroupModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					experimentalGroupModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {experimentalGroupModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((experimentalGroupModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					experimentalGroupModelImpl.getOriginalUuid(),
					experimentalGroupModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					experimentalGroupModelImpl.getUuid(),
					experimentalGroupModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((experimentalGroupModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					experimentalGroupModelImpl.getOriginalName()
				};

				finderCache.removeResult(_finderPathCountByName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName, args);

				args = new Object[] {experimentalGroupModelImpl.getName()};

				finderCache.removeResult(_finderPathCountByName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName, args);
			}

			if ((experimentalGroupModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					experimentalGroupModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {experimentalGroupModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ExperimentalGroupImpl.class,
			experimentalGroup.getPrimaryKey(), experimentalGroup, false);

		clearUniqueFindersCache(experimentalGroupModelImpl, false);
		cacheUniqueFindersCache(experimentalGroupModelImpl);

		experimentalGroup.resetOriginalValues();

		return experimentalGroup;
	}

	/**
	 * Returns the experimental group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the experimental group
	 * @return the experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExperimentalGroupException {

		ExperimentalGroup experimentalGroup = fetchByPrimaryKey(primaryKey);

		if (experimentalGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExperimentalGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return experimentalGroup;
	}

	/**
	 * Returns the experimental group with the primary key or throws a <code>NoSuchExperimentalGroupException</code> if it could not be found.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group
	 * @throws NoSuchExperimentalGroupException if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup findByPrimaryKey(long experimentalGroupId)
		throws NoSuchExperimentalGroupException {

		return findByPrimaryKey((Serializable)experimentalGroupId);
	}

	/**
	 * Returns the experimental group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experimentalGroupId the primary key of the experimental group
	 * @return the experimental group, or <code>null</code> if a experimental group with the primary key could not be found
	 */
	@Override
	public ExperimentalGroup fetchByPrimaryKey(long experimentalGroupId) {
		return fetchByPrimaryKey((Serializable)experimentalGroupId);
	}

	/**
	 * Returns all the experimental groups.
	 *
	 * @return the experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @return the range of experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findAll(
		int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the experimental groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperimentalGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experimental groups
	 * @param end the upper bound of the range of experimental groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of experimental groups
	 */
	@Override
	public List<ExperimentalGroup> findAll(
		int start, int end,
		OrderByComparator<ExperimentalGroup> orderByComparator,
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

		List<ExperimentalGroup> list = null;

		if (useFinderCache) {
			list = (List<ExperimentalGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EXPERIMENTALGROUP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EXPERIMENTALGROUP;

				sql = sql.concat(ExperimentalGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ExperimentalGroup>)QueryUtil.list(
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
	 * Removes all the experimental groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExperimentalGroup experimentalGroup : findAll()) {
			remove(experimentalGroup);
		}
	}

	/**
	 * Returns the number of experimental groups.
	 *
	 * @return the number of experimental groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EXPERIMENTALGROUP);

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
		return "experimentalGroupId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXPERIMENTALGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExperimentalGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the experimental group persistence.
	 */
	@Activate
	public void activate() {
		ExperimentalGroupModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ExperimentalGroupModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ExperimentalGroupModelImpl.UUID_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.NAME_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			ExperimentalGroupModelImpl.UUID_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			ExperimentalGroupModelImpl.UUID_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.COMPANYID_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.NAME_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByExperimentalGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExperimentalGroupId",
			new String[] {Long.class.getName()},
			ExperimentalGroupModelImpl.EXPERIMENTALGROUPID_COLUMN_BITMASK);

		_finderPathCountByExperimentalGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExperimentalGroupId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()},
			ExperimentalGroupModelImpl.NAME_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			ExperimentalGroupModelImpl.GROUPID_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.NAME_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathFetchByG_N = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExperimentalGroupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_N",
			new String[] {Long.class.getName(), String.class.getName()},
			ExperimentalGroupModelImpl.GROUPID_COLUMN_BITMASK |
			ExperimentalGroupModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_N = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_N",
			new String[] {Long.class.getName(), String.class.getName()});

		_setExperimentalGroupUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setExperimentalGroupUtilPersistence(null);

		entityCache.removeCache(ExperimentalGroupImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setExperimentalGroupUtilPersistence(
		ExperimentalGroupPersistence experimentalGroupPersistence) {

		try {
			Field field = ExperimentalGroupUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, experimentalGroupPersistence);
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
				"value.object.column.bitmask.enabled.ecrf.user.model.ExperimentalGroup"),
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

	private static final String _SQL_SELECT_EXPERIMENTALGROUP =
		"SELECT experimentalGroup FROM ExperimentalGroup experimentalGroup";

	private static final String _SQL_SELECT_EXPERIMENTALGROUP_WHERE =
		"SELECT experimentalGroup FROM ExperimentalGroup experimentalGroup WHERE ";

	private static final String _SQL_COUNT_EXPERIMENTALGROUP =
		"SELECT COUNT(experimentalGroup) FROM ExperimentalGroup experimentalGroup";

	private static final String _SQL_COUNT_EXPERIMENTALGROUP_WHERE =
		"SELECT COUNT(experimentalGroup) FROM ExperimentalGroup experimentalGroup WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"experimentalGroup.experimentalGroupId";

	private static final String _FILTER_SQL_SELECT_EXPERIMENTALGROUP_WHERE =
		"SELECT DISTINCT {experimentalGroup.*} FROM EC_ExperimentalGroup experimentalGroup WHERE ";

	private static final String
		_FILTER_SQL_SELECT_EXPERIMENTALGROUP_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {EC_ExperimentalGroup.*} FROM (SELECT DISTINCT experimentalGroup.experimentalGroupId FROM EC_ExperimentalGroup experimentalGroup WHERE ";

	private static final String
		_FILTER_SQL_SELECT_EXPERIMENTALGROUP_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN EC_ExperimentalGroup ON TEMP_TABLE.experimentalGroupId = EC_ExperimentalGroup.experimentalGroupId";

	private static final String _FILTER_SQL_COUNT_EXPERIMENTALGROUP_WHERE =
		"SELECT COUNT(DISTINCT experimentalGroup.experimentalGroupId) AS COUNT_VALUE FROM EC_ExperimentalGroup experimentalGroup WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "experimentalGroup";

	private static final String _FILTER_ENTITY_TABLE = "EC_ExperimentalGroup";

	private static final String _ORDER_BY_ENTITY_ALIAS = "experimentalGroup.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"EC_ExperimentalGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ExperimentalGroup exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ExperimentalGroup exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ExperimentalGroupPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

}