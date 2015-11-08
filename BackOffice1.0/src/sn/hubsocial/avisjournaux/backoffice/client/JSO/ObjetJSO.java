package sn.hubsocial.avisjournaux.backoffice.client.JSO;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class ObjetJSO extends JavaScriptObject {

	
	
	protected ObjetJSO() {
		
	}
	public final native int getId()/*-{ return this.id; }-*/;
	public final native String getName()/*-{ return this.name; }-*/;
	public final native String getDescription()/*-{ return this.description; }-*/;
	public final native String getLieu()/*-{ return this.lieu; }-*/;
	public final native String getImage()/*-{ return this.image; }-*/;
	public final native Date getCreationDate()/*-{ return this.creationDate; }-*/;
	public final native Date getEndDate()/*-{ return this.endDate; }-*/;
	public final native String getCodeConfirm()/*-{ return this.codeConfirm; }-*/;
	public final native String getStatus()/*-{ return this.status; }-*/;
	public final native String getVisible()/*-{ return this.visible; }-*/;
	public final native Integer getType()/*-{ return this.type; }-*/;
	public final native Boolean getIsPack()/*-{ return this.isPack; }-*/;
	public final native Integer getSeuil()/*-{ return this.seuil; }-*/;
	public final native String getReference()/*-{ return this.referece; }-*/;
	public final native OrganisationJSO getOrganisation()/*-{ return this.organisation; }-*/;
	public final native PaysJSO getPays()/*-{ return this.pays; }-*/;
	public final native UtilisateurJSO getAuthor()/*-{ return this.author; }-*/;
	public final native UserApplicationJSO getCreator()/*-{ return this.creator; }-*/;
	
}
