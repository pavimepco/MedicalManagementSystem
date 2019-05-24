package com.chainsys.mms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.chainsys.mms.model.DoctorList;
import com.chainsys.mms.model.Symptoms;
import com.chainsys.mms.services.SympServices;

public class SympServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(SympServlet.class);

	public SympServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = request.getParameter("sym");
		log.debug(search);
		Symptoms s = new Symptoms();
		s.setSym_name(search);
		log.debug(s.getSym_name());
		SympServices ss = new SympServices();
		boolean b = false;
		try {
			b = ss.checkSymp(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		log.debug(b);
		List<DoctorList> list = null;
		if (b) {
			try {
				list = ss.findDoc(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("List in servlet" + list);
			request.setAttribute("SY", list);
			RequestDispatcher rd = request.getRequestDispatcher("Symptom.jsp");
			rd.include(request, response);
		} else {
			request.setAttribute("error", "Invalid Symptom Name!!");
			RequestDispatcher rd = request.getRequestDispatcher("SearchSymp.jsp");
			rd.include(request, response);
		}
	}
}
