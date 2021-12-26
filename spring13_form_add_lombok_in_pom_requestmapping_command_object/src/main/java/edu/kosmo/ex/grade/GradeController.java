package edu.kosmo.ex.grade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kosmo.ex.member.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class GradeController {
	
	
	@RequestMapping("grade/input")
	public String input(Grade grade) {
		return "grade/input"; //"grade/input.jsp" 
	}

	@RequestMapping("grade/result")
	public String result(Grade grade) {
		grade.makeGrade();
		return "grade/result"; //"grade/result.jsp" 
	}

	
	
	@RequestMapping("tower/input")
	public String Towerinput(Tower tower) {
		return "tower/input"; //"tower/input.jsp" 
	}

	@RequestMapping("tower/result")
	public String Towerresult(Tower tower) {
		//grade.makeGrade();
		return "tower/result"; //"tower/result.jsp" 
	}
	
	
}
