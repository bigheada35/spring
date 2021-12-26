package edu.kosmo.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.kosmo.ex.vo.EmpVO;

//repository = persistance = mapper = dao

@Repository
public class EmpDao {
	private DataSource dataSource = null;
	
	public EmpDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<EmpVO> selectList(){
		ArrayList<EmpVO> empList = new ArrayList<EmpVO>();
		
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			String query = "select * from emp";
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				
				Timestamp hiredate = rs.getTimestamp("hiredate");
				
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				EmpVO emp = new EmpVO(empno,ename,job,mgr,hiredate,sal, comm, deptno);
				
				empList.add(emp);
				
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				
				if(preparedStatement != null)
					preparedStatement.close();
				
				if(connection != null)
					connection.close();
								
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
		
		return empList;	
		
	}

}
