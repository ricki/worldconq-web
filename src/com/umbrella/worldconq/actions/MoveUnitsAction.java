package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import com.umbrella.worldconq.exceptions.NotEnoughUnitsException;
import com.umbrella.worldconq.exceptions.OutOfTurnException;
import com.umbrella.worldconq.exceptions.PendingAttackException;
import com.umbrella.worldconq.exceptions.UnocupiedTerritoryException;

import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.InvalidTerritoryException;
import exceptions.NotCurrentPlayerGameException;

public class MoveUnitsAction extends WorldConqAction {

	private static final long serialVersionUID = -4662175395323526099L;
	private int src;
	private int dst;
	private int soldiers;
	private int[] cannons;
	private int missiles;
	private int icbms;
	private int antimissiles;
	private int availableSoldiers;
	private int[] availableCannons;
	private int availableMissiles;
	private int availableIcbms;
	private int availableAntimissiles;
	private String exceptionMessage;

	public String show() {
		if (!checkLogged() || !checkPlaying())
			return ERROR;
		setAvailableSoldiers(getApp().getGameManager().getGameEngine().getMapListModel().getTerritoryAt(
			src).getNumSoldiers());
		setAvailableCannons(getApp().getGameManager().getGameEngine().getMapListModel().getTerritoryAt(
			src).getNumCannons());
		setAvailableMissiles(getApp().getGameManager().getGameEngine().getMapListModel().getTerritoryAt(
			src).getNumMissiles());
		setAvailableAntimissiles(getApp().getGameManager().getGameEngine().getMapListModel().getTerritoryAt(
			src).getNumAntiMissiles());
		setAvailableIcbms(getApp().getGameManager().getGameEngine().getMapListModel().getTerritoryAt(
			src).getNumICBMs());
		return SUCCESS;
	}

	@Override
	public String execute() {
		if (!checkLogged() || !checkPlaying())
			return ERROR;
		try {
			getApp().getGameManager().getGameEngine().moveUnits(src, dst,
				soldiers, cannons, antimissiles, icbms, antimissiles);
		} catch (RemoteException e) {
			e.printStackTrace();
			this.setExceptionMessage("Error con el servidor remoto.");
			return ERROR;
		} catch (GameNotFoundException e) {
			e.printStackTrace();
			this.setExceptionMessage("No se ha podido localizar la partida seleccionada.");
			return ERROR;
		} catch (InvalidSessionException e) {
			e.printStackTrace();
			this.setExceptionMessage("Error sesión inválida.");
			return ERROR;
		} catch (NotCurrentPlayerGameException e) {
			e.printStackTrace();
			this.setExceptionMessage("El usuario debe de estar en la partida ");
			return ERROR;
		} catch (OutOfTurnException e) {
			e.printStackTrace();
			this.setExceptionMessage("Accion realizada fuera de turno.");
			return ERROR;
		} catch (UnocupiedTerritoryException e) {
			e.printStackTrace();
			this.setExceptionMessage("El territorio no está ocupado");
			return ERROR;
		} catch (InvalidTerritoryException e) {
			e.printStackTrace();
			this.setExceptionMessage("El territorio es inválido");
			return ERROR;
		} catch (NotEnoughUnitsException e) {
			e.printStackTrace();
			this.setExceptionMessage("No hay suficientes unidades");
			return ERROR;
		} catch (PendingAttackException e) {
			e.printStackTrace();
			this.setExceptionMessage("Hay otro ataque en curso");
			return ERROR;
		}
		return SUCCESS;
	}

	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public int[] getCannons() {
		return cannons;
	}

	public void setCannons(int[] cannons) {
		this.cannons = cannons;
	}

	public int getMissiles() {
		return missiles;
	}

	public void setMissiles(int missiles) {
		this.missiles = missiles;
	}

	public int getIcbms() {
		return icbms;
	}

	public void setIcbms(int icbms) {
		this.icbms = icbms;
	}

	public int getAntimissiles() {
		return antimissiles;
	}

	public void setAntimissiles(int antimissiles) {
		this.antimissiles = antimissiles;
	}

	public int getAvailableSoldiers() {
		return availableSoldiers;
	}

	public void setAvailableSoldiers(int availableSoldiers) {
		this.availableSoldiers = availableSoldiers;
	}

	public int[] getAvailableCannons() {
		return availableCannons;
	}

	public void setAvailableCannons(int[] availableCannons) {
		this.availableCannons = availableCannons;
	}

	public int getAvailableMissiles() {
		return availableMissiles;
	}

	public void setAvailableMissiles(int availableMissiles) {
		this.availableMissiles = availableMissiles;
	}

	public int getAvailableIcbms() {
		return availableIcbms;
	}

	public void setAvailableIcbms(int availableIcbms) {
		this.availableIcbms = availableIcbms;
	}

	public int getAvailableAntimissiles() {
		return availableAntimissiles;
	}

	public void setAvailableAntimissiles(int availableAntimissiles) {
		this.availableAntimissiles = availableAntimissiles;
	}

	public int getDst() {
		return dst;
	}

	public void setDst(int dst) {
		this.dst = dst;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
