package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.custom.MaterialSuggestionOracle;
import gwt.material.design.client.ui.MaterialAutoComplete;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextArea;

public class AvisFormDataGrid extends Composite {

	private static ModalContentUiBinder uiBinder = GWT.create(ModalContentUiBinder.class);

	interface ModalContentUiBinder extends UiBinder<Widget, AvisFormDataGrid> {
	}
	String structtitre[] = {"titre","AVIS D'APPEL D'OFFRES OUVERT","AVIS DE DEMANDE DE RENSEIGNEMENTS ET DE PRIX OUVERT","AVIS D'ATTRIBUTION PROVISOIRE DE MARCHE"};
	String structtype[]= {"Paru dans le Soleil","Paru dans l'Observateur","Paru dans le SUD Quotidien"};

	@UiField MaterialListBox titre;
	@UiField MaterialAutoComplete structure;
	@UiField MaterialTextArea resume;
	@UiField MaterialListBox type;
	
	public AvisFormDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
		for (int i = 0; i < structtype.length; i++) {
			type.addItem(structtype[i]);
		}
		for (int i = 0; i < structtitre.length; i++) {
			titre.addItem(structtitre[i]);
		}		
		titre.setValue(0, null);
		
		structure.setSuggestions(getSuggestions());
		//MaterialDropDown test = new MaterialDropDown(name, belowOrigin, constraintWidth)
	}
	  private MaterialSuggestionOracle getSuggestions() {
	        MaterialSuggestionOracle suggestions = new MaterialSuggestionOracle(); suggestions.add("Alabama");
	        suggestions.add("Alaska");
	        suggestions.add("Arizona");
	        suggestions.add("Arkansas");
	        suggestions.add("California");
	        suggestions.add("Colorado");
	        suggestions.add("Connecticut");
	        suggestions.add("Delaware");
	        
	        return suggestions;
	    }
	
	
	@UiHandler("btnAgree")
	void onAgree(ClickEvent e) {
		new AvisDataGrid().refreshData();
	}
	
	@UiHandler("btnDisagree")
	void onDisagree(ClickEvent e) {
		MaterialModal.closeModal();
	}
}
