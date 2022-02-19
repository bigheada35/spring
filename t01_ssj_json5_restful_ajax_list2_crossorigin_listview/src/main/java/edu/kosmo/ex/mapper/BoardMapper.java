package edu.kosmo.ex.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.kosmo.ex.vo.BoardVO;
import edu.kosmo.ex.page.Criteria;

@Mapper
public interface BoardMapper {

   List<BoardVO> getList();
   BoardVO read(int bid);
   void insert(BoardVO board);
   void delete(int bid);
   void update( BoardVO board);
   void updateHit(int bid);
   
   
   //댓글관련
   void updateShape(BoardVO boardVO);
   void insertReply(BoardVO boardVO);
   
   
	//페이징 처리 관련
   int getTotalCount();
   List<BoardVO> getListWithPaging(Criteria criteria);

}