package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import com.umbrella.worldconq.exceptions.NotEnoughMoneyException;
import com.umbrella.worldconq.exceptions.OcupiedTerritoryException;
import com.umbrella.worldconq.exceptions.OutOfTurnException;
import com.umbrella.worldconq.exceptions.PendingAttackException;

import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.InvalidTerritoryException;
import exceptions.NotCurrentPlayerGameException;

public class BuyTerritoryAction extends WorldConqAction {

	private static final long serialVersionUID = -5065037957984499211L;

	private int index;

	@Override
	public String execute() {
		if (!checkLogged() || !checkPlaying()) return ERROR;

		try {
			getApp().getGameManager().getGameEngine().buyTerritory(getIndex());
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
		} catch (final NotCurrentPlayerGameException e) {
			this.addActionError("El usuario debe de estar en la partida ");
			return ERROR;
		} catch (final OutOfTurnException e) {
			this.addActionError("Accion realizada fuera de turno.");
			return ERROR;
		} catch (final PendingAttackException e) {
			this.addActionError("Hay otro ataque en curso");
			return ERROR;
		} catch (final NotEnoughMoneyException e) {
			this.addActionError("No tienes dinero suficiente para la acción seleccionada");
			return ERROR;
		} catch (final OcupiedTerritoryException e) {
			this.addActionError("El territorio seleccionado está ocupado");
			return ERROR;
		} catch (final InvalidTerritoryException e) {
			this.addActionError("El territorio seleccionado no es válido");
			return ERROR;
		}
		return SUCCESS;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
