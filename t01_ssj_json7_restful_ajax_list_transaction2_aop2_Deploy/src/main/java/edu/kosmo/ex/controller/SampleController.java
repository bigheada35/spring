package edu.kosmo.ex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.kosmo.ex.vo.SampleVO;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */

//기존과는 다른 문법 사항이 적용됨.
@Log4j
@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		System.out.println("-----2-----");
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요!! 또 만났군요 ~~";
	}
	
	  @GetMapping(value = "/getSample")
	   public SampleVO getSample() { 
	      return new SampleVO(113, "로켓", "라쿤");
	   }
	  
	  @GetMapping(value = "/getSample.json")
	   public SampleVO getSamplejson() { 
	      return new SampleVO(113, "로켓", "라쿤");
	   }
	
	  
	  @GetMapping(value = "/check.json", params = { "height", "weight" })
	   public ResponseEntity<SampleVO> check(Double height, Double weight) {

	      SampleVO vo = new SampleVO(0, "" + height, "" + weight);
	      System.out.println("--h: " + height + "--w: " + weight);
	      ResponseEntity<SampleVO> result = null;

	      if (height <= 150) {
	         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
	      } else {
	         result = ResponseEntity.status(HttpStatus.OK).body(vo);
	      }

	      return result;
	   }
	  
}
