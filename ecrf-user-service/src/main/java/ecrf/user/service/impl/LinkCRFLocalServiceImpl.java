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
import com.liferay.portal.kernel.util.Validator;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.StructuredDataLocalService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.exception.NoSuchLinkCRFException;
import ecrf.user.model.CRFAutoquery;
import ecrf.user.model.CRFHistory;
import ecrf.user.model.LinkCRF;
import ecrf.user.service.CRFAutoqueryLocalService;
import ecrf.user.service.CRFHistoryLocalService;
import ecrf.user.service.base.LinkCRFLocalServiceBaseImpl;

/**
 * @author Ryu W.C.
 */
@Component(
	property = "model.class.name=ecrf.user.model.LinkCRF",
	service = AopService.class
)
public class LinkCRFLocalServiceImpl extends LinkCRFLocalServiceBaseImpl {
	private Log _log = LogFactoryUtil.getLog(LinkCRFLocalServiceImpl.class);
	
	public LinkCRF addLinkCRF(
			long subjectId,
			long crfId,
			long structuredDataId,
			ServiceContext sc) throws PortalException{
		
		long linkId = super.counterLocalService.increment();
		LinkCRF linkCRF = super.linkCRFLocalService.createLinkCRF(linkId);

		long userId = sc.getUserId();
		User user = super.userLocalService.getUser(userId);
		long groupId = sc.getScopeGroupId();
		long companyId = sc.getCompanyId();
		
		Date now = new Date();
		
		linkCRF.setSubjectId(subjectId);
		linkCRF.setCrfId(crfId);
		linkCRF.setStructuredDataId(structuredDataId);
		
		linkCRF.setCompanyId(companyId);
		linkCRF.setGroupId(groupId);
		linkCRF.setUserId(userId);
		linkCRF.setUserName(user.getFullName());
		linkCRF.setCreateDate(now);
		linkCRF.setModifiedDate(now);
		
		linkCRF.setExpandoBridgeAttributes(sc);
		
		super.linkCRFPersistence.update(linkCRF);
		
		resourceLocalService.addResources(
			companyId, groupId, userId, 
			LinkCRF.class.getName(), linkCRF.getLinkId(), 
			false, true, true);
		
		return linkCRF;
	}
	
	public LinkCRF updateLinkCRF(
			long linkId,
			long subjectId,
			long crfId,
			long structuredDataId,
			ServiceContext sc) throws PortalException{

		LinkCRF linkCRF = super.linkCRFPersistence.findByPrimaryKey(linkId);
		
		Date now = new Date();
		
		linkCRF.setSubjectId(subjectId);
		
		linkCRF.setCrfId(crfId);		
		linkCRF.setStructuredDataId(structuredDataId);

		linkCRF.setModifiedDate(now);
		
		linkCRF.setExpandoBridgeAttributes(sc);
		
		super.linkCRFPersistence.update(linkCRF);
		
		return linkCRF;
	}
	
	public LinkCRF deleteLinkCRF(long linkId) throws PortalException {
		LinkCRF linkCRF = super.linkCRFPersistence.remove(linkId);
		
		_dataTypeLocalService.removeStructuredData(linkCRF.getStructuredDataId(), 0);
		
		// remove crf-query
		List<CRFAutoquery> crfAutoQueryList = _crfAutoQueryLocalService.getQueryByG_C_S(linkCRF.getGroupId(), linkCRF.getCrfId(), linkCRF.getSubjectId());
		for(CRFAutoquery query : crfAutoQueryList) {
			_crfAutoQueryLocalService.deleteCRFAutoquery(query.getAutoQueryId());
		}
		
		// remove crf-history
		List<CRFHistory> historyList = _crfHistoryLocalService.getCRFHistoryByG_C_S(linkCRF.getGroupId(), linkCRF.getCrfId(), linkCRF.getSubjectId());
		for(CRFHistory history : historyList) {
			_crfHistoryLocalService.deleteCRFHistory(history.getHistoryId());
		}
		
		resourceLocalService.deleteResource(
			linkCRF.getCompanyId(), LinkCRF.class.getName(), 
			ResourceConstants.SCOPE_INDIVIDUAL, linkCRF.getLinkId());
		
		return linkCRF;
	}
	
	public void deleteLinkCRFs(long[] linkIds) throws PortalException {
		for(long linkId : linkIds) {
			this.deleteLinkCRF(linkId);
		}
	}
	
	public List<LinkCRF> getAllLinkCRF(){
		return super.linkCRFPersistence.findAll();
	}
	public List<LinkCRF> getAllLinkCRF(int start, int end){
		return super.linkCRFPersistence.findAll(start, end);
	}
	public List<LinkCRF> getAllLinkCRF(int start, int end, OrderByComparator<LinkCRF> comparator){
		return super.linkCRFPersistence.findAll(start, end, comparator);
	}
	public int countAllLinkCRF(){
		return super.linkCRFPersistence.countAll();
	}
	
	public List<LinkCRF> getLinkCRFByGroupId(long groupId){
		return super.linkCRFPersistence.findByGroupId(groupId);
	}
	public List<LinkCRF> getLinkCRFByGroupId(long groupId, int start, int end){
		return super.linkCRFPersistence.findByGroupId(groupId, start, end);
	}
	public List<LinkCRF> getLinkCRFByGroupId(long groupId, int start, int end, OrderByComparator<LinkCRF> comparator){
		return super.linkCRFPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int countLinkCRFByGroupId(long groupId) {
		return super.linkCRFPersistence.countByGroupId(groupId);
	}
	
	public List<LinkCRF> getLinkCRFByG_C(long groupId, long crfId) {
		return super.linkCRFPersistence.findByG_C(groupId, crfId);
	}
	public List<LinkCRF> getLinkCRFByG_C(long groupId, long crfId, int start, int end) {
		return super.linkCRFPersistence.findByG_C(groupId, crfId, start, end);
	}
	public List<LinkCRF> getLinkCRFByG_C(long groupId, long crfId, int start, int end, OrderByComparator<LinkCRF> comparator) {
		return super.linkCRFPersistence.findByG_C(groupId, crfId, start, end, comparator);
	}
	public int countLinkCRFByG_C(long groupId, long crfId) {
		return super.linkCRFPersistence.countByG_C(groupId, crfId);
	}
	
	public int countLinkBySubjectId(long subjectId){
		return super.linkCRFPersistence.countBySubjectId(subjectId);
	}
	public List<LinkCRF> getLinkCRFBySubjectId(long subjectId){
		return super.linkCRFPersistence.findBySubjectId(subjectId);
	}
	public List<LinkCRF> getLinkCRFBySubjectId(long subjectId, int start, int end){
		return super.linkCRFPersistence.findBySubjectId(subjectId, start, end);
	}
	public List<LinkCRF> getLinkCRFBySubjectId(long subjectId, int start, int end, OrderByComparator<LinkCRF> comparator){
		return super.linkCRFPersistence.findBySubjectId(subjectId, start, end, comparator);
	}
	
	public LinkCRF getLinkCRFByStructuredDataId(long structuredDataId) {
		return super.linkCRFPersistence.fetchByStructuredDataId(structuredDataId);
	}
	public int countLinkByStructuredDataId(long structuredDataId){
		LinkCRF link = super.linkCRFPersistence.fetchByStructuredDataId(structuredDataId);
		if(Validator.isNull(link)) return 0;
		else return 1; 
	}
	
	public List<LinkCRF> getLinkCRFByG_S(long groupId, long subjectId) {
		return super.linkCRFPersistence.findByG_S(groupId, subjectId);
	}
	public List<LinkCRF> getLinkCRFByG_S(long groupId, long subjectId, int start, int end) {
		return super.linkCRFPersistence.findByG_S(groupId, subjectId, start, end);
	}
	public List<LinkCRF> getLinkCRFByG_S(long groupId, long subjectId, int start, int end, OrderByComparator<LinkCRF> comparator) {
		return super.linkCRFPersistence.findByG_S(groupId, subjectId, start, end, comparator);
	}
	public int countLinkCRFByG_S(long groupId, long subjectId) {
		return super.linkCRFPersistence.countByG_S(groupId, subjectId);
	}
	
	public List<LinkCRF> getLinkCRFByG_S_C(long groupId, long subjectId, long crfId) {
		return super.linkCRFPersistence.findByG_S_C(groupId, subjectId, crfId);
	}
	public List<LinkCRF> getLinkCRFByG_S_C(long groupId, long subjectId, long crfId, int start, int end) {
		return super.linkCRFPersistence.findByG_S_C(groupId, subjectId, crfId, start, end);
	}
	public List<LinkCRF> getLinkCRFByG_S_C(long groupId, long subjectId, long crfId, int start, int end, OrderByComparator<LinkCRF> comparator) {
		return super.linkCRFPersistence.findByG_S_C(groupId, subjectId, crfId, start, end, comparator);
	}
	public int countLinkCRFByG_S_C(long groupId, long subjectId, long crfId) {
		return super.linkCRFPersistence.countByG_S_C(groupId, subjectId, crfId);
	}
	
	public LinkCRF getLinkCRFByG_S_C_SD(long groupId, long subjectId, long crfId, long structuredDataId) throws NoSuchLinkCRFException {
		return super.linkCRFPersistence.findByG_S_C_SD(groupId, subjectId, crfId, structuredDataId);
	}
	
	public LinkCRF getLinkCRFByC_S_SD(long crfId, long subjectId, long structuredDataId) throws NoSuchLinkCRFException {
		return super.linkCRFPersistence.findByC_S_SD(crfId, subjectId, structuredDataId);
	}
	
	public List<LinkCRF> getLinkCRFByC_S(long crfId, long subjectId) {
		return super.linkCRFPersistence.findByC_S(crfId, subjectId);
	}
	
	@Reference
	private CRFAutoqueryLocalService _crfAutoQueryLocalService;
	
	@Reference
	private CRFHistoryLocalService _crfHistoryLocalService;
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	private StructuredDataLocalService _sdLocalService;
}