package edu.kosmo.ex.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpMapper empMapper;
	
	@Override
	public ArrayList<EmpVO> getList() {
		
		return empMapper.selectList();
	}

	@Override
	public EmpVO getEmp(String empno) {
		// TODO Auto-generated method stub
		return empMapper.selectEmp(Integer.valueOf(empno));
	}

}
