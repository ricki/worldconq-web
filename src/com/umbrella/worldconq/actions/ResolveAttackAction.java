package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.NotCurrentPlayerGameException;

public class ResolveAttackAction extends WorldConqAction {

	private static final long serialVersionUID = -1398735491575138577L;
	private String option;

	@Override
	public String execute() {
		if (!checkLogged() || !checkPlaying())
			return ERROR;

		try {
			if ("Attack".equals(getOption())) {
				getApp().getGameManager().getGameEngine().resolveAttack();
			} else if ("Negotiation".equals(getOption())) {
				getApp().getGameManager().getGameEngine().resolveNegotiation();
			}
		} catch (RemoteException e) {
			this.addActionError("Error con el servidor remoto.");
			session.remove("app");
			session.remove("user");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.addActionError("Error sesión inválida.");
			session.remove("app");
			session.remove("user");
			return ERROR;
		} catch (GameNotFoundException e) {
			this.addActionError("No se ha podido localizar la partida seleccionada.");
			return ERROR;
		} catch (NotCurrentPlayerGameException e) {
			this.addActionError("No estás unido a la partida seleccionada.");
			return ERROR;
		}
		return SUCCESS;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getOption() {
		return option;
	}

}
