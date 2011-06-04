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
		try {
			getApp().getGameManager().getGameEngine().buyUnits(getIndex(),
				getSoldiers(), getCannons(), getMissiles(), getIcbm(),
				getAntimissiles());
		} catch (RemoteException e) {
			this.addActionError("Error con el servidor remoto.");
			getSession().remove("app");
			getSession().remove("user");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.addActionError("Error sesión inválida.");
			getSession().remove("app");
			getSession().remove("user");
			return ERROR;
		} catch (GameNotFoundException e) {
			this.addActionError("No se ha podido localizar la partida seleccionada.");
			return ERROR;
		} catch (NotCurrentPlayerGameException e) {
			this.addActionError("El usuario debe de estar en la partida ");
			return ERROR;
		} catch (InvalidTerritoryException e) {
			this.addActionError("El territorio seleccionado no es válido");
			return ERROR;
		} catch (UnocupiedTerritoryException e) {
			this.addActionError("El territorio seleccionado no está ocupado");
			return ERROR;
		} catch (OutOfTurnException e) {
			this.addActionError("Accion realizada fuera de turno.");
			return ERROR;
		} catch (NotEnoughMoneyException e) {
			this.addActionError("No tienes dinero suficiente para la acción seleccionada");
			return ERROR;
		} catch (PendingAttackException e) {
			this.addActionError("Hay otro ataque en curso");
			return ERROR;
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
