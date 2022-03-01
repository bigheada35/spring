package edu.kbat.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import edu.kbat.ex.page.Criteria;
import edu.kbat.ex.page.PageVO;
import edu.kbat.ex.service.NBoardService;
import edu.kbat.ex.vo.NBoardVO;
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
		return "nboard/nlist";		
	}
	
	@PostMapping("/nmodify")
	public String modify(NBoardVO boardVO, Model model) {		
		log.info("modify()...");
		nboardService.modify(boardVO);
		return "redirect:nlist";		
	}	
	
	/*
	@PostMapping("/modify_view")
	public String modify_view(Model model) {		
		log.info("modify()...");
		return "board/modify_view";		
	}	*/
	
	@GetMapping("/ndelete")
	public String delete(NBoardVO boardVO, Model model) {		
		log.info("delete()...");	
		nboardService.delete(boardVO.getBoard_id());				
		return "redirect:nlist";		
	}
}
