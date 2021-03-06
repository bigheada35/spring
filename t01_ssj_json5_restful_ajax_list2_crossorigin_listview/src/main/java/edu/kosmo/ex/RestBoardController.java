package edu.kosmo.ex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.page.PageVO;
import edu.kosmo.ex.service.BoardService;
import edu.kosmo.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/rest/*")
public class RestBoardController {
	@Autowired
	private BoardService boardService;
	
   // 1. list(처음 진입 화면이므로 화면이 깜박여도 상관없으므로 @Controller방식으로 접근 - veiw(화면)를 리턴
   @GetMapping("/board")
   public ModelAndView list(ModelAndView mav) {
	   System.out.println("-------/board-------");
      mav.setViewName("rest/rest_list");
      mav.addObject("list", boardService.getList());

      return mav;
   }
   
   
   @GetMapping("/board/ajaxList")
   public ModelAndView ajaxlist(ModelAndView mav) {
	   System.out.println("-------/board/ajaxList-------");
  // public List<BoardVO> ajaxlist(ModelAndView mav) {
      mav.setViewName("rest/ajaxList");
      
      //List<BoardVO> list = boardService.getList();
      //return list;
      return mav;
   }
   //ajaxList2hjs.jsp
   @GetMapping("/board/ajaxList2")
   public ModelAndView ajaxlist2(ModelAndView mav) {
	   System.out.println("-------/board/ajaxList2-------");
  // public List<BoardVO> ajaxlist(ModelAndView mav) {
      mav.setViewName("rest/ajaxList2");
      
      //List<BoardVO> list = boardService.getList();
      //return list;
      return mav;
   }
   
   
   
   @GetMapping("/board/list")
   public List<BoardVO> boardList(ModelAndView mav) {
	   System.out.println("-------/board/list-------");
      mav.setViewName("rest/list");
      List<BoardVO> list = boardService.getList();
      return list;
   }
   //ssj - 0219
   @GetMapping("/board/list2list")
   public List<BoardVO> boardList2list(Criteria cri,ModelAndView mav) {
	   System.out.println("-------/board/list2Page-------");
	   System.out.println("-------pageNum-------" + cri.getPageNum());
	   System.out.println("-------amount-------" + cri.getAmount() );
      //mav.setViewName("rest/list");
      List<BoardVO> list = boardService.getList(cri);
      return list;
   }
   @GetMapping("/board/list2page")
   public PageVO boardList2page(Criteria cri,ModelAndView mav) {
	   System.out.println("-------/board/list2Page-------");
	   
      mav.setViewName("rest/list2page");
      int total = boardService.getTotal();
      PageVO pageMaker = new PageVO(cri, total);
      return pageMaker;
   }   
   
	//ssj 0204
   @GetMapping("/board/boardVo")
    public BoardVO boardVo(ModelAndView mav) {
	   System.out.println("-------/board/boardVo-------");
      mav.setViewName("rest/list");
       BoardVO boardVO = boardService.get(10);//ssj 0204 
       return boardVO;
       //ssj
       /*
 		1. board/boardVo로 접근시에
          
	        전달시 10초코하임w전 집주인이 버리고 간 댕댕이애완동물 등록제 한다더만 아직 안된건가. 유기하면 중죄로 다스리길.163885109100022111
	        를 리턴함
			        
			|----|------	|-----------------		|---------------------------------------			|----------------------|-----|-------|------|--------|
			|bid |bname 	|btitle           		|bcontent                               			|bdate                 |bhit |bgroup |bstep |bindent |
			|----|------	|-----------------		|---------------------------------------			|----------------------|-----|-------|------|--------|
			|10  |초코하임w 	|전 집주인이 버리고 간 댕댕이 	|애완동물 등록제 한다더만 아직 안된건가.유기하면 중죄로 다스리길. 	|2021-12-07 13:24:51.0 |22   |1      |1     |1       |
			|----|------	|-----------------		|---------------------------------------			|----------------------|-----|-------|------|--------|



		2. board/boardVo.json으로 접근시에
		
			// 20220204193854
			// http://localhost:8282/ex/rest/board/boardVo.json
			
			{
			  "bid": 10,
			  "bname": "초코하임w",
			  "btitle": "전 집주인이 버리고 간 댕댕이",
			  "bcontent": "애완동물 등록제 한다더만 아직 안된건가.\r\n유기하면 중죄로 다스리길.",
			  "bdate": 1638851091000,
			  "bhit": 24,
			  "bgroup": 1,
			  "bstep": 1,
			  "bindent": 1
			}
		를 리턴한다.



        */
   }
   
   
   @GetMapping("/board/{bid}")
   public ModelAndView rest_content_view(BoardVO boardVO, ModelAndView mav) {
	   
	   log.info("rest_content_view..");
	   System.out.println("-------/board/{bid}-------");
      mav.setViewName("rest/rest_content_view");
      
      mav.addObject("content_view", boardService.get(boardVO.getBid()) );
      
      log.info("boardservice :" +  boardService.get(boardVO.getBid()));

      return mav;
   }  
   

   
   @PutMapping("/board/{bid}")
   public ResponseEntity<String> rest_update(@RequestBody BoardVO boardVO, Model model) {
	   					//@RequestBody 는  json을 객체로 바궈서 받게 해 준다. 
      ResponseEntity<String> entity = null;
      log.info("rest_update.. boardVO" + boardVO);
      
      try {
         boardService.modify(boardVO);
         // 삭제가 성공하면 성공 상태메시지 저장
         entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
      } catch (Exception e) {
         e.printStackTrace();
         // 업데이트가 실패하면 실패 상태메시지 저장
         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
      // 업데이트처리 HTTP 상태 메시지 리턴
      return entity;
   } 
   
   @DeleteMapping("/board/{bid}")
   public ResponseEntity<String> rest_delete(BoardVO boardVO, Model model) {
	      ResponseEntity<String> entity = null;
	      log.info("rest_delete..");
	      try {
	         boardService.remove(boardVO.getBid());
	         // 삭제가 성공하면 성공 상태메시지 저장
	         entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         // 댓글 삭제가 실패하면 실패 상태메시지 저장
	         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	      }
	      // 삭제 처리 HTTP 상태 메시지 리턴
	      return entity;
   }

   
	@GetMapping("/board/example")
	 public List<BoardVO> example() {	
		 
		 log.info("/board/example");		 
		 List<BoardVO> list = boardService.getList();		
		 
		 return list;
	 }
	
	//ssj 0213
	@PostMapping("/rboard/")
	public String rest_write(@RequestBody BoardVO boardVO) { //@RequestBody 는  json을 객체로 바궈서 받게 해 준다.
		System.out.println("-------/rboard/-------rest_write");
		log.info("rest_write()..");
		log.info("boardVO()" + boardVO);
		
		boardService.register(boardVO);
		return "";
	}
   //ssj 0213
   @GetMapping("/rboard/{bid}")
   public BoardVO rest_content_view2(BoardVO boardVO) {
	   System.out.println("-------/rboard/{bid}-------");
	   log.info("rest_content_view2..");
	   return boardService.get(boardVO.getBid());
   }
   	
}
