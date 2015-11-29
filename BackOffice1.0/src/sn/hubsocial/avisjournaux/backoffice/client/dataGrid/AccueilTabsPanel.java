package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;


import gwt.material.design.client.ui.MaterialTabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class AccueilTabsPanel extends Composite {

	private static MaterialTabsPanelUiBinder uiBinder = GWT.create(MaterialTabsPanelUiBinder.class);
	
	@UiField HTMLPanel content, content0, content1, content2;

	interface MaterialTabsPanelUiBinder extends UiBinder<Widget, AccueilTabsPanel> {
	}

	@UiField MaterialTabs tab2;
	
	public AccueilTabsPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		AnnonceDataGrid panelAnnonce = new AnnonceDataGrid();
		QuotidienDataGrid panelQuotidien = new QuotidienDataGrid();
		StructureDataGrid panelStructure =new StructureDataGrid();
		AvisDataGrid panelAvis= new AvisDataGrid();
		content.add(panelAnnonce);
		content0.add(panelQuotidien);
		content1.add(panelStructure);
		content2.add(panelAvis);
		tab2.setTabIndex(3);
	}

}
