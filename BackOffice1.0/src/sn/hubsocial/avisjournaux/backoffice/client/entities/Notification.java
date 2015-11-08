package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.util.Date;

public class Notification extends sn.hubsocial.avisjournaux.backoffice.client.entities.Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2357468159844801558L;
	private Date date;
	private String code;
	private String description;
	private String notiflu;
	private Long userApplicationId;
	private Long objectId;
	private Long identifiant;
	private int nbParticip;

	private UserApplication userApplication;
	private Objet object;
	public Notification() {
		super();
		date =  new Date();
		notiflu = "non"; 
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotiflu() {
		return notiflu;
	}

	public void setNotiflu(String notiflu) {
		this.notiflu = notiflu;
	}

	

	public Long getUserApplicationId() {
		return userApplicationId;
	}

	public void setUserApplicationId(Long userApplicationId) {
		this.userApplicationId = userApplicationId;
	}

	public UserApplication getUserApplication() {
		return userApplication;
	}

	public void setUserApplication(UserApplication userApplication) {
		this.userApplication = userApplication;
	}

	public Long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public int getNbParticip() {
		return nbParticip;
	}

	public void setNbParticip(int nbParticip) {
		this.nbParticip = nbParticip;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObject(Objet object) {
		this.object = object;
	}

	public Objet getObject() {
		return object;
	}
}