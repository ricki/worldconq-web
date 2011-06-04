package com.umbrella.worldconq.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.umbrella.worldconq.WorldConqWebApp;

public abstract class WorldConqAction extends ActionSupport implements
		SessionAware {

	private static final long serialVersionUID = 6821723529422415677L;

	protected Map<String, Object> session;

	private int errorCode;

	public static final int RemoteErrorCode = 1;
	public static final int InvalidSessionErrorCode = 2;
	public static final int GameNotFoundErrorCode = 3;
	public static final int NotCurrentPlayerGameErrorCode = 4;
	public static final int OutOfTurnErrorCode = 5;
	public static final int PendingAttackErrorCode = 6;
	public static final int NotEnoughMoneyErrorCode = 7;
	public static final int OcupiedTerritoryErrorCode = 8;
	public static final int InvalidTerritoryErrorCode = 9;

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	protected boolean checkLogged() {
		if (getApp().getUserManager().getSession() == null) {
			this.addActionError("El usuario debe estar logueado.");
			setErrorCode(InvalidSessionErrorCode);
			return false;
		}
		return true;
	}

	protected boolean checkPlaying() {
		if (getApp().getGameManager().getGameEngine() == null) {
			this.addActionError("El usuario debe estar jugando.");
			setErrorCode(GameNotFoundErrorCode);
			return false;
		}
		return true;
	}

	protected boolean checkCurrentAttack() {
		if (getApp().getGameManager().getGameEngine().getCurrentAttack() == null) {
			this.addActionError("No hay ataque en curso.");
			return false;
		}
		return true;
	}

	public WorldConqWebApp getApp() {
		WorldConqWebApp app = (WorldConqWebApp) session.get("app");
		if (app == null) {
			app = new WorldConqWebApp();
			session.put("app", app);
			session.remove("user");
		}
		return app;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
