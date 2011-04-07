package com.umbrella.worldconq.actions;

import java.rmi.RemoteException;

import com.umbrella.worldconq.exceptions.EmptyStringException;
import com.umbrella.worldconq.exceptions.MalformedEmailException;

import exceptions.UserAlreadyExistsException;

public class RegisterAction extends WorldConqAction {

	private static final long serialVersionUID = 3259341909489995346L;
	private String username;
	private String password;
	private String email;

	public RegisterAction() {
		super();
	}

	@Override
	public String execute() {
		try {
			getApp().getUserManager().registerUser(getUsername(),
				getPassword(), getEmail());
		} catch (RemoteException e) {
			this.addActionError("Error con el servidor remoto.");
			session.remove("app");
			return ERROR;
		} catch (UserAlreadyExistsException e) {
			this.addActionError("El usuario ya existe.");
			return ERROR;
		} catch (MalformedEmailException e) {
			this.addActionError("El correo es erroneo.");
			return ERROR;
		} catch (EmptyStringException e) {
			this.addActionError("No debe dejar ningún campo vacío, por favor rellénelos.");
			return ERROR;
		}
		this.addActionMessage("Usuario " + getUsername() + " registrado.");
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
