package com.gfi.training.gwtmvp.client.views;

import com.gfi.training.gwtmvp.client.places.PersonPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class PersonViewImpl extends Composite implements PersonView {

	private static PersonViewImplUiBinder uiBinder = GWT
			.create(PersonViewImplUiBinder.class);
	
	interface PersonViewImplUiBinder extends UiBinder<Widget, PersonViewImpl> {
	}
	
	@UiField
	Button button;
	@UiField
	Label name;
	
	private Presenter presenter;
	
	public PersonViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public PersonViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler(value="button")
	void onClickFullname(ClickEvent e) {
		if(presenter != null) {
			presenter.goTo(new PersonPlace(this.name.getText() + ", Gavin"));
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
