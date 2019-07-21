package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
	public static Connection getConnection() throws Exception{
		// TODO Auto-generated method stub
     Connection con;
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
     
      
      return con;
	
	}
}
