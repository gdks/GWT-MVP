package com.gfi.training.gwtmvp.client;

import com.gfi.training.gwtmvp.client.activities.PersonActivity;
import com.gfi.training.gwtmvp.client.places.PersonPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {
	
	private ClientFactory clientFactory;
	
	public AppActivityMapper (ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	
	/**
	 * GWT expect a getActivity method to be defined
	 * getActvity accepts a place, we then check if it's a type of place we can do something with and if so we return an Activity
	 * Maps our places to Activities
	 */
	@Override
    public Activity getActivity(Place place) {
		 if (place instanceof PersonPlace) {
			 return new PersonActivity((PersonPlace) place, clientFactory);
		 }
		 
		 return null;
	 }
}
