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
public class BoardController {
	@Inject
	private BoardService boardService;

	@GetMapping("/list")
	public String list(Model model) {
		
		log.info("list()..");
		model.addAttribute("boardList", boardService.getList());
		return "board/list";
	}
	@GetMapping("/list2")
	public String list2(Criteria cri, Model model) {
		
		log.info("list()..");
		model.addAttribute("boardList", boardService.getList(cri));
		
		int total = boardService.getTotal();
		log.info("total" + total);
		model.addAttribute("pageMaker", new PageVO(cri, total));
		
		return "board/list2";		
	}
	@GetMapping("/list3")
	public String list3(Criteria cri, Model model) {
		
		log.info("list()..");
		model.addAttribute("boardList", boardService.getList(cri));
		
		return "board/tables";		
	}
//	@GetMapping("/list4")
//	public String list4(Criteria cri, Model model) {
//		
//		log.info("list()..");
//		model.addAttribute("boardList", boardService.getList(cri));
//
//		return "board/tables_org";
//	}
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		
		log.info("content_view()..");
		log.info("boardVO()" + boardVO);
		
		int bid = boardVO.getBid();
		model.addAttribute("content_view", boardService.get(bid));
		return "board/content_view";
	}

	@PostMapping("/modify")
	public String modify(BoardVO boardVO) {
		
		log.info("modify()..");
		log.info("boardVO()" + boardVO);
		
		boardService.modify(boardVO);
		
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete()..");

		boardService.remove(boardVO.getBid());
		//boardService.delete(boardVO);
		
		return "redirect:list";
	}
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view()..");
		log.info("boardVO()" + boardVO);
		
		int bid = boardVO.getBid();
		model.addAttribute("reply_view", boardService.get(bid));
		
		return "board/reply_view";
	}
	@PostMapping("/reply")
	public String reply(BoardVO boardVO) {
		log.info("reply()..");
		
		boardService.registerReply(boardVO);
		
		return "redirect:list";
	}
	@GetMapping("/write_view")
	public String write_view() {
		log.info("write_view()..");
		System.out.println("---write_view---");
		return "board/write_view";
	}
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write()..");
		
		boardService.register(boardVO);
		System.out.println("---write---");
		return "redirect:list2";
	}
}
