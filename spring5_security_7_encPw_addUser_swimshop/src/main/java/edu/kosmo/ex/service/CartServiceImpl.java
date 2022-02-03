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

	//ssj0203
	@Override
	public List<CartProductVO> getListByUser(String p2user_member_id) {
		log.info("getList(user_id)..");
		
		List<CartVO> list = cartMapper.getListByUser(p2user_member_id);//ssj0203
		System.out.println("==========getList(user_id)==========");
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
		ProductVO productVo;
		//ssj 0203
		//동일 제품이 들어있으면 갯수를 증가시킨다.
		List<CartVO> list = cartMapper.getList();
		boolean find_same = false;
		for (CartVO cartVO : list) {
			if(cart.getP2product_product_id() == cartVO.getP2product_product_id()) {
				find_same = true;
				System.out.println("----qty:" +  cartVO.getCart_product_quantity());
				cartVO.setCart_product_quantity(cartVO.getCart_product_quantity() + 1);
				//갯수*단가 의 1개제품총금액에 적용
				productVo = productMapper.read(cartVO.getP2product_product_id());
				cartVO.setCart_product_total_price(cartVO.getCart_product_quantity()*productVo.getProduct_price());
				//DB에서수정하기
				cartMapper.update(cartVO);
			}
		}
		
		log.info("register()..");
		if(find_same == false) {//ssj 0203
			//1개의 단가를 1개제품총금액에 적용 
			productVo = productMapper.read(cart.getP2product_product_id());
			cart.setCart_product_total_price(productVo.getProduct_price());
			cartMapper.insert(cart);
		}
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
