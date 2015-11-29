package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import gwt.material.design.client.custom.MaterialCheckBoxCell;
import gwt.material.design.client.type.ModalType;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialToast;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.AvisDTO;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.QuotidienDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;

public class QuotidienDataGrid extends Composite {

	private static QuotidienDataGridUiBinder uiBinder = GWT.create(QuotidienDataGridUiBinder.class);

	interface QuotidienDataGridUiBinder extends	UiBinder<Widget, QuotidienDataGrid> { }
	
	private List<QuotidienDTO> orders = new ArrayList<QuotidienDTO>();
	
	
	public ListDataProvider<QuotidienDTO> getModelQuotienProvider() {
		return modelQuotidienProvider;
	}

	public void setModelStructureProvider(
			ListDataProvider<QuotidienDTO> modelQuotidienProvider) {
		modelQuotidienProvider = modelQuotidienProvider;
	}

	public ListHandler<QuotidienDTO> getSortDataHandler() {
		return sortDataHandler;
	}

	public void setSortDataHandler(ListHandler<QuotidienDTO> sortDataHandler) {
		this.sortDataHandler = sortDataHandler;
	}

	private int page = 0;
	private int offset = 10;
	private String sortOrder = "desc";
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	

	private DataGrid<QuotidienDTO> dataGrid;
	private ListDataProvider<QuotidienDTO> modelQuotidienProvider;
	private ListHandler<QuotidienDTO> sortDataHandler;
	private final ProvidesKey<QuotidienDTO> KEY_PROVIDER = new ProvidesKey<QuotidienDTO>() {

		@Override
		public Object getKey(QuotidienDTO item) {
			return item.getId();
		}
	};
	
	private final SelectionModel<QuotidienDTO> selectionModel = new MultiSelectionModel<QuotidienDTO>(KEY_PROVIDER);
	private QuotidienDTO quotidienDtoSelected;
	private QuotidienDTO ModelStructure;
	public ArrayList<Long> alID;
	private long id;
	private int nbreSelection;
	
	
	
	public int getNbreSelection() {
		return nbreSelection;
	}

	public void setNbreSelection(int nbreSelection) {
		this.nbreSelection = nbreSelection;
	}

	@UiField SimplePanel gridPanel, pagerPanel;

	public QuotidienDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
		setGrid();
		alID = new ArrayList<Long>();
		dataGrid.setStyleName("bordered responsive-table");
	}
	
	private void setGrid() {
		dataGrid = createDatagrid();
		gridPanel.setWidget(dataGrid);
		refreshData();
	}
	
	private void refreshData() {
		QuotidienDTO.retrieve(this);
//		modelQuotidienProvider.setList(new ArrayList<QuotidienDTO>());
//		getAllOrderDTO();
		
	}

	private DataGrid<QuotidienDTO> createDatagrid() {

		this.sortDataHandler = new ListHandler<QuotidienDTO>(new ArrayList<QuotidienDTO>());

		// CHECKBOX
		Column<QuotidienDTO, Boolean> checkColumn = new Column<QuotidienDTO, Boolean>(new MaterialCheckBoxCell()) {
			@Override
			public Boolean getValue(QuotidienDTO object) {
				boolean value = selectionModel.isSelected(object);	
				return value;
			}
		};

		FieldUpdater<QuotidienDTO, Boolean> checkColumnFU = new FieldUpdater<QuotidienDTO, Boolean>() {
		
		    @Override
		    public void update(int index, QuotidienDTO object, Boolean value) {
		    	// MaterialToast.alert("blaaaaaaaaaaa");
		    	selectionModel.setSelected(object, value);		        
		        id = object.getId();
		        quotidienDtoSelected = object;
		      //  MaterialToast.alert("blייייייייייי");
		    	if (alID.contains(id)== true) {
		    		alID.remove(id);
		    		nbreSelection -=1;
		            //MaterialToast.alert(""+(nbreSelection));
		           // MaterialToast.alert("remove");
		    	//	 MaterialToast.alert("bloooooooooooo");
				}
		    	else {
					alID.add(id);
					nbreSelection +=1;
					//MaterialToast.alert(""+(nbreSelection));
		          //  MaterialToast.alert("ajoute");
					
				}
		    }
		    
		};
		checkColumn.setFieldUpdater(checkColumnFU);
		
     // NOM
 		final TextColumn<QuotidienDTO> colNom = new TextColumn<QuotidienDTO>() {
 			@Override
 			public String getValue(QuotidienDTO object) {
 				if (object.getName() != null) {
 					return object.getName();
				}
 				return "";
 			}
 		};
 		colNom.setSortable(true);
 		sortDataHandler.setComparator(colNom, new Comparator<QuotidienDTO>() {

 			@Override
 			public int compare(QuotidienDTO o1, QuotidienDTO o2) {

 				return o1.getName().compareTo(o2.getName());
 			}
 		});
 		
 	// Email
 			TextColumn<QuotidienDTO> colEmail = new TextColumn<QuotidienDTO>() {
 				@Override
 				public String getValue(QuotidienDTO object) {
 					if (object.getEmail() != null) {
 						return object.getEmail();
 					}
 					return "";
 				}
 			};
 			colEmail.setSortable(true);
 			sortDataHandler.setComparator(colEmail, new Comparator<QuotidienDTO>() {

 				@Override
 				public int compare(QuotidienDTO o1, QuotidienDTO o2) {

 					return o1.getEmail().compareTo(o2.getEmail());
 				}
 			});

	// PAYS
		TextColumn<QuotidienDTO> colPays = new TextColumn<QuotidienDTO>() {
			@Override
			public String getValue(QuotidienDTO object) {
				if (object.getPays() != null) {
					if (object.getPays().getLibelle() != null) {
						return object.getPays().getLibelle();
					}					
				}
				return "";
			}
		};
		colPays.setSortable(true);
		sortDataHandler.setComparator(colPays, new Comparator<QuotidienDTO>() {

			@Override
			public int compare(QuotidienDTO o1, QuotidienDTO o2) {

				return o1.getPays().getLibelle().compareTo(o2.getPays().getLibelle());
			}
		});
        
     
        
        //

		final DataGrid<QuotidienDTO> dataGrid = new DataGrid<QuotidienDTO>(100, KEY_PROVIDER);
		dataGrid.setSize("100%", "75vh");
		
		dataGrid.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
		dataGrid.setColumnWidth(checkColumn, "40px");
		dataGrid.addColumn(colNom, "Nom");
		dataGrid.addColumn(colEmail, "Email");
		dataGrid.addColumn(colPays, "Pays");
		

		dataGrid.setStyleName("responsive-table");
		

		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);
		pagerPanel.add(pager);

		modelQuotidienProvider = new ListDataProvider<QuotidienDTO>();
		modelQuotidienProvider.addDataDisplay(dataGrid);
		dataGrid.addColumnSortHandler(sortDataHandler);

		return dataGrid;
	
	}
	private void getAllOrderDTO() {
		

		//Ajout des valeurs 
				//	orders.add(new QuotidienDTO( nomS , numeroS , emailS ));
				//	modelQuotidienProvider.setList(orders);
				//	sortDataHandler.setList(modelQuotidienProvider.getList());
					MaterialToast.alert("Ajout avec succes!!!");
				
		//remise a zero
//					nom.setText("");
//					pays.setText("");
//					pays.setText("");
				
	}
	public QuotidienDTO getModelStructure() {
		return ModelStructure;
	}

	public void setModelStructure(QuotidienDTO ModelStructure) {
		this.ModelStructure = ModelStructure;
	}
	
//	popup pour enrigistrer une organisation
	@UiHandler("quotidienForm")
    void onStructureEdit(ClickEvent e) {
        MaterialModal.showWindow(new QuotidienFormDataGrid(this), ModalType.WINDOW, "Enregistrer un Quotidien","blue",false);
	}
//	popup pour modifier une structure
	@UiHandler("modifier")
	 void onStructureModify(ClickEvent e) {
		if (nbreSelection == 1) {
			MaterialModal.showWindow(new QuotidienFormDataGrid(quotidienDtoSelected, this), ModalType.WINDOW, "Modifier une Structure","blue",false);
			nbreSelection --;
		}
		else {
			MaterialToast.alert("veuillez selectionner un seul Quotidien");
		}
		
	}
//        
////	supprimer une structure
	@UiHandler("supprimer")
	void onStructureDelete(ClickEvent e){
		if (nbreSelection == 1){
			QuotidienDTO.delete(quotidienDtoSelected, this);
			nbreSelection --;
		}	
		else{
			MaterialToast.alert("Vous ne pouvez supprimer qu'une seule structure א la fois");
			return;
		}
	}
//	
	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}	
	
}
