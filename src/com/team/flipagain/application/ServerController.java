package com.team.flipagain.application;

import java.sql.SQLException;
import java.util.ArrayList;
import com.team.flipagain.domain.Bundle;
import com.team.flipagain.domain.DBManager;
import com.team.flipagain.domain.DomainInterface;
import com.team.flipagain.domain.Module;
import com.team.flipagain.domain.User;
import com.team.flipagain.messaging.ServerMessager;

public class ServerController {
	private ServerMessager serverMessager = new ServerMessager();
	private DomainInterface doIn = new DBManager();

	/**
	 * Übergibt das gesendete Objekt.
	 * 
	 * @param messageObject
	 * @throws SQLException
	 */
	public void recieveObject(Object messageObject) {
		System.out.println("Hallo, bis da ane und ned wiiter");
		if (messageObject != null) {
			if (messageObject instanceof User) {
				System.out.println("UserObjekt");
				try {

					doIn.validateUser((User) messageObject);
					serverMessager.returnValidatedUser((User) messageObject);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (messageObject instanceof Bundle) {
				System.out.println("BundleObjekt");
				try {
					doIn.getBundleByName(((Bundle) messageObject).getName());
					serverMessager.returnBundlebyName((Bundle) messageObject);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (messageObject instanceof Module) {
				System.out.println("ModuleObjekt");
				try {
					doIn.getBundleList((Module) messageObject);
					serverMessager.returnBundleList((ArrayList<Bundle>) messageObject);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("FieldOfStudyObjekt");
			}
		} else {
			System.out.println("Das gesendete Objekt ist null bzw. leer");
		}

	}

}