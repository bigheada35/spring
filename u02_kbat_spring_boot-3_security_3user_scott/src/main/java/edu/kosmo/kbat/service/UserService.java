package edu.kosmo.kbat.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.kbat.mapper.UserMapper;
import edu.kosmo.kbat.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
@NoArgsConstructor
@Service
public class UserService {

	//에러나서 --> 
	//@Autowired
	// private BCryptPasswordEncoder passEncoder;
	// --> 이렇게 시도해봄
	BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
	
	@Autowired
   private UserMapper userMapper;

   // caution:  must use @Transactional
   //@Transactional(rollbackFor = Exception.class)
   public void addUser(UserVO userVO) {
	   
	  System.out.println("----addUser");
	   
      String password = userVO.getPassword();
      String encode = passEncoder.encode(password);

      userVO.setPassword(encode);

      userMapper.insertUser(userVO);
      userMapper.insertAuthorities(userVO);
   }
   
   
}

