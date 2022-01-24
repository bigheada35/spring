package edu.kosmo.ex.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.OrderMapper;
import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.OrderVO;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public List<OrderVO> getList() {
		log.info("getList()..");
		
		//sj0120
		List<OrderVO> list = orderMapper.getList();
		System.out.println("==========getList==========");
		System.out.println("list.toString()");
		
		for (OrderVO orderVO : list) {
			System.out.println(orderVO.getOrder_id() + "," +
							orderVO.getOrder_amount() + "," +
							orderVO.getOrder_address() + "," +  
							orderVO.getP2user_member_id() + "," +
							orderVO.getP2product_product_id() + "," +
							orderVO.getOrder_check_out() 
							);
		}
		
		return list;
		
		//sj0120 return orderMapper.getList();

		 
	}

	@Override
	public OrderVO get(int order_id) {
		log.info("get()..");
		return orderMapper.read(order_id);
	}

	@Override
	public void register(OrderVO board) {
		log.info("register()..");
		orderMapper.insert(board);
	}

	@Override
	public void modify(OrderVO board) {
		log.info("modify()..");
		orderMapper.update(board);
	}

	@Override
	public void remove(int order_id) {
		log.info("remove()..");
		orderMapper.delete(order_id);
		
	}

	@Override
	public void registerReply(OrderVO board) {
		log.info("registerReply()..");
		orderMapper.updateShape(board);
		orderMapper.insertReply(board);
	}

	@Override
	public void upHit(int order_id) {
		log.info("upHit()..");
		orderMapper.updateHit(order_id);
	}
	//page
	@Override
	public int getTotal() {
		log.info("getTotal()..");
		return orderMapper.getTotalCount();
	}
	@Override
	public List<OrderVO> getList(Criteria criteria){
		log.info("getList()..");
		return orderMapper.getListWithPaging(criteria);
	}
}
