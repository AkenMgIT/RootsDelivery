package com.akenmg.RootsDelivery.Dao;

public class DaoFactory {
	private DaoAdmin daoAdmin;
	private DaoClient daoClient;
	private DaoCommande daoCommande;
	private DaoPlat daoPlat;
	
	
	
	public DaoFactory() {
		super();
		daoAdmin = new DaoAdmin();
		daoClient = new DaoClient();
		daoCommande = new DaoCommande();
		daoPlat = new DaoPlat();
	}
	
	
	//-----------------------------------------------------
	public DaoAdmin getDaoAdmin() {
		return daoAdmin;
	}
	public void setDaoAdmin(DaoAdmin daoAdmin) {
		this.daoAdmin = daoAdmin;
	}
	public DaoClient getDaoClient() {
		return daoClient;
	}
	public void setDaoClient(DaoClient daoClient) {
		this.daoClient = daoClient;
	}
	public DaoCommande getDaoCommande() {
		return daoCommande;
	}
	public void setDaoCommande(DaoCommande daoCommande) {
		this.daoCommande = daoCommande;
	}
	public DaoPlat getDaoPlat() {
		return daoPlat;
	}
	public void setDaoPlat(DaoPlat daoPlat) {
		this.daoPlat = daoPlat;
	}
	
	
}
