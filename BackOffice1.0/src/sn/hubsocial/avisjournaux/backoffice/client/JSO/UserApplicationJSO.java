package sn.hubsocial.avisjournaux.backoffice.client.JSO;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

public class UserApplicationJSO extends JavaScriptObject {

	protected UserApplicationJSO() {}

	public final native int getId()/*-{ return this.id; }-*/;
	public final native String getNom()/*-{ return this.nom; }-*/;
	public final native  String getPrenom()/*-{ return this.prenom; }-*/;
	public final native String getPassword()/*-{ return this.password; }-*/;
	public final native String getImage()/*-{ return this.image; }-*/;
	public final native Long getApplicationId()/*-{ return this.applicationId; }-*/;
	public final native int getEtoile()/*-{ return this.etoile; }-*/;
	public final native String getProfil()/*-{ return this.profil; }-*/;
	public final native String getStatus()/*-{ return this.status; }-*/;
	public final native String getName()/*-{ return this.name; }-*/;
	public final native String getAdresse()/*-{ return this.adresse; }-*/;
	public final native String getTelephone()/*-{ return this.telephone; }-*/;
	public final native String getEmail()/*-{ return this.email; }-*/ ;



}
