package edu.kosmo.ex.vo;

import static org.junit.Assert.*;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardVOTest2 {

	private BoardVO boardVO;
	
	public void BoardVOtest2() {
		boardVO = new BoardVO();
	}

	@Test
	public void testBoardVO() {
		boardVO = null;
		assertNotNull(boardVO);
	}
	
	@Test
	public void testSetBname() {
		System.out.println("======x=========1========");
		boardVO.setBname("Kim");
		
		assertEquals("Kim", boardVO.getBname());
		System.out.println("======y=========1========");
		//System.out.println("---" + boardVO.getBname());
	}


	@Test
	public void testSetBid() {
		System.out.println("======x=========2========");
		boardVO.setBid(20);
		assertEquals(20, boardVO.getBid());
		System.out.println("======y=========2========");
		
	}



}
