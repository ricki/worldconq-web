package com.umbrella.worldconq.domain;

import java.util.Vector;

import com.umbrella.worldconq.ui.GameEventListener;

import domain.Arsenal;
import domain.Player;

public class GameEventPool extends Vector<GameEvent> implements
		GameEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3720667128671848534L;

	@Override
	public void territoryUnderAttack(TerritoryDecorator src, TerritoryDecorator dst, Arsenal arsenal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void negotiationRequested(int money, int soldiers) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attackEvent(TerritoryDecorator src, TerritoryDecorator dst) {
		// TODO Auto-generated method stub

	}

	@Override
	public void negotiationEvent(TerritoryDecorator src, TerritoryDecorator dst) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buyTerritoryEvent(TerritoryDecorator t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buyUnitsEvent(TerritoryDecorator t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnChangedEvent(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void winnerEvent(Player p) {
		// TODO Auto-generated method stub

	}

}
