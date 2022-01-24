package edu.kosmo.ex.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.CartMapper;
import edu.kosmo.ex.mapper.ProductMapper;
import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.CartProductVO;
import edu.kosmo.ex.vo.CartVO;
import edu.kosmo.ex.vo.ProductVO;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper; 
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	//public List<CartVO> getList() {
	public List<CartProductVO> getList() {
		log.info("getList()..");
		
		//sj0120
		List<CartVO> list = cartMapper.getList();
		System.out.println("==========getList==========");
		System.out.println("list.toString()");
		
		
		ProductVO productVo;
		int product_id;
		List<CartProductVO> list2 = new ArrayList<CartProductVO>();
		
		for (CartVO cartVO : list) {
			System.out.println(cartVO.getCart_product_id() + "," +
							cartVO.getCart_product_quantity() + "," +
							cartVO.getP2user_member_id() + "," +
							cartVO.getP2product_product_id() + "," +
							cartVO.getCart_product_total_price() 
							);
			
			product_id = cartVO.getP2product_product_id();
			productVo = productMapper.read(product_id);
			
			CartProductVO cartProductVO = new CartProductVO();
			cartProductVO.setCartVO(cartVO);
			cartProductVO.setProductVO(productVo);
			list2.add(cartProductVO);
		}
		
		return list2;
		//sj0120 return cartMapper.getList();

		 
	}

	@Override
	public CartVO get(int cart_product_id) {
		log.info("get()..");
		return cartMapper.read(cart_product_id);
	}

	@Override
	public void register(CartVO cart) {
		log.info("register()..");
		cartMapper.insert(cart);
	}

	@Override
	public void modify(CartVO board) {
		log.info("modify()..");
		cartMapper.update(board);
	}

	@Override
	public void remove(int cart_product_id) {
		log.info("remove()..");
		cartMapper.delete(cart_product_id);
		
	}

	@Override
	public void registerReply(CartVO board) {
		log.info("registerReply()..");
		cartMapper.updateShape(board);
		cartMapper.insertReply(board);
	}

	@Override
	public void upHit(int cart_product_id) {
		log.info("upHit()..");
		cartMapper.updateHit(cart_product_id);
	}
	//page
	@Override
	public int getTotal() {
		log.info("getTotal()..");
		return cartMapper.getTotalCount();
	}
	@Override
	public List<CartVO> getList(Criteria criteria){
		log.info("getList()..");
		return cartMapper.getListWithPaging(criteria);
	}
}
