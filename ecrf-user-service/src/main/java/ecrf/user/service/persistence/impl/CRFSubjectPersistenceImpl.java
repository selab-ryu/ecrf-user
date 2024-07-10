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

import ecrf.user.exception.NoSuchCRFSubjectException;
import ecrf.user.model.CRFSubject;
import ecrf.user.model.impl.CRFSubjectImpl;
import ecrf.user.model.impl.CRFSubjectModelImpl;
import ecrf.user.service.persistence.CRFSubjectPersistence;
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
 * The persistence implementation for the crf subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryu W.C.
 * @generated
 */
@Component(service = CRFSubjectPersistence.class)
public class CRFSubjectPersistenceImpl
	extends BasePersistenceImpl<CRFSubject> implements CRFSubjectPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CRFSubjectUtil</code> to access the crf subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CRFSubjectImpl.class.getName();

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
	 * Returns all the crf subjects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf subjects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf subjects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
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

		List<CRFSubject> list = null;

		if (useFinderCache) {
			list = (List<CRFSubject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFSubject crfSubject : list) {
					if (!uuid.equals(crfSubject.getUuid())) {
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

			sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the first crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByUuid_First(
			String uuid, OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByUuid_First(uuid, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByUuid_First(
		String uuid, OrderByComparator<CRFSubject> orderByComparator) {

		List<CRFSubject> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByUuid_Last(
			String uuid, OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByUuid_Last(uuid, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByUuid_Last(
		String uuid, OrderByComparator<CRFSubject> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CRFSubject> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where uuid = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] findByUuid_PrevAndNext(
			long crfSubjectId, String uuid,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		uuid = Objects.toString(uuid, "");

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, crfSubject, uuid, orderByComparator, true);

			array[1] = crfSubject;

			array[2] = getByUuid_PrevAndNext(
				session, crfSubject, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFSubject getByUuid_PrevAndNext(
		Session session, CRFSubject crfSubject, String uuid,
		OrderByComparator<CRFSubject> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

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
			sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf subjects where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CRFSubject crfSubject :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfSubject);
		}
	}

	/**
	 * Returns the number of crf subjects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crf subjects
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFSUBJECT_WHERE);

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
		"crfSubject.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(crfSubject.uuid IS NULL OR crfSubject.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the crf subject where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCRFSubjectException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByUUID_G(String uuid, long groupId)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByUUID_G(uuid, groupId);

		if (crfSubject == null) {
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

			throw new NoSuchCRFSubjectException(sb.toString());
		}

		return crfSubject;
	}

	/**
	 * Returns the crf subject where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the crf subject where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByUUID_G(
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

		if (result instanceof CRFSubject) {
			CRFSubject crfSubject = (CRFSubject)result;

			if (!Objects.equals(uuid, crfSubject.getUuid()) ||
				(groupId != crfSubject.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

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

				List<CRFSubject> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CRFSubject crfSubject = list.get(0);

					result = crfSubject;

					cacheResult(crfSubject);
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
			return (CRFSubject)result;
		}
	}

	/**
	 * Removes the crf subject where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the crf subject that was removed
	 */
	@Override
	public CRFSubject removeByUUID_G(String uuid, long groupId)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = findByUUID_G(uuid, groupId);

		return remove(crfSubject);
	}

	/**
	 * Returns the number of crf subjects where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching crf subjects
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFSUBJECT_WHERE);

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
		"crfSubject.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(crfSubject.uuid IS NULL OR crfSubject.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"crfSubject.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
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

		List<CRFSubject> list = null;

		if (useFinderCache) {
			list = (List<CRFSubject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFSubject crfSubject : list) {
					if (!uuid.equals(crfSubject.getUuid()) ||
						(companyId != crfSubject.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
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

				list = (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the first crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the first crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CRFSubject> orderByComparator) {

		List<CRFSubject> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the last crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CRFSubject> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CRFSubject> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] findByUuid_C_PrevAndNext(
			long crfSubjectId, String uuid, long companyId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		uuid = Objects.toString(uuid, "");

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, crfSubject, uuid, companyId, orderByComparator, true);

			array[1] = crfSubject;

			array[2] = getByUuid_C_PrevAndNext(
				session, crfSubject, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFSubject getByUuid_C_PrevAndNext(
		Session session, CRFSubject crfSubject, String uuid, long companyId,
		OrderByComparator<CRFSubject> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

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
			sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf subjects where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CRFSubject crfSubject :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfSubject);
		}
	}

	/**
	 * Returns the number of crf subjects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching crf subjects
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFSUBJECT_WHERE);

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
		"crfSubject.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(crfSubject.uuid IS NULL OR crfSubject.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"crfSubject.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the crf subjects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf subjects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
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

		List<CRFSubject> list = null;

		if (useFinderCache) {
			list = (List<CRFSubject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFSubject crfSubject : list) {
					if (groupId != crfSubject.getGroupId()) {
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

			sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the first crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByGroupId_First(
			long groupId, OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByGroupId_First(
			groupId, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByGroupId_First(
		long groupId, OrderByComparator<CRFSubject> orderByComparator) {

		List<CRFSubject> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByGroupId_Last(
			long groupId, OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByGroupId_Last(groupId, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByGroupId_Last(
		long groupId, OrderByComparator<CRFSubject> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CRFSubject> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] findByGroupId_PrevAndNext(
			long crfSubjectId, long groupId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, crfSubject, groupId, orderByComparator, true);

			array[1] = crfSubject;

			array[2] = getByGroupId_PrevAndNext(
				session, crfSubject, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFSubject getByGroupId_PrevAndNext(
		Session session, CRFSubject crfSubject, long groupId,
		OrderByComparator<CRFSubject> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

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
			sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the crf subjects that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf subjects that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFSubjectImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFSubjectImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the crf subjects before and after the current crf subject in the ordered set of crf subjects that the user has permission to view where groupId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] filterFindByGroupId_PrevAndNext(
			long crfSubjectId, long groupId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				crfSubjectId, groupId, orderByComparator);
		}

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, crfSubject, groupId, orderByComparator, true);

			array[1] = crfSubject;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, crfSubject, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFSubject filterGetByGroupId_PrevAndNext(
		Session session, CRFSubject crfSubject, long groupId,
		OrderByComparator<CRFSubject> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFSubjectImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFSubjectImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf subjects where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (CRFSubject crfSubject :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crfSubject);
		}
	}

	/**
	 * Returns the number of crf subjects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf subjects
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRFSUBJECT_WHERE);

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
	 * Returns the number of crf subjects that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching crf subjects that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_CRFSUBJECT_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
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
		"crfSubject.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C;
	private FinderPath _finderPathWithoutPaginationFindByG_C;
	private FinderPath _finderPathCountByG_C;

	/**
	 * Returns all the crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_C(long groupId, long crfId) {
		return findByG_C(
			groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_C(
		long groupId, long crfId, int start, int end) {

		return findByG_C(groupId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return findByG_C(groupId, crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
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

		List<CRFSubject> list = null;

		if (useFinderCache) {
			list = (List<CRFSubject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFSubject crfSubject : list) {
					if ((groupId != crfSubject.getGroupId()) ||
						(crfId != crfSubject.getCrfId())) {

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

			sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				list = (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByG_C_First(
			long groupId, long crfId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByG_C_First(
			groupId, crfId, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByG_C_First(
		long groupId, long crfId,
		OrderByComparator<CRFSubject> orderByComparator) {

		List<CRFSubject> list = findByG_C(
			groupId, crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByG_C_Last(
			long groupId, long crfId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByG_C_Last(
			groupId, crfId, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByG_C_Last(
		long groupId, long crfId,
		OrderByComparator<CRFSubject> orderByComparator) {

		int count = countByG_C(groupId, crfId);

		if (count == 0) {
			return null;
		}

		List<CRFSubject> list = findByG_C(
			groupId, crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63; and crfId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] findByG_C_PrevAndNext(
			long crfSubjectId, long groupId, long crfId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = getByG_C_PrevAndNext(
				session, crfSubject, groupId, crfId, orderByComparator, true);

			array[1] = crfSubject;

			array[2] = getByG_C_PrevAndNext(
				session, crfSubject, groupId, crfId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFSubject getByG_C_PrevAndNext(
		Session session, CRFSubject crfSubject, long groupId, long crfId,
		OrderByComparator<CRFSubject> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

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
			sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the crf subjects that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByG_C(long groupId, long crfId) {
		return filterFindByG_C(
			groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf subjects that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByG_C(
		long groupId, long crfId, int start, int end) {

		return filterFindByG_C(groupId, crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects that the user has permissions to view where groupId = &#63; and crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByG_C(
		long groupId, long crfId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CRFID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFSubjectImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFSubjectImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(crfId);

			return (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the crf subjects before and after the current crf subject in the ordered set of crf subjects that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] filterFindByG_C_PrevAndNext(
			long crfSubjectId, long groupId, long crfId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_PrevAndNext(
				crfSubjectId, groupId, crfId, orderByComparator);
		}

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = filterGetByG_C_PrevAndNext(
				session, crfSubject, groupId, crfId, orderByComparator, true);

			array[1] = crfSubject;

			array[2] = filterGetByG_C_PrevAndNext(
				session, crfSubject, groupId, crfId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CRFSubject filterGetByG_C_PrevAndNext(
		Session session, CRFSubject crfSubject, long groupId, long crfId,
		OrderByComparator<CRFSubject> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CRFID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFSubjectImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFSubjectImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(crfId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf subjects where groupId = &#63; and crfId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByG_C(long groupId, long crfId) {
		for (CRFSubject crfSubject :
				findByG_C(
					groupId, crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfSubject);
		}
	}

	/**
	 * Returns the number of crf subjects where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf subjects
	 */
	@Override
	public int countByG_C(long groupId, long crfId) {
		FinderPath finderPath = _finderPathCountByG_C;

		Object[] finderArgs = new Object[] {groupId, crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFSUBJECT_WHERE);

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
	 * Returns the number of crf subjects that the user has permission to view where groupId = &#63; and crfId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @return the number of matching crf subjects that the user has permission to view
	 */
	@Override
	public int filterCountByG_C(long groupId, long crfId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C(groupId, crfId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_CRFSUBJECT_WHERE);

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CRFID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
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
		"crfSubject.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_CRFID_2 =
		"crfSubject.crfId = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_S(long groupId, long subjectId) {
		return findByG_S(
			groupId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_S(
		long groupId, long subjectId, int start, int end) {

		return findByG_S(groupId, subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return findByG_S(
			groupId, subjectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
		boolean useFinderCache) {

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

		List<CRFSubject> list = null;

		if (useFinderCache) {
			list = (List<CRFSubject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFSubject crfSubject : list) {
					if ((groupId != crfSubject.getGroupId()) ||
						(subjectId != crfSubject.getSubjectId())) {

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

			sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(subjectId);

				list = (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the first crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByG_S_First(
			long groupId, long subjectId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByG_S_First(
			groupId, subjectId, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByG_S_First(
		long groupId, long subjectId,
		OrderByComparator<CRFSubject> orderByComparator) {

		List<CRFSubject> list = findByG_S(
			groupId, subjectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByG_S_Last(
			long groupId, long subjectId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByG_S_Last(
			groupId, subjectId, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByG_S_Last(
		long groupId, long subjectId,
		OrderByComparator<CRFSubject> orderByComparator) {

		int count = countByG_S(groupId, subjectId);

		if (count == 0) {
			return null;
		}

		List<CRFSubject> list = findByG_S(
			groupId, subjectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] findByG_S_PrevAndNext(
			long crfSubjectId, long groupId, long subjectId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, crfSubject, groupId, subjectId, orderByComparator,
				true);

			array[1] = crfSubject;

			array[2] = getByG_S_PrevAndNext(
				session, crfSubject, groupId, subjectId, orderByComparator,
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

	protected CRFSubject getByG_S_PrevAndNext(
		Session session, CRFSubject crfSubject, long groupId, long subjectId,
		OrderByComparator<CRFSubject> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

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
			sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the crf subjects that the user has permission to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByG_S(long groupId, long subjectId) {
		return filterFindByG_S(
			groupId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf subjects that the user has permission to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByG_S(
		long groupId, long subjectId, int start, int end) {

		return filterFindByG_S(groupId, subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects that the user has permissions to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByG_S(
		long groupId, long subjectId, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, subjectId, start, end, orderByComparator);
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
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_SUBJECTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFSubjectImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFSubjectImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(subjectId);

			return (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the crf subjects before and after the current crf subject in the ordered set of crf subjects that the user has permission to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] filterFindByG_S_PrevAndNext(
			long crfSubjectId, long groupId, long subjectId,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				crfSubjectId, groupId, subjectId, orderByComparator);
		}

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, crfSubject, groupId, subjectId, orderByComparator,
				true);

			array[1] = crfSubject;

			array[2] = filterGetByG_S_PrevAndNext(
				session, crfSubject, groupId, subjectId, orderByComparator,
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

	protected CRFSubject filterGetByG_S_PrevAndNext(
		Session session, CRFSubject crfSubject, long groupId, long subjectId,
		OrderByComparator<CRFSubject> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_SUBJECTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFSubjectImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFSubjectImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(subjectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf subjects where groupId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 */
	@Override
	public void removeByG_S(long groupId, long subjectId) {
		for (CRFSubject crfSubject :
				findByG_S(
					groupId, subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(crfSubject);
		}
	}

	/**
	 * Returns the number of crf subjects where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf subjects
	 */
	@Override
	public int countByG_S(long groupId, long subjectId) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFSUBJECT_WHERE);

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

	/**
	 * Returns the number of crf subjects that the user has permission to view where groupId = &#63; and subjectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf subjects that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, long subjectId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, subjectId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_CRFSUBJECT_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_SUBJECTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"crfSubject.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_SUBJECTID_2 =
		"crfSubject.subjectId = ?";

	private FinderPath _finderPathFetchByC_S;
	private FinderPath _finderPathCountByC_S;

	/**
	 * Returns the crf subject where crfId = &#63; and subjectId = &#63; or throws a <code>NoSuchCRFSubjectException</code> if it could not be found.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByC_S(long crfId, long subjectId)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByC_S(crfId, subjectId);

		if (crfSubject == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("crfId=");
			sb.append(crfId);

			sb.append(", subjectId=");
			sb.append(subjectId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCRFSubjectException(sb.toString());
		}

		return crfSubject;
	}

	/**
	 * Returns the crf subject where crfId = &#63; and subjectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByC_S(long crfId, long subjectId) {
		return fetchByC_S(crfId, subjectId, true);
	}

	/**
	 * Returns the crf subject where crfId = &#63; and subjectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByC_S(
		long crfId, long subjectId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {crfId, subjectId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_S, finderArgs, this);
		}

		if (result instanceof CRFSubject) {
			CRFSubject crfSubject = (CRFSubject)result;

			if ((crfId != crfSubject.getCrfId()) ||
				(subjectId != crfSubject.getSubjectId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

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

				List<CRFSubject> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_S, finderArgs, list);
					}
				}
				else {
					CRFSubject crfSubject = list.get(0);

					result = crfSubject;

					cacheResult(crfSubject);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByC_S, finderArgs);
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
			return (CRFSubject)result;
		}
	}

	/**
	 * Removes the crf subject where crfId = &#63; and subjectId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the crf subject that was removed
	 */
	@Override
	public CRFSubject removeByC_S(long crfId, long subjectId)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = findByC_S(crfId, subjectId);

		return remove(crfSubject);
	}

	/**
	 * Returns the number of crf subjects where crfId = &#63; and subjectId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param subjectId the subject ID
	 * @return the number of matching crf subjects
	 */
	@Override
	public int countByC_S(long crfId, long subjectId) {
		FinderPath finderPath = _finderPathCountByC_S;

		Object[] finderArgs = new Object[] {crfId, subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CRFSUBJECT_WHERE);

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
		"crfSubject.crfId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_SUBJECTID_2 =
		"crfSubject.subjectId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_UL;
	private FinderPath _finderPathWithoutPaginationFindByG_C_UL;
	private FinderPath _finderPathCountByG_C_UL;

	/**
	 * Returns all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @return the matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		return findByG_C_UL(
			groupId, crfId, updateLock, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end) {

		return findByG_C_UL(groupId, crfId, updateLock, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		return findByG_C_UL(
			groupId, crfId, updateLock, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crf subjects
	 */
	@Override
	public List<CRFSubject> findByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_UL;
				finderArgs = new Object[] {groupId, crfId, updateLock};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_UL;
			finderArgs = new Object[] {
				groupId, crfId, updateLock, start, end, orderByComparator
			};
		}

		List<CRFSubject> list = null;

		if (useFinderCache) {
			list = (List<CRFSubject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CRFSubject crfSubject : list) {
					if ((groupId != crfSubject.getGroupId()) ||
						(crfId != crfSubject.getCrfId()) ||
						(updateLock != crfSubject.isUpdateLock())) {

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

			sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

			sb.append(_FINDER_COLUMN_G_C_UL_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_UL_CRFID_2);

			sb.append(_FINDER_COLUMN_G_C_UL_UPDATELOCK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				queryPos.add(updateLock);

				list = (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByG_C_UL_First(
			long groupId, long crfId, boolean updateLock,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByG_C_UL_First(
			groupId, crfId, updateLock, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append(", updateLock=");
		sb.append(updateLock);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the first crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByG_C_UL_First(
		long groupId, long crfId, boolean updateLock,
		OrderByComparator<CRFSubject> orderByComparator) {

		List<CRFSubject> list = findByG_C_UL(
			groupId, crfId, updateLock, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject
	 * @throws NoSuchCRFSubjectException if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject findByG_C_UL_Last(
			long groupId, long crfId, boolean updateLock,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByG_C_UL_Last(
			groupId, crfId, updateLock, orderByComparator);

		if (crfSubject != null) {
			return crfSubject;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", crfId=");
		sb.append(crfId);

		sb.append(", updateLock=");
		sb.append(updateLock);

		sb.append("}");

		throw new NoSuchCRFSubjectException(sb.toString());
	}

	/**
	 * Returns the last crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crf subject, or <code>null</code> if a matching crf subject could not be found
	 */
	@Override
	public CRFSubject fetchByG_C_UL_Last(
		long groupId, long crfId, boolean updateLock,
		OrderByComparator<CRFSubject> orderByComparator) {

		int count = countByG_C_UL(groupId, crfId, updateLock);

		if (count == 0) {
			return null;
		}

		List<CRFSubject> list = findByG_C_UL(
			groupId, crfId, updateLock, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the crf subjects before and after the current crf subject in the ordered set where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] findByG_C_UL_PrevAndNext(
			long crfSubjectId, long groupId, long crfId, boolean updateLock,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = getByG_C_UL_PrevAndNext(
				session, crfSubject, groupId, crfId, updateLock,
				orderByComparator, true);

			array[1] = crfSubject;

			array[2] = getByG_C_UL_PrevAndNext(
				session, crfSubject, groupId, crfId, updateLock,
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

	protected CRFSubject getByG_C_UL_PrevAndNext(
		Session session, CRFSubject crfSubject, long groupId, long crfId,
		boolean updateLock, OrderByComparator<CRFSubject> orderByComparator,
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

		sb.append(_SQL_SELECT_CRFSUBJECT_WHERE);

		sb.append(_FINDER_COLUMN_G_C_UL_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_UL_CRFID_2);

		sb.append(_FINDER_COLUMN_G_C_UL_UPDATELOCK_2);

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
			sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(crfId);

		queryPos.add(updateLock);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the crf subjects that the user has permission to view where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @return the matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		return filterFindByG_C_UL(
			groupId, crfId, updateLock, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the crf subjects that the user has permission to view where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end) {

		return filterFindByG_C_UL(groupId, crfId, updateLock, start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects that the user has permissions to view where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crf subjects that the user has permission to view
	 */
	@Override
	public List<CRFSubject> filterFindByG_C_UL(
		long groupId, long crfId, boolean updateLock, int start, int end,
		OrderByComparator<CRFSubject> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_UL(
				groupId, crfId, updateLock, start, end, orderByComparator);
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
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_C_UL_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_UL_CRFID_2);

		sb.append(_FINDER_COLUMN_G_C_UL_UPDATELOCK_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFSubjectImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFSubjectImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(crfId);

			queryPos.add(updateLock);

			return (List<CRFSubject>)QueryUtil.list(
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
	 * Returns the crf subjects before and after the current crf subject in the ordered set of crf subjects that the user has permission to view where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param crfSubjectId the primary key of the current crf subject
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject[] filterFindByG_C_UL_PrevAndNext(
			long crfSubjectId, long groupId, long crfId, boolean updateLock,
			OrderByComparator<CRFSubject> orderByComparator)
		throws NoSuchCRFSubjectException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_UL_PrevAndNext(
				crfSubjectId, groupId, crfId, updateLock, orderByComparator);
		}

		CRFSubject crfSubject = findByPrimaryKey(crfSubjectId);

		Session session = null;

		try {
			session = openSession();

			CRFSubject[] array = new CRFSubjectImpl[3];

			array[0] = filterGetByG_C_UL_PrevAndNext(
				session, crfSubject, groupId, crfId, updateLock,
				orderByComparator, true);

			array[1] = crfSubject;

			array[2] = filterGetByG_C_UL_PrevAndNext(
				session, crfSubject, groupId, crfId, updateLock,
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

	protected CRFSubject filterGetByG_C_UL_PrevAndNext(
		Session session, CRFSubject crfSubject, long groupId, long crfId,
		boolean updateLock, OrderByComparator<CRFSubject> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_C_UL_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_UL_CRFID_2);

		sb.append(_FINDER_COLUMN_G_C_UL_UPDATELOCK_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CRFSubjectModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CRFSubjectImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CRFSubjectImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(crfId);

		queryPos.add(updateLock);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crfSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CRFSubject> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 */
	@Override
	public void removeByG_C_UL(long groupId, long crfId, boolean updateLock) {
		for (CRFSubject crfSubject :
				findByG_C_UL(
					groupId, crfId, updateLock, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(crfSubject);
		}
	}

	/**
	 * Returns the number of crf subjects where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @return the number of matching crf subjects
	 */
	@Override
	public int countByG_C_UL(long groupId, long crfId, boolean updateLock) {
		FinderPath finderPath = _finderPathCountByG_C_UL;

		Object[] finderArgs = new Object[] {groupId, crfId, updateLock};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CRFSUBJECT_WHERE);

			sb.append(_FINDER_COLUMN_G_C_UL_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_UL_CRFID_2);

			sb.append(_FINDER_COLUMN_G_C_UL_UPDATELOCK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(crfId);

				queryPos.add(updateLock);

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
	 * Returns the number of crf subjects that the user has permission to view where groupId = &#63; and crfId = &#63; and updateLock = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param updateLock the update lock
	 * @return the number of matching crf subjects that the user has permission to view
	 */
	@Override
	public int filterCountByG_C_UL(
		long groupId, long crfId, boolean updateLock) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C_UL(groupId, crfId, updateLock);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_CRFSUBJECT_WHERE);

		sb.append(_FINDER_COLUMN_G_C_UL_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_UL_CRFID_2);

		sb.append(_FINDER_COLUMN_G_C_UL_UPDATELOCK_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), CRFSubject.class.getName(),
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

			queryPos.add(updateLock);

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

	private static final String _FINDER_COLUMN_G_C_UL_GROUPID_2 =
		"crfSubject.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_UL_CRFID_2 =
		"crfSubject.crfId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_UL_UPDATELOCK_2 =
		"crfSubject.updateLock = ?";

	public CRFSubjectPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CRFSubject.class);

		setModelImplClass(CRFSubjectImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the crf subject in the entity cache if it is enabled.
	 *
	 * @param crfSubject the crf subject
	 */
	@Override
	public void cacheResult(CRFSubject crfSubject) {
		entityCache.putResult(
			entityCacheEnabled, CRFSubjectImpl.class,
			crfSubject.getPrimaryKey(), crfSubject);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {crfSubject.getUuid(), crfSubject.getGroupId()},
			crfSubject);

		finderCache.putResult(
			_finderPathFetchByC_S,
			new Object[] {crfSubject.getCrfId(), crfSubject.getSubjectId()},
			crfSubject);

		crfSubject.resetOriginalValues();
	}

	/**
	 * Caches the crf subjects in the entity cache if it is enabled.
	 *
	 * @param crfSubjects the crf subjects
	 */
	@Override
	public void cacheResult(List<CRFSubject> crfSubjects) {
		for (CRFSubject crfSubject : crfSubjects) {
			if (entityCache.getResult(
					entityCacheEnabled, CRFSubjectImpl.class,
					crfSubject.getPrimaryKey()) == null) {

				cacheResult(crfSubject);
			}
			else {
				crfSubject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all crf subjects.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CRFSubjectImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the crf subject.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CRFSubject crfSubject) {
		entityCache.removeResult(
			entityCacheEnabled, CRFSubjectImpl.class,
			crfSubject.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CRFSubjectModelImpl)crfSubject, true);
	}

	@Override
	public void clearCache(List<CRFSubject> crfSubjects) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CRFSubject crfSubject : crfSubjects) {
			entityCache.removeResult(
				entityCacheEnabled, CRFSubjectImpl.class,
				crfSubject.getPrimaryKey());

			clearUniqueFindersCache((CRFSubjectModelImpl)crfSubject, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CRFSubjectImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CRFSubjectModelImpl crfSubjectModelImpl) {

		Object[] args = new Object[] {
			crfSubjectModelImpl.getUuid(), crfSubjectModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, crfSubjectModelImpl, false);

		args = new Object[] {
			crfSubjectModelImpl.getCrfId(), crfSubjectModelImpl.getSubjectId()
		};

		finderCache.putResult(
			_finderPathCountByC_S, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_S, args, crfSubjectModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CRFSubjectModelImpl crfSubjectModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfSubjectModelImpl.getUuid(), crfSubjectModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((crfSubjectModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfSubjectModelImpl.getOriginalUuid(),
				crfSubjectModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				crfSubjectModelImpl.getCrfId(),
				crfSubjectModelImpl.getSubjectId()
			};

			finderCache.removeResult(_finderPathCountByC_S, args);
			finderCache.removeResult(_finderPathFetchByC_S, args);
		}

		if ((crfSubjectModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_S.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				crfSubjectModelImpl.getOriginalCrfId(),
				crfSubjectModelImpl.getOriginalSubjectId()
			};

			finderCache.removeResult(_finderPathCountByC_S, args);
			finderCache.removeResult(_finderPathFetchByC_S, args);
		}
	}

	/**
	 * Creates a new crf subject with the primary key. Does not add the crf subject to the database.
	 *
	 * @param crfSubjectId the primary key for the new crf subject
	 * @return the new crf subject
	 */
	@Override
	public CRFSubject create(long crfSubjectId) {
		CRFSubject crfSubject = new CRFSubjectImpl();

		crfSubject.setNew(true);
		crfSubject.setPrimaryKey(crfSubjectId);

		String uuid = PortalUUIDUtil.generate();

		crfSubject.setUuid(uuid);

		crfSubject.setCompanyId(CompanyThreadLocal.getCompanyId());

		return crfSubject;
	}

	/**
	 * Removes the crf subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject that was removed
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject remove(long crfSubjectId)
		throws NoSuchCRFSubjectException {

		return remove((Serializable)crfSubjectId);
	}

	/**
	 * Removes the crf subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the crf subject
	 * @return the crf subject that was removed
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject remove(Serializable primaryKey)
		throws NoSuchCRFSubjectException {

		Session session = null;

		try {
			session = openSession();

			CRFSubject crfSubject = (CRFSubject)session.get(
				CRFSubjectImpl.class, primaryKey);

			if (crfSubject == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCRFSubjectException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(crfSubject);
		}
		catch (NoSuchCRFSubjectException noSuchEntityException) {
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
	protected CRFSubject removeImpl(CRFSubject crfSubject) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(crfSubject)) {
				crfSubject = (CRFSubject)session.get(
					CRFSubjectImpl.class, crfSubject.getPrimaryKeyObj());
			}

			if (crfSubject != null) {
				session.delete(crfSubject);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (crfSubject != null) {
			clearCache(crfSubject);
		}

		return crfSubject;
	}

	@Override
	public CRFSubject updateImpl(CRFSubject crfSubject) {
		boolean isNew = crfSubject.isNew();

		if (!(crfSubject instanceof CRFSubjectModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(crfSubject.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(crfSubject);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in crfSubject proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CRFSubject implementation " +
					crfSubject.getClass());
		}

		CRFSubjectModelImpl crfSubjectModelImpl =
			(CRFSubjectModelImpl)crfSubject;

		if (Validator.isNull(crfSubject.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			crfSubject.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (crfSubject.getCreateDate() == null)) {
			if (serviceContext == null) {
				crfSubject.setCreateDate(now);
			}
			else {
				crfSubject.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!crfSubjectModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				crfSubject.setModifiedDate(now);
			}
			else {
				crfSubject.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (crfSubject.isNew()) {
				session.save(crfSubject);

				crfSubject.setNew(false);
			}
			else {
				crfSubject = (CRFSubject)session.merge(crfSubject);
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
			Object[] args = new Object[] {crfSubjectModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				crfSubjectModelImpl.getUuid(),
				crfSubjectModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {crfSubjectModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				crfSubjectModelImpl.getGroupId(), crfSubjectModelImpl.getCrfId()
			};

			finderCache.removeResult(_finderPathCountByG_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C, args);

			args = new Object[] {
				crfSubjectModelImpl.getGroupId(),
				crfSubjectModelImpl.getSubjectId()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S, args);

			args = new Object[] {
				crfSubjectModelImpl.getGroupId(),
				crfSubjectModelImpl.getCrfId(),
				crfSubjectModelImpl.isUpdateLock()
			};

			finderCache.removeResult(_finderPathCountByG_C_UL, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_UL, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((crfSubjectModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfSubjectModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {crfSubjectModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((crfSubjectModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfSubjectModelImpl.getOriginalUuid(),
					crfSubjectModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					crfSubjectModelImpl.getUuid(),
					crfSubjectModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((crfSubjectModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					crfSubjectModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {crfSubjectModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((crfSubjectModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfSubjectModelImpl.getOriginalGroupId(),
					crfSubjectModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);

				args = new Object[] {
					crfSubjectModelImpl.getGroupId(),
					crfSubjectModelImpl.getCrfId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);
			}

			if ((crfSubjectModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfSubjectModelImpl.getOriginalGroupId(),
					crfSubjectModelImpl.getOriginalSubjectId()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);

				args = new Object[] {
					crfSubjectModelImpl.getGroupId(),
					crfSubjectModelImpl.getSubjectId()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);
			}

			if ((crfSubjectModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_UL.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crfSubjectModelImpl.getOriginalGroupId(),
					crfSubjectModelImpl.getOriginalCrfId(),
					crfSubjectModelImpl.getOriginalUpdateLock()
				};

				finderCache.removeResult(_finderPathCountByG_C_UL, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_UL, args);

				args = new Object[] {
					crfSubjectModelImpl.getGroupId(),
					crfSubjectModelImpl.getCrfId(),
					crfSubjectModelImpl.isUpdateLock()
				};

				finderCache.removeResult(_finderPathCountByG_C_UL, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_UL, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CRFSubjectImpl.class,
			crfSubject.getPrimaryKey(), crfSubject, false);

		clearUniqueFindersCache(crfSubjectModelImpl, false);
		cacheUniqueFindersCache(crfSubjectModelImpl);

		crfSubject.resetOriginalValues();

		return crfSubject;
	}

	/**
	 * Returns the crf subject with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the crf subject
	 * @return the crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCRFSubjectException {

		CRFSubject crfSubject = fetchByPrimaryKey(primaryKey);

		if (crfSubject == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCRFSubjectException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return crfSubject;
	}

	/**
	 * Returns the crf subject with the primary key or throws a <code>NoSuchCRFSubjectException</code> if it could not be found.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject
	 * @throws NoSuchCRFSubjectException if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject findByPrimaryKey(long crfSubjectId)
		throws NoSuchCRFSubjectException {

		return findByPrimaryKey((Serializable)crfSubjectId);
	}

	/**
	 * Returns the crf subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crfSubjectId the primary key of the crf subject
	 * @return the crf subject, or <code>null</code> if a crf subject with the primary key could not be found
	 */
	@Override
	public CRFSubject fetchByPrimaryKey(long crfSubjectId) {
		return fetchByPrimaryKey((Serializable)crfSubjectId);
	}

	/**
	 * Returns all the crf subjects.
	 *
	 * @return the crf subjects
	 */
	@Override
	public List<CRFSubject> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the crf subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @return the range of crf subjects
	 */
	@Override
	public List<CRFSubject> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the crf subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crf subjects
	 */
	@Override
	public List<CRFSubject> findAll(
		int start, int end, OrderByComparator<CRFSubject> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the crf subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CRFSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crf subjects
	 * @param end the upper bound of the range of crf subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crf subjects
	 */
	@Override
	public List<CRFSubject> findAll(
		int start, int end, OrderByComparator<CRFSubject> orderByComparator,
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

		List<CRFSubject> list = null;

		if (useFinderCache) {
			list = (List<CRFSubject>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CRFSUBJECT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CRFSUBJECT;

				sql = sql.concat(CRFSubjectModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CRFSubject>)QueryUtil.list(
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
	 * Removes all the crf subjects from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CRFSubject crfSubject : findAll()) {
			remove(crfSubject);
		}
	}

	/**
	 * Returns the number of crf subjects.
	 *
	 * @return the number of crf subjects
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CRFSUBJECT);

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
		return "crfSubjectId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CRFSUBJECT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CRFSubjectModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the crf subject persistence.
	 */
	@Activate
	public void activate() {
		CRFSubjectModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CRFSubjectModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CRFSubjectModelImpl.UUID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CRFID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFSubjectModelImpl.UUID_COLUMN_BITMASK |
			CRFSubjectModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CRFSubjectModelImpl.UUID_COLUMN_BITMASK |
			CRFSubjectModelImpl.COMPANYID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CRFID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			CRFSubjectModelImpl.GROUPID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CRFID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFSubjectModelImpl.GROUPID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CRFID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFSubjectModelImpl.GROUPID_COLUMN_BITMASK |
			CRFSubjectModelImpl.SUBJECTID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CRFID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_S",
			new String[] {Long.class.getName(), Long.class.getName()},
			CRFSubjectModelImpl.CRFID_COLUMN_BITMASK |
			CRFSubjectModelImpl.SUBJECTID_COLUMN_BITMASK);

		_finderPathCountByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_C_UL = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_UL",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_UL = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CRFSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_UL",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			CRFSubjectModelImpl.GROUPID_COLUMN_BITMASK |
			CRFSubjectModelImpl.CRFID_COLUMN_BITMASK |
			CRFSubjectModelImpl.UPDATELOCK_COLUMN_BITMASK |
			CRFSubjectModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByG_C_UL = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_UL",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CRFSubjectImpl.class.getName());
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
				"value.object.column.bitmask.enabled.ecrf.user.model.CRFSubject"),
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

	private static final String _SQL_SELECT_CRFSUBJECT =
		"SELECT crfSubject FROM CRFSubject crfSubject";

	private static final String _SQL_SELECT_CRFSUBJECT_WHERE =
		"SELECT crfSubject FROM CRFSubject crfSubject WHERE ";

	private static final String _SQL_COUNT_CRFSUBJECT =
		"SELECT COUNT(crfSubject) FROM CRFSubject crfSubject";

	private static final String _SQL_COUNT_CRFSUBJECT_WHERE =
		"SELECT COUNT(crfSubject) FROM CRFSubject crfSubject WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"crfSubject.crfSubjectId";

	private static final String _FILTER_SQL_SELECT_CRFSUBJECT_WHERE =
		"SELECT DISTINCT {crfSubject.*} FROM EC_CRFSubject crfSubject WHERE ";

	private static final String
		_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {EC_CRFSubject.*} FROM (SELECT DISTINCT crfSubject.crfSubjectId FROM EC_CRFSubject crfSubject WHERE ";

	private static final String
		_FILTER_SQL_SELECT_CRFSUBJECT_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN EC_CRFSubject ON TEMP_TABLE.crfSubjectId = EC_CRFSubject.crfSubjectId";

	private static final String _FILTER_SQL_COUNT_CRFSUBJECT_WHERE =
		"SELECT COUNT(DISTINCT crfSubject.crfSubjectId) AS COUNT_VALUE FROM EC_CRFSubject crfSubject WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "crfSubject";

	private static final String _FILTER_ENTITY_TABLE = "EC_CRFSubject";

	private static final String _ORDER_BY_ENTITY_ALIAS = "crfSubject.";

	private static final String _ORDER_BY_ENTITY_TABLE = "EC_CRFSubject.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CRFSubject exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CRFSubject exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CRFSubjectPersistenceImpl.class);

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