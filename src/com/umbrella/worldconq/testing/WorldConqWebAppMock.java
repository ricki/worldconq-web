package com.umbrella.worldconq.testing;

import com.umbrella.worldconq.WorldConqWebApp;
import com.umbrella.worldconq.domain.UserManager;

class WorldConqWebAppMock extends WorldConqWebApp {

	UserManager userManager;

	public WorldConqWebAppMock() throws Exception {
	}

	@Override
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public UserManager getUserManager() {
		return userManager;
	}

}
