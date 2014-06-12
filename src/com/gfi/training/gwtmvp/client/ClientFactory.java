package com.gfi.training.gwtmvp.client;

import com.gfi.training.gwtmvp.client.views.BoardView;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
    BoardView getPersonView();
    ActivityManager getActivityManager();
    ActivityMapper getActivityMapper();
    PlaceHistoryHandler getPlaceHistoryHandler();
}
