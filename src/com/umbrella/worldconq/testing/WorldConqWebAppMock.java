package com.umbrella.worldconq.testing;

import com.umbrella.worldconq.WorldConqWebApp;
import com.umbrella.worldconq.domain.GameManager;
import com.umbrella.worldconq.domain.UserManager;

class WorldConqWebAppMock extends WorldConqWebApp {

	UserManager userManager;
	GameManager gameManager;

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

	public void setGameManager(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	@Override
	public GameManager getGameManager() {
		return gameManager;
	}

}
