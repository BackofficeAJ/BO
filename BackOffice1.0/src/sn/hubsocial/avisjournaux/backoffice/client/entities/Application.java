package sn.hubsocial.avisjournaux.backoffice.client.entities;

public class Application extends Entity{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6206975313276268951L;
	
	private String url;
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Application() {
		super();
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	
}
