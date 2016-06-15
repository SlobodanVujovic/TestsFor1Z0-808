package jUnitInJava8_Correct;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class SparseArrayTest {
	private SparseArray<Object> array;

	@Before
	public void create() {
		array = new SparseArray<>();
	}

	@Test
	public void handlesInsertionInDescendingOrder() {
		array.put(7, "seven");
		array.checkInvariants();
		array.put(6, "six");
		array.checkInvariants();

		assertThat(array.get(6), equalTo("six"));
		assertThat(array.get(7), equalTo("seven"));
	}

}
