package edu.kosmo.ex.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.ex.mapper.BoardMapper;
import edu.kosmo.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Service
public class TxTestService {

	@Inject
	private BoardMapper mapper;
	
	public void txTest1() {
		log.info("transionTest1()테스트 ");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션1");
		boardVO.setBname("트랜잭션1");
		boardVO.setBtitle("트랜잭션1");

		mapper.insert(boardVO);

		boardVO.setBcontent("트랜잭션2");
		boardVO.setBname("트랜잭션2");
		boardVO.setBtitle("트랜잭션2");

		mapper.insert(boardVO);

	}
	public void txTest2() {
		log.info("transionTest2()테스트 ");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션21");
		boardVO.setBname("트랜잭션21");
		boardVO.setBtitle("트랜잭션21");

		mapper.insert(boardVO);

		boardVO.setBcontent("트랜잭션22");
		boardVO.setBname("트랜잭션22");
		boardVO.setBtitle("트랜잭션22");

		mapper.insert(boardVO);
		
		// 일부러 트랙젝션 테스트 에러 나오게, 넣음
		boardVO = null;
		mapper.insert(boardVO);
	}
	@Transactional
	public void txTest3() {
		log.info("transionTest3()테스트 ");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션31");
		boardVO.setBname("트랜잭션31");
		boardVO.setBtitle("트랜잭션31");

		mapper.insert(boardVO);

		boardVO.setBcontent("트랜잭션32");
		boardVO.setBname("트랜잭션32");
		boardVO.setBtitle("트랜잭션32");

		mapper.insert(boardVO);
		
		// 일부러 트랙젝션 테스트 에러 나오게, 넣음
		boardVO = null;
		mapper.insert(boardVO);
	}
	//uncheckedException(롤백함)
	@Transactional
	public void txTest4() {
		log.info("transionTest4()테스트 ");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션31");
		boardVO.setBname("트랜잭션41");
		boardVO.setBtitle("트랜잭션41");

		mapper.insert(boardVO);
		
		// 일부러 에러 나오게, 넣음
	    throw new RuntimeException("RuntimeException for rollback");

	}
	// checked 인 경우는 롤백을 안한다. throws 된 경우는, 롤백을 안한다.
	@Transactional
	public void txTest5() throws SQLException{
		log.info("transionTest5()테스트 ");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션5");
		boardVO.setBname("트랜잭션5");
		boardVO.setBtitle("트랜잭션5");

		mapper.insert(boardVO);
		
		// 일부러 에러 나오게, 넣음
	    throw new SQLException("RuntimeException for rollback");

	}	
	
	//@Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
	   // Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. @Transactional(rollbackFor = Exception.class) 
	   // 여러개의 예외를 지정할 수도 있습니다. @Transactional(rollbackFro = {RuntimeException.class, Exception.class})
	   @Transactional(rollbackFor = Exception.class) 
	   public void transionTest6() throws SQLException {
	      BoardVO boardVO = new BoardVO();
	      boardVO.setBcontent("트랜잭션6");
	      boardVO.setBname("트랜잭션6");
	      boardVO.setBtitle("트랜잭션6");

	      mapper.insert(boardVO);

	      throw new SQLException("SQLException for rollback");
	   }
	   
	   @Transactional(rollbackFor = SQLException.class) 
	   public void transionTest7() throws SQLException {
	      BoardVO boardVO = new BoardVO();
	      boardVO.setBcontent("트랜잭션7");
	      boardVO.setBname("트랜잭션7");
	      boardVO.setBtitle("트랜잭션7");

	      mapper.insert(boardVO);

	      throw new SQLException("SQLException for rollback");
	   }
	
	
}
