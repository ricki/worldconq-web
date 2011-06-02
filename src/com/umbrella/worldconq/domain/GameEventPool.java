package com.umbrella.worldconq.domain;

import java.util.ArrayList;

import com.umbrella.worldconq.ui.GameEventListener;

import domain.Arsenal;
import domain.Player;

public class GameEventPool implements GameEventListener {

	ArrayList<GameEvent> pool;

	public GameEventPool() {
		pool = new ArrayList<GameEvent>();
	}

	@Override
	public void territoryUnderAttack(TerritoryDecorator src, TerritoryDecorator dst, Arsenal arsenal) {
		pool.add(new GameEvent());
	}

	@Override
	public void negotiationRequested(int money, int soldiers) {
		pool.add(new GameEvent(soldiers, money));
	}

	@Override
	public void attackEvent(TerritoryDecorator src, TerritoryDecorator dst) {
		pool.add(new GameEvent(
			"El territorio de " + dst.getName() + " está siendo atacado por "
					+ src.getName() + "."));
	}

	@Override
	public void negotiationEvent(TerritoryDecorator src, TerritoryDecorator dst) {
		pool.add(new GameEvent(
			"Se está ofreciendo una negociación de " + src.getName()
					+ " a " + dst.getName() + "."));
	}

	@Override
	public void buyTerritoryEvent(TerritoryDecorator t) {
		pool.add(new GameEvent(t.getOwner() + " ha comprado " + t.getName()));
	}

	@Override
	public void buyUnitsEvent(TerritoryDecorator t) {
		pool.add(new GameEvent(
			"Se ha realizado una compra de arsenal en " + t.getName()));
	}

	@Override
	public void turnChangedEvent(Player p) {
		pool.add(new GameEvent("Ha cambiado el turno. Es el turno de  "
				+ p.getName()));
	}

	@Override
	public void winnerEvent(Player p) {
		pool.add(new GameEvent(p.getName() + "ha ganado la partida."));
	}

	public ArrayList<GameEvent> getElements() {
		ArrayList<GameEvent> events = this.pool;
		this.pool = new ArrayList<GameEvent>();
		return events;
	}

}
