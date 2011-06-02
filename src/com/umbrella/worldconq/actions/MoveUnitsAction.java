package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.umbrella.worldconq.domain.TerritoryDecorator;
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

	private int soldiers;
	private int[] cannons;
	private int missiles;
	private int icbm;
	private int antimissiles;
	private int index;
	private int target;

	private int availableSoldiers;
	private int[] availableCannons;
	private int availableMissiles;
	private int availableIcbm;
	private int availableAntimissiles;
	private ArrayList<Integer> availableTargets;

	public String show() {
		if (!checkLogged() || !checkPlaying())
			return ERROR;

		TerritoryDecorator t = getApp().getGameManager().getGameEngine().getMapListModel().getTerritoryAt(
			getIndex());
		setAvailableSoldiers(t.getNumSoldiers());
		setAvailableCannons(t.getNumCannons());
		setAvailableMissiles(t.getNumMissiles());
		setAvailableAntimissiles(t.getNumAntiMissiles());
		setAvailableIcbm(t.getNumICBMs());
		// TODO avaibleTargets
		return SUCCESS;
	}

	@Override
	public String execute() {
		if (!checkLogged() || !checkPlaying())
			return ERROR;

		try {
			getApp().getGameManager().getGameEngine().moveUnits(getIndex(),
				getTarget(), getSoldiers(), getCannons(), getMissiles(),
				getIcbm(), getAntimissiles());
		} catch (RemoteException e) {
			this.setExceptionMessage("Error con el servidor remoto.");
			getSession().remove("app");
			getSession().remove("user");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.setExceptionMessage("Error sesión inválida.");
			getSession().remove("app");
			getSession().remove("user");
			return ERROR;
		} catch (GameNotFoundException e) {
			this.setExceptionMessage("No se ha podido localizar la partida seleccionada.");
			return ERROR;
		} catch (NotCurrentPlayerGameException e) {
			this.setExceptionMessage("El usuario debe de estar en la partida ");
			return ERROR;
		} catch (OutOfTurnException e) {
			this.setExceptionMessage("Accion realizada fuera de turno.");
			return ERROR;
		} catch (UnocupiedTerritoryException e) {
			this.setExceptionMessage("El territorio no está ocupado");
			return ERROR;
		} catch (InvalidTerritoryException e) {
			this.setExceptionMessage("El territorio es inválido");
			return ERROR;
		} catch (NotEnoughUnitsException e) {
			this.setExceptionMessage("No hay suficientes unidades");
			return ERROR;
		} catch (PendingAttackException e) {
			this.setExceptionMessage("Hay otro ataque en curso");
			return ERROR;
		}
		return SUCCESS;
	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setCannons(int[] cannons) {
		this.cannons = cannons;
	}

	public int[] getCannons() {
		return cannons;
	}

	public void setMissiles(int missiles) {
		this.missiles = missiles;
	}

	public int getMissiles() {
		return missiles;
	}

	public void setIcbm(int icbm) {
		this.icbm = icbm;
	}

	public int getIcbm() {
		return icbm;
	}

	public void setAntimissiles(int antimissiles) {
		this.antimissiles = antimissiles;
	}

	public int getAntimissiles() {
		return antimissiles;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getTarget() {
		return target;
	}

	public void setAvailableSoldiers(int availableSoldiers) {
		this.availableSoldiers = availableSoldiers;
	}

	public int getAvailableSoldiers() {
		return availableSoldiers;
	}

	public void setAvailableCannons(int[] availableCannons) {
		this.availableCannons = availableCannons;
	}

	public int[] getAvailableCannons() {
		return availableCannons;
	}

	public void setAvailableMissiles(int availableMissiles) {
		this.availableMissiles = availableMissiles;
	}

	public int getAvailableMissiles() {
		return availableMissiles;
	}

	public void setAvailableIcbm(int availableIcbm) {
		this.availableIcbm = availableIcbm;
	}

	public int getAvailableIcbm() {
		return availableIcbm;
	}

	public void setAvailableAntimissiles(int availableAntimissiles) {
		this.availableAntimissiles = availableAntimissiles;
	}

	public int getAvailableAntimissiles() {
		return availableAntimissiles;
	}

	public void setAvailableTargets(ArrayList<Integer> availableTargets) {
		this.availableTargets = availableTargets;
	}

	public ArrayList<Integer> getAvailableTargets() {
		return availableTargets;
	}

}
