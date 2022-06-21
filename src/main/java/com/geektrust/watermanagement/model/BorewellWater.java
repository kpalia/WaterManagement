package com.geektrust.watermanagement.model;

public class BorewellWater{
	private double litresSupplied = 0.0;
	private double price = 1.5;
	
	public double getLitresSupplied() {
		return litresSupplied;
	}
	public void setLitresSupplied(double litresSupplied) {
		this.litresSupplied = litresSupplied;
	}
	public double getPrice() {
		return this.litresSupplied*this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
