package sn.hubsocial.avisjournaux.backoffice.client.entities;


public class Article extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8272151198729754419L;
	private String name;
	private String description;
	private String image;
	private String date;
	private Long userAppId;

	public Article() {
		super();
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	

	public void setUserAppId(Long userAppId) {
		this.userAppId = userAppId;
	}

	public Long getUserAppId() {
		return userAppId;
	}

	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}