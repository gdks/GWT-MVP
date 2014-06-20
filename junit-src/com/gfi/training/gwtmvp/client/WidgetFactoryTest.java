package com.gfi.training.gwtmvp.client;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;

@GwtModule("com.gfi.training.gwtmvp.mvp")
public class WidgetFactoryTest extends GwtTestWithMockito {

	@Mock private Label label;
	
	private WidgetFactory testSubject;
	
	@Before
	public void setUp() throws Exception {
		
		testSubject = new WidgetFactory();
	}
	
	@Test
	public void testGettingALabelWithString() {
		
		Label lbl = testSubject.getLabel("Test");
		assertThat(lbl, instanceOf(Label.class));
	}
	
	@Test
	public void testGettingALabelWithNull() {
		Label lbl = testSubject.getLabel(null);
		assertThat(lbl, instanceOf(Label.class));
		assertEquals(lbl.getText(), "");
	}
	
	@Test
	public void testGettingAButtonWithString() {
		Button btn = testSubject.getButton("Click here");
		assertThat(btn, instanceOf(Button.class));
		assertEquals(btn.getText(), "Click here");
	}
	
	@Test
	public void testGettingAButtonWithNull() {
		Button btn = testSubject.getButton(null);
		assertThat(btn, instanceOf(Button.class));
		assertEquals(btn.getText(), "");
	}
	
	@Test
	public void testGettingAHorizontalPanel() {
		HorizontalPanel btn = testSubject.getHorizontalPanel();
		assertThat(btn, instanceOf(HorizontalPanel.class));
	}

}
