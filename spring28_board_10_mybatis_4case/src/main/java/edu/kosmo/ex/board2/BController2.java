package edu.kosmo.ex.board2;

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


import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.page.PageVO;
import edu.kosmo.ex.service.BoardService;
import edu.kosmo.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/*
1.interface IBDao�? XML namespac??매핑 <mapper namespace="edu.bit.ex.board1.IBDao"> 
2.sqlSession.getMapper(IBDao.class)�??�용.
* 
* 
* */


@Log4j
@Controller
public class BController2 {
	@Inject
	private Bservice2 bservice2;

	@GetMapping("/listtwo")
	public String listtwo(Model model) throws Exception {
		
		log.info("listtwo() ..");
		model.addAttribute("boardList", bservice2.selectBoardList());
		
		return "board/list";
		
	}

}
