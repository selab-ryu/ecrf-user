create table EC_CRF (
	uuid_ VARCHAR(75) null,
	crfId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	datatypeId LONG,
	managerId LONG,
	applyDate DATE null,
	crfStatus INTEGER
);

create table EC_CRFPatient (
	uuid_ VARCHAR(75) null,
	crfPatientId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	crfId LONG,
	patientId LONG
);

create table EC_CRFResearcher (
	uuid_ VARCHAR(75) null,
	crfResearcherId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	researcherId LONG,
	crfId LONG
);

create table EC_Patient (
	uuid_ VARCHAR(75) null,
	patientId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	birth DATE null,
	phone VARCHAR(75) null,
	position VARCHAR(75) null,
	gender INTEGER,
	consentDate DATE null,
	participationStartDate DATE null,
	participationStatus INTEGER,
	experimentalGroup VARCHAR(75) null,
	patientUserId LONG
);

create table EC_Project (
	uuid_ VARCHAR(75) null,
	projectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(75) null,
	shortTitle VARCHAR(75) null,
	purpose VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	principalResearcherId LONG,
	manageResearcherId LONG
);

create table EC_Researcher (
	uuid_ VARCHAR(75) null,
	researcherId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	birth DATE null,
	phone VARCHAR(75) null,
	institution VARCHAR(75) null,
	officeContact VARCHAR(75) null,
	position VARCHAR(75) null,
	approveStatus INTEGER,
	researcherUserId LONG
);