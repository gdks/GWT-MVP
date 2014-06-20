package com.gfi.training.gwtmvp.client.views;

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
	
	@UiField Button btnOne;
	@UiField Button btnTwo;
	@UiField Button btnThree;
	@UiField Button btnFour;
	@UiField Button btnFive;
	@UiField Button btnSix;
	@UiField Button btnSeven;
	@UiField Button btnEight;
	@UiField Button btnNine;
	
	public BoardViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public BoardViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		toPlay.setText(firstName);
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
