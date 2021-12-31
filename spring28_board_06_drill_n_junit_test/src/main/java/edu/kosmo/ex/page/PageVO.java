package edu.kosmo.ex.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {
	//페이징에 사용할 변수 갯수, 총 7 개, <--- 외워지지?

	private int startPage;// 화면에 보여지는 페이지 시작 번호
	private int endPage;// 화면에 보여지는 끝번호

	private boolean pre, next;

	private int total;// 전체 게시판 글수
	private Criteria cri;

	public PageVO(Criteria cri, int total) {
				this.cri = cri;
				this.total = total;

		
		
				// 먼저 engPage부터 계산
				this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10; // ceil(0.3) : 1
			
				this.startPage=this.endPage-9;
			
				// 게시글 이 80 개 라면, page는 1,2,3,4,5,6,7,8 까지만 보이도록
				int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
			
				if(realEnd<=this.endPage)
				{
					this.endPage = realEnd;
				}

				this.pre=this.startPage>1; // <--- ????
				this.next=this.endPage<realEnd;
	}

	public String makeQuery(int page) {
				UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance()
		            .queryParam("pageNum", page) // pageNum =                                              // 3
		            .queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
		            .build(); // ?pageNum=3&amount=10
			
		      return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 리턴
	}

}
