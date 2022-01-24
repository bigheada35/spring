package edu.kosmo.ex.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
	
}
