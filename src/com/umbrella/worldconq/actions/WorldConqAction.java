package com.umbrella.worldconq.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.umbrella.worldconq.WorldConqWebApp;

public abstract class WorldConqAction extends ActionSupport implements
		SessionAware {

	private static final long serialVersionUID = 6821723529422415677L;

	protected Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	protected boolean checkLogged() {
		if (getApp().getUserManager().getSession() == null) {
			this.addActionError("El ususario debe estar logueado.");
			session.remove("app");
			session.remove("user");
			return false;
		} else
			return true;
	}

	protected boolean checkPlaying() {
		if (getApp().getGameManager().getGameEngine() == null) {
			this.addActionError("El ususario debe estar jugando.");
			session.remove("app");
			session.remove("user");
			return false;
		} else
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

}
