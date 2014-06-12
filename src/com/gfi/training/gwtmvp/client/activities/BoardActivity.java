package com.gfi.training.gwtmvp.client.activities;

import com.gfi.training.gwtmvp.client.ClientFactory;
import com.gfi.training.gwtmvp.client.places.BoardPlace;
import com.gfi.training.gwtmvp.client.views.BoardView;
import com.gfi.training.gwtmvp.shared.Board;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class BoardActivity extends AbstractActivity implements BoardView.Presenter {
	
	// Used to obtain views, eventBus, placeController
    // Alternatively, could be injected via GIN
	private ClientFactory clientFactory;
	
	// Name of board
	private Board board;
	
	public BoardActivity(BoardPlace place, ClientFactory clientFactory) {
		// Find the correct Board for the Place
		this.getBoard(place.getToken());
		
		// Store the ClientFactory as a member property so that we can use it to get the view or go to a new place
		this.clientFactory = clientFactory;
	}
	
	/**
	 * Get Board object from Place token
	 * @param token
	 */
	public void getBoard(String token) {
		String[] parts = token.split(" ");
		this.board = new Board(parts[0], parts[parts.length-1]);
	}
	
	/**
     * Invoked by the ActivityManager to start a new Activity
     */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		BoardView boardView = this.clientFactory.getBoardView();
		boardView.setName(this.board.getFullName());
		boardView.setPresenter(this);
		containerWidget.setWidget(boardView.asWidget());
	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}
}
