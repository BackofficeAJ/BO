package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.util.Date;


public class Post extends sn.hubsocial.avisjournaux.backoffice.client.entities.Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2357468159844801558L;
	private String name;
	private String description;
	private String descriptionType;
	private int position;
	private int numValue;
	private float valuation;
	private Date date;
	private Long userApplicationId;
	private Long creatorId;
    private Long objectId;
    public static Boolean withObject = false; 
	private Objet object;
	private UserApplication userApplication;
	private UserApplication creator;
	public Post() {
		super();
		date =  new Date();
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * @param numValue the numValue to set
	 */
	public void setNumValue(int numValue) {
		this.numValue = numValue;
	}
	/**
	 * @return the numValue
	 */
	public int getNumValue() {
		return numValue;
	}
	/**
	 * @param valuation the valuation to set
	 */
	public void setValuation(float valuation) {
		this.valuation = valuation;
	}
	/**
	 * @return the valuation
	 */
	public float getValuation() {
		return valuation;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param userApplicationId the userApplicationId to set
	 */
	public void setUserApplicationId(Long userApplicationId) {
		this.userApplicationId = userApplicationId;
	}
	/**
	 * @return the userApplicationId
	 */
	public Long getUserApplicationId() {
		return userApplicationId;
	}
	
	/**
	 * @param objetId the objetId to set
	 */


	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	public void setUserApplication(UserApplication userApplication) {
		this.userApplication = userApplication;
	}
	public UserApplication getUserApplication() {
		return userApplication;
	}
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	public Long getObjectId() {
		return objectId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setObject(Objet object) {
		this.object = object;
	}
	public Objet getObject() {
		return object;
	}
	public void setCreator(UserApplication creator) {
		this.creator = creator;
	}
	public UserApplication getCreator() {
		return creator;
	}
	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}
	public String getDescriptionType() {
		return descriptionType;
	}

}
