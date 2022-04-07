package com.trs.trs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Officer {
	
	private String fullName;
	private String agentID;
	private String username;
	private String password;
	
	public static HashMap<String, Officer> officerMap = new HashMap<>();
	
	public Officer() throws FileNotFoundException {
		addOfficersToHashTableFromFile();
	}

	private Officer(String fullName, String agentID, String username, String password) {
		super();
		this.fullName = fullName.toLowerCase();
		this.agentID = agentID.toLowerCase();
		this.username = username;
		this.password = password;
	}

	private void addOfficersToHashTableFromFile() throws FileNotFoundException {
		
		File file1 = new File("officers.txt");
		Scanner input = new Scanner(file1);
		String s;
		while (input.hasNextLine()) {
			s = input.nextLine();
			String[] pieces = s.split(":");
			
			for(int i=0; i<pieces.length; i++) {
				pieces[i] = pieces[i].trim();
			}
			Officer o = new Officer(pieces[0], pieces[1], pieces[2], pieces[3]);
			
			officerMap.put(pieces[1].toLowerCase(), o);

			officerMap.put(pieces[0].toLowerCase(), o);
		}		
	}
	
	public String getFullName() {
		return fullName.toUpperCase();
	}

	public void setFullName(String fullName) {
		this.fullName = fullName.toLowerCase();
	}

	public String getAgentID() {
		return agentID.toUpperCase();
	}

	public void agentID(String agentID) {
		agentID = agentID.toLowerCase();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password.toLowerCase();
	}
	public HashMap<String, Officer> getOfficerMap() {
		return officerMap;
	}

	public boolean isValid(String name, String driversLicense) {
		//name and id keys are lowercase in the HashMap.
		name = name.toLowerCase();
		if(officerMap.containsKey(name) && officerMap.containsKey(driversLicense)) {
			if (officerMap.get(driversLicense).username.equals(officerMap.get(name).username))
				return true;
			else return false;
		}
		else
			return false;
	}

	public boolean isValid(String agentID) {
		//name and id keys are lowercase in the HashMap.
		if(officerMap.containsKey(agentID))
			return true;

		else
			return false;
	}
}	