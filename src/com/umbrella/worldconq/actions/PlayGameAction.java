package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import domain.Player;
import exceptions.AlreadyInGameException;
import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.InvalidTimeException;
import exceptions.NotCurrentPlayerGameException;

public class PlayGameAction extends WorldConqAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 690931065777345613L;
	private int id;

	@Override
	public String execute() {
		try {
			getApp().getGameManager().connectToGame(id, null);
		} catch (RemoteException e) {
			e.printStackTrace();
			this.addActionError("Error con el servidor remoto.");
			session.remove("app");
			session.remove("user");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.addActionError("Error sesión inválida.");
			session.remove("app");
			session.remove("user");
			e.printStackTrace();
			return ERROR;
		} catch (GameNotFoundException e) {
			this.addActionError("No se ha podido localizar la partida seleccionada.");
			session.remove("app");
			session.remove("user");
			e.printStackTrace();
			return ERROR;
		} catch (InvalidTimeException e) {
			this.addActionError("No es buen momento para jugar. Tómate un café.");
			session.remove("app");
			session.remove("user");
			e.printStackTrace();
			return ERROR;
		} catch (NotCurrentPlayerGameException e) {
			this.addActionError("No estás unido a la partida seleccionada.");
			session.remove("app");
			session.remove("user");
			e.printStackTrace();
			return ERROR;
		} catch (AlreadyInGameException e) {
			this.addActionError("Ya estás conectado a la partida seleccionada.");
			session.remove("app");
			session.remove("user");
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Player getPlayer() {
		return getApp().getGameManager().getGameEngine().getPlayerListModel().getSelfPlayer();
	}

	public void setPlayer(Player player) {
	}
}
