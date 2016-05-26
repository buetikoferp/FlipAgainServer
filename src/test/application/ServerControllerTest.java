package test.application;

import static org.junit.Assert.*;

import org.junit.Test;

import com.team.flipagain.application.ServerController;
import com.team.flipagain.domain.Bundle;
import com.team.flipagain.domain.FieldOfStudy;
import com.team.flipagain.domain.Module;
import com.team.flipagain.domain.User;

public class ServerControllerTest {
	
	ServerController sc = new ServerController();
	User user = new User(1, "Malygos", "password");
	Bundle bundle = new Bundle(1, "TestBundle", 1, 2);
	Module module = new Module(1, "TestModule");
	FieldOfStudy fos = new FieldOfStudy(32, "HearthStone");
	
	@Test
	public void receivedObjectTest(){
		Object obj = (Object) user;
				
	}

}
