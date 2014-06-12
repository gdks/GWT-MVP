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

	private static BoardViewImplUiBinder uiBinder = GWT
			.create(BoardViewImplUiBinder.class);
	
	interface BoardViewImplUiBinder extends UiBinder<Widget, BoardViewImpl> {
	}
	
	@UiField
	Button button;
	@UiField
	Label name;
	
	private Presenter presenter;
	
	public BoardViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public BoardViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler(value="button")
	void onClickFullname(ClickEvent e) {
		if(presenter != null) {
			presenter.goTo(new BoardPlace("John Smith"));
		}
	}
	
	@Override
	public void clear() {
		this.name.setText("");
	}

	@Override
	public void setName(String name) {
		this.name.setText(name);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
