package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import com.opensymphony.xwork2.Action;

public class LogoutAction extends WorldConqAction {

	private static final long serialVersionUID = -1664426206769813099L;

	@Override
	public String execute() {
		try {
			this.getApp().getUserManager().closeSession();
		} catch (RemoteException e) {
			e.printStackTrace();
			this.addActionError("Error con el servidor remoto.");
			session.remove("app");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

}
