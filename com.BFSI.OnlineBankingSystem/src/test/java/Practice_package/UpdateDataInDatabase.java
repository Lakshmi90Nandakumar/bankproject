package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataInDatabase {

	public static void main(String[] args) throws Throwable {

		Connection con=null;
		int result=0;
		try {
		Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_banking", "root", "root");
	Statement state = con.createStatement();
	String query="create table Customerdetails;";
	  result = state.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		finally{
			if(result==0) {
				System.out.println("data updated");
			}
			else {
				System.err.println("data not updated");
			}
		}
	
	}

}
