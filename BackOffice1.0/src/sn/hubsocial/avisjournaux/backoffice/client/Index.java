package sn.hubsocial.avisjournaux.backoffice.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import sn.hubsocial.avisjournaux.backoffice.client.Index.IndexUiBinder;
import sn.hubsocial.avisjournaux.backoffice.client.dataGrid.MaterialTabsPanel;

public class Index extends Composite {

private static IndexUiBinder uiBinder = GWT.create(IndexUiBinder.class);
	
	@UiField HTMLPanel content;

	interface IndexUiBinder extends UiBinder<Widget, Index> {	
		
	}

	public Index() {
		initWidget(uiBinder.createAndBindUi(this));
		MaterialTabsPanel menuBarr = new MaterialTabsPanel(); 
		content.add(menuBarr);
	}


}
