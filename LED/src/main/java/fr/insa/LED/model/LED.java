package fr.insa.LED.model;

public class LED {
	private double currentLuminosity;
	private double order;
	private boolean isON;
	
	public LED() {}
	
	public LED(double currentLuminosity, double order) {
		this.currentLuminosity = currentLuminosity;
		this.order = order;
		updateIsON();
	}
	
	public double getCurrentLuminosity() {
		return currentLuminosity;
	}
	
	public void setCurrentLumiosity(double currentLuminosity) {
		this.currentLuminosity = currentLuminosity;
		updateIsON();
	}
	
	public double getOrder() {
		return order;
	}
	
	public void setOrder(double order) {
		this.order = order;
		updateIsON();
	}
	
	public boolean isON() {
		return isON;
	}
	
	private void updateIsON() {
		isON = ! (currentLuminosity == order);
	}
}
