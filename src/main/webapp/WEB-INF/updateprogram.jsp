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
<h1> Update Program</h1>
<br>
<br>
<br>

<form action="updateprogram" method="post">
<c:forEach var="p" items="${program}">
Program: <input type="text" name="program" value={p.program}  />
<hr>
Release:<input type="text"  name="release" value={p.prgram_release}  />
<hr>
Version: <input type="text" name="version" value={p.version}  />
</c:forEach>
<input type="submit" value="Update"/>
</form>
</body>
</html>