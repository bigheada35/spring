package edu.kosmo.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EmpVO {
	int empno;			//NOT NULL NUMBER(4)
	String ename;			//  VARCHAR2(10) 
	String job;			//  VARCHAR2(9)  
	int mgr;			//  NUMBER(4)    
	Timestamp hiredate;		//  DATE         
	int sal;			//  NUMBER(7,2)  
	int comm;			//  NUMBER(7,2)  
	int deptno;			//  NUMBER(2)    

}
