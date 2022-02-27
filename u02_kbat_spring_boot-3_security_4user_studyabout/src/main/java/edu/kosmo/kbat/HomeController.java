package edu.kosmo.kbat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "<h1> Hello World :: 안녕하세요 </h1>";
	}
	@GetMapping("/hello")
	public String hello() {
		return "<h1> programmer </h1>";
	}
	//@GetMapping("/page2")
	//public String page2() {
	//	System.out.println("----page2");
	//	return "<h1> page 2 for ADMIN</h1>";
	//}
	//@GetMapping("/page1")
	//public String page1() {
	//	System.out.println("----page1");
	//	return "<h1> page 1 for USER </h1>";
	//}
}
