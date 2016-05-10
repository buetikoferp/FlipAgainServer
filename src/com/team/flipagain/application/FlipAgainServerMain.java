package com.team.flipagain.application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import com.team.flipagain.domain.Bundle;
import com.team.flipagain.domain.DBManager;
import com.team.flipagain.domain.DomainInterface;
import com.team.flipagain.domain.Module;
import com.team.flipagain.messaging.ServerConsumer;

/**
 * Created by Philipp on 04.04.2016.
 */
public class FlipAgainServerMain {

	public static void main(String args[]) {
		ServerController sc = new ServerController();
		try {
			sc.startServerController();
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
