package com.gfi.training.gwtmvp.client.places;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;

@GwtModule("com.gfi.training.gwtmvp.mvp")
public class BoardPlaceTokenizerTest extends GwtTestWithMockito {
	
	@Test
	public void testGetPlace() {
		BoardPlace.Tokenizer testSubject = new BoardPlace.Tokenizer();
		BoardPlace result = testSubject.getPlace("Gavin Stewart");
		
		assertEquals("Gavin Stewart", result.getToken());
	}
	
	@Test
	public void testGetToken() {
		BoardPlace.Tokenizer testSubject = new BoardPlace.Tokenizer();
		String result = testSubject.getToken(new BoardPlace("Gavin Stewart"));
		assertEquals("Gavin Stewart", result);
	}

}
