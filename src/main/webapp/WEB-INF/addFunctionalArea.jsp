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
<h1>Add a functional area :</h1>
<form action="addfuncarea" >
<table border="1">
<tr><td>${message}</td></tr>
<tr>
<td>Area_id</td>
<td>Program_id</td>
<td>Functional area</td>
</tr>

<c:forEach var="p" items="${functionalarea}" >
<tr>
<td><input type="text" value="${p.areaid}" readonly /></td>
<td><input type="text" value="${p.programid}" readonly /></td>
<td><input type="text" value="${p.functionalarea}" readonly /></td>
<td><input type="button" value="Update" onclick="myfunction(${p.areaid})"></td>
</tr>
</c:forEach>
<tr>
<td><input type="number" name="areaid" value="Add" readonly /></td>
<td><input type="number" name="programid" value="${program}" readonly /></td>
<td><input type="text" name="functionalarea" /></td>

</tr>
<tr>
</table>
<input type="submit" value="Add">
<input type="button" value="Cancel" onclick="cancelfunc()" >
</form>
<script>
function cancelfunc()
{
	window.location="/BugHound_omg/gohome"
	}
</script>
<script>
function myfunction(value)
{
	alert(value)
	window.location="/BugHound_omg/getfunctionalarea?id=".concat(value);
	}
</script>
</body>
</html>