package sn.hubsocial.avisjournaux.backoffice.client.DTO;

import sn.hubsocial.avisjournaux.backoffice.client.JSO.OrganisationJSO;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Organisation;

public class QuotidienDTO {
	
	private String name;
	private String email;
	private PaysDTO pays;
	
	public QuotidienDTO(OrganisationJSO org) {
		this.name = org.getName();
		this.email = org.getEmail();
		if (org.getPays() != null) {
			this.pays = new PaysDTO(org.getPays());
		}
		
	}
	
	public QuotidienDTO(Organisation org) {
		this.name = org.getName();
		this.email = org.getEmail();
		if (org.getPays() != null) {
			this.pays = new PaysDTO(org.getPays());
		}
		
	}
	public QuotidienDTO() {
		super();
	}
	public QuotidienDTO(String name, String email, PaysDTO pays) {
		super();
		this.name = name;
		this.email = email;
		this.pays = pays;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PaysDTO getPays() {
		return pays;
	}
	public void setPays(PaysDTO pays) {
		this.pays = pays;
	}
}
