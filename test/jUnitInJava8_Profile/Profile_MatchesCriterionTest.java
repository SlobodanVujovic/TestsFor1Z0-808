package jUnitInJava8_Profile;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Profile_MatchesCriterionTest {
	private Profile profile;
	private Question questionIsThereRelocation;
	private Question questionIsReimburseTuition;
	private Answer answerThereIsRelocation;
	private Answer answerThereIsNotRelocation;
	private Answer answerDoesNotReimburseTuition;
	private Answer answerReimbursesTuition;

	@Before
	public void createProfile() {
		profile = new Profile("1");
	}

	@Before
	public void createQuestionAndAnswer() {
		questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
		questionIsReimburseTuition = new BooleanQuestion(2, "Reimburse tuition?");
		answerThereIsRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
		answerThereIsNotRelocation = new Answer(questionIsThereRelocation, Bool.FALSE);
		answerDoesNotReimburseTuition = new Answer(questionIsReimburseTuition, Bool.FALSE);
		answerReimbursesTuition = new Answer(questionIsReimburseTuition, Bool.TRUE);
	}

	@Test
	public void trueWhenMatchesSoleAnswer() {
		profile.add(answerThereIsRelocation);
		Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

		assertTrue(profile.matches(criterion));
	}

	@Test
	public void falseWhenNoMatchingAnswerContained() {
		profile.add(answerThereIsNotRelocation);
		Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

		assertFalse(profile.matches(criterion));
	}

	@Test
	public void trueWhenOneOfMultipleAnswerMatches() {
		profile.add(answerThereIsRelocation);
		profile.add(answerDoesNotReimburseTuition);
		Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

		assertTrue(profile.matches(criterion));
	}

	@Test
	public void trueForAnyDontCareCriterion() {
		profile.add(answerDoesNotReimburseTuition);
		Criterion criterion = new Criterion(answerReimbursesTuition, Weight.DontCare);

		assertTrue(profile.matches(criterion));
	}

	@Test
	public void falseWhenAnswerIsNull() {
		assertFalse(new Answer(new BooleanQuestion(0, ""), Bool.TRUE).match(null));
	}
}
