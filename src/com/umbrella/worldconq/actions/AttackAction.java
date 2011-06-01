package com.umbrella.worldconq.actions;

import java.util.ArrayList;

import com.umbrella.worldconq.domain.GameEngine;
import com.umbrella.worldconq.domain.TerritoryDecorator;

import domain.Player;

public class AttackAction extends WorldConqAction {

	private static final long serialVersionUID = 4968337150399954579L;

	private int soldiers;
	private int cannons;
	private int missiles;
	private int icbm;
	private int index;

	private int availableSoldiers;
	private int availableCannons;
	private int availableMissiles;
	private int availableICBM;
	private ArrayList<Integer> availableTargets;

	private String exceptionMessage;

	public String show() {
		if (!checkLogged() || !checkPlaying()) {
			addActionError("Partida no en juego.");
			return ERROR;
		}

		GameEngine engine = getApp().getGameManager().getGameEngine();

		TerritoryDecorator src = engine.getMapListModel().getTerritoryAt(
			getIndex());

		setAvailableSoldiers(src.getNumSoldiers());
		setAvailableCannons(src.getNumTotalCannons());
		setAvailableMissiles(src.getNumMissiles());
		setAvailableICBM(src.getNumICBMs());

		ArrayList<Integer> adj = new ArrayList<Integer>();
		Player self = engine.getPlayerListModel().getSelfPlayer();
		for (TerritoryDecorator t : src.getAdjacentTerritories()) {
			Player target = t.getPlayer();
			if (target != null && !target.equals(self))
				adj.add(new Integer(t.getId()));
		}
		return SUCCESS;
	}

	//	@Override
	//	public String execute() {
	//		if (!checkLogged() || !checkPlaying())
	//			return ERROR;
	//		try {
	//			
	//		} catch (RemoteException e) {
	//			e.printStackTrace();
	//			this.setExceptionMessage("Error con el servidor remoto.");
	//			return ERROR;
	//		} catch (GameNotFoundException e) {
	//			e.printStackTrace();
	//			this.setExceptionMessage("No se ha podido localizar la partida seleccionada.");
	//			return ERROR;
	//		} catch (InvalidSessionException e) {
	//			e.printStackTrace();
	//			this.setExceptionMessage("Error sesión inválida.");
	//			return ERROR;
	//		} catch (NotCurrentPlayerGameException e) {
	//			e.printStackTrace();
	//			this.setExceptionMessage("El usuario debe de estar en la partida ");
	//			return ERROR;
	//		} catch (InvalidTerritoryException e) {
	//			e.printStackTrace();
	//			this.setExceptionMessage("El territorio seleccionado no es válido");
	//			return ERROR;
	//		} catch (UnocupiedTerritoryException e) {
	//			e.printStackTrace();
	//			this.setExceptionMessage("El territorio seleccionado no está ocupado");
	//			return ERROR;
	//		} catch (OutOfTurnException e) {
	//			e.printStackTrace();
	//			this.setExceptionMessage("Accion realizada fuera de turno.");
	//			return ERROR;
	//		} catch (NotEnoughMoneyException e) {
	//			e.printStackTrace();
	//			this.setExceptionMessage("No tienes dinero suficiente para la acción seleccionada");
	//			return ERROR;
	//		} catch (PendingAttackException e) {
	//			e.printStackTrace();
	//			this.setExceptionMessage("Hay otro ataque en curso");
	//			return ERROR;
	//		}
	//		return SUCCESS;
	//	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setCannons(int cannons) {
		this.cannons = cannons;
	}

	public int getCannons() {
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

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setAvailableSoldiers(int availableSoldiers) {
		this.availableSoldiers = availableSoldiers;
	}

	public int getAvailableSoldiers() {
		return availableSoldiers;
	}

	public void setAvailableCannons(int availableCannons) {
		this.availableCannons = availableCannons;
	}

	public int getAvailableCannons() {
		return availableCannons;
	}

	public void setAvailableMissiles(int availableMissiles) {
		this.availableMissiles = availableMissiles;
	}

	public int getAvailableMissiles() {
		return availableMissiles;
	}

	public void setAvailableICBM(int availableICBM) {
		this.availableICBM = availableICBM;
	}

	public int getAvailableICBM() {
		return availableICBM;
	}

	public void setAvailableTargets(ArrayList<Integer> availableTargets) {
		this.availableTargets = availableTargets;
	}

	public ArrayList<Integer> getAvailableTargets() {
		return availableTargets;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

}
