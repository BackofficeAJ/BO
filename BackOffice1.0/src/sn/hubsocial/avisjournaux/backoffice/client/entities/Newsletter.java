package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.util.Date;
import java.util.List;


public class Newsletter extends Entity {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1454879862L;

	private List<Long> categoriesId;
	private List<String> keywords;
	private String email;
	private Date dateBegin;
	private Date dateEnd;
	private String lastSend;
	private List<Objet> objects;

	public Newsletter() {
		super();
	}


	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	

	public List<String> getKeywords() {
		return this.keywords;
	}
	
	
	 

	public void setCategoriesId(List<Long> categoriesId) {
		this.categoriesId = categoriesId;
	}

	public List<Long> getCategoriesId() {
		return categoriesId;
	}

	public void setObjects(List<Objet> objects) {
		this.objects = objects;
	}



	public List<Objet> getObjects() {
		return objects;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}



	public String getEmail() {
		return email;
	}



	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}



	public Date getDateBegin() {
		return dateBegin;
	}



	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}



	public Date getDateEnd() {
		return dateEnd;
	}


	public void setLastSend(String lastSend) {
		this.lastSend = lastSend;
	}


	public String getLastSend() {
		return lastSend;
	}





	

}
