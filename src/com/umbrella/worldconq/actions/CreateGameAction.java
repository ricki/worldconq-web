package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.umbrella.worldconq.exceptions.EmptyStringException;
import com.umbrella.worldconq.exceptions.NegativeValueException;

import exceptions.InvalidGameInfoException;
import exceptions.InvalidSessionException;

public class CreateGameAction extends WorldConqAction {

	private static final long serialVersionUID = 1794555595702024650L;

	private String name;
	private String description;
	private int turnTime;
	private int negTime;
	private int defTime;
	private ArrayList<String> gameSessions;

	public CreateGameAction() {
		super();
	}

	@Override
	public String execute() {
		if (!checkLogged()) {
			this.addActionError("Usuario no está logeado.");
			return ERROR;
		}

		ArrayList<Calendar> gameS = new ArrayList<Calendar>();
		SimpleDateFormat sdf = new SimpleDateFormat
				("dd-MM-yyyy HH:mm");
		for (int i = 0; i < getGameSessions().size(); i++) {
			String date = getGameSessions().get(i);
			java.util.Date d = null;
			try {
				d = sdf.parse(date);
			} catch (ParseException e) {
				return INPUT;
			}
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			gameS.add(c);
		}

		try {
			getApp().getGameManager().createGame(getName(), getDescription(),
				gameS, getTurnTime(), getDefTime(), getNegTime());
		} catch (RemoteException e) {
			this.addActionError("Error con el servidor remoto.");
			session.remove("app");
			session.remove("user");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.addActionError("Session incorrecta.");
			session.remove("app");
			session.remove("user");
			return ERROR;
		} catch (InvalidGameInfoException e) {
			this.addActionError("Datos de partida incorrectos.");
			return ERROR;
		} catch (EmptyStringException e) {
			this.addActionError("Error al crear partida2.");
			return ERROR;
		} catch (NegativeValueException e) {
			this.addActionError("Error al crear partida3.");
			return ERROR;
		}

		this.addActionMessage("Partida creada correctamente.");
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getTurnTime() {
		return turnTime;
	}

	public int getDefTime() {
		return defTime;
	}

	public int getNegTime() {
		return negTime;
	}

	public ArrayList<String> getGameSessions() {
		return gameSessions;
	}

	public void setName(String string) {
		this.name = string;
	}

	public void setDescription(String string) {
		this.description = string;

	}

	public void setTurnTime(int i) {
		this.turnTime = i;
	}

	public void setDefTime(int i) {
		this.defTime = i;
	}

	public void setNegTime(int i) {
		this.negTime = i;
	}

	public void setGameSessions(ArrayList<String> i) {
		this.gameSessions = i;
	}

}
