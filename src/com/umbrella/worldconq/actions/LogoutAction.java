package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.InvalidTimeException;
import exceptions.NotCurrentPlayerGameException;

public class LogoutAction extends WorldConqAction {

	private static final long serialVersionUID = -2251248368154290083L;

	@Override
	public String execute() {
		try {
			getApp().getUserManager().closeSession();
			session.remove("app");
			session.remove("user");
		} catch (RemoteException e) {
			e.printStackTrace();
			this.addActionError("Error con el servidor remoto.");
			return ERROR;
		} catch (GameNotFoundException e) {
			this.addActionError("Partida no encontrada.");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.addActionError("Sesión inválida");
			return ERROR;
		} catch (InvalidTimeException e) {
			this.addActionError("Tiempo no válido");
			return ERROR;
		} catch (NotCurrentPlayerGameException e) {
			this.addActionError("El jugador no esta en la partida");
			return ERROR;
		}
		return SUCCESS;
	}

}
