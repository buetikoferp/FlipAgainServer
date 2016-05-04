package messaging;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import application.LoginHandler;
import domain.Bundle;
import domain.DBManager;
import domain.DomainInterface;
import domain.FieldOfStudy;
import domain.Module;
import domain.User;

/**
 * Created by Philipp on 01.04.2016.
 */
public final class ServerMessager implements ServerReply{
	private Object messageObject;
	DBManager dm = new DBManager();
	ServerProducer serverProducer;
	ServerConsumer serverConsumer;
	
	public void send(Serializable o) throws IOException, TimeoutException{
		try{
			serverProducer = new ServerProducer("flipagain");
			serverProducer.sendMessage(o);
		}catch(IOException e){
			e.printStackTrace();
		}catch(TimeoutException e){
			e.printStackTrace();
		}
		finally{
			serverProducer.close();
		}
	}

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


	@Override
	public void returnValidatedUser(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void returnBundlebyName(Bundle bundle) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void returnFoS(FieldOfStudy fos) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void returnModule(Module module) {
		// TODO Auto-generated method stub
		
	}
}
