package com.team.flipagain.server.messaging;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import com.sun.xml.internal.ws.resources.SenderMessages;
import com.team.flipagain.server.domain.Bundle;
import com.team.flipagain.server.domain.FieldOfStudy;
import com.team.flipagain.server.domain.Module;

/**
 * Created by Philipp on 01.04.2016.
 */
public final class ServerMessager implements ServerReply {
	private Object messageObject;
	private ServerProducer serverProducer;

	/**
	 * Sendet das übergebene Objekt an den Client zurück
	 * 
	 * @param object
	 * @throws IOException
	 * @throws TimeoutException
	 */

	public void send(Serializable object) throws IOException, TimeoutException {
		serverProducer.sendMessage(object);
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

	@Override
	public void returnValidatedUser() {

	}

	@Override
	public void returnBundlebyName(Bundle bundle) {
	

	}

	@Override
	public void returnFoS(FieldOfStudy fos) {
	

	}

	@Override
	public void returnModule(Module module) {
	

	}
}
