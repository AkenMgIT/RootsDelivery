package com.akenmg.RootsDelivery.backServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akenmg.RootsDelivery.Dao.DaoFactory;
import com.akenmg.RootsDelivery.dataObject.Plat;

/**
 * Servlet implementation class ListePlat
 */
@WebServlet("/backoffice/ListePlat")
public class ListePlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "/backoffice/listePlat.jsp" ;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory dao = new DaoFactory();
		List<Plat> plats = new ArrayList<Plat>();
		plats = dao.getDaoPlat().getAll();
		request.setAttribute("plats", plats);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
