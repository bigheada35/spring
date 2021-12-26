package edu.kosmo.ex.grade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class GradeController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("grade/input")
	public String gradeInput(Grade grade) {
	
		return "grade/input";//grade/input.jsp
	}
	@RequestMapping("grade/result")
	public String gradeResult(Grade grade) {
		grade.makeGrade();
		return "grade/result";//grade/result.jsp
	}
}
