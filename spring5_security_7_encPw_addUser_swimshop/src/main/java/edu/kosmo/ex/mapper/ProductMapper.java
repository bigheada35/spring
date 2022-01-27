package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.ProductVO;

@Mapper
public interface ProductMapper {
	List<ProductVO> getList();
	ProductVO read(int product_id);
	void insert(ProductVO product);
	void update(ProductVO product);
	void delete(int product_id);
	void updateShape(ProductVO product);
	void insertReply(ProductVO product);
	void updateHit(int product_id);
	
	int getTotalCount();
	List<ProductVO> getListWithPaging(Criteria criteria);
}
