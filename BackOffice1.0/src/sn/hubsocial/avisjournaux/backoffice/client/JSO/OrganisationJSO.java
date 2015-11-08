package sn.hubsocial.avisjournaux.backoffice.client.JSO;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;


 public class OrganisationJSO extends JavaScriptObject {

	protected OrganisationJSO() {}
	public final native String getName()/*-{ return this.name; }-*/;


	public final native List<UserApplicationJSO> getMembers()/*-{ return this.members; }-*/ ;
	public final native String getAdresse()/*-{ return this.adresse; }-*/;

	public final native String getTelephone()/*-{ return this.telephone; }-*/;

	public final native String getEmail()/*-{ return this.email; }-*/ ;

	public final native String getDescription()/*-{ return this.description; }-*/;
	public final native PaysJSO getPays()/*-{ return this.pays; }-*/;



}
