package com.geektrust.watermanagement.model;

import java.util.HashMap;
import java.util.Map;

public class TankerWater{
	private double litresSupplied = 0.0;
	private Map<Integer, Integer> tankerPrice = new HashMap<>();
	private double price = 0;
	
	public TankerWater() {
		tankerPrice.put(500, 2);
		tankerPrice.put(1500, 3);
		tankerPrice.put(3000, 5);
		tankerPrice.put(3001, 8);
    }
	
	public double getLitresSupplied() {
		return litresSupplied;
	}
	
	public void setLitresSupplied(double litresSupplied) {
		this.litresSupplied = litresSupplied;
	}
	
	public Double getPrice() {
		if (this.litresSupplied>0) {if(this.litresSupplied<500) {calculateTankerPrice(500-this.litresSupplied, tankerPrice.get(500));} else {calculateTankerPrice(500, tankerPrice.get(500));}}
		if (this.litresSupplied>500) {if(this.litresSupplied<1500) {calculateTankerPrice(this.litresSupplied-1000, tankerPrice.get(1500));} else {calculateTankerPrice(1000, tankerPrice.get(1500));}}
		if (this.litresSupplied>1500) {if(this.litresSupplied<3000) {calculateTankerPrice(this.litresSupplied-1500, tankerPrice.get(3000));} else {calculateTankerPrice(1500, tankerPrice.get(3000));}}
		if (this.litresSupplied>3000) calculateTankerPrice((this.litresSupplied-3000), tankerPrice.get(3001));
		return this.price;
	}
	
	public void calculateTankerPrice(double tempSuppliedLitrs, int applicableTankerPrice) {
		this.price += tempSuppliedLitrs * applicableTankerPrice;	
	}
}
