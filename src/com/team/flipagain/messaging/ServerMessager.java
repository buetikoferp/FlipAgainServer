package com.team.flipagain.messaging;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import com.team.flipagain.domain.Bundle;
import com.team.flipagain.domain.FieldOfStudy;
import com.team.flipagain.domain.Module;
import com.team.flipagain.domain.User;


/**
 * Created by Philipp on 01.04.2016.
 */
public final class ServerMessager implements ServerReply {
	@SuppressWarnings("unused")
	private Object messageObject = null;
	private ServerProducer serverProducer;

	/**
	 * Sendet das übergebene Objekt an den Client zurück
	 * 
	 * @param object
	 * @throws IOException
	 * @throws TimeoutException
	 */

	public void send(Serializable object) {
		try {
			serverProducer = new ServerProducer("flipagain");
			serverProducer.sendMessage(object);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Übergibt das gesendete Objekt.
	 * 
	 * @param messageObject
	 * @throws SQLException
	 */
	public void recieveObject(Object messageObject) {
		this.messageObject = messageObject;
	}
	
	public Object getDeliveredObject(){
		return messageObject;
	}

	@Override
	public void returnValidatedUser(User validatedUser) {
		try{
			Serializable message = (Serializable) validatedUser;
			serverProducer = new ServerProducer("flipagain");
			serverProducer.sendMessage(message);
		}catch(IOException e){
			e.printStackTrace();
		} catch(TimeoutException e){
			e.printStackTrace();
		}
	}

	@Override
	public void returnBundlebyName(Bundle bundle) {
		try{
			Serializable message = (Serializable) bundle;
			serverProducer = new ServerProducer("flipagain");
			serverProducer.sendMessage(message);
		}catch(IOException e){
			e.printStackTrace();
		} catch(TimeoutException e){
			e.printStackTrace();
		}
	}

	@Override
	public void returnFoS(FieldOfStudy fos) {
		try{
			Serializable message = (Serializable) fos;
			serverProducer = new ServerProducer("flipagain");
			serverProducer.sendMessage(message);
		}catch(IOException e){
			e.printStackTrace();
		} catch(TimeoutException e){
			e.printStackTrace();
		}
	}

	@Override
	public void returnModule(Module module) {
		try{
			Serializable message = (Serializable) module;
			serverProducer = new ServerProducer("flipagain");
			serverProducer.sendMessage(message);
		}catch(IOException e){
			e.printStackTrace();
		} catch(TimeoutException e){
			e.printStackTrace();
		}
	}
}
