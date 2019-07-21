<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="home.css">
<link rel="stylesheet" href="login.css">

<script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/F83F6E00-42FF-4741-B1BD-B18C2DE9CA81/main.js" charset="UTF-8"></script>
<style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

#main {
    transition: margin-left .5s;
    padding: 16px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
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
<a href="AboutUs.html">AboutUs</a>
<a href="Contact.jsp">ContactUs</a>
<a href="home.html" style="margin-left:750px">Logout</a>
</div>


<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
   <a href="UpdateUserDetails.jsp">Update Profile </a>
 <a href="AddExpense.html">Add Expenses </a>
 <a href="DeleteExpense.html">Delete Expenses</a>
  <a href="DisplayExpense.jsp">Display Total Expenses</a>
 <a href="DisplayExpenseMonthwise.html">Display Expense MonthWise</a>
 <a href="DisplayExpenseYearwise.html">Display Expense YearWise</a>
  <a href="fileupload.jsp">Attach Bills</a>
  <a href="UserChangePassword.html">Change Password</a>
  <a href="UserForgetPassword.html">Forget Password?</a>
 
</div>

<div id="main">
  <h2 style ="color:red;">USER Functions</h2>
  
  <span style="font-size:30px;cursor:pointer;color:green" onclick="openNav()">&#9776;</span>
</div>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}
</script>
     
     <form class="modal-content" action ="N2">
    <div class="container">
      <h1 style="color:white;text-align:center">Update Profile</h1>
    
      <hr>
      
       
    <label for="email" style="color:white"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" value=<%= request.getAttribute("email1") %>>
 
 
    <label for="uname" style="color:white"><b>UserName</b></label>
    <input type="text" placeholder="Enter Name" name="name" value=<%= request.getAttribute("name") %>>
 
  <label for="sal" style="color:white"><b>Salary</b></label>
    <input type="text" placeholder="Enter Salary" name="sal" value=<%= request.getAttribute("salary") %>>
 
 <label for="budgetsal" style="color:white"><b>Budget Amount</b></label>
    <input type="text" placeholder="Enter Budget Amount" name="budget" value=<%= request.getAttribute("budgetamt") %>>
    
    
 <div class="clearfix">
      
        <input type="submit" class="signupbtn" value="Update" name ="c1"/>
      </div>
    </div>
  
   
   
  </form>
 


</body>
</html>