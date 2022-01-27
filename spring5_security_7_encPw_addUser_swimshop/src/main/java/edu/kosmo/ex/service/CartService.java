package edu.kosmo.ex.service;

import java.util.List;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.CartProductVO;
import edu.kosmo.ex.vo.CartVO;
import edu.kosmo.ex.vo.ProductVO;

public interface CartService {
	//List<CartVO> getList();
	List<CartProductVO> getList();
	CartVO get(int cart_product_id);
	void register(CartVO cart);
	void modify(CartVO cart);	
	void remove(int cart_product_id);
	void registerReply(CartVO cart);
	void upHit(int cart_product_id);
	//page
	public int getTotal();
	public List<CartVO> getList(Criteria criteria);
}
