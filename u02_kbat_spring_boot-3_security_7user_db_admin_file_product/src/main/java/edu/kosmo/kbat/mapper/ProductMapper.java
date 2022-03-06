package edu.kosmo.kbat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.kbat.vo.ProductVO;
import edu.kosmo.kbat.vo.UserVO;

@Mapper
public interface ProductMapper {

	List<ProductVO> getList();
	
	@Select("select category_id from category where category_name = #{category_name}")
	int readCategory_id(String category_name);
	
	void write(ProductVO product);
	
	@Insert("insert into video(video_id, video_name, product_id) values(video_seq.nextval, #{video_name}, product_seq.currval)")
	void writeVideo(String video_name);
	
	@Insert("insert into image(image_id, image_name, product_id) values(image_seq.nextval, #{image_name}, product_seq.currval)") 
	void writeImage(String image_name);
	
	@Delete("delete from video where PRODUCT_ID=#{product_id}")
	void deleteVideo(int product_id);
	@Delete("delete from image where PRODUCT_ID=#{product_id}")
	void deleteImage(int product_id);
	@Delete("delete from product where PRODUCT_ID=#{product_id}")
	void deleteProduct(int product_id);
}
