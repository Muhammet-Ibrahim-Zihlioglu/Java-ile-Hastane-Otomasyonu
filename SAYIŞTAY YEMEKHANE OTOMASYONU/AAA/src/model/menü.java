package model;

import Helper.dbConnection;

public class menü{
	
	public static dbConnection conn= new dbConnection();
	int id1;
	String gün,corba,anayemek,aperatif,yanürün;
	
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public String getGün() {
		return gün;
	}
	public void setGün(String gün) {
		this.gün = gün;
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
	public String getYanürün() {
		return yanürün;
	}
	public void setYanürün(String yanürün) {
		this.yanürün = yanürün;
	}
	public menü(int id1, String gün, String corba, String anayemek, String aperatif, String yanürün) {
		super();
		this.id1 = id1;
		this.gün = gün;
		this.corba = corba;
		this.anayemek = anayemek;
		this.aperatif = aperatif;
		this.yanürün = yanürün;
	}
	
	
	public menü() {}
	
}
