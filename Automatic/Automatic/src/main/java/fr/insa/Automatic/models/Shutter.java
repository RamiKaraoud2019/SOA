package fr.insa.Automatic.models;



public class Shutter {

	private double currentOpening;
	private double order;
	private boolean isMoving;
	
	public Shutter() {}
	
	public Shutter(double currentOpening, double order) {
		this.currentOpening = currentOpening;
		this.order = order;
		updateIsMoving();
	}
	
	public double getCurrentOpening() {
		return currentOpening;
	}
	
	public void setCurrentOpening(double currentOpening) {
		this.currentOpening = currentOpening;
		updateIsMoving();
	}
	
	public double getOrder() {
		return order;
	}
	
	public void setOrder(double order) {
		this.order = order;
		updateIsMoving();
	}
	
	public boolean isMoving() {
		return isMoving;
	}
	
	private void updateIsMoving() {
		isMoving = ! (currentOpening == order);
	}
}
