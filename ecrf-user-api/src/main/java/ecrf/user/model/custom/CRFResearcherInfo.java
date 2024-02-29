package ecrf.user.model.custom;

import java.util.Date;

public class CRFResearcherInfo {
	private long crfResearcherId;
	private long groupId;
	
	private long crfId;
	private String crfName;
	private int crfStatus;
	
	private long researcherId;
	private String name;
	private String email;	
	private Date birth;
	private int gender;

	private String phone;
	private String officeContact;
	private String institution;
	
	private String position;
	private int approveStatus;
	
	private long researcherUserId;
	
	private String jobTitle;
		
	public CRFResearcherInfo() {
		
	}
	
	public CRFResearcherInfo(long crfResearcherId, long crfId, long researcherId) {
		this.crfResearcherId = crfResearcherId;
		this.crfId = crfId;
		this.researcherId = researcherId;
	}
	
	public CRFResearcherInfo(long crfResearcherId, long groupId, long crfId, String crfName, int crfStatus,
			long researcherId) {
		super();
		this.crfResearcherId = crfResearcherId;
		this.groupId = groupId;
		this.crfId = crfId;
		this.crfName = crfName;
		this.crfStatus = crfStatus;
		this.researcherId = researcherId;
		
		
	}
		
	@Override
	public String toString() {
		String str = String.format("{ crfResearcherId : %s, groupId : %s, "
				+ "crfId : %s, crfName : %s, crfStatus : %s, "
				+ "researcherId : %s "
				+ " }", 
				String.valueOf(crfResearcherId), String.valueOf(groupId),
				String.valueOf(crfId), String.valueOf(crfName), String.valueOf(crfStatus),
				String.valueOf(researcherId));
		
		return str;
	}


	public long getCrfResearcherId() {
		return crfResearcherId;
	}

	public void setCrfResearcherId(long crfResearcherId) {
		this.crfResearcherId = crfResearcherId;
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
	
	public long getResearcherId() {
		return researcherId;
	}

	public void setResearcherId(long researcherId) {
		this.researcherId = researcherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOfficeContact() {
		return officeContact;
	}

	public void setOfficeContact(String officeContact) {
		this.officeContact = officeContact;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(int approveStatus) {
		this.approveStatus = approveStatus;
	}
	
	public long getResearcherUserId() {
		return researcherUserId;
	}

	public void setResearcherUserId(long researcherUserId) {
		this.researcherUserId = researcherUserId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}	
}
