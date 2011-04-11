package com.umbrella.worldconq.testing;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.opensymphony.xwork2.Action;
import com.umbrella.worldconq.actions.CreateGameAction;
import com.umbrella.worldconq.comm.ClientAdapter;
import com.umbrella.worldconq.comm.ServerAdapter;
import com.umbrella.worldconq.domain.GameManager;

import exceptions.InvalidGameInfoException;
import exceptions.InvalidSessionException;

public class CreateGameActionTest extends TestCase {

	CreateGameAction action;

	@Override
	public void setUp() {
		action = new com.umbrella.worldconq.actions.CreateGameAction();
	}

	public void testCreateGameAction() {
		assertNull(action.getName());
		assertNull(action.getDescription());
		assertNull(action.getSession());
		assertEquals(0, action.getTurnTime());
		assertEquals(0, action.getDefTime());
		assertEquals(0, action.getNegTime());
		assertEquals(0, action.getGameSessions().size());
	}

	public void testCreateGameActionSuccess() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		GameManagerMock game;
		try {
			ServerAdapter srvAdp = new ServerAdapter();
			ClientAdapter cliAdp = new ClientAdapter();
			game = new GameManagerMock(srvAdp, cliAdp);
			app.setGameManager(game);

			session.put("app", app);
			action.setSession(session);
			action.setName("Nueva partida");
			action.setDescription("datos partida");
			action.setTurnTime(60);
			action.setDefTime(60);
			action.setNegTime(30);

			ArrayList<Calendar> calendario = new ArrayList<Calendar>();
			calendario.add(Calendar.getInstance());

			action.setGameSessions(calendario);
			String result = null;
			try {
				result = action.execute();
			} catch (Exception e) {
				e.printStackTrace();
				fail(e.getMessage());
			}

			assertEquals(Action.SUCCESS, result);
			assertEquals(0, action.getActionErrors().size());
			assertEquals(1, action.getActionMessages().size());
			assertEquals("Partida creada correctamente.",
							action.getActionMessages().toArray()[0]);
			assertTrue(game.isCreateGameCall);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	public void testCreateGameActionError() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		GameManagerMock game;
		try {
			ServerAdapter srvAdp = new ServerAdapter();
			ClientAdapter cliAdp = new ClientAdapter();
			game = new GameManagerMock(srvAdp, cliAdp);
			app.setGameManager(game);

			session.put("app", app);
			action.setSession(session);
			action.setName("nombre erroneo");
			action.setDescription("datos partida");
			action.setTurnTime(60);
			action.setDefTime(60);
			action.setNegTime(30);
			ArrayList<Calendar> calendario = new ArrayList<Calendar>();
			calendario.add(Calendar.getInstance());

			action.setGameSessions(calendario);
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
			assertTrue(game.isCreateGameCall);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	class GameManagerMock extends GameManager {

		boolean isCreateGameCall;

		public GameManagerMock(ServerAdapter srvAdp, ClientAdapter cliAdp) throws RemoteException {
			super(srvAdp, cliAdp);
			isCreateGameCall = false;
		}

		@Override
		public void createGame(String name, String description, ArrayList<Calendar> gameSessions, int turnTime, int defTime, int negTime)
				throws RemoteException, InvalidGameInfoException, InvalidSessionException {

			isCreateGameCall = true;

			if (!"Nueva partida".equals(name)) {
				throw new InvalidGameInfoException("Invalid game");
			}

		}

	}

}
