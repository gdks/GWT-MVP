package com.gfi.training.gwtmvp.client;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.gfi.training.gwtmvp.client.activities.BoardActivity;
import com.gfi.training.gwtmvp.client.places.BoardPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;

@GwtModule("com.gfi.training.gwtmvp.mvp")
public class AppActivityMapperTest extends GwtTestWithMockito {

	@Mock private ClientFactoryImpl clientFactory;
	@Mock private Place mockPlace;
	@Mock private BoardPlace board;
	
	private AppActivityMapper testSubject;
	
	@Before
	public void setUp() throws Exception {
		
		testSubject = new AppActivityMapper(clientFactory);
	}

	@Test
	public void testIfGetActivityReturnsNullForANonExistantPlace() {
		
		Activity activity = testSubject.getActivity(mockPlace);
		assertNull(activity);
	}
	
	@Test
	public void testIfGetActivityReturnsNullForNoPlace() {
		
		Activity activity = testSubject.getActivity(null);
		assertNull(activity);
	}
	
	@Test
	public void testIfGetActivityReturnsActivityForAPlaceThatExists() {
		
		board = new BoardPlace("Test board");
		Activity activity = testSubject.getActivity(board);
		assertThat(activity, instanceOf(BoardActivity.class));
	}
}
