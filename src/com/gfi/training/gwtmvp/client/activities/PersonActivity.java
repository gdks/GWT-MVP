package com.gfi.training.gwtmvp.client.activities;

import com.gfi.training.gwtmvp.client.ClientFactory;
import com.gfi.training.gwtmvp.client.places.PersonPlace;
import com.gfi.training.gwtmvp.client.views.BoardView;
import com.gfi.training.gwtmvp.shared.Person;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class PersonActivity extends AbstractActivity implements BoardView.Presenter {
	
	// Used to obtain views, eventBus, placeController
    // Alternatively, could be injected via GIN
	private ClientFactory clientFactory;
	
	// Name of person
	private Person person;
	
	public PersonActivity(PersonPlace place, ClientFactory clientFactory) {
		// Find the correct Person for the Place
		this.getPerson(place.getToken());
		
		// Store the ClientFactory as a member property so that we can use it to get the view or go to a new place
		this.clientFactory = clientFactory;
	}
	
	/**
	 * Get Person object from Place token
	 * @param token
	 */
	public void getPerson(String token) {
		String[] parts = token.split(" ");
		this.person = new Person(parts[0], parts[parts.length-1]);
	}
	
	/**
     * Invoked by the ActivityManager to start a new Activity
     */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		BoardView personView = this.clientFactory.getPersonView();
		personView.setName(this.person.getFullName());
		personView.setPresenter(this);
		containerWidget.setWidget(personView.asWidget());
	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}
}
