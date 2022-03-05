package edu.kosmo.kbat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.kbat.vo.ProductVO;
import edu.kosmo.kbat.vo.UserVO;

@Mapper
public interface ProductMapper {

	
	List<ProductVO> getList();

}
