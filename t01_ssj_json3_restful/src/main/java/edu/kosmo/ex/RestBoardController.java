package edu.kosmo.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.kosmo.ex.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController
@RequestMapping("/reset/*")
public class RestBoardController {
	@Autowired
	private BoardService boardService;
	
   // 1. list(처음 진입 화면이므로 화면이 깜박여도 상관없으므로 @Controller방식으로 접근 - veiw(화면)를 리턴
   @GetMapping("/board")
   public ModelAndView list(ModelAndView mav) {
      mav.setViewName("rest/rest_list");
      mav.addObject("list", boardService.getList());

      return mav;
   }
}
