package edu.kosmo.ex.service;

import java.util.List;

import edu.kosmo.ex.vo.BoardVO;
import edu.kosmo.ex.page.Criteria;

public interface BoardService {
	List<BoardVO> getList();
	BoardVO get(int bid);
	void register(BoardVO board);
	void modify(BoardVO board);	
	void remove(int bid);
	void registerReply(BoardVO board);
	void upHit(int bid);

	
	//페이징 처리 함수 ( 위에랑 똑같은거 기 때문에 함수 오버로딩을 적용시켰다.)
	public int getTotal();
	public List<BoardVO> getList(Criteria criteria);
}
