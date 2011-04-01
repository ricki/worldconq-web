package com.umbrella.worldconq.testing;

import java.rmi.RemoteException;
import java.util.UUID;

import com.umbrella.worldconq.domain.Session;
import com.umbrella.worldconq.domain.UserManager;

import exceptions.WrongLoginException;

public class UserManagerMock extends UserManager {

	public UserManagerMock() {
		super(null);
	}

	@Override
	public void createSession(String login, String passwd) throws RemoteException, WrongLoginException {
		if (!"ricki".equals(login) || !"asdf".equals(passwd)) {
			throw new WrongLoginException("Invalid user");
		}

		mSession = new Session(UUID.randomUUID(), "ricki");
	}

}
