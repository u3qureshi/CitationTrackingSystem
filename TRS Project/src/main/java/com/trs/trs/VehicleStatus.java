package com.trs.trs;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class VehicleStatus {

	private String agentId;
	private String ownerFullName;
	private String driversLicense;
	private String carLicensePlate;
	private String carYearMakeModel;
	private String vehicleViolation;
	private String additionalComments;
	private String date;
	
	public VehicleStatus(String agentId, String ownerFullName, String driversLicense, String carYearMakeModel, String carLicensePlate,
			 String vehicleViolation, String additionalComments, String date) throws FileNotFoundException {
		this.agentId = agentId.toLowerCase();
		this.ownerFullName = ownerFullName.toLowerCase();
		this.driversLicense = driversLicense.toLowerCase();
		this.carLicensePlate = carLicensePlate.toLowerCase();
		this.carYearMakeModel = carYearMakeModel.toLowerCase();
		this.vehicleViolation = vehicleViolation.toLowerCase();
		this.additionalComments = additionalComments.toLowerCase();
		this.date = date.toLowerCase();
				
	}

	// This getter information is to get the CitizenClass of the driver by the full name and drivers license
	public Citizen getCitizen() throws FileNotFoundException {
		Citizen c = new Citizen();
		//Get the citizen hashmap
		HashMap<String, Citizen> citizenMap = c.getCitizenMap();
		Citizen citizen = citizenMap.get(this.ownerFullName);
		return citizen;
	}
	public String getAgentId() {
		return agentId.toUpperCase();
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId.toLowerCase();
	}

	public String getOwnerFullName() {
		return ownerFullName.toUpperCase();
	}

	public void setOwnerFullName(String ownerFullName) {
		this.ownerFullName = ownerFullName.toLowerCase();
	}

	public String getDriversLicense() {
		return driversLicense.toUpperCase();
	}

	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense.toLowerCase();
	}

	public String getCarLicensePlate() {
		return carLicensePlate.toUpperCase();
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate.toLowerCase();
	}

	public String getCarYearMakeModel() {
		return carYearMakeModel.toUpperCase();
	}

	public void setCarYearMakeModel(String carYearMakeModel) {
		this.carYearMakeModel = carYearMakeModel.toLowerCase();
	}

	public String getVehicleViolation() {
		return vehicleViolation.toUpperCase();
	}

	public void setVehicleViolation(String vehicleViolation) {
		this.vehicleViolation = vehicleViolation.toLowerCase();
	}

	public String getAdditionalComments() {
		return additionalComments.toUpperCase();
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	public String getDate() {
		return date.toUpperCase();
	}
}
