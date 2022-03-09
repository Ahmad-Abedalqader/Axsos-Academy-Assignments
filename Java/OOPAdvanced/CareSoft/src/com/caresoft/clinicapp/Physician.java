package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
import java.util.spi.LocaleNameProvider;

import javax.security.auth.x500.X500Principal;
public class Physician extends User implements HIPAACompliantUser {
	
    private ArrayList<String> patientNotes;
    
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
    public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}



	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}



	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}



	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }



	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		
		if (pin < 9999 && pin > 999) {
			this.setPin(pin); 
		}
		return false;
	}



	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (this.id == confirmedAuthID) {
			return true;
		}
		return false;
	}
}
