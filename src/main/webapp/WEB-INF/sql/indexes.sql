create index IX_4AF39C5 on Matcher_Contact (emailAddress);
create index IX_BD50E3D2 on Matcher_Contact (eventContactId);

create index IX_C74C5A45 on Matcher_EventContact (emailAddress);
create index IX_107FC86E on Matcher_EventContact (eventContactId);
create index IX_63193E97 on Matcher_EventContact (eventContactId, eventId);
create index IX_88343EAA on Matcher_EventContact (eventContactId, verified);
create index IX_C1F4A9B8 on Matcher_EventContact (eventId, emailAddress);
create index IX_3DF8B74 on Matcher_EventContact (eventId, emailAddress, verified);
create index IX_2520721 on Matcher_EventContact (eventId, eventContactId);
create index IX_642C97DD on Matcher_EventContact (eventId, verified, eventContactId);

create index IX_7F648C65 on Matcher_EventPollAnswer (questionId);
create index IX_706E9DF on Matcher_EventPollAnswer (questionId, clientId);

create index IX_E63B89E0 on Matcher_EventPollQuestion (autoEnable, enabled, enableTriggerDate);
create index IX_9537183B on Matcher_EventPollQuestion (enableTriggerDate);
create index IX_8B8088D on Matcher_EventPollQuestion (eventId);
create index IX_F38D3444 on Matcher_EventPollQuestion (eventId, enabled);

create index IX_FD59AF00 on Matcher_GeoCache (address);

create index IX_7F76A428 on Matcher_Match (contactId1);
create index IX_BA04F41D on Matcher_Match (contactId1, eventId);
create index IX_7F76A7E9 on Matcher_Match (contactId2);
create index IX_C1B6997C on Matcher_Match (contactId2, eventId);
create index IX_86F74BB1 on Matcher_Match (eventId, contactId1);
create index IX_86F74F72 on Matcher_Match (eventId, contactId2);

create index IX_528763EF on Matcher_Message (eventId, toId);
create index IX_4AB4B66A on Matcher_Message (toId);
create index IX_D96A4C1B on Matcher_Message (toId, eventId);