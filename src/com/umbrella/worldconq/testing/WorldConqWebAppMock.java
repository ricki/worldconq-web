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
		super.setUserManager(userManager);
	}

	@Override
	public void setGameManager(GameManager gameManager) {
		super.setGameManager(gameManager);
	}

	@Override
	public GameManager getGameManager() {
		return gameManager;
	}

}
