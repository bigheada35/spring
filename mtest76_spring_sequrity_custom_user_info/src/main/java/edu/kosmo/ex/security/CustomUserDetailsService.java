package edu.kosmo.ex.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.CustomUser;
import edu.kosmo.ex.vo.EmpVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	@Setter(onMethod_ = @Autowired)
	private EmpMapper empMapper;
	
	@Override
	public UserDetails loadUserByUsername(String ename) throws UsernameNotFoundException{
		log.warn("Load User by Employee number: " + ename);
		
		EmpVO vo = empMapper.readUser(ename);
		
		log.warn("queried by EmpVO mapper: "  + vo);
		
		return vo == null ? null : new CustomUser(vo);
	}
}