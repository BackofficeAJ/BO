package sn.hubsocial.avisjournaux.backoffice.client.JSO;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class UtilisateurJSO extends JavaScriptObject {

	
	
	protected UtilisateurJSO() {
		
	}
	public final native int getId()/*-{ return this.id; }-*/;
	
	public final native String getPrenom()/*-{ return this.prenom; }-*/;
	public final native String getNom()/*-{ return this.nom; }-*/;
	public final native String getProfil()/*-{ return this.profil; }-*/;
	public final native String getEmail()/*-{ return this.email; }-*/;
	public final native PaysJSO getPays()/*-{ return this.pays; }-*/;

	
}
