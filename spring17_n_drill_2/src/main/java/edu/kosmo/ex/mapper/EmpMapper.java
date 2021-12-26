package edu.kosmo.ex.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.ex.vo.EmpVO;
@Mapper
public interface EmpMapper {

	ArrayList<EmpVO> selectList();

	EmpVO selectEmp(int empno);

}
