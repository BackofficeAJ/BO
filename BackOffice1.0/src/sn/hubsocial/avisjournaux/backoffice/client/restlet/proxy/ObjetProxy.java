package sn.hubsocial.avisjournaux.backoffice.client.restlet.proxy;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import sn.hubsocial.avisjournaux.backoffice.client.entities.Objet;

public interface ObjetProxy extends   RestService{

	@Path("/rest/objet")
	@PUT
	public   void saveOrUpdate(String json, MethodCallback<Objet>Callback) ;
	@Path("../rest/objet")
	@GET
	public    void find( @QueryParam("rp") String path, @QueryParam("page") String page, MethodCallback<List<Objet>> Callback) ;
	@Path("/rest/objet")
	@DELETE
	public  void remove(MethodCallback<Boolean> callback) ;
	
}
