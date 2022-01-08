package edu.kosmo.ex.database;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.kosmo.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTest {

	@Autowired
	private DataSource datasource;
	
	@Test
	public void testBoardVO() {
		assertNotNull(datasource);

		
		try(Connection conn = datasource.getConnection()){
			System.out.println("===================3333");
			assertEquals(100, getLong(conn, "select 100 from dual"));
			//assertEquals(1440, getLong(conn, "select 24*60 from dual"));
			//assertEquals(1450, getLong(conn, "select 24*60 from dual"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
		

	
	private long getLong(Connection conn, String sql) {
		long result = 0;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = rs.getLong(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}



}
