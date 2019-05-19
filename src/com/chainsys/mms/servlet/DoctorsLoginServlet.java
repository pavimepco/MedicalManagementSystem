package com.chainsys.mms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.mms.model.Employees;
import com.chainsys.mms.services.DoctorsLoginServices;

public class DoctorsLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DoctorsLoginServlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email =request.getParameter("email");	
		String password =request.getParameter("password");
		
		Employees e = new Employees();
		
		e.setEmp_email(email);
		e.setEmp_pwd(password);
	
		 HttpSession session=request.getSession();  
	     session.setAttribute("email" , email);  
	        
	     request.setAttribute("email",email);
		
	    DoctorsLoginServices dls=new DoctorsLoginServices();
		boolean b =  dls.existDoctors(e);
		if(b){	
			   
		      RequestDispatcher rd = request.getRequestDispatcher("ViewPatients.html");
			  rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("inCorrectDoctorLogin.html");		
			rd.forward(request, response);
		}

		doGet(request, response);
	}

}
