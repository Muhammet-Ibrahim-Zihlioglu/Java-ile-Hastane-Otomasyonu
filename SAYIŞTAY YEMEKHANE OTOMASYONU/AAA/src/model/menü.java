package model;

import Helper.dbConnection;

public class men�{
	
	public static dbConnection conn= new dbConnection();
	int id1;
	String g�n,corba,anayemek,aperatif,yan�r�n;
	
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public String getG�n() {
		return g�n;
	}
	public void setG�n(String g�n) {
		this.g�n = g�n;
	}
	public String getCorba() {
		return corba;
	}
	public void setCorba(String corba) {
		this.corba = corba;
	}
	public String getAnayemek() {
		return anayemek;
	}
	public void setAnayemek(String anayemek) {
		this.anayemek = anayemek;
	}
	public String getAperatif() {
		return aperatif;
	}
	public void setAperatif(String aperatif) {
		this.aperatif = aperatif;
	}
	public String getYan�r�n() {
		return yan�r�n;
	}
	public void setYan�r�n(String yan�r�n) {
		this.yan�r�n = yan�r�n;
	}
	public men�(int id1, String g�n, String corba, String anayemek, String aperatif, String yan�r�n) {
		super();
		this.id1 = id1;
		this.g�n = g�n;
		this.corba = corba;
		this.anayemek = anayemek;
		this.aperatif = aperatif;
		this.yan�r�n = yan�r�n;
	}
	
	
	public men�() {}
	
}
