package com.trs.trs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Citizen {

	private String fullName;
	private String DOB;
	private String carType;
	private String driversLicense;
	private String address;
	private String phoneNumber;
	private String licensePlate;
	private String sex;
	public static HashMap<String, Citizen> citizenMap = new HashMap<>();
	
	public Citizen() throws FileNotFoundException {
		addCitizensToHashTableFromFile();
	}

	private Citizen(String driversLicense, String fullName, String address, String DOB, String sex, String phoneNumber, String carType, String licensePlate) {
		super();
		this.fullName = fullName.toLowerCase();
		this.DOB = DOB.toLowerCase();
		this.carType = carType.toLowerCase();
		this.driversLicense = driversLicense.toLowerCase();
		this.address = address.toLowerCase();
		this.phoneNumber = phoneNumber.toLowerCase();
		this.licensePlate = licensePlate.toLowerCase();
		this.sex = sex.toLowerCase();
	}

	private void addCitizensToHashTableFromFile() throws FileNotFoundException {
		
		File file = new File("citizens.txt");
		Scanner input = new Scanner(file);
		String s;
		while (input.hasNextLine()) {
			s = input.nextLine();
			String[] pieces = s.split(":");
			
			//trim all the whitespaces of each piece in the array
			for(int i=0; i<pieces.length; i++) {
				pieces[i] = pieces[i].trim();
			}
			Citizen c = new Citizen(pieces[0], pieces[1], pieces[2], pieces[3], pieces[4], pieces[5], pieces[6], pieces[7]);
			
			//place the Citizen in the citizenHashMap using their full name
			citizenMap.put(pieces[1].toLowerCase(), c);
			//place the Citizen in the citizenHashMap using their drivers license
			citizenMap.put(pieces[0].toLowerCase(), c);
		}
		
	}
	
	public String getFullName() {
		return fullName.toUpperCase();
	}

	public void setFullName(String fullName) {
		this.fullName = fullName.toLowerCase();
	}

	public String getDOB() {
		return DOB.toUpperCase();
	}

	public void setDOB(String dOB) {
		DOB = dOB.toLowerCase();
	}

	public String getCarType() {
		return carType.toUpperCase();
	}

	public void setCarType(String carType) {
		this.carType = carType.toLowerCase();
	}

	public String getDriversLicense() {
		return driversLicense.toUpperCase();
	}

	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense.toLowerCase();
	}

	public String getAddress() {
		return address.toUpperCase();
	}

	public void setAddress(String address) {
		this.address = address.toLowerCase();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLicensePlate() {
		return licensePlate.toUpperCase();
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getSex() {
		return sex.toUpperCase();
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public HashMap<String, Citizen> getCitizenMap() {
		return citizenMap;
	}
	
	//In this method, the full name(lowercase) and drivers license of the citizen must match for this method to return true
	// If the drivers license does not belong to the person name, or vice versa, then this method returns false.
	// Full name and drivers license combination must be valid
	public boolean isValid(String name, String driversLicense) {
		//name and id keys are lowercase in the HashMap.
		name = name.toLowerCase();
		if(citizenMap.containsKey(name) && citizenMap.containsKey(driversLicense)) {
			if (citizenMap.get(driversLicense).DOB.equals(citizenMap.get(name).DOB))
				return true;
			else return false;
		}
		else
			return false;
	}
	public boolean isValid(String driversLicense) {
		//name and id keys are lowercase in the HashMap.
		if(citizenMap.containsKey(driversLicense))
			return true;

		else
			return false;
	}
	
}
