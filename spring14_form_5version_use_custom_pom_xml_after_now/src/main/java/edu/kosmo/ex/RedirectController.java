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
public class RedirectController {
	
	private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@GetMapping("/studentConfirm")
	public String studentConfirm(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOK";
		}
		return "redirect:studentNG";
	}
	
	@GetMapping("/studentOK")
	public String studentOK() {
		return "student/studentOK";
	}
	@GetMapping("/studentNG")
	public String studentNG() {
		return "student/studentNG";
	}
	
	
}
