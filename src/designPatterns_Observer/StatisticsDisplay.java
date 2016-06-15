package designPatterns_Observer;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum = 0.0f;
	private float currentTemp;
	private int numReadings;
	Observable observable;

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) observable;
			currentTemp = weatherData.getTemperature();
			tempSum += currentTemp;
			numReadings++;
			if (currentTemp > maxTemp) {
				maxTemp = currentTemp;
			}
			if (currentTemp < minTemp) {
				minTemp = currentTemp;
			}
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}
}
