<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="j_spring_security_logout" style="marging-left:0px;width:250px;height:20px;float:right"> Logout</a>
<hr>
<h1>Search results: </h1>
<form action="update">
<table border="5|0">
<tr>
<td> Id </td>
<td> Program</td>
<td> Reported By</td>
<td> Report type</td>
<td> Severity</td>
<td> Functional Area</td>
<td> Assigned to</td>
<td> Status</td>
<td> Priority</td>
<td> Resolution</td>
<td> Reported by</td>
<td> Resolved by</td>
<td>Problem</td>
<td> Problem Summary</td>
</tr>

<c:forEach var="p" items="${searchresults}">
 <tr id=${p.id} onclick="myfunc(id)"><td>${p.id}</td><td>${p.program}</td><td>${p.reportedby}</td><td>${p.reporttype}</td><td>${p.severity}</td><td>${p.functionalarea}</td><td>${p.assignedto}</td><td>${p.status}</td><td>${p.priority}</td><td>${p.resolution}</td><td>${p.reportedby}</td><td>${p.resolvedby}</td><td>${p.reproduction}</td><td>${p.problemsummary}</td></tr></c:forEach>
</table>
</form>
<script>
function myfunc(id)
{
	window.location= "/BugHound_omg/update?id=".concat(id);
	}
</script>
</body>
</html>