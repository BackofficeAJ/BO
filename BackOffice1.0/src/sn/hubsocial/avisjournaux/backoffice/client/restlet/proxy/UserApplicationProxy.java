package sn.hubsocial.avisjournaux.backoffice.client.restlet.proxy;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import sn.hubsocial.avisjournaux.backoffice.client.entities.UserApplication;


public interface UserApplicationProxy extends RestService{

	@Path("../rest/userapplication")
	@PUT
	public  void saveOrUpdate(UserApplication json, MethodCallback<UserApplication>Callback) ;
	@Path("../rest/userapplication")
	@GET
	public void find( @QueryParam("rp") String path, @QueryParam("page") String page, MethodCallback<List<UserApplication>> Callback) ;
	@Path("../rest/userapplication")
	@GET
	public void find(MethodCallback<List<UserApplication>> Callback) ;
	@Path("../rest/userapplication")
	@DELETE
	public  void remove(@QueryParam("id") Long id, MethodCallback<Boolean> callback) ;
	
}
