package com.gfi.training.gwtmvp.client;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.gfi.training.gwtmvp.client.places.BoardPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.SimplePanel;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;

@GwtModule("com.gfi.training.gwtmvp.mvp")
public class AppControllerTest extends GwtTestWithMockito {

	@Mock private ClientFactoryImpl clientFactory;
	@Mock private SimplePanel board;
	@Mock private EventBus eventBus;
	@Mock private ActivityManager activityManager;
	@Mock private ActivityMapper activityMapper;
	@Mock private PlaceHistoryHandler placeHistoryHandler;
	@Mock private PlaceController placeController;
	
	private Place defaultPlace = new BoardPlace("Gavin Stewart");
	
	private AppController game;
	
	@Before
	public void setUp() throws Exception {
		
		//set up ClientFactory mock
		when(clientFactory.getEventBus()).thenReturn(eventBus);
		when(clientFactory.getPlaceController()).thenReturn(placeController);
		when(clientFactory.getActivityMapper()).thenReturn(activityMapper);
		when(clientFactory.getActivityManager()).thenReturn(activityManager);
		when(clientFactory.getPlaceHistoryHandler()).thenReturn(placeHistoryHandler);
		
		this.game = new AppController(defaultPlace, board, clientFactory);
	}
	
	@Test
	public void testStartGame() {
		assertEquals(board, this.game.start());
	}
	
	@Test
	public void testGameSetsBoard() {
		board = (SimplePanel) this.game.start();
		verify(activityManager).setDisplay(board);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testHistoryHandlerIsSetUp() {
		board = (SimplePanel) this.game.start();
		verify(placeHistoryHandler).register(placeController, eventBus, defaultPlace);
	}
}
