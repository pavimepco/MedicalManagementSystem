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

import com.chainsys.mms.dao.AppointmentsDAO;
import com.chainsys.mms.model.Appointments;


public class FillDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FillDetailsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Appointments ap=new Appointments();

		String doctor=request.getParameter("doctor");
		String time=request.getParameter("time");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		
		ap.setDoc_name(doctor);
		ap.setApp_time(time);
		ap.setApp_date(date);

		
		
		System.out.println(doctor);
		
		
		HttpSession session = request.getSession();
		String user_name = (String) session.getAttribute("user_name");
		request.setAttribute("user_name", user_name);

		AppointmentsDAO dao=new AppointmentsDAO();
		try {
			
			HttpSession session1=request.getSession(false);
			String uname=(String)session1.getAttribute("user_name");
		    dao.addDetails(ap,uname);
      	    ArrayList<Appointments> list=dao.findall(uname);//--->findall(uname)
      	//    list.add(ap);
             
		    request.setAttribute("appointments", list);
			RequestDispatcher rd = request.getRequestDispatcher("DetailsList.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
