package com.chainsys.mms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.chainsys.mms.model.DoctorList;
import com.chainsys.mms.model.Symptoms;
import com.chainsys.mms.services.SympServices;


public class NeuroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(NeuroServlet.class);

	public NeuroServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Sym =request.getParameter("Symp");
		log.debug(Sym);
		Symptoms s = new Symptoms();
		s.setSym_name(Sym);
		log.debug(s.getSym_name());
		SympServices ss = new SympServices();
		List<DoctorList> list = null;
		boolean b = true;
		if (b) {
			try {
				list = ss.findDoc(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			HttpSession session=request.getSession(false);
			session.setAttribute("DOCTOR", list);
			System.out.println("List in servlet" + list);
			request.setAttribute("SY", list);
			RequestDispatcher rd = request.getRequestDispatcher("NeuroSymptom.jsp");
			rd.include(request, response);
		
	}
}
}