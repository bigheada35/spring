package edu.kosmo.kbat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;

import edu.kosmo.kbat.kakao.KakaoAuth;
import edu.kosmo.kbat.kakao.KakaoProfile;
import edu.kosmo.kbat.service.social.KakaoServiceImpl;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SocialController {
	
	@Autowired
	KakaoServiceImpl kakao;
	/*
	@RequestMapping(value="/login")
	public String login(String code, Model model, HttpSession session) {
	    System.out.println("code : " + code);
	   
	    return "index";
	}*/
	
	@RequestMapping(value="/login")
	public String login(@RequestParam("code") String code, HttpSession session) {
	    String access_Token = kakao.getAccessToken(code);
	    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    System.out.println("login Controller : " + userInfo);
	    
	    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
	    if (userInfo.get("email") != null) {
	        session.setAttribute("userId", userInfo.get("email"));
	        session.setAttribute("access_Token", access_Token);
	    }
	    return "index";
	}

	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
	    kakao.kakaoLogout((String)session.getAttribute("access_Token"));
	    session.removeAttribute("access_Token");
	    session.removeAttribute("userId");
	    return "index";
	}

	
	
	
	/*
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
	    kakao.kakaoLogout((String)session.getAttribute("access_Token"));
	    session.removeAttribute("access_Token");
	    session.removeAttribute("userId");
	    return "index";
	}
	*/
	/*
	@GetMapping(value="/logout")
	public String logout(HttpSession session) throws IOException {
		
		String access_token = (String)session.getAttribute("access_token");	
		kakao.kakaoLogout(access_token);
		
		return "index";
	}*/
	
	
	/*
	 @RequestMapping(value="/logout")
	    public String logout(HttpSession session) {
	        String access_Token = (String)session.getAttribute("access_Token");

	        if(access_Token != null && !"".equals(access_Token)){
	        	kakao.KakaoLogout(access_Token);
	            session.removeAttribute("access_Token");
	            session.removeAttribute("userId");
	        }else{
	            System.out.println("access_Token is null");
	            //return "redirect:/";
	        }
	        return "index";
	        //return "redirect:/";
	    }
	*/
	

}
