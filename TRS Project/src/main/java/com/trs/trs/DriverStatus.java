package com.trs.trs;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;

public class DriverStatus {

	private boolean arrestWarrant;
	private String agentId;
	private String ownerFullName;
	private String driversLicense;
	private String violationType;
	private String additionalComments;
	private String date;

	public DriverStatus(boolean arrestWarrant, String agentId, String ownerFullName, String driversLicense,
			String violationType, String additionalComments, String date) {
		super();
		this.arrestWarrant = arrestWarrant;
		this.agentId = agentId.toLowerCase();
		this.ownerFullName = ownerFullName.toLowerCase();
		this.driversLicense = driversLicense.toLowerCase();
		this.violationType = violationType.toLowerCase();
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



	public boolean isArrestWarrant() {
		return arrestWarrant;
	}



	public void setArrestWarrant(boolean arrestWarrant) {
		this.arrestWarrant = arrestWarrant;
	}



	public String getAgentId() {
		return agentId.toUpperCase();
	}



	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}



	public String getOwnerFullName() {
		return ownerFullName.toUpperCase();
	}



	public void setOwnerFullName(String ownerFullName) {
		this.ownerFullName = ownerFullName;
	}



	public String getDriversLicense() {
		return driversLicense.toUpperCase();
	}



	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense;
	}



	public String getViolationType() {
		return violationType.toUpperCase();
	}



	public void setViolationType(String violationType) {
		this.violationType = violationType;
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
