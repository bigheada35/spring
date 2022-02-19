package edu.kosmo.ex.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@ToString
@Setter
@Getter
public class Criteria {
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1,10);//한페이지당 10로 지정(디폴트로)
		log.info("===================Criteria()...");
	}
	public Criteria( int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
