package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.CartVO;
import edu.kosmo.ex.vo.ProductVO;

@Mapper
public interface CartMapper {
	List<CartVO> getList();
	List<CartVO> getListByUser(String p2user_member_id);//ssj 0203
	
	CartVO read(int cart_product_id);
	void insert(CartVO cart);
	void update(CartVO cart);
	void delete(int cart_product_id);
	void updateShape(CartVO cart);
	void insertReply(CartVO cart);
	void updateHit(int cart_product_id);
	
	int getTotalCount();
	List<CartVO> getListWithPaging(Criteria criteria);
}
