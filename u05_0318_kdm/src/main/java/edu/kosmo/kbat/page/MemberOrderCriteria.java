package edu.kosmo.kbat.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MemberOrderCriteria {
	private int pageNum; // 페이지 번호
	private int amount; // 한 페이지당 몇 개의 데이터를 보여줄것인가?

	public MemberOrderCriteria() {
		this(1, 10); // 기본 값 1페이지를 10개로 지정한다
	}

	public MemberOrderCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}