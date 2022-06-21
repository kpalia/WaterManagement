/**
 * 
 */
package com.geektrust.watermanagement.app;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.geektrust.watermanagement.classes.GeekHieghtsFactoryClass;
import com.geektrust.watermanagement.constants.CommonConstants;
import com.geektrust.watermanagement.interfaces.GeekHeightsApartment;

/**
 * @author Kamal.Palia
 *
 */
public class WaterManagementApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WaterManagementApp waterMgmtApp = new WaterManagementApp();
		waterMgmtApp.performAction(waterMgmtApp.readExpenseFileInList(args[CommonConstants.INDEX_0]));
	}

	/*
	 * @desc: Code read the file and returns the list containing lines
	 * @param: Absolute file path
	 */
	private List<String> readExpenseFileInList(String fileName)
	{
		List<String> lines = Collections.emptyList();
		try
		{
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		return lines;
	}

	/*
	 * @desc: Code reads the data line by line and perform respective actions.
	 * @param: List having lines
	 */
	private void performAction(List<String> lines) {
		String eachRecord = "";
		String[] recordArray;
		Iterator<String> itr = lines.iterator();
		GeekHeightsApartment aptChildreference = null;

		while (itr.hasNext()) {
			eachRecord = itr.next();
			recordArray = eachRecord.split(" ");
			switch(recordArray[0]) {
				case CommonConstants.ALLOT_WATER:
					aptChildreference = GeekHieghtsFactoryClass.getInstance(recordArray[1]);
					aptChildreference.allotWater(recordArray[2]);
					break;
				case CommonConstants.ADD_GUESTS:
					if(null!=aptChildreference)
						aptChildreference.addGuests(Integer.parseInt(recordArray[1]));
					break;
				case CommonConstants.BILL:
					if(null!=aptChildreference)
						printOutput(aptChildreference.generateWaterBill());
					break;
				default:
					System.out.println("No data to perform action");
			}
		}
	}

	private void printOutput(String returnValue) {
		String[] bill = returnValue.split(":");
		System.out.println(bill[0] + " " + bill[1]);
	}

}
