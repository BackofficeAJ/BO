package sn.hubsocial.avisjournaux.backoffice.client.entities;


public class Action extends Entity {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1454879862L;
	private String name;
	private String description;
	
	public Action() {
		super();
	}
	
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
}
