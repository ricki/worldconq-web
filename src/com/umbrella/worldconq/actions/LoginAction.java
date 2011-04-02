package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import exceptions.WrongLoginException;

public class LoginAction extends WorldConqAction {

	private static final long serialVersionUID = -8287753190029594857L;

	String username;
	String password;

	@Override
	public String execute() {
		try {
			getApp().getUserManager().createSession(getUsername(),
				getPassword());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ERROR;
		} catch (WrongLoginException e) {
			this.addActionError("Usuario o contraseña incorrectos.");
			return ERROR;
		}
		session.put("user", getUsername());
		this.addActionMessage("Bienvenido <b>" + getUsername() + "</b>");
		return SUCCESS;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
