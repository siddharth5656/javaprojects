package com.hlv.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hlv.bean.Message;
import com.hlv.bean.UsersBean;
import com.hlv.entity.Users;
import com.hlv.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home(Model model) {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String Upload(Model model) {
		return "upload";
	}

	@RequestMapping(value = "/upload/2003", method = RequestMethod.POST)
	public String processExcel(@ModelAttribute("bean") @Valid UsersBean bean, Model model,
			@RequestParam("excelfile") MultipartFile excelfile) {
		try {
			List<Users> lstUser = new ArrayList<Users>();
			int i = 0;
			// Creates a workbook object from the uploaded excelfile
			HSSFWorkbook workbook = new HSSFWorkbook(excelfile.getInputStream());
			// Creates a worksheet object representing the first sheet
			HSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			while (i <= worksheet.getLastRowNum()) {
				// Creates an object for the UserInfo Model
				Users user = new Users();
				// Creates an object representing a single row in excel
				HSSFRow row = worksheet.getRow(i++);
				// Sets the Read data to the model class
				// user.setId((int) row.getCell(0).getNumericCellValue());
				user.setUsername(row.getCell(1).getStringCellValue());
				user.setInputDate(row.getCell(2).getDateCellValue());
				// persist data into database in here
				lstUser.add(user);
			}
			workbook.close();

			userService.addListUser(lstUser);

			bean.addMessage(Message.SUCCESS, "Upload Excel 2003 Successfull");
			model.addAttribute("bean", bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/upload";
	}

	@RequestMapping(value = "/upload/2007", method = RequestMethod.POST)
	public String processExcel2007(@ModelAttribute("bean") @Valid UsersBean bean, Model model,
			@RequestParam("excelfile2007") MultipartFile excelfile) {
		try {
			List<Users> lstUser = new ArrayList<Users>();
			int i = 0;
			// Creates a workbook object from the uploaded excelfile
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());
			// Creates a worksheet object representing the first sheet
			XSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			while (i <= worksheet.getLastRowNum()) {
				// Creates an object for the UserInfo Model
				Users user = new Users();
				// Creates an object representing a single row in excel
				XSSFRow row = worksheet.getRow(i++);
				// Sets the Read data to the model class
				// user.setId((int) row.getCell(0).getNumericCellValue());
				user.setUsername(row.getCell(1).getStringCellValue());
				user.setInputDate(row.getCell(2).getDateCellValue());
				// persist data into database in here
				lstUser.add(user);
			}
			workbook.close();

			userService.addListUser(lstUser);

			bean.addMessage(Message.SUCCESS, "Upload Excel 2007 Successfull");
			model.addAttribute("bean", bean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/upload";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsers(Model model) {
		model.addAttribute("listUsers", this.userService.listUsers());
		return "users";
	}

	@RequestMapping("/remove/{id}")
	public String removeUsers(@PathVariable("id") int id) {
		this.userService.removeUsers(id);
		return "redirect:/users";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUsers(@ModelAttribute Users users) {
		return "adduser";

	}

	@RequestMapping(value = "/save")
	public String saveUsers(@ModelAttribute @Valid Users users) {

		this.userService.saveUsers(users);
		return "redirect:/users";
	}

	@RequestMapping(value = "/edit/edit")
	public String editsaveUsers(@ModelAttribute Users users){

		this.userService.editUsers(users);

		return "redirect:/users";

	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editUsers(@PathVariable("id") int id, Model model) {

		model.addAttribute("users", this.userService.getUsers(id));
		return "editUser";
	}
	
	/*@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsers(Model model) {
		model.addAttribute("listUsers", this.userService.listUsers());
		return "users";
	}*/
	
	  @RequestMapping(value = "/listing", method = RequestMethod.GET)
	  public String pagination(@ModelAttribute int id) {
		  Users users = new Users();
	    users=(Users) this.userService.getpagination(id);
	    return "page";
	  }
	  
	  @RequestMapping(value = "/index")
		public String savepagination(@ModelAttribute Users users){

			this.userService.savepagination(users);

			return "redirect:/upload";

		}

	  @RequestMapping(value="/search/{id}")
	    public String Search(@PathVariable("id") int id, Model model) {
		  model.addAttribute("users", this.userService.getUsers(id));
	   // int id, HttpServletRequest request, HttpServletResponse response) {
	       // ModelAndView mav = new ModelAndView("search");

	     //  mav.addObject("searchTerm", pSearchTerm);
	      // mav.addObject("searchResult", sp.findTeamByName(pSearchTerm));      

	     return "search";
	   }
}
	
	
	

