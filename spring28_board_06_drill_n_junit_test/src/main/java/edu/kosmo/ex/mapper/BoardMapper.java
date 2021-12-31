package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getList();
	BoardVO read(int bid);
	void insert(BoardVO board);
	void update(BoardVO board);
	
	//주의 : 복수개의 파라메터를 myBatis에서 넘길려고 하면 꼭, @Param을 써야함.
	//void update(@Param("bid"), @Param("bname"), @Param("btitle");
	
	
	//객체 넘기는게 가장 좋지만, 그냥 해보자
	//void delete(BoardVO board);
	void delete(int bid);

	void updateShape(BoardVO board);
	void insertReply(BoardVO board);
	
	void updateHit(int bid);
	
	//페이징 처리 관련
	   int getTotalCount();
	   List<BoardVO> getListWithPaging(Criteria criteria);
}
