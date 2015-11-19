package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import java.util.List;

import sn.hubsocial.avisjournaux.backoffice.client.DTO.AvisDTO;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Objet;
import gwt.material.design.client.custom.MaterialSuggestionOracle;
import gwt.material.design.client.ui.MaterialAutoComplete;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialToast;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AvisFormDataGrid extends Composite {

	private static ModalContentUiBinder uiBinder = GWT.create(ModalContentUiBinder.class);

	interface ModalContentUiBinder extends UiBinder<Widget, AvisFormDataGrid> {
	}
	String structtitre[] = {"titre","AVIS D'APPEL D'OFFRES OUVERT","AVIS DE DEMANDE DE RENSEIGNEMENTS ET DE PRIX OUVERT","AVIS D'ATTRIBUTION PROVISOIRE DE MARCHE"};
	String structtype[]= {"Paru dans le Soleil","Paru dans l'Observateur","Paru dans le SUD Quotidien"};
	private AvisDataGrid avisDataGridTempon;
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
		structure.getItemValues();

	}
	public AvisFormDataGrid(AvisDataGrid avisDataGrid) {
		initWidget(uiBinder.createAndBindUi(this));
		for (int i = 0; i < structtype.length; i++) {
			type.addItem(structtype[i]);
		}
		for (int i = 0; i < structtitre.length; i++) {
			titre.addItem(structtitre[i]);
		}		
		titre.setValue(0, null);
		
		structure.setSuggestions(getSuggestions());
		structure.getItemValues();
		this.avisDataGridTempon = avisDataGrid;

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
		//recuperation des valeurs saisies
		int indexTitre = titre.getSelectedIndex();		
		String titreSaisi = titre.getItemText(indexTitre);		
		List<String> structureSaisi = structure.getItemValues();						
		//String nomImg= fichierimage.getFilename();		
		String resumeSaisi = resume.getText().toUpperCase();				
		int indexType = type.getSelectedIndex();		
		String typeSaisi = type.getItemText(indexType);
		if (indexTitre == -1) {
			MaterialToast.alert("Titre requis");
			return;
		}
		else if (structureSaisi.isEmpty() ) {
			structure.setError("Structure requise ");
			return;
		}
		else if ("".equals(resumeSaisi)) {
			structure.setSuccess("valide");
			resume.setError("Structure requise ");
			return;
		}
		else if (indexType == -1) {
			structure.setSuccess("valide");
			resume.setSuccess("valide");
			MaterialToast.alert("Quotidien requis");
			return;
		}
		
		MaterialToast.alert("OK");
//		Enregistrement dans la base de données
		Objet avis = new Objet();
		avis.setName(titreSaisi);
		avis.setDescription(resumeSaisi);
		//avis.setOrganisationId(organisationId);
		//avis.setCreator(typeSaisi);
		AvisDTO.save(avis,avisDataGridTempon);
		//MaterialModal.closeModal();
	}
	
	@UiHandler("btnDisagree")
	void onDisagree(ClickEvent e) {
		MaterialModal.closeModal();
	}
}
