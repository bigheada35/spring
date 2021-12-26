package edu.kosmo.ex.constructor;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.kosmo.ex.service.BoardService;
import edu.kosmo.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
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
	//-------------1-> 2-------------------
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view()..");
		log.info("boardVO()" + boardVO);
		
		int bid = boardVO.getBid();
		model.addAttribute("content_view", boardService.get(bid));
		return "board/content_view";
	}
	//-------------2-> 수정-------------------
	@PostMapping("/modify")
	public String modify(BoardVO boardVO) {
		
		log.info("modify()..");
		log.info("boardVO()" + boardVO);
		
		boardService.modify(boardVO);
		
		return "redirect:list";
	}
	//-------------2-> 삭제-------------------
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete()..");
		
		boardService.delete(boardVO);
		return "redirect:list";
	}
	//-------------2-> 4 -------------------
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view()..");
		log.info("boardVO()" + boardVO);
		
		int bid = boardVO.getBid();
		model.addAttribute("reply_view", boardService.get(bid));
		
		return "board/reply_view";
	}
	//-------------4-> 답변 -------------------
	//http://localhost:8282/ex/reply_view?bid=45
	@PostMapping("/reply")
	public String reply(BoardVO boardVO) {
		log.info("reply()..");
		
		boardService.reply(boardVO);
		
		return "redirect:list";
	}

	//-------------1-> 3-------------------
	@GetMapping("/write_view")
	public String write_view() {
		log.info("write_view()..");
		return "board/write_view";
	}
	//-------------3-> 수정 -------------------
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write()..");
		
		boardService.register(boardVO);
		
		return "redirect:list";
	}
}
