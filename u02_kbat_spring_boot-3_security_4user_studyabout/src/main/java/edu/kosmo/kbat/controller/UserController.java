package edu.kosmo.kbat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.kbat.service.UserService;
import edu.kosmo.kbat.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Controller
public class UserController {

   //private UserService userService =  new UserService();
   @Autowired	
   private UserService userService;

   @GetMapping("/user")
   public void home() {
      log.info("home");
      System.out.println("----- home ");
   }
   
	@GetMapping("/page1")
	public String page1() {
		System.out.println("----page1");
		return "<h1> page 1 for USER </h1>";
	}  
	
	@GetMapping("/page2")
	public String page2() {
		System.out.println("----page2");
		return "<h1> page 2 for ADMIN</h1>";
	}
 
   
   @GetMapping("/add/addForm")
   public void userForm() {
      log.info("Welcome userForm");
      System.out.println("----- userForm ");
   }

   @PostMapping("/add/addUser")
   public String addUser(UserVO uservo) {
      log.info("post resister");
      System.out.println("----- addUser ");
      userService.addUser(uservo);

      return "redirect:/";
   }
}
