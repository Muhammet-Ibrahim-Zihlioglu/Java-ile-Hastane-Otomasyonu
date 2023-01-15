package model;

import javax.swing.JButton;

import Helper.dbConnection;

public class User {
	
	public static dbConnection c= new dbConnection();
	int id;
	String name,surname,tc,password;
	
	

	public User(int id, String name, String surname, String tc, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.tc = tc;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTc() {
		return tc;
	}


	public void setTc(String tc) {
		this.tc = tc;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User() {};
	

}
