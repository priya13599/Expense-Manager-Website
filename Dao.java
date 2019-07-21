package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Util.Util;

import Bean.AddExpense;

public class Dao {

	
	Connection con;
	String cmd="";
	java.sql.Date date;
	
	 PreparedStatement ps;
	 ResultSet rs;
	 int n;
	 
	 public boolean insert(AddExpense add)throws Exception
		{ 
		 
		 con=Util.getConnection();
			cmd ="insert into addexpense values(?,?,?,?)";
			 ps=con.prepareStatement(cmd);
			 ps.setString(1,add.getEmail());
		     ps.setString(2, add.getAmount());
		     ps.setString(3,add.getCategory());
		     date=new java.sql.Date(add.getDate().getTime());// java date converted into sql date
		      ps.setDate(4,date);
		      
		      n=ps.executeUpdate();
			    ps.close();
			    if(n>0)
			    return true;
			    else
			    	return false;
			   }
			
	 public int delete(AddExpense add)throws Exception
		{ 
		 
			 con=Util.getConnection();
		cmd ="delete from addexpense where email=? and amount=? and category=? and edate=?";
		 ps=con.prepareStatement(cmd);
		 ps.setString(1, add.getEmail());
	     ps.setString(2, add.getAmount());
	     ps.setString(3,add.getCategory());
	     date=new java.sql.Date(add.getDate().getTime());// java date converted into sql date
	      ps.setDate(4,date);
	      n= ps.executeUpdate();
			 ps.close();
			 return n;
			
		}
	 
		
}
