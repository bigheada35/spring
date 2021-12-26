package edu.kosmo.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	
	@RequestMapping("/board/view")
	public String view() {
		System.out.println("-----view()..");
		return "board/view";
	}
	
	
	@RequestMapping("/board/tel")
	public String tel() {
		System.out.println("-----tel()..");
		return "board/tel";
	}
	
	@RequestMapping("/board/phone")
	public String phone() {
		System.out.println("-----phone()..");
		return "board/phone";
	}

	@RequestMapping("/list")
	public String list() {
		System.out.println("-----list()..");
		return "list";
	}
	
	@RequestMapping("/board/content")
	public String content(Model model) {
		System.out.println("-----content()..");
		model.addAttribute("id", 30);
		model.addAttribute("pw", 1234);
		return "board/content";
	}

	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 40);
		mv.setViewName("board/reply");
		
		System.out.println("-----reply()..");
		return mv;
	}
	
}
