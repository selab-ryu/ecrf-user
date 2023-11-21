create index IX_5D770B4A on EC_CRF (groupId, managerId);
create index IX_A1D6F7D0 on EC_CRF (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C55B3252 on EC_CRF (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_28D9B52D on EC_CRFPatient (groupId, crfId);
create index IX_29FC1ADB on EC_CRFPatient (groupId, patientId);
create index IX_4D0B5249 on EC_CRFPatient (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_18A5D70B on EC_CRFPatient (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_25F4429C on EC_CRFResearcher (groupId, crfId);
create index IX_FCD6479D on EC_CRFResearcher (groupId, researcherId);
create index IX_6DB83FF8 on EC_CRFResearcher (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_15C0647A on EC_CRFResearcher (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C09E8394 on EC_CRFSubject (groupId, crfId);
create index IX_590C5C69 on EC_CRFSubject (groupId, subjectId);
create index IX_6D622F0 on EC_CRFSubject (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B06AA572 on EC_CRFSubject (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_EACD08E0 on EC_Patient (groupId);
create index IX_14F74A7E on EC_Patient (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A82C5880 on EC_Patient (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F875944C on EC_Project (groupId);
create index IX_D3B6D892 on EC_Project (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_83E05B94 on EC_Project (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B89E9D59 on EC_Researcher (companyId);
create index IX_61820A8C on EC_Researcher (position[$COLUMN_LENGTH:75$]);
create unique index IX_51AAFB11 on EC_Researcher (researcherUserId);
create index IX_6B1E9B55 on EC_Researcher (status);
create index IX_8AC15FA3 on EC_Researcher (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_C3C09059 on EC_Subject (groupId);
create index IX_CEC21B25 on EC_Subject (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3FF126E7 on EC_Subject (uuid_[$COLUMN_LENGTH:75$], groupId);