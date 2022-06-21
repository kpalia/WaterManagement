package com.geektrust.watermanagement.model;

public class FileRecord {
	private String commandName = null;
	private String apartmentType = null;
	private String waterConsumptionRatio = null;
	
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getApartmentType() {
		return apartmentType;
	}
	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}
	public String getWaterConsumptionRatio() {
		return waterConsumptionRatio;
	}
	public void setWaterConsumptionRatio(String waterConsumptionRatio) {
		this.waterConsumptionRatio = waterConsumptionRatio;
	}
			
}
