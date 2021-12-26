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
	public void register(BoardVO board){
		log.info("register()..");
		boardMapper.insert(board);
	}

	@Override
	public void modify(BoardVO board) {
		log.info("modify()..");
		boardMapper.update(board);
	}

	@Override
	public void remove(int bid){
	//public void delete(BoardVO board){

		log.info("remove()..");
		boardMapper.delete(bid);
		//boardMapper.delete(board);
	}

	// 이거 올려 주는 것이 중요, Transaction : 커밋과 롤백
	// updateShape는 성공했고, insertReply에서 에러가 났을때,
	// updateShape 부분을 롤백시켜 줘야 한다.
	//    update, insert, delete가 2개 이상이 한꺼번에 작업단위로 되는것은
	// 반드시 @Transactional 을 붙여야 한다.  - 나중에 넣자.~!! - 넣을려면 lib를 다운로드 받아야 한다.
	//@Transactional
	@Override
	public void registerReply(BoardVO board){
		log.info("registerReply()..");
		boardMapper.updateShape(board);
		boardMapper.insertReply(board);
	}
	
	@Override
	public void upHit(int bid){
		log.info("upHit()..");
		boardMapper.updateHit(bid);
	}
	
}
