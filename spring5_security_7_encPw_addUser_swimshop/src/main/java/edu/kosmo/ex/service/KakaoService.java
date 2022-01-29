package edu.kosmo.ex.service;

import java.sql.Timestamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.security.KakaoOAuth2;
import edu.kosmo.ex.security.KakaoUserInfo;
import edu.kosmo.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Service
public class KakaoService {
	/*
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    */
    private final KakaoOAuth2 kakaoOAuth2;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";
    
    @Autowired
    //public KakaoService(UserRepository userRepository, PasswordEncoder passwordEncoder, KakaoOAuth2 kakaoOAuth2, AuthenticationManager authenticationManager) {
    public KakaoService(KakaoOAuth2 kakaoOAuth2) {    	
        //this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
        this.kakaoOAuth2 = kakaoOAuth2;
        //this.authenticationManager = authenticationManager;
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

        System.out.println("-----TODO :  DB 에 중복된 Kakao Id 가 있는지 확인----");
        
/*      
 		// DB 에 중복된 Kakao Id 가 있는지 확인  
        User kakaoUser = userRepository.findByKakaoId(kakaoId)
                .orElse(null);
*/
        
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

        System.out.println("-----TODO :  로그인 처리----");
        // 로그인 처리
/*        
        Authentication kakaoUsernamePassword = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(kakaoUsernamePassword);
        SecurityContextHolder.getContext().setAuthentication(authentication);
*/
        return username;
    }
}