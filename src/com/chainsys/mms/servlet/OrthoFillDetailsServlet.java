package com.chainsys.mms.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.chainsys.mms.dao.AppointmentsDAO;
import com.chainsys.mms.model.Appointments;

public class OrthoFillDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(OrthoFillDetailsServlet.class);
	public OrthoFillDetailsServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Appointments ap = new Appointments();
		String doctor = request.getParameter("dname");
		log.debug(doctor);
		String time = request.getParameter("time");
		log.debug(time);
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		log.debug(date);
		ap.setDoc_name(doctor);
		ap.setApp_time(time);
		ap.setApp_date(date);
		System.out.println(ap.toString());
		HttpSession session = request.getSession();
		String user_name = (String) session.getAttribute("user_name");
		request.setAttribute("user_name", user_name);
		System.out.println(date);
		
		AppointmentsDAO dao = new AppointmentsDAO();
		try {

			HttpSession session1 = request.getSession(false);
			session.setAttribute("date", date);
			session.setAttribute("time", time);
			session.setAttribute("dname", doctor);
			String uname = (String) session1.getAttribute("user_name");
			dao.addDetails(ap, uname);
			ArrayList<Appointments> list = dao.findall(uname);
			request.setAttribute("appointments", list);
			RequestDispatcher rd = request.getRequestDispatcher("OrthoDetailsList.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
