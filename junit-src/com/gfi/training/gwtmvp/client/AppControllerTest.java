package com.gfi.training.gwtmvp.client;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
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
	
	private Place defaultPlace = new BoardPlace();
	
	private AppController testSubject;
	
	@Before
	public void setUp() throws Exception {
		
		//set up ClientFactory mock
		when(clientFactory.getEventBus()).thenReturn(eventBus);
		when(clientFactory.getPlaceController()).thenReturn(placeController);
		when(clientFactory.getActivityMapper()).thenReturn(activityMapper);
		when(clientFactory.getActivityManager()).thenReturn(activityManager);
		when(clientFactory.getPlaceHistoryHandler()).thenReturn(placeHistoryHandler);
		
		testSubject = new AppController(defaultPlace, board, clientFactory);
	}
	
	@Test
	public void testStartGameReturnsAPanel() {
		assertThat(testSubject.start(), instanceOf(SimplePanel.class));
	}
	
	@Test
	public void testGameSetsBoardAsView() {
		board = (SimplePanel) testSubject.start();
		verify(activityManager).setDisplay(board);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testHistoryHandlerIsSetUp() {
		board = (SimplePanel) testSubject.start();
		verify(placeHistoryHandler).register(placeController, eventBus, defaultPlace);
	}
}
