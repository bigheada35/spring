package edu.kosmo.ex.service;


import java.sql.Timestamp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.EmpVO;
import lombok.Data;



@Service
public class EmpServiceImpl implements EmpService {
	

	//@Autowired
	//private EmpDao empDao;
	
	@Autowired
	private EmpMapper empMapper;
	
	
	@Override
	public List<EmpVO> getList(){
		System.out.println("----getList-----!!");
		return empMapper.selectList();
		
	}

	@Override
	public EmpVO getEmp(String empno){
		System.out.println("----getEmp-----!!");
		return empMapper.selectEmp(Integer.valueOf(empno));
		
	}
} 
