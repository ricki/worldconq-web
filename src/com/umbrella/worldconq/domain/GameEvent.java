package com.umbrella.worldconq.domain;

import domain.Arsenal;
import domain.Player;

public class GameEvent {

	private EventType type;

	private TerritoryDecorator src;
	private TerritoryDecorator dst;
	private Arsenal arsenal;
	private int money;
	private int soldiers;
	private Player p;

	public GameEvent(EventType type, TerritoryDecorator src, TerritoryDecorator dst, Arsenal arsenal, int money, int soldiers, Player p) {
		super();
		this.type = type;
		this.src = src;
		this.dst = dst;
		this.arsenal = arsenal;
		this.money = money;
		this.soldiers = soldiers;
		this.p = p;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public TerritoryDecorator getSrc() {
		return src;
	}

	public void setSrc(TerritoryDecorator src) {
		this.src = src;
	}

	public TerritoryDecorator getDst() {
		return dst;
	}

	public void setDst(TerritoryDecorator dst) {
		this.dst = dst;
	}

	public Arsenal getArsenal() {
		return arsenal;
	}

	public void setArsenal(Arsenal arsenal) {
		this.arsenal = arsenal;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

}
