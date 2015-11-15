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
import com.akenmg.RootsDelivery.dataObject.Client;

/**
 * Servlet implementation class ListeClient
 */
@WebServlet("/backoffice/ListeClient")
public class ListeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "/backoffice/listeClient.jsp" ;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory dao = new DaoFactory();
		List<Client> clients = new ArrayList<Client>();
		clients = dao.getDaoClient().getAll();
		request.setAttribute("clients", clients);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
