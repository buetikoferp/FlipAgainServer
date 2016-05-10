package test.domain;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.team.flipagain.server.domain.DBManager;

public class DBManagerTest {
	
	DBManager dm = new DBManager();
	Connection conn;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void openConnectionTest() throws SQLException{
		conn = DriverManager.getConnection("");
	}
	
	@Test
	public void validateUser(){
		
	}
	
	@Test
	public void validateUserFails(){
		
	}
	
	@Test
	public void getBundleByName(){
		
	}
	
	@Test 
	public void getBundleList(){
		
	}

}
