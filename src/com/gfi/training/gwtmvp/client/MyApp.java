package com.gfi.training.gwtmvp.client;

import com.gfi.training.gwtmvp.client.presenters.PersonPresenter;
import com.gfi.training.gwtmvp.client.presenters.PersonPresenter.Display;
import com.gfi.training.gwtmvp.client.presenters.Presenter;
import com.gfi.training.gwtmvp.client.views.PersonView;
import com.gfi.training.gwtmvp.shared.Person;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class MyApp implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Person me = new Person();
		Display view = new PersonView();
		Presenter presenter = new PersonPresenter(me, view);
		presenter.go(RootPanel.get());
	}
}
