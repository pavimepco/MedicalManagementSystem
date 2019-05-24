package com.chainsys.mms.services;

import com.chainsys.mms.dao.PatientsDAO;

import com.chainsys.mms.model.Patients;

public class SignUpServices {

	public boolean insertPatients(Patients p) throws Exception {
       boolean b=false;
		PatientsDAO dao = new PatientsDAO();
		try {
			b=dao.addPatients(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
