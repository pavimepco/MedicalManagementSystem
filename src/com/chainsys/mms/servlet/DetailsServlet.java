package com.chainsys.mms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(DetailsServlet.class);

	public DetailsServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dname = request.getParameter("name");
		log.debug(dname);
		request.setAttribute("dname", dname);
		RequestDispatcher rd = request.getRequestDispatcher("FillDetails.jsp");
		rd.forward(request, response);
	}
}
