package jUnitInJava8_Profile;

import java.util.ArrayList;
import java.util.Iterator;

public class Criteria implements Iterable<Criterion> {
	private ArrayList<Criterion> criteria = new ArrayList<>();

	public void add(Criterion criterion) {
		criteria.add(criterion);
	}

	public ArrayList<Criterion> getCriteria() {
		return criteria;
	}

	@Override
	public Iterator<Criterion> iterator() {
		return criteria.iterator();
	}
}
