package application;

import java.sql.SQLException;

import domain.DBManager;
import domain.DomainInterface;
import domain.User;

/**
 * Created by Raffaele on 22.03.2016.
 */
public final class LoginHandler {
    private static DomainInterface di = new DBManager();


    public static boolean getAuthorization(User user) {
        try {
			user = di.validateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        System.out.println(user.isAuthorized());
        return user.isAuthorized();
    }
    
    public void createUser(User user){
    	
    }
}
