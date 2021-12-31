package edu.kosmo.ex.board2;

import java.util.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.vo.BoardVO;

/*
1. interface는 필요가 없음 
2. sqlSession에서 제공하는 함수(selectList,selectOne)를 이용함
3. 쿼리구현을 위한 XML이 필요. 해당 XML의 namespace는  개발자가가 정함
* 
* */


@Service
public class Bservice2 {
	
	@Inject
	SqlSession sqlSession;
	
	public List<BoardVO> selectBoardList() throws Exception{
		return sqlSession.selectList("board.selectBoardList");


	}
}
