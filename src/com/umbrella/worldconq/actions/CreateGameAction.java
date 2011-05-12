package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import com.umbrella.worldconq.exceptions.EmptyStringException;
import com.umbrella.worldconq.exceptions.NegativeValueException;

import exceptions.InvalidGameInfoException;
import exceptions.InvalidSessionException;

public class CreateGameAction extends WorldConqAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1794555595702024650L;

	private String name;
	private String description;
	private int turnTime;
	private int negTime;
	private int defTime;
	private ArrayList<Calendar> gameSessions;

	public CreateGameAction() {
		super();
		gameSessions = new ArrayList<Calendar>();
	}

	@Override
	public String execute() {

		try {

			System.out.println("nombre" + getName());
			System.out.println("descripcion" + getDescription());
			System.out.println("turno" + getTurnTime());
			System.out.println("def" + getDefTime());
			System.out.println("neg" + getNegTime());

			getApp().getGameManager().createGame(getName(), getDescription(),
				getGameSessions(), getTurnTime(), getDefTime(), getNegTime());
		} catch (RemoteException e) {
			e.printStackTrace();
			this.addActionError("Error con el servidor remoto.");
			session.remove("app");
			return ERROR;
		} catch (InvalidGameInfoException e) {
			this.addActionError("Datos de partida incorrectos.");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.addActionError("Session incorrecta.");
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

	public ArrayList<Calendar> getGameSessions() {
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

	public void setGameSessions(ArrayList<Calendar> i) {
		this.gameSessions = i;
	}

}
