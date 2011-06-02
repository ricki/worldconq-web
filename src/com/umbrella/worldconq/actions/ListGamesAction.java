package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.umbrella.worldconq.domain.GameListModel;

import domain.GameInfo;
import exceptions.InvalidSessionException;

public class ListGamesAction extends WorldConqAction {

	private static final long serialVersionUID = -8287753190029594857L;

	private ArrayList<GameInfo> currentGames;
	private ArrayList<GameInfo> openGames;

	private GameListModel currentGameList;
	private GameListModel openGameList;

	@Override
	public String execute() {
		if (!checkLogged()) {
			this.addActionError("Usuario no está logeado.");
			return ERROR;
		}

		try {
			getApp().getGameManager().updateGameList();
		} catch (RemoteException e) {
			e.printStackTrace();
			this.addActionError("Error con el servidor remoto.");
			session.remove("app");
			session.remove("user");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.addActionError("Error sesión inválida.");
			e.printStackTrace();
			return ERROR;
		}
		currentGameList = getApp().getGameManager().getCurrentGameListModel();
		currentGames = new ArrayList<GameInfo>();
		for (int i = 0; i < currentGameList.getRowCount(); i++) {
			currentGames.add(i, currentGameList.getGameAt(i));
		}
		openGameList = getApp().getGameManager().getOpenGameListModel();
		openGames = new ArrayList<GameInfo>();
		for (int i = 0; i < openGameList.getRowCount(); i++) {
			openGames.add(i, openGameList.getGameAt(i));
		}
		return SUCCESS;
	}

	public ArrayList<GameInfo> getCurrentGames() {
		return currentGames;
	}

	public void setCurrentGames(ArrayList<GameInfo> currentGame) {
		this.currentGames = currentGame;
	}

	public ArrayList<GameInfo> getOpenGames() {
		return openGames;
	}

	public void setOpenGames(ArrayList<GameInfo> openGame) {
		this.openGames = openGame;
	}

}
