package refactoring_Chapter1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class Customer_StatementTest {
	private Customer cus1;
	private Rental rental1, rental2, rental3, rental4, rental5, rental6, rental7, rental8, rental9;
	private Movie movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9;
	private String customer01WithoutRents, customer01RentMovie01For1Day, customer01RentMovie01For2Day,
			customer01RentMovie02For4Day, customer01RentMovies1_5_9, customer01RentMovies1_9_5,
			customer01RentMovie05For4Day;

	@Before
	public void createCustomers() {
		cus1 = new Customer("Customer 01");
	}

	@Before
	public void createMoviesAndRentals() {
		movie1 = new Movie("Movie 01", 0);
		movie2 = new Movie("Movie 02", 0);
		movie3 = new Movie("Movie 03", 0);
		movie4 = new Movie("Movie 04", 1);
		movie5 = new Movie("Movie 05", 1);
		movie6 = new Movie("Movie 06", 1);
		movie7 = new Movie("Movie 07", 2);
		movie8 = new Movie("Movie 08", 2);
		movie9 = new Movie("Movie 09", 2);

		rental1 = new Rental(movie1, 2);
		rental2 = new Rental(movie2, 4);
		rental5 = new Rental(movie5, 4);
		rental9 = new Rental(movie9, 5);

		customer01WithoutRents = "Rental Record for Customer 01\nAmount owed is 0.0\nYou earned 0 frequent renter points";
		customer01RentMovie01For1Day = "Rental Record for Customer 01\n\tMovie 01	2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points";
		customer01RentMovie01For2Day = "Rental Record for Customer 01\n\tMovie 01	2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points";
		customer01RentMovie02For4Day = "Rental Record for Customer 01\n\tMovie 02	5.0\nAmount owed is 5.0\nYou earned 1 frequent renter points";
		customer01RentMovies1_5_9 = "Rental Record for Customer 01\n\tMovie 01	2.0\n\tMovie 05	12.0\n\tMovie 09	4.5\nAmount owed is 18.5\nYou earned 4 frequent renter points";
		customer01RentMovies1_9_5 = "Rental Record for Customer 01\n\tMovie 01	2.0\n\tMovie 09	4.5\n\tMovie 05	12.0\nAmount owed is 18.5\nYou earned 4 frequent renter points";
		customer01RentMovie05For4Day = "Rental Record for Customer 01\n\tMovie 05	12.0\nAmount owed is 12.0\nYou earned 2 frequent renter points";
	}

	@Test
	public void customerDidntRentAnyMovie() {
		String result = cus1.statement();

		assertThat(result, equalTo(customer01WithoutRents));
	}

	@Test
	public void customerRent1RegularMovieFor1Day() {
		cus1.addRental(rental1);

		String result = cus1.statement();

		assertThat(result, equalTo(customer01RentMovie01For1Day));
	}

	@Test
	public void customerRent1RegularMovieFor2Day() {
		cus1.addRental(rental1);

		String result = cus1.statement();

		assertThat(result, equalTo(customer01RentMovie01For2Day));
	}

	@Test
	public void customerRent1NewReleseMovieFor4Day() {
		cus1.addRental(rental5);

		String result = cus1.statement();

		assertThat(result, equalTo(customer01RentMovie05For4Day));
	}

	@Test
	public void customerRent1MovieFor4Day() {
		cus1.addRental(rental2);

		String result = cus1.statement();

		assertThat(result, equalTo(customer01RentMovie02For4Day));
	}

	@Test
	public void customerRent3MovieFor2_4_5Days() {
		cus1.addRental(rental1);
		cus1.addRental(rental5);
		cus1.addRental(rental9);

		String result = cus1.statement();

		assertThat(result, equalTo(customer01RentMovies1_5_9));
	}

	@Test
	public void customerRent3MovieFor2_5_4Days() {
		cus1.addRental(rental1);
		cus1.addRental(rental9);
		cus1.addRental(rental5);

		String result = cus1.statement();

		assertThat(result, equalTo(customer01RentMovies1_9_5));
	}

}
