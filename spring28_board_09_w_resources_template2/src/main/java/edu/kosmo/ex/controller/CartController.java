package edu.kosmo.ex.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.page.PageVO;
import edu.kosmo.ex.service.CartService;
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
	@GetMapping(value={"/cart.html", "/cart"})
	public String cart(ProductVO productVO, Model model) {
		log.info("list()..");
		log.info("======cart.html  or  cart======");
		
		int product_id = productVO.getProduct_id();
		System.out.println("======== product_id : " + product_id);
		// ------------------------------------------
		//			todo
		//		나의 id와 product id 가지고, db에 저장을 하기
		// ------------------------------------------
		model.addAttribute("cartProductList", cartService.getList());
		System.out.println("-----cart.html or cart-----");
		return "shop/cart"; //use without .jsp
	}

}
