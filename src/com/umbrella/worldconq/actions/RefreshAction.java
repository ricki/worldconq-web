package com.umbrella.worldconq.actions;

import java.util.ArrayList;

import domain.Player;
import domain.Territory;

public class RefreshAction extends WorldConqAction {

	private static final long serialVersionUID = -4361295152987885751L;

	@Override
	public String execute() {
		return SUCCESS;
	}

	public String getData0() {
		return "DATA0";
	}

	public String getData1() {
		return "DATA1";
	}

	public ArrayList<Territory> getMap() {
		ArrayList<Territory> map = new ArrayList<Territory>();
		int can[] = new int[3];
		can[0] = 5;
		can[1] = 2;
		can[2] = 7;
		Territory t = new Territory(0, null, "paco", 7, can, 8, 9, 2);
		map.add(t);
		return map;
	}

	public ArrayList<Player> getPlayers() {
		ArrayList<Player> players = new ArrayList<Player>();
		Player p = new Player("paco", 50, false, false, null);
		players.add(p);
		return players;
	}
}
