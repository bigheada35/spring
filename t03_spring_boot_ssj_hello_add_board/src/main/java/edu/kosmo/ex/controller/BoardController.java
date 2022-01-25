package edu.kosmo.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kosmo.ex.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/jboard")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/list")
	public String list(Model model) {
		
		log.info("list()...");
		model.addAttribute("list", boardService.getList());
		
		return "/board/list";
	}
	
}
