package com.umbrella.worldconq;

import java.net.InetAddress;

import com.umbrella.worldconq.comm.ClientAdapter;
import com.umbrella.worldconq.comm.ServerAdapter;
import com.umbrella.worldconq.domain.GameManager;
import com.umbrella.worldconq.domain.UserManager;

public class WorldConqWebApp {

	UserManager userManager = null;
	GameManager gameManager = null;
	ServerAdapter serverAdapter = null;
	ClientAdapter clientAdapter = null;

	public WorldConqWebApp() throws Exception {
		clientAdapter = new ClientAdapter();
		serverAdapter = new ServerAdapter();
		serverAdapter.setRemoteInfo(
			"Server",
			InetAddress.getByName("161.67.106.74"),
			1099);

		gameManager = new GameManager(serverAdapter, clientAdapter);
		userManager = new UserManager(serverAdapter, gameManager, clientAdapter);
		gameManager.setUserManager(userManager);

	}

	/**
	 * @return the userManager
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * @param userManager
	 *            the userManager to set
	 */
	protected void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * @return the gameManager
	 */
	public GameManager getGameManager() {
		return gameManager;
	}

	/**
	 * @param gameManager
	 *            the gameManager to set
	 */
	protected void setGameManager(GameManager gameManager) {
		this.gameManager = gameManager;
	}

}
