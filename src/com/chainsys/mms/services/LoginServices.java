package com.chainsys.mms.services;

import java.sql.SQLException;

import com.chainsys.mms.dao.PatientsDAO;
import com.chainsys.mms.model.Patients;

public class LoginServices {

	public boolean existPatients(Patients p) {
		PatientsDAO dao = new PatientsDAO();
		boolean b = false;
		try {
			b = dao.existingPatients(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
}
