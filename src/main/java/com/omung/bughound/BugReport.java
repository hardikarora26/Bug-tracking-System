package com.omung.bughound;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

public class BugReport {
public int report_id;
public String program;
public int	program_release;
public int	version;
public String	companyname;
public Boolean	confidential;
public String	problem_summary;
public Boolean	reproducable;
public String	reproduction;
public String	suggested_fix; 
public String	reported_by;
public String	date;
public String severity;
public String status;
public String priority;
public String functional_area;
public String assigned_to;
public String resolution;
public String resolutionversion;
public String resolutiondate;
public String testdate;
public String resolutiontestedby;
public String comments;
public String resolved_by;
private String file;

public String getFile() {
	return file;
}

public void setFile(String file) {
	this.file = file;
}
public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
}

public String getFunctionalarea() {
	return functional_area;
}

public void setFunctionalarea(String functional_area) {
	this.functional_area = functional_area;
}

public String getAssignedto() {
	return assigned_to;
}

public void setAssignedto(String assigned_to) {
	this.assigned_to = assigned_to;
}

public String getResolution() {
	return resolution;
}

public void setResolution(String resolution) {
	this.resolution = resolution;
}

public String getResolutionversion() {
	return resolutionversion;
}

public void setResolutionversion(String resolutionversion) {
	this.resolutionversion = resolutionversion;
}

public String getResolutiondate() {
	return resolutiondate;
}

public void setResolutiondate(String resolutiondate) {
	this.resolutiondate = resolutiondate;
}

public String getTestdate() {
	return testdate;
}

public void setTestdate(String testdate) {
	this.testdate = testdate;
}

public String getResolutiontestedby() {
	return resolutiontestedby;
}

public void setResolutiontestedby(String resolutiontestedby) {
	this.resolutiontestedby = resolutiontestedby;
}

public String getComments() {
	return comments;
}

public void setComments(String comments) {
	this.comments = comments;
}

public String getResolvedby() {
	return resolved_by;
}

public void setResolvedby(String resolved_by) {
	this.resolved_by = resolved_by;
}

public String getSeverity() {
	return severity;
}

public void setSeverity(String severity) {
	this.severity = severity;
}

public String getReporttype() {
	return report_type;
}

public void setReporttype(String report_type) {
	this.report_type = report_type;
}
public String report_type;
public int getId() {
	return report_id;
}
public void setId(int report_id) {
	this.report_id=report_id;
}

public String getProgram() {
	return program;
}
public void setProgram(String program) {
	this.program = program;
}
public int getProgramrelease() {
	return program_release;
}
public void setProgramrelease(int program_release) {
	this.program_release = program_release;
}
public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public Boolean getConfidential() {
	return confidential;
}
public void setConfidential(Boolean confidential) {
	this.confidential = confidential;
}
public String getProblemsummary() {
	return problem_summary;
}
public void setProblemsummary(String problem_summary) {
	this.problem_summary = problem_summary;
}
public Boolean getReproducable() {
	return reproducable;
}
public void setReproducable(Boolean reproducable) {
	this.reproducable = reproducable;
}
public String getReproduction() {
	return reproduction;
}
public void setReproduction(String reproduction) {
	this.reproduction = reproduction;
}
public String getSuggestedfix() {
	return suggested_fix;
}
public void setSuggestedfix(String suggested_fix) {
	this.suggested_fix = suggested_fix;
}
public String getReportedby() {
	return reported_by;
}
public void setReportedby(String reported_by) {
	this.reported_by = reported_by;
}
public String getDate() {
	return date;
}
public void setDate(String string) {
	this.date = string;
}
}
