package edu.kosmo.kbat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.kbat.vo.UserVO;



@Mapper
public interface UserMapper {
   
   public UserVO getUser(String username);   
   
   //@Insert("insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
   @Insert("insert into member(member_number, member_id, password, member_name, member_email) values(member_seq.nextval, #{username}, #{password},'이름없음','이메일없음')")
   public int insertUser(UserVO userVO);

   //@Insert("insert into AUTHORITIES (username,AUTHORITY) values(#{username},'ROLE_USER')")
   @Insert("insert into authority(authority_id, authority_name, member_number) values(authority_seq.nextval, 'ROLE_USER', member_seq.currval)")
   public void insertAuthorities(UserVO UserVO);

   
}
