package edu.kosmo.kbat.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kosmo.kbat.page.Criteria;
import edu.kosmo.kbat.page.PageVO;
import edu.kosmo.kbat.service.NBoardService;
import edu.kosmo.kbat.vo.NBoardAndMemberVO;
import edu.kosmo.kbat.vo.NBoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
public class BoardController {
	
	@Autowired
	private NBoardService nboardService;

//ssj3
//	@GetMapping("/nlist")
//	public String list( Model model) {
//		log.info("list()..");
//		
//		//ssj2
//		//model.addAttribute("list", nboardService.getboardtypeList());
//		model.addAttribute("list", nboardService.getList());//ssj2
//		
//		
//		return "nboard/list";
//	}
		
	@GetMapping("/nlist")//ssj3
	public String list2(Criteria cri, Model model) {
		log.info("list()2..");
		
		model.addAttribute("list", nboardService.getList(cri));
		int total = nboardService.getTotal();
		log.info("total" + total);
		model.addAttribute("pageMaker", new PageVO(cri, total));
		
		return "nboard/list";
	}
	
	@GetMapping("/ncontent_view")
	public String content_view(NBoardVO boardVO, Model model) {
		log.info("content_view()..");
		int board_id = boardVO.getBoard_id();
		model.addAttribute("content_view", nboardService.read(board_id));
		return "nboard/content_view";
	}
	
	@GetMapping("/nwrite_view")
	public String write_view(Model model) {		
		log.info("write_view()...");
		return "nboard/write_view";
		
	}
	
	@PostMapping("/nwrite")
	public String write(NBoardVO boardVO) {		
		log.info("write()...");	
		nboardService.write(boardVO);
		return "redirect:nlist";		
	}
	
	//@PostMapping("/nmodify")
	@PostMapping("/nmodify")
	public String modify(NBoardVO boardVO, Model model) {
		System.out.println("===================nmodify===");
		log.info("modify()...");

		System.out.println("board_id:" + boardVO.getBoard_id());
		System.out.println("board_title:" + boardVO.getBoard_title());
		System.out.println("board_content:" + boardVO.getBoard_content());

		
		nboardService.modify(boardVO);
		
		int board_id = boardVO.getBoard_id();
		System.out.println("===================nmodify===board_id:"+board_id);
		model.addAttribute("modify_view", nboardService.read(board_id));
		System.out.println("board_id:" + boardVO.getBoard_id());
		System.out.println("board_title:" + boardVO.getBoard_title());
		System.out.println("board_content:" + boardVO.getBoard_content());
		
		
		return "redirect:nlist";		
	}	
	
	
	//ssj0303@GetMapping("/nmodify_view")
	@PostMapping("/nmodify_view")//ssj0303
	//public String modify_view(Model model) {
	//public String modify_view(HttpServletRequest req, Model model) {//ssj
	public String modify_view(NBoardVO boardVO, Model model) {//ssj
	
		//req.getParameter("board_id")
		log.info("modify_view()...");
		
		
		System.out.println("-----여기 뭔가를 넣어야 하닞 않나? content_view같은.");
		//ssj
		int board_id = boardVO.getBoard_id();
		String board_title = boardVO.getBoard_title();
		String board_content = boardVO.getBoard_content();
		
		System.out.println("board_id : " + board_id);
		System.out.println("board_id:" + boardVO.getBoard_id());
		System.out.println("board_title:" + boardVO.getBoard_title());
		System.out.println("board_content:" + boardVO.getBoard_content());

		
		
		//model.addAttribute("modify_view", nboardService.modify(boardVO));
		nboardService.modify(boardVO);
		
		
		System.out.println("modify_view222222");
		
		model.addAttribute("modify_view", nboardService.read(board_id));
		
		
		System.out.println("modify_view33333");
		
		
		return "nboard/modify_view";		
	}	
	
	@GetMapping("/ndelete")
	public String delete(NBoardVO boardVO, Model model) {		
		log.info("delete()...");	
		nboardService.delete(boardVO.getBoard_id());				
		return "redirect:nlist";		
	}
}
