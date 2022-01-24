package edu.kosmo.ex.service;

import java.util.List;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.OrderVO;
import edu.kosmo.ex.vo.ProductVO;

public interface OrderService {
	List<OrderVO> getList();
	OrderVO get(int order_id);
	void register(OrderVO order);
	void modify(OrderVO order);	
	void remove(int order_id);
	void registerReply(OrderVO order);
	void upHit(int order_id);
	//page
	public int getTotal();
	public List<OrderVO> getList(Criteria criteria);
}
