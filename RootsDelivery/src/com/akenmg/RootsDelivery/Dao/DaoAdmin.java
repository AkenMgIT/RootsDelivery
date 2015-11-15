package com.akenmg.RootsDelivery.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.akenmg.RootsDelivery.dataObject.Admin;

public class DaoAdmin implements DaoInterface<Admin>{

	private static final String createQuery = "insert into ADMINS (LOGINADMIN, MDPADMIN) values (?, ?)";
	private static final String findQuery = "SELECT * FROM ADMINS WHERE IDADMIN = ?";
	private static final String deleteQuery = "DELETE FROM ADMINS WHERE IDADMIN = ?";
	private static final String updateQuery = "UPDATE ADMINS SET LOGINADMIN=?,MDPADMIN=? WHERE IDADMIN=?";
	private static final String getAllQuery = "SELECT * FROM ADMINS";
	
	@Override
	public void create(Admin obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(createQuery);
			preparedStatement.setString(1, obj.getLogin());
			preparedStatement.setString(2, obj.getMdp());
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
	public Admin find(int id) {
		Admin admin = null;
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(findQuery);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				admin = mapRes(rs);
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
		return admin;
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
	public void update(Admin obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(updateQuery);
			preparedStatement.setString(1, obj.getLogin());
			preparedStatement.setString(2, obj.getMdp());
			preparedStatement.setInt(3, obj.getId());
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
	public List<Admin> getAll() {
		List<Admin> admins = new ArrayList<Admin>();
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(getAllQuery);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				admins.add(mapRes(rs));
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
		return admins;
	}

	private Admin mapRes(ResultSet rs) {
		Admin admin = new Admin();
		try{
			admin.setId(rs.getInt("IDADMIN"));
			admin.setLogin(rs.getString("LOGINADMIN"));
			admin.setMdp(rs.getString("MDPADMIN"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return admin;
	}

	
}
