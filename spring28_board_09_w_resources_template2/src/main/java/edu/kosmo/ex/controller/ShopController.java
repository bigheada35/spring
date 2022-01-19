package edu.kosmo.ex.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.page.PageVO;
import edu.kosmo.ex.service.BoardService;
import edu.kosmo.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class ShopController {
	@Inject
	private BoardService boardService;

	
	//sj0117
	@GetMapping("/404.html")
	public String err404() { 
		System.out.println("-----404.html-----");
		return "shop/404"; //use without .jsp
	}
	@GetMapping("/blog.html")
	public String blog() { 
		System.out.println("-----blog.html-----");
		return "shop/blog"; //use without .jsp
	}
	@GetMapping("/blog-single.html")
	public String blogSingle() { 
		System.out.println("-----blog-single.html-----");
		return "shop/blog-single"; //use without .jsp
	}	
	@GetMapping("/cart.html")
	public String cart() { 
		System.out.println("-----cart.html-----");
		return "shop/cart"; //use without .jsp
	}	
	@GetMapping("/checkout.html")
	public String checkout() { 
		System.out.println("-----checkout.html-----");
		return "shop/checkout"; //use without .jsp
	}	
	@GetMapping("/contact-us.html")
	public String contactUs() { 
		System.out.println("-----contact-us.html-----");
		return "shop/contact-us"; //use without .jsp
	}	
	@GetMapping("/index.html")
	public String index() { 
		System.out.println("-----index.html-----");
		return "shop/index"; //use without .jsp
	}	
	@GetMapping("/login.html")
	public String login() { 
		System.out.println("-----login.html-----");
		return "shop/login"; //use without .jsp
	}	
	@GetMapping("/product-details.html")
	public String productDetails() { 
		System.out.println("-----product-details.html-----");
		return "shop/product-details"; //use without .jsp
	}	
	@GetMapping("/sendemail.html")
	public String sendemail() { 
		System.out.println("-----sendemail.html-----");
		return "shop/sendemail"; //use without .jsp
	}	
	@GetMapping("/shop.html")
	public String shop() { 
		System.out.println("-----shop.html-----");
		return "shop/shop"; //use without .jsp
	}		
	
}
