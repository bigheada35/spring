package edu.kosmo.ex.service;

import java.util.List;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();
	BoardVO get(int bid);
	void register(BoardVO board);
	
	void modify(BoardVO board);
	
	void remove(int bid);
	//void delete(BoardVO board);
	
	void registerReply(BoardVO board);
	
	void upHit(int bid);

	//page
	public int getTotal();
	public List<BoardVO> getList(Criteria criteria);
}
