package com.chainsys.mms.services;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.mms.dao.SymptomsDAO;
import com.chainsys.mms.model.DoctorList;
import com.chainsys.mms.model.Symptoms;

public class SympServices {

	SymptomsDAO dao = new SymptomsDAO();

	public boolean checkSymp(Symptoms s) {
		boolean b = false;
		try {
			b = dao.checkSymptoms(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public List<DoctorList> findDoc(Symptoms s) throws SQLException {

		List<DoctorList> dl = dao.findDoctor(s);
		return dl;
	}

}
