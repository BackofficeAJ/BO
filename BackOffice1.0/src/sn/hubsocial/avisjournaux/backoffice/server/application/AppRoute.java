package sn.hubsocial.avisjournaux.backoffice.server.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.restlet.routing.Template;

import sn.hubsocial.avisjournaux.backoffice.server.resource.ObjetResource;

public class AppRoute extends Application {
	@Override
	public synchronized Restlet createInboundRoot(){

		final Router router = new Router(getContext()) ;
		router.setDefaultMatchingMode(Template.MODE_EQUALS) ;

		router.attach("/objet", ObjetResource.class);

		return router;
	}
}
