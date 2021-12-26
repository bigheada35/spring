package edu.kosmo.ex.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.kosmo.ex.vo.EmpVO;
  
 
//repository = persistance  = mapper = dao  

@Mapper
public interface EmpMapper {
	
	ArrayList<EmpVO> selectList(); 
	EmpVO selectEmp(int empno);
	
	
}
