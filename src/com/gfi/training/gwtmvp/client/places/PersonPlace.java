package com.gfi.training.gwtmvp.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class PersonPlace extends Place {
	private String personName;
	
	public PersonPlace(String token) { 
		this.personName = token; 
	}
	
    public String getPersonName() { 
    	return this.personName;
    }

    public static class Tokenizer implements PlaceTokenizer<PersonPlace> {
         @Override
         public String getToken(PersonPlace place) {
        	 return place.getPersonName();
         }

         @Override
         public PersonPlace getPlace(String token) {
        	 return new PersonPlace(token);
         }
    }
}
