package com.omung.bughound;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class FetchFromDatabase {
 
Jdbc_conn jdbcconn=new Jdbc_conn();
	public ArrayList<String> getPriorities() throws ClassNotFoundException, SQLException
{
	String sql="select * from priority";
	ResultSet rs=jdbcconn.connection(sql);
	ArrayList arr=new ArrayList<String>();
	while(rs.next())
	{
		
		arr.add(rs.getString("priority"));
	}
	return arr;
}
	public ArrayList<String> getSeverities() throws ClassNotFoundException, SQLException
{
	String sql="select * from severity";
	ResultSet rs=jdbcconn.connection(sql);
	ArrayList arr=new ArrayList<String>();
	while(rs.next())
	{
		
		arr.add(rs.getString("severity"));
	}
	return arr;
}
	public ArrayList<Program> getPrograms() throws ClassNotFoundException, SQLException
{
	String sql="select * from program";
	ResultSet rs=jdbcconn.connection(sql);
	ArrayList<Program> arr=new ArrayList<Program>();
	while(rs.next())
	{ Program prgm=new Program();
	prgm.setProgram_id(rs.getInt("program_id"));
	prgm.setProgram(rs.getString("program"));
	prgm.setPrgram_release(rs.getInt("prgram_release"));
	prgm.setVersion(rs.getInt("version"));
		
		arr.add(prgm);
	}
	return arr;
}
	public ArrayList<String> getArea(int programid) throws ClassNotFoundException, SQLException
	{
		String sql="select * from area where program_id="+programid;
		ResultSet rs=jdbcconn.connection(sql);
		ArrayList arr=new ArrayList<String>();
		int count=0;
		while(rs.next())
		{
			count++;
			FunctionalArea func=new FunctionalArea();
			func.setFunctionalarea(rs.getString("functionalarea"));
			func.setProgramid(rs.getInt("program_id"));
			func.setAreaid(rs.getInt("area_id"));
			
			arr.add(func);
		}
		
		return arr;
	}
	public ArrayList<String> getReportType() throws ClassNotFoundException, SQLException
	{
		String sql="select * from reporttype";
		ResultSet rs=jdbcconn.connection(sql);
		ArrayList arr=new ArrayList<String>();
		while(rs.next())
		{
			
			arr.add(rs.getString("reporttype"));
		}
		return arr;
	}
	public String addPrgram(String program,String release,String version) throws ClassNotFoundException, SQLException
	{ String str="";
		String sql="select * from program where program='"+program+"' and prgram_release='"+release+"' and version='"+version+"'";
		ResultSet rs=jdbcconn.connection(sql);
		ArrayList arr=new ArrayList<String>();
		while(rs.next())
		{
		 str="Program already exists";
		return str;
		}
		str="Program has been added successfully";
		String sql2="insert into program(program,prgram_release,version) values('"+program+"','"+release+"','"+version+"')";
		jdbcconn.insertop(sql2);
		
		return str;
	}
	public void updateProgram(String program,String release,String version,int id) throws ClassNotFoundException, SQLException
	{ 
		String sql="update program set program='"+program+"', program_release='"+release+"', version="+version+" where program_id='"+id+"'";

		jdbcconn.insertop(sql);

	}
	public void updateFunctionalArea(String program_id,String functionalarea,int id) throws ClassNotFoundException, SQLException
	{ 
		String sql="update area set program_id='"+program_id+"', functionalarea='"+functionalarea+"' where area_id='"+id+"'";

		jdbcconn.insertop(sql);

	}
	public ArrayList<FunctionalArea> getFunctionalArea(int id) throws ClassNotFoundException, SQLException
	{ 
		
		String sql="select * from area where area_id="+id;
		ResultSet rs=jdbcconn.connection(sql);
		ArrayList<FunctionalArea> arr=new ArrayList<FunctionalArea>();
		while(rs.next())
		{ FunctionalArea func=new FunctionalArea();
		func.setProgramid(rs.getInt("program_id"));
		ArrayList<Program> prgm=getProgrambyId(rs.getInt("program_id"));
		String str=prgm.get(0).getProgram();
		func.setProgram(str);
		func.setFunctionalarea(rs.getString("functionalarea"));
		func.setAreaid(rs.getInt("area_id"));
		
			arr.add(func);
		
		
		}
		return arr;
	}
	public void updateUser(String userrole,String password,String username) throws ClassNotFoundException, SQLException
	{ 
		String sql="update user set password='"+password+"' where username='"+username+"'";
		String sql2="update user set role='"+userrole+"' where username='"+username+"'";

		jdbcconn.insertop(sql);
		jdbcconn.insertop(sql2);

	}
	public ArrayList<User> getUser(int id) throws ClassNotFoundException, SQLException
	{ 
		
		String sql="select * from user where user_id='"+id+"'";
		ResultSet rs=jdbcconn.connection(sql);
		ArrayList<User> arr=new ArrayList<User>();
		while(rs.next())
		{ 
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUser_id(rs.getInt("user_id"));
				user.setUserrole(rs.getString("userrole"));
		arr.add(user);
		}
		return arr;
	}
	public void addArea(String area,int programid) throws ClassNotFoundException, SQLException
	{
		
		String sql="insert into area(functionalarea,program_id) values('"+area+"',"+programid+")";
		jdbcconn.insertop(sql);
	}
	public String addUser(String user,String password,String role) throws ClassNotFoundException, SQLException
	{
		String check="select * from user where username='"+user+"'";
		ResultSet rs=jdbcconn.connection(check);
		if(rs.next())
		{
			return "user already exists";
		}
		String sql="insert into user (username,password,enabled) values('"+user+"','"+password+"',1)";
		jdbcconn.insertop(sql);
		String sql2="insert into userroles (username,role) values('"+user+"','"+role+"')";
		jdbcconn.insertop(sql2);
		return "user added successfully";
	}
//	public ArrayList<String> getReportType() throws ClassNotFoundException, SQLException
//	{
//		String sql="select * from reporttype";
//		ResultSet rs=jdbcconn.connection(sql);
//		ArrayList arr=new ArrayList<String>();
//		while(rs.next())
//		{
//			
//			arr.add(rs.getString("reporttype"));
//		}
//		return arr;
//	}
	public ArrayList<String> getStatuses() throws ClassNotFoundException, SQLException {
		String sql="select * from status";
		ResultSet rs=jdbcconn.connection(sql);
		ArrayList arr=new ArrayList<String>();
		while(rs.next())
		{
			
			arr.add(rs.getString("status"));
		}
		return arr;}

	public ArrayList<String> getUserroles() throws ClassNotFoundException, SQLException {
		String sql="select * from userroles";
		ResultSet rs=jdbcconn.connection(sql);
		ArrayList arr=new ArrayList<String>();
		while(rs.next())
		{
			Userroles user=new Userroles();
			
			user.setUsername(rs.getString("username"));
			user.setRole(rs.getString("role"));
			arr.add(user);
		}
		return arr;}
	public ArrayList<String> getResolutions() throws ClassNotFoundException, SQLException {
		String sql="select * from resolution";
		ResultSet rs=jdbcconn.connection(sql);
		ArrayList arr=new ArrayList<String>();
		while(rs.next())
		{
			
			arr.add(rs.getString("resolution"));
		}
		return arr;}
	public void storeData(String companyname, Boolean confidential,
			String problem_summary, String program, String program_release,
			String reported_by, Boolean reproducable, String reproduction,
			String suggested_fix, String version, String report_type,
			String severity,String date,
			String status, String priority,
			String resolution, int resolution_version, String functional_area,
			String comment, String resolvedby, String testedby, String resolutiondate,
			String testdate,String assigned_to,String image) throws ClassNotFoundException, SQLException
	{
		
		String str="select * from program where program='"+program+"'";
		ResultSet rs=jdbcconn.connection(str);
	int programid=0;
		if(rs.next())
		{
		 programid=rs.getInt("program_id");
		}
		String sql= "insert into bugreport(companyname, confidential, problem_summary, program, program_release, reported_by, reproducable, reproduction, suggested_fix, version,report_type,severity,date,status, priority, resolution, resolutionversion, functional_area, comments, resolved_by, resolutiontestedby, resolutiondate, testdate,assigned_to,image) values ('"+companyname+"',"+ confidential+",'"+ problem_summary+"',"+ programid+",'"+program_release+"','"+ reported_by+"',"+ reproducable+",'"+ reproduction+"','"+ suggested_fix+"','"+ version+"','"+report_type+"','"+severity+"','"+ date+"', '"+status+"','"+ priority+"','"+ resolution+"','"+resolution_version+"','"+functional_area+"','"+ comment+"','"+ resolvedby+"','"+ testedby+"','"+ resolutiondate+"','"+ testdate+"' , '"+assigned_to+"', '"+image+"')";
		 ResultSet rs2=	jdbcconn.insertop(sql);
	}
	public void searchData(String companyname, Boolean confidential,
			String priority,String resolutiondate,String testdate,String program,
			String reported_by, Boolean reproducable, String report_type, String severity,String date) throws ClassNotFoundException, SQLException
	{ int a=0;
	String str2="select * from program where program='"+program+"'";
	ResultSet rs=jdbcconn.connection(str2);
	rs.next();
		String str="select * from bugreport where";
	
				  if(program!="choose") 
				  { a++;
				   str=str.concat("program='"+rs.getInt("program")+"'"); 
				  }
				  
				if(report_type!="choose") 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("report_type="+report_type+""); 
				  } 
				  if(companyname!=null) 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("companyname= '"+companyname+"'"); 
				  } 
				  if(confidential!=null) 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("confidential= '"+confidential+"' "); 
				  } 
				  
				  if(reported_by!="choose") 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("reported_by= '"+reported_by+"' "); 
				  } 
				  if(reproducable!=null) 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("reproducable="+reproducable+" and"); 
				  } 
				 
				 
				 
				  if(severity!="choose") 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("severity= '"+severity+"' "); 
				  } 
				  if(priority!="choose") 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("priority= '"+priority+"'"); 
				  } 
				  if(date!=null) 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("date= '"+date+"'"); 
				  } 
				  if(resolutiondate!=null) 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("resolutiondate= '"+resolutiondate+"'"); 
				  } 
				  if(testdate!=null) 
				  { if(a!=0){str=str.concat(" and ");}
				   str=str.concat("testdate= '"+testdate+"'"); 
				  } 
				   
				   
				  jdbcconn.insertop(str); 
				 }
		
	
	
	public void storeDataintoBugFix(String status, String priority,
			String resolution, int resolution_version, String functional_area,
			String comment, String resolvedby, String testedby, String reqdate,
			String testdate) throws ClassNotFoundException, SQLException {
		
		 String sql= "insert into bugreport(bugid,status, priority, resolution, resolution_version, functional_area, comments, resolvedby, testedby, reqdate, testdate) values ('"+status+"','"+ priority+"','"+ resolution+"','"+resolution_version+"','"+functional_area+"','"+ comment+"','"+ resolvedby+"','"+ testedby+"','"+ reqdate+"','"+ testdate+"')";
		jdbcconn.insertop(sql);
		
	}
	public ArrayList<BugReport> searchData2(int report_id,String priority, String resolution,
			String assigned_to, String resolved_by, String reportdate,
			String program, String reported_by, String report_type,
			String severity, String functional_area, String status) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		{ int a=0;
System.out.println(program);
		
		String str="select * from bugreport where ";
		 String str2="select * from program where program='"+program+"'";
		 if(!program.equalsIgnoreCase("choose") && !program.equalsIgnoreCase("")) 
	       
	      { 
	      
	      ResultSet rs2=jdbcconn.connection(str2);
	      rs2.next();
	      a++;
	       str=str.concat("program='"+rs2.getInt("program_id")+"'"); 
	      }
	      if(report_id!=0 )
	      {
	    	  if(a!=0){str=str.concat(" and ");}
	        str=str.concat("report_id="+report_id+"");
	        a++;
	       } 
	    if(!report_type.equalsIgnoreCase("choose")  && !report_type.equalsIgnoreCase("")) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("report_type='"+report_type+"'"); 
	       a++;
	      } 
	      if(functional_area!=null && !functional_area.equalsIgnoreCase("")) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("functional_area= '"+functional_area+"'"); 
	       a++;  } 
	      if(status!=null && !status.equalsIgnoreCase("")&& status!=null && !status.equalsIgnoreCase("choose")) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("status= '"+status+"'"); 
	       a++; } 
	      if(assigned_to!=null && !assigned_to.equalsIgnoreCase("")) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("assigned_to= '"+assigned_to+"'"); 
	       a++;} 
	      if(resolved_by!=null && !resolved_by.equalsIgnoreCase("")) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("resolved_by= '"+resolved_by+"' "); 
	       a++;} 
	      
	      if(reported_by!=null&& !reported_by.equalsIgnoreCase("") && !reported_by.equalsIgnoreCase("choose")) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("reported_by= '"+reported_by+"' "); 
	       a++;} 
	      if(resolution!=null && !resolution.equalsIgnoreCase("") && !resolution.equalsIgnoreCase("choose")) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("resolution= '"+resolution+"' "); 
	       a++; } 
	     
	     
	     
	      if(!severity.equalsIgnoreCase("choose") && severity!=null&& !severity.equalsIgnoreCase("choose") ) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("severity= '"+severity+"' "); 
	       a++;} 
	      if(!priority.equalsIgnoreCase("choose") && priority!=null && !priority.equalsIgnoreCase("") ) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("priority= '"+priority+"'"); 
	       a++;} 
	      if(reportdate!=null && !reportdate.equalsIgnoreCase("choose") && !reportdate.equalsIgnoreCase("")) 
	      { if(a!=0){str=str.concat(" and ");}
	       str=str.concat("date= '"+reportdate+"'"); 
	       a++; }

		System.out.println(str);
				  
				  ResultSet rs= jdbcconn.connection(str);
				  ArrayList<BugReport> arr=new ArrayList();
				  while(rs.next()){
					  BugReport bugreport=new BugReport();
					  bugreport.setId(rs.getInt("report_id")) ;
					  String str3="select * from program where program_id='"+rs.getInt("program")+"'";
						ResultSet rs3=jdbcconn.connection(str2);
						rs3.next();
						try{
					  bugreport.setProgram(rs3.getString("program")) ;
						}
						catch(Exception e)
						{
							
							 bugreport.setProgram("") ;
						}
						 bugreport.setReproduction(rs.getString("reproduction")) ;
						 bugreport.setProblemsummary(rs.getString("problem_summary")) ;
						 bugreport.setReporttype(rs.getString("report_type"));

					  bugreport.setSeverity(rs.getString("severity"));

					  bugreport.setFunctionalarea(rs.getString("functional_area"));

					  bugreport.setAssignedto(rs.getString("assigned_to"));

					  bugreport.setStatus(rs.getString("status"));

					  bugreport.setPriority(rs.getString("priority"));

					  bugreport.setResolution(rs.getString("resolution"));

					  bugreport.setReportedby(rs.getString("reported_by"));

					  bugreport.setDate(rs.getString("date"));

					  bugreport.setResolvedby(rs.getString("resolved_by"));
					  bugreport.setStatus(rs.getString("status"));
					  bugreport.setPriority(rs.getString("priority"));
					  bugreport.setFunctionalarea(rs.getString("functional_area"));
					  bugreport.setAssignedto(rs.getString("assigned_to"));
					  bugreport.setResolution(rs.getString("resolution"));
					  bugreport.setResolutionversion(rs.getString("resolutionversion"));
					  bugreport.setResolutiondate(rs.getString("resolutiondate"));
					  bugreport.setTestdate(rs.getString("testdate"));
					  bugreport.setResolutiontestedby(rs.getString("resolutiontestedby"));
					  bugreport.setComments(rs.getString("comments"));			  
				  arr.add(bugreport);
				  
				  
				  }
				 return arr; 
				 }
		
	
	
	}
public ArrayList<BugReport> getBugDetails(int id) throws ClassNotFoundException, SQLException {
		
		
		String sql= "select * from bugreport where report_id="+id+"";
	ResultSet rs=jdbcconn.connection(sql);
	ArrayList<BugReport> arr=new ArrayList();
	 while(rs.next()){
		 BugReport bugreport=new BugReport();
		 bugreport.setId(rs.getInt("report_id")) ;
		bugreport.setCompanyname(rs.getString("companyname"));
		bugreport.setProgramrelease(rs.getInt("program_release"));
		bugreport.setVersion(rs.getInt("version"));
		String str2="select * from program where program_id="+rs.getString("program")+"";
			ResultSet rs2=jdbcconn.connection(str2);
		if(rs2.next()){
			bugreport.setProgram(rs2.getString("program")) ;
		}
		else{
		 bugreport.setProgram("") ;
		}

		 bugreport.setReporttype(rs.getString("report_type"));
bugreport.setProblemsummary(rs.getString("problem_summary"));
bugreport.setConfidential(rs.getBoolean("confidential"));
bugreport.setReproducable(rs.getBoolean("reproducable"));
bugreport.setReproduction(rs.getString("reproduction"));
bugreport.setSuggestedfix(rs.getString("suggested_fix"));
		 bugreport.setSeverity(rs.getString("severity"));

		 bugreport.setFunctionalarea(rs.getString("functional_area"));

		 bugreport.setAssignedto(rs.getString("assigned_to"));

		 bugreport.setStatus(rs.getString("status"));

		 bugreport.setPriority(rs.getString("priority"));

		 bugreport.setResolution(rs.getString("resolution"));

		 bugreport.setReportedby(rs.getString("reported_by"));

		 bugreport.setDate(rs.getString("date"));

		 bugreport.setResolvedby(rs.getString("resolved_by"));

		 bugreport.setResolutionversion(rs.getString("resolutionversion"));
		 bugreport.setResolutiondate(rs.getString("resolutiondate"));
		 bugreport.setTestdate(rs.getString("testdate"));
		 bugreport.setResolutiontestedby(rs.getString("resolutiontestedby"));
		 bugreport.setComments(rs.getString("comments"));	
		 bugreport.setFile(rs.getString("image"));	
	 arr.add(bugreport);
	 }
	 return arr;
	}

public void updateData(String companyname, Boolean confidential,
			String problem_summary, String program, int program_release,
			String reported_by, Boolean reproducable, String reproduction,
			String suggested_fix, long version, String report_type,
			String severity, String date, String status, String priority,
			String resolution, int resolution_version, String functional_area,
			String comment, String resolvedby, String testedby,
			String resolutiondate, String testdate, String assigned_to,int report_id, String fn) throws ClassNotFoundException, SQLException {
		String str="select * from program where program='"+program+"'";
		ResultSet rs=jdbcconn.connection(str);
		int programvalue=0;
		if(rs.next()){
			programvalue=rs.getInt("program_id");}
		 String sql= "update bugreport set"
		 		+ " companyname="+"'"+companyname+"', confidential="+ confidential+", problem_summary ='"+ problem_summary+"',program ="+programvalue+","
		 				
		 		+ " program_release ="+program_release+" ,reported_by= '"+ reported_by+"',"
		 		+ " reproducable = "+ reproducable+","
		 		+ " reproduction ='"+ reproduction+"' ,"
		 		+ " suggested_fix ='"+suggested_fix+"' ,"
		 		+ " version ="+ version+","
		 		+ "report_type ='"+report_type+"' ,"
		 		+ "severity= '"+severity+"' ,"
		 		+ "date ='"+date+"' ,"
		 		+ "status ='"+status+"' ,"
		 		+ " priority ="+priority+","
		 		+ " resolution ='"+ resolution +"' ,"
		 		+ " resolutionversion ="+resolution_version+" ,"
		 		+ " functional_area ='"+functional_area+"' ,"
		 		+ " comments ='"+comment+"' ,"
		 		+ " resolved_by ='"+resolvedby+"' ,"
		 		+ " resolutiontestedby ='"+testedby+"' ,"
		 		+ " resolutiondate ='"+resolutiondate+"' ,"
		 		+ " testdate ='"+testdate+"' ,"
		 		+ "assigned_to ='"+assigned_to+"' ,"
		 		+ "image ='"+fn+"' where report_id="+report_id+"";
		 ResultSet rs2=	jdbcconn.insertop(sql);
		if(rs2.next())
		 System.out.println(rs2);
	}
	public void deleteBug(int id) throws ClassNotFoundException, SQLException {
		
		String sql="delete from bugreport where report_id="+id;
		jdbcconn.insertop(sql);
		
	}
	public ArrayList<Program> getReleaseVersion(String program) throws ClassNotFoundException, SQLException {
		String sql="select * from program where program='"+program+"'";
	ResultSet rs=jdbcconn.connection(sql);
	ArrayList<Program> arr=new ArrayList<Program>();
	while(rs.next())
	{ Program prgm=new Program();
	prgm.setProgram_id(rs.getInt("program_id"));
	prgm.setProgram(rs.getString("program"));
	prgm.setPrgram_release(rs.getInt("prgram_release"));
	prgm.setVersion(rs.getInt("version"));
		
		arr.add(prgm);
	}
return arr;
}
	public ArrayList<FunctionalArea> getFunctionalArea(String program) throws ClassNotFoundException, SQLException 
	{
		String sql="select * from program where program='"+program+"'";
		ResultSet rs=jdbcconn.connection(sql);
		rs.next();
		int programid=rs.getInt("program_id");
		String sql2="select * from area where program_id="+programid;
		ResultSet rs2=jdbcconn.connection(sql);
		ArrayList<FunctionalArea> arr=new ArrayList<FunctionalArea>();
		while(rs.next())
		{ FunctionalArea func=new FunctionalArea();
		func.setProgramid(rs.getInt("program_id"));
		func.setFunctionalarea(rs.getString("functionalarea"));
		func.setAreaid(rs.getInt("area_id"));
		
			arr.add(func);
		}
		
		
		
		return arr;
	}
	public ArrayList<Program> getProgrambyId(int id) throws ClassNotFoundException, SQLException {
		String sql="select * from program where program_id="+id+"";
	ResultSet rs=jdbcconn.connection(sql);
	ArrayList<Program> arr=new ArrayList<Program>();
	while(rs.next())
	{
		Program prgm=new Program();
	prgm.setProgram_id(rs.getInt("program_id"));
	prgm.setProgram(rs.getString("program"));
	prgm.setPrgram_release(rs.getInt("prgram_release"));
	prgm.setVersion(rs.getInt("version"));
		
		arr.add(prgm);
	}
return arr;
}
	public StringBuilder expotxml(String name) throws ClassNotFoundException, SQLException, IOException {
	String sql="select * from "+name;
	ResultSet rs=jdbcconn.connection(sql);
	StringBuilder response=new StringBuilder();
	int counter=1;
File file=new File("//home//omung//workspace//omungproj_xmls//xmlfile"+counter+".xml");


	while(file.exists())
	{ 
		counter++;
	file=new File("//home//omung//workspace//omungproj_xmls//xmlfile"+counter+".xml");
if(file.exists()){
	continue;
}
else{System.out.println("We had to make a new file.");
        file.createNewFile();
break;}}
	response.append("<TABLENAME>");

	if(name.equalsIgnoreCase("bugreport"))
	{
		while(rs.next())
		{
		response.append("<ROW>");
		response.append("<REPORT_ID>");
		response.append(rs.getString("report_id"));
		response.append("</REPORT_ID>");

		response.append("<PROGRAM_RELEASE>");
		response.append(rs.getString("program_release"));
		response.append("</PROGRAM_RELEASE>");

		response.append("<VERSION>");
		response.append(rs.getString("version"));
		response.append("</VERSION>");

		response.append("<COMPANYNAME>");
		response.append(rs.getString("companyname"));
		response.append("</COMPANYNAME>");

		response.append("<CONFIDENTIAL>");
		response.append(rs.getString("confidential"));
		response.append("</CONFIDENTIAL>");

		response.append("<PROBLEM_SUMMARY>");
		response.append(rs.getString("problem_summary"));
		response.append("</PROBLEM_SUMMARY>");

		response.append("<REPRODUCABLE>");
		response.append(rs.getString("reproducable"));
		response.append("</REPRODUCABLE>");

		response.append("<REPRODUCTION>");
		response.append(rs.getString("reproduction"));
		response.append("</REPRODUCTION>");

		response.append("<SUGGESTED_FIX>");
		response.append(rs.getString("suggested_fix"));
		response.append("</SUGGESTED_FIX>");

		response.append("<REPORTED_BY>");
		response.append(rs.getString("reported_by"));
		response.append("</REPORTED_BY >");

		response.append("<REPORT_TYPE >");
		response.append(rs.getString("report_type"));
		response.append("</REPORT_TYPE >");

		response.append("<SEVERITY>");
		response.append(rs.getString("severity"));
		response.append("</SEVERITY>");

		response.append("<PROGRAM>");
		response.append(rs.getString("program"));
		response.append("</PROGRAM>");

		response.append("<DATE>");
		response.append(rs.getString("date"));
		response.append("</DATE>");

		response.append("<STATUS>");
		response.append(rs.getString("status"));
		response.append("</STATUS>");

		response.append("<PRIORITY>");
		response.append(rs.getString("priority"));
		response.append("</PRIORITY>");

		response.append("<FUNCTIONAL_AREA>");
		response.append(rs.getString("functional_area"));
		response.append("</FUNCTIONAL_AREA>");


		response.append("<ASSIGNED_TO>");
		response.append(rs.getString("assigned_to"));
		response.append("</ASSIGNED_TO>");


		response.append("<RESOLUTION>");
		response.append(rs.getString("resolution"));
		response.append("</RESOLUTION>");


		response.append("<RESOLVED_BY>");
		response.append(rs.getString("resolved_by"));
		response.append("</RESOLVED_BY>");


		response.append("<RESOLUTIONVERSION>");
		response.append(rs.getString("resolutionversion"));
		response.append("</RESOLUTIONVERSION>");

		response.append("<COMMENTS>");
		response.append(rs.getString("comments"));
		response.append("</COMMENTS>");

		response.append("<RESOLUTIONTESTEDBY>");
		response.append(rs.getString("resolutiontestedby"));
		response.append("</RESOLUTIONTESTEDBY>");

		response.append("<RESOLUTIONDATE>");
		response.append(rs.getString("resolutiondate"));
		response.append("</RESOLUTIONDATE>");

		response.append("<TESTDATE>");
		response.append(rs.getString("testdate"));
		response.append("</TESTDATE>");

		response.append("<IMAGE>");
		response.append(rs.getString("image"));
		response.append("</IMAGE>");


		
		
		response.append("</ROW>");
		}
	}
		if(name.equalsIgnoreCase("program"))
		{
			while(rs.next())
			{
				response.append("<ROW>");
				response.append("<PROGRAM>");
				response.append(rs.getString("program"));
				response.append("</PROGRAM>");

				response.append("<PROGRAM_ID>");
				response.append(rs.getString("program_id"));
				response.append("</PROGRAM_ID>");

				response.append("<PRGRAM_RELEASE>");
				response.append(rs.getString("prgram_release"));
				response.append("</PRGRAM_RELEASE>");

				response.append("<VERSION>");
				response.append(rs.getString("version"));
				response.append("</VERSION>");
				response.append("</ROW>");
			}
		}
		if(name.equalsIgnoreCase("area"))
		{
			while(rs.next())
			{
				response.append("<ROW>");
				response.append("<AREA_ID>");
				response.append(rs.getString("area_id"));
				response.append("</AREA_ID>");

				response.append("<FUNCTIONALAREA>");
				response.append(rs.getString("functionalarea"));
				response.append("</FUNCTIONALAREA>");

				response.append("<PROGRAM_ID>");
				response.append(rs.getString("program_id"));
				response.append("</PROGRAM_ID>");
				response.append("</ROW>");

			}}
		if(name.equalsIgnoreCase("user"))
		{
			while(rs.next())
			{
				response.append("<ROW>");
				response.append("<USERNAME>");
				response.append(rs.getString("username"));
				response.append("</USERNAME>");

				response.append("<PASSWORD>");
				response.append(rs.getString("password"));
				response.append("</PASSWORD>");

				response.append("<ENABLED>");
				response.append(rs.getString("enabled"));
				response.append("</ENABLED>");

				response.append("<USER_ID>");
				response.append(rs.getString("user_id"));
				response.append("</USER_ID>");
				response.append("</ROW>");
			}
			}
	
	response.append("</TABLENAME>");
	FileWriter fw = new FileWriter(file.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write(response.toString());
	bw.close();

	return response;
	}
	public int getProgrambyName(String program) throws ClassNotFoundException, SQLException {
		String sql="select * from program where program='"+program+"'";
		ResultSet rs=jdbcconn.connection(sql);
		if(rs.next()){return rs.getInt("program_id");}
		return 0;
	}
	}
