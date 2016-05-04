package messaging;

import domain.Bundle;
import domain.FieldOfStudy;
import domain.Module;
import domain.User;

public interface ServerReply {
	
	public void returnValidatedUser(User user);
	public void returnBundlebyName(Bundle bundle);
	public void returnFoS(FieldOfStudy fos);
	public void returnModule(Module module);

}
