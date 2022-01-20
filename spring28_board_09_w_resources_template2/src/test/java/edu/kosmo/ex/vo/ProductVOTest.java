package edu.kosmo.ex.vo;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class ProductVOTest {

	private ProductVO productVO;
	
	public void ProductVOTest() {
		System.out.println("---ProductVOTest---");
		productVO = new ProductVO();
	}
	
	
	@Test
	public void testGetProduct_Name() {
		//productVO.get
	}
}
