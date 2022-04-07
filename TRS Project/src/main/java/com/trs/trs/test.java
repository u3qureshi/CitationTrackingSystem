package com.trs.trs;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Citizen c = new Citizen();
		HashMap<String, Citizen> h = c.getCitizenMap();
		Citizen offender = h.get("101715179");
		System.out.println(c.isValid("scott vasko", "725770845"));

		IssueCitation i = new IssueCitation();
		i.addCitationToVehicleOffenseMap("123", "Scott Vasko", "725770845", "2011 Audi A6", "5N40623","popped headlight", "Hes been a Bad boy", "March,1,2019");
		i.addCitationToVehicleOffenseMap("123", "Scott Vasko", "725770845", "2011 Audi A6", "5N40623","popped headlight", "Hes been a Bad boy", "March,1,2019");

		System.out.println(i.vehicleOffenseMap.size());
		List<VehicleStatus> list = i.vehicleOffenseMap.get("725770845");
		//This is how we access the information in a list of objects
		String s;
		for(VehicleStatus l : list) {
			s = l.getAgentId() + " " + l.getOwnerFullName() + " " + l.getDriversLicense() + " " + l.getCarYearMakeModel() + " " + l.getCarLicensePlate();
			System.out.println(s);
		}

	}

}
