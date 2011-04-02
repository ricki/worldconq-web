package com.umbrella.worldconq.testing;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import junit.framework.TestCase;

import com.opensymphony.xwork2.Action;
import com.umbrella.worldconq.actions.LoginAction;
import com.umbrella.worldconq.domain.Session;
import com.umbrella.worldconq.domain.UserManager;

import exceptions.WrongLoginException;

public class LoginActionTest extends TestCase {

	LoginAction action;

	@Override
	public void setUp() {
		action = new com.umbrella.worldconq.actions.LoginAction();
	}

	public void testConstructor() {
		assertNull(action.getUsername());
		assertNull(action.getPassword());
		assertNull(action.getSession());
	}

	public void testLoginSuccess() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		app.setUserManager(new UserManagerMock());
		session.put("app", app);
		action.setSession(session);
		action.setUsername("ricki");
		action.setPassword("asdf");
		String result = null;
		try {
			result = action.execute();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertEquals(Action.SUCCESS, result);
		assertEquals("ricki",
				action.getApp().getUserManager().getSession().getUser());
		assertEquals("ricki", action.getSession().get("user"));
		assertEquals(0, action.getActionErrors().size());
		assertEquals(1, action.getActionMessages().size());
	}

	public void testLoginError() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		app.setUserManager(new UserManagerMock());
		session.put("app", app);
		action.setSession(session);
		action.setUsername("paco");
		action.setPassword("asdf");
		String result = null;
		try {
			result = action.execute();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertEquals(Action.ERROR, result);
		assertNull(action.getApp().getUserManager().getSession());
		assertFalse(action.getSession().containsKey("user"));
		assertEquals(1, action.getActionErrors().size());
		assertEquals(0, action.getActionMessages().size());
	}

	class UserManagerMock extends UserManager {

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

}
