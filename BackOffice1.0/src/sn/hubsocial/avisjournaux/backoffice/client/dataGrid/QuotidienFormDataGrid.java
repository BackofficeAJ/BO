package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import java.util.List;

import sn.hubsocial.avisjournaux.backoffice.client.DTO.QuotidienDTO;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.StructureDTO;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Organisation;
import sn.hubsocial.avisjournaux.backoffice.client.entities.UserApplication;
import gwt.material.design.client.ui.MaterialAutoComplete;
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

public class QuotidienFormDataGrid extends Composite {

	private static QuotidienFormDataGridUiBinder uiBinder = GWT.create(QuotidienFormDataGridUiBinder.class);

	interface QuotidienFormDataGridUiBinder extends UiBinder<Widget, QuotidienFormDataGrid> {
	}
	
	private QuotidienDataGrid quotidienDataGridTempon;
	private QuotidienDTO quotidienDto;
	@UiField MaterialTextBox nom;
	@UiField MaterialTextBox email;
	@UiField MaterialAutoComplete pays;
	
	
	
	public MaterialTextBox getNom() {
		return nom;
	}
	public void setNom(MaterialTextBox nom) {
		this.nom = nom;
	}
	public MaterialTextBox getEmail() {
		return email;
	}
	public void setEmail(MaterialTextBox email) {
		this.email = email;
	}
	public MaterialAutoComplete getPays() {
		return pays;
	}
	public void setPays(MaterialAutoComplete pays) {
		this.pays = pays;
	}
	public QuotidienFormDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public QuotidienFormDataGrid(QuotidienDataGrid quotidienDataGrid) {
		this();
		this.quotidienDataGridTempon = quotidienDataGrid;
		QuotidienDTO.retrievePays(this);
	}
	public QuotidienFormDataGrid(QuotidienDTO quotidienDto,QuotidienDataGrid quotidienDataGrid ){
		this();
		this.quotidienDataGridTempon = quotidienDataGrid;
		this.quotidienDto = quotidienDto;
		nom.setText(quotidienDto.getName());
		email.setText(quotidienDto.getEmail());
//TODO Modfier autocomplete PAYS
		QuotidienDTO.retrievePays(this);
		
	}

	@UiHandler("btnAgree")
	void onAgree(ClickEvent e) {
		//recuperation des valeurs saisies
		String nomSaisi = nom.getValue();
		String emailSaisi = email.getValue();
		List<String> paysSelected = pays.getItemValues();
		String paysSelected_0 = paysSelected.get(0);
		if ("".equals(nomSaisi)) {
			nom.setError("nom requis");
			return;
		}else if ("".equals(emailSaisi)) {
			nom.setSuccess("valide");
			email.setError("email requis");
			return;
		}
		else if (paysSelected.isEmpty() ) {
			pays.setError("Pays requise ");
			email.setSuccess("valide");
			return;
		}
		
		
//		Enregistrement dans la base de données
		Organisation organisation = new Organisation();
		//Window.alert(String.valueOf(quotidienDto.getId()));
		if (quotidienDto != null) {
			organisation.setId(quotidienDto.getId());
		}		
		organisation.setName(nomSaisi);
		organisation.setEmail(emailSaisi);
		for(Organisation obj : QuotidienDTO.listOrganistionPays){
			if (obj.getPays().getName() == paysSelected_0) {
				organisation.setPaysId(obj.getPaysId());
			}
		}
			
		QuotidienDTO.save(organisation,quotidienDataGridTempon);
		MaterialModal.closeModal();
		//MaterialToast.alert("OK");

	}
	
	@UiHandler("btnDisagree")
	void onDisagree(ClickEvent e) {
		MaterialModal.closeModal();
	}

}
