package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import gwt.material.design.client.custom.MaterialButtonCell;
import gwt.material.design.client.custom.MaterialCheckBoxCell;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.AvisDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SafeHtmlCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;



public class AvisDataGrid extends Composite {

	private static MaterialDataGridUiBinder uiBinder = GWT.create(MaterialDataGridUiBinder.class);

	interface MaterialDataGridUiBinder extends UiBinder<Widget, AvisDataGrid> { }
	
	 String structtype[]= {"Paru dans le Soleil","Paru dans l'Observateur","Paru dans le SUD Quotidien"};
	 String structtitre[] = {"titre","AVIS D'APPEL D'OFFRES OUVERT","AVIS DE DEMANDE DE RENSEIGNEMENTS ET DE PRIX OUVERT","AVIS D'ATTRIBUTION PROVISOIRE DE MARCHE"};
	
	 
	 

	private List<AvisDTO> orders = new ArrayList<AvisDTO>();

	private DataGrid<AvisDTO> dataGrid;
	private ListDataProvider<AvisDTO> orderDTOProvider;
	private ListHandler<AvisDTO> sortDataHandler;
	private final ProvidesKey<AvisDTO> KEY_PROVIDER = new ProvidesKey<AvisDTO>() {

		@Override
		public Object getKey(AvisDTO item) {
			return item.getId();
		}
	};

	private final SelectionModel<AvisDTO> selectionModel = new MultiSelectionModel<AvisDTO>(KEY_PROVIDER);

	private AvisDTO OrderDTO;

	@UiField SimplePanel gridPanel;
	
	@UiField MaterialListBox titre;
	@UiField MaterialTextBox structure;
	//@UiField VerticalPanel pdf;
	FileUpload fichierpdf;
	@UiField MaterialTextArea resume;	
	@UiField MaterialListBox type;
	//@UiField VerticalPanel image;
	FileUpload fichierimage;
	
	@UiField MaterialLink formulaireCollaps;
	@UiField MaterialLink listeCollaps;
	
	public AvisDataGrid() {
		
		initWidget(uiBinder.createAndBindUi(this));
	/*	fichierpdf = new FileUpload();
		pdf.add(new HTML("PDF"));
		pdf.add(fichierpdf);
		
		fichierimage = new FileUpload();
		image.add(new HTML("IMAGE"));
		image.add(fichierimage);	*/
		
		
		listeCollaps.addStyleName("active");
		setGrid();
		

		//liste de choix
		dataGrid.setStyleName("striped responsive-table");	
		for (int i = 0; i < structtype.length; i++) {
			type.addItem(structtype[i]);
		}
		
		for (int i = 0; i < structtitre.length; i++) {
			titre.addItem(structtitre[i]);
		}		
		titre.setValue(0, null);
	
	}

	private void setGrid() {
		dataGrid = createDatagrid();
		gridPanel.setWidget(dataGrid);
		refreshData();
	}

	private void refreshData() {
		/*orderDTOProvider.setList(new ArrayList<AvisDTO>());
		getAllOrderDTO();*/
		AvisDTO.retrieve(orderDTOProvider,sortDataHandler, 0, 10, "desc");


		
		
	}

	private DataGrid<AvisDTO> createDatagrid() {

		this.sortDataHandler = new ListHandler<AvisDTO>(new ArrayList<AvisDTO>());
		// CHECKBOX
		final Column<AvisDTO, Boolean> checkColumn = new Column<AvisDTO, Boolean>(new MaterialCheckBoxCell()) {
			@Override
			public Boolean getValue(AvisDTO object) {
				boolean value = selectionModel.isSelected(object);

				return value;
				
			}
		};
		
		FieldUpdater<AvisDTO, Boolean> checkColumnFU = new FieldUpdater<AvisDTO, Boolean>() {

            @Override
            public void update(int index, AvisDTO object, Boolean value) {
                selectionModel.setSelected(object, value);
                MaterialToast.alert("index"+index+"object"+object+"value"+value+"");
            }
        };
        checkColumn.setFieldUpdater(checkColumnFU);

     // TITRE
 		final TextColumn<AvisDTO> colTitre = new TextColumn<AvisDTO>() {
 			@Override
 			public String getValue(AvisDTO object) {

 				return object.getTitre();
 			}
 		};
 		colTitre.setSortable(true);
 		sortDataHandler.setComparator(colTitre, new Comparator<AvisDTO>() {

 			@Override
 			public int compare(AvisDTO o1, AvisDTO o2) {

 				return o1.getTitre().compareTo(o2.getTitre());
 			}
 		});
 		

	// ITEM Structure
		Column<AvisDTO,String> colStructure = new Column<AvisDTO, String>(new EditTextCell()) {
			@Override
			public String getValue(AvisDTO object) {

				return object.getStructure().getNom();
			}
		};
		colStructure.setSortable(true);
		sortDataHandler.setComparator(colStructure, new Comparator<AvisDTO>() {

			@Override
			public int compare(AvisDTO o1, AvisDTO o2) {

				return o1.getStructure().getNom().compareTo(o2.getStructure().getNom());
			}
		});
		
	// PDF
    /*    Column<AvisDTO, MaterialImage> pdf = new Column<AvisDTO, MaterialImage>(new MaterialImageCell()) {
            @Override
            public MaterialImage getValue(AvisDTO object) {
                
            	MaterialImage img = new MaterialImage();
            	img.setUrl(object.getPdf());
            	img.setWidth("40px");
            	img.setHeight("40px");
            	//SET IMAGE TO CIRCLE
            	img.setType("circle");
                return img;
            }
            
        };*/
        
     // RESUME
		
		final SafeHtmlCell progressCell = new SafeHtmlCell();
		 Column<AvisDTO, SafeHtml> colResume = new Column<AvisDTO, SafeHtml>(progressCell) {

		        @Override
		        public SafeHtml getValue(AvisDTO value) {
		            SafeHtmlBuilder sb = new SafeHtmlBuilder();
		           
		            sb.appendHtmlConstant(value.getResume());
		          
		            return sb.toSafeHtml();
		        }
		    };
		sortDataHandler.setComparator(colResume, new Comparator<AvisDTO>() {

			@Override
			public int compare(AvisDTO o1, AvisDTO o2) {

				return o1.getResume().compareTo(o2.getResume());
			}
		});
		
	// TYPE QUOTIDIEN
		TextColumn<AvisDTO> colType = new TextColumn<AvisDTO>() {
			@Override
			public String getValue(AvisDTO object) {

				return object.getQuotidien().getName();
			}
		};
		colType.setSortable(true);
		sortDataHandler.setComparator(colType, new Comparator<AvisDTO>() {

			@Override
			public int compare(AvisDTO o1, AvisDTO o2) {

				return o1.getQuotidien().getName().compareTo(o2.getQuotidien().getName());
			}
		});

//    // IMAGE
  /*  Column<AvisDTO, MaterialImage> image = new Column<AvisDTO, MaterialImage>(new MaterialImageCell()) {
        @Override
        public MaterialImage getValue(AvisDTO object) {
            
        	MaterialImage img = new MaterialImage();
        	if (object.getImage() != null && !object.getImage().isEmpty()){
        		img.setUrl(object.getImage());
            	img.setWidth("40px");
            	img.setHeight("40px");
            	//SET IMAGE TO CIRCLE
            	img.setType("circle");
            	
        	}
        	
            return img;
        }
        
    };*/

		// ACTION BUTTON SUPPRIMER
		Column<AvisDTO, MaterialButton> buttSupp = new Column<AvisDTO, MaterialButton>(new MaterialButtonCell()) {
            @Override
            public MaterialButton getValue(AvisDTO object) {
                
                MaterialButton mb = new MaterialButton("", "red", "light");
                mb.setWidth("30px");
                mb.setIconPosition("right");
                mb.setIcon("mdi-action-delete");                
                mb.setType("floating");
               return mb;
            }
            
        };
        
     // ACTION BUTTON MODIFIER
        Column<AvisDTO, MaterialButton > buttModif = new Column<AvisDTO, MaterialButton>(new MaterialButtonCell()) {
            @Override
            public MaterialButton getValue(AvisDTO object) {
                
                MaterialButton mb = new MaterialButton("", "blue", "light");
                mb.setWidth("30px");
                mb.setIconPosition("right");
                mb.setIcon("mdi-editor-mode-edit");                
                mb.setType("floating");
                return mb;
            }
            
        };
        
     // ACTION BUTTON AJOUTER MOT CLE
        Column<AvisDTO, MaterialButton> buttCle = new Column<AvisDTO, MaterialButton>(new MaterialButtonCell()) {
            @Override
            public MaterialButton getValue(AvisDTO object) {
                
                MaterialButton mb = new MaterialButton("", "grey", "light");
                mb.setWidth("30px");
                mb.setIconPosition("right");
                mb.setIcon("mdi-content-add-circle-outline");                
                mb.setType("floating");
                return mb;
            }
            
        };
        
        
      //GESTION DE LA SUPPRESSION
        buttSupp.setFieldUpdater(new FieldUpdater<AvisDTO, MaterialButton>() {			
			@Override
			public void update(int index, AvisDTO object, MaterialButton value) {
				sortDataHandler.getList().remove(object);
			}
		});    
		
        
    //GESTION DE LA MODIFICATION
        buttModif.setFieldUpdater(new FieldUpdater<AvisDTO, MaterialButton>() {
			
			@Override
			public void update(int index, AvisDTO object, MaterialButton value) {
				
				
	//recuperation des valeurs
				
				String titreM = object.getTitre();
				String structureM = object.getStructure().getNom();
				String resumeM = object.getResume();
				String typeM = object.getQuotidien().getName();
				
	//suppression de l'avis
				sortDataHandler.getList().remove(object);
				
	//remise des valeurs dans les champs du formulaire
				
				structure.setText(structureM);
				resume.setText(resumeM);
				
			}
		});
        
        //
        buttCle.setFieldUpdater(new FieldUpdater<AvisDTO, MaterialButton>() {
			
			@Override
			public void update(int index, AvisDTO object, MaterialButton value) {
				MaterialToast.alert("mot cle ajouté!!!!");
			}
		});

		final DataGrid<AvisDTO> dataGrid = new DataGrid<AvisDTO>(100, KEY_PROVIDER);
		dataGrid.setSize("100%", "75vh");

		dataGrid.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
		dataGrid.setColumnWidth(checkColumn, "40px");
		dataGrid.addColumn(colTitre, "Titre");
		dataGrid.addColumn(colStructure, "Structure");
		//dataGrid.addColumn(pdf, "Contenu");
		dataGrid.addColumn(colResume, "Resume");
		dataGrid.addColumn(colType, "Type Quotidien");
		//dataGrid.addColumn(image, "Image");
		dataGrid.setColumnWidth(buttSupp, "45px");
		dataGrid.addColumn(buttSupp);		
		dataGrid.addColumn(buttModif);
		dataGrid.setColumnWidth(buttModif, "45px");
		dataGrid.addColumn(buttCle);
		dataGrid.setColumnWidth(buttCle,"45px");		

		dataGrid.setStyleName("responsive-table");		

		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);

		orderDTOProvider = new ListDataProvider<AvisDTO>();
		orderDTOProvider.addDataDisplay(dataGrid);
		dataGrid.addColumnSortHandler(sortDataHandler);

		return dataGrid;

	}

	private void getAllOrderDTO() {
		
		
		
		/*//recuperation des valeurs saisies
				String titreS = titre.getSelectedValue();
				String structureS = structure.getValue();			
				String nomImg= fichierimage.getFilename();
				String resumeS = resume.getText().toUpperCase();
				String typeC = type.getSelectedValue();
				int indextypeAO = type.getSelectedIndex();
				*/
				
		//controle de saisie
				
			/*	 if ("".equals(structureS)) {
					MaterialToast.alert("Nom de la Structure");
					return;
				}
				else if ("".equals(resumeS)) {
					MaterialToast.alert("resumer l'avis");
					return;
				}	*/
					
				
		//Ajout des valeurs 
				// orders = AvisDTO.retreive(0, 10, "desc");
				//orders.add(new AvisDTO( titreS , structureS , "logo.jpg" , resumeS , typeC, "logo.jpg" ));
					orderDTOProvider.setList(orders);
					sortDataHandler.setList(orderDTOProvider.getList());
					MaterialToast.alert("Ajout avec succes!!!");
				
				//remise a zero
					structure.setText("");
					resume.setText("");
				
}

	public AvisDTO getOrderDTO() {
		return OrderDTO;
	}

	public void setOrderDTO(AvisDTO OrderDTO) {
		this.OrderDTO = OrderDTO;
	}
	@UiHandler("submit")
    protected void onConfirmAddButtonClick(ClickEvent e){
		
		refreshData();	
		
	}
}
