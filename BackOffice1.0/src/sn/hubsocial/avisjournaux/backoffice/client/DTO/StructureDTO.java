package sn.hubsocial.avisjournaux.backoffice.client.DTO;

import sn.hubsocial.avisjournaux.backoffice.client.JSO.UserApplicationJSO;
import sn.hubsocial.avisjournaux.backoffice.client.entities.UserApplication;

public class StructureDTO {


	 private static int nextId = 0;
	
	private long id;
	private String nom;
	private String numero;
	private String email;

	public StructureDTO(UserApplicationJSO structure) {
		this.id = structure.getId();
		this.nom = structure.getNom();
		this.numero = structure.getTelephone();
		this.email = structure.getEmail();
		// TODO Auto-generated constructor stub
	}
	
	public StructureDTO(UserApplication structure) {
		this.id = structure.getId();
		this.nom = structure.getNom();
		this.numero = structure.getTelephone();
		this.email = structure.getEmail();
		// TODO Auto-generated constructor stub
	}
	public StructureDTO() {
		super();
	}

	public StructureDTO( String nom, String numero,String email) {
		super();
		 nextId++;
	     this.id = nextId;
		this.nom = nom;
		this.numero = numero;
		this.email = email;
		
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
