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
@RestController
@RequestMapping("/kakao")
public class KakaoRestController {
	
    @Autowired
    private KakaoService kakaoService;
    
    @PostMapping(value = "/getAccesToken")
    public ResponseEntity<?> createAuthenticationTokenByKakao(@RequestBody SocialLoginDto socialLoginDto) throws Exception {
    	System.out.println("----- > kakaoLogin : ");
        String username = kakaoService.kakaoLogin(socialLoginDto.getToken());
        System.out.println("----- username : " + username);
        System.out.println("==== TODO: userDetailsService ====");
       /*
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token, userDetails.getUsername()));
        */
        System.out.println("==== TODO: temp ====");
        return ResponseEntity.ok(new JwtResponse("tok1234", "username_abcd"));
    }
	
}
