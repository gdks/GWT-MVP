package com.gfi.training.gwtmvp.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;

public class AppController {
	
	private Place defaultPlace;
	private SimplePanel board;
	private ClientFactory clientFactory;
	private ActivityManager activityManager;

	public AppController(Place defaultPlace, SimplePanel board, ClientFactory clientFactory) {
		this.defaultPlace = defaultPlace;
		this.board = board;
		this.clientFactory = clientFactory;
	}

	@SuppressWarnings("deprecation")
	public Panel start() {
		// EventBus is a GWT SimpleEventBus created within ClientFactory
		EventBus eventBus = clientFactory.getEventBus();
		
		// PlaceController is a GWT PlaceController created within ClientFactory but PlaceController is deprecated
		PlaceController placeController = clientFactory.getPlaceController();
		
		// A way to map each Place to some Activity and used to automatically route app to an Activity
		activityManager = clientFactory.getActivityManager();
		activityManager.setDisplay(board);
		
		// Link between PlaceTokenizers and GWT's history mechanism
		PlaceHistoryHandler historyHandler = clientFactory.getPlaceHistoryHandler();
		// Go to the place represented on URL else default place
		historyHandler.register(placeController, eventBus, defaultPlace);
		historyHandler.handleCurrentHistory();
		
		return board;
	}
}
