package sn.hubsocial.avisjournaux.backoffice.client.entities;

/**
 * @since 
 */
public class Message extends Post{

	private static final long serialVersionUID = 15487897879978L;
	private String messagelu;
	private String image;


	public Message() {
		super();
	}

	public String getMessagelu() {
		return messagelu;
	}
	public void setMessagelu(String messagelu) {
		this.messagelu = messagelu;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}
}