package com.gfi.training.gwtmvp.client;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.isA;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.gfi.training.gwtmvp.client.places.BoardPlace;
import com.gfi.training.gwtmvp.client.activities.BoardActivity;
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
	public void testIfGetActivityReturnsActivityForAPlaceThatExists() {
		
		board = new BoardPlace("Test board");
		Activity activity = testSubject.getActivity(board);
		assertThat(activity, instanceOf(BoardActivity.class));
	}
}
