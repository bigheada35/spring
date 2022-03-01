package edu.kbat.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kbat.ex.service.NBoardService;
import edu.kbat.ex.vo.NBoardAndMemberVO;
import edu.kbat.ex.vo.NBoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rboard")
public class RestBoardControllerXX {
	
	@Autowired
	private NBoardService boardService;
	
//ssj2	
//	@GetMapping("/list")
//	public List<NBoardVO> list() {
//		log.info("list()..");		
//		return boardService.getList();
//	}
	
	//ssj2
	@GetMapping("/list")
	public List<NBoardAndMemberVO> list() {
		log.info("list()..");		
		return boardService.getList();
	}

}
