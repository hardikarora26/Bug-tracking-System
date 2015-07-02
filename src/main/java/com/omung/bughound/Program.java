package com.omung.bughound;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Program {
public int program_id;
public String program;
public int prgram_release;
public int version;
public int getPrgram_release() {
	return prgram_release;
}
public void setPrgram_release(int prgram_release) {
	this.prgram_release = prgram_release;
}
public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}
public int getProgram_id() {
	return program_id;
}
public void setProgram_id(int program_id) {
	this.program_id = program_id;
}
public String getProgram() {
	return program;
}
public void setProgram(String program) {
	this.program = program;
}

}
