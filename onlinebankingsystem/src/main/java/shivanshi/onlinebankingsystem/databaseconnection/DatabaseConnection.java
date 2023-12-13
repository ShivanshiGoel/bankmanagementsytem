package shivanshi.onlinebankingsystem.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	public static Connection provideConnection() {
		Connection conn = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			
		}
		String url = "jdbc:mysql://localhost:3306/bankingsystem";
		try {
			conn = DriverManager.getConnection(url, "root" , "javaproject");
		}
		catch (Exception e)
		{
			 System.out.println("exception occured in the databse");
		}
		return conn;
	}

}
