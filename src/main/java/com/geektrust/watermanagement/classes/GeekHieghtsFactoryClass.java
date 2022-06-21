package com.geektrust.watermanagement.classes;

import com.geektrust.watermanagement.constants.CommonConstants;
import com.geektrust.watermanagement.interfaces.GeekHeightsApartment;

public class GeekHieghtsFactoryClass {
	
	private GeekHieghtsFactoryClass() {}
	
	public static GeekHeightsApartment getInstance(String apartmentType) {
		if(CommonConstants.COUNT_2 == Integer.parseInt(apartmentType)) {
			return new TwoBhkApartment(CommonConstants.COUNT_3);
		} else {
			return new ThreeBhkApartment(CommonConstants.COUNT_5);
		}
	}
}
