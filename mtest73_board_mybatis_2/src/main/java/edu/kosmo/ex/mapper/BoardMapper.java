package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getList();
	BoardVO read(int bid);
	void insert(BoardVO board);
	void update(BoardVO board);
	
	//주의 : 복수개의 ?�라메터�?myBatis?�서 ?�길?�고 ?�면 �? @Param???�야??
	//void update(@Param("bid"), @Param("bname"), @Param("btitle");
	
	
	//객체 ?�기?�게 가??좋�?�? 그냥 ?�보??
	//void delete(BoardVO board);
	void delete(int bid);

	void updateShape(BoardVO board);
	void insertReply(BoardVO board);
	
	void updateHit(int bid);

	
	
}
