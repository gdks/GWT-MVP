package com.gfi.training.gwtmvp.client;

import com.gfi.training.gwtmvp.client.views.PersonView;
import com.gfi.training.gwtmvp.client.views.PersonViewImpl;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {
    private final EventBus eventBus = new SimpleEventBus();
    @SuppressWarnings("deprecation")
	private final PlaceController placeController = new PlaceController(eventBus);
    private final PersonView personView = new PersonViewImpl();

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}
	
	@Override
	public PersonView getPersonView() {
		
		// PersonView defined in com.gfi.training.gwtmvp.client.views.PersonViewImpl.java
		return personView;
	}
}
