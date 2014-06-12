package com.gfi.training.gwtmvp.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BoardPlace extends Place {
	private String token;
	
	public BoardPlace(String token) { 
		this.token = token; 
	}
	
    public String getToken() { 
    	return this.token;
    }

    public static class Tokenizer implements PlaceTokenizer<BoardPlace> {
         @Override
         public String getToken(BoardPlace place) {
        	 return place.getToken();
         }

         @Override
         public BoardPlace getPlace(String token) {
        	 return new BoardPlace(token);
         }
    }
}
