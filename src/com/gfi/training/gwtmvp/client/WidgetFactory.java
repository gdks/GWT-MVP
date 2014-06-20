package com.gfi.training.gwtmvp.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class WidgetFactory {

	Label label;
	Button button;
	HorizontalPanel hPanel;
	
	public Label getLabel(String msg) {
		label = new Label();
		label.setText(msg);
		return label;
	}

	public Button getButton(String msg) {
		button = new Button();
		button.setText(msg);
		return button;
	}
	
	public HorizontalPanel getHorizontalPanel() {
		hPanel = new HorizontalPanel();
		return hPanel;
	}
}
