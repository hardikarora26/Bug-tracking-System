<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html>
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.11/jquery-ui.min.js"></script>
<title>Insert title here</title> 

</head> 
<body> 
<a href="j_spring_security_logout" style="marging-left:0px;width:250px;height:20px;float:right"> Logout</a>
<hr>
<h1>Update bug:</h1> 

<form name="updatebug" action="updatebug" method="post" id="updateform" enctype="multipart/form-data" modelAttribute="bugreport"> 

Company name:<input type="text" name="company" value="${bugdetails.companyname}"   />   

Confidential:<input  type="checkbox" name="conf"  />  
Problem report no:<input type="text"name="report_id" value="${bugdetails.id}" readonly  /> 
<hr> 
<br>
Program:
<select name="programdisabled" id="program"  onchange= getprogram(this.value) disabled>
<c:forEach var="p" items="${program}">
  <c:set var="a" value="${p.program}" />
<c:set var="b" value="${bugdetails.program}"/>
<c:choose>

  <c:when test="${a.equals(b)}">
   <option value="${p.program}" selected="selected">${p.program}</option> 
   
   </c:when>
   <c:otherwise>
    <option value="${p.program}" >${p.program}</option>
   </c:otherwise>
   </c:choose>
  </c:forEach> 
  </select>     
<input type="hidden" name="program" value="${bugdetails.program}"/>
<div id="release_select">
 </div> 
 <div id="version_select">
 </div>    
<label id="releaselabel">Release:</label>
<select name="releaseini" id="releaseini" disabled>

   <option value="${bugdetails.programrelease}" selected="selected">${bugdetails.programrelease}</option> 
  
</select> 
<input type="hidden" name="release" value="${bugdetails.programrelease}"/>
<label id="versionlabel">Version:</label>
<select name="versionini" id="versionini" disabled>
   <option value="${bugdetails.version}" selected="selected">"${bugdetails.version}</option> 
</select> 
<input type="hidden" name="version" value="${bugdetails.version}"/>
<br> 
Report type:<select name="report_type" value="${bugdetails.reporttype}"> 
<c:forEach var="p" items="${report_type}">
  <c:set var="a" value="${p}" />
<c:set var="b" value="${bugdetails.reporttype}"/>
<c:choose>
  <c:when test="${a.equals(b)}">
   <option value="${p}" selected="selected">${p}</option> 
   </c:when>
   <c:otherwise>
    <option value="${p}" >${p}</option>
   </c:otherwise>
   </c:choose>
  </c:forEach>
 </select> 
Severity:  <select name="severity" value=${bugdetails.severity }> 
<c:forEach var="p" items="${severity}">
  <c:set var="a" value="${p}" />
<c:set var="b" value="${bugdetails.severity}"/>
<c:choose>
  <c:when test="${a.equals(b)}">
   <option value="${p}" selected="selected">${p}</option> 
   </c:when>
   <c:otherwise>
    <option value="${p}" >${p}</option>
   </c:otherwise>
   </c:choose>
  </c:forEach>
  </select> 
Update Attachment: <select name="atch" onchange=myfunc(this.value)> 
  <option value="none">Chose:</option> 
   
  <option value="yes">Yes</option> 
  <option value="no">No</option>
  </select> 
<p name="type" id=type>Type:</p><input type="file"name="image" id="${bugdetails.file}" /> 

<br> 
Problem Summary :<input type="text"  name="summary" id="summary" value="${bugdetails.problemsummary}"  /> 
Can you reproduce the problem (Y/N) :<input  type="checkbox" id="reproducable" name="reproducable" value="${bugdetails.reproducable}" style=line-height:"40px"/>

<br>
Problem and how to reproduce it:<input type="text"name="reproduction" value="${bugdetails.reproduction}" /> 
Suggested fix(Optional):<input type="text"name="suggested" value="${bugdetails.suggestedfix}" /> 
<br> 
Reported by:<input type="text"name="reportedby" value="${bugdetails.reportedby}" readonly/> Date:<input type="date" name="date" id="date" value="${bugdetails.date}" readonly> 
<hr/>


<security:authorize access="hasAnyRole('ROLE_DEVELOPER','ROLE_ADMIN')">
Funcional_area: <input type="text" name="functional_area" value="${bugdetails.functionalarea}"/>
Assigned to:<input type="text" name="assigned_to" value="${bugdetails.assignedto}"/>
Comments :<input type="text" name="comment" value="${bugdetails.comments}">
Status :<select name="status" value="${bugdetails.status}"> 
<c:forEach var="p" items="${status}">
  <c:set var="a" value="${p}" />
<c:set var="b" value="${bugdetails.status}"/>
<c:choose>

  <c:when test="${a.equals(b)}">
   <option value="${p}" selected="selected">${p}</option> 
   </c:when>
   <c:otherwise>
    <option value="${p}" >${p}</option>
   </c:otherwise>
   </c:choose>
  </c:forEach>
 </select>

Priority :<select name="priority" value="${bugdetails.priority}"> 
<c:forEach var="p" items="${priority}">
  <c:set var="a" value="${p}" />
<c:set var="b" value="${bugdetails.priority}"/>
<c:choose>

  <c:when test="${a.equals(b)}">
   <option value="${p}" selected="selected">${p}</option> 
   </c:when>
   <c:otherwise>
    <option value="${p}" >${p}</option>
   </c:otherwise>
   </c:choose>
  </c:forEach>
 </select>

<br>
Resolution :<select name="resolution" value="${bugdetails.resolution}"> 
<c:forEach var="p" items="${resolution}">
  <c:set var="a" value="${p}" />
<c:set var="b" value="${bugdetails.resolution}"/>
<c:choose>

  <c:when test="${a.equals(b)}">
   <option value="${p}" selected="selected">${p}</option> 
   </c:when>
   <c:otherwise>
    <option value="${p}" >${p}</option>
   </c:otherwise>
   </c:choose>
  </c:forEach>
 </select>
 
Resolution verison :<input type="number"name="resolutionversion" value=${bugdetails.resolutionversion}>
<br>
Resolved by :<input type="text"name="resolvedby" value=${bugdetails.resolvedby}>     Date:<input type="date"name="date2" id="date2" value=${bugdetails.resolutiondate}>
<br>
Resolution tested by:<input type="text" name="resolutiontestedby" value=${bugdetails.resolutiontestedby}>     Date:<input type="date"name="date3" id="date3" value=${bugdetails.testdate}> 
</security:authorize>

<br>
<input type="submit" value="Submit"> 
<input type="button" value="Cancel" onclick="myfunc3()">
<input type="button" id=${bugdetails.id} value="Delete" onclick="myfunc2(this.id)">

</form>
<script> 

//     alert("working")
// document.getElementById('date').datepicker();
//     document.getElementById('date2').datepicker();
//     document.getElementById('date2').datepicker();


</script>
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<script>

document.getElementById('atchtype').style.visibility = 'hidden'; 
document.getElementById('type').style.visibility = 'hidden'; 
document.getElementById('date').datepicker();
document.getElementById('date2').datepicker();
document.getElementById('date2').datepicker();
</script> 
<script> 
function myfunc(value)
{
 if(value=="yes"){ 
  document.getElementById('atchtype').style.visibility = 'visible'; 
     document.getElementById('type').style.visibility = 'visible';
 }
 else{
      
      document.getElementById('atchtype').style.visibility = 'hidden'; 
         document.getElementById('type').style.visibility = 'hidden';
     }}
 </script>
 <script>
 function myfunc3()
 {
  window.location="/BugHound_omg/gohome"
  }
 </script>
<script> 
function myfunc2(id)
{
 window.location= "/BugHound_omg/deletebug?id=".concat(id);
 }
</script> 
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
	<script> 
	function getprogram(value) {
		alert(value)
		debugger;
        $.ajax({
            type: "GET",     
            url: "/BugHound_omg/getrelver?program=".concat(value),
            data: "{program: " + value + "}",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (result) {
                debugger;
                $("#releaseini").remove();
                $("#versionini").remove();
                $("#releaselabel").remove();
                $("#versionlabel").remove();
                var json=result;
                alert(result)
                $("#release_select").html('');
                $("#version_select").html('');
           	 console.log(result);
           	 $("#release_select").append("<label> Release :</label>");
       		 $("#version_select").append("<label> Version :</label>");
           	 $.each(result, function(index, element) {
           		
           		 var itemHTML = [     "<select name=","release",">",
           	
           	                                
           	                                "<option value=",element.prgram_release,">",element.prgram_release,"</option>",
           	                            
           	                            ] .join('\n');
           	        $("#release_select").append(itemHTML);
           	        
           	 var itemHTML2 = [
                                "<select name=","version",">",

                                "<option value=",element.version,">",element.version,"</option>",
                            
                            ] .join('\n');
        $("#version_select").append(itemHTML2);
        
    });
            
           	 $("#release_select").append("</select>");
           	 $("#version_select").append("</select>");
           	 },
            error: function (response) {
                debugger;
                alert(response.responseText);
            }
        });

    }
	</script>
</body> 
</html>