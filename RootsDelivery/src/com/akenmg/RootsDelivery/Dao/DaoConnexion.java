package com.akenmg.RootsDelivery.Dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnexion {
	private static final String dbUrl="postgres://hdxjxnzhkjeuaj:sikq1k4syxIWaSYOda8bw6V5N-@ec2-54-247-170-228.eu-west-1.compute.amazonaws.com:5432/d13erbpffrfb58";
	
	public static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(dbUrl);
	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath()+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	    return DriverManager.getConnection(dbUrl, username, password);
	}
}
