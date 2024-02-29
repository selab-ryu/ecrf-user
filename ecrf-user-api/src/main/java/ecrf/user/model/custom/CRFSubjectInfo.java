package ecrf.user.model.custom;

import java.util.Date;

public class CRFSubjectInfo {
	private long crfSubjectId;
	private long groupId;
	
	private long crfId;
	private String crfName;
	private int crfStatus;
	
	private long subjectId;
	private String subjectName;
	private String serialId;
	private Date subjectBirth;
	private int subjectGender;
	
	private int participationStatus;
	private Date participationStartDate;
	private String experimentalGroup;
	
	public CRFSubjectInfo() {
		
	}
	
	public CRFSubjectInfo(long crfSubjectId, long crfId, long subjectId) {
		this.crfSubjectId = crfSubjectId;
		this.crfId = crfId;
		this.subjectId = subjectId;
	}
	
	public CRFSubjectInfo(long crfSubjectId, long groupId, long crfId, String crfName, int crfStatus,
			long subjectId, String subjectName, String serialId, Date subjectBirth, int subjectGender,
			int participationStatus, Date participationStartDate, String experimentalGroup) {
		super();
		this.crfSubjectId = crfSubjectId;
		this.groupId = groupId;
		this.crfId = crfId;
		this.crfName = crfName;
		this.crfStatus = crfStatus;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.serialId = serialId;
		this.subjectBirth = subjectBirth;
		this.subjectGender = subjectGender;
		this.participationStatus = participationStatus;
		this.participationStartDate = participationStartDate;
		this.experimentalGroup = experimentalGroup;
	}
		
	@Override
	public String toString() {
		String str = String.format("{ crfSubjectId : %s, groupId : %s, "
				+ "crfId : %s, crfName : %s, crfStatus : %s, "
				+ "subjectId : %s, subjectName : %s, serialId : %s, subjectBirth : %s, subjectGender : %s, "
				+ "ppStatus : %s, ppStartDate : %s, expGroup : %s } ", 
				String.valueOf(crfSubjectId), String.valueOf(groupId),
				String.valueOf(crfId), String.valueOf(crfName), String.valueOf(crfStatus),
				String.valueOf(subjectId), String.valueOf(subjectName), String.valueOf(serialId), String.valueOf(subjectBirth), String.valueOf(subjectGender),
				String.valueOf(participationStatus), String.valueOf(participationStartDate), String.valueOf(experimentalGroup));
		
		return str;
	}

	public long getCrfSubjectId() {
		return crfSubjectId;
	}
	public void setCrfSubjectId(long crfSubjectId) {
		this.crfSubjectId = crfSubjectId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCrfId() {
		return crfId;
	}
	public void setCrfId(long crfId) {
		this.crfId = crfId;
	}
	public String getCrfName() {
		return crfName;
	}
	public void setCrfName(String crfName) {
		this.crfName = crfName;
	}
	public int getCrfStatus() {
		return crfStatus;
	}
	public void setCrfStatus(int crfStatus) {
		this.crfStatus = crfStatus;
	}
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public Date getSubjectBirth() {
		return subjectBirth;
	}
	public void setSubjectBirth(Date subjectBirth) {
		this.subjectBirth = subjectBirth;
	}
	public int getSubjectGender() {
		return subjectGender;
	}
	public void setSubjectGender(int subjectGender) {
		this.subjectGender = subjectGender;
	}
	public int getParticipationStatus() {
		return participationStatus;
	}
	public void setParticipationStatus(int participationStatus) {
		this.participationStatus = participationStatus;
	}
	public Date getParticipationStartDate() {
		return participationStartDate;
	}
	public void setParticipationStartDate(Date participationStartDate) {
		this.participationStartDate = participationStartDate;
	}
	public String getExperimentalGroup() {
		return experimentalGroup;
	}
	public void setExperimentalGroup(String experimentalGroup) {
		this.experimentalGroup = experimentalGroup;
	}
}
