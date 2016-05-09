package com.team.flipagain.server.messaging;

import com.team.flipagain.server.domain.Bundle;
import com.team.flipagain.server.domain.FieldOfStudy;
import com.team.flipagain.server.domain.Module;
import com.team.flipagain.server.domain.User;

public interface ServerReply {
	
	public void returnValidatedUser();
	public void returnBundlebyName(Bundle bundle);
	public void returnFoS(FieldOfStudy fos);
	public void returnModule(Module module);

}
