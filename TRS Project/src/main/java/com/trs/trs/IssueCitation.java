package com.trs.trs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IssueCitation {

	// These two Maps store both these objects with the drivers license as the keys.
	// These MAPS are public and static so we are able to access and alter them directly
	public static HashMap<String, List<VehicleStatus>> vehicleOffenseMap = new HashMap<>();
	public static HashMap<String, List<DriverStatus>> driverOffenseMap = new HashMap<>();

	public IssueCitation() {
	}

	// If it is a vehicle offense, we use this method
	public void addCitationToVehicleOffenseMap(String agentId, String ownerFullName, String driversLicense,
			String carYearMakeModel, String carLicensePlate, String vehicleViolation, String additionalComments,
			String date) throws FileNotFoundException {

		VehicleStatus v = new VehicleStatus(agentId, ownerFullName, driversLicense, carYearMakeModel, carLicensePlate,
				vehicleViolation, additionalComments, date);

		// Verify if the name and driversLicense combination is valid.
		if (new Citizen().isValid(ownerFullName, driversLicense)) {

			// If the key already exists.
			if (vehicleOffenseMap.containsKey(driversLicense)) {

				// Get the list from the map
				List<VehicleStatus> vehicleOffenseList = vehicleOffenseMap.get(driversLicense);
				// Update the list
				vehicleOffenseList.add(v);
				// Add the updated list back into MAP
				IssueCitation.vehicleOffenseMap.put(driversLicense, vehicleOffenseList);
			}
			// If the key does not exist.
			else {

				// Create a list to hold the new vehicleStatus object
				List<VehicleStatus> list = new ArrayList<>();
				// Fill the list with the new vehicleStatus Object
				list.add(v);
				// Add the list to the map with the corresponding driversLicense KEY
				IssueCitation.vehicleOffenseMap.put(driversLicense, list);
			}
		} else
				throw new TRSException("Offender name and driver's license combination is invalid");
	}

	// If it is a citizen offense, we use this method
	public void addCitationToDriverOffenseMap(boolean arrestWarrant, String agentId, String ownerFullName,
			String driversLicense, String violationType, String additionalComments, String date)
			throws FileNotFoundException {

		DriverStatus d = new DriverStatus(arrestWarrant, agentId, ownerFullName, driversLicense, violationType,
				additionalComments, date);

		// Verify if the name and driversLicense combination is valid.
		if (new Citizen().isValid(ownerFullName, driversLicense)) {

			// If the key already exists.
			if (driverOffenseMap.containsKey(driversLicense)) {

				// Get the list from the map
				List<DriverStatus> driverOffenseList = driverOffenseMap.get(driversLicense);
				// Update the list
				driverOffenseList.add(d);
				// Add the updated list back into MAP
				IssueCitation.driverOffenseMap.put(driversLicense, driverOffenseList);
			}
			// If the key does not exist.
			else {

				// Create a list to hold the new vehicleStatus object
				List<DriverStatus> list = new ArrayList<>();
				// Fill the list with the new vehicleStatus Object
				list.add(d);
				// Add the list to the map with the corresponding driversLicense KEY
				IssueCitation.driverOffenseMap.put(driversLicense, list);
			}
		} else
			throw new TRSException("Offender name and driver's license combination is invalid");
	}

	public HashMap<String, List<VehicleStatus>> getVehicleOffenseMap() {
		return vehicleOffenseMap;
	}

	public HashMap<String, List<DriverStatus>> getDriverOffenseMap() {
		return driverOffenseMap;
	}
	
	
	// Can use an iterator to access a list of objects and iterate through to find of get values
	
//	Iterator<yellowPate> iter = ob1.iterator();
//	while(iter.hasNext())
//	{
//	    yellowPage yp = iter.next();
//	    yp.whateverYouwantGet();
//	}

}
