package sn.hubsocial.avisjournaux.backoffice.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BackOffice1_0 implements EntryPoint {
	 public void onModuleLoad() {		   
		    RootPanel.get().add(new Index());
		  }
}
