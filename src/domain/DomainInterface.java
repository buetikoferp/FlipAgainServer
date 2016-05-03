package domain;

import java.util.ArrayList;

/**
 * Created by Philipp on 31.03.2016.
 */
public interface DomainInterface {
	/**
	 *
	 * @param user
	 * @return
	 */
	public User validateUser(User user);

	public Bundle getBundle(Bundle bundle);

	public ArrayList<String> getBundleList(String modul);

}
