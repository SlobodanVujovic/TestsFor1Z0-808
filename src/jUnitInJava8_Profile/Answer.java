package jUnitInJava8_Profile;

public class Answer {
	private Question question;
	private int i;

	public Answer(Question questionText, int i) {
		this.question = questionText;
		this.i = i;
	}

	public boolean match(Answer otherAnswer) {
		if (otherAnswer == null) {
			return false;
		}
		return question == otherAnswer.question && i == otherAnswer.i;
	}

	public String getQuestionText() {
		return question.getQuestionText();
	}

	public int getI() {
		return i;
	}
}
