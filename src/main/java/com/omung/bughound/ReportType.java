package com.omung.bughound;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reporttype")
public class ReportType {
@Id
public int reporttype_id;
public String reporttype;
public int getReporttype_id() {
	return reporttype_id;
}
public void setReporttype_id(int reporttype_id) {
	this.reporttype_id = reporttype_id;
}
public String getReporttype() {
	return reporttype;
}
public void setReporttype(String reporttype) {
	this.reporttype = reporttype;
}
}
