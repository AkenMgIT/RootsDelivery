package com.akenmg.RootsDelivery.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.akenmg.RootsDelivery.dataObject.Admin;
import com.akenmg.RootsDelivery.dataObject.Plat;

public class DaoPlat implements DaoInterface<Plat>{

	private static final String createQuery = "insert into PLATS (TITREPLAT, DESCRIPTIONPLAT, PRIXPLAT,IMGPLAT) values (?, ?, ?, ?)";
	private static final String findQuery = "SELECT * FROM PLATS WHERE IDPLAT = ?";
	private static final String deleteQuery = "DELETE FROM PLATS WHERE IDPLAT = ?";
	private static final String updateQuery = "UPDATE PLATS SET TITREPLAT=?,DESCRIPTIONPLAT=?,PRIXPLAT=?,IMGPLAT=? WHERE IDPLAT=?";
	private static final String getAllQuery = "SELECT * FROM PLATS";
	
	@Override
	public void create(Plat obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(createQuery);
			preparedStatement.setString(1, obj.getTitre());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setInt(3, obj.getPrix());
			preparedStatement.setString(4, obj.getImg());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public Plat find(int id) {
		Plat plat = null;
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(findQuery);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				plat = mapRes(rs);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return plat;
	}

	@Override
	public void delete(int id) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Plat obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(updateQuery);
			preparedStatement.setString(1, obj.getTitre());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setInt(3, obj.getPrix());
			preparedStatement.setString(4, obj.getImg());
			preparedStatement.setInt(5, obj.getId());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Plat> getAll() {
		List<Plat> plats = new ArrayList<Plat>();
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(getAllQuery);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				plats.add(mapRes(rs));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return plats;
	}

	private Plat mapRes(ResultSet rs) {
		Plat plat = new Plat();
		try{
			plat.setId(rs.getInt("IDPLAT"));
			plat.setTitre(rs.getString("TITREPLAT"));
			plat.setDescription(rs.getString("DESCRIPTIONPLAT"));
			plat.setPrix(rs.getInt("PRIXPLAT"));
			plat.setImg(rs.getString("IMGPLAT"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return plat;
	}

}
