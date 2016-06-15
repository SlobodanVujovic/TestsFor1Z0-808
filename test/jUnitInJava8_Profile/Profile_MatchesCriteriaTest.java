package jUnitInJava8_Profile;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Profile_MatchesCriteriaTest {
	private Profile profile;
	private Question questionIsReimburseTuition;
	private Question questionIsThereRelo;
	private Answer answerDoesNotReimburseTuition;
	private Answer answerThereIsRelo;
	private Answer answerReimbursesTuition;
	private Criteria criteria;

	@Before
	public void createProfile() {
		profile = new Profile("1");
	}

	@Before
	public void createQuestionAndAnswer() {
		questionIsReimburseTuition = new BooleanQuestion(2, "Reimburse tuition?");
		questionIsThereRelo = new BooleanQuestion(3, "Relocation package?");
		answerDoesNotReimburseTuition = new Answer(questionIsReimburseTuition, Bool.FALSE);
		answerThereIsRelo = new Answer(questionIsThereRelo, Bool.TRUE);
		answerReimbursesTuition = new Answer(questionIsReimburseTuition, Bool.TRUE);
		criteria = new Criteria();
	}

	@Test
	public void falseWhenNoneOfMultipleCriteriaMatch() {
		profile.add(answerDoesNotReimburseTuition);
		criteria.add(new Criterion(answerThereIsRelo, Weight.Important));
		criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));

		assertFalse(profile.matches(criteria));
	}

	@Test
	public void trueWhenAnyOfMultipleCriteriaMatch() {
		profile.add(answerThereIsRelo);
		criteria.add(new Criterion(answerThereIsRelo, Weight.Important));
		criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));

		assertTrue(profile.matches(criteria));
	}

	@Test
	public void falseWhenAnyMustMeetCriteriaNotMet() {
		profile.add(answerThereIsRelo);
		profile.add(answerDoesNotReimburseTuition);
		criteria.add(new Criterion(answerThereIsRelo, Weight.Important));
		criteria.add(new Criterion(answerReimbursesTuition, Weight.MustMatch));

		assertFalse(profile.matches(criteria));
	}

}
