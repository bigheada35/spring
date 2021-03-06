package edu.kosmo.kbat.service;

import java.util.List;

import edu.kosmo.kbat.vo.ProductVO;

public interface ProductService {
	
	List<ProductVO> getList();
	
	void write(ProductVO product);
	
	void delete(int product_id);
}
