package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import java.util.List;

import sn.hubsocial.avisjournaux.backoffice.client.DTO.AvisDTO;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.QuotidienDTO;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.StructureDTO;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Objet;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Organisation;
import sn.hubsocial.avisjournaux.backoffice.client.entities.UserApplication;
import gwt.material.design.client.custom.MaterialSuggestionOracle;
import gwt.material.design.client.ui.MaterialAutoComplete;
import gwt.material.design.client.ui.MaterialFileInput;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
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
	
	String nomAvis[] = {"Nom","AVIS D'APPEL D'OFFRES OUVERT","AVIS DE DEMANDE DE RENSEIGNEMENTS ET DE PRIX OUVERT","AVIS D'ATTRIBUTION PROVISOIRE DE MARCHE"};
	
	private AvisDataGrid avisDataGridTempon;
	private int page = 0;
	private int offset = 10;
	private MaterialSuggestionOracle suggestions;
	private AvisDTO avisDTO;
	private Long id;
	

	@UiField MaterialListBox nom;
	@UiField MaterialAutoComplete structure;
	@UiField MaterialTextBox titre;
	@UiField MaterialTextArea resume;
	@UiField MaterialAutoComplete typeQuot;
	@UiField MaterialFileInput fichierPDF;
	
	
	public MaterialAutoComplete getTypeQuot() {
		return typeQuot;
	}
	public void setTypeQuot(MaterialAutoComplete typeQuot) {
		this.typeQuot = typeQuot;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public AvisFormDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
		for (int i = 0; i < nomAvis.length; i++) {
			nom.addItem(nomAvis[i]);
		}		
		nom.setValue(0, null);
	}
	
	
	public AvisFormDataGrid(AvisDataGrid avisDataGrid) {
		this();
		this.avisDataGridTempon = avisDataGrid;
		StructureDTO.retrieveStructure(this);
		QuotidienDTO.retrieveQuotidien(this);
	}
	
	public AvisFormDataGrid(AvisDTO avisDTO, AvisDataGrid avisDataGrid ){
		this();
		this.avisDataGridTempon = avisDataGrid;
		this.avisDTO = avisDTO;
		nom.setItemText(0, avisDTO.getNom());
		resume.setText(avisDTO.getResume());
		id = avisDTO.getId();
		StructureDTO.retrieveStructure(this);
		QuotidienDTO.retrieveQuotidien(this);
		
		
	}
	
	 public MaterialAutoComplete getStructure() {
		return structure;
	}
	public void setStructure(MaterialAutoComplete structure) {
		this.structure = structure;
	}
	
	@UiHandler("btnAgree")
	void onAgree(ClickEvent e) {
		//recuperation des valeurs saisies
		int indexNom = nom.getSelectedIndex();		
		String nomSaisi = nom.getItemText(indexNom);		
		List<String> structureSelected = structure.getItemValues();
		String structureSelected_0 = structureSelected.get(0);	
		String titreSelected = titre.getValue();
		String resumeSaisi = resume.getText().toUpperCase();
		
		List<String> quotidienSelected = typeQuot.getItemValues();
		String quotidienSelected_0 = quotidienSelected.get(0);
		
		if (indexNom == -1) {
			MaterialToast.alert("Nom requis");
			return;
		}
		else if (structureSelected.isEmpty() ) {
			structure.setError("Structure requise ");
			return;
		}
		else if ("".equals(titreSelected)) {
			structure.setSuccess("valide");
			titre.setError("Titre requis ");
		}
		else if ("".equals(resumeSaisi)) {
			structure.setSuccess("valide");
			titre.setSuccess("valide");
			resume.setError("Structure requise ");
			return;
		}
		
		else if (quotidienSelected.isEmpty()) {
			structure.setSuccess("valide");
			titre.setSuccess("valide");
			resume.setSuccess("valide");
			typeQuot.setError("Quotidien requis");
			return;
		}
		
//		MaterialToast.alert("OK");
//		Enregistrement dans la base de données
		Objet avis = new Objet();
		if (avisDTO != null) {
			
			avis.setId(id);
		}	
		
		avis.setName(nomSaisi);
		
		for(UserApplication obj : StructureDTO.listUserApplication){
			if (obj.getNom() == structureSelected_0) {
				avis.setCreatorId(obj.getId());
			}
		}
		
		avis.setDescription(resumeSaisi);
		
		for(Organisation obj : QuotidienDTO.listOrganistion){
			if (obj.getName() == quotidienSelected_0) {
				avis.setOrganisationId(obj.getId());
				avis.setOrganisation(obj);
			}
		}
		
		
		AvisDTO.save(avis,avisDataGridTempon);
		MaterialModal.closeModal();
	}
	
	@UiHandler("btnDisagree")
	void onDisagree(ClickEvent e) {
		MaterialModal.closeModal();
	}
}
