package com.umbrella.worldconq.testing;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.opensymphony.xwork2.Action;
import com.umbrella.worldconq.actions.LoginAction;

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
			fail(e.getMessage());
		}
		session.put("app", app);
		action.setSession(session);
		action.setUsername("ricki");
		action.setPassword("asdf");
		String result = null;
		try {
			result = action.execute();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(result, Action.SUCCESS);
		assertEquals("ricki",
				action.getApp().getUserManager().getSession().getUser());
		assertEquals("ricki", session.get("user"));
	}

	public void testLoginError() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		session.put("app", app);
		action.setSession(session);
		action.setUsername("paco");
		action.setPassword("asdf");
		String result = null;
		try {
			result = action.execute();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(result, Action.ERROR);
		assertNull(action.getApp().getUserManager().getSession());
	}
}
