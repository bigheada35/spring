package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.OrderVO;
import edu.kosmo.ex.vo.ProductVO;

@Mapper
public interface OrderMapper {
	List<OrderVO> getList();
	OrderVO read(int order_id);
	void insert(OrderVO order);
	void update(OrderVO order);
	void delete(int order_id);
	void updateShape(OrderVO order);
	void insertReply(OrderVO order);
	void updateHit(int order_id);
	
	int getTotalCount();
	List<OrderVO> getListWithPaging(Criteria criteria);
}
