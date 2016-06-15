package jUnitInJava8_First;

import java.time.Clock;
import java.util.HashMap;
import java.util.Map;

public class QuestionController {
	private Map<Integer, Question> questionMap = new HashMap<>();
	private Question question;
	private Clock clock = Clock.systemUTC();

	public Question find(Integer id) {
		question = questionMap.get(id);
		return question;
	}

	public int addBooleanQuestion(String text) {
		return persist(new BooleanQuestion(text));
	}

	void setClock(Clock clock) {
		this.clock = clock;
	}

	private int persist(Question question) {
		question.setCreateTimestamp(clock.instant());
		questionMap.put(question.getId(), question);
		return question.getId();
	}
}
