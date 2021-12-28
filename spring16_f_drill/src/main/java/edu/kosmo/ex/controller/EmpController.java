package edu.kosmo.ex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.kosmo.ex.service.EmpService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmpController {

	@Autowired
	private EmpService empService;

	@RequestMapping("/emp/list")
	public String list(Model model) {
		
		model.addAttribute("empList", empService.getList() );
		
		return "/emp/list";
	}
	
	
	@RequestMapping("/emp/emp_view")
	public String emp_view(HttpServletRequest request, Model model) {
		
		String empno = request.getParameter("empno");
		model.addAttribute("emp", empService.getEmp(empno) );
		
		return "/emp/emp_view";
	}
}
