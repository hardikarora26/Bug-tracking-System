<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BugHond</title>
<h1>welocome to bug reporter:</h1>
</head>
<body>
<a href="j_spring_security_logout" style="marging-left:0px;width:250px;height:20px;float:right"> Logout</a>
<hr>
<ul>
<li><h3> <a href="/BugHound_omg/create">Create a new bug</a></h3></li>
<li><h3> <a href="/BugHound_omg/update2">Update a bug</a></h3></li>
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><h3> <a href="/BugHound_omg/database">DataBase maintainance</a></h3></li>
</security:authorize>
</ul>
</body>
</html>