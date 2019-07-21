package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class N2
 */
@WebServlet("/N2")
public class N2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public N2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String val = request.getParameter("c1");
		Connection con;
		String target="";
		if(val.equals("SUBMIT"))
		{
			String email = request.getParameter("email");
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
			
				String str = "select* from emlogin where EMAIL =?";
				PreparedStatement ps = con.prepareStatement(str);
				ps.setString(1, email);
				ResultSet rs1 = ps.executeQuery();
				
				if(rs1.next())
				{
					
					   request.setAttribute("name", rs1.getString(1));
					   request.setAttribute("email1", rs1.getString(2));
					   request.setAttribute("salary", rs1.getString(3));
					   request.setAttribute("budgetamt", rs1.getString(4));
					
					    target ="UpdateUserDetails1.jsp";
				           	
		        	 
				}
				 else
	        	 {
	        		 target ="invalid.jsp";
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
		
		
		if(val.equals("Update"))
		  {
			String email = request.getParameter("email");
			String username = request.getParameter("name");
			String sal = request.getParameter("sal");
			String budgetsal = request.getParameter("budget");
			
			
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
				
					String str = "Update emlogin set username=?,salary=?,budget_amount=? where email=?";
					PreparedStatement ps = con.prepareStatement(str);
					ps.setString(1, username);
					ps.setString(2, sal);
					ps.setString(3, budgetsal);
					ps.setString(4, email);
					
	                 int n = ps.executeUpdate();
					
					if(n>0)
					{
						
						    target ="Update.jsp";
					           	
			        	 
					}
					 else
		        	 {
		        		 target ="notUpdate.jsp";
		        	 }
	}
				
				catch (Exception e1)
				{
					
					pw.print(e1);
				}
				
				RequestDispatcher rd = request.getRequestDispatcher(target);
				rd.forward(request,response);
		}
		
			
			else
		     {
		    	 target="notmatch.jsp";
		    	 RequestDispatcher rd = request.getRequestDispatcher(target);
					rd.forward(request,response);
		     }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
