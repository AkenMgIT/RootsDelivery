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
import com.akenmg.RootsDelivery.util.UtilApp;
import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.utils.ObjectUtils;

/**
 * Servlet implementation class UpdatePlat
 */
@WebServlet("/backoffice/UpdatePlat")
public class UpdatePlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "ListePlat" ;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Plat plat ;
		DaoFactory dao = new DaoFactory();
		String titre = (String)request.getParameter("titre");
		String description = (String)request.getParameter("description");
		int prix = 0;
		if(request.getParameter("prix")!=null){
			if(UtilApp.isNumber(request.getParameter("prix"))){
				prix = Integer.parseInt(request.getParameter("prix")) ;
			}else{
				prix = 0 ;
			}
		}
		
		if(request.getParameter("id")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			plat = dao.getDaoPlat().find(id);
			plat.setTitre(titre);
			plat.setDescription(description);
			plat.setPrix(prix);
			System.out.println("update attempt");
			dao.getDaoPlat().update(plat);
			System.out.println("update success");
		}
		
//		String CLOUDINARY_URL="cloudinary://381597415628764:Fo6Vyj7kMmj-0P-GADFoBR5n4zM@dytda3ltu";
//		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
//				  "cloud_name", "dytda3ltu",
//				  "api_key", "381597415628764",
//				  "api_secret", "Fo6Vyj7kMmj-0P-GADFoBR5n4zM"));
//		
//		SingletonManager manager = new SingletonManager();
//		manager.setCloudinary(cloudinary);
//		manager.init();
		
		response.sendRedirect(url);
	}

}
