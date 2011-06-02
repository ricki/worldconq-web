package com.umbrella.worldconq.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.umbrella.worldconq.WorldConqWebApp;

public abstract class WorldConqAction extends ActionSupport implements
		SessionAware {

	private static final long serialVersionUID = 6821723529422415677L;

	protected Map<String, Object> session;
	private String exceptionMessage;

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	protected boolean checkLogged() {
		if (getApp().getUserManager().getSession() == null) {
			this.setExceptionMessage("El usuario debe estar logueado.");
			return false;
		}
		return true;
	}

	protected boolean checkPlaying() {
		if (getApp().getGameManager().getGameEngine() == null) {
			this.setExceptionMessage("El usuario debe estar jugando.");
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

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

}
