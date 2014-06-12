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
		EventBus eventBus = this.clientFactory.getEventBus();
		
		// PlaceController is a GWT PlaceController created within ClientFactory but PlaceController is deprecated
		PlaceController placeController = this.clientFactory.getPlaceController();
		
		activityManager = this.clientFactory.getActivityManager();
		activityManager.setDisplay(this.board);
		
		PlaceHistoryHandler historyHandler = this.clientFactory.getPlaceHistoryHandler();
		historyHandler.register(placeController, eventBus, this.defaultPlace);
		
		return this.board;
	}
}
