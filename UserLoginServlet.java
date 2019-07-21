package com.abes;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import Bean.AddExpense;
import Bean.DisplayYearwise;




/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
@MultipartConfig(maxFileSize=16177215)
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession sn=request.getSession();
		String val = request.getParameter("c1");
		Connection con;
		String target="";
		if(val.equals("LOGIN"))
		{
			String email = request.getParameter("email");
			String Password = request.getParameter("psw");
			
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
			
				String str = "select* from emlogin where EMAIL =? and PASSWORD =?";
				PreparedStatement ps = con.prepareStatement(str);
				ps.setString(1, email);
				ps.setString(2, Password);
			
				ResultSet rs1 = ps.executeQuery();
				
				if(rs1.next())
				{
					
					    target ="Function.html";
				           	
		        	 
				}
				 else
	        	 {
	        		 target ="invalid.jsp";
	        	 }
				sn.setAttribute("str", email);	
					
			}
			
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			
		}
		
		if(val.equals("DISPLAY"))
		{
			
			
			try
			{
				int flag=0;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
				
				ArrayList<AddExpense> al= new ArrayList<AddExpense>();
				String str = "select* from addexpense where EMAIL =?";
				PreparedStatement ps = con.prepareStatement(str);
				HttpSession sn1 = request.getSession();
				String email2=(String) sn1.getAttribute("str");
				ps.setString(1, email2);
				
			
				ResultSet rs1 = ps.executeQuery();
				
				while(rs1.next())
				{
					String email4= rs1.getString(1);
					String amt= rs1.getString(2);
					String category = rs1.getString(3);
					Date d = rs1.getDate(4);
					java.util.Date doe = new java.util.Date(d.getTime());
					AddExpense ae = new AddExpense(email4,amt,category,doe);
					al.add(ae);
					//System.out.println(al);
					flag=1;
					
					 
				}
				if(flag==1)
	               {
	                	
	                	
		 			sn.setAttribute("s3", al);
		 			
				    target ="DisplayExpense1.jsp";
				    
	                }
			           	
		        	 
				else
	        	 {
	        		 target ="Function.html";
	        	 }
				
				
                
					
			}
			
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			 
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			
		}
		
		
		
		if(val.equals("UPLOAD"))
		{
			
			InputStream is = null;
			Part filepart = request.getPart("myfile");
			if(filepart != null)
			{
				System.out.println(filepart.getName());
				is = filepart.getInputStream();
			}
			
			
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
			
				String str = "insert into Img values(?,?,?)";
				PreparedStatement ps = con.prepareStatement(str);
				HttpSession sn1 = request.getSession();
				String email2=(String) sn1.getAttribute("str");
				ps.setString(1, email2);
				ps.setString(2, filepart.getName());
				//ps.setString(2, extractFileName(filepart));
				
				if(is != null)
				{
					
					ps.setBinaryStream(3,is,(int)is.available());
				}
				
			
				int n = ps.executeUpdate();
				
				if(n>0)
				{
					
					    target ="Upload.jsp";
				           	
		        	 
				}
				 else
	        	 {
	        		 target ="notUpload.jsp";
	        	 }
				
					
			}
			
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			
		}
		
	
		if(val.equals("DISPLAY EXPENSE YEARWISE"))
		{
		

			try
			{
				int flag=0;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
				
				
				ArrayList<DisplayYearwise> al= new ArrayList<DisplayYearwise>();
				String str = "select amount,category,extract(year from edate) from addexpense where EMAIL =?";
				PreparedStatement ps = con.prepareStatement(str);
				HttpSession sn1 = request.getSession();
				String email2=(String) sn1.getAttribute("str");
				ps.setString(1, email2);
				
				ResultSet rs1 = ps.executeQuery();
				
				while(rs1.next())
				{
					
					String amt= rs1.getString(1);
					String category = rs1.getString(2);
					String year= rs1.getString(3);
				    DisplayYearwise ae = new DisplayYearwise(amt,category,year);
					al.add(ae);
					System.out.println(al);
					
					flag=1;
					
					 
				}
				
				if(flag==1)
	               {
	                	
	                	
		 			sn.setAttribute("s3", al);
		 			
				    target ="DisplayYearwise.jsp";
				    
	                }
			           	
		        	 
				else
	        	 {
	        		 target ="Function.html";
	        	 }
				
				
             
					
			}
			
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			 
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
		}
			
				
		if(val.equals("DISPLAY EXPENSE MONTHWISE"))
		{
		

			try
			{
				int flag=0;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
				
				
				ArrayList<DisplayYearwise> al= new ArrayList<DisplayYearwise>();
				String str = "select amount,category,to_char(edate,'DD-Month') from addexpense where EMAIL =?";
				PreparedStatement ps = con.prepareStatement(str);
				HttpSession sn1 = request.getSession();
				String email2=(String) sn1.getAttribute("str");
				ps.setString(1, email2);
				
				ResultSet rs1 = ps.executeQuery();
				
				while(rs1.next())
				{
					
					String amt= rs1.getString(1);
					String category = rs1.getString(2);
					String month= rs1.getString(3);
				    DisplayYearwise ae = new DisplayYearwise(amt,category,month);
					al.add(ae);
					System.out.println(al);
					flag=1;
					
					
					
					 
				}
				
				if(flag==1)
	               {
	                	
	                	
		 			sn.setAttribute("s3", al);
		 			
				    target ="DisplayMonthwise.jsp";
				    
	                }
			           	
		        	 
				else
	        	 {
	        		 target ="Function.html";
	        	 }
				
				
             
					
			}
			
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			 
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
		}
			
				
		
		
	}

	/*private String extractFileName(Part filepart) {
		// TODO Auto-generated method stub
		
		
		String cd = filepart.getHeader("content-disposition");
		String[] items = cd.split(";");
		for(String s : items)
		{
			if(s.trim().startsWith("filename"))
			{
				String cfn = s.substring(s.indexOf("=")+2,s.length()-1);
				cfn = cfn.replace("\\", "/");
				int i = cfn.lastIndexOf("/");
				return cfn.substring(i+1);
			}
		}
		return null;
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
