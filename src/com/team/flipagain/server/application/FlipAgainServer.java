package com.team.flipagain.server.application;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.team.flipagain.server.messaging.ServerConsumer;

/**
 * Created by Philipp on 04.04.2016.
 */
public class FlipAgainServer {

	public static void main(String args[]) {
		ServerConsumer serverConsumer;
		runCommunication();

	}

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
