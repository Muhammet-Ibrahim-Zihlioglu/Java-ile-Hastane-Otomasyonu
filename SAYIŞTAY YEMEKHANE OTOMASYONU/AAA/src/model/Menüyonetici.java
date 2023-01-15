package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Helper.*;

public class Menüyonetici extends menü{
	
	Connection con= conn.connDb();
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement preparedStatement= null ;

	
	public Menüyonetici(int id1, String gün, String corba, String anayemek, String aperatif, String yanürün) {
		super();
	}

	public Menüyonetici() {}

	public  ArrayList<menü> getMenüList() throws SQLException {
		ArrayList<menü> liste = new ArrayList<>();
		menü obj;
		try {
			st =  con.createStatement();
			rs=st.executeQuery("SELECT * FROM yemekmenü");
			while(rs.next()) {
				obj=new menü(rs.getInt("id1"),rs.getString("gün"),rs.getString("corba"),rs.getString("anayemek"),rs.getString("aperatif"),rs.getString("yanürün"));
				liste.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return liste;
		}
	  public boolean addMenu(String gün, String corba, String anayemek, String aperatif,String yanürün) {
	    	String query= "INSERT INTO yemekmenü (gün,corba,anayemek,aperatif,yanürün) VALUES (?,?, ?, ?,?)";
	    	boolean key=false;
	    	try {
	    		
				st=con.createStatement();
				PreparedStatement preparedStatement ;
				preparedStatement=con.prepareStatement(query);
				preparedStatement.setString(1, gün);
				preparedStatement.setString(2, corba);
				preparedStatement.setString(3, anayemek);
				preparedStatement.setString(4, aperatif);
				preparedStatement.setString(5, yanürün);
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
	    	String query="DELETE FROM yemekmenü Where id1 = ?";
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
	    
	  
	  public boolean updateMenu(int id1,String gün,String corba,String anayemek,String aperatif,String yanürün) throws SQLException {
	    	String query="UPDATE yemekmenü SET  gün=?,corba=?,anayemek=?,aperatif=?,yanürün=? WHERE id1 = ?";
	    	boolean key=false;
	    	try {
				st=con.createStatement();
				preparedStatement=con.prepareStatement(query);
				preparedStatement.setString(1, gün);
				preparedStatement.setString(2, corba);
				preparedStatement.setString(3, anayemek);
				preparedStatement.setString(4, aperatif);
				preparedStatement.setString(5,yanürün);
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
