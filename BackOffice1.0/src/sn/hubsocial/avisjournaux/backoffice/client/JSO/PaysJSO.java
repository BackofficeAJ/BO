package sn.hubsocial.avisjournaux.backoffice.client.JSO;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class PaysJSO extends JavaScriptObject {

	
	
	protected PaysJSO() {
		
	}
	public final native int getId()/*-{ return this.id; }-*/;
	public final native String getName()/*-{ return this.name; }-*/;
	public final native String getDescription()/*-{ return this.description; }-*/;
	
}
