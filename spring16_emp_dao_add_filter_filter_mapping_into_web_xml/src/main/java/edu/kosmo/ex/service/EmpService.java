package edu.kosmo.ex.service;


import java.sql.Timestamp;
import java.util.List;

import edu.kosmo.ex.vo.EmpVO;
import lombok.Data;


public interface EmpService {
	List<EmpVO> getList(); 
	List<EmpVO> getList2(String empno);
	EmpVO getEmp(String empno);
} 
