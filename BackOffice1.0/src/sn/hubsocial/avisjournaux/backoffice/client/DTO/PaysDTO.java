package sn.hubsocial.avisjournaux.backoffice.client.DTO;

import sn.hubsocial.avisjournaux.backoffice.client.JSO.PaysJSO;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Pays;

public class PaysDTO {
	private String libelle;
	private long id;
	public PaysDTO(PaysJSO pays) {
		this.libelle = pays.getName();
		this.id = pays.getId();
	}
	
	public PaysDTO(Pays pays) {
		this.libelle = pays.getName();
		this.id = pays.getId();
	}
	
	public PaysDTO() {
		super();
	}
	public PaysDTO(String libelle, long id) {
		super();
		this.libelle = libelle;
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
