create index IX_C6A56BAF on EC_CRF (datatypeId);
create index IX_2C9FB74E on EC_CRF (groupId);
create index IX_A1D6F7D0 on EC_CRF (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C55B3252 on EC_CRF (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_ADEFB396 on EC_CRFAutoquery (groupId, crfId, subjectId);
create index IX_9CE7CD0B on EC_CRFAutoquery (queryTermId, subjectId, queryTermName[$COLUMN_LENGTH:75$], queryValue[$COLUMN_LENGTH:75$]);
create index IX_2FDE3CBE on EC_CRFAutoquery (queryTermId, subjectId, queryValue[$COLUMN_LENGTH:75$]);
create index IX_7596A101 on EC_CRFAutoquery (subjectId, queryTermName[$COLUMN_LENGTH:75$]);
create index IX_8B5008C3 on EC_CRFAutoquery (userId);
create index IX_FCD4DB3D on EC_CRFAutoquery (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7B650CFF on EC_CRFAutoquery (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A0C6B8F9 on EC_CRFHistory (crfId, subjectId);
create index IX_85C608FC on EC_CRFHistory (groupId, crfId);
create index IX_893E5CDB on EC_CRFHistory (groupId, subjectId, crfId, structuredDataId);
create index IX_B637FA00 on EC_CRFHistory (groupId, userId);
create index IX_7CBB5AEE on EC_CRFHistory (structuredDataId);
create index IX_5F492973 on EC_CRFHistory (subjectId);
create index IX_E79A319E on EC_CRFHistory (userId);
create index IX_2031EE58 on EC_CRFHistory (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_75922ADA on EC_CRFHistory (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8E35E375 on EC_CRFResearcher (crfId, researcherId);
create index IX_25F4429C on EC_CRFResearcher (groupId, crfId);
create index IX_FCD6479D on EC_CRFResearcher (groupId, researcherId);
create index IX_85703FFB on EC_CRFResearcher (researcherId);
create index IX_6DB83FF8 on EC_CRFResearcher (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_15C0647A on EC_CRFResearcher (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E0074FC0 on EC_CRFSearchLog (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3EA0C642 on EC_CRFSearchLog (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_876AED91 on EC_CRFSubject (crfId, subjectId);
create index IX_ED2F489C on EC_CRFSubject (groupId, crfId, updateLock);
create index IX_590C5C69 on EC_CRFSubject (groupId, subjectId);
create index IX_6D622F0 on EC_CRFSubject (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B06AA572 on EC_CRFSubject (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_56E01E2D on EC_ExperimentalGroup (groupId, name[$COLUMN_LENGTH:75$]);
create index IX_7B4711FB on EC_ExperimentalGroup (name[$COLUMN_LENGTH:75$]);
create index IX_A6C9CA30 on EC_ExperimentalGroup (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4B9F1CB2 on EC_ExperimentalGroup (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_12A03061 on EC_LinkCRF (crfId, subjectId, structuredDataId);
create index IX_FD215524 on EC_LinkCRF (groupId, crfId, structuredDataId);
create index IX_A672C97D on EC_LinkCRF (groupId, subjectId, crfId, structuredDataId);
create index IX_BFC84DA2 on EC_LinkCRF (groupId, userId);
create index IX_A5357B8C on EC_LinkCRF (structuredDataId);
create index IX_A2015E95 on EC_LinkCRF (subjectId);
create index IX_ED48DFBC on EC_LinkCRF (userId);
create index IX_48AC0EF6 on EC_LinkCRF (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D0B7DAF8 on EC_LinkCRF (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F875944C on EC_Project (groupId);
create index IX_D3B6D892 on EC_Project (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_83E05B94 on EC_Project (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B89E9D59 on EC_Researcher (companyId);
create index IX_61820A8C on EC_Researcher (position[$COLUMN_LENGTH:75$]);
create unique index IX_51AAFB11 on EC_Researcher (researcherUserId);
create index IX_6B1E9B55 on EC_Researcher (status);
create index IX_8AC15FA3 on EC_Researcher (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_C3C09059 on EC_Subject (groupId);
create index IX_E216A70 on EC_Subject (name[$COLUMN_LENGTH:75$]);
create unique index IX_456AFF94 on EC_Subject (serialId[$COLUMN_LENGTH:75$]);
create index IX_CEC21B25 on EC_Subject (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3FF126E7 on EC_Subject (uuid_[$COLUMN_LENGTH:75$], groupId);