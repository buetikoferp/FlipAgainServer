package com.team.flipagain.server.application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import com.team.flipagain.server.domain.Bundle;
import com.team.flipagain.server.domain.DBManager;
import com.team.flipagain.server.domain.DomainInterface;
import com.team.flipagain.server.domain.Module;
import com.team.flipagain.server.messaging.ServerConsumer;

/**
 * Created by Philipp on 04.04.2016.
 */
public class FlipAgainServer {

	public static void main(String args[]) {
		ServerConsumer serverConsumer;
		// runCommunication();

	}
	/**
	 * Startet den ConsumerThread, Listener auf Channel/Queue
	 */
	public static void runCommunication() {
		ServerConsumer serverConsumer = null;

		try {
			serverConsumer = new ServerConsumer("flipagain");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

		Thread consumerThread = new Thread(serverConsumer);
		consumerThread.start();
	}


}
