package com.chainsys.mms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.chainsys.mms.model.Patients;
import com.chainsys.mms.services.SignUpServices;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(SignUpServlet.class);

	public SignUpServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pat_name = request.getParameter("pat_name");
		log.debug(pat_name);
		int pat_age = Integer.parseInt(request.getParameter("pat_age"));
		long contact_num = Long.parseLong(request.getParameter("contact_num"));
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		String pat_gender = request.getParameter("gender");
		Patients p = new Patients();
		p.setPat_name(pat_name);
		p.setPat_age(pat_age);
		p.setContact_num(contact_num);
		p.setUser_name(user_name);
		p.setUser_pwd(user_pwd);
		p.setPat_gender(pat_gender);
		SignUpServices sus = new SignUpServices();
		try {
			boolean b = sus.insertPatients(p);
			if (b) {
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("incorrectSignUp.html");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			e.printStackTrace();
		}
	}
}
