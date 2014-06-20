package com.gfi.training.gwtmvp.client.views;

import java.util.List;

import com.gfi.training.gwtmvp.client.places.BoardPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class BoardViewImpl extends Composite implements BoardView {
	
	interface BoardViewImplUiBinder extends UiBinder<Widget, BoardViewImpl> { }
	
	private static BoardViewImplUiBinder uiBinder = GWT.create(BoardViewImplUiBinder.class);
	
	private Presenter presenter;
	
	@UiField Button reset;
	@UiField Label toPlay;
	
	List<Button> buttons;
	
	public BoardViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public BoardViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		toPlay.setText(firstName);
		
		// instantiate button widgets
		// add buttons to 
	}

	@UiHandler(value="reset")
	void onClickFullname(ClickEvent e) {
		if(presenter != null) {
			presenter.goTo(new BoardPlace("John Smith"));
		}
	}
	
	@Override
	public void clear() {
		this.toPlay.setText("");
	}

	@Override
	public void setName(String name) {
		this.toPlay.setText(name);
	}

	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter = presenter;
	}
}
