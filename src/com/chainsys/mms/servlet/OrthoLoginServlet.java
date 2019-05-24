package com.chainsys.mms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.chainsys.mms.model.Patients;
import com.chainsys.mms.services.LoginServices;



public class OrthoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
		static final Logger log = Logger.getLogger(OrthoLoginServlet.class);  
   
    public OrthoLoginServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PropertyConfigurator.configure("D:\\Oxify\\MedicalManagementSystem\\src\\log4j.properties");
		log.debug(" ----  Invoked LoginServlet doPost method ----");
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		log.debug(" ----  user_name: "+ user_name);
		log.debug(" ----  user_pwd: "+ user_pwd);
		Patients p = new Patients();
		p.setUser_name(user_name);
		p.setUser_pwd(user_pwd);
		HttpSession session = request.getSession();
		session.setAttribute("user_name", user_name);
		request.setAttribute("user_name", user_name);
		LoginServices ls = new LoginServices();
		boolean b = ls.existPatients(p);
		if (b) {
			RequestDispatcher rd = request.getRequestDispatcher("OrthoFillDetails.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("incorrectLogin.html");
			rd.forward(request, response);
		}
		
	}

}
