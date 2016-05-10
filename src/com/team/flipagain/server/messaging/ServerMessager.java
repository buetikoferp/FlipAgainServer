package com.team.flipagain.server.messaging;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import com.team.flipagain.server.domain.Bundle;
import com.team.flipagain.server.domain.FieldOfStudy;
import com.team.flipagain.server.domain.Module;
import com.team.flipagain.server.domain.User;


/**
 * Created by Philipp on 01.04.2016.
 */
public final class ServerMessager implements ServerReply {
	@SuppressWarnings("unused")
	private Object messageObject;
	private ServerProducer serverProducer;

	/**
	 * Sendet das �bergebene Objekt an den Client zur�ck
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
	 * �bergibt das gesendete Objekt.
	 * 
	 * @param messageObject
	 * @throws SQLException
	 */
	public void recieveObject(Object messageObject) {
		this.messageObject = messageObject;
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
