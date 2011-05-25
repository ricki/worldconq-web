package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import com.umbrella.worldconq.exceptions.NotEnoughMoneyException;
import com.umbrella.worldconq.exceptions.OutOfTurnException;
import com.umbrella.worldconq.exceptions.PendingAttackException;
import com.umbrella.worldconq.exceptions.UnocupiedTerritoryException;

import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.InvalidTerritoryException;
import exceptions.NotCurrentPlayerGameException;

public class BuyUnitsAction extends WorldConqAction {
	private static final long serialVersionUID = 2307285953676749684L;
	private String exceptionMessage;
	private int index;
	private int money;
	private int soldiers;
	private int cannons;
	private int missiles;
	private int icbms;
	private int antimissiles;

	public String show() {
		if (!checkLogged() || !checkPlaying())
			return ERROR;
		setMoney(getApp().getGameManager().getGameEngine().getPlayerListModel().getSelfPlayer().getMoney());
		return SUCCESS;
	}

	@Override
	public String execute() {
		if (!checkLogged() || !checkPlaying())
			return ERROR;
		try {
			getApp().getGameManager().getGameEngine().buyUnits(getIndex(),
				getSoldiers(), getCannons(), getMissiles(), getIcbm(),
				getAntimissiles());
		} catch (RemoteException e) {
			e.printStackTrace();
			this.setExceptionMessage("Error con el servidor remoto.");
		} catch (GameNotFoundException e) {
			e.printStackTrace();
			this.setExceptionMessage("No se ha podido localizar la partida seleccionada.");
		} catch (InvalidSessionException e) {
			e.printStackTrace();
			this.setExceptionMessage("Error sesión inválida.");
		} catch (NotCurrentPlayerGameException e) {
			e.printStackTrace();
			this.setExceptionMessage("El usuario debe de estar en la partida ");
		} catch (InvalidTerritoryException e) {
			e.printStackTrace();
			this.setExceptionMessage("El territorio seleccionado no es válido");
		} catch (UnocupiedTerritoryException e) {
			e.printStackTrace();
			this.setExceptionMessage("El territorio seleccionado no está ocupado");
		} catch (OutOfTurnException e) {
			e.printStackTrace();
			this.setExceptionMessage("Accion realizada fuera de turno.");
		} catch (NotEnoughMoneyException e) {
			e.printStackTrace();
			this.setExceptionMessage("No tienes dinero suficiente para la acción seleccionada");
		} catch (PendingAttackException e) {
			e.printStackTrace();
			this.setExceptionMessage("Hay otro ataque en curso");
		}
		return SUCCESS;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	String getExceptionMessage() {
		return exceptionMessage;
	}

	void setExceptionMessage(String msg) {
		this.exceptionMessage = msg;

	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public int getCannons() {
		return cannons;
	}

	public void setCannons(int cannons) {
		this.cannons = cannons;
	}

	public int getMissiles() {
		return missiles;
	}

	public void setMissiles(int missiles) {
		this.missiles = missiles;
	}

	public int getIcbm() {
		return icbms;
	}

	public void setIcbm(int icbms) {
		this.icbms = icbms;
	}

	public int getAntimissiles() {
		return antimissiles;
	}

	public void setAntimissiles(int antimissiles) {
		this.antimissiles = antimissiles;
	}

}
