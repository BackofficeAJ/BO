package sn.hubsocial.avisjournaux.backoffice.client.entities;
/**
 * 
 */
public class Categorie extends Entity{

	private static final long serialVersionUID = 15487897879978L;
	private String name;
	private String description;
	private int type;
	private String image;

	public Categorie() {
		super();
	}
	public Categorie(String name,String description,int type,String image) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.image = image;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}