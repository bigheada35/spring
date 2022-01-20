package edu.kosmo.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.ProductMapper;
import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.ProductVO;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<ProductVO> getList() {
		log.info("getList()..");
		
		//sj0120
		List<ProductVO> list = productMapper.getList();
		System.out.println("==========getList==========");
		System.out.println("list.toString()");
		
		for (ProductVO productVO : list) {
			System.out.println(productVO.getProduct_id() + "," +
							productVO.getProduct_name() + "," +
							productVO.getProduct_amount() + "," +  
							productVO.getProduct_price() + "," +
							productVO.getProduct_category() 
							);
		}
		
		return list;
		
		//sj0120 return productMapper.getList();
		
		 
	}

	@Override
	public ProductVO get(int product_id) {
		log.info("get()..");
		return productMapper.read(product_id);
	}

	@Override
	public void register(ProductVO board) {
		log.info("register()..");
		productMapper.insert(board);
	}

	@Override
	public void modify(ProductVO board) {
		log.info("modify()..");
		productMapper.update(board);
	}

	@Override
	public void remove(int product_id) {
		log.info("remove()..");
		productMapper.delete(product_id);
		
	}

	@Override
	public void registerReply(ProductVO board) {
		log.info("registerReply()..");
		productMapper.updateShape(board);
		productMapper.insertReply(board);
	}

	@Override
	public void upHit(int product_id) {
		log.info("upHit()..");
		productMapper.updateHit(product_id);
	}
	//page
	@Override
	public int getTotal() {
		log.info("getTotal()..");
		return productMapper.getTotalCount();
	}
	@Override
	public List<ProductVO> getList(Criteria criteria){
		log.info("getList()..");
		return productMapper.getListWithPaging(criteria);
	}
}
