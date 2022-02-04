package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.ProductBoardVO;

@Mapper
public interface ProductBoardMapper {
	List<ProductBoardVO> getList();
	List<ProductBoardVO> getListByProductId(int product_id);
	
	ProductBoardVO read(int bid);
	void insert(ProductBoardVO board);
	void update(ProductBoardVO board);
	void delete(int bid);
	void updateShape(ProductBoardVO board);
	void insertReply(ProductBoardVO board);
	void updateHit(int bid);
	
	int getTotalCount();
	List<ProductBoardVO> getListWithPaging(Criteria criteria);
}
