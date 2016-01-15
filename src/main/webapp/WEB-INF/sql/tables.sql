create table Matcher_Contact (
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	city VARCHAR(75) null,
	country VARCHAR(75) null,
	lat DOUBLE,
	lng DOUBLE,
	jobTitle VARCHAR(75) null,
	company VARCHAR(75) null,
	industry VARCHAR(75) null,
	interests VARCHAR(75) null,
	interestedIds VARCHAR(75) null,
	picUrl VARCHAR(75) null,
	eventContactId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Matcher_EventContact (
	givenName VARCHAR(256) null,
	fullName VARCHAR(256) null,
	emailAddress VARCHAR(256) null,
	city VARCHAR(75) null,
	country VARCHAR(75) null,
	lat DOUBLE,
	lng DOUBLE,
	jobTitle VARCHAR(75) null,
	company VARCHAR(1024) null,
	industry VARCHAR(75) null,
	interests TEXT null,
	desires TEXT null,
	expertise TEXT null,
	attendeeType VARCHAR(75) null,
	interestedIds TEXT null,
	picUrl VARCHAR(2000) null,
	eventId VARCHAR(75) null,
	verified BOOLEAN,
	eventContactId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Matcher_EventPollAnswer (
	questionId LONG,
	clientId VARCHAR(75) null,
	payload TEXT null,
	answer TEXT null,
	createDate DATE null,
	answerId LONG not null primary key
);

create table Matcher_EventPollQuestion (
	eventId VARCHAR(75) null,
	sponsorName VARCHAR(75) null,
	shortTitle VARCHAR(75) null,
	question TEXT null,
	questionType VARCHAR(75) null,
	choices TEXT null,
	anonymousResults BOOLEAN,
	showResponseCount BOOLEAN,
	chartType VARCHAR(75) null,
	askForId BOOLEAN,
	idIntro TEXT null,
	createDate DATE null,
	enabled BOOLEAN,
	autoEnable BOOLEAN,
	enableTriggerDate DATE null,
	enableTriggerTimezone VARCHAR(75) null,
	picUrl TEXT null,
	questionId LONG not null primary key
);

create table Matcher_GeoCache (
	address VARCHAR(75) null,
	lat DOUBLE,
	lng DOUBLE,
	geoCacheId LONG not null primary key,
	createDate DATE null
);

create table Matcher_Match (
	contactId1 LONG,
	contactId2 LONG,
	eventId VARCHAR(75) null,
	matchId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Matcher_Message (
	fromId LONG,
	toId LONG,
	content TEXT null,
	read_ BOOLEAN,
	eventId VARCHAR(75) null,
	messageId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);