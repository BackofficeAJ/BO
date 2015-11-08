package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.util.Date;

@SuppressWarnings("serial")
public class Offer extends Post{
	// A remettre en cause
	
	/**
	 * 
	 */

	public Offer() {
		super();
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		super.setName(name);
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		super.setDescription(description);
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return super.getPosition();
	}

	/**
	 * @return the numValue
	 */
	public int getNumValue() {
		return super.getNumValue();
	}

	/**
	 * @return the valuation
	 */
	public float getValuation() {
		return super.getValuation();
	}
	 
	/**
	 * @return the date
	 */
	public Date getDate() {
		return super.getDate();
	}
	
	
	/**
	 * @return the userApplicationId
	 */
	public Long getUserApplicationId() {
		return super.getUserApplicationId();
	}
	 
	/**
	 * @return the objetId
	 */
	public Long getObjetId() {
		return super.getObjectId();
	}
	
	public String getName(){
		return super.getName();
	}
	
	public String getDescription(){
		return super.getDescription();
	}
	
	
	

}
