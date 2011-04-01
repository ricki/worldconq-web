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

	public WorldConqWebApp getApp() {
		WorldConqWebApp app = (WorldConqWebApp) session.get("app");
		if (app == null) {
			try {
				app = new WorldConqWebApp();
				session.put("app", app);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return app;
	}

}
