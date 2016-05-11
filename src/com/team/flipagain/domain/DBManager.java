package com.team.flipagain.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Philipp & Raffaele on 31.03.2016.
 */
public class DBManager implements DomainInterface {
	private Connection conn;
	private Statement stmt;
	private Statement stmt2;

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

	/**
	 * Fragt die Datenbank nach dem gew�nschten Bundle ab und retourniert
	 * dieses.
	 */
	@Override
	public Bundle getBundleByName(String bundleName) {
		Bundle bundle = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_bundle WHERE bundleName=" + bundleName);
			while (rs.next()) {
				bundle = new Bundle(rs.getInt("bundleId"), rs.getString("bundleName"), rs.getInt("userId"),
						rs.getInt("moduleId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bundle;
	}

	/**
	 * Fragt die Datenbank nach dem �bergebenen User-Objekt ab und setzt
	 * isAuthorized() auf true, sofern die Logindaten �bereinstimmen.
	 * Legt ein neues Benutzerobjekt an, sofern isNewUser() = true.
	 * 
	 * @throws SQLException
	 */
	@Override
	public User validateUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		if (user.isNewUser()) {
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("INSERT INTO tbl_user (userid, username, password) VALUES('"
						+ user.getUserid() + "', '" + user.getUsername() + "', '" + user.getPassword() + "')");
				return user;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
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

	/**
	 * Filtert die Datenbank nach dem �bergebenen Modul und f�llt die Treffer in
	 * eine ArrayList ab
	 * 
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Bundle> getBundleList(Module module) {
		int modulID = module.getModuleId();
		Bundle bundle;
		Card card;
		ArrayList<Bundle> bundleList = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_Bundle WHERE modulid= '" + modulID + "'");

			while (rs.next()) {
				bundle = new Bundle(rs.getInt("bundleid"), rs.getString("bundlename"), rs.getInt("userid"),
						rs.getInt("moduleId"));
				bundleList.add(bundle);

				System.out.println(bundle.getName());
				ResultSet rsCard = stmt2
						.executeQuery("SELECT * FROM tbl_Card where bundleid='" + bundle.getBundleId() + "'");
				for (Bundle b : bundleList) {
					while (rsCard.next()) {

						card = new Card(rsCard.getInt("cardid"), rsCard.getInt("userid"), rsCard.getString("question"),
								rsCard.getString("answer"), rsCard.getInt("bundleid"));
						System.out.println(card.getQuestion() + " | Antwort: " + card.getAnswer());
						b.getCardList().add(card);
					}
				}

			}

			printResult(bundleList);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

		return bundleList;
	}

	/**
	 * 
	 * @param bundleList
	 */
	public void printResult(ArrayList<Bundle> bundleList) {

		for (Bundle bundle : bundleList) {

			System.out.println("BundleName: " + bundle.getName());

			for (int i = 0; i < bundle.getCardList().size(); i++) {
				System.out.println("Frage:" + bundle.getCardList().get(i).getQuestion());
				System.out.println("Antwort: " + bundle.getCardList().get(i).getAnswer());

			}

		}
	}

	/**
	 * Liefert eine Liste von allen BundleNamen des �bergebeben Moduls.
	 * 
	 * @throws SQLException
	 * 
	 */
	@Override
	public ArrayList<String> getBundleListByName(String moduleName) {
		int modulId = 0;
		ArrayList<String> bundleList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_modul WHERE modulname='" + moduleName + "'");
			while (rs.next()) {
				modulId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();

			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_bundle WHERE modulId='" + modulId + "'");
				while (rs.next()) {
					bundleList.add(rs.getString(4));
				}
			} catch (SQLException q) {
				q.getMessage();
				q.printStackTrace();
			}
		}
		return bundleList;
	}

	@Override
	public void insertNewBundle(Bundle bundle) {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO tbl_bundle (bundleid, userid, modulid, bundlename) VALUES('"
					+ bundle.getBundleId() + "', '" + bundle.getUserId() + "', '" + bundle.getModuleId() + "', '"
					+ bundle.getName() + "')");
			for (Card c : bundle.getCardList()) {
				stmt2 = conn.createStatement();
				ResultSet rs2 = stmt2
						.executeQuery("INSERT INTO tbl_card (cardid, userid, question, answer, bundleid ) VALUES('"
								+ c.getCardId() + "', '" + c.getUserId() + "', '" + c.getQuestion() + "', '"
								+ c.getAnswer() + "', '" + c.getBundleId() + "')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}