package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import gwt.material.design.client.custom.MaterialCheckBoxCell;
import gwt.material.design.client.type.ModalType;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialToast;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.AvisDTO;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Objet;
import sn.hubsocial.avisjournaux.backoffice.client.entities.UserApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SafeHtmlCell;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;



public class AvisDataGrid extends Composite {

	private static MaterialDataGridUiBinder uiBinder = GWT.create(MaterialDataGridUiBinder.class);

	interface MaterialDataGridUiBinder extends UiBinder<Widget, AvisDataGrid> { }
	
	 String structtype[]= {"Paru dans le Soleil","Paru dans l'Observateur","Paru dans le SUD Quotidien"};
	 String structtitre[] = {"nom","AVIS D'APPEL D'OFFRES OUVERT","AVIS DE DEMANDE DE RENSEIGNEMENTS ET DE PRIX OUVERT","AVIS D'ATTRIBUTION PROVISOIRE DE MARCHE"};
	
	 
	 

	private List<AvisDTO> orders = new ArrayList<AvisDTO>();
	
	private int page = 3;
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

	public ListDataProvider<AvisDTO> getOrderDTOProvider() {
		return orderDTOProvider;
	}

	public void setOrderDTOProvider(ListDataProvider<AvisDTO> orderDTOProvider) {
		this.orderDTOProvider = orderDTOProvider;
	}

	public ListHandler<AvisDTO> getSortDataHandler() {
		return sortDataHandler;
	}

	public void setSortDataHandler(ListHandler<AvisDTO> sortDataHandler) {
		this.sortDataHandler = sortDataHandler;
	}
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
	private AvisDTO avisDtoSelected;
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
	
	public AvisDataGrid() {
		
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

	public void refreshData() {
		AvisDTO.retrieve(this);		
	}

	private DataGrid<AvisDTO> createDatagrid() {

		this.sortDataHandler = new ListHandler<AvisDTO>(new ArrayList<AvisDTO>());
		
		// CHECKBOX
			Column<AvisDTO, Boolean> checkColumn = new Column<AvisDTO, Boolean>(new MaterialCheckBoxCell()) {
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
                id = object.getId();
                avisDtoSelected = object;
               // MaterialToast.alert("id1"+id);
            	if (alID.contains(id)== true) {
            		alID.remove(id);
            		nbreSelection -=1;
            		
//                    MaterialToast.alert("remove");
				}
            	else {
					alID.add(id);
					nbreSelection +=1;
//					MaterialToast.alert(""+(nbreSelection));
//                    MaterialToast.alert("ajoute");
					
				}
            	// MaterialToast.alert("index"+index+"objet"+object+"value"+value);
            	
            }
           
        };
        checkColumn.setFieldUpdater(checkColumnFU);

     // TITRE
 		final TextColumn<AvisDTO> colTitre = new TextColumn<AvisDTO>() {
 			@Override
 			public String getValue(AvisDTO object) {
 				if (object.getNom() != null) {
 					return object.getNom();
				}
 				return "";
 			}
 		};
 		colTitre.setSortable(true);
 		sortDataHandler.setComparator(colTitre, new Comparator<AvisDTO>() {

 			@Override
 			public int compare(AvisDTO o1, AvisDTO o2) {

 				return o1.getNom().compareTo(o2.getNom());
 			}
 		});
 		

	// ITEM Structure
		Column<AvisDTO,String> colStructure = new Column<AvisDTO, String>(new EditTextCell()) {
			@Override
			public String getValue(AvisDTO object) {
				if (object.getStructure() != null) {
					if (object.getStructure().getNom() != null) {
						return object.getStructure().getNom();
					}
				}
				return "";
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
				if (object.getQuotidien() != null) {
					if (object.getQuotidien().getName() != null) {
						return object.getQuotidien().getName();
						
					}
					
				}
				return "";
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

		dataGrid.setStyleName("responsive-table");		

		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);
		pagerPanel.add(pager);

		orderDTOProvider = new ListDataProvider<AvisDTO>();
		orderDTOProvider.addDataDisplay(dataGrid);
		dataGrid.addColumnSortHandler(sortDataHandler);

		return dataGrid;

	}

	private void getAllOrderDTO() {
		
		
		
		/*//recuperation des valeurs saisies
				String titreS = nom.getSelectedValue();
				String structureS = structure.getValue();			
				String nomImg= fichierimage.getFilename();
				String resumeS = resume.getText().toUpperCase();
				String typeC = typeQuot.getSelectedValue();
				int indextypeAO = typeQuot.getSelectedIndex();
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
				//	structure.setText("");
				//	resume.setText("");
				
}

	public AvisDTO getAvisDtoSelected() {
		return avisDtoSelected;
	}

	public void setAvisDtoSelected(AvisDTO OrderDTO) {
		this.avisDtoSelected = OrderDTO;
	}
//	popup pour enrigistrer un avis
	@UiHandler("avisForm")
    void onAvisEdit(ClickEvent e) {
        MaterialModal.showWindow(new AvisFormDataGrid(this), ModalType.WINDOW, "Enregistrer un Avis","blue",false);
	}
//	popup pour modifier un avis
	@UiHandler("modifier")
	 void onAvisModify(ClickEvent e) {
		if (nbreSelection == 1) {
			
//			mettre les requetes pour recuperer les données et les mettre dans les champs
			MaterialModal.showWindow(new AvisFormDataGrid(avisDtoSelected, this), ModalType.WINDOW, "Modifier un Avis","blue",false);
		}
		else {
			MaterialToast.alert("veuillez selectionner un seul Avis");
		}
		
	}
//	Ajouter mot cle
	@UiHandler("mots_cles")
	void onAddKeyWord(ClickEvent e){
		if (nbreSelection == 1) {
			MaterialModal.showWindow(new MotsClesDataGrid(), ModalType.WINDOW, "Ajout mots cles","blue",false);
			nbreSelection --;
		
			
		}
		else {
			MaterialToast.alert("veuillez selectionner un seul Avis");
		}
			
		
	}
//	supprimer un Avis
	@UiHandler("supprimer")
	void onAvisDelete(ClickEvent e){
		if (nbreSelection == 1){
			
			AvisDTO.delete(avisDtoSelected, this);
			nbreSelection --;
		}	
		else{
			MaterialToast.alert("Vous ne pouvez supprimer qu'un seul avis à la fois");
			return;
		}

	}
	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}	
	
}
