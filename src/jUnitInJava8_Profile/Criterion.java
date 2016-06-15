package jUnitInJava8_Profile;

public class Criterion {
	private Answer answer;
	private Weight weight;

	public Criterion(Answer answer, Weight weight) {
		this.answer = answer;
		this.weight = weight;
	}

	public Answer getAnswer() {
		return answer;
	}

	public Weight getWeight() {
		return weight;
	}

	public boolean matches(Answer answerMatching) {
		if (answer.getI() == answerMatching.getI()) {
			return true;
		}
		return false;
	}
}
