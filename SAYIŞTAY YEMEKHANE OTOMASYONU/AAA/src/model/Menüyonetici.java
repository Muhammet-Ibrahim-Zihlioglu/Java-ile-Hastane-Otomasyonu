package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Helper.*;

public class Men�yonetici extends men�{
	
	Connection con= conn.connDb();
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement preparedStatement= null ;

	
	public Men�yonetici(int id1, String g�n, String corba, String anayemek, String aperatif, String yan�r�n) {
		super();
	}

	public Men�yonetici() {}

	public  ArrayList<men�> getMen�List() throws SQLException {
		ArrayList<men�> liste = new ArrayList<>();
		men� obj;
		try {
			st =  con.createStatement();
			rs=st.executeQuery("SELECT * FROM yemekmen�");
			while(rs.next()) {
				obj=new men�(rs.getInt("id1"),rs.getString("g�n"),rs.getString("corba"),rs.getString("anayemek"),rs.getString("aperatif"),rs.getString("yan�r�n"));
				liste.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return liste;
		}
	  public boolean addMenu(String g�n, String corba, String anayemek, String aperatif,String yan�r�n) {
	    	String query= "INSERT INTO yemekmen� (g�n,corba,anayemek,aperatif,yan�r�n) VALUES (?,?, ?, ?,?)";
	    	boolean key=false;
	    	try {
	    		
				st=con.createStatement();
				PreparedStatement preparedStatement ;
				preparedStatement=con.prepareStatement(query);
				preparedStatement.setString(1, g�n);
				preparedStatement.setString(2, corba);
				preparedStatement.setString(3, anayemek);
				preparedStatement.setString(4, aperatif);
				preparedStatement.setString(5, yan�r�n);
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
	  
	  public boolean removeMenu(int id1) {
	    	String query="DELETE FROM yemekmen� Where id1 = ?";
	    	boolean key=false;
	    	try {
				st=con.createStatement();
				PreparedStatement preparedStatement ;
				preparedStatement=con.prepareStatement(query);
				preparedStatement.setInt(1,id1);
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
	    
	  
	  public boolean updateMenu(int id1,String g�n,String corba,String anayemek,String aperatif,String yan�r�n) throws SQLException {
	    	String query="UPDATE yemekmen� SET  g�n=?,corba=?,anayemek=?,aperatif=?,yan�r�n=? WHERE id1 = ?";
	    	boolean key=false;
	    	try {
				st=con.createStatement();
				preparedStatement=con.prepareStatement(query);
				preparedStatement.setString(1, g�n);
				preparedStatement.setString(2, corba);
				preparedStatement.setString(3, anayemek);
				preparedStatement.setString(4, aperatif);
				preparedStatement.setString(5,yan�r�n);
				preparedStatement.setInt(6,id1);
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
