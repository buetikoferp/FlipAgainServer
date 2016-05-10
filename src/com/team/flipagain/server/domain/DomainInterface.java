package com.team.flipagain.server.domain;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Philipp on 31.03.2016.
 */
public interface DomainInterface {
	/**
	 *
	 * @param user
	 * @param bundleName
	 * @param modul
	 * @param modulName
	 * @throws SQLException
	 */
	public User validateUser(User user) throws SQLException;

	public Bundle getBundleByName(String bundleName);

	public ArrayList<Bundle> getBundleList(Module modul) throws SQLException;

	public ArrayList<String> getBundleListByName(String moduleName) throws SQLException;
	
	
	
	
	
	

}
