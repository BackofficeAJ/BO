package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.util.Date;
import java.util.List;


public class Circle extends sn.hubsocial.avisjournaux.backoffice.client.entities.Entity{
	/**
	 * @author sambinfo_ad
	 */
	private static final long serialVersionUID = -2357468159844801558L;
	private String nom;
	private String image;
	private Date date;
	private String email;
	int nbMember;
	private List<Member> members;	

	public Circle() {
		super();
		date =  new Date();
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public List<Member> getMembers() {
		return members;
	}
	
	public int getNbMember() {
		return nbMember;
	}

	public void setNbMember(int nbMember) {
		this.nbMember = nbMember;
	}
	
	
}