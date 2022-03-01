package edu.kbat.ex.service;

import java.util.List;

import edu.kbat.ex.page.Criteria;
import edu.kbat.ex.vo.BoardtypeVO;
import edu.kbat.ex.vo.MemberVO;
import edu.kbat.ex.vo.NBoardAndMemberVO;
import edu.kbat.ex.vo.NBoardVO;


public interface NBoardService {
	
	//공지사항 : n, 후기 : r, 문의 : q
	//ssj2
	//List<NBoardVO> getList();
	List<NBoardAndMemberVO> getList();//ssj2
	
	NBoardVO read(int board_id);
	void write(NBoardVO board);
	void modify(NBoardVO board);
	void hit(int board_id);
	void delete(int board_id);
	
	public int getTotal();
	public List<NBoardVO> getList(Criteria criteria);
	
	List<BoardtypeVO> getboardtypeList();
	
	

}
