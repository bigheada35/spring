package edu.kosmo.ex.service;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.kosmo.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {

	@Inject
	private BoardService boardService;

	@Test
	public void testBoardService() {
		assertNotNull(boardService);
		log.info(boardService);

	}

	@Ignore
	public void testGetList() {
		System.out.println("-------------------1111------------------");
		List<BoardVO> list = boardService.getList();
		System.out.println("-------------------1112------------------");

	}

	
	 @Test
	 public void testGet() {
		 System.out.println("-------------------2221------------------");
		 //|15 |술똥이형 |[소동님] 인.정.하.새.우 |is content-답3rd-B 
		 //BoardVO board = boardService.get(15);
		 BoardVO board = boardService.get(1107);
		 System.out.println("-------------------222 2------------------");
		 log.info(board); 
	 }
	

	@Test
	public void testRemove() {
		System.out.println("-------------------222 3------------------");
		boardService.remove(1107);
		System.out.println("-------------------222 4------------------");
		BoardVO board = boardService.get(1107);
		log.info(board);
		System.out.println("-------------------222 5------------------");
	}

}
