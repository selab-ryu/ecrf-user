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

package ecrf.user.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import ecrf.user.model.CRFHistory;
import ecrf.user.service.base.CRFHistoryLocalServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = "model.class.name=ecrf.user.model.CRFHistory",
	service = AopService.class
)
public class CRFHistoryLocalServiceImpl extends CRFHistoryLocalServiceBaseImpl {
	private Log _log = LogFactoryUtil.getLog(CRFHistoryLocalServiceImpl.class);
	
	public CRFHistory addCRFHistory(
			String subjectName,
			long subjectId,
			String serialId,
			long structuredDataId,
			long crfId,
			String previousJSON,
			String currentJSON,
			int actionType,
			String historyVersion,
			ServiceContext sc) throws PortalException{
		_log.info("Start add History");
		long historyId = super.counterLocalService.increment();
		CRFHistory crfHistory = super.crfHistoryPersistence.create(historyId);
		
		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		long companyId = sc.getCompanyId();
		
		Date now = new Date();
		
		crfHistory.setSubjectName(subjectName);
		crfHistory.setSubjectId(subjectId);
		crfHistory.setSerialId(serialId);
		crfHistory.setStructuredDataId(structuredDataId);
		crfHistory.setCrfId(crfId);
		crfHistory.setPreviousJSON(previousJSON);
		crfHistory.setCurrentJSON(currentJSON);
		crfHistory.setActionType(actionType);
		crfHistory.setHistoryVersion(historyVersion);
		crfHistory.setPreviousHistoryVersion(historyVersion);
		
		crfHistory.setCompanyId(companyId);
		crfHistory.setGroupId(groupId);
		crfHistory.setUserId(userId);
		crfHistory.setUserName(user.getFullName());
		crfHistory.setCreateDate(now);
		crfHistory.setModifiedDate(now);
		
		crfHistory.setStatus(WorkflowConstants.STATUS_APPROVED);
		crfHistory.setStatusByUserId(userId);
		crfHistory.setStatusByUserName(user.getFullName());
		crfHistory.setStatusDate(now);
		
		crfHistory.setExpandoBridgeAttributes(sc);
		super.crfHistoryPersistence.update(crfHistory);
		
		resourceLocalService.addResources(
			companyId, groupId, userId,
			CRFHistory.class.getName(), crfHistory.getHistoryId(), 
			false, true, true);
		
		_log.info("End add History");

		return crfHistory;		
	}
	
	public CRFHistory updateCRFHistory(
			long historyId,
			String subjectName,
			long subjectId,
			String serialId,
			long structuredDataId,
			long crfId,
			String previousJSON,
			String currentJSON,
			int actionType,
			String historyVersion,
			String previousVersion,
			ServiceContext sc) throws PortalException{
		_log.info("Start update History");

		CRFHistory crfHistory = super.crfHistoryPersistence.findByPrimaryKey(historyId);
		
		Date now = new Date();
		
		crfHistory.setSubjectName(subjectName);
		crfHistory.setSubjectId(subjectId);
		crfHistory.setSerialId(serialId);
		crfHistory.setStructuredDataId(structuredDataId);
		crfHistory.setCrfId(crfId);
		crfHistory.setPreviousJSON(previousJSON);
		crfHistory.setCurrentJSON(currentJSON);
		crfHistory.setActionType(actionType);
		crfHistory.setPreviousHistoryVersion(previousVersion);
		crfHistory.setHistoryVersion(historyVersion);
		
		crfHistory.setModifiedDate(now);
		
		crfHistory.setExpandoBridgeAttributes(sc);
		super.crfHistoryPersistence.update(crfHistory);
		
		_log.info("End update History");

		return crfHistory;		
	}
	
	public CRFHistory deleteCRFHistory(long historyId) throws PortalException {
		CRFHistory crfHistory = super.crfHistoryPersistence.remove(historyId);
		
		resourceLocalService.deleteResource(
			crfHistory.getCompanyId(), CRFHistory.class.getName(), 
			ResourceConstants.SCOPE_INDIVIDUAL, crfHistory.getHistoryId());
		
		return crfHistory;
	}
	
	public void deleteCRFHistorys(long[] historyIds) throws PortalException {
		for(long historyId : historyIds)
			this.deleteCRFHistory(historyId);
	}
	
	public List<CRFHistory> getAllCRFHistory(){
		return super.crfHistoryPersistence.findAll();
	}
	public List<CRFHistory> getAllCRFHistory(int start, int end){
		return super.crfHistoryPersistence.findAll(start, end);
	}
	public List<CRFHistory> getAllCRFHistory(int start, int end, OrderByComparator<CRFHistory> comparator){
		return super.crfHistoryPersistence.findAll(start, end, comparator);
	}
	public int countAllCRFHistory(){
		return super.crfHistoryPersistence.countAll();
	}
	
	public List<CRFHistory> getCRFHistoryByGroupId(long groupId){
		return super.crfHistoryPersistence.findByGroupId(groupId);
	}
	public List<CRFHistory> getCRFHistoryByGroupId(long groupId, int start, int end){
		return super.crfHistoryPersistence.findByGroupId(groupId, start, end);
	}
	public List<CRFHistory> getCRFHistoryByGroupId(long groupId, int start, int end, OrderByComparator<CRFHistory> comparator){
		return super.crfHistoryPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int countCRFHistoryByGroupId(long groupId){
		return super.crfHistoryPersistence.countByGroupId(groupId);
	}
	
	public List<CRFHistory> getCRFHistoryByHistoryId(long historyId){
		return super.crfHistoryPersistence.findByHistoryId(historyId);
	}
	public List<CRFHistory> getCRFHistoryByHistoryId(long historyId, int start, int end){
		return super.crfHistoryPersistence.findByHistoryId(historyId, start, end);
	}
	public List<CRFHistory> getCRFHistoryByHistoryId(long historyId, int start, int end, OrderByComparator<CRFHistory> comparator){
		return super.crfHistoryPersistence.findByHistoryId(historyId, start, end, comparator);
	}
	public int countCRFHistoryByHistoryId(long historyId){
		return super.crfHistoryPersistence.countByHistoryId(historyId);
	}
	
	public List<CRFHistory> getCRFHistoryBySubjectId(long subjectId){
		return super.crfHistoryPersistence.findBySubjectId(subjectId);
	}
	public List<CRFHistory> getCRFHistoryBySubjectId(long subjectId, int start, int end){
		return super.crfHistoryPersistence.findBySubjectId(subjectId, start, end);
	}
	public List<CRFHistory> getCRFHistoryBySubjectId(long subjectId, int start, int end, OrderByComparator<CRFHistory> comparator){
		return super.crfHistoryPersistence.findBySubjectId(subjectId, start, end, comparator);
	}
	public int countCRFHistoryBySubjectId(long subjectId){
		return super.crfHistoryPersistence.countBySubjectId(subjectId);
	}
	
	public List<CRFHistory> getCRFHistoryByG_C(long groupId, long crfId) {
		return super.crfHistoryPersistence.findByG_C(groupId, crfId);
	}
	
	public List<CRFHistory> getCRFHistoryByG_S_C(long groupId, long subjectId, long crfId) {
		return super.crfHistoryPersistence.findByG_S_C(groupId, subjectId, crfId);
	}
	public List<CRFHistory> getCRFHistoryByG_S_C(long groupId, long subjectId, long crfId, int start, int end) {
		return super.crfHistoryPersistence.findByG_S_C(groupId, subjectId, crfId, start, end);
	}
	public List<CRFHistory> getCRFHistoryByG_S_C(long groupId, long subjectId, long crfId, int start, int end, OrderByComparator<CRFHistory> comparator) {
		return super.crfHistoryPersistence.findByG_S_C(groupId, subjectId, crfId, start, end, comparator);
	}
	public int countCRFHistoryByG_S_C(long groupId, long subjectId, long crfId) {
		return super.crfHistoryPersistence.countByG_S_C(groupId, subjectId, crfId);
	}
	
	public List<CRFHistory> getCRFHistoryByG_S_C_SD(long groupId, long subjectId, long crfId, long structuredDataId) {
		return super.crfHistoryPersistence.findByG_S_C_SD(groupId, subjectId, crfId, structuredDataId);
	}
	public List<CRFHistory> getCRFHistoryByG_S_C_SD(long groupId, long subjectId, long crfId, long structuredDataId, int start, int end) {
		return super.crfHistoryPersistence.findByG_S_C_SD(groupId, subjectId, crfId, structuredDataId, start, end);
	}
	public List<CRFHistory> getCRFHistoryByG_S_C_SD(long groupId, long subjectId, long crfId, long structuredDataId, int start, int end, OrderByComparator<CRFHistory> comparator) {
		return super.crfHistoryPersistence.findByG_S_C_SD(groupId, subjectId, crfId, structuredDataId, start, end, comparator);
	}
	public int countCRFHistoryByG_S_C_SD(long groupId, long subjectId, long crfId, long structuredDataId) {
		return super.crfHistoryPersistence.countByG_S_C_SD(groupId, subjectId, crfId, structuredDataId);
	}
	
	public List<CRFHistory> getCRFHistoryByC_S(long crfId, long subjectId) {
		return super.crfHistoryPersistence.findByC_S(crfId, subjectId);
	}
}