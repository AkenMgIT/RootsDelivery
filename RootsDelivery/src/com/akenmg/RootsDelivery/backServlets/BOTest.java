package com.akenmg.RootsDelivery.backServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BOTest
 */
@WebServlet("/backoffice/BOTest")
public class BOTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BOTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("BO Test : GET");
		response.getWriter().println("Parameter -> titre plat = " + request.getParameter("titre"));
		response.getWriter().println("Attribute -> titre plat = " + request.getAttribute("titre"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.getWriter().println("BO Test : POST");
		response.getWriter().println("Parameter -> titre plat = " + request.getParameter("titre"));
		response.getWriter().println("Attribute -> titre plat = " + request.getAttribute("titre"));
	}

}
