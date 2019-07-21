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
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
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
		
		String val = request.getParameter("c1");
		Connection con;
		String target="";
		String email = request.getParameter("email");
		String username = request.getParameter("uname");
		String sal = request.getParameter("sal");
		String budgetsal = request.getParameter("budgetsal");
		
		
		
		if(val.equals("UPDATE"))
	  {
			
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
