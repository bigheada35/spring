package edu.kosmo.kbat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.kosmo.kbat.kakao.KakaoAuth;
import edu.kosmo.kbat.kakao.KakaoProfile;
import edu.kosmo.kbat.service.social.KakaoServiceImpl;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SocialController2 {
	
	@Setter(onMethod_ = @Autowired)
	private KakaoServiceImpl kakaoService;

	@GetMapping("/social")
	public String home(Model model) {
		log.info("social..");
		model.addAttribute("kakaoUrl", kakaoService.getAuthorizationUrl());
		
		return "social/login";
	}
	
	@GetMapping("ex/auth/kakao/callback")   
	public String kakaoCallback(String code,Model model,HttpSession session) {
	    log.info("kakaoCallback ..");
	    //이제 부터 스프링 서버와  외부 카카오 서버와 POST 통신을 해야함.
	    System.out.println("집에가자=====" + code);
	    KakaoAuth kakaoAuth = kakaoService.getKakaoTokenInfo(code);
	    System.out.println("플젝하자=====" + kakaoAuth);
	    KakaoProfile profile= kakaoService.getKakaoProfile(kakaoAuth.getAccess_token());
	    model.addAttribute("user", profile);
	      
	    session.setAttribute("access_token", kakaoAuth.getAccess_token());
	      
	    //user.kakao_account.profile.nickname
	    return "social/social_home";
	 }
	
	
	@GetMapping(value="/kakao/logout")
	public String logout(HttpSession session) throws IOException {
		
		String access_token = (String)session.getAttribute("access_token");	
		kakaoService.kakaoLogout(access_token);
		log.info("logout()..");
		return "redirect:/";
	}
	
	/*
	@GetMapping("/kakao/logout")	
	public String kakaoCallbackLogout(String state,Model model) {
		log.info("kakaoCallbackLogout ..");
		System.out.println(state);		
		
		return "redirect:/";
	}
	*/
	
}
