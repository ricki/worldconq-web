package com.umbrella.worldconq.domain;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import com.umbrella.worldconq.ui.GameEventListener;

import domain.Arsenal;
import domain.Player;

public class GameEventPool extends Vector<GameEvent> implements
		GameEventListener {

	private static final long serialVersionUID = 3720667128671848534L;

	@Override
	public void territoryUnderAttack(TerritoryDecorator src, TerritoryDecorator dst, Arsenal arsenal) {
		this.add(new GameEvent(EventType.TerritoryUnderAttackEvent,
			"El territorio de " + dst.getName() + " está siendo atacado por "
					+ src.getName() + "."));
	}

	@Override
	public void negotiationRequested(int money, int soldiers) {
		this.add(new GameEvent(EventType.NegotiationEvent,
			"Se está ofreciendo una negociación de " + Integer.toString(money)
					+ " gallifantes y " + Integer.toString(soldiers)
					+ " soldados."));
	}

	@Override
	public void attackEvent(TerritoryDecorator src, TerritoryDecorator dst) {
		this.add(new GameEvent(EventType.TerritoryUnderAttackEvent,
			"El territorio de " + dst.getName() + " está siendo atacado por "
					+ src.getName() + "."));
	}

	@Override
	public void negotiationEvent(TerritoryDecorator src, TerritoryDecorator dst) {
		this.add(new GameEvent(EventType.NegotiationEvent,
			"Se está ofreciendo una negociación de " + src.getName()
					+ " a " + dst.getName() + "."));
	}

	@Override
	public void buyTerritoryEvent(TerritoryDecorator t) {
		this.add(new GameEvent(EventType.BuyTerritoryEvent, t.getOwner()
				+ " ha comprado " + t.getName()));
	}

	@Override
	public void buyUnitsEvent(TerritoryDecorator t) {
		this.add(new GameEvent(EventType.BuyArsenalEvent,
			"Se ha realizado una compra de arsenal en " + t.getName()));
	}

	@Override
	public void turnChangedEvent(Player p) {
		this.add(new GameEvent(EventType.TurnChanged,
			"Ha cambiado el turno. Es el turno de  " + p.getName()));
	}

	@Override
	public void winnerEvent(Player p) {
		this.add(new GameEvent(EventType.WinnerEvent,
			p.getName() + "ha ganado la partida."));
	}

	@Override
	public Enumeration<GameEvent> elements() {
		Enumeration<GameEvent> e = super.elements();
		this.clear();
		return e;
	}

	public ArrayList<GameEvent> getElements() {
		Enumeration<GameEvent> e = this.elements();
		ArrayList<GameEvent> listElements = new ArrayList<GameEvent>();
		while (e.hasMoreElements())
			listElements.add(e.nextElement());
		return listElements;

	}

}
