<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update functional area :</h1>
<form action="updatefunctionalarea" >
<table>
<thead>
<tr>
<td>Area_id</td>
<td>Program</td>
<td>Functional area</td>
</tr>
</thead>

<c:forEach var="p" items="${functionalarea}" >
<c:set var="programid" scope="session" value="${p.programid}"/>
<tr>
<td><input type="text" name="id" value="${p.areaid}" readonly/></td>
<td><input type="text" name="program" value="${p.program}" /></td>
<td><input type="text" name="functionalarea" value="${p.functionalarea}" /></td>
<td><input type="hidden" name="program_id" value="${p.programid}" /></td>
</tr>
</c:forEach>
</table>
<input type="submit" value="Update">
</form>
</body>
</html>