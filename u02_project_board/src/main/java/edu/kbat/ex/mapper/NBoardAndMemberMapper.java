package edu.kbat.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kbat.ex.page.Criteria;
import edu.kbat.ex.vo.BoardtypeVO;
import edu.kbat.ex.vo.MemberVO;
import edu.kbat.ex.vo.NBoardAndMemberVO;
import edu.kbat.ex.vo.NBoardVO;

@Mapper
public interface NBoardAndMemberMapper {

	//List<NBoardVO> getList();	
	List<NBoardAndMemberVO> getList();//ssj2
	NBoardVO read(int board_id);
	void write(NBoardVO board);
	void modify(NBoardVO board);
	void hit(int board_id);
	void delete(int board_id);

	//페이징
	int getTotalCount();
	List<NBoardVO> getListWithPaging(Criteria criteria);
	
	List<BoardtypeVO> getboardtypeList();

}
