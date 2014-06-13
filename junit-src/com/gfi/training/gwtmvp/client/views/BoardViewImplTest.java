package com.gfi.training.gwtmvp.client.views;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;

@GwtModule("com.gfi.training.gwtmvp.mvp")
public class BoardViewImplTest extends GwtTestWithMockito {

	private BoardViewImpl testSubject;
	
	@Mock private BoardViewImpl.Presenter presenter;
	@Mock private Button button;
	@Mock private Label label;
	
	@Before
	public void setUp() throws Exception {
		testSubject = new BoardViewImpl();
		testSubject.name = label;
		testSubject.setPresenter(presenter);
	}

	@Test
	public void testClear() {
		testSubject.clear();
		verify(testSubject.name).setText("");
	}
	
	@Test
	public void testSettingAName() {
		testSubject.setName("Gavin Stewart");
		verify(testSubject.name).setText("Gavin Stewart");
	}

	@Override
	public String getHostPagePath(String moduleFullQualifiedName) {
		return "war/index.html";
	}
}
