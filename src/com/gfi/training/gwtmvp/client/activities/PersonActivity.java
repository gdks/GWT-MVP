package com.gfi.training.gwtmvp.client.activities;

import com.gfi.training.gwtmvp.client.ClientFactory;
import com.gfi.training.gwtmvp.client.places.PersonPlace;
import com.gfi.training.gwtmvp.client.views.PersonView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class PersonActivity extends AbstractActivity implements PersonView.Presenter {
	
	// Used to obtain views, eventBus, placeController
    // Alternatively, could be injected via GIN
	private ClientFactory clientFactory;
	
	// Name of person
	private String name;
	
	public PersonActivity(PersonPlace place, ClientFactory clientFactory) {
		this.name = place.getPersonName();
		this.clientFactory = clientFactory;
	}
	
	/**
     * Invoked by the ActivityManager to start a new Activity
     */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		PersonView personView = this.clientFactory.getPersonView();
		personView.setName(this.name);
		personView.setPresenter(this);
		containerWidget.setWidget(personView.asWidget());
	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}
}
