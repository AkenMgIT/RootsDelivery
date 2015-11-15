package com.akenmg.RootsDelivery.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.akenmg.RootsDelivery.dataObject.Admin;
import com.akenmg.RootsDelivery.dataObject.Client;

public class DaoClient implements DaoInterface<Client>{

	private static final String createQuery = "insert into CLIENTS (NOMCLIENT, PRENOMCLIENT, NUMEROCLIENT, EMAILCLIENT, MDPCLIENT) values (?, ?, ?, ?, ?)";
	private static final String findQuery = "SELECT * FROM CLIENTS WHERE IDCLIENT = ?";
	private static final String deleteQuery = "DELETE FROM CLIENTS WHERE IDCLIENT = ?";
	private static final String updateQuery = "UPDATE CLIENTS SET NOMCLIENT=?,PRENOMCLIENT=?,NUMEROCLIENT=?,EMAILCLIENT=?,MDPCLIENT=? WHERE IDCLIENT=?";
	private static final String getAllQuery = "SELECT * FROM CLIENTS";
	
	@Override
	public void create(Client obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(createQuery);
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getPrenom());
			preparedStatement.setString(3, obj.getNom());
			preparedStatement.setString(4, obj.getEmail());
			preparedStatement.setString(5, obj.getMdp());
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
	public Client find(int id) {
		Client client = null;
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(findQuery);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				client = mapRes(rs);
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
		return client;
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
	public void update(Client obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(updateQuery);
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getPrenom());
			preparedStatement.setString(3, obj.getNumero());
			preparedStatement.setString(4, obj.getEmail());
			preparedStatement.setString(5, obj.getMdp());
			preparedStatement.setInt(6, obj.getId());
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
	public List<Client> getAll() {
		List<Client> clients = new ArrayList<Client>();
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoConnexion.getConnection();
			preparedStatement = dbConnection.prepareStatement(getAllQuery);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				clients.add(mapRes(rs));
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
		return clients;
	}

	private Client mapRes(ResultSet rs) {
		Client client = new Client();
		try{
			client.setId(rs.getInt("IDCLIENT"));
			client.setNom(rs.getString("NOMCLIENT"));
			client.setPrenom(rs.getString("PRENOMCLIENT"));
			client.setNumero(rs.getString("NUMEROCLIENT"));
			client.setEmail(rs.getString("EMAILCLIENT"));
			client.setMdp(rs.getString("MDPCLIENT"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return client;
	}
	
}
