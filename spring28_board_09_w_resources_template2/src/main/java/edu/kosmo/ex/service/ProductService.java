package edu.kosmo.ex.service;

import java.util.List;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.ProductVO;

public interface ProductService {
	List<ProductVO> getList();
	ProductVO get(int product_id);
	void register(ProductVO product);
	void modify(ProductVO product);	
	void remove(int product_id);
	void registerReply(ProductVO product);
	void upHit(int product_id);
	//page
	public int getTotal();
	public List<ProductVO> getList(Criteria criteria);
}
