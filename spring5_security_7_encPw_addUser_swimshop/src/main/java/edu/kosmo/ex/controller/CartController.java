package edu.kosmo.ex.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.page.PageVO;
import edu.kosmo.ex.service.CartService;
import edu.kosmo.ex.vo.CartProductVO;
import edu.kosmo.ex.vo.CartVO;
import edu.kosmo.ex.vo.ProductVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class CartController {
	@Inject
	private CartService cartService;

	//sj0122
	@GetMapping("/cart.html")
	public String cart(ProductVO productVO, Model model) {
		log.info("list()..");
		log.info("======cart.html ======");
		
	      //2.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할수있음 )
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String user_id = auth.getName();
	        System.out.println("2.유저 아이디:" + user_id   );
		
		//ssj 0203 model.addAttribute("cartProductList", cartService.getList());
		model.addAttribute("cartProductList", cartService.getListByUser(user_id));//ssj 0203
		return "shop/cart"; //use without .jsp
	}
	
	
	//cart_add
	@GetMapping("/cart_add")
	public String cart_add(ProductVO productVO, Model model) {
		log.info("list()..");
		log.info("======cart.html  or  cart======");
		 
	      //2.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할수있음 )
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String user_id = auth.getName();
	        System.out.println("2.유저 아이디:" + user_id   );
		
		int product_id = productVO.getProduct_id();
		System.out.println("======== product_id : " + product_id);
		// ------------------------------------------
		//			todo
		//		나의 id와 product id 가지고, db에 저장을 하기
		// ------------------------------------------
		//---1---
		CartVO cart = new CartVO();
		// todo -- temp use 1
		cart.setCart_product_quantity(1);
		cart.setP2product_product_id(product_id);
		// todo -- temp use 'user'
		cart.setP2user_member_id("user");
		
		cart.setP2user_member_id(user_id);//ssj 0203
		
		cartService.register(cart);
		
		// ---2--- 카트에서  유저이름으로 된 리스트를 뽑아 내기
		
		
		//ssj 0203 model.addAttribute("cartProductList", cartService.getList());
		model.addAttribute("cartProductList", cartService.getListByUser(user_id));//ssj 0203
		
		System.out.println("-----cart.html or cart-----");
		return "shop/cart"; //use without .jsp
		//return "redirect:shop/cart.html";
	}
	
	@GetMapping("/cart_delete")
	public String cart_delete(CartProductVO cartProductVO, Model model) {
		
	      //2.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할수있음 )
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String user_id = auth.getName();
	        System.out.println("2.유저 아이디:" + user_id   );
		
		System.out.println("=================" + cartProductVO.getCart_product_id());
		//System.out.println(cartProductVO.getCartVO());
		//System.out.println(cartProductVO.getProductVO());
		
		//CartVO cart = cartProductVO.getCartVO();
		
		int cart_product_id = cartProductVO.getCart_product_id();
		System.out.println("======1 delete cart_product_id : " + cart_product_id);
		cartService.remove(cart_product_id);
		System.out.println("======2 delete cart_product_id : " + cart_product_id);
		//ssj 0203 model.addAttribute("cartProductList", cartService.getList());
		model.addAttribute("cartProductList", cartService.getListByUser(user_id));//ssj 0203
		return "shop/cart";
	}

}
