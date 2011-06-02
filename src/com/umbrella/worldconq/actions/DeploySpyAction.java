package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import com.umbrella.worldconq.exceptions.NotEnoughMoneyException;
import com.umbrella.worldconq.exceptions.OutOfTurnException;
import com.umbrella.worldconq.exceptions.PendingAttackException;

import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.InvalidTerritoryException;
import exceptions.NotCurrentPlayerGameException;

public class DeploySpyAction extends WorldConqAction {
	private static final long serialVersionUID = 5743892256685309006L;
	private int index;

	@Override
	public String execute() {
		if (!checkLogged() || !checkPlaying())
			return ERROR;

		try {
			getApp().getGameManager().getGameEngine().deploySpy(getIndex());
		} catch (RemoteException e) {
			this.setExceptionMessage("Error con el servidor remoto.");
			session.remove("app");
			session.remove("user");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.setExceptionMessage("Error sesión inválida.");
			session.remove("app");
			session.remove("user");
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
		} catch (NotEnoughMoneyException e) {
			this.setExceptionMessage("No tienes dinero suficiente para la acción seleccionada");
			return ERROR;
		} catch (PendingAttackException e) {
			this.setExceptionMessage("Hay otro ataque en curso");
			return ERROR;
		} catch (InvalidTerritoryException e) {
			this.setExceptionMessage("El territorio seleccionado no es válido");
			return ERROR;
		}
		return SUCCESS;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
