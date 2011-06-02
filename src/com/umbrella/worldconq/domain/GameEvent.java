package com.umbrella.worldconq.domain;

public class GameEvent {

	private int type;
	private String message;
	private int soldiers;
	private int money;

	public GameEvent(String message) {
		setType(0);
		setMessage(message);
	}

	public GameEvent() {
		setType(1);
	}

	public GameEvent(int soldiers, int money) {
		setType(2);
		setSoldiers(soldiers);
		setMoney(money);
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

}
