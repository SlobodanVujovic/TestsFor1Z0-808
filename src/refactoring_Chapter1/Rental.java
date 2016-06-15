package refactoring_Chapter1;

class Rental {
	private Movie _movie;
	private int _dayRented;

	public Rental(Movie _movie, int _dayRented) {
		this._movie = _movie;
		this._dayRented = _dayRented;
	}

	public int getDaysRented() {
		return _dayRented;
	}

	public void setDaysRented(int _dayRented) {
		this._dayRented = _dayRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	double getCharge() {
		return _movie.getCharge(_dayRented);
	}

	int getFrequentRenterPoints() {
		return _movie.getFrequentRenterPoints(_dayRented);
	}
}
