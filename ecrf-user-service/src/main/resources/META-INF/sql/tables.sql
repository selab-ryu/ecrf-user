create table EC_CRF (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	crfId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	datatypeId LONG,
	crfStatus INTEGER,
	applyDate DATE null,
	defaultUILayout INTEGER
);

create table EC_CRFAutoquery (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	autoQueryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	subjectId LONG,
	crfId LONG,
	queryTermId LONG,
	queryTermName VARCHAR(75) null,
	queryValue VARCHAR(75) null,
	queryPreviousValue VARCHAR(75) null,
	queryType INTEGER,
	queryComment VARCHAR(75) null,
	queryComfirm INTEGER,
	queryComfirmUserId LONG,
	queryComfirmUserName VARCHAR(75) null,
	queryComfirmDate DATE null
);

create table EC_CRFHistory (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	historyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	subjectId LONG,
	subjectName VARCHAR(75) null,
	serialId VARCHAR(75) null,
	crfId LONG,
	structuredDataId LONG,
	actionType INTEGER,
	previousJSON TEXT null,
	currentJSON TEXT null,
	historyVersion VARCHAR(75) null,
	previousHistoryVersion VARCHAR(75) null
);

create table EC_CRFResearcher (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	crfResearcherId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	researcherId LONG,
	crfId LONG,
	jobTitle VARCHAR(75) null
);

create table EC_CRFSearchLog (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	searchLogId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	searchLog TEXT null
);

create table EC_CRFSubject (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	crfSubjectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	crfId LONG,
	subjectId LONG,
	participationStatus INTEGER,
	participationStartDate DATE null,
	updateLock BOOLEAN
);

create table EC_ExperimentalGroup (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	experimentalGroupId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	abbreviation VARCHAR(75) null,
	description VARCHAR(75) null,
	type_ INTEGER
);

create table EC_LinkCRF (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	linkId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	subjectId LONG,
	crfId LONG,
	structuredDataId LONG
);

create table EC_Project (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	projectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(75) null,
	shortTitle VARCHAR(75) null,
	purpose STRING null,
	startDate DATE null,
	endDate DATE null,
	principalResearcherId LONG,
	manageResearcherId LONG
);

create table EC_Researcher (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	researcherId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	birth DATE null,
	gender INTEGER,
	phone VARCHAR(75) null,
	institution VARCHAR(75) null,
	officeContact VARCHAR(75) null,
	position VARCHAR(75) null,
	approveStatus INTEGER,
	privacyAgree INTEGER,
	termOfUseAgree INTEGER,
	researcherUserId LONG
);

create table EC_Subject (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	subjectId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	birth DATE null,
	lunarBirth VARCHAR(75) null,
	gender INTEGER,
	phone VARCHAR(75) null,
	phone2 VARCHAR(75) null,
	address VARCHAR(75) null,
	serialId VARCHAR(75) null,
	hospitalCode INTEGER,
	expGroupId LONG
);