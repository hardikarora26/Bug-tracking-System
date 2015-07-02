package com.omung.bughound;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class MainController {
	
	FetchFromDatabase fetchFromDatabase=new FetchFromDatabase();
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	

	@RequestMapping("/")
	public String abc(Model model){
		System.out.println("main chal gya :P");
		return "login";

	}
	@RequestMapping("/gohome")
	public String home(Model model){
		System.out.println("main chal gya :P");
		return "home";

	}
	@RequestMapping("/login")
	public String login(@RequestParam(required = false) String authfailed,
			String logout, String denied, Model model,HttpServletRequest request){
		System.out.println("main chal gya :P...authfailed login");
		String message = "";
		HttpSession session=request.getSession();
		if (authfailed != null) {
			message = "Invalid username or password, try again !";
		} else if (logout != null) {

			session.invalidate();
			message = "Logged Out successfully, login again to continue !";
		} else if (denied != null) {
			message = "Access denied for this user !";
		}
		model.addAttribute("message", message);
		return "login";

	}
	@RequestMapping("/home")
	public String getHomePage(Model model){
		System.out.println("main chal gya :P");
		return "home";

	}
	@RequestMapping("/create")
	public String create(Model model) throws ClassNotFoundException, SQLException{
		System.out.println("main chal gya :P...........create");
	model.addAttribute("priority",fetchFromDatabase.getPriorities());
		model.addAttribute("severity",fetchFromDatabase.getSeverities());
		model.addAttribute("status",fetchFromDatabase.getStatuses());
		model.addAttribute("program",fetchFromDatabase.getPrograms());
		model.addAttribute("reporttype",fetchFromDatabase.getReportType());
		model.addAttribute("resolution",fetchFromDatabase.getResolutions());
		System.out.println(fetchFromDatabase.getResolutions());
		return "create";

	}
	@RequestMapping("/update2")
	public String update(Model model) throws ClassNotFoundException, SQLException{
		System.out.println("main chal gya :P...........update");
		System.out.println("main chal gya :P...........create");
		model.addAttribute("priority",fetchFromDatabase.getPriorities());
			model.addAttribute("severity",fetchFromDatabase.getSeverities());
			model.addAttribute("status",fetchFromDatabase.getStatuses());
			model.addAttribute("program",fetchFromDatabase.getPrograms());
			model.addAttribute("report_type",fetchFromDatabase.getReportType());
			model.addAttribute("resolution",fetchFromDatabase.getResolutions());
			System.out.println(fetchFromDatabase.getResolutions());
		return "search";

	}
	@RequestMapping("/database")
	public String delete(Model model){
		System.out.println("main chal gya :P...........database");
		return "database";

	}
	
	@RequestMapping(value="/savedata", method=RequestMethod.POST)
	public String saveData( @RequestParam(value="program",required=false) String program,
			   @RequestParam(value="releaseini",required=false) String program_release,
			   @RequestParam(value="conf",required=false) Boolean confidential,
			   @RequestParam(value="companyname",required=false) String companyname,
			   @RequestParam(value="suggested",required=false) String suggested_fix,
			   @RequestParam(value="reportedby",required=false) String reported_by,
			   @RequestParam(value="versionini",required=false) String version,
			   @RequestParam(value="summary",required=false) String problem_summary,
			   @RequestParam(value="report_type",required=false) String report_type,
			   @RequestParam(value="severity",required=false) String severity,
			   @RequestParam(value="reproduction",required=false) String reproduction,
			   @RequestParam(value="reproducable",required=false) Boolean reproducable,
			   @RequestParam(value="date",required=false) String date,
			   @RequestParam(value="status",required=false) String status,
			   @RequestParam(value="functional_area",required=false) String functional_area,
			   @RequestParam(value="comment",required=false) String comment,
			   @RequestParam(value="resolvedby",required=false) String resolvedby,
			   @RequestParam(value="date2",required=false) String resolutiondate,
			   @RequestParam(value="resolutiontestedby",required=false) String testedby,
			   @RequestParam(value="date3",required=false) String testdate,
			   @RequestParam(value="assigned_to",required=false) String assigned_to,
			   @RequestParam(value="priority",required=false) String priority,
			   @RequestParam(value="resolution",required=false) String resolution,
			   @RequestParam(value="resolutionversion",required=false) Integer resolution_version,
			   @RequestParam(value="image",required=false) MultipartFile image,

			Model model) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException, ParseException, IOException
	{
		System.out.println(",,,,,,,,,,,,,,"+program);
		
		
		if(program==null){
			program="";
			}

			 if(program_release==null||program_release==""){
			program_release="0";
			}

			 if(confidential==null){
			confidential=false;
			}

			 if(companyname==null){
			companyname="";
			}

			 if(suggested_fix==null){
			suggested_fix="";
			}

			 if(reported_by==null){
			reported_by="";
			}

			 if(version==null || version.equalsIgnoreCase(""))
			 {
			version="0";
			}

			 if(problem_summary==null){
			problem_summary="";
			}

			 if(report_type==null){
			report_type="";
			}

			 if(severity==null){
			severity="";
			}

			 if(reproduction==null){
			reproduction="";
			}

			 if(reproducable==null){
			reproducable=false;
			}



			 if(date==null){
			date="";
			}

			 if(status==null){
			status="";
			}

			 if(functional_area==null){
			functional_area="";
			}

			 if(comment==null){
			comment="";
			}

			 if(resolvedby==null){
			resolvedby="";
			}

			 if(resolutiondate==null){
			resolutiondate="";
			}

			 if(testedby==null){
			testedby="";
			}

			 if(testdate==null){
			testdate="";
			}

			 if(assigned_to==null){
			assigned_to="";
			}

			 if(priority==null){
			priority="0";
			}

			 if(resolution==null){
			resolution="";
			}

			 if(resolution_version==null){
			resolution_version=0;
			}
		
		
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String fn="";
if(image!=null){
	MultipartFile file =image;
	//	fileValidator.validate(uploadedFile, result);

		String fileName = file.getOriginalFilename();
if( fileName!=null && fileName!="" ) {
		fn = "/home/omung/workspace" + fileName;
		inputStream = file.getInputStream();

			File newFile = new File("/home/omung/workspace" + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}}
}
		
		System.out.println("uhgjgjh");
		fetchFromDatabase.storeData(companyname, confidential, problem_summary, program, program_release, reported_by, reproducable, reproduction, suggested_fix, version, report_type, severity, date, status, priority, resolution, resolution_version, functional_area, comment, resolvedby, testedby, resolutiondate, testdate, assigned_to,fn);
		//fetchFromDatabase.storeDataintoBugFix(status, priority, resolution, resolution_version, functional_area, comment, resolvedby, testedby, reqdate, testdate);
		return "home";
	}
	
	//................................................................................
	
	@RequestMapping(value="/savedata2", method=RequestMethod.POST)
	public @ResponseBody String saveData2( @RequestParam(value="program",required=false) String program,
			   @RequestParam(value="release",required=false) String program_release,
			   @RequestParam(value="conf",required=false) Boolean confidential,
			   @RequestParam(value="company",required=false) String companyname,
			   @RequestParam(value="suggested",required=false) String suggested_fix,
			   @RequestParam(value="reportedby",required=false) String reported_by,
			   @RequestParam(value="version",required=false) String version,
			   @RequestParam(value="summary",required=false) String problem_summary,
			   @RequestParam(value="report_type",required=false) String report_type,
			   @RequestParam(value="severity",required=false) String severity,
			   @RequestParam(value="reproduction",required=false) String reproduction,
			   @RequestParam(value="reproducable",required=false) Boolean reproducable,
			   @RequestParam(value="date",required=false) String date,
			   @RequestParam(value="status",required=false) String status,
			   @RequestParam(value="functional_area",required=false) String functional_area,
			   @RequestParam(value="comment",required=false) String comment,
			   @RequestParam(value="resolvedby",required=false) String resolvedby,
			   @RequestParam(value="date2",required=false) String resolutiondate,
			   @RequestParam(value="resolutiontestedby",required=false) String testedby,
			   @RequestParam(value="date3",required=false) String testdate,
			   @RequestParam(value="assigned_to",required=false) String assigned_to,
			   @RequestParam(value="priority",required=false) String priority,
			   @RequestParam(value="resolution",required=false) String resolution,
			   @RequestParam(value="resolutionversion",required=false) Integer resolution_version,
			   @RequestParam(value="image",required=false) MultipartFile image,

			Model model) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException, ParseException, IOException
	{
	if(program_release == ""||program_release=="Chose a program first" || program_release == null)
	{
		model.addAttribute("priority",fetchFromDatabase.getPriorities());
		model.addAttribute("severity",fetchFromDatabase.getSeverities());
		model.addAttribute("status",fetchFromDatabase.getStatuses());
		
		model.addAttribute("reporttype",fetchFromDatabase.getReportType());
		model.addAttribute("resolution",fetchFromDatabase.getResolutions());			
		ArrayList<Program> arr=fetchFromDatabase.getReleaseVersion(program);	
		model.addAttribute("release", arr);
		model.addAttribute("program",arr);
		ArrayList<FunctionalArea> arr2=fetchFromDatabase.getFunctionalArea(program);	
		model.addAttribute("func", arr2);
		return "create";
	}
		else{
		System.out.println(",,,,,,,,,,,,,,"+program);
		
		
		if(program==null){
			program="";
			}

if(program_release=="")
{
	program_release="0";
	}
			 if(confidential==null){
			confidential=false;
			}

			 if(companyname==null){
			companyname="";
			}

			 if(suggested_fix==null){
			suggested_fix="";
			}

			 if(reported_by==null){
			reported_by="";
			}

			 if(version==""){
			version="0";
			}

			 if(problem_summary==null){
			problem_summary="";
			}

			 if(report_type==null){
			report_type="";
			}

			 if(severity==null){
			severity="";
			}

			 if(reproduction==null){
			reproduction="";
			}

			 if(reproducable==null){
			reproducable=false;
			}



			 if(date==null){
			date="";
			}

			 if(status==null){
			status="";
			}

			 if(functional_area==null){
			functional_area="";
			}

			 if(comment==null){
			comment="";
			}

			 if(resolvedby==null){
			resolvedby="";
			}

			 if(resolutiondate==null){
			resolutiondate="";
			}

			 if(testedby==null){
			testedby="";
			}

			 if(testdate==null){
			testdate="";
			}

			 if(assigned_to==null){
			assigned_to="";
			}

			 if(priority==null){
			priority="0";
			}

			 if(resolution==null){
			resolution="";
			}

			 if(resolution_version==null){
			resolution_version=0;
			}
		
		
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String fn="";
		if(image!=null){
			MultipartFile file =image;
	//	fileValidator.validate(uploadedFile, result);

		String fileName = file.getOriginalFilename();
		if( fileName!=null && fileName!="" ) {
		fn = "/home/omung/workspace" + fileName;
		inputStream = file.getInputStream();

			File newFile = new File("/home/omung/workspace" + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}}
}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_r =sdf.parse(date);
		System.out.println("uhgjgjh");
		fetchFromDatabase.storeData(companyname, confidential, problem_summary, program, program_release, reported_by, reproducable, reproduction, suggested_fix, version, report_type, severity, date, status, priority, resolution, resolution_version, functional_area, comment, resolvedby, testedby, resolutiondate, testdate, assigned_to,fn);
		//fetchFromDatabase.storeDataintoBugFix(status, priority, resolution, resolution_version, functional_area, comment, resolvedby, testedby, reqdate, testdate);
		return "home";}
		
	}
	//..........................................................................................
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchData( @RequestParam(value="report_id",required=false) Integer report_id,
			@RequestParam(value="program",required=false) String program, 
			   @RequestParam(value="report_type",required=false) String report_type,
			   @RequestParam(value="functional_area",required=false) String functional_area, 
			   @RequestParam(value="reported_by",required=false) String reported_by,
			   @RequestParam(value="resolution",required=false) String resolution,
			   @RequestParam(value="resolved_by",required=false) String resolved_by,
			   @RequestParam(value="severity",required=false) String severity,
			   @RequestParam(value="assigned_to",required=false) String assigned_to,
			   @RequestParam(value="reportdate",required=false) String reportdate,
			   @RequestParam(value="status",required=false) String status,
			@RequestParam(value="priority",required=false) String priority,
			Model model) throws UnsupportedEncodingException, NoSuchAlgorithmException, ClassNotFoundException, SQLException, ParseException
	{
		if(report_id==null)
		{
			report_id=0;
		}
		//String functional_area="abc";
//		String comment="asdf";
//		String resolvedby="sdfghj";
//		String resolutiondate="asdf";
//		String testedby="abc";
//		String testdate="abc";
//		String reported_by="abc";
	//	String reproduction="abc";
//		String report_type="abc";
//		String suggested_fix="abc";
	//	int program_release=3456;
	//	int version=3456;
		
		System.out.println("uhgjgjhhgjkl;");
		ArrayList<BugReport> arr=fetchFromDatabase.searchData2(report_id,priority, resolution,assigned_to,resolved_by, reportdate,program, reported_by, report_type, severity,functional_area,status);
		model.addAttribute("searchresults",arr);
		model.addAttribute("priority",fetchFromDatabase.getPriorities());
		model.addAttribute("severity",fetchFromDatabase.getSeverities());
		model.addAttribute("status",fetchFromDatabase.getStatuses());
		model.addAttribute("program",fetchFromDatabase.getPrograms());
		model.addAttribute("report_type",fetchFromDatabase.getReportType());
		model.addAttribute("resolution",fetchFromDatabase.getResolutions());
		System.out.println(fetchFromDatabase.getResolutions());
		return "searchresult";
	}
	@RequestMapping(value="update")
	public String getBug(@RequestParam("id") int id,Model model) throws ClassNotFoundException, SQLException
	{
		ArrayList<BugReport> arr=fetchFromDatabase.getBugDetails(id);
		System.out.println(",,,,,,,,,,,,,,"+arr.get(0).getProblemsummary());
		model.addAttribute("bugdetails",arr.get(0));
		model.addAttribute("priority",fetchFromDatabase.getPriorities());
		model.addAttribute("severity",fetchFromDatabase.getSeverities());
		model.addAttribute("status",fetchFromDatabase.getStatuses());
		model.addAttribute("program",fetchFromDatabase.getPrograms());
		model.addAttribute("report_type",fetchFromDatabase.getReportType());
		model.addAttribute("resolution",fetchFromDatabase.getResolutions());
		System.out.println(fetchFromDatabase.getPrograms()+"\n"+arr.get(0).companyname);
		return "Update";
	}
//	@RequestMapping(value="update", method=RequestMethod.POST)
//	public String getBugforUpdate(@RequestParam("id") int id,Model model) throws ClassNotFoundException, SQLException
//	{
//		ArrayList<BugReport> arr=fetchFromDatabase.getBugDetails(id);
//		System.out.println(",,,,,,,,,,,,,,"+arr.get(0).getProblemsummary());
//		model.addAttribute("bugdetails",arr.get(0));
//		model.addAttribute("priority",fetchFromDatabase.getPriorities());
//		model.addAttribute("severity",fetchFromDatabase.getSeverities());
//		model.addAttribute("status",fetchFromDatabase.getStatuses());
//		model.addAttribute("program",fetchFromDatabase.getPrograms());
//		model.addAttribute("report_type",fetchFromDatabase.getReportType());
//		model.addAttribute("resolution",fetchFromDatabase.getResolutions());
//		System.out.println(fetchFromDatabase.getPrograms()+"\n"+arr.get(0));
//		return "Update";
//	}
	@RequestMapping(value="/updatebug", method=RequestMethod.POST)
	public String updatebug(@RequestParam(value="report_id",required=false) int report_id,
			   @RequestParam(value="program",required=false) String program,
			   @RequestParam(value="release",required=false) Integer program_release,
			   @RequestParam(value="conf",required=false) Boolean confidential,
			   @RequestParam(value="company",required=false) String companyname,
			   @RequestParam(value="suggested",required=false) String suggested_fix,
			   @RequestParam(value="reportedby",required=false) String reported_by,
			   @RequestParam(value="version",required=false) Integer version,
			   @RequestParam(value="summary",required=false) String problem_summary,
			   @RequestParam(value="report_type",required=false) String report_type,
			   @RequestParam(value="severity",required=false) String severity,
			   @RequestParam(value="reproduction",required=false) String reproduction,
			   @RequestParam(value="reproducable",required=false) Boolean reproducable,
			   @RequestParam(value="date",required=false) String date,
			   @RequestParam(value="status",required=false) String status,
			   @RequestParam(value="functional_area",required=false) String functional_area,
			   @RequestParam(value="comment",required=false) String comment,
			   @RequestParam(value="resolvedby",required=false) String resolvedby,
			   @RequestParam(value="date2",required=false) String resolutiondate,
			   @RequestParam(value="resolutiontestedby",required=false) String testedby,
			   @RequestParam(value="date3",required=false) String testdate,
			   @RequestParam(value="assigned_to",required=false) String assigned_to,
			   @RequestParam(value="priority",required=false) String priority,
			   @RequestParam(value="resolution",required=false) String resolution,
			   @RequestParam(value="resolutionversion",required=false) Integer resolution_version,
			   @RequestParam(value="file",required=false) MultipartFile image,
			Model model) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException, ParseException, IOException
	{
		System.out.println(",,,,,,,,,,,,,,"+program);
		
		
		if(program==null){
			program="";
			}

			 if(program_release==null){
			program_release=0;
			}

			 if(confidential==null){
			confidential=false;
			}

			 if(companyname==null){
			companyname="";
			}

			 if(suggested_fix==null){
			suggested_fix="";
			}

			 if(reported_by==null){
			reported_by="";
			}

			 if(version==null){
			version=0;
			}

			 if(problem_summary==null){
			problem_summary="";
			}

			 if(report_type==null){
			report_type="";
			}

			 if(severity==null){
			severity="";
			}

			 if(reproduction==null){
			reproduction="";
			}

			 if(reproducable==null){
			reproducable=false;
			}



			 if(date==null){
			date="";
			}

			 if(status==null){
			status="";
			}

			 if(functional_area==null){
			functional_area="";
			}

			 if(comment==null){
			comment="";
			}

			 if(resolvedby==null){
			resolvedby="";
			}

			 if(resolutiondate==null){
			resolutiondate="";
			}

			 if(testedby==null){
			testedby="";
			}

			 if(testdate==null){
			testdate="";
			}

			 if(assigned_to==null){
			assigned_to="";
			}

			 if(priority==null){
			priority="0";
			}

			 if(resolution==null){
			resolution="";
			}

			 if(resolution_version==null){
			resolution_version=0;
			}
		
		
		System.out.println(",,,,,,,,,,,,,,");
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String fn="";
		if(image!=null){
	MultipartFile file =image;
	//	fileValidator.validate(uploadedFile, result);

		String fileName = file.getOriginalFilename();
		 fn= "/home/omung/workspace" + fileName;
		inputStream = file.getInputStream();

			File newFile = new File("/home/omung/workspace" + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}}
//		String priority="1";
//		String resolution="asdf";
//		int resolution_version=2345;
//	String functional_area="abc";
//		String comment="asdf";
//		String resolvedby="sdfghj";
//		String resolutiondate="asdf";
//		String testedby="abc";
//		String testdate="abc";
//		String reported_by="abc";
	//	String reproduction="abc";
//		String report_type="abc";
//		String suggested_fix="abc";
	//	int program_release=3456;
	//	int version=3456;
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//	Date date_r =sdf.parse(date);
		System.out.println("uhgjgjh");
		fetchFromDatabase.updateData(companyname, confidential, problem_summary, program, program_release, reported_by, reproducable, reproduction, suggested_fix, version, report_type, severity, date, status, priority, resolution, resolution_version, functional_area, comment, resolvedby, testedby, resolutiondate, testdate, assigned_to,report_id,fn);
		//fetchFromDatabase.storeDataintoBugFix(status, priority, resolution, resolution_version, functional_area, comment, resolvedby, testedby, reqdate, testdate);
		return "home";
	}
	@RequestMapping("deletebug")
	public String deleteBug(@RequestParam("id") int id) throws ClassNotFoundException, SQLException
	{
		fetchFromDatabase.deleteBug(id);
		return "home";
		
	}
	@RequestMapping("/addprogram")
	public String addProgram(Model model,@RequestParam("program") String program,@RequestParam("release") String release,@RequestParam("version") String version) throws ClassNotFoundException, SQLException
	{
		
		String message= fetchFromDatabase.addPrgram(program,release,version);
		model.addAttribute("programs", fetchFromDatabase.getPrograms());
		model.addAttribute("message",message);
		System.out.println(message);
		return "addprogram";
	}
	@RequestMapping("/addfuncarea")
	public String addArea(@RequestParam("functionalarea") String area,@RequestParam("programid") int programid,Model model )throws ClassNotFoundException, SQLException
	{
		fetchFromDatabase.addArea(area,programid);
		model.addAttribute("message", "area has been added successfully");
		model.addAttribute("functionalarea", fetchFromDatabase.getArea(programid));
		model.addAttribute("program",programid);
		return "addFunctionalArea";
		
	}
	@RequestMapping("/addemployee")
	public String addUser(@RequestParam("user") String user,@RequestParam("password") String password,@RequestParam("userrole") String role,Model model) throws ClassNotFoundException, SQLException
	{
		model.addAttribute("users", fetchFromDatabase.getUserroles());
		String message=fetchFromDatabase.addUser(user,password,role);
		model.addAttribute("message",message);
		return "adduser";
	}
	@RequestMapping("/programpage")
	public String programPage(Model model) throws ClassNotFoundException, SQLException
	{
		model.addAttribute("programs", fetchFromDatabase.getPrograms());
	
	return "addprogram";
		
	}
	@RequestMapping("/functionalareapage")
	public String areaPage(@RequestParam("id") int id,Model model )throws ClassNotFoundException, SQLException
	{
		model.addAttribute("program",id);
		model.addAttribute("functionalarea", fetchFromDatabase.getArea(id));
		return "addFunctionalArea";
		
	}
	@RequestMapping("/areapage")
	public String funcareaPage(Model model )throws ClassNotFoundException, SQLException
	{
		model.addAttribute("programs", fetchFromDatabase.getPrograms());
		return "addarea";
		
	}
	@RequestMapping("/employeepage")
	public String employeePage(Model model) throws ClassNotFoundException, SQLException
	{
		model.addAttribute("users", fetchFromDatabase.getUserroles());
	return "adduser";
	}
	
	@RequestMapping(value="/getrelver" ,method=RequestMethod.GET)
	public @ResponseBody ArrayList<Program> getrelver(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("program") String program,Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println(program);
		model.addAttribute("release",fetchFromDatabase.getReleaseVersion(program));
		int programvalue=fetchFromDatabase.getProgrambyName(program);
		model.addAttribute("functionalarea", fetchFromDatabase.getArea(programvalue));
	return fetchFromDatabase.getReleaseVersion(program);
		
	}
	@RequestMapping(value="/getfuncarea" ,method=RequestMethod.GET)
	public @ResponseBody ArrayList<String> getfuncarea(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("program") String program,Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println(program);
		model.addAttribute("release",fetchFromDatabase.getReleaseVersion(program));
		int programvalue=fetchFromDatabase.getProgrambyName(program);
		model.addAttribute("functionalarea", fetchFromDatabase.getArea(programvalue));
	return fetchFromDatabase.getArea(programvalue);
		
	}
}
