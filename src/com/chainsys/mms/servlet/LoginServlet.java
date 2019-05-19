package com.chainsys.mms.servlet;
	
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.mms.model.Patients;
import com.chainsys.mms.services.LoginServices;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_name =request.getParameter("user_name");	
		String user_pwd =request.getParameter("user_pwd");
		
		Patients p = new Patients();
		
		p.setUser_name(user_name);
		p.setUser_pwd(user_pwd);
		
		 HttpSession session=request.getSession();  
	       session.setAttribute("user_name" , user_name);  
	        
	        request.setAttribute("user_name",user_name);
		
		//PatientsDAO dao = new PatientsDAO();
	    LoginServices ls=new LoginServices();
		boolean b =  ls.existPatients(p);
		if(b){	
			  
		      RequestDispatcher rd = request.getRequestDispatcher("SearchSymp.html");
			  rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("incorrectLogin.html");		
			rd.forward(request, response);
		}

		doGet(request, response);
	}

}
