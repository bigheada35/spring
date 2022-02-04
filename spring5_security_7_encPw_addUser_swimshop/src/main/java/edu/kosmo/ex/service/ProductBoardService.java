package edu.kosmo.ex.service;

import java.util.List;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.ProductBoardVO;

public interface ProductBoardService {
	//ssj 0203
	List<ProductBoardVO> getList();
	List<ProductBoardVO> getListByProductId(int product_id);
	//todo
	ProductBoardVO get(int bid);
	void register(ProductBoardVO board);
	void modify(ProductBoardVO board);	
	void remove(int bid);
	void registerReply(ProductBoardVO board);
	void upHit(int bid);
	//page
	public int getTotal();
	public List<ProductBoardVO> getList(Criteria criteria);
}
