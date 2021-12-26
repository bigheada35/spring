package edu.kosmo.ex.eao;

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

@Repository
public class EmpEao {
	private DataSource dataSource;

	public EmpEao() {

		try {
			Context context = new InitialContext();
			
			// 주의 Servers --> Tomcat v9.0  --> context.xml 안에 정의된
			/*
		 	<Resource 
				auth="Container" 
				driverClassName="oracle.jdbc.OracleDriver" 
				maxIdle="10" 
				maxTotal="20" 
				maxWaitMillis="-1" 
				name="jdbc/oracle"
				password="tiger" 
				type="javax.sql.DataSource" 
				url="jdbc:oracle:thin:@127.0.0.1:1521:xe" 
				username="scott"
			/>	
			*/
			// 중에서 name="jdbc/oracle"  부분의 이름이 들어가도록 
				
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
	}
	
	public ArrayList<EmpVO> selectList(){
		ArrayList<EmpVO> empList = new ArrayList<EmpVO>();
		
		Connection con = null;
		PreparedStatement preSta = null;
		ResultSet rs = null;
		
		try {
			String query = "select * from emp";
			con = dataSource.getConnection();
			preSta= con.prepareStatement(query);
			rs = preSta.executeQuery(query);
			
			while(rs.next()) {
				
				int empno = rs.getInt("empno");			
				String ename = rs.getString("ename");		
				String job= rs.getString("job");			
				int mgr= rs.getInt("mgr");			
				Timestamp hiredate = rs.getTimestamp("hiredate");	
				int sal= rs.getInt("sal");			
				int comm= rs.getInt("comm");			
				int deptno= rs.getInt("deptno");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)	rs.close();
				if(preSta !=null)	preSta.close();
				if(con != null)	con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return empList;
	}
	
	
	public EmpVO selectEmp(String empno2) {
		
		EmpVO emp = null;
		
		Connection con = null;
		PreparedStatement preSta = null;
		ResultSet rs = null;
				try {
					//String query = "select * from emp where empno = ?";
					String query = "select * from emp where empno = ?";
					con = dataSource.getConnection();
					preSta = con.prepareStatement(query);
					rs = preSta.executeQuery();
							
					while(rs.next()) {
						int empno = rs.getInt("empno");			
						String ename = rs.getString("ename");		
						String job= rs.getString("job");			
						int mgr = rs.getInt("mgr");			
						Timestamp hiredate = rs.getTimestamp("hiredate");	
						int sal = rs.getInt("sal");			
						int comm = rs.getInt("comm");			
						int deptno = rs.getInt("deptno");	
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				return emp;
				
		
	}
	
}
