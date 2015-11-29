package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import java.util.List;

import gwt.material.design.client.custom.MaterialSuggestionOracle;
import gwt.material.design.client.ui.MaterialAutoComplete;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialToast;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MotsClesDataGrid extends Composite {

	private static MotsClesDataGridUiBinder uiBinder = GWT.create(MotsClesDataGridUiBinder.class);

	interface MotsClesDataGridUiBinder extends UiBinder<Widget, MotsClesDataGrid> {	}
	List<String> cles;
//	MaterialChip motsCles;
	@UiField MaterialAutoComplete motsCles;


	public MotsClesDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
		
		motsCles.setSuggestions(getSuggestions());
		
		
	}
	 private MaterialSuggestionOracle getSuggestions() {
	        MaterialSuggestionOracle suggestions = new MaterialSuggestionOracle();
	        suggestions.add("Alabama");
	        suggestions.add("Alaska");
	        suggestions.add("Arizona");
	        suggestions.add("Arkansas");
	        suggestions.add("California");
	        suggestions.add("Colorado");
	        suggestions.add("Connecticut");
	        suggestions.add("Delaware");
	        
	        return suggestions;
	    }
	 @UiHandler("btnAgree")
		void onAgree(ClickEvent e) {
		 MaterialToast.alert(" " +motsCles.getItemValues());
		}
		
		@UiHandler("btnDisagree")
		void onDisagree(ClickEvent e) {
			MaterialModal.closeModal();
		}


}
