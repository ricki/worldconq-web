package com.umbrella.worldconq.testing;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import junit.framework.TestCase;

import com.opensymphony.xwork2.Action;
import com.umbrella.worldconq.actions.ListGamesAction;
import com.umbrella.worldconq.domain.GameManager;

import domain.GameInfo;
import exceptions.InvalidSessionException;

public class ListGamesActionTest extends TestCase {
	ListGamesAction action;

	@Override
	public void setUp() {
		action = new com.umbrella.worldconq.actions.ListGamesAction();
	}

	public void testConstructor() {
		assertNull(action.getOpenGames());
		assertNull(action.getCurrentGames());
	}

	public void testListGamesSuccess() {
		Map<String, Object> session = new HashMap<String, Object>();
		WorldConqWebAppMock app = null;
		try {
			app = new WorldConqWebAppMock();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		app.setGameManager(new GameManagerMock(app));
		session.put("app", app);
		action.setSession(session);
		String result = null;
		try {
			result = action.execute();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertEquals(Action.SUCCESS, result);
		assertTrue(action.getCurrentGames().size() == 1);
		assertEquals("Partida 1", action.getCurrentGames().get(0).getName());
		assertEquals("descripción p1",
			action.getCurrentGames().get(0).getDescription());
		assertEquals("Laura",
			action.getCurrentGames().get(0).getPlayers().get(0));
		assertNull(action.getCurrentGames().get(0).getGameSessions());
		assertTrue(action.getCurrentGames().get(0).getnFreeTerritories() == 1);
		assertTrue(action.getCurrentGames().get(0).getTurnTime() == 2);
		assertTrue(action.getCurrentGames().get(0).getDefenseTime() == 3);
		assertTrue(action.getCurrentGames().get(0).getNegotiationTime() == 4);

		assertTrue(action.getOpenGames().size() == 1);
		assertEquals("Partida 2", action.getOpenGames().get(0).getName());
		assertEquals("descripción p2",
			action.getOpenGames().get(0).getDescription());
		assertEquals("Laura",
			action.getOpenGames().get(0).getPlayers().get(0));
		assertNull(action.getOpenGames().get(0).getGameSessions());
		assertTrue(action.getOpenGames().get(0).getnFreeTerritories() == 4);
		assertTrue(action.getOpenGames().get(0).getTurnTime() == 3);
		assertTrue(action.getOpenGames().get(0).getDefenseTime() == 2);
		assertTrue(action.getOpenGames().get(0).getNegotiationTime() == 1);
		assertEquals(0, action.getActionErrors().size());

	}

	class GameManagerMock extends GameManager {

		public GameManagerMock(WorldConqWebAppMock app) {
			super(app.getServerAdapter(), app.getClientAdapter());

		}

		@Override
		public void updateGameList() throws RemoteException, InvalidSessionException {
			ArrayList<String> players = new ArrayList<String>();
			players.add("Laura");
			GameInfo partida1 = new GameInfo(UUID.randomUUID(), "Partida 1",
				"descripción p1",
				players, null,
				1, 2, 3, 4);
			ArrayList<GameInfo> currentGamesArray = new ArrayList<GameInfo>();
			currentGamesArray.add(partida1);
			this.getCurrentGameListModel().setData(currentGamesArray);
			GameInfo partida2 = new GameInfo(UUID.randomUUID(), "Partida 2",
				"descripción p2",
				players, null,
				4, 3, 2, 1);
			ArrayList<GameInfo> openGamesArray = new ArrayList<GameInfo>();
			openGamesArray.add(partida2);
			this.getOpenGameListModel().setData(openGamesArray);
		}
	}
}
