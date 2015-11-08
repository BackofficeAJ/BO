package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import gwt.material.design.client.custom.MaterialButtonCell;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.StructureDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.google.gwt.view.client.ProvidesKey;

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

	private StructureDTO ModelStructure;
	
@UiField SimplePanel gridPanel;
	
	@UiField MaterialTextBox nom;
	@UiField MaterialTextBox numero;
	@UiField MaterialTextBox email;
	
	@UiField MaterialLink listeCollaps;

	public StructureDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
		listeCollaps.addStyleName("active");
		setGrid();
	}
	
	private void setGrid() {
		dataGrid = createDatagrid();
		gridPanel.setWidget(dataGrid);
	}
	
	private void refreshData() {
		ModelStructureProvider.setList(new ArrayList<StructureDTO>());
		getAllOrderDTO();
	}

	private DataGrid<StructureDTO> createDatagrid() {


		this.sortDataHandler = new ListHandler<StructureDTO>(new ArrayList<StructureDTO>());


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
		

		// ACTION BUTTON SUPPRIMER
		Column<StructureDTO, MaterialButton> buttSupp = new Column<StructureDTO, MaterialButton>(new MaterialButtonCell()) {
            @Override
            public MaterialButton getValue(StructureDTO object) {
                
                MaterialButton mb = new MaterialButton("", "red", "light");
                mb.setIcon("mdi-action-delete");                
                mb.setType("floating");
                mb.getElement().getStyle().setProperty("display", "inline-flex");
                return mb;
            }
            
        };
        
     // ACTION BUTTON MODIFIER
        Column<StructureDTO, MaterialButton > buttModif = new Column<StructureDTO, MaterialButton>(new MaterialButtonCell()) {
            @Override
            public MaterialButton getValue(StructureDTO object) {
                
                MaterialButton mb = new MaterialButton("", "blue", "light");
                mb.setIcon("mdi-editor-mode-edit");                
                mb.setType("floating");
                return mb;
            }
            
        };
        
        
        
      //GESTION DE LA SUPPRESSION
        buttSupp.setFieldUpdater(new FieldUpdater<StructureDTO, MaterialButton>() {			
			@Override
			public void update(int index, StructureDTO object, MaterialButton value) {
				
				sortDataHandler.getList().remove(object);
				String nom =object.getNom();
				MaterialToast.alert(""+nom+"");	
				
			}
		});    
		
        
    //GESTION DE LA MODIFICATION
        buttModif.setFieldUpdater(new FieldUpdater<StructureDTO, MaterialButton>() {
			
			@Override
			public void update(int index, StructureDTO object, MaterialButton value) {
				
				
	//recuperation des valeurs
				String nomM = object.getNom();
				String numeroM = object.getNumero();
				String emailM = object.getEmail();
				
				
	//suppression de la structure
				sortDataHandler.getList().remove(object);
				
	//remise des valeurs dans les champs du formulaire
				nom.setText(nomM);
				numero.setText(numeroM);
				email.setText(emailM);
				
			}
		});
        
        //

		final DataGrid<StructureDTO> dataGrid = new DataGrid<StructureDTO>(100, KEY_PROVIDER);
		dataGrid.setSize("100%", "75vh");

		dataGrid.addColumn(colNom, "Nom");
		dataGrid.addColumn(colNumero, "Numero");
		dataGrid.addColumn(colEmail, "Email");
		dataGrid.addColumn(buttSupp,"Supprimer");
		dataGrid.addColumn(buttModif,"Modifier");

		dataGrid.setStyleName("responsive-table");
		

		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);

		ModelStructureProvider = new ListDataProvider<StructureDTO>();
		ModelStructureProvider.addDataDisplay(dataGrid);
		dataGrid.addColumnSortHandler(sortDataHandler);

		return dataGrid;
	
	}
	private void getAllOrderDTO() {
		
		//recuperation des valeurs saisies
				String nomS = nom.getValue();
				String numeroS = numero.getValue();
				String emailS = email.getText();
				
				
		//controle de saisie
				if ("".equals(nomS)) {
					MaterialToast.alert("Saisir un Nom");	
					
					return;
				}
		//Ajout des valeurs 
					orders.add(new StructureDTO( nomS , numeroS , emailS ));
					ModelStructureProvider.setList(orders);
					sortDataHandler.setList(ModelStructureProvider.getList());
					MaterialToast.alert("Ajout avec succes!!!");
				
		//remise a zero
					nom.setText("");
					numero.setText("");
					email.setText("");
				
	}
	public StructureDTO getModelStructure() {
		return ModelStructure;
	}

	public void setModelStructure(StructureDTO ModelStructure) {
		this.ModelStructure = ModelStructure;
	}
	@UiHandler("submit")
    protected void onConfirmAddButtonClick(ClickEvent e){
		
		refreshData();	
		
	}
}
