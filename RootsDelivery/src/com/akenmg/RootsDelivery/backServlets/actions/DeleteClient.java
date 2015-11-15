package com.akenmg.RootsDelivery.backServlets.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akenmg.RootsDelivery.Dao.DaoFactory;

/**
 * Servlet implementation class DeleteClient
 */
@WebServlet("/backoffice/DeleteClient")
public class DeleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "ListeClient" ;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory dao = new DaoFactory();
		if(request.getParameter("id")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			dao.getDaoClient().delete(id);
		}
		response.sendRedirect(url);
	}


}
