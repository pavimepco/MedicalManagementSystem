package com.chainsys.mms.services;

import java.sql.SQLException;

import com.chainsys.mms.dao.EmployeesDAO;
import com.chainsys.mms.model.Employees;

public class DoctorsLoginServices {
	
	
	
	
	public boolean existDoctors(Employees e) 
	{
		
	    EmployeesDAO dao = new EmployeesDAO();
		boolean b = false;
		try {
			b = dao.existingDoctors(e);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return b;
		
	}


}
