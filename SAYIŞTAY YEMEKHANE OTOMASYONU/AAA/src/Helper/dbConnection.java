package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {
	Connection conn=null;
	public dbConnection() {}
	public Connection connDb() {
		try {
			this.conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sayistay","postgres","745222");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public PreparedStatement prepareStatement(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
