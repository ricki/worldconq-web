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
			this.setErrorCode(RemoteErrorCode);
			session.remove("app");
			session.remove("user");
			return ERROR;
		} catch (InvalidSessionException e) {
			this.setErrorCode(InvalidSessionErrorCode);
			session.remove("app");
			session.remove("user");
			return ERROR;
		} catch (GameNotFoundException e) {
			this.setErrorCode(GameNotFoundErrorCode);
			return ERROR;
		} catch (NotCurrentPlayerGameException e) {
			this.setErrorCode(NotCurrentPlayerGameErrorCode);
			return ERROR;
		} catch (OutOfTurnException e) {
			this.setErrorCode(OutOfTurnErrorCode);
			return ERROR;
		} catch (NotEnoughMoneyException e) {
			this.setErrorCode(NotEnoughMoneyErrorCode);
			return ERROR;
		} catch (PendingAttackException e) {
			this.setErrorCode(PendingAttackErrorCode);
			return ERROR;
		} catch (InvalidTerritoryException e) {
			this.setErrorCode(InvalidTerritoryErrorCode);
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
