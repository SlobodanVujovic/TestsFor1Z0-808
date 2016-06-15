package jUnitInJava8_Correct;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.*;
import static java.lang.Math.abs;

public class NewtonTest {
	static class Newton {
		private static final double TOLERANCE = 1E-16;

		public static double squareRoot(double n) {
			double approx = n;
			while (abs(approx - n / approx) > TOLERANCE * approx) {
				approx = (n / approx + approx) / 2.0;
			}
			return approx;
		}
	}

	@Test
	public void squareRoot() {
		double result = Newton.squareRoot(250.0);

		assertThat(result * result, closeTo(250.0, Newton.TOLERANCE));
		assertThat(Newton.squareRoot(1969.0), closeTo(Math.sqrt(1969.0), Newton.TOLERANCE));
	}
}
