package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import exceptions.AlreadyInGameException;
import exceptions.FullGameException;
import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;

public class JoinGameAction extends WorldConqAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8078209054558646998L;
	private int id;

	@Override
	public String execute() {
		System.out.println("JoinGameAction::execute");
		try {
			getApp().getGameManager().joinGame(getId());
		} catch (RemoteException e) {
			e.printStackTrace();
			this.addActionError("Error con el servidor remoto.");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.addActionError("Error sesión inválida.");
			e.printStackTrace();
			return ERROR;
		} catch (FullGameException e) {
			this.addActionError("La partida a la que intentas unirte ya está llena.");
			e.printStackTrace();
			return ERROR;
		} catch (GameNotFoundException e) {
			this.addActionError("No se ha podido localizar la partida seleccionada.");
			e.printStackTrace();
			return ERROR;
		} catch (AlreadyInGameException e) {
			this.addActionError("Ya estás unido a la partida seleccionada.");
			return ERROR;
		}
		this.addActionMessage("Te has unido a la partida " + getId());
		return SUCCESS;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
