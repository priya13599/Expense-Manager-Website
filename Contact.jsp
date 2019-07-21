<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contact Us</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="home.css">
<link rel="stylesheet" href="login.css">

<script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/F83F6E00-42FF-4741-B1BD-B18C2DE9CA81/main.js" charset="UTF-8"></script>
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
</div>

<form class="modal-content" action ="ControllerContactUs" >
  <div class="container">
    <h1 style="color:white;text-align:center">Contact Us</h1>
    

    <label for="email" style="color:white"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>
 
 
    <label for="uname" style="color:white"><b>Name</b></label>
    <input type="text" placeholder="Enter name" name="name" required>
    
     <labelfor="phone" style="color:white"><b>Phone Number</b></label>
      <input type="text" id="phone" name="phone"placeholder="Enter Phone no."required />
       <br>
      
      
      <label for="subject" style="color:white"><b>Message</b></label>
    <textarea id="subject" name="msg" placeholder="Enquiry Message..." style="height:200px; width:630px;" required></textarea>
        <br>
        <br>
 
  
  
  <div class="clearfix">
       <input type="submit" class="signupbtn" value="SUBMIT" name ="c1"/>
        
      </div>
    </div>
</form>


</body>
</html>