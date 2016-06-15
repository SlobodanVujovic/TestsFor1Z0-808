package refactoring_Chapter1;

public class VideoClub {

	public static void main(String[] args) {
		Customer cus1 = new Customer("Customer 01");
		Movie movie1 = new Movie("Movie 01", 0);
		Movie movie2 = new Movie("Movie 02", 2);
		Rental rental1 = new Rental(movie1, 4);
		Rental rental2 = new Rental(movie2, 3);
		cus1.addRental(rental1);
		cus1.addRental(rental2);
		System.out.println(cus1.statement());
		System.out.println();
		System.out.println(cus1.htmlStatement());
	}
}
