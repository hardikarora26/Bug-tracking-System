package com.omung.bughound;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="severity")
public class Severity {
@Id
public int severity_id;
public String severity;
public int getSeverity_id() {
	return severity_id;
}
public void setSeverity_id(int severity_id) {
	this.severity_id = severity_id;
}
public String getSeverity() {
	return severity;
}
public void setSeverity(String severity) {
	this.severity = severity;
}
}
