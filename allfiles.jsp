<%@page import="java.util.List"%>
<%@page import="Bean.UploadDetail"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Servlet File Upload/Download</title>
        
        <link rel="stylesheet" href="resource/css/main.css" />
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="home.css">
<link rel="stylesheet" href="login.css">
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
<a href="AboutUs.jsp">AboutUs</a>
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
     
     
        <div class="panel">
            <h1 style="color:red"><b><u>Uploaded Files</u></b></h1>
            <table class="bordered_table">
               <thead>
                  <tr align="center"><th>File Name</th><th>File Size</th><th>Action</th></tr>
               </thead>
               <tbody>
                  <% List<UploadDetail> uploadDetails = (List<UploadDetail>)request.getAttribute("uploadedFiles");
                     if(uploadDetails != null && uploadDetails.size() > 0) {
                     for(int i=0; i<uploadDetails.size(); i++) {
                  %>
                  <tr>
                     <td align="center"><span id="fileName"><%=uploadDetails.get(i).getFileName() %></span></td>
                     <td align="center"><span id="fileSize"><%=uploadDetails.get(i).getFileSize() %> KB</span></td>
                     <td align="center"><span id="fileDownload"><a id="downloadLink" class="hyperLink" href="<%=request.getContextPath()%>/FileDownloadServlet?fileName=<%=uploadDetails.get(i).getFileName() %>">Download</a></span></td>
                  </tr>
                  <% }
                   } else { %>
                  <tr>
                     <td colspan="3" align="center"><span id="noFiles">No Files Uploaded.....!</span></td>
                  </tr>
                  <% } %>
               </tbody>
            </table>
            <div class="margin_top_15px">
               <a id="fileUpload" class="hyperLink" href="<%=request.getContextPath()%>/fileupload.jsp">Back</a>
            </div>
         </div>
     </body>
</html>