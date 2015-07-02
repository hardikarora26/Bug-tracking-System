<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Choose a program:</h1>
<br>
<br>
<hr>
<table>
<tr>
<td>Program id</td>
<td>Program</td>

</tr>
<c:forEach var="p" items="${programs}" >
<tr id="${p.program_id}" onclick="myfunc(this.id)">
<td >${p.program_id}</td>
<td>${p.program}</td>
</tr>
</c:forEach>

</table>



<hr>
<script>
function myfunc(id)
{
	window.location="/BugHound_omg/functionalareapage?id=".concat(id);
	}
</script>
</body>
</html>