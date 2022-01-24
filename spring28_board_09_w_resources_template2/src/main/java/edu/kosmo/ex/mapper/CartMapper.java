package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.CartVO;
import edu.kosmo.ex.vo.ProductVO;

@Mapper
public interface CartMapper {
	List<CartVO> getList();
	CartVO read(int cart_product_id);
	void insert(CartVO order);
	void update(CartVO order);
	void delete(int cart_product_id);
	void updateShape(CartVO order);
	void insertReply(CartVO order);
	void updateHit(int cart_product_id);
	
	int getTotalCount();
	List<CartVO> getListWithPaging(Criteria criteria);
}
