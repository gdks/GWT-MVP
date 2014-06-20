package com.gfi.training.gwtmvp.client;

import com.gfi.training.gwtmvp.client.places.BoardPlace;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class MyApp implements EntryPoint {
	
	private SimplePanel appWidget;
	private AppController game;
	
	@Override
	public void onModuleLoad() {
		
		// Initialise AppController
		game = new AppController(
				new BoardPlace("Gavin Stewart"), // default place
				new SimplePanel(), // main panel
				new ClientFactoryImpl() // factory to produce all objects
				);
		
		// Get the game board
		appWidget = (SimplePanel) game.start();
		
		// Add the game board to the interface
		RootPanel.get().add(appWidget);

	}
}
