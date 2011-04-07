package com.umbrella.worldconq.testing;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import junit.framework.TestCase;

import com.opensymphony.xwork2.Action;
import com.umbrella.worldconq.actions.LogoutAction;
import com.umbrella.worldconq.domain.Session;
import com.umbrella.worldconq.domain.UserManager;

import exceptions.GameNotFoundException;
import exceptions.InvalidSessionException;
import exceptions.InvalidTimeException;
import exceptions.NotCurrentPlayerGameException;

public class LogoutActionTest extends TestCase {

	LogoutAction action;

	@Override
	public void setUp() {
		action = new com.umbrella.worldconq.actions.LogoutAction();
	}

	public void testLogoutSuccess() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		UserManagerMock usrMgr = new UserManagerMock();
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		usrMgr.setSession(new Session(UUID.randomUUID(), "ricki"));
		app.setUserManager(usrMgr);
		session.put("app", app);
		action.setSession(session);

		String result = action.execute();

		assertEquals(Action.SUCCESS, result);
		assertNull(usrMgr.getSession());
	}

	public void testLogoutError() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		UserManagerMock usrMgr = new UserManagerMock();
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		app.setUserManager(usrMgr);
		session.put("app", app);
		action.setSession(session);

		String result = action.execute();

		assertEquals(Action.SUCCESS, result);
		assertNull(usrMgr.getSession());
	}

	class UserManagerMock extends UserManager {

		public UserManagerMock() {
			super(null);
		}

		public void setSession(Session session) {
			mSession = session;
		}

		@Override
		public void closeSession() throws RemoteException, GameNotFoundException, InvalidSessionException, InvalidTimeException, NotCurrentPlayerGameException {
			if (mSession == null) {
				throw new InvalidSessionException("");
			} else {
				mSession = null;
			}
		}

	}

}
