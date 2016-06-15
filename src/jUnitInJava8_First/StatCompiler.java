package jUnitInJava8_First;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StatCompiler {
	public QuestionController controller = new QuestionController();

	public Map<String, Map<Boolean, AtomicInteger>> responsesByQuestion(List<BooleanAnswer> answers,
			Map<Integer, String> questions) {
		Map<Integer, Map<Boolean, AtomicInteger>> responses = new HashMap<>();
		answers.stream().forEach(answer -> incrementHistogram(responses, answer));
		return convertHistogramIdsToText(responses, questions);
	}

	/*
	 * Create Map that have question text as key and as value another Map which key is boolean and value is number of answers for that boolean.
	 */
	private Map<String, Map<Boolean, AtomicInteger>> convertHistogramIdsToText(
			Map<Integer, Map<Boolean, AtomicInteger>> responses, Map<Integer, String> questions) {
		Map<String, Map<Boolean, AtomicInteger>> textResponses = new HashMap<>();
		responses.keySet().stream().forEach(id -> textResponses.put(questions.get(id), responses.get(id)));
		return textResponses;
	}

	/*
	 * Take histogram which key = specific id (getQuestionId()) and increment its value by 1.
	 */
	private void incrementHistogram(Map<Integer, Map<Boolean, AtomicInteger>> responses, BooleanAnswer answer) {
		Map<Boolean, AtomicInteger> histogram = getHistogram(responses, answer.getQuestionId());
		histogram.get(Boolean.valueOf(answer.getValue())).getAndIncrement();
	}

	/*
	 * If responses contain value with key = id then return that value, else create new histogram and put it in responses with key = id. Anyway return
	 * histogram.
	 */
	private Map<Boolean, AtomicInteger> getHistogram(Map<Integer, Map<Boolean, AtomicInteger>> responses, int id) {
		Map<Boolean, AtomicInteger> histogram = null;
		if (responses.containsKey(id))
			histogram = responses.get(id);
		else {
			histogram = createNewHistogram();
			responses.put(id, histogram);
		}
		return histogram;
	}

	/*
	 * Create histogram which is HashMap with Boolean as key and AtomicInteger (an int value that can be update automatically) as value.
	 */
	private Map<Boolean, AtomicInteger> createNewHistogram() {
		Map<Boolean, AtomicInteger> histogram;
		histogram = new HashMap<>();
		histogram.put(Boolean.FALSE, new AtomicInteger(0));
		histogram.put(Boolean.TRUE, new AtomicInteger(0));
		return histogram;
	}

	/*
	 * Create Map of questions IDs as keys and questions text as value.
	 */
	public Map<Integer, String> questionText(List<BooleanAnswer> answers) {
		Map<Integer, String> questions = new HashMap<>();
		answers.stream().forEach(answer -> {
			if (!questions.containsKey(answer.getQuestionId())) {
				questions.put(answer.getQuestionId(), controller.find(answer.getQuestionId()).getText());
			}
		});
		return questions;
	}
}
