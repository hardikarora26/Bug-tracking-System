package com.omung.bughound;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BatchJob implements RowMapper<BugReport>{
	
	public BugReport mapRow(ResultSet resultSet, int rowNum) throws SQLException {  
		BugReport bugReport= new BugReport();
		bugReport.setAssignedto(resultSet.getString("assigned_to"));
		bugReport.setComments(resultSet.getString("comments"));
		bugReport.setCompanyname(resultSet.getString("companyname"));
		bugReport.setConfidential(resultSet.getBoolean("confidential"));
		bugReport.setDate(resultSet.getString("date"));
		bugReport.setFile(resultSet.getString("file"));
		bugReport.setFunctionalarea(resultSet.getString("functionalarea"));
		bugReport.setId(resultSet.getInt(""));
		bugReport.setPriority(resultSet.getString("priority"));
	  
	  return bugReport;  
	 }  
}
