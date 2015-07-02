package com.omung.bughound;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="resolution")
public class Resolution {
@Id
public int resolution_id;
public String resolution;
public int getResolution_id() {
	return resolution_id;
}
public void setResolution_id(int resolution_id) {
	this.resolution_id = resolution_id;
}
public String getResolution() {
	return resolution;
}
public void setResolution(String resolution) {
	this.resolution = resolution;
}

}
