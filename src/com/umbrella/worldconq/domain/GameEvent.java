package com.umbrella.worldconq.domain;


public class GameEvent {

	private EventType type;

	private String message;

	public GameEvent(EventType type, String message) {
		super();
		this.type = type;
		this.message = message;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
