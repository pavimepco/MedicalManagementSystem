package com.chainsys.mms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.mms.dao.AppointmentsDAO;
import com.chainsys.mms.model.Appointments;


public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Appointments ap=new Appointments();
		
		AppointmentsDAO dao = new AppointmentsDAO();
		
		try {
									
			RequestDispatcher rd = request.getRequestDispatcher("DisplayDetails.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
