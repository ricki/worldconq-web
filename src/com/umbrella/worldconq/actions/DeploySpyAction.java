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
	private String exceptionMessage;

	@Override
	public String execute() {
		if (!checkLogged() || !checkPlaying()) {
			this.addActionError("El ususario debe estar logueado y jugando.");
			session.remove("app");
			session.remove("user");
			return ERROR;
		}
		try {
			getApp().getGameManager().getGameEngine().deploySpy(getIndex());
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
		} catch (NotEnoughMoneyException e) {
			e.printStackTrace();
			this.setExceptionMessage("No tienes dinero suficiente para la acción seleccionada");
			return ERROR;
		} catch (PendingAttackException e) {
			e.printStackTrace();
			this.setExceptionMessage("Hay otro ataque en curso");
			return ERROR;
		} catch (InvalidTerritoryException e) {
			e.printStackTrace();
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

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
