package edu.kosmo.ex.service;

import java.sql.Timestamp;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.UserMapper;
import edu.kosmo.ex.security.KakaoOAuth2;
import edu.kosmo.ex.security.KakaoUserInfo;
import edu.kosmo.ex.vo.BoardVO;
import edu.kosmo.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class KakaoService {
	
	//ssj 0131
	   @Inject
	   private BCryptPasswordEncoder passEncoder;
	   @Inject
	   private UserMapper userMapper;
	   
	   //@Inject
	   //@Autowired
	   //private AuthenticationManager authenticationManager;

    //private final PasswordEncoder passwordEncoder;
    //private final UserRepository userRepository;
    //private final AuthenticationManager authenticationManager;
    private final KakaoOAuth2 kakaoOAuth2;
    
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";
    
    
    //public KakaoService(UserRepository userRepository, PasswordEncoder passwordEncoder, KakaoOAuth2 kakaoOAuth2, AuthenticationManager authenticationManager) {
    //@Qualifier("AuthenticationManager")
    @Autowired(required=false)
    public KakaoService(KakaoOAuth2 kakaoOAuth2) {
    //public KakaoService(KakaoOAuth2 kakaoOAuth2, AuthenticationManager authenticationManager) {
    //public KakaoService(PasswordEncoder passwordEncoder,KakaoOAuth2 kakaoOAuth2, AuthenticationManager authenticationManager) {
    	System.out.println("-------------KakaoService()--------------");
        //this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
        this.kakaoOAuth2 = kakaoOAuth2;
        System.out.println("-------------kakaoOAuth2 : " + kakaoOAuth2);
        //this.authenticationManager = authenticationManager;
        //System.out.println("-------------authenticationManager : " + authenticationManager);
        
    }
	
	
    public String kakaoLogin(String token) {
    	
    	System.out.println("----kakaoLogin, token:" + token);
    	
        // 카카오 OAuth2 를 통해 카카오 사용자 정보 조회
        KakaoUserInfo userInfo = kakaoOAuth2.getUserInfo(token);
        Long kakaoId = userInfo.getId();
        String nickname = userInfo.getNickname();
        String email = userInfo.getEmail();

        // 우리 DB 에서 회원 Id 와 패스워드
        // 회원 Id = 카카오 nickname
        String username = nickname;
        // 패스워드 = 카카오 Id + ADMIN TOKEN
        String password = kakaoId + ADMIN_TOKEN;
        System.out.println("kakaoId: "+ kakaoId);
        System.out.println("username: "+ username);
        System.out.println("password: "+ password);
        System.out.println("-----TODO :  DB 에 중복된 Kakao Id 가 있는지 확인 ---- kakaoId: " + kakaoId);
        
/*      
 		// DB 에 중복된 Kakao Id 가 있는지 확인  
        User kakaoUser = userRepository.findByKakaoId(kakaoId)
                .orElse(null);
*/
      //ssj 0131	
        UserVO kakaoUser = userMapper.getUser(username);

        
        System.out.println("-----TODO :  카카오 정보로 회원가입----");
/*
  		// 카카오 정보로 회원가입       
        if (kakaoUser == null) {
            // 패스워드 인코딩
            String encodedPassword = passwordEncoder.encode(password);
            // ROLE = 사용자
            UserRole role = UserRole.USER;

            kakaoUser = new User(nickname, encodedPassword, email, role, kakaoId);
            userRepository.save(kakaoUser);
        }
*/        
        //ssj 0131
        if (kakaoUser == null) {
	        
	        String encode = passEncoder.encode(email);
	        
	        UserVO userVO = new UserVO();
	        
	        userVO.setUsername(username);
	        userVO.setPassword(encode);
	        userVO.setEnabled(1);
	
	        userMapper.insertUser(userVO);
	        userMapper.insertAuthorities(userVO);    
	        System.out.println("    ===insertUser===");
    	}else {
    		System.out.println("    ===find exist User===");
    	}
        
        System.out.println("-----TODO :  로그인 처리----");
        
        // 로그인 처리
        private AuthenticationManager authenticationManager = new AuthenticationManager();
        //ssj Authentication kakaoUsernamePassword = new UsernamePasswordAuthenticationToken(username, password);
        //Authentication kakaoUsernamePassword = new UsernamePasswordAuthenticationToken(username, passEncoder.encode(email));
        //Authentication authentication = authenticationManager.authenticate(kakaoUsernamePassword);
        //SecurityContextHolder.getContext().setAuthentication(authentication);

        return username;
    }
}