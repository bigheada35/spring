package edu.kosmo.ex.service;

import java.util.ArrayList;

import edu.kosmo.ex.vo.EmpVO;

public interface EmpService {

	ArrayList<EmpVO> getList();
	EmpVO getEmp(String empno);
	
}
