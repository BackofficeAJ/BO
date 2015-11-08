package sn.hubsocial.avisjournaux.backoffice.client.entities;


public class Livraison extends Entity {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1454879862L;
	private Long userId;
	private UserApplication user;
	private Long objetId;
	private Long RequestId;
	private Objet objet;
	private String longitude;
	private String latitude;
	private String address;
	private String telephone;
	
	public Livraison() {
		super();
	}
	
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Long getObjetId() {
		return objetId;
	}


	public void setObjetId(Long objetId) {
		this.objetId = objetId;
	}


	public Objet getObjet() {
		return objet;
	}


	public void setObjet(Objet objet) {
		this.objet = objet;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public void setUser(UserApplication user) {
		this.user = user;
	}


	public UserApplication getUser() {
		return user;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setRequestId(Long requestId) {
		RequestId = requestId;
	}


	public Long getRequestId() {
		return RequestId;
	}


	
	

}
