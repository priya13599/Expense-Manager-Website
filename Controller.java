package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Service.Service;

import Bean.AddExpense;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		HttpSession sn=request.getSession();
		 Service ser=new Service();
		 String target="";
		 String str="";
		 int n;
		
		String button=request.getParameter("c1");
		try
		{
		if(button.equals("ADD"))
		{  
			String email = request.getParameter("email");
			String amount=request.getParameter("amt");
		    String cate=request.getParameter("o1");
			String date=request.getParameter("date");
			
			SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
			AddExpense add = new AddExpense(email,amount,cate,df.parse(date));
			
			 boolean flag=false;
			  // System.out.println("dao inserr");
				flag = ser.insert(add);
			//System.out.println("inser boo"+flag);
			if(flag) {
				 str+=" Expense added successfully";
				
				 }
		      else
		    	 str+=" Expense not added"; 
				 sn.setAttribute("s1", str);
			target+="Insert.jsp";
			
		}
		
		
		else if(button.equals("DELETE"))
		{
			String email = request.getParameter("email");
			String amount=request.getParameter("amt");
		    String cate=request.getParameter("o1");
			String date=request.getParameter("date");
			
			SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
			AddExpense add = new AddExpense(email,amount,cate,df.parse(date));
			 n=ser.delete(add);
			  if(n>0)
					 str+="Expense deleted successfully";
				 else
					 str+="Given Details not Found Here";
				 
					  sn.setAttribute("s1", str);
					 target+="Delete.jsp";
			 
			 
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
