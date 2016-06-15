package jUnitInJava8_Profile;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class Profile_ScoreTest {
	private Profile profile;
	private Question questionIsThereRelocation;
	private Answer answerThereIsRelocation;
	private Criteria criteria;

	@Before
	public void createProfile() {
		profile = new Profile("1");
	}

	@Before
	public void createQuestionAndAnswer() {
		questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
		answerThereIsRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
		criteria = new Criteria();
	}

	@Test
	public void zeroWhenThereAreNoMatches() {
		criteria.add(new Criterion(answerThereIsRelocation, Weight.Important));
		ProfileMatch match = profile.match(criteria);

		assertThat(match.getScore(), equalTo(0));
	}

}
