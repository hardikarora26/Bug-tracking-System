package com.omung.bughound;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UpdateController {
	FetchFromDatabase fetchFromDatabase= new FetchFromDatabase();
@RequestMapping("/getprogrambyid")
	public String getProgrambyId(@RequestParam("id") int id,Model model) throws ClassNotFoundException, SQLException
{
ArrayList<Program> program=fetchFromDatabase.getProgrambyId(id);
model.addAttribute("program", program);
	return "updateprogram";
	}
@RequestMapping("/updateprogram")
public String updateProgram(@RequestParam("program") String program,@RequestParam("id") int id,@RequestParam("release") String release,@RequestParam("version") String version,Model model) throws ClassNotFoundException, SQLException
{
fetchFromDatabase.updateProgram(program, release, version, id);

return "home";
}
@RequestMapping("/getfunctionalarea")
public String getfunctionalarea(@RequestParam("id") int id,Model model) throws ClassNotFoundException, SQLException
{
ArrayList<FunctionalArea> functionalarea=fetchFromDatabase.getFunctionalArea(id);
model.addAttribute("functionalarea", functionalarea);
return "updatefunctionalarea";
}
@RequestMapping("/export")
public String mainexport(){
 
 return "export";
}

@RequestMapping("/updatefunctionalarea")
public String updatefunctionalarea(@RequestParam("program_id") String program_id,@RequestParam("functionalarea") String functionalarea,@RequestParam("id") int id,Model model) throws ClassNotFoundException, SQLException
{
fetchFromDatabase.updateFunctionalArea(program_id, functionalarea, id);
return "home";
}
@RequestMapping("/getuser")
public String getuser(@RequestParam("id") int id,Model model) throws ClassNotFoundException, SQLException
{
ArrayList<User> user=fetchFromDatabase.getUser(id);
model.addAttribute("users", user);
return "updateuser";
}
@RequestMapping("/updateuser")
public String updateUser(@RequestParam("userrole") String userrole,@RequestParam("password") String password,@RequestParam("username") String username,Model model) throws ClassNotFoundException, SQLException
{
fetchFromDatabase.updateUser(userrole, password, username);
return "home";
}
@RequestMapping("/exportxml")
public String export(@RequestParam("name") String name,Model model) throws ClassNotFoundException, SQLException, IOException
{
fetchFromDatabase.expotxml(name);
return "home";
}
}
