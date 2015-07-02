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
<a href="j_spring_security_logout" style="marging-left:0px;width:250px;height:20px;float:right"> Logout</a>
<hr>
<h1>Search on the basis of :</h1>
<hr>
<form action="search" method="post">
Report Id:
<input type="number" name="report_id"/>
Program:
<select name="program">
<option value="choose">Choose</option> 
<c:forEach var="p" items="${program}">
   <option value="${p.program}">${p.program}</option> 
  </c:forEach>
 </select>     
<br>
severity:
<select name="severity">
<option value="choose">Choose</option> 
<c:forEach var="p" items="${severity}">
   <option value="${p}">${p}</option> 
  </c:forEach>
 </select>     
 Priority:
 <select name="priority">
 <option value="choose">Choose</option> 
<c:forEach var="p" items="${priority}">
   <option value="${p}">${p}</option> 
  </c:forEach>
  
 </select>    
  Resolution:
  
 <select name="resolution">
 <option value="choose">Choose</option> 
<c:forEach var="p" items="${resolution}">
   <option value="${p}">${p}</option> 
  </c:forEach>
  </select>  
   Status:
 <select name="status">
<c:forEach var="p" items="${status}">
   <option value="${p}">${p}</option> 
  </c:forEach>
  </select>  
   Report Type:
 <select name="report_type">
 <option value="choose">Choose</option> 
<c:forEach var="p" items="${report_type}">
   <option value="${p}">${p}</option> 
  </c:forEach>
  </select>  
    
  Functional Area:
 <input type="text" name="functional_area">
  Assigned to:
 <input type="text" name="assigned_to">
 Reported by:
 <input type="text" name="reported_by">
 Resolved by:
 <input type="text" name="resolved_by">
 Report Date
 <input type="date" name="reportdate">
<br>
<input type="submit" value="Search"/>
<input type="button" value="Cancel" onclick="myfunc2()"/>
<input type="button" value="Reset"onclick="myfunc()"/>
</form>
<script> 
function myfunc()
{window.location="/BugHound_omg/update2"
	}
	</script>
	<script> 
function myfunc2()
{window.location="/BugHound_omg/gohome"
	}
	</script>
</body>
</html>