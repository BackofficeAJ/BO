package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import gwt.material.design.client.ui.MaterialImage;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.DOM;

public class MaterialImageCell extends AbstractCell<MaterialImage> {

	@SuppressWarnings("deprecation")
	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context,
			MaterialImage value, SafeHtmlBuilder sb) {
		 sb.appendHtmlConstant(DOM.toString(value.getElement()));
	}

}