package test.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.rabbitmq.client.test.performance.ScalabilityTest;
import com.team.flipagain.domain.Bundle;
import com.team.flipagain.domain.Card;
import com.team.flipagain.domain.DBManager;
import com.team.flipagain.domain.User;

public class DBManagerTest {
	
	DBManager dm = new DBManager();
	
	Connection conn;

	@Test
	public void validateUserTest(){
		User success = new User(1, "malygos@mana.com", "essence");
		User fail = new User(1000, "Neltharion", "Fire");
		assertEquals(success, dm.validateUser(success));
		System.out.println("User existiert in der DB");
		assertEquals(fail, dm.validateUser(fail));
		System.out.println("User existiert nicht in der DB");
		
	}
	
	@Test
	public void getBundleByNameTest(){
		Bundle success = new Bundle(1, "TestBundle", 1, 1);
		for(int i = 0; i < 10; i++){
			Card c = new Card(i, 1, "TestFrage" + i, "TestAntwort" + i, 3);
			success.getCardList().add(c);
		}
		Card testCard = new Card(3, 1, "TestFrage3", "TestAntwort3", 3);
		assertThat(success.getCardList(), hasItem(testCard));	
	}
	
	@Test
	public void createNewUserTest(){
		User success = new User(2, "Ysera", "Dream");
		success.setIsNewUser(true);
		assertSame(success, dm.validateUser(success));
	}
	
	@Test
	public void insertNewBundleTest(){
		Bundle success = new Bundle(1, "TestBundle", 1, 1);
		for(int i = 0; i < 10; i++){
			Card c = new Card(i, 1, "TestFrage" + i, "TestAntwort" + i, 3);
			success.getCardList().add(c);
		}
		
		dm.insertNewBundle(success);
		assertSame(success, dm.getBundleByName(success.getName()));
	}
	
	
	
	


}
