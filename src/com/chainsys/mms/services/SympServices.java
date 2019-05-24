package com.chainsys.mms.services;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.mms.dao.SymptomsDAO;
import com.chainsys.mms.model.DoctorList;
import com.chainsys.mms.model.Symptoms;

public class SympServices {

	SymptomsDAO dao = new SymptomsDAO();

	public boolean checkSymp(Symptoms s) throws SQLException{
		boolean b = false;
		
			b = dao.checkSymptoms(s);
		return b;
	}

	public List<DoctorList> findDoc(Symptoms s) throws SQLException {
		List<DoctorList> dl = dao.findDoctor(s);
		return dl;
	}
}
