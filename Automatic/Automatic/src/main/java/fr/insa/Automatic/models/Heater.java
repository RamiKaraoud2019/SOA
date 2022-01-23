package fr.insa.Automatic.models;

public class Heater {
	private double currentTemperature;
	private double order;
	private boolean isHeating;
	
	public Heater() {}
	
	public Heater(double currenttemperature, double order) {
		this.currentTemperature = currentTemperature;
		this.order = order;
		updateIsHeating();
	}
	
	public double getCurrentTemperature() {
		return currentTemperature;
	}
	
	public void setCurrentTemperature(double currentOpening) {
		this.currentTemperature = currentTemperature;
		updateIsHeating();
	}
	
	public double getOrder() {
		return order;
	}
	
	public void setOrder(double order) {
		this.order = order;
		updateIsHeating();
	}
	
	public boolean isHeating() {
		return isHeating;
	}
	
	private void updateIsHeating() {
		isHeating = ! (currentTemperature == order);
	}
}

