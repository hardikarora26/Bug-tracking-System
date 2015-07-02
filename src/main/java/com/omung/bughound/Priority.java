package com.omung.bughound;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="priority")
public class Priority {
@Id
public int priority_id;
public String priority;
public int getPriority_id() {
	return priority_id;
}
public void setPriority_id(int priority_id) {
	this.priority_id = priority_id;
}
public String getPriority() {
	return priority;
}
public void setPriority(String priority) {
	this.priority = priority;
}
}
