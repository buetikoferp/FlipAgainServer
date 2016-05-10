package com.team.flipagain.messaging;

import com.team.flipagain.domain.Bundle;
import com.team.flipagain.domain.FieldOfStudy;
import com.team.flipagain.domain.Module;
import com.team.flipagain.domain.User;

public interface ServerReply {
	
	public void returnValidatedUser(User validatedUser);
	public void returnBundlebyName(Bundle bundle);
	public void returnFoS(FieldOfStudy fos);
	public void returnModule(Module module);

}
