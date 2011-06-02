package com.umbrella.worldconq.actions;

import java.util.ArrayList;

import com.umbrella.worldconq.domain.GameEngine;
import com.umbrella.worldconq.domain.GameEvent;
import com.umbrella.worldconq.domain.MapModel;
import com.umbrella.worldconq.domain.PlayerListModel;
import com.umbrella.worldconq.domain.Session;

import domain.Player;
import domain.Territory;

public class RefreshGameAction extends WorldConqAction {

	private static final long serialVersionUID = -1061243041072947248L;

	private ArrayList<Player> players;
	private ArrayList<Territory> map;
	private ArrayList<GameEvent> events;

	private String exceptionMessage;

	@Override
	public String execute() {
		if (!checkLogged() || !checkPlaying()) {
			this.addActionError("El ususario debe estar logueado y jugando.");
			return ERROR;
		}

		GameEngine engine = getApp().getGameManager().getGameEngine();

		PlayerListModel playerList = engine.getPlayerListModel();
		setPlayers(new ArrayList<Player>());
		for (int i = 0; i < playerList.getRowCount(); i++)
			getPlayers().add(playerList.getPlayerAt(i));

		MapModel mapList = engine.getMapListModel();
		setMap(new ArrayList<Territory>());
		for (int i = 0; i < mapList.getRowCount(); i++) {
			int cannons[] = new int[3];

			if (mapList.getValueAt(i, 1).equals("¿?"))
				getMap().add(new Territory(i, null, null, 0, cannons, 0, 0, 0));
			else {
				cannons[0] = (Integer) mapList.getValueAt(i, 3);
				cannons[1] = (Integer) mapList.getValueAt(i, 4);
				cannons[2] = (Integer) mapList.getValueAt(i, 5);
				getMap().add(new Territory(i, null,
					(String) mapList.getValueAt(i, 1),
					(Integer) mapList.getValueAt(i, 2), cannons,
					(Integer) mapList.getValueAt(i, 6),
					(Integer) mapList.getValueAt(i, 7),
					(Integer) mapList.getValueAt(i, 8)));
			}
		}

		setEvents(getApp().getEventPool().getElements());

		return SUCCESS;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setMap(ArrayList<Territory> map) {
		this.map = map;
	}

	public ArrayList<Territory> getMap() {
		return map;
	}

	public void setEvents(ArrayList<GameEvent> events) {
		this.events = events;
	}

	public ArrayList<GameEvent> getEvents() {
		return events;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

}
