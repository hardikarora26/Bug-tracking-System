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
<h1>Current Programs:</h1>
<br>
<br>
<hr>
<table>
<tr>
<td>Program</td>
<td>Release</td>
<td>Version</td>
</tr>
<c:forEach var="p" items="${programs}" >
<tr>
<td>${p.program}</td>
<td>${p.prgram_release}</td>
<td>${p.version}</td>
</tr>
</c:forEach>

</table>
<h1> Add Program</h1>
<br>
<br>
${message}
<br>
<br>
<br>

<form id="form" action="addprogram" method="post" >
Program: <input type="text" name="program" required="required"/>
<hr>
Release:<input type="number"  name="release" required="required" />
<hr>
Version: <input type="number" name="version" required="required"/>
<input type="submit" value="add" onclick="verify()"/>
<input type="button" value="cancel" onclick="cancelfunc()" />
</form>
<script>


function verify()
{
	if(isNaN($("#program").val())==false)
			{
		alert("Only characters allowed ");
		
			}
	else
	{
		$("#form").submit();
	}
	}
</script>
<script>


function cancelfunc()
{
window.location="/BugHound_omg/gohome";
	}
</script>

</body>
</html>