package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import gwt.material.design.client.custom.MaterialCheckBoxCell;
import gwt.material.design.client.type.ModalType;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialToast;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.AvisDTO;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.StructureDTO;

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

public class StructureDataGrid extends Composite {

	private static StructureDataGridUiBinder uiBinder = GWT.create(StructureDataGridUiBinder.class);

	interface StructureDataGridUiBinder extends	UiBinder<Widget, StructureDataGrid> { }
	
	private List<StructureDTO> orders = new ArrayList<StructureDTO>();

	private DataGrid<StructureDTO> dataGrid;
	private ListDataProvider<StructureDTO> ModelStructureProvider;
	private ListHandler<StructureDTO> sortDataHandler;
	private final ProvidesKey<StructureDTO> KEY_PROVIDER = new ProvidesKey<StructureDTO>() {

		@Override
		public Object getKey(StructureDTO item) {
			return item.getId();
		}
	};
	
	private final SelectionModel<StructureDTO> selectionModel = new MultiSelectionModel<StructureDTO>(KEY_PROVIDER);

	private StructureDTO ModelStructure;
	public ArrayList<Long> alID;
	private long id;
	private int nbreSelection;
	
	@UiField SimplePanel gridPanel, pagerPanel;

	public StructureDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
		setGrid();
		dataGrid.setStyleName("bordered responsive-table");
	}
	
	private void setGrid() {
		dataGrid = createDatagrid();
		gridPanel.setWidget(dataGrid);
	}
	
	private void refreshData() {
		//ModelStructureProvider.setList(new ArrayList<StructureDTO>());
		//getAllOrderDTO();
	}

	private DataGrid<StructureDTO> createDatagrid() {

		this.sortDataHandler = new ListHandler<StructureDTO>(new ArrayList<StructureDTO>());

		// CHECKBOX
		Column<StructureDTO, Boolean> checkColumn = new Column<StructureDTO, Boolean>(new MaterialCheckBoxCell()) {
			@Override
			public Boolean getValue(StructureDTO object) {
				boolean value = selectionModel.isSelected(object);	
				return value;
			}
		};

		FieldUpdater<StructureDTO, Boolean> checkColumnFU = new FieldUpdater<StructureDTO, Boolean>() {
		
		    @Override
		    public void update(int index, StructureDTO object, Boolean value) {
		        selectionModel.setSelected(object, value);
		        id = +object.getId();
		        
		    	if (alID.contains(id)== true) {
		    		alID.remove(id);
		    		nbreSelection -=1;
		            MaterialToast.alert(""+(nbreSelection));
		            MaterialToast.alert("remove");
				}
		    	else {
					alID.add(id);
					nbreSelection +=1;
					MaterialToast.alert(""+(nbreSelection));
		            MaterialToast.alert("ajoute");
					
				}
		    }
		    
		};
		checkColumn.setFieldUpdater(checkColumnFU);
		
     // NOM
 		final TextColumn<StructureDTO> colNom = new TextColumn<StructureDTO>() {
 			@Override
 			public String getValue(StructureDTO object) {

 				return object.getNom();
 			}
 		};
 		colNom.setSortable(true);
 		sortDataHandler.setComparator(colNom, new Comparator<StructureDTO>() {

 			@Override
 			public int compare(StructureDTO o1, StructureDTO o2) {

 				return o1.getNom().compareTo(o2.getNom());
 			}
 		});
 		

	// NUMERO
		TextColumn<StructureDTO> colNumero = new TextColumn<StructureDTO>() {
			@Override
			public String getValue(StructureDTO object) {

				return object.getNumero();
			}
		};
		colNumero.setSortable(true);
		sortDataHandler.setComparator(colNumero, new Comparator<StructureDTO>() {

			@Override
			public int compare(StructureDTO o1, StructureDTO o2) {

				return o1.getNumero().compareTo(o2.getNumero());
			}
		});
        
     // Email
		TextColumn<StructureDTO> colEmail = new TextColumn<StructureDTO>() {
			@Override
			public String getValue(StructureDTO object) {

				return object.getEmail();
			}
		};
		colEmail.setSortable(true);
		sortDataHandler.setComparator(colEmail, new Comparator<StructureDTO>() {

			@Override
			public int compare(StructureDTO o1, StructureDTO o2) {

				return o1.getEmail().compareTo(o2.getEmail());
			}
		});
        
        //

		final DataGrid<StructureDTO> dataGrid = new DataGrid<StructureDTO>(100, KEY_PROVIDER);
		dataGrid.setSize("100%", "75vh");
		dataGrid.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
		dataGrid.setColumnWidth(checkColumn, "40px");
		dataGrid.addColumn(colNom, "Nom");
		dataGrid.addColumn(colNumero, "Numero");
		dataGrid.addColumn(colEmail, "Email");

		dataGrid.setStyleName("responsive-table");
		

		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);
		pagerPanel.add(pager);

		ModelStructureProvider = new ListDataProvider<StructureDTO>();
		ModelStructureProvider.addDataDisplay(dataGrid);
		dataGrid.addColumnSortHandler(sortDataHandler);

		return dataGrid;
	
	}
	private void getAllOrderDTO() {
		

		//Ajout des valeurs 
				//	orders.add(new StructureDTO( nomS , numeroS , emailS ));
//					ModelStructureProvider.setList(orders);
//					sortDataHandler.setList(ModelStructureProvider.getList());
//					MaterialToast.alert("Ajout avec succes!!!");
//				
		//remise a zero
//					nom.setText("");
//					numero.setText("");
//					email.setText("");
				
	}
	public StructureDTO getModelStructure() {
		return ModelStructure;
	}

	public void setModelStructure(StructureDTO ModelStructure) {
		this.ModelStructure = ModelStructure;
	}
	
//	popup pour enrigistrer une structure
	@UiHandler("structureForm")
    void onStructureEdit(ClickEvent e) {
        MaterialModal.showWindow(new StuctureFormDataGrid(), ModalType.WINDOW, "Enregistrer un Avis","blue",false);
	}
//	popup pour modifier une structure
	@UiHandler("modifier")
	 void onStructureModify(ClickEvent e) {
		if (nbreSelection == 1) {
//			mettre les requetes pour recuperer les données et les mettre dans les champs
			MaterialModal.showWindow(new StuctureFormDataGrid(), ModalType.WINDOW, "Modifier un Avis","blue",false);
		}
		MaterialToast.alert("veuillez selectionner une seule Structure");
	}
        
//	supprimer une structure
	@UiHandler("supprimer")
	void onStructureDelete(ClickEvent e){
//		mettre le requete pour supprimer la strucure de Id id recuperer dans le checkBox
		MaterialToast.alert("Suppression");
	}
	
}
