<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="home.css">

<script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/F83F6E00-42FF-4741-B1BD-B18C2DE9CA81/main.js" charset="UTF-8"></script>
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
<a href="AboutUs.jsp">AboutUs</a>
<a href="Contact.jsp">ContactUs</a>
</div>
<div class="container">
<%
String s=(String)session.getAttribute("s1");
%>
<h1 style="color:red"><%= s %></h1>
<form action="AddExpense.html">
<button type="submit" class="button" style="background-color:#008CBA">Back</button>

</form>
</div>


</body>
</html>