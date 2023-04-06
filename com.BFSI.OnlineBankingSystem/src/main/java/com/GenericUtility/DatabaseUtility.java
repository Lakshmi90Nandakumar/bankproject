package com.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con=null;
	
	public void conenectToBB() throws Throwable {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstant.DBURL, IpathConstant.DBUSERNAME, IpathConstant.DBPASSWORD);		
	}
	
	public String excuteQueryAndGetData (String query,String expdata,int columnIndex) throws Throwable {
		 ResultSet result = con.createStatement().executeQuery(query);
		 boolean flag = false;
		 
		 while(result.next()) {
			 
			 String data=result.getString(columnIndex);
			 if(data.equalsIgnoreCase(expdata)) {
				 flag=true;
				 break;
			 }
		 }
		if(flag) {
			
			System.out.println("Data is verified");
			return expdata;
		}
		else {
			System.out.println("data is not updated");
			return "";
		}
	}

	public void closeDB() throws Throwable {
		con.close();
		System.out.println("Database connection closed");
	}

}
