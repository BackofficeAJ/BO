package sn.hubsocial.avisjournaux.backoffice.server.resource;

import java.util.List;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

import sn.hubsocial.avisjournaux.backoffice.client.entities.Entity;


public interface EntityResourceInterface<T extends Entity> {
	@Put
	public   T saveOrUpdate(String objet) ;
	@Get
	public   List<T> find() ;
	@Delete
	public  Boolean remove() ;
	
}
