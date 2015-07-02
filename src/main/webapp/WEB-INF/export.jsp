<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Export</title>
</head>
<body>
<a href="j_spring_security_logout" style="marging-left:0px;width:250px;height:20px;float:right"> Logout</a>
<hr>
<h1>Export Tables</h1>h1>
<ul>
<li><h3> <a href="/BugHound_omg/exportxml?name=program">Export program table</a></h3></li>
<li><h3> <a href="/BugHound_omg/exportxml?name=user">Export User table</a></h3></li>
<li><h3> <a href="/BugHound_omg/exportxml?name=area">Export Functional Area table</a></h3></li>
<li><h3> <a href="/BugHound_omg/exportxml?name=bugreport">Export Bug Details table</a></h3></li>

</ul>
</body>
</html>