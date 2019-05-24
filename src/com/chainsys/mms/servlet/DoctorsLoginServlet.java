package com.chainsys.mms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.chainsys.mms.model.Employees;
import com.chainsys.mms.services.DoctorsLoginServices;

public class DoctorsLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(DoctorsLoginServlet.class);

	public DoctorsLoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		log.debug(email);
		String password = request.getParameter("password");
		log.debug(password);
		HttpSession session = request.getSession();
		session.setAttribute("d_email", email);
		Employees e = new Employees();
		e.setEmp_email(email);
		e.setEmp_pwd(password);
		HttpSession session1 = request.getSession();
		session1.setAttribute("email", email);
		request.setAttribute("email", email);
		DoctorsLoginServices dls = new DoctorsLoginServices();
		boolean b = dls.existDoctors(e);
		if (b) {

			RequestDispatcher rd = request.getRequestDispatcher("ViewPatients.html");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("inCorrectDoctorLogin.html");
			rd.forward(request, response);
		}
	}
}
