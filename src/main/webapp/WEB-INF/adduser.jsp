<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Current Employees:</h1>
<br>
<br>
<hr>
<table>
<tr>
<td>Username</td>
<td>Role</td>
</tr>

<c:forEach var="p" items="${users}" >
<tr>
<td>${p.username}</td>
<td>${p.role}</td>
</tr>
</c:forEach>
<tr>
</table>
<h1>Add an employee :</h1>
<br>
<br>
<br>
<table border="1">${message}</table> 
<br>
<br>
<br>
<hr>
<form action="addemployee">
User Name:<input type="text" name="user" required="required">
User Role :<input type="text" name="userrole" required="required">
Password :<input type="password" name="password" required="required">
<input type="submit" value="add"/>
<input type="button" value="cancel" onclick="cancelfunc()">

</form>

<script>
function cancelfunc(){
window.location="/BugHound_omg/gohome"
}</script>
</body>
</html>