package messaging;

import java.util.ArrayList;

import application.LoginHandler;
import domain.Bundle;
import domain.DBManager;
import domain.DomainInterface;
import domain.User;

/**
 * Created by Philipp on 01.04.2016.
 */
public final class ServerMessager {
	private Object messageObject;
	DBManager dm = new DBManager();
	

	/**
	 * Übergibt das gesendete Objekt.
	 * 
	 * @param messageObject
	 */
	public void recievedObject(Object messageObject) {
		this.messageObject = messageObject;
		Object o = messageObject;
		
		if(o instanceof User){
			User u = (User) messageObject;
			System.out.println(u.getUsername() + " | " + u.getPassword());
			LoginHandler.getAuthorization(u);
		} else if(o instanceof Bundle){
			dm.getBundle((Bundle)o);
		}
		else if(o instanceof String){
			dm.getBundleList((String) o);
		}

	}
}
