package edu.kosmo.ex.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.dao.EmpDao;
import edu.kosmo.ex.vo.EmpVO;

@Service
public class EmpServiceImp implements EmpService {

	@Autowired
	private EmpDao empDao;
	
	@Override
	public ArrayList<EmpVO> getList() {
		
		System.out.println("---EmpServiceImp---getList--");
		return empDao.selectList();
	}

	@Override
	public EmpVO getEmp(String empno) {
		
		return empDao.selectEmp(empno);
	}

}
