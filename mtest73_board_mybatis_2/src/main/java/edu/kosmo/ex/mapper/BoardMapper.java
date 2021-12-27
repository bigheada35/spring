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
	
	//ì£¼ì˜ : ë³µìˆ˜ê°œì˜ ?Œë¼ë©”í„°ë¥?myBatis?ì„œ ?˜ê¸¸?¤ê³  ?˜ë©´ ê¼? @Param???¨ì•¼??
	//void update(@Param("bid"), @Param("bname"), @Param("btitle");
	
	
	//ê°ì²´ ?˜ê¸°?”ê²Œ ê°€??ì¢‹ì?ë§? ê·¸ëƒ¥ ?´ë³´??
	//void delete(BoardVO board);
	void delete(int bid);

	void updateShape(BoardVO board);
	void insertReply(BoardVO board);
	
	void updateHit(int bid);

	
	
}
