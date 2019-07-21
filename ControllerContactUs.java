package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Service.ServiceContactUs;

import Bean.ContactUsBean;

/**
 * Servlet implementation class ControllerContactUs
 */
@WebServlet("/ControllerContactUs")
public class ControllerContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerContactUs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		HttpSession sn=request.getSession();
		 ServiceContactUs ser=new ServiceContactUs();
		 String target="";
		 String str="";
		 int n;
		
		String button=request.getParameter("c1");
		try
		{
		if(button.equals("SUBMIT"))
		{  
			//System.out.println("insert abcd"+dob);
			
			String email_id=request.getParameter("email");
			String name=request.getParameter("name");
		    String phone=request.getParameter("phone");
			String msg=request.getParameter("msg");
			
            
		    ContactUsBean s = new ContactUsBean(email_id,name,phone,msg);
		   boolean flag=false;
			  // System.out.println("dao inserr");
				flag = ser.insert(s);
			//System.out.println("inser boo"+flag);
			if(flag) {
				 str+="ThankYou For Your Response!! "
				 		+ "We Will Get in Touch With You Soon";
				
				 }
		      else
		    	 str+=" Record not added"; 
				 sn.setAttribute("s1", str);
			target+="InsertContactUs.jsp";
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		 rd.forward(request, response);
		}
		catch(Exception e)
		{
			pw.print(e);
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
