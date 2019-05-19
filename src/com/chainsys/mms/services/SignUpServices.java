package com.chainsys.mms.services;

import com.chainsys.mms.dao.PatientsDAO;
import com.chainsys.mms.model.Patients;

public class SignUpServices {
	
	public void insertPatients(Patients p) {
		
		
		PatientsDAO dao = new PatientsDAO();
		
		
		  try {
			dao.addPatients(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
	}
	
}
