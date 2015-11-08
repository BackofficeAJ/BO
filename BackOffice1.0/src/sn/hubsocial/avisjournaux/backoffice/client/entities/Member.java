package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.util.Date;


public class Member extends sn.hubsocial.avisjournaux.backoffice.client.entities.Entity{
	/**
	 * @author sambinfo_ad
	 */
	private static final long serialVersionUID = -2357468159844801558L;
	private Date date;
	private String email;
	private String image;
	private boolean isAdministrator = false;
	private String status;
	public Member() {
		super();
		date =  new Date();
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public boolean isAdministrator() {
		return isAdministrator;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}	

	
}