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
    private final BoardView personView = new BoardViewImpl();
    ActivityMapper activityMapper = new AppActivityMapper(this);

    @Override
    public EventBus getEventBus() {
        return this.eventBus;
    }

	@Override
	public PlaceController getPlaceController() {
		return this.placeController;
	}
	
	@Override
	public BoardView getPersonView() {
		return this.personView;
	}

	@Override
	public ActivityMapper getActivityMapper() {
		return this.activityMapper;
	}

	@Override
	public ActivityManager getActivityManager() {
		this.getActivityMapper();
		ActivityManager activityManager = new ActivityManager(this.activityMapper, this.eventBus);
		return activityManager;
	}
	
	@Override
	public PlaceHistoryHandler getPlaceHistoryHandler() {
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		return historyHandler;
	}
}
