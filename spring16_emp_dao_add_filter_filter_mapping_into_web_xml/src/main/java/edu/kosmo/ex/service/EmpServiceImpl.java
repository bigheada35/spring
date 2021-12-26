package edu.kosmo.ex.service;


import java.sql.Timestamp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.dao.EmpDao;
import edu.kosmo.ex.vo.EmpVO;
import lombok.Data;


//------------이거
@Service
public class EmpServiceImpl implements EmpService {
	
	// new 대신에 Autowired를 사용함. ( IoC 컨터에너에 넣어줌 )
	//
	//@Inject
	@Autowired
	private EmpDao empDao;// 여기 고민해 보기, new 않쓰고 어떻게 연결이 되는지.
	
	@Override
	public List<EmpVO> getList(){
		System.out.println("----getList-----!!");
		return empDao.selectList();
		
	}
	@Override
	public List<EmpVO> getList2(String empno){
		System.out.println("----getList2-----!!");
		return empDao.selectList2(empno);
		
	}
	@Override
	public EmpVO getEmp(String empno){
		System.out.println("----getEmp-----!!");
		return empDao.selectEmp(empno);
		
	}
} 
