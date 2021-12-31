package edu.kosmo.ex.service;

import java.util.ArrayList;
import java.util.List;

import edu.kosmo.ex.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> getList();
	BoardVO get(int bid);
	void register(BoardVO baord);
	void modify(BoardVO board);
	void delete(BoardVO board);
	void reply(BoardVO board);
}
