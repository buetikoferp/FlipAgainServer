package com.team.flipagain.server.messaging;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import com.team.flipagain.server.application.LoginHandler;
import com.team.flipagain.server.domain.Bundle;
import com.team.flipagain.server.domain.DBManager;
import com.team.flipagain.server.domain.DomainInterface;
import com.team.flipagain.server.domain.FieldOfStudy;
import com.team.flipagain.server.domain.Module;
import com.team.flipagain.server.domain.User;

/**
 * Created by Philipp on 01.04.2016.
 */
public final class ServerMessager implements ServerReply {
	private Object messageObject;
	DBManager dm = new DBManager();
	ServerProducer serverProducer;
	ServerConsumer serverConsumer;
	Thread consumerThread;

	/**
	 * Sendet das übergebene Objekt an den Client zurück
	 * 
	 * @param object
	 * @throws IOException
	 * @throws TimeoutException
	 */

	public void send(Serializable object) throws IOException, TimeoutException {
		try {
			serverProducer = new ServerProducer("flipagain");
			serverProducer.sendMessage(object);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} finally {
			serverProducer.close();
		}
	}

	/**
	 * Übergibt das gesendete Objekt.
	 * 
	 * @param messageObject
	 * @throws SQLException
	 */
	public void recievedObject(Object messageObject) {
		this.messageObject = messageObject;
		Object o = messageObject;
	}

	@Override
	public void returnValidatedUser() {
		consumerThread = new Thread(serverConsumer);
		consumerThread.start();
		try {
			consumerThread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

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
