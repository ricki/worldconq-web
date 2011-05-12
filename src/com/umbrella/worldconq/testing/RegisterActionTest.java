package com.umbrella.worldconq.testing;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.opensymphony.xwork2.Action;
import com.umbrella.worldconq.actions.RegisterAction;
import com.umbrella.worldconq.domain.UserManager;
import com.umbrella.worldconq.exceptions.MalformedEmailException;

import exceptions.UserAlreadyExistsException;

public class RegisterActionTest extends TestCase {

	RegisterAction action;

	@Override
	public void setUp() {
		action = new com.umbrella.worldconq.actions.RegisterAction();

	}

	public void testRegisterAction() {
		assertNull(action.getUsername());
		assertNull(action.getPassword());
		assertNull(action.getEmail());
		assertNull(action.getSession());
	}

	public void testRegisterSuccess() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		UserManagerMock usrMgr = new UserManagerMock();
		app.setUserManager(usrMgr);
		session.put("app", app);
		action.setSession(session);
		action.setUsername("usuario");
		action.setPassword("user");
		action.setEmail("user@user.com");
		String result = null;
		try {
			result = action.execute();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertEquals(Action.SUCCESS, result);
		assertTrue(usrMgr.isRegisteruserCall());
		assertEquals(0, action.getActionErrors().size());
		assertEquals(1, action.getActionMessages().size());
	}

	public void testRegisterError() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		UserManagerMock usrMgr = new UserManagerMock();
		app.setUserManager(usrMgr);
		session.put("app", app);
		action.setSession(session);
		action.setUsername("pepe");
		action.setPassword("0000");
		action.setEmail("p@p.com");
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
		assertEquals("El usuario ya existe.",
			action.getActionErrors().toArray()[0]);
		assertTrue(usrMgr.isRegisteruserCall());
		assertEquals(1, action.getActionErrors().size());
		assertEquals(0, action.getActionMessages().size());

	}

	class UserManagerMock extends UserManager {

		private boolean isregisterusercall;

		public UserManagerMock() {
			super(null);
			isregisterusercall = false;
		}

		@Override
		public void registerUser(String login, String passwd, String email) throws RemoteException, UserAlreadyExistsException, MalformedEmailException {
			isregisterusercall = true;
			if ("pepe".equals(login)) {
				throw new UserAlreadyExistsException("ERROR");
			}

		}

		public boolean isRegisteruserCall() {
			return isregisterusercall;
		}
	}

}
