package com.gfi.training.gwtmvp.client;

import com.gfi.training.gwtmvp.client.places.BoardPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class MyApp implements EntryPoint {
	
	private Place defaultPlace = new BoardPlace("Gavin Stewart");
	private SimplePanel appWidget = new SimplePanel();
	private ClientFactory clientFactory = GWT.create(ClientFactory.class);
	
	@SuppressWarnings("deprecation")
	@Override
	public void onModuleLoad() {
		
		// EventBus is a GWT SimpleEventBus created within ClientFactory
		EventBus eventBus = clientFactory.getEventBus();
		
		// PlaceController is a GWT PlaceController created within ClientFactory but PlaceController is deprecated
		PlaceController placeController = clientFactory.getPlaceController();
		
		// Start ActivityManager for the main widget with our ActivityMapper
		// A way to map each Place to some Activity and used to automatically route app to an Activity
		// Activity implements presenter so an Activity is a Presenter
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(this.appWidget);
		
		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		// Link between PlaceTokenizers and GWT's history mechanism
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, this.defaultPlace);
		
		RootPanel.get().add(this.appWidget);
		// Goes to the place represented on URL else default place
		historyHandler.handleCurrentHistory();
	}
}
