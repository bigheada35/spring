package edu.kosmo.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kosmo.ex.service.BoardService;
import edu.kosmo.ex.service.KakaoService;
import edu.kosmo.ex.vo.JwtResponse;
import edu.kosmo.ex.vo.SocialLoginDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/kakao")
public class KakaoController {
	
	//@Autowired
	//private BoardService boardService;
	
    @Autowired
    private KakaoService kakaoService;
    
	
	@GetMapping("/login")
	public String login(Model model) {
		
		log.info("login()...");
		//model.addAttribute("list", boardService.getList());
		
		return "/kakao/login";
	}
	@GetMapping("/login2")
	public String login2(Model model) {
		
		log.info("login2()...");
		//model.addAttribute("list", boardService.getList());
		
		return "/kakao/login2";
	}

}
