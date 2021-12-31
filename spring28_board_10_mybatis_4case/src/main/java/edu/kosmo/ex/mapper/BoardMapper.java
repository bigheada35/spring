package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getList();
	BoardVO read(int bid);
	void insert(BoardVO board);
	void update(BoardVO board);
	void delete(int bid);
	void updateShape(BoardVO board);
	void insertReply(BoardVO board);
	void updateHit(int bid);
	
	
	@Select("select * from mvc_board order by bGroup desc, bStep asc")		
	public List<BoardVO> selectList();
	
	
	
	int getTotalCount();
	List<BoardVO> getListWithPaging(Criteria criteria);
}
