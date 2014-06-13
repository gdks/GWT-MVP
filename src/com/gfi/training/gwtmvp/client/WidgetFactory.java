package com.gfi.training.gwtmvp.client;

import com.google.gwt.user.client.ui.Label;

public class WidgetFactory {

	Label label;
	
	public Label getLabel(String msg) {
		label = new Label();
		label.setText(msg);
		return label;
	}
}
