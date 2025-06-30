package ecrf.user.constants;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;

import ecrf.user.constants.attribute.ECRFUserCRFResearcherInfoAttribute;
import ecrf.user.constants.attribute.ECRFUserCRFSubjectInfoAttribute;
import ecrf.user.model.CRFResearcher;
import ecrf.user.model.CRFSubject;
import ecrf.user.model.custom.CRFSubjectInfo;
import ecrf.user.service.CRFResearcherLocalServiceUtil;
import ecrf.user.service.CRFSubjectLocalServiceUtil;

public class ECRFUserUtil {
	public static boolean isLong(String strNum) {
		if(strNum == null) {
			return false;
		}
		
		try {
			long l = Long.parseLong(strNum);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	public static String getDateStr(Date date) {
		String dateStr = "";
		
		if(Validator.isNotNull(date)) {
			String year = StringPool.BLANK + (date.getYear() + 1900);
			String mon = String.format("%02d", date.getMonth()+1);
			String day = String.format("%02d", date.getDate());
			
			dateStr = year + "/" + mon + "/" + day;
		}
				
		return dateStr;
	}
	
	public static String getGenderStr(int gender) {
		String genderStr = "-";
		
		if(gender == 0) {
			genderStr = "ecrf-user.general.male";
		} else if(gender == 1) {
			genderStr = "ecrf-user.general.female";
		}
		
		return genderStr;
	}
	
	public static String highlightText(String origin, String pattern) {
		return origin.replaceAll("(?i)"+pattern, "<mark>$0</mark>");
	}
	
	public static String capitalize(String str) {
		if(nullCheck(str)) {
	        return str;
	    }

	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	public static String anonymousName(String name) {
		if(nullCheck(name)) {
			return name;
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(name.charAt(0));
		builder.append('*');
		if(name.length() > 2) builder.append(name.subSequence(2, name.length()));
		
		return builder.toString();
	}
	
	public static String encryptName(String name) {
		if(nullCheck(name)) {
			return name;
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<name.length(); i++)
			builder.append("*");
		
		return builder.toString();
	}
	
	public static boolean nullCheck(String str) {
		return str == null || str.isEmpty(); 
	}
	
	public static ArrayList<CRFSubjectInfo> toCRFSubjectInfoList(JSONArray array) {
		ArrayList<CRFSubjectInfo> crfSubjectInfoList = new ArrayList<CRFSubjectInfo>();
		
		for(int i=0; i<array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			CRFSubjectInfo info = new CRFSubjectInfo();
			
			info.setGroupId(obj.getLong(ECRFUserCRFSubjectInfoAttribute.GROUP_ID));
			info.setCrfId(obj.getLong(ECRFUserCRFSubjectInfoAttribute.CRF_ID));
			info.setCrfName(obj.getString(ECRFUserCRFSubjectInfoAttribute.CRF_NAME));
			info.setCrfStatus(obj.getInt(ECRFUserCRFSubjectInfoAttribute.CRF_STATUS));
			
			info.setSubjectId(obj.getLong(ECRFUserCRFSubjectInfoAttribute.SUBJECT_ID));
			info.setSubjectName(obj.getString(ECRFUserCRFSubjectInfoAttribute.SUBJECT_NAME));
			info.setSubjectBirth(new Date(obj.getLong(ECRFUserCRFSubjectInfoAttribute.SUBJECT_BIRTH)));
			info.setSubjectGender(obj.getInt(ECRFUserCRFSubjectInfoAttribute.SUBJECT_GENDER));
			
			info.setParticipationStatus(obj.getInt(ECRFUserCRFSubjectInfoAttribute.PARTICIPATION_STATUS));
			info.setParticipationStartDate(new Date(obj.getLong(ECRFUserCRFSubjectInfoAttribute.PARTICIPATION_START_DATE)));
			info.setUpdateLock(obj.getBoolean(ECRFUserCRFSubjectInfoAttribute.UPDATE_LOCK));
			
			crfSubjectInfoList.add(info);
		}
		
		return crfSubjectInfoList;
	}
	
	public static ArrayList<CRFSubject> toCRFSubjectList(JSONArray array) {
		ArrayList<CRFSubject> crfSubjectList = new ArrayList<CRFSubject>();
		
		for(int i=0; i<array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			CRFSubject crfSubject = CRFSubjectLocalServiceUtil.createCRFSubject(0);
			
			crfSubject.setGroupId(obj.getLong(ECRFUserCRFSubjectInfoAttribute.GROUP_ID));
			
			crfSubject.setCrfId(obj.getLong(ECRFUserCRFSubjectInfoAttribute.CRF_ID));
			crfSubject.setSubjectId(obj.getLong(ECRFUserCRFSubjectInfoAttribute.SUBJECT_ID));
			
			crfSubject.setParticipationStatus(obj.getInt(ECRFUserCRFSubjectInfoAttribute.PARTICIPATION_STATUS));
			crfSubject.setParticipationStartDate(new Date(obj.getLong(ECRFUserCRFSubjectInfoAttribute.PARTICIPATION_START_DATE)));
			crfSubject.setUpdateLock(obj.getBoolean(ECRFUserCRFSubjectInfoAttribute.UPDATE_LOCK));
			
			crfSubjectList.add(crfSubject);
		}
		
		return crfSubjectList;
	}
	
	public static ArrayList<CRFResearcher> toCRFResearcherList(JSONArray array) {
		ArrayList<CRFResearcher> crfResearcherList = new ArrayList<CRFResearcher>();
		
		for(int i=0; i<array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			CRFResearcher crfResearcher = CRFResearcherLocalServiceUtil.createCRFResearcher(0);
			
			crfResearcher.setGroupId(obj.getLong(ECRFUserCRFResearcherInfoAttribute.GROUP_ID));
			
			crfResearcher.setCrfId(obj.getLong(ECRFUserCRFSubjectInfoAttribute.CRF_ID));
			crfResearcher.setResearcherId(obj.getLong(ECRFUserCRFResearcherInfoAttribute.RESEARCHER_ID));
			crfResearcher.setJobTitle("researcher");
			
			crfResearcherList.add(crfResearcher);
		}
		
		return crfResearcherList;
	}
	
	public static long[] getSubjectIdFromCRFSubject(ArrayList<CRFSubject> crfSubjectList) {
		long[] subjectIds = null;
		int crfSubjectListSize = crfSubjectList.size(); 
		if(crfSubjectListSize > 0) {
			subjectIds = new long[crfSubjectListSize];
			
			for(int i=0; i < crfSubjectListSize; i++) {
				CRFSubject crfSubject = crfSubjectList.get(i); 
				subjectIds[i] = crfSubject.getSubjectId();
			}
		}
		return subjectIds;
	}
	
	public static String randomizedString(int length, String code) {
		String mask = "";
		
		if (code.indexOf('a') > -1) mask += "abcdefghijklmnopqrstuvwxyz";
        if (code.indexOf('A') > -1) mask += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (code.indexOf('1') > -1) mask += "0123456789";
        
		String result = "";
		
		for (int i = length; i > 0; --i){
            result += mask.charAt((int)Math.floor(Math.random() * mask.length()));
        } 
        return result;
	}
	
	public static String getLogMsg(String msg, String del, Object... var) {
		String log = msg;
		
		for(Object obj : var) {
			log += obj.toString();
			log += del;
		}
		
		return log;
	}
}
