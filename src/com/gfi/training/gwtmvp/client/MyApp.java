package com.gfi.training.gwtmvp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class MyApp implements EntryPoint {
	
	private SimplePanel appWidget;
	private AppController game;
	
	@Override
	public void onModuleLoad() {
		
		// Get the game board
		appWidget = (SimplePanel) game.start();
		
		// Add the game board to the interface
		RootPanel.get().add(appWidget);

	}
}
