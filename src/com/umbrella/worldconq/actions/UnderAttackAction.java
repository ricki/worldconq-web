package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import com.umbrella.worldconq.domain.Attack;
import com.umbrella.worldconq.exceptions.NotEnoughMoneyException;
import com.umbrella.worldconq.exceptions.NotEnoughUnitsException;
import com.umbrella.worldconq.exceptions.OutOfTurnException;

import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.InvalidTimeException;

public class UnderAttackAction extends WorldConqAction {

	private static final long serialVersionUID = -7228418678746042546L;
	private Attack currentAttack;
	private int money;
	private int soldiers;

	public String show() {
		if (!checkLogged() || !checkPlaying() || !checkCurrentAttack())
			return ERROR;
		setCurrentAttack(getApp().getGameManager().getGameEngine().getCurrentAttack());
		return SUCCESS;
	}

	public String executeAttack() {
		try {
			getApp().getGameManager().getGameEngine().acceptAttack();
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
		} catch (InvalidTimeException e) {
			this.setExceptionMessage("Tiempo no válido.");
			return ERROR;
		} catch (OutOfTurnException e) {
			this.setExceptionMessage("Accion realizada fuera de turno.");
			return ERROR;
		}
		return SUCCESS;
	}

	public String executeNegotiation() {
		try {
			getApp().getGameManager().getGameEngine().requestNegotiation(
					getMoney(), getSoldiers());
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
		} catch (InvalidTimeException e) {
			this.setExceptionMessage("Tiempo no válido.");
			return ERROR;
		} catch (OutOfTurnException e) {
			this.setExceptionMessage("Accion realizada fuera de turno.");
			return ERROR;
		} catch (NotEnoughMoneyException e) {
			this.setExceptionMessage("No tienes dinero suficiente para la acción seleccionada");
			return ERROR;
		} catch (NotEnoughUnitsException e) {
			this.setExceptionMessage("No tienes soldados suficiente para la acción seleccionada");
			return ERROR;
		}
		return SUCCESS;
	}

	public void setCurrentAttack(Attack currentAttack) {
		this.currentAttack = currentAttack;
	}

	public Attack getCurrentAttack() {
		return currentAttack;
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
