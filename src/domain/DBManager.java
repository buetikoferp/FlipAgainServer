package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Philipp & Raffaele on 31.03.2016.
 */
public class DBManager implements DomainInterface {

	private Connection conn;
	private Statement stmt;

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
	 * Fragt die Datenbank nach dem gewünschten Bundle ab und retourniert dieses.
	 */
	@Override
	public Bundle getBundle(Bundle bundle) {
		bundle.getName();
		int id = bundle.getBundleId();
		try {
			stmt = conn.createStatement();
			stmt.executeQuery("SELECT * FROM tbl_bundle WHERE bundleId=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bundle;
	}
	
	
	/**
	 * Fragt die Datenbank nach dem übergebenen User-Objekt ab und setzt isAuthorized() auf true, sofern die Logindaten übereinstimmen.
	 * @throws SQLException 
	 */
	@Override
	public User validateUser(User user) throws SQLException {
		String username = user.getUsername();
		String password = user.getPassword();
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
		finally{
			conn.close();
		}

		return user;
	}
	
	/**
	 * Filtert die Datenbank nach dem übergebenen Modul und füllt die Treffer in eine ArrayList ab
	 * @throws SQLException 
	 */
	@Override
	public ArrayList<Bundle> getBundleList(Module module) throws SQLException {
		int modulID = module.getModuleId();
		Bundle bundle;
		ArrayList<Bundle> bundleList = new ArrayList<>();
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_Bundle WHERE modulID=" + modulID);
			while(rs.next()){
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			conn.close();
		}
			
		return bundleList;
	}

}
