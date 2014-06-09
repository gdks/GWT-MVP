package com.gfi.training.gwtmvp.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class PersonPlace extends Place {
	private String token;
	
	public PersonPlace(String token) { 
		this.token = token; 
	}
	
    public String getToken() { 
    	return this.token;
    }

    public static class Tokenizer implements PlaceTokenizer<PersonPlace> {
         @Override
         public String getToken(PersonPlace place) {
        	 return place.getToken();
         }

         @Override
         public PersonPlace getPlace(String token) {
        	 return new PersonPlace(token);
         }
    }
}
