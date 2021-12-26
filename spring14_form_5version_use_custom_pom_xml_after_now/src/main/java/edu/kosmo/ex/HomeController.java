package edu.kosmo.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.kosmo.ex.vo.StudentInformation;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
	@GetMapping("/index")
	public String goIndex() {
		return "index";
	}
	
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String student(HttpServletRequest request, Model model) {
		logger.info(" student()...POST");
		
		String id = request.getParameter("id");
		logger.info(" 아이디 " + id);
		
		model.addAttribute("studentId", id );
		
		return "student/studentId";
	}
	
	@GetMapping("/studentView")
	public String student(@ModelAttribute("studentInfo") StudentInformation studentInformation) {
		System.out.println(studentInformation);
		return "studentView";
	}
		
/*	public String student(StudentInformation studentInformation) {
		System.out.println(studentInformation);
		return "studentView";
	}*/
	
	
}
