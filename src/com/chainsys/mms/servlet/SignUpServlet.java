package com.chainsys.mms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.mms.model.Patients;
import com.chainsys.mms.services.SignUpServices;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// int pat_id =Integer.parseInt(request.getParameter("pat_id"));
		String pat_name = request.getParameter("pat_name");
		int pat_age = Integer.parseInt(request.getParameter("pat_age"));
		long contact_num = Long.parseLong(request.getParameter("contact_num"));
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		String pat_gender = request.getParameter("gender");
		Patients p = new Patients();
		// p.setPat_id(pat_id);
		p.setPat_name(pat_name);
		p.setPat_age(pat_age);
		p.setContact_num(contact_num);
		p.setUser_name(user_name);
		p.setUser_pwd(user_pwd);
		p.setPat_gender(pat_gender);

		SignUpServices sus = new SignUpServices();

		try {
			boolean b = true;

			if (b) {
				System.out.println(" Inserting......");
				sus.insertPatients(p);
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("incorrectSignUp.html");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
