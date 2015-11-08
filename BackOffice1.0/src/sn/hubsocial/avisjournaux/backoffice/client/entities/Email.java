package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.util.List;


public class Email extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8272151198729754419L;
	private List<String> recipents;
	private List<String> recipCC;
	private List<String> recipCCI;
	private String subject;
	private String content;

	public Email() {
		super();
	}
	
	public List<String> getRecipCC() {
		return recipCC;
	}

	public void setRecipCC(List<String> recipCC) {
		this.recipCC = recipCC;
	}

	public List<String> getRecipCCI() {
		return recipCCI;
	}

	public void setRecipCCI(List<String> recipCCI) {
		this.recipCCI = recipCCI;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public void setRecipents(List<String> recipents) {
		this.recipents = recipents;
	}

	public List<String> getRecipents() {
		return recipents;
	}

	
}