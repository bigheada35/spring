package edu.kosmo.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.BoardMapper;
import edu.kosmo.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList()..");
		return boardMapper.getList();

	}

	@Override
	public BoardVO get(int bid) {
		log.info("get()..");
		upHit(bid);
		return boardMapper.read(bid);

	}

	@Override
	public void register(BoardVO board) {
		log.info("register()..");
		boardMapper.insert(board);


	}

	@Override
	public void modify(BoardVO board) {
		log.info("modify()..");
		boardMapper.update(board);


	}

	@Override
	public void remove(int bid) {
		log.info("remove()..");
		boardMapper.delete(bid);


	}

	@Override
	public void registerReply(BoardVO board) {
		log.info("registerReply()..");
		boardMapper.updateShape(board);
		boardMapper.insertReply(board);


	}

	@Override
	public void upHit(int bid) {
		log.info("upHit()..");
		boardMapper.updateHit(bid);


	}

}
