package com.chainsys.mms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.mms.model.DoctorList;
import com.chainsys.mms.model.Symptoms;
import com.chainsys.mms.services.SympServices;

public class SympServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SympServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String search = request.getParameter("sym");
		System.out.println(search);
				
		Symptoms s = new Symptoms();
		s.setSym_name(search);
		System.out.println(s.getSym_name());
		
	//	SymptomsDAO dao = new SymptomsDAO();
		
		SympServices ss=new SympServices();
		boolean b=ss.checkSymp(s);
		System.out.println(b);
		List<DoctorList> list = null;
		if(b) {		
		
		try {
			list = ss.findDoc(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("List in servlet" + list);
		
		request.setAttribute("SY", list);
		RequestDispatcher rd = request.getRequestDispatcher("Symptom.jsp");
		rd.include(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Success.html");
			rd.include(request, response);
		}
		
		doGet(request, response);
	}
	
}
