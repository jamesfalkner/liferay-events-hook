package com.liferay.events.global.mobile.model;

public enum PollQuestionType {

	QUESTION_TYPE_SINGLE("single"),
	QUESTION_TYPE_MULTIPLE("multiple"),
	QUESTION_TYPE_RANKING("ranking"),
	QUESTION_TYPE_RATING("rating"),
	QUESTION_TYPE_TEXT("text");

	private final String typeName;

	PollQuestionType(String name) {
		this.typeName = name;
	}

	public String getTypeName() {
		return this.typeName;
	}
}
