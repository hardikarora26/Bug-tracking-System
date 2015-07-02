<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
<br>
<br>
<hr>
<p>${message}</p>
<form action="<c:url value='j_spring_security_check' />" method="post"  class="well">
USERNAME : <input type="text" name=username>
PASSWORD : <input type="password" name="password"/>
<input type="submit" value="Log in"/>
</form>
</body>
</html>