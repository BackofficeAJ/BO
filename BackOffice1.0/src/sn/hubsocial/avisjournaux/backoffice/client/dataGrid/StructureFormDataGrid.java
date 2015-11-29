package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import sn.hubsocial.avisjournaux.backoffice.client.DTO.StructureDTO;
import sn.hubsocial.avisjournaux.backoffice.client.entities.UserApplication;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class StructureFormDataGrid extends Composite {

	private static StructureFormDataGridUiBinder uiBinder = GWT.create(StructureFormDataGridUiBinder.class);

	interface StructureFormDataGridUiBinder extends UiBinder<Widget, StructureFormDataGrid> {
	}
	
	private StructureDataGrid structureDataGridTempon;
	private StructureDTO structureDTO;
	@UiField MaterialTextBox nom;
	@UiField MaterialTextBox numero;
	@UiField MaterialTextBox email;
	

	
	public StructureFormDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public StructureFormDataGrid(StructureDataGrid structureDataGrid) {
		this();
		this.structureDataGridTempon = structureDataGrid;
		
	}
	public StructureFormDataGrid(StructureDTO structureDTO,StructureDataGrid structureDataGrid ){
		this();
		this.structureDataGridTempon = structureDataGrid;
		this.structureDTO = structureDTO;
		nom.setText(structureDTO.getNom());
		numero.setText(structureDTO.getNumero());
		email.setText(structureDTO.getEmail());
	
	}

	@UiHandler("btnAgree")
	void onAgree(ClickEvent e) {
		//recuperation des valeurs saisies
		String nomSaisi = nom.getValue();
		String numeroSaisi = numero.getValue();
		String emailSaisi = email.getValue();
		if ("".equals(nomSaisi)) {
			nom.setError("nom requis");
			return;
		}else if ("".equals(numeroSaisi)) {
			nom.setSuccess("valide");
			numero.setError("pays requis");
			return;
		}
		else if ("".equals(emailSaisi)) {
			nom.setSuccess("valide");
			numero.setSuccess("valide");
			email.setError("mail requis");
			return;
		}
		
//		Enregistrement dans la base de données
		UserApplication structure = new UserApplication();
		//Window.alert(String.valueOf(structureDTO.getId()));
		if (structureDTO != null) {
			structure.setId(structureDTO.getId());
		}		
		structure.setNom(nomSaisi);
		structure.setTelephone(numeroSaisi);
		structure.setEmail(emailSaisi);		
		StructureDTO.save(structure,structureDataGridTempon);
		
		structureDataGridTempon.getNbreSelection();
		MaterialModal.closeModal();
		//MaterialToast.alert("OK");

	}
	
	@UiHandler("btnDisagree")
	void onDisagree(ClickEvent e) {
		MaterialModal.closeModal();
	}

}
