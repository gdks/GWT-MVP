package com.gfi.training.gwtmvp.client;

import com.gfi.training.gwtmvp.client.views.BoardView;
import com.gfi.training.gwtmvp.client.views.BoardViewImpl;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;

public class ClientFactoryImpl implements ClientFactory {
    private final EventBus eventBus = new SimpleEventBus();
    @SuppressWarnings("deprecation")
	private final PlaceController placeController = new PlaceController(eventBus);
    private final BoardView boardView = new BoardViewImpl();
    private final ActivityMapper activityMapper = new AppActivityMapper(this);

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}
	
	@Override
	public BoardView getBoardView() {
		return boardView;
	}

	@Override
	public ActivityMapper getActivityMapper() {
		return activityMapper;
	}

	@Override
	public ActivityManager getActivityManager() {
		getActivityMapper();
		
		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		return activityManager;
	}
	
	@Override
	public PlaceHistoryHandler getPlaceHistoryHandler() {
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		
		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		return historyHandler;
	}
}
