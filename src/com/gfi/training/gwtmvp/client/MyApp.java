package com.gfi.training.gwtmvp.client;

import com.gfi.training.gwtmvp.shared.Person;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class MyApp implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Person me = new Person();
		
		Label label = new Label("Hello, my name is " + me.getFullName());
		RootPanel.get().add(label);
	}
}
