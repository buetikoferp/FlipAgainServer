package com.team.flipagain.server.application;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.team.flipagain.server.domain.DBManager;
import com.team.flipagain.server.domain.DomainInterface;
import com.team.flipagain.server.messaging.ServerConsumer;
import com.team.flipagain.server.messaging.ServerMessager;

public class ServerController {

	private ServerMessager serverMessager = new ServerMessager();
	private DomainInterface doIn = new DBManager();
	private Thread consumerThread;
	private ServerConsumer serverConsumer;

	public void startServerController() throws IOException, TimeoutException {
		serverConsumer = new ServerConsumer("flipagain");
		consumerThread = new Thread(serverConsumer);
		consumerThread.start();
	}
}
