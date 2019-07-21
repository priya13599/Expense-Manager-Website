<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name ="form" action="N2">
<table>
<tr>
<td>
Username: 
</td>
<td><input type="text" name="name" value=<%= request.getAttribute("name") %>>
</td>
</tr>

<tr>
<td>
Email: 
</td>
<td><input type="text" name="email" value=<%= request.getAttribute("email1") %>>
</td>
</tr>


<tr>
<td>
Salary: 
</td>
<td><input type="text" name="sal" value=<%= request.getAttribute("salary") %>>
</td>
</tr>


<tr>
<td>
Budget: 
</td>
<td><input type="text" name="budget" value=<%= request.getAttribute("budgetamt") %>>
</td>
</tr>


<tr>
<td>
<input type="submit" name="c1" value="Update">
</td>
</tr>
</table>
</form>
</body>
</html>