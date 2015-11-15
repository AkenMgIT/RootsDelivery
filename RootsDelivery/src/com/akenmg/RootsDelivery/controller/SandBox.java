package com.akenmg.RootsDelivery.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akenmg.RootsDelivery.Dao.DaoConnexion;
import com.akenmg.RootsDelivery.Dao.DaoFactory;
import com.akenmg.RootsDelivery.dataObject.*;
import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class SandBox
 */
@WebServlet("/SandBox")
public class SandBox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SandBox() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "dytda3ltu",
				  "api_key", "381597415628764",
				  "api_secret", "Fo6Vyj7kMmj-0P-GADFoBR5n4zM"));
//		
//		SingletonManager manager = new SingletonManager();
//		manager.setCloudinary(cloudinary);
//		manager.init();
//		
//		Map result = cloudinary.uploader().upload(new File("C:/Users/AkenDev/Pictures/products/mojito-thumb.jpg"), 
//				ObjectUtils.asMap(
//				  "public_id", "test_id_mojito",
//				  "tags", "test"
//				  ));
		String url = cloudinary.url().format("jpg")
		  .generate("test_id_mojito");
		response.getWriter().println(url);
		
		//--------------------------------------------------------------------------------------
		
		//DaoFactory dao = new DaoFactory();
		
		
		
		//-----------------------------------TEST UPDATE
		
		/*
		Plat plat = dao.getDaoPlat().find(2);
		plat.setDescription("une description updaté");
		plat.setImg("avc une image?");
		dao.getDaoPlat().update(plat);
		 */
		
		
		//-----------------------------------TEST Delete
		/*
		response.getWriter().println("Avant delete");
		dao.getDaoPlat().delete(2);
		response.getWriter().println("Après delete");
		*/
		

		//-----------------------------------TEST FIND
		
		/*
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(dao.getDaoPlat().find(1));
		response.getWriter().println(json);
		*/
	
		
		//-----------------------------------TEST INSERT
		
		/*
		Plat plat = new Plat();
		plat.setTitre("Banane");
		plat.setDescription("meh");
		plat.setPrix(1000);
		response.getWriter().println("------------------------Avant input");
		dao.getDaoPlat().create(plat);
		response.getWriter().println("------------------------Après l'input");
		*/
		
		//-----------------------------------TEST GET ALL
		
		/*
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(dao.getDaoPlat().getAll());
		response.getWriter().println("------------------------GET ALL PLATS");
		response.getWriter().println(json);
		*/
		
		//---------------------------------------------------------------------------------------
		
		
		//-----------------------------------TEST UPDATE ADMIN
		/*
		Admin admin = dao.getDaoAdmin().find(1);
		admin.setMdp("12345678");
		dao.getDaoAdmin().update(admin);
		*/
		
		/*
		Client client = dao.getDaoClient().find(2);
		client.setMdp("12345678");
		dao.getDaoClient().update(client);
		*/
		
		//-----------------------------------TEST Delete ADMIN
		/*
		response.getWriter().println("Avant delete");
		dao.getDaoAdmin().delete(2);
		response.getWriter().println("Après delete");
		*/
		
		/*
		response.getWriter().println("Avant delete");
		dao.getDaoClient().delete(2);
		response.getWriter().println("Après delete");
		*/
		
		//-----------------------------------TEST FIND ADMIN
		/*
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Admin> admins = dao.getDaoAdmin().getAll() ;
		String json = gson.toJson(dao.getDaoAdmin().find(2));
		response.getWriter().println(json);
		*/
		
		/*
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(dao.getDaoClient().find(1));
		response.getWriter().println(json);
		*/
		
		//-----------------------------------TEST INSERT ADMIN
		/*
		Admin admin = new Admin();
		admin.setLogin("test");
		admin.setMdp("test");
		response.getWriter().println("------------------------Avant input");
		dao.getDaoAdmin().create(admin);
		response.getWriter().println("------------------------Après l'input");
		 */	
		
		/*
		Client client = new Client(0, "testnom", "testprenom", "testnumero", "testemail", "testmdp");
		response.getWriter().println("------------------------Avant input");
		dao.getDaoClient().create(client);
		response.getWriter().println("------------------------Après l'input");
		*/
		
		//-----------------------------------TEST GET ALL ADMIN
		
		/*
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Admin> admins = dao.getDaoAdmin().getAll();
		String json = gson.toJson(dao.getDaoAdmin().getAll());
		response.getWriter().println("------------------------GET ALL ADMINS");
		response.getWriter().println(json);
		*/
		
		
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(dao.getDaoClient().getAll());
//		response.getWriter().println("------------------------GET ALL CLIENTS");
//		response.getWriter().println(json);
		
		
		
		//-----------------------------------TEST DE LA CONNEXION
		/*
		Connection herokuConnection = null;
		try {
			herokuConnection = DaoConnexion.getConnection();
		} catch (URISyntaxException | SQLException e) {
			e.printStackTrace();
		}finally{
			if(herokuConnection!=null){
				try {
					herokuConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
