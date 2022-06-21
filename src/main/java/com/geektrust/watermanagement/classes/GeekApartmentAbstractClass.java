package com.geektrust.watermanagement.classes;

import com.geektrust.watermanagement.constants.CommonConstants;
import com.geektrust.watermanagement.interfaces.Bill;
import com.geektrust.watermanagement.interfaces.GeekHeightsApartment;
import com.geektrust.watermanagement.model.BorewellWater;
import com.geektrust.watermanagement.model.CorporationWater;
import com.geektrust.watermanagement.model.TankerWater;

public class GeekApartmentAbstractClass implements GeekHeightsApartment, Bill{

	private int houseMembers = 0;
	private int guests = 0;
	private int defaultWaterQuantity = 0;
	private CorporationWater corpWater = null;
	private BorewellWater borewellWater = null;
	private TankerWater tankerWater = null;
	
	public GeekApartmentAbstractClass(int houseMembers) {
		this.houseMembers = houseMembers;
		this.corpWater = new CorporationWater();
		this.borewellWater = new BorewellWater();
		this.tankerWater = new TankerWater();
		this.defaultWaterQuantityRequired();
	}
	
	@Override
	public void allotWater(String waterSourceRatio) {
		String[] waterRatio = waterSourceRatio.split(":");
		double ratio = (double)this.defaultWaterQuantity/(Integer.parseInt(waterRatio[0])+Integer.parseInt(waterRatio[1]));
		this.corpWater.setLitresSupplied(ratio*(Integer.parseInt(waterRatio[0])));
		this.borewellWater.setLitresSupplied(ratio*(Integer.parseInt(waterRatio[1])));
	}

	@Override
	public void addGuests(int numberOfGuests) {
		this.guests += numberOfGuests;
		this.tankerWater.setLitresSupplied(this.guests * CommonConstants.PER_PERSON_WATER * CommonConstants.MONTH_DAYS);
	}

	@Override
	public String generateWaterBill() {
		StringBuilder totalFormattedBill = new StringBuilder();
		totalFormattedBill.append((int)Math.round(this.corpWater.getLitresSupplied()+this.borewellWater.getLitresSupplied()+this.tankerWater.getLitresSupplied()));
		totalFormattedBill.append(":");
		totalFormattedBill.append((int)Math.ceil(this.corpWater.getPrice()+this.borewellWater.getPrice()+this.tankerWater.getPrice()));
		return totalFormattedBill.toString();
	}

	private void defaultWaterQuantityRequired() {
		this.defaultWaterQuantity = (this.houseMembers * CommonConstants.PER_PERSON_WATER * CommonConstants.MONTH_DAYS);
	}
}
