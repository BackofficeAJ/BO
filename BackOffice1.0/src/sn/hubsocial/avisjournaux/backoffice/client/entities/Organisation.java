package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.util.List;


/**
 * @since 
 */
public class Organisation extends Entity{

	private static final long serialVersionUID = 15487897879978L;
	private String name;
	private String adresse;
	private String telephone;
	private String email;
	private String description;
	private Pays pays;
	private Long paysId;
	
	private List<UserApplication> members;	

	public Organisation() {
		super();
	}
	public Organisation(String name,List<UserApplication> members) {
		super();
		this.name = name;
		this.members = members;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setMembers(List<UserApplication> members) {
		this.members = members;
	}
	public List<UserApplication> getMembers() {
		return members;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public Long getPaysId() {
		return paysId;
	}
	public void setPaysId(Long paysId) {
		this.paysId = paysId;
	}
}