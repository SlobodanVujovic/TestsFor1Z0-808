package designPatterns_Compound;

public interface QuackObservable {
	public void registerObserver(Observer observer);

	public void notifyObservers();
}
