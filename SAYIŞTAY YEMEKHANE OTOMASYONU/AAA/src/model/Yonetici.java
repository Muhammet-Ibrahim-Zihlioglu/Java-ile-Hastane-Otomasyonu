package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;

import Helper.*;

public class Yonetici extends User {
	Connection conn= c.connDb();
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement preparedStatement=null;
	public Yonetici() {}
	

	public Yonetici(int id, String name, String surname, String tc, String password) {
		super(id, name, surname, tc, password);
	}
	
	public  ArrayList<User> getPersonelList() throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		User obj;
		try {
			st = conn.createStatement();
			rs=st.executeQuery("SELECT * FROM personel");
			while(rs.next()) {
				
				obj=new User(rs.getInt("id"),rs.getString("name"),rs.getString("surname"),rs.getString("tc"),rs.getString("password"));
				list.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return list;
	}
    public boolean addPersonel(String name, String surname, String tc, String password) {
    	String query="INSERT INTO personel" + "(name,surname,tc,password) VALUES"+"(?,?,?,?)";
    	boolean key=false;
    	try {
			st=conn.createStatement();
			preparedStatement=conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, tc);
			preparedStatement.setString(4, password);
			preparedStatement.executeUpdate();
			key=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	if(key)
    		return true;
        else
    		return false;
    }
    
    public boolean removePersonel(int id) {
    	String query="DELETE FROM personel Where id = ?";
    	boolean key=false;
    	try {
			st=conn.createStatement();
			preparedStatement=conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			key=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	if(key)
    		return true;
        else
    		return false;
    }
    
    public boolean updatePersonel(int id,String name,String surname,String tc,String password) throws SQLException {
    	String query="UPDATE personel SET  name=?,surname=?,tc=?,password=? WHERE id = ?";
    	boolean key=false;
    	try {
			st=conn.createStatement();
			preparedStatement=conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, tc);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5,id);
			preparedStatement.executeUpdate();
			key=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	if(key)
    		return true;
        else
    		return false;
    }
    
}
