package com.umbrella.worldconq.testing;

import com.umbrella.worldconq.WorldConqWebApp;
import com.umbrella.worldconq.domain.UserManager;

class WorldConqWebAppMock extends WorldConqWebApp {

	UserManager usrMgr;

	public WorldConqWebAppMock() throws Exception {
	}

	@Override
	public UserManager getUserManager() {
		if (usrMgr == null) usrMgr = new UserManagerMock();
		return usrMgr;
	}

}
