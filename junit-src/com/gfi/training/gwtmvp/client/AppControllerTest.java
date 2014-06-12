package com.gfi.training.gwtmvp.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.SimplePanel;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;

@GwtModule("com.gfi.training.gwtmvp.mvp")
public class AppControllerTest extends GwtTestWithMockito {

	@Mock private ClientFactoryImpl clientFactory;
	@Mock private SimplePanel board;
	@Mock private Place defaultPlace;
	@Mock private BoardView boardView;
	
	private AppController game;
	
	@Before
	public void setUp() throws Exception {
		game = new AppController(defaultPlace, board, clientFactory);
	}
	
	@Test
	public void testStartGame() {
		assertEquals(board, game.start());
	}
	
	@Test
	public void testGameHasBoard() {
		game.start();
		assertEquals(boardView, this.board.getWidget());
	}
}
