package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Util.Util;

import Bean.ContactUsBean;

public class DaoContactUs {

	
	Connection con;
	String cmd="";
	
	 PreparedStatement ps;
	 ResultSet rs;
	 int n;
	 
	 public boolean insert(ContactUsBean obj) throws Exception
		{ 
			
			con=Util.getConnection();
			cmd ="insert into emcontactus values(?,?,?,?)";
		    ps=con.prepareStatement(cmd);
		    
		     ps.setString(1,obj.getEmail_id());
		     ps.setString(2,obj.getName());
		     ps.setString(3,obj.getPhone_number());
		     ps.setString(4,obj.getMessage());
		     n=ps.executeUpdate();
		    ps.close();
		    if(n>0)
		    return true;
		    else
		    	return false;
		   }
		
	 
}
