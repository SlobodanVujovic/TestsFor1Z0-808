package jUnitInJava8_Profile;

public class BooleanQuestion extends Question {
	private int number;
	private String questionText;

	public BooleanQuestion(int number, String questionText) {
		this.number = number;
		this.questionText = questionText;
	}

	public String getQuestionText() {
		return questionText;
	}
}
