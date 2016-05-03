package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Philipp on 31.03.2016.
 */
public class DBManager implements DomainInterface {

	private Connection conn;

	public DBManager() {
		startConnection();
	}

	/**
	 * Startet die verbindungen zur Datenbank
	 */
	private void startConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/flipagain", "postgres", "flipagain");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (conn != null) {
			System.out.println("Connection success");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	@Override
	public Bundle getBundle(Bundle bundle) {
		bundle.getName();
		int id = bundle.getBundleId();
		Statement s = null;

		try {
			s = conn.createStatement();
			s.executeQuery("SELECT * FROM tbl_bundle WHERE bundleId=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bundle;
	}

	@Override
	public User validateUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_user");
			System.out.println(rs);
			while (rs.next()) {

				if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
					user.setIsAuthorized(true);
				} else {
					user.setIsAuthorized(false);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public ArrayList<String> getBundleList(String modul) {
			
		return null;
	}

}
