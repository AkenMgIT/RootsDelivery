package com.akenmg.RootsDelivery.backServlets.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akenmg.RootsDelivery.Dao.DaoFactory;
import com.akenmg.RootsDelivery.dataObject.Client;
import com.akenmg.RootsDelivery.util.UtilApp;

/**
 * Servlet implementation class UpdateClient
 */
@WebServlet("/backoffice/UpdateClient")
public class UpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "ListeClient" ;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client ;
		DaoFactory dao = new DaoFactory();
		String nom = (String)request.getParameter("nom");
		String prenom = (String)request.getParameter("prenom");
		String numero = (String)request.getParameter("numero");
		String email = (String)request.getParameter("email");
		String mdp = (String)request.getParameter("mdp");
		if(request.getParameter("id")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			client = dao.getDaoClient().find(id);
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setNumero(numero);
			client.setEmail(email);
			client.setMdp(mdp);
			dao.getDaoClient().update(client);
		}
		response.sendRedirect(url);
	}

}
