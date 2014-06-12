package com.gfi.training.gwtmvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;

public class AppController {
	
	private SimplePanel board = new SimplePanel();

	public AppController(Place defaultPlace, SimplePanel board, ClientFactory clientFactory) {
		this.board = board;
	}

	public Panel start() {
		return this.board;
	}
}
