package edu.kbat.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kbat.ex.mapper.NBoardAndMemberMapper;
import edu.kbat.ex.mapper.NBoardMapper;
import edu.kbat.ex.page.Criteria;
import edu.kbat.ex.vo.BoardtypeVO;
import edu.kbat.ex.vo.MemberVO;
import edu.kbat.ex.vo.NBoardAndMemberVO;
import edu.kbat.ex.vo.NBoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NBoardServiceImpl implements NBoardService{
	
	@Autowired
	private NBoardMapper boardMapper;
	
	@Autowired
	private NBoardAndMemberMapper boardAndMemberMapper;//ssj

//ssj2
//	@Override
//	public List<NBoardVO> getList() {
//		log.info("getList()..");
//		return boardMapper.getList();
//	}
	@Override
	public List<NBoardAndMemberVO> getList() {//ssj2
		log.info("getList()..");
		return boardAndMemberMapper.getList();
	}
	
	@Override
	public NBoardVO read(int board_id) {
		log.info("read()..");
		hit(board_id);
		return boardMapper.read(board_id);
	}
	
	@Override
	public void write(NBoardVO board) {
		log.info("write()..");
		boardMapper.write(board);
		log.info("write2()..");
	}

	@Override
	public void modify(NBoardVO board) {
		log.info("modify()...");	
		boardMapper.modify(board);		
	}

	@Override
	public void hit(int board_id) {
		log.info("hit()...");	
		boardMapper.hit(board_id);		
	}

	@Override
	public void delete(int board_id) {
		log.info("delete()...");	
		boardMapper.delete(board_id);		
	}
	
	@Override
	public int getTotal() {
		log.info("getTotal() ..");
		return boardMapper.getTotalCount();
	}

	@Override
	public List<NBoardVO> getList(Criteria criteria) {
		log.info("getList() ..");
		return boardMapper.getListWithPaging(criteria);
	}

	@Override
	public List<BoardtypeVO> getboardtypeList() {
		// TODO Auto-generated method stub
		
		//return boardMapper.getboardtypeList();
		return boardAndMemberMapper.getboardtypeList();//ssj
	}


}
