package edu.kosmo.kbat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.kbat.page.Criteria;
import edu.kosmo.kbat.vo.BoardtypeVO;
import edu.kosmo.kbat.vo.MemberVO;
import edu.kosmo.kbat.vo.NBoardAndMemberVO;
import edu.kosmo.kbat.vo.NBoardVO;

@Mapper
public interface NBoardMapper {

	List<NBoardVO> getList();
	NBoardVO read(int board_id); //esh
	void write(NBoardVO board);
	//void write(NBoardVO board); esh
	void modify(NBoardVO board);
	void hit(int board_id);
	void delete(int board_id);

	//페이징
	int getTotalCount();
	List<NBoardVO> getListWithPaging(Criteria criteria);
	
	List<BoardtypeVO> getboardtypeList();

}
