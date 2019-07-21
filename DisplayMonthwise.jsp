<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="Bean.DisplayYearwise,java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Expense Monthwise</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <style type="text/css">
  .button
{
border:none;
color:white;
padding:15px 32px;
text-align:center;
text-decoration:none;
display:inline-block;
font-size:16px;
margin:4px 2px;
cursor:pointer;

}

</style>
   <link rel="stylesheet" href="home.css">
</head>
<body style="background-color:#DEF2F1;">
<div class="logo">
<img src="logo.png" alt="ABES EC" float="left" height="130" width="110">
<div class ="title">
<u><font style="margin-left:-50px ; margin-top:60px; position:absolute; color:#DEF2F1; " size="7px"><b><u>BUDGET BUDDY</u></b></font></u>

</div>

</div>

<div class="navbar">
  <a href="home.html">Home</a>
  <a href="Createaccount.html">Registration</a>
  <a href="Login.html">Login</a>
  <a href="Privacy.html">Privacy Policy</a>
  <a href="Tos.html">Terms of Service</a>
<a href="AboutUs.html">AboutUs</a>
<a href="Contact.jsp">ContactUs</a>
<a href="home.html" style="margin-left:750px">Logout</a>
</div>



</div>


<div class="container">
  <h1 align="center" style="color:red"><b><u>Expense Details</u></b></h1>
    <table class="table table-striped" border="1" >
    <thead>
      <tr>
      
        <th>Amount </th>
        <th>Category</th>
        <th>Month</th>
         </tr>
    </thead>
    
    
    <%

ArrayList <DisplayYearwise> al=(ArrayList)session.getAttribute("s3");
Iterator <DisplayYearwise> it=al.iterator();
while(it.hasNext())
 {
	DisplayYearwise s=(DisplayYearwise)it.next();
	 //out.println(s);
%>
   
 
 <tbody>
      <tr>
        
      
        <td><%=s.getAmount()%></td>
        <td><%=s.getCategory() %></td>
        <td><%=s.getYear() %></td>
        
          </tr>
    </tbody>
     <%
 }

%>
    
     <form action="DisplayExpenseMonthwise.html"> 
<button type="submit" class="button" style="background-color:#008CBA;">Back</button>
</form>
 
    

</div>
 



</body>
</html>