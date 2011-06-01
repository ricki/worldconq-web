package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import com.umbrella.worldconq.domain.Attack;
import com.umbrella.worldconq.domain.TerritoryDecorator;
import com.umbrella.worldconq.exceptions.NotEnoughMoneyException;
import com.umbrella.worldconq.exceptions.NotEnoughUnitsException;
import com.umbrella.worldconq.exceptions.OutOfTurnException;

import domain.Arsenal;
import domain.Territory;
import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.InvalidTimeException;

public class UnderAttackAction extends WorldConqAction {

	private static final long serialVersionUID = -7228418678746042546L;
	private String exceptionMessage;
	private Attack currentAttack;
	private int money;
	private int soldiers;

	public String show() {
		if (!checkLogged() || !checkPlaying() || !checkCurrentAttack()) {
			setCurrentAttack(new Attack(new Arsenal(1, 1, 1, 0),
							new TerritoryDecorator(new Territory(0, null,
								"usuario de error origen", 0,
								null, 4, 3, 3), null, null),
				new TerritoryDecorator(
								new Territory(2, null,
									"usuario de error destino", 4, null,
									14, 13, 13),
								null, null)));
			return ERROR;
		}
		setCurrentAttack(getApp().getGameManager().getGameEngine().getCurrentAttack());
		return SUCCESS;
	}

	public void executeAttack() {
		try {
			getApp().getGameManager().getGameEngine().acceptAttack();
		} catch (RemoteException e) {
			this.setExceptionMessage("Error con el servidor remoto.");
		} catch (GameNotFoundException e) {
			this.setExceptionMessage("No se ha podido localizar la partida seleccionada.");
		} catch (InvalidSessionException e) {
			this.setExceptionMessage("Error sesión inválida.");
		} catch (InvalidTimeException e) {
			this.setExceptionMessage("Tiempo no válido.");
		} catch (OutOfTurnException e) {
			this.setExceptionMessage("Accion realizada fuera de turno.");
		}
	}

	public void executeNegotiation() {
		try {
			getApp().getGameManager().getGameEngine().requestNegotiation(
					getMoney(), getSoldiers());
		} catch (RemoteException e) {
			this.setExceptionMessage("Error con el servidor remoto.");
		} catch (GameNotFoundException e) {
			this.setExceptionMessage("No se ha podido localizar la partida seleccionada.");
		} catch (InvalidSessionException e) {
			this.setExceptionMessage("Error sesión inválida.");
		} catch (InvalidTimeException e) {
			this.setExceptionMessage("Tiempo no válido.");
		} catch (OutOfTurnException e) {
			this.setExceptionMessage("Accion realizada fuera de turno.");
		} catch (NotEnoughMoneyException e) {
			this.setExceptionMessage("No tienes dinero suficiente para la acción seleccionada");
		} catch (NotEnoughUnitsException e) {
			this.setExceptionMessage("No tienes soldados suficiente para la acción seleccionada");
		}
	}

	public void setCurrentAttack(Attack currentAttack) {
		this.currentAttack = currentAttack;
	}

	public Attack getCurrentAttack() {
		return currentAttack;
	}

	String getExceptionMessage() {
		return exceptionMessage;
	}

	void setExceptionMessage(String msg) {
		this.exceptionMessage = msg;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void setSondiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public int getSoldiers() {
		return soldiers;
	}

}
