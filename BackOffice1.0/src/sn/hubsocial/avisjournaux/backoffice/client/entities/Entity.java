package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * hubsocial janvier 2012
 */
public class Entity  implements Serializable{
	private static final long serialVersionUID = 8383358001127305021L;
	protected Long id ;
	public Entity(){
		// TODO Auto-generated constructor stub	
	} 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private class Container {
		public String content;
	}
	
}