package com.umbrella.worldconq.actions;

import java.util.ArrayList;

import com.umbrella.worldconq.domain.MapModel;
import com.umbrella.worldconq.domain.PlayerListModel;

import domain.Player;
import domain.Territory;

public class RefreshGameAction extends WorldConqAction {

	private ArrayList<Player> players;
	private ArrayList<Territory> map;

	@Override
	public String execute() {
		if (getApp().getUserManager().getSession() == null
				|| getApp().getGameManager().getGameEngine() == null) {
			this.addActionError("El ususario debe estar logueado y jugando.");
			session.remove("app");
			session.remove("user");
			return ERROR;
		}
		PlayerListModel playerList = getApp().getGameManager().getGameEngine().getPlayerListModel();
		players = new ArrayList<Player>();

		for (int i = 0; i < playerList.getRowCount(); i++)
			players.add(playerList.getPlayerAt(i));

		MapModel mapList = getApp().getGameManager().getGameEngine().getMapListModel();
		map = new ArrayList<Territory>();

		for (int i = 0; i < mapList.getRowCount(); i++) {
			int cannons[] = new int[3];

			if (mapList.getValueAt(i, 1).equals("¿?")) 
				map.add(new Territory(i, null, null, 0, cannons, 0, 0, 0));
			else {
				cannons[0] = (Integer) mapList.getValueAt(i, 3);
				cannons[1] = (Integer) mapList.getValueAt(i, 4);
				cannons[2] = (Integer) mapList.getValueAt(i, 5);
				map.add(new Territory(i, null,
					(String) mapList.getValueAt(i, 1),
					(Integer) mapList.getValueAt(i, 2), cannons,
					(Integer) mapList.getValueAt(i, 6),
					(Integer) mapList.getValueAt(i, 7),
					(Integer) mapList.getValueAt(i, 8)));
			}
		}
		return SUCCESS;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
	}

	public ArrayList<Territory> getMap() {
		return map;
	}

	public void setMap(ArrayList<Territory> map) {
	}

}
