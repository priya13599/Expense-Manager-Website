package com.abes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servletregistration
 */
@WebServlet("/Servletregistration")
public class Servletregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servletregistration() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String val = request.getParameter("c1");
		Connection con;
		String target="";
		String email = request.getParameter("email");
		String username = request.getParameter("uname");
		String sal = request.getParameter("sal");
		String budgetsal = request.getParameter("budgetsal");
		String Password = request.getParameter("psw");
		String Confirmpsw = request.getParameter("pswrepeat");
		
		
	if(val.equals("REGISTER"))
  {
			
     if(Password.equals(Confirmpsw))
	{
		
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
			
				String str = "insert into emlogin values(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(str);
				ps.setString(1, username);
				ps.setString(2, email);
				ps.setString(3, sal);
				ps.setString(4, budgetsal);
				ps.setString(5, Password);
				
			
				int n = ps.executeUpdate();
				
				if(n>0)
				{
					
					    target ="register.jsp";
				           	
		        	 
				}
				 else
	        	 {
	        		 target ="notregister.jsp";
	        	 }
					
					
			}
			
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
