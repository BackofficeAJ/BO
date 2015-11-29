package sn.hubsocial.avisjournaux.backoffice.client.restlet.proxy;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import sn.hubsocial.avisjournaux.backoffice.client.entities.Organisation;


public interface OrganisationProxy extends RestService{

	@Path("../rest/organisation")
	@PUT
	public  void saveOrUpdate(Organisation json, MethodCallback<Organisation>Callback) ;
	@Path("../rest/organisation")
	@GET
	public void find( @QueryParam("rp") String path, @QueryParam("page") String page, MethodCallback<List<Organisation>> Callback) ;
	@Path("../rest/organisation")
	@GET
	public void find( MethodCallback<List<Organisation>> Callback) ;
	
	@Path("../rest/organisation")
	@DELETE
	public  void remove(@QueryParam("id") Long id, MethodCallback<Boolean> callback) ;
	
}
