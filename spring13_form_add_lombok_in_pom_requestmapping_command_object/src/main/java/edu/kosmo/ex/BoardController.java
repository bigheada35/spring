package edu.kosmo.ex;

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
public class BoardController {
	
	
	
	
	@RequestMapping("board/confirm")
	public String confirm(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String ad = request.getParameter("ad");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("ad", ad);
		
		return "board/confirm";
	}
	
	//http://localhost:8282/ex/baord/check?id=1234&pw=234
	@RequestMapping("board/check")
	public String check(@RequestParam("id")String id,
						@RequestParam("pw")String pw, Model model) {
		

		model.addAttribute("identify", id);
		model.addAttribute("passord", pw);

		
		return "board/check";  // "board/check.jsp"
	}
	
	//http://localhost:8282/ex/member/join?name=abcd&id=1234&pw=12345
	@RequestMapping("member/join")
	public String join(Member member) {

		return "member/join"; //"member/join.jsp" 
	}	
	
	@RequestMapping("member/input")
	public String input(Member member) {

		return "member/input"; //"member/input.jsp" 
	}
	
	
}
