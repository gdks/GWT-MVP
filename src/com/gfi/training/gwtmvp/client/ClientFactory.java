package com.gfi.training.gwtmvp.client;

import com.gfi.training.gwtmvp.client.views.PersonView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
    PersonView getPersonView();
}
