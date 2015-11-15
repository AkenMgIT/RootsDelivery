package com.akenmg.RootsDelivery.backServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashBoard
 */
@WebServlet({"/backoffice/DashBoard","/backoffice/"})
public class DashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "/backoffice/dashboard.jsp" ;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}

}
