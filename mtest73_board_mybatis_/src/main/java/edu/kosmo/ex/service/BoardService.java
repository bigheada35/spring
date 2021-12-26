package edu.kosmo.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.kosmo.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;


public interface BoardService {
	List<BoardVO> getList();
	BoardVO get( int bid);
	void register(BoardVO board);
	void modify(BoardVO board);
	void delete(BoardVO board);
	void reply(BoardVO board);
}
