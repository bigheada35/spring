package edu.kosmo.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.ProductBoardMapper;
import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.ProductBoardVO;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class ProductBoardServiceImpl implements ProductBoardService {

	@Autowired
	private ProductBoardMapper productBoardMapper;
	
	@Override
	public List<ProductBoardVO> getList() {
		log.info("getList()..");
		return productBoardMapper.getList();
	}
	@Override
	public List<ProductBoardVO> getListByProductId(int product_id) {
		log.info("getList()..");
		return productBoardMapper.getList();
	}	

	@Override
	public ProductBoardVO get(int bid) {
		log.info("get()..");
		upHit(bid);
		return productBoardMapper.read(bid);
	}

	@Override
	public void register(ProductBoardVO board) {
		log.info("register()..");
		productBoardMapper.insert(board);
	}

	@Override
	public void modify(ProductBoardVO board) {
		log.info("modify()..");
		productBoardMapper.update(board);
	}

	@Override
	public void remove(int bid) {
		log.info("remove()..");
		productBoardMapper.delete(bid);
		
	}

	@Override
	public void registerReply(ProductBoardVO board) {
		log.info("registerReply()..");
		productBoardMapper.updateShape(board);
		productBoardMapper.insertReply(board);
	}

	@Override
	public void upHit(int bid) {
		log.info("upHit()..");
		productBoardMapper.updateHit(bid);
	}
	//page
	@Override
	public int getTotal() {
		log.info("getTotal()..");
		return productBoardMapper.getTotalCount();
	}
	@Override
	public List<ProductBoardVO> getList(Criteria criteria){
		log.info("getList()..");
		return productBoardMapper.getListWithPaging(criteria);
	}
}
