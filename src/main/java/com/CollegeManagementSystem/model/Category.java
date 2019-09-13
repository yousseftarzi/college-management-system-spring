package com.CollegeManagementSystem.model;

public enum Category {
	HOMEWORK("Homework"), QUIZ("Quiz"), TEST("Test"), LAB("Lab"), CONTINUOUS_ASSESSMENT(
			"Continuous Assessement"), PROJECT("Project"), EXAM("Exam");

	private final String text;

	Category(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
