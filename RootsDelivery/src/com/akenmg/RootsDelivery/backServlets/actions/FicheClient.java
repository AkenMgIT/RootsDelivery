package com.akenmg.RootsDelivery.backServlets.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akenmg.RootsDelivery.Dao.DaoFactory;
import com.akenmg.RootsDelivery.dataObject.Client;

/**
 * Servlet implementation class FicheClient
 */
@WebServlet("/backoffice/FicheClient")
public class FicheClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "/backoffice/ficheClient.jsp" ;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idClient;
		Client client;
		if(request.getParameter("id")!=null){
			idClient = Integer.parseInt(request.getParameter("id"));
			DaoFactory dao = new DaoFactory();
			client = dao.getDaoClient().find(idClient.intValue());
			request.setAttribute("client", client);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
