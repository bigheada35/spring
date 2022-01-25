package edu.kosmo.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kosmo.ex.service.BoardService;
import edu.kosmo.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rboard")
public class RestBoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/list")
	public List<BoardVO> list() {
		
		log.info("list()...");
		
		
		return boardService.getList();
	}
	
}
