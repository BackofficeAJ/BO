package sn.hubsocial.avisjournaux.backoffice.client.entities;

public class User extends Entity {
	
	private static final long serialVersionUID = 7802751388485151885L;
	private String firstName ;
	private String lastName ;
	
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User() {
		firstName = "" ;
		lastName = "" ;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
