package refactoring_Chapter1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Customer_HtmlStatementTest {

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

		customer01WithoutRents = "<H1>Rentals for <EM>Customer 01</EM></H1><P>\n<P>You owe <EM>0.0</EM><P>\nOn this rental you earned <EM>0</EM> frequent renter points<P>";
		customer01RentMovie01For1Day = "<H1>Rentals for <EM>Customer 01</EM></H1><P>\nMovie 01: 2.0<BR>\n<P>You owe <EM>2.0</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>";
		customer01RentMovie01For2Day = "<H1>Rentals for <EM>Customer 01</EM></H1><P>\nMovie 01: 2.0<BR>\n<P>You owe <EM>2.0</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>";
		customer01RentMovie02For4Day = "<H1>Rentals for <EM>Customer 01</EM></H1><P>\nMovie 02: 5.0<BR>\n<P>You owe <EM>5.0</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>";
		customer01RentMovies1_5_9 = "<H1>Rentals for <EM>Customer 01</EM></H1><P>\nMovie 01: 2.0<BR>\nMovie 05: 12.0<BR>\nMovie 09: 4.5<BR>\n<P>You owe <EM>18.5</EM><P>\nOn this rental you earned <EM>4</EM> frequent renter points<P>";
		customer01RentMovies1_9_5 = "<H1>Rentals for <EM>Customer 01</EM></H1><P>\nMovie 01: 2.0<BR>\nMovie 09: 4.5<BR>\nMovie 05: 12.0<BR>\n<P>You owe <EM>18.5</EM><P>\nOn this rental you earned <EM>4</EM> frequent renter points<P>";
		customer01RentMovie05For4Day = "<H1>Rentals for <EM>Customer 01</EM></H1><P>\nMovie 05: 12.0<BR>\n<P>You owe <EM>12.0</EM><P>\nOn this rental you earned <EM>2</EM> frequent renter points<P>";
	}

	@Test
	public void customerDidntRentAnyMovie() {

		String result = cus1.htmlStatement();

		assertThat(result, equalTo(customer01WithoutRents));
	}

	@Test
	public void customerRent1RegularMovieFor1Day() {
		cus1.addRental(rental1);

		String result = cus1.htmlStatement();

		assertThat(result, equalTo(customer01RentMovie01For1Day));
	}

	@Test
	public void customerRent1RegularMovieFor2Day() {
		cus1.addRental(rental1);

		String result = cus1.htmlStatement();

		assertThat(result, equalTo(customer01RentMovie01For2Day));
	}

	@Test
	public void customerRent1NewReleseMovieFor4Day() {
		cus1.addRental(rental5);

		String result = cus1.htmlStatement();

		assertThat(result, equalTo(customer01RentMovie05For4Day));
	}

	@Test
	public void customerRent1MovieFor4Day() {
		cus1.addRental(rental2);

		String result = cus1.htmlStatement();

		assertThat(result, equalTo(customer01RentMovie02For4Day));
	}

	@Test
	public void customerRent3MovieFor2_4_5Days() {
		cus1.addRental(rental1);
		cus1.addRental(rental5);
		cus1.addRental(rental9);

		String result = cus1.htmlStatement();

		assertThat(result, equalTo(customer01RentMovies1_5_9));
	}

	@Test
	public void customerRent3MovieFor2_5_4Days() {
		cus1.addRental(rental1);
		cus1.addRental(rental9);
		cus1.addRental(rental5);

		String result = cus1.htmlStatement();

		assertThat(result, equalTo(customer01RentMovies1_9_5));
	}

}
