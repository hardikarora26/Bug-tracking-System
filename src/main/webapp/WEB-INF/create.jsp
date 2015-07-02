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
<link rel="stylesheet" type="text/css"
	    href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
	 
	<script type="text/javascript"
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
    src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

</head> 
<body> 
<a href="j_spring_security_logout" style="marging-left:0px;width:250px;height:20px;float:right"> Logout</a>
<hr>
<h1>create a new bug:</h1> 

<form:form method="post" action="savedata" id="createform" enctype="multipart/form-data" modelAttribute="bugreport">
Company name:<input type="text" name="companyname" />      
Confidential:<input  type="checkbox" name="confidential" />  
Problem report no: # 
<hr> 
<br>
Program:
<select name="program" onchange= getprogram(this.value)>
<option value="" disabled selected>Choose a program</option>
<c:forEach var="p" items="${program}" >
   <option value="${p.program}">${p.program}</option> 
  </c:forEach>
 </select> 
 <div id="release_select">

 </div> 
 <div id="version_select">
 </div>    
<label id="releaselabel">Release:</label>
<select name="releaseini" id="releaseini">
<option>Chose a program first</option>
<%-- <c:forEach var="p" items="${release}"> --%>
<%--    <option value="${p.prgram_release}">${p.prgram_release}</option>  --%>
<%--   </c:forEach> --%>
</select> 
<label id="versionlabel">Version:</label><select name="versionini" id="versionini">
<option>Chose a program first</option>
<%-- <c:forEach var="p" items="${release}"> --%>
<%--    <option value="${p.version}">${p.version}</option>  --%>
<%--   </c:forEach> --%>
</select> 

<br> 
Report type:<select name="report_type" required="required"> 
<c:forEach var="p" items="${reporttype}">
   <option value="${p}">${p}</option> 
  </c:forEach>
 </select> 
Severity:  <select name="severity" required="required"> 
 <c:forEach var="p" items="${severity}">
   <option value="${p}">${p}</option> 
  </c:forEach>
  </select> 
  Attachment: <select name="atch" onchange=myfunc(this.value)> 
  <option value="none">Chose:</option> 
   
  <option value="yes">Yes</option> 
  <option value="no">No</option>
  </select> 
<p name="type" id=type>Type:</p><input type="file"name="image" id="atchtype" /> 

<br> 
Problem Summary :<input type="text" name="summary" id="summary" required="required"/> 
Can you reproduce the problem (Y/N) :<input  type="checkbox" name="reproducable" style=line-height:"40px"/>

<br>
Problem and how to reproduce it:<input type="text" name="reproduction" id="reproduction" required="required"> 
Suggested fix(Optional):<input type="text"name="suggested"> 
<br> 
Reported by:<input type="text"name="reportedby" > Date:<input type="date" name="date" id="date"> 
<hr/>
<security:authorize access="hasAnyRole('ROLE_DEVELOPER','ROLE_ADMIN')">
<label id="funcarealabel">Funcional area:</label> <select id="funcarea"><option value="">Choose a program first</option></select>
<div id="func_select">
 </div> 
Assigned to:<input type="text" name="assigned_to"/>
Comments :<input type="text" name="comment">
Status :<select name="status"> 
<c:forEach var="p" items="${status}">
   <option value="${p}">${p}</option> 
  </c:forEach>
 </select>

Priority :<select name="priority"> 
<c:forEach var="p" items="${priority}">
   <option value="${p}">${p}</option> 
  </c:forEach>
 </select>

<br>

Resolution :<select name="resolution"> 
<c:forEach var="p" items="${resolution}">
   <option value="${p}">${p}</option> 
  </c:forEach>
 </select>
 
Resolution verison :<input type="number" name="resolutionversion">
<br>
Resolved by :<input type="text"name="resolvedby">     Date:<input type="date"name="date2" id="date2">
<br>
</security:authorize>
<security:authorize access="hasAnyRole('ROLE_DEVELOPER','ROLE_ADMIN','ROLE_ADMIN')">
Resolution tested by:<input type="text"name="resolutiontestedby">     Date:<input type="date"name="date3" id="date3"> 
</security:authorize>
<br>
<input type="button" value="Submit" onclick="verify()"> 
<input type="button" value="Cancel" onclick="myfunc3()">
<input type="button" value="Reset" onclick="myfunc4()">
</form:form>
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
function verify()
{
	
	if($("#summary").val()==undefined || $("#summary").val().trim()==="")
		{
	alert("Please enter a valid problem summary");	
		}
	else if($("#reproduction").val()==undefined || $("#reproduction").val().trim()==="")
		{
		alert("Please enter a valid problem");
		}
	else
	{
		$("#createform").submit();
	}
	}
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
function myfunc4()
{window.location="/BugHound_omg/create"
	}
	</script>
<script> 
function myfunction(value)
{ 
     if(value=="yes"){ 
        document.getElementById('atchtype').style.visibility = 'visible'; 
    document.getElementById('type').style.visibility = 'visible';
    } 
     else{
    	 
    	 document.getElementById('atchtype').style.visibility = 'hidden'; 
    	    document.getElementById('type').style.visibility = 'hidden';
     }
}}); 
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
	<script> 
	function getprogram(value) {
	
		debugger;
        $.ajax({
            type: "GET",     
            url: "/BugHound_omg/getrelver?program=".concat(value),
            data: "{program: " + value + "}",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (result) {
                debugger;
             
                $("#old").remove();
       
                
                var json=result;
           
                $("#release_select").html('');
                $("#version_select").html('');
            
       		 $.each(result, function(index, element) {
       			 var div_data="<option value="+element.prgram_release+">"+element.prgram_release+"</option>";
                 $(div_data).appendTo('#releaseini'); 
                 var div_data2="<option value="+element.version+">"+element.version+"</option>";
                 $(div_data2).appendTo('#versionini'); 

        
    });
            
         
           	 },
            error: function (response) {
                debugger;
                alert(response.responseText);
            }
        });
        $.ajax({
            type: "GET",     
            url: "/BugHound_omg/getfuncarea?program=".concat(value),
            data: "{program: " + value + "}",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (result) {
                debugger;
 
                alert("area")
                var json=result;
             
                $("#func_select").html('');
                
       		 $.each(result, function(index, element) {
       			 var div_data3="<option value="+element.functionalarea+">"+element.functionalarea+"</option>";
                 $(div_data3).appendTo('#funcarea'); 
        	
        
    });

           	 },
            error: function (response) {
                debugger;
                alert(response.responseText);
            }
        });

    }
// function getprogram(value)
// {
// 	alert(value);
	
// 	$('#program').change(
// 			function(event) {			
// 				var data = $('#program').val();
// 				$.ajax({
// 					url : 'BugHound_omg/savedata2?id='.concat(value),
// 					data : data,
// 					type : "GET",
	 
// 					success : function(response) {
// 						alert( response );
// 					},
// 					error : function(xhr, status, error) {
// 						alert(xhr.responseText);
// 					}
// 				});
// 				return false;
// 			});
	
	
	
// 	}
	</script>
 
</body> 
</html>