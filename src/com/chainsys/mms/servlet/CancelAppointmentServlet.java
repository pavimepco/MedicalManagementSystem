package com.chainsys.mms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.mms.dao.AppointmentsDAO;
import com.chainsys.mms.model.Appointments;

@WebServlet("/CancelAppointmentServlet")
public class CancelAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CancelAppointmentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		Appointments a = new Appointments();
		a.setUserid(userid);
		HttpSession session = request.getSession();
		String user_name = (String) session.getAttribute("user_name");
		request.setAttribute("user_name", user_name);
		AppointmentsDAO dao = new AppointmentsDAO();
		try {
			dao.deleteAppointment(userid);
			RequestDispatcher rd = request.getRequestDispatcher("Success.html");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
