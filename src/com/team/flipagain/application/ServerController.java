package com.team.flipagain.application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import com.team.flipagain.domain.Bundle;
import com.team.flipagain.domain.DBManager;
import com.team.flipagain.domain.DomainInterface;
import com.team.flipagain.domain.FieldOfStudy;
import com.team.flipagain.domain.Module;
import com.team.flipagain.domain.User;
import com.team.flipagain.messaging.ServerConsumer;
import com.team.flipagain.messaging.ServerMessager;

public class ServerController {
	private Object messageObject;
	private ServerMessager serverMessager = new ServerMessager();
	private DomainInterface doIn = new DBManager();
	private Thread consumerThread;
	private ServerConsumer serverConsumer;

	public void startServerController() throws IOException, TimeoutException {
		serverConsumer = new ServerConsumer("flipagain");
		consumerThread = new Thread(serverConsumer);
		consumerThread.start();

	}

	public void validatedUser() throws SQLException {
		User validatedUser = (User) messageObject;
		validatedUser = doIn.validateUser(validatedUser);
		serverMessager.returnValidatedUser(validatedUser);
	}

	/**
	 * Übergibt das gesendete Objekt.
	 * 
	 * @param messageObject
	 * @throws SQLException
	 */
	public void recieveObject(Object messageObject) {

		if (messageObject != null) {
			if (messageObject instanceof User) {
				System.out.println("UserObjekt");
				try {
					validatedUser();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if (messageObject instanceof Bundle) {
				System.out.println("BundleObjekt");
			}
			if (messageObject instanceof Module) {
				System.out.println("ModuleObjekt");
			} else {
				System.out.println("FieldOfStudyObjekt");
			}
		} else {
			System.out.println("Das gesendete Objekt ist null bzw. leer");
		}

	}

}