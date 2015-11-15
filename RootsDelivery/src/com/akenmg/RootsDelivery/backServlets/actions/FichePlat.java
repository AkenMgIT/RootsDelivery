package com.akenmg.RootsDelivery.backServlets.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akenmg.RootsDelivery.Dao.DaoFactory;
import com.akenmg.RootsDelivery.dataObject.Client;
import com.akenmg.RootsDelivery.dataObject.Plat;

/**
 * Servlet implementation class FichePlat
 */
@WebServlet("/backoffice/FichePlat")
public class FichePlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "/backoffice/fichePlat.jsp" ;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idPlat;
		Plat plat;
		if(request.getParameter("id")!=null){
			idPlat = Integer.parseInt(request.getParameter("id"));
			DaoFactory dao = new DaoFactory();
			plat = dao.getDaoPlat().find(idPlat.intValue());
			request.setAttribute("plat", plat);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}


}
