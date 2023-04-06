package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws Throwable {

		 Connection con = null;
		try {
			
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
		Statement state = con.createStatement();
		String query="select* from Customer_details;";
		ResultSet result = state.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2));
			
		}
		}
		catch(Exception e) {
			
		}
		finally {
			con.close();
		}
		
		}
	}


